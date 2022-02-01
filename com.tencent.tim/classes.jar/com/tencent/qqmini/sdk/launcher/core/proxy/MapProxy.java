package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;

public abstract class MapProxy
{
  public void captureImage(IMiniAppContext paramIMiniAppContext, View paramView, ViewGroup paramViewGroup, MapSnapshotCallback paramMapSnapshotCallback) {}
  
  public static abstract interface MapSnapshotCallback
  {
    public abstract void onSnapshotReady(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.MapProxy
 * JD-Core Version:    0.7.0.1
 */