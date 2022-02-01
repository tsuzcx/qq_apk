package com.tencent.android.tpush.stat;

import android.content.Context;
import com.tencent.android.tpush.stat.event.c.a;
import com.tencent.tpns.baseapi.XGApiConfig;

final class StatServiceImpl$12
  implements Runnable
{
  StatServiceImpl$12(Context paramContext, String paramString, c.a parama) {}
  
  public void run()
  {
    try
    {
      long l = XGApiConfig.getAccessId(this.a);
      com.tencent.android.tpush.stat.event.c localc = new com.tencent.android.tpush.stat.event.c(this.a, 0, this.b, l, System.currentTimeMillis());
      localc.a().c = this.c.c;
      StatServiceImpl.a(localc);
      return;
    }
    catch (Throwable localThrowable)
    {
      StatServiceImpl.d().b(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.StatServiceImpl.12
 * JD-Core Version:    0.7.0.1
 */