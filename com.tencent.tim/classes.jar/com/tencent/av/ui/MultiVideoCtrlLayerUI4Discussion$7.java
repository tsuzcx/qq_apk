package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class MultiVideoCtrlLayerUI4Discussion$7
  implements Runnable
{
  MultiVideoCtrlLayerUI4Discussion$7(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.mDestroy) {
      return;
    }
    String str = this.this$0.a.d(String.valueOf(this.val$uin), String.valueOf(this.this$0.md), this.this$0.aqx);
    this.this$0.dg.put(String.valueOf(this.val$uin), str);
    QLog.d(this.this$0.TAG, 1, "refreshUI --> user name mark name=" + str + ", mApp.getCurrentAccountUin()=" + String.valueOf(this.val$uin) + ", mMapNickNameCache.size()=" + this.this$0.dg.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion.7
 * JD-Core Version:    0.7.0.1
 */