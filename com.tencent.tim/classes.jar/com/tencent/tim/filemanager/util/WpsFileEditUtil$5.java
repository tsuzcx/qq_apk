package com.tencent.tim.filemanager.util;

import android.content.res.Resources;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.widget.WpsFileEditToastStyleDlg;

public final class WpsFileEditUtil$5
  implements Runnable
{
  public WpsFileEditUtil$5(boolean paramBoolean1, int paramInt, boolean paramBoolean2) {}
  
  public void run()
  {
    if (BaseActivity.sTopActivity == null)
    {
      QLog.e("WpsFileEditUtil", 1, "[WPSEDIT] showSaveCloudGuideTip err. bCopyVer:" + this.diL + " busType:" + this.erm);
      return;
    }
    boolean bool = false;
    String str;
    if (this.erm == 6)
    {
      if (this.diL) {}
      for (str = BaseActivity.sTopActivity.getResources().getString(2131693892);; str = BaseActivity.sTopActivity.getResources().getString(2131693893))
      {
        WpsFileEditToastStyleDlg.a(BaseActivity.sTopActivity, str, WpsFileEditToastStyleDlg.ert, bool);
        return;
      }
    }
    if (this.diL) {
      str = BaseActivity.sTopActivity.getResources().getString(2131693897);
    }
    for (;;)
    {
      bool = true;
      break;
      if (this.diM) {
        str = BaseActivity.sTopActivity.getResources().getString(2131693896);
      } else {
        str = BaseActivity.sTopActivity.getResources().getString(2131693898);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.util.WpsFileEditUtil.5
 * JD-Core Version:    0.7.0.1
 */