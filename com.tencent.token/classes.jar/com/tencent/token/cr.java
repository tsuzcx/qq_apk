package com.tencent.token;

import com.tencent.token.core.push.b;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class cr
{
  private static cr a;
  private String b = "/cn/mbtoken3/mbtoken3_asec_push_getconn";
  
  public static cr a()
  {
    if (a == null) {
      a = new cr();
    }
    return a;
  }
  
  public e b()
  {
    e locale = new e();
    Object localObject1 = new fc();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(c.e());
    ((StringBuilder)localObject2).append(this.b);
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = ((fc)localObject1).a((String)localObject2);
    if (localObject3 == null)
    {
      locale.a(((fc)localObject1).a());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("client request url: ");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(" failed, reason: ");
      ((StringBuilder)localObject1).append(locale.a);
      ((StringBuilder)localObject1).append(":");
      ((StringBuilder)localObject1).append(locale.b);
      g.c(((StringBuilder)localObject1).toString());
      return locale;
    }
    try
    {
      localObject1 = new JSONObject(new String((byte[])localObject3));
      int i = ((JSONObject)localObject1).getInt("err");
      if (i != 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("error");
        ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
        g.c(((StringBuilder)localObject2).toString());
        localObject1 = ((JSONObject)localObject1).getString("info");
        locale.a(i, (String)localObject1, (String)localObject1);
        return locale;
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
      b.a().a((String[])localObject2, (int[])localObject3, j, k * 1000, m * 1000);
      locale.c();
      return locale;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("unknown err: ");
      ((StringBuilder)localObject2).append(localException.toString());
      g.c(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("JSONException:");
      ((StringBuilder)localObject2).append(localException.toString());
      locale.a(10021, ((StringBuilder)localObject2).toString());
      return locale;
    }
    catch (JSONException localJSONException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("parse json failed: ");
      ((StringBuilder)localObject2).append(localJSONException.toString());
      g.c(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("JSONException:");
      ((StringBuilder)localObject2).append(localJSONException.toString());
      locale.a(10020, ((StringBuilder)localObject2).toString());
    }
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cr
 * JD-Core Version:    0.7.0.1
 */