package com.tencent.mobileqq.filemanager.activity;

import ahbi;
import ahbi.a;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;

class FilePreviewActivity$12
  implements Runnable
{
  FilePreviewActivity$12(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void run()
  {
    if (this.this$0.ccP) {
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0 - this.this$0.mTitleBar.getHeight());
    if (this.this$0.a == null) {
      this.this$0.a = new ahbi(this.this$0.mTitleBar);
    }
    ahbi.a locala = new ahbi.a();
    locala.dL = localTranslateAnimation;
    locala.bShow = false;
    locala.eType = ahbi.cZj;
    locala.duration = 250;
    this.this$0.a.a(locala);
    this.this$0.a.dkV();
    this.this$0.ccP = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.12
 * JD-Core Version:    0.7.0.1
 */