package com.tencent.tim.filemanager.fileviewer.presenter;

import aucd;
import aucv;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

public class VideoFilePresenter$4
  implements Runnable
{
  public VideoFilePresenter$4(aucd paramaucd) {}
  
  public void run()
  {
    if (aucd.a(this.this$0) != null) {
      this.this$0.a.JU(aucd.a(this.this$0).isPlaying());
    }
    for (;;)
    {
      aucd.d(this.this$0);
      return;
      this.this$0.a.JU(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.fileviewer.presenter.VideoFilePresenter.4
 * JD-Core Version:    0.7.0.1
 */