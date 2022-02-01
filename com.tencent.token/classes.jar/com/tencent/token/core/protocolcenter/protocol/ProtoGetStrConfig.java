package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.cb;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.de;
import com.tencent.token.de.a;
import com.tencent.token.dp;
import com.tencent.token.dq;
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
  
  private dq e()
  {
    de.a locala = RqdApplication.m().a(this);
    if (locala == null) {
      return null;
    }
    return locala.b;
  }
  
  public static void e(dp paramdp) {}
  
  public dq a(Serializable paramSerializable)
  {
    dq localdq = new dq();
    localdq.a = paramSerializable;
    return localdq;
  }
  
  public Serializable a(dq paramdq)
  {
    return (String)paramdq.a;
  }
  
  protected String a()
  {
    String str = cb.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?aq_base_sid=");
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(c.e());
    localStringBuilder.append("/cn/mbtoken3/mbtoken3_get_key_value_conf_v2");
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  protected void a(dp paramdp) {}
  
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
      localObject = new dq();
      ((dq)localObject).a = paramJSONObject.toString();
      RqdApplication.m().a(this, (dq)localObject, null);
      this.d = paramJSONObject.getJSONObject("data").toString();
      this.a.c();
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("parseJSON error decodeData=");
    ((StringBuilder)localObject).append(paramJSONObject);
    g.c(((StringBuilder)localObject).toString());
    a(10022, RqdApplication.n().getString(2131493068));
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
  
  public dq d(dp paramdp)
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