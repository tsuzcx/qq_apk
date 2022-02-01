package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.ca;
import com.tencent.token.cc;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.do;
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
  
  public static void a(do paramdo, long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    paramdo.c.put("param.uinhash", Long.valueOf(paramLong1));
    paramdo.c.put("param.realuin", Long.valueOf(paramLong2));
    paramdo.c.put("param.general.mobilecode.sceneid", Integer.valueOf(paramInt1));
    paramdo.c.put("param.mbmobile.vrycode", paramString);
    paramdo.c.put("param.type", Integer.valueOf(paramInt3));
    paramdo.j = paramInt2;
  }
  
  protected String a()
  {
    String str1 = ca.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    String str2 = l.a(new Object[] { "real_uin", Long.valueOf(this.e), "scene_id", Integer.valueOf(this.g), "seq_id", Integer.valueOf(this.f), "op_time", Long.valueOf(cc.c().s() / 1000L), "mobile_code", this.h, "verify_type_id", Integer.valueOf(this.i) });
    str1 = "?uin=" + this.d + "&aq_base_sid=" + str1 + "&data=" + str2;
    return c.e() + "/cn/mbtoken3/mbtoken3_general_verify_mobile_code" + str1;
  }
  
  protected void a(do paramdo)
  {
    this.d = ((Long)paramdo.c.get("param.uinhash")).longValue();
    this.e = ((Long)paramdo.c.get("param.realuin")).longValue();
    this.g = ((Integer)paramdo.c.get("param.general.mobilecode.sceneid")).intValue();
    this.h = ((String)paramdo.c.get("param.mbmobile.vrycode"));
    this.i = ((Integer)paramdo.c.get("param.type")).intValue();
    this.f = paramdo.j;
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
      g.a("mbtoken3_general_verify_mobile_code ret: " + paramJSONObject);
      k = paramJSONObject.getInt("seq_id");
      if (k != this.f)
      {
        g.c("parseJSON error seq is wrong seq=" + k + ",right = " + this.f);
        this.a.b(10030);
        return;
      }
      this.a.c();
      return;
    }
    g.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGeneralVryMobileCode
 * JD-Core Version:    0.7.0.1
 */