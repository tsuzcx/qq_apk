package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.util.HashMap;
import org.json.JSONObject;

public final class cy
  extends bm
{
  private long c;
  private int d;
  private int e;
  private boolean f;
  private String g;
  private final String h = "/cn/mbtoken3/mbtoken3_face_verify_on_off";
  
  protected final String a()
  {
    int j = 1;
    int i = 1;
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str1 = ax.c; str1 == null; str1 = null)
    {
      this.a.a(104, null, null);
      return null;
    }
    String str2;
    if (this.e == 0)
    {
      l = this.c;
      if (this.f) {}
      for (;;)
      {
        str2 = s.a(new Object[] { "uin", Long.valueOf(l), "on_off", Integer.valueOf(i), "seq_id", Integer.valueOf(this.d), "A2", this.g });
        str1 = "?uin=" + this.c + "&aq_base_sid=" + str1 + "&data=" + str2;
        return b.c() + "/cn/mbtoken3/mbtoken3_face_verify_on_off" + str1;
        i = 0;
      }
    }
    long l = this.c;
    if (this.f) {}
    for (i = j;; i = 0)
    {
      str2 = s.a(new Object[] { "uin", Long.valueOf(l), "on_off", Integer.valueOf(i), "scene_id", Integer.valueOf(this.e), "seq_id", Integer.valueOf(this.d), "A2", this.g });
      break;
    }
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ((Long)paramfs.c.get("param.uinhash")).longValue();
    this.e = ((Integer)paramfs.c.get("param.scene_id")).intValue();
    this.f = ((Boolean)paramfs.c.get("param.verifyonoff")).booleanValue();
    this.g = ((String)paramfs.c.get("param.wtlogin.a2"));
    this.d = paramfs.j;
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = s.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      e.a("mbtoken3_general_verify_mobile_code ret: " + paramJSONObject);
      i = paramJSONObject.getInt("seq_id");
      if (i != this.d)
      {
        e.c("parseJSON error seq is wrong seq=" + i + ",right = " + this.d);
        this.a.a(10030, null, null);
        return;
      }
      this.a.a = 0;
      return;
    }
    e.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.i().getString(2131361799));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cy
 * JD-Core Version:    0.7.0.1
 */