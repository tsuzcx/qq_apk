package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import acfp;
import android.content.Context;
import arhz;
import com.tencent.mobileqq.app.ThreadManager;

class DataJsPlugin$30
  implements Runnable
{
  DataJsPlugin$30(DataJsPlugin paramDataJsPlugin, Context paramContext, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    arhz localarhz = new arhz(this.val$context);
    localarhz.setMessage(acfp.m(2131704610));
    localarhz.show();
    ThreadManager.excute(new DataJsPlugin.30.1(this, localarhz), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.30
 * JD-Core Version:    0.7.0.1
 */