package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.cb;
import com.tencent.token.cd;
import com.tencent.token.core.bean.LoginProtectResult;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dp;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoGetLoginProtect
  extends d
{
  private long d;
  private LoginProtectResult e;
  private String f;
  private int g;
  
  public static void a(dp paramdp, long paramLong, String paramString, int paramInt)
  {
    paramdp.c.put("param.uinhash", Long.valueOf(paramLong));
    paramdp.c.put("param.wtlogin.a2", paramString);
    paramdp.c.put("param.common.seq", Integer.valueOf(paramInt));
  }
  
  protected String a()
  {
    String str = cb.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject1 = "";
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("A2", this.f);
      ((JSONObject)localObject2).put("uin", this.d);
      ((JSONObject)localObject2).put("seq_id", this.g);
      ((JSONObject)localObject2).put("op_time", (int)(cd.c().s() / 1000L));
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("loginprotect data=");
      localStringBuilder2.append(localObject2);
      g.a(localStringBuilder2.toString());
      localObject2 = l.b(((JSONObject)localObject2).toString().getBytes());
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("?aq_base_sid=");
    localStringBuilder1.append(str);
    localStringBuilder1.append("&data=");
    localStringBuilder1.append((String)localObject1);
    localObject1 = localStringBuilder1.toString();
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(c.e());
    localStringBuilder1.append("/cn/mbtoken3/mbtoken3_get_login_prot_encrypt");
    localStringBuilder1.append((String)localObject1);
    return localStringBuilder1.toString();
  }
  
  protected void a(dp paramdp)
  {
    this.d = ((Long)paramdp.c.get("param.uinhash")).longValue();
    this.f = ((String)paramdp.c.get("param.wtlogin.a2"));
    this.g = ((Integer)paramdp.c.get("param.common.seq")).intValue();
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
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("login protect: ");
      localStringBuilder.append(paramJSONObject);
      g.a(localStringBuilder.toString());
      if (paramJSONObject.getInt("seq_id") != this.g)
      {
        this.a.b(10030);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("parseJSON error seq is wrong seq=");
        localStringBuilder.append(paramJSONObject.getInt("seq_id"));
        localStringBuilder.append(",right = ");
        localStringBuilder.append(this.g);
        g.c(localStringBuilder.toString());
        return;
      }
      this.e = new LoginProtectResult(paramJSONObject);
      this.a.c();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parseJSON error decodeData=");
    localStringBuilder.append(paramJSONObject);
    g.c(localStringBuilder.toString());
    a(10022, RqdApplication.n().getString(2131493068));
  }
  
  protected void b()
  {
    if ((!this.b.e) && (this.b.d != null))
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.e;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetLoginProtect
 * JD-Core Version:    0.7.0.1
 */