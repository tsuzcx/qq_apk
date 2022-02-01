package com.tencent.moai.mailsdk.protocol.model;

import java.util.Vector;

public abstract class MultiPart
  implements Part
{
  protected String contentType;
  protected Vector<Part> parts = new Vector();
  
  public void addPart(Part paramPart)
  {
    this.parts.add(paramPart);
  }
  
  public String getContentType()
  {
    return this.contentType;
  }
  
  public int getCount()
  {
    return this.parts.size();
  }
  
  public Part getPart(int paramInt)
  {
    return (Part)this.parts.get(paramInt);
  }
  
  public Part removePart(int paramInt)
  {
    return (Part)this.parts.remove(paramInt);
  }
  
  public void setContentType(String paramString)
  {
    this.contentType = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.model.MultiPart
 * JD-Core Version:    0.7.0.1
 */