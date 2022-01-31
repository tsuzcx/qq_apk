package com.tencent.token;

import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.utils.s;
import java.util.HashMap;
import org.json.JSONObject;

public final class cf
  extends bm
{
  private String c;
  
  protected final String a()
  {
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    String str2;
    for (String str1 = ax.c;; str1 = null)
    {
      str2 = s.a(new Object[] { "uin", this.c });
      if ((str1 != null) && (str2 != null)) {
        break;
      }
      this.a.a(104, null, null);
      return null;
    }
    str1 = "?aq_base_sid=" + str1 + "&data=" + str2;
    return b.c() + "/cn/mbtoken3/mbtoken3_del_unvfy_uin" + str1;
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ("" + (Long)paramfs.c.get("param.realuin"));
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
 * Qualified Name:     com.tencent.token.cf
 * JD-Core Version:    0.7.0.1
 */