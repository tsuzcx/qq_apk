package com.tencent.token;

import android.text.TextUtils;

public final class aem
{
  public static a a(aer paramaer)
  {
    return new b(paramaer);
  }
  
  public static abstract interface a
  {
    public abstract String a();
    
    public abstract int b();
    
    public abstract String c();
  }
  
  public static final class b
    implements aem.a
  {
    public b(aer paramaer) {}
    
    public final String a()
    {
      return ((ada)this.a).b;
    }
    
    public final int b()
    {
      return ((ada)this.a).d;
    }
    
    public final String c()
    {
      String str3 = ((ada)this.a).g;
      String str1 = "";
      if (TextUtils.isEmpty(str3)) {
        return "";
      }
      try
      {
        String str2 = str3.substring(0, 2);
        str3 = str3.substring(2);
        if (Integer.parseInt(str2, 16) == 1) {
          str1 = aey.a(str3);
        }
        return str1;
      }
      catch (Throwable localThrowable) {}
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aem
 * JD-Core Version:    0.7.0.1
 */