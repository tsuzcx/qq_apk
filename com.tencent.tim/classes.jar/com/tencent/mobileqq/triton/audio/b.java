package com.tencent.mobileqq.triton.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.audio.IAudioPlayer;
import com.tencent.mobileqq.triton.sdk.audio.IAudioStateChangeListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;

public class b
  implements IAudioPlayer
{
  private int a;
  private boolean b;
  private double c;
  private int d;
  private volatile boolean e = true;
  private volatile boolean f;
  private float g = 1.0F;
  private boolean h;
  private String i;
  private boolean j;
  private volatile int k;
  private MediaPlayer l;
  MediaPlayer.OnBufferingUpdateListener m = new b.e(this);
  private IAudioStateChangeListener n;
  MediaPlayer.OnCompletionListener o = new b.f(this);
  MediaPlayer.OnSeekCompleteListener p = new b.g(this);
  private List<Runnable> q = Collections.synchronizedList(new ArrayList());
  private Timer r;
  MediaPlayer.OnErrorListener s = new b.h(this);
  MediaPlayer.OnPreparedListener t = new b.i(this);
  
  private void a(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      this.q.add(paramRunnable);
    }
  }
  
  private void c()
  {
    if (this.q.size() > 0)
    {
      Iterator localIterator = this.q.iterator();
      while (localIterator.hasNext())
      {
        Runnable localRunnable = (Runnable)localIterator.next();
        if (localRunnable != null) {
          localRunnable.run();
        }
      }
      this.q.clear();
    }
  }
  
  private MediaPlayer d()
  {
    MediaPlayer localMediaPlayer = d.b().a();
    if (localMediaPlayer != null)
    {
      localMediaPlayer.setOnErrorListener(this.s);
      localMediaPlayer.setOnCompletionListener(this.o);
      localMediaPlayer.setOnPreparedListener(this.t);
      localMediaPlayer.setOnBufferingUpdateListener(this.m);
      localMediaPlayer.setOnSeekCompleteListener(this.p);
      if (Build.VERSION.SDK_INT >= 28) {
        localMediaPlayer.setOnMediaTimeDiscontinuityListener(new b.j(this));
      }
    }
    return localMediaPlayer;
  }
  
  private void e()
  {
    if (this.r == null) {
      this.r = new Timer(true);
    }
    this.r.scheduleAtFixedRate(new b.d(this), 0L, 250L);
  }
  
  private void f()
  {
    Timer localTimer = this.r;
    if (localTimer != null)
    {
      localTimer.cancel();
      this.r = null;
    }
  }
  
  public boolean a()
  {
    return (this.l != null) && (this.f);
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   6: ifnull +28 -> 34
    //   9: aload_0
    //   10: invokevirtual 197	com/tencent/mobileqq/triton/audio/b:isPlaying	()Z
    //   13: ifeq +10 -> 23
    //   16: aload_0
    //   17: getfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   20: invokevirtual 200	android/media/MediaPlayer:stop	()V
    //   23: aload_0
    //   24: getfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   27: invokevirtual 203	android/media/MediaPlayer:reset	()V
    //   30: aload_0
    //   31: invokespecial 205	com/tencent/mobileqq/triton/audio/b:f	()V
    //   34: aload_0
    //   35: getfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +70 -> 110
    //   43: aload_1
    //   44: aconst_null
    //   45: invokevirtual 145	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   48: aload_0
    //   49: getfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   52: aconst_null
    //   53: invokevirtual 149	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   56: aload_0
    //   57: getfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   60: aconst_null
    //   61: invokevirtual 153	android/media/MediaPlayer:setOnPreparedListener	(Landroid/media/MediaPlayer$OnPreparedListener;)V
    //   64: aload_0
    //   65: getfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   68: aconst_null
    //   69: invokevirtual 157	android/media/MediaPlayer:setOnBufferingUpdateListener	(Landroid/media/MediaPlayer$OnBufferingUpdateListener;)V
    //   72: aload_0
    //   73: getfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   76: aconst_null
    //   77: invokevirtual 161	android/media/MediaPlayer:setOnSeekCompleteListener	(Landroid/media/MediaPlayer$OnSeekCompleteListener;)V
    //   80: getstatic 166	android/os/Build$VERSION:SDK_INT	I
    //   83: bipush 28
    //   85: if_icmplt +10 -> 95
    //   88: aload_0
    //   89: getfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   92: invokevirtual 208	android/media/MediaPlayer:clearOnMediaTimeDiscontinuityListener	()V
    //   95: invokestatic 137	com/tencent/mobileqq/triton/audio/d:b	()Lcom/tencent/mobileqq/triton/audio/d;
    //   98: aload_0
    //   99: getfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   102: invokevirtual 211	com/tencent/mobileqq/triton/audio/d:a	(Landroid/media/MediaPlayer;)V
    //   105: aload_0
    //   106: aconst_null
    //   107: putfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   110: aload_0
    //   111: iconst_0
    //   112: putfield 105	com/tencent/mobileqq/triton/audio/b:f	Z
    //   115: aload_0
    //   116: iconst_1
    //   117: putfield 49	com/tencent/mobileqq/triton/audio/b:e	Z
    //   120: aload_0
    //   121: iconst_0
    //   122: putfield 213	com/tencent/mobileqq/triton/audio/b:k	I
    //   125: aload_0
    //   126: monitorexit
    //   127: return
    //   128: astore_1
    //   129: ldc 215
    //   131: ldc 217
    //   133: iconst_2
    //   134: anewarray 4	java/lang/Object
    //   137: dup
    //   138: iconst_0
    //   139: aload_0
    //   140: invokevirtual 220	com/tencent/mobileqq/triton/audio/b:getAudioId	()I
    //   143: invokestatic 226	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   146: aastore
    //   147: dup
    //   148: iconst_1
    //   149: aload_0
    //   150: invokevirtual 230	com/tencent/mobileqq/triton/audio/b:getAudioPath	()Ljava/lang/String;
    //   153: aastore
    //   154: invokestatic 236	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   157: aload_1
    //   158: invokestatic 241	com/tencent/mobileqq/triton/engine/TTLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   161: pop
    //   162: aload_0
    //   163: getfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   166: astore_1
    //   167: aload_1
    //   168: ifnull -58 -> 110
    //   171: aload_1
    //   172: aconst_null
    //   173: invokevirtual 145	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   176: aload_0
    //   177: getfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   180: aconst_null
    //   181: invokevirtual 149	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   184: aload_0
    //   185: getfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   188: aconst_null
    //   189: invokevirtual 153	android/media/MediaPlayer:setOnPreparedListener	(Landroid/media/MediaPlayer$OnPreparedListener;)V
    //   192: aload_0
    //   193: getfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   196: aconst_null
    //   197: invokevirtual 157	android/media/MediaPlayer:setOnBufferingUpdateListener	(Landroid/media/MediaPlayer$OnBufferingUpdateListener;)V
    //   200: aload_0
    //   201: getfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   204: aconst_null
    //   205: invokevirtual 161	android/media/MediaPlayer:setOnSeekCompleteListener	(Landroid/media/MediaPlayer$OnSeekCompleteListener;)V
    //   208: getstatic 166	android/os/Build$VERSION:SDK_INT	I
    //   211: bipush 28
    //   213: if_icmplt +10 -> 223
    //   216: aload_0
    //   217: getfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   220: invokevirtual 208	android/media/MediaPlayer:clearOnMediaTimeDiscontinuityListener	()V
    //   223: invokestatic 137	com/tencent/mobileqq/triton/audio/d:b	()Lcom/tencent/mobileqq/triton/audio/d;
    //   226: aload_0
    //   227: getfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   230: invokevirtual 211	com/tencent/mobileqq/triton/audio/d:a	(Landroid/media/MediaPlayer;)V
    //   233: aload_0
    //   234: aconst_null
    //   235: putfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   238: goto -128 -> 110
    //   241: astore_1
    //   242: goto -132 -> 110
    //   245: astore_1
    //   246: aload_0
    //   247: getfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   250: astore_2
    //   251: aload_2
    //   252: ifnull +70 -> 322
    //   255: aload_2
    //   256: aconst_null
    //   257: invokevirtual 145	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   260: aload_0
    //   261: getfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   264: aconst_null
    //   265: invokevirtual 149	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   268: aload_0
    //   269: getfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   272: aconst_null
    //   273: invokevirtual 153	android/media/MediaPlayer:setOnPreparedListener	(Landroid/media/MediaPlayer$OnPreparedListener;)V
    //   276: aload_0
    //   277: getfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   280: aconst_null
    //   281: invokevirtual 157	android/media/MediaPlayer:setOnBufferingUpdateListener	(Landroid/media/MediaPlayer$OnBufferingUpdateListener;)V
    //   284: aload_0
    //   285: getfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   288: aconst_null
    //   289: invokevirtual 161	android/media/MediaPlayer:setOnSeekCompleteListener	(Landroid/media/MediaPlayer$OnSeekCompleteListener;)V
    //   292: getstatic 166	android/os/Build$VERSION:SDK_INT	I
    //   295: bipush 28
    //   297: if_icmplt +10 -> 307
    //   300: aload_0
    //   301: getfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   304: invokevirtual 208	android/media/MediaPlayer:clearOnMediaTimeDiscontinuityListener	()V
    //   307: invokestatic 137	com/tencent/mobileqq/triton/audio/d:b	()Lcom/tencent/mobileqq/triton/audio/d;
    //   310: aload_0
    //   311: getfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   314: invokevirtual 211	com/tencent/mobileqq/triton/audio/d:a	(Landroid/media/MediaPlayer;)V
    //   317: aload_0
    //   318: aconst_null
    //   319: putfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   322: aload_0
    //   323: iconst_0
    //   324: putfield 105	com/tencent/mobileqq/triton/audio/b:f	Z
    //   327: aload_0
    //   328: iconst_1
    //   329: putfield 49	com/tencent/mobileqq/triton/audio/b:e	Z
    //   332: aload_0
    //   333: iconst_0
    //   334: putfield 213	com/tencent/mobileqq/triton/audio/b:k	I
    //   337: aload_1
    //   338: athrow
    //   339: astore_1
    //   340: aload_0
    //   341: monitorexit
    //   342: aload_1
    //   343: athrow
    //   344: astore_2
    //   345: goto -23 -> 322
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	348	0	this	b
    //   38	6	1	localMediaPlayer1	MediaPlayer
    //   128	30	1	localThrowable	Throwable
    //   166	6	1	localMediaPlayer2	MediaPlayer
    //   241	1	1	localObject1	Object
    //   245	93	1	localObject2	Object
    //   339	4	1	localObject3	Object
    //   250	6	2	localMediaPlayer3	MediaPlayer
    //   344	1	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   2	23	128	finally
    //   23	34	128	finally
    //   43	95	241	finally
    //   95	110	241	finally
    //   171	223	241	finally
    //   223	238	241	finally
    //   129	162	245	finally
    //   34	39	339	finally
    //   110	125	339	finally
    //   162	167	339	finally
    //   246	251	339	finally
    //   322	339	339	finally
    //   255	307	344	finally
    //   307	322	344	finally
  }
  
  public int getAudioId()
  {
    return this.a;
  }
  
  public String getAudioPath()
  {
    return this.i;
  }
  
  public boolean getAutoPlay()
  {
    return this.j;
  }
  
  public double getBufferedTime()
  {
    return this.c;
  }
  
  public int getCurrentPosition()
  {
    int i2 = 0;
    int i1 = i2;
    if (a()) {
      i1 = i2;
    }
    try
    {
      if (this.l != null) {
        i1 = this.l.getCurrentPosition();
      }
      return i1;
    }
    finally
    {
      TTLog.b("[audio] InnerAudioPlayer", String.format("getCurrentPosition error. audioId=%d path=%s", new Object[] { Integer.valueOf(getAudioId()), getAudioPath() }), localThrowable);
    }
    return 0;
  }
  
  public int getDuration()
  {
    if (this.k > 0) {
      return this.k;
    }
    if (a()) {}
    try
    {
      if (this.l != null) {
        this.k = this.l.getDuration();
      }
      if (this.k < 0) {
        this.k = 0;
      }
      return this.k;
    }
    finally
    {
      for (;;)
      {
        TTLog.b("[audio] InnerAudioPlayer", String.format("getDuration error. audioId=%d path=%s", new Object[] { Integer.valueOf(getAudioId()), getAudioPath() }), localThrowable);
      }
    }
  }
  
  public boolean getLoop()
  {
    return this.h;
  }
  
  public float getStartTime()
  {
    return this.d;
  }
  
  public IAudioStateChangeListener getStateChangeListener()
  {
    return this.n;
  }
  
  public float getVolume()
  {
    return this.g;
  }
  
  public boolean isNeedResume()
  {
    return this.b;
  }
  
  public boolean isPaused()
  {
    return this.e;
  }
  
  public boolean isPlaying()
  {
    return (a()) && (this.l.isPlaying());
  }
  
  public void pause()
  {
    if (this.l == null) {}
    for (;;)
    {
      return;
      if (!a())
      {
        a(new b.l(this));
        return;
      }
      try
      {
        this.e = true;
        if (this.l != null) {
          this.l.pause();
        }
        f();
        if (getStateChangeListener() == null) {
          continue;
        }
        getStateChangeListener().onPause();
        return;
      }
      finally
      {
        for (;;)
        {
          TTLog.b("[audio] InnerAudioPlayer", String.format("pause error. audioId=%d path=%s", new Object[] { Integer.valueOf(getAudioId()), getAudioPath() }), localThrowable);
        }
      }
    }
  }
  
  public void play()
  {
    if (TextUtils.isEmpty(getAudioPath())) {
      TTLog.d("[audio] InnerAudioPlayer", String.format("play error on empty audio path, audioId=%d path=%s", new Object[] { Integer.valueOf(getAudioId()), getAudioPath() }));
    }
    do
    {
      do
      {
        for (;;)
        {
          return;
          MediaPlayer localMediaPlayer;
          if (this.l == null)
          {
            this.l = d();
            localMediaPlayer = this.l;
            if (localMediaPlayer == null) {}
          }
          try
          {
            localMediaPlayer.setDataSource(getAudioPath());
            this.l.prepareAsync();
            boolean bool = getAutoPlay();
            if (bool) {}
          }
          finally
          {
            for (;;)
            {
              TTLog.b("[audio] InnerAudioPlayer", String.format("play error on setDataSource and prepareAsync. audioId=%d path=%s", new Object[] { Integer.valueOf(getAudioId()), getAudioPath() }), localThrowable1);
            }
          }
        }
        if (this.l == null)
        {
          TTLog.d("[audio] InnerAudioPlayer", String.format("play error on null mMediaPlayer, audioId=%d path=%s", new Object[] { Integer.valueOf(getAudioId()), getAudioPath() }));
          return;
        }
      } while (isPlaying());
      if (!a())
      {
        a(new b.k(this));
        return;
      }
      try
      {
        if (this.l != null)
        {
          this.l.setLooping(getLoop());
          if (getVolume() >= 0.0F) {
            this.l.setVolume(getVolume(), getVolume());
          }
          if ((!isPaused()) && (getStartTime() > 0.0F)) {
            this.l.seekTo(this.d);
          }
          this.l.start();
          e();
        }
        this.e = false;
      }
      finally
      {
        for (;;)
        {
          TTLog.b("[audio] InnerAudioPlayer", String.format("play error. audioId=%d path=%s", new Object[] { Integer.valueOf(getAudioId()), getAudioPath() }), localThrowable2);
        }
      }
    } while (getStateChangeListener() == null);
    getStateChangeListener().onPlay();
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   6: ifnull +31 -> 37
    //   9: aload_0
    //   10: invokevirtual 197	com/tencent/mobileqq/triton/audio/b:isPlaying	()Z
    //   13: ifeq +10 -> 23
    //   16: aload_0
    //   17: getfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   20: invokevirtual 200	android/media/MediaPlayer:stop	()V
    //   23: aload_0
    //   24: getfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   27: invokevirtual 203	android/media/MediaPlayer:reset	()V
    //   30: aload_0
    //   31: getfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   34: invokevirtual 358	android/media/MediaPlayer:release	()V
    //   37: aload_0
    //   38: iconst_0
    //   39: putfield 243	com/tencent/mobileqq/triton/audio/b:a	I
    //   42: aload_0
    //   43: aconst_null
    //   44: putfield 245	com/tencent/mobileqq/triton/audio/b:i	Ljava/lang/String;
    //   47: aload_0
    //   48: iconst_0
    //   49: putfield 277	com/tencent/mobileqq/triton/audio/b:b	Z
    //   52: aload_0
    //   53: dconst_0
    //   54: putfield 93	com/tencent/mobileqq/triton/audio/b:c	D
    //   57: aload_0
    //   58: iconst_0
    //   59: putfield 269	com/tencent/mobileqq/triton/audio/b:d	I
    //   62: aload_0
    //   63: ldc_w 359
    //   66: putfield 51	com/tencent/mobileqq/triton/audio/b:g	F
    //   69: aload_0
    //   70: iconst_0
    //   71: putfield 265	com/tencent/mobileqq/triton/audio/b:h	Z
    //   74: aload_0
    //   75: iconst_0
    //   76: putfield 248	com/tencent/mobileqq/triton/audio/b:j	Z
    //   79: aload_0
    //   80: iconst_1
    //   81: putfield 49	com/tencent/mobileqq/triton/audio/b:e	Z
    //   84: aload_0
    //   85: aconst_null
    //   86: putfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   89: aload_0
    //   90: getfield 79	com/tencent/mobileqq/triton/audio/b:q	Ljava/util/List;
    //   93: invokeinterface 131 1 0
    //   98: aload_0
    //   99: monitorexit
    //   100: return
    //   101: astore_1
    //   102: ldc 215
    //   104: ldc_w 361
    //   107: iconst_2
    //   108: anewarray 4	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload_0
    //   114: invokevirtual 220	com/tencent/mobileqq/triton/audio/b:getAudioId	()I
    //   117: invokestatic 226	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   120: aastore
    //   121: dup
    //   122: iconst_1
    //   123: aload_0
    //   124: invokevirtual 230	com/tencent/mobileqq/triton/audio/b:getAudioPath	()Ljava/lang/String;
    //   127: aastore
    //   128: invokestatic 236	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   131: aload_1
    //   132: invokestatic 241	com/tencent/mobileqq/triton/engine/TTLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   135: pop
    //   136: aload_0
    //   137: iconst_0
    //   138: putfield 243	com/tencent/mobileqq/triton/audio/b:a	I
    //   141: aload_0
    //   142: aconst_null
    //   143: putfield 245	com/tencent/mobileqq/triton/audio/b:i	Ljava/lang/String;
    //   146: aload_0
    //   147: iconst_0
    //   148: putfield 277	com/tencent/mobileqq/triton/audio/b:b	Z
    //   151: aload_0
    //   152: dconst_0
    //   153: putfield 93	com/tencent/mobileqq/triton/audio/b:c	D
    //   156: aload_0
    //   157: iconst_0
    //   158: putfield 269	com/tencent/mobileqq/triton/audio/b:d	I
    //   161: aload_0
    //   162: ldc_w 359
    //   165: putfield 51	com/tencent/mobileqq/triton/audio/b:g	F
    //   168: aload_0
    //   169: iconst_0
    //   170: putfield 265	com/tencent/mobileqq/triton/audio/b:h	Z
    //   173: aload_0
    //   174: iconst_0
    //   175: putfield 248	com/tencent/mobileqq/triton/audio/b:j	Z
    //   178: aload_0
    //   179: iconst_1
    //   180: putfield 49	com/tencent/mobileqq/triton/audio/b:e	Z
    //   183: aload_0
    //   184: aconst_null
    //   185: putfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   188: aload_0
    //   189: getfield 79	com/tencent/mobileqq/triton/audio/b:q	Ljava/util/List;
    //   192: invokeinterface 131 1 0
    //   197: goto -99 -> 98
    //   200: astore_1
    //   201: aload_0
    //   202: monitorexit
    //   203: aload_1
    //   204: athrow
    //   205: astore_1
    //   206: aload_0
    //   207: iconst_0
    //   208: putfield 243	com/tencent/mobileqq/triton/audio/b:a	I
    //   211: aload_0
    //   212: aconst_null
    //   213: putfield 245	com/tencent/mobileqq/triton/audio/b:i	Ljava/lang/String;
    //   216: aload_0
    //   217: iconst_0
    //   218: putfield 277	com/tencent/mobileqq/triton/audio/b:b	Z
    //   221: aload_0
    //   222: dconst_0
    //   223: putfield 93	com/tencent/mobileqq/triton/audio/b:c	D
    //   226: aload_0
    //   227: iconst_0
    //   228: putfield 269	com/tencent/mobileqq/triton/audio/b:d	I
    //   231: aload_0
    //   232: ldc_w 359
    //   235: putfield 51	com/tencent/mobileqq/triton/audio/b:g	F
    //   238: aload_0
    //   239: iconst_0
    //   240: putfield 265	com/tencent/mobileqq/triton/audio/b:h	Z
    //   243: aload_0
    //   244: iconst_0
    //   245: putfield 248	com/tencent/mobileqq/triton/audio/b:j	Z
    //   248: aload_0
    //   249: iconst_1
    //   250: putfield 49	com/tencent/mobileqq/triton/audio/b:e	Z
    //   253: aload_0
    //   254: aconst_null
    //   255: putfield 194	com/tencent/mobileqq/triton/audio/b:l	Landroid/media/MediaPlayer;
    //   258: aload_0
    //   259: getfield 79	com/tencent/mobileqq/triton/audio/b:q	Ljava/util/List;
    //   262: invokeinterface 131 1 0
    //   267: aload_1
    //   268: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	b
    //   101	31	1	localThrowable	Throwable
    //   200	4	1	localObject1	Object
    //   205	63	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	23	101	finally
    //   23	37	101	finally
    //   37	98	200	finally
    //   136	197	200	finally
    //   206	269	200	finally
    //   102	136	205	finally
  }
  
  public void resume()
  {
    if (this.l == null)
    {
      TTLog.d("[audio] InnerAudioPlayer", String.format("resume error on null mMediaPlayer. audioId=%d path=%s", new Object[] { Integer.valueOf(getAudioId()), getAudioPath() }));
      return;
    }
    if (!a())
    {
      a(new b.m(this));
      return;
    }
    try
    {
      if (this.l != null)
      {
        this.l.start();
        e();
      }
      this.e = false;
      return;
    }
    finally
    {
      TTLog.b("[audio] InnerAudioPlayer", String.format("resume error. audioId=%d path=%s", new Object[] { Integer.valueOf(getAudioId()), getAudioPath() }), localThrowable);
    }
  }
  
  public void seekTo(float paramFloat)
  {
    if (Float.isNaN(paramFloat)) {}
    for (;;)
    {
      return;
      if (!a())
      {
        a(new b.a(this, paramFloat));
        return;
      }
      try
      {
        if (this.l != null) {
          this.l.seekTo((int)paramFloat);
        }
        if (getStateChangeListener() == null) {
          continue;
        }
        getStateChangeListener().onSeeking();
        return;
      }
      finally
      {
        for (;;)
        {
          TTLog.b("[audio] InnerAudioPlayer", String.format("seekTo error. audioId=%d path=%", new Object[] { Integer.valueOf(getAudioId()), getAudioPath() }), localThrowable);
        }
      }
    }
  }
  
  public void setAudioId(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setAudioPath(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(getAudioPath())))
    {
      TTLog.d("[audio] InnerAudioPlayer", String.format("setAudioPath audioId=%d, from %s to %s", new Object[] { Integer.valueOf(getAudioId()), getAudioPath(), paramString }));
      this.i = paramString;
      b();
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if (getStateChangeListener() != null) {
        getStateChangeListener().onCanPlay();
      }
    } while (!getAutoPlay());
    play();
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    this.j = paramBoolean;
    if ((paramBoolean) && (!TextUtils.isEmpty(getAudioPath()))) {
      play();
    }
  }
  
  public void setLoop(boolean paramBoolean)
  {
    if (!a()) {
      a(new b.c(this, paramBoolean));
    }
    for (;;)
    {
      return;
      this.h = paramBoolean;
      try
      {
        if (this.l != null)
        {
          this.l.setLooping(paramBoolean);
          return;
        }
      }
      finally
      {
        TTLog.b("[audio] InnerAudioPlayer", String.format("setLoop error. audioId=%d path=%s", new Object[] { Integer.valueOf(getAudioId()), getAudioPath() }), localThrowable);
      }
    }
  }
  
  public void setNeedResume(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setStartTime(float paramFloat)
  {
    this.d = ((int)paramFloat);
  }
  
  public void setStateChangeListener(IAudioStateChangeListener paramIAudioStateChangeListener)
  {
    this.n = paramIAudioStateChangeListener;
  }
  
  public void setVolume(float paramFloat)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    if (paramFloat < 0.0F) {
      paramFloat = f2;
    }
    for (;;)
    {
      if (paramFloat > 1.0F) {
        paramFloat = f1;
      }
      for (;;)
      {
        if (!a()) {
          a(new b.b(this, paramFloat));
        }
        for (;;)
        {
          return;
          this.g = paramFloat;
          try
          {
            if (this.l != null)
            {
              this.l.setVolume(paramFloat, paramFloat);
              return;
            }
          }
          finally
          {
            TTLog.b("[audio] InnerAudioPlayer", String.format("setVolume error. audioId=%d path=%s", new Object[] { Integer.valueOf(getAudioId()), getAudioPath() }), localThrowable);
            return;
          }
        }
      }
    }
  }
  
  public void stop()
  {
    if (this.l == null) {}
    do
    {
      return;
      try
      {
        if (a())
        {
          if (isPlaying()) {
            this.l.pause();
          }
          if (getStartTime() > 0.0F) {
            setStartTime(0.0F);
          }
          this.l.seekTo(this.d);
          f();
        }
      }
      finally
      {
        for (;;)
        {
          TTLog.b("[audio] InnerAudioPlayer", String.format("stop error. audioId=%d path=%s", new Object[] { Integer.valueOf(getAudioId()), getAudioPath() }), localThrowable);
        }
      }
    } while (getStateChangeListener() == null);
    getStateChangeListener().onStop();
  }
  
  class n
    implements Runnable
  {
    public int a;
    public String b;
    
    public n(int paramInt, String paramString)
    {
      this.a = paramInt;
      this.b = paramString;
    }
    
    public void run()
    {
      if ((b.this.getAudioId() == this.a) && (b.this.getAudioPath() != null) && (b.this.getAudioPath().equals(this.b))) {
        b.this.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.b
 * JD-Core Version:    0.7.0.1
 */