package com.tencent.mobileqq.filemanager.bubble;

import agjn;
import agkf;
import ahav;
import ahbj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class OfflineFileBubbleModel$3
  implements Runnable
{
  public OfflineFileBubbleModel$3(agjn paramagjn, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    ahav.J(this.g);
    if (ahbj.fileExistsAndNotEmpty(this.g.strLargeThumPath)) {
      this.this$0.mApp.a().u(this.g);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.OfflineFileBubbleModel.3
 * JD-Core Version:    0.7.0.1
 */