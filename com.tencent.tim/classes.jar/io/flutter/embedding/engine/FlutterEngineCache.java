package io.flutter.embedding.engine;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

public class FlutterEngineCache
{
  private static FlutterEngineCache instance;
  private final Map<String, FlutterEngine> cachedEngines = new HashMap();
  
  @NonNull
  public static FlutterEngineCache getInstance()
  {
    if (instance == null) {
      instance = new FlutterEngineCache();
    }
    return instance;
  }
  
  public boolean contains(@NonNull String paramString)
  {
    return this.cachedEngines.containsKey(paramString);
  }
  
  @Nullable
  public FlutterEngine get(@NonNull String paramString)
  {
    return (FlutterEngine)this.cachedEngines.get(paramString);
  }
  
  public void put(@NonNull String paramString, @Nullable FlutterEngine paramFlutterEngine)
  {
    if (paramFlutterEngine != null)
    {
      this.cachedEngines.put(paramString, paramFlutterEngine);
      return;
    }
    this.cachedEngines.remove(paramString);
  }
  
  public void remove(@NonNull String paramString)
  {
    put(paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.embedding.engine.FlutterEngineCache
 * JD-Core Version:    0.7.0.1
 */