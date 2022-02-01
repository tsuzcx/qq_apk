package com.tencent.mobileqq.activity.richmedia;

import aara;
import aasr;
import com.tencent.qphone.base.util.QLog;

public class NewFlowCameraActivity$21
  implements Runnable
{
  NewFlowCameraActivity$21(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    if (aasr.isSupport(this.this$0.getApplicationContext()))
    {
      aasr localaasr = aasr.a();
      localaasr.a(this.this$0.getApplicationContext(), new aara(this, localaasr));
      return;
    }
    QLog.w("PTV.NewFlowCameraActivity", 2, "your device don't support video filter!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.21
 * JD-Core Version:    0.7.0.1
 */