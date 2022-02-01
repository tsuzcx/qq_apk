package com.tencent.qqmini.flutter.core.page.tissue;

import android.app.Activity;
import android.content.Context;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;

public final class Flutter
{
  public static final String START_TAG = "miniapp-start-TISSUE";
  public static final String TAG = "miniapp-TISSUE";
  
  public static FlutterView createView(Activity paramActivity, String paramString, FlutterNativeView paramFlutterNativeView)
  {
    FlutterMain.startInitialization(paramActivity.getApplicationContext());
    FlutterMain.ensureInitializationComplete(paramActivity.getApplicationContext(), null);
    if (paramFlutterNativeView != null) {}
    for (;;)
    {
      paramActivity = new Flutter.1(paramActivity, null, paramFlutterNativeView);
      if (paramString != null) {
        paramActivity.setInitialRoute(paramString);
      }
      paramActivity.setAlpha(0.0F);
      return paramActivity;
      paramFlutterNativeView = new FlutterNativeView(paramActivity);
    }
  }
  
  public static void startInitialization(Context paramContext)
  {
    FlutterMain.startInitialization(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.page.tissue.Flutter
 * JD-Core Version:    0.7.0.1
 */