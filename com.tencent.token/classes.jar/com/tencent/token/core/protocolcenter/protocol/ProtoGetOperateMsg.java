package com.tencent.token.core.protocolcenter.protocol;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.bz;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dn;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoGetOperateMsg
  extends d
{
  private long d;
  private String e;
  
  protected String a()
  {
    String str = bz.a().b();
    if (str == null)
    {
      this.a.b(104);
      return null;
    }
    str = "?aq_base_sid=" + str + "&uin=" + this.d;
    return c.e() + "/cn/mbtoken3/mbtoken3_get_ads_info" + str;
  }
  
  protected void a(dn paramdn)
  {
    this.d = ((Long)paramdn.c.get("param.uinhash")).longValue();
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, null);
      return;
    }
    this.e = paramJSONObject.getString("ads_info");
    this.a.c();
  }
  
  protected void b()
  {
    if (!this.b.e)
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.e;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetOperateMsg
 * JD-Core Version:    0.7.0.1
 */