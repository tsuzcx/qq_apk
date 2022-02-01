package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.bean.LoginProtectResult;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class vx
  extends ud
{
  private long d;
  private LoginProtectResult e;
  private String f;
  private int g;
  
  public final String a()
  {
    st.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abm paramabm)
  {
    this.d = ((Long)paramabm.c.get("param.uinhash")).longValue();
    this.f = ((String)paramabm.c.get("param.wtlogin.a2"));
    this.g = ((Integer)paramabm.c.get("param.common.seq")).intValue();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = aay.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      xv.a("login protect: ".concat(String.valueOf(paramJSONObject)));
      if (paramJSONObject.getInt("seq_id") != this.g)
      {
        this.a.a(10030, null, null);
        StringBuilder localStringBuilder = new StringBuilder("parseJSON error seq is wrong seq=");
        localStringBuilder.append(paramJSONObject.getInt("seq_id"));
        localStringBuilder.append(",right = ");
        localStringBuilder.append(this.g);
        xv.c(localStringBuilder.toString());
        return;
      }
      this.e = new LoginProtectResult(paramJSONObject);
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
      localMessage.obj = this.e;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.vx
 * JD-Core Version:    0.7.0.1
 */