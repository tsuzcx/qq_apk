package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import qlt;
import qlu;
import qlv;
import qlv.a;
import qlw;
import qlx;
import qly;
import qlz;
import qma;
import qmb;
import qmc;
import qmc.a;
import qmc.b;
import qmc.c;
import qmc.d;
import qmc.e;
import qmc.f;
import qmc.g;
import qmc.h;
import ram;

public class MediaPlayer
  implements qmc
{
  protected long Bc;
  protected long Bd;
  protected long Be;
  protected MediaFormat a;
  protected AudioPlayback a;
  public PlaybackThread a;
  public a a;
  protected b a;
  public qlt a;
  protected qma a;
  protected qmc.b a;
  protected qmc.c a;
  protected qmc.d a;
  protected qmc.e a;
  protected qmc.f a;
  protected qmc.g a;
  protected boolean aEi;
  protected boolean aEj;
  public boolean aEk;
  protected boolean aEl;
  protected int azv;
  protected int azw;
  protected MediaFormat b;
  protected qlx b;
  protected qmc.a b;
  protected qmc.h b;
  protected int bng = 3;
  protected int bnj;
  protected int bnk = 1;
  protected final Object bs = new Object();
  protected qlx c;
  private CountDownLatch d;
  protected long fB;
  protected int mAudioSessionId = 0;
  protected int mCurrentState = 1;
  protected int mRotation;
  protected boolean mScreenOnWhilePlaying;
  protected boolean mStayAwake;
  protected Surface mSurface;
  protected SurfaceHolder mSurfaceHolder;
  protected Uri mUri;
  protected PowerManager.WakeLock mWakeLock;
  protected float mk = 1.0F;
  protected float ml = 1.0F;
  
  public MediaPlayer()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$b = b.a(4);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread = null;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$a = new a(null);
    this.jdField_a_of_type_Qma = new qma();
  }
  
  public static boolean JZ()
  {
    return Build.VERSION.SDK_INT <= 19;
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
  
  @TargetApi(16)
  public void a(qlz paramqlz)
    throws IOException, IllegalStateException
  {
    int j = 0;
    if (this.mCurrentState != 1) {
      throw new IllegalStateException();
    }
    this.jdField_b_of_type_Qlx = paramqlz.a();
    this.c = paramqlz.b();
    this.azv = -1;
    this.azw = -1;
    int i = 0;
    String str;
    if (i < this.jdField_b_of_type_Qlx.getTrackCount())
    {
      paramqlz = this.jdField_b_of_type_Qlx.getTrackFormat(i);
      Log.d("Story-MediaPlayer", paramqlz.toString());
      str = paramqlz.getString("mime");
      if ((this.azv < 0) && (str.startsWith("video/")))
      {
        this.jdField_b_of_type_Qlx.selectTrack(i);
        this.azv = i;
        this.jdField_b_of_type_AndroidMediaMediaFormat = paramqlz;
        this.Bc = this.jdField_b_of_type_Qlx.getSampleTime();
      }
      for (;;)
      {
        i += 1;
        break;
        if ((this.c == null) && (this.azw < 0) && (str.startsWith("audio/")))
        {
          this.jdField_b_of_type_Qlx.selectTrack(i);
          this.azw = i;
          this.jdField_a_of_type_AndroidMediaMediaFormat = paramqlz;
          this.Bd = this.jdField_b_of_type_Qlx.getSampleTime();
          this.c = this.jdField_b_of_type_Qlx;
        }
      }
    }
    if ((this.c != null) && (this.azw == -1))
    {
      i = j;
      while (i < this.c.getTrackCount())
      {
        paramqlz = this.c.getTrackFormat(i);
        Log.d("Story-MediaPlayer", paramqlz.toString());
        str = paramqlz.getString("mime");
        if ((this.azw < 0) && (str.startsWith("audio/")))
        {
          this.c.selectTrack(i);
          this.azw = i;
          this.jdField_a_of_type_AndroidMediaMediaFormat = paramqlz;
          this.Bd = this.c.getSampleTime();
        }
        i += 1;
      }
    }
    if (this.azv == -1) {
      this.jdField_b_of_type_Qlx = null;
    }
    if ((this.azv == -1) && (this.azw == -1)) {
      throw new IOException("invalid data source, no supported stream found");
    }
    if ((this.azv != -1) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread == null) && (this.mSurface == null)) {
      Log.i("Story-MediaPlayer", "no video output surface specified");
    }
    this.mCurrentState = 2;
    if (!this.jdField_b_of_type_AndroidMediaMediaFormat.containsKey("rotation-degrees"))
    {
      paramqlz = new MediaMetadataRetriever();
      paramqlz.setDataSource(this.mUri.getPath());
      str = paramqlz.extractMetadata(24);
    }
    try
    {
      this.mRotation = Integer.parseInt(str);
      this.jdField_b_of_type_AndroidMediaMediaFormat.setInteger("rotation-degrees", this.mRotation);
      label448:
      paramqlz.release();
      return;
      this.mRotation = this.jdField_b_of_type_AndroidMediaMediaFormat.getInteger("rotation-degrees");
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label448;
    }
  }
  
  public void a(qmc.a parama)
  {
    this.jdField_b_of_type_Qmc$a = parama;
  }
  
  public void a(qmc.h paramh)
  {
    this.jdField_b_of_type_Qmc$h = paramh;
  }
  
  protected void bpd()
    throws IOException, IllegalStateException
  {
    if (this.jdField_a_of_type_AndroidMediaMediaFormat != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback = new AudioPlayback();
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.setAudioSessionId(this.mAudioSessionId);
      setVolume(this.mk, this.ml);
    }
    qly localqly = new qly(this);
    if (this.mCurrentState == 6) {
      return;
    }
    this.jdField_a_of_type_Qlt = new qlt();
    if (this.azv != -1) {}
    for (;;)
    {
      try
      {
        Object localObject = new qlw(this.jdField_b_of_type_Qlx, false, this.azv, localqly, this.mSurface, c.eH(this.bnk));
        this.jdField_a_of_type_Qlt.a((qlv)localObject);
        if (this.azw != -1) {}
        try
        {
          if (this.c == this.jdField_b_of_type_Qlx) {
            break label528;
          }
          if (this.c != null) {
            continue;
          }
        }
        catch (Exception localException2)
        {
          qlx localqlx;
          Log.e("Story-MediaPlayer", "cannot create audio decoder: " + localException2.getMessage());
          continue;
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback == null) {
            break label334;
          }
          this.mAudioSessionId = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.getAudioSessionId();
          this.bng = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.getAudioStreamType();
          if (this.jdField_a_of_type_Qlt.a() == null) {
            break label409;
          }
          i = this.jdField_a_of_type_Qlt.a().getVideoWidth();
          j = this.jdField_a_of_type_Qlt.a().getVideoHeight();
          k = this.mRotation;
          if ((k <= 0) || (k == 180)) {
            break label523;
          }
          this.aEl = true;
          k = j;
          j = i;
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$a.sendMessage(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$a.obtainMessage(5, k, j));
        }
        if (this.c != null)
        {
          localObject = this.c;
          localObject = new qlu((qlx)localObject, bool, this.azw, localqly, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback);
          this.jdField_a_of_type_Qlt.a((qlv)localObject);
          if (!this.jdField_a_of_type_Qlt.bQ().isEmpty()) {
            break label305;
          }
          throw new IOException("cannot decode any stream");
        }
      }
      catch (Exception localException1)
      {
        Log.e("Story-MediaPlayer", "cannot create video decoder: " + localException1.getMessage());
        continue;
        bool = false;
        continue;
        localqlx = this.jdField_b_of_type_Qlx;
        continue;
      }
      for (;;)
      {
        label305:
        label334:
        int i;
        int j;
        label409:
        if (this.mCurrentState == 6) {
          break label526;
        }
        if (this.jdField_a_of_type_Qlt.a() != null)
        {
          qlv.a locala = this.jdField_a_of_type_Qlt.a(true);
          this.jdField_a_of_type_Qlt.a().b(locala);
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback != null) {
            this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.pause(true);
          }
          this.jdField_a_of_type_Qlt.a(b.a(0), 0L);
          if (this.mCurrentState == 6) {
            break;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread = new PlaybackThread();
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread.start();
          this.mCurrentState = 4;
          return;
          this.jdField_a_of_type_Qlt.a(false);
        }
        label523:
        int k = i;
      }
      label526:
      break;
      label528:
      boolean bool = true;
    }
  }
  
  protected void bpe()
  {
    int j = 1;
    if (this.jdField_a_of_type_Qlt != null) {
      this.jdField_a_of_type_Qlt.release();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.boU();
    }
    int i;
    if (this.c != null)
    {
      i = 1;
      if (this.c == this.jdField_b_of_type_Qlx) {
        break label83;
      }
    }
    for (;;)
    {
      if ((i & j) != 0) {
        this.c.release();
      }
      if (this.jdField_b_of_type_Qlx != null) {
        this.jdField_b_of_type_Qlx.release();
      }
      return;
      i = 0;
      break;
      label83:
      j = 0;
    }
  }
  
  public int getAudioSessionId()
  {
    return this.mAudioSessionId;
  }
  
  public int getCurrentPosition()
  {
    if (this.mCurrentState >= 6)
    {
      this.mCurrentState = 8;
      throw new IllegalStateException();
    }
    if (this.aEi) {}
    for (long l = this.Be;; l = this.fB) {
      return (int)(l / 1000L);
    }
  }
  
  @TargetApi(16)
  public int getDuration()
  {
    if ((this.mCurrentState <= 3) && (this.mCurrentState >= 6))
    {
      this.mCurrentState = 8;
      throw new IllegalStateException();
    }
    if (this.jdField_b_of_type_AndroidMediaMediaFormat != null) {
      return (int)(this.jdField_b_of_type_AndroidMediaMediaFormat.getLong("durationUs") / 1000L);
    }
    if ((this.jdField_a_of_type_AndroidMediaMediaFormat != null) && (this.jdField_a_of_type_AndroidMediaMediaFormat.containsKey("durationUs"))) {
      return (int)(this.jdField_a_of_type_AndroidMediaMediaFormat.getLong("durationUs") / 1000L);
    }
    return 0;
  }
  
  @TargetApi(16)
  public int getVideoHeight()
  {
    if (this.mCurrentState >= 6)
    {
      ram.e("Story-MediaPlayer", "getVideoHeight() with wrong state: " + this.mCurrentState + "!", new IllegalStateException());
      this.mCurrentState = 8;
    }
    do
    {
      do
      {
        return 0;
        if ((!this.aEl) || (JZ())) {
          break;
        }
      } while (this.jdField_b_of_type_AndroidMediaMediaFormat == null);
      return (int)(this.jdField_b_of_type_AndroidMediaMediaFormat.getInteger("height") * this.jdField_b_of_type_AndroidMediaMediaFormat.getFloat("mpx-dar"));
    } while (this.jdField_b_of_type_AndroidMediaMediaFormat == null);
    return this.jdField_b_of_type_AndroidMediaMediaFormat.getInteger("height");
  }
  
  @TargetApi(16)
  public int getVideoWidth()
  {
    if (this.mCurrentState >= 6)
    {
      ram.e("Story-MediaPlayer", "getVideoWidth() with wrong state: " + this.mCurrentState + "!", new IllegalStateException());
      this.mCurrentState = 8;
    }
    do
    {
      do
      {
        return 0;
        if ((this.aEl) && (!JZ())) {
          break;
        }
      } while (this.jdField_b_of_type_AndroidMediaMediaFormat == null);
      return (int)(this.jdField_b_of_type_AndroidMediaMediaFormat.getInteger("height") * this.jdField_b_of_type_AndroidMediaMediaFormat.getFloat("mpx-dar"));
    } while (this.jdField_b_of_type_AndroidMediaMediaFormat == null);
    return this.jdField_b_of_type_AndroidMediaMediaFormat.getInteger("height");
  }
  
  public boolean isPlaying()
  {
    if (this.mCurrentState >= 6)
    {
      this.mCurrentState = 8;
      throw new IllegalStateException();
    }
    return (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread.isPaused());
  }
  
  public void pause()
  {
    if (this.mCurrentState != 4)
    {
      this.mCurrentState = 8;
      throw new IllegalStateException();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread.o(2, null);
    stayAwake(false);
  }
  
  public void prepareAsync()
    throws IllegalStateException
  {
    if ((this.mCurrentState != 2) && (this.mCurrentState != 5)) {
      throw new IllegalStateException();
    }
    this.d = new CountDownLatch(1);
    this.mCurrentState = 3;
    new Thread(new MediaPlayer.2(this)).start();
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: bipush 6
    //   3: putfield 101	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:mCurrentState	I
    //   6: aload_0
    //   7: getfield 116	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:d	Ljava/util/concurrent/CountDownLatch;
    //   10: ifnull +15 -> 25
    //   13: aload_0
    //   14: getfield 116	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:d	Ljava/util/concurrent/CountDownLatch;
    //   17: invokevirtual 458	java/util/concurrent/CountDownLatch:await	()V
    //   20: aload_0
    //   21: aconst_null
    //   22: putfield 116	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:d	Ljava/util/concurrent/CountDownLatch;
    //   25: aload_0
    //   26: getfield 87	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread;
    //   29: ifnull +44 -> 73
    //   32: aload_0
    //   33: getfield 87	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread;
    //   36: invokestatic 461	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:a	(Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread;)V
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield 87	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread;
    //   44: aload_0
    //   45: iconst_0
    //   46: invokevirtual 439	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:stayAwake	(Z)V
    //   49: aload_0
    //   50: bipush 7
    //   52: putfield 101	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:mCurrentState	I
    //   55: return
    //   56: astore_1
    //   57: aload_0
    //   58: aconst_null
    //   59: putfield 116	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:d	Ljava/util/concurrent/CountDownLatch;
    //   62: goto -37 -> 25
    //   65: astore_1
    //   66: aload_0
    //   67: aconst_null
    //   68: putfield 116	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:d	Ljava/util/concurrent/CountDownLatch;
    //   71: aload_1
    //   72: athrow
    //   73: aload_0
    //   74: invokevirtual 463	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:bpe	()V
    //   77: goto -33 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	MediaPlayer
    //   56	1	1	localInterruptedException	InterruptedException
    //   65	7	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	20	56	java/lang/InterruptedException
    //   13	20	65	finally
  }
  
  public void reset()
  {
    stop();
    this.mCurrentState = 1;
  }
  
  public void seekTo(int paramInt)
  {
    seekTo(paramInt * 1000L);
  }
  
  public void seekTo(long paramLong)
  {
    if ((this.mCurrentState < 4) && (this.mCurrentState >= 6))
    {
      this.mCurrentState = 8;
      throw new IllegalStateException();
    }
    Log.d("Story-MediaPlayer", "seekTo " + paramLong);
    if (this.jdField_a_of_type_Qmc$g != null) {
      this.jdField_a_of_type_Qmc$g.d(this);
    }
    this.aEi = true;
    this.Be = Math.max(this.Bc, paramLong);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread.o(4, Long.valueOf(this.Be));
  }
  
  public void setAudioSessionId(int paramInt)
  {
    if (this.mCurrentState != 1) {
      throw new IllegalStateException();
    }
    this.mAudioSessionId = paramInt;
  }
  
  public void setAudioStreamType(int paramInt)
  {
    this.bng = paramInt;
  }
  
  @Deprecated
  public void setDataSource(Context paramContext, Uri paramUri, Map<String, String> paramMap)
    throws IOException
  {
    this.mUri = paramUri;
    a(new qmb(paramContext, paramUri, paramMap));
  }
  
  public void setLooping(boolean paramBoolean)
  {
    this.aEj = paramBoolean;
  }
  
  public void setOnCompletionListener(qmc.b paramb)
  {
    this.jdField_a_of_type_Qmc$b = paramb;
  }
  
  public void setOnErrorListener(qmc.c paramc)
  {
    this.jdField_a_of_type_Qmc$c = paramc;
  }
  
  public void setOnInfoListener(qmc.d paramd)
  {
    this.jdField_a_of_type_Qmc$d = paramd;
  }
  
  public void setOnPreparedListener(qmc.e parame)
  {
    this.jdField_a_of_type_Qmc$e = parame;
  }
  
  public void setOnSeekCompleteListener(qmc.f paramf)
  {
    this.jdField_a_of_type_Qmc$f = paramf;
  }
  
  public void setScreenOnWhilePlaying(boolean paramBoolean)
  {
    if (this.mScreenOnWhilePlaying != paramBoolean)
    {
      if ((paramBoolean) && (this.mSurfaceHolder == null)) {
        Log.w("Story-MediaPlayer", "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
      }
      this.mScreenOnWhilePlaying = paramBoolean;
      updateSurfaceScreenOn();
    }
  }
  
  public void setSurface(Surface paramSurface)
  {
    this.mSurface = paramSurface;
    if ((this.mScreenOnWhilePlaying) && (paramSurface != null)) {
      Log.w("Story-MediaPlayer", "setScreenOnWhilePlaying(true) is ineffective for Surface");
    }
    this.mSurfaceHolder = null;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread == null)
    {
      wq(2);
      updateSurfaceScreenOn();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread.setSurface(this.mSurface);
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    this.mk = paramFloat1;
    this.ml = paramFloat2;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.E(paramFloat1, paramFloat2);
    }
  }
  
  public void start()
  {
    if (this.mCurrentState != 4)
    {
      this.mCurrentState = 8;
      throw new IllegalStateException();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread.o(1, null);
    stayAwake(true);
  }
  
  protected void stayAwake(boolean paramBoolean)
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
  
  public void stop()
  {
    release();
    this.mCurrentState = 5;
  }
  
  void wq(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread != null) {
      throw new IllegalStateException("called after prepare/prepareAsync");
    }
    if ((paramInt == 3) && (Build.VERSION.SDK_INT < 21)) {
      throw new IllegalArgumentException("this mode needs min API 21");
    }
    Log.d("Story-MediaPlayer", "setVideoRenderTimingMode " + paramInt);
    this.bnk = paramInt;
  }
  
  public class PlaybackThread
    extends HandlerThread
    implements Handler.Callback
  {
    private boolean aEh = MediaPlayer.c.eH(MediaPlayer.this.bnk);
    private boolean aEm = false;
    private boolean aEn = true;
    private boolean aEo = false;
    private qlv.a b;
    private double bl;
    private Handler mHandler;
    private boolean mPaused = true;
    
    public PlaybackThread()
    {
      super(-16);
    }
    
    private void bpf()
      throws IOException, InterruptedException
    {
      if (MediaPlayer.this.jdField_a_of_type_Qlt.JU())
      {
        MediaPlayer.this.fB = 0L;
        MediaPlayer.this.jdField_a_of_type_Qlt.a(MediaPlayer.b.a(0), 0L);
      }
      MediaPlayer.this.jdField_a_of_type_Qma.fl(MediaPlayer.this.jdField_a_of_type_Qlt.dR());
      if (MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback != null)
      {
        this.mHandler.removeMessages(6);
        MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.play();
      }
      this.bl = MediaPlayer.this.jdField_a_of_type_Qma.getSpeed();
      if (MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback != null) {
        MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.aa((float)this.bl);
      }
      this.mHandler.removeMessages(3);
      bpi();
    }
    
    private void bpg()
    {
      sM(false);
    }
    
    private void bph()
    {
      if (MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback != null) {
        MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.pause();
      }
    }
    
    private void bpi()
      throws IOException, InterruptedException
    {
      long l1 = MediaPlayer.this.jdField_a_of_type_Qlt.getCachedDuration();
      if (l1 != -1L) {
        MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$a.sendMessage(MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$a.obtainMessage(3, (int)(100.0D / (MediaPlayer.this.getDuration() * 1000) * (MediaPlayer.this.fB + l1)), 0));
      }
      if ((MediaPlayer.this.aEk) && (l1 > -1L) && (l1 < 2000000L) && (!MediaPlayer.this.jdField_a_of_type_Qlt.hasCacheReachedEndOfStream())) {
        this.mHandler.sendEmptyMessageDelayed(3, 100L);
      }
      for (;;)
      {
        return;
        if ((MediaPlayer.this.jdField_a_of_type_Qlt.a() != null) && (this.b == null))
        {
          this.b = MediaPlayer.this.jdField_a_of_type_Qlt.a(false);
          if ((this.b == null) && (!MediaPlayer.this.jdField_a_of_type_Qlt.JU()))
          {
            this.mHandler.sendEmptyMessageDelayed(3, 10L);
            return;
          }
        }
        l1 = SystemClock.elapsedRealtime();
        if (MediaPlayer.this.aEk)
        {
          MediaPlayer.this.aEk = false;
          MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$a.sendMessage(MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$a.obtainMessage(200, 702, 0));
          MediaPlayer.this.jdField_a_of_type_Qma.fl(MediaPlayer.this.jdField_a_of_type_Qlt.dR());
        }
        if ((this.b != null) && (MediaPlayer.this.jdField_a_of_type_Qma.I(this.b.presentationTimeUs) > 60000L))
        {
          this.mHandler.sendEmptyMessageDelayed(3, 50L);
          return;
        }
        MediaPlayer.this.fB = MediaPlayer.this.jdField_a_of_type_Qlt.dR();
        if ((MediaPlayer.this.jdField_a_of_type_Qlt.a() != null) && (this.b != null))
        {
          d(this.b);
          this.b = null;
          if (this.aEn)
          {
            this.aEn = false;
            MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$a.sendMessage(MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$a.obtainMessage(200, 3, 0));
          }
        }
        if (MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback != null)
        {
          if (this.bl != MediaPlayer.this.jdField_a_of_type_Qma.getSpeed())
          {
            this.bl = MediaPlayer.this.jdField_a_of_type_Qma.getSpeed();
            MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.aa((float)this.bl);
          }
          long l2 = MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.dQ();
          if (l2 > AudioPlayback.AX) {
            MediaPlayer.this.jdField_a_of_type_Qma.fl(l2);
          }
        }
        if (MediaPlayer.this.jdField_a_of_type_Qlt.JU())
        {
          MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$a.sendEmptyMessage(2);
          if (MediaPlayer.this.aEj)
          {
            if (MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback != null) {
              MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.flush();
            }
            MediaPlayer.this.jdField_a_of_type_Qlt.a(MediaPlayer.b.a(0), 0L);
            MediaPlayer.this.jdField_a_of_type_Qlt.boW();
          }
        }
        while (!this.mPaused)
        {
          l1 = (10L / MediaPlayer.this.jdField_a_of_type_Qma.getSpeed()) - (SystemClock.elapsedRealtime() - l1);
          if (l1 <= 0L) {
            break label637;
          }
          this.mHandler.sendEmptyMessageDelayed(3, l1);
          return;
          this.mPaused = true;
          sM(true);
          continue;
          this.b = MediaPlayer.this.jdField_a_of_type_Qlt.a(false);
        }
      }
      label637:
      this.mHandler.sendEmptyMessage(3);
    }
    
    private void d(qlv.a parama)
      throws InterruptedException
    {
      if (parama.endOfStream)
      {
        MediaPlayer.this.jdField_a_of_type_Qlt.a().a(parama);
        return;
      }
      long l = MediaPlayer.this.jdField_a_of_type_Qma.I(parama.presentationTimeUs);
      if (l < -1000L)
      {
        Log.d("Story-MediaPlayer", "LAGGING " + l);
        MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$a.sendMessage(MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$a.obtainMessage(200, 700, 0));
      }
      if (parama.aEg)
      {
        if (!MediaPlayer.this.aEl) {
          break label202;
        }
        MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$a.sendMessage(MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$a.obtainMessage(5, MediaPlayer.this.jdField_a_of_type_Qlt.a().getVideoHeight(), MediaPlayer.this.jdField_a_of_type_Qlt.a().getVideoWidth()));
      }
      for (;;)
      {
        if ((!this.aEh) && (l > 5000L)) {
          Thread.sleep(l / 1000L);
        }
        MediaPlayer.this.jdField_a_of_type_Qlt.a().a(parama, l);
        return;
        label202:
        MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$a.sendMessage(MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$a.obtainMessage(5, MediaPlayer.this.jdField_a_of_type_Qlt.a().getVideoWidth(), MediaPlayer.this.jdField_a_of_type_Qlt.a().getVideoHeight()));
      }
    }
    
    private void fk(long paramLong)
      throws IOException, InterruptedException
    {
      if (this.b != null)
      {
        MediaPlayer.this.jdField_a_of_type_Qlt.a().a(this.b);
        this.b = null;
      }
      if (MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback != null) {
        MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.pause(true);
      }
      MediaPlayer.this.jdField_a_of_type_Qlt.a(MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$b, paramLong);
      MediaPlayer.this.jdField_a_of_type_Qma.fl(MediaPlayer.this.jdField_a_of_type_Qlt.dR());
      boolean bool = this.mHandler.hasMessages(4);
      if (bool) {
        MediaPlayer.this.jdField_a_of_type_Qlt.boX();
      }
      for (;;)
      {
        if (!bool)
        {
          MediaPlayer.this.fB = MediaPlayer.this.jdField_a_of_type_Qlt.dR();
          MediaPlayer.this.aEi = false;
          this.aEo = false;
          MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$a.sendEmptyMessage(4);
          if (!this.mPaused) {
            bpf();
          }
        }
        return;
        MediaPlayer.this.jdField_a_of_type_Qlt.boW();
      }
    }
    
    private void release()
    {
      if (!isAlive()) {
        return;
      }
      this.mPaused = true;
      synchronized (MediaPlayer.this.bs)
      {
        this.aEm = true;
        boolean bool = this.mHandler.sendEmptyMessage(5);
        if (bool) {}
        try
        {
          MediaPlayer.this.bs.wait();
          Log.d("Story-MediaPlayer", "PlaybackThread released");
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            Log.e("Story-MediaPlayer", "wait lock interrupted", localInterruptedException);
          }
        }
      }
    }
    
    /* Error */
    private void releaseInternal()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual 328	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:interrupt	()V
      //   4: aload_0
      //   5: invokevirtual 331	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:quit	()Z
      //   8: pop
      //   9: aload_0
      //   10: iconst_1
      //   11: putfield 52	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:mPaused	Z
      //   14: aload_0
      //   15: getfield 27	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
      //   18: getfield 84	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:jdField_a_of_type_Qlt	Lqlt;
      //   21: ifnull +32 -> 53
      //   24: aload_0
      //   25: getfield 197	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:b	Lqlv$a;
      //   28: ifnull +25 -> 53
      //   31: aload_0
      //   32: getfield 27	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
      //   35: getfield 84	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:jdField_a_of_type_Qlt	Lqlt;
      //   38: invokevirtual 195	qlt:a	()Lqlw;
      //   41: aload_0
      //   42: getfield 197	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:b	Lqlv$a;
      //   45: invokevirtual 333	qlw:b	(Lqlv$a;)V
      //   48: aload_0
      //   49: aconst_null
      //   50: putfield 197	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:b	Lqlv$a;
      //   53: aload_0
      //   54: getfield 27	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
      //   57: invokevirtual 336	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:bpe	()V
      //   60: ldc 253
      //   62: ldc_w 338
      //   65: invokestatic 263	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   68: pop
      //   69: aload_0
      //   70: getfield 27	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
      //   73: getfield 311	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:bs	Ljava/lang/Object;
      //   76: astore_1
      //   77: aload_1
      //   78: monitorenter
      //   79: aload_0
      //   80: getfield 27	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
      //   83: getfield 311	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:bs	Ljava/lang/Object;
      //   86: invokevirtual 341	java/lang/Object:notify	()V
      //   89: aload_1
      //   90: monitorexit
      //   91: return
      //   92: astore_2
      //   93: aload_1
      //   94: monitorexit
      //   95: aload_2
      //   96: athrow
      //   97: astore_2
      //   98: ldc 253
      //   100: ldc_w 338
      //   103: invokestatic 263	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   106: pop
      //   107: aload_0
      //   108: getfield 27	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
      //   111: getfield 311	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:bs	Ljava/lang/Object;
      //   114: astore_1
      //   115: aload_1
      //   116: monitorenter
      //   117: aload_0
      //   118: getfield 27	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer$PlaybackThread:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer;
      //   121: getfield 311	com/tencent/biz/qqstory/playvideo/player/mediaplayer/MediaPlayer:bs	Ljava/lang/Object;
      //   124: invokevirtual 341	java/lang/Object:notify	()V
      //   127: aload_1
      //   128: monitorexit
      //   129: aload_2
      //   130: athrow
      //   131: astore_2
      //   132: aload_1
      //   133: monitorexit
      //   134: aload_2
      //   135: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	136	0	this	PlaybackThread
      //   76	57	1	localObject1	Object
      //   92	4	2	localObject2	Object
      //   97	33	2	localObject3	Object
      //   131	4	2	localObject4	Object
      // Exception table:
      //   from	to	target	type
      //   79	91	92	finally
      //   93	95	92	finally
      //   0	53	97	finally
      //   53	60	97	finally
      //   117	129	131	finally
      //   132	134	131	finally
    }
    
    private void sM(boolean paramBoolean)
    {
      this.mHandler.removeMessages(3);
      if (MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback != null)
      {
        if (paramBoolean) {
          this.mHandler.sendEmptyMessageDelayed(6, (MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.dM() + MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.dN()) / 1000L + 1L);
        }
      }
      else {
        return;
      }
      MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback.pause(false);
    }
    
    private void setVideoSurface(Surface paramSurface)
    {
      if ((MediaPlayer.this.jdField_a_of_type_Qlt != null) && (MediaPlayer.this.jdField_a_of_type_Qlt.a() != null))
      {
        if (this.b != null)
        {
          MediaPlayer.this.jdField_a_of_type_Qlt.a().a(this.b);
          this.b = null;
        }
        MediaPlayer.this.jdField_a_of_type_Qlt.a().c(paramSurface);
      }
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      if (this.aEm)
      {
        releaseInternal();
        return true;
      }
      try
      {
        switch (paramMessage.what)
        {
        case 1: 
          Log.d("Story-MediaPlayer", "unknown/invalid message");
          return false;
          bpf();
          return true;
        case 2: 
          bpg();
          return true;
        case 6: 
          bph();
          return true;
        case 3: 
          bpi();
          return true;
        case 4: 
          fk(((Long)paramMessage.obj).longValue());
          return true;
        case 5: 
          releaseInternal();
          return true;
        case 100: 
          setVideoSurface((Surface)paramMessage.obj);
          return true;
        }
      }
      catch (InterruptedException paramMessage)
      {
        Log.d("Story-MediaPlayer", "decoder interrupted", paramMessage);
        MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$a.sendMessage(MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$a.obtainMessage(100, 1, 0));
        releaseInternal();
        return true;
      }
      catch (IllegalStateException paramMessage)
      {
        for (;;)
        {
          Log.e("Story-MediaPlayer", "decoder error, too many instances?", paramMessage);
          MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$a.sendMessage(MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$a.obtainMessage(100, 1, 0));
        }
      }
      catch (IOException paramMessage)
      {
        for (;;)
        {
          Log.e("Story-MediaPlayer", "decoder error, codec can not be created", paramMessage);
          MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$a.sendMessage(MediaPlayer.this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$a.obtainMessage(100, 1, -1004));
        }
      }
    }
    
    public boolean isPaused()
    {
      return this.mPaused;
    }
    
    public void o(int paramInt, Object paramObject)
    {
      switch (paramInt)
      {
      case 3: 
      default: 
        throw new IllegalArgumentException("Message should be Play or Pause or Seek");
      case 1: 
        this.mPaused = false;
        this.mHandler.sendEmptyMessage(1);
        return;
      case 2: 
        this.mPaused = true;
        this.mHandler.sendEmptyMessage(2);
        return;
      }
      this.mHandler.removeMessages(4);
      this.mHandler.obtainMessage(4, paramObject).sendToTarget();
    }
    
    public void setSurface(Surface paramSurface)
    {
      this.mHandler.sendMessage(this.mHandler.obtainMessage(100, paramSurface));
    }
    
    public void start()
    {
      try
      {
        super.start();
        this.mHandler = new Handler(getLooper(), this);
        Log.d("Story-MediaPlayer", "PlaybackThread started");
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
  
  public class a
    extends Handler
  {
    private a() {}
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
      case 1: 
      case 4: 
      case 2: 
      case 5: 
        do
        {
          do
          {
            do
            {
              return;
              Log.d("Story-MediaPlayer", "onPrepared");
            } while (MediaPlayer.this.jdField_a_of_type_Qmc$e == null);
            MediaPlayer.this.jdField_a_of_type_Qmc$e.a(MediaPlayer.this);
            return;
            Log.d("Story-MediaPlayer", "onSeekComplete");
          } while (MediaPlayer.this.jdField_a_of_type_Qmc$f == null);
          MediaPlayer.this.jdField_a_of_type_Qmc$f.c(MediaPlayer.this);
          return;
          Log.d("Story-MediaPlayer", "onPlaybackComplete");
          if (MediaPlayer.this.jdField_a_of_type_Qmc$b != null) {
            MediaPlayer.this.jdField_a_of_type_Qmc$b.b(MediaPlayer.this);
          }
          MediaPlayer.this.stayAwake(false);
          return;
          Log.d("Story-MediaPlayer", "onVideoSizeChanged");
        } while (MediaPlayer.this.jdField_b_of_type_Qmc$h == null);
        MediaPlayer.this.jdField_b_of_type_Qmc$h.a(MediaPlayer.this, paramMessage.arg1, paramMessage.arg2);
        return;
      case 100: 
        Log.e("Story-MediaPlayer", "Error (" + paramMessage.arg1 + "," + paramMessage.arg2 + ")");
        if (MediaPlayer.this.jdField_a_of_type_Qmc$c == null) {
          break;
        }
      }
      for (boolean bool = MediaPlayer.this.jdField_a_of_type_Qmc$c.b(MediaPlayer.this, paramMessage.arg1, paramMessage.arg2);; bool = false)
      {
        if ((MediaPlayer.this.jdField_a_of_type_Qmc$b != null) && (!bool)) {
          MediaPlayer.this.jdField_a_of_type_Qmc$b.b(MediaPlayer.this);
        }
        MediaPlayer.this.stayAwake(false);
        return;
        Log.d("Story-MediaPlayer", "onInfo");
        if (MediaPlayer.this.jdField_a_of_type_Qmc$d == null) {
          break;
        }
        MediaPlayer.this.jdField_a_of_type_Qmc$d.a(MediaPlayer.this, paramMessage.arg1, paramMessage.arg2);
        return;
        if (MediaPlayer.this.jdField_b_of_type_Qmc$a != null) {
          MediaPlayer.this.jdField_b_of_type_Qmc$a.a(MediaPlayer.this, paramMessage.arg1);
        }
        MediaPlayer.this.bnj = paramMessage.arg1;
        return;
      }
    }
  }
  
  public static class b
  {
    private int bnl = 0;
    
    b(int paramInt)
    {
      this.bnl = paramInt;
    }
    
    public static b a(int paramInt)
    {
      return new b(paramInt);
    }
    
    public int sL()
    {
      switch (this.bnl)
      {
      default: 
        return this.bnl;
      }
      return 0;
    }
    
    public int sM()
    {
      return this.bnl;
    }
  }
  
  public static class c
  {
    public static boolean eH(int paramInt)
    {
      boolean bool2 = true;
      boolean bool1 = bool2;
      switch (paramInt)
      {
      default: 
        bool1 = false;
      case 3: 
      case 1: 
        do
        {
          return bool1;
          bool1 = bool2;
        } while (Build.VERSION.SDK_INT >= 21);
        return false;
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer
 * JD-Core Version:    0.7.0.1
 */