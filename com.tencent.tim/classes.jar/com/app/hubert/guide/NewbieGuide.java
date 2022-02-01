package com.app.hubert.guide;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.app.hubert.guide.core.Builder;

public class NewbieGuide
{
  public static final int FAILED = -1;
  public static final int SUCCESS = 1;
  public static final String TAG = "NewbieGuide";
  
  public static void resetLabel(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("NewbieGuide", 0).edit().putInt(paramString, 0).apply();
  }
  
  public static Builder with(Activity paramActivity)
  {
    return new Builder(paramActivity);
  }
  
  public static Builder with(android.app.Fragment paramFragment)
  {
    return new Builder(paramFragment);
  }
  
  public static Builder with(android.support.v4.app.Fragment paramFragment)
  {
    return new Builder(paramFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.app.hubert.guide.NewbieGuide
 * JD-Core Version:    0.7.0.1
 */