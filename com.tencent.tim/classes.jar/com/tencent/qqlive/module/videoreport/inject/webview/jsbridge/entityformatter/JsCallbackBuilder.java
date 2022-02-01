package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.entityformatter;

import org.json.JSONException;
import org.json.JSONObject;

public class JsCallbackBuilder
{
  private IJsEntityFormatter dataFormatter;
  private String msg = "success";
  private String ret = "0";
  
  public String format()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ret", this.ret).put("msg", this.msg);
      if (this.dataFormatter != null) {
        localJSONObject.put("data", this.dataFormatter.format());
      }
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public JsCallbackBuilder setData(IJsEntityFormatter paramIJsEntityFormatter)
  {
    this.dataFormatter = paramIJsEntityFormatter;
    return this;
  }
  
  public JsCallbackBuilder setMsg(String paramString)
  {
    this.msg = paramString;
    return this;
  }
  
  public JsCallbackBuilder setRet(String paramString)
  {
    this.ret = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.entityformatter.JsCallbackBuilder
 * JD-Core Version:    0.7.0.1
 */