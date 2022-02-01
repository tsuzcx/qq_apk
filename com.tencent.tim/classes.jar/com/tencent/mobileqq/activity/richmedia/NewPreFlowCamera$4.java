package com.tencent.mobileqq.activity.richmedia;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class NewPreFlowCamera$4
  implements Runnable
{
  NewPreFlowCamera$4(NewPreFlowCamera paramNewPreFlowCamera, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewPreFlowCamera", 2, "onStatusChanged: " + this.byL + " error:" + this.val$error);
    }
    if (!this.byL)
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2131718877, 0).show();
      NewPreFlowCamera.a(this.this$0, -1);
      return;
    }
    NewPreFlowCamera.a(this.this$0, 101);
    NewPreFlowCamera.a(this.this$0, "onStatusChanged");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewPreFlowCamera.4
 * JD-Core Version:    0.7.0.1
 */