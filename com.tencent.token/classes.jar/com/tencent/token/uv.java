package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import com.tmsdk.common.util.TmsLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class uv
  extends ud
{
  private String d;
  private String e;
  private long f;
  private int g;
  private int h;
  private int i;
  
  public final String a()
  {
    st.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abm paramabm)
  {
    this.f = ((Long)paramabm.c.get("param.realuin")).longValue();
    this.g = ((Integer)paramabm.c.get("param.type")).intValue();
    this.d = ((String)paramabm.c.get("param.bind.mobile"));
    this.e = ((String)paramabm.c.get("param.bind.areacode"));
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int j = paramJSONObject.getInt("err");
    TmsLog.i("mod_seed", "ProtoDoGeneralBindToken, errcode: ".concat(String.valueOf(j)));
    if (j != 0)
    {
      paramJSONObject = paramJSONObject.getString("info");
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder("server errcode=");
      localStringBuilder.append(j);
      localStringBuilder.append(":");
      localStringBuilder.append(paramJSONObject);
      ((xt)localObject).a(j, localStringBuilder.toString(), paramJSONObject);
      return;
    }
    Object localObject = aay.d(paramJSONObject.getString("data"));
    if (localObject != null)
    {
      localObject = new JSONObject(new String((byte[])localObject));
      j = ((JSONObject)localObject).getInt("seq_id");
      if (j != this.i)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(j);
        paramJSONObject.append(",right = ");
        su.a();
        paramJSONObject.append(su.b());
        xv.c(paramJSONObject.toString());
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
      sv.b();
      sv.a(l);
      try
      {
        ((JSONObject)localObject).getLong("seed_expire_time");
        sv.b();
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      paramJSONObject = tt.a().d(this.f);
      if (paramJSONObject != null) {
        tt.a().a(paramJSONObject);
      }
      this.a.a = 0;
      return;
    }
    xv.c("parseJSON error decodeData=".concat(String.valueOf(localObject)));
    a(10022, RqdApplication.n().getString(2131493069));
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
 * Qualified Name:     com.tencent.token.uv
 * JD-Core Version:    0.7.0.1
 */