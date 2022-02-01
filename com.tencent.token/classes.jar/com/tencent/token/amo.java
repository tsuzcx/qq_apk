package com.tencent.token;

import java.net.ProtocolException;

public final class amo
{
  public final alh a;
  public final int b;
  public final String c;
  
  private amo(alh paramalh, int paramInt, String paramString)
  {
    this.a = paramalh;
    this.b = paramInt;
    this.c = paramString;
  }
  
  public static amo a(String paramString)
  {
    boolean bool = paramString.startsWith("HTTP/1.");
    int i = 9;
    alh localalh;
    if (bool)
    {
      if ((paramString.length() >= 9) && (paramString.charAt(8) == ' '))
      {
        j = paramString.charAt(7) - '0';
        if (j == 0) {
          localalh = alh.a;
        } else if (j == 1) {
          localalh = alh.b;
        } else {
          throw new ProtocolException("Unexpected status line: ".concat(String.valueOf(paramString)));
        }
      }
      else
      {
        throw new ProtocolException("Unexpected status line: ".concat(String.valueOf(paramString)));
      }
    }
    else
    {
      if (!paramString.startsWith("ICY ")) {
        break label243;
      }
      localalh = alh.a;
      i = 4;
    }
    int k = paramString.length();
    int j = i + 3;
    if (k >= j) {}
    try
    {
      k = Integer.parseInt(paramString.substring(i, j));
      String str = "";
      if (paramString.length() > j) {
        if (paramString.charAt(j) == ' ') {
          str = paramString.substring(i + 4);
        } else {
          throw new ProtocolException("Unexpected status line: ".concat(String.valueOf(paramString)));
        }
      }
      return new amo(localalh, k, str);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label209:
      break label209;
    }
    throw new ProtocolException("Unexpected status line: ".concat(String.valueOf(paramString)));
    throw new ProtocolException("Unexpected status line: ".concat(String.valueOf(paramString)));
    label243:
    throw new ProtocolException("Unexpected status line: ".concat(String.valueOf(paramString)));
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str;
    if (this.a == alh.a) {
      str = "HTTP/1.0";
    } else {
      str = "HTTP/1.1";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(' ');
    localStringBuilder.append(this.b);
    if (this.c != null)
    {
      localStringBuilder.append(' ');
      localStringBuilder.append(this.c);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.amo
 * JD-Core Version:    0.7.0.1
 */