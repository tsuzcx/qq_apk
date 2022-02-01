package com.tencent.open.agent.util;

import android.app.Activity;
import com.tencent.mobileqq.widget.QQToast;

public final class AuthorityUtil$1
  implements Runnable
{
  public AuthorityUtil$1(Activity paramActivity, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    QQToast localQQToast = new QQToast(this.val$activity);
    if (this.val$isSuccess)
    {
      localQQToast.setToastIcon(QQToast.getIconRes(2));
      localQQToast.setType(2);
    }
    for (;;)
    {
      localQQToast.setDuration(1);
      localQQToast.setToastMsg(this.val$msg);
      localQQToast.show();
      return;
      localQQToast.setToastIcon(QQToast.getIconRes(1));
      localQQToast.setType(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.util.AuthorityUtil.1
 * JD-Core Version:    0.7.0.1
 */