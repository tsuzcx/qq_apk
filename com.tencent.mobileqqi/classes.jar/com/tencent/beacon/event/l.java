package com.tencent.beacon.event;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public final class l
  implements Runnable
{
  private Context a;
  
  public l(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }
  
  public final void run()
  {
    com.tencent.beacon.a.a.e locale = com.tencent.beacon.a.e.l(this.a);
    Object localObject;
    if (locale != null)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("A43", locale.c());
      ((HashMap)localObject).put("A44", locale.d());
      ((HashMap)localObject).put("A41", locale.a());
      ((HashMap)localObject).put("A42", locale.b());
      m.a("rqd_useInfoEvent", true, 0L, 0L, (Map)localObject, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.beacon.event.l
 * JD-Core Version:    0.7.0.1
 */