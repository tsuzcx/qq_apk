package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import org.json.JSONObject;

public final class vw
  extends tk
{
  private a d;
  
  public final String a()
  {
    sa.a();
    this.a.a(104, null, null);
    return null;
  }
  
  public final void a(aar paramaar) {}
  
  public final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = aad.d(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      i = paramJSONObject.getInt("seq_id");
      if (this.c != i)
      {
        this.a.a(10030, null, null);
        return;
      }
      this.d = new a();
      this.d.a = paramJSONObject.getInt("is_have_msg");
      if (this.d.a == 1)
      {
        this.d.b = paramJSONObject.getString("content");
        this.d.c = paramJSONObject.getLong("uin");
      }
      this.a.a(this.d.b);
    }
  }
  
  public final void b()
  {
    if ((!this.b.e) && (this.b.d != null))
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.d;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
  
  public static final class a
  {
    public int a;
    public String b;
    public long c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.vw
 * JD-Core Version:    0.7.0.1
 */