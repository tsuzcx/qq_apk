package com.tencent.mobileqq.triton.bridge.d;

import com.tencent.mobileqq.triton.audio.e;
import com.tencent.mobileqq.triton.engine.TTLog;
import org.json.JSONObject;

class a$f
  implements Runnable
{
  a$f(a parama, String paramString) {}
  
  public void run()
  {
    int i;
    String str;
    try
    {
      JSONObject localJSONObject = new JSONObject(this.a);
      i = localJSONObject.optInt("audioId", -1);
      str = localJSONObject.optString("operationType");
      if ("play".equals(str))
      {
        if (a.b(this.b)) {
          return;
        }
        a.a(this.b).j(i);
        return;
      }
      if ("pause".equals(str))
      {
        a.a(this.b).i(i);
        return;
      }
    }
    finally
    {
      TTLog.b("[audio] AudioPlugin", "API_OPERATE_AUDIO exception:", localThrowable);
      return;
    }
    if ("stop".equals(str))
    {
      a.a(this.b).k(i);
      return;
    }
    if ("seek".equals(str)) {
      a.a(this.b).a(i, (float)localThrowable.optDouble("currentTime"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.bridge.d.a.f
 * JD-Core Version:    0.7.0.1
 */