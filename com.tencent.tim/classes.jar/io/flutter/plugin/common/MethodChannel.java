package io.flutter.plugin.common;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.util.Log;
import java.nio.ByteBuffer;

public final class MethodChannel
{
  private static final String TAG = "MethodChannel#";
  private final MethodCodec codec;
  private final BinaryMessenger messenger;
  private final String name;
  
  public MethodChannel(BinaryMessenger paramBinaryMessenger, String paramString)
  {
    this(paramBinaryMessenger, paramString, StandardMethodCodec.INSTANCE);
  }
  
  public MethodChannel(BinaryMessenger paramBinaryMessenger, String paramString, MethodCodec paramMethodCodec)
  {
    this.messenger = paramBinaryMessenger;
    this.name = paramString;
    this.codec = paramMethodCodec;
  }
  
  @UiThread
  public void invokeMethod(@NonNull String paramString, @Nullable Object paramObject)
  {
    invokeMethod(paramString, paramObject, null);
  }
  
  @UiThread
  public void invokeMethod(String paramString, @Nullable Object paramObject, Result paramResult)
  {
    BinaryMessenger localBinaryMessenger = this.messenger;
    String str = this.name;
    paramObject = this.codec.encodeMethodCall(new MethodCall(paramString, paramObject));
    if (paramResult == null) {}
    for (paramString = null;; paramString = new IncomingResultHandler(paramResult))
    {
      localBinaryMessenger.send(str, paramObject, paramString);
      return;
    }
  }
  
  @UiThread
  public void setMethodCallHandler(@Nullable MethodCallHandler paramMethodCallHandler)
  {
    BinaryMessenger localBinaryMessenger = this.messenger;
    String str = this.name;
    if (paramMethodCallHandler == null) {}
    for (paramMethodCallHandler = null;; paramMethodCallHandler = new IncomingMethodCallHandler(paramMethodCallHandler))
    {
      localBinaryMessenger.setMessageHandler(str, paramMethodCallHandler);
      return;
    }
  }
  
  final class IncomingMethodCallHandler
    implements BinaryMessenger.BinaryMessageHandler
  {
    private final MethodChannel.MethodCallHandler handler;
    
    IncomingMethodCallHandler(MethodChannel.MethodCallHandler paramMethodCallHandler)
    {
      this.handler = paramMethodCallHandler;
    }
    
    @UiThread
    public void onMessage(ByteBuffer paramByteBuffer, BinaryMessenger.BinaryReply paramBinaryReply)
    {
      paramByteBuffer = MethodChannel.this.codec.decodeMethodCall(paramByteBuffer);
      try
      {
        this.handler.onMethodCall(paramByteBuffer, new MethodChannel.IncomingMethodCallHandler.1(this, paramBinaryReply));
        return;
      }
      catch (RuntimeException paramByteBuffer)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("MethodChannel#");
        localStringBuilder.append(MethodChannel.this.name);
        Log.e(localStringBuilder.toString(), "Failed to handle method call", paramByteBuffer);
        paramBinaryReply.reply(MethodChannel.this.codec.encodeErrorEnvelope("error", paramByteBuffer.getMessage(), null));
      }
    }
  }
  
  final class IncomingResultHandler
    implements BinaryMessenger.BinaryReply
  {
    private final MethodChannel.Result callback;
    
    IncomingResultHandler(MethodChannel.Result paramResult)
    {
      this.callback = paramResult;
    }
    
    @UiThread
    public void reply(ByteBuffer paramByteBuffer)
    {
      if (paramByteBuffer == null) {}
      for (;;)
      {
        try
        {
          this.callback.notImplemented();
          return;
        }
        catch (RuntimeException paramByteBuffer)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("MethodChannel#");
          localStringBuilder.append(MethodChannel.this.name);
          Log.e(localStringBuilder.toString(), "Failed to handle method call result", paramByteBuffer);
        }
        try
        {
          this.callback.success(MethodChannel.this.codec.decodeEnvelope(paramByteBuffer));
          return;
        }
        catch (FlutterException paramByteBuffer)
        {
          this.callback.error(paramByteBuffer.code, paramByteBuffer.getMessage(), paramByteBuffer.details);
          return;
        }
      }
    }
  }
  
  public static abstract interface MethodCallHandler
  {
    @UiThread
    public abstract void onMethodCall(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult);
  }
  
  public static abstract interface Result
  {
    @UiThread
    public abstract void error(String paramString1, @Nullable String paramString2, @Nullable Object paramObject);
    
    @UiThread
    public abstract void notImplemented();
    
    @UiThread
    public abstract void success(@Nullable Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.plugin.common.MethodChannel
 * JD-Core Version:    0.7.0.1
 */