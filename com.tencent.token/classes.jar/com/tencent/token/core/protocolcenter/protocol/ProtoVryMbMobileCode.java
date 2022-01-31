package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.ev;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoVryMbMobileCode
  extends e
{
  private long d;
  private String e;
  
  public static void a(ev paramev, long paramLong, String paramString)
  {
    paramev.c.put("param.uinhash", Long.valueOf(paramLong));
    paramev.c.put("param.mbmobile.vrycode", paramString);
  }
  
  protected String a()
  {
    String str1 = cv.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("uin", this.d);
      int i = cw.a + 1;
      cw.a = i;
      this.c = i;
      ((JSONObject)localObject).put("seq_id", this.c);
      ((JSONObject)localObject).put("op_time", (int)(cx.c().s() / 1000L));
      ((JSONObject)localObject).put("mobile_code", this.e);
      localObject = w.b(((JSONObject)localObject).toString().getBytes());
      if (localObject == null)
      {
        this.a.b(10000);
        return null;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      this.a.b(10000);
      return null;
    }
    finally
    {
      if (w.b(((JSONObject)localObject).toString().getBytes()) == null)
      {
        this.a.b(10000);
        return null;
      }
    }
    localObject = "?aq_base_sid=" + str2 + "&data=" + (String)localObject;
    return c.e() + "/cn/mbtoken3/mbtoken3_mbop_verify_mobile_code_encrypt" + (String)localObject;
  }
  
  protected void a(ev paramev)
  {
    this.d = ((Long)paramev.c.get("param.uinhash")).longValue();
    this.e = ((String)paramev.c.get("param.mbmobile.vrycode"));
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = w.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      i = new JSONObject(new String(paramJSONObject)).getInt("seq_id");
      if (this.c != i)
      {
        this.a.b(10030);
        h.c("parseJSON error seq is wrong seq=" + i + ",right = " + this.c);
        return;
      }
      this.a.c();
      return;
    }
    a(10022, RqdApplication.l().getString(2131230925));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoVryMbMobileCode
 * JD-Core Version:    0.7.0.1
 */