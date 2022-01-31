package com.tencent.mobileqq.mqsafeedit;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class CodecWarpper
{
  public static final String NATIVE_LIB_NAME = "codecwrapperV2";
  private static AtomicBoolean isSoLoaded = new AtomicBoolean(false);
  
  static
  {
    loadSo();
  }
  
  public static void loadSo()
  {
    if (!isSoLoaded.get()) {
      try
      {
        if (CoreUtil.loadLibrary("codecwrapperV2", BaseApplication.getContext()))
        {
          isSoLoaded.set(true);
          return;
        }
        String str = BaseApplication.getContext().getPackageName().replace(".", "_");
        isSoLoaded.set(CoreUtil.loadLibrary(str + "_" + "codecwrapperV2", BaseApplication.getContext()));
        return;
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.mqsafeedit.CodecWarpper
 * JD-Core Version:    0.7.0.1
 */