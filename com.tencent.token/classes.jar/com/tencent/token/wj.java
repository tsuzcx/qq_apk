package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import java.io.Serializable;
import org.json.JSONObject;

public final class wj
  extends ud
{
  private String d;
  
  public final abn a(Serializable paramSerializable)
  {
    abn localabn = new abn();
    localabn.a = paramSerializable;
    return localabn;
  }
  
  public final Serializable a(abn paramabn)
  {
    return (String)paramabn.a;
  }
  
  public final String a()
  {
    st.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abm paramabm) {}
  
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
      abn localabn = new abn();
      localabn.a = paramJSONObject.toString();
      RqdApplication.m().a(this, localabn);
      this.d = paramJSONObject.getJSONObject("data").toString();
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
 * Qualified Name:     com.tencent.token.wj
 * JD-Core Version:    0.7.0.1
 */