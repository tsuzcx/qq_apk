package com.tencent.mobileqq.webprocess;

import arcp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebAccelerator;
import java.util.HashMap;
import java.util.Map;
import jqo;

class WebAccelerateHelper$1
  implements Runnable
{
  WebAccelerateHelper$1(WebAccelerateHelper paramWebAccelerateHelper, boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public void run()
  {
    if (this.val$fisX5PreFetch)
    {
      localHashMap = new HashMap();
      localHashMap.put("User-Agent", arcp.b(arcp.qc("x5prefetch_1.0"), "", false));
      WebAccelerator.prefetchResource(BaseApplicationImpl.getContext(), this.val$fUrl, localHashMap, true);
      QLog.i("WebAccelerateHelper", 1, "now prefetchResource " + jqo.b(this.val$fUrl, new String[0]));
    }
    while (!this.val$fisX5PreConnect)
    {
      HashMap localHashMap;
      return;
    }
    WebAccelerator.preConnect(BaseApplicationImpl.getContext(), this.val$fUrl, 1, true);
    QLog.i("WebAccelerateHelper", 1, "now preconnect " + jqo.b(this.val$fUrl, new String[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebAccelerateHelper.1
 * JD-Core Version:    0.7.0.1
 */