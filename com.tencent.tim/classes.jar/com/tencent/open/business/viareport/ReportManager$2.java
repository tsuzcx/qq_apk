package com.tencent.open.business.viareport;

import arwt;
import arye;

public class ReportManager$2
  implements Runnable
{
  public ReportManager$2(arye paramarye, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.this$0.isUploading) {
      arwt.i("viareport", "isUploading ---return");
    }
    while (!this.this$0.sw(this.val$uin)) {
      return;
    }
    this.this$0.a(this.val$uin, null, true, this.dda);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.business.viareport.ReportManager.2
 * JD-Core Version:    0.7.0.1
 */