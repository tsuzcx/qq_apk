package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.utils.s;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class ew
  extends bm
{
  private long c;
  private String d;
  private String e;
  private String f;
  private int g;
  private String h;
  private String i;
  
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
      ((JSONObject)localObject).put("op_type", this.g);
      ((JSONObject)localObject).put("new_mobile", this.h);
      ((JSONObject)localObject).put("area_code", this.i);
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
    return b.c() + "/cn/mbtoken3/mbtoken3_set_mod_mobile" + str3;
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ((Long)paramfs.c.get("param.uinhash")).longValue();
    this.g = ((Integer)paramfs.c.get("param.mbmobile.set")).intValue();
    this.h = ((String)paramfs.c.get("param.mbmobile.mobile"));
    this.i = ((String)paramfs.c.get("param.mbmoible.areacode"));
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    int j = paramJSONObject.getInt("err");
    String str = paramJSONObject.getString("info");
    this.d = str;
    a(j, str);
    if (j == 0)
    {
      this.a.a = 0;
      this.e = paramJSONObject.getString("time1");
      this.f = paramJSONObject.getString("time2");
    }
  }
  
  protected final void b()
  {
    Message localMessage;
    JSONObject localJSONObject;
    if (!this.b.e)
    {
      localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("info", this.d);
      localJSONObject.put("time1", this.e);
      localJSONObject.put("time2", this.f);
      localMessage.obj = localJSONObject;
      localMessage.sendToTarget();
      this.b.e = true;
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ew
 * JD-Core Version:    0.7.0.1
 */