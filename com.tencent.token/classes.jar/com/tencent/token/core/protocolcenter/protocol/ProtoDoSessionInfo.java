package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.core.bean.j;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cp;
import com.tencent.token.cv;
import com.tencent.token.cw;
import com.tencent.token.dr;
import com.tencent.token.es;
import com.tencent.token.ev;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import com.tencent.token.utils.x;
import java.net.URLEncoder;
import org.json.JSONObject;

public class ProtoDoSessionInfo
  extends e
{
  protected String a()
  {
    String str2 = "";
    String str1 = str2;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      str1 = str2;
      int i = cw.a + 1;
      str1 = str2;
      cw.a = i;
      str1 = str2;
      localJSONObject.put("seq_id", i);
      str1 = str2;
      Object localObject = j.b();
      str1 = str2;
      localJSONObject.put("rmd_ver", ((j)localObject).g);
      str1 = str2;
      localJSONObject.put("rmd_times", ((j)localObject).h);
      str1 = str2;
      localJSONObject.put("rmd_last_time", ((j)localObject).i);
      str1 = str2;
      localJSONObject.put("config_ver", dr.a().h.b);
      str1 = str2;
      localObject = RqdApplication.j();
      if (localObject != null)
      {
        str1 = str2;
        localJSONObject.put("sec_sig", URLEncoder.encode((String)localObject));
      }
      str1 = str2;
      localJSONObject.put("channel_id", w.m());
      str1 = str2;
      localJSONObject.put("wtsdk_guid", w.a(cp.a(RqdApplication.l()).b()));
      str1 = str2;
      localJSONObject.put("device_name", URLEncoder.encode(x.x()));
      str1 = str2;
      localJSONObject.put("release_tag", c.a);
      str1 = str2;
      str2 = localJSONObject.toString();
      str1 = str2;
      str2 = w.b(str2.getBytes());
      str1 = str2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        h.c("JSONException:" + localException.getMessage());
      }
      str1 = "?aq_base_sid=" + localException + "&data=" + str1;
      str1 = c.e() + "/cn/mbtoken3/mbtoken3_session_info" + str1;
      h.c("url:" + str1);
    }
    str2 = cv.a().b();
    if (str2 == null)
    {
      this.a.b(104);
      return null;
    }
    return str1;
  }
  
  protected void a(ev paramev) {}
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      this.a.a(i, "server errcode=" + i + ":" + paramJSONObject, paramJSONObject);
      return;
    }
    paramJSONObject = w.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      h.c(paramJSONObject.toString());
      if (paramJSONObject.has("new_config"))
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject("new_config");
        dr.a().h.a(localJSONObject);
      }
      if ((paramJSONObject.has("update")) && (!j.b().a(paramJSONObject.optJSONObject("update")))) {}
      this.a.c();
      return;
    }
    h.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDoSessionInfo
 * JD-Core Version:    0.7.0.1
 */