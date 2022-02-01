package com.tencent.token;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class sy
{
  private static sy a;
  private String b = "/cn/mbtoken3/mbtoken3_asec_push_getconn";
  
  public static sy a()
  {
    if (a == null) {
      a = new sy();
    }
    return a;
  }
  
  public final wy b()
  {
    wy localwy = new wy();
    Object localObject1 = new ahq();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(ww.e());
    ((StringBuilder)localObject2).append(this.b);
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = ((ahq)localObject1).a((String)localObject2);
    if (localObject3 == null)
    {
      localwy.a(((ahq)localObject1).a);
      localObject1 = new StringBuilder("client request url: ");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(" failed, reason: ");
      ((StringBuilder)localObject1).append(localwy.a);
      ((StringBuilder)localObject1).append(":");
      ((StringBuilder)localObject1).append(localwy.b);
      xa.c(((StringBuilder)localObject1).toString());
      return localwy;
    }
    try
    {
      localObject1 = new JSONObject(new String((byte[])localObject3));
      int i = ((JSONObject)localObject1).getInt("err");
      if (i != 0)
      {
        localObject2 = new StringBuilder("error");
        ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
        xa.c(((StringBuilder)localObject2).toString());
        localObject1 = ((JSONObject)localObject1).getString("info");
        localwy.a(i, (String)localObject1, (String)localObject1);
        return localwy;
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
      wn.a().a((String[])localObject2, (int[])localObject3, j, k * 1000, m * 1000);
      localwy.a = 0;
      return localwy;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder("unknown err: ");
      ((StringBuilder)localObject2).append(localException.toString());
      xa.c(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder("JSONException:");
      ((StringBuilder)localObject2).append(localException.toString());
      localwy.a(10021, ((StringBuilder)localObject2).toString(), null);
      return localwy;
    }
    catch (JSONException localJSONException)
    {
      localObject2 = new StringBuilder("parse json failed: ");
      ((StringBuilder)localObject2).append(localJSONException.toString());
      xa.c(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder("JSONException:");
      ((StringBuilder)localObject2).append(localJSONException.toString());
      localwy.a(10020, ((StringBuilder)localObject2).toString(), null);
    }
    return localwy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.sy
 * JD-Core Version:    0.7.0.1
 */