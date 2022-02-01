package com.tencent.tim.filemanager.fileviewer.model;

import agsd;
import aths;
import auaj;
import java.util.List;

public class TIMCloudFileModel$7
  implements Runnable
{
  public TIMCloudFileModel$7(auaj paramauaj, int paramInt) {}
  
  public void run()
  {
    agsd localagsd;
    if (this.val$pos > 0)
    {
      localagsd = (agsd)this.this$0.BG.get(this.val$pos - 1);
      if (localagsd != null) {
        aths.a().c(localagsd.b(), 640);
      }
    }
    int i = this.this$0.BG.size();
    if (this.val$pos < i - 1)
    {
      localagsd = (agsd)this.this$0.BG.get(this.val$pos + 1);
      if (localagsd != null) {
        aths.a().c(localagsd.b(), 640);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.fileviewer.model.TIMCloudFileModel.7
 * JD-Core Version:    0.7.0.1
 */