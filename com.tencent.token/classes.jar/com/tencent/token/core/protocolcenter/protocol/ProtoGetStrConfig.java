package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.eg;
import com.tencent.token.eh;
import com.tencent.token.ev;
import com.tencent.token.ew;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.io.Serializable;
import org.json.JSONObject;

public class ProtoGetStrConfig
  extends e
{
  private String d;
  
  private ew e()
  {
    eh localeh = RqdApplication.k().a(this);
    if (localeh == null) {
      return null;
    }
    return localeh.b;
  }
  
  public static void e(ev paramev) {}
  
  public ew a(Serializable paramSerializable)
  {
    ew localew = new ew();
    localew.a = paramSerializable;
    return localew;
  }
  
  public Serializable a(ew paramew)
  {
    return (String)paramew.a;
  }
  
  protected String a()
  {
    String str = cv.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    str = "?aq_base_sid=" + str;
    return c.e() + "/cn/mbtoken3/mbtoken3_get_key_value_conf_v2" + str;
  }
  
  protected void a(ev paramev) {}
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = w.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      ew localew = new ew();
      localew.a = paramJSONObject.toString();
      RqdApplication.k().a(this, localew, null);
      this.d = paramJSONObject.getJSONObject("data").toString();
      this.a.c();
      return;
    }
    h.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
  
  protected void b()
  {
    if (!this.b.e)
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.d;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
  
  public ew d(ev paramev)
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