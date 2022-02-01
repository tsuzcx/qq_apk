package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.token.cb;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dp;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoSetSuperCode
  extends d
{
  public long d;
  private int e;
  private int f = 0;
  private int g = 0;
  
  protected String a()
  {
    Object localObject4 = cb.a().b();
    if (localObject4 == null)
    {
      this.a.b(104);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this);
      ((StringBuilder)localObject1).append("sessId null ");
      g.c(((StringBuilder)localObject1).toString());
      return null;
    }
    Object localObject1 = "";
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("uin", this.d);
      ((JSONObject)localObject2).put("seq_id", this.e);
      ((JSONObject)localObject2).put("config_val", this.f);
      localObject2 = l.b(((JSONObject)localObject2).toString().getBytes());
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      g.c(localException.getMessage());
      localException.printStackTrace();
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("?aq_base_sid=");
    ((StringBuilder)localObject3).append((String)localObject4);
    localObject3 = ((StringBuilder)localObject3).toString();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append((String)localObject3);
      ((StringBuilder)localObject4).append("&data=");
      ((StringBuilder)localObject4).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject4).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(c.e());
      ((StringBuilder)localObject3).append("/cn/mbtoken3/mbtoken3_set_super_code");
      ((StringBuilder)localObject3).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject3).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this);
      ((StringBuilder)localObject3).append("ProtoSetSuperCode url ");
      ((StringBuilder)localObject3).append((String)localObject1);
      g.c(((StringBuilder)localObject3).toString());
      return localObject1;
    }
    this.a.b(10000);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this);
    ((StringBuilder)localObject1).append("ProtoSetSuperCode url data is null ");
    g.c(((StringBuilder)localObject1).toString());
    return null;
  }
  
  protected void a(dp paramdp)
  {
    this.d = ((Long)paramdp.c.get("param.uinhash")).longValue();
    this.e = ((Integer)paramdp.c.get("param.common.seq")).intValue();
    this.f = ((Integer)paramdp.c.get("param.set_supercode")).intValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("error");
      ((StringBuilder)localObject).append(paramJSONObject);
      ((StringBuilder)localObject).append(",error code =");
      ((StringBuilder)localObject).append(i);
      g.a(((StringBuilder)localObject).toString());
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("server errcode=");
      localStringBuilder.append(i);
      localStringBuilder.append(":");
      localStringBuilder.append(paramJSONObject);
      ((e)localObject).a(i, localStringBuilder.toString(), paramJSONObject);
      return;
    }
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append("--data:");
      ((StringBuilder)localObject).append(new String(paramJSONObject));
      g.a(((StringBuilder)localObject).toString());
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      if (paramJSONObject.getInt("seq_id") != this.e)
      {
        this.a.b(10030);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this);
        ((StringBuilder)localObject).append("parseJSON error seq is wrong seq=");
        ((StringBuilder)localObject).append(paramJSONObject.getInt("seq_id"));
        ((StringBuilder)localObject).append(",right = ");
        ((StringBuilder)localObject).append(this.e);
        g.c(((StringBuilder)localObject).toString());
        return;
      }
      this.g = paramJSONObject.optInt("config_val_ret");
      this.a.c();
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("parseJSON error decodeData=");
    ((StringBuilder)localObject).append(paramJSONObject);
    g.c(((StringBuilder)localObject).toString());
    a(10022, RqdApplication.n().getString(2131493068));
  }
  
  protected void b()
  {
    if ((!this.b.e) && (this.b.d != null))
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