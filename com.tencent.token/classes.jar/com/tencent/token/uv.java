package com.tencent.token;

import android.content.ContentValues;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class uv
  extends tr
{
  public long d;
  public int e;
  public String f;
  private byte[] g;
  private a h;
  
  public final String a()
  {
    sh.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abc paramabc)
  {
    this.d = ((Long)paramabc.c.get("param.uinhash")).longValue();
    this.e = paramabc.j;
    this.g = ((byte[])paramabc.c.get("param.facedata"));
    paramabc = paramabc.c.get("param.videopath");
    if (paramabc != null) {
      this.f = paramabc.toString();
    }
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    paramJSONObject = aao.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      int i = paramJSONObject.getInt("seq_id");
      if (i != this.e)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.e);
        xj.c(paramJSONObject.toString());
        return;
      }
      i = paramJSONObject.getInt("err");
      if (i != 0)
      {
        a(i, paramJSONObject.getString("info"));
        return;
      }
      this.h.a = paramJSONObject.getString("share_page_url");
      this.h.c = paramJSONObject.getString("share_desc");
      this.h.b = paramJSONObject.getString("share_title");
      this.a.a = 0;
      return;
    }
    xj.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.p().getString(2131493068));
  }
  
  public final abc b(abc paramabc)
  {
    int i = paramabc.j;
    paramabc.m = 1;
    paramabc.n = new ContentValues(3);
    Object localObject = paramabc.n;
    sh.a();
    ((ContentValues)localObject).put("aq_base_sid", null);
    paramabc.n.put("uin", Long.valueOf(this.d));
    localObject = aaf.a(aao.c(this.g)).replace('+', '-').replace('=', '_');
    paramabc.n.put("img_data", (String)localObject);
    paramabc.n.put("op_time", Integer.valueOf((int)(sj.b().i() / 1000L)));
    paramabc.n.put("seq_id", Integer.valueOf(i));
    localObject = this.f;
    if (localObject != null)
    {
      localObject = aaf.a(aao.c(aap.d((String)localObject))).replace('+', '-').replace('=', '_');
      paramabc.n.put("live_video_data", (String)localObject);
    }
    this.g = null;
    return paramabc;
  }
  
  public final void b()
  {
    if ((!this.b.e) && (this.b.d != null))
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.obj = this.h;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
  
  public final class a
  {
    public String a;
    public String b;
    public String c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.uv
 * JD-Core Version:    0.7.0.1
 */