package com.tencent.qqmail.utilities.stringextention;

import java.util.MissingFormatArgumentException;

public class StringFormat
{
  public static final String DEFAULT_SPLITTER = "\\$";
  private final String pattern;
  private final String[] tokens;
  
  public StringFormat(String paramString)
  {
    this(paramString, "\\$");
  }
  
  public StringFormat(String paramString1, String paramString2)
  {
    this.pattern = paramString1;
    this.tokens = paramString1.split(paramString2, -1);
  }
  
  public String format(String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    if (j + 1 != this.tokens.length) {
      throw new MissingFormatArgumentException(this.pattern + " args:" + paramVarArgs.length + ", " + this.tokens.length);
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append(this.tokens[i]).append(paramVarArgs[i]);
      i += 1;
    }
    localStringBuffer.append(this.tokens[j]);
    return localStringBuffer.toString();
  }
  
  int getTokenLength()
  {
    return this.tokens.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.stringextention.StringFormat
 * JD-Core Version:    0.7.0.1
 */