package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class vr
  extends ud
{
  public byte[] d;
  public long e;
  public DeterminVerifyFactorsResult f;
  private int g;
  private int h;
  private int i;
  
  public final String a()
  {
    xv.c("upgrade url: ");
    st.a();
    this.a.a(104, null, null);
    xv.c("upgrade url: ");
    return null;
  }
  
  public final void a(abm paramabm)
  {
    this.e = ((Long)paramabm.c.get("param.realuin")).longValue();
    this.d = ((byte[])paramabm.c.get("param.wtlogin.a2"));
    this.g = ((Integer)paramabm.c.get("param.common.seq")).intValue();
    this.h = ((Integer)paramabm.c.get("param.wtlogin.type")).intValue();
    this.i = ((Integer)paramabm.c.get("param.scene_id")).intValue();
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
      xv.a(((StringBuilder)localObject).toString());
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder("server errcode=");
      localStringBuilder.append(j);
      localStringBuilder.append(":");
      localStringBuilder.append(paramJSONObject);
      ((xt)localObject).a(j, localStringBuilder.toString(), paramJSONObject);
      return;
    }
    paramJSONObject = aay.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      xv.c("mbtoken3_determine_verify_factors=".concat(String.valueOf(paramJSONObject)));
      if (paramJSONObject.getInt("seq_id") != this.g)
      {
        this.a.a(10030, null, null);
        localObject = new StringBuilder("parseJSON error seq is wrong seq=");
        ((StringBuilder)localObject).append(paramJSONObject.getInt("seq_id"));
        ((StringBuilder)localObject).append(",right = ");
        ((StringBuilder)localObject).append(this.g);
        xv.c(((StringBuilder)localObject).toString());
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
        sv.b();
        sv.a(l);
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      this.a.a = 0;
      return;
    }
    xv.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493069));
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
 * Qualified Name:     com.tencent.token.vr
 * JD-Core Version:    0.7.0.1
 */