package workshop

sealed trait List[+T]

object List {
  def apply[T](ts: T*): List[T] = {
    if (ts.isEmpty) Empty
    else Cons(ts.head, List(ts.tail: _*))
  }
}

case class Cons[T](t: T, ts: List[T]) extends List[T]

case object Empty extends List[Nothing]
