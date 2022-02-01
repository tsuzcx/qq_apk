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
    boolean bool = paramString.startsWith("HTTP/1.");
    int i = 9;
    if (bool)
    {
      if ((paramString.length() >= 9) && (paramString.charAt(8) == ' '))
      {
        j = paramString.charAt(7) - '0';
        if (j == 0)
        {
          localObject = Protocol.HTTP_1_0;
        }
        else if (j == 1)
        {
          localObject = Protocol.HTTP_1_1;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Unexpected status line: ");
          ((StringBuilder)localObject).append(paramString);
          throw new ProtocolException(((StringBuilder)localObject).toString());
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unexpected status line: ");
        ((StringBuilder)localObject).append(paramString);
        throw new ProtocolException(((StringBuilder)localObject).toString());
      }
    }
    else
    {
      if (!paramString.startsWith("ICY ")) {
        break label343;
      }
      localObject = Protocol.HTTP_1_0;
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
        if (paramString.charAt(j) == ' ')
        {
          str = paramString.substring(i + 4);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Unexpected status line: ");
          ((StringBuilder)localObject).append(paramString);
          throw new ProtocolException(((StringBuilder)localObject).toString());
        }
      }
      return new ft((Protocol)localObject, k, str);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label269:
      break label269;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unexpected status line: ");
    ((StringBuilder)localObject).append(paramString);
    throw new ProtocolException(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unexpected status line: ");
    ((StringBuilder)localObject).append(paramString);
    throw new ProtocolException(((StringBuilder)localObject).toString());
    label343:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unexpected status line: ");
    ((StringBuilder)localObject).append(paramString);
    throw new ProtocolException(((StringBuilder)localObject).toString());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str;
    if (this.a == Protocol.HTTP_1_0) {
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
 * Qualified Name:     com.tencent.token.ft
 * JD-Core Version:    0.7.0.1
 */