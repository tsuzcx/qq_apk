package com.tencent.token;

import android.content.Context;
import com.tencent.token.core.bean.a;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class dl
{
  private final String a = "/cn/mbtoken3/mbtoken3_update_dual_msg_status_encrypt";
  protected List b = new ArrayList();
  protected long c;
  int d;
  private int e;
  
  protected dl(int paramInt)
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
      paramInt = cw.a + 1;
      cw.a = paramInt;
      this.d = paramInt;
      localJSONObject.put("seq_id", this.d);
      localJSONObject.put("op_time", (int)(cx.c().s() / 1000L));
      parama = localJSONObject.toString();
      h.a("palin: " + parama);
      parama = w.b(parama.getBytes());
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
  
  public f a(a parama, int paramInt)
  {
    f localf = new f();
    gk localgk = new gk();
    Object localObject = do.a();
    if (parama == null)
    {
      localf.b(10023);
      return localf;
    }
    parama = b(parama, paramInt);
    if (parama == null)
    {
      localf.a(10000, "encrypt msg status failed");
      return localf;
    }
    parama = "?aq_base_sid=" + ((do)localObject).g() + "&data=" + parama;
    parama = c.e() + "/cn/mbtoken3/mbtoken3_update_dual_msg_status_encrypt" + parama;
    localObject = localgk.a(parama);
    if (localObject == null)
    {
      localf.a(localgk.a());
      h.c("client request url: " + parama + " failed, reason: " + localf.a + ":" + localf.b);
      return localf;
    }
    try
    {
      parama = new JSONObject(new String((byte[])localObject));
      paramInt = parama.getInt("err");
      if (paramInt != 0)
      {
        parama = parama.getString("info");
        localf.a(paramInt, parama, parama);
        return localf;
      }
    }
    catch (JSONException parama)
    {
      h.c("parse json failed: " + parama.toString());
      localf.a(10020, "JSONException:" + parama.toString());
      return localf;
      parama = w.c(parama.getString("data"));
      if (parama == null) {
        break label408;
      }
      paramInt = new JSONObject(new String(parama)).getInt("seq_id");
      if (this.d != paramInt)
      {
        localf.b(10030);
        return localf;
      }
    }
    catch (Exception parama)
    {
      h.c("unknown err: " + parama.toString());
      localf.a(10021, "JSONException:" + parama.toString());
      return localf;
    }
    do.a().m();
    localf.c();
    return localf;
    label408:
    h.c("parseJSON error decodeData=" + parama);
    localf.a(10022, RqdApplication.l().getString(2131230925));
    return localf;
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
 * Qualified Name:     com.tencent.token.dl
 * JD-Core Version:    0.7.0.1
 */