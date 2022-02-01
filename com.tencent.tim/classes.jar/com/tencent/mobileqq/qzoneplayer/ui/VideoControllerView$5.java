package com.tencent.mobileqq.qzoneplayer.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoControllerView$5
  implements View.OnClickListener
{
  VideoControllerView$5(VideoControllerView paramVideoControllerView) {}
  
  public void onClick(View paramView)
  {
    this.this$0.doToggleLandscape();
    this.this$0.show(VideoControllerView.sDefaultTimeout);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView.5
 * JD-Core Version:    0.7.0.1
 */