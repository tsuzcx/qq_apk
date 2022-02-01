package com.tencent.open.downloadnew;

import android.os.Handler;
import android.os.Looper;
import aryy;
import arzk;
import arzk.f;
import arzs;

public class MyAppApi$YYBDownloadListener$1
  implements Runnable
{
  public MyAppApi$YYBDownloadListener$1(arzk.f paramf, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    if ((this.b.this$0.a != null) && (this.b.this$0.a.isShowing())) {
      this.b.this$0.a.dismiss();
    }
    aryy.a().y(this.a);
    new Handler(Looper.getMainLooper()).postAtTime(new MyAppApi.YYBDownloadListener.1.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */