package com.tencent.beacon.d;

import android.content.SharedPreferences.Editor;
import com.tencent.beacon.a.d.a;
import com.tencent.beacon.a.d.a.a;
import com.tencent.beacon.base.net.b.d;

class b
  implements Runnable
{
  b(c paramc, String paramString, a parama) {}
  
  public void run()
  {
    if (!d.d()) {}
    a.a locala;
    do
    {
      boolean bool;
      do
      {
        return;
        bool = c.a(this.c);
      } while ((!c.b(this.c)) || (!bool));
      com.tencent.beacon.base.util.c.a("[event] rqd_heartbeat A85=Y report success : " + this.a, new Object[0]);
      locala = this.b.edit();
    } while (!com.tencent.beacon.base.util.b.a(locala));
    locala.putString("active_user_date", this.a).commit();
    locala.putString("HEART_DENGTA", this.a).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.d.b
 * JD-Core Version:    0.7.0.1
 */