package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.ca;
import com.tencent.token.cc;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoGeneralGetMobileCode
  extends d
{
  public static String d;
  public static String e;
  public static String f;
  private long g;
  private long h;
  private int i;
  private int j;
  private final String k = "/cn/mbtoken3/mbtoken3_general_get_mobile_code";
  
  public static void a(do paramdo, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    paramdo.c.put("param.uinhash", Long.valueOf(paramLong1));
    paramdo.c.put("param.realuin", Long.valueOf(paramLong2));
    paramdo.c.put("param.general.mobilecode.sceneid", Integer.valueOf(paramInt1));
    paramdo.j = paramInt2;
  }
  
  protected String a()
  {
    String str = ca.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject = l.a(new Object[] { "real_uin", Long.valueOf(this.h), "scene_id", Integer.valueOf(this.j), "seq_id", Integer.valueOf(this.i), "op_time", Long.valueOf(cc.c().s() / 1000L) });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?uin=");
    localStringBuilder.append(this.g);
    localStringBuilder.append("&aq_base_sid=");
    localStringBuilder.append(str);
    localStringBuilder.append("&data=");
    localStringBuilder.append((String)localObject);
    str = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c.e());
    ((StringBuilder)localObject).append("/cn/mbtoken3/mbtoken3_general_get_mobile_code");
    ((StringBuilder)localObject).append(str);
    return ((StringBuilder)localObject).toString();
  }
  
  protected void a(do paramdo)
  {
    this.g = ((Long)paramdo.c.get("param.uinhash")).longValue();
    this.h = ((Long)paramdo.c.get("param.realuin")).longValue();
    this.j = ((Integer)paramdo.c.get("param.general.mobilecode.sceneid")).intValue();
    this.i = paramdo.j;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int m = paramJSONObject.getInt("err");
    if (m != 0)
    {
      localObject = paramJSONObject.getString("info");
      if (m == 124)
      {
        paramJSONObject = l.c(paramJSONObject.getString("data"));
        if (paramJSONObject != null)
        {
          paramJSONObject = new JSONObject(new String(paramJSONObject));
          d = paramJSONObject.getString("sms_port");
          e = paramJSONObject.getString("sms_up_code");
          try
          {
            f = paramJSONObject.getString("mobile_sms_prefix");
          }
          catch (Exception paramJSONObject)
          {
            paramJSONObject.printStackTrace();
          }
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("realname port=");
          paramJSONObject.append(d);
          paramJSONObject.append(", content=");
          paramJSONObject.append(e);
          g.b(paramJSONObject.toString());
        }
      }
      a(m, (String)localObject);
      return;
    }
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("json");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      g.a(((StringBuilder)localObject).toString());
      m = paramJSONObject.getInt("seq_id");
      if (m != this.i)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("parseJSON error seq is wrong seq=");
        paramJSONObject.append(m);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.i);
        g.c(paramJSONObject.toString());
        this.a.b(10030);
        return;
      }
      d = paramJSONObject.getString("sms_port");
      e = paramJSONObject.getString("sms_up_code");
      try
      {
        f = paramJSONObject.getString("mobile_sms_prefix");
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("realname port=");
      paramJSONObject.append(d);
      paramJSONObject.append(", content=");
      paramJSONObject.append(e);
      g.b(paramJSONObject.toString());
      this.a.c();
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("parseJSON error decodeData=");
    ((StringBuilder)localObject).append(paramJSONObject);
    g.c(((StringBuilder)localObject).toString());
    a(10022, RqdApplication.l().getString(2131493067));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGeneralGetMobileCode
 * JD-Core Version:    0.7.0.1
 */