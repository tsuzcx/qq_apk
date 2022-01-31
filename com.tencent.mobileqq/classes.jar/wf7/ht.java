package wf7;

import com.tencent.wifisdk.TMSDKFreeWifiInfo;
import com.tencent.wifisdk.TMSDKWifiEventListener;
import com.wifisdk.ui.view.d;

public class ht
  implements TMSDKWifiEventListener
{
  private d tY;
  private TMSDKFreeWifiInfo tZ = null;
  private int ua = 0;
  
  public void a(d paramd)
  {
    this.tY = paramd;
    paramd.a(this);
  }
  
  public void onConnectionCancel()
  {
    this.tY.fS();
    this.tZ = null;
    this.ua = 0;
  }
  
  public void onConnectionFailed(int paramInt)
  {
    if (paramInt == -9) {
      if ((this.ua == 2) || (this.ua == 3))
      {
        this.ua = 4;
        this.tY.b(this.tZ);
      }
    }
    while ((this.ua != 1) && (this.ua != 2) && (this.ua != 3)) {
      return;
    }
    this.ua = 4;
    this.tY.b(this.tZ);
  }
  
  public void onConnectionStart(TMSDKFreeWifiInfo paramTMSDKFreeWifiInfo)
  {
    this.ua = 1;
    this.tZ = paramTMSDKFreeWifiInfo;
  }
  
  public void onConnectionStateChanged(int paramInt, TMSDKFreeWifiInfo paramTMSDKFreeWifiInfo)
  {
    if (this.tZ == null) {
      this.tZ = paramTMSDKFreeWifiInfo;
    }
    this.ua = 2;
    this.tZ = paramTMSDKFreeWifiInfo;
  }
  
  public void onConnectionSuccess(TMSDKFreeWifiInfo paramTMSDKFreeWifiInfo)
  {
    if (paramTMSDKFreeWifiInfo == null) {
      return;
    }
    this.ua = 3;
    this.tZ = paramTMSDKFreeWifiInfo;
    this.tY.a(this.tZ);
  }
  
  public void onGPSDisabled()
  {
    this.tY.fS();
    this.tZ = null;
    this.ua = 0;
  }
  
  public void onGPSEnabled() {}
  
  public void onWifiDisabled()
  {
    this.tY.fS();
    this.tZ = null;
    this.ua = 0;
  }
  
  public void onWifiEnabled() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.ht
 * JD-Core Version:    0.7.0.1
 */