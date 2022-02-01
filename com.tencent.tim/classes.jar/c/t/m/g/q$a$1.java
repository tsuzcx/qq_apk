package c.t.m.g;

import android.content.SharedPreferences;
import org.json.JSONObject;

final class q$a$1
  implements aj.c
{
  q$a$1(q.a parama) {}
  
  public final void a(String paramString)
  {
    try
    {
      Object localObject1 = new JSONObject(paramString);
      int i = ((JSONObject)localObject1).getInt("status");
      if (i == 0)
      {
        String str = ((JSONObject)localObject1).getString("version");
        Object localObject2 = ((JSONObject)localObject1).getString("key");
        localObject1 = localObject2;
        if (((String)localObject2).contains("-----")) {
          localObject1 = localObject2.split("-----")[2];
        }
        localObject1 = ((String)localObject1).replaceAll("\n", "");
        ag.a(ac.a((String)localObject1), str);
        localObject2 = am.a();
        am.a((SharedPreferences)localObject2, "loc_comm_rsa_pub_key_ver", str);
        am.a((SharedPreferences)localObject2, "loc_comm_rsa_pub_key_64", localObject1);
        am.a((SharedPreferences)localObject2, "loc_comm_rsa_key_update_time", Long.valueOf(System.currentTimeMillis()));
        return;
      }
      ai.a(3, "UpdateRsaPublicKey", "parse json status:" + i + ", json=" + paramString, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      ai.a("UpdateRsaPublicKey", "parse json error : ".concat(String.valueOf(paramString)), localThrowable);
    }
  }
  
  public final void b(String paramString)
  {
    ai.a(3, "UpdateRsaPublicKey", "onFailed:".concat(String.valueOf(paramString)), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.q.a.1
 * JD-Core Version:    0.7.0.1
 */