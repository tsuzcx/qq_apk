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
  private static final String TAG = IjkMediaPlayer.class.getName();
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
    if (paramNativeLibLoader != null) {
      this.mEventHandler = new IjkMediaPlayer.EventHandler(this, paramNativeLibLoader);
    }
    for (;;)
    {
      native_setup(new WeakReference(this));
      return;
      paramNativeLibLoader = Looper.getMainLooper();
      if (paramNativeLibLoader != null) {
        this.mEventHandler = new IjkMediaPlayer.EventHandler(this, paramNativeLibLoader);
      } else {
        this.mEventHandler = null;
      }
    }
  }
  
  public static boolean isNativeLibReady(NativeLibLoader paramNativeLibLoader)
  {
    boolean bool2 = false;
    NativeLibLoader localNativeLibLoader = paramNativeLibLoader;
    if (paramNativeLibLoader == null) {}
    try
    {
      localNativeLibLoader = sLocalLibLoader;
      if (sIsNativeLibReady != null)
      {
        bool1 = ((Boolean)sIsNativeLibReady).booleanValue();
        return bool1;
      }
      if (localNativeLibLoader == null) {
        break label171;
      }
      if ((localNativeLibLoader.isLibReadyToLoad("ijkffmpeg") == NativeLibLoader.State.WAIT) || (localNativeLibLoader.isLibReadyToLoad("ijksdl") == NativeLibLoader.State.WAIT) || (localNativeLibLoader.isLibReadyToLoad("ijkplayer") == NativeLibLoader.State.WAIT)) {
        return false;
      }
    }
    finally {}
    boolean bool1 = bool2;
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
    label171:
    return false;
  }
  
  /* Error */
  public static void loadLibrariesOnce(NativeLibLoader paramNativeLibLoader)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 165	tv/danmaku/ijk/media/player/IjkMediaPlayer:sIsLibLoadSuccess	Z
    //   6: ifne +78 -> 84
    //   9: aload_0
    //   10: astore_1
    //   11: aload_0
    //   12: ifnonnull +7 -> 19
    //   15: getstatic 163	tv/danmaku/ijk/media/player/IjkMediaPlayer:sLocalLibLoader	Lcom/tencent/oskplayer/support/loader/NativeLibLoader;
    //   18: astore_1
    //   19: aload_1
    //   20: ldc_w 300
    //   23: invokeinterface 329 2 0
    //   28: aload_1
    //   29: ldc_w 314
    //   32: invokeinterface 329 2 0
    //   37: aload_1
    //   38: ldc_w 316
    //   41: invokeinterface 329 2 0
    //   46: iconst_1
    //   47: putstatic 165	tv/danmaku/ijk/media/player/IjkMediaPlayer:sIsLibLoadSuccess	Z
    //   50: invokestatic 335	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   53: getstatic 156	tv/danmaku/ijk/media/player/IjkMediaPlayer:TAG	Ljava/lang/String;
    //   56: new 337	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 338	java/lang/StringBuilder:<init>	()V
    //   63: ldc_w 340
    //   66: invokevirtual 344	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: getstatic 165	tv/danmaku/ijk/media/player/IjkMediaPlayer:sIsLibLoadSuccess	Z
    //   72: invokevirtual 347	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   75: invokevirtual 350	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokeinterface 356 3 0
    //   83: pop
    //   84: ldc 2
    //   86: monitorexit
    //   87: return
    //   88: astore_0
    //   89: invokestatic 335	com/tencent/oskplayer/support/log/Logger:g	()Lcom/tencent/oskplayer/support/log/ILogger;
    //   92: getstatic 156	tv/danmaku/ijk/media/player/IjkMediaPlayer:TAG	Ljava/lang/String;
    //   95: new 337	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 338	java/lang/StringBuilder:<init>	()V
    //   102: ldc_w 358
    //   105: invokevirtual 344	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: getstatic 165	tv/danmaku/ijk/media/player/IjkMediaPlayer:sIsLibLoadSuccess	Z
    //   111: invokevirtual 347	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   114: invokevirtual 350	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokeinterface 361 3 0
    //   122: pop
    //   123: aload_0
    //   124: invokevirtual 364	java/lang/Throwable:printStackTrace	()V
    //   127: goto -77 -> 50
    //   130: astore_0
    //   131: ldc 2
    //   133: monitorexit
    //   134: aload_0
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramNativeLibLoader	NativeLibLoader
    //   10	28	1	localNativeLibLoader	NativeLibLoader
    // Exception table:
    //   from	to	target	type
    //   19	50	88	java/lang/Throwable
    //   3	9	130	finally
    //   15	19	130	finally
    //   19	50	130	finally
    //   50	84	130	finally
    //   84	87	130	finally
    //   89	127	130	finally
    //   131	134	130	finally
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
    if ((paramObject == null) || (!(paramObject instanceof WeakReference))) {
      throw new IllegalStateException("<null weakThiz>.onNativeInvoke()");
    }
    paramObject = (IjkMediaPlayer)((WeakReference)paramObject).get();
    if (paramObject == null) {
      throw new IllegalStateException("<null weakPlayer>.onNativeInvoke()");
    }
    IjkMediaPlayer.OnNativeInvokeListener localOnNativeInvokeListener = paramObject.mOnNativeInvokeListener;
    if ((localOnNativeInvokeListener != null) && (localOnNativeInvokeListener.onNativeInvoke(paramInt, paramBundle))) {
      return true;
    }
    switch (paramInt)
    {
    default: 
      return false;
    }
    paramObject = paramObject.mOnControlMessageListener;
    if (paramObject == null) {
      return false;
    }
    paramInt = paramBundle.getInt("segment_index", -1);
    if (paramInt < 0) {
      throw new InvalidParameterException("onNativeInvoke(invalid segment index)");
    }
    paramObject = paramObject.onControlResolveSegmentUrl(paramInt);
    if (paramObject == null) {
      throw new RuntimeException(new IOException("onNativeInvoke() = <NULL newUrl>"));
    }
    paramBundle.putString("url", paramObject);
    return true;
  }
  
  @CalledByNative
  private static String onSelectCodec(Object paramObject, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramObject == null) || (!(paramObject instanceof WeakReference))) {
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
  
  @CalledByNative
  private static void postEventFromNative(Object paramObject1, int paramInt1, int paramInt2, int paramInt3, Object paramObject2)
  {
    if (paramObject1 == null) {}
    do
    {
      do
      {
        return;
        paramObject1 = (IjkMediaPlayer)((WeakReference)paramObject1).get();
      } while (paramObject1 == null);
      if ((paramInt1 == 200) && (paramInt2 == 2)) {
        paramObject1.start();
      }
    } while (paramObject1.mEventHandler == null);
    paramObject2 = paramObject1.mEventHandler.obtainMessage(paramInt1, paramInt2, paramInt3, paramObject2);
    paramObject1.mEventHandler.sendMessage(paramObject2);
  }
  
  private void setDataSource(FileDescriptor paramFileDescriptor, long paramLong1, long paramLong2)
  {
    setDataSource(paramFileDescriptor);
  }
  
  @SuppressLint({"Wakelock"})
  private void stayAwake(boolean paramBoolean)
  {
    if (this.mWakeLock != null)
    {
      if ((!paramBoolean) || (this.mWakeLock.isHeld())) {
        break label38;
      }
      this.mWakeLock.acquire();
    }
    for (;;)
    {
      this.mStayAwake = paramBoolean;
      updateSurfaceScreenOn();
      return;
      label38:
      if ((!paramBoolean) && (this.mWakeLock.isHeld())) {
        this.mWakeLock.release();
      }
    }
  }
  
  private void updateSurfaceScreenOn()
  {
    SurfaceHolder localSurfaceHolder;
    if (this.mSurfaceHolder != null)
    {
      localSurfaceHolder = this.mSurfaceHolder;
      if ((!this.mScreenOnWhilePlaying) || (!this.mStayAwake)) {
        break label36;
      }
    }
    label36:
    for (boolean bool = true;; bool = false)
    {
      localSurfaceHolder.setKeepScreenOn(bool);
      return;
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
    }
    else
    {
      localObject = _getAudioCodecInfo();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(",");
        if (localObject.length < 2) {
          break label131;
        }
        localMediaInfo.mAudioDecoder = localObject[0];
        localMediaInfo.mAudioDecoderImpl = localObject[1];
      }
    }
    for (;;)
    {
      try
      {
        localMediaInfo.mMeta = IjkMediaMeta.parse(_getMediaMeta());
        return localMediaInfo;
      }
      catch (Throwable localThrowable)
      {
        label131:
        localThrowable.printStackTrace();
      }
      if (localObject.length < 1) {
        break;
      }
      localMediaInfo.mVideoDecoder = localObject[0];
      localMediaInfo.mVideoDecoderImpl = "";
      break;
      if (localObject.length >= 1)
      {
        localMediaInfo.mAudioDecoder = localObject[0];
        localMediaInfo.mAudioDecoderImpl = "";
      }
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
    if ((j <= 5) || (j >= 26)) {
      return j;
    }
    int k = Runtime.getRuntime().availableProcessors();
    ArrayList localArrayList = new ArrayList(k);
    long l = System.currentTimeMillis();
    int i = 0;
    Thread localThread;
    while (i < k)
    {
      localThread = new Thread(new IjkMediaPlayer.1(this));
      localArrayList.add(localThread);
      localThread.start();
      i += 1;
    }
    i = 0;
    for (;;)
    {
      if (i < k)
      {
        localThread = (Thread)localArrayList.get(i);
        try
        {
          localThread.join();
          i += 1;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    l = System.currentTimeMillis() - l;
    if (j == 11) {
      if (l < 250L) {
        i = 15;
      }
    }
    for (;;)
    {
      DebugLog.w("IjkMediaPlayer", "getFPCalculation score total " + Long.toString(l));
      return i;
      if ((l >= 250L) && (l < 400L))
      {
        i = 14;
      }
      else if ((l >= 400L) && (l < 600L))
      {
        i = 13;
      }
      else
      {
        if ((l >= 600L) && (l < 800L))
        {
          i = 12;
          continue;
          if (j == 16)
          {
            if (l < 250L)
            {
              i = 20;
              continue;
            }
            if ((l >= 250L) && (l < 350L))
            {
              i = 19;
              continue;
            }
            if ((l >= 350L) && (l < 500L))
            {
              i = 18;
              continue;
            }
            if ((l >= 500L) && (l < 650L)) {
              i = 17;
            }
          }
          else if (j == 21)
          {
            if (l < 200L)
            {
              i = 25;
              continue;
            }
            if ((l >= 200L) && (l < 300L))
            {
              i = 24;
              continue;
            }
            if ((l >= 300L) && (l < 450L))
            {
              i = 23;
              continue;
            }
            if ((l >= 450L) && (l < 600L))
            {
              i = 22;
              continue;
            }
          }
        }
        i = j;
      }
    }
  }
  
  public long getSeekLoadDuration()
  {
    return _getPropertyLong(20300, 0L);
  }
  
  public int getSelectedTrack(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return (int)_getPropertyLong(20001, -1L);
    case 2: 
      return (int)_getPropertyLong(20002, -1L);
    }
    return (int)_getPropertyLong(20011, -1L);
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
    if (this.mIsReleased) {}
    do
    {
      do
      {
        return null;
        localObject1 = getMediaMeta();
      } while (localObject1 == null);
      localObject2 = IjkMediaMeta.parse((Bundle)localObject1);
    } while ((localObject2 == null) || (((IjkMediaMeta)localObject2).mStreams == null));
    Object localObject1 = new ArrayList();
    Object localObject2 = ((IjkMediaMeta)localObject2).mStreams.iterator();
    if (((Iterator)localObject2).hasNext())
    {
      IjkMediaMeta.IjkStreamMeta localIjkStreamMeta = (IjkMediaMeta.IjkStreamMeta)((Iterator)localObject2).next();
      IjkTrackInfo localIjkTrackInfo = new IjkTrackInfo(localIjkStreamMeta);
      if (localIjkStreamMeta.mType.equalsIgnoreCase("video")) {
        localIjkTrackInfo.setTrackType(1);
      }
      for (;;)
      {
        ((ArrayList)localObject1).add(localIjkTrackInfo);
        break;
        if (localIjkStreamMeta.mType.equalsIgnoreCase("audio")) {
          localIjkTrackInfo.setTrackType(2);
        } else if (localIjkStreamMeta.mType.equalsIgnoreCase("timedtext")) {
          localIjkTrackInfo.setTrackType(3);
        }
      }
    }
    return (IjkTrackInfo[])((ArrayList)localObject1).toArray(new IjkTrackInfo[((ArrayList)localObject1).size()]);
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
    //   1: invokevirtual 795	android/net/Uri:getScheme	()Ljava/lang/String;
    //   4: astore 5
    //   6: ldc_w 797
    //   9: aload 5
    //   11: invokevirtual 800	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: ifeq +12 -> 26
    //   17: aload_0
    //   18: aload_2
    //   19: invokevirtual 803	android/net/Uri:getPath	()Ljava/lang/String;
    //   22: invokevirtual 805	tv/danmaku/ijk/media/player/IjkMediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   25: return
    //   26: aload_2
    //   27: astore 4
    //   29: ldc_w 807
    //   32: aload 5
    //   34: invokevirtual 800	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   37: ifeq +46 -> 83
    //   40: aload_2
    //   41: astore 4
    //   43: ldc_w 809
    //   46: aload_2
    //   47: invokevirtual 812	android/net/Uri:getAuthority	()Ljava/lang/String;
    //   50: invokevirtual 800	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   53: ifeq +30 -> 83
    //   56: aload_1
    //   57: aload_2
    //   58: invokestatic 818	android/media/RingtoneManager:getDefaultType	(Landroid/net/Uri;)I
    //   61: invokestatic 822	android/media/RingtoneManager:getActualDefaultRingtoneUri	(Landroid/content/Context;I)Landroid/net/Uri;
    //   64: astore_2
    //   65: aload_2
    //   66: astore 4
    //   68: aload_2
    //   69: ifnonnull +14 -> 83
    //   72: new 824	java/io/FileNotFoundException
    //   75: dup
    //   76: ldc_w 826
    //   79: invokespecial 827	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   82: athrow
    //   83: aconst_null
    //   84: astore_2
    //   85: aload_1
    //   86: invokevirtual 833	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   89: aload 4
    //   91: ldc_w 835
    //   94: invokevirtual 841	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   97: astore_1
    //   98: aload_1
    //   99: ifnonnull +12 -> 111
    //   102: aload_1
    //   103: ifnull -78 -> 25
    //   106: aload_1
    //   107: invokevirtual 846	android/content/res/AssetFileDescriptor:close	()V
    //   110: return
    //   111: aload_1
    //   112: invokevirtual 849	android/content/res/AssetFileDescriptor:getDeclaredLength	()J
    //   115: lconst_0
    //   116: lcmp
    //   117: ifge +20 -> 137
    //   120: aload_0
    //   121: aload_1
    //   122: invokevirtual 853	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   125: invokevirtual 477	tv/danmaku/ijk/media/player/IjkMediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   128: aload_1
    //   129: ifnull -104 -> 25
    //   132: aload_1
    //   133: invokevirtual 846	android/content/res/AssetFileDescriptor:close	()V
    //   136: return
    //   137: aload_0
    //   138: aload_1
    //   139: invokevirtual 853	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   142: aload_1
    //   143: invokevirtual 856	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   146: aload_1
    //   147: invokevirtual 849	android/content/res/AssetFileDescriptor:getDeclaredLength	()J
    //   150: invokespecial 858	tv/danmaku/ijk/media/player/IjkMediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   153: goto -25 -> 128
    //   156: astore_2
    //   157: aload_1
    //   158: ifnull +7 -> 165
    //   161: aload_1
    //   162: invokevirtual 846	android/content/res/AssetFileDescriptor:close	()V
    //   165: getstatic 156	tv/danmaku/ijk/media/player/IjkMediaPlayer:TAG	Ljava/lang/String;
    //   168: ldc_w 860
    //   171: invokestatic 865	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   174: pop
    //   175: aload_0
    //   176: aload 4
    //   178: invokevirtual 866	android/net/Uri:toString	()Ljava/lang/String;
    //   181: aload_3
    //   182: invokevirtual 869	tv/danmaku/ijk/media/player/IjkMediaPlayer:setDataSource	(Ljava/lang/String;Ljava/util/Map;)V
    //   185: return
    //   186: astore_1
    //   187: aconst_null
    //   188: astore_1
    //   189: aload_1
    //   190: ifnull -25 -> 165
    //   193: aload_1
    //   194: invokevirtual 846	android/content/res/AssetFileDescriptor:close	()V
    //   197: goto -32 -> 165
    //   200: astore_1
    //   201: aconst_null
    //   202: astore_3
    //   203: aload_1
    //   204: astore_2
    //   205: aload_3
    //   206: ifnull +7 -> 213
    //   209: aload_3
    //   210: invokevirtual 846	android/content/res/AssetFileDescriptor:close	()V
    //   213: aload_2
    //   214: athrow
    //   215: astore_2
    //   216: aload_1
    //   217: astore_3
    //   218: goto -13 -> 205
    //   221: astore_2
    //   222: goto -33 -> 189
    //   225: astore_1
    //   226: aload_2
    //   227: astore_1
    //   228: goto -71 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	this	IjkMediaPlayer
    //   0	231	1	paramContext	Context
    //   0	231	2	paramUri	Uri
    //   0	231	3	paramMap	Map<String, String>
    //   27	150	4	localUri	Uri
    //   4	29	5	str	String
    // Exception table:
    //   from	to	target	type
    //   111	128	156	java/lang/SecurityException
    //   137	153	156	java/lang/SecurityException
    //   85	98	186	java/io/IOException
    //   85	98	200	finally
    //   111	128	215	finally
    //   137	153	215	finally
    //   111	128	221	java/io/IOException
    //   137	153	221	java/io/IOException
    //   85	98	225	java/lang/SecurityException
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
      catch (NoSuchFieldException paramFileDescriptor)
      {
        throw new RuntimeException(paramFileDescriptor);
      }
      catch (IllegalAccessException paramFileDescriptor)
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
    if (paramSurfaceHolder != null) {}
    for (paramSurfaceHolder = paramSurfaceHolder.getSurface();; paramSurfaceHolder = null)
    {
      _setVideoSurface(paramSurfaceHolder);
      updateSurfaceScreenOn();
      return;
    }
  }
  
  public void setKeepInBackground(boolean paramBoolean) {}
  
  public void setLogEnabled(boolean paramBoolean) {}
  
  public void setLooping(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      setOption(4, "loop", i);
      _setLoopCount(i);
      return;
    }
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
    if (paramSeekParameters == null)
    {
      DebugLog.w("IjkMediaPlayer", "no SeekParameter set");
      return;
    }
    if ((paramSeekParameters.equals(SeekParameters.EXACT)) || (paramSeekParameters.equals(SeekParameters.DEFAULT)))
    {
      if (paramSeekParameters.equals(SeekParameters.EXACT)) {}
      for (int i = 1;; i = 0)
      {
        setOption(4, "enable-accurate-seek", i);
        return;
      }
    }
    DebugLog.w("IjkMediaPlayer", "unsupported seekParameter ignored!");
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
    int i;
    if (this.mWakeLock != null) {
      if (this.mWakeLock.isHeld())
      {
        i = 1;
        this.mWakeLock.release();
        this.mWakeLock = null;
      }
    }
    for (;;)
    {
      this.mWakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(0x20000000 | paramInt, IjkMediaPlayer.class.getName());
      this.mWakeLock.setReferenceCounted(false);
      if (i != 0) {
        this.mWakeLock.acquire();
      }
      return;
      i = 0;
      break;
      i = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.IjkMediaPlayer
 * JD-Core Version:    0.7.0.1
 */