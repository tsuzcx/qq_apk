package com.tencent.turingfd.sdk.base;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;

public class bu
{
  public static final dj a = new br();
  
  public static bu a()
  {
    return (bu)a.b();
  }
  
  public final String a(String paramString)
  {
    try
    {
      Object localObject = Environment.getExternalStorageDirectory().getAbsolutePath();
      localObject = new File((String)localObject + File.separator + ".turingdebug");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      return ((File)localObject).getAbsolutePath() + File.separator + paramString;
    }
    catch (Throwable paramString) {}
    return "";
  }
  
  public final void a(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1);
    if (TextUtils.isEmpty(paramString1)) {}
    while (new File(paramString1).exists()) {
      return;
    }
    new bs(this, paramString1, paramString2).start();
  }
  
  public void a(Throwable paramThrowable)
  {
    a("1", Log.getStackTraceString(paramThrowable));
  }
  
  public void b(Throwable paramThrowable)
  {
    a("2", Log.getStackTraceString(paramThrowable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.bu
 * JD-Core Version:    0.7.0.1
 */