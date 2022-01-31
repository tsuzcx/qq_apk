package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.util.HashMap;
import org.json.JSONObject;

public final class eq
  extends bm
{
  private long c;
  private int d;
  private String e;
  private long f;
  
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
    String str2 = s.a(new Object[] { "real_uin", Long.valueOf(this.c), "seq_id", Integer.valueOf(this.d), "op_time", Long.valueOf(ag.c().r() / 1000L), "id_number", this.e });
    str1 = "?aq_base_sid=" + str1 + "&data=" + str2;
    return b.c() + "/cn/mbtoken3/mbtoken3_card_check" + str1;
  }
  
  protected final void a(fs paramfs)
  {
    this.f = ((Long)paramfs.c.get("param.uinhash")).longValue();
    this.c = ((Long)paramfs.c.get("param.realuin")).longValue();
    this.d = paramfs.j;
    this.e = ((String)paramfs.c.get("param.idnumber"));
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
      if (i != this.d)
      {
        this.a.a(10030, null, null);
        e.c("parseJSON error seq is wrong seq=" + i + ",right = " + this.d);
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
 * Qualified Name:     com.tencent.token.eq
 * JD-Core Version:    0.7.0.1
 */