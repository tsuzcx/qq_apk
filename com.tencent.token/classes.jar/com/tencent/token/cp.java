package com.tencent.token;

import com.tencent.token.core.push.b;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class cp
{
  private static cp a = null;
  private String b = "/cn/mbtoken3/mbtoken3_asec_push_getconn";
  
  public static cp a()
  {
    if (a == null) {
      a = new cp();
    }
    return a;
  }
  
  public e b()
  {
    e locale = new e();
    Object localObject1 = new ey();
    Object localObject2 = c.e() + this.b;
    Object localObject3 = ((ey)localObject1).a((String)localObject2);
    if (localObject3 == null)
    {
      locale.a(((ey)localObject1).a());
      g.c("client request url: " + (String)localObject2 + " failed, reason: " + locale.a + ":" + locale.b);
      return locale;
    }
    try
    {
      localObject1 = new JSONObject(new String((byte[])localObject3));
      int i = ((JSONObject)localObject1).getInt("err");
      if (i != 0)
      {
        g.c("error" + ((JSONObject)localObject1).toString());
        localObject1 = ((JSONObject)localObject1).getString("info");
        locale.a(i, (String)localObject1, (String)localObject1);
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
        locale.c();
      }
    }
    catch (JSONException localJSONException)
    {
      g.c("parse json failed: " + localJSONException.toString());
      locale.a(10020, "JSONException:" + localJSONException.toString());
    }
    catch (Exception localException)
    {
      g.c("unknown err: " + localException.toString());
      locale.a(10021, "JSONException:" + localException.toString());
    }
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cp
 * JD-Core Version:    0.7.0.1
 */