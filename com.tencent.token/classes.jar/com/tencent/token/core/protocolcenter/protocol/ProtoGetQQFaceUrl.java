package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.ev;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoGetQQFaceUrl
  extends e
{
  private long d;
  private String e;
  private int f;
  
  protected String a()
  {
    Object localObject1 = null;
    String str = cv.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("uin", this.d);
      int i = cw.a + 1;
      cw.a = i;
      this.f = i;
      ((JSONObject)localObject2).put("seq_id", this.f);
      ((JSONObject)localObject2).put("op_time", cx.c().s() / 1000L);
      localObject2 = ((JSONObject)localObject2).toString();
      h.a("plain:" + (String)localObject2);
      localObject2 = w.b(((String)localObject2).getBytes());
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        h.c("JSONException:" + localJSONException.getMessage());
      }
    }
    localObject1 = "?aq_base_sid=" + str + "&data=" + (String)localObject1;
    return c.e() + "/cn/mbtoken3/mbtoken3_get_photo_v3" + (String)localObject1;
  }
  
  protected void a(ev paramev)
  {
    this.d = ((Long)paramev.c.get("param.uinhash")).longValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject.getInt("err") != 0)
    {
      this.e = null;
      return;
    }
    byte[] arrayOfByte = w.c(paramJSONObject.getString("data"));
    if (arrayOfByte != null)
    {
      int i = new JSONObject(new String(arrayOfByte)).getInt("seq_id");
      if (i != this.f)
      {
        this.a.b(10030);
        h.c("parseJSON error seq is wrong seq=" + i + ",right = " + cw.a().b());
        return;
      }
      this.e = paramJSONObject.getString("photo_url");
      return;
    }
    h.c("parseJSON error decodeData=" + arrayOfByte);
    a(10022, RqdApplication.l().getString(2131230925));
  }
  
  protected void b()
  {
    if (!this.b.e)
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
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetQQFaceUrl
 * JD-Core Version:    0.7.0.1
 */