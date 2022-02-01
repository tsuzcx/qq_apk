package com.tencent.mobileqq.filemanager.core;

import agke;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class FileIPv6StrateyController$3
  implements Runnable
{
  public void run()
  {
    if (!agke.a(this.this$0)) {
      return;
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.this$0);
    agke.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.3
 * JD-Core Version:    0.7.0.1
 */