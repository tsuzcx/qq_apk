package com.tencent.tim.filemanager.fileviewer.viewer;

import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import aucv;

public class VideoFileViewer$1
  implements Runnable
{
  public VideoFileViewer$1(aucv paramaucv) {}
  
  public void run()
  {
    if (aucv.a(this.this$0).getVisibility() == 0)
    {
      Animation localAnimation = aucv.a(this.this$0).getAnimation();
      if (localAnimation != null) {
        localAnimation.cancel();
      }
      aucv.a(this.this$0).clearAnimation();
    }
    aucv.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.fileviewer.viewer.VideoFileViewer.1
 * JD-Core Version:    0.7.0.1
 */