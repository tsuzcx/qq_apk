package io.flutter.view;

import android.support.annotation.NonNull;
import io.flutter.embedding.engine.FlutterJNI;

public final class FlutterCallbackInformation
{
  public final String callbackClassName;
  public final String callbackLibraryPath;
  public final String callbackName;
  
  private FlutterCallbackInformation(String paramString1, String paramString2, String paramString3)
  {
    this.callbackName = paramString1;
    this.callbackClassName = paramString2;
    this.callbackLibraryPath = paramString3;
  }
  
  @NonNull
  public static FlutterCallbackInformation lookupCallbackInformation(long paramLong)
  {
    return FlutterJNI.nativeLookupCallbackInformation(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.view.FlutterCallbackInformation
 * JD-Core Version:    0.7.0.1
 */