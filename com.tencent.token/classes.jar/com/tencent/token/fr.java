package com.tencent.token;

import java.net.Proxy.Type;
import okhttp3.s;
import okhttp3.x;

public final class fr
{
  public static String a(s params)
  {
    String str1 = params.h();
    String str2 = params.j();
    params = str1;
    if (str2 != null)
    {
      params = new StringBuilder();
      params.append(str1);
      params.append('?');
      params.append(str2);
      params = params.toString();
    }
    return params;
  }
  
  public static String a(x paramx, Proxy.Type paramType)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramx.b());
    localStringBuilder.append(' ');
    if (b(paramx, paramType)) {
      localStringBuilder.append(paramx.a());
    } else {
      localStringBuilder.append(a(paramx.a()));
    }
    localStringBuilder.append(" HTTP/1.1");
    return localStringBuilder.toString();
  }
  
  private static boolean b(x paramx, Proxy.Type paramType)
  {
    return (!paramx.g()) && (paramType == Proxy.Type.HTTP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fr
 * JD-Core Version:    0.7.0.1
 */