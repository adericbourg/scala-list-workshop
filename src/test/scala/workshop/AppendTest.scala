package workshop

import org.scalatest.{FunSuite, Ignore, Matchers}

@Ignore
class AppendTest extends FunSuite with Matchers {

  test("append should create a new list with provided element as the last element " +
    "when initial list is filled") {
    val initialList = workshop.List(1, 2, 3) // Cons(1, Cons(2, Cons(3, Empty)))

    val appendedList = initialList.append(0)

    appendedList shouldBe workshop.List(1, 2, 3, 0) // Cons(1, Cons(2, Cons(3, Cons(0, Empty))))
  }

  test("append should create a new list with provided element as the last element " +
    "when initial list is empty") {
    val initialList = workshop.List() // Empty

    val appendedList = initialList.append(0)

    appendedList shouldBe workshop.List(0)
  }
}
