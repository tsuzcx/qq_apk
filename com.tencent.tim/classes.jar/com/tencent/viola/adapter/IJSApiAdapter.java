package com.tencent.viola.adapter;

import com.tencent.viola.core.ViolaInstance;
import org.json.JSONObject;

public abstract interface IJSApiAdapter
{
  public abstract void invoke(String paramString, JSONObject paramJSONObject, OnInovkeCallback paramOnInovkeCallback, ViolaInstance paramViolaInstance);
  
  public static abstract interface OnInovkeCallback
  {
    public abstract void callback(JSONObject paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.adapter.IJSApiAdapter
 * JD-Core Version:    0.7.0.1
 */