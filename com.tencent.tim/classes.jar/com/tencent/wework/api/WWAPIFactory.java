package com.tencent.wework.api;

import android.content.Context;
import android.util.Log;

public class WWAPIFactory
{
  private static final String TAG = "WWAPI.WWAPIFactory";
  
  private WWAPIFactory()
  {
    throw new RuntimeException(getClass().getSimpleName() + " should not be instantiated");
  }
  
  public static IWWAPI createWWAPI(Context paramContext)
  {
    return createWWAPI(paramContext, "");
  }
  
  public static IWWAPI createWWAPI(Context paramContext, String paramString)
  {
    return createWWAPI(paramContext, paramString, false);
  }
  
  public static IWWAPI createWWAPI(Context paramContext, String paramString, boolean paramBoolean)
  {
    Log.d("WWAPI.WWAPIFactory", "createWXAPI, appId = " + paramString + ", checkSignature = " + paramBoolean);
    return new WWAPIImpl(paramContext, paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.wework.api.WWAPIFactory
 * JD-Core Version:    0.7.0.1
 */