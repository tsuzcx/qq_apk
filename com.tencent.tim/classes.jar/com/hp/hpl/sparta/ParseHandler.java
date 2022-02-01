package com.hp.hpl.sparta;

public abstract interface ParseHandler
{
  public abstract void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws ParseException;
  
  public abstract void endDocument()
    throws ParseException;
  
  public abstract void endElement(Element paramElement)
    throws ParseException;
  
  public abstract ParseSource getParseSource();
  
  public abstract void setParseSource(ParseSource paramParseSource);
  
  public abstract void startDocument()
    throws ParseException;
  
  public abstract void startElement(Element paramElement)
    throws ParseException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.ParseHandler
 * JD-Core Version:    0.7.0.1
 */