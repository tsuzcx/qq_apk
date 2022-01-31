package com.tencent.token.core.protocolcenter;

import com.tencent.token.ev;
import com.tencent.token.ew;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class f
{
  private ExecutorService a = Executors.newFixedThreadPool(5);
  private i b = new i(this, "");
  private h c = new g(this);
  
  public int a(ev paramev)
  {
    paramev.l = this.c;
    this.b.a(paramev);
    return 0;
  }
  
  public int a(String paramString)
  {
    this.b.a(paramString);
    return 0;
  }
  
  public ew b(ev paramev)
  {
    e locale = b.a(paramev.a);
    if (locale == null) {
      return null;
    }
    return locale.d(paramev);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.f
 * JD-Core Version:    0.7.0.1
 */