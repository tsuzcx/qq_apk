package com.tencent.beacon.event.c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.beacon.base.util.b;
import java.util.concurrent.atomic.AtomicLong;

class e
  implements Runnable
{
  private volatile long a = 0L;
  private volatile long b = 0L;
  private volatile long c = 0L;
  
  e(g paramg) {}
  
  public void run()
  {
    synchronized (this.d)
    {
      long l1 = g.a(this.d).get();
      long l2 = g.b(this.d).get();
      long l3 = g.c(this.d).get();
      if ((this.a == l1) && (this.b == l2) && (this.c == l3)) {
        return;
      }
      this.a = l1;
      this.b = l2;
      this.c = l3;
      SharedPreferences.Editor localEditor = g.a(this.d, g.d(this.d)).edit();
      boolean bool = b.a(localEditor);
      if (bool)
      {
        localEditor = localEditor.putString("on_date", g.e(this.d));
        localEditor = localEditor.putLong("realtime_log_id", this.a);
        localEditor = localEditor.putLong("normal_log_id", this.b);
        localEditor.putLong("immediate_log_id", this.c).apply();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.event.c.e
 * JD-Core Version:    0.7.0.1
 */