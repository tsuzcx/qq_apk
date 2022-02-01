package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class vo
  extends tk
{
  private long d;
  private int e;
  private tb f;
  
  public final String a()
  {
    sa.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aar paramaar)
  {
    this.d = ((Long)paramaar.c.get("param.uinhash")).longValue();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, null);
      return;
    }
    paramJSONObject = aad.d(paramJSONObject.getString("data"));
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
        sb.a();
        paramJSONObject.append(sb.b());
        xb.c(paramJSONObject.toString());
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
    xb.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493068));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.vo
 * JD-Core Version:    0.7.0.1
 */