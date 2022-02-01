package com.tencent.token;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.secprotocol.t.s;
import org.json.JSONObject;

public final class aj
{
  public final Context a;
  
  public aj(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public final JSONObject a(int paramInt, String paramString, af paramaf)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(ak.a(0), paramInt);
      localJSONObject.put(ak.a(1), 1);
      localJSONObject.put(ak.a(2), paramaf.b);
      localJSONObject.put(ak.a(3), paramaf.d);
      localJSONObject.put(ak.a(4), paramaf.c);
      localJSONObject.put(ak.a(5), paramaf.e);
      localJSONObject.put(ak.a(6), paramString);
      localJSONObject.put(ak.a(7), paramaf.f);
      localJSONObject.put(ak.a(8), paramaf.g);
      localJSONObject.put(ak.a(9), Build.VERSION.SDK_INT);
      localJSONObject.put(ak.a(10), s.b(paramaf.a));
      localJSONObject.put(ak.a(11), paramaf.h);
      localJSONObject.put(ak.a(12), System.currentTimeMillis());
      localJSONObject.put(ak.a(13), 1);
      localJSONObject.put(ak.a(14), "");
      localJSONObject.put(ak.a(15), s.getProcessName(this.a));
      localJSONObject.put(ak.a(16), s.c(this.a));
      localJSONObject.put(ak.a(17), s.d(this.a));
      localJSONObject.put(ak.a(18), s.e(this.a));
      return localJSONObject;
    }
    finally
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aj
 * JD-Core Version:    0.7.0.1
 */