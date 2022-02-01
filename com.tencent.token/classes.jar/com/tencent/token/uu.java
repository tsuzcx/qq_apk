package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class uu
  extends tj
{
  private long d;
  private int e;
  private ta f;
  
  public final String a()
  {
    rz.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aaq paramaaq)
  {
    this.d = ((Long)paramaaq.c.get("param.uinhash")).longValue();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, null);
      return;
    }
    Object localObject = aac.d(paramJSONObject.getString("data"));
    if (localObject != null)
    {
      localObject = new JSONObject(new String((byte[])localObject));
      i = ((JSONObject)localObject).getInt("seq_id");
      if (i != this.e)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i);
        paramJSONObject.append(",right = ");
        sa.a();
        paramJSONObject.append(sa.b());
        xa.c(paramJSONObject.toString());
        return;
      }
      long l = ((JSONObject)localObject).getLong("uin");
      if (l != this.d)
      {
        paramJSONObject = this.a;
        localObject = new StringBuilder("uin not match=");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(this.d);
        paramJSONObject.a(10000, ((StringBuilder)localObject).toString(), null);
        return;
      }
      localObject = ((JSONObject)localObject).getJSONArray("result");
      if (!this.f.a((JSONArray)localObject))
      {
        paramJSONObject = this.a;
        StringBuilder localStringBuilder = new StringBuilder("update conf list failed:");
        localStringBuilder.append(((JSONArray)localObject).toString());
        paramJSONObject.a(10000, localStringBuilder.toString(), null);
        return;
      }
      xb.a("account_lock", new String(paramJSONObject.toString()));
      this.f.b.e = true;
      this.f.b.f = false;
      this.a.a = 0;
      return;
    }
    xa.c("parseJSON error decodeData=".concat(String.valueOf(localObject)));
    a(10022, RqdApplication.n().getString(2131493068));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.uu
 * JD-Core Version:    0.7.0.1
 */