package com.tencent.token;

import android.content.ContentValues;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;
import java.util.HashMap;
import org.json.JSONObject;

public final class cw
  extends bm
{
  public long c;
  public int d;
  public String e;
  private byte[] f;
  private cx g = new cx(this);
  
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
    return com.tencent.token.global.b.c() + "/cn/mbtoken3/mbtoken3_face_pk";
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ((Long)paramfs.c.get("param.uinhash")).longValue();
    this.d = paramfs.j;
    this.f = ((byte[])paramfs.c.get("param.facedata"));
    paramfs = paramfs.c.get("param.videopath");
    if (paramfs != null) {
      this.e = paramfs.toString();
    }
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    paramJSONObject = s.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      int i = paramJSONObject.getInt("seq_id");
      if (i != this.d)
      {
        this.a.a(10030, null, null);
        e.c("parseJSON error seq is wrong seq=" + i + ",right = " + this.d);
        return;
      }
      i = paramJSONObject.getInt("err");
      if (i != 0)
      {
        a(i, paramJSONObject.getString("info"));
        return;
      }
      this.g.a = paramJSONObject.getString("share_page_url");
      this.g.c = paramJSONObject.getString("share_desc");
      this.g.b = paramJSONObject.getString("share_title");
      this.a.a = 0;
      return;
    }
    e.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.i().getString(2131361799));
  }
  
  public final fs b(fs paramfs)
  {
    int i = paramfs.j;
    paramfs.m = 1;
    paramfs.n = new ContentValues(3);
    ContentValues localContentValues = paramfs.n;
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str = ax.c;; str = null)
    {
      localContentValues.put("aq_base_sid", str);
      paramfs.n.put("uin", Long.valueOf(this.c));
      str = com.tencent.token.utils.b.a(s.c(this.f)).replace('+', '-').replace('=', '_');
      paramfs.n.put("img_data", str);
      paramfs.n.put("op_time", Integer.valueOf((int)(ag.c().r() / 1000L)));
      paramfs.n.put("seq_id", Integer.valueOf(i));
      if (this.e != null)
      {
        str = com.tencent.token.utils.b.a(s.c(t.b(this.e))).replace('+', '-').replace('=', '_');
        paramfs.n.put("live_video_data", str);
      }
      this.f = null;
      return paramfs;
    }
  }
  
  protected final void b()
  {
    if (!this.b.e)
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.obj = this.g;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cw
 * JD-Core Version:    0.7.0.1
 */