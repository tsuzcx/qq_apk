package dov.com.tencent.mobileqq.richmedia.mediacodec;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.text.TextUtils;
import aopl;
import aqhq;
import ayyg;
import ayzb;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import ram;

@TargetApi(16)
public class AudioDecoder
{
  private Thread D;
  private AudioPlayRunnable jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable;
  private BgmAudioPlayRunnable jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$BgmAudioPlayRunnable;
  public a a;
  private Thread u;
  
  private void a(AudioTrack paramAudioTrack, byte[] paramArrayOfByte, int paramInt)
  {
    int i;
    switch (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.speedType)
    {
    default: 
      if (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.mMuteAudio) {
        paramAudioTrack.write(paramArrayOfByte, 0, paramInt);
      }
      paramInt = 1;
      paramArrayOfByte = null;
      i = 0;
    }
    for (;;)
    {
      if ((!this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.mMuteAudio) && (paramInt == 0) && (paramArrayOfByte != null)) {
        paramAudioTrack.write(paramArrayOfByte, 0, i);
      }
      return;
      i = paramArrayOfByte.length / 2;
      byte[] arrayOfByte = new byte[i];
      ayzb.b(paramArrayOfByte, 0, arrayOfByte, i);
      paramArrayOfByte = arrayOfByte;
      paramInt = 0;
      continue;
      i = paramArrayOfByte.length * 2;
      arrayOfByte = new byte[i];
      ayzb.a(paramArrayOfByte, 0, arrayOfByte, i, 2);
      paramArrayOfByte = arrayOfByte;
      paramInt = 0;
      continue;
      i = paramArrayOfByte.length * 2 / 3;
      arrayOfByte = new byte[i];
      ayzb.e(paramArrayOfByte, 0, arrayOfByte, i);
      paramArrayOfByte = arrayOfByte;
      paramInt = 0;
      continue;
      i = paramArrayOfByte.length * 4;
      arrayOfByte = new byte[i];
      ayzb.a(paramArrayOfByte, 0, arrayOfByte, i, 4);
      paramArrayOfByte = arrayOfByte;
      paramInt = 0;
    }
  }
  
  /* Error */
  public static void k(String paramString1, long paramLong, String paramString2)
  {
    // Byte code:
    //   0: new 2	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder
    //   3: dup
    //   4: invokespecial 66	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: new 12	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a
    //   14: dup
    //   15: invokespecial 67	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:<init>	()V
    //   18: putfield 30	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
    //   21: aload 4
    //   23: getfield 30	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
    //   26: aload_0
    //   27: putfield 71	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:audioFilePath	Ljava/lang/String;
    //   30: aload 4
    //   32: getfield 30	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
    //   35: aload_0
    //   36: aconst_null
    //   37: iconst_0
    //   38: invokestatic 76	com/tencent/mobileqq/shortvideo/util/AudioEncoder:a	(Ljava/lang/String;Ljava/lang/String;I)Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
    //   41: putfield 79	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:a	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
    //   44: aload 4
    //   46: getfield 30	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
    //   49: lload_1
    //   50: putfield 83	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:videoDurationMs	J
    //   53: aload_3
    //   54: invokestatic 89	aqhq:UD	(Ljava/lang/String;)V
    //   57: new 91	java/io/FileOutputStream
    //   60: dup
    //   61: aload_3
    //   62: invokespecial 93	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   65: astore_3
    //   66: aload_3
    //   67: astore_0
    //   68: aload 4
    //   70: invokevirtual 97	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:aN	()[B
    //   73: astore 4
    //   75: aload 4
    //   77: ifnull +11 -> 88
    //   80: aload_3
    //   81: astore_0
    //   82: aload_3
    //   83: aload 4
    //   85: invokevirtual 100	java/io/FileOutputStream:write	([B)V
    //   88: aload_3
    //   89: ifnull +7 -> 96
    //   92: aload_3
    //   93: invokevirtual 103	java/io/FileOutputStream:close	()V
    //   96: return
    //   97: astore_0
    //   98: aload_0
    //   99: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   102: return
    //   103: astore 4
    //   105: aconst_null
    //   106: astore_3
    //   107: aload_3
    //   108: astore_0
    //   109: aload 4
    //   111: invokevirtual 107	java/io/FileNotFoundException:printStackTrace	()V
    //   114: aload_3
    //   115: ifnull -19 -> 96
    //   118: aload_3
    //   119: invokevirtual 103	java/io/FileOutputStream:close	()V
    //   122: return
    //   123: astore_0
    //   124: aload_0
    //   125: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   128: return
    //   129: astore 4
    //   131: aconst_null
    //   132: astore_3
    //   133: aload_3
    //   134: astore_0
    //   135: aload 4
    //   137: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   140: aload_3
    //   141: ifnull -45 -> 96
    //   144: aload_3
    //   145: invokevirtual 103	java/io/FileOutputStream:close	()V
    //   148: return
    //   149: astore_0
    //   150: aload_0
    //   151: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   154: return
    //   155: astore_3
    //   156: aconst_null
    //   157: astore_0
    //   158: aload_0
    //   159: ifnull +7 -> 166
    //   162: aload_0
    //   163: invokevirtual 103	java/io/FileOutputStream:close	()V
    //   166: aload_3
    //   167: athrow
    //   168: astore_0
    //   169: aload_0
    //   170: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   173: goto -7 -> 166
    //   176: astore_3
    //   177: goto -19 -> 158
    //   180: astore 4
    //   182: goto -49 -> 133
    //   185: astore 4
    //   187: goto -80 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	paramString1	String
    //   0	190	1	paramLong	long
    //   0	190	3	paramString2	String
    //   7	77	4	localObject	Object
    //   103	7	4	localFileNotFoundException1	FileNotFoundException
    //   129	7	4	localIOException1	IOException
    //   180	1	4	localIOException2	IOException
    //   185	1	4	localFileNotFoundException2	FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   92	96	97	java/io/IOException
    //   57	66	103	java/io/FileNotFoundException
    //   118	122	123	java/io/IOException
    //   57	66	129	java/io/IOException
    //   144	148	149	java/io/IOException
    //   57	66	155	finally
    //   162	166	168	java/io/IOException
    //   68	75	176	finally
    //   82	88	176	finally
    //   109	114	176	finally
    //   135	140	176	finally
    //   68	75	180	java/io/IOException
    //   82	88	180	java/io/IOException
    //   68	75	185	java/io/FileNotFoundException
    //   82	88	185	java/io/FileNotFoundException
  }
  
