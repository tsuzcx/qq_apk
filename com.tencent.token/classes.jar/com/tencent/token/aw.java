package com.tencent.token;

import com.tencent.token.core.push.a;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class aw
{
  private static aw a = null;
  private String b = "/cn/mbtoken3/mbtoken3_asec_push_getconn";
  
  public static aw a()
  {
    if (a == null) {
      a = new aw();
    }
    return a;
  }
  
  public final d b()
  {
    int i = 0;
    d locald = new d((byte)0);
    Object localObject2 = new gv();
    Object localObject1 = b.c() + this.b;
    Object localObject3 = ((gv)localObject2).a((String)localObject1);
    if (localObject3 == null)
    {
      localObject2 = ((gv)localObject2).a();
      locald.a(((d)localObject2).a, ((d)localObject2).b, ((d)localObject2).c);
      e.c("client request url: " + (String)localObject1 + " failed, reason: " + locald.a + ":" + locald.b);
      return locald;
    }
    try
    {
      localObject1 = new JSONObject(new String((byte[])localObject3));
      int j = ((JSONObject)localObject1).getInt("err");
      if (j != 0)
      {
        e.c("error" + ((JSONObject)localObject1).toString());
        localObject1 = ((JSONObject)localObject1).getString("info");
        locald.a(j, (String)localObject1, (String)localObject1);
      }
      else
      {
        j = ((JSONObject)localObject1).getInt("retry_cnt");
        int k = ((JSONObject)localObject1).getInt("retry_time");
        int m = ((JSONObject)localObject1).getInt("hb_time");
        localObject1 = ((JSONObject)localObject1).getJSONArray("conn");
        localObject2 = new String[((JSONArray)localObject1).length()];
        localObject3 = new int[((JSONArray)localObject1).length()];
        while (i < ((JSONArray)localObject1).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject1).getJSONObject(i);
          localObject2[i] = localJSONObject.getString("ip");
          localObject3[i] = localJSONObject.getInt("port");
          i += 1;
        }
        a.a().a((String[])localObject2, (int[])localObject3, j, k * 1000, m * 1000);
        locald.a = 0;
      }
    }
    catch (JSONException localJSONException)
    {
      e.c("parse json failed: " + localJSONException.toString());
      locald.a(10020, "JSONException:" + localJSONException.toString(), null);
    }
    catch (Exception localException)
    {
      e.c("unknown err: " + localException.toString());
      locald.a(10021, "JSONException:" + localException.toString(), null);
    }
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aw
 * JD-Core Version:    0.7.0.1
 */