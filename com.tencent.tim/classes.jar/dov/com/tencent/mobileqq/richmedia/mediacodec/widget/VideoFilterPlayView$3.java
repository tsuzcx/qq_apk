package dov.com.tencent.mobileqq.richmedia.mediacodec.widget;

import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQTransferFilter;
import java.util.List;

class VideoFilterPlayView$3
  implements Runnable
{
  VideoFilterPlayView$3(VideoFilterPlayView paramVideoFilterPlayView, int paramInt) {}
  
  public void run()
  {
    if (VideoFilterPlayView.a(this.this$0) != null)
    {
      List localList = VideoFilterPlayView.a(this.this$0).getQQFilters(160);
      if ((localList != null) && (localList.size() > 0) && ((localList.get(0) instanceof QQTransferFilter))) {
        ((QQTransferFilter)localList.get(0)).setSpeedRate(HWVideoDecoder.getSpeedRate(this.bRh));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.widget.VideoFilterPlayView.3
 * JD-Core Version:    0.7.0.1
 */