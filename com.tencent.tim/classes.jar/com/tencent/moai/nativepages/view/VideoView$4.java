package com.tencent.moai.nativepages.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.moai.nativepages.util.DataUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoView$4
  implements View.OnClickListener
{
  VideoView$4(VideoView paramVideoView) {}
  
  public void onClick(View paramView)
  {
    VideoView localVideoView = this.this$0;
    if (!VideoView.access$600(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      localVideoView.soundOn(bool);
      DataUtil.collect(VideoView.access$500(this.this$0), "Event_Native_AD_Component_Stream_Video_Sound_Click", 1L);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.view.VideoView.4
 * JD-Core Version:    0.7.0.1
 */