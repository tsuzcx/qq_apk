package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import org.json.JSONException;
import org.json.JSONObject;

public final class ek
  extends bm
{
  private el c;
  
  protected final String a()
  {
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str = ax.c; str == null; str = null)
    {
      this.a.a(104, null, null);
      return null;
    }
    str = "?aq_base_sid=" + str;
    return b.c() + "/cn/mbtoken3/mbtoken3_qry_bind_notify_msg" + str;
  }
  
  protected final void a(fs paramfs) {}
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    this.c = new el(this);
    this.c.a = paramJSONObject.getInt("is_have_msg");
    if (this.c.a == 1)
    {
      this.c.b = paramJSONObject.getString("content");
      paramJSONObject = paramJSONObject.getString("data");
      localObject = s.d(paramJSONObject);
      if (localObject == null) {
        throw new JSONException("dec transdata error");
      }
      this.c.c = new JSONObject(new String((byte[])localObject)).getLong("uin");
      e.b("qrybindnotifymsg: havemsg=" + this.c.a + ", content=" + this.c.b + ", uin=" + this.c.c + ", data=" + paramJSONObject + ", descdata=" + new String((byte[])localObject));
    }
    paramJSONObject = this.a;
    Object localObject = this.c.b;
    paramJSONObject.a = 0;
    paramJSONObject.c = ((String)localObject);
  }
  
  protected final void b()
  {
    if (!this.b.e)
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.c;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ek
 * JD-Core Version:    0.7.0.1
 */