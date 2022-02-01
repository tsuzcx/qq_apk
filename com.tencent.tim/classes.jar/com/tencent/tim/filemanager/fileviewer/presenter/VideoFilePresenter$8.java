package com.tencent.tim.filemanager.fileviewer.presenter;

import android.os.Handler;
import aucd;
import aucv;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

public class VideoFilePresenter$8
  implements Runnable
{
  public VideoFilePresenter$8(aucd paramaucd) {}
  
  public void run()
  {
    if (aucd.a(this.this$0) == null) {}
    do
    {
      return;
      this.this$0.a.JU(aucd.a(this.this$0).isPlaying());
    } while ((aucd.a(this.this$0)) || (!aucd.a(this.this$0).isPlaying()));
    int i = (int)aucd.a(this.this$0).getCurPlayingPos();
    int j = (int)aucd.a(this.this$0).getVideoDurationMs();
    this.this$0.a.setCurrentTime(i);
    if ((!aucd.b(this.this$0)) && (i > aucd.a(this.this$0))) {
      aucd.a(this.this$0, i);
    }
    float f = i / j;
    if (f <= 0.001D)
    {
      aucd.a(this.this$0).postDelayed(this.this$0.eu, 100L);
      return;
    }
    if (i >= aucd.a(this.this$0)) {
      this.this$0.a.OL((int)(f * 10000.0F));
    }
    aucd.a(this.this$0).postDelayed(this.this$0.eu, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.fileviewer.presenter.VideoFilePresenter.8
 * JD-Core Version:    0.7.0.1
 */