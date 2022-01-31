package com.tencent.token.core.protocolcenter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.cv;
import com.tencent.token.cx;
import com.tencent.token.ev;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoSetServiceStatusV2
  extends e
{
  private long d;
  private int[] e;
  private int[] f;
  private String g;
  private int h;
  
  public static void a(ev paramev, long paramLong, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String paramString, int paramInt)
  {
    paramev.c.put("param.uinhash", Long.valueOf(paramLong));
    paramev.c.put("param.mbinfo.id", paramArrayOfInt1);
    paramev.c.put("param.mbinfo.val", paramArrayOfInt2);
    paramev.c.put("param.wtlogin.a2", paramString);
    paramev.c.put("param.common.seq", Integer.valueOf(paramInt));
  }
  
  protected String a()
  {
    String str = cv.a().b();
    if (str == null)
    {
      this.a.b(10000);
      return null;
    }
    Object localObject = new StringBuffer("");
    if ((this.e == null) || (this.f == null) || (this.e.length != this.f.length))
    {
      this.a.b(10000);
      return null;
    }
    int i = 0;
    while (i < this.e.length)
    {
      ((StringBuffer)localObject).append("{\"id\":" + this.e[i] + ",\"value\":" + this.f[i] + "}");
      if (i < this.e.length - 1) {
        ((StringBuffer)localObject).append(",");
      }
      i += 1;
    }
    localObject = "{\"conf_data\":[" + ((StringBuffer)localObject).toString() + "], \"A2\":\"" + this.g + "\", \"seq_id\":" + this.h + ", \"op_time\":" + (int)(cx.c().s() / 1000L) + ",\"uin\":" + this.d + "}";
    h.a((String)localObject);
    localObject = w.b(((String)localObject).getBytes());
    if (localObject == null)
    {
      this.a.b(10000);
      return null;
    }
    str = "?aq_base_sid=" + str + "&data=" + (String)localObject;
    return c.e() + "/cn/mbtoken3/mbtoken3_set_service_status_encrypt" + str;
  }
  
  protected void a(ev paramev)
  {
    this.d = ((Long)paramev.c.get("param.uinhash")).longValue();
    this.e = ((int[])paramev.c.get("param.mbinfo.id"));
    this.f = ((int[])paramev.c.get("param.mbinfo.val"));
    this.g = ((String)paramev.c.get("param.wtlogin.a2"));
    this.h = ((Integer)paramev.c.get("param.common.seq")).intValue();
  }
  
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
      h.b("ProtoSetServiceStatusV2:" + paramJSONObject);
      paramJSONObject.getLong("uin");
      if (paramJSONObject.getInt("seq_id") != this.h)
      {
        this.a.b(10030);
        return;
      }
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
      localMessage.obj = this.e;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.ProtoSetServiceStatusV2
 * JD-Core Version:    0.7.0.1
 */