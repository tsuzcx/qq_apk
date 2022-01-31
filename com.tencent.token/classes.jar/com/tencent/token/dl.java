package com.tencent.token;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class dl
  extends bm
{
  private long c;
  private Bundle d;
  private int e;
  private int f;
  private int g;
  private String h;
  private String i;
  private long j;
  private long k;
  
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
    str = "?uin=" + this.c + "&aq_base_sid=" + str + "&role_id=" + this.e + "&role_name=" + URLEncoder.encode(this.h) + "&area_id=" + this.f + "&world_id=" + this.g + "&world_name=" + URLEncoder.encode(this.i) + "&last_login_time=" + this.j / 1000L + "&stolen_time=" + this.k / 1000L;
    str = b.c() + "/cn/mbtoken3/mbtoken3_jl_appeal" + str;
    e.b(str);
    return str;
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ((Long)paramfs.c.get("param.uinhash")).longValue();
    this.e = ((Integer)paramfs.c.get("param.jl_roleid")).intValue();
    this.h = ((String)paramfs.c.get("param.jl_rolename"));
    this.f = ((Integer)paramfs.c.get("param.jl_zoneid")).intValue();
    this.g = ((Integer)paramfs.c.get("param.jl_serverid")).intValue();
    this.i = ((String)paramfs.c.get("param.jl_servername"));
    this.j = ((Long)paramfs.c.get("param.jl_lastlogintime")).longValue();
    this.k = ((Long)paramfs.c.get("param.jl_stealtime")).longValue();
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int m = paramJSONObject.getInt("err");
    if (m != 0)
    {
      a(m, paramJSONObject.getString("info"));
      return;
    }
    this.d = new Bundle();
    m = paramJSONObject.getInt("result");
    String str = paramJSONObject.getString("title");
    paramJSONObject = paramJSONObject.getString("desc");
    e.b("submit return result" + m + ",title =" + str + ",desc =" + paramJSONObject);
    this.d.putInt("result", m);
    this.d.putString("title", str);
    this.d.putString("desc", paramJSONObject);
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
 * Qualified Name:     com.tencent.token.dl
 * JD-Core Version:    0.7.0.1
 */