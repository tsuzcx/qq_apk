package com.tencent.tmediacodec.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

class LogUtils$1
  implements ILogProxy
{
  public void d(@NonNull String paramString1, @NonNull String paramString2)
  {
    Log.d(paramString1, paramString2);
  }
  
  public void e(@NonNull String paramString1, @NonNull String paramString2, @Nullable Throwable paramThrowable)
  {
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public void i(@NonNull String paramString1, @NonNull String paramString2)
  {
    Log.i(paramString1, paramString2);
  }
  
  public void v(@NonNull String paramString1, @NonNull String paramString2)
  {
    Log.v(paramString1, paramString2);
  }
  
  public void w(@NonNull String paramString1, @NonNull String paramString2, @Nullable Throwable paramThrowable)
  {
    Log.w(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmediacodec.util.LogUtils.1
 * JD-Core Version:    0.7.0.1
 */