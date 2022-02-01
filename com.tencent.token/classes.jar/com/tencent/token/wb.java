package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class wb
  extends tk
{
  private long d;
  private long e;
  private int f;
  private int g;
  private long h;
  private Integer i;
  
  public final String a()
  {
    sa.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aar paramaar)
  {
    this.e = ((Long)paramaar.c.get("param.realuin")).longValue();
    this.g = ((Integer)paramaar.c.get("param.scene_id")).intValue();
    this.h = ((Long)paramaar.c.get("param.op_time")).longValue();
    this.f = paramaar.j;
    this.d = ((Long)paramaar.c.get("param.uinhash")).longValue();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    int j = paramJSONObject.getInt("err");
    if (j != 0)
    {
      a(j, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = aad.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      xb.a("mbtoken3_qry_face_verify_on_off ret: ".concat(String.valueOf(paramJSONObject)));
      j = paramJSONObject.getInt("seq_id");
      if (j != this.f)
      {
        paramJSONObject = new StringBuilder("parseJSON error seq is wrong seq=");
        paramJSONObject.append(j);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.f);
        xb.c(paramJSONObject.toString());
        this.a.a(10030, null, null);
        return;
      }
      this.i = Integer.valueOf(paramJSONObject.getInt("verify_type"));
      this.a.a = 0;
      return;
    }
    xb.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493068));
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
 * Qualified Name:     com.tencent.token.wb
 * JD-Core Version:    0.7.0.1
 */