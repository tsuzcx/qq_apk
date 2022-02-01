package com.tencent.token;

import android.os.Build;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class afe
  extends Thread
{
  public afe(AtomicBoolean paramAtomicBoolean, HashMap paramHashMap, aem paramaem, Object paramObject) {}
  
  public final void run()
  {
    super.run();
    if (this.a.get()) {
      return;
    }
    for (;;)
    {
      try
      {
        HashMap localHashMap = this.b;
        String str = this.c.a();
        ??? = str;
        if (str == null) {
          ??? = "";
        }
        localHashMap.put("274", ???);
        localHashMap = this.b;
        str = this.c.b();
        ??? = str;
        if (str == null) {
          ??? = "";
        }
        localHashMap.put("276", ???);
        localHashMap = this.b;
        str = this.c.c();
        ??? = str;
        if (str == null) {
          ??? = "";
        }
        localHashMap.put("275", ???);
        str = this.c.d();
        ??? = str;
        if (str == null) {
          ??? = "";
        }
        if (!TextUtils.isEmpty((CharSequence)???))
        {
          this.b.put("264", ???);
        }
        else
        {
          ??? = this.b;
          if (acx.c == null) {
            acx.c = Build.MODEL;
          }
          ((HashMap)???).put("264", acx.c);
        }
      }
      finally
      {
        continue;
      }
      synchronized (this.d)
      {
        this.d.notify();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afe
 * JD-Core Version:    0.7.0.1
 */