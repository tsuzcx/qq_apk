package com.tencent.turingfd.sdk.base;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;

public class bf
{
  public static final cx<bf> a = new a();
  
  public void a(Throwable paramThrowable)
  {
    String str = Log.getStackTraceString(paramThrowable);
    try
    {
      paramThrowable = Environment.getExternalStorageDirectory().getAbsolutePath();
      paramThrowable = new File(ci.a(ci.a(paramThrowable), File.separator, ".turingdebug"));
      if (!paramThrowable.exists()) {
        paramThrowable.mkdirs();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramThrowable.getAbsolutePath());
      paramThrowable = ci.a(localStringBuilder, File.separator, "2");
    }
    catch (Throwable paramThrowable)
    {
      label74:
      break label74;
    }
    paramThrowable = "";
    if (TextUtils.isEmpty(paramThrowable)) {
      return;
    }
    if (new File(paramThrowable).exists()) {
      return;
    }
    new bg(this, paramThrowable, str).start();
  }
  
  public static final class a
    extends cx<bf>
  {
    public Object a()
    {
      return new bf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.bf
 * JD-Core Version:    0.7.0.1
 */