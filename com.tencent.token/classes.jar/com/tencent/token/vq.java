package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import java.io.Serializable;
import org.json.JSONObject;

public final class vq
  extends tk
{
  private String d;
  
  public final aas a(Serializable paramSerializable)
  {
    aas localaas = new aas();
    localaas.a = paramSerializable;
    return localaas;
  }
  
  public final Serializable a(aas paramaas)
  {
    return (String)paramaas.a;
  }
  
  public final String a()
  {
    sa.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aar paramaar) {}
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = aad.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      aas localaas = new aas();
      localaas.a = paramJSONObject.toString();
      RqdApplication.m().a(this, localaas);
      this.d = paramJSONObject.getJSONObject("data").toString();
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
 * Qualified Name:     com.tencent.token.vq
 * JD-Core Version:    0.7.0.1
 */