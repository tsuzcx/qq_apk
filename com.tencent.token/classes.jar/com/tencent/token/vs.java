package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class vs
  extends tr
{
  public static String d;
  public static int e;
  private long f;
  private long g;
  private int h;
  private int i;
  
  public final String a()
  {
    sh.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abc paramabc)
  {
    this.f = ((Long)paramabc.c.get("param.uinhash")).longValue();
    this.g = ((Long)paramabc.c.get("param.realuin")).longValue();
    this.i = ((Integer)paramabc.c.get("param.scene.id")).intValue();
    this.h = paramabc.j;
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int j = paramJSONObject.getInt("err");
    if (j == 0)
    {
      paramJSONObject = aao.d(paramJSONObject.getString("data"));
      if (paramJSONObject != null)
      {
        paramJSONObject = new JSONObject(new String(paramJSONObject));
        d = paramJSONObject.getString("validate_code");
        e = paramJSONObject.getInt("validate_id");
        this.a.a = 0;
        return;
      }
      xj.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
      a(10022, RqdApplication.p().getString(2131493068));
      return;
    }
    a(j, paramJSONObject.getString("info"));
    xj.a("ProtoGetRealNameVerify fail errCode=".concat(String.valueOf(j)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.vs
 * JD-Core Version:    0.7.0.1
 */