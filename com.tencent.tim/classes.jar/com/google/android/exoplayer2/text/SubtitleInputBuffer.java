package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;

public class SubtitleInputBuffer
  extends DecoderInputBuffer
{
  public long subsampleOffsetUs;
  
  public SubtitleInputBuffer()
  {
    super(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.text.SubtitleInputBuffer
 * JD-Core Version:    0.7.0.1
 */