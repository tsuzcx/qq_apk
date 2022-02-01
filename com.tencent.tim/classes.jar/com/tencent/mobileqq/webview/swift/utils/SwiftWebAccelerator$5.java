package com.tencent.mobileqq.webview.swift.utils;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import aopd;
import arcn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import jml;

public class SwiftWebAccelerator$5
  implements Runnable
{
  public SwiftWebAccelerator$5(arcn paramarcn, long paramLong, Bundle paramBundle) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_LoadConfigs.run cost " + (l - this.val$startTime) + "ms.");
    l = System.currentTimeMillis();
    aopd.a();
    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_LoadConfigs:init inner-dns cost " + (l - this.val$startTime) + "ms.");
    l = System.currentTimeMillis();
    jml localjml = jml.a(false);
    localjml.z("https://www.qq.com/", "foo.bar");
    localjml.a("skey");
    localjml.a("pskey");
    localjml.a("pt4_token");
    localjml.a("a1");
    localjml.a("a2");
    localjml.dF("https://www.qq.com/");
    localjml.xW();
    localjml.xX();
    localjml.ya();
    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_LoadConfigs:load domain white list config, cost " + (System.currentTimeMillis() - l) + "ms.");
    l = System.currentTimeMillis();
    if (WebAccelerateHelper.getInstance().isPreGetKey()) {
      SwiftBrowserCookieMonster.a(BaseApplicationImpl.sApplication.getRuntime(), new Intent());
    }
    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_LoadConfigs:pre get key, cost " + (System.currentTimeMillis() - l) + "ms.");
    int i = this.bv.getInt("from", -1);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_SwiftWebAccelerator", 2, "doThreadedStep_LoadConfigs: preload from " + i);
    }
    new Handler(Looper.getMainLooper()).post(new SwiftWebAccelerator.5.1(this, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.5
 * JD-Core Version:    0.7.0.1
 */