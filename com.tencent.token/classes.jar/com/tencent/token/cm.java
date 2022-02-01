package com.tencent.token;

import android.content.Context;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.a;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class cm
  extends cn
{
  static cm a;
  private final String e = "/cn/mbtoken3/mbtoken3_scan_qrcode_v2";
  private String f;
  private int g;
  private int h;
  
  private cm()
  {
    super(2);
  }
  
  public static cm a()
  {
    if (a == null) {
      a = new cm();
    }
    return a;
  }
  
  public e a(String paramString)
  {
    this.b.clear();
    this.f = "";
    this.g = 0;
    e locale = new e();
    Object localObject3 = cq.a();
    if ((localObject3 == null) || (((cq)localObject3).e() == null))
    {
      locale.b(110);
      return locale;
    }
    long l = ((cq)localObject3).f();
    if (l == 0L)
    {
      locale.b(10029);
      return locale;
    }
    if (((cq)localObject3).e().mIsBinded) {
      l = ((cq)localObject3).e().mUin;
    }
    ey localey = new ey();
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("uin", l);
      i = ca.a + 1;
      ca.a = i;
      this.h = i;
      ((JSONObject)localObject1).put("seq_id", this.h);
      ((JSONObject)localObject1).put("op_time", cb.c().s() / 1000L);
      if (paramString != null) {
        ((JSONObject)localObject1).put("url_data", paramString);
      }
      localObject1 = ((JSONObject)localObject1).toString();
      g.a("plain:" + (String)localObject1);
      localObject1 = l.b(((String)localObject1).getBytes());
    }
    catch (JSONException localJSONException)
    {
      int i;
      Object localObject2;
      for (;;)
      {
        Object localObject1;
        g.c("JSONException:" + localJSONException.getMessage());
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
            locale.a(i, paramString, paramString);
            break label822;
          }
          localObject2 = l.c(((JSONObject)localObject2).getString("data"));
          if (localObject2 == null) {
            break;
          }
          localObject2 = new JSONObject(new String((byte[])localObject2));
          i = ((JSONObject)localObject2).getInt("seq_id");
          if (i != this.h)
          {
            locale.b(10030);
            g.c("parseJSON error seq is wrong seq=" + i + ",right = " + ca.a().b());
            return locale;
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
          g.c("object item parse failed ");
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
          g.c("parse json failed: " + paramString.toString());
          locale.a(10020, "JSONException:" + paramString.toString());
          break label822;
          this.b.add(localObject2);
          continue;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          g.c("unknown err: " + paramString.toString());
          locale.a(10021, "JSONException:" + paramString.toString());
        }
        cq.a().m();
        locale.c();
        break label822;
        if (2 == this.g) {
          this.f = ((JSONObject)localObject2).getString("text");
        } else {
          this.f = paramString;
        }
      }
      g.c("parseJSON error decodeData=" + localObject2);
      locale.a(10022, RqdApplication.l().getString(2131230925));
    }
    localObject1 = "?aq_base_sid=" + ((cq)localObject3).g() + "&data=" + (String)localObject1;
    localObject1 = c.e() + "/cn/mbtoken3/mbtoken3_scan_qrcode_v2" + (String)localObject1;
    localObject3 = localey.a((String)localObject1);
    if (localObject3 == null)
    {
      locale.a(localey.a());
      g.c("client request url: " + (String)localObject1 + " failed, reason: " + locale.a + ":" + locale.b);
      return locale;
    }
    label750:
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cm
 * JD-Core Version:    0.7.0.1
 */