package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.ca;
import com.tencent.token.cb;
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

public class ProtoModifyQQPwd
  extends d
{
  public String d;
  public long e;
  public int f;
  
  public static void a(do paramdo, long paramLong, String paramString, int paramInt)
  {
    paramdo.c.put("param.uinhash", Long.valueOf(paramLong));
    paramdo.c.put("param.qqpwd", paramString);
    paramdo.c.put("param.scene.id", Integer.valueOf(paramInt));
  }
  
  protected String a()
  {
    Object localObject = ca.a().b();
    if (localObject == null)
    {
      this.a.b(104);
      return null;
    }
    int i = cb.a + 1;
    cb.a = i;
    this.c = i;
    if (this.f == 0) {
      str = l.a(new Object[] { "uin", Long.valueOf(this.e), "seq_id", Integer.valueOf(this.c), "pwd", this.d, "op_time", Long.valueOf(cc.c().s() / 1000L) });
    } else {
      str = l.a(new Object[] { "uin", Long.valueOf(this.e), "seq_id", Integer.valueOf(this.c), "pwd", this.d, "op_time", Long.valueOf(cc.c().s() / 1000L), "scene_id", Integer.valueOf(this.f) });
    }
    if (str == null)
    {
      this.a.a(10000, "encrypt qqtoken code failed");
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?aq_base_sid=");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("&data=");
    localStringBuilder.append(str);
    String str = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c.e());
    ((StringBuilder)localObject).append("/cn/mbtoken3/mbtoken3_modify_pwd_encrypt");
    ((StringBuilder)localObject).append(str);
    return ((StringBuilder)localObject).toString();
  }
  
  protected void a(do paramdo)
  {
    this.e = ((Long)paramdo.c.get("param.uinhash")).longValue();
    this.d = ((String)paramdo.c.get("param.qqpwd"));
    this.f = ((Integer)paramdo.c.get("param.scene.id")).intValue();
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
      i = new JSONObject(new String(paramJSONObject)).getInt("seq_id");
      if (this.c != i)
      {
        this.a.b(10030);
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.c);
        g.c(paramJSONObject.toString());
        return;
      }
      this.a.c();
      return;
    }
    a(10022, RqdApplication.l().getString(2131493067));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoModifyQQPwd
 * JD-Core Version:    0.7.0.1
 */