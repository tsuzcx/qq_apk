package com.tencent.biz.qqstory.takevideo;

import alwd;
import android.os.SystemClock;
import android.text.TextUtils;
import aurf;
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr;
import java.io.File;

class CommonPicUploadFragment$1
  implements Runnable
{
  CommonPicUploadFragment$1(CommonPicUploadFragment paramCommonPicUploadFragment) {}
  
  public void run()
  {
    CommonPicUploadFragment.a(this.this$0).sendEmptyMessage(1001);
    if (CommonPicUploadFragment.a(this.this$0) == 2)
    {
      String str = RecentDanceConfigMgr.Aa();
      new StringBuilder().append(alwd.bYM).append(str).append(File.separator).toString();
      CommonPicUploadFragment.a(this.this$0, "");
    }
    if (!TextUtils.isEmpty(CommonPicUploadFragment.a(this.this$0)))
    {
      CommonPicUploadFragment.a(this.this$0, SystemClock.elapsedRealtime());
      this.this$0.mw(CommonPicUploadFragment.a(this.this$0));
      CommonPicUploadFragment.a(this.this$0).sendEmptyMessageDelayed(1002, 10000L);
      return;
    }
    CommonPicUploadFragment.a(this.this$0).sendEmptyMessage(1003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.CommonPicUploadFragment.1
 * JD-Core Version:    0.7.0.1
 */