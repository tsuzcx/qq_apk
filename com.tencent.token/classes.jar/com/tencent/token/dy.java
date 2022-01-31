package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.util.HashMap;
import org.json.JSONObject;

public final class dy
  extends bm
{
  public static String c;
  public static int d;
  private long e;
  private long f;
  private int g;
  private int h;
  
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
    String str2 = s.a(new Object[] { "real_uin", Long.valueOf(this.f), "seq_id", Integer.valueOf(this.g), "op_time", Long.valueOf(ag.c().r() / 1000L), "scene_id", Integer.valueOf(this.h) });
    str1 = "?uin=" + this.e + "&aq_base_sid=" + str1 + "&data=" + str2;
    return b.c() + "/cn/mbtoken3/mbtoken3_realname_lip" + str1;
  }
  
  protected final void a(fs paramfs)
  {
    this.e = ((Long)paramfs.c.get("param.uinhash")).longValue();
    this.f = ((Long)paramfs.c.get("param.realuin")).longValue();
    this.h = ((Integer)paramfs.c.get("param.scene.id")).intValue();
    this.g = paramfs.j;
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i == 0)
    {
      paramJSONObject = s.d(paramJSONObject.getString("data"));
      if (paramJSONObject != null)
      {
        paramJSONObject = new JSONObject(new String(paramJSONObject));
        c = paramJSONObject.getString("validate_code");
        d = paramJSONObject.getInt("validate_id");
        this.a.a = 0;
        return;
      }
      e.c("parseJSON error decodeData=" + paramJSONObject);
      a(10022, RqdApplication.i().getString(2131361799));
      return;
    }
    a(i, paramJSONObject.getString("info"));
    e.a("ProtoGetRealNameVerify fail errCode=" + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dy
 * JD-Core Version:    0.7.0.1
 */