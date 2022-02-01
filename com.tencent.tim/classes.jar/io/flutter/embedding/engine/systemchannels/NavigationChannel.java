package io.flutter.embedding.engine.systemchannels;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;

public class NavigationChannel
{
  private static final String TAG = "NavigationChannel";
  @NonNull
  public final MethodChannel channel;
  
  public NavigationChannel(@NonNull DartExecutor paramDartExecutor)
  {
    this.channel = new MethodChannel(paramDartExecutor, "flutter/navigation", JSONMethodCodec.INSTANCE);
  }
  
  public void popRoute()
  {
    Log.v("NavigationChannel", "Sending message to pop route.");
    this.channel.invokeMethod("popRoute", null);
  }
  
  public void pushRoute(@NonNull String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Sending message to push route '");
    localStringBuilder.append(paramString);
    localStringBuilder.append("'");
    Log.v("NavigationChannel", localStringBuilder.toString());
    this.channel.invokeMethod("pushRoute", paramString);
  }
  
  public void setInitialRoute(@NonNull String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Sending message to set initial route to '");
    localStringBuilder.append(paramString);
    localStringBuilder.append("'");
    Log.v("NavigationChannel", localStringBuilder.toString());
    this.channel.invokeMethod("setInitialRoute", paramString);
  }
  
  public void setMethodCallHandler(@Nullable MethodChannel.MethodCallHandler paramMethodCallHandler)
  {
    this.channel.setMethodCallHandler(paramMethodCallHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.NavigationChannel
 * JD-Core Version:    0.7.0.1
 */