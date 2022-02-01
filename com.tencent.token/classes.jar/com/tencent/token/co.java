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

public class co
{
  private final String a = "/cn/mbtoken3/mbtoken3_update_dual_msg_status_encrypt";
  protected List<a> b = new ArrayList();
  protected long c;
  int d;
  private int e;
  
  protected co(int paramInt)
  {
    this.e = paramInt;
  }
  
  private String b(a parama, int paramInt)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("app_id", parama.b());
      ((JSONObject)localObject).put("msg_type", parama.d());
      ((JSONObject)localObject).put("msg_id", parama.a());
      ((JSONObject)localObject).put("msg_status", paramInt);
      ((JSONObject)localObject).put("uin", parama.c());
      ((JSONObject)localObject).put("msg_uin", parama.c());
      ((JSONObject)localObject).put("type", this.e);
      paramInt = cb.a + 1;
      cb.a = paramInt;
      this.d = paramInt;
      ((JSONObject)localObject).put("seq_id", this.d);
      ((JSONObject)localObject).put("op_time", (int)(cc.c().s() / 1000L));
      parama = ((JSONObject)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("palin: ");
      ((StringBuilder)localObject).append(parama);
      g.a(((StringBuilder)localObject).toString());
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
    if (this.b == null) {
      return null;
    }
    int i = b();
    if (paramInt >= 0)
    {
      if (paramInt >= i) {
        return null;
      }
      return (a)this.b.get(paramInt);
    }
    return null;
  }
  
  public e a(a parama, int paramInt)
  {
    e locale = new e();
    Object localObject1 = new ez();
    Object localObject2 = cr.a();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?aq_base_sid=");
    localStringBuilder.append(((cr)localObject2).g());
    localStringBuilder.append("&data=");
    localStringBuilder.append(parama);
    parama = localStringBuilder.toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(c.e());
    ((StringBuilder)localObject2).append("/cn/mbtoken3/mbtoken3_update_dual_msg_status_encrypt");
    ((StringBuilder)localObject2).append(parama);
    parama = ((StringBuilder)localObject2).toString();
    localObject2 = ((ez)localObject1).a(parama);
    if (localObject2 == null)
    {
      locale.a(((ez)localObject1).a());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("client request url: ");
      ((StringBuilder)localObject1).append(parama);
      ((StringBuilder)localObject1).append(" failed, reason: ");
      ((StringBuilder)localObject1).append(locale.a);
      ((StringBuilder)localObject1).append(":");
      ((StringBuilder)localObject1).append(locale.b);
      g.c(((StringBuilder)localObject1).toString());
      return locale;
    }
    try
    {
      parama = new JSONObject(new String((byte[])localObject2));
      paramInt = parama.getInt("err");
      if (paramInt != 0)
      {
        parama = parama.getString("info");
        locale.a(paramInt, parama, parama);
        return locale;
      }
      parama = l.c(parama.getString("data"));
      if (parama != null)
      {
        paramInt = new JSONObject(new String(parama)).getInt("seq_id");
        if (this.d != paramInt)
        {
          locale.b(10030);
          return locale;
        }
        cr.a().m();
        locale.c();
        return locale;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parseJSON error decodeData=");
      ((StringBuilder)localObject1).append(parama);
      g.c(((StringBuilder)localObject1).toString());
      locale.a(10022, RqdApplication.l().getString(2131493067));
      return locale;
    }
    catch (Exception parama)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("unknown err: ");
      ((StringBuilder)localObject1).append(parama.toString());
      g.c(((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("JSONException:");
      ((StringBuilder)localObject1).append(parama.toString());
      locale.a(10021, ((StringBuilder)localObject1).toString());
      return locale;
    }
    catch (JSONException parama)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parse json failed: ");
      ((StringBuilder)localObject1).append(parama.toString());
      g.c(((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("JSONException:");
      ((StringBuilder)localObject1).append(parama.toString());
      locale.a(10020, ((StringBuilder)localObject1).toString());
    }
    return locale;
  }
  
  public int b()
  {
    List localList = this.b;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.co
 * JD-Core Version:    0.7.0.1
 */