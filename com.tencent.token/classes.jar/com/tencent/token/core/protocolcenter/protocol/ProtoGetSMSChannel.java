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

public class ProtoGetSMSChannel
  extends d
{
  public static String d;
  public static String e;
  private long f;
  private String g;
  private int h;
  private int i;
  private String j;
  private int k;
  
  public static void a(dp paramdp, long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3)
  {
    paramdp.c.put("param.realuin", Long.valueOf(paramLong));
    paramdp.c.put("param.mbmobile.mobile", paramString1);
    paramdp.c.put("param.mbmoible.ismobile", Integer.valueOf(paramInt1));
    paramdp.c.put("param.scene.id", Integer.valueOf(paramInt2));
    paramdp.c.put("param.mbmoible.areacode", paramString2);
    paramdp.j = paramInt3;
  }
  
  protected String a()
  {
    String str = cb.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject = l.a(new Object[] { "seq_id", Integer.valueOf(this.k), "op_time", Long.valueOf(cd.c().s() / 1000L), "uin", Long.valueOf(this.f), "mobile", this.g, "area_code", this.j, "scene", Integer.valueOf(this.i), "is_mb_mobile", Integer.valueOf(this.h) });
    if (localObject == null)
    {
      this.a.a(10000, "encrypt data failed");
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?aq_base_sid=");
    localStringBuilder.append(str);
    localStringBuilder.append("&data=");
    localStringBuilder.append((String)localObject);
    str = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c.e());
    ((StringBuilder)localObject).append("/cn/mbtoken3/mbtoken3_get_sms_port_v2");
    ((StringBuilder)localObject).append(str);
    return ((StringBuilder)localObject).toString();
  }
  
  protected void a(dp paramdp)
  {
    this.f = ((Long)paramdp.c.get("param.realuin")).longValue();
    this.g = ((String)paramdp.c.get("param.mbmobile.mobile"));
    this.h = ((Integer)paramdp.c.get("param.mbmoible.ismobile")).intValue();
    this.i = ((Integer)paramdp.c.get("param.scene.id")).intValue();
    this.j = ((String)paramdp.c.get("param.mbmoible.areacode"));
    this.k = paramdp.j;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int m = paramJSONObject.getInt("err");
    if (m != 0)
    {
      a(m, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    StringBuilder localStringBuilder;
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ProtoGetSMSChannel result =");
      localStringBuilder.append(paramJSONObject);
      g.a(localStringBuilder.toString());
      m = paramJSONObject.getInt("seq_id");
      if (m != this.k)
      {
        this.a.b(10030);
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("parseJSON error seq is wrong seq=");
        paramJSONObject.append(m);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.k);
        g.c(paramJSONObject.toString());
        return;
      }
      d = paramJSONObject.getString("sms_port");
    }
    try
    {
      e = paramJSONObject.getString("sms_up_code");
      label169:
      this.a.c();
      return;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseJSON error decodeData=");
      localStringBuilder.append(paramJSONObject);
      g.c(localStringBuilder.toString());
      a(10022, RqdApplication.n().getString(2131493068));
      return;
    }
    catch (Exception paramJSONObject)
    {
      break label169;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetSMSChannel
 * JD-Core Version:    0.7.0.1
 */