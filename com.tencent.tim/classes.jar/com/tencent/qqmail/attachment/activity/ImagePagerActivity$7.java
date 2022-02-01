package com.tencent.qqmail.attachment.activity;

import com.tencent.qqmail.attachment.view.CustomViewPager;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.ui.QMTips.QMTipsCallback;

class ImagePagerActivity$7
  extends QMTips.QMTipsCallback
{
  ImagePagerActivity$7(ImagePagerActivity paramImagePagerActivity) {}
  
  public void onCancel(QMTips paramQMTips)
  {
    super.onCancel(paramQMTips);
  }
  
  public void onHide(QMTips paramQMTips)
  {
    super.onHide(paramQMTips);
    ImagePagerActivity.access$1200(this.this$0, false);
    ImagePagerActivity.access$1300(this.this$0).setPagingEnable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerActivity.7
 * JD-Core Version:    0.7.0.1
 */