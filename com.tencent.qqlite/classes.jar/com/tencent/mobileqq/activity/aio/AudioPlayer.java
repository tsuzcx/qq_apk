package com.tencent.mobileqq.activity.aio;

import android.app.Application;
import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import bss;
import com.tencent.mobileqq.ptt.player.IPttPlayer;
import com.tencent.mobileqq.ptt.player.IPttPlayerListener;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.AudioHelper.AudioPlayerParameter;
import com.tencent.mobileqq.utils.AudioUtil;

public class AudioPlayer
  implements IPttPlayerListener
{
  private static final float jdField_a_of_type_Float = 0.1F;
  public static final int a = -1;
  private static final long jdField_a_of_type_Long = 200L;
  public static final String a;
  public static final int b = -2;
  public static final int c = -3;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 0;
  public static final int g = 1;
  private static final int i = 1000;
  private static final int j = 1000;
  private Application jdField_a_of_type_AndroidAppApplication;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private Handler jdField_a_of_type_AndroidOsHandler = new bss(this);
  private AudioPlayer.AudioPlayerListener jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener;
  private IPttPlayer jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer;
  private volatile AudioHelper.AudioPlayerParameter jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter;
  private boolean jdField_a_of_type_Boolean = false;
  AudioHelper.AudioPlayerParameter[] jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = true;
  private volatile int h;
  
  static
  {
    jdField_a_of_type_JavaLangString = AudioPlayer.class.getSimpleName();
  }
  
  public AudioPlayer(Context paramContext, AudioPlayer.AudioPlayerListener paramAudioPlayerListener)
  {
    this.jdField_a_of_type_AndroidAppApplication = ((Application)paramContext.getApplicationContext());
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidAppApplication.getSystemService("audio"));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener = paramAudioPlayerListener;
  }
  
  private AudioHelper.AudioPlayerParameter a()
  {
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter == null) {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter = AudioHelper.a();
    }
    if (this.jdField_b_of_type_Boolean) {
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[3];
    }
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[2];
    }
    AudioHelper.AudioPlayerParameter[] arrayOfAudioPlayerParameter = this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter;
    if (this.c) {}
    for (int k = 0;; k = 1) {
      return arrayOfAudioPlayerParameter[k];
    }
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_b_of_type_JavaLangString != null) {
      a(this.jdField_b_of_type_JavaLangString, paramInt);
    }
  }
  
  /* Error */
  private boolean a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_3
    //   2: iconst_0
    //   3: istore 6
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: aload_1
    //   9: putfield 109	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   12: aload_1
    //   13: invokestatic 121	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   16: ifne +99 -> 115
    //   19: new 114	java/io/FileNotFoundException
    //   22: dup
    //   23: new 123	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   30: ldc 126
    //   32: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokespecial 136	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   45: athrow
    //   46: astore 7
    //   48: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   51: ifeq +29 -> 80
    //   54: getstatic 48	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   57: iconst_2
    //   58: new 123	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   65: ldc 144
    //   67: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_1
    //   71: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: aload_0
    //   81: invokevirtual 149	com/tencent/mobileqq/activity/aio/AudioPlayer:c	()V
    //   84: iload 6
    //   86: istore 5
    //   88: aload_0
    //   89: getfield 88	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener	Lcom/tencent/mobileqq/activity/aio/AudioPlayer$AudioPlayerListener;
    //   92: ifnull +18 -> 110
    //   95: aload_0
    //   96: getfield 88	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener	Lcom/tencent/mobileqq/activity/aio/AudioPlayer$AudioPlayerListener;
    //   99: aload_0
    //   100: iconst_m1
    //   101: invokeinterface 154 3 0
    //   106: iload 6
    //   108: istore 5
    //   110: aload_0
    //   111: monitorexit
    //   112: iload 5
    //   114: ireturn
    //   115: aload_0
    //   116: invokespecial 156	com/tencent/mobileqq/activity/aio/AudioPlayer:d	()V
    //   119: new 158	java/io/FileInputStream
    //   122: dup
    //   123: aload_1
    //   124: invokespecial 159	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   127: astore 8
    //   129: aload 8
    //   131: astore 7
    //   133: aload 8
    //   135: invokestatic 164	com/tencent/mobileqq/utils/RecordParams:a	(Ljava/io/InputStream;)B
    //   138: istore 4
    //   140: aload 8
    //   142: astore 7
    //   144: iload 4
    //   146: istore_3
    //   147: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +46 -> 196
    //   153: aload 8
    //   155: astore 7
    //   157: iload 4
    //   159: istore_3
    //   160: getstatic 48	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   163: iconst_2
    //   164: new 123	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   171: ldc 166
    //   173: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_1
    //   177: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc 168
    //   182: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: iload 4
    //   187: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   190: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aload 8
    //   198: invokevirtual 176	java/io/InputStream:close	()V
    //   201: iload 4
    //   203: istore_3
    //   204: iload_3
    //   205: iflt +181 -> 386
    //   208: aload_0
    //   209: new 178	com/tencent/mobileqq/ptt/player/SilkPlayer
    //   212: dup
    //   213: invokespecial 179	com/tencent/mobileqq/ptt/player/SilkPlayer:<init>	()V
    //   216: putfield 181	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer	Lcom/tencent/mobileqq/ptt/player/IPttPlayer;
    //   219: aload_0
    //   220: getfield 181	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer	Lcom/tencent/mobileqq/ptt/player/IPttPlayer;
    //   223: aload_1
    //   224: invokeinterface 185 2 0
    //   229: aload_0
    //   230: getfield 181	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer	Lcom/tencent/mobileqq/ptt/player/IPttPlayer;
    //   233: iload_2
    //   234: invokeinterface 187 2 0
    //   239: aload_0
    //   240: getfield 181	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer	Lcom/tencent/mobileqq/ptt/player/IPttPlayer;
    //   243: iconst_m1
    //   244: iload_3
    //   245: invokeinterface 190 3 0
    //   250: aload_0
    //   251: getfield 181	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer	Lcom/tencent/mobileqq/ptt/player/IPttPlayer;
    //   254: aload_0
    //   255: invokeinterface 193 2 0
    //   260: aload_0
    //   261: getfield 181	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer	Lcom/tencent/mobileqq/ptt/player/IPttPlayer;
    //   264: invokeinterface 195 1 0
    //   269: iconst_1
    //   270: istore 5
    //   272: goto -162 -> 110
    //   275: astore 9
    //   277: aconst_null
    //   278: astore 8
    //   280: aload 8
    //   282: astore 7
    //   284: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   287: ifeq +37 -> 324
    //   290: aload 8
    //   292: astore 7
    //   294: getstatic 48	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   297: iconst_2
    //   298: new 123	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   305: ldc 197
    //   307: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload 9
    //   312: invokevirtual 200	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   315: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: aload 8
    //   326: invokevirtual 176	java/io/InputStream:close	()V
    //   329: goto -125 -> 204
    //   332: astore 7
    //   334: goto -130 -> 204
    //   337: astore 8
    //   339: aconst_null
    //   340: astore 7
    //   342: aload 7
    //   344: invokevirtual 176	java/io/InputStream:close	()V
    //   347: aload 8
    //   349: athrow
    //   350: astore_1
    //   351: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   354: ifeq +13 -> 367
    //   357: getstatic 48	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   360: iconst_2
    //   361: ldc 202
    //   363: aload_1
    //   364: invokestatic 205	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   367: aload_0
    //   368: aconst_null
    //   369: iconst_0
    //   370: iconst_0
    //   371: invokevirtual 208	com/tencent/mobileqq/activity/aio/AudioPlayer:a	(Lcom/tencent/mobileqq/ptt/player/IPttPlayer;II)V
    //   374: iload 6
    //   376: istore 5
    //   378: goto -268 -> 110
    //   381: astore_1
    //   382: aload_0
    //   383: monitorexit
    //   384: aload_1
    //   385: athrow
    //   386: aload_0
    //   387: new 210	com/tencent/mobileqq/ptt/player/AmrPlayer
    //   390: dup
    //   391: invokespecial 211	com/tencent/mobileqq/ptt/player/AmrPlayer:<init>	()V
    //   394: putfield 181	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer	Lcom/tencent/mobileqq/ptt/player/IPttPlayer;
    //   397: goto -178 -> 219
    //   400: astore 7
    //   402: iload 4
    //   404: istore_3
    //   405: goto -201 -> 204
    //   408: astore 7
    //   410: goto -63 -> 347
    //   413: astore 8
    //   415: goto -73 -> 342
    //   418: astore 9
    //   420: goto -140 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	423	0	this	AudioPlayer
    //   0	423	1	paramString	String
    //   0	423	2	paramInt	int
    //   1	404	3	b1	byte
    //   138	265	4	b2	byte
    //   86	291	5	bool1	boolean
    //   3	372	6	bool2	boolean
    //   46	1	7	localFileNotFoundException	java.io.FileNotFoundException
    //   131	162	7	localObject1	Object
    //   332	1	7	localException1	java.lang.Exception
    //   340	3	7	localObject2	Object
    //   400	1	7	localException2	java.lang.Exception
    //   408	1	7	localException3	java.lang.Exception
    //   127	198	8	localFileInputStream	java.io.FileInputStream
    //   337	11	8	localObject3	Object
    //   413	1	8	localObject4	Object
    //   275	36	9	localException4	java.lang.Exception
    //   418	1	9	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   12	46	46	java/io/FileNotFoundException
    //   115	119	46	java/io/FileNotFoundException
    //   196	201	46	java/io/FileNotFoundException
    //   208	219	46	java/io/FileNotFoundException
    //   219	269	46	java/io/FileNotFoundException
    //   324	329	46	java/io/FileNotFoundException
    //   342	347	46	java/io/FileNotFoundException
    //   347	350	46	java/io/FileNotFoundException
    //   386	397	46	java/io/FileNotFoundException
    //   119	129	275	java/lang/Exception
    //   324	329	332	java/lang/Exception
    //   119	129	337	finally
    //   12	46	350	java/lang/Exception
    //   115	119	350	java/lang/Exception
    //   208	219	350	java/lang/Exception
    //   219	269	350	java/lang/Exception
    //   347	350	350	java/lang/Exception
    //   386	397	350	java/lang/Exception
    //   7	12	381	finally
    //   12	46	381	finally
    //   48	80	381	finally
    //   80	84	381	finally
    //   88	106	381	finally
    //   115	119	381	finally
    //   196	201	381	finally
    //   208	219	381	finally
    //   219	269	381	finally
    //   324	329	381	finally
    //   342	347	381	finally
    //   347	350	381	finally
    //   351	367	381	finally
    //   367	374	381	finally
    //   386	397	381	finally
    //   196	201	400	java/lang/Exception
    //   342	347	408	java/lang/Exception
    //   133	140	413	finally
    //   147	153	413	finally
    //   160	196	413	finally
    //   284	290	413	finally
    //   294	324	413	finally
    //   133	140	418	java/lang/Exception
    //   147	153	418	java/lang/Exception
    //   160	196	418	java/lang/Exception
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.a()) {
        this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.c();
      this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.d();
      this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer = null;
    }
  }
  
  public void a()
  {
    c();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener.a(this);
    }
  }
  
  public void a(IPttPlayer paramIPttPlayer, int paramInt1, int paramInt2)
  {
    c();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener.a(this, -2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (a()) {
      a(this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.a());
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.a());
  }
  
  public boolean a(String paramString)
  {
    return a(paramString, 0);
  }
  
  public boolean a(boolean paramBoolean)
  {
    return a(paramBoolean, false);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool1 = bool2;
      if (!this.jdField_b_of_type_Boolean) {
        if (paramBoolean1 == this.c)
        {
          bool1 = bool2;
          if (!paramBoolean2) {}
        }
        else
        {
          this.c = paramBoolean1;
          if (a()) {
            a(0);
          }
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter = a();
    this.jdField_a_of_type_AndroidMediaAudioManager.setMode(this.jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidMediaAudioManager.setSpeakerphoneOn(this.jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener.b(this, this.jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter.b);
    }
    AudioUtil.a(this.jdField_a_of_type_AndroidAppApplication, true);
    this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.a(this.jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter.b);
    this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.f();
    int k = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(this.jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter.b);
    int m = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamMaxVolume(this.jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter.b);
    if (k / m < 0.1F)
    {
      this.h = 0;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 200L);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener.c(this, this.h);
      }
      PttInfoCollector.a(this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.b(), this.jdField_b_of_type_JavaLangString);
      return;
      this.h = 1;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (a()) {
      a(this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.a());
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_AndroidMediaAudioManager.isSpeakerphoneOn();
  }
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
      if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.a()) {
          this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.b();
        }
        this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.d();
        this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer = null;
        this.jdField_b_of_type_JavaLangString = null;
        AudioUtil.a(this.jdField_a_of_type_AndroidAppApplication, false);
        this.jdField_a_of_type_AndroidMediaAudioManager.setMode(0);
        this.jdField_a_of_type_AndroidMediaAudioManager.setSpeakerphoneOn(false);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AudioPlayer
 * JD-Core Version:    0.7.0.1
 */