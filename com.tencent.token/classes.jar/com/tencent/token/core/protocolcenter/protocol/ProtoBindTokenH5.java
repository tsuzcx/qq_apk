package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.cr;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoBindTokenH5
  extends d
{
  private long d;
  private String e;
  
  protected String a()
  {
    String str3 = ca.a().b();
    if (str3 == null)
    {
      this.a.b(104);
      return null;
    }
    String str2 = "";
    String str1 = str2;
    try
    {
      localObject = new JSONObject();
      str1 = str2;
      ((JSONObject)localObject).put("real_uin", this.d);
      str1 = str2;
      int i = cb.a + 1;
      str1 = str2;
      cb.a = i;
      str1 = str2;
      ((JSONObject)localObject).put("seq_id", i);
      str1 = str2;
      ((JSONObject)localObject).put("op_time", cc.c().s() / 1000L);
      str1 = str2;
      ((JSONObject)localObject).put("token_seq", cc.c().k());
      str1 = str2;
      ((JSONObject)localObject).put("token_code", cc.c().o());
      str1 = str2;
      ((JSONObject)localObject).put("imei", l.b(RqdApplication.l()));
      str1 = str2;
      ((JSONObject)localObject).put("signature", this.e);
      str1 = str2;
      str2 = ((JSONObject)localObject).toString();
      str1 = str2;
      localObject = new StringBuilder();
      str1 = str2;
      ((StringBuilder)localObject).append("plain:");
      str1 = str2;
      ((StringBuilder)localObject).append(str2);
      str1 = str2;
      g.a(((StringBuilder)localObject).toString());
      str1 = str2;
      str2 = l.b(str2.getBytes());
      str1 = str2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("JSONException:");
      ((StringBuilder)localObject).append(localException.getMessage());
      g.c(((StringBuilder)localObject).toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?aq_base_sid=");
    localStringBuilder.append(str3);
    localStringBuilder.append("&data=");
    localStringBuilder.append(str1);
    str1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(c.e());
    localStringBuilder.append("/cn/mbtoken3/mbtoken3_bind_token_h5");
    localStringBuilder.append(str1);
    str1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("url:");
    localStringBuilder.append(str1);
    g.c(localStringBuilder.toString());
    return str1;
  }
  
  protected void a(do paramdo)
  {
    this.d = ((Long)paramdo.c.get("param.realuin")).longValue();
    this.e = ((String)paramdo.c.get("param.bind.sig"));
  }
  
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
      if (paramJSONObject.getInt("seed_available") == 1)
      {
        localObject = l.d(paramJSONObject.getString("seed"));
        if (localObject != null)
        {
          cc.c().e();
          cc.c().a((byte[])localObject);
          cc.c().i();
        }
      }
      long l = paramJSONObject.getLong("server_time");
      cc.c().b(l);
      paramJSONObject = cr.a().d(this.d);
      if (paramJSONObject != null) {
        cr.a().b(paramJSONObject);
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
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoBindTokenH5
 * JD-Core Version:    0.7.0.1
 */