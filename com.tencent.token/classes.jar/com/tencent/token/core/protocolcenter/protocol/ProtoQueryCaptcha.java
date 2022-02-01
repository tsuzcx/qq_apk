package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.ca;
import com.tencent.token.core.bean.QueryCaptchaResult;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoQueryCaptcha
  extends d
{
  public QueryCaptchaResult d;
  private long e;
  private int f;
  
  public static void a(do paramdo, long paramLong, int paramInt)
  {
    paramdo.c.put("param.realuin", Long.valueOf(paramLong));
    paramdo.c.put("param.scene.id", Integer.valueOf(paramInt));
  }
  
  protected String a()
  {
    String str1 = ca.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    String str2 = l.a(new Object[] { "uin", Long.valueOf(this.e), "scenario_id", Integer.valueOf(this.f) });
    if (str2 == null)
    {
      this.a.a(10000, "encrypt  failed");
      return null;
    }
    str1 = "?data=" + str2 + "&aq_base_sid=" + str1;
    g.c("params: " + str1);
    return c.e() + "/cn/mbtoken3/mbtoken3_query_captcha_v3" + str1;
  }
  
  protected void a(do paramdo)
  {
    this.e = ((Long)paramdo.c.get("param.realuin")).longValue();
    this.f = ((Integer)paramdo.c.get("param.scene.id")).intValue();
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
      this.d = new QueryCaptchaResult(new JSONObject(new String(paramJSONObject)));
      this.d.mRealUin = this.e;
      this.d.mSceneId = this.f;
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
      localMessage.obj = this.d;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoQueryCaptcha
 * JD-Core Version:    0.7.0.1
 */