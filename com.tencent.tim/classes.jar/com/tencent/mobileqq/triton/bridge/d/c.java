package com.tencent.mobileqq.triton.bridge.d;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSPlugin;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.mobileqq.triton.sdk.utils.ApiUtil;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

public abstract class c
  implements ITTJSPlugin
{
  private final Set<String> a = new HashSet();
  private TTEngine b;
  
  c(TTEngine paramTTEngine)
  {
    if (paramTTEngine != null)
    {
      this.b = paramTTEngine;
      return;
    }
    throw new IllegalArgumentException("can't constructor InnerPlugin with null tritonEngine");
  }
  
  public TTEngine a()
  {
    return this.b;
  }
  
  public void a(ITTJSRuntime paramITTJSRuntime, int paramInt, String paramString)
  {
    if (paramITTJSRuntime != null) {
      paramITTJSRuntime.evaluateCallbackJs(paramInt, paramString);
    }
  }
  
  public void a(ITTJSRuntime paramITTJSRuntime, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {}
    while (paramITTJSRuntime == null) {
      return;
    }
    paramITTJSRuntime.evaluateSubscribeJs(paramString1, paramString2);
  }
  
  public void a(ITTJSRuntime paramITTJSRuntime, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    a(paramITTJSRuntime, paramString, paramJSONObject, null, paramInt);
  }
  
  public void a(ITTJSRuntime paramITTJSRuntime, String paramString1, JSONObject paramJSONObject, String paramString2, int paramInt)
  {
    if (paramITTJSRuntime != null)
    {
      paramString1 = ApiUtil.wrapCallbackFail(paramString1, paramJSONObject, paramString2);
      if (paramString1 == null) {
        break label30;
      }
    }
    label30:
    for (paramString1 = paramString1.toString();; paramString1 = "")
    {
      a(paramITTJSRuntime, paramInt, paramString1);
      return;
    }
  }
  
  public void b() {}
  
  public void b(ITTJSRuntime paramITTJSRuntime, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (paramITTJSRuntime != null)
    {
      paramString = ApiUtil.wrapCallbackOk(paramString, paramJSONObject);
      if (paramString == null) {
        break label28;
      }
    }
    label28:
    for (paramString = paramString.toString();; paramString = "")
    {
      a(paramITTJSRuntime, paramInt, paramString);
      return;
    }
  }
  
  public void c() {}
  
  public Set<String> getEventMap()
  {
    return this.a;
  }
  
  public String handleScriptRequest(String paramString1, String paramString2, int paramInt, ITTJSRuntime paramITTJSRuntime)
  {
    return null;
  }
  
  public void onCreate(Context paramContext, ITTEngine paramITTEngine) {}
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.bridge.d.c
 * JD-Core Version:    0.7.0.1
 */