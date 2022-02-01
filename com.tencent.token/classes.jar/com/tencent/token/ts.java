package com.tencent.token;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ts
{
  private static ts a;
  private String b = "/cn/mbtoken3/mbtoken3_asec_push_getconn";
  
  public static ts a()
  {
    if (a == null) {
      a = new ts();
    }
    return a;
  }
  
  public final xt b()
  {
    xt localxt = new xt();
    Object localObject1 = new akl();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(xr.e());
    ((StringBuilder)localObject2).append(this.b);
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = ((akl)localObject1).a((String)localObject2);
    if (localObject3 == null)
    {
      localxt.a(((akl)localObject1).a);
      localObject1 = new StringBuilder("client request url: ");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(" failed, reason: ");
      ((StringBuilder)localObject1).append(localxt.a);
      ((StringBuilder)localObject1).append(":");
      ((StringBuilder)localObject1).append(localxt.b);
      xv.c(((StringBuilder)localObject1).toString());
      return localxt;
    }
    try
    {
      localObject1 = new JSONObject(new String((byte[])localObject3));
      int i = ((JSONObject)localObject1).getInt("err");
      if (i != 0)
      {
        localObject2 = new StringBuilder("error");
        ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
        xv.c(((StringBuilder)localObject2).toString());
        localObject1 = ((JSONObject)localObject1).getString("info");
        localxt.a(i, (String)localObject1, (String)localObject1);
        return localxt;
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
      xh.a().a((String[])localObject2, (int[])localObject3, j, k * 1000, m * 1000);
      localxt.a = 0;
      return localxt;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder("unknown err: ");
      ((StringBuilder)localObject2).append(localException.toString());
      xv.c(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder("JSONException:");
      ((StringBuilder)localObject2).append(localException.toString());
      localxt.a(10021, ((StringBuilder)localObject2).toString(), null);
      return localxt;
    }
    catch (JSONException localJSONException)
    {
      localObject2 = new StringBuilder("parse json failed: ");
      ((StringBuilder)localObject2).append(localJSONException.toString());
      xv.c(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder("JSONException:");
      ((StringBuilder)localObject2).append(localJSONException.toString());
      localxt.a(10020, ((StringBuilder)localObject2).toString(), null);
    }
    return localxt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ts
 * JD-Core Version:    0.7.0.1
 */