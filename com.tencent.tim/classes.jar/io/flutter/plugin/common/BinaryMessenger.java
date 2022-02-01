package io.flutter.plugin.common;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import java.nio.ByteBuffer;

public abstract interface BinaryMessenger
{
  @UiThread
  public abstract void send(@NonNull String paramString, @Nullable ByteBuffer paramByteBuffer);
  
  @UiThread
  public abstract void send(@NonNull String paramString, @Nullable ByteBuffer paramByteBuffer, @Nullable BinaryReply paramBinaryReply);
  
  @UiThread
  public abstract void setMessageHandler(@NonNull String paramString, @Nullable BinaryMessageHandler paramBinaryMessageHandler);
  
  public static abstract interface BinaryMessageHandler
  {
    @UiThread
    public abstract void onMessage(@Nullable ByteBuffer paramByteBuffer, @NonNull BinaryMessenger.BinaryReply paramBinaryReply);
  }
  
  public static abstract interface BinaryReply
  {
    @UiThread
    public abstract void reply(@Nullable ByteBuffer paramByteBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.plugin.common.BinaryMessenger
 * JD-Core Version:    0.7.0.1
 */