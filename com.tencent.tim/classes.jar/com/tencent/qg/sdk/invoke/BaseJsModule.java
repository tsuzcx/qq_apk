package com.tencent.qg.sdk.invoke;

import org.json.JSONObject;

public abstract class BaseJsModule
{
  public abstract String getModuleName();
  
  public abstract boolean handleJsRequest(String paramString, JSONObject paramJSONObject, InvokeCallback paramInvokeCallback);
  
  public void onDestroy() {}
  
  public static abstract interface ModuleNames
  {
    public static final String MODULE_BASE = "mqq";
    public static final String MODULE_FACE_EFFECT = "faceEffect";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qg.sdk.invoke.BaseJsModule
 * JD-Core Version:    0.7.0.1
 */