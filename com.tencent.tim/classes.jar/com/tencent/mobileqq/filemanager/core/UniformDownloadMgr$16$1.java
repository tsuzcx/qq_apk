package com.tencent.mobileqq.filemanager.core;

import agmb;
import ahch;

public class UniformDownloadMgr$16$1
  implements Runnable
{
  public UniformDownloadMgr$16$1(agmb paramagmb, String paramString) {}
  
  public void run()
  {
    if (this.bId != null)
    {
      ahch.K(this.a.val$filePath, this.a.arC);
      return;
    }
    ahch.fW(this.a.val$filePath, this.a.arC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadMgr.16.1
 * JD-Core Version:    0.7.0.1
 */