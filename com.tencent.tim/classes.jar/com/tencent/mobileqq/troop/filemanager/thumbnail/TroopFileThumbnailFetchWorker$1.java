package com.tencent.mobileqq.troop.filemanager.thumbnail;

import android.text.TextUtils;
import apef.b;
import apfn;
import apue.a;
import aqhq;
import aqiw;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopFileThumbnailFetchWorker$1
  implements Runnable
{
  public TroopFileThumbnailFetchWorker$1(apfn paramapfn) {}
  
  public void run()
  {
    if (this.this$0.bkn)
    {
      apef.b.w("TroopFileDownloadWorker", apef.b.USR, "[" + this.this$0.coy + "] start. had stoped");
      return;
    }
    this.this$0.dZh();
    this.this$0.mFilePath = this.this$0.c.getThumbnailFile(this.this$0.mTroopUin, this.this$0.bYf);
    this.this$0.mTmpFilePath = (this.this$0.mFilePath + ".ttmp");
    if (aqhq.fileExistsAndNotEmpty(this.this$0.mFilePath))
    {
      apef.b.w("TroopFileDownloadWorker", apef.b.USR, "[" + this.this$0.coy + "] thumb had exsited");
      this.this$0.RC(true);
      return;
    }
    if (!aqiw.isNetworkAvailable(BaseApplication.getContext()))
    {
      apef.b.e("TroopFileDownloadWorker", apef.b.USR, "[" + this.this$0.coy + "] no network");
      this.this$0.WG(apue.a.dWh);
      return;
    }
    if (TextUtils.isEmpty(this.this$0.c.FilePath))
    {
      apef.b.e("TroopFileDownloadWorker", apef.b.USR, "[" + this.this$0.coy + "] filepath is null");
      this.this$0.WG(apue.a.dWt);
      return;
    }
    this.this$0.dYW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailFetchWorker.1
 * JD-Core Version:    0.7.0.1
 */