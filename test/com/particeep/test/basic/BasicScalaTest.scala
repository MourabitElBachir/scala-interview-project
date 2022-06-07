package com.particeep.test.basic

import org.scalatestplus.play.PlaySpec

class BasicScalaTest extends PlaySpec {

  "BasicScala" should {
    "compute encodeParamsInUrl" in {
      BasicScala.encodeParamsInUrl(Map("sort_by" -> "name", "order_by" -> "asc", "user_id" -> "12")) mustBe "?sort_by=name&order_by=asc&user_id=12"
      BasicScala.encodeParamsInUrl(Map()) mustBe ""
    }
    "compute email" in {
      BasicScala.isEmail("jean@particeep.com") mustBe true
      BasicScala.isEmail("jean_particeep.com") mustBe false
    }
    "compute power" in {
      BasicScala.power(2, 3) mustBe 8
      BasicScala.power(99, 38997) mustBe 1723793299
    }
  }
}
