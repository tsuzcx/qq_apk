package com.tencent.bugly.crashreport.crash.anr;

import android.os.FileObserver;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.x;

final class b$4
  extends FileObserver
{
  b$4(b paramb, String paramString, int paramInt)
  {
    super(paramString, 256);
  }
  
  public final void onEvent(int paramInt, String paramString)
  {
    if (paramString == null) {}
    do
    {
      return;
      x.d("startWatchingPrivateAnrDir %s", new Object[] { paramString });
      if (!b.a(this.a, paramString))
      {
        x.c("trace file not caused by sigquit , ignore ", new Object[0]);
        return;
      }
    } while (b.b(this.a) == null);
    b.b(this.a).a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.anr.b.4
 * JD-Core Version:    0.7.0.1
 */