package com.tencent.token.core.protocolcenter.protocol;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.ev;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.utils.w;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoQryBindNotifyMsg
  extends e
{
  private b d;
  
  protected String a()
  {
    String str = cv.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject1 = "";
    try
    {
      Object localObject2 = new JSONObject();
      int i = cw.a + 1;
      cw.a = i;
      this.c = i;
      ((JSONObject)localObject2).put("seq_id", this.c);
      ((JSONObject)localObject2).put("op_time", (int)(cx.c().s() / 1000L));
      localObject2 = w.b(((JSONObject)localObject2).toString().getBytes());
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    localObject1 = "?aq_base_sid=" + str + "&data=" + (String)localObject1;
    return c.e() + "/cn/mbtoken3/mbtoken3_qry_bind_notify_msg_encrypt" + (String)localObject1;
  }
  
  protected void a(ev paramev) {}
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0) {
      a(i, paramJSONObject.getString("info"));
    }
    do
    {
      return;
      paramJSONObject = w.c(paramJSONObject.getString("data"));
    } while (paramJSONObject == null);
    paramJSONObject = new JSONObject(new String(paramJSONObject));
    i = paramJSONObject.getInt("seq_id");
    if (this.c != i)
    {
      this.a.b(10030);
      return;
    }
    this.d = new b(this);
    this.d.a = paramJSONObject.getInt("is_have_msg");
    if (this.d.a == 1)
    {
      this.d.b = paramJSONObject.getString("content");
      this.d.c = paramJSONObject.getLong("uin");
    }
    this.a.a(this.d.b);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoQryBindNotifyMsg
 * JD-Core Version:    0.7.0.1
 */