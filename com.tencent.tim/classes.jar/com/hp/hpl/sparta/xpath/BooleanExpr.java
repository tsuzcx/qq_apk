package com.hp.hpl.sparta.xpath;

public abstract class BooleanExpr
{
  public abstract void accept(BooleanExprVisitor paramBooleanExprVisitor)
    throws XPathException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.xpath.BooleanExpr
 * JD-Core Version:    0.7.0.1
 */