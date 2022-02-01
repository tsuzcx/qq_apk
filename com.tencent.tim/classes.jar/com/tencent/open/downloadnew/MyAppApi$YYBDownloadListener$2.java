package com.tencent.open.downloadnew;

import android.text.TextUtils;
import arwt;
import arxn;
import aryq;
import arzk.f;

public class MyAppApi$YYBDownloadListener$2
  implements Runnable
{
  public MyAppApi$YYBDownloadListener$2(arzk.f paramf, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    arwt.d("MyAppApi", "rooted and start silent install...");
    long l = System.currentTimeMillis();
    if (aryq.db(l))
    {
      if ((arxn.aHi()) && (this.a != null) && (!TextUtils.isEmpty(this.a.filePath))) {
        arxn.sr(this.a.filePath);
      }
    }
    else {
      return;
    }
    arwt.d("MyAppApi", "root confused and remember user operation time!");
    aryq.ms(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.2
 * JD-Core Version:    0.7.0.1
 */