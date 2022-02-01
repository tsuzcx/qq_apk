package com.tencent.mobileqq.filemanager.app;

import agjj;
import agjk;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;

public class UniformDownload$1$1
  implements Runnable
{
  public UniformDownload$1$1(agjk paramagjk, String paramString, long paramLong) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.a.a.mActivity, UniformDownloadActivity.class);
    Object localObject = this.a.aN.getString("param_content_memo");
    String str1 = this.a.aN.getString("param_icon_path");
    String str2 = this.a.aN.getString("param_mime_type");
    if (localObject != null) {
      localIntent.putExtra(UniformDownloadActivity.bGJ, (String)localObject);
    }
    if (str1 != null) {
      localIntent.putExtra(UniformDownloadActivity.bGI, str1);
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
      localIntent.putExtra(UniformDownloadActivity.bGL, str2);
      if (this.a.Yz == 1L) {
        localIntent.putExtra(UniformDownloadActivity.bGE, this.a.Yz);
      }
      localIntent.putExtra("fromArkAppDownload", this.a.aN.getBoolean("fromArkAppDownload", false));
      localIntent.putExtra(UniformDownloadActivity.bGM, this.a.aN.getString("param_refer_url", ""));
      localObject = this.a.a.mActivity.getIntent();
      if (localObject != null)
      {
        localIntent.putExtra("big_brother_source_key", ((Intent)localObject).getStringExtra("big_brother_source_key"));
        localIntent.putExtra("big_brother_ref_source_key", ((Intent)localObject).getStringExtra("big_brother_ref_source_key"));
      }
      this.a.a.mActivity.startActivity(localIntent);
      this.a.a.mActivity.overridePendingTransition(0, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.UniformDownload.1.1
 * JD-Core Version:    0.7.0.1
 */