package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.ca;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dd;
import com.tencent.token.dd.a;
import com.tencent.token.do;
import com.tencent.token.dp;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.io.Serializable;
import org.json.JSONObject;

public class ProtoGetStrConfig
  extends d
{
  private String d;
  
  private dp e()
  {
    dd.a locala = RqdApplication.k().a(this);
    if (locala == null) {
      return null;
    }
    return locala.b;
  }
  
  public static void e(do paramdo) {}
  
  public dp a(Serializable paramSerializable)
  {
    dp localdp = new dp();
    localdp.a = paramSerializable;
    return localdp;
  }
  
  public Serializable a(dp paramdp)
  {
    return (String)paramdp.a;
  }
  
  protected String a()
  {
    String str = ca.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    str = "?aq_base_sid=" + str;
    return c.e() + "/cn/mbtoken3/mbtoken3_get_key_value_conf_v2" + str;
  }
  
  protected void a(do paramdo) {}
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      dp localdp = new dp();
      localdp.a = paramJSONObject.toString();
      RqdApplication.k().a(this, localdp, null);
      this.d = paramJSONObject.getJSONObject("data").toString();
      this.a.c();
      return;
    }
    g.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
  
  protected void b()
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
  
  public dp d(do paramdo)
  {
    return e();
  }
  
  public String d()
  {
    return getClass().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetStrConfig
 * JD-Core Version:    0.7.0.1
 */