package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class xa
  extends ud
{
  private long d;
  private String e;
  private String f;
  private String g;
  private int h;
  private String i;
  private String j;
  private String k;
  
  public final String a()
  {
    st.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abm paramabm)
  {
    this.d = ((Long)paramabm.c.get("param.uinhash")).longValue();
    this.h = ((Integer)paramabm.c.get("param.mbmobile.set")).intValue();
    this.i = ((String)paramabm.c.get("param.mbmobile.mobile"));
    this.j = ((String)paramabm.c.get("param.mbmoible.areacode"));
    this.k = ((String)paramabm.c.get("param.wtlogin.a2"));
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int m = paramJSONObject.getInt("err");
    if (m == 0)
    {
      paramJSONObject = aay.d(paramJSONObject.getString("data"));
      if (paramJSONObject != null)
      {
        paramJSONObject = new JSONObject(new String(paramJSONObject));
        if (paramJSONObject.getInt("seq_id") != this.c)
        {
          a(10000, RqdApplication.n().getString(2131493069));
          return;
        }
        this.a.a = 0;
        this.f = paramJSONObject.getString("time1");
        this.g = paramJSONObject.getString("time2");
        this.e = paramJSONObject.optString("extraInfo");
        return;
      }
      xv.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
      this.a.a(10022, RqdApplication.n().getString(2131493069), RqdApplication.n().getString(2131493069));
      return;
    }
    paramJSONObject = paramJSONObject.getString("info");
    this.e = paramJSONObject;
    a(m, paramJSONObject);
  }
  
  public final void b()
  {
    if ((!this.b.e) && (this.b.d != null))
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("info", this.e);
        localJSONObject.put("time1", this.f);
        localJSONObject.put("time2", this.g);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      localMessage.obj = localJSONObject;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.xa
 * JD-Core Version:    0.7.0.1
 */