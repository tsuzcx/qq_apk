package com.tencent.mobileqq.filemanager.activity;

import ahbi;
import ahbi.a;
import android.view.animation.AlphaAnimation;
import com.tencent.qphone.base.util.QLog;

class FilePreviewActivity$15
  implements Runnable
{
  FilePreviewActivity$15(FilePreviewActivity paramFilePreviewActivity, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.c == null) {
      this.this$0.c = new ahbi(this.this$0.iR);
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    ahbi.a locala = new ahbi.a();
    locala.dL = localAlphaAnimation;
    locala.bShow = false;
    locala.eType = ahbi.cZi;
    locala.duration = this.val$duration;
    this.this$0.c.a(locala);
    this.this$0.c.dkV();
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FilePreviewActivity", 2, "hideGetMore(" + this.val$duration + ")");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.15
 * JD-Core Version:    0.7.0.1
 */