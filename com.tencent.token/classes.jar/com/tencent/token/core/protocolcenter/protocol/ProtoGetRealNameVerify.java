package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.cx;
import com.tencent.token.ev;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoGetRealNameVerify
  extends e
{
  public static String d;
  public static int e;
  private long f;
  private long g;
  private int h;
  private int i;
  
  protected String a()
  {
    String str1 = cv.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    String str2 = w.a(new Object[] { "real_uin", Long.valueOf(this.g), "seq_id", Integer.valueOf(this.h), "op_time", Long.valueOf(cx.c().s() / 1000L), "scene_id", Integer.valueOf(this.i) });
    str1 = "?uin=" + this.f + "&aq_base_sid=" + str1 + "&data=" + str2;
    return c.e() + "/cn/mbtoken3/mbtoken3_realname_lip" + str1;
  }
  
  protected void a(ev paramev)
  {
    this.f = ((Long)paramev.c.get("param.uinhash")).longValue();
    this.g = ((Long)paramev.c.get("param.realuin")).longValue();
    this.i = ((Integer)paramev.c.get("param.scene.id")).intValue();
    this.h = paramev.j;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int j = paramJSONObject.getInt("err");
    if (j == 0)
    {
      paramJSONObject = w.c(paramJSONObject.getString("data"));
      if (paramJSONObject != null)
      {
        paramJSONObject = new JSONObject(new String(paramJSONObject));
        d = paramJSONObject.getString("validate_code");
        e = paramJSONObject.getInt("validate_id");
        this.a.c();
        return;
      }
      h.c("parseJSON error decodeData=" + paramJSONObject);
      a(10022, RqdApplication.l().getString(2131230925));
      return;
    }
    a(j, paramJSONObject.getString("info"));
    h.a("ProtoGetRealNameVerify fail errCode=" + j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetRealNameVerify
 * JD-Core Version:    0.7.0.1
 */