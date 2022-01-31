package com.tencent.token;

import com.tencent.token.global.b;
import com.tencent.token.global.d;
import java.util.HashMap;
import org.json.JSONObject;

public final class cz
  extends bm
{
  private long c;
  private long d;
  
  protected final String a()
  {
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str = ax.c; str == null; str = null)
    {
      this.a.a(104, null, null);
      return null;
    }
    str = "?uin=" + this.c + "&msgid=" + this.d + "&aq_base_sid=" + str;
    return b.c() + "/cn/mbtoken3/mbtoken3_feedback_abnormal_login" + str;
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ((Long)paramfs.c.get("param.uinhash")).longValue();
    this.d = ((Long)paramfs.c.get("param.feedback.msgid")).longValue();
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    this.a.a = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cz
 * JD-Core Version:    0.7.0.1
 */