package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class vq
  extends tr
{
  private long d;
  private String e;
  private int f;
  
  public final String a()
  {
    sh.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abc paramabc)
  {
    this.d = ((Long)paramabc.c.get("param.uinhash")).longValue();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject.getInt("err") != 0)
    {
      this.e = null;
      return;
    }
    byte[] arrayOfByte = aao.d(paramJSONObject.getString("data"));
    if (arrayOfByte != null)
    {
      int i = new JSONObject(new String(arrayOfByte)).getInt("seq_id");
      if (i != this.f)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i);
        paramJSONObject.append(",right = ");
        si.a();
        paramJSONObject.append(si.b());
        xj.c(paramJSONObject.toString());
        return;
      }
      this.e = paramJSONObject.getString("photo_url");
      return;
    }
    xj.c("parseJSON error decodeData=".concat(String.valueOf(arrayOfByte)));
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
 * Qualified Name:     com.tencent.token.vq
 * JD-Core Version:    0.7.0.1
 */