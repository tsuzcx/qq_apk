package com.tencent.webbundle.sdk;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public abstract interface IWebBundleWebView
{
  public abstract void addJavascriptInterface(@NotNull Object paramObject, @NotNull String paramString);
  
  public abstract void destroy();
  
  public abstract void dispatchJsEvent(@NotNull String paramString, @NotNull JSONObject paramJSONObject1, @Nullable JSONObject paramJSONObject2);
  
  public abstract void enableJavaScript(boolean paramBoolean);
  
  public abstract void loadUrl(@NotNull String paramString);
  
  public abstract void setOnPageFinishedListener(@NotNull OnPageFinishedListener paramOnPageFinishedListener);
  
  public static abstract interface OnPageFinishedListener
  {
    public abstract void onPageFinished(@NotNull IWebBundleWebView paramIWebBundleWebView, @NotNull String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.webbundle.sdk.IWebBundleWebView
 * JD-Core Version:    0.7.0.1
 */