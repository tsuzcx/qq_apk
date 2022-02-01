package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import java.io.Serializable;
import org.json.JSONObject;

public final class vx
  extends tr
{
  private String d;
  
  public final abd a(Serializable paramSerializable)
  {
    abd localabd = new abd();
    localabd.a = paramSerializable;
    return localabd;
  }
  
  public final Serializable a(abd paramabd)
  {
    return (String)paramabd.a;
  }
  
  public final String a()
  {
    sh.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abc paramabc) {}
  
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
      abd localabd = new abd();
      localabd.a = paramJSONObject.toString();
      RqdApplication.o().a(this, localabd);
      this.d = paramJSONObject.getJSONObject("data").toString();
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
      localMessage.obj = this.d;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
  
  public final String c()
  {
    return "pgscgj";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.vx
 * JD-Core Version:    0.7.0.1
 */