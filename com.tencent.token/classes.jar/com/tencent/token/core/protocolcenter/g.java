package com.tencent.token.core.protocolcenter;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.tencent.token.cn;
import com.tencent.token.ev;
import com.tencent.token.upload.useraction.a;
import com.tencent.token.utils.w;

class g
  implements h
{
  g(f paramf) {}
  
  public void a(ev paramev)
  {
    MotionEvent localMotionEvent = a.a().b();
    if (localMotionEvent != null)
    {
      com.tencent.token.global.h.c("cginame:" + paramev.a);
      com.tencent.token.global.h.c("pagename:" + paramev.i);
      com.tencent.token.global.h.c("getRawX:" + localMotionEvent.getRawX());
      com.tencent.token.global.h.c("getRawY:" + localMotionEvent.getRawY());
      long l = System.currentTimeMillis() - (SystemClock.uptimeMillis() - localMotionEvent.getDownTime());
      com.tencent.token.global.h.c("eventStartTime:" + l);
      int i = a.a().c();
      com.tencent.token.global.h.c("touch_type:" + i);
      a.a().a(i, paramev.a, paramev.i, "", "", "", (int)localMotionEvent.getRawX(), (int)localMotionEvent.getRawY(), l);
      a.a().d();
    }
  }
  
  public void a(ev paramev, com.tencent.token.global.f paramf)
  {
    if (paramf.b())
    {
      cn.a().a(System.currentTimeMillis(), 0, paramev.a, 0, "", w.k());
      if (!paramev.e)
      {
        paramf = paramev.d.obtainMessage(paramev.f);
        paramf.arg1 = 0;
        paramf.sendToTarget();
        paramev.e = true;
      }
    }
    label175:
    for (;;)
    {
      f.a(this.a).b(paramev);
      return;
      if (paramf.a < 10000) {
        cn.a().a(System.currentTimeMillis(), 0, paramev.a, 0, "", w.k());
      }
      for (;;)
      {
        if (paramev.e) {
          break label175;
        }
        Message localMessage = paramev.d.obtainMessage(paramev.f);
        localMessage.arg1 = paramf.a;
        localMessage.obj = paramf;
        localMessage.sendToTarget();
        paramev.e = true;
        break;
        cn.a().a(System.currentTimeMillis(), cn.a(paramf.a), paramev.a, 1, paramf.b, w.k());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.g
 * JD-Core Version:    0.7.0.1
 */