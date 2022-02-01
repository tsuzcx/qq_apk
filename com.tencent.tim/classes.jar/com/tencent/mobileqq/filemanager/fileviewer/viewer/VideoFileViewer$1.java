package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import agyc;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class VideoFileViewer$1
  implements Runnable
{
  public VideoFileViewer$1(agyc paramagyc) {}
  
  public void run()
  {
    if (agyc.a(this.this$0).getVisibility() == 0)
    {
      Animation localAnimation = agyc.a(this.this$0).getAnimation();
      if (localAnimation != null) {
        localAnimation.cancel();
      }
      agyc.a(this.this$0).clearAnimation();
    }
    agyc.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer.1
 * JD-Core Version:    0.7.0.1
 */