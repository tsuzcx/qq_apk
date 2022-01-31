package com.tencent.token;

import android.content.Context;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.a;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class dk
  extends dl
{
  static dk a;
  private final String e = "/cn/mbtoken3/mbtoken3_scan_qrcode_v2";
  private String f;
  private int g;
  private int h;
  
  private dk()
  {
    super(2);
  }
  
  public static dk a()
  {
    if (a == null) {
      a = new dk();
    }
    return a;
  }
  
  public f a(String paramString)
  {
    this.b.clear();
    this.f = "";
    this.g = 0;
    f localf = new f();
    Object localObject3 = do.a();
    if ((localObject3 == null) || (((do)localObject3).e() == null))
    {
      localf.b(110);
      return localf;
    }
    long l = ((do)localObject3).f();
    if (l == 0L)
    {
      localf.b(10029);
      return localf;
    }
    if (((do)localObject3).e().mIsBinded) {
      l = ((do)localObject3).e().mUin;
    }
    gk localgk = new gk();
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("uin", l);
      i = cw.a + 1;
      cw.a = i;
      this.h = i;
      ((JSONObject)localObject1).put("seq_id", this.h);
      ((JSONObject)localObject1).put("op_time", cx.c().s() / 1000L);
      if (paramString != null) {
        ((JSONObject)localObject1).put("url_data", paramString);
      }
      localObject1 = ((JSONObject)localObject1).toString();
      h.a("plain:" + (String)localObject1);
      localObject1 = w.b(((String)localObject1).getBytes());
    }
    catch (JSONException localJSONException)
    {
      int i;
      Object localObject2;
      for (;;)
      {
        Object localObject1;
        h.c("JSONException:" + localJSONException.getMessage());
        localObject2 = null;
      }
      for (;;)
      {
        try
        {
          localObject2 = new JSONObject(new String((byte[])localObject3));
          i = ((JSONObject)localObject2).getInt("err");
          if (i != 0)
          {
            paramString = ((JSONObject)localObject2).getString("info");
            localf.a(i, paramString, paramString);
            break label822;
          }
          localObject2 = w.c(((JSONObject)localObject2).getString("data"));
          if (localObject2 == null) {
            break;
          }
          localObject2 = new JSONObject(new String((byte[])localObject2));
          i = ((JSONObject)localObject2).getInt("seq_id");
          if (i != this.h)
          {
            localf.b(10030);
            h.c("parseJSON error seq is wrong seq=" + i + ",right = " + cw.a().b());
            return localf;
          }
          this.g = ((JSONObject)localObject2).getInt("type");
          if (1 != this.g) {
            break label750;
          }
          paramString = ((JSONObject)localObject2).getJSONObject("msg");
          localObject2 = new a();
          if (((a)localObject2).a(paramString)) {
            continue;
          }
          h.c("object item parse failed ");
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
          h.c("parse json failed: " + paramString.toString());
          localf.a(10020, "JSONException:" + paramString.toString());
          break label822;
          this.b.add(localObject2);
          continue;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          h.c("unknown err: " + paramString.toString());
          localf.a(10021, "JSONException:" + paramString.toString());
        }
        do.a().m();
        localf.c();
        break label822;
        if (2 == this.g) {
          this.f = ((JSONObject)localObject2).getString("text");
        } else {
          this.f = paramString;
        }
      }
      h.c("parseJSON error decodeData=" + localObject2);
      localf.a(10022, RqdApplication.l().getString(2131230925));
    }
    localObject1 = "?aq_base_sid=" + ((do)localObject3).g() + "&data=" + (String)localObject1;
    localObject1 = c.e() + "/cn/mbtoken3/mbtoken3_scan_qrcode_v2" + (String)localObject1;
    localObject3 = localgk.a((String)localObject1);
    if (localObject3 == null)
    {
      localf.a(localgk.a());
      h.c("client request url: " + (String)localObject1 + " failed, reason: " + localf.a + ":" + localf.b);
      return localf;
    }
    label750:
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dk
 * JD-Core Version:    0.7.0.1
 */