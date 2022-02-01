package com.tencent.qg.video.videodecoder;

import android.graphics.SurfaceTexture;
import asgs;
import asgt.a;
import asgt.b;
import asgu;
import asgv;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import dov.com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder.a;
import ram;

public class MediaDecoder
{
  private asgt.b jdField_a_of_type_Asgt$b;
  private final asgu jdField_a_of_type_Asgu;
  private DecodeRunnable jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable;
  private volatile long axf = -1L;
  private final asgs jdField_b_of_type_Asgs;
  private a jdField_b_of_type_ComTencentQgVideoVideodecoderMediaDecoder$a;
  private final boolean des;
  private boolean det = true;
  private volatile boolean deu;
  private volatile boolean dev;
  private volatile boolean dew;
  private Thread mDecodeThread;
  
  public MediaDecoder(String paramString, int paramInt1, a parama, boolean paramBoolean, int paramInt2)
  {
    ram.b("Q.qqstory.mediadecoderMediaDecoder", "Construct MediaDecoder , src = %s , supportMusic = %s", paramString, Boolean.valueOf(paramBoolean));
    this.jdField_a_of_type_Asgt$b = new asgt.b();
    this.jdField_a_of_type_Asgt$b.axe = paramInt2;
    this.des = paramBoolean;
    asgt.a locala = new asgt.a();
    locala.name = "video/";
    locala.path = paramString;
    this.jdField_a_of_type_Asgu = new asgu(this.jdField_a_of_type_Asgt$b, locala, paramInt1, new asgv(this, parama));
    AudioDecoder.a locala1;
    if (this.des)
    {
      locala = new asgt.a();
      locala.name = "audio/";
      locala.path = paramString;
      locala1 = new AudioDecoder.a();
      locala1.audioFilePath = paramString;
      locala1.a = AudioEncoder.a(paramString, null, 0);
    }
    for (this.jdField_b_of_type_Asgs = new asgs(this.jdField_a_of_type_Asgt$b, locala, locala1);; this.jdField_b_of_type_Asgs = null)
    {
      this.jdField_b_of_type_ComTencentQgVideoVideodecoderMediaDecoder$a = parama;
      this.jdField_a_of_type_Asgu.a(parama);
      return;
    }
  }
  
  private boolean aHQ()
  {
    return (this.des) && (this.det);
  }
  
  public boolean aHP()
  {
    return this.dew;
  }
  
  public void enq()
  {
    ram.d("Q.qqstory.mediadecoderMediaDecoder", "start decode");
    this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable = new DecodeRunnable(null);
    this.mDecodeThread = ThreadManager.newFreeThread(this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable, "MediaDecoder-Thread", 8);
    this.mDecodeThread.start();
  }
  
