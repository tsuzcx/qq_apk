package com.tencent.ad.tangram.canvas.resource;

import android.support.annotation.Keep;
import java.lang.ref.WeakReference;

@Keep
public enum AdResource
{
  INSTANCE;
  
  private WeakReference<AdResourceAdapter> adapter;
  
  private AdResource() {}
  
  private static AdResourceAdapter getAdapter()
  {
    if (INSTANCE.adapter != null) {
      return (AdResourceAdapter)INSTANCE.adapter.get();
    }
    return null;
  }
  
  public static int getAppDescViewId()
  {
    AdResourceAdapter localAdResourceAdapter = getAdapter();
    if (localAdResourceAdapter != null) {
      return localAdResourceAdapter.getAppDescViewId();
    }
    return -2147483648;
  }
  
  public static int getAppDownloadButtonViewId()
  {
    AdResourceAdapter localAdResourceAdapter = getAdapter();
    if (localAdResourceAdapter != null) {
      return localAdResourceAdapter.getAppDownloadButtonViewId();
    }
    return -2147483648;
  }
  
  public static int getAppLogoViewId()
  {
    AdResourceAdapter localAdResourceAdapter = getAdapter();
    if (localAdResourceAdapter != null) {
      return localAdResourceAdapter.getAppLogoViewId();
    }
    return -2147483648;
  }
  
  public static int getAppNameViewId()
  {
    AdResourceAdapter localAdResourceAdapter = getAdapter();
    if (localAdResourceAdapter != null) {
      return localAdResourceAdapter.getAppNameViewId();
    }
    return -2147483648;
  }
  
  public static int getAppSizeViewId()
  {
    AdResourceAdapter localAdResourceAdapter = getAdapter();
    if (localAdResourceAdapter != null) {
      return localAdResourceAdapter.getAppSizeViewId();
    }
    return -2147483648;
  }
  
  public static int getArkWindowLayoutId()
  {
    AdResourceAdapter localAdResourceAdapter = getAdapter();
    if (localAdResourceAdapter != null) {
      return localAdResourceAdapter.getArkWindowLayoutId();
    }
    return -2147483648;
  }
  
  public static int getBottomFixedButtonId()
  {
    AdResourceAdapter localAdResourceAdapter = getAdapter();
    if (localAdResourceAdapter != null) {
      return localAdResourceAdapter.getBottomFixedButtonId();
    }
    return -2147483648;
  }
  
  public static int getCanvasContentId()
  {
    AdResourceAdapter localAdResourceAdapter = getAdapter();
    if (localAdResourceAdapter != null) {
      return localAdResourceAdapter.getCanvasContentId();
    }
    return -2147483648;
  }
  
  public static int getCanvasFixedButtonLayoutId()
  {
    AdResourceAdapter localAdResourceAdapter = getAdapter();
    if (localAdResourceAdapter != null) {
      return localAdResourceAdapter.getCanvasFixedButtonLayoutId();
    }
    return -2147483648;
  }
  
  public static int getCanvasLayoutId()
  {
    AdResourceAdapter localAdResourceAdapter = getAdapter();
    if (localAdResourceAdapter != null) {
      return localAdResourceAdapter.getCanvasLayoutId();
    }
    return -2147483648;
  }
  
  public static int getCloseViewId()
  {
    AdResourceAdapter localAdResourceAdapter = getAdapter();
    if (localAdResourceAdapter != null) {
      return localAdResourceAdapter.getCloseViewId();
    }
    return -2147483648;
  }
  
  public static int getCommonFixedButtonContainerId()
  {
    AdResourceAdapter localAdResourceAdapter = getAdapter();
    if (localAdResourceAdapter != null) {
      return localAdResourceAdapter.getCommonFixedButtonContainerId();
    }
    return -2147483648;
  }
  
  public static int getFloatingProgressBarId()
  {
    AdResourceAdapter localAdResourceAdapter = getAdapter();
    if (localAdResourceAdapter != null) {
      return localAdResourceAdapter.getFloatingProgressBarId();
    }
    return -2147483648;
  }
  
  public static int getTopFixedButtonId()
  {
    AdResourceAdapter localAdResourceAdapter = getAdapter();
    if (localAdResourceAdapter != null) {
      return localAdResourceAdapter.getTopFixedButtonId();
    }
    return -2147483648;
  }
  
  public static void setAdapter(WeakReference<AdResourceAdapter> paramWeakReference)
  {
    INSTANCE.adapter = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.resource.AdResource
 * JD-Core Version:    0.7.0.1
 */