package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class uo
  extends tj
{
  private long d;
  private int e;
  private int f;
  private boolean g;
  private String h;
  
  public final String a()
  {
    rz.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aaq paramaaq)
  {
    this.d = ((Long)paramaaq.c.get("param.uinhash")).longValue();
    this.f = ((Integer)paramaaq.c.get("param.scene_id")).intValue();
    this.g = ((Boolean)paramaaq.c.get("param.verifyonoff")).booleanValue();
    this.h = ((String)paramaaq.c.get("param.wtlogin.a2"));
    this.e = paramaaq.j;
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = aac.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      xa.a("mbtoken3_general_verify_mobile_code ret: ".concat(String.valueOf(paramJSONObject)));
      i = paramJSONObject.getInt("seq_id");
      if (i != this.e)
      {
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.e);
        xa.c(paramJSONObject.toString());
        this.a.a(10030, null, null);
        return;
      }
      this.a.a = 0;
      return;
    }
    xa.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493068));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.uo
 * JD-Core Version:    0.7.0.1
 */