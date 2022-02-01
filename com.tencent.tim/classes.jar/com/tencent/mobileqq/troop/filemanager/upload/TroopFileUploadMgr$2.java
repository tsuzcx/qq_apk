package com.tencent.mobileqq.troop.filemanager.upload;

import apfx;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class TroopFileUploadMgr$2
  implements Runnable
{
  public TroopFileUploadMgr$2(apfx paramapfx) {}
  
  public void run()
  {
    if (!this.this$0.cQf) {
      return;
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.this$0);
    this.this$0.cQf = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.2
 * JD-Core Version:    0.7.0.1
 */