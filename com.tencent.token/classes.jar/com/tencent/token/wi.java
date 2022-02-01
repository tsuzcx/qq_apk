package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class wi
  extends tk
{
  public long d;
  private int e;
  private int f;
  private int g;
  
  public final String a()
  {
    sa.a();
    this.a.a(104, null, null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this);
    localStringBuilder.append("sessId null ");
    xb.c(localStringBuilder.toString());
    return null;
  }
  
  public final void a(aar paramaar)
  {
    this.d = ((Long)paramaar.c.get("param.uinhash")).longValue();
    this.e = ((Integer)paramaar.c.get("param.common.seq")).intValue();
    this.f = ((Integer)paramaar.c.get("param.set_supercode")).intValue();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    Object localObject;
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      localObject = new StringBuilder("error");
      ((StringBuilder)localObject).append(paramJSONObject);
      ((StringBuilder)localObject).append(",error code =");
      ((StringBuilder)localObject).append(i);
      xb.a(((StringBuilder)localObject).toString());
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder("server errcode=");
      localStringBuilder.append(i);
      localStringBuilder.append(":");
      localStringBuilder.append(paramJSONObject);
      ((wz)localObject).a(i, localStringBuilder.toString(), paramJSONObject);
      return;
    }
    paramJSONObject = aad.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append("--data:");
      ((StringBuilder)localObject).append(new String(paramJSONObject));
      xb.a(((StringBuilder)localObject).toString());
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      if (paramJSONObject.getInt("seq_id") != this.e)
      {
        this.a.a(10030, null, null);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append("parseJSON error seq is wrong seq=");
        ((StringBuilder)localObject).append(paramJSONObject.getInt("seq_id"));
        ((StringBuilder)localObject).append(",right = ");
        ((StringBuilder)localObject).append(this.e);
        xb.c(((StringBuilder)localObject).toString());
        return;
      }
      this.g = paramJSONObject.optInt("config_val_ret");
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
      localMessage.arg2 = this.g;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.wi
 * JD-Core Version:    0.7.0.1
 */