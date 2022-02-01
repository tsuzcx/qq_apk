package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.cd;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.cs;
import com.tencent.token.dp;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoDoWtLogin
  extends d
{
  private String d;
  private byte[] e;
  private int f;
  
  public static void a(dp paramdp, String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    paramdp.c.put("param.uin.wtlogin", paramString);
    paramdp.c.put("param.wtlogin.a2", paramArrayOfByte);
    paramdp.c.put("param.wtlogin.type", Integer.valueOf(paramInt));
  }
  
  protected String a()
  {
    String str = cb.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    int i = cc.a + 1;
    cc.a = i;
    this.c = i;
    Object localObject = l.a(new Object[] { "uin", this.d, "wtlogin_sig", l.a(this.e), "wtlogin_type", Integer.valueOf(this.f), "seq_id", Integer.valueOf(this.c), "op_time", Integer.valueOf((int)(cd.c().s() / 1000L)) });
    if (localObject == null)
    {
      this.a.b(10000);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?aq_base_sid=");
    localStringBuilder.append(str);
    localStringBuilder.append("&data=");
    localStringBuilder.append((String)localObject);
    str = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c.e());
    ((StringBuilder)localObject).append("/cn/mbtoken3/mbtoken3_vfy_wtlogin_encrypt");
    ((StringBuilder)localObject).append(str);
    return ((StringBuilder)localObject).toString();
  }
  
  protected void a(dp paramdp)
  {
    this.d = ((String)paramdp.c.get("param.uin.wtlogin"));
    this.e = ((byte[])paramdp.c.get("param.wtlogin.a2"));
    this.f = ((Integer)paramdp.c.get("param.wtlogin.type")).intValue();
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
    long l1;
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      i = paramJSONObject.getInt("seq_id");
      if (this.c != i)
      {
        this.a.b(10030);
        return;
      }
      l1 = Long.parseLong(paramJSONObject.getString("uin"));
      paramJSONObject = paramJSONObject.getString("uin_mask");
    }
    try
    {
      long l2 = Long.parseLong(this.d);
      localObject = cs.a().d(l2);
      if (localObject != null)
      {
        ((QQUser)localObject).mUin = l1;
        ((QQUser)localObject).mUinMask = paramJSONObject;
      }
      this.b.c.put("param.uinhash", Long.valueOf(l1));
      this.b.c.put("param.wtlogin.a2", this.e);
      cs.a().e(l2);
      this.a.c();
      return;
    }
    catch (Exception paramJSONObject)
    {
      Object localObject;
      label182:
      break label182;
    }
    this.a.b(10000);
    return;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("parseJSON error decodeData=");
    ((StringBuilder)localObject).append(paramJSONObject);
    g.c(((StringBuilder)localObject).toString());
    a(10022, RqdApplication.n().getString(2131493068));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDoWtLogin
 * JD-Core Version:    0.7.0.1
 */