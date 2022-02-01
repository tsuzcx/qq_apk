package com.hp.hpl.sparta.xpath;

public abstract interface BooleanExprVisitor
{
  public abstract void visit(AttrEqualsExpr paramAttrEqualsExpr)
    throws XPathException;
  
  public abstract void visit(AttrExistsExpr paramAttrExistsExpr)
    throws XPathException;
  
  public abstract void visit(AttrGreaterExpr paramAttrGreaterExpr)
    throws XPathException;
  
  public abstract void visit(AttrLessExpr paramAttrLessExpr)
    throws XPathException;
  
  public abstract void visit(AttrNotEqualsExpr paramAttrNotEqualsExpr)
    throws XPathException;
  
  public abstract void visit(PositionEqualsExpr paramPositionEqualsExpr)
    throws XPathException;
  
  public abstract void visit(TextEqualsExpr paramTextEqualsExpr)
    throws XPathException;
  
  public abstract void visit(TextExistsExpr paramTextExistsExpr)
    throws XPathException;
  
  public abstract void visit(TextNotEqualsExpr paramTextNotEqualsExpr)
    throws XPathException;
  
  public abstract void visit(TrueExpr paramTrueExpr);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.xpath.BooleanExprVisitor
 * JD-Core Version:    0.7.0.1
 */