package com.tencent.ad.tangram.canvas.download;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.util.Pair;
import java.util.List;

@Keep
public abstract interface IAdDownloader
{
  public abstract void doDownloadAction(Activity paramActivity, Bundle paramBundle, String paramString, int paramInt);
  
  public abstract int getCurrentPkgDownloadProgress(Context paramContext, String paramString1, String paramString2);
  
  public abstract Object getDownloadInfoByUrl(String paramString);
  
  public abstract void installDownload(Object paramObject);
  
  public abstract int isPkgDownloadPaused(Context paramContext, String paramString1, String paramString2);
  
  public abstract int isPkgDownloading(Context paramContext, String paramString1, String paramString2);
  
  public abstract boolean isPkgExist(Context paramContext, String paramString1, String paramString2);
  
  public abstract void pauseDownload(String paramString1, String paramString2);
  
  public abstract void registerListener(Callback paramCallback);
  
  public abstract void unregisterListener(Callback paramCallback);
  
  @Keep
  public static abstract interface Callback
  {
    public abstract void onDownloadProgressUpdate(List<Object> paramList, List<Pair<String, String>> paramList1);
    
    public abstract void onDownloadStatusChanged(int paramInt1, int paramInt2, Pair<String, String> paramPair, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.download.IAdDownloader
 * JD-Core Version:    0.7.0.1
 */