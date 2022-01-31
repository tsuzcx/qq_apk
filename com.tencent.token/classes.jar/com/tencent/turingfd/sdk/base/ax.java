package com.tencent.turingfd.sdk.base;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;

public final class ax
  implements bt
{
  public void a(String paramString, MotionEvent paramMotionEvent)
  {
    bc localbc = bc.a();
    localbc.m = paramString;
    localbc.f = paramMotionEvent.getAction();
    localbc.g = paramMotionEvent.getDeviceId();
    localbc.h = paramMotionEvent.getToolType(0);
    localbc.i = paramMotionEvent.getRawX();
    localbc.j = paramMotionEvent.getRawY();
    localbc.k = paramMotionEvent.getPressure();
    localbc.l = paramMotionEvent.getSize();
    ba.b.obtainMessage(1, localbc).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.ax
 * JD-Core Version:    0.7.0.1
 */