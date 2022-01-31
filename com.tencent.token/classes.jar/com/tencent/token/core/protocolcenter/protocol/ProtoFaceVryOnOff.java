package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.ev;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoFaceVryOnOff
  extends e
{
  private long d;
  private int e;
  private int f;
  private boolean g;
  private String h;
  private final String i = "/cn/mbtoken3/mbtoken3_face_verify_on_off";
  
  public static void a(ev paramev, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    paramev.c.put("param.uinhash", Long.valueOf(paramLong));
    paramev.c.put("param.scene_id", Integer.valueOf(paramInt1));
    paramev.c.put("param.verifyonoff", Boolean.valueOf(paramBoolean));
    paramev.c.put("param.wtlogin.a2", paramString);
    paramev.j = paramInt2;
  }
  
  protected String a()
  {
    int k = 1;
    int j = 1;
    String str2 = cv.a().b();
    if (str2 == null)
    {
      this.a.b(104);
      return null;
    }
    String str1;
    if (this.f == 0)
    {
      l = this.d;
      if (this.g) {}
      for (;;)
      {
        str1 = w.a(new Object[] { "uin", Long.valueOf(l), "on_off", Integer.valueOf(j), "seq_id", Integer.valueOf(this.e), "A2", this.h });
        str1 = "?uin=" + this.d + "&aq_base_sid=" + str2 + "&data=" + str1;
        return c.e() + "/cn/mbtoken3/mbtoken3_face_verify_on_off" + str1;
        j = 0;
      }
    }
    long l = this.d;
    if (this.g) {}
    for (j = k;; j = 0)
    {
      str1 = w.a(new Object[] { "uin", Long.valueOf(l), "on_off", Integer.valueOf(j), "scene_id", Integer.valueOf(this.f), "seq_id", Integer.valueOf(this.e), "A2", this.h });
      break;
    }
  }
  
  protected void a(ev paramev)
  {
    this.d = ((Long)paramev.c.get("param.uinhash")).longValue();
    this.f = ((Integer)paramev.c.get("param.scene_id")).intValue();
    this.g = ((Boolean)paramev.c.get("param.verifyonoff")).booleanValue();
    this.h = ((String)paramev.c.get("param.wtlogin.a2"));
    this.e = paramev.j;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int j = paramJSONObject.getInt("err");
    if (j != 0)
    {
      a(j, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = w.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      h.a("mbtoken3_general_verify_mobile_code ret: " + paramJSONObject);
      j = paramJSONObject.getInt("seq_id");
      if (j != this.e)
      {
        h.c("parseJSON error seq is wrong seq=" + j + ",right = " + this.e);
        this.a.b(10030);
        return;
      }
      this.a.c();
      return;
    }
    h.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoFaceVryOnOff
 * JD-Core Version:    0.7.0.1
 */