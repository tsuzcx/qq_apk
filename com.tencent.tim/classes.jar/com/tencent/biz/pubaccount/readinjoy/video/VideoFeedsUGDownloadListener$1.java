package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.HashMap;
import kfq;
import mxw;
import mxw.a;

public class VideoFeedsUGDownloadListener$1
  implements Runnable
{
  public VideoFeedsUGDownloadListener$1(mxw parammxw, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    mxw.a locala = (mxw.a)mxw.a(this.this$0).get(this.a.packageName);
    if ((locala != null) && (!TextUtils.isEmpty(locala.akF)) && (locala.akF.equals(this.a.urlStr)))
    {
      kfq.ma(kfq.p(locala.akD, "11", locala.akE));
      kfq.ma(kfq.p(locala.akD, "20", locala.akE));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */