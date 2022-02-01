package com.tencent.mobileqq.minigame.gpkg;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.mini.launch.CmdCallback;

final class GpkgManager$9
  implements Downloader.DownloadListener
{
  GpkgManager$9(CmdCallback paramCmdCallback) {}
  
  public void onDownloadCanceled(String paramString)
  {
    Bundle localBundle;
    if (this.val$cmdCallback != null)
    {
      localBundle = new Bundle();
      localBundle.putInt("key_download_retcode", 0);
      localBundle.putString("key_download_retstring", paramString);
    }
    try
    {
      this.val$cmdCallback.onCmdResult(false, localBundle);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    Bundle localBundle;
    if (this.val$cmdCallback != null)
    {
      localBundle = new Bundle();
      localBundle.putInt("key_download_retcode", -1);
      localBundle.putString("key_download_retstring", paramString);
      localBundle.putParcelable("key_download_result_object", paramDownloadResult);
    }
    try
    {
      this.val$cmdCallback.onCmdResult(false, localBundle);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    Bundle localBundle;
    if (this.val$cmdCallback != null)
    {
      localBundle = new Bundle();
      localBundle.putInt("key_download_retcode", 2);
      localBundle.putFloat("key_download_process_percent", paramFloat);
      localBundle.putLong("key_download_progress_size", paramLong);
      localBundle.putString("key_download_retstring", paramString);
    }
    try
    {
      this.val$cmdCallback.onCmdResult(false, localBundle);
      return;
    }
    catch (RemoteException paramString) {}
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    Bundle localBundle;
    if (this.val$cmdCallback != null)
    {
      localBundle = new Bundle();
      localBundle.putInt("key_download_retcode", 1);
      localBundle.putString("key_download_retstring", paramString);
      localBundle.putParcelable("key_download_result_object", paramDownloadResult);
    }
    try
    {
      this.val$cmdCallback.onCmdResult(true, localBundle);
      return;
    }
    catch (RemoteException paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.gpkg.GpkgManager.9
 * JD-Core Version:    0.7.0.1
 */