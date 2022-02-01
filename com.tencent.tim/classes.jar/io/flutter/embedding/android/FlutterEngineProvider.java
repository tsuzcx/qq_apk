package io.flutter.embedding.android;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import io.flutter.embedding.engine.FlutterEngine;

public abstract interface FlutterEngineProvider
{
  @Nullable
  public abstract FlutterEngine provideFlutterEngine(@NonNull Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterEngineProvider
 * JD-Core Version:    0.7.0.1
 */