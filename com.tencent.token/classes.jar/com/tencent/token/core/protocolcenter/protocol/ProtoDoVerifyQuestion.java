package com.tencent.token.core.protocolcenter.protocol;

import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.cw;
import com.tencent.token.ev;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.utils.w;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class ProtoDoVerifyQuestion
  extends e
{
  public String[] d;
  public long e;
  public List f;
  private int g;
  
  public static void a(ev paramev, long paramLong, List paramList, String[] paramArrayOfString)
  {
    paramev.c.put("param.realuin", Long.valueOf(paramLong));
    paramev.c.put("param.qqquestion", paramList);
    paramev.c.put("param.qqquestionanswer", paramArrayOfString);
  }
  
  protected String a()
  {
    String str1 = cv.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    int i = cw.a + 1;
    cw.a = i;
    this.g = i;
    String str2 = w.a(this.g, this.e, this.f, this.d);
    if (str2 == null)
    {
      this.a.a(10000, "encrypt ques answer failed");
      return null;
    }
    str1 = "?aq_base_sid=" + str1 + "&data=" + str2;
    return c.e() + "/cn/mbtoken3/mbtoken3_vry_ques_v2" + str1;
  }
  
  protected void a(ev paramev)
  {
    this.e = ((Long)paramev.c.get("param.realuin")).longValue();
    this.f = ((List)paramev.c.get("param.qqquestion"));
    this.d = ((String[])paramev.c.get("param.qqquestionanswer"));
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