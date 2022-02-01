package com.tencent.mobileqq.filemanager.util;

import ahch;
import ahch.a;
import ahch.c;

public final class UniformDownloadUtil$1
  implements Runnable
{
  public UniformDownloadUtil$1(String paramString, ahch.c paramc) {}
  
  public void run()
  {
    ahch.a locala = ahch.a(this.val$url);
    if ((this.a != null) && (locala != null)) {
      this.a.ai(locala.fName, locala.aal);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.UniformDownloadUtil.1
 * JD-Core Version:    0.7.0.1
 */