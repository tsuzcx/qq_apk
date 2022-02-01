package com.tencent.mobileqq.vaswebviewplugin;

import aqvn;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import org.json.JSONObject;

public class KingCardJsPlugin
  extends VasWebviewJsPluginV2
{
  public static final String BUSINESS_NAME = "kingCard";
  
  public KingCardJsPlugin()
  {
    super("kingCard");
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(method="openKingCardActivation")
  public void openKingCardActivation(VasWebviewJsPluginV2.JsData paramJsData)
  {
    int i = 1;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (aqvn.a().x(this.mRuntime.getActivity())) {}
      for (;;)
      {
        localJSONObject.put("result", i);
        super.callJs(paramJsData.callbackId, new String[] { localJSONObject.toString() });
        return;
        i = 0;
      }
      return;
    }
    catch (Exception localException)
    {
      super.callJsOnError(paramJsData.callbackId, localException.getMessage());
    }
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="callback", method="supportKingCardActivation")
  public void supportKingCardActivation(String paramString)
  {
    int i = 1;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (aqvn.a().aFG()) {}
      for (;;)
      {
        localJSONObject.put("result", i);
        super.callJs(paramString, new String[] { localJSONObject.toString() });
        return;
        i = 0;
      }
      return;
    }
    catch (Exception localException)
    {
      super.callJsOnError(paramString, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.KingCardJsPlugin
 * JD-Core Version:    0.7.0.1
 */