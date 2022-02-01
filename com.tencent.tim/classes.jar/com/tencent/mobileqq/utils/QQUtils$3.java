package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public final class QQUtils$3
  implements Runnable
{
  public void run()
  {
    String str = null;
    if (this.cUx) {
      str = this.val$app.getApp().getString(2131720663);
    }
    if (str != null) {
      QQToast.a(this.val$app.getApp(), 2, str, 0).show(this.cuo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQUtils.3
 * JD-Core Version:    0.7.0.1
 */