package com.tencent.mobileqq.mini.appbrand;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.qphone.base.util.QLog;

class JsErrorGuard$8
  implements DialogInterface.OnClickListener
{
  JsErrorGuard$8(JsErrorGuard paramJsErrorGuard) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.e("miniapp-start_JsConsoleGuard", 2, "confirm");
    AppBrandProxy.g().sendCmd("cmd_exit_qq", new Bundle(), null);
    AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().exitProcess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.JsErrorGuard.8
 * JD-Core Version:    0.7.0.1
 */