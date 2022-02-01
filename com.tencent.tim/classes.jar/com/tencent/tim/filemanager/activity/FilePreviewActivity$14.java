package com.tencent.tim.filemanager.activity;

import android.view.animation.AlphaAnimation;
import aueg;
import aueg.a;
import com.tencent.qphone.base.util.QLog;

class FilePreviewActivity$14
  implements Runnable
{
  FilePreviewActivity$14(FilePreviewActivity paramFilePreviewActivity, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.c == null) {
      this.this$0.c = new aueg(this.this$0.iR);
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    aueg.a locala = new aueg.a();
    locala.dL = localAlphaAnimation;
    locala.bShow = false;
    locala.eType = aueg.cZi;
    locala.duration = this.val$duration;
    this.this$0.c.a(locala);
    this.this$0.c.dkV();
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FilePreviewActivity", 2, "hideGetMore(" + this.val$duration + ")");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.FilePreviewActivity.14
 * JD-Core Version:    0.7.0.1
 */