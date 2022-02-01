package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class uk
  extends ud
{
  private long d;
  private long e;
  private int f;
  private int g;
  private int h;
  
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
    this.h = ((Integer)paramabm.c.get("param.type")).intValue();
    this.f = paramabm.j;
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
      i = new JSONObject(new String(paramJSONObject)).getInt("seq_id");
      if (i != this.f)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.f);
        xv.c(paramJSONObject.toString());
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
 * Qualified Name:     com.tencent.token.uk
 * JD-Core Version:    0.7.0.1
 */