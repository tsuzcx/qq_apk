package com.tencent.mobileqq.activity;

import acfp;
import ahgq;
import android.content.Intent;
import aqha;
import aqju;
import com.tencent.qphone.base.util.QLog;
import ufr;
import ufs;

public class ArkFullScreenAppActivity$8$1$1
  implements Runnable
{
  ArkFullScreenAppActivity$8$1$1(ArkFullScreenAppActivity.8.1 param1, Intent paramIntent) {}
  
  public void run()
  {
    try
    {
      if (this.val$intent != null)
      {
        ahgq.f(this.a.a.this$0, this.val$intent, 100);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ArkFullScreenAppActivity", 2, "showActionSheet share: intent == null");
      }
      aqha.a(this.a.a.this$0, 230, acfp.m(2131702817), acfp.m(2131702813), new ufs(this), null).show();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ArkFullScreenAppActivity", 1, "getShareMsg showActionSheet error: " + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ArkFullScreenAppActivity.8.1.1
 * JD-Core Version:    0.7.0.1
 */