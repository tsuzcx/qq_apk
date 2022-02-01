package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoQueryMaliciousURL
  extends d
{
  public String d;
  private int e;
  private String f;
  
  public static void a(do paramdo, String paramString)
  {
    paramdo.c.put("param.barcode.url", paramString);
  }
  
  protected String a()
  {
    String str1 = ca.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    int i = cb.a + 1;
    cb.a = i;
    this.c = i;
    String str2 = l.a(new Object[] { "url", URLEncoder.encode(this.d), "seq_id", Integer.valueOf(this.c), "op_time", Long.valueOf(cc.c().s() / 1000L) });
    str1 = "?aq_base_sid=" + str1 + "&data=" + str2;
    return c.e() + "/cn/mbtoken3/mbtoken3_query_malicious_url_encrypt" + str1;
  }
  
  protected void a(do paramdo)
  {
    this.d = ((String)paramdo.c.get("param.barcode.url"));
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
      g.a("json" + paramJSONObject.toString());
      i = paramJSONObject.getInt("seq_id");
      if (i != this.c)
      {
        this.a.b(10030);
        g.c("parseJSON error seq is wrong seq=" + i + ",right = " + this.c);
        return;
      }
      this.e = paramJSONObject.getInt("malicious_id");
      this.f = paramJSONObject.getString("malicious_desc");
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
      localMessage.arg2 = this.e;
      localMessage.obj = this.f;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoQueryMaliciousURL
 * JD-Core Version:    0.7.0.1
 */