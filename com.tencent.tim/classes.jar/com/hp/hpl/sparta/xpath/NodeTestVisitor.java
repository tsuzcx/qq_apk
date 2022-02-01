package com.hp.hpl.sparta.xpath;

public abstract interface NodeTestVisitor
{
  public abstract void visit(AllElementTest paramAllElementTest);
  
  public abstract void visit(AttrTest paramAttrTest);
  
  public abstract void visit(ElementTest paramElementTest);
  
  public abstract void visit(ParentNodeTest paramParentNodeTest)
    throws XPathException;
  
  public abstract void visit(TextTest paramTextTest);
  
  public abstract void visit(ThisNodeTest paramThisNodeTest);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.xpath.NodeTestVisitor
 * JD-Core Version:    0.7.0.1
 */