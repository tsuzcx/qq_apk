package com.tencent.token;

import android.content.Context;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class at
  extends au
{
  static at a;
  private final String d = "/cn/mbtoken3/mbtoken3_scan_qrcode_v2";
  private String e;
  private int f;
  private int g;
  
  private at()
  {
    super(2);
  }
  
  public static at a()
  {
    if (a == null) {
      a = new at();
    }
    return a;
  }
  
  public final d a(String paramString)
  {
    this.b.clear();
    this.e = "";
    this.f = 0;
    d locald = new d((byte)0);
    Object localObject1 = ax.a();
    if ((localObject1 == null) || (((ax)localObject1).e() == null))
    {
      locald.a(110, null, null);
      return locald;
    }
    long l = ((ax)localObject1).f();
    if (l == 0L)
    {
      locald.a(10029, null, null);
      return locald;
    }
    if (((ax)localObject1).e().mIsBinded) {
      l = ((ax)localObject1).e().mUin;
    }
    gv localgv = new gv();
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("uin", l);
      i = af.a + 1;
      af.a = i;
      this.g = i;
      ((JSONObject)localObject1).put("seq_id", this.g);
      ((JSONObject)localObject1).put("op_time", ag.c().r() / 1000L);
      if (paramString != null) {
        ((JSONObject)localObject1).put("url_data", paramString);
      }
      localObject1 = ((JSONObject)localObject1).toString();
      e.a("plain:" + (String)localObject1);
      localObject1 = s.b(((String)localObject1).getBytes());
    }
    catch (JSONException localJSONException)
    {
      int i;
      byte[] arrayOfByte;
      Object localObject2;
      for (;;)
      {
        e.c("JSONException:" + localJSONException.getMessage());
        localObject2 = null;
      }
      for (;;)
      {
        try
        {
          localObject2 = new JSONObject(new String(arrayOfByte));
          i = ((JSONObject)localObject2).getInt("err");
          if (i != 0)
          {
            paramString = ((JSONObject)localObject2).getString("info");
            locald.a(i, paramString, paramString);
            break label845;
          }
          localObject2 = s.d(((JSONObject)localObject2).getString("data"));
          if (localObject2 == null) {
            break;
          }
          localObject2 = new JSONObject(new String((byte[])localObject2));
          i = ((JSONObject)localObject2).getInt("seq_id");
          if (i != this.g)
          {
            locald.a(10030, null, null);
            paramString = new StringBuilder().append("parseJSON error seq is wrong seq=").append(i).append(",right = ");
            af.a();
            e.c(af.b());
            return locald;
          }
          this.f = ((JSONObject)localObject2).getInt("type");
          if (1 != this.f) {
            break label774;
          }
          paramString = ((JSONObject)localObject2).getJSONObject("msg");
          localObject2 = new com.tencent.token.core.bean.b();
          if (((com.tencent.token.core.bean.b)localObject2).a(paramString)) {
            continue;
          }
          e.c("object item parse failed ");
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
          e.c("parse json failed: " + paramString.toString());
          locald.a(10020, "JSONException:" + paramString.toString(), null);
          break label845;
          this.b.add(localObject2);
          continue;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          e.c("unknown err: " + paramString.toString());
          locald.a(10021, "JSONException:" + paramString.toString(), null);
        }
        ax.a().m();
        locald.a = 0;
        break label845;
        if (2 == this.f) {
          this.e = ((JSONObject)localObject2).getString("text");
        } else {
          this.e = paramString;
        }
      }
      e.c("parseJSON error decodeData=" + localObject2);
      locald.a(10022, RqdApplication.i().getString(2131361799), null);
    }
    localObject1 = "?aq_base_sid=" + ax.g() + "&data=" + (String)localObject1;
    localObject1 = com.tencent.token.global.b.c() + "/cn/mbtoken3/mbtoken3_scan_qrcode_v2" + (String)localObject1;
    arrayOfByte = localgv.a((String)localObject1);
    if (arrayOfByte == null)
    {
      paramString = localgv.a();
      locald.a(paramString.a, paramString.b, paramString.c);
      e.c("client request url: " + (String)localObject1 + " failed, reason: " + locald.a + ":" + locald.b);
      return locald;
    }
    label774:
    label845:
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.at
 * JD-Core Version:    0.7.0.1
 */