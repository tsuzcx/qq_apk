package com.tencent.token.core.protocolcenter.protocol;

import com.tencent.token.cb;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dp;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoDelUnverifyUin
  extends d
{
  private String d;
  
  public static void a(dp paramdp, long paramLong)
  {
    paramdp.c.put("param.realuin", Long.valueOf(paramLong));
  }
  
  protected String a()
  {
    String str = cb.a().b();
    Object localObject = l.a(new Object[] { "uin", this.d });
    if ((str != null) && (localObject != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("?aq_base_sid=");
      localStringBuilder.append(str);
      localStringBuilder.append("&data=");
      localStringBuilder.append((String)localObject);
      str = localStringBuilder.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(c.e());
      ((StringBuilder)localObject).append("/cn/mbtoken3/mbtoken3_del_unvfy_uin");
      ((StringBuilder)localObject).append(str);
      return ((StringBuilder)localObject).toString();
    }
    this.a.b(104);
    return null;
  }
  
  protected void a(dp paramdp)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramdp.c.get("param.realuin"));
    this.d = localStringBuilder.toString();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ProtoDelUnverifyUin:errCode");
    localStringBuilder.append(i);
    g.a(localStringBuilder.toString());
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDelUnverifyUin
 * JD-Core Version:    0.7.0.1
 */