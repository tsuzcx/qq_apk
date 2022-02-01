package com.tencent.token.core.protocolcenter.protocol;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.do;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoCopyFace
  extends d
{
  private final String d = "/cn/mbtoken3/mbtoken3_copy_face_uins";
  private long e;
  private int f;
  
  public static void a(do paramdo, long paramLong)
  {
    paramdo.c.put("param.uinhash", Long.valueOf(paramLong));
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
    Object localObject = l.a(new Object[] { "uin", Long.valueOf(this.e), "seq_id", Integer.valueOf(this.f), "op_time", Long.valueOf(cc.c().s() / 1000L) });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?aq_base_sid=");
    localStringBuilder.append(str);
    localStringBuilder.append("&data=");
    localStringBuilder.append((String)localObject);
    str = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c.e());
    ((StringBuilder)localObject).append("/cn/mbtoken3/mbtoken3_copy_face_uins");
    ((StringBuilder)localObject).append(str);
    return ((StringBuilder)localObject).toString();
  }
  
  protected void a(do paramdo)
  {
    this.e = ((Long)paramdo.c.get("param.uinhash")).longValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    i = paramJSONObject.getInt("seq_id");
    if (i != this.f)
    {
      this.a.b(10030);
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("parseJSON error seq is wrong seq=");
      paramJSONObject.append(i);
      paramJSONObject.append(",right = ");
      paramJSONObject.append(cb.a().b());
      g.c(paramJSONObject.toString());
      return;
    }
    this.a.c();
  }
  
  protected void b()
  {
    if ((!this.b.e) && (this.b.d != null))
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoCopyFace
 * JD-Core Version:    0.7.0.1
 */