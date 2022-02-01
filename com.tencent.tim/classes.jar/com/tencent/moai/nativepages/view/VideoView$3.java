package com.tencent.moai.nativepages.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.moai.nativepages.util.DataUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoView$3
  implements View.OnClickListener
{
  VideoView$3(VideoView paramVideoView) {}
  
  public void onClick(View paramView)
  {
    if (VideoView.access$300(this.this$0))
    {
      this.this$0.pause();
      VideoView.access$402(this.this$0, true);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.resume();
      VideoView.access$402(this.this$0, false);
      DataUtil.collect(VideoView.access$500(this.this$0), "Event_Native_AD_Component_Stream_Video_Play_Count", 1L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.view.VideoView.3
 * JD-Core Version:    0.7.0.1
 */