package com.tencent.mobileqq.fragment;

import android.net.Uri;
import android.os.Handler;
import ardk;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.qphone.base.util.QLog;

class NearbyHybridFragment$4
  implements Runnable
{
  NearbyHybridFragment$4(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void run()
  {
    boolean bool = WebSoService.a().rV(this.this$0.bZ);
    int i = this.this$0.Fd();
    if (QLog.isColorLevel()) {
      QLog.d("nearby.NearbyHybridFragment.webloading", 2, "startWebSoRequest, hasWebSoCache=" + bool + ", initTab=" + i + ", url=" + this.this$0.bZ);
    }
    if (bool) {
      this.this$0.mHandler.removeMessages(3);
    }
    if (i != -1) {}
    try
    {
      ardk.k(Uri.parse(this.this$0.bZ));
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment.webloading", 2, "cleanWebSoData: hasCacheData=" + WebSoService.a().rV(this.this$0.bZ));
      }
      WebSoService.a().a(this.this$0.bZ, null);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("nearby.NearbyHybridFragment.webloading", 2, "cleanWebSoData exp:" + localException.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment.4
 * JD-Core Version:    0.7.0.1
 */