package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class ut
  extends ud
{
  private long d;
  private int e;
  private String f;
  
  public final String a()
  {
    st.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abm paramabm)
  {
    this.d = ((Long)paramabm.c.get("param.realuin")).longValue();
    this.e = paramabm.j;
    this.f = ((String)paramabm.c.get("param.bind.areacode"));
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = aay.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      i = paramJSONObject.getInt("seq_id");
      if (i != this.e)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.e);
        xv.c(paramJSONObject.toString());
        return;
      }
      long l = paramJSONObject.getLong("server_time");
      sv.b();
      sv.a(l);
      try
      {
        paramJSONObject.getLong("seed_expire_time");
        sv.b();
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if (paramJSONObject.getInt("seed_available") == 1)
      {
        paramJSONObject = aay.e(paramJSONObject.getString("seed"));
        if (paramJSONObject != null)
        {
          sv.b();
          sv.b();
          sv.a(paramJSONObject);
          sv.b();
        }
      }
      paramJSONObject = tt.a().d(this.d);
      if (paramJSONObject != null) {
        tt.a().a(paramJSONObject);
      }
      this.a.a = 0;
      return;
    }
    xv.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493069));
  }
  
  public final void b()
  {
    if ((!this.b.e) && (this.b.d != null))
    {
      Object localObject = new StringBuilder("handleSuccess");
      ((StringBuilder)localObject).append(this.b.f);
      xv.c(((StringBuilder)localObject).toString());
      localObject = this.b.d.obtainMessage(this.b.f);
      ((Message)localObject).arg1 = 0;
      ((Message)localObject).sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ut
 * JD-Core Version:    0.7.0.1
 */