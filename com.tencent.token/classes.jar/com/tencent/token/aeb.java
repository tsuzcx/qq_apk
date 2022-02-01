package com.tencent.token;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class aeb
  extends Thread
{
  public aeb(AtomicBoolean paramAtomicBoolean, HashMap paramHashMap, adp paramadp, Object paramObject) {}
  
  public final void run()
  {
    super.run();
    if (this.a.get()) {
      return;
    }
    Object localObject3 = ael.a;
    HashMap localHashMap;
    String str;
    if (((ael)localObject3).a(2))
    {
      localHashMap = this.b;
      str = this.c.a();
      ??? = str;
      if (str == null) {
        ??? = "";
      }
      localHashMap.put("260", ???);
    }
    if (((ael)localObject3).a(32))
    {
      localHashMap = this.b;
      str = this.c.b();
      ??? = str;
      if (str == null) {
        ??? = "";
      }
      localHashMap.put("261", ???);
    }
    if (((ael)localObject3).a(3))
    {
      localHashMap = this.b;
      str = this.c.c();
      ??? = str;
      if (str == null) {
        ??? = "";
      }
      localHashMap.put("262", ???);
    }
    if (((ael)localObject3).a(23))
    {
      localHashMap = this.b;
      str = this.c.d();
      ??? = str;
      if (str == null) {
        ??? = "";
      }
      localHashMap.put("263", ???);
    }
    if (((ael)localObject3).a(24))
    {
      localHashMap = this.b;
      str = this.c.e();
      ??? = str;
      if (str == null) {
        ??? = "";
      }
      localHashMap.put("264", ???);
    }
    if (((ael)localObject3).a(7))
    {
      localObject3 = this.b;
      str = this.c.f();
      ??? = str;
      if (str == null) {
        ??? = "";
      }
      ((HashMap)localObject3).put("265", ???);
    }
    synchronized (this.d)
    {
      this.d.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aeb
 * JD-Core Version:    0.7.0.1
 */