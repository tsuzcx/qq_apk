package io.flutter.plugin.platform;

import android.content.Context;
import io.flutter.plugin.common.MessageCodec;

public abstract class PlatformViewFactory
{
  private final MessageCodec<Object> createArgsCodec;
  
  public PlatformViewFactory(MessageCodec<Object> paramMessageCodec)
  {
    this.createArgsCodec = paramMessageCodec;
  }
  
  public abstract PlatformView create(Context paramContext, int paramInt, Object paramObject);
  
  public final MessageCodec<Object> getCreateArgsCodec()
  {
    return this.createArgsCodec;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.plugin.platform.PlatformViewFactory
 * JD-Core Version:    0.7.0.1
 */