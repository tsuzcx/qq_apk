package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.bz;
import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.core.bean.h;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.cs;
import com.tencent.token.dl;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import com.tencent.token.utils.m;
import java.net.URLEncoder;
import org.json.JSONObject;

public class ProtoDoSessionInfo
  extends d
{
  protected String a()
  {
    String str2 = "";
    String str1 = str2;
    try
    {
      localObject2 = new JSONObject();
      str1 = str2;
      int i = cb.a + 1;
      str1 = str2;
      cb.a = i;
      str1 = str2;
      ((JSONObject)localObject2).put("seq_id", i);
      str1 = str2;
      Object localObject3 = h.b();
      str1 = str2;
      ((JSONObject)localObject2).put("rmd_ver", ((h)localObject3).g);
      str1 = str2;
      ((JSONObject)localObject2).put("rmd_times", ((h)localObject3).h);
      str1 = str2;
      ((JSONObject)localObject2).put("rmd_last_time", ((h)localObject3).i);
      str1 = str2;
      ((JSONObject)localObject2).put("config_ver", cs.a().h.b);
      str1 = str2;
      localObject3 = RqdApplication.j();
      if (localObject3 != null)
      {
        str1 = str2;
        ((JSONObject)localObject2).put("sec_sig", URLEncoder.encode((String)localObject3));
      }
      str1 = str2;
      ((JSONObject)localObject2).put("channel_id", l.m());
      str1 = str2;
      ((JSONObject)localObject2).put("wtsdk_guid", l.a(bz.a(RqdApplication.l()).b()));
      str1 = str2;
      ((JSONObject)localObject2).put("device_name", URLEncoder.encode(m.x()));
      str1 = str2;
      ((JSONObject)localObject2).put("release_tag", c.a);
      str1 = str2;
      str2 = ((JSONObject)localObject2).toString();
      str1 = str2;
      str2 = l.b(str2.getBytes());
      str1 = str2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("JSONException:");
      ((StringBuilder)localObject2).append(localException.getMessage());
      g.c(((StringBuilder)localObject2).toString());
    }
    Object localObject1 = ca.a().b();
    if (localObject1 == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("?aq_base_sid=");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("&data=");
    ((StringBuilder)localObject2).append(str1);
    str1 = ((StringBuilder)localObject2).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(c.e());
    ((StringBuilder)localObject1).append("/cn/mbtoken3/mbtoken3_session_info");
    ((StringBuilder)localObject1).append(str1);
    str1 = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("url:");
    ((StringBuilder)localObject1).append(str1);
    g.c(((StringBuilder)localObject1).toString());
    return str1;
  }
  
  protected void a(do paramdo) {}
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("server errcode=");
      localStringBuilder.append(i);
      localStringBuilder.append(":");
      localStringBuilder.append(paramJSONObject);
      ((e)localObject).a(i, localStringBuilder.toString(), paramJSONObject);
      return;
    }
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      g.c(paramJSONObject.toString());
      if (paramJSONObject.has("new_config"))
      {
        localObject = paramJSONObject.getJSONObject("new_config");
        cs.a().h.a((JSONObject)localObject);
      }
      if (paramJSONObject.has("update")) {
        h.b().a(paramJSONObject.optJSONObject("update"));
      }
      this.a.c();
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("parseJSON error decodeData=");
    ((StringBuilder)localObject).append(paramJSONObject);
    g.c(((StringBuilder)localObject).toString());
    a(10022, RqdApplication.l().getString(2131493067));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDoSessionInfo
 * JD-Core Version:    0.7.0.1
 */