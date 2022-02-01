package com.tencent.beacon.a.b;

import com.tencent.beacon.base.net.HttpMethod;
import com.tencent.beacon.base.net.call.Callback;
import com.tencent.beacon.base.net.call.e;
import com.tencent.beacon.base.net.call.e.a;
import com.tencent.beacon.base.util.b;
import java.util.LinkedHashMap;
import java.util.Map;

class c
  implements Runnable
{
  c(d paramd, String paramString1, String paramString2, Throwable paramThrowable, Callback paramCallback) {}
  
  public void run()
  {
    synchronized (this.e)
    {
      Object localObject1 = new LinkedHashMap(d.a());
      ((Map)localObject1).put("error_code", this.a);
      ((Map)localObject1).put("error_msg", this.b);
      ((Map)localObject1).put("error_stack_full", b.a(this.c));
      ((Map)localObject1).put("_dc", String.valueOf(Math.random()));
      e.a locala = e.b();
      locala = locala.b("https://h.trace.qq.com/kv");
      localObject1 = locala.a("atta").a((Map)localObject1).a(HttpMethod.POST).a();
      com.tencent.beacon.base.net.c.c().a((e)localObject1).a(this.d);
      com.tencent.beacon.base.util.c.d("[atta] upload a new error, errorCode: %s, message: %s, stack: %s", new Object[] { this.a, this.b, b.a(this.c) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.a.b.c
 * JD-Core Version:    0.7.0.1
 */