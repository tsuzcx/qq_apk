package com.tencent.mobileqq.apollo.process.download;

import abmt;
import abpi;
import abpl;
import com.tencent.qphone.base.util.QLog;

public class CmGameRscDownloader$1
  implements Runnable
{
  public CmGameRscDownloader$1(abpi paramabpi) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameRscDownloader", 2, "download now");
    }
    abmt.x(new Object[] { "[downloadRes], for delay:", Integer.valueOf(abpi.a(this.this$0).delayMs), ",and download now" });
    this.this$0.cDY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.download.CmGameRscDownloader.1
 * JD-Core Version:    0.7.0.1
 */