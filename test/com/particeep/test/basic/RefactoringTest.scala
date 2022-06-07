package com.particeep.test.basic

import com.particeep.test.basic.Refactoring.File
import org.scalatest.wordspec.AnyWordSpec

class RefactoringTest extends AnyWordSpec{
  "Refactoring " when {
    " return a list of categories" should {
      val files: List[File] = List(
        File("Une Vie", "Music"),
        File("Ecrit sur l'art", null),
        null,
        File("Draft", "Music"),
        File("De la vrai vie", "Science"),
        File("Les chemins de la thérapie", "Science")
      )
      "return expected list" in {
        val result = Refactoring.getCategories(files)
        val expected = List("Music", "Science")
        assert(result.equals(expected))
      }
    }
  }
}
