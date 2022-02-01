package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class wu
  extends ud
{
  private long d;
  private long e;
  private int f;
  private int g;
  private long h;
  private Integer i;
  
  public final String a()
  {
    st.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(abm paramabm)
  {
    this.e = ((Long)paramabm.c.get("param.realuin")).longValue();
    this.g = ((Integer)paramabm.c.get("param.scene_id")).intValue();
    this.h = ((Long)paramabm.c.get("param.op_time")).longValue();
    this.f = paramabm.j;
    this.d = ((Long)paramabm.c.get("param.uinhash")).longValue();
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
      xv.a("mbtoken3_qry_face_verify_on_off ret: ".concat(String.valueOf(paramJSONObject)));
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
      this.i = Integer.valueOf(paramJSONObject.getInt("verify_type"));
      this.a.a = 0;
      return;
    }
    xv.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493069));
  }
  
  public final void b()
  {
    if ((!this.b.e) && (this.b.d != null))
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.i;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.wu
 * JD-Core Version:    0.7.0.1
 */