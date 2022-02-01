package com.google.android.exoplayer2.text.cea;

import android.support.annotation.NonNull;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.util.LinkedList;
import java.util.PriorityQueue;

abstract class CeaDecoder
  implements SubtitleDecoder
{
  private static final int NUM_INPUT_BUFFERS = 10;
  private static final int NUM_OUTPUT_BUFFERS = 2;
  private final LinkedList<CeaInputBuffer> availableInputBuffers = new LinkedList();
  private final LinkedList<SubtitleOutputBuffer> availableOutputBuffers;
  private CeaInputBuffer dequeuedInputBuffer;
  private long playbackPositionUs;
  private long queuedInputBufferCount;
  private final PriorityQueue<CeaInputBuffer> queuedInputBuffers;
  
  public CeaDecoder()
  {
    int i = 0;
    while (i < 10)
    {
      this.availableInputBuffers.add(new CeaInputBuffer(null));
      i += 1;
    }
    this.availableOutputBuffers = new LinkedList();
    i = j;
    while (i < 2)
    {
      this.availableOutputBuffers.add(new CeaOutputBuffer(null));
      i += 1;
    }
    this.queuedInputBuffers = new PriorityQueue();
  }
  
  private void releaseInputBuffer(CeaInputBuffer paramCeaInputBuffer)
  {
    paramCeaInputBuffer.clear();
    this.availableInputBuffers.add(paramCeaInputBuffer);
  }
  
  protected abstract Subtitle createSubtitle();
  
  protected abstract void decode(SubtitleInputBuffer paramSubtitleInputBuffer);
  
  public SubtitleInputBuffer dequeueInputBuffer()
    throws SubtitleDecoderException
  {
    if (this.dequeuedInputBuffer == null) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      if (!this.availableInputBuffers.isEmpty()) {
        break;
      }
      return null;
    }
    this.dequeuedInputBuffer = ((CeaInputBuffer)this.availableInputBuffers.pollFirst());
    return this.dequeuedInputBuffer;
  }
  
  public SubtitleOutputBuffer dequeueOutputBuffer()
    throws SubtitleDecoderException
  {
    if (this.availableOutputBuffers.isEmpty()) {
      return null;
    }
    CeaInputBuffer localCeaInputBuffer;
    Object localObject;
    do
    {
      do
      {
        releaseInputBuffer(localCeaInputBuffer);
        if ((this.queuedInputBuffers.isEmpty()) || (((CeaInputBuffer)this.queuedInputBuffers.peek()).timeUs > this.playbackPositionUs)) {
          break;
        }
        localCeaInputBuffer = (CeaInputBuffer)this.queuedInputBuffers.poll();
        if (localCeaInputBuffer.isEndOfStream())
        {
          localObject = (SubtitleOutputBuffer)this.availableOutputBuffers.pollFirst();
          ((SubtitleOutputBuffer)localObject).addFlag(4);
          releaseInputBuffer(localCeaInputBuffer);
          return localObject;
        }
        decode(localCeaInputBuffer);
      } while (!isNewSubtitleDataAvailable());
      localObject = createSubtitle();
    } while (localCeaInputBuffer.isDecodeOnly());
    SubtitleOutputBuffer localSubtitleOutputBuffer = (SubtitleOutputBuffer)this.availableOutputBuffers.pollFirst();
    localSubtitleOutputBuffer.setContent(localCeaInputBuffer.timeUs, (Subtitle)localObject, 9223372036854775807L);
    releaseInputBuffer(localCeaInputBuffer);
    return localSubtitleOutputBuffer;
    return null;
  }
  
  public void flush()
  {
    this.queuedInputBufferCount = 0L;
    this.playbackPositionUs = 0L;
    while (!this.queuedInputBuffers.isEmpty()) {
      releaseInputBuffer((CeaInputBuffer)this.queuedInputBuffers.poll());
    }
    if (this.dequeuedInputBuffer != null)
    {
      releaseInputBuffer(this.dequeuedInputBuffer);
      this.dequeuedInputBuffer = null;
    }
  }
  
  public abstract String getName();
  
  protected abstract boolean isNewSubtitleDataAvailable();
  
  public void queueInputBuffer(SubtitleInputBuffer paramSubtitleInputBuffer)
    throws SubtitleDecoderException
  {
    boolean bool;
    if (paramSubtitleInputBuffer == this.dequeuedInputBuffer)
    {
      bool = true;
      Assertions.checkArgument(bool);
      if (!paramSubtitleInputBuffer.isDecodeOnly()) {
        break label40;
      }
      releaseInputBuffer(this.dequeuedInputBuffer);
    }
    for (;;)
    {
      this.dequeuedInputBuffer = null;
      return;
      bool = false;
      break;
      label40:
      paramSubtitleInputBuffer = this.dequeuedInputBuffer;
      long l = this.queuedInputBufferCount;
      this.queuedInputBufferCount = (1L + l);
      CeaInputBuffer.access$202(paramSubtitleInputBuffer, l);
      this.queuedInputBuffers.add(this.dequeuedInputBuffer);
    }
  }
  
  public void release() {}
  
  protected void releaseOutputBuffer(SubtitleOutputBuffer paramSubtitleOutputBuffer)
  {
    paramSubtitleOutputBuffer.clear();
    this.availableOutputBuffers.add(paramSubtitleOutputBuffer);
  }
  
  public void setPositionUs(long paramLong)
  {
    this.playbackPositionUs = paramLong;
  }
  
  static final class CeaInputBuffer
    extends SubtitleInputBuffer
    implements Comparable<CeaInputBuffer>
  {
    private long queuedInputBufferCount;
    
    public int compareTo(@NonNull CeaInputBuffer paramCeaInputBuffer)
    {
      if (isEndOfStream() != paramCeaInputBuffer.isEndOfStream()) {
        if (!isEndOfStream()) {}
      }
      long l1;
      do
      {
        return 1;
        return -1;
        long l2 = this.timeUs - paramCeaInputBuffer.timeUs;
        l1 = l2;
        if (l2 == 0L)
        {
          l2 = this.queuedInputBufferCount - paramCeaInputBuffer.queuedInputBufferCount;
          l1 = l2;
          if (l2 == 0L) {
            return 0;
          }
        }
      } while (l1 > 0L);
      return -1;
    }
  }
  
  final class CeaOutputBuffer
    extends SubtitleOutputBuffer
  {
    private CeaOutputBuffer() {}
    
    public final void release()
    {
      CeaDecoder.this.releaseOutputBuffer(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.text.cea.CeaDecoder
 * JD-Core Version:    0.7.0.1
 */