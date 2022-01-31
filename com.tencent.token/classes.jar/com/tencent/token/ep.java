package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;
import java.util.HashMap;
import org.json.JSONObject;

public final class ep
  extends bm
{
  private long c;
  private long d;
  private int e;
  private int f;
  private long g;
  private Integer h = Integer.valueOf(1);
  private final String i = "/cn/mbtoken3/mbtoken3_qry_spec_verify";
  private final String j = "/cn/mbtoken3/mbtoken3_qry_face_verify_on_off";
  
  protected final String a()
  {
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str1 = ax.c; str1 == null; str1 = null)
    {
      this.a.a(104, null, null);
      return null;
    }
    String str2 = s.a(new Object[] { "real_uin", Long.valueOf(this.d), "seq_id", Integer.valueOf(this.e), "op_time", Long.valueOf(this.g), "scene_id", Integer.valueOf(this.f) });
    str1 = "?uin=" + this.c + "&aq_base_sid=" + str1 + "&data=" + str2;
    if (t.l() == 0) {}
    for (str1 = b.c() + "/cn/mbtoken3/mbtoken3_qry_spec_verify" + str1;; str1 = b.c() + "/cn/mbtoken3/mbtoken3_qry_face_verify_on_off" + str1)
    {
      e.c("query special verify url:" + str1);
      return str1;
    }
  }
  
  protected final void a(fs paramfs)
  {
    this.d = ((Long)paramfs.c.get("param.realuin")).longValue();
    this.f = ((Integer)paramfs.c.get("param.scene_id")).intValue();
    this.g = ((Long)paramfs.c.get("param.op_time")).longValue();
    this.e = paramfs.j;
    this.c = ((Long)paramfs.c.get("param.uinhash")).longValue();
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int k = paramJSONObject.getInt("err");
    if (k != 0)
    {
      a(k, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = s.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      e.a("mbtoken3_qry_face_verify_on_off ret: " + paramJSONObject);
      k = paramJSONObject.getInt("seq_id");
      if (k != this.e)
      {
        e.c("parseJSON error seq is wrong seq=" + k + ",right = " + this.e);
        this.a.a(10030, null, null);
        return;
      }
      if (paramJSONObject.getInt("verify_type") == 0) {}
      for (this.h = Integer.valueOf(0);; this.h = Integer.valueOf(1))
      {
        this.a.a = 0;
        return;
      }
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
      localMessage.obj = this.h;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ep
 * JD-Core Version:    0.7.0.1
 */