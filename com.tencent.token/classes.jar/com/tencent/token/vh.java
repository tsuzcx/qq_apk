package com.tencent.token;

import android.content.ContentValues;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class vh
  extends ud
{
  public long d;
  public int e;
  public String f;
  private byte[] g;
  private a h;
  
  public final String a()
  {
    st.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abm paramabm)
  {
    this.d = ((Long)paramabm.c.get("param.uinhash")).longValue();
    this.e = paramabm.j;
    this.g = ((byte[])paramabm.c.get("param.facedata"));
    paramabm = paramabm.c.get("param.videopath");
    if (paramabm != null) {
      this.f = paramabm.toString();
    }
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    paramJSONObject = aay.d(paramJSONObject.getString("data"));
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
        xv.c(paramJSONObject.toString());
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
    xv.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493069));
  }
  
  public final abm b(abm paramabm)
  {
    int i = paramabm.j;
    paramabm.m = 1;
    paramabm.n = new ContentValues(3);
    Object localObject = paramabm.n;
    st.a();
    ((ContentValues)localObject).put("aq_base_sid", null);
    paramabm.n.put("uin", Long.valueOf(this.d));
    localObject = aap.a(aay.c(this.g)).replace('+', '-').replace('=', '_');
    paramabm.n.put("img_data", (String)localObject);
    localObject = paramabm.n;
    sv.b();
    ((ContentValues)localObject).put("op_time", Integer.valueOf((int)((System.currentTimeMillis() + 0L) / 1000L)));
    paramabm.n.put("seq_id", Integer.valueOf(i));
    localObject = this.f;
    if (localObject != null)
    {
      localObject = aap.a(aay.c(aaz.d((String)localObject))).replace('+', '-').replace('=', '_');
      paramabm.n.put("live_video_data", (String)localObject);
    }
    this.g = null;
    return paramabm;
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
 * Qualified Name:     com.tencent.token.vh
 * JD-Core Version:    0.7.0.1
 */