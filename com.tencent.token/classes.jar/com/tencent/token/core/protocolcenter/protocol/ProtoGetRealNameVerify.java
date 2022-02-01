package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.bz;
import com.tencent.token.cb;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dn;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoGetRealNameVerify
  extends d
{
  public static String d;
  public static int e;
  private long f;
  private long g;
  private int h;
  private int i;
  
  protected String a()
  {
    String str1 = bz.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    String str2 = l.a(new Object[] { "real_uin", Long.valueOf(this.g), "seq_id", Integer.valueOf(this.h), "op_time", Long.valueOf(cb.c().s() / 1000L), "scene_id", Integer.valueOf(this.i) });
    str1 = "?uin=" + this.f + "&aq_base_sid=" + str1 + "&data=" + str2;
    return c.e() + "/cn/mbtoken3/mbtoken3_realname_lip" + str1;
  }
  
  protected void a(dn paramdn)
  {
    this.f = ((Long)paramdn.c.get("param.uinhash")).longValue();
    this.g = ((Long)paramdn.c.get("param.realuin")).longValue();
    this.i = ((Integer)paramdn.c.get("param.scene.id")).intValue();
    this.h = paramdn.j;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int j = paramJSONObject.getInt("err");
    if (j == 0)
    {
      paramJSONObject = l.c(paramJSONObject.getString("data"));
      if (paramJSONObject != null)
      {
        paramJSONObject = new JSONObject(new String(paramJSONObject));
        d = paramJSONObject.getString("validate_code");
        e = paramJSONObject.getInt("validate_id");
        this.a.c();
        return;
      }
      g.c("parseJSON error decodeData=" + paramJSONObject);
      a(10022, RqdApplication.l().getString(2131230925));
      return;
    }
    a(j, paramJSONObject.getString("info"));
    g.a("ProtoGetRealNameVerify fail errCode=" + j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetRealNameVerify
 * JD-Core Version:    0.7.0.1
 */