package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class VasWebReport
  extends WebViewPlugin
{
  private static final String TAG = "VasWebReport";
  private Map erroMap = new HashMap();
  private Map startTimeMap = new HashMap();
  
  protected boolean handleEvent(String paramString, int paramInt, Map paramMap)
  {
    switch (paramInt)
    {
    }
    label237:
    do
    {
      do
      {
        return false;
        this.startTimeMap.remove(paramString);
        this.startTimeMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
      } while (!QLog.isColorLevel());
      QLog.d("VasWebReport", 2, "VasWebReport:EVENT_LOAD_START");
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("VasWebReport", 2, "VasWebReport:EVENT_LOAD_FINISH");
      }
      Context localContext;
      if ((paramString.contains("vip.qq.com")) || (paramString.contains("vaswebreport=1")))
      {
        paramMap = "XG";
        localContext = this.mRuntime.a().getApplicationContext();
        if (2 != NetworkUtil.a(localContext)) {
          break label237;
        }
        paramMap = "2G";
      }
      while (this.erroMap.containsKey(paramString))
      {
        ReportController.a(null, "P_CliOper", "vasweb", "", "load", "finish", 0, 1, "errocode:" + this.erroMap.get(paramString), paramMap, paramString, "6.0.2--android--" + Build.VERSION.SDK_INT);
        this.erroMap.remove(paramString);
        this.startTimeMap.remove(paramString);
        return false;
        if (3 == NetworkUtil.a(localContext)) {
          paramMap = "3G";
        } else if (4 == NetworkUtil.a(localContext)) {
          paramMap = "4G";
        } else if (1 == NetworkUtil.a(localContext)) {
          paramMap = "WIFI";
        }
      }
      if (this.startTimeMap.containsKey(paramString)) {}
      for (long l = System.currentTimeMillis() - ((Long)this.startTimeMap.get(paramString)).longValue();; l = -1L)
      {
        ReportController.a(null, "P_CliOper", "vasweb", "", "load", "finish", 0, 0, "" + l, paramMap, paramString, "6.0.2--android--" + Build.VERSION.SDK_INT);
        break;
        if (QLog.isColorLevel()) {
          QLog.e("VasWebReport", 2, "VasWebReport--EVENT_LOAD_FINISH:report erro,there is not starttime for " + paramString);
        }
      }
      paramInt = ((Integer)paramMap.get("errorCode")).intValue();
      this.erroMap.put(paramString, Integer.valueOf(paramInt));
    } while (!QLog.isColorLevel());
    QLog.e("VasWebReport", 2, "VasWebReport:EVENT_LOAD_ERROR");
    return false;
  }
  
  protected void onDestroy()
  {
    this.startTimeMap.clear();
    this.startTimeMap = null;
    this.erroMap.clear();
    this.erroMap = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasWebReport
 * JD-Core Version:    0.7.0.1
 */