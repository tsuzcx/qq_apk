package com.tencent.mobileqq.activity.richmedia;

import acfp;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.qphone.base.util.QLog;

class NewFlowCameraActivity$41
  implements Runnable
{
  NewFlowCameraActivity$41(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    if (!this.this$0.bwO)
    {
      this.this$0.c.j(2002, acfp.m(2131709011), false);
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "[@] ERR_CODE_CAMERA_CREATE  黑名单机型,2秒还没有获取到预览帧,可能没有权限");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.41
 * JD-Core Version:    0.7.0.1
 */