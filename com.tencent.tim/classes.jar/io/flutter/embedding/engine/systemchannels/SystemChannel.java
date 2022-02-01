package io.flutter.embedding.engine.systemchannels;

import android.support.annotation.NonNull;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.JSONMessageCodec;
import java.util.HashMap;
import java.util.Map;

public class SystemChannel
{
  private static final String TAG = "SystemChannel";
  @NonNull
  public final BasicMessageChannel<Object> channel;
  
  public SystemChannel(@NonNull DartExecutor paramDartExecutor)
  {
    this.channel = new BasicMessageChannel(paramDartExecutor, "flutter/system", JSONMessageCodec.INSTANCE);
  }
  
  public void sendMemoryPressureWarning()
  {
    Log.v("SystemChannel", "Sending memory pressure warning to Flutter.");
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("type", "memoryPressure");
    this.channel.send(localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.SystemChannel
 * JD-Core Version:    0.7.0.1
 */