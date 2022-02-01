package com.tencent.mobileqq.triton.sdk.bridge;

import android.content.Context;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import java.util.Set;

public abstract interface ITTJSPlugin
{
  public abstract Set<String> getEventMap();
  
  public abstract String handleScriptRequest(String paramString1, String paramString2, int paramInt, ITTJSRuntime paramITTJSRuntime);
  
  public abstract void onCreate(Context paramContext, ITTEngine paramITTEngine);
  
  public abstract void onDestroy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.bridge.ITTJSPlugin
 * JD-Core Version:    0.7.0.1
 */