package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.ca;
import com.tencent.token.cc;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import com.tencent.token.utils.m;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoQuerySpecialVerify
  extends d
{
  private long d;
  private long e;
  private int f;
  private int g;
  private long h;
  private Integer i = Integer.valueOf(1);
  private final String j = "/cn/mbtoken3/mbtoken3_qry_spec_verify";
  private final String k = "/cn/mbtoken3/mbtoken3_qry_face_verify_on_off";
  
  public static void a(do paramdo, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    paramdo.c.put("param.realuin", Long.valueOf(paramLong2));
    paramdo.c.put("param.scene_id", Integer.valueOf(paramInt1));
    paramdo.c.put("param.op_time", Long.valueOf(cc.c().s() / 1000L));
    paramdo.c.put("param.uinhash", Long.valueOf(paramLong1));
    paramdo.j = paramInt2;
  }
  
  protected String a()
  {
    String str = ca.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject = l.a(new Object[] { "real_uin", Long.valueOf(this.e), "seq_id", Integer.valueOf(this.f), "op_time", Long.valueOf(this.h), "scene_id", Integer.valueOf(this.g) });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?uin=");
    localStringBuilder.append(this.d);
    localStringBuilder.append("&aq_base_sid=");
    localStringBuilder.append(str);
    localStringBuilder.append("&data=");
    localStringBuilder.append((String)localObject);
    str = localStringBuilder.toString();
    if (m.i() == 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(c.e());
      ((StringBuilder)localObject).append("/cn/mbtoken3/mbtoken3_qry_spec_verify");
      ((StringBuilder)localObject).append(str);
      str = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(c.e());
      ((StringBuilder)localObject).append("/cn/mbtoken3/mbtoken3_qry_face_verify_on_off");
      ((StringBuilder)localObject).append(str);
      str = ((StringBuilder)localObject).toString();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("query special verify url:");
    ((StringBuilder)localObject).append(str);
    g.c(((StringBuilder)localObject).toString());
    return str;
  }
  
  protected void a(do paramdo)
  {
    this.e = ((Long)paramdo.c.get("param.realuin")).longValue();
    this.g = ((Integer)paramdo.c.get("param.scene_id")).intValue();
    this.h = ((Long)paramdo.c.get("param.op_time")).longValue();
    this.f = paramdo.j;
    this.d = ((Long)paramdo.c.get("param.uinhash")).longValue();
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
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mbtoken3_qry_face_verify_on_off ret: ");
      localStringBuilder.append(paramJSONObject);
      g.a(localStringBuilder.toString());
      m = paramJSONObject.getInt("seq_id");
      if (m != this.f)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("parseJSON error seq is wrong seq=");
        paramJSONObject.append(m);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.f);
        g.c(paramJSONObject.toString());
        this.a.b(10030);
        return;
      }
      this.i = Integer.valueOf(paramJSONObject.getInt("verify_type"));
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
      localMessage.obj = this.i;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoQuerySpecialVerify
 * JD-Core Version:    0.7.0.1
 */