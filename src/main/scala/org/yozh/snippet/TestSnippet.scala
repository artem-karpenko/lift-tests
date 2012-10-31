package org.yozh.snippet

import xml.NodeSeq

/**
 *
 * @author Artem
 */
class TestSnippet {
  def render(in: NodeSeq): NodeSeq = <span>Test snippet render</span>

  def renderMethod(in: NodeSeq): NodeSeq = <span>Test render via method</span>
}
