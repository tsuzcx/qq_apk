package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.bz;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dn;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoReportLocation
  extends d
{
  private long d;
  private String e;
  private int f = -1;
  
  public static void a(dn paramdn, long paramLong, int paramInt1, int paramInt2, int paramInt3, SafeMsgItem paramSafeMsgItem)
  {
    paramdn.c.put("param.uinhash", Long.valueOf(paramLong));
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject3 = new JSONObject();
    JSONObject localJSONObject4 = new JSONObject();
    try
    {
      localJSONObject2.put("type_a", paramSafeMsgItem.f());
      localJSONObject2.put("type_b", paramSafeMsgItem.g());
      localJSONObject2.put("type_c", paramSafeMsgItem.h());
      int i = paramSafeMsgItem.k();
      localJSONObject3.put("ip", i);
      localJSONObject3.put("country_id", paramSafeMsgItem.l());
      localJSONObject3.put("prov_id", paramSafeMsgItem.m());
      localJSONObject3.put("city_id", paramSafeMsgItem.n());
      localJSONObject4.put("ip", i);
      localJSONObject4.put("country_id", 1);
      localJSONObject4.put("prov_id", paramInt1);
      localJSONObject4.put("city_id", paramInt2);
      localJSONObject1.put("msg_time", paramSafeMsgItem.e());
      localJSONObject1.put("msg_type", localJSONObject2);
      localJSONObject1.put("old_loc", localJSONObject3);
      localJSONObject1.put("new_loc", localJSONObject4);
      if ((paramInt3 == 1) || (paramInt3 == 2)) {
        localJSONObject1.put("feed_priv_ip_type", paramInt3);
      }
      paramdn.c.put("param.loginmsg.reportlocation", localJSONObject1.toString());
      return;
    }
    catch (Exception paramSafeMsgItem)
    {
      paramSafeMsgItem.printStackTrace();
      paramdn.c.put("param.loginmsg.reportlocation", "");
    }
  }
  
  protected String a()
  {
    String str1 = bz.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    String str2 = l.a(new Object[] { "uin", Long.valueOf(this.d), "data", this.e });
    if (str2 == null)
    {
      this.a.a(10000, "encrypt  failed");
      return null;
    }
    str1 = "?data=" + str2 + "&aq_base_sid=" + str1;
    g.c("params: " + str1);
    return c.e() + "/cn/mbtoken3/mbtoken3_report_location_v2" + str1;
  }
  
  protected void a(dn paramdn)
  {
    this.d = ((Long)paramdn.c.get("param.uinhash")).longValue();
    this.e = ((String)paramdn.c.get("param.loginmsg.reportlocation"));
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      try
      {
        this.f = paramJSONObject.getInt("is_priv_ip_user");
        this.a.c();
        return;
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          this.f = -1;
          paramJSONObject.printStackTrace();
        }
      }
    }
    g.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
  
  protected void b()
  {
    if (!this.b.e)
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.arg2 = this.f;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoReportLocation
 * JD-Core Version:    0.7.0.1
 */