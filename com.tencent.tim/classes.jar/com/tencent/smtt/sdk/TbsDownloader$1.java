package com.tencent.smtt.sdk;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.smtt.utils.TbsLog;

final class TbsDownloader$1
  implements c.a
{
  TbsDownloader$1(TbsDownloadConfig paramTbsDownloadConfig) {}
  
  public void a(String paramString)
  {
    TbsLog.i("TbsDownload", "Execute command [1000](" + paramString + "), force tbs downloader request");
    paramString = this.a.mPreferences.edit();
    paramString.putLong("last_check", 0L);
    paramString.apply();
    paramString.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsDownloader.1
 * JD-Core Version:    0.7.0.1
 */