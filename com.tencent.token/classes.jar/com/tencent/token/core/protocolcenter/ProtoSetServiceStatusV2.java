package com.tencent.token.core.protocolcenter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.ca;
import com.tencent.token.cc;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoSetServiceStatusV2
  extends d
{
  private long d;
  private int[] e;
  private int[] f;
  private String g;
  private int h;
  
  public static void a(do paramdo, long paramLong, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String paramString, int paramInt)
  {
    paramdo.c.put("param.uinhash", Long.valueOf(paramLong));
    paramdo.c.put("param.mbinfo.id", paramArrayOfInt1);
    paramdo.c.put("param.mbinfo.val", paramArrayOfInt2);
    paramdo.c.put("param.wtlogin.a2", paramString);
    paramdo.c.put("param.common.seq", Integer.valueOf(paramInt));
  }
  
  protected String a()
  {
    String str = ca.a().b();
    if (str == null)
    {
      this.a.b(10000);
      return null;
    }
    Object localObject1 = new StringBuffer("");
    Object localObject2 = this.e;
    if (localObject2 != null)
    {
      int[] arrayOfInt = this.f;
      if ((arrayOfInt != null) && (localObject2.length == arrayOfInt.length))
      {
        int i = 0;
        while (i < this.e.length)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("{\"id\":");
          ((StringBuilder)localObject2).append(this.e[i]);
          ((StringBuilder)localObject2).append(",\"value\":");
          ((StringBuilder)localObject2).append(this.f[i]);
          ((StringBuilder)localObject2).append("}");
          ((StringBuffer)localObject1).append(((StringBuilder)localObject2).toString());
          if (i < this.e.length - 1) {
            ((StringBuffer)localObject1).append(",");
          }
          i += 1;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("{\"conf_data\":[");
        ((StringBuilder)localObject2).append(((StringBuffer)localObject1).toString());
        ((StringBuilder)localObject2).append("], \"A2\":\"");
        ((StringBuilder)localObject2).append(this.g);
        ((StringBuilder)localObject2).append("\", \"seq_id\":");
        ((StringBuilder)localObject2).append(this.h);
        ((StringBuilder)localObject2).append(", \"op_time\":");
        ((StringBuilder)localObject2).append((int)(cc.c().s() / 1000L));
        ((StringBuilder)localObject2).append(",\"uin\":");
        ((StringBuilder)localObject2).append(this.d);
        ((StringBuilder)localObject2).append("}");
        localObject1 = ((StringBuilder)localObject2).toString();
        g.a((String)localObject1);
        localObject1 = l.b(((String)localObject1).getBytes());
        if (localObject1 == null)
        {
          this.a.b(10000);
          return null;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("?aq_base_sid=");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append("&data=");
        ((StringBuilder)localObject2).append((String)localObject1);
        str = ((StringBuilder)localObject2).toString();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(c.e());
        ((StringBuilder)localObject1).append("/cn/mbtoken3/mbtoken3_set_service_status_encrypt");
        ((StringBuilder)localObject1).append(str);
        return ((StringBuilder)localObject1).toString();
      }
    }
    this.a.b(10000);
    return null;
  }
  
  protected void a(do paramdo)
  {
    this.d = ((Long)paramdo.c.get("param.uinhash")).longValue();
    this.e = ((int[])paramdo.c.get("param.mbinfo.id"));
    this.f = ((int[])paramdo.c.get("param.mbinfo.val"));
    this.g = ((String)paramdo.c.get("param.wtlogin.a2"));
    this.h = ((Integer)paramdo.c.get("param.common.seq")).intValue();
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
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ProtoSetServiceStatusV2:");
      localStringBuilder.append(paramJSONObject);
      g.b(localStringBuilder.toString());
      paramJSONObject.getLong("uin");
      if (paramJSONObject.getInt("seq_id") != this.h)
      {
        this.a.b(10030);
        return;
      }
      this.a.c();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parseJSON error decodeData=");
    localStringBuilder.append(paramJSONObject);
    g.c(localStringBuilder.toString());
    a(10022, RqdApplication.l().getString(2131493067));
  }
  
  protected void b()
  {
    if ((!this.b.e) && (this.b.d != null))
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
 * Qualified Name:     com.tencent.token.core.protocolcenter.ProtoSetServiceStatusV2
 * JD-Core Version:    0.7.0.1
 */