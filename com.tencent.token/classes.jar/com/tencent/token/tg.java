package com.tencent.token;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class tg
{
  private static tg a;
  private String b = "/cn/mbtoken3/mbtoken3_asec_push_getconn";
  
  public static tg a()
  {
    if (a == null) {
      a = new tg();
    }
    return a;
  }
  
  public final xh b()
  {
    xh localxh = new xh();
    Object localObject1 = new ajn();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(xf.e());
    ((StringBuilder)localObject2).append(this.b);
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = ((ajn)localObject1).a((String)localObject2);
    if (localObject3 == null)
    {
      localxh.a(((ajn)localObject1).a);
      localObject1 = new StringBuilder("client request url: ");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(" failed, reason: ");
      ((StringBuilder)localObject1).append(localxh.a);
      ((StringBuilder)localObject1).append(":");
      ((StringBuilder)localObject1).append(localxh.b);
      xj.c(((StringBuilder)localObject1).toString());
      return localxh;
    }
    try
    {
      localObject1 = new JSONObject(new String((byte[])localObject3));
      int i = ((JSONObject)localObject1).getInt("err");
      if (i != 0)
      {
        localObject2 = new StringBuilder("error");
        ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
        xj.c(((StringBuilder)localObject2).toString());
        localObject1 = ((JSONObject)localObject1).getString("info");
        localxh.a(i, (String)localObject1, (String)localObject1);
        return localxh;
      }
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
      wv.a().a((String[])localObject2, (int[])localObject3, j, k * 1000, m * 1000);
      localxh.a = 0;
      return localxh;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder("unknown err: ");
      ((StringBuilder)localObject2).append(localException.toString());
      xj.c(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder("JSONException:");
      ((StringBuilder)localObject2).append(localException.toString());
      localxh.a(10021, ((StringBuilder)localObject2).toString(), null);
      return localxh;
    }
    catch (JSONException localJSONException)
    {
      localObject2 = new StringBuilder("parse json failed: ");
      ((StringBuilder)localObject2).append(localJSONException.toString());
      xj.c(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder("JSONException:");
      ((StringBuilder)localObject2).append(localJSONException.toString());
      localxh.a(10020, ((StringBuilder)localObject2).toString(), null);
    }
    return localxh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tg
 * JD-Core Version:    0.7.0.1
 */