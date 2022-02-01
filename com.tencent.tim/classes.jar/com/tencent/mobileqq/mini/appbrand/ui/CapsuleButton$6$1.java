package com.tencent.mobileqq.mini.appbrand.ui;

import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.mini.sdk.MiniAppController;

class CapsuleButton$6$1
  implements ThreadExcutor.IThreadListener
{
  CapsuleButton$6$1(CapsuleButton.6 param6) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    MiniAppController.startApp(null, this.this$1.val$miniAppConfig, null);
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton.6.1
 * JD-Core Version:    0.7.0.1
 */