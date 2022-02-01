package com.tencent.av.share;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import aqju;
import com.tencent.qphone.base.util.QLog;

class AVSchema$4
  implements Runnable
{
  AVSchema$4(AVSchema paramAVSchema, long paramLong) {}
  
  public void run()
  {
    QLog.w(this.this$0.TAG, 1, "handleResult_I_Known, msg[" + this.this$0.isResumed() + "], seq[" + this.kQ + "]");
    if (this.this$0.m != null) {}
    try
    {
      this.this$0.m.show();
      this.this$0.m.getWindow().getDecorView().requestLayout();
      this.this$0.getActivity().getWindow().getDecorView().requestLayout();
      this.this$0.getActivity().getWindow().getDecorView().invalidate();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.share.AVSchema.4
 * JD-Core Version:    0.7.0.1
 */