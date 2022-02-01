package com.tencent.qqmail.attachment.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ImagePagerFragment$3
  implements View.OnClickListener
{
  ImagePagerFragment$3(ImagePagerFragment paramImagePagerFragment) {}
  
  public void onClick(View paramView)
  {
    ImagePagerActivity localImagePagerActivity = (ImagePagerActivity)this.this$0.getActivity();
    if ((localImagePagerActivity != null) && (!localImagePagerActivity.isShowInfo()) && (!localImagePagerActivity.isBottomBarActionProcess()))
    {
      localImagePagerActivity.updateAttachInfo(ImagePagerFragment.access$000(this.this$0));
      localImagePagerActivity.setVisibilityOfBar(null, localImagePagerActivity);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerFragment.3
 * JD-Core Version:    0.7.0.1
 */