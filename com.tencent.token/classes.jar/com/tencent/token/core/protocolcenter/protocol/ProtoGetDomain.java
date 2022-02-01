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
    String str = ca.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject = l.a(new Object[] { "uin", Long.valueOf(this.d) });
    if (localObject == null)
    {
      this.a.a(10000, "encrypt  failed");
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?data=");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("&aq_base_sid=");
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c.e());
    ((StringBuilder)localObject).append("/cn/mbtoken3/mbtoken3_get_domain_v2");
    ((StringBuilder)localObject).append(str);
    return ((StringBuilder)localObject).toString();
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
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("domain name:");
      localStringBuilder.append(paramJSONObject);
      g.a(localStringBuilder.toString());
      this.e = paramJSONObject.optJSONArray("domain_list");
      this.a.c();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parseJSON error decodeData=");
    localStringBuilder.append(paramJSONObject);
    g.c(localStringBuilder.toString());
    a(10022, RqdApplication.l().getString(2131493067));
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