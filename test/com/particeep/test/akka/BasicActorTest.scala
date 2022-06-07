package com.particeep.test.akka

import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit, TestProbe}
import org.scalatest.BeforeAndAfterAll
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

class BasicActorTest
  extends TestKit(ActorSystem("MySpec"))
    with ImplicitSender
    with AnyWordSpecLike
    with Matchers
    with BeforeAndAfterAll {
  override def afterAll(): Unit = {
    TestKit.shutdownActorSystem(system)
  }
  "BasicActor" when {
    val probe      = TestProbe()
    val basicActor = system.actorOf(Props(new BasicActor() {
      override def print(msg: String): Unit =
        probe.ref ! msg
    }))
    "Hello message" should {
      basicActor ! "Hello"
      "'Hello there.' message" in {
        probe.expectMsg("Hello there.")
      }
    }
    "Different message" should {
      basicActor ! "Hi"
      "'What?' message" in {
        probe.expectMsg("What?")
      }
    }
  }
}