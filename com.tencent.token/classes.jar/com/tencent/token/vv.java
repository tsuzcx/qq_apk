package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class vv
  extends tr
{
  private long d;
  private int e;
  private ti f;
  
  public final String a()
  {
    sh.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abc paramabc)
  {
    this.d = ((Long)paramabc.c.get("param.uinhash")).longValue();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, null);
      return;
    }
    paramJSONObject = aao.d(paramJSONObject.getString("data"));
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
        si.a();
        paramJSONObject.append(si.b());
        xj.c(paramJSONObject.toString());
        return;
      }
      long l = paramJSONObject.getLong("uin");
      if (l != this.d)
      {
        paramJSONObject = this.a;
        StringBuilder localStringBuilder = new StringBuilder("uin not match=");
        localStringBuilder.append(l);
        localStringBuilder.append(":");
        localStringBuilder.append(this.d);
        paramJSONObject.a(10000, localStringBuilder.toString(), null);
        return;
      }
      paramJSONObject = paramJSONObject.getJSONArray("result");
      this.f.d(paramJSONObject);
      this.a.a = 0;
      return;
    }
    xj.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.p().getString(2131493068));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.vv
 * JD-Core Version:    0.7.0.1
 */