package com.tencent.token;

import android.content.Context;
import com.tencent.token.core.bean.h;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;
import java.net.URLEncoder;
import org.json.JSONObject;

public final class co
  extends bm
{
  protected final String a()
  {
    String str2 = "";
    String str1 = str2;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      str1 = str2;
      int i = af.a + 1;
      str1 = str2;
      af.a = i;
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
      localJSONObject.put("config_ver", ba.a().h.b);
      str1 = str2;
      localObject = RqdApplication.g();
      if (localObject != null)
      {
        str1 = str2;
        localJSONObject.put("sec_sig", URLEncoder.encode((String)localObject));
      }
      str1 = str2;
      localJSONObject.put("channel_id", s.k());
      str1 = str2;
      localJSONObject.put("wtsdk_guid", s.a(x.a(RqdApplication.i()).c()));
      str1 = str2;
      localJSONObject.put("device_name", URLEncoder.encode(t.q()));
      str1 = str2;
      localJSONObject.put("release_tag", b.a);
      str1 = str2;
      str2 = localJSONObject.toString();
      str1 = str2;
      str2 = s.b(str2.getBytes());
      str1 = str2;
    }
    catch (Exception localException)
    {
      String str3;
      for (;;)
      {
        localException.printStackTrace();
        e.c("JSONException:" + localException.getMessage());
        continue;
        str3 = null;
      }
      label297:
      str1 = "?aq_base_sid=" + str3 + "&data=" + str1;
      str1 = b.c() + "/cn/mbtoken3/mbtoken3_session_info" + str1;
      e.c("url:" + str1);
    }
    ae.a();
    if (ax.a().p())
    {
      ax.a();
      str2 = ax.c;
      if (str2 != null) {
        break label297;
      }
      this.a.a(104, null, null);
      return null;
    }
    return str1;
  }
  
  protected final void a(fs paramfs) {}
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      this.a.a(i, "server errcode=" + i + ":" + paramJSONObject, paramJSONObject);
      return;
    }
    paramJSONObject = s.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      e.c(paramJSONObject.toString());
      if (paramJSONObject.has("new_config"))
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject("new_config");
        ba.a().h.a(localJSONObject);
      }
      if (paramJSONObject.has("update")) {
        h.b().a(paramJSONObject.getJSONObject("update"));
      }
      this.a.a = 0;
      return;
    }
    e.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.i().getString(2131361799));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.co
 * JD-Core Version:    0.7.0.1
 */