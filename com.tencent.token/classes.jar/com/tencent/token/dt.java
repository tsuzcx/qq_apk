package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.utils.s;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class dt
  extends bm
{
  private long c;
  private String d = "";
  private int e;
  private String f;
  private String g;
  
  protected final String a()
  {
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str1 = ax.c; str1 == null; str1 = null)
    {
      this.a.a(104, null, null);
      return null;
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("new_mobile", this.f);
      ((JSONObject)localObject).put("op_type", this.e);
      ((JSONObject)localObject).put("area_code", this.g);
      localObject = s.b(((JSONObject)localObject).toString().getBytes());
      if (localObject == null)
      {
        this.a.a(10000, null, null);
        return null;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      this.a.a(10000, null, null);
      return null;
    }
    finally
    {
      if (s.b(((JSONObject)localObject).toString().getBytes()) == null)
      {
        this.a.a(10000, null, null);
        return null;
      }
    }
    String str3 = "?uin=" + this.c + "&aq_base_sid=" + str2 + "&data=" + (String)localObject;
    return b.c() + "/cn/mbtoken3/mbtoken3_mbop_get_mobile_code" + str3;
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ((Long)paramfs.c.get("param.uinhash")).longValue();
    this.e = ((Integer)paramfs.c.get("param.mbmobile.getcode")).intValue();
    this.f = ((String)paramfs.c.get("param.mbmobile.mobile"));
    this.g = ((String)paramfs.c.get("param.mbmoible.areacode"));
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    this.d = paramJSONObject.getString("sms_prefix");
    this.a.a = 0;
  }
  
  protected final void b()
  {
    if (!this.b.e)
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.d;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dt
 * JD-Core Version:    0.7.0.1
 */