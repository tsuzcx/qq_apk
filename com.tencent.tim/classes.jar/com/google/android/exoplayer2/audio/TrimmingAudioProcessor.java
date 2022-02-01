package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class TrimmingAudioProcessor
  implements AudioProcessor
{
  private ByteBuffer buffer = EMPTY_BUFFER;
  private int channelCount = -1;
  private byte[] endBuffer;
  private int endBufferSize;
  private boolean inputEnded;
  private boolean isActive;
  private ByteBuffer outputBuffer = EMPTY_BUFFER;
  private int pendingTrimStartBytes;
  private int sampleRateHz;
  private int trimEndSamples;
  private int trimStartSamples;
  
  public boolean configure(int paramInt1, int paramInt2, int paramInt3)
    throws AudioProcessor.UnhandledFormatException
  {
    if (paramInt3 != 2) {
      throw new AudioProcessor.UnhandledFormatException(paramInt1, paramInt2, paramInt3);
    }
    this.channelCount = paramInt2;
    this.sampleRateHz = paramInt1;
    this.endBuffer = new byte[this.trimEndSamples * paramInt2 * 2];
    this.endBufferSize = 0;
    this.pendingTrimStartBytes = (this.trimStartSamples * paramInt2 * 2);
    boolean bool2 = this.isActive;
    if ((this.trimStartSamples != 0) || (this.trimEndSamples != 0)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.isActive = bool1;
      if (bool2 == this.isActive) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void flush()
  {
    this.outputBuffer = EMPTY_BUFFER;
    this.inputEnded = false;
    this.pendingTrimStartBytes = 0;
    this.endBufferSize = 0;
  }
  
  public ByteBuffer getOutput()
  {
    ByteBuffer localByteBuffer = this.outputBuffer;
    this.outputBuffer = EMPTY_BUFFER;
    return localByteBuffer;
  }
  
  public int getOutputChannelCount()
  {
    return this.channelCount;
  }
  
  public int getOutputEncoding()
  {
    return 2;
  }
  
  public int getOutputSampleRateHz()
  {
    return this.sampleRateHz;
  }
  
  public boolean isActive()
  {
    return this.isActive;
  }
  
  public boolean isEnded()
  {
    return (this.inputEnded) && (this.outputBuffer == EMPTY_BUFFER);
  }
  
  public void queueEndOfStream()
  {
    this.inputEnded = true;
  }
  
  public void queueInput(ByteBuffer paramByteBuffer)
  {
    int j = paramByteBuffer.position();
    int i = paramByteBuffer.limit();
    int k = i - j;
    int m = Math.min(k, this.pendingTrimStartBytes);
    this.pendingTrimStartBytes -= m;
    paramByteBuffer.position(j + m);
    if (this.pendingTrimStartBytes > 0) {
      return;
    }
    k -= m;
    m = this.endBufferSize + k - this.endBuffer.length;
    if (this.buffer.capacity() < m) {
      this.buffer = ByteBuffer.allocateDirect(m).order(ByteOrder.nativeOrder());
    }
    for (;;)
    {
      j = Util.constrainValue(m, 0, this.endBufferSize);
      this.buffer.put(this.endBuffer, 0, j);
      m = Util.constrainValue(m - j, 0, k);
      paramByteBuffer.limit(paramByteBuffer.position() + m);
      this.buffer.put(paramByteBuffer);
      paramByteBuffer.limit(i);
      i = k - m;
      this.endBufferSize -= j;
      System.arraycopy(this.endBuffer, j, this.endBuffer, 0, this.endBufferSize);
      paramByteBuffer.get(this.endBuffer, this.endBufferSize, i);
      this.endBufferSize = (i + this.endBufferSize);
      this.buffer.flip();
      this.outputBuffer = this.buffer;
      return;
      this.buffer.clear();
    }
  }
  
  public void reset()
  {
    flush();
    this.buffer = EMPTY_BUFFER;
    this.channelCount = -1;
    this.sampleRateHz = -1;
    this.endBuffer = null;
  }
  
  public void setTrimSampleCount(int paramInt1, int paramInt2)
  {
    this.trimStartSamples = paramInt1;
    this.trimEndSamples = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.TrimmingAudioProcessor
 * JD-Core Version:    0.7.0.1
 */