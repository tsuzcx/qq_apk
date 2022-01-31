package com.tencent.token.ui.base;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.h;

class cj
  extends Handler
{
  cj(RecordTextView paramRecordTextView) {}
  
  public void handleMessage(Message paramMessage)
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
        RecordTextView.a(this.a, RecordTextView.f(this.a) + this.a.getWidth() / 10);
        this.a.invalidate();
        RecordTextView.e(this.a).sendEmptyMessageDelayed(0, 70L);
        return;
      }
    } while (RecordTextView.g(this.a) == null);
    h.c("onAniEnd");
    RecordTextView.g(this.a).a(RecordTextView.h(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.cj
 * JD-Core Version:    0.7.0.1
 */