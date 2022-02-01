package com.hp.hpl.sparta.xpath;

import com.hp.hpl.sparta.Sparta;

public class ElementTest
  extends NodeTest
{
  private final String tagName_;
  
  ElementTest(String paramString)
  {
    this.tagName_ = Sparta.intern(paramString);
  }
  
  public void accept(Visitor paramVisitor)
  {
    paramVisitor.visit(this);
  }
  
  public String getTagName()
  {
    return this.tagName_;
  }
  
  public boolean isStringValue()
  {
    return false;
  }
  
  public String toString()
  {
    return this.tagName_;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.xpath.ElementTest
 * JD-Core Version:    0.7.0.1
 */