package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap.SeekPoints;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader.Callback;
import com.google.android.exoplayer2.upstream.Loader.Loadable;
import com.google.android.exoplayer2.upstream.Loader.ReleaseCallback;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;

final class ExtractorMediaPeriod
  implements ExtractorOutput, MediaPeriod, SampleQueue.UpstreamFormatChangedListener, Loader.Callback<ExtractingLoadable>, Loader.ReleaseCallback
{
  private static final long DEFAULT_LAST_SAMPLE_DURATION_US = 10000L;
  private int actualMinLoadableRetryCount;
  private final Allocator allocator;
  private MediaPeriod.Callback callback;
  private final long continueLoadingCheckIntervalBytes;
  @Nullable
  private final String customCacheKey;
  private final DataSource dataSource;
  private long durationUs;
  private int enabledTrackCount;
  private final MediaSourceEventListener.EventDispatcher eventDispatcher;
  private int extractedSamplesCountAtStartOfLoad;
  private final ExtractorHolder extractorHolder;
  private final Handler handler;
  private boolean haveAudioVideoTracks;
  private long lastSeekPositionUs;
  private long length;
  private final Listener listener;
  private final ConditionVariable loadCondition;
  private final Loader loader;
  private boolean loadingFinished;
  private final Runnable maybeFinishPrepareRunnable;
  private final int minLoadableRetryCount;
  private boolean notifyDiscontinuity;
  private final Runnable onContinueLoadingRequestedRunnable;
  private boolean pendingDeferredRetry;
  private long pendingResetPositionUs;
  private boolean prepared;
  private boolean released;
  private int[] sampleQueueTrackIds;
  private int[] sampleQueueTrackTypes;
  private SampleQueue[] sampleQueues;
  private boolean sampleQueuesBuilt;
  private SeekMap seekMap;
  private boolean seenFirstTrackSelection;
  private boolean[] trackEnabledStates;
  private boolean[] trackFormatNotificationSent;
  private boolean[] trackIsAudioVideoFlags;
  private TrackGroupArray tracks;
  private final Uri uri;
  
  public ExtractorMediaPeriod(Uri paramUri, DataSource paramDataSource, Extractor[] paramArrayOfExtractor, int paramInt1, MediaSourceEventListener.EventDispatcher paramEventDispatcher, Listener paramListener, Allocator paramAllocator, @Nullable String paramString, int paramInt2)
  {
    this.uri = paramUri;
    this.dataSource = paramDataSource;
    this.minLoadableRetryCount = paramInt1;
    this.eventDispatcher = paramEventDispatcher;
    this.listener = paramListener;
    this.allocator = paramAllocator;
    this.customCacheKey = paramString;
    this.continueLoadingCheckIntervalBytes = paramInt2;
    this.loader = new Loader("Loader:ExtractorMediaPeriod");
    this.extractorHolder = new ExtractorHolder(paramArrayOfExtractor, this);
    this.loadCondition = new ConditionVariable();
    this.maybeFinishPrepareRunnable = new ExtractorMediaPeriod.1(this);
    this.onContinueLoadingRequestedRunnable = new ExtractorMediaPeriod.2(this);
    this.handler = new Handler();
    this.sampleQueueTrackIds = new int[0];
    this.sampleQueueTrackTypes = new int[0];
    this.sampleQueues = new SampleQueue[0];
    this.pendingResetPositionUs = -9223372036854775807L;
    this.length = -1L;
    this.durationUs = -9223372036854775807L;
    paramInt2 = paramInt1;
    if (paramInt1 == -1) {
      paramInt2 = 3;
    }
    this.actualMinLoadableRetryCount = paramInt2;
  }
  
  private boolean configureRetry(ExtractingLoadable paramExtractingLoadable, int paramInt)
  {
    int i = 0;
    if ((this.length != -1L) || ((this.seekMap != null) && (this.seekMap.getDurationUs() != -9223372036854775807L)))
    {
      this.extractedSamplesCountAtStartOfLoad = paramInt;
      return true;
    }
    if ((this.prepared) && (!suppressRead()))
    {
      this.pendingDeferredRetry = true;
      return false;
    }
    this.notifyDiscontinuity = this.prepared;
    this.lastSeekPositionUs = 0L;
    this.extractedSamplesCountAtStartOfLoad = 0;
    SampleQueue[] arrayOfSampleQueue = this.sampleQueues;
    int j = arrayOfSampleQueue.length;
    paramInt = i;
    while (paramInt < j)
    {
      arrayOfSampleQueue[paramInt].reset();
      paramInt += 1;
    }
    paramExtractingLoadable.setLoadPosition(0L, 0L);
    return true;
  }
  
  private void copyLengthFromLoader(ExtractingLoadable paramExtractingLoadable)
  {
    if (this.length == -1L) {
      this.length = paramExtractingLoadable.length;
    }
  }
  
  private int getExtractedSamplesCount()
  {
    int i = 0;
    SampleQueue[] arrayOfSampleQueue = this.sampleQueues;
    int k = arrayOfSampleQueue.length;
    int j = 0;
    while (i < k)
    {
      j += arrayOfSampleQueue[i].getWriteIndex();
      i += 1;
    }
    return j;
  }
  
  private long getLargestQueuedTimestampUs()
  {
    long l = -9223372036854775808L;
    SampleQueue[] arrayOfSampleQueue = this.sampleQueues;
    int j = arrayOfSampleQueue.length;
    int i = 0;
    while (i < j)
    {
      l = Math.max(l, arrayOfSampleQueue[i].getLargestQueuedTimestampUs());
      i += 1;
    }
    return l;
  }
  
  private static boolean isLoadableExceptionFatal(IOException paramIOException)
  {
    return paramIOException instanceof UnrecognizedInputFormatException;
  }
  
  private boolean isPendingReset()
  {
    return this.pendingResetPositionUs != -9223372036854775807L;
  }
  
  private void maybeFinishPrepare()
  {
    if ((this.released) || (this.prepared) || (this.seekMap == null) || (!this.sampleQueuesBuilt)) {
      return;
    }
    Object localObject1 = this.sampleQueues;
    int j = localObject1.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label63;
      }
      if (localObject1[i].getUpstreamFormat() == null) {
        break;
      }
      i += 1;
    }
    label63:
    this.loadCondition.close();
    j = this.sampleQueues.length;
    localObject1 = new TrackGroup[j];
    this.trackIsAudioVideoFlags = new boolean[j];
    this.trackEnabledStates = new boolean[j];
    this.trackFormatNotificationSent = new boolean[j];
    this.durationUs = this.seekMap.getDurationUs();
    i = 0;
    if (i < j)
    {
      Object localObject2 = this.sampleQueues[i].getUpstreamFormat();
      localObject1[i] = new TrackGroup(new Format[] { localObject2 });
      localObject2 = ((Format)localObject2).sampleMimeType;
      if ((MimeTypes.isVideo((String)localObject2)) || (MimeTypes.isAudio((String)localObject2))) {}
      for (int k = 1;; k = 0)
      {
        this.trackIsAudioVideoFlags[i] = k;
        this.haveAudioVideoTracks = (k | this.haveAudioVideoTracks);
        i += 1;
        break;
      }
    }
    this.tracks = new TrackGroupArray((TrackGroup[])localObject1);
    if ((this.minLoadableRetryCount == -1) && (this.length == -1L) && (this.seekMap.getDurationUs() == -9223372036854775807L)) {
      this.actualMinLoadableRetryCount = 6;
    }
    this.prepared = true;
    this.listener.onSourceInfoRefreshed(this.durationUs, this.seekMap.isSeekable());
    this.callback.onPrepared(this);
  }
  
  private void maybeNotifyTrackFormat(int paramInt)
  {
    if (this.trackFormatNotificationSent[paramInt] == 0)
    {
      Format localFormat = this.tracks.get(paramInt).getFormat(0);
      this.eventDispatcher.downstreamFormatChanged(MimeTypes.getTrackType(localFormat.sampleMimeType), localFormat, 0, null, this.lastSeekPositionUs);
      this.trackFormatNotificationSent[paramInt] = true;
    }
  }
  
  private void maybeStartDeferredRetry(int paramInt)
  {
    int i = 0;
    if ((!this.pendingDeferredRetry) || (this.trackIsAudioVideoFlags[paramInt] == 0) || (this.sampleQueues[paramInt].hasNextSample())) {
      return;
    }
    this.pendingResetPositionUs = 0L;
    this.pendingDeferredRetry = false;
    this.notifyDiscontinuity = true;
    this.lastSeekPositionUs = 0L;
    this.extractedSamplesCountAtStartOfLoad = 0;
    SampleQueue[] arrayOfSampleQueue = this.sampleQueues;
    int j = arrayOfSampleQueue.length;
    paramInt = i;
    while (paramInt < j)
    {
      arrayOfSampleQueue[paramInt].reset();
      paramInt += 1;
    }
    this.callback.onContinueLoadingRequested(this);
  }
  
  private boolean seekInsideBufferUs(long paramLong)
  {
    int k = this.sampleQueues.length;
    int i = 0;
    while (i < k)
    {
      SampleQueue localSampleQueue = this.sampleQueues[i];
      localSampleQueue.rewind();
      if (localSampleQueue.advanceTo(paramLong, true, false) != -1) {}
      for (int j = 1; (j == 0) && ((this.trackIsAudioVideoFlags[i] != 0) || (!this.haveAudioVideoTracks)); j = 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void startLoading()
  {
    ExtractingLoadable localExtractingLoadable = new ExtractingLoadable(this.uri, this.dataSource, this.extractorHolder, this.loadCondition);
    if (this.prepared)
    {
      Assertions.checkState(isPendingReset());
      if ((this.durationUs != -9223372036854775807L) && (this.pendingResetPositionUs >= this.durationUs))
      {
        this.loadingFinished = true;
        this.pendingResetPositionUs = -9223372036854775807L;
        return;
      }
      localExtractingLoadable.setLoadPosition(this.seekMap.getSeekPoints(this.pendingResetPositionUs).first.position, this.pendingResetPositionUs);
      this.pendingResetPositionUs = -9223372036854775807L;
    }
    this.extractedSamplesCountAtStartOfLoad = getExtractedSamplesCount();
    long l = this.loader.startLoading(localExtractingLoadable, this, this.actualMinLoadableRetryCount);
    this.eventDispatcher.loadStarted(localExtractingLoadable.dataSpec, 1, -1, null, 0, null, localExtractingLoadable.seekTimeUs, this.durationUs, l);
  }
  
  private boolean suppressRead()
  {
    return (this.notifyDiscontinuity) || (isPendingReset());
  }
  
  public boolean continueLoading(long paramLong)
  {
    boolean bool;
    if ((this.loadingFinished) || (this.pendingDeferredRetry) || ((this.prepared) && (this.enabledTrackCount == 0))) {
      bool = false;
    }
    do
    {
      return bool;
      bool = this.loadCondition.open();
    } while (this.loader.isLoading());
    startLoading();
    return true;
  }
  
  public void discardBuffer(long paramLong, boolean paramBoolean)
  {
    int j = this.sampleQueues.length;
    int i = 0;
    while (i < j)
    {
      this.sampleQueues[i].discardTo(paramLong, paramBoolean, this.trackEnabledStates[i]);
      i += 1;
    }
  }
  
  public void endTracks()
  {
    this.sampleQueuesBuilt = true;
    this.handler.post(this.maybeFinishPrepareRunnable);
  }
  
  public long getAdjustedSeekPositionUs(long paramLong, SeekParameters paramSeekParameters)
  {
    if (!this.seekMap.isSeekable()) {
      return 0L;
    }
    SeekMap.SeekPoints localSeekPoints = this.seekMap.getSeekPoints(paramLong);
    return Util.resolveSeekPositionUs(paramLong, paramSeekParameters, localSeekPoints.first.timeUs, localSeekPoints.second.timeUs);
  }
  
  public long getBufferedPositionUs()
  {
    long l1;
    if (this.loadingFinished) {
      l1 = -9223372036854775808L;
    }
    long l2;
    do
    {
      return l1;
      if (isPendingReset()) {
        return this.pendingResetPositionUs;
      }
      if (this.haveAudioVideoTracks)
      {
        int j = this.sampleQueues.length;
        l1 = 9223372036854775807L;
        int i = 0;
        for (;;)
        {
          l2 = l1;
          if (i >= j) {
            break;
          }
          l2 = l1;
          if (this.trackIsAudioVideoFlags[i] != 0) {
            l2 = Math.min(l1, this.sampleQueues[i].getLargestQueuedTimestampUs());
          }
          i += 1;
          l1 = l2;
        }
      }
      l2 = getLargestQueuedTimestampUs();
      l1 = l2;
    } while (l2 != -9223372036854775808L);
    return this.lastSeekPositionUs;
  }
  
  public long getNextLoadPositionUs()
  {
    if (this.enabledTrackCount == 0) {
      return -9223372036854775808L;
    }
    return getBufferedPositionUs();
  }
  
  public TrackGroupArray getTrackGroups()
  {
    return this.tracks;
  }
  
  boolean isReady(int paramInt)
  {
    return (!suppressRead()) && ((this.loadingFinished) || (this.sampleQueues[paramInt].hasNextSample()));
  }
  
  void maybeThrowError()
    throws IOException
  {
    this.loader.maybeThrowError(this.actualMinLoadableRetryCount);
  }
  
  public void maybeThrowPrepareError()
    throws IOException
  {
    maybeThrowError();
  }
  
  public void onLoadCanceled(ExtractingLoadable paramExtractingLoadable, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.eventDispatcher.loadCanceled(paramExtractingLoadable.dataSpec, 1, -1, null, 0, null, paramExtractingLoadable.seekTimeUs, this.durationUs, paramLong1, paramLong2, paramExtractingLoadable.bytesLoaded);
    if (!paramBoolean)
    {
      copyLengthFromLoader(paramExtractingLoadable);
      paramExtractingLoadable = this.sampleQueues;
      int j = paramExtractingLoadable.length;
      int i = 0;
      while (i < j)
      {
        paramExtractingLoadable[i].reset();
        i += 1;
      }
      if (this.enabledTrackCount > 0) {
        this.callback.onContinueLoadingRequested(this);
      }
    }
  }
  
  public void onLoadCompleted(ExtractingLoadable paramExtractingLoadable, long paramLong1, long paramLong2)
  {
    if (this.durationUs == -9223372036854775807L)
    {
      l = getLargestQueuedTimestampUs();
      if (l != -9223372036854775808L) {
        break label109;
      }
    }
    label109:
    for (long l = 0L;; l += 10000L)
    {
      this.durationUs = l;
      this.listener.onSourceInfoRefreshed(this.durationUs, this.seekMap.isSeekable());
      this.eventDispatcher.loadCompleted(paramExtractingLoadable.dataSpec, 1, -1, null, 0, null, paramExtractingLoadable.seekTimeUs, this.durationUs, paramLong1, paramLong2, paramExtractingLoadable.bytesLoaded);
      copyLengthFromLoader(paramExtractingLoadable);
      this.loadingFinished = true;
      this.callback.onContinueLoadingRequested(this);
      return;
    }
  }
  
  public int onLoadError(ExtractingLoadable paramExtractingLoadable, long paramLong1, long paramLong2, IOException paramIOException)
  {
    boolean bool = isLoadableExceptionFatal(paramIOException);
    this.eventDispatcher.loadError(paramExtractingLoadable.dataSpec, 1, -1, null, 0, null, paramExtractingLoadable.seekTimeUs, this.durationUs, paramLong1, paramLong2, paramExtractingLoadable.bytesLoaded, paramIOException, bool);
    copyLengthFromLoader(paramExtractingLoadable);
    if (bool) {
      return 3;
    }
    int j = getExtractedSamplesCount();
    int i;
    if (j > this.extractedSamplesCountAtStartOfLoad) {
      i = 1;
    }
    while (configureRetry(paramExtractingLoadable, j)) {
      if (i != 0)
      {
        return 1;
        i = 0;
      }
      else
      {
        return 0;
      }
    }
    return 2;
  }
  
  public void onLoaderReleased()
  {
    SampleQueue[] arrayOfSampleQueue = this.sampleQueues;
    int j = arrayOfSampleQueue.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSampleQueue[i].reset();
      i += 1;
    }
    this.extractorHolder.release();
  }
  
  public void onUpstreamFormatChanged(Format paramFormat)
  {
    this.handler.post(this.maybeFinishPrepareRunnable);
  }
  
  public void prepare(MediaPeriod.Callback paramCallback, long paramLong)
  {
    this.callback = paramCallback;
    this.loadCondition.open();
    startLoading();
  }
  
  int readData(int paramInt, FormatHolder paramFormatHolder, DecoderInputBuffer paramDecoderInputBuffer, boolean paramBoolean)
  {
    if (suppressRead()) {
      return -3;
    }
    int i = this.sampleQueues[paramInt].read(paramFormatHolder, paramDecoderInputBuffer, paramBoolean, this.loadingFinished, this.lastSeekPositionUs);
    if (i == -4) {
      maybeNotifyTrackFormat(paramInt);
    }
    for (;;)
    {
      return i;
      if (i == -3) {
        maybeStartDeferredRetry(paramInt);
      }
    }
  }
  
  public long readDiscontinuity()
  {
    if ((this.notifyDiscontinuity) && ((this.loadingFinished) || (getExtractedSamplesCount() > this.extractedSamplesCountAtStartOfLoad)))
    {
      this.notifyDiscontinuity = false;
      return this.lastSeekPositionUs;
    }
    return -9223372036854775807L;
  }
  
  public void reevaluateBuffer(long paramLong) {}
  
  public void release()
  {
    if (this.prepared)
    {
      SampleQueue[] arrayOfSampleQueue = this.sampleQueues;
      int j = arrayOfSampleQueue.length;
      int i = 0;
      while (i < j)
      {
        arrayOfSampleQueue[i].discardToEnd();
        i += 1;
      }
    }
    this.loader.release(this);
    this.handler.removeCallbacksAndMessages(null);
    this.released = true;
  }
  
  public void seekMap(SeekMap paramSeekMap)
  {
    this.seekMap = paramSeekMap;
    this.handler.post(this.maybeFinishPrepareRunnable);
  }
  
  public long seekToUs(long paramLong)
  {
    int i = 0;
    if (this.seekMap.isSeekable())
    {
      this.lastSeekPositionUs = paramLong;
      this.notifyDiscontinuity = false;
      if ((isPendingReset()) || (!seekInsideBufferUs(paramLong))) {
        break label46;
      }
    }
    for (;;)
    {
      return paramLong;
      paramLong = 0L;
      break;
      label46:
      this.pendingDeferredRetry = false;
      this.pendingResetPositionUs = paramLong;
      this.loadingFinished = false;
      if (this.loader.isLoading())
      {
        this.loader.cancelLoading();
        return paramLong;
      }
      SampleQueue[] arrayOfSampleQueue = this.sampleQueues;
      int j = arrayOfSampleQueue.length;
      while (i < j)
      {
        arrayOfSampleQueue[i].reset();
        i += 1;
      }
    }
  }
  
  public long selectTracks(TrackSelection[] paramArrayOfTrackSelection, boolean[] paramArrayOfBoolean1, SampleStream[] paramArrayOfSampleStream, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    int n = 0;
    int i1 = 0;
    int m = 0;
    Assertions.checkState(this.prepared);
    int j = this.enabledTrackCount;
    int i = 0;
    int k;
    while (i < paramArrayOfTrackSelection.length)
    {
      if ((paramArrayOfSampleStream[i] != null) && ((paramArrayOfTrackSelection[i] == null) || (paramArrayOfBoolean1[i] == 0)))
      {
        k = ((SampleStreamImpl)paramArrayOfSampleStream[i]).track;
        Assertions.checkState(this.trackEnabledStates[k]);
        this.enabledTrackCount -= 1;
        this.trackEnabledStates[k] = false;
        paramArrayOfSampleStream[i] = null;
      }
      i += 1;
    }
    label129:
    boolean bool;
    if (this.seenFirstTrackSelection) {
      if (j == 0)
      {
        i = 1;
        j = 0;
        k = i;
        if (j >= paramArrayOfTrackSelection.length) {
          break label375;
        }
        i = k;
        if (paramArrayOfSampleStream[j] == null)
        {
          i = k;
          if (paramArrayOfTrackSelection[j] != null)
          {
            paramArrayOfBoolean1 = paramArrayOfTrackSelection[j];
            if (paramArrayOfBoolean1.length() != 1) {
              break label351;
            }
            bool = true;
            label176:
            Assertions.checkState(bool);
            if (paramArrayOfBoolean1.getIndexInTrackGroup(0) != 0) {
              break label357;
            }
            bool = true;
            label194:
            Assertions.checkState(bool);
            int i2 = this.tracks.indexOf(paramArrayOfBoolean1.getTrackGroup());
            if (this.trackEnabledStates[i2] != 0) {
              break label363;
            }
            bool = true;
            label227:
            Assertions.checkState(bool);
            this.enabledTrackCount += 1;
            this.trackEnabledStates[i2] = true;
            paramArrayOfSampleStream[j] = new SampleStreamImpl(i2);
            paramArrayOfBoolean2[j] = true;
            i = k;
            if (k == 0)
            {
              paramArrayOfBoolean1 = this.sampleQueues[i2];
              paramArrayOfBoolean1.rewind();
              if ((paramArrayOfBoolean1.advanceTo(paramLong, true, true) != -1) || (paramArrayOfBoolean1.getReadIndex() == 0)) {
                break label369;
              }
            }
          }
        }
      }
    }
    label351:
    label357:
    label363:
    label369:
    for (i = 1;; i = 0)
    {
      j += 1;
      k = i;
      break label129;
      i = 0;
      break;
      if (paramLong != 0L)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      bool = false;
      break label176;
      bool = false;
      break label194;
      bool = false;
      break label227;
    }
    label375:
    long l;
    if (this.enabledTrackCount == 0)
    {
      this.pendingDeferredRetry = false;
      this.notifyDiscontinuity = false;
      if (this.loader.isLoading())
      {
        paramArrayOfTrackSelection = this.sampleQueues;
        j = paramArrayOfTrackSelection.length;
        i = m;
        while (i < j)
        {
          paramArrayOfTrackSelection[i].discardToEnd();
          i += 1;
        }
        this.loader.cancelLoading();
        l = paramLong;
      }
    }
    do
    {
      this.seenFirstTrackSelection = true;
      return l;
      paramArrayOfTrackSelection = this.sampleQueues;
      j = paramArrayOfTrackSelection.length;
      i = n;
      for (;;)
      {
        l = paramLong;
        if (i >= j) {
          break;
        }
        paramArrayOfTrackSelection[i].reset();
        i += 1;
      }
      l = paramLong;
    } while (k == 0);
    paramLong = seekToUs(paramLong);
    i = i1;
    for (;;)
    {
      l = paramLong;
      if (i >= paramArrayOfSampleStream.length) {
        break;
      }
      if (paramArrayOfSampleStream[i] != null) {
        paramArrayOfBoolean2[i] = true;
      }
      i += 1;
    }
  }
  
  int skipData(int paramInt, long paramLong)
  {
    int i = 0;
    if (suppressRead()) {
      return 0;
    }
    SampleQueue localSampleQueue = this.sampleQueues[paramInt];
    if ((this.loadingFinished) && (paramLong > localSampleQueue.getLargestQueuedTimestampUs())) {
      i = localSampleQueue.advanceToEnd();
    }
    while (i > 0)
    {
      maybeNotifyTrackFormat(paramInt);
      return i;
      int j = localSampleQueue.advanceTo(paramLong, true, true);
      if (j != -1) {
        i = j;
      }
    }
    maybeStartDeferredRetry(paramInt);
    return i;
  }
  
  public TrackOutput track(int paramInt1, int paramInt2)
  {
    int j = this.sampleQueues.length;
    int i = 0;
    while (i < j)
    {
      if (this.sampleQueueTrackIds[i] == paramInt1) {
        return this.sampleQueues[i];
      }
      i += 1;
    }
    SampleQueue localSampleQueue = new SampleQueue(this.allocator);
    localSampleQueue.setUpstreamFormatChangeListener(this);
    this.sampleQueueTrackIds = Arrays.copyOf(this.sampleQueueTrackIds, j + 1);
    this.sampleQueueTrackIds[j] = paramInt1;
    this.sampleQueueTrackTypes = Arrays.copyOf(this.sampleQueueTrackTypes, j + 1);
    this.sampleQueueTrackTypes[j] = paramInt2;
    this.sampleQueues = ((SampleQueue[])Arrays.copyOf(this.sampleQueues, j + 1));
    this.sampleQueues[j] = localSampleQueue;
    return localSampleQueue;
  }
  
  final class ExtractingLoadable
    implements Loader.Loadable
  {
    private long bytesLoaded;
    private final DataSource dataSource;
    private DataSpec dataSpec;
    private final ExtractorMediaPeriod.ExtractorHolder extractorHolder;
    private long length;
    private volatile boolean loadCanceled;
    private final ConditionVariable loadCondition;
    private boolean pendingExtractorSeek;
    private final PositionHolder positionHolder;
    private long seekTimeUs;
    private final Uri uri;
    
    public ExtractingLoadable(Uri paramUri, DataSource paramDataSource, ExtractorMediaPeriod.ExtractorHolder paramExtractorHolder, ConditionVariable paramConditionVariable)
    {
      this.uri = ((Uri)Assertions.checkNotNull(paramUri));
      this.dataSource = ((DataSource)Assertions.checkNotNull(paramDataSource));
      this.extractorHolder = ((ExtractorMediaPeriod.ExtractorHolder)Assertions.checkNotNull(paramExtractorHolder));
      this.loadCondition = paramConditionVariable;
      this.positionHolder = new PositionHolder();
      this.pendingExtractorSeek = true;
      this.length = -1L;
    }
    
    public void cancelLoad()
    {
      this.loadCanceled = true;
    }
    
    public boolean isLoadCanceled()
    {
      return this.loadCanceled;
    }
    
    /* Error */
    public void load()
      throws IOException, java.lang.InterruptedException
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_1
      //   2: iload_1
      //   3: ifne +362 -> 365
      //   6: aload_0
      //   7: getfield 84	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:loadCanceled	Z
      //   10: ifne +355 -> 365
      //   13: aload_0
      //   14: getfield 62	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:positionHolder	Lcom/google/android/exoplayer2/extractor/PositionHolder;
      //   17: getfield 94	com/google/android/exoplayer2/extractor/PositionHolder:position	J
      //   20: lstore_3
      //   21: aload_0
      //   22: new 96	com/google/android/exoplayer2/upstream/DataSpec
      //   25: dup
      //   26: aload_0
      //   27: getfield 47	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:uri	Landroid/net/Uri;
      //   30: lload_3
      //   31: ldc2_w 65
      //   34: aload_0
      //   35: getfield 34	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:this$0	Lcom/google/android/exoplayer2/source/ExtractorMediaPeriod;
      //   38: invokestatic 100	com/google/android/exoplayer2/source/ExtractorMediaPeriod:access$800	(Lcom/google/android/exoplayer2/source/ExtractorMediaPeriod;)Ljava/lang/String;
      //   41: invokespecial 103	com/google/android/exoplayer2/upstream/DataSpec:<init>	(Landroid/net/Uri;JJLjava/lang/String;)V
      //   44: putfield 73	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:dataSpec	Lcom/google/android/exoplayer2/upstream/DataSpec;
      //   47: aload_0
      //   48: aload_0
      //   49: getfield 51	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:dataSource	Lcom/google/android/exoplayer2/upstream/DataSource;
      //   52: aload_0
      //   53: getfield 73	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:dataSpec	Lcom/google/android/exoplayer2/upstream/DataSpec;
      //   56: invokeinterface 107 2 0
      //   61: putfield 68	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:length	J
      //   64: aload_0
      //   65: getfield 68	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:length	J
      //   68: ldc2_w 65
      //   71: lcmp
      //   72: ifeq +13 -> 85
      //   75: aload_0
      //   76: aload_0
      //   77: getfield 68	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:length	J
      //   80: lload_3
      //   81: ladd
      //   82: putfield 68	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:length	J
      //   85: new 109	com/google/android/exoplayer2/extractor/DefaultExtractorInput
      //   88: dup
      //   89: aload_0
      //   90: getfield 51	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:dataSource	Lcom/google/android/exoplayer2/upstream/DataSource;
      //   93: lload_3
      //   94: aload_0
      //   95: getfield 68	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:length	J
      //   98: invokespecial 112	com/google/android/exoplayer2/extractor/DefaultExtractorInput:<init>	(Lcom/google/android/exoplayer2/upstream/DataSource;JJ)V
      //   101: astore 5
      //   103: aload_0
      //   104: getfield 55	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:extractorHolder	Lcom/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractorHolder;
      //   107: aload 5
      //   109: aload_0
      //   110: getfield 51	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:dataSource	Lcom/google/android/exoplayer2/upstream/DataSource;
      //   113: invokeinterface 116 1 0
      //   118: invokevirtual 120	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractorHolder:selectExtractor	(Lcom/google/android/exoplayer2/extractor/ExtractorInput;Landroid/net/Uri;)Lcom/google/android/exoplayer2/extractor/Extractor;
      //   121: astore 6
      //   123: aload_0
      //   124: getfield 64	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:pendingExtractorSeek	Z
      //   127: ifeq +20 -> 147
      //   130: aload 6
      //   132: lload_3
      //   133: aload_0
      //   134: getfield 77	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:seekTimeUs	J
      //   137: invokeinterface 126 5 0
      //   142: aload_0
      //   143: iconst_0
      //   144: putfield 64	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:pendingExtractorSeek	Z
      //   147: ldc 128
      //   149: invokestatic 134	com/google/android/exoplayer2/util/TraceUtil:beginSection	(Ljava/lang/String;)V
      //   152: iload_1
      //   153: ifne +90 -> 243
      //   156: aload_0
      //   157: getfield 84	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:loadCanceled	Z
      //   160: ifne +83 -> 243
      //   163: aload_0
      //   164: getfield 57	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:loadCondition	Lcom/google/android/exoplayer2/util/ConditionVariable;
      //   167: invokevirtual 139	com/google/android/exoplayer2/util/ConditionVariable:block	()V
      //   170: aload 6
      //   172: aload 5
      //   174: aload_0
      //   175: getfield 62	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:positionHolder	Lcom/google/android/exoplayer2/extractor/PositionHolder;
      //   178: invokeinterface 143 3 0
      //   183: istore_2
      //   184: iload_2
      //   185: istore_1
      //   186: aload 5
      //   188: invokeinterface 149 1 0
      //   193: aload_0
      //   194: getfield 34	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:this$0	Lcom/google/android/exoplayer2/source/ExtractorMediaPeriod;
      //   197: invokestatic 153	com/google/android/exoplayer2/source/ExtractorMediaPeriod:access$900	(Lcom/google/android/exoplayer2/source/ExtractorMediaPeriod;)J
      //   200: lload_3
      //   201: ladd
      //   202: lcmp
      //   203: ifle +206 -> 409
      //   206: aload 5
      //   208: invokeinterface 149 1 0
      //   213: lstore_3
      //   214: aload_0
      //   215: getfield 57	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:loadCondition	Lcom/google/android/exoplayer2/util/ConditionVariable;
      //   218: invokevirtual 156	com/google/android/exoplayer2/util/ConditionVariable:close	()Z
      //   221: pop
      //   222: aload_0
      //   223: getfield 34	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:this$0	Lcom/google/android/exoplayer2/source/ExtractorMediaPeriod;
      //   226: invokestatic 160	com/google/android/exoplayer2/source/ExtractorMediaPeriod:access$1100	(Lcom/google/android/exoplayer2/source/ExtractorMediaPeriod;)Landroid/os/Handler;
      //   229: aload_0
      //   230: getfield 34	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:this$0	Lcom/google/android/exoplayer2/source/ExtractorMediaPeriod;
      //   233: invokestatic 164	com/google/android/exoplayer2/source/ExtractorMediaPeriod:access$1000	(Lcom/google/android/exoplayer2/source/ExtractorMediaPeriod;)Ljava/lang/Runnable;
      //   236: invokevirtual 170	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   239: pop
      //   240: goto -88 -> 152
      //   243: invokestatic 173	com/google/android/exoplayer2/util/TraceUtil:endSection	()V
      //   246: iload_1
      //   247: iconst_1
      //   248: if_icmpne +15 -> 263
      //   251: iconst_0
      //   252: istore_1
      //   253: aload_0
      //   254: getfield 51	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:dataSource	Lcom/google/android/exoplayer2/upstream/DataSource;
      //   257: invokestatic 179	com/google/android/exoplayer2/util/Util:closeQuietly	(Lcom/google/android/exoplayer2/upstream/DataSource;)V
      //   260: goto -258 -> 2
      //   263: aload 5
      //   265: ifnull +36 -> 301
      //   268: aload_0
      //   269: getfield 62	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:positionHolder	Lcom/google/android/exoplayer2/extractor/PositionHolder;
      //   272: aload 5
      //   274: invokeinterface 149 1 0
      //   279: putfield 94	com/google/android/exoplayer2/extractor/PositionHolder:position	J
      //   282: aload_0
      //   283: aload_0
      //   284: getfield 62	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:positionHolder	Lcom/google/android/exoplayer2/extractor/PositionHolder;
      //   287: getfield 94	com/google/android/exoplayer2/extractor/PositionHolder:position	J
      //   290: aload_0
      //   291: getfield 73	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:dataSpec	Lcom/google/android/exoplayer2/upstream/DataSpec;
      //   294: getfield 182	com/google/android/exoplayer2/upstream/DataSpec:absoluteStreamPosition	J
      //   297: lsub
      //   298: putfield 80	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:bytesLoaded	J
      //   301: goto -48 -> 253
      //   304: astore 5
      //   306: aconst_null
      //   307: astore 6
      //   309: iload_1
      //   310: iconst_1
      //   311: if_icmpne +13 -> 324
      //   314: aload_0
      //   315: getfield 51	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:dataSource	Lcom/google/android/exoplayer2/upstream/DataSource;
      //   318: invokestatic 179	com/google/android/exoplayer2/util/Util:closeQuietly	(Lcom/google/android/exoplayer2/upstream/DataSource;)V
      //   321: aload 5
      //   323: athrow
      //   324: aload 6
      //   326: ifnull -12 -> 314
      //   329: aload_0
      //   330: getfield 62	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:positionHolder	Lcom/google/android/exoplayer2/extractor/PositionHolder;
      //   333: aload 6
      //   335: invokeinterface 149 1 0
      //   340: putfield 94	com/google/android/exoplayer2/extractor/PositionHolder:position	J
      //   343: aload_0
      //   344: aload_0
      //   345: getfield 62	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:positionHolder	Lcom/google/android/exoplayer2/extractor/PositionHolder;
      //   348: getfield 94	com/google/android/exoplayer2/extractor/PositionHolder:position	J
      //   351: aload_0
      //   352: getfield 73	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:dataSpec	Lcom/google/android/exoplayer2/upstream/DataSpec;
      //   355: getfield 182	com/google/android/exoplayer2/upstream/DataSpec:absoluteStreamPosition	J
      //   358: lsub
      //   359: putfield 80	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractingLoadable:bytesLoaded	J
      //   362: goto -48 -> 314
      //   365: return
      //   366: astore 6
      //   368: aload 5
      //   370: astore 7
      //   372: aload 6
      //   374: astore 5
      //   376: aload 7
      //   378: astore 6
      //   380: goto -71 -> 309
      //   383: astore 7
      //   385: aload 5
      //   387: astore 6
      //   389: aload 7
      //   391: astore 5
      //   393: goto -84 -> 309
      //   396: astore 7
      //   398: aload 5
      //   400: astore 6
      //   402: aload 7
      //   404: astore 5
      //   406: goto -97 -> 309
      //   409: goto -257 -> 152
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	412	0	this	ExtractingLoadable
      //   1	311	1	i	int
      //   183	2	2	j	int
      //   20	194	3	l	long
      //   101	172	5	localDefaultExtractorInput	com.google.android.exoplayer2.extractor.DefaultExtractorInput
      //   304	65	5	localObject1	Object
      //   374	31	5	localObject2	Object
      //   121	213	6	localExtractor	Extractor
      //   366	7	6	localObject3	Object
      //   378	23	6	localObject4	Object
      //   370	7	7	localObject5	Object
      //   383	7	7	localObject6	Object
      //   396	7	7	localObject7	Object
      // Exception table:
      //   from	to	target	type
      //   13	85	304	finally
      //   85	103	304	finally
      //   103	147	366	finally
      //   147	152	366	finally
      //   156	184	383	finally
      //   243	246	383	finally
      //   186	240	396	finally
    }
    
    public void setLoadPosition(long paramLong1, long paramLong2)
    {
      this.positionHolder.position = paramLong1;
      this.seekTimeUs = paramLong2;
      this.pendingExtractorSeek = true;
    }
  }
  
  static final class ExtractorHolder
  {
    private Extractor extractor;
    private final ExtractorOutput extractorOutput;
    private final Extractor[] extractors;
    
    public ExtractorHolder(Extractor[] paramArrayOfExtractor, ExtractorOutput paramExtractorOutput)
    {
      this.extractors = paramArrayOfExtractor;
      this.extractorOutput = paramExtractorOutput;
    }
    
    public void release()
    {
      if (this.extractor != null)
      {
        this.extractor.release();
        this.extractor = null;
      }
    }
    
    /* Error */
    public Extractor selectExtractor(com.google.android.exoplayer2.extractor.ExtractorInput paramExtractorInput, Uri paramUri)
      throws IOException, java.lang.InterruptedException
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 26	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractorHolder:extractor	Lcom/google/android/exoplayer2/extractor/Extractor;
      //   4: ifnull +8 -> 12
      //   7: aload_0
      //   8: getfield 26	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractorHolder:extractor	Lcom/google/android/exoplayer2/extractor/Extractor;
      //   11: areturn
      //   12: aload_0
      //   13: getfield 20	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractorHolder:extractors	[Lcom/google/android/exoplayer2/extractor/Extractor;
      //   16: astore 5
      //   18: aload 5
      //   20: arraylength
      //   21: istore 4
      //   23: iconst_0
      //   24: istore_3
      //   25: iload_3
      //   26: iload 4
      //   28: if_icmpge +32 -> 60
      //   31: aload 5
      //   33: iload_3
      //   34: aaload
      //   35: astore 6
      //   37: aload 6
      //   39: aload_1
      //   40: invokeinterface 42 2 0
      //   45: ifeq +61 -> 106
      //   48: aload_0
      //   49: aload 6
      //   51: putfield 26	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractorHolder:extractor	Lcom/google/android/exoplayer2/extractor/Extractor;
      //   54: aload_1
      //   55: invokeinterface 47 1 0
      //   60: aload_0
      //   61: getfield 26	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractorHolder:extractor	Lcom/google/android/exoplayer2/extractor/Extractor;
      //   64: ifnonnull +75 -> 139
      //   67: new 49	com/google/android/exoplayer2/source/UnrecognizedInputFormatException
      //   70: dup
      //   71: new 51	java/lang/StringBuilder
      //   74: dup
      //   75: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   78: ldc 54
      //   80: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   83: aload_0
      //   84: getfield 20	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractorHolder:extractors	[Lcom/google/android/exoplayer2/extractor/Extractor;
      //   87: invokestatic 64	com/google/android/exoplayer2/util/Util:getCommaDelimitedSimpleClassNames	([Ljava/lang/Object;)Ljava/lang/String;
      //   90: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   93: ldc 66
      //   95: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   98: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   101: aload_2
      //   102: invokespecial 73	com/google/android/exoplayer2/source/UnrecognizedInputFormatException:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
      //   105: athrow
      //   106: aload_1
      //   107: invokeinterface 47 1 0
      //   112: iload_3
      //   113: iconst_1
      //   114: iadd
      //   115: istore_3
      //   116: goto -91 -> 25
      //   119: astore 6
      //   121: aload_1
      //   122: invokeinterface 47 1 0
      //   127: goto -15 -> 112
      //   130: astore_2
      //   131: aload_1
      //   132: invokeinterface 47 1 0
      //   137: aload_2
      //   138: athrow
      //   139: aload_0
      //   140: getfield 26	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractorHolder:extractor	Lcom/google/android/exoplayer2/extractor/Extractor;
      //   143: aload_0
      //   144: getfield 22	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractorHolder:extractorOutput	Lcom/google/android/exoplayer2/extractor/ExtractorOutput;
      //   147: invokeinterface 77 2 0
      //   152: aload_0
      //   153: getfield 26	com/google/android/exoplayer2/source/ExtractorMediaPeriod$ExtractorHolder:extractor	Lcom/google/android/exoplayer2/extractor/Extractor;
      //   156: areturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	157	0	this	ExtractorHolder
      //   0	157	1	paramExtractorInput	com.google.android.exoplayer2.extractor.ExtractorInput
      //   0	157	2	paramUri	Uri
      //   24	92	3	i	int
      //   21	8	4	j	int
      //   16	16	5	arrayOfExtractor	Extractor[]
      //   35	15	6	localExtractor	Extractor
      //   119	1	6	localEOFException	java.io.EOFException
      // Exception table:
      //   from	to	target	type
      //   37	54	119	java/io/EOFException
      //   37	54	130	finally
    }
  }
  
  static abstract interface Listener
  {
    public abstract void onSourceInfoRefreshed(long paramLong, boolean paramBoolean);
  }
  
  final class SampleStreamImpl
    implements SampleStream
  {
    private final int track;
    
    public SampleStreamImpl(int paramInt)
    {
      this.track = paramInt;
    }
    
    public boolean isReady()
    {
      return ExtractorMediaPeriod.this.isReady(this.track);
    }
    
    public void maybeThrowError()
      throws IOException
    {
      ExtractorMediaPeriod.this.maybeThrowError();
    }
    
    public int readData(FormatHolder paramFormatHolder, DecoderInputBuffer paramDecoderInputBuffer, boolean paramBoolean)
    {
      return ExtractorMediaPeriod.this.readData(this.track, paramFormatHolder, paramDecoderInputBuffer, paramBoolean);
    }
    
    public int skipData(long paramLong)
    {
      return ExtractorMediaPeriod.this.skipData(this.track, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ExtractorMediaPeriod
 * JD-Core Version:    0.7.0.1
 */