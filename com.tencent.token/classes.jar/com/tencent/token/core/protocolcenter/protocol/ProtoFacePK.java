package com.tencent.token.core.protocolcenter.protocol;

import android.content.ContentValues;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.ca;
import com.tencent.token.cc;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.b;
import com.tencent.token.utils.l;
import com.tencent.token.utils.m;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoFacePK
  extends d
{
  public long d;
  public int e;
  public String f;
  private byte[] g;
  private a h = new a();
  
  protected String a()
  {
    if (ca.a().b() == null)
    {
      this.a.b(104);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c.e());
    localStringBuilder.append("/cn/mbtoken3/mbtoken3_face_pk");
    return localStringBuilder.toString();
  }
  
  protected void a(do paramdo)
  {
    this.d = ((Long)paramdo.c.get("param.uinhash")).longValue();
    this.e = paramdo.j;
    this.g = ((byte[])paramdo.c.get("param.facedata"));
    paramdo = paramdo.c.get("param.videopath");
    if (paramdo != null) {
      this.f = paramdo.toString();
    }
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      int i = paramJSONObject.getInt("seq_id");
      if (i != this.e)
      {
        this.a.b(10030);
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.e);
        g.c(paramJSONObject.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parseJSON error decodeData=");
    localStringBuilder.append(paramJSONObject);
    g.c(localStringBuilder.toString());
    a(10022, RqdApplication.l().getString(2131493067));
  }
  
  public do b(do paramdo)
  {
    int i = paramdo.j;
    paramdo.m = 1;
    paramdo.n = new ContentValues(3);
    paramdo.n.put("aq_base_sid", ca.a().b());
    paramdo.n.put("uin", Long.valueOf(this.d));
    String str = b.a(l.c(this.g)).replace('+', '-').replace('=', '_');
    paramdo.n.put("img_data", str);
    paramdo.n.put("op_time", Integer.valueOf((int)(cc.c().s() / 1000L)));
    paramdo.n.put("seq_id", Integer.valueOf(i));
    str = this.f;
    if (str != null)
    {
      str = b.a(l.c(m.a(str))).replace('+', '-').replace('=', '_');
      paramdo.n.put("live_video_data", str);
    }
    this.g = null;
    return paramdo;
  }
  
  protected void b()
  {
    if ((!this.b.e) && (this.b.d != null))
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.obj = this.h;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
  
  public class a
  {
    public String a;
    public String b;
    public String c;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoFacePK
 * JD-Core Version:    0.7.0.1
 */