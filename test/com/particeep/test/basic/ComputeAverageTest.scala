package com.particeep.test.basic

import org.scalatestplus.play.PlaySpec

class ComputeAverageTest extends PlaySpec {

  "ComputeAverage" should {
    "compute average" in {
      ComputeAverage.average(List(1, 10, 16)) mustBe 9
    }
  }

}
