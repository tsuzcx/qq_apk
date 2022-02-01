package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.cb;
import com.tencent.token.cd;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dp;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoGetRealNameVerify
  extends d
{
  public static String d;
  public static int e;
  private long f;
  private long g;
  private int h;
  private int i;
  
  protected String a()
  {
    String str = cb.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    Object localObject = l.a(new Object[] { "real_uin", Long.valueOf(this.g), "seq_id", Integer.valueOf(this.h), "op_time", Long.valueOf(cd.c().s() / 1000L), "scene_id", Integer.valueOf(this.i) });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?uin=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("&aq_base_sid=");
    localStringBuilder.append(str);
    localStringBuilder.append("&data=");
    localStringBuilder.append((String)localObject);
    str = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c.e());
    ((StringBuilder)localObject).append("/cn/mbtoken3/mbtoken3_realname_lip");
    ((StringBuilder)localObject).append(str);
    return ((StringBuilder)localObject).toString();
  }
  
  protected void a(dp paramdp)
  {
    this.f = ((Long)paramdp.c.get("param.uinhash")).longValue();
    this.g = ((Long)paramdp.c.get("param.realuin")).longValue();
    this.i = ((Integer)paramdp.c.get("param.scene.id")).intValue();
    this.h = paramdp.j;
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int j = paramJSONObject.getInt("err");
    if (j == 0)
    {
      paramJSONObject = l.c(paramJSONObject.getString("data"));
      if (paramJSONObject != null)
      {
        paramJSONObject = new JSONObject(new String(paramJSONObject));
        d = paramJSONObject.getString("validate_code");
        e = paramJSONObject.getInt("validate_id");
        this.a.c();
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseJSON error decodeData=");
      localStringBuilder.append(paramJSONObject);
      g.c(localStringBuilder.toString());
      a(10022, RqdApplication.n().getString(2131493068));
      return;
    }
    a(j, paramJSONObject.getString("info"));
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("ProtoGetRealNameVerify fail errCode=");
    paramJSONObject.append(j);
    g.a(paramJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetRealNameVerify
 * JD-Core Version:    0.7.0.1
 */