package com.tencent.token;

import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class au
{
  private final String a = "/cn/mbtoken3/mbtoken3_update_dual_msg_status";
  protected List b = new ArrayList();
  protected long c;
  private int d;
  
  protected au(int paramInt)
  {
    this.d = paramInt;
  }
  
  private static String b(com.tencent.token.core.bean.b paramb, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("app_id", paramb.b());
      localJSONObject.put("msg_type", paramb.d());
      localJSONObject.put("msg_id", paramb.a());
      localJSONObject.put("msg_status", paramInt);
      paramb = localJSONObject.toString();
      e.a("palin: " + paramb);
      paramb = s.b(paramb.getBytes());
      return paramb;
    }
    catch (JSONException paramb)
    {
      paramb.printStackTrace();
    }
    return null;
  }
  
  public final com.tencent.token.core.bean.b a(int paramInt)
  {
    if (this.b == null) {}
    for (;;)
    {
      return null;
      if (this.b == null) {}
      for (int i = 0; (paramInt >= 0) && (paramInt < i); i = this.b.size()) {
        return (com.tencent.token.core.bean.b)this.b.get(paramInt);
      }
    }
  }
  
  public final d a(com.tencent.token.core.bean.b paramb, int paramInt)
  {
    d locald = new d((byte)0);
    Object localObject1 = new gv();
    ax.a();
    if (paramb == null)
    {
      locald.a(10023, null, null);
      return locald;
    }
    Object localObject2 = b(paramb, paramInt);
    if (localObject2 == null)
    {
      locald.a(10000, "encrypt msg status failed", null);
      return locald;
    }
    paramb = "?aq_base_sid=" + ax.g() + "&uin=" + paramb.c() + "&msg_uin=" + paramb.c() + "&data=" + (String)localObject2 + "&type=" + this.d;
    paramb = com.tencent.token.global.b.c() + "/cn/mbtoken3/mbtoken3_update_dual_msg_status" + paramb;
    localObject2 = ((gv)localObject1).a(paramb);
    if (localObject2 == null)
    {
      localObject1 = ((gv)localObject1).a();
      locald.a(((d)localObject1).a, ((d)localObject1).b, ((d)localObject1).c);
      e.c("client request url: " + paramb + " failed, reason: " + locald.a + ":" + locald.b);
      return locald;
    }
    try
    {
      paramb = new JSONObject(new String((byte[])localObject2));
      paramInt = paramb.getInt("err");
      if (paramInt != 0)
      {
        paramb = paramb.getString("info");
        locald.a(paramInt, paramb, paramb);
        return locald;
      }
    }
    catch (JSONException paramb)
    {
      e.c("parse json failed: " + paramb.toString());
      locald.a(10020, "JSONException:" + paramb.toString(), null);
      return locald;
      ax.a().m();
      locald.a = 0;
      return locald;
    }
    catch (Exception paramb)
    {
      e.c("unknown err: " + paramb.toString());
      locald.a(10021, "JSONException:" + paramb.toString(), null);
    }
    return locald;
  }
  
  public final int b()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.au
 * JD-Core Version:    0.7.0.1
 */