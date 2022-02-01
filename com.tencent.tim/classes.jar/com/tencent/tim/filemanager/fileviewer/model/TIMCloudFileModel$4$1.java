package com.tencent.tim.filemanager.fileviewer.model;

import atzy.c;
import auaj;
import auan;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class TIMCloudFileModel$4$1
  implements Runnable
{
  public TIMCloudFileModel$4$1(auan paramauan, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    if (this.a.this$0.a != null) {
      this.a.this$0.a.fP(new String(this.t.cloudId) + new String(this.t.pDirKey), this.t.strLargeThumPath);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.fileviewer.model.TIMCloudFileModel.4.1
 * JD-Core Version:    0.7.0.1
 */