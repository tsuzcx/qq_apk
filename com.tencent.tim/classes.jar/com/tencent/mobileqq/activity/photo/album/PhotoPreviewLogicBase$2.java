package com.tencent.mobileqq.activity.photo.album;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PhotoPreviewLogicBase$2
  implements View.OnClickListener
{
  PhotoPreviewLogicBase$2(PhotoPreviewLogicBase paramPhotoPreviewLogicBase) {}
  
  public void onClick(View paramView)
  {
    this.this$0.onBackPressed(false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicBase.2
 * JD-Core Version:    0.7.0.1
 */