package com.tencent.tim.filemanager.activity;

import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import aueg;
import aueg.a;

class FilePreviewActivity$12
  implements Runnable
{
  FilePreviewActivity$12(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void run()
  {
    if (!this.this$0.ccP) {
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0 - this.this$0.mTitleBar.getHeight(), 0.0F);
    if (this.this$0.a == null) {
      this.this$0.a = new aueg(this.this$0.mTitleBar);
    }
    aueg.a locala = new aueg.a();
    locala.dL = localTranslateAnimation;
    locala.bShow = true;
    locala.eType = aueg.cZj;
    locala.duration = 250;
    this.this$0.a.a(locala);
    this.this$0.a.dkV();
    this.this$0.ccP = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.FilePreviewActivity.12
 * JD-Core Version:    0.7.0.1
 */