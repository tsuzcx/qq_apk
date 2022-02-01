package com.tencent.mobileqq.mini.utils;

import android.content.Intent;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener;
import com.tencent.qphone.base.util.QLog;

final class TroopApplicationListUtil$7
  implements MiniAppController.ActivityResultListener
{
  TroopApplicationListUtil$7(BaseJsPluginEngine paramBaseJsPluginEngine, String paramString, TroopApplicationListUtil.JsPluginParam paramJsPluginParam) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1048576) && (paramInt2 == -1))
    {
      String str = paramIntent.getStringExtra("uin");
      paramIntent = paramIntent.getStringExtra("uinname");
      TroopApplicationListUtil.addMiniAppToTroopApplicationList(this.val$jsPluginEngine, str, this.val$appId, null, this.val$jsPluginParam);
      MiniAppController.getInstance().removeActivityResultListener(this);
      QLog.d("TroopApplicationListUtil", 1, "group uin: " + str + ", group name: " + paramIntent);
    }
    QLog.d("TroopApplicationListUtil", 2, "startTroopActivityAndAddTroopApplication, requestCode = " + paramInt1 + ", resultCode = " + paramInt2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.TroopApplicationListUtil.7
 * JD-Core Version:    0.7.0.1
 */