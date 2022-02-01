package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class uy
  extends tk
{
  public byte[] d;
  public long e;
  public DeterminVerifyFactorsResult f;
  private int g;
  private int h;
  private int i;
  
  public final String a()
  {
    xb.c("upgrade url: ");
    sa.a();
    this.a.a(104, null, null);
    xb.c("upgrade url: ");
    return null;
  }
  
  public final void a(aar paramaar)
  {
    this.e = ((Long)paramaar.c.get("param.realuin")).longValue();
    this.d = ((byte[])paramaar.c.get("param.wtlogin.a2"));
    this.g = ((Integer)paramaar.c.get("param.common.seq")).intValue();
    this.h = ((Integer)paramaar.c.get("param.wtlogin.type")).intValue();
    this.i = ((Integer)paramaar.c.get("param.scene_id")).intValue();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int j = paramJSONObject.getInt("err");
    Object localObject;
    if (j != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      localObject = new StringBuilder("error");
      ((StringBuilder)localObject).append(paramJSONObject);
      ((StringBuilder)localObject).append(",error code =");
      ((StringBuilder)localObject).append(j);
      xb.a(((StringBuilder)localObject).toString());
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder("server errcode=");
      localStringBuilder.append(j);
      localStringBuilder.append(":");
      localStringBuilder.append(paramJSONObject);
      ((wz)localObject).a(j, localStringBuilder.toString(), paramJSONObject);
      return;
    }
    paramJSONObject = aad.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      xb.c("mbtoken3_determine_verify_factors=".concat(String.valueOf(paramJSONObject)));
      if (paramJSONObject.getInt("seq_id") != this.g)
      {
        this.a.a(10030, null, null);
        localObject = new StringBuilder("parseJSON error seq is wrong seq=");
        ((StringBuilder)localObject).append(paramJSONObject.getInt("seq_id"));
        ((StringBuilder)localObject).append(",right = ");
        ((StringBuilder)localObject).append(this.g);
        xb.c(((StringBuilder)localObject).toString());
        return;
      }
      long l = paramJSONObject.getLong("uin");
      if (this.e != l)
      {
        paramJSONObject = this.a;
        localObject = new StringBuilder("uin not match ");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(l);
        paramJSONObject.a(10000, ((StringBuilder)localObject).toString(), null);
        return;
      }
      this.f = new DeterminVerifyFactorsResult(paramJSONObject);
      try
      {
        l = paramJSONObject.getLong("server_time");
        sc.b();
        sc.a(l);
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      this.a.a = 0;
      return;
    }
    xb.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493068));
  }
  
  public final void b()
  {
    if ((!this.b.e) && (this.b.d != null))
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.f;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.uy
 * JD-Core Version:    0.7.0.1
 */