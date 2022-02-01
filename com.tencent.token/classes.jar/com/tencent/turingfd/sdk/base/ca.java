package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.text.TextUtils;

public final class ca
{
  public static a a(Context paramContext)
  {
    return a(cz.a(paramContext));
  }
  
  public static a a(cf paramcf)
  {
    return new b(paramcf);
  }
  
  public static void a(bz parambz)
  {
    cz.a(parambz);
  }
  
  public static abstract interface a
  {
    public abstract String a();
    
    public abstract int b();
    
    public abstract String c();
  }
  
  public static final class b
    implements ca.a
  {
    public b(cf paramcf) {}
    
    public String a()
    {
      return ((ao)this.a).b;
    }
    
    public int b()
    {
      return ((ao)this.a).d;
    }
    
    public String c()
    {
      String str2 = ((ao)this.a).g;
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
            str1 = cm.a(str2);
            return str1;
          }
        }
        catch (Throwable localThrowable) {}
      }
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.ca
 * JD-Core Version:    0.7.0.1
 */