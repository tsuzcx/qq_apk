package com.tencent.mobileqq.utils;

import anot;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public final class QQUtils$2
  implements Runnable
{
  public QQUtils$2(boolean paramBoolean, QQAppInterface paramQQAppInterface, int paramInt, String paramString) {}
  
  public void run()
  {
    String str1 = null;
    if (this.cUx) {
      str1 = this.val$app.getApp().getString(2131720663);
    }
    for (String str2 = "0";; str2 = "1")
    {
      if (str1 != null) {
        QQToast.a(this.val$app.getApp(), 2, str1, 0).show(this.cuo);
      }
      anot.a(this.val$app, "CliOper", "", "", "Fast_launch", "Fast_launch_creat", 0, 0, this.val$from, str2, "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQUtils.2
 * JD-Core Version:    0.7.0.1
 */