package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.bean.LoginProtectResult;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class vl
  extends tr
{
  private long d;
  private LoginProtectResult e;
  private String f;
  private int g;
  
  public final String a()
  {
    sh.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abc paramabc)
  {
    this.d = ((Long)paramabc.c.get("param.uinhash")).longValue();
    this.f = ((String)paramabc.c.get("param.wtlogin.a2"));
    this.g = ((Integer)paramabc.c.get("param.common.seq")).intValue();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = aao.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      xj.a("login protect: ".concat(String.valueOf(paramJSONObject)));
      if (paramJSONObject.getInt("seq_id") != this.g)
      {
        this.a.a(10030, null, null);
        StringBuilder localStringBuilder = new StringBuilder("parseJSON error seq is wrong seq=");
        localStringBuilder.append(paramJSONObject.getInt("seq_id"));
        localStringBuilder.append(",right = ");
        localStringBuilder.append(this.g);
        xj.c(localStringBuilder.toString());
        return;
      }
      this.e = new LoginProtectResult(paramJSONObject);
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
      localMessage.obj = this.e;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.vl
 * JD-Core Version:    0.7.0.1
 */