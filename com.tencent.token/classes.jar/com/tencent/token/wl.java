package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class wl
  extends tk
{
  private long d;
  private long e;
  private String f;
  private String g;
  private String h;
  private int i;
  
  public final String a()
  {
    sa.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aar paramaar)
  {
    this.d = ((Long)paramaar.c.get("param.realuin")).longValue();
    this.e = ((Integer)paramaar.c.get("param.scene.id")).intValue();
    this.f = ((String)paramaar.c.get("param.ticket"));
    this.g = ((String)paramaar.c.get("param.randstr"));
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int j = paramJSONObject.getInt("err");
    if (j != 0)
    {
      a(j, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = aad.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      j = paramJSONObject.getInt("seq_id");
      if (j != this.i)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(j);
        paramJSONObject.append(",right = ");
        sb.a();
        paramJSONObject.append(sb.b());
        xb.c(paramJSONObject.toString());
        return;
      }
      if (this.e == 5L) {
        this.h = paramJSONObject.getString("captcha_sig");
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
      localMessage.obj = this.h;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.wl
 * JD-Core Version:    0.7.0.1
 */