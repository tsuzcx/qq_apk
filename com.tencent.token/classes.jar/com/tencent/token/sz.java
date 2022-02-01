package com.tencent.token;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class sz
{
  private static sz a;
  private String b = "/cn/mbtoken3/mbtoken3_asec_push_getconn";
  
  public static sz a()
  {
    if (a == null) {
      a = new sz();
    }
    return a;
  }
  
  public final wz b()
  {
    wz localwz = new wz();
    Object localObject1 = new ahr();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(wx.e());
    ((StringBuilder)localObject2).append(this.b);
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = ((ahr)localObject1).a((String)localObject2);
    if (localObject3 == null)
    {
      localwz.a(((ahr)localObject1).a);
      localObject1 = new StringBuilder("client request url: ");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(" failed, reason: ");
      ((StringBuilder)localObject1).append(localwz.a);
      ((StringBuilder)localObject1).append(":");
      ((StringBuilder)localObject1).append(localwz.b);
      xb.c(((StringBuilder)localObject1).toString());
      return localwz;
    }
    try
    {
      localObject1 = new JSONObject(new String((byte[])localObject3));
      int i = ((JSONObject)localObject1).getInt("err");
      if (i != 0)
      {
        localObject2 = new StringBuilder("error");
        ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
        xb.c(((StringBuilder)localObject2).toString());
        localObject1 = ((JSONObject)localObject1).getString("info");
        localwz.a(i, (String)localObject1, (String)localObject1);
        return localwz;
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
      wo.a().a((String[])localObject2, (int[])localObject3, j, k * 1000, m * 1000);
      localwz.a = 0;
      return localwz;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder("unknown err: ");
      ((StringBuilder)localObject2).append(localException.toString());
      xb.c(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder("JSONException:");
      ((StringBuilder)localObject2).append(localException.toString());
      localwz.a(10021, ((StringBuilder)localObject2).toString(), null);
      return localwz;
    }
    catch (JSONException localJSONException)
    {
      localObject2 = new StringBuilder("parse json failed: ");
      ((StringBuilder)localObject2).append(localJSONException.toString());
      xb.c(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder("JSONException:");
      ((StringBuilder)localObject2).append(localJSONException.toString());
      localwz.a(10020, ((StringBuilder)localObject2).toString(), null);
    }
    return localwz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.sz
 * JD-Core Version:    0.7.0.1
 */