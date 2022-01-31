package com.tencent.token;

import java.net.Proxy.Type;
import okhttp3.af;
import okhttp3.ap;

public final class hk
{
  public static String a(af paramaf)
  {
    String str1 = paramaf.h();
    String str2 = paramaf.j();
    paramaf = str1;
    if (str2 != null) {
      paramaf = str1 + '?' + str2;
    }
    return paramaf;
  }
  
  public static String a(ap paramap, Proxy.Type paramType)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramap.b());
    localStringBuilder.append(' ');
    if (b(paramap, paramType)) {
      localStringBuilder.append(paramap.a());
    }
    for (;;)
    {
      localStringBuilder.append(" HTTP/1.1");
      return localStringBuilder.toString();
      localStringBuilder.append(a(paramap.a()));
    }
  }
  
  private static boolean b(ap paramap, Proxy.Type paramType)
  {
    return (!paramap.g()) && (paramType == Proxy.Type.HTTP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hk
 * JD-Core Version:    0.7.0.1
 */