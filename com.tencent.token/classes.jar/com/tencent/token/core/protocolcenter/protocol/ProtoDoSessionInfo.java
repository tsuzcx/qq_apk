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
      JSONObject localJSONObject = new JSONObject();
      str1 = str2;
      int i = cb.a + 1;
      str1 = str2;
      cb.a = i;
      str1 = str2;
      localJSONObject.put("seq_id", i);
      str1 = str2;
      Object localObject = h.b();
      str1 = str2;
      localJSONObject.put("rmd_ver", ((h)localObject).g);
      str1 = str2;
      localJSONObject.put("rmd_times", ((h)localObject).h);
      str1 = str2;
      localJSONObject.put("rmd_last_time", ((h)localObject).i);
      str1 = str2;
      localJSONObject.put("config_ver", cs.a().h.b);
      str1 = str2;
      localObject = RqdApplication.j();
      if (localObject != null)
      {
        str1 = str2;
        localJSONObject.put("sec_sig", URLEncoder.encode((String)localObject));
      }
      str1 = str2;
      localJSONObject.put("channel_id", l.m());
      str1 = str2;
      localJSONObject.put("wtsdk_guid", l.a(bz.a(RqdApplication.l()).b()));
      str1 = str2;
      localJSONObject.put("device_name", URLEncoder.encode(m.x()));
      str1 = str2;
      localJSONObject.put("release_tag", c.a);
      str1 = str2;
      str2 = localJSONObject.toString();
      str1 = str2;
      str2 = l.b(str2.getBytes());
      str1 = str2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        g.c("JSONException:" + localException.getMessage());
      }
      str1 = "?aq_base_sid=" + localException + "&data=" + str1;
      str1 = c.e() + "/cn/mbtoken3/mbtoken3_session_info" + str1;
      g.c("url:" + str1);
    }
    str2 = ca.a().b();
    if (str2 == null)
    {
      this.a.b(104);
      return null;
    }
    return str1;
  }
  
  protected void a(do paramdo) {}
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      this.a.a(i, "server errcode=" + i + ":" + paramJSONObject, paramJSONObject);
      return;
    }
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      g.c(paramJSONObject.toString());
      if (paramJSONObject.has("new_config"))
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject("new_config");
        cs.a().h.a(localJSONObject);
      }
      if ((paramJSONObject.has("update")) && (!h.b().a(paramJSONObject.optJSONObject("update")))) {}
      this.a.c();
      return;
    }
    g.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDoSessionInfo
 * JD-Core Version:    0.7.0.1
 */