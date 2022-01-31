package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.util.HashMap;
import org.json.JSONObject;

public final class ex
  extends bm
{
  private long c;
  private int[] d;
  private int[] e;
  private String f;
  
  protected final String a()
  {
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (Object localObject1 = ax.c; localObject1 == null; localObject1 = null)
    {
      this.a.a(104, null, null);
      return null;
    }
    Object localObject2 = new StringBuffer("");
    if ((this.d == null) || (this.e == null) || (this.d.length != this.e.length))
    {
      this.a.a(10000, null, null);
      return null;
    }
    int i = 0;
    while (i < this.d.length)
    {
      ((StringBuffer)localObject2).append("{\"id\":" + this.d[i] + ",\"value\":" + this.e[i] + "}");
      if (i < this.d.length - 1) {
        ((StringBuffer)localObject2).append(",");
      }
      i += 1;
    }
    localObject2 = "{\"conf_data\":[" + ((StringBuffer)localObject2).toString() + "]}";
    e.a((String)localObject2);
    localObject2 = s.b(((String)localObject2).getBytes());
    if (localObject2 == null)
    {
      this.a.a(10000, null, null);
      return null;
    }
    localObject2 = "?uin=" + this.c + "&sess_id=" + (String)localObject1 + "&data=" + (String)localObject2;
    localObject1 = localObject2;
    if (!TextUtils.isEmpty(this.f)) {
      localObject1 = (String)localObject2 + "&skey=" + this.f;
    }
    return b.c() + "/cn/mbtoken3/mbtoken3_set_service_status" + (String)localObject1;
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ((Long)paramfs.c.get("param.uinhash")).longValue();
    this.d = ((int[])paramfs.c.get("param.mbinfo.id"));
    this.e = ((int[])paramfs.c.get("param.mbinfo.val"));
    this.f = ((String)paramfs.c.get("param.skey"));
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    long l = paramJSONObject.getLong("uin");
    int i = paramJSONObject.getInt("err");
    if (l != this.c)
    {
      this.a.a(10000, "uin not match=" + l + ":" + this.c, null);
      return;
    }
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    this.a.a = 0;
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
 * Qualified Name:     com.tencent.token.ex
 * JD-Core Version:    0.7.0.1
 */