package com.tencent.smtt.sdk;

import android.os.Build.VERSION;

class l$1
  extends com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings
{
  l$1(l paraml, android.webkit.ServiceWorkerWebSettings paramServiceWorkerWebSettings) {}
  
  public boolean getAllowContentAccess()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return this.a.getAllowContentAccess();
    }
    return false;
  }
  
  public boolean getAllowFileAccess()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return this.a.getAllowFileAccess();
    }
    return false;
  }
  
  public boolean getBlockNetworkLoads()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return this.a.getBlockNetworkLoads();
    }
    return false;
  }
  
  public int getCacheMode()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return this.a.getCacheMode();
    }
    return -1;
  }
  
  public void setAllowContentAccess(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      this.a.setAllowContentAccess(paramBoolean);
    }
  }
  
  public void setAllowFileAccess(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      this.a.setAllowContentAccess(paramBoolean);
    }
  }
  
  public void setBlockNetworkLoads(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      this.a.setBlockNetworkLoads(paramBoolean);
    }
  }
  
  public void setCacheMode(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      this.a.setCacheMode(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.l.1
 * JD-Core Version:    0.7.0.1
 */