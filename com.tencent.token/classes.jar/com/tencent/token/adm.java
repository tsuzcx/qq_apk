package com.tencent.token;

import android.text.TextUtils;

public final class adm
  implements ado
{
  public adm(aha paramaha) {}
  
  public final int a()
  {
    return ((adt)this.a).d;
  }
  
  public final String b()
  {
    return ((adt)this.a).b;
  }
  
  public final String c()
  {
    String str2 = ((adt)this.a).g;
    Object localObject1 = agp.a;
    String str1 = "";
    localObject1 = str1;
    if (!TextUtils.isEmpty(str2)) {}
    try
    {
      String str3 = str2.substring(0, 2);
      str2 = str2.substring(2);
      localObject1 = str1;
      if (Integer.parseInt(str3, 16) == 1) {
        localObject1 = agp.a(str2);
      }
      return localObject1;
    }
    finally {}
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.adm
 * JD-Core Version:    0.7.0.1
 */