package com.tencent.mobileqq.troop.filemanager.upload;

import apge;

public class TroopFileUploader$1
  implements Runnable
{
  public TroopFileUploader$1(apge paramapge) {}
  
  public void run()
  {
    if ((apge.a(this.this$0) != null) && (this.this$0.a != null)) {
      this.this$0.bme();
    }
    this.this$0.b(true, apge.a(this.this$0), 9303, "readfilefail", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploader.1
 * JD-Core Version:    0.7.0.1
 */