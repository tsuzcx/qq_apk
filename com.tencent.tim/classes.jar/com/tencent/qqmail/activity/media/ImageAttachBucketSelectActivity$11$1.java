package com.tencent.qqmail.activity.media;

import android.view.View;
import com.tencent.qqmail.utilities.OneStepUtils;

class ImageAttachBucketSelectActivity$11$1
  implements ImageAttachBucketSelectActivity.onCurrentInfoListener
{
  ImageAttachBucketSelectActivity$11$1(ImageAttachBucketSelectActivity.11 param11, View paramView) {}
  
  public void onCurrentInfo(MediaItemInfo paramMediaItemInfo)
  {
    if (paramMediaItemInfo != null) {
      OneStepUtils.dragImageByOneStep(this.val$view, paramMediaItemInfo.getSourcePath());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImageAttachBucketSelectActivity.11.1
 * JD-Core Version:    0.7.0.1
 */