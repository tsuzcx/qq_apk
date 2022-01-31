package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.util.HashMap;
import org.json.JSONObject;

public final class bl
  extends bm
{
  private long c;
  private int[] d;
  private int[] e;
  private String f;
  private int g;
  
  protected final String a()
  {
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str = ax.c; str == null; str = null)
    {
      this.a.a(10000, null, null);
      return null;
    }
    Object localObject = new StringBuffer("");
    if ((this.d == null) || (this.e == null) || (this.d.length != this.e.length))
    {
      this.a.a(10000, null, null);
      return null;
    }
    int i = 0;
    while (i < this.d.length)
    {
      ((StringBuffer)localObject).append("{\"id\":" + this.d[i] + ",\"value\":" + this.e[i] + "}");
      if (i < this.d.length - 1) {
        ((StringBuffer)localObject).append(",");
      }
      i += 1;
    }
    localObject = "{\"conf_data\":[" + ((StringBuffer)localObject).toString() + "]" + ", \"A2\":\"" + this.f + "\", \"seq_id\":" + this.g + ", \"op_time\":" + (int)(ag.c().r() / 1000L) + "}";
    e.a((String)localObject);
    localObject = s.b(((String)localObject).getBytes());
    if (localObject == null)
    {
      this.a.a(10000, null, null);
      return null;
    }
    str = "?uin=" + this.c + "&sess_id=" + str + "&data=" + (String)localObject;
    return b.c() + "/cn/mbtoken3/mbtoken3_set_service_status_v2" + str;
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ((Long)paramfs.c.get("param.uinhash")).longValue();
    this.d = ((int[])paramfs.c.get("param.mbinfo.id"));
    this.e = ((int[])paramfs.c.get("param.mbinfo.val"));
    this.f = ((String)paramfs.c.get("param.wtlogin.a2"));
    this.g = ((Integer)paramfs.c.get("param.common.seq")).intValue();
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    paramJSONObject = s.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      e.b("ProtoSetServiceStatusV2:" + paramJSONObject);
      int i = paramJSONObject.getInt("err");
      if (i != 0)
      {
        a(i, paramJSONObject.getString("info"));
        return;
      }
      long l = paramJSONObject.getLong("uin");
      if (paramJSONObject.getInt("seq_id") != this.g)
      {
        this.a.a(10000, "uin not match=" + l + ":" + this.c, null);
        return;
      }
      this.a.a = 0;
      return;
    }
    e.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.i().getString(2131361799));
  }
  
  protected final void b()
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
 * Qualified Name:     com.tencent.token.bl
 * JD-Core Version:    0.7.0.1
 */