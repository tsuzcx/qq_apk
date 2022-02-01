package com.tencent.mobileqq.apollo.sdk;

import absa;
import absp;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class CmShowViewListener$1
  implements Runnable
{
  public CmShowViewListener$1(absp paramabsp, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (absp.a(this.this$0).get() != null) {
      ((absa)absp.a(this.this$0).get()).HW(absp.a(this.this$0));
    }
    QLog.d("CmShow_ApolloDrawerInfoViewListener", 1, new Object[] { "onSurfaceReady w:", Integer.valueOf(this.val$w), " h:", Integer.valueOf(this.val$h) });
    if (absp.a(this.this$0) != null) {
      absp.a(this.this$0).aH(this.val$w, this.val$h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowViewListener.1
 * JD-Core Version:    0.7.0.1
 */