package com.hp.hpl.sparta;

import com.hp.hpl.sparta.xpath.AttrCompareExpr;
import com.hp.hpl.sparta.xpath.AttrEqualsExpr;
import com.hp.hpl.sparta.xpath.AttrExistsExpr;
import com.hp.hpl.sparta.xpath.AttrExpr;
import com.hp.hpl.sparta.xpath.AttrGreaterExpr;
import com.hp.hpl.sparta.xpath.AttrLessExpr;
import com.hp.hpl.sparta.xpath.AttrNotEqualsExpr;
import com.hp.hpl.sparta.xpath.BooleanExprVisitor;
import com.hp.hpl.sparta.xpath.PositionEqualsExpr;
import com.hp.hpl.sparta.xpath.TextCompareExpr;
import com.hp.hpl.sparta.xpath.TextEqualsExpr;
import com.hp.hpl.sparta.xpath.TextExistsExpr;
import com.hp.hpl.sparta.xpath.TextNotEqualsExpr;
import com.hp.hpl.sparta.xpath.TrueExpr;
import com.hp.hpl.sparta.xpath.XPath;
import com.hp.hpl.sparta.xpath.XPathException;

class Node$1
  implements BooleanExprVisitor
{
  private final Node this$0;
  private final String val$msgContext;
  private final Element val$newChild;
  private final Element val$parent;
  private final String val$tagName;
  
  Node$1(Node paramNode, Element paramElement1, Element paramElement2, String paramString1, String paramString2)
    throws XPathException
  {
    this.this$0 = paramNode;
    this.val$newChild = paramElement1;
    this.val$parent = paramElement2;
    this.val$msgContext = paramString1;
    this.val$tagName = paramString2;
  }
  
  public void visit(AttrEqualsExpr paramAttrEqualsExpr)
    throws XPathException
  {
    this.val$newChild.setAttribute(paramAttrEqualsExpr.getAttrName(), paramAttrEqualsExpr.getAttrValue());
  }
  
  public void visit(AttrExistsExpr paramAttrExistsExpr)
    throws XPathException
  {
    this.val$newChild.setAttribute(paramAttrExistsExpr.getAttrName(), "something");
  }
  
  public void visit(AttrGreaterExpr paramAttrGreaterExpr)
    throws XPathException
  {
    this.val$newChild.setAttribute(paramAttrGreaterExpr.getAttrName(), Long.toString(9223372036854775807L));
  }
  
  public void visit(AttrLessExpr paramAttrLessExpr)
    throws XPathException
  {
    this.val$newChild.setAttribute(paramAttrLessExpr.getAttrName(), Long.toString(-9223372036854775808L));
  }
  
  public void visit(AttrNotEqualsExpr paramAttrNotEqualsExpr)
    throws XPathException
  {
    this.val$newChild.setAttribute(paramAttrNotEqualsExpr.getAttrName(), "not " + paramAttrNotEqualsExpr.getAttrValue());
  }
  
  public void visit(PositionEqualsExpr paramPositionEqualsExpr)
    throws XPathException
  {
    int j = 1;
    int k = paramPositionEqualsExpr.getPosition();
    int i = j;
    if (this.val$parent == null)
    {
      i = j;
      if (k != 1) {
        throw new XPathException(XPath.get(this.val$msgContext), "Position of root node must be 1");
      }
    }
    while (i < k)
    {
      this.val$parent.appendChild(new Element(this.val$tagName));
      i += 1;
    }
  }
  
  public void visit(TextEqualsExpr paramTextEqualsExpr)
    throws XPathException
  {
    this.val$newChild.appendChild(new Text(paramTextEqualsExpr.getValue()));
  }
  
  public void visit(TextExistsExpr paramTextExistsExpr)
    throws XPathException
  {
    this.val$newChild.appendChild(new Text("something"));
  }
  
  public void visit(TextNotEqualsExpr paramTextNotEqualsExpr)
    throws XPathException
  {
    this.val$newChild.appendChild(new Text("not " + paramTextNotEqualsExpr.getValue()));
  }
  
  public void visit(TrueExpr paramTrueExpr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.Node.1
 * JD-Core Version:    0.7.0.1
 */