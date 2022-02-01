package com.tencent.mobileqq.filemanager.util;

import ahch;
import ahch.b;

public final class UniformDownloadUtil$2
  implements Runnable
{
  public UniformDownloadUtil$2(String paramString, ahch.b paramb) {}
  
  public void run()
  {
    String str = ahch.lh(this.bJU);
    if (this.a != null) {
      this.a.onResult(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.UniformDownloadUtil.2
 * JD-Core Version:    0.7.0.1
 */