package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import java.io.Serializable;
import org.json.JSONObject;

public final class ee
  extends bm
{
  private String c;
  
  public final ft a(Serializable paramSerializable)
  {
    ft localft = new ft();
    localft.a = paramSerializable;
    return localft;
  }
  
  public final Serializable a(ft paramft)
  {
    return (String)paramft.a;
  }
  
  protected final String a()
  {
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str = ax.c; str == null; str = null)
    {
      this.a.a(104, null, null);
      return null;
    }
    str = "?aq_base_sid=" + str;
    return b.c() + "/cn/mbtoken3/mbtoken3_get_key_value_conf" + str;
  }
  
  protected final void a(fs paramfs) {}
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    ft localft = new ft();
    localft.a = paramJSONObject.toString();
    RqdApplication.h().a(this, localft);
    this.c = paramJSONObject.getJSONObject("data").toString();
    this.a.a = 0;
  }
  
  protected final void b()
  {
    if (!this.b.e)
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.c;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
  
  public final ft c()
  {
    fe localfe = RqdApplication.h().a(this);
    if (localfe == null) {
      return null;
    }
    return localfe.b;
  }
  
  public final String d()
  {
    return getClass().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ee
 * JD-Core Version:    0.7.0.1
 */