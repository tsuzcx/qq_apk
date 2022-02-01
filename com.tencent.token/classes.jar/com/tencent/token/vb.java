package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.bean.EvalAccountResult;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class vb
  extends tj
{
  EvalAccountResult d;
  private long e;
  private int f;
  
  public final String a()
  {
    rz.a();
    StringBuilder localStringBuilder = new StringBuilder("account page generateUrl sessId =");
    localStringBuilder.append(null);
    xa.c(localStringBuilder.toString());
    this.a.a(104, null, null);
    localStringBuilder = new StringBuilder("account page generateUrl sessId =");
    localStringBuilder.append(null);
    xa.c(localStringBuilder.toString());
    return null;
  }
  
  public final void a(aaq paramaaq)
  {
    this.e = ((Long)paramaaq.c.get("param.uinhash")).longValue();
    paramaaq = new StringBuilder("account page ProtoGetEvalAccountResult unpacketParams: user =");
    paramaaq.append(this.e);
    xa.c(paramaaq.toString());
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = aac.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      i = paramJSONObject.getInt("seq_id");
      if (i != this.f)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i);
        paramJSONObject.append(",right = ");
        sa.a();
        paramJSONObject.append(sa.b());
        xa.c(paramJSONObject.toString());
        return;
      }
      this.d = new EvalAccountResult(paramJSONObject.getJSONObject("result"), paramJSONObject);
      this.a.a = 0;
      return;
    }
    xa.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493068));
  }
  
  public final void b()
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
 * Qualified Name:     com.tencent.token.vb
 * JD-Core Version:    0.7.0.1
 */