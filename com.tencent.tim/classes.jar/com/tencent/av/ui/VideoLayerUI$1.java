package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.qphone.base.util.QLog;

class VideoLayerUI$1
  implements Runnable
{
  VideoLayerUI$1(VideoLayerUI paramVideoLayerUI) {}
  
  public void run()
  {
    if (this.this$0.b == null) {}
    int i;
    do
    {
      return;
      i = this.this$0.b.getHeight();
      j = this.this$0.b.getWidth();
    } while ((i == 0) || (j == 0));
    int j = this.this$0.mContext.getResources().getDimensionPixelSize(2131299734);
    VideoLayerUI.a(this.this$0, new Rect(0, i - j - this.this$0.axX, VideoLayerUI.a(this.this$0).widthPixels, i - j));
    QLog.w(this.this$0.TAG, 1, "initGlRootView mSlideWindowAreas init end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.1
 * JD-Core Version:    0.7.0.1
 */