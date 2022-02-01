package com.tencent.beacon.e;

import android.content.SharedPreferences.Editor;
import com.tencent.beacon.a.d.a;
import com.tencent.beacon.base.util.b;
import java.util.Date;

class f
  implements Runnable
{
  f(g paramg, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = b.d(this.a);
    if (localObject != null) {}
    for (long l1 = ((Date)localObject).getTime() / 1000L;; l1 = 0L)
    {
      long l2 = l1;
      if (l1 == 0L) {
        l2 = new Date().getTime() / 1000L + 86400L;
      }
      localObject = a.a().edit();
      if (b.a((SharedPreferences.Editor)localObject)) {
        ((SharedPreferences.Editor)localObject).putString("sid_value", this.b).putLong("sid_mt", l2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.e.f
 * JD-Core Version:    0.7.0.1
 */