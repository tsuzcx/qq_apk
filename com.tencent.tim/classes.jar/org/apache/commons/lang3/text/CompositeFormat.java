package org.apache.commons.lang3.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;

public class CompositeFormat
  extends Format
{
  private static final long serialVersionUID = -4329119827877627683L;
  private final Format formatter;
  private final Format parser;
  
  public CompositeFormat(Format paramFormat1, Format paramFormat2)
  {
    this.parser = paramFormat1;
    this.formatter = paramFormat2;
  }
  
  public StringBuffer format(Object paramObject, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition)
  {
    return this.formatter.format(paramObject, paramStringBuffer, paramFieldPosition);
  }
  
  public Format getFormatter()
  {
    return this.formatter;
  }
  
  public Format getParser()
  {
    return this.parser;
  }
  
  public Object parseObject(String paramString, ParsePosition paramParsePosition)
  {
    return this.parser.parseObject(paramString, paramParsePosition);
  }
  
  public String reformat(String paramString)
    throws ParseException
  {
    return format(parseObject(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.text.CompositeFormat
 * JD-Core Version:    0.7.0.1
 */