  public void enr()
  {
    ram.d("Q.qqstory.mediadecoderMediaDecoder", "stopDecode");
    this.dew = false;
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable != null)
    {
      this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable.interruptedFlag = true;
      this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable = null;
    }
  }
  
  public long ih()
  {
    return this.jdField_a_of_type_Asgu.ig() / 1000L;
  }
  
  public boolean isMuted()
  {
    return this.jdField_a_of_type_Asgt$b.mMuteAudio;
  }
  
  public boolean isPause()
  {
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable != null) {
      return this.dev;
    }
    return false;
  }
  
  public void pauseDecode()
  {
    ram.d("Q.qqstory.mediadecoderMediaDecoder", "pauseDecode");
    if (this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable != null)
    {
      this.dev = true;
      return;
    }
    ram.w("Q.qqstory.mediadecoderMediaDecoder", "pauseDecode failed, can not find DecodeRunnable");
  }
  
  public void resumeDecode()
  {
    ram.d("Q.qqstory.mediadecoderMediaDecoder", "resumeDecode");
    DecodeRunnable localDecodeRunnable = this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeRunnable;
    if (localDecodeRunnable != null)
    {
      this.dev = false;
      synchronized (DecodeRunnable.a(localDecodeRunnable))
      {
        DecodeRunnable.a(localDecodeRunnable).notifyAll();
        return;
      }
    }
    ram.w("Q.qqstory.mediadecoderMediaDecoder", "resumeDecode failed, can not find DecodeRunnable");
  }
  
  public void seekTo(long paramLong)
  {
    this.axf = paramLong;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.deu = paramBoolean;
  }
  
  public void setMuted(boolean paramBoolean)
  {
    this.jdField_a_of_type_Asgt$b.mMuteAudio = paramBoolean;
  }
  
  class DecodeRunnable
    implements Runnable
  {
    public volatile boolean interruptedFlag;
    private final Object pauseLock = new Object();
    
    private DecodeRunnable() {}
    
    private boolean aHR()
    {
      boolean bool = true;
      if (MediaDecoder.a(MediaDecoder.this).ig() / 1000L <= System.currentTimeMillis() - MediaDecoder.a(MediaDecoder.this).getStartTime())
      {
        MediaDecoder.a(MediaDecoder.this).decodeFrame();
        MediaDecoder.a(MediaDecoder.this).fp(MediaDecoder.a(MediaDecoder.this).ig());
      }
      for (int i = 1;; i = 0)
      {
        int j = i;
        if (MediaDecoder.a(MediaDecoder.this))
        {
          j = i;
          if (MediaDecoder.a(MediaDecoder.this).ig() <= MediaDecoder.a(MediaDecoder.this).ig() - 500000L)
          {
            MediaDecoder.a(MediaDecoder.this).decodeFrame();
            j = 1;
          }
        }
        if (j == 0) {}
        try
        {
          ram.d("Q.qqstory.mediadecoderMediaDecoder", "no render decode in this round !");
          Thread.sleep(10L);
          if (MediaDecoder.a(MediaDecoder.this).aHO())
          {
            if (MediaDecoder.d(MediaDecoder.this))
            {
              MediaDecoder.a(MediaDecoder.this).seekInLoop(0L);
              if (MediaDecoder.a(MediaDecoder.this)) {
                MediaDecoder.a(MediaDecoder.this).seekInLoop(0L);
              }
              MediaDecoder.a(MediaDecoder.this).onDecodeRepeat();
            }
          }
          else {
            bool = false;
          }
          return bool;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            ram.w("Q.qqstory.mediadecoderMediaDecoder", "decodeFrame sleep error :%s", localInterruptedException);
          }
        }
      }
    }
    
    private void eno()
    {
      ram.d("Q.qqstory.mediadecoderMediaDecoder", "onPauseFinish");
      MediaDecoder.a(MediaDecoder.this).eno();
      if (MediaDecoder.a(MediaDecoder.this)) {
        MediaDecoder.a(MediaDecoder.this).eno();
      }
    }
    
    private boolean init()
    {
      MediaDecoder localMediaDecoder = MediaDecoder.this;
      if ((MediaDecoder.c(MediaDecoder.this)) && (MediaDecoder.a(MediaDecoder.this).init())) {}
      for (boolean bool = true;; bool = false)
      {
        MediaDecoder.b(localMediaDecoder, bool);
        return MediaDecoder.a(MediaDecoder.this).init();
      }
    }
    
    private void release()
    {
      ram.d("Q.qqstory.mediadecoderMediaDecoder", "release");
      MediaDecoder.a(MediaDecoder.this).onRelease();
      if (MediaDecoder.a(MediaDecoder.this)) {
        MediaDecoder.a(MediaDecoder.this).onRelease();
      }
      if (MediaDecoder.a(MediaDecoder.this) != null) {
        MediaDecoder.a(MediaDecoder.this).interrupt();
      }
      MediaDecoder.a(MediaDecoder.this, null);
    }
    
    private boolean start()
    {
      if (MediaDecoder.a(MediaDecoder.this)) {
        MediaDecoder.a(MediaDecoder.this).start();
      }
      boolean bool = MediaDecoder.a(MediaDecoder.this).start();
      ram.b("Q.qqstory.mediadecoderMediaDecoder", "start finish : %s", Boolean.valueOf(bool));
      return bool;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   4: invokestatic 164	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lasgt$b;
      //   7: getfield 170	asgt$b:axe	J
      //   10: ldc 172
      //   12: invokestatic 178	asgr:aP	(JLjava/lang/String;)V
      //   15: aload_0
      //   16: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   19: iconst_0
      //   20: invokestatic 180	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;Z)Z
      //   23: pop
      //   24: aload_0
      //   25: invokespecial 181	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:init	()Z
      //   28: ifne +81 -> 109
      //   31: aload_0
      //   32: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   35: invokestatic 59	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lcom/tencent/qg/video/videodecoder/MediaDecoder$a;
      //   38: sipush 1000
      //   41: new 183	java/lang/Exception
      //   44: dup
      //   45: ldc 185
      //   47: invokespecial 188	java/lang/Exception:<init>	(Ljava/lang/String;)V
      //   50: invokeinterface 192 3 0
      //   55: aload_0
      //   56: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   59: iconst_0
      //   60: invokestatic 180	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;Z)Z
      //   63: pop
      //   64: aload_0
      //   65: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   68: invokestatic 37	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lasgu;
      //   71: invokevirtual 97	asgu:aHO	()Z
      //   74: ifeq +20 -> 94
      //   77: aload_0
      //   78: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   81: invokestatic 59	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lcom/tencent/qg/video/videodecoder/MediaDecoder$a;
      //   84: invokeinterface 195 1 0
      //   89: aload_0
      //   90: invokespecial 197	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:release	()V
      //   93: return
      //   94: aload_0
      //   95: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   98: invokestatic 59	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lcom/tencent/qg/video/videodecoder/MediaDecoder$a;
      //   101: invokeinterface 200 1 0
      //   106: goto -17 -> 89
      //   109: aload_0
      //   110: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   113: invokestatic 164	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lasgt$b;
      //   116: getfield 170	asgt$b:axe	J
      //   119: ldc 202
      //   121: invokestatic 178	asgr:aP	(JLjava/lang/String;)V
      //   124: aload_0
      //   125: invokespecial 203	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:start	()Z
      //   128: ifne +81 -> 209
      //   131: aload_0
      //   132: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   135: invokestatic 59	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lcom/tencent/qg/video/videodecoder/MediaDecoder$a;
      //   138: sipush 1001
      //   141: new 183	java/lang/Exception
      //   144: dup
      //   145: ldc 205
      //   147: invokespecial 188	java/lang/Exception:<init>	(Ljava/lang/String;)V
      //   150: invokeinterface 192 3 0
      //   155: aload_0
      //   156: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   159: iconst_0
      //   160: invokestatic 180	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;Z)Z
      //   163: pop
      //   164: aload_0
      //   165: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   168: invokestatic 37	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lasgu;
      //   171: invokevirtual 97	asgu:aHO	()Z
      //   174: ifeq +20 -> 194
      //   177: aload_0
      //   178: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   181: invokestatic 59	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lcom/tencent/qg/video/videodecoder/MediaDecoder$a;
      //   184: invokeinterface 195 1 0
      //   189: aload_0
      //   190: invokespecial 197	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:release	()V
      //   193: return
      //   194: aload_0
      //   195: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   198: invokestatic 59	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lcom/tencent/qg/video/videodecoder/MediaDecoder$a;
      //   201: invokeinterface 200 1 0
      //   206: goto -17 -> 189
      //   209: aload_0
      //   210: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   213: invokestatic 164	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lasgt$b;
      //   216: getfield 170	asgt$b:axe	J
      //   219: ldc 207
      //   221: invokestatic 178	asgr:aP	(JLjava/lang/String;)V
      //   224: aload_0
      //   225: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   228: iconst_1
      //   229: invokestatic 180	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;Z)Z
      //   232: pop
      //   233: aload_0
      //   234: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   237: invokestatic 59	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lcom/tencent/qg/video/videodecoder/MediaDecoder$a;
      //   240: invokeinterface 210 1 0
      //   245: invokestatic 213	java/lang/Thread:interrupted	()Z
      //   248: ifne +96 -> 344
      //   251: aload_0
      //   252: getfield 215	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:interruptedFlag	Z
      //   255: ifne +89 -> 344
      //   258: aload_0
      //   259: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   262: invokestatic 218	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)J
      //   265: lconst_0
      //   266: lcmp
      //   267: iflt +68 -> 335
      //   270: aload_0
      //   271: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   274: invokestatic 37	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lasgu;
      //   277: aload_0
      //   278: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   281: invokestatic 218	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)J
      //   284: ldc2_w 44
      //   287: lmul
      //   288: invokevirtual 103	asgu:seekInLoop	(J)J
      //   291: pop2
      //   292: aload_0
      //   293: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   296: invokestatic 68	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Z
      //   299: ifeq +25 -> 324
      //   302: aload_0
      //   303: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   306: invokestatic 71	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lasgs;
      //   309: aload_0
      //   310: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   313: invokestatic 218	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)J
      //   316: ldc2_w 44
      //   319: lmul
      //   320: invokevirtual 104	asgs:seekInLoop	(J)J
      //   323: pop2
      //   324: aload_0
      //   325: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   328: ldc2_w 219
      //   331: invokestatic 223	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;J)J
      //   334: pop2
      //   335: aload_0
      //   336: invokespecial 225	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:aHR	()Z
      //   339: istore_1
      //   340: iload_1
      //   341: ifeq +42 -> 383
      //   344: aload_0
      //   345: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   348: iconst_0
      //   349: invokestatic 180	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;Z)Z
      //   352: pop
      //   353: aload_0
      //   354: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   357: invokestatic 37	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lasgu;
      //   360: invokevirtual 97	asgu:aHO	()Z
      //   363: ifeq +143 -> 506
      //   366: aload_0
      //   367: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   370: invokestatic 59	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lcom/tencent/qg/video/videodecoder/MediaDecoder$a;
      //   373: invokeinterface 195 1 0
      //   378: aload_0
      //   379: invokespecial 197	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:release	()V
      //   382: return
      //   383: aload_0
      //   384: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   387: invokestatic 227	com/tencent/qg/video/videodecoder/MediaDecoder:b	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Z
      //   390: istore_1
      //   391: iload_1
      //   392: ifeq -147 -> 245
      //   395: aload_0
      //   396: getfield 24	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:pauseLock	Ljava/lang/Object;
      //   399: astore_2
      //   400: aload_2
      //   401: monitorenter
      //   402: aload_0
      //   403: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   406: iconst_0
      //   407: invokestatic 180	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;Z)Z
      //   410: pop
      //   411: aload_0
      //   412: getfield 215	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:interruptedFlag	Z
      //   415: ifne +10 -> 425
      //   418: aload_0
      //   419: getfield 24	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:pauseLock	Ljava/lang/Object;
      //   422: invokevirtual 230	java/lang/Object:wait	()V
      //   425: aload_2
      //   426: monitorexit
      //   427: aload_0
      //   428: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   431: iconst_1
      //   432: invokestatic 180	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;Z)Z
      //   435: pop
      //   436: aload_0
      //   437: invokespecial 231	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:eno	()V
      //   440: goto -195 -> 245
      //   443: astore_2
      //   444: ldc 79
      //   446: ldc 233
      //   448: aload_2
      //   449: invokestatic 113	ram:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   452: aload_0
      //   453: iconst_1
      //   454: putfield 215	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:interruptedFlag	Z
      //   457: goto -212 -> 245
      //   460: astore_2
      //   461: aload_0
      //   462: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   465: iconst_0
      //   466: invokestatic 180	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;Z)Z
      //   469: pop
      //   470: aload_0
      //   471: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   474: invokestatic 37	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lasgu;
      //   477: invokevirtual 97	asgu:aHO	()Z
      //   480: ifeq +41 -> 521
      //   483: aload_0
      //   484: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   487: invokestatic 59	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lcom/tencent/qg/video/videodecoder/MediaDecoder$a;
      //   490: invokeinterface 195 1 0
      //   495: aload_0
      //   496: invokespecial 197	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:release	()V
      //   499: aload_2
      //   500: athrow
      //   501: astore_3
      //   502: aload_2
      //   503: monitorexit
      //   504: aload_3
      //   505: athrow
      //   506: aload_0
      //   507: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   510: invokestatic 59	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lcom/tencent/qg/video/videodecoder/MediaDecoder$a;
      //   513: invokeinterface 200 1 0
      //   518: goto -140 -> 378
      //   521: aload_0
      //   522: getfield 19	com/tencent/qg/video/videodecoder/MediaDecoder$DecodeRunnable:this$0	Lcom/tencent/qg/video/videodecoder/MediaDecoder;
      //   525: invokestatic 59	com/tencent/qg/video/videodecoder/MediaDecoder:a	(Lcom/tencent/qg/video/videodecoder/MediaDecoder;)Lcom/tencent/qg/video/videodecoder/MediaDecoder$a;
      //   528: invokeinterface 200 1 0
      //   533: goto -38 -> 495
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	536	0	this	DecodeRunnable
      //   339	53	1	bool	boolean
      //   443	6	2	localInterruptedException	InterruptedException
      //   460	43	2	localObject2	Object
      //   501	4	3	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   395	402	443	java/lang/InterruptedException
      //   427	440	443	java/lang/InterruptedException
      //   504	506	443	java/lang/InterruptedException
      //   0	55	460	finally
      //   109	155	460	finally
      //   209	245	460	finally
      //   245	324	460	finally
      //   324	335	460	finally
      //   335	340	460	finally
      //   383	391	460	finally
      //   395	402	460	finally
      //   427	440	460	finally
      //   444	457	460	finally
      //   504	506	460	finally
      //   402	425	501	finally
      //   425	427	501	finally
      //   502	504	501	finally
    }
  }
  
  public static abstract interface a
  {
    public abstract void fp(long paramLong);
    
    public abstract void onDecodeCancel();
    
    public abstract void onDecodeError(int paramInt, Throwable paramThrowable);
    
    public abstract void onDecodeFinish();
    
    public abstract void onDecodeRepeat();
    
    public abstract void onDecodeSeekTo(long paramLong);
    
    public abstract void onDecodeStart();
    
    public abstract void onFrameAvailable(SurfaceTexture paramSurfaceTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qg.video.videodecoder.MediaDecoder
 * JD-Core Version:    0.7.0.1
 */