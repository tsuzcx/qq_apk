package com.tencent.mobileqq.richmedia.mediacodec.widget;

import com.tencent.ttpic.openapi.filter.GPUBaseFilter;

class VideoFilterPlayView$2
  implements Runnable
{
  VideoFilterPlayView$2(VideoFilterPlayView paramVideoFilterPlayView) {}
  
  public void run()
  {
    VideoFilterPlayView.b(this.this$0).init();
    VideoFilterPlayView.b(this.this$0).onOutputSizeChanged(this.this$0.surfaceWidth, this.this$0.surfaceHeight);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.widget.VideoFilterPlayView.2
 * JD-Core Version:    0.7.0.1
 */