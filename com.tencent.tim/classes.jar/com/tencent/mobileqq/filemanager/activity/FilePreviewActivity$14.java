package com.tencent.mobileqq.filemanager.activity;

import ahbi;
import ahbi.a;
import android.view.animation.AlphaAnimation;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class FilePreviewActivity$14
  implements Runnable
{
  FilePreviewActivity$14(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void run()
  {
    if (this.this$0.c == null) {
      this.this$0.c = new ahbi(this.this$0.iR);
    }
    this.this$0.mProgressBar.setVisibility(0);
    this.this$0.Si.setText(2131696546);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.5F, 1.0F);
    localAlphaAnimation.setFillAfter(true);
    ahbi.a locala = new ahbi.a();
    locala.dL = localAlphaAnimation;
    locala.bShow = true;
    locala.eType = ahbi.cZi;
    locala.duration = 1000;
    this.this$0.c.a(locala);
    this.this$0.c.dkV();
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FilePreviewActivity", 2, "showGetmore(1000)");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.14
 * JD-Core Version:    0.7.0.1
 */