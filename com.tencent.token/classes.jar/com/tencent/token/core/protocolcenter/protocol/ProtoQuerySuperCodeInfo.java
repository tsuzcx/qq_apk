package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.token.ca;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoQuerySuperCodeInfo
  extends d
{
  public long d;
  private int e;
  private int f = 0;
  
  protected String a()
  {
    String str = ca.a().b();
    if (str == null)
    {
      this.a.b(104);
      g.c(this + "sessId null ");
      return null;
    }
    Object localObject1 = "";
    try
    {
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("uin", this.d);
      ((JSONObject)localObject2).put("seq_id", this.e);
      localObject2 = l.b(((JSONObject)localObject2).toString().getBytes());
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        g.c(localException.getMessage());
        localException.printStackTrace();
      }
      this.a.b(10000);
      g.c(this + "ProtoQuerySuperCodeInfo url data is null ");
    }
    localObject2 = "?aq_base_sid=" + str;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = (String)localObject2 + "&data=" + (String)localObject1;
      localObject1 = c.e() + "/cn/mbtoken3/mbtoken3_qry_super_code_info" + (String)localObject1;
      g.c(this + "ProtoQuerySuperCodeInfo url " + (String)localObject1);
      return localObject1;
    }
    return null;
  }
  
  protected void a(do paramdo)
  {
    this.d = ((Long)paramdo.c.get("param.uinhash")).longValue();
    this.e = ((Integer)paramdo.c.get("param.common.seq")).intValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      g.a("error" + paramJSONObject + ",error code =" + i);
      this.a.a(i, "server errcode=" + i + ":" + paramJSONObject, paramJSONObject);
      return;
    }
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      g.a(this + "--data:" + new String(paramJSONObject));
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      if (paramJSONObject.getInt("seq_id") != this.e)
      {
        this.a.b(10030);
        g.c(this + "parseJSON error seq is wrong seq=" + paramJSONObject.getInt("seq_id") + ",right = " + this.e);
        return;
      }
      this.f = paramJSONObject.optInt("config_val");
      this.a.c();
      return;
    }
    g.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
  
  protected void b()
  {
    if ((!this.b.e) && (this.b.d != null))
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
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoQuerySuperCodeInfo
 * JD-Core Version:    0.7.0.1
 */