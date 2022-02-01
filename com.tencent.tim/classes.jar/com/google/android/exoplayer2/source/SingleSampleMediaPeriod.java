package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSource.Factory;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader.Callback;
import com.google.android.exoplayer2.upstream.Loader.Loadable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

final class SingleSampleMediaPeriod
  implements MediaPeriod, Loader.Callback<SourceLoadable>
{
  private static final int INITIAL_SAMPLE_SIZE = 1024;
  private final DataSource.Factory dataSourceFactory;
  private final DataSpec dataSpec;
  private final long durationUs;
  private int errorCount;
  private final MediaSourceEventListener.EventDispatcher eventDispatcher;
  final Format format;
  final Loader loader;
  boolean loadingFinished;
  boolean loadingSucceeded;
  private final int minLoadableRetryCount;
  byte[] sampleData;
  int sampleSize;
  private final ArrayList<SampleStreamImpl> sampleStreams;
  private final TrackGroupArray tracks;
  final boolean treatLoadErrorsAsEndOfStream;
  
  public SingleSampleMediaPeriod(DataSpec paramDataSpec, DataSource.Factory paramFactory, Format paramFormat, long paramLong, int paramInt, MediaSourceEventListener.EventDispatcher paramEventDispatcher, boolean paramBoolean)
  {
    this.dataSpec = paramDataSpec;
    this.dataSourceFactory = paramFactory;
    this.format = paramFormat;
    this.durationUs = paramLong;
    this.minLoadableRetryCount = paramInt;
    this.eventDispatcher = paramEventDispatcher;
    this.treatLoadErrorsAsEndOfStream = paramBoolean;
    this.tracks = new TrackGroupArray(new TrackGroup[] { new TrackGroup(new Format[] { paramFormat }) });
    this.sampleStreams = new ArrayList();
    this.loader = new Loader("Loader:SingleSampleMediaPeriod");
  }
  
  public boolean continueLoading(long paramLong)
  {
    if ((this.loadingFinished) || (this.loader.isLoading())) {
      return false;
    }
    paramLong = this.loader.startLoading(new SourceLoadable(this.dataSpec, this.dataSourceFactory.createDataSource()), this, this.minLoadableRetryCount);
    this.eventDispatcher.loadStarted(this.dataSpec, 1, -1, this.format, 0, null, 0L, this.durationUs, paramLong);
    return true;
  }
  
  public void discardBuffer(long paramLong, boolean paramBoolean) {}
  
  public long getAdjustedSeekPositionUs(long paramLong, SeekParameters paramSeekParameters)
  {
    return paramLong;
  }
  
  public long getBufferedPositionUs()
  {
    if (this.loadingFinished) {
      return -9223372036854775808L;
    }
    return 0L;
  }
  
  public long getNextLoadPositionUs()
  {
    if ((this.loadingFinished) || (this.loader.isLoading())) {
      return -9223372036854775808L;
    }
    return 0L;
  }
  
  public TrackGroupArray getTrackGroups()
  {
    return this.tracks;
  }
  
  public void maybeThrowPrepareError()
    throws IOException
  {}
  
  public void onLoadCanceled(SourceLoadable paramSourceLoadable, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.eventDispatcher.loadCanceled(paramSourceLoadable.dataSpec, 1, -1, null, 0, null, 0L, this.durationUs, paramLong1, paramLong2, paramSourceLoadable.sampleSize);
  }
  
  public void onLoadCompleted(SourceLoadable paramSourceLoadable, long paramLong1, long paramLong2)
  {
    this.eventDispatcher.loadCompleted(paramSourceLoadable.dataSpec, 1, -1, this.format, 0, null, 0L, this.durationUs, paramLong1, paramLong2, paramSourceLoadable.sampleSize);
    this.sampleSize = paramSourceLoadable.sampleSize;
    this.sampleData = paramSourceLoadable.sampleData;
    this.loadingFinished = true;
    this.loadingSucceeded = true;
  }
  
  public int onLoadError(SourceLoadable paramSourceLoadable, long paramLong1, long paramLong2, IOException paramIOException)
  {
    this.errorCount += 1;
    if ((this.treatLoadErrorsAsEndOfStream) && (this.errorCount >= this.minLoadableRetryCount)) {}
    for (boolean bool = true;; bool = false)
    {
      this.eventDispatcher.loadError(paramSourceLoadable.dataSpec, 1, -1, this.format, 0, null, 0L, this.durationUs, paramLong1, paramLong2, paramSourceLoadable.sampleSize, paramIOException, bool);
      if (!bool) {
        break;
      }
      this.loadingFinished = true;
      return 2;
    }
    return 0;
  }
  
  public void prepare(MediaPeriod.Callback paramCallback, long paramLong)
  {
    paramCallback.onPrepared(this);
  }
  
  public long readDiscontinuity()
  {
    return -9223372036854775807L;
  }
  
  public void reevaluateBuffer(long paramLong) {}
  
  public void release()
  {
    this.loader.release();
  }
  
  public long seekToUs(long paramLong)
  {
    int i = 0;
    while (i < this.sampleStreams.size())
    {
      ((SampleStreamImpl)this.sampleStreams.get(i)).reset();
      i += 1;
    }
    return paramLong;
  }
  
  public long selectTracks(TrackSelection[] paramArrayOfTrackSelection, boolean[] paramArrayOfBoolean1, SampleStream[] paramArrayOfSampleStream, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    int i = 0;
    while (i < paramArrayOfTrackSelection.length)
    {
      if ((paramArrayOfSampleStream[i] != null) && ((paramArrayOfTrackSelection[i] == null) || (paramArrayOfBoolean1[i] == 0)))
      {
        this.sampleStreams.remove(paramArrayOfSampleStream[i]);
        paramArrayOfSampleStream[i] = null;
      }
      if ((paramArrayOfSampleStream[i] == null) && (paramArrayOfTrackSelection[i] != null))
      {
        SampleStreamImpl localSampleStreamImpl = new SampleStreamImpl(null);
        this.sampleStreams.add(localSampleStreamImpl);
        paramArrayOfSampleStream[i] = localSampleStreamImpl;
        paramArrayOfBoolean2[i] = true;
      }
      i += 1;
    }
    return paramLong;
  }
  
  final class SampleStreamImpl
    implements SampleStream
  {
    private static final int STREAM_STATE_END_OF_STREAM = 2;
    private static final int STREAM_STATE_SEND_FORMAT = 0;
    private static final int STREAM_STATE_SEND_SAMPLE = 1;
    private boolean formatSent;
    private int streamState;
    
    private SampleStreamImpl() {}
    
    private void sendFormat()
    {
      if (!this.formatSent)
      {
        SingleSampleMediaPeriod.this.eventDispatcher.downstreamFormatChanged(MimeTypes.getTrackType(SingleSampleMediaPeriod.this.format.sampleMimeType), SingleSampleMediaPeriod.this.format, 0, null, 0L);
        this.formatSent = true;
      }
    }
    
    public boolean isReady()
    {
      return SingleSampleMediaPeriod.this.loadingFinished;
    }
    
    public void maybeThrowError()
      throws IOException
    {
      if (!SingleSampleMediaPeriod.this.treatLoadErrorsAsEndOfStream) {
        SingleSampleMediaPeriod.this.loader.maybeThrowError();
      }
    }
    
    public int readData(FormatHolder paramFormatHolder, DecoderInputBuffer paramDecoderInputBuffer, boolean paramBoolean)
    {
      if (this.streamState == 2)
      {
        paramDecoderInputBuffer.addFlag(4);
        return -4;
      }
      if ((paramBoolean) || (this.streamState == 0))
      {
        paramFormatHolder.format = SingleSampleMediaPeriod.this.format;
        this.streamState = 1;
        return -5;
      }
      if (SingleSampleMediaPeriod.this.loadingFinished)
      {
        if (SingleSampleMediaPeriod.this.loadingSucceeded)
        {
          paramDecoderInputBuffer.timeUs = 0L;
          paramDecoderInputBuffer.addFlag(1);
          paramDecoderInputBuffer.ensureSpaceForWrite(SingleSampleMediaPeriod.this.sampleSize);
          paramDecoderInputBuffer.data.put(SingleSampleMediaPeriod.this.sampleData, 0, SingleSampleMediaPeriod.this.sampleSize);
          sendFormat();
        }
        for (;;)
        {
          this.streamState = 2;
          return -4;
          paramDecoderInputBuffer.addFlag(4);
        }
      }
      return -3;
    }
    
    public void reset()
    {
      if (this.streamState == 2) {
        this.streamState = 1;
      }
    }
    
    public int skipData(long paramLong)
    {
      if ((paramLong > 0L) && (this.streamState != 2))
      {
        this.streamState = 2;
        sendFormat();
        return 1;
      }
      return 0;
    }
  }
  
  static final class SourceLoadable
    implements Loader.Loadable
  {
    private final DataSource dataSource;
    public final DataSpec dataSpec;
    private byte[] sampleData;
    private int sampleSize;
    
    public SourceLoadable(DataSpec paramDataSpec, DataSource paramDataSource)
    {
      this.dataSpec = paramDataSpec;
      this.dataSource = paramDataSource;
    }
    
    public void cancelLoad() {}
    
    public boolean isLoadCanceled()
    {
      return false;
    }
    
    public void load()
      throws IOException, InterruptedException
    {
      int i = 0;
      this.sampleSize = 0;
      try
      {
        this.dataSource.open(this.dataSpec);
        if (i != -1)
        {
          this.sampleSize = (i + this.sampleSize);
          if (this.sampleData == null) {
            this.sampleData = new byte[1024];
          }
          for (;;)
          {
            i = this.dataSource.read(this.sampleData, this.sampleSize, this.sampleData.length - this.sampleSize);
            break;
            if (this.sampleSize == this.sampleData.length) {
              this.sampleData = Arrays.copyOf(this.sampleData, this.sampleData.length * 2);
            }
          }
        }
      }
      finally
      {
        Util.closeQuietly(this.dataSource);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.SingleSampleMediaPeriod
 * JD-Core Version:    0.7.0.1
 */