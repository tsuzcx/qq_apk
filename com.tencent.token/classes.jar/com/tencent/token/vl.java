package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class vl
  extends tk
{
  public static String d;
  public static int e;
  private long f;
  private long g;
  private int h;
  private int i;
  
  public final String a()
  {
    sa.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aar paramaar)
  {
    this.f = ((Long)paramaar.c.get("param.uinhash")).longValue();
    this.g = ((Long)paramaar.c.get("param.realuin")).longValue();
    this.i = ((Integer)paramaar.c.get("param.scene.id")).intValue();
    this.h = paramaar.j;
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int j = paramJSONObject.getInt("err");
    if (j == 0)
    {
      paramJSONObject = aad.d(paramJSONObject.getString("data"));
      if (paramJSONObject != null)
      {
        paramJSONObject = new JSONObject(new String(paramJSONObject));
        d = paramJSONObject.getString("validate_code");
        e = paramJSONObject.getInt("validate_id");
        this.a.a = 0;
        return;
      }
      xb.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
      a(10022, RqdApplication.n().getString(2131493068));
      return;
    }
    a(j, paramJSONObject.getString("info"));
    xb.a("ProtoGetRealNameVerify fail errCode=".concat(String.valueOf(j)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.vl
 * JD-Core Version:    0.7.0.1
 */