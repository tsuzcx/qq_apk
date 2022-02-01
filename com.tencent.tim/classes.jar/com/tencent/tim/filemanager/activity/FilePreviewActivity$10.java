package com.tencent.tim.filemanager.activity;

import android.view.animation.AlphaAnimation;
import aueg;
import aueg.a;

class FilePreviewActivity$10
  implements Runnable
{
  FilePreviewActivity$10(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void run()
  {
    if (this.this$0.b == null) {
      this.this$0.b = new aueg(this.this$0.Sg);
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    aueg.a locala = new aueg.a();
    locala.dL = localAlphaAnimation;
    locala.bShow = false;
    locala.eType = aueg.cZi;
    locala.duration = 1500;
    this.this$0.b.a(locala);
    this.this$0.b.dkV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.FilePreviewActivity.10
 * JD-Core Version:    0.7.0.1
 */