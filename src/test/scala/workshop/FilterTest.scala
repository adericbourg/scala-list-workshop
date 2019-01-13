package workshop

import org.scalatest.{FunSuite, Matchers}

class FilterTest extends FunSuite with Matchers {

  test("filter should create a new list containing only elements matching the predicate") {
    val initialList = workshop.List(0, 1, 2, 3, 4, 5)

    val filteredList = initialList.filter(x => x % 2 == 0)

    filteredList shouldBe workshop.List(0, 2, 4)
  }

  test("filter should return Empty when filtered list is Empty") {
    val initialList = workshop.List[Int]()

    val filteredList = initialList.filter(x => x % 2 == 0)

    filteredList shouldBe workshop.List()
  }
}
