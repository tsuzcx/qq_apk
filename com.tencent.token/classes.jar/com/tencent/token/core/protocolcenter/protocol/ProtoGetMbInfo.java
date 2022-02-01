package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.cd;
import com.tencent.token.core.bean.MbInfoResult;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dk;
import com.tencent.token.dp;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoGetMbInfo
  extends d
{
  MbInfoResult d;
  private long e;
  
  public static void a(dp paramdp, long paramLong)
  {
    paramdp.c.put("param.uinhash", Long.valueOf(paramLong));
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
    Object localObject = l.a(new Object[] { "uin", Long.valueOf(this.e), "seq_id", Integer.valueOf(this.c), "op_time", Long.valueOf(cd.c().s() / 1000L) });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?data=");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("&aq_base_sid=");
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c.e());
    ((StringBuilder)localObject).append("/cn/mbtoken3/mbtoken3_get_mbinfo_encrypt");
    ((StringBuilder)localObject).append(str);
    return ((StringBuilder)localObject).toString();
  }
  
  protected void a(dp paramdp)
  {
    this.e = ((Long)paramdp.c.get("param.uinhash")).longValue();
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
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      i = paramJSONObject.getInt("seq_id");
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
      this.d = new MbInfoResult(paramJSONObject.getJSONArray("mb_list"));
      dk.a().a(this.d);
      this.a.c();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parseJSON error decodeData=");
    localStringBuilder.append(paramJSONObject);
    g.c(localStringBuilder.toString());
    a(10022, RqdApplication.n().getString(2131493068));
  }
  
  protected void b()
  {
    if ((!this.b.e) && (this.b.d != null))
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.d;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetMbInfo
 * JD-Core Version:    0.7.0.1
 */