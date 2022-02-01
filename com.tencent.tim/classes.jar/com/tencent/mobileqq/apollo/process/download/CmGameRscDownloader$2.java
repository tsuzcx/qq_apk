package com.tencent.mobileqq.apollo.process.download;

import abpi;
import abpl;
import abxi;
import aqhq;

public class CmGameRscDownloader$2
  implements Runnable
{
  public CmGameRscDownloader$2(abpi paramabpi) {}
  
  public void run()
  {
    String str = abxi.biF + abpi.a(this.this$0).itemId + ".patch";
    aqhq.writeFile(abpi.a(this.this$0).cM, str);
    abpi.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.download.CmGameRscDownloader.2
 * JD-Core Version:    0.7.0.1
 */