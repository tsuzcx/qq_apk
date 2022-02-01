package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AudioPlayback
{
  public static long AX = -9223372036854775808L;
  private long AY;
  private long AZ;
  private long Ba;
  private MediaFormat jdField_a_of_type_AndroidMediaMediaFormat;
  private AudioThread jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback$AudioThread;
  protected a a;
  private int azc;
  private byte[] bE;
  private int bne = 8192;
  private int bnf;
  private int bng = 3;
  private int mAudioSessionId = 0;
  private AudioTrack mAudioTrack;
  private int mSampleRate;
  private float mk = 1.0F;
  private float ml = 1.0F;
  
  public AudioPlayback()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback$a = new a();
  }
  
  @TargetApi(16)
  private boolean a(MediaFormat paramMediaFormat)
  {
    return (this.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("channel-count") != paramMediaFormat.getInteger("channel-count")) || (this.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("sample-rate") != paramMediaFormat.getInteger("sample-rate")) || (!this.jdField_a_of_type_AndroidMediaMediaFormat.getString("mime").equals(paramMediaFormat.getString("mime")));
  }
  
  private long dO()
  {
    return ((0xFFFFFFFF & this.mAudioTrack.getPlaybackHeadPosition()) / this.mSampleRate * 1000000.0D);
  }
  
  private void sL(boolean paramBoolean)
  {
    if (isInitialized())
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback$AudioThread.interrupt();
      }
      this.mAudioTrack.stop();
      this.mAudioTrack.release();
    }
    this.mAudioTrack = null;
  }
  
  public void E(float paramFloat1, float paramFloat2)
  {
    this.mk = paramFloat1;
    this.ml = paramFloat2;
    if (this.mAudioTrack != null) {
      this.mAudioTrack.setStereoVolume(paramFloat1, paramFloat2);
    }
  }
  
  @TargetApi(16)
  public void a(MediaFormat paramMediaFormat)
  {
    Log.d("AudioPlayback", "init");
    boolean bool;
    label44:
    int j;
    int i;
    if (isInitialized())
    {
      if (!a(paramMediaFormat))
      {
        this.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
        return;
      }
      bool = isPlaying();
      pause();
      sL(false);
      this.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
      j = paramMediaFormat.getInteger("channel-count");
      this.azc = (2 * j);
      this.mSampleRate = paramMediaFormat.getInteger("sample-rate");
      switch (j)
      {
      case 3: 
      case 5: 
      case 7: 
      default: 
        i = 1;
      }
    }
    for (;;)
    {
      this.bnf = (j * this.bne);
      this.mAudioTrack = new AudioTrack(this.bng, this.mSampleRate, i, 2, this.bnf, 1, this.mAudioSessionId);
      this.mAudioSessionId = this.mAudioTrack.getAudioSessionId();
      this.bng = this.mAudioTrack.getStreamType();
      E(this.mk, this.ml);
      this.AZ = AX;
      if (!bool) {
        break;
      }
      play();
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback$AudioThread = new AudioThread();
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback$AudioThread.setPaused(true);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback$AudioThread.start();
      bool = false;
      break label44;
      i = 4;
      continue;
      i = 12;
      continue;
      i = 204;
      continue;
      i = 252;
      continue;
      i = 1020;
    }
  }
  
  public void a(ByteBuffer paramByteBuffer, long paramLong)
  {
    int i = paramByteBuffer.remaining();
    if (this.bne < i)
    {
      Log.d("AudioPlayback", "incoming frame chunk size increased to " + i);
      this.bne = i;
      a(this.jdField_a_of_type_AndroidMediaMediaFormat);
    }
    if (this.AZ == AX)
    {
      this.AZ = paramLong;
      this.Ba = 0L;
      long l = dO();
      if (l > 0L)
      {
        this.AZ -= l;
        Log.d("AudioPlayback", "playback head not reset");
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback$a.c(paramByteBuffer, paramLong);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback$AudioThread.boV();
  }
  
  public void aa(float paramFloat)
  {
    if (isInitialized())
    {
      this.mAudioTrack.setPlaybackRate((int)(this.mSampleRate * paramFloat));
      return;
    }
    throw new IllegalStateException();
  }
  
  protected void b(ByteBuffer paramByteBuffer, long paramLong)
  {
    int i = paramByteBuffer.remaining();
    if ((this.bE == null) || (this.bE.length < i)) {
      this.bE = new byte[i];
    }
    paramByteBuffer.get(this.bE, 0, i);
    this.AY = paramLong;
    this.mAudioTrack.write(this.bE, 0, i);
  }
  
  public void boU()
  {
    sL(true);
  }
  
  public long dM()
  {
    return (a.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback$a) / this.azc / this.mSampleRate * 1000000.0D);
  }
  
  public long dN()
  {
    return (this.bnf / this.azc / this.mSampleRate * 1000000.0D);
  }
  
  public long dQ()
  {
    if (this.AZ == AX) {
      return AX;
    }
    long l = dO();
    if (l < this.Ba)
    {
      Log.d("AudioPlayback", "playback head has wrapped");
      this.AZ += (-1.0D / this.mSampleRate * 1000000.0D);
    }
    this.Ba = l;
    return l + this.AZ;
  }
  
  public void flush()
  {
    if (isInitialized())
    {
      boolean bool = isPlaying();
      if (bool) {
        this.mAudioTrack.pause();
      }
      this.mAudioTrack.flush();
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback$a.flush();
      this.AZ = AX;
      if (bool) {
        this.mAudioTrack.play();
      }
      return;
    }
    throw new IllegalStateException();
  }
  
  public int getAudioSessionId()
  {
    return this.mAudioSessionId;
  }
  
  public int getAudioStreamType()
  {
    return this.bng;
  }
  
  public boolean isInitialized()
  {
    return this.mAudioTrack != null;
  }
  
  public boolean isPlaying()
  {
    return this.mAudioTrack.getPlayState() == 3;
  }
  
  public void pause()
  {
    pause(true);
  }
  
  public void pause(boolean paramBoolean)
  {
    if (isInitialized())
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback$AudioThread.setPaused(true);
      this.mAudioTrack.pause();
      if (paramBoolean) {
        flush();
      }
      return;
    }
    throw new IllegalStateException();
  }
  
  public void play()
  {
    if (isInitialized())
    {
      this.mAudioTrack.play();
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback$AudioThread.setPaused(false);
      return;
    }
    throw new IllegalStateException();
  }
  
  public void setAudioSessionId(int paramInt)
  {
    if (isInitialized()) {
      throw new IllegalStateException("cannot set session id on an initialized audio track");
    }
    this.mAudioSessionId = paramInt;
  }
  
  class AudioThread
    extends Thread
  {
    private final Object br = new Object();
    private boolean mPaused = true;
    
    AudioThread()
    {
      super();
    }
    
    public void boV()
    {
      synchronized (this.br)
      {
        this.br.notify();
        return;
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual 43	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$AudioThread:isInterrupted	()Z
      //   4: ifne +102 -> 106
      //   7: aload_0
      //   8: monitorenter
      //   9: aload_0
      //   10: getfield 31	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$AudioThread:mPaused	Z
      //   13: ifeq +23 -> 36
      //   16: aload_0
      //   17: invokevirtual 46	java/lang/Object:wait	()V
      //   20: goto -11 -> 9
      //   23: astore_1
      //   24: aload_0
      //   25: monitorexit
      //   26: aload_1
      //   27: athrow
      //   28: astore_1
      //   29: aload_0
      //   30: invokevirtual 49	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$AudioThread:interrupt	()V
      //   33: goto -33 -> 0
      //   36: aload_0
      //   37: monitorexit
      //   38: aload_0
      //   39: getfield 29	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$AudioThread:br	Ljava/lang/Object;
      //   42: astore_1
      //   43: aload_1
      //   44: monitorenter
      //   45: aload_0
      //   46: getfield 17	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$AudioThread:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback;
      //   49: getfield 53	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback:a	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$a;
      //   52: invokevirtual 58	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$a:a	()Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$a$a;
      //   55: astore_2
      //   56: aload_2
      //   57: ifnonnull +18 -> 75
      //   60: aload_0
      //   61: getfield 29	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$AudioThread:br	Ljava/lang/Object;
      //   64: invokevirtual 46	java/lang/Object:wait	()V
      //   67: goto -22 -> 45
      //   70: astore_2
      //   71: aload_1
      //   72: monitorexit
      //   73: aload_2
      //   74: athrow
      //   75: aload_1
      //   76: monitorexit
      //   77: aload_0
      //   78: getfield 17	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$AudioThread:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback;
      //   81: aload_2
      //   82: getfield 64	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$a$a:buffer	Ljava/nio/ByteBuffer;
      //   85: aload_2
      //   86: getfield 68	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$a$a:presentationTimeUs	J
      //   89: invokevirtual 72	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback:b	(Ljava/nio/ByteBuffer;J)V
      //   92: aload_0
      //   93: getfield 17	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$AudioThread:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback;
      //   96: getfield 53	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback:a	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$a;
      //   99: aload_2
      //   100: invokevirtual 75	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$a:a	(Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$a$a;)V
      //   103: goto -103 -> 0
      //   106: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	107	0	this	AudioThread
      //   23	4	1	localObject1	Object
      //   28	1	1	localInterruptedException	java.lang.InterruptedException
      //   55	2	2	locala1	AudioPlayback.a.a
      //   70	30	2	locala2	AudioPlayback.a.a
      // Exception table:
      //   from	to	target	type
      //   9	20	23	finally
      //   24	26	23	finally
      //   36	38	23	finally
      //   7	9	28	java/lang/InterruptedException
      //   26	28	28	java/lang/InterruptedException
      //   38	45	28	java/lang/InterruptedException
      //   73	75	28	java/lang/InterruptedException
      //   77	103	28	java/lang/InterruptedException
      //   45	56	70	finally
      //   60	67	70	finally
      //   71	73	70	finally
      //   75	77	70	finally
    }
    
    void setPaused(boolean paramBoolean)
    {
      this.mPaused = paramBoolean;
      try
      {
        notify();
        return;
      }
      finally {}
    }
  }
  
  static class a
  {
    private int bnh;
    private int bufferSize;
    private List<a> nT = new ArrayList();
    private Queue<a> s = new LinkedList();
    
    a a()
    {
      try
      {
        a locala = (a)this.s.poll();
        if (locala != null) {
          this.bnh -= locala.buffer.remaining();
        }
        return locala;
      }
      finally {}
    }
    
    /* Error */
    void a(a parama)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_1
      //   3: getfield 47	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$a$a:buffer	Ljava/nio/ByteBuffer;
      //   6: invokevirtual 57	java/nio/ByteBuffer:capacity	()I
      //   9: istore_2
      //   10: aload_0
      //   11: getfield 59	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$a:bufferSize	I
      //   14: istore_3
      //   15: iload_2
      //   16: iload_3
      //   17: if_icmpeq +6 -> 23
      //   20: aload_0
      //   21: monitorexit
      //   22: return
      //   23: aload_1
      //   24: getfield 47	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$a$a:buffer	Ljava/nio/ByteBuffer;
      //   27: invokevirtual 63	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
      //   30: pop
      //   31: aload_0
      //   32: getfield 32	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$a:nT	Ljava/util/List;
      //   35: aload_1
      //   36: invokeinterface 69 2 0
      //   41: pop
      //   42: goto -22 -> 20
      //   45: astore_1
      //   46: aload_0
      //   47: monitorexit
      //   48: aload_1
      //   49: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	50	0	this	a
      //   0	50	1	parama	a
      //   9	9	2	i	int
      //   14	4	3	j	int
      // Exception table:
      //   from	to	target	type
      //   2	15	45	finally
      //   23	42	45	finally
    }
    
    /* Error */
    void c(ByteBuffer paramByteBuffer, long paramLong)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_1
      //   3: invokevirtual 53	java/nio/ByteBuffer:remaining	()I
      //   6: aload_0
      //   7: getfield 59	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$a:bufferSize	I
      //   10: if_icmple +20 -> 30
      //   13: aload_0
      //   14: getfield 32	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$a:nT	Ljava/util/List;
      //   17: invokeinterface 74 1 0
      //   22: aload_0
      //   23: aload_1
      //   24: invokevirtual 53	java/nio/ByteBuffer:remaining	()I
      //   27: putfield 59	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$a:bufferSize	I
      //   30: aload_0
      //   31: getfield 32	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$a:nT	Ljava/util/List;
      //   34: invokeinterface 78 1 0
      //   39: ifne +101 -> 140
      //   42: aload_0
      //   43: getfield 32	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$a:nT	Ljava/util/List;
      //   46: iconst_0
      //   47: invokeinterface 82 2 0
      //   52: checkcast 9	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$a$a
      //   55: astore 5
      //   57: aload 5
      //   59: getfield 47	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$a$a:buffer	Ljava/nio/ByteBuffer;
      //   62: aload_1
      //   63: invokevirtual 53	java/nio/ByteBuffer:remaining	()I
      //   66: invokevirtual 86	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
      //   69: pop
      //   70: aload 5
      //   72: getfield 47	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$a$a:buffer	Ljava/nio/ByteBuffer;
      //   75: invokevirtual 89	java/nio/ByteBuffer:mark	()Ljava/nio/Buffer;
      //   78: pop
      //   79: aload 5
      //   81: getfield 47	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$a$a:buffer	Ljava/nio/ByteBuffer;
      //   84: aload_1
      //   85: invokevirtual 93	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
      //   88: pop
      //   89: aload 5
      //   91: getfield 47	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$a$a:buffer	Ljava/nio/ByteBuffer;
      //   94: invokevirtual 96	java/nio/ByteBuffer:reset	()Ljava/nio/Buffer;
      //   97: pop
      //   98: aload 5
      //   100: lload_2
      //   101: putfield 100	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$a$a:presentationTimeUs	J
      //   104: aload_0
      //   105: getfield 27	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$a:s	Ljava/util/Queue;
      //   108: aload 5
      //   110: invokeinterface 101 2 0
      //   115: pop
      //   116: aload_0
      //   117: getfield 36	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$a:bnh	I
      //   120: istore 4
      //   122: aload_0
      //   123: aload 5
      //   125: getfield 47	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$a$a:buffer	Ljava/nio/ByteBuffer;
      //   128: invokevirtual 53	java/nio/ByteBuffer:remaining	()I
      //   131: iload 4
      //   133: iadd
      //   134: putfield 36	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$a:bnh	I
      //   137: aload_0
      //   138: monitorexit
      //   139: return
      //   140: new 9	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$a$a
      //   143: dup
      //   144: aload_1
      //   145: invokevirtual 53	java/nio/ByteBuffer:remaining	()I
      //   148: invokespecial 104	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$a$a:<init>	(I)V
      //   151: astore 5
      //   153: goto -96 -> 57
      //   156: astore_1
      //   157: aload_0
      //   158: monitorexit
      //   159: aload_1
      //   160: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	161	0	this	a
      //   0	161	1	paramByteBuffer	ByteBuffer
      //   0	161	2	paramLong	long
      //   120	14	4	i	int
      //   55	97	5	locala	a
      // Exception table:
      //   from	to	target	type
      //   2	30	156	finally
      //   30	57	156	finally
      //   57	137	156	finally
      //   140	153	156	finally
    }
    
    void flush()
    {
      try
      {
        for (;;)
        {
          a locala = (a)this.s.poll();
          if (locala == null) {
            break;
          }
          a(locala);
        }
        this.bnh = 0;
      }
      finally {}
    }
    
    static class a
    {
      protected ByteBuffer buffer;
      protected long presentationTimeUs;
      
      a(int paramInt)
      {
        this.buffer = ByteBuffer.allocate(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.AudioPlayback
 * JD-Core Version:    0.7.0.1
 */