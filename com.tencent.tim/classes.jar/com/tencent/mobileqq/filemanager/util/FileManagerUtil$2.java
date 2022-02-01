package com.tencent.mobileqq.filemanager.util;

import acfp;
import ahao;
import ahav;
import ahbf;
import android.content.Context;
import aqft;

public final class FileManagerUtil$2
  implements Runnable
{
  public FileManagerUtil$2(String paramString, Context paramContext) {}
  
  public void run()
  {
    try
    {
      long l = ahav.getFileSizes(this.val$filePath);
      if (aqft.hE() < l)
      {
        ahao.JD(acfp.m(2131706243));
        return;
      }
      ahbf.le(this.val$filePath);
      ahao.h(this.val$context, 2, 2131694150);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      ahao.h(this.val$context, 0, 2131706243);
      return;
    }
    catch (Exception localException)
    {
      ahao.h(this.val$context, 0, 2131694149);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.2
 * JD-Core Version:    0.7.0.1
 */