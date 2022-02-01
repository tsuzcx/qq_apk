package com.tencent.token.core.protocolcenter.protocol;

import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.do;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoDoVerifyOriginalMobile
  extends d
{
  public String d;
  public long e;
  private int f;
  private int g = 0;
  
  public static void a(do paramdo, long paramLong, String paramString, int paramInt)
  {
    paramdo.c.put("param.realuin", Long.valueOf(paramLong));
    paramdo.c.put("param.mbmobile.mobile", paramString);
    paramdo.c.put("param.type", Integer.valueOf(paramInt));
  }
  
  protected String a()
  {
    String str = ca.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    int i = cb.a + 1;
    cb.a = i;
    this.f = i;
    Object localObject = l.a(new Object[] { "seq_id", Integer.valueOf(this.f), "op_time", Long.valueOf(cc.c().s() / 1000L), "uin", Long.valueOf(this.e), "mobile", this.d, "verify_type_id", Integer.valueOf(this.g) });
    if (localObject == null)
    {
      this.a.a(10000, "encrypt qqtoken code failed");
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
    ((StringBuilder)localObject).append("/cn/mbtoken3/mbtoken3_verify_original_mobile");
    ((StringBuilder)localObject).append(str);
    return ((StringBuilder)localObject).toString();
  }
  
  protected void a(do paramdo)
  {
    this.e = ((Long)paramdo.c.get("param.realuin")).longValue();
    this.d = ((String)paramdo.c.get("param.mbmobile.mobile"));
    this.g = ((Integer)paramdo.c.get("param.type")).intValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      this.a.a(i, paramJSONObject, paramJSONObject);
      return;
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDoVerifyOriginalMobile
 * JD-Core Version:    0.7.0.1
 */