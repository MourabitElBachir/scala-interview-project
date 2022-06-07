package com.particeep.test.async

import org.scalatest.wordspec.AnyWordSpec

import scala.concurrent.Await
import scala.concurrent.duration.Duration

class WhatsWrong2Test extends AnyWordSpec{
  "WhatsWrong2" when {
    "getCEOAndEnterprise(1)" should {
      "return a result" in {
        val result = WhatsWrong2.getCEOAndEnterprise(Some("1"))
        val asyncResult = Await.result(result, Duration.Inf)
        val expected = (Some(CEO("1", "Mark", "Zuckerberg")),Some(Enterprise("1", "Google", "1")))
        assert(asyncResult == expected)
      }
    }
    "getCEOAndEnterprise(0)" should {
      "return (None,None)" in {
        val result = WhatsWrong2.getCEOAndEnterprise(Some("0"))
        val asyncResult = Await.result(result, Duration.Inf)
        val expected = (None,None)
        assert(asyncResult == expected)
      }
    }
    "getCEOAndEnterprise(None)" should {
      "return (None,None)" in {
        val result = WhatsWrong2.getCEOAndEnterprise(None)
        val asyncResult = Await.result(result, Duration.Inf)
        val expected = (None,None)
        assert(asyncResult == expected)
      }
    }

  }
}
