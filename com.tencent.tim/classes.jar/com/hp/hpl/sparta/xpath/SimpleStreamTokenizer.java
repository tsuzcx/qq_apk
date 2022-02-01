package com.hp.hpl.sparta.xpath;

import java.io.IOException;
import java.io.Reader;

public class SimpleStreamTokenizer
{
  private static final int QUOTE = -6;
  public static final int TT_EOF = -1;
  public static final int TT_NUMBER = -2;
  public static final int TT_WORD = -3;
  private static final int WHITESPACE = -5;
  private final StringBuffer buf_ = new StringBuffer();
  private final int[] charType_ = new int[256];
  private char inQuote_ = '\000';
  private int nextType_;
  public int nval = -2147483648;
  private boolean pushedBack_ = false;
  private final Reader reader_;
  public String sval = "";
  public int ttype = -2147483648;
  
  public SimpleStreamTokenizer(Reader paramReader)
    throws IOException
  {
    this.reader_ = paramReader;
    if (i >= this.charType_.length)
    {
      nextToken();
      return;
    }
    if (((65 <= i) && (i <= 90)) || ((97 <= i) && (i <= 122)) || (i == 45)) {
      this.charType_[i] = -3;
    }
    for (;;)
    {
      i = (char)(i + 1);
      break;
      if ((48 <= i) && (i <= 57)) {
        this.charType_[i] = -2;
      } else if ((i >= 0) && (i <= 32)) {
        this.charType_[i] = -5;
      } else {
        this.charType_[i] = i;
      }
    }
  }
  
  public int nextToken()
    throws IOException
  {
    if (this.pushedBack_)
    {
      this.pushedBack_ = false;
      return this.ttype;
    }
    this.ttype = this.nextType_;
    int k = 0;
    int n;
    int i;
    label61:
    int m;
    label77:
    int j;
    label88:
    do
    {
      n = this.reader_.read();
      if (n != -1) {
        break;
      }
      if (this.inQuote_ != 0) {
        throw new IOException("Unterminated quote");
      }
      i = -1;
      if ((this.inQuote_ != 0) || (i != -5)) {
        break label308;
      }
      m = 1;
      if ((k == 0) && (m == 0)) {
        break label314;
      }
      j = 1;
      k = j;
    } while (m != 0);
    if ((i == 39) || (i == 34))
    {
      if (this.inQuote_ == 0) {
        this.inQuote_ = ((char)i);
      }
    }
    else
    {
      label120:
      if (this.inQuote_ != 0) {
        i = this.inQuote_;
      }
      if ((j == 0) && ((this.ttype < -1) || (this.ttype == 39) || (this.ttype == 34)) && (this.ttype == i)) {
        break label335;
      }
      j = 1;
      label172:
      if (j != 0) {}
      switch (this.ttype)
      {
      default: 
        label224:
        if (i != -5)
        {
          if (i == -6)
          {
            k = n;
            label239:
            this.nextType_ = k;
          }
        }
        else {
          switch (i)
          {
          }
        }
        break;
      }
    }
    while (j != 0)
    {
      return this.ttype;
      i = this.charType_[n];
      break label61;
      label308:
      m = 0;
      break label77;
      label314:
      j = 0;
      break label88;
      if (this.inQuote_ != i) {
        break label120;
      }
      this.inQuote_ = '\000';
      break label120;
      label335:
      j = 0;
      break label172;
      this.sval = this.buf_.toString();
      this.buf_.setLength(0);
      break label224;
      this.sval = this.buf_.toString().substring(1, this.buf_.length() - 1);
      this.buf_.setLength(0);
      break label224;
      this.nval = Integer.parseInt(this.buf_.toString());
      this.buf_.setLength(0);
      break label224;
      k = i;
      break label239;
      this.buf_.append((char)n);
    }
  }
  
  public void ordinaryChar(char paramChar)
  {
    this.charType_[paramChar] = paramChar;
  }
  
  public void pushBack()
  {
    this.pushedBack_ = true;
  }
  
  public String toString()
  {
    switch (this.ttype)
    {
    default: 
      return "'" + (char)this.ttype + "'";
    case -2: 
      return Integer.toString(this.nval);
    case -3: 
    case 34: 
      return "\"" + this.sval + "\"";
    case 39: 
      return "'" + this.sval + "'";
    }
    return "(EOF)";
  }
  
  public void wordChars(char paramChar1, char paramChar2)
  {
    for (;;)
    {
      if (paramChar1 > paramChar2) {
        return;
      }
      this.charType_[paramChar1] = -3;
      paramChar1 = (char)(paramChar1 + '\001');
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.xpath.SimpleStreamTokenizer
 * JD-Core Version:    0.7.0.1
 */