package com.tencent.token.core.protocolcenter;

import com.tencent.token.dp;
import com.tencent.token.global.e;
import java.util.concurrent.Callable;

public class h
{
  public static Callable<e> a(dp paramdp)
  {
    new Callable()
    {
      public e a()
      {
        e locale = new e();
        d locald = b.a(this.a.a);
        if (locald != null)
        {
          locale = locald.c(this.a);
          this.a.l.a(this.a, locale);
        }
        return locale;
      }
    };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.h
 * JD-Core Version:    0.7.0.1
 */