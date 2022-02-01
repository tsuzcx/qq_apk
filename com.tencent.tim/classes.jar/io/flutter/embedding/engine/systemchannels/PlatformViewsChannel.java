package io.flutter.embedding.engine.systemchannels;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.StandardMethodCodec;
import java.nio.ByteBuffer;

public class PlatformViewsChannel
{
  private static final String TAG = "PlatformViewsChannel";
  private final MethodChannel channel;
  private PlatformViewsHandler handler;
  private final MethodChannel.MethodCallHandler parsingHandler = new PlatformViewsChannel.1(this);
  
  public PlatformViewsChannel(@NonNull DartExecutor paramDartExecutor)
  {
    this.channel = new MethodChannel(paramDartExecutor, "flutter/platform_views", StandardMethodCodec.INSTANCE);
    this.channel.setMethodCallHandler(this.parsingHandler);
  }
  
  public void invokeViewFocused(int paramInt)
  {
    if (this.channel == null) {
      return;
    }
    this.channel.invokeMethod("viewFocused", Integer.valueOf(paramInt));
  }
  
  public void setPlatformViewsHandler(@Nullable PlatformViewsHandler paramPlatformViewsHandler)
  {
    this.handler = paramPlatformViewsHandler;
  }
  
  public static class PlatformViewCreationRequest
  {
    public final int direction;
    public final double logicalHeight;
    public final double logicalWidth;
    @Nullable
    public final ByteBuffer params;
    public final int viewId;
    @NonNull
    public final String viewType;
    
    public PlatformViewCreationRequest(int paramInt1, @NonNull String paramString, double paramDouble1, double paramDouble2, int paramInt2, @Nullable ByteBuffer paramByteBuffer)
    {
      this.viewId = paramInt1;
      this.viewType = paramString;
      this.logicalWidth = paramDouble1;
      this.logicalHeight = paramDouble2;
      this.direction = paramInt2;
      this.params = paramByteBuffer;
    }
  }
  
  public static class PlatformViewResizeRequest
  {
    public final double newLogicalHeight;
    public final double newLogicalWidth;
    public final int viewId;
    
    public PlatformViewResizeRequest(int paramInt, double paramDouble1, double paramDouble2)
    {
      this.viewId = paramInt;
      this.newLogicalWidth = paramDouble1;
      this.newLogicalHeight = paramDouble2;
    }
  }
  
  public static class PlatformViewTouch
  {
    public final int action;
    public final int buttonState;
    public final int deviceId;
    @NonNull
    public final Number downTime;
    public final int edgeFlags;
    @NonNull
    public final Number eventTime;
    public final int flags;
    public final int metaState;
    public final int pointerCount;
    @NonNull
    public final Object rawPointerCoords;
    @NonNull
    public final Object rawPointerPropertiesList;
    public final int source;
    public final int viewId;
    public final float xPrecision;
    public final float yPrecision;
    
    PlatformViewTouch(int paramInt1, @NonNull Number paramNumber1, @NonNull Number paramNumber2, int paramInt2, int paramInt3, @NonNull Object paramObject1, @NonNull Object paramObject2, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
    {
      this.viewId = paramInt1;
      this.downTime = paramNumber1;
      this.eventTime = paramNumber2;
      this.action = paramInt2;
      this.pointerCount = paramInt3;
      this.rawPointerPropertiesList = paramObject1;
      this.rawPointerCoords = paramObject2;
      this.metaState = paramInt4;
      this.buttonState = paramInt5;
      this.xPrecision = paramFloat1;
      this.yPrecision = paramFloat2;
      this.deviceId = paramInt6;
      this.edgeFlags = paramInt7;
      this.source = paramInt8;
      this.flags = paramInt9;
    }
  }
  
  public static abstract interface PlatformViewsHandler
  {
    public abstract void clearFocus(int paramInt);
    
    public abstract long createPlatformView(@NonNull PlatformViewsChannel.PlatformViewCreationRequest paramPlatformViewCreationRequest);
    
    public abstract void disposePlatformView(int paramInt);
    
    public abstract void onTouch(@NonNull PlatformViewsChannel.PlatformViewTouch paramPlatformViewTouch);
    
    public abstract void resizePlatformView(@NonNull PlatformViewsChannel.PlatformViewResizeRequest paramPlatformViewResizeRequest, @NonNull Runnable paramRunnable);
    
    public abstract void setDirection(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.PlatformViewsChannel
 * JD-Core Version:    0.7.0.1
 */