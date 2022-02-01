package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

public final class MetadataRenderer
  extends BaseRenderer
  implements Handler.Callback
{
  private static final int MAX_PENDING_METADATA_COUNT = 5;
  private static final int MSG_INVOKE_RENDERER = 0;
  private final MetadataInputBuffer buffer;
  private MetadataDecoder decoder;
  private final MetadataDecoderFactory decoderFactory;
  private final FormatHolder formatHolder;
  private boolean inputStreamEnded;
  private final MetadataOutput output;
  private final Handler outputHandler;
  private final Metadata[] pendingMetadata;
  private int pendingMetadataCount;
  private int pendingMetadataIndex;
  private final long[] pendingMetadataTimestamps;
  
  public MetadataRenderer(MetadataOutput paramMetadataOutput, Looper paramLooper)
  {
    this(paramMetadataOutput, paramLooper, MetadataDecoderFactory.DEFAULT);
  }
  
  public MetadataRenderer(MetadataOutput paramMetadataOutput, Looper paramLooper, MetadataDecoderFactory paramMetadataDecoderFactory)
  {
    super(4);
    this.output = ((MetadataOutput)Assertions.checkNotNull(paramMetadataOutput));
    if (paramLooper == null) {}
    for (paramMetadataOutput = null;; paramMetadataOutput = new Handler(paramLooper, this))
    {
      this.outputHandler = paramMetadataOutput;
      this.decoderFactory = ((MetadataDecoderFactory)Assertions.checkNotNull(paramMetadataDecoderFactory));
      this.formatHolder = new FormatHolder();
      this.buffer = new MetadataInputBuffer();
      this.pendingMetadata = new Metadata[5];
      this.pendingMetadataTimestamps = new long[5];
      return;
    }
  }
  
  private void flushPendingMetadata()
  {
    Arrays.fill(this.pendingMetadata, null);
    this.pendingMetadataIndex = 0;
    this.pendingMetadataCount = 0;
  }
  
  private void invokeRenderer(Metadata paramMetadata)
  {
    if (this.outputHandler != null)
    {
      this.outputHandler.obtainMessage(0, paramMetadata).sendToTarget();
      return;
    }
    invokeRendererInternal(paramMetadata);
  }
  
  private void invokeRendererInternal(Metadata paramMetadata)
  {
    this.output.onMetadata(paramMetadata);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      throw new IllegalStateException();
    }
    invokeRendererInternal((Metadata)paramMessage.obj);
    return true;
  }
  
  public boolean isEnded()
  {
    return this.inputStreamEnded;
  }
  
  public boolean isReady()
  {
    return true;
  }
  
  public void onDisabled()
  {
    flushPendingMetadata();
    this.decoder = null;
  }
  
  public void onPositionReset(long paramLong, boolean paramBoolean)
  {
    flushPendingMetadata();
    this.inputStreamEnded = false;
  }
  
  public void onStreamChanged(Format[] paramArrayOfFormat, long paramLong)
    throws ExoPlaybackException
  {
    this.decoder = this.decoderFactory.createDecoder(paramArrayOfFormat[0]);
  }
  
  public void render(long paramLong1, long paramLong2)
    throws ExoPlaybackException
  {
    if ((!this.inputStreamEnded) && (this.pendingMetadataCount < 5))
    {
      this.buffer.clear();
      if (readSource(this.formatHolder, this.buffer, false) == -4)
      {
        if (!this.buffer.isEndOfStream()) {
          break label122;
        }
        this.inputStreamEnded = true;
      }
    }
    for (;;)
    {
      if ((this.pendingMetadataCount > 0) && (this.pendingMetadataTimestamps[this.pendingMetadataIndex] <= paramLong1))
      {
        invokeRenderer(this.pendingMetadata[this.pendingMetadataIndex]);
        this.pendingMetadata[this.pendingMetadataIndex] = null;
        this.pendingMetadataIndex = ((this.pendingMetadataIndex + 1) % 5);
        this.pendingMetadataCount -= 1;
      }
      return;
      label122:
      if (this.buffer.isDecodeOnly()) {
        continue;
      }
      this.buffer.subsampleOffsetUs = this.formatHolder.format.subsampleOffsetUs;
      this.buffer.flip();
      try
      {
        int i = (this.pendingMetadataIndex + this.pendingMetadataCount) % 5;
        this.pendingMetadata[i] = this.decoder.decode(this.buffer);
        this.pendingMetadataTimestamps[i] = this.buffer.timeUs;
        this.pendingMetadataCount += 1;
      }
      catch (MetadataDecoderException localMetadataDecoderException)
      {
        throw ExoPlaybackException.createForRenderer(localMetadataDecoderException, getIndex());
      }
    }
  }
  
  public int supportsFormat(Format paramFormat)
  {
    if (this.decoderFactory.supportsFormat(paramFormat))
    {
      if (supportsFormatDrm(null, paramFormat.drmInitData)) {
        return 4;
      }
      return 2;
    }
    return 0;
  }
  
  @Deprecated
  public static abstract interface Output
    extends MetadataOutput
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.MetadataRenderer
 * JD-Core Version:    0.7.0.1
 */