package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class vn
  extends ud
{
  private long d;
  private long e;
  private int f;
  private int g;
  private String h;
  private int i;
  
  public final String a()
  {
    st.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abm paramabm)
  {
    this.d = ((Long)paramabm.c.get("param.uinhash")).longValue();
    this.e = ((Long)paramabm.c.get("param.realuin")).longValue();
    this.g = ((Integer)paramabm.c.get("param.general.mobilecode.sceneid")).intValue();
    this.h = ((String)paramabm.c.get("param.mbmobile.vrycode"));
    this.i = ((Integer)paramabm.c.get("param.type")).intValue();
    this.f = paramabm.j;
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int j = paramJSONObject.getInt("err");
    if (j != 0)
    {
      a(j, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = aay.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      xv.a("mbtoken3_general_verify_mobile_code ret: ".concat(String.valueOf(paramJSONObject)));
      j = paramJSONObject.getInt("seq_id");
      if (j != this.f)
      {
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(j);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.f);
        xv.c(paramJSONObject.toString());
        this.a.a(10030, null, null);
        return;
      }
      this.a.a = 0;
      return;
    }
    xv.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493069));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.vn
 * JD-Core Version:    0.7.0.1
 */