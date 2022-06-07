package com.particeep.test.async

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

case class CEO(id: String, first_name: String, last_name: String)
case class Enterprise(id: String, name: String, ceo_id: String)

object CEODao {
  val ceos = List(
    CEO("1", "Mark", "Zuckerberg"),
    CEO("2", "Sundar", "Pichai")
  )

  def byId(id: String): Future[Option[CEO]] = Future(ceos.find(_.id == id))
}

object EnterpriseDao {
  val enterprises = List(
    Enterprise("1", "Google", "1"),
    Enterprise("2", "Facebook", "2")
  )

  def byId(id:        String): Future[Option[Enterprise]] = Future(enterprises.find(_.id == id))
  def byCEOId(ceo_id: String): Future[Option[Enterprise]] = Future(enterprises.find(_.ceo_id == ceo_id))
}

object WhatsWrong2 {

  //Review this code. What could be done better ? How would you do it ?
  /***
   *
   * When retrieving the content of an Option, do not use get
   * Some Options are Nones, and get deals with them by throwing an exception
   * We return A Future with (None, None) when ceo_id is None. No need to make two search when ceo is None
   * Finally we return the result without using get because we used Idiomatic Expressions especially Pattern Matching
   *
   */
  def getCEOAndEnterprise(ceo_id: Option[String]): Future[(Option[CEO], Option[Enterprise])] = {
    ceo_id match {
      case None => Future.successful(None, None)
      case Some(ceo_id_value) =>
        for {
          ceo        <- CEODao.byId(ceo_id_value)
          enterprise <- EnterpriseDao.byCEOId(ceo_id_value)
        } yield {
          (ceo, enterprise)
        }
    }

  }
}
