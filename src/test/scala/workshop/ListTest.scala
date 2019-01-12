package workshop

import org.scalatest.{FunSuite, Matchers}

class ListTest extends FunSuite with Matchers {

  test("List should create an empty list") {
    workshop.List() shouldBe Empty
  }

  test("List should build a single-linked list with 1 element") {
    workshop.List(1) shouldBe Cons(1, Empty)
    workshop.List("a") shouldBe Cons("a", Empty)
  }

  test("List should build a single-linked list with several elements") {
    workshop.List(1, 2, 3) shouldBe Cons(1, Cons(2, Cons(3, Empty)))
    workshop.List("a", "b", "c", "d") shouldBe Cons("a", Cons("b", Cons("c", Cons("d", Empty))))
  }
}
