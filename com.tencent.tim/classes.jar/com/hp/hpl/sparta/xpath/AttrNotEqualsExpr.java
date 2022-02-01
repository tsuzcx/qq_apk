package com.hp.hpl.sparta.xpath;

public class AttrNotEqualsExpr
  extends AttrCompareExpr
{
  AttrNotEqualsExpr(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void accept(BooleanExprVisitor paramBooleanExprVisitor)
    throws XPathException
  {
    paramBooleanExprVisitor.visit(this);
  }
  
  public String toString()
  {
    return toString("!=");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.xpath.AttrNotEqualsExpr
 * JD-Core Version:    0.7.0.1
 */