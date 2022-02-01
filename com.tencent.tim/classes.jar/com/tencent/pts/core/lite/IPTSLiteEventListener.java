package com.tencent.pts.core.lite;

import android.view.View;
import java.util.HashMap;

public abstract interface IPTSLiteEventListener
{
  public static final int LITE_EVENT_TYPE_EXPOSURE = 2;
  public static final int LITE_EVENT_TYPE_TAP = 1;
  public static final int LITE_EVENT_TYPE_UNKNOWN = 0;
  
  public abstract void onExposureTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView);
  
  public abstract void onTapEventTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pts.core.lite.IPTSLiteEventListener
 * JD-Core Version:    0.7.0.1
 */