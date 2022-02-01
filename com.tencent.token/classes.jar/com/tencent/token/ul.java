package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import java.util.HashMap;
import org.json.JSONObject;

public final class ul
  extends ud
{
  private long d;
  private int e;
  
  public final String a()
  {
    st.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abm paramabm)
  {
    this.d = ((Long)paramabm.c.get("param.uinhash")).longValue();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    i = paramJSONObject.getInt("seq_id");
    if (i != this.e)
    {
      this.a.a(10030, null, null);
      paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
      paramJSONObject.append(i);
      paramJSONObject.append(",right = ");
      su.a();
      paramJSONObject.append(su.b());
      xv.c(paramJSONObject.toString());
      return;
    }
    this.a.a = 0;
  }
  
  public final void b()
  {
    if ((!this.b.e) && (this.b.d != null))
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ul
 * JD-Core Version:    0.7.0.1
 */