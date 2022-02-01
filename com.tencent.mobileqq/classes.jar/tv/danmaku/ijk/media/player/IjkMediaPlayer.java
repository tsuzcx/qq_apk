package tv.danmaku.ijk.media.player;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.tencent.oskplayer.miscellaneous.MediaFormatProxy;
import com.tencent.oskplayer.support.loader.DefaultNativeLibLoader;
import com.tencent.oskplayer.support.loader.NativeLibLoader;
import com.tencent.oskplayer.support.loader.NativeLibLoader.State;
import com.tencent.oskplayer.support.log.ILogger;
import com.tencent.oskplayer.support.log.Logger;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import tv.danmaku.ijk.media.player.annotations.AccessedByNative;
import tv.danmaku.ijk.media.player.annotations.CalledByNative;
import tv.danmaku.ijk.media.player.misc.IAndroidIO;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.misc.IjkTrackInfo;
import tv.danmaku.ijk.media.player.pragma.DebugLog;

public final class IjkMediaPlayer
  extends AbstractMediaPlayer
{
  public static final int FFP_PROPV_DECODER_AVCODEC = 1;
  public static final int FFP_PROPV_DECODER_MEDIACODEC = 2;
  public static final int FFP_PROPV_DECODER_UNKNOWN = 0;
  public static final int FFP_PROPV_DECODER_VIDEOTOOLBOX = 3;
  public static final int FFP_PROP_FLOAT_DROP_FRAME_RATE = 10007;
  public static final int FFP_PROP_FLOAT_PLAYBACK_RATE = 10003;
  public static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_BACKWARDS = 20201;
  public static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_CAPACITY = 20203;
  public static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_FORWARDS = 20202;
  public static final int FFP_PROP_INT64_AUDIO_CACHED_BYTES = 20008;
  public static final int FFP_PROP_INT64_AUDIO_CACHED_DURATION = 20006;
  public static final int FFP_PROP_INT64_AUDIO_CACHED_PACKETS = 20010;
  public static final int FFP_PROP_INT64_AUDIO_DECODER = 20004;
  public static final int FFP_PROP_INT64_BIT_RATE = 20100;
  public static final int FFP_PROP_INT64_CACHE_STATISTIC_COUNT_BYTES = 20208;
  public static final int FFP_PROP_INT64_CACHE_STATISTIC_FILE_FORWARDS = 20206;
  public static final int FFP_PROP_INT64_CACHE_STATISTIC_FILE_POS = 20207;
  public static final int FFP_PROP_INT64_CACHE_STATISTIC_PHYSICAL_POS = 20205;
  public static final int FFP_PROP_INT64_IMMEDIATE_RECONNECT = 20211;
  public static final int FFP_PROP_INT64_LATEST_SEEK_LOAD_DURATION = 20300;
  public static final int FFP_PROP_INT64_LOGICAL_FILE_SIZE = 20209;
  public static final int FFP_PROP_INT64_PRE_READING_BUFFER = 20016;
  public static final int FFP_PROP_INT64_SELECTED_AUDIO_STREAM = 20002;
  public static final int FFP_PROP_INT64_SELECTED_TIMEDTEXT_STREAM = 20011;
  public static final int FFP_PROP_INT64_SELECTED_VIDEO_STREAM = 20001;
  public static final int FFP_PROP_INT64_SHARE_CACHE_DATA = 20210;
  public static final int FFP_PROP_INT64_TCP_SPEED = 20200;
  public static final int FFP_PROP_INT64_TRAFFIC_STATISTIC_BYTE_COUNT = 20204;
  public static final int FFP_PROP_INT64_VIDEO_CACHED_BYTES = 20007;
  public static final int FFP_PROP_INT64_VIDEO_CACHED_DURATION = 20005;
  public static final int FFP_PROP_INT64_VIDEO_CACHED_PACKETS = 20009;
  public static final int FFP_PROP_INT64_VIDEO_DECODER = 20003;
  public static final int IJK_LOG_DEBUG = 3;
  public static final int IJK_LOG_DEFAULT = 1;
  public static final int IJK_LOG_ERROR = 6;
  public static final int IJK_LOG_FATAL = 7;
  public static final int IJK_LOG_INFO = 4;
  public static final int IJK_LOG_SILENT = 8;
  public static final int IJK_LOG_UNKNOWN = 0;
  public static final int IJK_LOG_VERBOSE = 2;
  public static final int IJK_LOG_WARN = 5;
  private static final int MEDIA_BUFFERING_UPDATE = 3;
  private static final int MEDIA_ERROR = 100;
  private static final int MEDIA_INFO = 200;
  private static final int MEDIA_NOP = 0;
  private static final int MEDIA_PLAYBACK_COMPLETE = 2;
  private static final int MEDIA_PREPARED = 1;
  private static final int MEDIA_SEEK_COMPLETE = 4;
  protected static final int MEDIA_SET_VIDEO_SAR = 10001;
  private static final int MEDIA_SET_VIDEO_SIZE = 5;
  private static final int MEDIA_TIMED_TEXT = 99;
  public static final int OPT_CATEGORY_CODEC = 2;
  public static final int OPT_CATEGORY_FORMAT = 1;
  public static final int OPT_CATEGORY_PLAYER = 4;
  public static final int OPT_CATEGORY_SWS = 3;
  public static final int PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND = 10001;
  public static final int PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND = 10002;
  public static final int SDL_FCC_RV16 = 909203026;
  public static final int SDL_FCC_RV32 = 842225234;
  public static final int SDL_FCC_YV12 = 842094169;
  private static final String TAG = "tv.danmaku.ijk.media.player.IjkMediaPlayer";
  private static volatile boolean mIsNativeInitialized = false;
  public static volatile boolean sIsLibLoadSuccess;
  private static Object sIsNativeLibReady;
  private static final NativeLibLoader sLocalLibLoader = new DefaultNativeLibLoader();
  private String mDataSource;
  private IjkMediaPlayer.EventHandler mEventHandler;
  private volatile boolean mIsReleased;
  @AccessedByNative
  private int mListenerContext;
  @AccessedByNative
  private long mNativeAndroidIO;
  @AccessedByNative
  private long mNativeMediaDataSource;
  @AccessedByNative
  private long mNativeMediaPlayer;
  @AccessedByNative
  private int mNativeSurfaceTexture;
  private IjkMediaPlayer.OnControlMessageListener mOnControlMessageListener;
  private IjkMediaPlayer.OnMediaCodecSelectListener mOnMediaCodecSelectListener;
  private IjkMediaPlayer.OnNativeInvokeListener mOnNativeInvokeListener;
  private boolean mScreenOnWhilePlaying;
  private boolean mStayAwake;
  private SurfaceHolder mSurfaceHolder;
  private int mVideoHeight;
  private int mVideoSarDen;
  private int mVideoSarNum;
  private int mVideoWidth;
  private PowerManager.WakeLock mWakeLock = null;
  
  static
  {
    sIsLibLoadSuccess = false;
    sIsNativeLibReady = null;
  }
  
  public IjkMediaPlayer()
  {
    this(sLocalLibLoader);
  }
  
  public IjkMediaPlayer(NativeLibLoader paramNativeLibLoader)
  {
    initPlayer(paramNativeLibLoader);
  }
  
  private native String _getAudioCodecInfo();
  
  private static native String _getColorFormatName(int paramInt);
  
  private native double _getFPCalculation(int paramInt);
  
  private native int _getLoopCount();
  
  private native Bundle _getMediaMeta();
  
  private native float _getPropertyFloat(int paramInt, float paramFloat);
  
  private native long _getPropertyLong(int paramInt, long paramLong);
  
  private native String _getVideoCodecInfo();
  
  private native void _pause();
  
  private native void _release();
  
  private native void _reset();
  
  private native void _setAndroidIOCallback(IAndroidIO paramIAndroidIO);
  
  private native void _setDataSource(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2);
  
  private native void _setDataSource(IMediaDataSource paramIMediaDataSource);
  
  private native void _setDataSourceFd(int paramInt);
  
  private native void _setFrameAtTime(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native void _setLoopCount(int paramInt);
  
  private native void _setOption(int paramInt, String paramString, long paramLong);
  
  private native void _setOption(int paramInt, String paramString1, String paramString2);
  
  private native void _setPropertyFloat(int paramInt, float paramFloat);
  
  private native void _setPropertyLong(int paramInt, long paramLong);
  
  private native void _setStreamSelected(int paramInt, boolean paramBoolean);
  
  private native void _setVideoSurface(Surface paramSurface);
  
  private native void _start();
  
  private native void _stop();
  
  public static String getColorFormatName(int paramInt)
  {
    return _getColorFormatName(paramInt);
  }
  
  public static native MediaFormatProxy getHEVCVideoFormat(String paramString);
  
  private static void initNativeOnce()
  {
    try
    {
      if (!mIsNativeInitialized)
      {
        native_init();
        mIsNativeInitialized = true;
      }
      return;
    }
    finally {}
  }
  
  private void initPlayer(NativeLibLoader paramNativeLibLoader)
  {
    loadLibrariesOnce(paramNativeLibLoader);
    if (!sIsLibLoadSuccess) {
      return;
    }
    initNativeOnce();
    paramNativeLibLoader = Looper.myLooper();
    if (paramNativeLibLoader != null)
    {
      this.mEventHandler = new IjkMediaPlayer.EventHandler(this, paramNativeLibLoader);
    }
    else
    {
      paramNativeLibLoader = Looper.getMainLooper();
      if (paramNativeLibLoader != null) {
        this.mEventHandler = new IjkMediaPlayer.EventHandler(this, paramNativeLibLoader);
      } else {
        this.mEventHandler = null;
      }
    }
    native_setup(new WeakReference(this));
  }
  
  public static boolean isNativeLibReady(NativeLibLoader paramNativeLibLoader)
  {
    NativeLibLoader localNativeLibLoader = paramNativeLibLoader;
    if (paramNativeLibLoader == null) {}
    try
    {
      localNativeLibLoader = sLocalLibLoader;
      boolean bool1;
      if (sIsNativeLibReady != null)
      {
        bool1 = ((Boolean)sIsNativeLibReady).booleanValue();
        return bool1;
      }
      boolean bool2 = false;
      if (localNativeLibLoader != null)
      {
        if ((localNativeLibLoader.isLibReadyToLoad("ijkffmpeg") != NativeLibLoader.State.WAIT) && (localNativeLibLoader.isLibReadyToLoad("ijksdl") != NativeLibLoader.State.WAIT) && (localNativeLibLoader.isLibReadyToLoad("ijkplayer") != NativeLibLoader.State.WAIT))
        {
          bool1 = bool2;
          if (localNativeLibLoader.isLibReadyToLoad("ijkffmpeg") == NativeLibLoader.State.TRUE)
          {
            bool1 = bool2;
            if (localNativeLibLoader.isLibReadyToLoad("ijksdl") == NativeLibLoader.State.TRUE)
            {
              bool1 = bool2;
              if (localNativeLibLoader.isLibReadyToLoad("ijkplayer") == NativeLibLoader.State.TRUE) {
                bool1 = true;
              }
            }
          }
          sIsNativeLibReady = Boolean.valueOf(bool1);
          bool1 = ((Boolean)sIsNativeLibReady).booleanValue();
          return bool1;
        }
        return false;
      }
      return false;
    }
    finally {}
  }
  
  public static void loadLibrariesOnce(NativeLibLoader paramNativeLibLoader)
  {
    try
    {
      if (!sIsLibLoadSuccess)
      {
        Object localObject1 = paramNativeLibLoader;
        if (paramNativeLibLoader == null) {
          localObject1 = sLocalLibLoader;
        }
        try
        {
          ((NativeLibLoader)localObject1).loadLibrary("ijkffmpeg");
          ((NativeLibLoader)localObject1).loadLibrary("ijksdl");
          ((NativeLibLoader)localObject1).loadLibrary("ijkplayer");
          sIsLibLoadSuccess = true;
        }
        catch (Throwable paramNativeLibLoader)
        {
          localObject1 = Logger.g();
          localObject2 = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("failed to load library mIsLibLoaded=");
          localStringBuilder.append(sIsLibLoadSuccess);
          ((ILogger)localObject1).w((String)localObject2, localStringBuilder.toString());
          paramNativeLibLoader.printStackTrace();
        }
        paramNativeLibLoader = Logger.g();
        localObject1 = TAG;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("library loaded result ");
        ((StringBuilder)localObject2).append(sIsLibLoadSuccess);
        paramNativeLibLoader.i((String)localObject1, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    finally {}
  }
  
  private native void native_finalize();
  
  private static native void native_init();
  
  private native void native_message_loop(Object paramObject);
  
  public static native void native_profileBegin(String paramString);
  
  public static native void native_profileEnd();
  
  public static native void native_setLogLevel(int paramInt);
  
  private native void native_setup(Object paramObject);
  
  @CalledByNative
  private static boolean onNativeInvoke(Object paramObject, int paramInt, Bundle paramBundle)
  {
    DebugLog.ifmt(TAG, "onNativeInvoke %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramObject != null) && ((paramObject instanceof WeakReference)))
    {
      paramObject = (IjkMediaPlayer)((WeakReference)paramObject).get();
      if (paramObject != null)
      {
        IjkMediaPlayer.OnNativeInvokeListener localOnNativeInvokeListener = paramObject.mOnNativeInvokeListener;
        if ((localOnNativeInvokeListener != null) && (localOnNativeInvokeListener.onNativeInvoke(paramInt, paramBundle))) {
          return true;
        }
        if (paramInt != 131079) {
          return false;
        }
        paramObject = paramObject.mOnControlMessageListener;
        if (paramObject == null) {
          return false;
        }
        paramInt = paramBundle.getInt("segment_index", -1);
        if (paramInt >= 0)
        {
          paramObject = paramObject.onControlResolveSegmentUrl(paramInt);
          if (paramObject != null)
          {
            paramBundle.putString("url", paramObject);
            return true;
          }
          throw new RuntimeException(new IOException("onNativeInvoke() = <NULL newUrl>"));
        }
        throw new InvalidParameterException("onNativeInvoke(invalid segment index)");
      }
      throw new IllegalStateException("<null weakPlayer>.onNativeInvoke()");
    }
    throw new IllegalStateException("<null weakThiz>.onNativeInvoke()");
  }
  
  @CalledByNative
  private static String onSelectCodec(Object paramObject, String paramString, int paramInt1, int paramInt2)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof WeakReference)) {
        return null;
      }
      IjkMediaPlayer localIjkMediaPlayer = (IjkMediaPlayer)((WeakReference)paramObject).get();
      if (localIjkMediaPlayer == null) {
        return null;
      }
      IjkMediaPlayer.OnMediaCodecSelectListener localOnMediaCodecSelectListener = localIjkMediaPlayer.mOnMediaCodecSelectListener;
      paramObject = localOnMediaCodecSelectListener;
      if (localOnMediaCodecSelectListener == null) {
        paramObject = IjkMediaPlayer.DefaultMediaCodecSelector.sInstance;
      }
      return paramObject.onMediaCodecSelect(localIjkMediaPlayer, paramString, paramInt1, paramInt2);
    }
    return null;
  }
  
  @CalledByNative
  private static void postEventFromNative(Object paramObject1, int paramInt1, int paramInt2, int paramInt3, Object paramObject2)
  {
    if (paramObject1 == null) {
      return;
    }
    paramObject1 = (IjkMediaPlayer)((WeakReference)paramObject1).get();
    if (paramObject1 == null) {
      return;
    }
    if ((paramInt1 == 200) && (paramInt2 == 2)) {
      paramObject1.start();
    }
    IjkMediaPlayer.EventHandler localEventHandler = paramObject1.mEventHandler;
    if (localEventHandler != null)
    {
      paramObject2 = localEventHandler.obtainMessage(paramInt1, paramInt2, paramInt3, paramObject2);
      paramObject1.mEventHandler.sendMessage(paramObject2);
    }
  }
  
  private void setDataSource(FileDescriptor paramFileDescriptor, long paramLong1, long paramLong2)
  {
    setDataSource(paramFileDescriptor);
  }
  
  @SuppressLint({"Wakelock"})
  private void stayAwake(boolean paramBoolean)
  {
    PowerManager.WakeLock localWakeLock = this.mWakeLock;
    if (localWakeLock != null) {
      if ((paramBoolean) && (!localWakeLock.isHeld())) {
        this.mWakeLock.acquire();
      } else if ((!paramBoolean) && (this.mWakeLock.isHeld())) {
        this.mWakeLock.release();
      }
    }
    this.mStayAwake = paramBoolean;
    updateSurfaceScreenOn();
  }
  
  private void updateSurfaceScreenOn()
  {
    SurfaceHolder localSurfaceHolder = this.mSurfaceHolder;
    if (localSurfaceHolder != null)
    {
      boolean bool;
      if ((this.mScreenOnWhilePlaying) && (this.mStayAwake)) {
        bool = true;
      } else {
        bool = false;
      }
      localSurfaceHolder.setKeepScreenOn(bool);
    }
  }
  
  public native void _prepareAsync();
  
  public void deselectTrack(int paramInt)
  {
    _setStreamSelected(paramInt, false);
  }
  
  protected void finalize()
  {
    super.finalize();
    native_finalize();
  }
  
  public long getAsyncStatisticBufBackwards()
  {
    return _getPropertyLong(20201, 0L);
  }
  
  public long getAsyncStatisticBufCapacity()
  {
    return _getPropertyLong(20203, 0L);
  }
  
  public long getAsyncStatisticBufForwards()
  {
    return _getPropertyLong(20202, 0L);
  }
  
  public long getAudioCachedBytes()
  {
    return _getPropertyLong(20008, 0L);
  }
  
  public long getAudioCachedDuration()
  {
    return _getPropertyLong(20006, 0L);
  }
  
  public long getAudioCachedPackets()
  {
    return _getPropertyLong(20010, 0L);
  }
  
  public native int getAudioSessionId();
  
  public long getBitRate()
  {
    return _getPropertyLong(20100, 0L);
  }
  
  public long getCacheStatisticCountBytes()
  {
    return _getPropertyLong(20208, 0L);
  }
  
  public long getCacheStatisticFileForwards()
  {
    return _getPropertyLong(20206, 0L);
  }
  
  public long getCacheStatisticFilePos()
  {
    return _getPropertyLong(20207, 0L);
  }
  
  public long getCacheStatisticPhysicalPos()
  {
    return _getPropertyLong(20205, 0L);
  }
  
  public native long getCurrentPosition();
  
  public String getDataSource()
  {
    return this.mDataSource;
  }
  
  public float getDropFrameRate()
  {
    return _getPropertyFloat(10007, 0.0F);
  }
  
  public native long getDuration();
  
  public long getFileSize()
  {
    return _getPropertyLong(20209, 0L);
  }
  
  public MediaInfo getMediaInfo()
  {
    MediaInfo localMediaInfo = new MediaInfo();
    localMediaInfo.mMediaPlayerName = "ijkplayer";
    Object localObject = _getVideoCodecInfo();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(",");
      if (localObject.length >= 2)
      {
        localMediaInfo.mVideoDecoder = localObject[0];
        localMediaInfo.mVideoDecoderImpl = localObject[1];
      }
      else if (localObject.length >= 1)
      {
        localMediaInfo.mVideoDecoder = localObject[0];
        localMediaInfo.mVideoDecoderImpl = "";
      }
    }
    localObject = _getAudioCodecInfo();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(",");
      if (localObject.length >= 2)
      {
        localMediaInfo.mAudioDecoder = localObject[0];
        localMediaInfo.mAudioDecoderImpl = localObject[1];
      }
      else if (localObject.length >= 1)
      {
        localMediaInfo.mAudioDecoder = localObject[0];
        localMediaInfo.mAudioDecoderImpl = "";
      }
    }
    try
    {
      localMediaInfo.mMeta = IjkMediaMeta.parse(_getMediaMeta());
      return localMediaInfo;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return localMediaInfo;
  }
  
  public Bundle getMediaMeta()
  {
    return _getMediaMeta();
  }
  
  public int getScore()
  {
    int j = super.getScore();
    int i = j;
    if (j > 5)
    {
      if (j >= 26) {
        return j;
      }
      int n = Runtime.getRuntime().availableProcessors();
      Object localObject = new ArrayList(n);
      long l = System.currentTimeMillis();
      int m = 0;
      i = 0;
      int k;
      Thread localThread;
      for (;;)
      {
        k = m;
        if (i >= n) {
          break;
        }
        localThread = new Thread(new IjkMediaPlayer.1(this));
        ((List)localObject).add(localThread);
        localThread.start();
        i += 1;
      }
      while (k < n)
      {
        localThread = (Thread)((List)localObject).get(k);
        try
        {
          localThread.join();
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
        k += 1;
      }
      l = System.currentTimeMillis() - l;
      if (j == 11)
      {
        if (l < 250L)
        {
          i = 15;
        }
        else if ((l >= 250L) && (l < 400L))
        {
          i = 14;
        }
        else if ((l >= 400L) && (l < 600L))
        {
          i = 13;
        }
        else
        {
          i = j;
          if (l >= 600L)
          {
            i = j;
            if (l < 800L) {
              i = 12;
            }
          }
        }
      }
      else if (j == 16)
      {
        if (l < 250L)
        {
          i = 20;
        }
        else if ((l >= 250L) && (l < 350L))
        {
          i = 19;
        }
        else if ((l >= 350L) && (l < 500L))
        {
          i = 18;
        }
        else
        {
          i = j;
          if (l >= 500L)
          {
            i = j;
            if (l < 650L) {
              i = 17;
            }
          }
        }
      }
      else
      {
        i = j;
        if (j == 21) {
          if (l < 200L)
          {
            i = 25;
          }
          else if ((l >= 200L) && (l < 300L))
          {
            i = 24;
          }
          else if ((l >= 300L) && (l < 450L))
          {
            i = 23;
          }
          else
          {
            i = j;
            if (l >= 450L)
            {
              i = j;
              if (l < 600L) {
                i = 22;
              }
            }
          }
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getFPCalculation score total ");
      ((StringBuilder)localObject).append(Long.toString(l));
      DebugLog.w("IjkMediaPlayer", ((StringBuilder)localObject).toString());
    }
    return i;
  }
  
  public long getSeekLoadDuration()
  {
    return _getPropertyLong(20300, 0L);
  }
  
  public int getSelectedTrack(int paramInt)
  {
    long l;
    if (paramInt != 1) {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return -1;
        }
        l = _getPropertyLong(20011, -1L);
      }
    }
    for (;;)
    {
      return (int)l;
      l = _getPropertyLong(20002, -1L);
      continue;
      l = _getPropertyLong(20001, -1L);
    }
  }
  
  public float getSpeed(float paramFloat)
  {
    return _getPropertyFloat(10003, 0.0F);
  }
  
  public long getTcpSpeed()
  {
    return _getPropertyLong(20200, 0L);
  }
  
  public IjkTrackInfo[] getTrackInfo()
  {
    if (this.mIsReleased) {
      return null;
    }
    Object localObject1 = getMediaMeta();
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = IjkMediaMeta.parse((Bundle)localObject1);
    if (localObject2 != null)
    {
      if (((IjkMediaMeta)localObject2).mStreams == null) {
        return null;
      }
      localObject1 = new ArrayList();
      localObject2 = ((IjkMediaMeta)localObject2).mStreams.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        IjkMediaMeta.IjkStreamMeta localIjkStreamMeta = (IjkMediaMeta.IjkStreamMeta)((Iterator)localObject2).next();
        IjkTrackInfo localIjkTrackInfo = new IjkTrackInfo(localIjkStreamMeta);
        if (localIjkStreamMeta.mType.equalsIgnoreCase("video")) {
          localIjkTrackInfo.setTrackType(1);
        } else if (localIjkStreamMeta.mType.equalsIgnoreCase("audio")) {
          localIjkTrackInfo.setTrackType(2);
        } else if (localIjkStreamMeta.mType.equalsIgnoreCase("timedtext")) {
          localIjkTrackInfo.setTrackType(3);
        }
        ((ArrayList)localObject1).add(localIjkTrackInfo);
      }
      return (IjkTrackInfo[])((ArrayList)localObject1).toArray(new IjkTrackInfo[((ArrayList)localObject1).size()]);
    }
    return null;
  }
  
  public long getTrafficStatisticByteCount()
  {
    return _getPropertyLong(20204, 0L);
  }
  
  public long getVideoCachedBytes()
  {
    return _getPropertyLong(20007, 0L);
  }
  
  public long getVideoCachedDuration()
  {
    return _getPropertyLong(20005, 0L);
  }
  
  public long getVideoCachedPackets()
  {
    return _getPropertyLong(20009, 0L);
  }
  
  public float getVideoDecodeFramesPerSecond()
  {
    return _getPropertyFloat(10001, 0.0F);
  }
  
  public int getVideoDecoder()
  {
    return (int)_getPropertyLong(20003, 0L);
  }
  
  public int getVideoHeight()
  {
    return this.mVideoHeight;
  }
  
  public float getVideoOutputFramesPerSecond()
  {
    return _getPropertyFloat(10002, 0.0F);
  }
  
  public int getVideoSarDen()
  {
    return this.mVideoSarDen;
  }
  
  public int getVideoSarNum()
  {
    return this.mVideoSarNum;
  }
  
  public int getVideoWidth()
  {
    return this.mVideoWidth;
  }
  
  public void httphookReconnect()
  {
    _setPropertyLong(20211, 1L);
  }
  
  public boolean isLooping()
  {
    return _getLoopCount() != 1;
  }
  
  public boolean isPlayable()
  {
    return true;
  }
  
  public native boolean isPlaying();
  
  public void pause()
  {
    stayAwake(false);
    _pause();
  }
  
  public void prepareAsync()
  {
    _prepareAsync();
  }
  
  public void release()
  {
    this.mIsReleased = true;
    stayAwake(false);
    updateSurfaceScreenOn();
    resetListeners();
    _release();
  }
  
  public void reset()
  {
    stayAwake(false);
    _reset();
    this.mEventHandler.removeCallbacksAndMessages(null);
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
  }
  
  public void resetListeners()
  {
    super.resetListeners();
    this.mOnMediaCodecSelectListener = null;
  }
  
  public native void seekTo(long paramLong);
  
  public void selectTrack(int paramInt)
  {
    _setStreamSelected(paramInt, true);
  }
  
  public void setAndroidIOCallback(IAndroidIO paramIAndroidIO)
  {
    _setAndroidIOCallback(paramIAndroidIO);
  }
  
  public void setAudioStreamType(int paramInt) {}
  
  public void setCacheShare(int paramInt)
  {
    _setPropertyLong(20210, paramInt);
  }
  
  public void setDataSource(Context paramContext, Uri paramUri)
  {
    setDataSource(paramContext, paramUri, null);
  }
  
  /* Error */
  @TargetApi(14)
  public void setDataSource(Context paramContext, Uri paramUri, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 793	android/net/Uri:getScheme	()Ljava/lang/String;
    //   4: astore 4
    //   6: ldc_w 795
    //   9: aload 4
    //   11: invokevirtual 798	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: ifeq +12 -> 26
    //   17: aload_0
    //   18: aload_2
    //   19: invokevirtual 801	android/net/Uri:getPath	()Ljava/lang/String;
    //   22: invokevirtual 803	tv/danmaku/ijk/media/player/IjkMediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   25: return
    //   26: aload_2
    //   27: astore 5
    //   29: ldc_w 805
    //   32: aload 4
    //   34: invokevirtual 798	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   37: ifeq +48 -> 85
    //   40: aload_2
    //   41: astore 5
    //   43: ldc_w 807
    //   46: aload_2
    //   47: invokevirtual 810	android/net/Uri:getAuthority	()Ljava/lang/String;
    //   50: invokevirtual 798	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   53: ifeq +32 -> 85
    //   56: aload_1
    //   57: aload_2
    //   58: invokestatic 816	android/media/RingtoneManager:getDefaultType	(Landroid/net/Uri;)I
    //   61: invokestatic 820	android/media/RingtoneManager:getActualDefaultRingtoneUri	(Landroid/content/Context;I)Landroid/net/Uri;
    //   64: astore 5
    //   66: aload 5
    //   68: ifnull +6 -> 74
    //   71: goto +14 -> 85
    //   74: new 822	java/io/FileNotFoundException
    //   77: dup
    //   78: ldc_w 824
    //   81: invokespecial 825	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   84: athrow
    //   85: aconst_null
    //   86: astore_2
    //   87: aconst_null
    //   88: astore 4
    //   90: aconst_null
    //   91: astore 6
    //   93: aload_1
    //   94: invokevirtual 831	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   97: aload 5
    //   99: ldc_w 833
    //   102: invokevirtual 839	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   105: astore_1
    //   106: aload_1
    //   107: ifnonnull +12 -> 119
    //   110: aload_1
    //   111: ifnull +7 -> 118
    //   114: aload_1
    //   115: invokevirtual 844	android/content/res/AssetFileDescriptor:close	()V
    //   118: return
    //   119: aload_1
    //   120: astore 6
    //   122: aload_1
    //   123: astore_2
    //   124: aload_1
    //   125: astore 4
    //   127: aload_1
    //   128: invokevirtual 847	android/content/res/AssetFileDescriptor:getDeclaredLength	()J
    //   131: lconst_0
    //   132: lcmp
    //   133: ifge +22 -> 155
    //   136: aload_1
    //   137: astore 6
    //   139: aload_1
    //   140: astore_2
    //   141: aload_1
    //   142: astore 4
    //   144: aload_0
    //   145: aload_1
    //   146: invokevirtual 851	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   149: invokevirtual 475	tv/danmaku/ijk/media/player/IjkMediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   152: goto +27 -> 179
    //   155: aload_1
    //   156: astore 6
    //   158: aload_1
    //   159: astore_2
    //   160: aload_1
    //   161: astore 4
    //   163: aload_0
    //   164: aload_1
    //   165: invokevirtual 851	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   168: aload_1
    //   169: invokevirtual 854	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   172: aload_1
    //   173: invokevirtual 847	android/content/res/AssetFileDescriptor:getDeclaredLength	()J
    //   176: invokespecial 856	tv/danmaku/ijk/media/player/IjkMediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   179: aload_1
    //   180: ifnull +7 -> 187
    //   183: aload_1
    //   184: invokevirtual 844	android/content/res/AssetFileDescriptor:close	()V
    //   187: return
    //   188: astore_1
    //   189: aload 6
    //   191: ifnull +8 -> 199
    //   194: aload 6
    //   196: invokevirtual 844	android/content/res/AssetFileDescriptor:close	()V
    //   199: aload_1
    //   200: athrow
    //   201: aload 4
    //   203: ifnull +17 -> 220
    //   206: aload 4
    //   208: astore_2
    //   209: goto +7 -> 216
    //   212: aload_2
    //   213: ifnull +7 -> 220
    //   216: aload_2
    //   217: invokevirtual 844	android/content/res/AssetFileDescriptor:close	()V
    //   220: getstatic 221	tv/danmaku/ijk/media/player/IjkMediaPlayer:TAG	Ljava/lang/String;
    //   223: ldc_w 858
    //   226: invokestatic 863	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   229: pop
    //   230: aload_0
    //   231: aload 5
    //   233: invokevirtual 864	android/net/Uri:toString	()Ljava/lang/String;
    //   236: aload_3
    //   237: invokevirtual 867	tv/danmaku/ijk/media/player/IjkMediaPlayer:setDataSource	(Ljava/lang/String;Ljava/util/Map;)V
    //   240: return
    //   241: astore_1
    //   242: goto -30 -> 212
    //   245: astore_1
    //   246: goto -45 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	this	IjkMediaPlayer
    //   0	249	1	paramContext	Context
    //   0	249	2	paramUri	Uri
    //   0	249	3	paramMap	Map<String, String>
    //   4	203	4	localObject	Object
    //   27	205	5	localUri	Uri
    //   91	104	6	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   93	106	188	finally
    //   127	136	188	finally
    //   144	152	188	finally
    //   163	179	188	finally
    //   93	106	241	java/lang/SecurityException
    //   127	136	241	java/lang/SecurityException
    //   144	152	241	java/lang/SecurityException
    //   163	179	241	java/lang/SecurityException
    //   93	106	245	java/io/IOException
    //   127	136	245	java/io/IOException
    //   144	152	245	java/io/IOException
    //   163	179	245	java/io/IOException
  }
  
  @TargetApi(13)
  public void setDataSource(FileDescriptor paramFileDescriptor)
  {
    if (Build.VERSION.SDK_INT < 12) {
      try
      {
        Field localField = paramFileDescriptor.getClass().getDeclaredField("descriptor");
        localField.setAccessible(true);
        int i = localField.getInt(paramFileDescriptor);
        _setDataSourceFd(i);
        return;
      }
      catch (IllegalAccessException paramFileDescriptor)
      {
        throw new RuntimeException(paramFileDescriptor);
      }
      catch (NoSuchFieldException paramFileDescriptor)
      {
        throw new RuntimeException(paramFileDescriptor);
      }
    }
    paramFileDescriptor = ParcelFileDescriptor.dup(paramFileDescriptor);
    try
    {
      _setDataSourceFd(paramFileDescriptor.getFd());
      return;
    }
    finally
    {
      paramFileDescriptor.close();
    }
  }
  
  public void setDataSource(String paramString)
  {
    this.mDataSource = paramString;
    _setDataSource(paramString, null, null);
  }
  
  public void setDataSource(String paramString, Map<String, String> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append(":");
        if (!TextUtils.isEmpty((String)localEntry.getValue())) {
          localStringBuilder.append((String)localEntry.getValue());
        }
        localStringBuilder.append("\r\n");
        setOption(1, "headers", localStringBuilder.toString());
        setOption(1, "protocol_whitelist", "async,cache,crypto,file,http,https,ijkhttphook,ijkinject,ijklivehook,ijklongurl,ijksegment,ijktcphook,pipe,rtp,tcp,tls,udp,ijkurlhook,data");
      }
    }
    setDataSource(paramString);
  }
  
  public void setDataSource(IMediaDataSource paramIMediaDataSource)
  {
    _setDataSource(paramIMediaDataSource);
  }
  
  public void setDisplay(SurfaceHolder paramSurfaceHolder)
  {
    this.mSurfaceHolder = paramSurfaceHolder;
    if (paramSurfaceHolder != null) {
      paramSurfaceHolder = paramSurfaceHolder.getSurface();
    } else {
      paramSurfaceHolder = null;
    }
    _setVideoSurface(paramSurfaceHolder);
    updateSurfaceScreenOn();
  }
  
  public void setKeepInBackground(boolean paramBoolean) {}
  
  public void setLogEnabled(boolean paramBoolean) {}
  
  public void setLooping(boolean paramBoolean)
  {
    int i = paramBoolean ^ true;
    setOption(4, "loop", i);
    _setLoopCount(i);
  }
  
  public void setNextMediaPlayer(IMediaPlayer paramIMediaPlayer)
  {
    throw new UnsupportedOperationException("setNextMediaPlayer is not supported");
  }
  
  public void setOnControlMessageListener(IjkMediaPlayer.OnControlMessageListener paramOnControlMessageListener)
  {
    this.mOnControlMessageListener = paramOnControlMessageListener;
  }
  
  public void setOnMediaCodecSelectListener(IjkMediaPlayer.OnMediaCodecSelectListener paramOnMediaCodecSelectListener)
  {
    this.mOnMediaCodecSelectListener = paramOnMediaCodecSelectListener;
  }
  
  public void setOnNativeInvokeListener(IjkMediaPlayer.OnNativeInvokeListener paramOnNativeInvokeListener)
  {
    this.mOnNativeInvokeListener = paramOnNativeInvokeListener;
  }
  
  public void setOption(int paramInt, String paramString, long paramLong)
  {
    _setOption(paramInt, paramString, paramLong);
  }
  
  public void setOption(int paramInt, String paramString1, String paramString2)
  {
    _setOption(paramInt, paramString1, paramString2);
  }
  
  public void setPreReadingBuffer(long paramLong)
  {
    _setPropertyLong(20016, paramLong);
  }
  
  public void setScreenOnWhilePlaying(boolean paramBoolean)
  {
    if (this.mScreenOnWhilePlaying != paramBoolean)
    {
      if ((paramBoolean) && (this.mSurfaceHolder == null)) {
        DebugLog.w(TAG, "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
      }
      this.mScreenOnWhilePlaying = paramBoolean;
      updateSurfaceScreenOn();
    }
  }
  
  public void setSeekParameters(SeekParameters paramSeekParameters)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:539)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void setSpeed(float paramFloat)
  {
    _setPropertyFloat(10003, paramFloat);
  }
  
  public void setSurface(Surface paramSurface)
  {
    if ((this.mScreenOnWhilePlaying) && (paramSurface != null)) {
      DebugLog.w(TAG, "setScreenOnWhilePlaying(true) is ineffective for Surface");
    }
    this.mSurfaceHolder = null;
    _setVideoSurface(paramSurface);
    updateSurfaceScreenOn();
  }
  
  public native void setVolume(float paramFloat1, float paramFloat2);
  
  @SuppressLint({"Wakelock"})
  public void setWakeMode(Context paramContext, int paramInt)
  {
    PowerManager.WakeLock localWakeLock = this.mWakeLock;
    int i;
    if (localWakeLock != null)
    {
      if (localWakeLock.isHeld())
      {
        i = 1;
        this.mWakeLock.release();
      }
      else
      {
        i = 0;
      }
      this.mWakeLock = null;
    }
    else
    {
      i = 0;
    }
    this.mWakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(paramInt | 0x20000000, IjkMediaPlayer.class.getName());
    this.mWakeLock.setReferenceCounted(false);
    if (i != 0) {
      this.mWakeLock.acquire();
    }
  }
  
  public void start()
  {
    stayAwake(true);
    _start();
  }
  
  public void stop()
  {
    stayAwake(false);
    _stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.IjkMediaPlayer
 * JD-Core Version:    0.7.0.1
 */