  public void a(a parama)
  {
    for (;;)
    {
      float f2;
      float f3;
      float f1;
      try
      {
        QLog.d("AudioDecoder", 4, "startPlay " + parama.toString());
        pausePlay();
        stopAudio();
        if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a == null) {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a = new a();
        }
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.b(parama);
        if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.endTimeMs == 0L) {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.endTimeMs = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.videoDurationMs;
        }
        f2 = (float)this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.startTimeMs / (float)this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.videoDurationMs;
        f3 = (float)this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.endTimeMs / (float)this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.videoDurationMs;
        f1 = f2;
        if (f2 >= 0.0F) {
          break label228;
        }
        f1 = 0.0F;
      }
      finally {}
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable = new AudioPlayRunnable(f1, f2);
      this.u = ThreadManager.newFreeThread(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable, "AudioPlay", 8);
      this.u.start();
      if (!TextUtils.isEmpty(parama.cYj))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$BgmAudioPlayRunnable = new BgmAudioPlayRunnable();
        this.D = ThreadManager.newFreeThread(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$BgmAudioPlayRunnable, "BgmPlay", 8);
        this.D.start();
      }
      return;
      label228:
      if (f3 != 0.0F)
      {
        f2 = f3;
        if (f3 <= 1.0F) {}
      }
      else
      {
        f2 = 1.0F;
      }
    }
  }
  
  public byte[] aN()
  {
    return AudioPlayRunnable.a(new AudioPlayRunnable(0.0F, 1.0F), this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.audioFilePath, false);
  }
  
  public void dLH()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable != null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable.dLH();
      QLog.d("AudioDecoder", 4, "repeat");
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$BgmAudioPlayRunnable != null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$BgmAudioPlayRunnable.dLH();
      QLog.d("AudioDecoder", 4, " bgm repeat");
    }
  }
  
  public void pausePlay()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable != null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable.pausePlay();
      QLog.d("AudioDecoder", 4, "pausePlay");
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$BgmAudioPlayRunnable != null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$BgmAudioPlayRunnable.pausePlay();
      QLog.d("AudioDecoder", 4, "bgm pausePlay");
    }
  }
  
  public void resumePlay()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable != null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable.resumePlay();
      QLog.d("AudioDecoder", 4, "resumePlay");
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$BgmAudioPlayRunnable != null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$BgmAudioPlayRunnable.resumePlay();
      QLog.d("AudioDecoder", 4, "bgm resumePlay");
    }
  }
  
  public void seekTo(long paramLong)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable != null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable.aH(paramLong, this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.videoDurationMs);
      QLog.d("AudioDecoder", 1, new Object[] { "seekTo: ", Long.valueOf(paramLong) });
      return;
    }
    QLog.d("AudioDecoder", 4, "seekTo failed: " + paramLong);
  }
  
  public void setMuteAudio(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a == null) {
      return;
    }
    QLog.d("AudioDecoder", 1, "setMuteAudio: " + paramBoolean);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.mMuteAudio = paramBoolean;
  }
  
  public void setPlayRange(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a == null)
    {
      QLog.w("AudioDecoder", 4, "you must start play first");
      return;
    }
    if ((paramLong1 == this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.startTimeMs) && (paramLong2 == this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.endTimeMs))
    {
      ram.w("AudioDecoder", "segment not changed, setPlayRange ignore, startTimeMs=%d, endTimeMs=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      return;
    }
    QLog.d("AudioDecoder", 4, "setPlayRange begin startTimeMs=" + paramLong1 + " endTimeMs=" + paramLong2);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.startTimeMs = paramLong1;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.endTimeMs = paramLong2;
    a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a);
  }
  
  public void setSpeedType(int paramInt)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a != null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$a.speedType = paramInt;
      QLog.d("AudioDecoder", 4, "setSpeedType:" + paramInt);
    }
  }
  
  public void stopAudio()
  {
    if (this.u != null)
    {
      this.u.interrupt();
      this.u = null;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable.interruptedFlag = true;
      QLog.d("AudioDecoder", 4, "stopAudio");
    }
    if (this.D != null)
    {
      this.D.interrupt();
      this.D = null;
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$BgmAudioPlayRunnable != null) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$BgmAudioPlayRunnable.stop();
      }
      QLog.d("AudioDecoder", 4, "bgm stopAudio");
    }
  }
  
  class AudioPlayRunnable
    implements Runnable
  {
    private volatile boolean cBw;
    private volatile boolean cuB;
    private volatile int dAM;
    private int dAN;
    public boolean dBW;
    private volatile int eNm = -1;
    private int endPosition;
    public boolean interruptedFlag;
    private Object pauseLock = new Object();
    private int startPosition;
    private long videoDuration;
    private float zi;
    private float zj;
    private float zk = -1.0F;
    
    public AudioPlayRunnable(float paramFloat1, float paramFloat2)
    {
      this.zi = paramFloat1;
      this.zj = paramFloat2;
    }
    
    /* Error */
    private AudioTrack a()
    {
      // Byte code:
      //   0: iconst_3
      //   1: istore_2
      //   2: aload_0
      //   3: getfield 34	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   6: getfield 56	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   9: getfield 61	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:a	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
      //   12: getfield 66	com/tencent/mobileqq/shortvideo/util/AudioEncoder$a:dII	I
      //   15: iconst_1
      //   16: if_icmpne +111 -> 127
      //   19: iconst_4
      //   20: istore_1
      //   21: aload_0
      //   22: getfield 34	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   25: getfield 56	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   28: getfield 61	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:a	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
      //   31: getfield 69	com/tencent/mobileqq/shortvideo/util/AudioEncoder$a:dIH	I
      //   34: bipush 16
      //   36: if_icmpne +5 -> 41
      //   39: iconst_2
      //   40: istore_2
      //   41: aload_0
      //   42: getfield 34	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   45: getfield 56	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   48: getfield 61	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:a	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
      //   51: getfield 72	com/tencent/mobileqq/shortvideo/util/AudioEncoder$a:sample_rate	I
      //   54: iload_1
      //   55: iload_2
      //   56: invokestatic 78	android/media/AudioTrack:getMinBufferSize	(III)I
      //   59: istore_3
      //   60: new 74	android/media/AudioTrack
      //   63: dup
      //   64: iconst_3
      //   65: aload_0
      //   66: getfield 34	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   69: getfield 56	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   72: getfield 61	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:a	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
      //   75: getfield 72	com/tencent/mobileqq/shortvideo/util/AudioEncoder$a:sample_rate	I
      //   78: iload_1
      //   79: iload_2
      //   80: iload_3
      //   81: iconst_1
      //   82: invokespecial 81	android/media/AudioTrack:<init>	(IIIIII)V
      //   85: astore 4
      //   87: aload 4
      //   89: aload_0
      //   90: getfield 34	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   93: getfield 56	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   96: getfield 61	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:a	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
      //   99: getfield 84	com/tencent/mobileqq/shortvideo/util/AudioEncoder$a:zO	F
      //   102: aload_0
      //   103: getfield 34	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   106: getfield 56	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   109: getfield 61	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:a	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
      //   112: getfield 84	com/tencent/mobileqq/shortvideo/util/AudioEncoder$a:zO	F
      //   115: invokevirtual 88	android/media/AudioTrack:setStereoVolume	(FF)I
      //   118: pop
      //   119: aload 4
      //   121: invokevirtual 91	android/media/AudioTrack:play	()V
      //   124: aload 4
      //   126: areturn
      //   127: bipush 12
      //   129: istore_1
      //   130: goto -109 -> 21
      //   133: astore 5
      //   135: aconst_null
      //   136: astore 4
      //   138: ldc 93
      //   140: iconst_4
      //   141: ldc 95
      //   143: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   146: aload 5
      //   148: invokevirtual 104	java/lang/Throwable:printStackTrace	()V
      //   151: aload 4
      //   153: areturn
      //   154: astore 5
      //   156: goto -18 -> 138
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	159	0	this	AudioPlayRunnable
      //   20	110	1	i	int
      //   1	79	2	j	int
      //   59	22	3	k	int
      //   85	67	4	localAudioTrack	AudioTrack
      //   133	14	5	localThrowable1	Throwable
      //   154	1	5	localThrowable2	Throwable
      // Exception table:
      //   from	to	target	type
      //   2	19	133	java/lang/Throwable
      //   21	39	133	java/lang/Throwable
      //   41	87	133	java/lang/Throwable
      //   87	124	154	java/lang/Throwable
    }
    
    /* Error */
    private byte[] a(String paramString, boolean paramBoolean)
    {
      // Byte code:
      //   0: ldc 93
      //   2: iconst_4
      //   3: ldc 114
      //   5: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   8: invokestatic 123	java/lang/System:currentTimeMillis	()J
      //   11: lstore 14
      //   13: aconst_null
      //   14: astore 25
      //   16: aconst_null
      //   17: astore 20
      //   19: aconst_null
      //   20: astore 18
      //   22: new 125	android/media/MediaExtractor
      //   25: dup
      //   26: invokespecial 126	android/media/MediaExtractor:<init>	()V
      //   29: astore 26
      //   31: aconst_null
      //   32: astore 24
      //   34: aconst_null
      //   35: astore 23
      //   37: aconst_null
      //   38: astore 22
      //   40: aload 24
      //   42: astore 21
      //   44: aload 25
      //   46: astore 17
      //   48: aload 20
      //   50: astore 19
      //   52: aload 26
      //   54: aload_1
      //   55: invokevirtual 130	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
      //   58: lconst_0
      //   59: lstore 10
      //   61: lconst_0
      //   62: lstore 8
      //   64: iconst_0
      //   65: istore_3
      //   66: aload 24
      //   68: astore 21
      //   70: aload 25
      //   72: astore 17
      //   74: aload 20
      //   76: astore 19
      //   78: iload_3
      //   79: aload 26
      //   81: invokevirtual 134	android/media/MediaExtractor:getTrackCount	()I
      //   84: if_icmpge +1853 -> 1937
      //   87: aload 24
      //   89: astore 21
      //   91: aload 25
      //   93: astore 17
      //   95: aload 20
      //   97: astore 19
      //   99: aload 26
      //   101: iload_3
      //   102: invokevirtual 138	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
      //   105: astore 27
      //   107: aload 24
      //   109: astore 21
      //   111: aload 25
      //   113: astore 17
      //   115: aload 20
      //   117: astore 19
      //   119: aload 27
      //   121: ldc 140
      //   123: invokevirtual 146	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   126: astore 28
      //   128: aload 24
      //   130: astore 21
      //   132: aload 25
      //   134: astore 17
      //   136: aload 20
      //   138: astore 19
      //   140: aload_0
      //   141: aload 27
      //   143: ldc 148
      //   145: invokevirtual 152	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
      //   148: putfield 154	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:videoDuration	J
      //   151: aload 24
      //   153: astore 21
      //   155: aload 25
      //   157: astore 17
      //   159: aload 20
      //   161: astore 19
      //   163: aload_0
      //   164: getfield 46	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:zi	F
      //   167: aload_0
      //   168: getfield 154	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:videoDuration	J
      //   171: l2f
      //   172: fmul
      //   173: f2l
      //   174: lstore 10
      //   176: aload 24
      //   178: astore 21
      //   180: aload 25
      //   182: astore 17
      //   184: aload 20
      //   186: astore 19
      //   188: aload_0
      //   189: getfield 48	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:zj	F
      //   192: aload_0
      //   193: getfield 154	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:videoDuration	J
      //   196: l2f
      //   197: fmul
      //   198: f2l
      //   199: lstore 12
      //   201: lload 12
      //   203: lstore 8
      //   205: lload 12
      //   207: lconst_0
      //   208: lcmp
      //   209: ifne +21 -> 230
      //   212: aload 24
      //   214: astore 21
      //   216: aload 25
      //   218: astore 17
      //   220: aload 20
      //   222: astore 19
      //   224: aload_0
      //   225: getfield 154	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:videoDuration	J
      //   228: lstore 8
      //   230: aload 24
      //   232: astore 21
      //   234: aload 25
      //   236: astore 17
      //   238: aload 20
      //   240: astore 19
      //   242: aload 28
      //   244: ldc 156
      //   246: invokevirtual 162	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   249: ifeq +494 -> 743
      //   252: aload 24
      //   254: astore 21
      //   256: aload 25
      //   258: astore 17
      //   260: aload 20
      //   262: astore 19
      //   264: aload 26
      //   266: iload_3
      //   267: invokevirtual 166	android/media/MediaExtractor:selectTrack	(I)V
      //   270: lload 10
      //   272: lconst_0
      //   273: lcmp
      //   274: ifle +23 -> 297
      //   277: aload 24
      //   279: astore 21
      //   281: aload 25
      //   283: astore 17
      //   285: aload 20
      //   287: astore 19
      //   289: aload 26
      //   291: lload 10
      //   293: iconst_0
      //   294: invokevirtual 170	android/media/MediaExtractor:seekTo	(JI)V
      //   297: aload 24
      //   299: astore 21
      //   301: aload 25
      //   303: astore 17
      //   305: aload 20
      //   307: astore 19
      //   309: aload 28
      //   311: invokestatic 176	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
      //   314: astore 20
      //   316: aload 20
      //   318: astore 18
      //   320: aload 24
      //   322: astore 21
      //   324: aload 20
      //   326: astore 17
      //   328: aload 20
      //   330: astore 19
      //   332: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   335: ifeq +98 -> 433
      //   338: aload 20
      //   340: astore 18
      //   342: aload 24
      //   344: astore 21
      //   346: aload 20
      //   348: astore 17
      //   350: aload 20
      //   352: astore 19
      //   354: ldc 93
      //   356: iconst_4
      //   357: new 182	java/lang/StringBuilder
      //   360: dup
      //   361: invokespecial 183	java/lang/StringBuilder:<init>	()V
      //   364: ldc 185
      //   366: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   369: aload_0
      //   370: getfield 34	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   373: getfield 56	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   376: getfield 61	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:a	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
      //   379: getfield 192	com/tencent/mobileqq/shortvideo/util/AudioEncoder$a:bitrate	I
      //   382: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   385: ldc 197
      //   387: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   390: aload_0
      //   391: getfield 34	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   394: getfield 56	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   397: getfield 61	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:a	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
      //   400: getfield 66	com/tencent/mobileqq/shortvideo/util/AudioEncoder$a:dII	I
      //   403: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   406: ldc 199
      //   408: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   411: aload_0
      //   412: getfield 34	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   415: getfield 56	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   418: getfield 61	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:a	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
      //   421: getfield 72	com/tencent/mobileqq/shortvideo/util/AudioEncoder$a:sample_rate	I
      //   424: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   427: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   430: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   433: aload 24
      //   435: astore 21
      //   437: aload 20
      //   439: astore 17
      //   441: aload 20
      //   443: astore 19
      //   445: aload_0
      //   446: getfield 34	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   449: getfield 56	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   452: getfield 61	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:a	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
      //   455: aload 27
      //   457: aload_1
      //   458: invokestatic 208	ron:a	(Landroid/media/MediaFormat;Ljava/lang/String;)I
      //   461: putfield 66	com/tencent/mobileqq/shortvideo/util/AudioEncoder$a:dII	I
      //   464: aload 24
      //   466: astore 21
      //   468: aload 20
      //   470: astore 17
      //   472: aload 20
      //   474: astore 19
      //   476: aload_0
      //   477: getfield 34	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   480: getfield 56	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   483: getfield 61	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:a	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
      //   486: aload 27
      //   488: invokestatic 211	ron:a	(Landroid/media/MediaFormat;)I
      //   491: putfield 72	com/tencent/mobileqq/shortvideo/util/AudioEncoder$a:sample_rate	I
      //   494: aload 20
      //   496: astore 18
      //   498: aload 24
      //   500: astore 21
      //   502: aload 20
      //   504: astore 17
      //   506: aload 20
      //   508: astore 19
      //   510: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   513: ifeq +98 -> 611
      //   516: aload 20
      //   518: astore 18
      //   520: aload 24
      //   522: astore 21
      //   524: aload 20
      //   526: astore 17
      //   528: aload 20
      //   530: astore 19
      //   532: ldc 93
      //   534: iconst_4
      //   535: new 182	java/lang/StringBuilder
      //   538: dup
      //   539: invokespecial 183	java/lang/StringBuilder:<init>	()V
      //   542: ldc 213
      //   544: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   547: aload_0
      //   548: getfield 34	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   551: getfield 56	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   554: getfield 61	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:a	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
      //   557: getfield 192	com/tencent/mobileqq/shortvideo/util/AudioEncoder$a:bitrate	I
      //   560: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   563: ldc 197
      //   565: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   568: aload_0
      //   569: getfield 34	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   572: getfield 56	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   575: getfield 61	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:a	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
      //   578: getfield 66	com/tencent/mobileqq/shortvideo/util/AudioEncoder$a:dII	I
      //   581: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   584: ldc 199
      //   586: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   589: aload_0
      //   590: getfield 34	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   593: getfield 56	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   596: getfield 61	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:a	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
      //   599: getfield 72	com/tencent/mobileqq/shortvideo/util/AudioEncoder$a:sample_rate	I
      //   602: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   605: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   608: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   611: aload 20
      //   613: astore 18
      //   615: aload 24
      //   617: astore 21
      //   619: aload 20
      //   621: astore 17
      //   623: aload 20
      //   625: astore 19
      //   627: aload 20
      //   629: aload 27
      //   631: aconst_null
      //   632: aconst_null
      //   633: iconst_0
      //   634: invokevirtual 217	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
      //   637: aload 20
      //   639: astore 17
      //   641: aload 17
      //   643: ifnonnull +121 -> 764
      //   646: ldc 93
      //   648: iconst_2
      //   649: ldc 219
      //   651: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   654: aconst_null
      //   655: astore_1
      //   656: aload 17
      //   658: ifnull +13 -> 671
      //   661: aload 17
      //   663: invokevirtual 222	android/media/MediaCodec:stop	()V
      //   666: aload 17
      //   668: invokevirtual 225	android/media/MediaCodec:release	()V
      //   671: aload 26
      //   673: ifnull +8 -> 681
      //   676: aload 26
      //   678: invokevirtual 226	android/media/MediaExtractor:release	()V
      //   681: iconst_0
      //   682: ifeq +11 -> 693
      //   685: new 228	java/lang/NullPointerException
      //   688: dup
      //   689: invokespecial 229	java/lang/NullPointerException:<init>	()V
      //   692: athrow
      //   693: aload_1
      //   694: areturn
      //   695: astore_1
      //   696: aload 20
      //   698: astore 18
      //   700: aload 24
      //   702: astore 21
      //   704: aload 20
      //   706: astore 17
      //   708: aload 20
      //   710: astore 19
      //   712: aload_1
      //   713: invokevirtual 104	java/lang/Throwable:printStackTrace	()V
      //   716: goto -222 -> 494
      //   719: astore_1
      //   720: aload 24
      //   722: astore 21
      //   724: aload 18
      //   726: astore 17
      //   728: aload 18
      //   730: astore 19
      //   732: aload_1
      //   733: invokevirtual 104	java/lang/Throwable:printStackTrace	()V
      //   736: aload 18
      //   738: astore 17
      //   740: goto -99 -> 641
      //   743: iload_3
      //   744: iconst_1
      //   745: iadd
      //   746: istore_3
      //   747: goto -681 -> 66
      //   750: astore_1
      //   751: ldc 93
      //   753: iconst_1
      //   754: aload_1
      //   755: iconst_0
      //   756: anewarray 4	java/lang/Object
      //   759: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
      //   762: aconst_null
      //   763: areturn
      //   764: aload 17
      //   766: invokevirtual 235	android/media/MediaCodec:start	()V
      //   769: aload 17
      //   771: invokevirtual 239	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
      //   774: astore 21
      //   776: aload 17
      //   778: invokevirtual 242	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
      //   781: astore_1
      //   782: new 244	android/media/MediaCodec$BufferInfo
      //   785: dup
      //   786: invokespecial 245	android/media/MediaCodec$BufferInfo:<init>	()V
      //   789: astore 20
      //   791: iconst_0
      //   792: istore 4
      //   794: iload_2
      //   795: ifeq +374 -> 1169
      //   798: aload_0
      //   799: invokespecial 247	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:a	()Landroid/media/AudioTrack;
      //   802: astore 18
      //   804: aconst_null
      //   805: astore 19
      //   807: iconst_0
      //   808: istore 7
      //   810: iconst_0
      //   811: istore_3
      //   812: iload 7
      //   814: ifne +911 -> 1725
      //   817: iload 4
      //   819: ifne +1132 -> 1951
      //   822: aload 17
      //   824: ldc2_w 248
      //   827: invokevirtual 253	android/media/MediaCodec:dequeueInputBuffer	(J)I
      //   830: istore 5
      //   832: iload 5
      //   834: iflt +1117 -> 1951
      //   837: aload 26
      //   839: aload 21
      //   841: iload 5
      //   843: aaload
      //   844: iconst_0
      //   845: invokevirtual 257	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
      //   848: istore 6
      //   850: aload 26
      //   852: invokevirtual 260	android/media/MediaExtractor:getSampleTime	()J
      //   855: lstore 12
      //   857: iload 6
      //   859: iflt +18 -> 877
      //   862: lload 8
      //   864: lconst_0
      //   865: lcmp
      //   866: ifle +318 -> 1184
      //   869: lload 12
      //   871: lload 8
      //   873: lcmp
      //   874: iflt +310 -> 1184
      //   877: aload 17
      //   879: iload 5
      //   881: iconst_0
      //   882: iconst_0
      //   883: lconst_0
      //   884: iconst_4
      //   885: invokevirtual 264	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
      //   888: iconst_1
      //   889: istore 4
      //   891: iload_3
      //   892: ifne +1042 -> 1934
      //   895: aload 17
      //   897: aload 20
      //   899: ldc2_w 248
      //   902: invokevirtual 268	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
      //   905: istore 5
      //   907: iload 5
      //   909: tableswitch	default:+1034 -> 1943, -3:+297->1206, -2:+321->1230, -1:+360->1269
      //   937: ldc2_w -19455
      //   940: dconst_1
      //   941: iconst_4
      //   942: iand
      //   943: ifeq +344 -> 1287
      //   946: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   949: ifeq +997 -> 1946
      //   952: ldc 93
      //   954: iconst_2
      //   955: ldc_w 273
      //   958: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   961: goto +985 -> 1946
      //   964: aload 17
      //   966: iload 5
      //   968: iconst_0
      //   969: invokevirtual 277	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
      //   972: iload_3
      //   973: ifeq +660 -> 1633
      //   976: iload_2
      //   977: ifeq +748 -> 1725
      //   980: aload_0
      //   981: getfield 34	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   984: getfield 56	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   987: getfield 280	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:speedType	I
      //   990: iconst_3
      //   991: if_icmpeq +38 -> 1029
      //   994: aload_0
      //   995: monitorenter
      //   996: aload_0
      //   997: getfield 282	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:cBw	Z
      //   1000: ifne +27 -> 1027
      //   1003: aload_0
      //   1004: invokevirtual 285	java/lang/Object:wait	()V
      //   1007: aload_0
      //   1008: iconst_0
      //   1009: putfield 282	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:cBw	Z
      //   1012: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1015: ifeq +12 -> 1027
      //   1018: ldc 93
      //   1020: iconst_1
      //   1021: ldc_w 287
      //   1024: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1027: aload_0
      //   1028: monitorexit
      //   1029: aload 17
      //   1031: invokevirtual 290	android/media/MediaCodec:flush	()V
      //   1034: aload 26
      //   1036: lload 10
      //   1038: iconst_0
      //   1039: invokevirtual 170	android/media/MediaExtractor:seekTo	(JI)V
      //   1042: iconst_0
      //   1043: istore 5
      //   1045: iconst_0
      //   1046: istore 6
      //   1048: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1051: ifeq +643 -> 1694
      //   1054: ldc 93
      //   1056: iconst_1
      //   1057: ldc_w 292
      //   1060: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1063: iconst_0
      //   1064: istore_3
      //   1065: iconst_0
      //   1066: istore 4
      //   1068: aload_0
      //   1069: getfield 294	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:cuB	Z
      //   1072: istore 16
      //   1074: iload 16
      //   1076: ifeq +855 -> 1931
      //   1079: aload_0
      //   1080: getfield 41	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:pauseLock	Ljava/lang/Object;
      //   1083: astore 23
      //   1085: aload 23
      //   1087: monitorenter
      //   1088: aload_0
      //   1089: getfield 41	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:pauseLock	Ljava/lang/Object;
      //   1092: invokevirtual 285	java/lang/Object:wait	()V
      //   1095: aload 23
      //   1097: monitorexit
      //   1098: goto -286 -> 812
      //   1101: astore_1
      //   1102: aload_1
      //   1103: invokevirtual 104	java/lang/Throwable:printStackTrace	()V
      //   1106: ldc 93
      //   1108: iconst_2
      //   1109: ldc_w 296
      //   1112: aload_1
      //   1113: invokestatic 299	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   1116: aconst_null
      //   1117: astore_1
      //   1118: aload 17
      //   1120: ifnull +13 -> 1133
      //   1123: aload 17
      //   1125: invokevirtual 222	android/media/MediaCodec:stop	()V
      //   1128: aload 17
      //   1130: invokevirtual 225	android/media/MediaCodec:release	()V
      //   1133: aload 26
      //   1135: ifnull +8 -> 1143
      //   1138: aload 26
      //   1140: invokevirtual 226	android/media/MediaExtractor:release	()V
      //   1143: iconst_0
      //   1144: ifeq -451 -> 693
      //   1147: new 228	java/lang/NullPointerException
      //   1150: dup
      //   1151: invokespecial 229	java/lang/NullPointerException:<init>	()V
      //   1154: athrow
      //   1155: astore_1
      //   1156: ldc 93
      //   1158: iconst_1
      //   1159: aload_1
      //   1160: iconst_0
      //   1161: anewarray 4	java/lang/Object
      //   1164: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
      //   1167: aconst_null
      //   1168: areturn
      //   1169: new 301	java/io/ByteArrayOutputStream
      //   1172: dup
      //   1173: invokespecial 302	java/io/ByteArrayOutputStream:<init>	()V
      //   1176: astore 19
      //   1178: aconst_null
      //   1179: astore 18
      //   1181: goto -374 -> 807
      //   1184: aload 17
      //   1186: iload 5
      //   1188: iconst_0
      //   1189: iload 6
      //   1191: lload 12
      //   1193: iconst_0
      //   1194: invokevirtual 264	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
      //   1197: aload 26
      //   1199: invokevirtual 305	android/media/MediaExtractor:advance	()Z
      //   1202: pop
      //   1203: goto +748 -> 1951
      //   1206: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1209: ifeq +12 -> 1221
      //   1212: ldc 93
      //   1214: iconst_2
      //   1215: ldc_w 307
      //   1218: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1221: aload 17
      //   1223: invokevirtual 242	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
      //   1226: astore_1
      //   1227: goto -255 -> 972
      //   1230: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1233: ifeq +701 -> 1934
      //   1236: ldc 93
      //   1238: iconst_2
      //   1239: new 182	java/lang/StringBuilder
      //   1242: dup
      //   1243: invokespecial 183	java/lang/StringBuilder:<init>	()V
      //   1246: ldc_w 309
      //   1249: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1252: aload 17
      //   1254: invokevirtual 313	android/media/MediaCodec:getOutputFormat	()Landroid/media/MediaFormat;
      //   1257: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   1260: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1263: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1266: goto -294 -> 972
      //   1269: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1272: ifeq +662 -> 1934
      //   1275: ldc 93
      //   1277: iconst_2
      //   1278: ldc_w 318
      //   1281: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1284: goto -312 -> 972
      //   1287: aload_1
      //   1288: iload 5
      //   1290: aaload
      //   1291: astore 23
      //   1293: aload 23
      //   1295: ifnonnull +70 -> 1365
      //   1298: ldc 93
      //   1300: iconst_1
      //   1301: ldc_w 320
      //   1304: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   1307: aconst_null
      //   1308: astore_1
      //   1309: aload 17
      //   1311: ifnull +13 -> 1324
      //   1314: aload 17
      //   1316: invokevirtual 222	android/media/MediaCodec:stop	()V
      //   1319: aload 17
      //   1321: invokevirtual 225	android/media/MediaCodec:release	()V
      //   1324: aload 26
      //   1326: ifnull +8 -> 1334
      //   1329: aload 26
      //   1331: invokevirtual 226	android/media/MediaExtractor:release	()V
      //   1334: aload 18
      //   1336: ifnull -643 -> 693
      //   1339: aload 18
      //   1341: invokevirtual 321	android/media/AudioTrack:stop	()V
      //   1344: aload 18
      //   1346: invokevirtual 322	android/media/AudioTrack:release	()V
      //   1349: aconst_null
      //   1350: areturn
      //   1351: astore_1
      //   1352: ldc 93
      //   1354: iconst_1
      //   1355: aload_1
      //   1356: iconst_0
      //   1357: anewarray 4	java/lang/Object
      //   1360: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
      //   1363: aconst_null
      //   1364: areturn
      //   1365: aload 20
      //   1367: getfield 325	android/media/MediaCodec$BufferInfo:size	I
      //   1370: ifeq +31 -> 1401
      //   1373: aload 23
      //   1375: aload 20
      //   1377: getfield 328	android/media/MediaCodec$BufferInfo:offset	I
      //   1380: invokevirtual 334	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
      //   1383: pop
      //   1384: aload 23
      //   1386: aload 20
      //   1388: getfield 328	android/media/MediaCodec$BufferInfo:offset	I
      //   1391: aload 20
      //   1393: getfield 325	android/media/MediaCodec$BufferInfo:size	I
      //   1396: iadd
      //   1397: invokevirtual 337	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
      //   1400: pop
      //   1401: aload 23
      //   1403: invokevirtual 340	java/nio/ByteBuffer:remaining	()I
      //   1406: istore 6
      //   1408: iload 6
      //   1410: newarray byte
      //   1412: astore 22
      //   1414: aload 23
      //   1416: aload 22
      //   1418: iconst_0
      //   1419: iload 6
      //   1421: invokevirtual 344	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
      //   1424: pop
      //   1425: iload_2
      //   1426: ifeq +19 -> 1445
      //   1429: aload_0
      //   1430: getfield 34	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   1433: aload 18
      //   1435: aload 22
      //   1437: iload 6
      //   1439: invokestatic 347	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;Landroid/media/AudioTrack;[BI)V
      //   1442: goto +512 -> 1954
      //   1445: aload 19
      //   1447: aload 22
      //   1449: iconst_0
      //   1450: iload 6
      //   1452: invokevirtual 351	java/io/ByteArrayOutputStream:write	([BII)V
      //   1455: goto +499 -> 1954
      //   1458: astore_1
      //   1459: ldc 93
      //   1461: iconst_1
      //   1462: new 182	java/lang/StringBuilder
      //   1465: dup
      //   1466: invokespecial 183	java/lang/StringBuilder:<init>	()V
      //   1469: ldc_w 353
      //   1472: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1475: aload_1
      //   1476: invokevirtual 354	java/lang/Exception:toString	()Ljava/lang/String;
      //   1479: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1482: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1485: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   1488: aconst_null
      //   1489: astore_1
      //   1490: aload 17
      //   1492: ifnull +13 -> 1505
      //   1495: aload 17
      //   1497: invokevirtual 222	android/media/MediaCodec:stop	()V
      //   1500: aload 17
      //   1502: invokevirtual 225	android/media/MediaCodec:release	()V
      //   1505: aload 26
      //   1507: ifnull +8 -> 1515
      //   1510: aload 26
      //   1512: invokevirtual 226	android/media/MediaExtractor:release	()V
      //   1515: aload 18
      //   1517: ifnull -824 -> 693
      //   1520: aload 18
      //   1522: invokevirtual 321	android/media/AudioTrack:stop	()V
      //   1525: aload 18
      //   1527: invokevirtual 322	android/media/AudioTrack:release	()V
      //   1530: aconst_null
      //   1531: areturn
      //   1532: astore_1
      //   1533: ldc 93
      //   1535: iconst_1
      //   1536: aload_1
      //   1537: iconst_0
      //   1538: anewarray 4	java/lang/Object
      //   1541: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
      //   1544: aconst_null
      //   1545: areturn
      //   1546: astore_1
      //   1547: aload_0
      //   1548: monitorexit
      //   1549: aload_1
      //   1550: athrow
      //   1551: astore_1
      //   1552: aload 17
      //   1554: astore 19
      //   1556: aload 18
      //   1558: astore 21
      //   1560: aload 19
      //   1562: astore 17
      //   1564: ldc 93
      //   1566: iconst_1
      //   1567: aload_1
      //   1568: iconst_0
      //   1569: anewarray 4	java/lang/Object
      //   1572: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
      //   1575: aconst_null
      //   1576: astore_1
      //   1577: aload 19
      //   1579: ifnull +13 -> 1592
      //   1582: aload 19
      //   1584: invokevirtual 222	android/media/MediaCodec:stop	()V
      //   1587: aload 19
      //   1589: invokevirtual 225	android/media/MediaCodec:release	()V
      //   1592: aload 26
      //   1594: ifnull +8 -> 1602
      //   1597: aload 26
      //   1599: invokevirtual 226	android/media/MediaExtractor:release	()V
      //   1602: aload 18
      //   1604: ifnull -911 -> 693
      //   1607: aload 18
      //   1609: invokevirtual 321	android/media/AudioTrack:stop	()V
      //   1612: aload 18
      //   1614: invokevirtual 322	android/media/AudioTrack:release	()V
      //   1617: aconst_null
      //   1618: areturn
      //   1619: astore_1
      //   1620: ldc 93
      //   1622: iconst_1
      //   1623: aload_1
      //   1624: iconst_0
      //   1625: anewarray 4	java/lang/Object
      //   1628: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
      //   1631: aconst_null
      //   1632: areturn
      //   1633: iload 4
      //   1635: istore 5
      //   1637: iload_3
      //   1638: istore 6
      //   1640: aload_0
      //   1641: getfield 39	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:eNm	I
      //   1644: ifne +50 -> 1694
      //   1647: aload_0
      //   1648: iconst_m1
      //   1649: putfield 39	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:eNm	I
      //   1652: aload 17
      //   1654: invokevirtual 290	android/media/MediaCodec:flush	()V
      //   1657: aload 26
      //   1659: lload 10
      //   1661: iconst_0
      //   1662: invokevirtual 170	android/media/MediaExtractor:seekTo	(JI)V
      //   1665: iload 4
      //   1667: istore 5
      //   1669: iload_3
      //   1670: istore 6
      //   1672: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1675: ifeq +19 -> 1694
      //   1678: ldc 93
      //   1680: iconst_1
      //   1681: ldc_w 356
      //   1684: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1687: iload_3
      //   1688: istore 6
      //   1690: iload 4
      //   1692: istore 5
      //   1694: iload 6
      //   1696: istore_3
      //   1697: iload 5
      //   1699: istore 4
      //   1701: goto -633 -> 1068
      //   1704: astore 22
      //   1706: aload 23
      //   1708: monitorexit
      //   1709: aload 22
      //   1711: athrow
      //   1712: astore 22
      //   1714: aload 22
      //   1716: invokevirtual 357	java/lang/InterruptedException:printStackTrace	()V
      //   1719: iconst_1
      //   1720: istore 7
      //   1722: goto -910 -> 812
      //   1725: ldc 93
      //   1727: iconst_1
      //   1728: new 182	java/lang/StringBuilder
      //   1731: dup
      //   1732: invokespecial 183	java/lang/StringBuilder:<init>	()V
      //   1735: ldc_w 359
      //   1738: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1741: invokestatic 123	java/lang/System:currentTimeMillis	()J
      //   1744: lload 14
      //   1746: lsub
      //   1747: invokevirtual 362	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1750: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1753: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1756: aload 19
      //   1758: ifnonnull +67 -> 1825
      //   1761: aconst_null
      //   1762: astore 19
      //   1764: aload 17
      //   1766: ifnull +13 -> 1779
      //   1769: aload 17
      //   1771: invokevirtual 222	android/media/MediaCodec:stop	()V
      //   1774: aload 17
      //   1776: invokevirtual 225	android/media/MediaCodec:release	()V
      //   1779: aload 26
      //   1781: ifnull +8 -> 1789
      //   1784: aload 26
      //   1786: invokevirtual 226	android/media/MediaExtractor:release	()V
      //   1789: aload 19
      //   1791: astore_1
      //   1792: aload 18
      //   1794: ifnull -1101 -> 693
      //   1797: aload 18
      //   1799: invokevirtual 321	android/media/AudioTrack:stop	()V
      //   1802: aload 18
      //   1804: invokevirtual 322	android/media/AudioTrack:release	()V
      //   1807: aload 19
      //   1809: areturn
      //   1810: astore_1
      //   1811: ldc 93
      //   1813: iconst_1
      //   1814: aload_1
      //   1815: iconst_0
      //   1816: anewarray 4	java/lang/Object
      //   1819: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
      //   1822: aload 19
      //   1824: areturn
      //   1825: aload 19
      //   1827: invokevirtual 366	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   1830: astore 19
      //   1832: goto -68 -> 1764
      //   1835: astore_1
      //   1836: aload 17
      //   1838: ifnull +13 -> 1851
      //   1841: aload 17
      //   1843: invokevirtual 222	android/media/MediaCodec:stop	()V
      //   1846: aload 17
      //   1848: invokevirtual 225	android/media/MediaCodec:release	()V
      //   1851: aload 26
      //   1853: ifnull +8 -> 1861
      //   1856: aload 26
      //   1858: invokevirtual 226	android/media/MediaExtractor:release	()V
      //   1861: aload 21
      //   1863: ifnull +13 -> 1876
      //   1866: aload 21
      //   1868: invokevirtual 321	android/media/AudioTrack:stop	()V
      //   1871: aload 21
      //   1873: invokevirtual 322	android/media/AudioTrack:release	()V
      //   1876: aload_1
      //   1877: athrow
      //   1878: astore 17
      //   1880: ldc 93
      //   1882: iconst_1
      //   1883: aload 17
      //   1885: iconst_0
      //   1886: anewarray 4	java/lang/Object
      //   1889: invokestatic 232	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
      //   1892: goto -16 -> 1876
      //   1895: astore_1
      //   1896: aload 23
      //   1898: astore 21
      //   1900: goto -64 -> 1836
      //   1903: astore_1
      //   1904: aload 18
      //   1906: astore 21
      //   1908: goto -72 -> 1836
      //   1911: astore_1
      //   1912: aload 22
      //   1914: astore 18
      //   1916: goto -360 -> 1556
      //   1919: astore_1
      //   1920: aload 22
      //   1922: astore 18
      //   1924: aload 17
      //   1926: astore 19
      //   1928: goto -372 -> 1556
      //   1931: goto -1119 -> 812
      //   1934: goto -962 -> 972
      //   1937: aconst_null
      //   1938: astore 17
      //   1940: goto -1299 -> 641
      //   1943: goto -1007 -> 936
      //   1946: iconst_1
      //   1947: istore_3
      //   1948: goto -984 -> 964
      //   1951: goto -1060 -> 891
      //   1954: goto -990 -> 964
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1957	0	this	AudioPlayRunnable
      //   0	1957	1	paramString	String
      //   0	1957	2	paramBoolean	boolean
      //   65	1883	3	i	int
      //   792	908	4	j	int
      //   830	868	5	k	int
      //   848	847	6	m	int
      //   808	913	7	n	int
      //   62	810	8	l1	long
      //   59	1601	10	l2	long
      //   199	993	12	l3	long
      //   11	1734	14	l4	long
      //   1072	3	16	bool	boolean
      //   46	1801	17	localObject1	Object
      //   1878	47	17	localException	Exception
      //   1938	1	17	localObject2	Object
      //   20	1903	18	localObject3	Object
      //   50	1877	19	localObject4	Object
      //   17	1375	20	localObject5	Object
      //   42	1865	21	localObject6	Object
      //   38	1410	22	arrayOfByte	byte[]
      //   1704	6	22	localObject7	Object
      //   1712	209	22	localInterruptedException	InterruptedException
      //   32	689	24	localObject9	Object
      //   14	288	25	localObject10	Object
      //   29	1828	26	localMediaExtractor	android.media.MediaExtractor
      //   105	525	27	localMediaFormat	android.media.MediaFormat
      //   126	184	28	str	String
      // Exception table:
      //   from	to	target	type
      //   445	464	695	java/lang/Throwable
      //   476	494	695	java/lang/Throwable
      //   309	316	719	java/lang/Throwable
      //   332	338	719	java/lang/Throwable
      //   354	433	719	java/lang/Throwable
      //   510	516	719	java/lang/Throwable
      //   532	611	719	java/lang/Throwable
      //   627	637	719	java/lang/Throwable
      //   712	716	719	java/lang/Throwable
      //   661	671	750	java/lang/Exception
      //   676	681	750	java/lang/Exception
      //   685	693	750	java/lang/Exception
      //   764	769	1101	java/lang/Throwable
      //   1123	1133	1155	java/lang/Exception
      //   1138	1143	1155	java/lang/Exception
      //   1147	1155	1155	java/lang/Exception
      //   1314	1324	1351	java/lang/Exception
      //   1329	1334	1351	java/lang/Exception
      //   1339	1349	1351	java/lang/Exception
      //   1298	1307	1458	java/lang/Exception
      //   1365	1401	1458	java/lang/Exception
      //   1401	1425	1458	java/lang/Exception
      //   1429	1442	1458	java/lang/Exception
      //   1445	1455	1458	java/lang/Exception
      //   1495	1505	1532	java/lang/Exception
      //   1510	1515	1532	java/lang/Exception
      //   1520	1530	1532	java/lang/Exception
      //   996	1027	1546	finally
      //   1027	1029	1546	finally
      //   1547	1549	1546	finally
      //   822	832	1551	java/lang/Exception
      //   837	857	1551	java/lang/Exception
      //   877	888	1551	java/lang/Exception
      //   895	907	1551	java/lang/Exception
      //   936	961	1551	java/lang/Exception
      //   964	972	1551	java/lang/Exception
      //   980	996	1551	java/lang/Exception
      //   1029	1042	1551	java/lang/Exception
      //   1048	1063	1551	java/lang/Exception
      //   1068	1074	1551	java/lang/Exception
      //   1079	1088	1551	java/lang/Exception
      //   1184	1203	1551	java/lang/Exception
      //   1206	1221	1551	java/lang/Exception
      //   1221	1227	1551	java/lang/Exception
      //   1230	1266	1551	java/lang/Exception
      //   1269	1284	1551	java/lang/Exception
      //   1459	1488	1551	java/lang/Exception
      //   1549	1551	1551	java/lang/Exception
      //   1640	1665	1551	java/lang/Exception
      //   1672	1687	1551	java/lang/Exception
      //   1709	1712	1551	java/lang/Exception
      //   1714	1719	1551	java/lang/Exception
      //   1725	1756	1551	java/lang/Exception
      //   1825	1832	1551	java/lang/Exception
      //   1582	1592	1619	java/lang/Exception
      //   1597	1602	1619	java/lang/Exception
      //   1607	1617	1619	java/lang/Exception
      //   1088	1098	1704	finally
      //   1706	1709	1704	finally
      //   1079	1088	1712	java/lang/InterruptedException
      //   1709	1712	1712	java/lang/InterruptedException
      //   1769	1779	1810	java/lang/Exception
      //   1784	1789	1810	java/lang/Exception
      //   1797	1807	1810	java/lang/Exception
      //   52	58	1835	finally
      //   78	87	1835	finally
      //   99	107	1835	finally
      //   119	128	1835	finally
      //   140	151	1835	finally
      //   163	176	1835	finally
      //   188	201	1835	finally
      //   224	230	1835	finally
      //   242	252	1835	finally
      //   264	270	1835	finally
      //   289	297	1835	finally
      //   309	316	1835	finally
      //   332	338	1835	finally
      //   354	433	1835	finally
      //   445	464	1835	finally
      //   476	494	1835	finally
      //   510	516	1835	finally
      //   532	611	1835	finally
      //   627	637	1835	finally
      //   712	716	1835	finally
      //   732	736	1835	finally
      //   1564	1575	1835	finally
      //   1841	1851	1878	java/lang/Exception
      //   1856	1861	1878	java/lang/Exception
      //   1866	1876	1878	java/lang/Exception
      //   646	654	1895	finally
      //   764	769	1895	finally
      //   769	791	1895	finally
      //   798	804	1895	finally
      //   1102	1116	1895	finally
      //   1169	1178	1895	finally
      //   822	832	1903	finally
      //   837	857	1903	finally
      //   877	888	1903	finally
      //   895	907	1903	finally
      //   936	961	1903	finally
      //   964	972	1903	finally
      //   980	996	1903	finally
      //   1029	1042	1903	finally
      //   1048	1063	1903	finally
      //   1068	1074	1903	finally
      //   1079	1088	1903	finally
      //   1184	1203	1903	finally
      //   1206	1221	1903	finally
      //   1221	1227	1903	finally
      //   1230	1266	1903	finally
      //   1269	1284	1903	finally
      //   1298	1307	1903	finally
      //   1365	1401	1903	finally
      //   1401	1425	1903	finally
      //   1429	1442	1903	finally
      //   1445	1455	1903	finally
      //   1459	1488	1903	finally
      //   1549	1551	1903	finally
      //   1640	1665	1903	finally
      //   1672	1687	1903	finally
      //   1709	1712	1903	finally
      //   1714	1719	1903	finally
      //   1725	1756	1903	finally
      //   1825	1832	1903	finally
      //   52	58	1911	java/lang/Exception
      //   78	87	1911	java/lang/Exception
      //   99	107	1911	java/lang/Exception
      //   119	128	1911	java/lang/Exception
      //   140	151	1911	java/lang/Exception
      //   163	176	1911	java/lang/Exception
      //   188	201	1911	java/lang/Exception
      //   224	230	1911	java/lang/Exception
      //   242	252	1911	java/lang/Exception
      //   264	270	1911	java/lang/Exception
      //   289	297	1911	java/lang/Exception
      //   309	316	1911	java/lang/Exception
      //   332	338	1911	java/lang/Exception
      //   354	433	1911	java/lang/Exception
      //   445	464	1911	java/lang/Exception
      //   476	494	1911	java/lang/Exception
      //   510	516	1911	java/lang/Exception
      //   532	611	1911	java/lang/Exception
      //   627	637	1911	java/lang/Exception
      //   712	716	1911	java/lang/Exception
      //   732	736	1911	java/lang/Exception
      //   646	654	1919	java/lang/Exception
      //   764	769	1919	java/lang/Exception
      //   769	791	1919	java/lang/Exception
      //   798	804	1919	java/lang/Exception
      //   1102	1116	1919	java/lang/Exception
      //   1169	1178	1919	java/lang/Exception
    }
    
    /* Error */
    private byte[] ak()
    {
      // Byte code:
      //   0: invokestatic 123	java/lang/System:currentTimeMillis	()J
      //   3: lstore_3
      //   4: new 373	java/io/File
      //   7: dup
      //   8: aload_0
      //   9: getfield 34	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   12: getfield 56	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   15: getfield 377	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:audioFilePath	Ljava/lang/String;
      //   18: invokespecial 379	java/io/File:<init>	(Ljava/lang/String;)V
      //   21: astore 5
      //   23: aload_0
      //   24: aload 5
      //   26: invokevirtual 382	java/io/File:length	()J
      //   29: l2i
      //   30: putfield 384	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:dAN	I
      //   33: aload_0
      //   34: aload_0
      //   35: getfield 384	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:dAN	I
      //   38: i2f
      //   39: aload_0
      //   40: getfield 46	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:zi	F
      //   43: fmul
      //   44: f2i
      //   45: putfield 386	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:startPosition	I
      //   48: aload_0
      //   49: getfield 386	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:startPosition	I
      //   52: aload_0
      //   53: getfield 34	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   56: getfield 56	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   59: getfield 61	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:a	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
      //   62: getfield 69	com/tencent/mobileqq/shortvideo/util/AudioEncoder$a:dIH	I
      //   65: irem
      //   66: istore_1
      //   67: iload_1
      //   68: ifeq +29 -> 97
      //   71: aload_0
      //   72: getfield 386	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:startPosition	I
      //   75: istore_2
      //   76: aload_0
      //   77: aload_0
      //   78: getfield 34	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   81: getfield 56	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   84: getfield 61	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:a	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
      //   87: getfield 69	com/tencent/mobileqq/shortvideo/util/AudioEncoder$a:dIH	I
      //   90: iload_1
      //   91: isub
      //   92: iload_2
      //   93: iadd
      //   94: putfield 386	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:startPosition	I
      //   97: aload_0
      //   98: getfield 48	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:zj	F
      //   101: fconst_0
      //   102: fcmpl
      //   103: ifne +163 -> 266
      //   106: aload_0
      //   107: aload_0
      //   108: getfield 384	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:dAN	I
      //   111: putfield 388	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:endPosition	I
      //   114: ldc 93
      //   116: iconst_4
      //   117: new 182	java/lang/StringBuilder
      //   120: dup
      //   121: invokespecial 183	java/lang/StringBuilder:<init>	()V
      //   124: ldc_w 390
      //   127: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   130: aload_0
      //   131: getfield 386	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:startPosition	I
      //   134: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   137: ldc_w 392
      //   140: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   143: aload_0
      //   144: getfield 388	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:endPosition	I
      //   147: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   150: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   153: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   156: aload_0
      //   157: getfield 388	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:endPosition	I
      //   160: aload_0
      //   161: getfield 386	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:startPosition	I
      //   164: isub
      //   165: newarray byte
      //   167: astore 6
      //   169: new 394	java/io/FileInputStream
      //   172: dup
      //   173: aload 5
      //   175: invokespecial 397	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   178: astore 7
      //   180: aload 7
      //   182: ifnull +41 -> 223
      //   185: aload 7
      //   187: astore 5
      //   189: aload_0
      //   190: getfield 386	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:startPosition	I
      //   193: ifeq +18 -> 211
      //   196: aload 7
      //   198: astore 5
      //   200: aload 7
      //   202: aload_0
      //   203: getfield 386	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:startPosition	I
      //   206: i2l
      //   207: invokevirtual 401	java/io/FileInputStream:skip	(J)J
      //   210: pop2
      //   211: aload 7
      //   213: astore 5
      //   215: aload 7
      //   217: aload 6
      //   219: invokevirtual 405	java/io/FileInputStream:read	([B)I
      //   222: pop
      //   223: aload 7
      //   225: ifnull +8 -> 233
      //   228: aload 7
      //   230: invokevirtual 408	java/io/FileInputStream:close	()V
      //   233: ldc 93
      //   235: iconst_4
      //   236: new 182	java/lang/StringBuilder
      //   239: dup
      //   240: invokespecial 183	java/lang/StringBuilder:<init>	()V
      //   243: ldc_w 410
      //   246: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   249: invokestatic 123	java/lang/System:currentTimeMillis	()J
      //   252: lload_3
      //   253: lsub
      //   254: invokevirtual 362	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   257: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   260: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   263: aload 6
      //   265: areturn
      //   266: aload_0
      //   267: aload_0
      //   268: getfield 384	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:dAN	I
      //   271: i2f
      //   272: aload_0
      //   273: getfield 48	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:zj	F
      //   276: fmul
      //   277: f2i
      //   278: putfield 388	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:endPosition	I
      //   281: aload_0
      //   282: getfield 388	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:endPosition	I
      //   285: aload_0
      //   286: getfield 34	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   289: getfield 56	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   292: getfield 61	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:a	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
      //   295: getfield 69	com/tencent/mobileqq/shortvideo/util/AudioEncoder$a:dIH	I
      //   298: irem
      //   299: istore_1
      //   300: iload_1
      //   301: ifeq -187 -> 114
      //   304: aload_0
      //   305: getfield 388	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:endPosition	I
      //   308: istore_2
      //   309: aload_0
      //   310: aload_0
      //   311: getfield 34	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:this$0	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
      //   314: getfield 56	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	Ldov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a;
      //   317: getfield 61	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$a:a	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$a;
      //   320: getfield 69	com/tencent/mobileqq/shortvideo/util/AudioEncoder$a:dIH	I
      //   323: iload_1
      //   324: isub
      //   325: iload_2
      //   326: iadd
      //   327: putfield 388	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:endPosition	I
      //   330: goto -216 -> 114
      //   333: astore 6
      //   335: ldc 93
      //   337: iconst_4
      //   338: ldc_w 412
      //   341: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   344: getstatic 418	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
      //   347: ifnull +9 -> 356
      //   350: getstatic 418	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
      //   353: invokevirtual 423	android/support/v4/util/MQLruCache:evictAll	()V
      //   356: aload_0
      //   357: getfield 388	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:endPosition	I
      //   360: aload_0
      //   361: getfield 386	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioPlayRunnable:startPosition	I
      //   364: isub
      //   365: newarray byte
      //   367: astore 6
      //   369: goto -200 -> 169
      //   372: astore 5
      //   374: aload 5
      //   376: invokevirtual 424	java/io/IOException:printStackTrace	()V
      //   379: goto -146 -> 233
      //   382: astore 8
      //   384: aconst_null
      //   385: astore 6
      //   387: aload 6
      //   389: astore 5
      //   391: ldc 93
      //   393: iconst_4
      //   394: ldc_w 426
      //   397: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   400: aload 6
      //   402: astore 5
      //   404: aload 8
      //   406: invokevirtual 104	java/lang/Throwable:printStackTrace	()V
      //   409: aload 6
      //   411: ifnull +8 -> 419
      //   414: aload 6
      //   416: invokevirtual 408	java/io/FileInputStream:close	()V
      //   419: aconst_null
      //   420: areturn
      //   421: astore 5
      //   423: aload 5
      //   425: invokevirtual 424	java/io/IOException:printStackTrace	()V
      //   428: goto -9 -> 419
      //   431: astore 6
      //   433: aconst_null
      //   434: astore 5
      //   436: aload 5
      //   438: ifnull +8 -> 446
      //   441: aload 5
      //   443: invokevirtual 408	java/io/FileInputStream:close	()V
      //   446: aload 6
      //   448: athrow
      //   449: astore 5
      //   451: aload 5
      //   453: invokevirtual 424	java/io/IOException:printStackTrace	()V
      //   456: goto -10 -> 446
      //   459: astore 6
      //   461: goto -25 -> 436
      //   464: astore 8
      //   466: aload 7
      //   468: astore 6
      //   470: goto -83 -> 387
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	473	0	this	AudioPlayRunnable
      //   66	259	1	i	int
      //   75	252	2	j	int
      //   3	250	3	l	long
      //   21	193	5	localObject1	Object
      //   372	3	5	localIOException1	IOException
      //   389	14	5	localObject2	Object
      //   421	3	5	localIOException2	IOException
      //   434	8	5	localObject3	Object
      //   449	3	5	localIOException3	IOException
      //   167	97	6	arrayOfByte1	byte[]
      //   333	1	6	localOutOfMemoryError	java.lang.OutOfMemoryError
      //   367	48	6	arrayOfByte2	byte[]
      //   431	16	6	localObject4	Object
      //   459	1	6	localObject5	Object
      //   468	1	6	localObject6	Object
      //   178	289	7	localFileInputStream	java.io.FileInputStream
      //   382	23	8	localThrowable1	Throwable
      //   464	1	8	localThrowable2	Throwable
      // Exception table:
      //   from	to	target	type
      //   156	169	333	java/lang/OutOfMemoryError
      //   228	233	372	java/io/IOException
      //   169	180	382	java/lang/Throwable
      //   414	419	421	java/io/IOException
      //   169	180	431	finally
      //   441	446	449	java/io/IOException
      //   189	196	459	finally
      //   200	211	459	finally
      //   215	223	459	finally
      //   391	400	459	finally
      //   404	409	459	finally
      //   189	196	464	java/lang/Throwable
      //   200	211	464	java/lang/Throwable
      //   215	223	464	java/lang/Throwable
    }
    
    private void bs(byte[] paramArrayOfByte)
    {
      QLog.d("AudioDecoder", 4, "begin playAudio");
      Object localObject2 = null;
      Object localObject1 = null;
      AudioTrack localAudioTrack;
      int i;
      try
      {
        localAudioTrack = a();
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        k = AudioTrack.getMinBufferSize(localAudioTrack.getSampleRate(), localAudioTrack.getChannelConfiguration(), localAudioTrack.getAudioFormat());
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        arrayOfByte = new byte[k * 2];
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        this.interruptedFlag = false;
      }
      catch (Throwable paramArrayOfByte)
      {
        for (;;)
        {
          int k;
          byte[] arrayOfByte;
          int m;
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          int j = ayzb.b(paramArrayOfByte, this.dAM, arrayOfByte, k * 2);
          i = 0;
          continue;
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          j = ayzb.a(paramArrayOfByte, this.dAM, arrayOfByte, k * 2, 2);
          i = 0;
          continue;
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          j = ayzb.e(paramArrayOfByte, this.dAM, arrayOfByte, k * 2);
          i = 0;
          continue;
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          j = ayzb.a(paramArrayOfByte, this.dAM, arrayOfByte, k * 2, 4);
          i = 0;
          continue;
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          j = ayzb.d(paramArrayOfByte, this.dAM, arrayOfByte, k * 2);
          i = 0;
        }
      }
      finally
      {
        if (localObject2 == null) {
          break label889;
        }
        localObject2.release();
      }
      localObject1 = localAudioTrack;
      localObject2 = localAudioTrack;
      if (this.dAM < paramArrayOfByte.length)
      {
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        if (!this.interruptedFlag)
        {
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          if (this.zk != -1.0F)
          {
            localObject1 = localAudioTrack;
            localObject2 = localAudioTrack;
            j = (int)(this.zk * this.dAN / this.zj);
            localObject1 = localAudioTrack;
            localObject2 = localAudioTrack;
            m = j % AudioDecoder.this.a.a.dIH;
            i = j;
            if (m != 0)
            {
              localObject1 = localAudioTrack;
              localObject2 = localAudioTrack;
              i = j + (AudioDecoder.this.a.a.dIH - m);
            }
            localObject1 = localAudioTrack;
            localObject2 = localAudioTrack;
            this.dAM = (i - this.startPosition);
            localObject1 = localAudioTrack;
            localObject2 = localAudioTrack;
            localAudioTrack.flush();
            localObject1 = localAudioTrack;
            localObject2 = localAudioTrack;
            this.zk = -1.0F;
          }
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          switch (AudioDecoder.this.a.speedType)
          {
          case 1: 
            localObject1 = localAudioTrack;
            localObject2 = localAudioTrack;
            j = Math.min(paramArrayOfByte.length - this.dAM, k * 2);
            localObject1 = localAudioTrack;
            localObject2 = localAudioTrack;
            if (!AudioDecoder.this.a.mMuteAudio)
            {
              localObject1 = localAudioTrack;
              localObject2 = localAudioTrack;
              localAudioTrack.write(paramArrayOfByte, this.dAM, j);
            }
            break;
          }
        }
      }
      for (;;)
      {
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        if ((!AudioDecoder.this.a.mMuteAudio) && (i == 0))
        {
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          localAudioTrack.write(arrayOfByte, 0, k * 2);
        }
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        this.dAM += j;
        localObject1 = localAudioTrack;
        localObject2 = localAudioTrack;
        if (this.dAM >= paramArrayOfByte.length)
        {
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          if (AudioDecoder.this.a.repeat)
          {
            localObject1 = localAudioTrack;
            localObject2 = localAudioTrack;
            if (AudioDecoder.this.a.speedType != 3)
            {
              localObject1 = localAudioTrack;
              localObject2 = localAudioTrack;
            }
          }
        }
        label889:
        do
        {
          boolean bool;
          Object localObject3;
          localObject1 = localAudioTrack;
          localObject2 = localAudioTrack;
          localAudioTrack.stop();
        } while (localAudioTrack == null);
        localAudioTrack.release();
        return;
        break;
        i = 1;
      }
    }
    
    public void aH(long paramLong1, long paramLong2)
    {
      float f;
      if (AudioDecoder.this.a != null)
      {
        f = (float)paramLong1 / (float)paramLong2;
        if ((f < this.zi) || (f > this.zj)) {
          break label103;
        }
        if (AudioDecoder.this.a.speedType != 5) {
          break label94;
        }
      }
      label94:
      for (this.zk = (this.zj - (f - this.zi));; this.zk = f)
      {
        QLog.d("AudioDecoder", 1, new Object[] { "seekToPercent: ", Float.valueOf(this.zk) });
        return;
      }
      label103:
      QLog.w("AudioDecoder", 1, "seek error, timePercent=" + f);
    }
    
    public void dLH()
    {
      if (AudioDecoder.this.a.speedType != 3) {}
      try
      {
        Thread.sleep(500L);
      }
      catch (InterruptedException localInterruptedException)
      {
        try
        {
          for (;;)
          {
            this.cBw = true;
            notifyAll();
            this.dAM = 0;
            this.eNm = 0;
            return;
            localInterruptedException = localInterruptedException;
            localInterruptedException.printStackTrace();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        finally {}
      }
    }
    
    public void pausePlay()
    {
      this.cuB = true;
    }
    
    public void resumePlay()
    {
      this.cuB = false;
      synchronized (this.pauseLock)
      {
        this.pauseLock.notifyAll();
        return;
      }
    }
    
    public void run()
    {
      boolean bool = true;
      if ((this.dBW) && (!TextUtils.isEmpty(AudioDecoder.this.a.cYj))) {}
      for (;;)
      {
        try
        {
          byte[] arrayOfByte = aqhq.fileToBytes(new File(AudioDecoder.this.a.cYj));
          if (arrayOfByte != null) {
            bs(arrayOfByte);
          }
          return;
        }
        catch (Exception localException)
        {
          QLog.e("AudioDecoder", 1, "bgm music get error");
          localObject = null;
          continue;
        }
        if (MimeHelper.validateVideoType(aopl.F(BaseApplication.getContext(), AudioDecoder.this.a.audioFilePath)))
        {
          localObject = AudioDecoder.this.a.audioFilePath;
          if (AudioDecoder.this.a.speedType != 5) {}
          for (;;)
          {
            localObject = a((String)localObject, bool);
            break;
            bool = false;
          }
        }
        Object localObject = ak();
      }
    }
  }
  
  public class BgmAudioPlayRunnable
    implements Runnable
  {
    Timer aj;
    TimerTask g;
    MediaPlayer mediaPlayer;
    long videoDuration;
    
    public BgmAudioPlayRunnable()
    {
      if (AudioDecoder.this.a != null) {
        this.videoDuration = AudioDecoder.this.a.videoDurationMs;
      }
    }
    
    private void playMusic(String paramString)
    {
      try
      {
        this.mediaPlayer = new MediaPlayer();
        this.mediaPlayer.setDataSource(paramString);
        this.mediaPlayer.setAudioStreamType(3);
        this.mediaPlayer.prepareAsync();
        this.mediaPlayer.setOnPreparedListener(new ayyg(this));
        return;
      }
      catch (FileNotFoundException paramString)
      {
        QLog.e("AudioDecoder", 1, paramString, new Object[0]);
        return;
      }
      catch (IOException paramString)
      {
        QLog.e("AudioDecoder", 1, paramString, new Object[0]);
      }
    }
    
    public void dLH()
    {
      if (this.mediaPlayer != null)
      {
        this.mediaPlayer.seekTo(0);
        eUs();
      }
    }
    
    public void eUs()
    {
      if (this.mediaPlayer != null)
      {
        if (this.aj == null) {
          this.aj = new Timer();
        }
        this.mediaPlayer.start();
        if (AudioDecoder.this.a != null)
        {
          if (this.g != null) {
            this.g.cancel();
          }
          this.g = new AudioDecoder.BgmAudioPlayRunnable.2(this);
          this.aj.schedule(this.g, this.videoDuration);
        }
      }
    }
    
    public void pausePlay()
    {
      if (this.mediaPlayer != null) {
        this.mediaPlayer.pause();
      }
    }
    
    public void resumePlay()
    {
      if (this.mediaPlayer != null) {
        eUs();
      }
    }
    
    public void run()
    {
      if (!TextUtils.isEmpty(AudioDecoder.this.a.cYj)) {
        playMusic(AudioDecoder.this.a.cYj);
      }
    }
    
    public void stop()
    {
      if (this.mediaPlayer != null)
      {
        this.mediaPlayer.stop();
        this.mediaPlayer.release();
        this.mediaPlayer = null;
        if (this.aj != null)
        {
          this.aj.cancel();
          this.aj.purge();
          this.aj = null;
        }
      }
    }
  }
  
  public static class a
  {
    public AudioEncoder.a a;
    public String audioFilePath;
    public AudioEncoder.a b;
    public String cYj;
    public long endTimeMs;
    public boolean mMuteAudio;
    public boolean repeat = true;
    public int speedType = 0;
    public long startTimeMs;
    public long videoDurationMs;
    
    public void b(a parama)
    {
      if (parama == null) {
        throw new NullPointerException();
      }
      this.audioFilePath = parama.audioFilePath;
      this.cYj = parama.cYj;
      this.a = parama.a;
      this.repeat = parama.repeat;
      this.speedType = parama.speedType;
      this.mMuteAudio = parama.mMuteAudio;
      this.startTimeMs = parama.startTimeMs;
      this.endTimeMs = parama.endTimeMs;
      this.videoDurationMs = parama.videoDurationMs;
    }
    
    public String toString()
    {
      return "AudioDecodeConfig=[audioFilePath:" + this.audioFilePath + " repeat:" + this.repeat + " speedType:" + this.speedType + " mMuteAudio:" + this.mMuteAudio + " startTimeMs:" + this.startTimeMs + " endTimeMs:" + this.endTimeMs + " videoDuration:" + this.videoDurationMs + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder
 * JD-Core Version:    0.7.0.1
 */