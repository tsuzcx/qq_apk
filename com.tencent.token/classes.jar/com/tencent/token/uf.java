package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import java.net.URLEncoder;
import oicq.wlogin_sdk.request.WtloginHelper;
import org.json.JSONObject;

public final class uf
  extends tj
{
  public final String a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      int i = sa.b + 1;
      sa.b = i;
      localJSONObject.put("seq_id", i);
      localObject = sm.b();
      localJSONObject.put("rmd_ver", ((sm)localObject).g);
      localJSONObject.put("rmd_times", ((sm)localObject).h);
      localJSONObject.put("rmd_last_time", ((sm)localObject).i);
      localJSONObject.put("config_ver", ta.a().h.b);
      localObject = RqdApplication.l();
      if (localObject != null) {
        localJSONObject.put("sec_sig", URLEncoder.encode((String)localObject));
      }
      localJSONObject.put("channel_id", aac.k());
      localJSONObject.put("wtsdk_guid", aac.a(ry.a(RqdApplication.n()).a.GetGuid()));
      localJSONObject.put("device_name", URLEncoder.encode(aad.x()));
      localJSONObject.put("release_tag", ww.a);
      aac.b(localJSONObject.toString().getBytes());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Object localObject = new StringBuilder("JSONException:");
      ((StringBuilder)localObject).append(localException.getMessage());
      xa.c(((StringBuilder)localObject).toString());
    }
    rz.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aaq paramaaq) {}
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    Object localObject;
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder("server errcode=");
      localStringBuilder.append(i);
      localStringBuilder.append(":");
      localStringBuilder.append(paramJSONObject);
      ((wy)localObject).a(i, localStringBuilder.toString(), paramJSONObject);
      return;
    }
    paramJSONObject = aac.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      xa.c(paramJSONObject.toString());
      if (paramJSONObject.has("new_config"))
      {
        localObject = paramJSONObject.getJSONObject("new_config");
        ta.a().h.a((JSONObject)localObject);
      }
      if (paramJSONObject.has("update")) {
        sm.b().a(paramJSONObject.optJSONObject("update"));
      }
      this.a.a = 0;
      return;
    }
    xa.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493068));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.uf
 * JD-Core Version:    0.7.0.1
 */