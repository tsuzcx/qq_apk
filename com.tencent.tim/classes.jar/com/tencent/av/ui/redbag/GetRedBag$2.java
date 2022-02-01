package com.tencent.av.ui.redbag;

import com.tencent.qphone.base.util.QLog;
import jia;

public class GetRedBag$2
  implements Runnable
{
  public GetRedBag$2(jia paramjia, int paramInt) {}
  
  public void run()
  {
    this.this$0.mRunnable = null;
    QLog.w(this.this$0.TAG, 1, "getRedBag还没回包，超时结束, resultCode[" + this.val$resultCode + "]");
    jia.a(this.this$0, this.val$resultCode, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.redbag.GetRedBag.2
 * JD-Core Version:    0.7.0.1
 */