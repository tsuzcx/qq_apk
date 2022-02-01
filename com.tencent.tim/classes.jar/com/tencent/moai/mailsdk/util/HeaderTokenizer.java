package com.tencent.moai.mailsdk.util;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.util.log.Logger;

public class HeaderTokenizer
{
  private static final Token EOFToken = new Token(-4, null);
  public static final String MIME = "()<>@,;:\\\"\t []/?=";
  public static final String RFC822 = "()<>@,;:\\\"\t .[]";
  private static final String TAG = "HeaderTokenizer";
  private int currentPos;
  private String delimiters;
  private int maxPos;
  private int nextPos;
  private int peekPos;
  private boolean skipComments;
  private String string;
  
  public HeaderTokenizer(String paramString)
  {
    this(paramString, "()<>@,;:\\\"\t .[]");
  }
  
  public HeaderTokenizer(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, true);
  }
  
  public HeaderTokenizer(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    this.string = str;
    this.skipComments = paramBoolean;
    this.delimiters = paramString2;
    this.peekPos = 0;
    this.nextPos = 0;
    this.currentPos = 0;
    this.maxPos = this.string.length();
  }
  
  private Token collectString(char paramChar, boolean paramBoolean)
    throws MessageException
  {
    int j = 0;
    int k = this.currentPos;
    if (this.currentPos < this.maxPos)
    {
      char c = this.string.charAt(this.currentPos);
      int i;
      if (c == '\\')
      {
        this.currentPos += 1;
        i = 1;
      }
      label80:
      do
      {
        for (;;)
        {
          this.currentPos += 1;
          j = i;
          break;
          if (c != '\r') {
            break label80;
          }
          i = 1;
        }
        i = j;
      } while (c != paramChar);
      this.currentPos += 1;
      if (j != 0) {}
      for (str1 = filterToken(this.string, k, this.currentPos - 1, paramBoolean);; str1 = this.string.substring(k, this.currentPos - 1))
      {
        String str2 = str1;
        if (c != '"')
        {
          str2 = trimWhiteSpace(str1);
          this.currentPos -= 1;
        }
        return new Token(-2, str2);
      }
    }
    if (paramChar == '"')
    {
      if (j != 0) {}
      for (str1 = filterToken(this.string, k, this.currentPos, paramBoolean);; str1 = this.string.substring(k, this.currentPos)) {
        return new Token(-2, str1);
      }
    }
    if (j != 0) {}
    for (String str1 = filterToken(this.string, k, this.currentPos, paramBoolean);; str1 = this.string.substring(k, this.currentPos)) {
      return new Token(-2, trimWhiteSpace(str1));
    }
  }
  
  private static String filterToken(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    int k = 0;
    int j = paramInt1;
    paramInt1 = k;
    if (j < paramInt2)
    {
      char c = paramString.charAt(j);
      if ((c == '\n') && (i != 0))
      {
        k = 0;
        i = paramInt1;
        paramInt1 = k;
      }
      for (;;)
      {
        k = j + 1;
        j = paramInt1;
        paramInt1 = i;
        i = j;
        j = k;
        break;
        if (paramInt1 == 0)
        {
          if (c == '\\')
          {
            paramInt1 = 0;
            i = 1;
          }
          else if (c == '\r')
          {
            i = paramInt1;
            paramInt1 = 1;
          }
          else
          {
            localStringBuffer.append(c);
            i = paramInt1;
            paramInt1 = 0;
          }
        }
        else
        {
          if (paramBoolean) {
            localStringBuffer.append('\\');
          }
          localStringBuffer.append(c);
          paramInt1 = 0;
          i = 0;
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  private Token getNext(char paramChar, boolean paramBoolean)
    throws MessageException
  {
    if (this.currentPos >= this.maxPos) {
      return EOFToken;
    }
    if (skipWhiteSpace() == -4) {
      return EOFToken;
    }
    char c3 = '\000';
    char c1 = this.string.charAt(this.currentPos);
    int i;
    char c2;
    if (this.string.substring(this.currentPos).startsWith("=?"))
    {
      i = this.string.lastIndexOf("?=");
      if (i != -1)
      {
        c2 = this.currentPos;
        i += 2;
        this.currentPos = i;
        return new Token(-3, this.string.substring(c2, i));
        c1 = this.string.charAt(this.currentPos);
      }
    }
    for (;;)
    {
      if (c1 == '(')
      {
        int k = this.currentPos + 1;
        this.currentPos = k;
        int j = 1;
        if ((j > 0) && (this.currentPos < this.maxPos))
        {
          int m = this.string.charAt(this.currentPos);
          if (m == 92)
          {
            this.currentPos += 1;
            c2 = '\001';
            i = j;
          }
          for (;;)
          {
            this.currentPos += 1;
            j = i;
            c3 = c2;
            break;
            if (m == 13)
            {
              c2 = '\001';
              i = j;
            }
            else if (m == 40)
            {
              i = j + 1;
              c2 = c3;
            }
            else
            {
              i = j;
              c2 = c3;
              if (m == 41)
              {
                i = j - 1;
                c2 = c3;
              }
            }
          }
        }
        if (j != 0)
        {
          Logger.log(5, "headerToken", "Unbalanced comments: " + this.string);
          return new Token(-3, this.string.substring(k, this.currentPos));
        }
        if (!this.skipComments)
        {
          if (c3 != 0) {}
          for (String str = filterToken(this.string, k, this.currentPos - 1, paramBoolean);; str = this.string.substring(k, this.currentPos - 1)) {
            return new Token(-3, str);
          }
        }
        if (skipWhiteSpace() != -4) {
          break;
        }
        return EOFToken;
      }
      if (c1 == '"')
      {
        this.currentPos += 1;
        return collectString('"', paramBoolean);
      }
      if (this.delimiters.indexOf(c1) >= 0)
      {
        if ((paramChar > 0) && (c1 != paramChar)) {
          return collectString(paramChar, paramBoolean);
        }
        this.currentPos += 1;
        return new Token(c1, new String(new char[] { c1 }));
      }
      i = this.currentPos;
      while (this.currentPos < this.maxPos)
      {
        c2 = this.string.charAt(this.currentPos);
        if ((c2 == '(') || (c2 == ' ') || (c2 == '"') || (this.delimiters.indexOf(c2) >= 0))
        {
          if ((paramChar <= 0) || (c2 == paramChar)) {
            break;
          }
          this.currentPos = i;
          return collectString(paramChar, paramBoolean);
        }
        this.currentPos += 1;
      }
      return new Token(-1, this.string.substring(i, this.currentPos));
    }
  }
  
  private int skipWhiteSpace()
  {
    while (this.currentPos < this.maxPos)
    {
      int i = this.string.charAt(this.currentPos);
      if ((i != 32) && (i != 9) && (i != 13) && (i != 10)) {
        return this.currentPos;
      }
      this.currentPos += 1;
    }
    return -4;
  }
  
  private static String trimWhiteSpace(String paramString)
  {
    int i = paramString.length() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        int j = paramString.charAt(i);
        if ((j == 32) || (j == 9) || (j == 13) || (j == 10)) {}
      }
      else
      {
        if (i > 0) {
          break;
        }
        return "";
      }
      i -= 1;
    }
    return paramString.substring(0, i + 1);
  }
  
  public String getRemainder()
  {
    if (this.nextPos >= this.string.length()) {
      return null;
    }
    return this.string.substring(this.nextPos);
  }
  
  public Token next()
    throws MessageException
  {
    return next('\000', false);
  }
  
  public Token next(char paramChar)
    throws MessageException
  {
    return next(paramChar, false);
  }
  
  public Token next(char paramChar, boolean paramBoolean)
    throws MessageException
  {
    this.currentPos = this.nextPos;
    Token localToken = getNext(paramChar, paramBoolean);
    int i = this.currentPos;
    this.peekPos = i;
    this.nextPos = i;
    return localToken;
  }
  
  public Token peek()
    throws MessageException
  {
    this.currentPos = this.peekPos;
    Token localToken = getNext('\000', false);
    this.peekPos = this.currentPos;
    return localToken;
  }
  
  public static class Token
  {
    public static final int ATOM = -1;
    public static final int COMMENT = -3;
    public static final int EOF = -4;
    public static final int QUOTEDSTRING = -2;
    private int type;
    private String value;
    
    public Token(int paramInt, String paramString)
    {
      this.type = paramInt;
      this.value = paramString;
    }
    
    public int getType()
    {
      return this.type;
    }
    
    public String getValue()
    {
      return this.value;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.HeaderTokenizer
 * JD-Core Version:    0.7.0.1
 */