package com.tencent.token;

import android.content.ContentValues;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class uo
  extends tk
{
  public long d;
  public int e;
  public String f;
  private byte[] g;
  private a h;
  
  public final String a()
  {
    sa.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aar paramaar)
  {
    this.d = ((Long)paramaar.c.get("param.uinhash")).longValue();
    this.e = paramaar.j;
    this.g = ((byte[])paramaar.c.get("param.facedata"));
    paramaar = paramaar.c.get("param.videopath");
    if (paramaar != null) {
      this.f = paramaar.toString();
    }
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    paramJSONObject = aad.d(paramJSONObject.getString("data"));
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
        xb.c(paramJSONObject.toString());
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
    xb.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493068));
  }
  
  public final aar b(aar paramaar)
  {
    int i = paramaar.j;
    paramaar.m = 1;
    paramaar.n = new ContentValues(3);
    Object localObject = paramaar.n;
    sa.a();
    ((ContentValues)localObject).put("aq_base_sid", null);
    paramaar.n.put("uin", Long.valueOf(this.d));
    localObject = zu.a(aad.c(this.g)).replace('+', '-').replace('=', '_');
    paramaar.n.put("img_data", (String)localObject);
    paramaar.n.put("op_time", Integer.valueOf((int)(sc.b().i() / 1000L)));
    paramaar.n.put("seq_id", Integer.valueOf(i));
    localObject = this.f;
    if (localObject != null)
    {
      localObject = zu.a(aad.c(aae.d((String)localObject))).replace('+', '-').replace('=', '_');
      paramaar.n.put("live_video_data", (String)localObject);
    }
    this.g = null;
    return paramaar;
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
 * Qualified Name:     com.tencent.token.uo
 * JD-Core Version:    0.7.0.1
 */