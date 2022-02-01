package com.tencent.mobileqq.triton.bridge.d;

import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.font.FontBitmapManager;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import java.util.Arrays;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends c
{
  public b(TTEngine paramTTEngine)
  {
    super(paramTTEngine);
    getEventMap().addAll(Arrays.asList(new String[] { "loadFont", "getTextLineHeight" }));
  }
  
  public String handleScriptRequest(String paramString1, String paramString2, int paramInt, ITTJSRuntime paramITTJSRuntime)
  {
    TTLog.a("FontPlugin", "handleScriptRequest() called with: eventName = [" + paramString1 + "], jsonParams = [" + paramString2 + "], callbackId = [" + paramInt + "], jsRuntime = [" + paramITTJSRuntime + "]");
    if ("loadFont".equals(paramString1)) {
      try
      {
        paramString2 = new JSONObject(paramString2).optString("path");
        TTLog.a("FontPlugin", "handleScriptRequest: " + paramString1 + " path " + paramString2);
        paramString1 = a().f().b(paramString2);
        return paramString1;
      }
      catch (JSONException paramString1)
      {
        TTLog.b("FontPlugin", "FontPlugin fail " + paramString1.getMessage());
      }
    }
    while (!"getTextLineHeight".equals(paramString1)) {
      return "{}";
    }
    TTLog.a("FontPlugin", "handleScriptRequest: " + paramString1);
    return a().f().a(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.bridge.d.b
 * JD-Core Version:    0.7.0.1
 */