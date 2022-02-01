package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.ca;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoFaceVryOnOff
  extends d
{
  private long d;
  private int e;
  private int f;
  private boolean g;
  private String h;
  private final String i = "/cn/mbtoken3/mbtoken3_face_verify_on_off";
  
  public static void a(do paramdo, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    paramdo.c.put("param.uinhash", Long.valueOf(paramLong));
    paramdo.c.put("param.scene_id", Integer.valueOf(paramInt1));
    paramdo.c.put("param.verifyonoff", Boolean.valueOf(paramBoolean));
    paramdo.c.put("param.wtlogin.a2", paramString);
    paramdo.j = paramInt2;
  }
  
  protected String a()
  {
    int k = 1;
    int j = 1;
    String str2 = ca.a().b();
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
        str1 = l.a(new Object[] { "uin", Long.valueOf(l), "on_off", Integer.valueOf(j), "seq_id", Integer.valueOf(this.e), "A2", this.h });
        str1 = "?uin=" + this.d + "&aq_base_sid=" + str2 + "&data=" + str1;
        return c.e() + "/cn/mbtoken3/mbtoken3_face_verify_on_off" + str1;
        j = 0;
      }
    }
    long l = this.d;
    if (this.g) {}
    for (j = k;; j = 0)
    {
      str1 = l.a(new Object[] { "uin", Long.valueOf(l), "on_off", Integer.valueOf(j), "scene_id", Integer.valueOf(this.f), "seq_id", Integer.valueOf(this.e), "A2", this.h });
      break;
    }
  }
  
  protected void a(do paramdo)
  {
    this.d = ((Long)paramdo.c.get("param.uinhash")).longValue();
    this.f = ((Integer)paramdo.c.get("param.scene_id")).intValue();
    this.g = ((Boolean)paramdo.c.get("param.verifyonoff")).booleanValue();
    this.h = ((String)paramdo.c.get("param.wtlogin.a2"));
    this.e = paramdo.j;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int j = paramJSONObject.getInt("err");
    if (j != 0)
    {
      a(j, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      g.a("mbtoken3_general_verify_mobile_code ret: " + paramJSONObject);
      j = paramJSONObject.getInt("seq_id");
      if (j != this.e)
      {
        g.c("parseJSON error seq is wrong seq=" + j + ",right = " + this.e);
        this.a.b(10030);
        return;
      }
      this.a.c();
      return;
    }
    g.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoFaceVryOnOff
 * JD-Core Version:    0.7.0.1
 */