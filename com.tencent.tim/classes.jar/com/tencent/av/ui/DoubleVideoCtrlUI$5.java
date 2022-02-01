package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import iiv;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

class DoubleVideoCtrlUI$5
  extends TimerTask
{
  boolean Wi = this.Wj;
  
  DoubleVideoCtrlUI$5(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.this$0.a == null) || (this.this$0.mApp == null)) {}
    iiv localiiv;
    do
    {
      return;
      localiiv = this.this$0.a.b();
    } while (localiiv == null);
    if (localiiv.ann <= 0)
    {
      if (this.this$0.m != null)
      {
        this.this$0.m.cancel();
        this.this$0.m = null;
      }
      QLog.w(this.this$0.TAG, 1, "StartGlassCheck, cancel cur Timer");
      return;
    }
    for (;;)
    {
      long l3;
      try
      {
        if (this.this$0.mContext == null) {
          break label333;
        }
        l1 = ((AVActivity)this.this$0.mContext.get()).b.z(this.this$0.a.b().peerUin);
        long l2 = System.currentTimeMillis();
        if (l1 == 0L) {
          break;
        }
        l3 = l2 - l1;
        QLog.w(this.this$0.TAG, 1, "StartGlassCheck, interval[" + l3 + "], mCheck[" + this.Wi + "], mCurrentDoubleVideoGlassSwitch[" + this.this$0.a.b().anm + "]");
        if ((l3 > this.this$0.a.b().ann * 1000) && (this.Wi))
        {
          this.this$0.mApp.runOnUiThread(new DoubleVideoCtrlUI.5.1(this, l2, l1));
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.w(this.this$0.TAG, 1, "StartGlassCheck, Exception", localException);
        l1 = 0L;
        continue;
      }
      if ((this.this$0.a.b().anm == 0) || (l3 >= 1000L)) {
        break;
      }
      this.this$0.mApp.runOnUiThread(new DoubleVideoCtrlUI.5.2(this));
      return;
      label333:
      long l1 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.5
 * JD-Core Version:    0.7.0.1
 */