package com.tencent.token;

import android.content.ContentValues;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class un
  extends tj
{
  public long d;
  public int e;
  public String f;
  private byte[] g;
  private a h;
  
  public final String a()
  {
    rz.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aaq paramaaq)
  {
    this.d = ((Long)paramaaq.c.get("param.uinhash")).longValue();
    this.e = paramaaq.j;
    this.g = ((byte[])paramaaq.c.get("param.facedata"));
    paramaaq = paramaaq.c.get("param.videopath");
    if (paramaaq != null) {
      this.f = paramaaq.toString();
    }
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    paramJSONObject = aac.d(paramJSONObject.getString("data"));
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
        xa.c(paramJSONObject.toString());
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
    xa.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493068));
  }
  
  public final aaq b(aaq paramaaq)
  {
    int i = paramaaq.j;
    paramaaq.m = 1;
    paramaaq.n = new ContentValues(3);
    Object localObject = paramaaq.n;
    rz.a();
    ((ContentValues)localObject).put("aq_base_sid", null);
    paramaaq.n.put("uin", Long.valueOf(this.d));
    localObject = zt.a(aac.c(this.g)).replace('+', '-').replace('=', '_');
    paramaaq.n.put("img_data", (String)localObject);
    paramaaq.n.put("op_time", Integer.valueOf((int)(sb.b().i() / 1000L)));
    paramaaq.n.put("seq_id", Integer.valueOf(i));
    localObject = this.f;
    if (localObject != null)
    {
      localObject = zt.a(aac.c(aad.d((String)localObject))).replace('+', '-').replace('=', '_');
      paramaaq.n.put("live_video_data", (String)localObject);
    }
    this.g = null;
    return paramaaq;
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
 * Qualified Name:     com.tencent.token.un
 * JD-Core Version:    0.7.0.1
 */