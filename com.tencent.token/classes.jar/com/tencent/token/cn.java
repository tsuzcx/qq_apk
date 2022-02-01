package com.tencent.token;

import android.content.Context;
import com.tencent.token.core.bean.a;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class cn
{
  private final String a = "/cn/mbtoken3/mbtoken3_update_dual_msg_status_encrypt";
  protected List<a> b = new ArrayList();
  protected long c;
  int d;
  private int e;
  
  protected cn(int paramInt)
  {
    this.e = paramInt;
  }
  
  private String b(a parama, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("app_id", parama.b());
      localJSONObject.put("msg_type", parama.d());
      localJSONObject.put("msg_id", parama.a());
      localJSONObject.put("msg_status", paramInt);
      localJSONObject.put("uin", parama.c());
      localJSONObject.put("msg_uin", parama.c());
      localJSONObject.put("type", this.e);
      paramInt = ca.a + 1;
      ca.a = paramInt;
      this.d = paramInt;
      localJSONObject.put("seq_id", this.d);
      localJSONObject.put("op_time", (int)(cb.c().s() / 1000L));
      parama = localJSONObject.toString();
      g.a("palin: " + parama);
      parama = l.b(parama.getBytes());
      return parama;
    }
    catch (JSONException parama)
    {
      parama.printStackTrace();
    }
    return null;
  }
  
  public a a(int paramInt)
  {
    if (this.b == null) {}
    int i;
    do
    {
      return null;
      i = b();
    } while ((paramInt < 0) || (paramInt >= i));
    return (a)this.b.get(paramInt);
  }
  
  public e a(a parama, int paramInt)
  {
    e locale = new e();
    ey localey = new ey();
    Object localObject = cq.a();
    if (parama == null)
    {
      locale.b(10023);
      return locale;
    }
    parama = b(parama, paramInt);
    if (parama == null)
    {
      locale.a(10000, "encrypt msg status failed");
      return locale;
    }
    parama = "?aq_base_sid=" + ((cq)localObject).g() + "&data=" + parama;
    parama = c.e() + "/cn/mbtoken3/mbtoken3_update_dual_msg_status_encrypt" + parama;
    localObject = localey.a(parama);
    if (localObject == null)
    {
      locale.a(localey.a());
      g.c("client request url: " + parama + " failed, reason: " + locale.a + ":" + locale.b);
      return locale;
    }
    try
    {
      parama = new JSONObject(new String((byte[])localObject));
      paramInt = parama.getInt("err");
      if (paramInt != 0)
      {
        parama = parama.getString("info");
        locale.a(paramInt, parama, parama);
        return locale;
      }
    }
    catch (JSONException parama)
    {
      g.c("parse json failed: " + parama.toString());
      locale.a(10020, "JSONException:" + parama.toString());
      return locale;
      parama = l.c(parama.getString("data"));
      if (parama == null) {
        break label408;
      }
      paramInt = new JSONObject(new String(parama)).getInt("seq_id");
      if (this.d != paramInt)
      {
        locale.b(10030);
        return locale;
      }
    }
    catch (Exception parama)
    {
      g.c("unknown err: " + parama.toString());
      locale.a(10021, "JSONException:" + parama.toString());
      return locale;
    }
    cq.a().m();
    locale.c();
    return locale;
    label408:
    g.c("parseJSON error decodeData=" + parama);
    locale.a(10022, RqdApplication.l().getString(2131230925));
    return locale;
  }
  
  public int b()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cn
 * JD-Core Version:    0.7.0.1
 */