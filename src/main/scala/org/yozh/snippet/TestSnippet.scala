package org.yozh.snippet

import xml.NodeSeq
import java.util.Date
import net.liftweb.util.BindHelpers._

/**
 *
 * @author Artem
 */
class TestSnippet {
  def render(in: NodeSeq): NodeSeq = <span>Test snippet render</span>

  def renderMethod(in: NodeSeq): NodeSeq = <span>Test render via method: {TestObject.balance}</span>

  def changeInput = "#balance *" #> TestObject.balance & "#date *+" #> TestObject.date.toString
}

object TestObject {
  def balance = 42

  def date = new Date
}