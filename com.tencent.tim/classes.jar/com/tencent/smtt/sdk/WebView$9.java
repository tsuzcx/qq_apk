package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;

final class WebView$9
  implements Runnable
{
  public void run()
  {
    if (WebView.g() == null) {
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
    }
    g localg;
    int i;
    int j;
    do
    {
      return;
      localg = g.a(true);
      if (g.b)
      {
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
        return;
      }
      n localn = n.a(WebView.g());
      i = localn.c();
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--installStatus = " + i);
      if (i == 2)
      {
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
        localg.a(String.valueOf(localn.b()));
        localg.b(true);
        return;
      }
      j = localn.b("copy_status");
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copyStatus = " + j);
      if (j == 1)
      {
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
        localg.a(String.valueOf(localn.c("copy_core_ver")));
        localg.b(true);
        return;
      }
    } while ((y.a().b()) || ((i != 3) && (j != 3)));
    TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
    localg.a(String.valueOf(g.c()));
    localg.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView.9
 * JD-Core Version:    0.7.0.1
 */