package workshop

sealed trait List[+T] {
  /**
    * Adds an element at the head of the list.
    */
  def prepend[ST >: T](a: ST): List[ST] = ???

  /**
    * Adds an element at the end (after the tail) of the list.
    */
  def append[ST >: T](a: ST): List[ST] = ???

  /**
    * Creates a new list containing only the elements matching the predicate.
    */
  def filter(predicate: T => Boolean): List[T] = ???

  /**
    * Applies the operator f to each elements of the list and the accumulated value, starting from the right to the
    * left.
    */
  def foldRight[S](accumulator: S)(f: (T, S) => S): S = ???

  /**
    * Applies the operator f to each elements of the list and the accumulated value, starting from the left to the
    * right.
    */
  def foldLeft[S](accumulator: S)(f: (S, T) => S): S = ???

  /**
    * Reverses the list.
    */
  def reverse: List[T] = ???

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
