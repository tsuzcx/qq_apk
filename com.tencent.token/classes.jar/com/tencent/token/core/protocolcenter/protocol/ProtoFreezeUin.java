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

public class ProtoFreezeUin
  extends d
{
  private final String d = "/cn/mbtoken3/mbtoken3_freeze_action";
  private long e;
  private int f;
  private int g;
  private String h;
  private int i = -1;
  private int j;
  
  public static void a(do paramdo, long paramLong, int paramInt, String paramString)
  {
    paramdo.c.put("param.uinhash", Long.valueOf(paramLong));
    paramdo.c.put("param.wtlogin.a2", paramString);
    paramdo.c.put("param.factor.type", Integer.valueOf(paramInt));
  }
  
  protected String a()
  {
    String str = ca.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    int k = cb.a + 1;
    cb.a = k;
    this.f = k;
    Object localObject = l.a(new Object[] { "uin", Long.valueOf(this.e), "seq_id", Integer.valueOf(this.f), "op_time", Long.valueOf(cc.c().s() / 1000L), "a2_sign", this.h, "sign_qq", Integer.valueOf(this.g) });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?aq_base_sid=");
    localStringBuilder.append(str);
    localStringBuilder.append("&data=");
    localStringBuilder.append((String)localObject);
    str = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c.e());
    ((StringBuilder)localObject).append("/cn/mbtoken3/mbtoken3_freeze_action");
    ((StringBuilder)localObject).append(str);
    return ((StringBuilder)localObject).toString();
  }
  
  protected void a(do paramdo)
  {
    this.e = ((Long)paramdo.c.get("param.uinhash")).longValue();
    this.h = ((String)paramdo.c.get("param.wtlogin.a2"));
    this.g = ((Integer)paramdo.c.get("param.factor.type")).intValue();
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
      k = paramJSONObject.getInt("seq_id");
      if (k != this.f)
      {
        this.a.b(10030);
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("parseJSON error seq is wrong seq=");
        paramJSONObject.append(k);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(cb.a().b());
        g.c(paramJSONObject.toString());
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("freeze result = ");
      localStringBuilder.append(paramJSONObject);
      g.a(localStringBuilder.toString());
      try
      {
        this.i = paramJSONObject.getInt("sign_status");
        this.j = paramJSONObject.getInt("auto_melt_time");
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
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
      localMessage.arg2 = this.i;
      localMessage.obj = Integer.valueOf(this.j);
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoFreezeUin
 * JD-Core Version:    0.7.0.1
 */