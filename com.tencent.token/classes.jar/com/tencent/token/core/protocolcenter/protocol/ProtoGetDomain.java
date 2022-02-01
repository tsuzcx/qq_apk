package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.ca;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class ProtoGetDomain
  extends d
{
  private long d;
  private JSONArray e;
  
  public static void a(do paramdo, long paramLong)
  {
    paramdo.c.put("param.realuin", Long.valueOf(paramLong));
  }
  
  protected String a()
  {
    String str1 = ca.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    String str2 = l.a(new Object[] { "uin", Long.valueOf(this.d) });
    if (str2 == null)
    {
      this.a.a(10000, "encrypt  failed");
      return null;
    }
    str1 = "?data=" + str2 + "&aq_base_sid=" + str1;
    return c.e() + "/cn/mbtoken3/mbtoken3_get_domain_v2" + str1;
  }
  
  protected void a(do paramdo)
  {
    this.d = ((Long)paramdo.c.get("param.realuin")).longValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      g.a("domain name:" + paramJSONObject);
      this.e = paramJSONObject.optJSONArray("domain_list");
      this.a.c();
      return;
    }
    g.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
  
  protected void b()
  {
    if ((!this.b.e) && (this.b.d != null))
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.e;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetDomain
 * JD-Core Version:    0.7.0.1
 */