package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;

class MediaSourceEventListener$EventDispatcher$6
  implements Runnable
{
  MediaSourceEventListener$EventDispatcher$6(MediaSourceEventListener.EventDispatcher paramEventDispatcher, int paramInt1, Format paramFormat, int paramInt2, Object paramObject, long paramLong) {}
  
  public void run()
  {
    MediaSourceEventListener.EventDispatcher.access$100(this.this$0).onDownstreamFormatChanged(this.val$trackType, this.val$trackFormat, this.val$trackSelectionReason, this.val$trackSelectionData, MediaSourceEventListener.EventDispatcher.access$000(this.this$0, this.val$mediaTimeUs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.6
 * JD-Core Version:    0.7.0.1
 */