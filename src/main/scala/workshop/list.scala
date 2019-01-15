package workshop

import scala.annotation.tailrec

sealed trait List[+T] {
  /**
    * Adds an element at the head of the list.
    */
  def prepend[ST >: T](a: ST): List[ST] = Cons(a, this)

  /**
    * Adds an element at the end (after the tail) of the list.
    */
  def append[ST >: T](a: ST): List[ST] = {
    this match {
      case Empty            => Cons(a, Empty)
      case Cons(head, tail) => Cons(head, tail.append(a))
    }
  }

  /**
    * Creates a new list containing only the elements matching the predicate.
    */
  def filter[ST >: T](predicate: ST => Boolean): List[T] = {
    this match {
      case Empty            =>
        Empty
      case Cons(head, tail) =>
        if (predicate(head)) {
          Cons(head, tail.filter(predicate))
        }
        else {
          tail.filter(predicate)
        }
    }
  }

  /**
    * Applies the operator f to each elements of the list and the accumulated value, starting from the right to the
    * left.
    */
  def foldRight[S](accumulator: S)(f: (T, S) => S): S = {
    this match {
      case Empty            => accumulator
      case Cons(head, tail) => f(head, tail.foldRight(accumulator)(f))
    }
  }

  /**
    * Applies the operator f to each elements of the list and the accumulated value, starting from the left to the
    * right.
    */

  def foldLeft[S](accumulatorInitialValue: S)(f: (S, T) => S): S = {
    @tailrec
    def impl(list: List[T], accumulator: S): S = {
      list match {
        case Empty            => accumulator
        case Cons(head, tail) => impl(tail, f(accumulator, head))
      }
    }

    impl(this, accumulatorInitialValue)
  }

  /**
    * Reverses the list.
    */
  def reverse: List[T] = this.foldLeft(workshop.List[T]()) { case (acc, item) => Cons(item, acc) }

  /**
    * Creates a new list where elements are the elements of the initial list transformed with the provided function.
    */
  def map[S](f: T => S): List[S] = ???
}

object List {
  def apply[T](ts: T*): List[T] = {
    if (ts.isEmpty) Empty
    else Cons(ts.head, List(ts.tail: _*))
  }
}

case class Cons[+T](t: T, ts: List[T]) extends List[T]

case object Empty extends List[Nothing]
