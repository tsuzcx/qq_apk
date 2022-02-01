package com.tencent.tim.filemanager.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import atsw;
import atsx;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;

public class UniformDownload$1$1
  implements Runnable
{
  public UniformDownload$1$1(atsx paramatsx, String paramString, long paramLong) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.a.a.mActivity, UniformDownloadActivity.class);
    String str1 = this.a.aN.getString("param_content_memo");
    String str2 = this.a.aN.getString("param_icon_path");
    String str3 = this.a.aN.getString("param_mime_type");
    if (str1 != null) {
      localIntent.putExtra(UniformDownloadActivity.bGJ, str1);
    }
    if (str2 != null) {
      localIntent.putExtra(UniformDownloadActivity.bGI, str2);
    }
    boolean bool = this.a.aN.getBoolean("param_isqbdownload", false);
    localIntent.putExtra(UniformDownloadActivity.bGK, bool);
    localIntent.putExtra(UniformDownloadActivity.bGD, this.a.val$url);
    localIntent.putExtra(UniformDownloadActivity.bGF, this.val$fileName);
    localIntent.setFlags(536870912);
    if (this.a.Yy != 0L) {}
    for (long l = this.a.Yy;; l = this.YA)
    {
      localIntent.putExtra(UniformDownloadActivity.bGG, l);
      localIntent.putExtra(UniformDownloadActivity.bGL, str3);
      if (this.a.Yz == 1L) {
        localIntent.putExtra(UniformDownloadActivity.bGE, this.a.Yz);
      }
      this.a.a.mActivity.startActivity(localIntent);
      this.a.a.mActivity.overridePendingTransition(0, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.app.UniformDownload.1.1
 * JD-Core Version:    0.7.0.1
 */