package com.tencent.mobileqq.ar.ARRenderModel;

import addp;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.QLog;

public class Interactive3DRenderable$4
  implements Runnable
{
  public void run()
  {
    addp.a(this.this$0).native_onTouchBegin(this.val$idDown, this.val$xDown, this.val$yDown, 0, this.val$timestamp, addp.a(this.this$0).mCurrentActiveId);
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_Interactive3DRenderable", 2, "ACTION_DOWN native_onTouchBegin");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.Interactive3DRenderable.4
 * JD-Core Version:    0.7.0.1
 */