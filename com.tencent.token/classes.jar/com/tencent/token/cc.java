package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.util.HashMap;
import org.json.JSONObject;

public final class cc
  extends bm
{
  private long c;
  private long d;
  private int e;
  private int f;
  private final String g = "/cn/mbtoken3/mbtoken3_check_up_sms";
  
  public static void a(fs paramfs, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    paramfs.c.put("param.uinhash", Long.valueOf(paramLong1));
    paramfs.c.put("param.realuin", Long.valueOf(paramLong2));
    paramfs.c.put("param.general.mobilecode.sceneid", Integer.valueOf(paramInt1));
    paramfs.j = paramInt2;
  }
  
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
    String str2 = s.a(new Object[] { "real_uin", Long.valueOf(this.d), "scene_id", Integer.valueOf(this.f), "seq_id", Integer.valueOf(this.e), "op_time", Long.valueOf(ag.c().r() / 1000L) });
    str1 = "?uin=" + this.c + "&aq_base_sid=" + str1 + "&data=" + str2;
    return b.c() + "/cn/mbtoken3/mbtoken3_check_up_sms" + str1;
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ((Long)paramfs.c.get("param.uinhash")).longValue();
    this.d = ((Long)paramfs.c.get("param.realuin")).longValue();
    this.f = ((Integer)paramfs.c.get("param.general.mobilecode.sceneid")).intValue();
    this.e = paramfs.j;
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
      i = new JSONObject(new String(paramJSONObject)).getInt("seq_id");
      if (i != this.e)
      {
        this.a.a(10030, null, null);
        e.c("parseJSON error seq is wrong seq=" + i + ",right = " + this.e);
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
 * Qualified Name:     com.tencent.token.cc
 * JD-Core Version:    0.7.0.1
 */