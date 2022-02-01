package com.tencent.bugly.crashreport.crash.anr;

import android.os.FileObserver;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;

final class b$1
  extends FileObserver
{
  b$1(b paramb, String paramString, int paramInt)
  {
    super(paramString, 8);
  }
  
  public final void onEvent(int paramInt, String paramString)
  {
    if (paramString == null) {
      return;
    }
    paramString = "/data/anr/" + paramString;
    x.d("watching file %s", new Object[] { paramString });
    if (!paramString.contains("trace"))
    {
      x.d("not anr file %s", new Object[] { paramString });
      return;
    }
    b.a(this.a).a(new b.1.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.anr.b.1
 * JD-Core Version:    0.7.0.1
 */