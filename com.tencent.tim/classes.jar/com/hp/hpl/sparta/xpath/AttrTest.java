package com.hp.hpl.sparta.xpath;

public class AttrTest
  extends NodeTest
{
  private final String attrName_;
  
  AttrTest(String paramString)
  {
    this.attrName_ = paramString;
  }
  
  public void accept(Visitor paramVisitor)
  {
    paramVisitor.visit(this);
  }
  
  public String getAttrName()
  {
    return this.attrName_;
  }
  
  public boolean isStringValue()
  {
    return true;
  }
  
  public String toString()
  {
    return "@" + this.attrName_;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.xpath.AttrTest
 * JD-Core Version:    0.7.0.1
 */