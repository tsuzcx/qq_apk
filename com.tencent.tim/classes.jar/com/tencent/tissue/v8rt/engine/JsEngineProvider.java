package com.tencent.tissue.v8rt.engine;

import java.util.ArrayList;

public class JsEngineProvider
  extends ArrayList<IJsEngine>
{
  public static final String TAG = "JsEngineProvider";
  public static JsEngineProvider sInstance = new JsEngineProvider();
  
  public static JsEngineProvider getInstance()
  {
    return sInstance;
  }
  
  public boolean add(IJsEngine paramIJsEngine)
  {
    if (paramIJsEngine == null)
    {
      Logger.e("JsEngineProvider", "null engine");
      return false;
    }
    if (contains(paramIJsEngine))
    {
      Logger.w("JsEngineProvider", paramIJsEngine + " already added");
      return false;
    }
    return super.add(paramIJsEngine);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tissue.v8rt.engine.JsEngineProvider
 * JD-Core Version:    0.7.0.1
 */