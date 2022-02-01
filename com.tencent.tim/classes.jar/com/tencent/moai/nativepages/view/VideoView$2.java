package com.tencent.moai.nativepages.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.SeekBar;

class VideoView$2
  implements View.OnTouchListener
{
  VideoView$2(VideoView paramVideoView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      int i = (int)(VideoView.access$000(this.this$0).getProgress() / 100.0F * (float)VideoView.access$100(this.this$0));
      VideoView.access$200(this.this$0).seekTo(i);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.view.VideoView.2
 * JD-Core Version:    0.7.0.1
 */