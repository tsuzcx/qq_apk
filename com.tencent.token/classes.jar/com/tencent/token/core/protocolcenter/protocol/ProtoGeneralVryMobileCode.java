package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.cb;
import com.tencent.token.cd;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dp;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoGeneralVryMobileCode
  extends d
{
  private long d;
  private long e;
  private int f;
  private int g;
  private String h;
  private int i = 0;
  private final String j = "/cn/mbtoken3/mbtoken3_general_verify_mobile_code";
  
  public static void a(dp paramdp, long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    paramdp.c.put("param.uinhash", Long.valueOf(paramLong1));
    paramdp.c.put("param.realuin", Long.valueOf(paramLong2));
    paramdp.c.put("param.general.mobilecode.sceneid", Integer.valueOf(paramInt1));
    paramdp.c.put("param.mbmobile.vrycode", paramString);
    paramdp.c.put("param.type", Integer.valueOf(paramInt3));
    paramdp.j = paramInt2;
  }
  
  protected String a()
  {
    String str = cb.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject = l.a(new Object[] { "real_uin", Long.valueOf(this.e), "scene_id", Integer.valueOf(this.g), "seq_id", Integer.valueOf(this.f), "op_time", Long.valueOf(cd.c().s() / 1000L), "mobile_code", this.h, "verify_type_id", Integer.valueOf(this.i) });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?uin=");
    localStringBuilder.append(this.d);
    localStringBuilder.append("&aq_base_sid=");
    localStringBuilder.append(str);
    localStringBuilder.append("&data=");
    localStringBuilder.append((String)localObject);
    str = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c.e());
    ((StringBuilder)localObject).append("/cn/mbtoken3/mbtoken3_general_verify_mobile_code");
    ((StringBuilder)localObject).append(str);
    return ((StringBuilder)localObject).toString();
  }
  
  protected void a(dp paramdp)
  {
    this.d = ((Long)paramdp.c.get("param.uinhash")).longValue();
    this.e = ((Long)paramdp.c.get("param.realuin")).longValue();
    this.g = ((Integer)paramdp.c.get("param.general.mobilecode.sceneid")).intValue();
    this.h = ((String)paramdp.c.get("param.mbmobile.vrycode"));
    this.i = ((Integer)paramdp.c.get("param.type")).intValue();
    this.f = paramdp.j;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int k = paramJSONObject.getInt("err");
    if (k != 0)
    {
      a(k, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mbtoken3_general_verify_mobile_code ret: ");
      localStringBuilder.append(paramJSONObject);
      g.a(localStringBuilder.toString());
      k = paramJSONObject.getInt("seq_id");
      if (k != this.f)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("parseJSON error seq is wrong seq=");
        paramJSONObject.append(k);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.f);
        g.c(paramJSONObject.toString());
        this.a.b(10030);
        return;
      }
      this.a.c();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parseJSON error decodeData=");
    localStringBuilder.append(paramJSONObject);
    g.c(localStringBuilder.toString());
    a(10022, RqdApplication.n().getString(2131493068));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGeneralVryMobileCode
 * JD-Core Version:    0.7.0.1
 */