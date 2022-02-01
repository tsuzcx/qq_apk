package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import java.net.URLEncoder;
import oicq.wlogin_sdk.request.WtloginHelper;
import org.json.JSONObject;

public final class ug
  extends tk
{
  public final String a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      int i = sb.b + 1;
      sb.b = i;
      localJSONObject.put("seq_id", i);
      localObject = sn.b();
      localJSONObject.put("rmd_ver", ((sn)localObject).g);
      localJSONObject.put("rmd_times", ((sn)localObject).h);
      localJSONObject.put("rmd_last_time", ((sn)localObject).i);
      localJSONObject.put("config_ver", tb.a().h.b);
      localObject = RqdApplication.l();
      if (localObject != null) {
        localJSONObject.put("sec_sig", URLEncoder.encode((String)localObject));
      }
      localJSONObject.put("channel_id", aad.k());
      localJSONObject.put("wtsdk_guid", aad.a(rz.a(RqdApplication.n()).a.GetGuid()));
      localJSONObject.put("device_name", URLEncoder.encode(aae.x()));
      localJSONObject.put("release_tag", wx.a);
      aad.b(localJSONObject.toString().getBytes());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Object localObject = new StringBuilder("JSONException:");
      ((StringBuilder)localObject).append(localException.getMessage());
      xb.c(((StringBuilder)localObject).toString());
    }
    sa.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aar paramaar) {}
  
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
      ((wz)localObject).a(i, localStringBuilder.toString(), paramJSONObject);
      return;
    }
    paramJSONObject = aad.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      xb.c(paramJSONObject.toString());
      if (paramJSONObject.has("new_config"))
      {
        localObject = paramJSONObject.getJSONObject("new_config");
        tb.a().h.a((JSONObject)localObject);
      }
      if (paramJSONObject.has("update")) {
        sn.b().a(paramJSONObject.optJSONObject("update"));
      }
      this.a.a = 0;
      return;
    }
    xb.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493068));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ug
 * JD-Core Version:    0.7.0.1
 */