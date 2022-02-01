package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;

public final class ClippingMediaPeriod
  implements MediaPeriod, MediaPeriod.Callback
{
  private MediaPeriod.Callback callback;
  long endUs;
  public final MediaPeriod mediaPeriod;
  private long pendingInitialDiscontinuityPositionUs;
  private ClippingSampleStream[] sampleStreams;
  long startUs;
  
  public ClippingMediaPeriod(MediaPeriod paramMediaPeriod, boolean paramBoolean)
  {
    this.mediaPeriod = paramMediaPeriod;
    this.sampleStreams = new ClippingSampleStream[0];
    if (paramBoolean) {}
    for (long l = 0L;; l = -9223372036854775807L)
    {
      this.pendingInitialDiscontinuityPositionUs = l;
      this.startUs = -9223372036854775807L;
      this.endUs = -9223372036854775807L;
      return;
    }
  }
  
  private SeekParameters clipSeekParameters(long paramLong, SeekParameters paramSeekParameters)
  {
    long l = Math.min(paramLong - this.startUs, paramSeekParameters.toleranceBeforeUs);
    if (this.endUs == -9223372036854775808L) {}
    for (paramLong = paramSeekParameters.toleranceAfterUs; (l == paramSeekParameters.toleranceBeforeUs) && (paramLong == paramSeekParameters.toleranceAfterUs); paramLong = Math.min(this.endUs - paramLong, paramSeekParameters.toleranceAfterUs)) {
      return paramSeekParameters;
    }
    return new SeekParameters(l, paramLong);
  }
  
  private static boolean shouldKeepInitialDiscontinuity(long paramLong, TrackSelection[] paramArrayOfTrackSelection)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int j;
    int i;
    if (paramLong != 0L)
    {
      j = paramArrayOfTrackSelection.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        TrackSelection localTrackSelection = paramArrayOfTrackSelection[i];
        if ((localTrackSelection != null) && (!MimeTypes.isAudio(localTrackSelection.getSelectedFormat().sampleMimeType))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean continueLoading(long paramLong)
  {
    return this.mediaPeriod.continueLoading(this.startUs + paramLong);
  }
  
  public void discardBuffer(long paramLong, boolean paramBoolean)
  {
    this.mediaPeriod.discardBuffer(this.startUs + paramLong, paramBoolean);
  }
  
  public long getAdjustedSeekPositionUs(long paramLong, SeekParameters paramSeekParameters)
  {
    if (paramLong == this.startUs) {
      return 0L;
    }
    paramLong = this.startUs + paramLong;
    paramSeekParameters = clipSeekParameters(paramLong, paramSeekParameters);
    return this.mediaPeriod.getAdjustedSeekPositionUs(paramLong, paramSeekParameters) - this.startUs;
  }
  
  public long getBufferedPositionUs()
  {
    long l = this.mediaPeriod.getBufferedPositionUs();
    if ((l == -9223372036854775808L) || ((this.endUs != -9223372036854775808L) && (l >= this.endUs))) {
      return -9223372036854775808L;
    }
    return Math.max(0L, l - this.startUs);
  }
  
  public long getNextLoadPositionUs()
  {
    long l = this.mediaPeriod.getNextLoadPositionUs();
    if ((l == -9223372036854775808L) || ((this.endUs != -9223372036854775808L) && (l >= this.endUs))) {
      return -9223372036854775808L;
    }
    return l - this.startUs;
  }
  
  public TrackGroupArray getTrackGroups()
  {
    return this.mediaPeriod.getTrackGroups();
  }
  
  boolean isPendingInitialDiscontinuity()
  {
    return this.pendingInitialDiscontinuityPositionUs != -9223372036854775807L;
  }
  
  public void maybeThrowPrepareError()
    throws IOException
  {
    this.mediaPeriod.maybeThrowPrepareError();
  }
  
  public void onContinueLoadingRequested(MediaPeriod paramMediaPeriod)
  {
    this.callback.onContinueLoadingRequested(this);
  }
  
  public void onPrepared(MediaPeriod paramMediaPeriod)
  {
    if ((this.startUs != -9223372036854775807L) && (this.endUs != -9223372036854775807L)) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      this.callback.onPrepared(this);
      return;
    }
  }
  
  public void prepare(MediaPeriod.Callback paramCallback, long paramLong)
  {
    this.callback = paramCallback;
    this.mediaPeriod.prepare(this, this.startUs + paramLong);
  }
  
  public long readDiscontinuity()
  {
    boolean bool2 = false;
    if (isPendingInitialDiscontinuity())
    {
      l1 = this.pendingInitialDiscontinuityPositionUs;
      this.pendingInitialDiscontinuityPositionUs = -9223372036854775807L;
      long l2 = readDiscontinuity();
      if (l2 != -9223372036854775807L) {
        return l2;
      }
      return l1;
    }
    long l1 = this.mediaPeriod.readDiscontinuity();
    if (l1 == -9223372036854775807L) {
      return -9223372036854775807L;
    }
    if (l1 >= this.startUs) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Assertions.checkState(bool1);
      if (this.endUs != -9223372036854775808L)
      {
        bool1 = bool2;
        if (l1 > this.endUs) {}
      }
      else
      {
        bool1 = true;
      }
      Assertions.checkState(bool1);
      return l1 - this.startUs;
    }
  }
  
  public void reevaluateBuffer(long paramLong)
  {
    this.mediaPeriod.reevaluateBuffer(this.startUs + paramLong);
  }
  
  public long seekToUs(long paramLong)
  {
    boolean bool2 = false;
    this.pendingInitialDiscontinuityPositionUs = -9223372036854775807L;
    ClippingSampleStream[] arrayOfClippingSampleStream = this.sampleStreams;
    int j = arrayOfClippingSampleStream.length;
    int i = 0;
    while (i < j)
    {
      ClippingSampleStream localClippingSampleStream = arrayOfClippingSampleStream[i];
      if (localClippingSampleStream != null) {
        localClippingSampleStream.clearSentEos();
      }
      i += 1;
    }
    paramLong = this.startUs + paramLong;
    long l = this.mediaPeriod.seekToUs(paramLong);
    if (l != paramLong)
    {
      bool1 = bool2;
      if (l < this.startUs) {
        break label120;
      }
      if (this.endUs != -9223372036854775808L)
      {
        bool1 = bool2;
        if (l > this.endUs) {
          break label120;
        }
      }
    }
    boolean bool1 = true;
    label120:
    Assertions.checkState(bool1);
    return l - this.startUs;
  }
  
  public long selectTracks(TrackSelection[] paramArrayOfTrackSelection, boolean[] paramArrayOfBoolean1, SampleStream[] paramArrayOfSampleStream, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    this.sampleStreams = new ClippingSampleStream[paramArrayOfSampleStream.length];
    SampleStream[] arrayOfSampleStream = new SampleStream[paramArrayOfSampleStream.length];
    int i = 0;
    if (i < paramArrayOfSampleStream.length)
    {
      this.sampleStreams[i] = ((ClippingSampleStream)paramArrayOfSampleStream[i]);
      if (this.sampleStreams[i] != null) {}
      for (SampleStream localSampleStream = this.sampleStreams[i].childStream;; localSampleStream = null)
      {
        arrayOfSampleStream[i] = localSampleStream;
        i += 1;
        break;
      }
    }
    long l2 = this.mediaPeriod.selectTracks(paramArrayOfTrackSelection, paramArrayOfBoolean1, arrayOfSampleStream, paramArrayOfBoolean2, paramLong + this.startUs) - this.startUs;
    long l1;
    boolean bool;
    if ((isPendingInitialDiscontinuity()) && (paramLong == 0L) && (shouldKeepInitialDiscontinuity(this.startUs, paramArrayOfTrackSelection)))
    {
      l1 = l2;
      this.pendingInitialDiscontinuityPositionUs = l1;
      if ((l2 != paramLong) && ((l2 < 0L) || ((this.endUs != -9223372036854775808L) && (this.startUs + l2 > this.endUs)))) {
        break label251;
      }
      bool = true;
      label192:
      Assertions.checkState(bool);
      i = 0;
      label200:
      if (i >= paramArrayOfSampleStream.length) {
        break label305;
      }
      if (arrayOfSampleStream[i] != null) {
        break label257;
      }
      this.sampleStreams[i] = null;
    }
    for (;;)
    {
      paramArrayOfSampleStream[i] = this.sampleStreams[i];
      i += 1;
      break label200;
      l1 = -9223372036854775807L;
      break;
      label251:
      bool = false;
      break label192;
      label257:
      if ((paramArrayOfSampleStream[i] == null) || (this.sampleStreams[i].childStream != arrayOfSampleStream[i])) {
        this.sampleStreams[i] = new ClippingSampleStream(arrayOfSampleStream[i]);
      }
    }
    label305:
    return l2;
  }
  
  public void setClipping(long paramLong1, long paramLong2)
  {
    this.startUs = paramLong1;
    this.endUs = paramLong2;
  }
  
  final class ClippingSampleStream
    implements SampleStream
  {
    public final SampleStream childStream;
    private boolean sentEos;
    
    public ClippingSampleStream(SampleStream paramSampleStream)
    {
      this.childStream = paramSampleStream;
    }
    
    public void clearSentEos()
    {
      this.sentEos = false;
    }
    
    public boolean isReady()
    {
      return (!ClippingMediaPeriod.this.isPendingInitialDiscontinuity()) && (this.childStream.isReady());
    }
    
    public void maybeThrowError()
      throws IOException
    {
      this.childStream.maybeThrowError();
    }
    
    public int readData(FormatHolder paramFormatHolder, DecoderInputBuffer paramDecoderInputBuffer, boolean paramBoolean)
    {
      if (ClippingMediaPeriod.this.isPendingInitialDiscontinuity()) {
        return -3;
      }
      if (this.sentEos)
      {
        paramDecoderInputBuffer.setFlags(4);
        return -4;
      }
      int i = this.childStream.readData(paramFormatHolder, paramDecoderInputBuffer, paramBoolean);
      if (i == -5)
      {
        paramDecoderInputBuffer = paramFormatHolder.format;
        if ((paramDecoderInputBuffer.encoderDelay != -1) || (paramDecoderInputBuffer.encoderPadding != -1))
        {
          if (ClippingMediaPeriod.this.startUs == 0L) {
            break label117;
          }
          i = 0;
          if (ClippingMediaPeriod.this.endUs == -9223372036854775808L) {
            break label126;
          }
        }
        label117:
        label126:
        for (int j = 0;; j = paramDecoderInputBuffer.encoderPadding)
        {
          paramFormatHolder.format = paramDecoderInputBuffer.copyWithGaplessInfo(i, j);
          return -5;
          i = paramDecoderInputBuffer.encoderDelay;
          break;
        }
      }
      if ((ClippingMediaPeriod.this.endUs != -9223372036854775808L) && (((i == -4) && (paramDecoderInputBuffer.timeUs >= ClippingMediaPeriod.this.endUs)) || ((i == -3) && (ClippingMediaPeriod.this.getBufferedPositionUs() == -9223372036854775808L))))
      {
        paramDecoderInputBuffer.clear();
        paramDecoderInputBuffer.setFlags(4);
        this.sentEos = true;
        return -4;
      }
      if ((i == -4) && (!paramDecoderInputBuffer.isEndOfStream())) {
        paramDecoderInputBuffer.timeUs -= ClippingMediaPeriod.this.startUs;
      }
      return i;
    }
    
    public int skipData(long paramLong)
    {
      if (ClippingMediaPeriod.this.isPendingInitialDiscontinuity()) {
        return -3;
      }
      return this.childStream.skipData(ClippingMediaPeriod.this.startUs + paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ClippingMediaPeriod
 * JD-Core Version:    0.7.0.1
 */