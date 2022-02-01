package com.tencent.viola.adapter;

import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public abstract interface IHttpAdapter
{
  public abstract void sendRequest(HttpRequset paramHttpRequset, OnHttpListener paramOnHttpListener, boolean paramBoolean);
  
  public static abstract interface OnHttpListener
  {
    public abstract void onHeadersReceived(int paramInt, Map<String, List<String>> paramMap);
    
    public abstract void onHttpFinish(HttpResponse paramHttpResponse);
    
    public abstract void onHttpStart();
  }
  
  public static abstract interface OnInovkeCallback
  {
    public abstract void callback(JSONObject paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.adapter.IHttpAdapter
 * JD-Core Version:    0.7.0.1
 */