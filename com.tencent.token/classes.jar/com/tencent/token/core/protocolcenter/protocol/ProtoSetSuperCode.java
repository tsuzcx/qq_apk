package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.ev;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoSetSuperCode
  extends e
{
  public long d;
  private int e;
  private int f = 0;
  private int g = 0;
  
  protected String a()
  {
    String str = cv.a().b();
    if (str == null)
    {
      this.a.b(104);
      h.c(this + "sessId null ");
      return null;
    }
    Object localObject1 = "";
    try
    {
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("uin", this.d);
      ((JSONObject)localObject2).put("seq_id", this.e);
      ((JSONObject)localObject2).put("config_val", this.f);
      localObject2 = w.b(((JSONObject)localObject2).toString().getBytes());
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        h.c(localException.getMessage());
        localException.printStackTrace();
      }
      this.a.b(10000);
      h.c(this + "ProtoSetSuperCode url data is null ");
    }
    localObject2 = "?aq_base_sid=" + str;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = (String)localObject2 + "&data=" + (String)localObject1;
      localObject1 = c.e() + "/cn/mbtoken3/mbtoken3_set_super_code" + (String)localObject1;
      h.c(this + "ProtoSetSuperCode url " + (String)localObject1);
      return localObject1;
    }
    return null;
  }
  
  protected void a(ev paramev)
  {
    this.d = ((Long)paramev.c.get("param.uinhash")).longValue();
    this.e = ((Integer)paramev.c.get("param.common.seq")).intValue();
    this.f = ((Integer)paramev.c.get("param.set_supercode")).intValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      h.a("error" + paramJSONObject + ",error code =" + i);
      this.a.a(i, "server errcode=" + i + ":" + paramJSONObject, paramJSONObject);
      return;
    }
    paramJSONObject = w.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      h.a(this + "--data:" + new String(paramJSONObject));
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      if (paramJSONObject.getInt("seq_id") != this.e)
      {
        this.a.b(10030);
        h.c(this + "parseJSON error seq is wrong seq=" + paramJSONObject.getInt("seq_id") + ",right = " + this.e);
        return;
      }
      this.g = paramJSONObject.optInt("config_val_ret");
      this.a.c();
      return;
    }
    h.c("parseJSON error decodeData=" + paramJSONObject);
    a(10022, RqdApplication.l().getString(2131230925));
  }
  
  protected void b()
  {
    if (!this.b.e)
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.arg2 = this.g;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoSetSuperCode
 * JD-Core Version:    0.7.0.1
 */