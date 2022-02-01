package io.flutter.plugin.common;

import android.support.annotation.UiThread;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class EventChannel
{
  private static final String TAG = "EventChannel#";
  private final MethodCodec codec;
  private final BinaryMessenger messenger;
  private final String name;
  
  public EventChannel(BinaryMessenger paramBinaryMessenger, String paramString)
  {
    this(paramBinaryMessenger, paramString, StandardMethodCodec.INSTANCE);
  }
  
  public EventChannel(BinaryMessenger paramBinaryMessenger, String paramString, MethodCodec paramMethodCodec)
  {
    this.messenger = paramBinaryMessenger;
    this.name = paramString;
    this.codec = paramMethodCodec;
  }
  
  @UiThread
  public void setStreamHandler(StreamHandler paramStreamHandler)
  {
    BinaryMessenger localBinaryMessenger = this.messenger;
    String str = this.name;
    if (paramStreamHandler == null) {}
    for (paramStreamHandler = null;; paramStreamHandler = new IncomingStreamRequestHandler(paramStreamHandler))
    {
      localBinaryMessenger.setMessageHandler(str, paramStreamHandler);
      return;
    }
  }
  
  public static abstract interface EventSink
  {
    public abstract void endOfStream();
    
    public abstract void error(String paramString1, String paramString2, Object paramObject);
    
    public abstract void success(Object paramObject);
  }
  
  final class IncomingStreamRequestHandler
    implements BinaryMessenger.BinaryMessageHandler
  {
    private final AtomicReference<EventChannel.EventSink> activeSink = new AtomicReference(null);
    private final EventChannel.StreamHandler handler;
    
    IncomingStreamRequestHandler(EventChannel.StreamHandler paramStreamHandler)
    {
      this.handler = paramStreamHandler;
    }
    
    private void onCancel(Object paramObject, BinaryMessenger.BinaryReply paramBinaryReply)
    {
      if ((EventChannel.EventSink)this.activeSink.getAndSet(null) != null) {
        try
        {
          this.handler.onCancel(paramObject);
          paramBinaryReply.reply(EventChannel.this.codec.encodeSuccessEnvelope(null));
          return;
        }
        catch (RuntimeException paramObject)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("EventChannel#");
          localStringBuilder.append(EventChannel.this.name);
          Log.e(localStringBuilder.toString(), "Failed to close event stream", paramObject);
          paramBinaryReply.reply(EventChannel.this.codec.encodeErrorEnvelope("error", paramObject.getMessage(), null));
          return;
        }
      }
      paramBinaryReply.reply(EventChannel.this.codec.encodeErrorEnvelope("error", "No active stream to cancel", null));
    }
    
    private void onListen(Object paramObject, BinaryMessenger.BinaryReply paramBinaryReply)
    {
      Object localObject = new EventSinkImplementation(null);
      if ((EventChannel.EventSink)this.activeSink.getAndSet(localObject) != null) {}
      try
      {
        this.handler.onCancel(null);
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;)
        {
          try
          {
            this.handler.onListen(paramObject, (EventChannel.EventSink)localObject);
            paramBinaryReply.reply(EventChannel.this.codec.encodeSuccessEnvelope(null));
            return;
          }
          catch (RuntimeException paramObject)
          {
            StringBuilder localStringBuilder;
            this.activeSink.set(null);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("EventChannel#");
            ((StringBuilder)localObject).append(EventChannel.this.name);
            Log.e(((StringBuilder)localObject).toString(), "Failed to open event stream", paramObject);
            paramBinaryReply.reply(EventChannel.this.codec.encodeErrorEnvelope("error", paramObject.getMessage(), null));
          }
          localRuntimeException = localRuntimeException;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("EventChannel#");
          localStringBuilder.append(EventChannel.this.name);
          Log.e(localStringBuilder.toString(), "Failed to close existing event stream", localRuntimeException);
        }
      }
    }
    
    public void onMessage(ByteBuffer paramByteBuffer, BinaryMessenger.BinaryReply paramBinaryReply)
    {
      paramByteBuffer = EventChannel.this.codec.decodeMethodCall(paramByteBuffer);
      if (paramByteBuffer.method.equals("listen"))
      {
        onListen(paramByteBuffer.arguments, paramBinaryReply);
        return;
      }
      if (paramByteBuffer.method.equals("cancel"))
      {
        onCancel(paramByteBuffer.arguments, paramBinaryReply);
        return;
      }
      paramBinaryReply.reply(null);
    }
    
    final class EventSinkImplementation
      implements EventChannel.EventSink
    {
      final AtomicBoolean hasEnded = new AtomicBoolean(false);
      
      private EventSinkImplementation() {}
      
      @UiThread
      public void endOfStream()
      {
        if ((this.hasEnded.getAndSet(true)) || (EventChannel.IncomingStreamRequestHandler.this.activeSink.get() != this)) {
          return;
        }
        EventChannel.this.messenger.send(EventChannel.this.name, null);
      }
      
      @UiThread
      public void error(String paramString1, String paramString2, Object paramObject)
      {
        if ((this.hasEnded.get()) || (EventChannel.IncomingStreamRequestHandler.this.activeSink.get() != this)) {
          return;
        }
        EventChannel.this.messenger.send(EventChannel.this.name, EventChannel.this.codec.encodeErrorEnvelope(paramString1, paramString2, paramObject));
      }
      
      @UiThread
      public void success(Object paramObject)
      {
        if ((this.hasEnded.get()) || (EventChannel.IncomingStreamRequestHandler.this.activeSink.get() != this)) {
          return;
        }
        EventChannel.this.messenger.send(EventChannel.this.name, EventChannel.this.codec.encodeSuccessEnvelope(paramObject));
      }
    }
  }
  
  public static abstract interface StreamHandler
  {
    public abstract void onCancel(Object paramObject);
    
    public abstract void onListen(Object paramObject, EventChannel.EventSink paramEventSink);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.plugin.common.EventChannel
 * JD-Core Version:    0.7.0.1
 */