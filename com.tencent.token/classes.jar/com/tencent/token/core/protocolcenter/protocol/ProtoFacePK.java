package com.tencent.token.core.protocolcenter.protocol;

import android.content.ContentValues;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.cx;
import com.tencent.token.ev;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.b;
import com.tencent.token.utils.w;
import com.tencent.token.utils.x;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoFacePK
  extends e
{
  public long d;
  public int e;
  public String f;
  private byte[] g;
  private a h = new a(this);
  
  protected String a()
  {
    if (cv.a().b() == null)
    {
      this.a.b(104);
      return null;
    }
    return c.e() + "/cn/mbtoken3/mbtoken3_face_pk";
  }
  
  protected void a(ev paramev)
  {
    this.d = ((Long)paramev.c.get("param.uinhash")).longValue();
    this.e = paramev.j;
    this.g = ((byte[])paramev.c.get("param.facedata"));
    paramev = paramev.c.get("param.videopath");
    if (paramev != null) {
      this.f = paramev.toString();
    }
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    paramJSONObject = w.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      int i = paramJSONObject.getInt("seq_id");
      if (i != this.e)
      {
        this.a.b(10030);
        h.c("parseJSON error seq is wrong seq=" + i + ",right = " + this.e);
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
      this.a.c();
      return;
    }
    h.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
  
  public ev b(ev paramev)
  {
    int i = paramev.j;
    paramev.m = 1;
    paramev.n = new ContentValues(3);
    paramev.n.put("aq_base_sid", cv.a().b());
    paramev.n.put("uin", Long.valueOf(this.d));
    String str = b.a(w.c(this.g)).replace('+', '-').replace('=', '_');
    paramev.n.put("img_data", str);
    paramev.n.put("op_time", Integer.valueOf((int)(cx.c().s() / 1000L)));
    paramev.n.put("seq_id", Integer.valueOf(i));
    if (this.f != null)
    {
      str = b.a(w.c(x.a(this.f))).replace('+', '-').replace('=', '_');
      paramev.n.put("live_video_data", str);
    }
    this.g = null;
    return paramev;
  }
  
  protected void b()
  {
    if (!this.b.e)
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.obj = this.h;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoFacePK
 * JD-Core Version:    0.7.0.1
 */