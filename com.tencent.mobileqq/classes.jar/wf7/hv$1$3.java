package wf7;

import com.wifisdk.ui.WifiSDKUIApi;

class hv$1$3
  implements Runnable
{
  hv$1$3(hv.1 param1, int paramInt) {}
  
  public void run()
  {
    hc.b localb = hv.a(this.ut.ur);
    if (localb != null) {
      localb.ay(this.uv);
    }
    WifiSDKUIApi.showToast(hv.d(this.ut.ur), "下载腾讯WiFi管家失败", 0);
    if (hv.e(this.ut.ur) != null) {
      hv.e(this.ut.ur).release();
    }
    hv.a(this.ut.ur, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.hv.1.3
 * JD-Core Version:    0.7.0.1
 */