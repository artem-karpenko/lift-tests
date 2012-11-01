package org.yozh.snippet

import net.liftweb.http.S
import net.liftweb.common.Full
import net.liftweb.util.PassThru
import net.liftweb.util.Helpers._

/**
 *
 * @author Artem
 */
class SampleForm {
  val inputParam = for {
    r <- S.request if r.get_?
    v <- S.param("name")
  } yield v

  def render = inputParam match {
    case Full(x) =>
      println("Input is: " + x)
      "#result *" #> x

    case _ =>
      println("No input present! Rendering input form HTML")
      PassThru
  }
}
