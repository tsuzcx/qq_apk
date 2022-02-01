package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import agxa;
import agyc;
import android.os.Handler;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

public class VideoFilePresenter$10
  implements Runnable
{
  public VideoFilePresenter$10(agxa paramagxa) {}
  
  public void run()
  {
    if (agxa.a(this.this$0) == null) {}
    do
    {
      return;
      this.this$0.a.JU(agxa.a(this.this$0).isPlaying());
    } while ((agxa.a(this.this$0)) || (!agxa.a(this.this$0).isPlaying()));
    int i = (int)agxa.a(this.this$0).getCurPlayingPos();
    int j = (int)agxa.a(this.this$0).getVideoDurationMs();
    this.this$0.a.setCurrentTime(i);
    if ((!agxa.b(this.this$0)) && (i > agxa.a(this.this$0))) {
      agxa.a(this.this$0, i);
    }
    float f = i / j;
    if (f <= 0.001D)
    {
      agxa.a(this.this$0).postDelayed(this.this$0.eu, 100L);
      return;
    }
    if (i >= agxa.a(this.this$0)) {
      this.this$0.a.OL((int)(f * 10000.0F));
    }
    agxa.a(this.this$0).postDelayed(this.this$0.eu, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.10
 * JD-Core Version:    0.7.0.1
 */