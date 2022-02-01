package com.tencent.moai.nativepages.view;

import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.moai.nativepages.util.DataUtil;

class VideoView$5
  implements VideoPlayer.VideoStateCallback
{
  VideoView$5(VideoView paramVideoView) {}
  
  public void finishedVideo()
  {
    if (VideoView.access$000(this.this$0).getProgress() != 0) {
      DataUtil.collect(VideoView.access$500(this.this$0), "Event_Native_AD_Component_Stream_Video_Play_Full_Count", 1L);
    }
    VideoView.access$1200(this.this$0);
  }
  
  public void preparedVideo()
  {
    VideoView.access$1300(this.this$0).setVisibility(8);
  }
  
  public void setDuration(long paramLong)
  {
    VideoView.access$800(this.this$0).setText(VideoView.access$700(this.this$0, paramLong));
    VideoView.access$102(this.this$0, paramLong);
  }
  
  public void setPosition(long paramLong)
  {
    VideoView.access$000(this.this$0).setProgress((int)((float)paramLong / (float)VideoView.access$100(this.this$0) * 100.0F));
    VideoView.access$900(this.this$0).setText(VideoView.access$700(this.this$0, paramLong));
    VideoView.access$1002(this.this$0, paramLong);
    if (VideoView.access$1100(this.this$0) < paramLong) {
      VideoView.access$1102(this.this$0, paramLong);
    }
  }
  
  public void startPrepareAsync()
  {
    VideoView.access$1300(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.view.VideoView.5
 * JD-Core Version:    0.7.0.1
 */