package com.tencent.biz.common.offline;

import java.util.HashMap;
import jox;
import jpa;
import jpj;
import mqq.app.AppRuntime;

public final class HtmlOffline$4
  implements Runnable
{
  public HtmlOffline$4(int paramInt, String paramString, AppRuntime paramAppRuntime, HashMap paramHashMap, jox paramjox, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (jpa.a.isColorLevel()) {
      jpa.a.i("HtmlCheckUpdate", 2, "start checkUpThread. delay:" + this.aCA + ", businessId:" + this.val$businessId);
    }
    if (this.aCA > 0) {}
    try
    {
      Thread.sleep(this.aCA * 1000);
      label75:
      jpa.a(this.val$app, this.cP, this.d, true, this.abb, this.abc);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label75;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.common.offline.HtmlOffline.4
 * JD-Core Version:    0.7.0.1
 */