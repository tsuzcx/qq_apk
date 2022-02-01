package com.tencent.ad.tangram.canvas.download;

import android.support.annotation.Keep;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppDownloadManager;
import java.lang.ref.WeakReference;

@Keep
public enum AdCanvasDownloadListener
{
  INSTANCE;
  
  private WeakReference<AdCanvasDownloadListenerAdapter> adapter;
  
  private AdCanvasDownloadListener() {}
  
  private static AdCanvasDownloadListenerAdapter getAdapter()
  {
    if ((INSTANCE.adapter != null) && (INSTANCE.adapter.get() != null)) {
      return (AdCanvasDownloadListenerAdapter)INSTANCE.adapter.get();
    }
    return null;
  }
  
  public static IAdDownloader.Callback getDownloadListener(AdAppDownloadManager paramAdAppDownloadManager)
  {
    if (paramAdAppDownloadManager == null) {}
    for (;;)
    {
      paramAdAppDownloadManager = null;
      label9:
      return paramAdAppDownloadManager;
      try
      {
        AdCanvasDownloadListenerAdapter localAdCanvasDownloadListenerAdapter = getAdapter();
        if (localAdCanvasDownloadListenerAdapter == null) {
          continue;
        }
        paramAdAppDownloadManager = localAdCanvasDownloadListenerAdapter.getDownloadListener(paramAdAppDownloadManager);
        break label9;
      }
      finally {}
    }
  }
  
  public static void removeDownloadListener(AdAppDownloadManager paramAdAppDownloadManager)
  {
    if (paramAdAppDownloadManager == null) {}
    AdCanvasDownloadListenerAdapter localAdCanvasDownloadListenerAdapter;
    do
    {
      return;
      localAdCanvasDownloadListenerAdapter = getAdapter();
    } while (localAdCanvasDownloadListenerAdapter == null);
    localAdCanvasDownloadListenerAdapter.removeDownloadListener(paramAdAppDownloadManager);
  }
  
  public static void setAdapter(AdCanvasDownloadListenerAdapter paramAdCanvasDownloadListenerAdapter)
  {
    INSTANCE.adapter = new WeakReference(paramAdCanvasDownloadListenerAdapter);
  }
  
  public static void setDownloadListener(AdAppDownloadManager paramAdAppDownloadManager)
  {
    if (paramAdAppDownloadManager == null) {}
    AdCanvasDownloadListenerAdapter localAdCanvasDownloadListenerAdapter;
    do
    {
      return;
      localAdCanvasDownloadListenerAdapter = getAdapter();
    } while (localAdCanvasDownloadListenerAdapter == null);
    localAdCanvasDownloadListenerAdapter.setDownloadListener(paramAdAppDownloadManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.download.AdCanvasDownloadListener
 * JD-Core Version:    0.7.0.1
 */