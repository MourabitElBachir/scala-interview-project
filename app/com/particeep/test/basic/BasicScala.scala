package com.particeep.test.basic

import scala.annotation.tailrec

/**
 * This is com.particeep.test.basic language questions so don't use external library or build in function
 */
object BasicScala {

  /**
   * Encode parameter in url format
   *
   * Example:
   *
   * input  : Map("sort_by" -> "name", "order_by" -> "asc", "user_id" -> "12")
   * output : "?sort_by=name&order_by=asc&user_id=12"
   *
   * input  : Map()
   * output : ""
   */
  def encodeParamsInUrl(params: Map[String, String]): String = {
    params.map { case (key, value) => s"$key=$value" }.mkString("&") match {
      case str if !str.isEmpty => s"?$str"
      case _ => ""
    }
  }

  /**
   * Test if a String is an email
   */
  def isEmail(maybeEmail: String): Boolean = {
    val emailRegex = """^[a-zA-Z0-9\.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$""".r
    maybeEmail match {
      case null => false
      case e if e.trim.isEmpty => false
      case e if emailRegex.findFirstMatchIn(e).isDefined => true
      case _ => false
    }
  }

  /**
   * Compute i ^ n
   *
   * Example:
   *
   * input : (i = 2, n = 3) we compute 2^3 = 2x2x2
   * output : 8
   *
   * input : (i = 99, n = 38997)
   * output : 1723793299
   */
  def power(i: Int, n: Int): Int = {
    @tailrec
    def powerRec(j: Int, m: Int, result: Int): Int =
      m match {
        case 0 => result
        case _ => powerRec(j, m - 1, result * j)
      }

    powerRec(i, n, 1)
  }

}
