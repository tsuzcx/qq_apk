package com.tencent.token;

import android.content.Context;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class wo
  extends ud
{
  public String d;
  public long e;
  public int f;
  
  public final String a()
  {
    st.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abm paramabm)
  {
    this.e = ((Long)paramabm.c.get("param.uinhash")).longValue();
    this.d = ((String)paramabm.c.get("param.qqpwd"));
    this.f = ((Integer)paramabm.c.get("param.scene.id")).intValue();
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
      if (this.c != i)
      {
        this.a.a(10030, null, null);
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.c);
        xv.c(paramJSONObject.toString());
        return;
      }
      this.a.a = 0;
      return;
    }
    a(10022, RqdApplication.n().getString(2131493069));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.wo
 * JD-Core Version:    0.7.0.1
 */