package com.tencent.biz.pubaccount.readinjoy.video;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import aqbn;
import aqcx;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import mvr;

public class VideoFeedsPlayActivity$3
  implements Runnable
{
  VideoFeedsPlayActivity$3(VideoFeedsPlayActivity paramVideoFeedsPlayActivity, VideoInfo paramVideoInfo) {}
  
  public void run()
  {
    if ((!this.a.yV()) || (TextUtils.isEmpty(this.a.a.appIconUrl)) || (TextUtils.isEmpty(this.a.a.appName)))
    {
      VideoFeedsPlayActivity.a(this.this$0).setVisibility(8);
      return;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    try
    {
      localObject = URLDrawable.getDrawable(new URL(this.a.a.appIconUrl), (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(aqbn.d(0, 0, aqcx.dip2px(this.this$0, 3.0F)));
      ((URLDrawable)localObject).setDecodeHandler(aqbn.a);
      VideoFeedsPlayActivity.a(this.this$0).setImageDrawable((Drawable)localObject);
      VideoFeedsPlayActivity.a(this.this$0).setText(this.a.a.appName);
      VideoFeedsPlayActivity.a(this.this$0).setOnClickListener(new mvr(this));
      VideoFeedsPlayActivity.a(this.this$0).setVisibility(0);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "innerConfigHeaderAppJump() ERROR e = " + localException.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity.3
 * JD-Core Version:    0.7.0.1
 */