package com.tencent.biz.pubaccount;

import com.tencent.qphone.base.util.QLog;
import oac;

class PublicAccountBrowser$PublicAccountBrowserFragment$5
  implements Runnable
{
  PublicAccountBrowser$PublicAccountBrowserFragment$5(PublicAccountBrowser.PublicAccountBrowserFragment paramPublicAccountBrowserFragment) {}
  
  public void run()
  {
    try
    {
      boolean bool = oac.a(this.this$0.mApp, false, this.this$0.mUrl);
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "set subscribe full recommend switch = false , result : " + bool);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountBrowser.PublicAccountBrowserFragment.5
 * JD-Core Version:    0.7.0.1
 */