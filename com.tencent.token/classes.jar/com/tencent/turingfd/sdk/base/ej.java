package com.tencent.turingfd.sdk.base;

import android.text.TextUtils;

public final class ej
  implements df
{
  public ej(ew paramew) {}
  
  public String a()
  {
    return ((bg)((ee)this.a).a).b;
  }
  
  public int b()
  {
    return ((bg)((ee)this.a).a).d;
  }
  
  public String c()
  {
    String str2 = ((bg)((ee)this.a).a).h;
    if (TextUtils.isEmpty(str2)) {}
    for (;;)
    {
      return "";
      try
      {
        String str1 = str2.substring(0, 2);
        str2 = str2.substring(2);
        if (Integer.parseInt(str1, 16) == 1)
        {
          str1 = ed.a(str2);
          return str1;
        }
      }
      catch (Throwable localThrowable) {}
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.ej
 * JD-Core Version:    0.7.0.1
 */