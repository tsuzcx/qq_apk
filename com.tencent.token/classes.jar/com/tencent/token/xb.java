package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class xb
  extends ud
{
  public long d;
  private int e;
  private int f;
  private int g;
  
  public final String a()
  {
    st.a();
    this.a.a(104, null, null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this);
    localStringBuilder.append("sessId null ");
    xv.c(localStringBuilder.toString());
    return null;
  }
  
  public final void a(abm paramabm)
  {
    this.d = ((Long)paramabm.c.get("param.uinhash")).longValue();
    this.e = ((Integer)paramabm.c.get("param.common.seq")).intValue();
    this.f = ((Integer)paramabm.c.get("param.set_supercode")).intValue();
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
      xv.a(((StringBuilder)localObject).toString());
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder("server errcode=");
      localStringBuilder.append(i);
      localStringBuilder.append(":");
      localStringBuilder.append(paramJSONObject);
      ((xt)localObject).a(i, localStringBuilder.toString(), paramJSONObject);
      return;
    }
    paramJSONObject = aay.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append("--data:");
      ((StringBuilder)localObject).append(new String(paramJSONObject));
      xv.a(((StringBuilder)localObject).toString());
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
        xv.c(((StringBuilder)localObject).toString());
        return;
      }
      this.g = paramJSONObject.optInt("config_val_ret");
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
      localMessage.arg2 = this.g;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.xb
 * JD-Core Version:    0.7.0.1
 */