package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.io.IOException;

public final class EmptySampleStream
  implements SampleStream
{
  public boolean isReady()
  {
    return true;
  }
  
  public void maybeThrowError()
    throws IOException
  {}
  
  public int readData(FormatHolder paramFormatHolder, DecoderInputBuffer paramDecoderInputBuffer, boolean paramBoolean)
  {
    paramDecoderInputBuffer.setFlags(4);
    return -4;
  }
  
  public int skipData(long paramLong)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.EmptySampleStream
 * JD-Core Version:    0.7.0.1
 */