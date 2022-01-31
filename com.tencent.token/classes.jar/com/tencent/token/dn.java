package com.tencent.token;

import com.tencent.token.core.push.b;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class dn
{
  private static dn a = null;
  private String b = "/cn/mbtoken3/mbtoken3_asec_push_getconn";
  
  public static dn a()
  {
    if (a == null) {
      a = new dn();
    }
    return a;
  }
  
  public f b()
  {
    f localf = new f();
    Object localObject1 = new gk();
    Object localObject2 = c.e() + this.b;
    Object localObject3 = ((gk)localObject1).a((String)localObject2);
    if (localObject3 == null)
    {
      localf.a(((gk)localObject1).a());
      h.c("client request url: " + (String)localObject2 + " failed, reason: " + localf.a + ":" + localf.b);
      return localf;
    }
    try
    {
      localObject1 = new JSONObject(new String((byte[])localObject3));
      int i = ((JSONObject)localObject1).getInt("err");
      if (i != 0)
      {
        h.c("error" + ((JSONObject)localObject1).toString());
        localObject1 = ((JSONObject)localObject1).getString("info");
        localf.a(i, (String)localObject1, (String)localObject1);
      }
      else
      {
        int j = ((JSONObject)localObject1).getInt("retry_cnt");
        int k = ((JSONObject)localObject1).getInt("retry_time");
        int m = ((JSONObject)localObject1).getInt("hb_time");
        localObject1 = ((JSONObject)localObject1).getJSONArray("conn");
        localObject2 = new String[((JSONArray)localObject1).length()];
        localObject3 = new int[((JSONArray)localObject1).length()];
        i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject1).getJSONObject(i);
          localObject2[i] = localJSONObject.getString("ip");
          localObject3[i] = localJSONObject.getInt("port");
          i += 1;
        }
        b.a().a((String[])localObject2, (int[])localObject3, j, k * 1000, m * 1000);
        localf.c();
      }
    }
    catch (JSONException localJSONException)
    {
      h.c("parse json failed: " + localJSONException.toString());
      localf.a(10020, "JSONException:" + localJSONException.toString());
    }
    catch (Exception localException)
    {
      h.c("unknown err: " + localException.toString());
      localf.a(10021, "JSONException:" + localException.toString());
    }
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dn
 * JD-Core Version:    0.7.0.1
 */