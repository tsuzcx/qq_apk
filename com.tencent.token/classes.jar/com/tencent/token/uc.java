package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.RqdApplication;
import java.util.HashMap;
import org.json.JSONObject;

public final class uc
  extends ud
{
  private long d;
  private int[] e;
  private int[] f;
  private String g;
  private int h;
  
  protected final String a()
  {
    st.a();
    this.a.a(10000, null, null);
    return null;
  }
  
  protected final void a(abm paramabm)
  {
    this.d = ((Long)paramabm.c.get("param.uinhash")).longValue();
    this.e = ((int[])paramabm.c.get("param.mbinfo.id"));
    this.f = ((int[])paramabm.c.get("param.mbinfo.val"));
    this.g = ((String)paramabm.c.get("param.wtlogin.a2"));
    this.h = ((Integer)paramabm.c.get("param.common.seq")).intValue();
  }
  
  protected final void a(JSONObject paramJSONObject)
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
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      xv.b("ProtoSetServiceStatusV2:".concat(String.valueOf(paramJSONObject)));
      paramJSONObject.getLong("uin");
      if (paramJSONObject.getInt("seq_id") != this.h)
      {
        this.a.a(10030, null, null);
        return;
      }
      this.a.a = 0;
      return;
    }
    xv.c("parseJSON error decodeData=".concat(String.valueOf(paramJSONObject)));
    a(10022, RqdApplication.n().getString(2131493069));
  }
  
  protected final void b()
  {
    if ((!this.b.e) && (this.b.d != null))
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.e;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.uc
 * JD-Core Version:    0.7.0.1
 */