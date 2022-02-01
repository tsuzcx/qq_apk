package com.tencent.mobileqq.mini.widget.media;

import android.media.AudioManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

class MiniAppVideoPlayer$3
  implements VideoGestureRelativeLayout.VideoGestureListener
{
  MiniAppVideoPlayer$3(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void onBrightnessGesture(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    paramFloat1 = 0.0F;
    if (!this.this$0.pageGesture) {}
    while (this.this$0.isFullScreen) {
      return;
    }
    paramFloat2 = (paramMotionEvent1.getY() - paramMotionEvent2.getY()) / MiniAppVideoPlayer.access$300(this.this$0).getHeight() + MiniAppVideoPlayer.access$400(this.this$0);
    if (paramFloat2 < 0.0F) {}
    for (;;)
    {
      if ((MiniAppVideoPlayer.access$500(this.this$0) != null) && (MiniAppVideoPlayer.access$600(this.this$0) != null))
      {
        MiniAppVideoPlayer.access$600(this.this$0).screenBrightness = paramFloat1;
        MiniAppVideoPlayer.access$500(this.this$0).setAttributes(MiniAppVideoPlayer.access$600(this.this$0));
      }
      MiniAppVideoPlayer.access$700(this.this$0).setProgress((int)(paramFloat1 * 100.0F));
      MiniAppVideoPlayer.access$700(this.this$0).setImageResource(2130841828);
      MiniAppVideoPlayer.access$700(this.this$0).show();
      return;
      if (paramFloat2 > 1.0F) {
        paramFloat1 = 1.0F;
      } else {
        paramFloat1 = paramFloat2;
      }
    }
  }
  
  public void onDoubleTapGesture(MotionEvent paramMotionEvent) {}
  
  public void onDown(MotionEvent paramMotionEvent)
  {
    MiniAppVideoPlayer.access$1402(this.this$0, MiniAppVideoPlayer.access$1500(this.this$0));
    if (MiniAppVideoPlayer.access$1000(this.this$0) != null) {
      MiniAppVideoPlayer.access$902(this.this$0, MiniAppVideoPlayer.access$1000(this.this$0).getStreamVolume(3));
    }
    if (MiniAppVideoPlayer.access$600(this.this$0) != null) {
      MiniAppVideoPlayer.access$402(this.this$0, MiniAppVideoPlayer.access$600(this.this$0).screenBrightness);
    }
    if (MiniAppVideoPlayer.access$400(this.this$0) == -1.0F) {
      MiniAppVideoPlayer.access$402(this.this$0, MiniAppVideoPlayer.access$1600(this.this$0) / 255.0F);
    }
  }
  
  public void onEndFF_REW(MotionEvent paramMotionEvent) {}
  
  public void onProgressGesture(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {}
  
  public void onSingleTapGesture(MotionEvent paramMotionEvent)
  {
    if (MiniAppVideoPlayer.access$1100(this.this$0).getVisibility() != 8)
    {
      if (MiniAppVideoPlayer.access$1100(this.this$0).getVisibility() == 4) {
        MiniAppVideoPlayer.access$1200(this.this$0);
      }
    }
    else {
      return;
    }
    MiniAppVideoPlayer.access$1300(this.this$0);
  }
  
  public void onVolumeGesture(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!this.this$0.pageGesture) {}
    while ((this.this$0.isFullScreen) || (MiniAppVideoPlayer.access$800(this.this$0) == 0)) {
      return;
    }
    int i = MiniAppVideoPlayer.access$300(this.this$0).getHeight() / MiniAppVideoPlayer.access$800(this.this$0);
    i = (int)((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / i + MiniAppVideoPlayer.access$900(this.this$0));
    if (MiniAppVideoPlayer.access$1000(this.this$0) != null) {
      MiniAppVideoPlayer.access$1000(this.this$0).setStreamVolume(3, i, 4);
    }
    i = (int)(i / Float.valueOf(MiniAppVideoPlayer.access$800(this.this$0)).floatValue() * 100.0F);
    if (i >= 50) {
      MiniAppVideoPlayer.access$700(this.this$0).setImageResource(2130841832);
    }
    for (;;)
    {
      MiniAppVideoPlayer.access$700(this.this$0).setProgress(i);
      MiniAppVideoPlayer.access$700(this.this$0).show();
      return;
      if (i > 0) {
        MiniAppVideoPlayer.access$700(this.this$0).setImageResource(2130841833);
      } else {
        MiniAppVideoPlayer.access$700(this.this$0).setImageResource(2130841834);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppVideoPlayer.3
 * JD-Core Version:    0.7.0.1
 */