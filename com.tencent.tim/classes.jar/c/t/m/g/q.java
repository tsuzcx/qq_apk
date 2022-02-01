package c.t.m.g;

import android.content.SharedPreferences;
import java.util.Timer;

public final class q
{
  private static volatile boolean a = true;
  
  public static void a()
  {
    Object localObject = am.a();
    long l = ((Long)am.b((SharedPreferences)localObject, "loc_comm_rsa_key_update_time", Long.valueOf(0L))).longValue();
    if (l != 0L)
    {
      String str = (String)am.b((SharedPreferences)localObject, "loc_comm_rsa_pub_key_ver", "");
      ag.a(ac.a((String)am.b((SharedPreferences)localObject, "loc_comm_rsa_pub_key_64", "")), str);
    }
    if (Math.abs(System.currentTimeMillis() - l) < 259200000L) {
      return;
    }
    localObject = new Timer();
    ((Timer)localObject).schedule(new q.1((Timer)localObject), 5000L);
  }
  
  static final class a
    implements Runnable
  {
    public final void run()
    {
      if (!q.b()) {
        return;
      }
      aj.a("https://cs.map.qq.com/key", new q.a.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.q
 * JD-Core Version:    0.7.0.1
 */