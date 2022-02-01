package com.tencent.qqmail.activity.media;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.animation.SlideViewAnimation;
import com.tencent.qqmail.view.QMTopBar;
import java.util.List;

class ImageAttachBucketSelectActivity$8
  implements View.OnClickListener
{
  ImageAttachBucketSelectActivity$8(ImageAttachBucketSelectActivity paramImageAttachBucketSelectActivity) {}
  
  public void onClick(View paramView)
  {
    if (!ImageAttachBucketSelectActivity.access$1100(this.this$0).isAnimFinish()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ImageAttachBucketSelectActivity.access$1200(this.this$0).getButtonRight().setEnabled(true);
      if (ImageAttachBucketSelectActivity.access$1300(this.this$0))
      {
        ImageAttachBucketSelectActivity.access$1100(this.this$0).slideBottom2Top(this.this$0, ImageAttachBucketSelectActivity.access$1400(this.this$0));
        paramView.setContentDescription(this.this$0.getString(2131720857));
      }
      else
      {
        if ((ImageAttachBucketSelectActivity.access$100(this.this$0) != null) && (ImageAttachBucketSelectActivity.access$1500(this.this$0) != null))
        {
          MediaItemInfo localMediaItemInfo = (MediaItemInfo)ImageAttachBucketSelectActivity.access$100(this.this$0).get(ImageAttachBucketSelectActivity.access$1500(this.this$0).getCurrentItem());
          if (localMediaItemInfo != null) {
            ImageAttachBucketSelectActivity.access$1600(this.this$0, localMediaItemInfo.getAttach());
          }
        }
        ImageAttachBucketSelectActivity.access$1100(this.this$0).slideTop2Bottom(this.this$0, ImageAttachBucketSelectActivity.access$1400(this.this$0));
        paramView.setContentDescription(this.this$0.getString(2131720832));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImageAttachBucketSelectActivity.8
 * JD-Core Version:    0.7.0.1
 */