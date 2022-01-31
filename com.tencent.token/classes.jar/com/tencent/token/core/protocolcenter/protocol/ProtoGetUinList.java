package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.cx;
import com.tencent.token.do;
import com.tencent.token.ev;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import org.json.JSONObject;

public class ProtoGetUinList
  extends e
{
  cx d = cx.c();
  do e = do.a();
  
  protected String a()
  {
    this.d.m();
    String str1 = this.d.o();
    str1 = this.e.a(this.d.k(), str1);
    String str2 = cv.a().b();
    if (str2 == null)
    {
      this.a.b(104);
      return null;
    }
    str1 = "?aq_base_sid=" + str2 + "&data=" + str1;
    return c.e() + "/cn/mbtoken3/mbtoken3_get_uin_list_v2" + str1;
  }
  
  protected void a(ev paramev) {}
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      this.a.a(i, "server errcode=" + i + ":" + paramJSONObject, paramJSONObject);
      return;
    }
    paramJSONObject = w.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      h.c("parseJSON =" + paramJSONObject.toString());
      paramJSONObject = this.e.a(paramJSONObject.getJSONArray("uinlist"));
      if (paramJSONObject.b())
      {
        this.e.k = true;
        if (this.e.m != 0L)
        {
          this.e.b(this.e.m);
          this.e.m = 0L;
        }
        this.a.c();
        return;
      }
      this.a.a(paramJSONObject);
      return;
    }
    h.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetUinList
 * JD-Core Version:    0.7.0.1
 */