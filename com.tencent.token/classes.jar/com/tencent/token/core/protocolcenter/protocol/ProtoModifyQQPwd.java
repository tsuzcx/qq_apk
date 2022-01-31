package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.ev;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoModifyQQPwd
  extends e
{
  public String d;
  public long e;
  public int f;
  
  public static void a(ev paramev, long paramLong, String paramString, int paramInt)
  {
    paramev.c.put("param.uinhash", Long.valueOf(paramLong));
    paramev.c.put("param.qqpwd", paramString);
    paramev.c.put("param.scene.id", Integer.valueOf(paramInt));
  }
  
  protected String a()
  {
    String str2 = cv.a().b();
    if (str2 == null)
    {
      this.a.b(104);
      return null;
    }
    int i = cw.a + 1;
    cw.a = i;
    this.c = i;
    if (this.f == 0) {}
    for (String str1 = w.a(new Object[] { "uin", Long.valueOf(this.e), "seq_id", Integer.valueOf(this.c), "pwd", this.d, "op_time", Long.valueOf(cx.c().s() / 1000L) }); str1 == null; str1 = w.a(new Object[] { "uin", Long.valueOf(this.e), "seq_id", Integer.valueOf(this.c), "pwd", this.d, "op_time", Long.valueOf(cx.c().s() / 1000L), "scene_id", Integer.valueOf(this.f) }))
    {
      this.a.a(10000, "encrypt qqtoken code failed");
      return null;
    }
    str1 = "?aq_base_sid=" + str2 + "&data=" + str1;
    return c.e() + "/cn/mbtoken3/mbtoken3_modify_pwd_encrypt" + str1;
  }
  
  protected void a(ev paramev)
  {
    this.e = ((Long)paramev.c.get("param.uinhash")).longValue();
    this.d = ((String)paramev.c.get("param.qqpwd"));
    this.f = ((Integer)paramev.c.get("param.scene.id")).intValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = w.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      i = new JSONObject(new String(paramJSONObject)).getInt("seq_id");
      if (this.c != i)
      {
        this.a.b(10030);
        h.c("parseJSON error seq is wrong seq=" + i + ",right = " + this.c);
        return;
      }
      this.a.c();
      return;
    }
    a(10022, RqdApplication.l().getString(2131230925));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoModifyQQPwd
 * JD-Core Version:    0.7.0.1
 */