package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Intent;
import android.content.pm.PackageManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import kfq;
import mxw;
import mxw.a;

public class VideoFeedsUGDownloadListener$2
  implements Runnable
{
  public VideoFeedsUGDownloadListener$2(mxw parammxw, String paramString) {}
  
  public void run()
  {
    mxw.a locala = (mxw.a)mxw.a(this.this$0).get(this.val$packageName);
    if (locala != null)
    {
      kfq.ma(kfq.p(locala.akD, "19", locala.akE));
      Intent localIntent = BaseApplicationImpl.getContext().getPackageManager().getLaunchIntentForPackage(this.val$packageName);
      if (localIntent != null)
      {
        localIntent.setFlags(268435456);
        localIntent.putExtra("big_brother_source_key", "biz_src_kandian_videos");
        BaseApplicationImpl.getContext().startActivity(localIntent);
        kfq.ma(kfq.p(locala.akD, "106", locala.akE));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGDownloadListener.2
 * JD-Core Version:    0.7.0.1
 */