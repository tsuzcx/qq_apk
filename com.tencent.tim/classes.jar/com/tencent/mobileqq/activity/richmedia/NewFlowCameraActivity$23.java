package com.tencent.mobileqq.activity.richmedia;

import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr;

class NewFlowCameraActivity$23
  implements Runnable
{
  NewFlowCameraActivity$23(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    Bitmap localBitmap = null;
    if (this.this$0.c != null) {
      localBitmap = this.this$0.c.a.b(false);
    }
    if (this.this$0.mUIHandler != null) {
      this.this$0.mUIHandler.post(new NewFlowCameraActivity.RunnableUpdate(localBitmap, this.this$0.wq));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.23
 * JD-Core Version:    0.7.0.1
 */