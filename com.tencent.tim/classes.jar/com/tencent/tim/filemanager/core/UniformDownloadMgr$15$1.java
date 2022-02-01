package com.tencent.tim.filemanager.core;

import ahch;
import atus;

public class UniformDownloadMgr$15$1
  implements Runnable
{
  public UniformDownloadMgr$15$1(atus paramatus, String paramString) {}
  
  public void run()
  {
    if (this.bId != null)
    {
      ahch.dh(this.a.val$filePath);
      return;
    }
    ahch.fW(this.a.val$filePath, "TIM");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.core.UniformDownloadMgr.15.1
 * JD-Core Version:    0.7.0.1
 */