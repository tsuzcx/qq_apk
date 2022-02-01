package com.tencent.open.agent;

import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class OpenSelectPermissionFragment$2
  implements Runnable
{
  OpenSelectPermissionFragment$2(OpenSelectPermissionFragment paramOpenSelectPermissionFragment, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.this$0.getActivity() == null)
    {
      QLog.e("SDK_LOGIN.OpenSelectPermissionFragment", 1, "showToast activity is null");
      return;
    }
    QQToast localQQToast = new QQToast(this.this$0.getActivity());
    if (this.val$isSuccess)
    {
      localQQToast.setToastIcon(QQToast.getIconRes(2));
      localQQToast.setType(2);
    }
    for (;;)
    {
      localQQToast.setDuration(2000);
      localQQToast.setToastMsg(this.val$msg);
      localQQToast.show();
      return;
      localQQToast.setToastIcon(QQToast.getIconRes(1));
      localQQToast.setType(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.OpenSelectPermissionFragment.2
 * JD-Core Version:    0.7.0.1
 */