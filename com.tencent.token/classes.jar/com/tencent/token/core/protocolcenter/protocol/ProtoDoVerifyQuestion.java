package com.tencent.token.core.protocolcenter.protocol;

import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.QuesInfoItem;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.do;
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
  
  public static void a(do paramdo, long paramLong, List<DeterminVerifyFactorsResult.QuesInfoItem> paramList, String[] paramArrayOfString)
  {
    paramdo.c.put("param.realuin", Long.valueOf(paramLong));
    paramdo.c.put("param.qqquestion", paramList);
    paramdo.c.put("param.qqquestionanswer", paramArrayOfString);
  }
  
  protected String a()
  {
    String str1 = ca.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    int i = cb.a + 1;
    cb.a = i;
    this.g = i;
    String str2 = l.a(this.g, this.e, this.f, this.d);
    if (str2 == null)
    {
      this.a.a(10000, "encrypt ques answer failed");
      return null;
    }
    str1 = "?aq_base_sid=" + str1 + "&data=" + str2;
    return c.e() + "/cn/mbtoken3/mbtoken3_vry_ques_v2" + str1;
  }
  
  protected void a(do paramdo)
  {
    this.e = ((Long)paramdo.c.get("param.realuin")).longValue();
    this.f = ((List)paramdo.c.get("param.qqquestion"));
    this.d = ((String[])paramdo.c.get("param.qqquestionanswer"));
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