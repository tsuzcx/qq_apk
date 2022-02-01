package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class wg
  extends ud
{
  public static String d;
  public static String e;
  private long f;
  private String g;
  private int h;
  private int i;
  private String j;
  private int k;
  
  public final String a()
  {
    st.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abm paramabm)
  {
    this.f = ((Long)paramabm.c.get("param.realuin")).longValue();
    this.g = ((String)paramabm.c.get("param.mbmobile.mobile"));
    this.h = ((Integer)paramabm.c.get("param.mbmoible.ismobile")).intValue();
    this.i = ((Integer)paramabm.c.get("param.scene.id")).intValue();
    this.j = ((String)paramabm.c.get("param.mbmoible.areacode"));
    this.k = paramabm.j;
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int m = paramJSONObject.getInt("err");
    if (m != 0)
    {
      a(m, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = aay.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      xv.a("ProtoGetSMSChannel result =".concat(String.valueOf(paramJSONObject)));
      m = paramJSONObject.getInt("seq_id");
      if (m != this.k)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(m);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.k);
        xv.c(paramJSONObject.toString());
        return;
      }
      d = paramJSONObject.getString("sms_port");
    }
    try
    {
      e = paramJSONObject.getString("sms_up_code");
      label150:
      this.a.a = 0;
      return;
      xv.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
      a(10022, RqdApplication.n().getString(2131493069));
      return;
    }
    catch (Exception paramJSONObject)
    {
      break label150;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.wg
 * JD-Core Version:    0.7.0.1
 */