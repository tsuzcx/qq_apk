package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class ty
  extends tk
{
  private String d;
  private String e;
  private long f;
  private int g;
  private int h;
  private sc i;
  private int j;
  
  public final String a()
  {
    sa.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aar paramaar)
  {
    this.f = ((Long)paramaar.c.get("param.realuin")).longValue();
    this.g = ((Integer)paramaar.c.get("param.bind.type")).intValue();
    this.d = ((String)paramaar.c.get("param.bind.mobile"));
    this.e = ((String)paramaar.c.get("param.bind.areacode"));
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int k = paramJSONObject.getInt("err");
    if (k != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder("server errcode=");
      localStringBuilder.append(k);
      localStringBuilder.append(":");
      localStringBuilder.append(paramJSONObject);
      ((wz)localObject).a(k, localStringBuilder.toString(), paramJSONObject);
      return;
    }
    Object localObject = aad.d(paramJSONObject.getString("data"));
    if (localObject != null)
    {
      localObject = new JSONObject(new String((byte[])localObject));
      k = ((JSONObject)localObject).getInt("seq_id");
      if (k != this.j)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(k);
        paramJSONObject.append(",right = ");
        sb.a();
        paramJSONObject.append(sb.b());
        xb.c(paramJSONObject.toString());
        return;
      }
      this.h = ((JSONObject)localObject).getInt("bind_mobile_succ");
      if (1 != this.h) {
        try
        {
          this.a.a(paramJSONObject.getString("info"));
        }
        catch (Exception paramJSONObject)
        {
          paramJSONObject.printStackTrace();
        }
      }
      long l = ((JSONObject)localObject).getLong("server_time");
      sc.b();
      sc.a(l);
      if (((JSONObject)localObject).getInt("seed_available") == 1)
      {
        paramJSONObject = aad.e(((JSONObject)localObject).getString("seed"));
        if (paramJSONObject != null)
        {
          this.i.c();
          this.i.a(paramJSONObject);
          sc.b().a.a();
        }
      }
      paramJSONObject = ta.a().d(this.f);
      if (paramJSONObject != null) {
        ta.a().b(paramJSONObject);
      }
      this.a.a = 0;
      return;
    }
    xb.c("parseJSON error decodeData=".concat(String.valueOf(localObject)));
    a(10022, RqdApplication.n().getString(2131493068));
  }
  
  public final void b()
  {
    if ((!this.b.e) && (this.b.d != null))
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.a;
      localMessage.arg2 = this.h;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ty
 * JD-Core Version:    0.7.0.1
 */