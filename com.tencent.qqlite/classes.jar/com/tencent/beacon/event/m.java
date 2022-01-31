package com.tencent.beacon.event;

import android.content.Context;
import com.tencent.beacon.a.a.e;
import com.tencent.beacon.a.g;
import java.util.HashMap;
import java.util.Map;

public final class m
  implements Runnable
{
  private Context a;
  
  public m(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public final void run()
  {
    e locale = g.o(this.a);
    Object localObject;
    if (locale != null)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("A43", locale.c());
      ((HashMap)localObject).put("A44", locale.d());
      ((HashMap)localObject).put("A41", locale.a());
      ((HashMap)localObject).put("A42", locale.b());
      n.a("rqd_useInfoEvent", true, 0L, 0L, (Map)localObject, true);
      localObject = this.a;
      if (localObject != null) {
        break label171;
      }
    }
    for (;;)
    {
      com.tencent.beacon.d.a.e("%s %d %d", new Object[] { "rqd_useInfoEvent", Long.valueOf(locale.a()), Long.valueOf(locale.b()) });
      return;
      label171:
      com.tencent.beacon.a.a.a.a((Context)localObject, new int[] { 8 }, -1L, 9223372036854775807L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.beacon.event.m
 * JD-Core Version:    0.7.0.1
 */