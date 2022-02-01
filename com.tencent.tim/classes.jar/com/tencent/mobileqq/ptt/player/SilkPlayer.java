package com.tencent.mobileqq.ptt.player;

import alim;
import alin;
import alio;
import android.app.Application;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import anpc;
import aqlv;
import auru;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class SilkPlayer
  implements alin, Handler.Callback
{
  private alim jdField_a_of_type_Alim;
  private alio jdField_a_of_type_Alio;
  private SilkPlayerThread jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread;
  private auru b = new auru(Looper.getMainLooper(), this);
  private byte bu = -1;
  private int duv = 3;
  private int duw;
  private int dux;
  private long lastTime = -1L;
  private Application mApplication = BaseApplicationImpl.sApplication;
  private int mDuration = -1;
  private String mFilePath;
  private int mSeekToTime = -1;
  private float mSpeed = 1.0F;
  
  public void a(int paramInt, byte paramByte)
  {
    this.mDuration = paramInt;
    this.bu = paramByte;
  }
  
  public void a(alim paramalim)
  {
    this.jdField_a_of_type_Alim = paramalim;
  }
  
  public void a(alio paramalio)
  {
    this.jdField_a_of_type_Alio = paramalio;
  }
  
  public void ao(float paramFloat)
  {
    this.mSpeed = paramFloat;
    if (QLog.isColorLevel()) {
      QLog.d("SilkPlayer", 2, "setPlaySpeed=" + paramFloat);
    }
  }
  
  public int getCurrentPosition()
  {
    return this.dux * 20;
  }
  
  public int getDuration()
  {
    return this.mDuration;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      if (this.jdField_a_of_type_Alio != null) {
        this.jdField_a_of_type_Alio.a(this, 0, 0);
      }
    }
    do
    {
      do
      {
        return true;
        if (paramMessage.what != 2) {
          break;
        }
      } while (this.jdField_a_of_type_Alio == null);
      this.jdField_a_of_type_Alio.onCompletion();
      return true;
    } while ((paramMessage.what != 3) || (this.jdField_a_of_type_Alio == null));
    this.jdField_a_of_type_Alio.Ce(((Integer)paramMessage.obj).intValue());
    return true;
  }
  
  public boolean isPlaying()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread != null) && (SilkPlayerThread.a(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread));
  }
  
  public void onCompletion()
  {
    this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread = null;
    if (this.jdField_a_of_type_Alio != null) {
      this.b.sendEmptyMessage(2);
    }
  }
  
  public void onError(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread = null;
    if (this.jdField_a_of_type_Alio != null) {
      this.b.sendEmptyMessage(1);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_succ_flag", "0");
    localHashMap.put("errCode", paramInt + "");
    localHashMap.put("param_version", Build.VERSION.SDK_INT + "");
    localHashMap.put("param_deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "PttSilkPlaryerError", true, 0L, 0L, localHashMap, null);
  }
  
  public void onProgress(int paramInt)
  {
    if (this.jdField_a_of_type_Alio != null)
    {
      if (this.lastTime >= 0L) {
        break label46;
      }
      localMessage = this.b.obtainMessage(3, Integer.valueOf(paramInt));
      this.b.sendMessage(localMessage);
      this.lastTime = System.currentTimeMillis();
    }
    label46:
    while (System.currentTimeMillis() - this.lastTime <= 100L) {
      return;
    }
    Message localMessage = this.b.obtainMessage(3, Integer.valueOf(paramInt));
    this.b.sendMessage(localMessage);
    this.lastTime = System.currentTimeMillis();
  }
  
  public void pause()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread != null) && (this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread.isAlive()))
    {
      SilkPlayerThread.a(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread, false);
      this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread = null;
    }
  }
  
  /* Error */
  public void prepare()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/tencent/mobileqq/ptt/player/SilkPlayer:mDuration	I
    //   4: iconst_m1
    //   5: if_icmpeq +11 -> 16
    //   8: aload_0
    //   9: getfield 45	com/tencent/mobileqq/ptt/player/SilkPlayer:bu	B
    //   12: iconst_m1
    //   13: if_icmpne +67 -> 80
    //   16: new 253	java/io/FileInputStream
    //   19: dup
    //   20: aload_0
    //   21: getfield 86	com/tencent/mobileqq/ptt/player/SilkPlayer:mFilePath	Ljava/lang/String;
    //   24: invokespecial 256	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   27: astore_2
    //   28: aload_2
    //   29: astore_1
    //   30: aload_0
    //   31: getfield 45	com/tencent/mobileqq/ptt/player/SilkPlayer:bu	B
    //   34: iconst_m1
    //   35: if_icmpne +46 -> 81
    //   38: aload_2
    //   39: astore_1
    //   40: aload_0
    //   41: aload_2
    //   42: invokestatic 261	aqlv:a	(Ljava/io/InputStream;)B
    //   45: putfield 45	com/tencent/mobileqq/ptt/player/SilkPlayer:bu	B
    //   48: aload_2
    //   49: astore_1
    //   50: aload_0
    //   51: getfield 41	com/tencent/mobileqq/ptt/player/SilkPlayer:mDuration	I
    //   54: iconst_m1
    //   55: if_icmpne +17 -> 72
    //   58: aload_2
    //   59: astore_1
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 45	com/tencent/mobileqq/ptt/player/SilkPlayer:bu	B
    //   65: aload_2
    //   66: invokestatic 266	com/tencent/mobileqq/utils/QQRecorder:a	(BLjava/io/InputStream;)I
    //   69: putfield 41	com/tencent/mobileqq/ptt/player/SilkPlayer:mDuration	I
    //   72: aload_2
    //   73: ifnull +7 -> 80
    //   76: aload_2
    //   77: invokevirtual 269	java/io/FileInputStream:close	()V
    //   80: return
    //   81: aload_2
    //   82: astore_1
    //   83: aload_2
    //   84: ldc2_w 270
    //   87: invokevirtual 275	java/io/FileInputStream:skip	(J)J
    //   90: pop2
    //   91: goto -43 -> 48
    //   94: astore_3
    //   95: aload_2
    //   96: astore_1
    //   97: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +34 -> 134
    //   103: aload_2
    //   104: astore_1
    //   105: ldc 106
    //   107: iconst_2
    //   108: new 108	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   115: ldc_w 277
    //   118: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_3
    //   122: invokevirtual 280	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   125: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: aload_2
    //   135: ifnull -55 -> 80
    //   138: aload_2
    //   139: invokevirtual 269	java/io/FileInputStream:close	()V
    //   142: return
    //   143: astore_1
    //   144: return
    //   145: astore_2
    //   146: aconst_null
    //   147: astore_1
    //   148: aload_1
    //   149: ifnull +7 -> 156
    //   152: aload_1
    //   153: invokevirtual 269	java/io/FileInputStream:close	()V
    //   156: aload_2
    //   157: athrow
    //   158: astore_1
    //   159: return
    //   160: astore_1
    //   161: goto -5 -> 156
    //   164: astore_2
    //   165: goto -17 -> 148
    //   168: astore_3
    //   169: aconst_null
    //   170: astore_2
    //   171: goto -76 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	SilkPlayer
    //   29	76	1	localFileInputStream1	java.io.FileInputStream
    //   143	1	1	localException1	java.lang.Exception
    //   147	6	1	localObject1	Object
    //   158	1	1	localException2	java.lang.Exception
    //   160	1	1	localException3	java.lang.Exception
    //   27	112	2	localFileInputStream2	java.io.FileInputStream
    //   145	12	2	localObject2	Object
    //   164	1	2	localObject3	Object
    //   170	1	2	localObject4	Object
    //   94	28	3	localException4	java.lang.Exception
    //   168	1	3	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   30	38	94	java/lang/Exception
    //   40	48	94	java/lang/Exception
    //   50	58	94	java/lang/Exception
    //   60	72	94	java/lang/Exception
    //   83	91	94	java/lang/Exception
    //   138	142	143	java/lang/Exception
    //   16	28	145	finally
    //   76	80	158	java/lang/Exception
    //   152	156	160	java/lang/Exception
    //   30	38	164	finally
    //   40	48	164	finally
    //   50	58	164	finally
    //   60	72	164	finally
    //   83	91	164	finally
    //   97	103	164	finally
    //   105	134	164	finally
    //   16	28	168	java/lang/Exception
  }
  
  public void release() {}
  
  public void reset() {}
  
  public void seekTo(int paramInt)
  {
    this.mSeekToTime = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("SilkPlayer", 2, "seekTo=" + paramInt);
    }
  }
  
  public void setDataSource(String paramString)
  {
    this.mFilePath = paramString;
  }
  
  public void setStreamType(int paramInt)
  {
    this.duv = paramInt;
  }
  
  public void start()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread = new SilkPlayerThread(this.mApplication);
      if ((this.mSeekToTime == -1) && (this.dux > 0)) {
        seekTo(getCurrentPosition());
      }
      this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread.start();
    }
  }
  
  public void stop()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread != null) && (this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread.isAlive()))
    {
      SilkPlayerThread.a(this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread, false);
      this.jdField_a_of_type_ComTencentMobileqqPttPlayerSilkPlayer$SilkPlayerThread = null;
    }
    this.mDuration = -1;
    this.bu = -1;
    this.duw = 0;
    this.dux = 0;
  }
  
  class SilkPlayerThread
    extends Thread
  {
    private SilkCodecWrapper a;
    private volatile boolean cxm;
    private int duy;
    private byte[] ff;
    private byte[] fg;
    private AudioTrack mAudioTrack;
    private int sampleRate = aqlv.e(SilkPlayer.a(SilkPlayer.this));
    
    public SilkPlayerThread(Application paramApplication)
    {
      this.a = new SilkCodecWrapper(paramApplication, false);
      this.duy = aqlv.kg(this.sampleRate);
      this.ff = new byte[this.duy];
      this.fg = new byte[this.duy];
      if (QLog.isColorLevel()) {
        QLog.d("SilkPlayer", 2, "SilkPlayerThread sampleRate=" + this.sampleRate + ", oneFrameSize=" + this.duy + ", currenttime:" + System.currentTimeMillis());
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: iconst_2
      //   1: newarray byte
      //   3: astore 11
      //   5: bipush 237
      //   7: invokestatic 113	android/os/Process:setThreadPriority	(I)V
      //   10: aload_0
      //   11: getfield 46	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:a	Lcom/tencent/mobileqq/utils/SilkCodecWrapper;
      //   14: aload_0
      //   15: getfield 39	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:sampleRate	I
      //   18: iconst_0
      //   19: iconst_1
      //   20: invokevirtual 117	com/tencent/mobileqq/utils/SilkCodecWrapper:init	(III)V
      //   23: aload_0
      //   24: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   27: invokestatic 120	com/tencent/mobileqq/ptt/player/SilkPlayer:a	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)F
      //   30: invokestatic 126	com/tencent/mobileqq/activity/aio/MediaPlayerManager:f	(F)Z
      //   33: ifeq +1139 -> 1172
      //   36: getstatic 131	xla:bhy	Z
      //   39: ifeq +1133 -> 1172
      //   42: new 133	com/tencent/mobileqq/ptt/pttspeed/Sonic
      //   45: dup
      //   46: aload_0
      //   47: getfield 39	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:sampleRate	I
      //   50: iconst_1
      //   51: invokespecial 136	com/tencent/mobileqq/ptt/pttspeed/Sonic:<init>	(II)V
      //   54: astore 10
      //   56: aload 10
      //   58: aload_0
      //   59: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   62: invokestatic 120	com/tencent/mobileqq/ptt/player/SilkPlayer:a	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)F
      //   65: invokevirtual 140	com/tencent/mobileqq/ptt/pttspeed/Sonic:setSpeed	(F)V
      //   68: sipush 2048
      //   71: newarray byte
      //   73: astore 7
      //   75: aload_0
      //   76: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   79: invokestatic 143	com/tencent/mobileqq/ptt/player/SilkPlayer:a	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)Lalio;
      //   82: ifnull +15 -> 97
      //   85: aload_0
      //   86: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   89: invokestatic 143	com/tencent/mobileqq/ptt/player/SilkPlayer:a	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)Lalio;
      //   92: invokeinterface 148 1 0
      //   97: aload_0
      //   98: getfield 39	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:sampleRate	I
      //   101: iconst_4
      //   102: iconst_2
      //   103: invokestatic 154	android/media/AudioTrack:getMinBufferSize	(III)I
      //   106: istore_1
      //   107: aload_0
      //   108: new 150	android/media/AudioTrack
      //   111: dup
      //   112: aload_0
      //   113: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   116: invokestatic 157	com/tencent/mobileqq/ptt/player/SilkPlayer:a	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)I
      //   119: aload_0
      //   120: getfield 39	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:sampleRate	I
      //   123: iconst_4
      //   124: iconst_2
      //   125: iload_1
      //   126: iconst_1
      //   127: invokespecial 160	android/media/AudioTrack:<init>	(IIIIII)V
      //   130: putfield 162	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:mAudioTrack	Landroid/media/AudioTrack;
      //   133: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   136: ifeq +66 -> 202
      //   139: ldc 64
      //   141: iconst_2
      //   142: new 66	java/lang/StringBuilder
      //   145: dup
      //   146: invokespecial 67	java/lang/StringBuilder:<init>	()V
      //   149: ldc 164
      //   151: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   154: aload_0
      //   155: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   158: invokestatic 157	com/tencent/mobileqq/ptt/player/SilkPlayer:a	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)I
      //   161: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   164: ldc 166
      //   166: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   169: aload_0
      //   170: getfield 39	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:sampleRate	I
      //   173: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   176: ldc 168
      //   178: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   181: iload_1
      //   182: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   185: ldc 170
      //   187: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   190: invokestatic 86	java/lang/System:currentTimeMillis	()J
      //   193: invokevirtual 89	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   196: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   199: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   202: aload_0
      //   203: getfield 162	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:mAudioTrack	Landroid/media/AudioTrack;
      //   206: invokevirtual 173	android/media/AudioTrack:play	()V
      //   209: aload_0
      //   210: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   213: invokestatic 176	com/tencent/mobileqq/ptt/player/SilkPlayer:b	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)I
      //   216: iconst_m1
      //   217: if_icmpeq +263 -> 480
      //   220: aload_0
      //   221: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   224: invokestatic 176	com/tencent/mobileqq/ptt/player/SilkPlayer:b	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)I
      //   227: aload_0
      //   228: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   231: invokevirtual 180	com/tencent/mobileqq/ptt/player/SilkPlayer:getCurrentPosition	()I
      //   234: if_icmpne +228 -> 462
      //   237: aload_0
      //   238: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   241: invokestatic 183	com/tencent/mobileqq/ptt/player/SilkPlayer:c	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)I
      //   244: istore_2
      //   245: aload_0
      //   246: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   249: invokestatic 183	com/tencent/mobileqq/ptt/player/SilkPlayer:c	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)I
      //   252: istore_1
      //   253: aload_0
      //   254: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   257: iconst_m1
      //   258: invokestatic 186	com/tencent/mobileqq/ptt/player/SilkPlayer:a	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;I)I
      //   261: pop
      //   262: new 188	java/io/FileInputStream
      //   265: dup
      //   266: aload_0
      //   267: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   270: invokestatic 191	com/tencent/mobileqq/ptt/player/SilkPlayer:a	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)Ljava/lang/String;
      //   273: invokespecial 194	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
      //   276: astore 9
      //   278: iload_2
      //   279: ifne +208 -> 487
      //   282: aload 9
      //   284: ldc2_w 195
      //   287: invokevirtual 200	java/io/FileInputStream:skip	(J)J
      //   290: pop2
      //   291: iload_1
      //   292: bipush 10
      //   294: iadd
      //   295: istore_2
      //   296: aload_0
      //   297: getfield 101	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:cxm	Z
      //   300: ifeq +854 -> 1154
      //   303: aload 9
      //   305: ifnull +849 -> 1154
      //   308: aload 9
      //   310: aload 11
      //   312: iconst_0
      //   313: iconst_2
      //   314: invokevirtual 204	java/io/FileInputStream:read	([BII)I
      //   317: istore_3
      //   318: iload_2
      //   319: iconst_2
      //   320: iadd
      //   321: istore_1
      //   322: iload_3
      //   323: iconst_m1
      //   324: if_icmpne +180 -> 504
      //   327: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   330: ifeq +833 -> 1163
      //   333: ldc 64
      //   335: iconst_2
      //   336: new 66	java/lang/StringBuilder
      //   339: dup
      //   340: invokespecial 67	java/lang/StringBuilder:<init>	()V
      //   343: ldc 206
      //   345: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   348: aload_0
      //   349: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   352: invokestatic 208	com/tencent/mobileqq/ptt/player/SilkPlayer:d	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)I
      //   355: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   358: ldc 210
      //   360: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   363: aload_0
      //   364: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   367: invokestatic 183	com/tencent/mobileqq/ptt/player/SilkPlayer:c	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)I
      //   370: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   373: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   376: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   379: iconst_1
      //   380: istore_1
      //   381: aload 9
      //   383: astore 7
      //   385: aload_0
      //   386: iconst_0
      //   387: putfield 101	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:cxm	Z
      //   390: aload_0
      //   391: getfield 162	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:mAudioTrack	Landroid/media/AudioTrack;
      //   394: ifnull +39 -> 433
      //   397: aload_0
      //   398: getfield 162	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:mAudioTrack	Landroid/media/AudioTrack;
      //   401: invokevirtual 213	android/media/AudioTrack:getState	()I
      //   404: ifeq +29 -> 433
      //   407: aload_0
      //   408: getfield 162	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:mAudioTrack	Landroid/media/AudioTrack;
      //   411: invokevirtual 216	android/media/AudioTrack:pause	()V
      //   414: aload_0
      //   415: getfield 162	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:mAudioTrack	Landroid/media/AudioTrack;
      //   418: invokevirtual 219	android/media/AudioTrack:flush	()V
      //   421: aload_0
      //   422: getfield 162	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:mAudioTrack	Landroid/media/AudioTrack;
      //   425: invokevirtual 222	android/media/AudioTrack:release	()V
      //   428: aload_0
      //   429: aconst_null
      //   430: putfield 162	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:mAudioTrack	Landroid/media/AudioTrack;
      //   433: aload_0
      //   434: getfield 46	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:a	Lcom/tencent/mobileqq/utils/SilkCodecWrapper;
      //   437: invokevirtual 225	com/tencent/mobileqq/utils/SilkCodecWrapper:eer	()V
      //   440: iload_1
      //   441: ifeq +10 -> 451
      //   444: aload_0
      //   445: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   448: invokevirtual 228	com/tencent/mobileqq/ptt/player/SilkPlayer:onCompletion	()V
      //   451: aload 7
      //   453: ifnull +8 -> 461
      //   456: aload 7
      //   458: invokevirtual 231	java/io/FileInputStream:close	()V
      //   461: return
      //   462: aload_0
      //   463: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   466: iconst_0
      //   467: invokestatic 233	com/tencent/mobileqq/ptt/player/SilkPlayer:b	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;I)I
      //   470: pop
      //   471: aload_0
      //   472: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   475: iconst_0
      //   476: invokestatic 235	com/tencent/mobileqq/ptt/player/SilkPlayer:c	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;I)I
      //   479: pop
      //   480: iconst_0
      //   481: istore_2
      //   482: iconst_0
      //   483: istore_1
      //   484: goto -222 -> 262
      //   487: iload_2
      //   488: i2l
      //   489: lstore 5
      //   491: aload 9
      //   493: lload 5
      //   495: invokevirtual 200	java/io/FileInputStream:skip	(J)J
      //   498: pop2
      //   499: iload_1
      //   500: istore_2
      //   501: goto -205 -> 296
      //   504: aload_0
      //   505: getfield 101	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:cxm	Z
      //   508: ifne +12 -> 520
      //   511: iconst_0
      //   512: istore_1
      //   513: aload 9
      //   515: astore 7
      //   517: goto -132 -> 385
      //   520: aload 11
      //   522: invokestatic 239	aqlv:z	([B)I
      //   525: istore_3
      //   526: iload_3
      //   527: ifgt +51 -> 578
      //   530: aload_0
      //   531: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   534: iconst_1
      //   535: invokevirtual 242	com/tencent/mobileqq/ptt/player/SilkPlayer:onError	(I)V
      //   538: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   541: ifeq +613 -> 1154
      //   544: ldc 64
      //   546: iconst_2
      //   547: new 66	java/lang/StringBuilder
      //   550: dup
      //   551: invokespecial 67	java/lang/StringBuilder:<init>	()V
      //   554: ldc 244
      //   556: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   559: iload_3
      //   560: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   563: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   566: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   569: iconst_0
      //   570: istore_1
      //   571: aload 9
      //   573: astore 7
      //   575: goto -190 -> 385
      //   578: aload_0
      //   579: getfield 101	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:cxm	Z
      //   582: ifne +12 -> 594
      //   585: iconst_0
      //   586: istore_1
      //   587: aload 9
      //   589: astore 7
      //   591: goto -206 -> 385
      //   594: aload_0
      //   595: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   598: invokestatic 176	com/tencent/mobileqq/ptt/player/SilkPlayer:b	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)I
      //   601: iconst_m1
      //   602: if_icmpne +486 -> 1088
      //   605: aload 9
      //   607: aload_0
      //   608: getfield 54	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:ff	[B
      //   611: iconst_0
      //   612: iload_3
      //   613: invokevirtual 204	java/io/FileInputStream:read	([BII)I
      //   616: istore 4
      //   618: iload_1
      //   619: iload_3
      //   620: iadd
      //   621: istore_2
      //   622: iload 4
      //   624: iconst_m1
      //   625: if_icmpne +51 -> 676
      //   628: aload_0
      //   629: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   632: iconst_2
      //   633: invokevirtual 242	com/tencent/mobileqq/ptt/player/SilkPlayer:onError	(I)V
      //   636: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   639: ifeq +515 -> 1154
      //   642: ldc 64
      //   644: iconst_2
      //   645: new 66	java/lang/StringBuilder
      //   648: dup
      //   649: invokespecial 67	java/lang/StringBuilder:<init>	()V
      //   652: ldc 246
      //   654: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   657: iload_3
      //   658: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   661: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   664: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   667: iconst_0
      //   668: istore_1
      //   669: aload 9
      //   671: astore 7
      //   673: goto -288 -> 385
      //   676: aload_0
      //   677: getfield 101	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:cxm	Z
      //   680: ifne +12 -> 692
      //   683: iconst_0
      //   684: istore_1
      //   685: aload 9
      //   687: astore 7
      //   689: goto -304 -> 385
      //   692: aload_0
      //   693: getfield 46	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:a	Lcom/tencent/mobileqq/utils/SilkCodecWrapper;
      //   696: aload_0
      //   697: getfield 54	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:ff	[B
      //   700: aload_0
      //   701: getfield 56	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:fg	[B
      //   704: iload_3
      //   705: aload_0
      //   706: getfield 56	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:fg	[B
      //   709: arraylength
      //   710: invokevirtual 249	com/tencent/mobileqq/utils/SilkCodecWrapper:a	([B[BII)I
      //   713: istore_3
      //   714: iload_3
      //   715: ifne +34 -> 749
      //   718: aload_0
      //   719: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   722: iconst_3
      //   723: invokevirtual 242	com/tencent/mobileqq/ptt/player/SilkPlayer:onError	(I)V
      //   726: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   729: ifeq +425 -> 1154
      //   732: ldc 64
      //   734: iconst_2
      //   735: ldc 251
      //   737: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   740: iconst_0
      //   741: istore_1
      //   742: aload 9
      //   744: astore 7
      //   746: goto -361 -> 385
      //   749: aload 7
      //   751: astore 8
      //   753: iload_2
      //   754: istore_1
      //   755: aload_0
      //   756: getfield 101	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:cxm	Z
      //   759: ifeq +99 -> 858
      //   762: aload_0
      //   763: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   766: invokestatic 120	com/tencent/mobileqq/ptt/player/SilkPlayer:a	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)F
      //   769: invokestatic 126	com/tencent/mobileqq/activity/aio/MediaPlayerManager:f	(F)Z
      //   772: ifeq +258 -> 1030
      //   775: aload 7
      //   777: ifnull +253 -> 1030
      //   780: getstatic 131	xla:bhy	Z
      //   783: ifeq +247 -> 1030
      //   786: iload_3
      //   787: ifle +235 -> 1022
      //   790: aload 10
      //   792: aload_0
      //   793: getfield 56	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:fg	[B
      //   796: iload_3
      //   797: invokevirtual 254	com/tencent/mobileqq/ptt/pttspeed/Sonic:e	([BI)Z
      //   800: pop
      //   801: aload 10
      //   803: invokevirtual 257	com/tencent/mobileqq/ptt/pttspeed/Sonic:HC	()I
      //   806: istore_3
      //   807: aload 7
      //   809: astore 8
      //   811: iload_2
      //   812: istore_1
      //   813: iload_3
      //   814: ifle +44 -> 858
      //   817: aload 7
      //   819: astore 8
      //   821: aload 7
      //   823: arraylength
      //   824: iload_3
      //   825: if_icmpge +10 -> 835
      //   828: iload_3
      //   829: iconst_2
      //   830: imul
      //   831: newarray byte
      //   833: astore 8
      //   835: aload 10
      //   837: aload 8
      //   839: iload_3
      //   840: invokevirtual 261	com/tencent/mobileqq/ptt/pttspeed/Sonic:i	([BI)I
      //   843: pop
      //   844: aload_0
      //   845: getfield 162	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:mAudioTrack	Landroid/media/AudioTrack;
      //   848: aload 8
      //   850: iconst_0
      //   851: iload_3
      //   852: invokevirtual 264	android/media/AudioTrack:write	([BII)I
      //   855: pop
      //   856: iload_2
      //   857: istore_1
      //   858: ldc 64
      //   860: monitorenter
      //   861: aload_0
      //   862: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   865: iload_1
      //   866: invokestatic 235	com/tencent/mobileqq/ptt/player/SilkPlayer:c	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;I)I
      //   869: pop
      //   870: aload_0
      //   871: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   874: invokestatic 266	com/tencent/mobileqq/ptt/player/SilkPlayer:e	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)I
      //   877: pop
      //   878: aload_0
      //   879: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   882: invokestatic 176	com/tencent/mobileqq/ptt/player/SilkPlayer:b	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)I
      //   885: iconst_m1
      //   886: if_icmpne +20 -> 906
      //   889: aload_0
      //   890: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   893: aload_0
      //   894: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   897: invokestatic 208	com/tencent/mobileqq/ptt/player/SilkPlayer:d	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)I
      //   900: bipush 20
      //   902: imul
      //   903: invokevirtual 269	com/tencent/mobileqq/ptt/player/SilkPlayer:onProgress	(I)V
      //   906: ldc 64
      //   908: monitorexit
      //   909: aload 8
      //   911: astore 7
      //   913: iload_1
      //   914: istore_2
      //   915: aload_0
      //   916: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   919: invokestatic 176	com/tencent/mobileqq/ptt/player/SilkPlayer:b	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)I
      //   922: iconst_m1
      //   923: if_icmpeq -627 -> 296
      //   926: aload 8
      //   928: astore 7
      //   930: iload_1
      //   931: istore_2
      //   932: aload_0
      //   933: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   936: invokevirtual 180	com/tencent/mobileqq/ptt/player/SilkPlayer:getCurrentPosition	()I
      //   939: aload_0
      //   940: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   943: invokestatic 176	com/tencent/mobileqq/ptt/player/SilkPlayer:b	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)I
      //   946: if_icmplt -650 -> 296
      //   949: aload_0
      //   950: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   953: iconst_m1
      //   954: invokestatic 186	com/tencent/mobileqq/ptt/player/SilkPlayer:a	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;I)I
      //   957: pop
      //   958: aload 8
      //   960: astore 7
      //   962: iload_1
      //   963: istore_2
      //   964: goto -668 -> 296
      //   967: astore 8
      //   969: iconst_0
      //   970: istore_1
      //   971: aload 9
      //   973: astore 7
      //   975: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   978: ifeq +33 -> 1011
      //   981: ldc 64
      //   983: iconst_2
      //   984: new 66	java/lang/StringBuilder
      //   987: dup
      //   988: invokespecial 67	java/lang/StringBuilder:<init>	()V
      //   991: ldc_w 271
      //   994: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   997: aload 8
      //   999: invokevirtual 272	java/lang/Exception:toString	()Ljava/lang/String;
      //   1002: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1005: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1008: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1011: aload_0
      //   1012: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   1015: iconst_4
      //   1016: invokevirtual 242	com/tencent/mobileqq/ptt/player/SilkPlayer:onError	(I)V
      //   1019: goto -634 -> 385
      //   1022: aload 10
      //   1024: invokevirtual 273	com/tencent/mobileqq/ptt/pttspeed/Sonic:flush	()V
      //   1027: goto -226 -> 801
      //   1030: aload_0
      //   1031: getfield 162	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:mAudioTrack	Landroid/media/AudioTrack;
      //   1034: aload_0
      //   1035: getfield 56	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:fg	[B
      //   1038: iconst_0
      //   1039: aload_0
      //   1040: getfield 52	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:duy	I
      //   1043: invokevirtual 264	android/media/AudioTrack:write	([BII)I
      //   1046: pop
      //   1047: aload 7
      //   1049: astore 8
      //   1051: iload_2
      //   1052: istore_1
      //   1053: aload_0
      //   1054: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   1057: invokestatic 276	com/tencent/mobileqq/ptt/player/SilkPlayer:a	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)Lalim;
      //   1060: ifnull -202 -> 858
      //   1063: aload_0
      //   1064: getfield 25	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:this$0	Lcom/tencent/mobileqq/ptt/player/SilkPlayer;
      //   1067: invokestatic 276	com/tencent/mobileqq/ptt/player/SilkPlayer:a	(Lcom/tencent/mobileqq/ptt/player/SilkPlayer;)Lalim;
      //   1070: aload_0
      //   1071: getfield 56	com/tencent/mobileqq/ptt/player/SilkPlayer$SilkPlayerThread:fg	[B
      //   1074: invokeinterface 282 2 0
      //   1079: aload 7
      //   1081: astore 8
      //   1083: iload_2
      //   1084: istore_1
      //   1085: goto -227 -> 858
      //   1088: iload_1
      //   1089: iload_3
      //   1090: iadd
      //   1091: istore_1
      //   1092: aload 9
      //   1094: iload_3
      //   1095: i2l
      //   1096: invokevirtual 200	java/io/FileInputStream:skip	(J)J
      //   1099: pop2
      //   1100: aload 7
      //   1102: astore 8
      //   1104: goto -246 -> 858
      //   1107: astore 7
      //   1109: ldc 64
      //   1111: monitorexit
      //   1112: aload 7
      //   1114: athrow
      //   1115: astore 8
      //   1117: aload 8
      //   1119: invokevirtual 285	java/lang/Exception:printStackTrace	()V
      //   1122: goto -694 -> 428
      //   1125: astore 7
      //   1127: aload 7
      //   1129: invokevirtual 286	java/io/IOException:printStackTrace	()V
      //   1132: return
      //   1133: astore 8
      //   1135: aconst_null
      //   1136: astore 7
      //   1138: iconst_0
      //   1139: istore_1
      //   1140: goto -165 -> 975
      //   1143: astore 8
      //   1145: iconst_1
      //   1146: istore_1
      //   1147: aload 9
      //   1149: astore 7
      //   1151: goto -176 -> 975
      //   1154: iconst_0
      //   1155: istore_1
      //   1156: aload 9
      //   1158: astore 7
      //   1160: goto -775 -> 385
      //   1163: iconst_1
      //   1164: istore_1
      //   1165: aload 9
      //   1167: astore 7
      //   1169: goto -784 -> 385
      //   1172: aconst_null
      //   1173: astore 7
      //   1175: aconst_null
      //   1176: astore 10
      //   1178: goto -1103 -> 75
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1181	0	this	SilkPlayerThread
      //   106	1059	1	i	int
      //   244	840	2	j	int
      //   317	778	3	k	int
      //   616	10	4	m	int
      //   489	5	5	l	long
      //   73	1028	7	localObject1	Object
      //   1107	6	7	localObject2	Object
      //   1125	3	7	localIOException	java.io.IOException
      //   1136	38	7	localObject3	Object
      //   751	208	8	localObject4	Object
      //   967	31	8	localException1	java.lang.Exception
      //   1049	54	8	localObject5	Object
      //   1115	3	8	localException2	java.lang.Exception
      //   1133	1	8	localException3	java.lang.Exception
      //   1143	1	8	localException4	java.lang.Exception
      //   276	890	9	localFileInputStream	java.io.FileInputStream
      //   54	1123	10	localSonic	com.tencent.mobileqq.ptt.pttspeed.Sonic
      //   3	518	11	arrayOfByte	byte[]
      // Exception table:
      //   from	to	target	type
      //   282	291	967	java/lang/Exception
      //   296	303	967	java/lang/Exception
      //   308	318	967	java/lang/Exception
      //   491	499	967	java/lang/Exception
      //   504	511	967	java/lang/Exception
      //   520	526	967	java/lang/Exception
      //   530	569	967	java/lang/Exception
      //   578	585	967	java/lang/Exception
      //   594	618	967	java/lang/Exception
      //   628	667	967	java/lang/Exception
      //   676	683	967	java/lang/Exception
      //   692	714	967	java/lang/Exception
      //   718	740	967	java/lang/Exception
      //   755	775	967	java/lang/Exception
      //   780	786	967	java/lang/Exception
      //   790	801	967	java/lang/Exception
      //   801	807	967	java/lang/Exception
      //   821	835	967	java/lang/Exception
      //   835	856	967	java/lang/Exception
      //   858	861	967	java/lang/Exception
      //   915	926	967	java/lang/Exception
      //   932	958	967	java/lang/Exception
      //   1022	1027	967	java/lang/Exception
      //   1030	1047	967	java/lang/Exception
      //   1053	1079	967	java/lang/Exception
      //   1092	1100	967	java/lang/Exception
      //   1112	1115	967	java/lang/Exception
      //   861	906	1107	finally
      //   906	909	1107	finally
      //   1109	1112	1107	finally
      //   407	428	1115	java/lang/Exception
      //   456	461	1125	java/io/IOException
      //   10	75	1133	java/lang/Exception
      //   75	97	1133	java/lang/Exception
      //   97	202	1133	java/lang/Exception
      //   202	262	1133	java/lang/Exception
      //   262	278	1133	java/lang/Exception
      //   462	480	1133	java/lang/Exception
      //   327	379	1143	java/lang/Exception
    }
    
    public void start()
    {
      this.cxm = true;
      super.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.player.SilkPlayer
 * JD-Core Version:    0.7.0.1
 */