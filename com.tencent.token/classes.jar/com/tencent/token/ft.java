package com.tencent.token;

import java.net.ProtocolException;
import okhttp3.Protocol;

public final class ft
{
  public final Protocol a;
  public final int b;
  public final String c;
  
  public ft(Protocol paramProtocol, int paramInt, String paramString)
  {
    this.a = paramProtocol;
    this.b = paramInt;
    this.c = paramString;
  }
  
  public static ft a(String paramString)
  {
    int i = 9;
    int j;
    Protocol localProtocol;
    if (paramString.startsWith("HTTP/1."))
    {
      if ((paramString.length() < 9) || (paramString.charAt(8) != ' ')) {
        throw new ProtocolException("Unexpected status line: " + paramString);
      }
      j = paramString.charAt(7) - '0';
      if (j == 0) {
        localProtocol = Protocol.HTTP_1_0;
      }
    }
    while (paramString.length() < i + 3)
    {
      throw new ProtocolException("Unexpected status line: " + paramString);
      if (j == 1)
      {
        localProtocol = Protocol.HTTP_1_1;
      }
      else
      {
        throw new ProtocolException("Unexpected status line: " + paramString);
        if (paramString.startsWith("ICY "))
        {
          localProtocol = Protocol.HTTP_1_0;
          i = 4;
        }
        else
        {
          throw new ProtocolException("Unexpected status line: " + paramString);
        }
      }
    }
    try
    {
      j = Integer.parseInt(paramString.substring(i, i + 3));
      if (paramString.length() > i + 3) {
        if (paramString.charAt(i + 3) != ' ') {
          throw new ProtocolException("Unexpected status line: " + paramString);
        }
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new ProtocolException("Unexpected status line: " + paramString);
    }
    for (paramString = paramString.substring(i + 4);; paramString = "") {
      return new ft(localNumberFormatException, j, paramString);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.a == Protocol.HTTP_1_0) {}
    for (String str = "HTTP/1.0";; str = "HTTP/1.1")
    {
      localStringBuilder.append(str);
      localStringBuilder.append(' ').append(this.b);
      if (this.c != null) {
        localStringBuilder.append(' ').append(this.c);
      }
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ft
 * JD-Core Version:    0.7.0.1
 */