package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class en
  extends bm
{
  public String c;
  private int d;
  private String e;
  
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
    str = "?sess_id=" + str + "&url=" + URLEncoder.encode(this.c);
    return b.c() + "/cn/mbtoken3/mbtoken3_query_malicious_url" + str;
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ((String)paramfs.c.get("param.barcode.url"));
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    this.d = paramJSONObject.getInt("malicious_id");
    this.e = paramJSONObject.getString("malicious_desc");
    this.a.a = 0;
  }
  
  protected final void b()
  {
    if (!this.b.e)
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.arg2 = this.d;
      localMessage.obj = this.e;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.en
 * JD-Core Version:    0.7.0.1
 */