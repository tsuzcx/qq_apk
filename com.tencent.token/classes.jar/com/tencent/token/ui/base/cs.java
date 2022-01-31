package com.tencent.token.ui.base;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.e;

final class cs
  extends Handler
{
  cs(RecordTextView paramRecordTextView) {}
  
  public final void handleMessage(Message paramMessage)
  {
    paramMessage = this.a;
    boolean bool;
    if (!RecordTextView.a(this.a))
    {
      bool = true;
      RecordTextView.a(paramMessage, bool);
      if (!RecordTextView.b(this.a)) {
        break label81;
      }
      RecordTextView.c(this.a);
      this.a.invalidate();
      if (RecordTextView.d(this.a) >= 10) {
        break label81;
      }
      RecordTextView.e(this.a).sendEmptyMessageDelayed(0, 70L);
    }
    label81:
    do
    {
      return;
      bool = false;
      break;
      if (RecordTextView.f(this.a) < this.a.getWidth())
      {
        RecordTextView.a(this.a, this.a.getWidth() / 10);
        this.a.invalidate();
        RecordTextView.e(this.a).sendEmptyMessageDelayed(0, 70L);
        return;
      }
    } while (RecordTextView.g(this.a) == null);
    e.c("onAniEnd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.cs
 * JD-Core Version:    0.7.0.1
 */