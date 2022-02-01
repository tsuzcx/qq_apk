package com.tencent.mobileqq.mini.appbrand.jsapi;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.util.Set;

public abstract interface IJsPlugin
{
  public abstract String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt);
  
  public abstract void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine);
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  @NonNull
  public abstract Set<String> supportedEvents();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.IJsPlugin
 * JD-Core Version:    0.7.0.1
 */