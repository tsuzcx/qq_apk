package com.hp.hpl.sparta;

public class DefaultParseHandler
  implements ParseHandler
{
  private ParseSource parseSource_ = null;
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws ParseException
  {}
  
  public void endDocument()
    throws ParseException
  {}
  
  public void endElement(Element paramElement)
    throws ParseException
  {}
  
  public ParseSource getParseSource()
  {
    return this.parseSource_;
  }
  
  public void setParseSource(ParseSource paramParseSource)
  {
    this.parseSource_ = paramParseSource;
  }
  
  public void startDocument()
    throws ParseException
  {}
  
  public void startElement(Element paramElement)
    throws ParseException
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.DefaultParseHandler
 * JD-Core Version:    0.7.0.1
 */