package io.flutter.plugin.common;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.util.Log;
import java.nio.ByteBuffer;

public final class BasicMessageChannel<T>
{
  private static final String TAG = "BasicMessageChannel#";
  @NonNull
  private final MessageCodec<T> codec;
  @NonNull
  private final BinaryMessenger messenger;
  @NonNull
  private final String name;
  
  public BasicMessageChannel(@NonNull BinaryMessenger paramBinaryMessenger, @NonNull String paramString, @NonNull MessageCodec<T> paramMessageCodec)
  {
    this.messenger = paramBinaryMessenger;
    this.name = paramString;
    this.codec = paramMessageCodec;
  }
  
  public void send(@Nullable T paramT)
  {
    send(paramT, null);
  }
  
  @UiThread
  public void send(@Nullable T paramT, @Nullable Reply<T> paramReply)
  {
    Object localObject = null;
    BinaryMessenger localBinaryMessenger = this.messenger;
    String str = this.name;
    ByteBuffer localByteBuffer = this.codec.encodeMessage(paramT);
    if (paramReply == null) {}
    for (paramT = localObject;; paramT = new IncomingReplyHandler(paramReply, null))
    {
      localBinaryMessenger.send(str, localByteBuffer, paramT);
      return;
    }
  }
  
  @UiThread
  public void setMessageHandler(@Nullable MessageHandler<T> paramMessageHandler)
  {
    Object localObject = null;
    BinaryMessenger localBinaryMessenger = this.messenger;
    String str = this.name;
    if (paramMessageHandler == null) {}
    for (paramMessageHandler = localObject;; paramMessageHandler = new IncomingMessageHandler(paramMessageHandler, null))
    {
      localBinaryMessenger.setMessageHandler(str, paramMessageHandler);
      return;
    }
  }
  
  final class IncomingMessageHandler
    implements BinaryMessenger.BinaryMessageHandler
  {
    private final BasicMessageChannel.MessageHandler<T> handler;
    
    private IncomingMessageHandler()
    {
      Object localObject;
      this.handler = localObject;
    }
    
    public void onMessage(@Nullable ByteBuffer paramByteBuffer, @NonNull BinaryMessenger.BinaryReply paramBinaryReply)
    {
      try
      {
        this.handler.onMessage(BasicMessageChannel.this.codec.decodeMessage(paramByteBuffer), new BasicMessageChannel.IncomingMessageHandler.1(this, paramBinaryReply));
        return;
      }
      catch (RuntimeException paramByteBuffer)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("BasicMessageChannel#");
        localStringBuilder.append(BasicMessageChannel.this.name);
        Log.e(localStringBuilder.toString(), "Failed to handle message", paramByteBuffer);
        paramBinaryReply.reply(null);
      }
    }
  }
  
  final class IncomingReplyHandler
    implements BinaryMessenger.BinaryReply
  {
    private final BasicMessageChannel.Reply<T> callback;
    
    private IncomingReplyHandler()
    {
      Object localObject;
      this.callback = localObject;
    }
    
    public void reply(@Nullable ByteBuffer paramByteBuffer)
    {
      try
      {
        this.callback.reply(BasicMessageChannel.this.codec.decodeMessage(paramByteBuffer));
        return;
      }
      catch (RuntimeException paramByteBuffer)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("BasicMessageChannel#");
        localStringBuilder.append(BasicMessageChannel.this.name);
        Log.e(localStringBuilder.toString(), "Failed to handle message reply", paramByteBuffer);
      }
    }
  }
  
  public static abstract interface MessageHandler<T>
  {
    public abstract void onMessage(@Nullable T paramT, @NonNull BasicMessageChannel.Reply<T> paramReply);
  }
  
  public static abstract interface Reply<T>
  {
    public abstract void reply(@Nullable T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.plugin.common.BasicMessageChannel
 * JD-Core Version:    0.7.0.1
 */