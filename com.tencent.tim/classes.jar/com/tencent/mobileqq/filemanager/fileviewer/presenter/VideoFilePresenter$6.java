package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import agxa;
import agyc;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

public class VideoFilePresenter$6
  implements Runnable
{
  public VideoFilePresenter$6(agxa paramagxa) {}
  
  public void run()
  {
    if (agxa.a(this.this$0) != null) {
      this.this$0.a.JU(agxa.a(this.this$0).isPlaying());
    }
    for (;;)
    {
      agxa.d(this.this$0);
      return;
      this.this$0.a.JU(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter.6
 * JD-Core Version:    0.7.0.1
 */