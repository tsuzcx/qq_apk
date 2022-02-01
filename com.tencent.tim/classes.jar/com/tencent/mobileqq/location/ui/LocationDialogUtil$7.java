package com.tencent.mobileqq.location.ui;

import airk;
import airz;
import aivd;
import android.content.res.Resources;
import aqha;
import aqju;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public final class LocationDialogUtil$7
  implements Runnable
{
  public LocationDialogUtil$7(BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    if (aivd.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).clT)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationDialogUtil", 2, "showBadNetDialog: invoked. 当前如果展示悬浮窗，就不显示这个弹窗了");
      }
      return;
    }
    aqju localaqju = aqha.a(this.val$activity, 230, null, this.val$activity.getResources().getString(2131720285), 2131721079, 2131721058, null, new airz(this));
    airk.b(this.val$activity, localaqju);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationDialogUtil.7
 * JD-Core Version:    0.7.0.1
 */