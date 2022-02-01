package com.tencent.mobileqq.filemanager.activity;

import ahbi;
import ahbi.a;
import android.view.animation.AlphaAnimation;

class FilePreviewActivity$11
  implements Runnable
{
  FilePreviewActivity$11(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void run()
  {
    if (this.this$0.b == null) {
      this.this$0.b = new ahbi(this.this$0.Sg);
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    ahbi.a locala = new ahbi.a();
    locala.dL = localAlphaAnimation;
    locala.bShow = false;
    locala.eType = ahbi.cZi;
    locala.duration = 1500;
    this.this$0.b.a(locala);
    this.this$0.b.dkV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.11
 * JD-Core Version:    0.7.0.1
 */