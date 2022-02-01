package com.tencent.mobileqq.ar.ARRenderModel;

import addp;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.QLog;

public class Interactive3DRenderable$8
  implements Runnable
{
  public void run()
  {
    addp.a(this.this$0).native_onTouchCancel(this.val$ids, this.val$xs, this.val$ys, this.val$timestamp, addp.a(this.this$0).mCurrentActiveId);
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_Interactive3DRenderable", 2, "ACTION_CANCEL native_onTouchCancel");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable.8
 * JD-Core Version:    0.7.0.1
 */