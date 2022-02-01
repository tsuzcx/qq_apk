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
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoVryCaptcha
  extends d
{
  private long d;
  private long e;
  private String f;
  private String g;
  private String h = "";
  private int i;
  
  public static void a(do paramdo, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    paramdo.c.put("param.realuin", Long.valueOf(paramLong));
    paramdo.c.put("param.scene.id", Integer.valueOf(paramInt));
    paramdo.c.put("param.scene.id", Integer.valueOf(paramInt));
    paramdo.c.put("param.ticket", paramString1);
    paramdo.c.put("param.randstr", paramString2);
  }
  
  protected String a()
  {
    String str = ca.a().b();
    Object localObject1 = null;
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("uin", this.d);
      int j = cb.a + 1;
      cb.a = j;
      this.i = j;
      ((JSONObject)localObject2).put("seq_id", this.i);
      ((JSONObject)localObject2).put("op_time", cc.c().s() / 1000L);
      ((JSONObject)localObject2).put("scenario_id", this.e);
      ((JSONObject)localObject2).put("ticket", this.f);
      ((JSONObject)localObject2).put("randstr", this.g);
      localObject2 = ((JSONObject)localObject2).toString();
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("plain:");
      localStringBuilder2.append((String)localObject2);
      g.a(localStringBuilder2.toString());
      localObject2 = l.b(((String)localObject2).getBytes());
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("JSONException:");
      localStringBuilder2.append(localJSONException.getMessage());
      g.c(localStringBuilder2.toString());
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("?aq_base_sid=");
    localStringBuilder1.append(str);
    localStringBuilder1.append("&data=");
    localStringBuilder1.append((String)localObject1);
    localObject1 = localStringBuilder1.toString();
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("params: ");
    localStringBuilder1.append((String)localObject1);
    g.c(localStringBuilder1.toString());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(c.e());
    localStringBuilder1.append("/cn/mbtoken3/mbtoken3_verify_captcha_v3");
    localStringBuilder1.append((String)localObject1);
    return localStringBuilder1.toString();
  }
  
  protected void a(do paramdo)
  {
    this.d = ((Long)paramdo.c.get("param.realuin")).longValue();
    this.e = ((Integer)paramdo.c.get("param.scene.id")).intValue();
    this.f = ((String)paramdo.c.get("param.ticket"));
    this.g = ((String)paramdo.c.get("param.randstr"));
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int j = paramJSONObject.getInt("err");
    if (j != 0)
    {
      a(j, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      j = paramJSONObject.getInt("seq_id");
      if (j != this.i)
      {
        this.a.b(10030);
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("parseJSON error seq is wrong seq=");
        paramJSONObject.append(j);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(cb.a().b());
        g.c(paramJSONObject.toString());
        return;
      }
      if (this.e == 5L) {
        this.h = paramJSONObject.getString("captcha_sig");
      }
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
      localMessage.obj = this.h;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoVryCaptcha
 * JD-Core Version:    0.7.0.1
 */