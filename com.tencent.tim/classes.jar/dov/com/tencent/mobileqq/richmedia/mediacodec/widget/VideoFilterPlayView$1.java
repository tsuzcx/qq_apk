package dov.com.tencent.mobileqq.richmedia.mediacodec.widget;

import com.tencent.ttpic.openapi.filter.GPUBaseFilter;

class VideoFilterPlayView$1
  implements Runnable
{
  VideoFilterPlayView$1(VideoFilterPlayView paramVideoFilterPlayView) {}
  
  public void run()
  {
    VideoFilterPlayView.a(this.this$0).init();
    VideoFilterPlayView.a(this.this$0).onOutputSizeChanged(this.this$0.mVideoWidth, this.this$0.mVideoHeight);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.widget.VideoFilterPlayView.1
 * JD-Core Version:    0.7.0.1
 */