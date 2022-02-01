package io.flutter.embedding.engine.systemchannels;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.InputDevice;
import android.view.KeyEvent;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.JSONMessageCodec;
import java.util.HashMap;
import java.util.Map;

public class KeyEventChannel
{
  @NonNull
  public final BasicMessageChannel<Object> channel;
  
  public KeyEventChannel(@NonNull DartExecutor paramDartExecutor)
  {
    this.channel = new BasicMessageChannel(paramDartExecutor, "flutter/keyevent", JSONMessageCodec.INSTANCE);
  }
  
  private void encodeKeyEvent(@NonNull FlutterKeyEvent paramFlutterKeyEvent, @NonNull Map<String, Object> paramMap)
  {
    paramMap.put("flags", Integer.valueOf(paramFlutterKeyEvent.flags));
    paramMap.put("plainCodePoint", Integer.valueOf(paramFlutterKeyEvent.plainCodePoint));
    paramMap.put("codePoint", Integer.valueOf(paramFlutterKeyEvent.codePoint));
    paramMap.put("keyCode", Integer.valueOf(paramFlutterKeyEvent.keyCode));
    paramMap.put("scanCode", Integer.valueOf(paramFlutterKeyEvent.scanCode));
    paramMap.put("metaState", Integer.valueOf(paramFlutterKeyEvent.metaState));
    if (paramFlutterKeyEvent.complexCharacter != null) {
      paramMap.put("character", paramFlutterKeyEvent.complexCharacter.toString());
    }
    paramMap.put("source", Integer.valueOf(paramFlutterKeyEvent.source));
    paramMap.put("vendorId", Integer.valueOf(paramFlutterKeyEvent.vendorId));
    paramMap.put("productId", Integer.valueOf(paramFlutterKeyEvent.productId));
  }
  
  public void keyDown(@NonNull FlutterKeyEvent paramFlutterKeyEvent)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", "keydown");
    localHashMap.put("keymap", "android");
    encodeKeyEvent(paramFlutterKeyEvent, localHashMap);
    this.channel.send(localHashMap);
  }
  
  public void keyUp(@NonNull FlutterKeyEvent paramFlutterKeyEvent)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", "keyup");
    localHashMap.put("keymap", "android");
    encodeKeyEvent(paramFlutterKeyEvent, localHashMap);
    this.channel.send(localHashMap);
  }
  
  public static class FlutterKeyEvent
  {
    public final int codePoint;
    @Nullable
    public final Character complexCharacter;
    public final int deviceId;
    public final int flags;
    public final int keyCode;
    public final int metaState;
    public final int plainCodePoint;
    public final int productId;
    public final int scanCode;
    public final int source;
    public final int vendorId;
    
    public FlutterKeyEvent(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @Nullable Character paramCharacter, int paramInt6, int paramInt7, int paramInt8)
    {
      this.deviceId = paramInt1;
      this.flags = paramInt2;
      this.plainCodePoint = paramInt3;
      this.codePoint = paramInt4;
      this.keyCode = paramInt5;
      this.complexCharacter = paramCharacter;
      this.scanCode = paramInt6;
      this.metaState = paramInt7;
      this.source = paramInt8;
      paramCharacter = InputDevice.getDevice(paramInt1);
      if (paramCharacter != null)
      {
        if (Build.VERSION.SDK_INT >= 19)
        {
          this.vendorId = paramCharacter.getVendorId();
          this.productId = paramCharacter.getProductId();
          return;
        }
        this.vendorId = 0;
        this.productId = 0;
        return;
      }
      this.vendorId = 0;
      this.productId = 0;
    }
    
    public FlutterKeyEvent(@NonNull KeyEvent paramKeyEvent)
    {
      this(paramKeyEvent, null);
    }
    
    public FlutterKeyEvent(@NonNull KeyEvent paramKeyEvent, @Nullable Character paramCharacter)
    {
      this(paramKeyEvent.getDeviceId(), paramKeyEvent.getFlags(), paramKeyEvent.getUnicodeChar(0), paramKeyEvent.getUnicodeChar(), paramKeyEvent.getKeyCode(), paramCharacter, paramKeyEvent.getScanCode(), paramKeyEvent.getMetaState(), paramKeyEvent.getSource());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.KeyEventChannel
 * JD-Core Version:    0.7.0.1
 */