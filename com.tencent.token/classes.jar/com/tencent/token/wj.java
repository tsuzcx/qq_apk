package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class wj
  extends tr
{
  public long d;
  private int e;
  private int f;
  
  public final String a()
  {
    sh.a();
    this.a.a(104, null, null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this);
    localStringBuilder.append("sessId null ");
    xj.c(localStringBuilder.toString());
    return null;
  }
  
  public final void a(abc paramabc)
  {
    this.d = ((Long)paramabc.c.get("param.uinhash")).longValue();
    this.e = ((Integer)paramabc.c.get("param.common.seq")).intValue();
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
      xj.a(((StringBuilder)localObject).toString());
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder("server errcode=");
      localStringBuilder.append(i);
      localStringBuilder.append(":");
      localStringBuilder.append(paramJSONObject);
      ((xh)localObject).a(i, localStringBuilder.toString(), paramJSONObject);
      return;
    }
    paramJSONObject = aao.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append("--data:");
      ((StringBuilder)localObject).append(new String(paramJSONObject));
      xj.a(((StringBuilder)localObject).toString());
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
        xj.c(((StringBuilder)localObject).toString());
        return;
      }
      this.f = paramJSONObject.optInt("config_val");
      this.a.a = 0;
      return;
    }
    xj.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.p().getString(2131493068));
  }
  
  public final void b()
  {
    if ((!this.b.e) && (this.b.d != null))
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.arg2 = this.f;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.wj
 * JD-Core Version:    0.7.0.1
 */