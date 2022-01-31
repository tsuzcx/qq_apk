package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import org.json.JSONObject;

public final class ef
  extends bm
{
  ag c = ag.c();
  ax d = ax.a();
  
  protected final String a()
  {
    this.c.m();
    String str1 = this.c.o();
    String str2 = ax.a(this.c.k(), str1);
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (str1 = ax.c; str1 == null; str1 = null)
    {
      this.a.a(104, null, null);
      return null;
    }
    str1 = "?aq_base_sid=" + str1 + "&data=" + str2;
    return b.c() + "/cn/mbtoken3/mbtoken3_get_uin_list_v2" + str1;
  }
  
  protected final void a(fs paramfs) {}
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      this.a.a(i, "server errcode=" + i + ":" + paramJSONObject, paramJSONObject);
      return;
    }
    paramJSONObject = s.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      e.c("parseJSON =" + paramJSONObject.toString());
      paramJSONObject = this.d.a(paramJSONObject.getJSONArray("uinlist"));
      if (paramJSONObject.a == 0) {}
      for (i = 1; i != 0; i = 0)
      {
        this.d.k = true;
        if (this.d.m != 0L)
        {
          this.d.b(this.d.m);
          this.d.m = 0L;
        }
        this.a.a = 0;
        return;
      }
      this.a.a(paramJSONObject.a, paramJSONObject.b, paramJSONObject.c);
      return;
    }
    e.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.i().getString(2131361799));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ef
 * JD-Core Version:    0.7.0.1
 */