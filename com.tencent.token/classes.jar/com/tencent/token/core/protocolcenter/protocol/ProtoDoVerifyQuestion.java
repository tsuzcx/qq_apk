package com.tencent.token.core.protocolcenter.protocol;

import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.QuesInfoItem;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dp;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.utils.l;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class ProtoDoVerifyQuestion
  extends d
{
  public String[] d;
  public long e;
  public List<DeterminVerifyFactorsResult.QuesInfoItem> f;
  private int g;
  
  public static void a(dp paramdp, long paramLong, List<DeterminVerifyFactorsResult.QuesInfoItem> paramList, String[] paramArrayOfString)
  {
    paramdp.c.put("param.realuin", Long.valueOf(paramLong));
    paramdp.c.put("param.qqquestion", paramList);
    paramdp.c.put("param.qqquestionanswer", paramArrayOfString);
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
    this.g = i;
    Object localObject = l.a(this.g, this.e, this.f, this.d);
    if (localObject == null)
    {
      this.a.a(10000, "encrypt ques answer failed");
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
    ((StringBuilder)localObject).append("/cn/mbtoken3/mbtoken3_vry_ques_v2");
    ((StringBuilder)localObject).append(str);
    return ((StringBuilder)localObject).toString();
  }
  
  protected void a(dp paramdp)
  {
    this.e = ((Long)paramdp.c.get("param.realuin")).longValue();
    this.f = ((List)paramdp.c.get("param.qqquestion"));
    this.d = ((String[])paramdp.c.get("param.qqquestionanswer"));
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
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDoVerifyQuestion
 * JD-Core Version:    0.7.0.1
 */