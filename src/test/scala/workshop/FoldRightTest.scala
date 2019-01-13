package workshop

import org.scalatest.{FunSuite, Ignore, Matchers}

@Ignore
class FoldRightTest extends FunSuite with Matchers {

  test("foldRight should accumulate items from non-empty list according to the provided function") {
    val initialList = workshop.List(1, 2, 3)

    val foldedResult1 = initialList.foldRight(0) { case (item, acc) => acc + item }
    val foldedResult2 = initialList.foldRight("Numbers:") { case (item, acc) => s"$acc $item" }

    foldedResult1 shouldBe 6
    foldedResult2 shouldBe "Numbers: 3 2 1"
  }

  test("foldRight should return the initial value of the accumulator when list is empty") {
    val initialList = workshop.List[Int]()

    val foldedResult1 = initialList.foldRight(0) { case (item, acc) => acc + item }
    val foldedResult2 = initialList.foldRight("Numbers:") { case (item, acc) => s"$acc $item" }

    foldedResult1 shouldBe 0
    foldedResult2 shouldBe "Numbers:"
  }
}
