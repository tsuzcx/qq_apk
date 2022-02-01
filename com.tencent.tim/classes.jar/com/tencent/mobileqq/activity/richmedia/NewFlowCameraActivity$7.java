package com.tencent.mobileqq.activity.richmedia;

import aaqi;
import aary;
import aasb;
import aaso;
import com.tencent.qphone.base.util.QLog;

class NewFlowCameraActivity$7
  implements Runnable
{
  NewFlowCameraActivity$7(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    String str = this.this$0.bdF;
    NewFlowCameraActivity.a(this.this$0);
    aaso.cX(str, aary.cjn);
    this.this$0.cfl = 0;
    if (QLog.isColorLevel()) {
      QLog.d(".photo", 2, "shot photo with capture from video");
    }
    NewFlowCameraActivity.a(this.this$0);
    if (this.this$0.a == null) {}
    for (str = "";; str = this.this$0.a.qD())
    {
      aaqi.h("", "0X80075BE", str, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.7
 * JD-Core Version:    0.7.0.1
 */