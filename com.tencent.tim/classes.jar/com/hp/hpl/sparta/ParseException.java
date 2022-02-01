package com.hp.hpl.sparta;

public class ParseException
  extends Exception
{
  private Throwable cause_ = null;
  private int lineNumber_ = -1;
  
  public ParseException(ParseCharStream paramParseCharStream, char paramChar1, char paramChar2)
  {
    this(paramParseCharStream, "got '" + paramChar1 + "' instead of expected '" + paramChar2 + "'");
  }
  
  public ParseException(ParseCharStream paramParseCharStream, char paramChar, String paramString)
  {
    this(paramParseCharStream, "got '" + paramChar + "' instead of " + paramString + " as expected");
  }
  
  public ParseException(ParseCharStream paramParseCharStream, char paramChar, char[] paramArrayOfChar)
  {
    this(paramParseCharStream, "got '" + paramChar + "' instead of " + toString(paramArrayOfChar));
  }
  
  public ParseException(ParseCharStream paramParseCharStream, String paramString)
  {
    this(paramParseCharStream.getLog(), paramParseCharStream.getSystemId(), paramParseCharStream.getLineNumber(), paramParseCharStream.getLastCharRead(), paramParseCharStream.getHistory(), paramString);
  }
  
  public ParseException(ParseCharStream paramParseCharStream, String paramString1, String paramString2)
  {
    this(paramParseCharStream, "got \"" + paramString1 + "\" instead of \"" + paramString2 + "\" as expected");
  }
  
  public ParseException(ParseCharStream paramParseCharStream, String paramString, char[] paramArrayOfChar)
  {
    this(paramParseCharStream, paramString, new String(paramArrayOfChar));
  }
  
  public ParseException(ParseLog paramParseLog, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    this(paramString1, paramInt1, paramInt2, paramString2, paramString3);
    paramParseLog.error(paramString3, paramString1, paramInt1);
  }
  
  public ParseException(String paramString)
  {
    super(paramString);
  }
  
  public ParseException(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    super(toMessage(paramString1, paramInt1, paramInt2, paramString2, paramString3));
    this.lineNumber_ = paramInt1;
  }
  
  public ParseException(String paramString, Throwable paramThrowable)
  {
    super(paramString + " " + paramThrowable);
    this.cause_ = paramThrowable;
  }
  
  static String charRepr(int paramInt)
  {
    if (paramInt == -1) {
      return "EOF";
    }
    return "" + (char)paramInt;
  }
  
  private static String toMessage(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    return paramString1 + "(" + paramInt1 + "): \n" + paramString2 + "\nLast character read was '" + charRepr(paramInt2) + "'\n" + paramString3;
  }
  
  private static String toString(char[] paramArrayOfChar)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramArrayOfChar[0]);
    int i = 1;
    for (;;)
    {
      if (i >= paramArrayOfChar.length) {
        return localStringBuffer.toString();
      }
      localStringBuffer.append("or " + paramArrayOfChar[i]);
      i += 1;
    }
  }
  
  public Throwable getCause()
  {
    return this.cause_;
  }
  
  public int getLineNumber()
  {
    return this.lineNumber_;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.ParseException
 * JD-Core Version:    0.7.0.1
 */