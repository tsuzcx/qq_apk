package com.tencent.mobileqq.activity.aio;

import ainb;
import alin;
import android.annotation.TargetApi;
import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.SystemClock;
import anpc;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.AudioHelper.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import wka;

public class AudioPlayer
  extends AudioPlayerBase
{
  AudioHelper.a[] a;
  private BroadcastReceiver aJ;
  private boolean bcZ;
  private boolean bda;
  private boolean bde = true;
  
  public AudioPlayer(Context paramContext, AudioPlayerBase.a parama)
  {
    super(paramContext, parama);
  }
  
  public static void an(float paramFloat)
  {
    HashMap localHashMap = new HashMap();
    if ((paramFloat >= 0.0F) && (paramFloat < 24.0F)) {
      localHashMap.put("errorCode", String.valueOf(0));
    }
    for (;;)
    {
      localHashMap.put("hour", String.valueOf(paramFloat));
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "pttPlayFileNotFind", true, 0L, 0L, localHashMap, "");
      return;
      if ((paramFloat >= 24.0F) && (paramFloat < 168.0F)) {
        localHashMap.put("errorCode", String.valueOf(1));
      } else if ((paramFloat >= 168.0F) && (paramFloat < 360.0F)) {
        localHashMap.put("errorCode", String.valueOf(2));
      } else if (paramFloat > 360.0F) {
        localHashMap.put("errorCode", String.valueOf(3));
      }
    }
  }
  
  private void b(AudioManager paramAudioManager)
  {
    paramAudioManager.setBluetoothScoOn(true);
  }
  
  private void bYB()
  {
    if (this.aJ != null) {
      if (QLog.isColorLevel()) {
        QLog.d("AudioPlayer_Old", 2, "unregister sco receiver:  " + SystemClock.uptimeMillis());
      }
    }
    try
    {
      this.application.unregisterReceiver(this.aJ);
      label51:
      this.aJ = null;
      return;
    }
    catch (Exception localException)
    {
      break label51;
    }
  }
  
  private void cv(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioPlayer_Old", 2, "tryStartBlueToothSco " + paramString);
    }
    bYB();
    paramString = new a(paramString, paramInt);
    this.application.registerReceiver(paramString, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
    this.aJ = paramString;
    this.audioManager.startBluetoothSco();
  }
  
  public static void n(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("issilk", String.valueOf(paramInt2));
    localHashMap.put("isSuccess", String.valueOf(paramInt1));
    localHashMap.put("errorCode", String.valueOf(paramInt3));
    localHashMap.put("errormsg", paramString);
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "pttplaysuc", true, 0L, 0L, localHashMap, "");
  }
  
  public void a(alin paramalin, int paramInt1, int paramInt2)
  {
    bYB();
    super.a(paramalin, paramInt1, paramInt2);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((!this.bcZ) && (!this.bda) && ((paramBoolean1 != this.bde) || (paramBoolean2)))
    {
      this.bde = paramBoolean1;
      ainb.a().Lg(paramBoolean1);
      if (isPlaying()) {
        Cf(paramInt);
      }
      return true;
    }
    return false;
  }
  
  public boolean ar(boolean paramBoolean)
  {
    return a(paramBoolean, false, 0);
  }
  
  public void bYF()
  {
    if ((this.bda) && (!this.audioManager.isBluetoothA2dpOn())) {
      this.bda = false;
    }
  }
  
  protected AudioHelper.a c()
  {
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$a == null) {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$a = AudioHelper.a();
    }
    if ((this.audioManager.isBluetoothScoOn()) && (bdf)) {
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$a[4];
    }
    if (this.bcZ) {
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$a[2];
    }
    if (this.bda) {
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$a[3];
    }
    AudioHelper.a[] arrayOfa = this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$a;
    if (this.bde) {}
    for (int i = 0;; i = 1) {
      return arrayOfa[i];
    }
  }
  
  @TargetApi(14)
  public void cu(String paramString, int paramInt)
  {
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (localBluetoothAdapter == null)
    {
      bNK = 0;
      play(paramString, paramInt);
      return;
    }
    if (!localBluetoothAdapter.isEnabled())
    {
      bNK = 0;
      play(paramString, paramInt);
      return;
    }
    if (localBluetoothAdapter.getProfileConnectionState(1) != 2)
    {
      bNK = 0;
      play(paramString, paramInt);
      return;
    }
    if (localBluetoothAdapter.getProfileConnectionState(2) == 2)
    {
      bNK = 0;
      play(paramString, paramInt);
      return;
    }
    paramString = new wka(this, paramString, paramInt, localBluetoothAdapter);
    localBluetoothAdapter.getProfileProxy(BaseApplication.getContext(), paramString, 1);
  }
  
  public void onCompletion()
  {
    bYB();
    super.onCompletion();
  }
  
  /* Error */
  public boolean play(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_3
    //   2: iconst_1
    //   3: istore 7
    //   5: iconst_1
    //   6: istore 9
    //   8: aload_0
    //   9: monitorenter
    //   10: iload_2
    //   11: istore 6
    //   13: iload_2
    //   14: ifge +6 -> 20
    //   17: iconst_0
    //   18: istore 6
    //   20: invokestatic 255	java/lang/System:currentTimeMillis	()J
    //   23: lstore 10
    //   25: aload_0
    //   26: aload_1
    //   27: putfield 259	com/tencent/mobileqq/activity/aio/AudioPlayer:sourcePath	Ljava/lang/String;
    //   30: aload_0
    //   31: invokestatic 265	com/tencent/mobileqq/app/ThreadManager:remove	(Ljava/lang/Runnable;)Z
    //   34: pop
    //   35: getstatic 226	com/tencent/mobileqq/activity/aio/AudioPlayer:bNK	I
    //   38: iconst_m1
    //   39: if_icmpne +19 -> 58
    //   42: aload_0
    //   43: aload_1
    //   44: iload 6
    //   46: invokevirtual 267	com/tencent/mobileqq/activity/aio/AudioPlayer:cu	(Ljava/lang/String;I)V
    //   49: iload 9
    //   51: istore 8
    //   53: aload_0
    //   54: monitorexit
    //   55: iload 8
    //   57: ireturn
    //   58: aload_0
    //   59: getfield 155	com/tencent/mobileqq/activity/aio/AudioPlayer:audioManager	Landroid/media/AudioManager;
    //   62: invokestatic 270	com/tencent/mobileqq/activity/aio/AudioPlayer:a	(Landroid/media/AudioManager;)Z
    //   65: ifeq +22 -> 87
    //   68: aload_0
    //   69: aload_1
    //   70: iload 6
    //   72: invokespecial 272	com/tencent/mobileqq/activity/aio/AudioPlayer:cv	(Ljava/lang/String;I)V
    //   75: iload 9
    //   77: istore 8
    //   79: goto -26 -> 53
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    //   87: aload_1
    //   88: invokestatic 278	aqhq:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   91: ifne +97 -> 188
    //   94: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +29 -> 126
    //   100: ldc 95
    //   102: iconst_2
    //   103: new 97	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   110: ldc_w 280
    //   113: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_1
    //   117: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: aload_0
    //   127: invokevirtual 283	com/tencent/mobileqq/activity/aio/AudioPlayer:stop	()V
    //   130: aload_0
    //   131: getfield 286	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayerBase$a	Lcom/tencent/mobileqq/activity/aio/AudioPlayerBase$a;
    //   134: ifnull +48 -> 182
    //   137: aload_0
    //   138: getfield 286	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayerBase$a	Lcom/tencent/mobileqq/activity/aio/AudioPlayerBase$a;
    //   141: aload_0
    //   142: iconst_m1
    //   143: invokeinterface 291 3 0
    //   148: iconst_0
    //   149: iconst_1
    //   150: iconst_1
    //   151: ldc_w 293
    //   154: invokestatic 295	com/tencent/mobileqq/activity/aio/AudioPlayer:n	(IIILjava/lang/String;)V
    //   157: aload_0
    //   158: getfield 299	com/tencent/mobileqq/activity/aio/AudioPlayer:mMsgTime	J
    //   161: lconst_0
    //   162: lcmp
    //   163: ifle +19 -> 182
    //   166: invokestatic 304	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   169: aload_0
    //   170: getfield 299	com/tencent/mobileqq/activity/aio/AudioPlayer:mMsgTime	J
    //   173: lsub
    //   174: l2f
    //   175: ldc_w 305
    //   178: fdiv
    //   179: invokestatic 307	com/tencent/mobileqq/activity/aio/AudioPlayer:an	(F)V
    //   182: iconst_0
    //   183: istore 8
    //   185: goto -132 -> 53
    //   188: aload_0
    //   189: invokevirtual 310	com/tencent/mobileqq/activity/aio/AudioPlayer:stopPlaying	()V
    //   192: new 312	java/io/FileInputStream
    //   195: dup
    //   196: aload_1
    //   197: invokespecial 313	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   200: astore 13
    //   202: aload 13
    //   204: astore 12
    //   206: aload 13
    //   208: invokestatic 318	aqlv:a	(Ljava/io/InputStream;)B
    //   211: istore 4
    //   213: aload 13
    //   215: astore 12
    //   217: iload 4
    //   219: istore_3
    //   220: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +47 -> 270
    //   226: aload 13
    //   228: astore 12
    //   230: iload 4
    //   232: istore_3
    //   233: ldc 95
    //   235: iconst_2
    //   236: new 97	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   243: ldc_w 320
    //   246: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_1
    //   250: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: ldc_w 322
    //   256: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: iload 4
    //   261: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   264: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   270: iload 4
    //   272: istore 5
    //   274: aload 13
    //   276: ifnull +12 -> 288
    //   279: aload 13
    //   281: invokevirtual 330	java/io/InputStream:close	()V
    //   284: iload 4
    //   286: istore 5
    //   288: iload 5
    //   290: iflt +282 -> 572
    //   293: aload_0
    //   294: new 332	com/tencent/mobileqq/ptt/player/SilkPlayer
    //   297: dup
    //   298: invokespecial 333	com/tencent/mobileqq/ptt/player/SilkPlayer:<init>	()V
    //   301: putfield 336	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Alin	Lalin;
    //   304: iconst_1
    //   305: istore_2
    //   306: iload_2
    //   307: invokestatic 341	aqjh:Xt	(I)V
    //   310: aload_0
    //   311: getfield 336	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Alin	Lalin;
    //   314: aload_1
    //   315: invokeinterface 346 2 0
    //   320: aload_0
    //   321: getfield 336	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Alin	Lalin;
    //   324: iload 6
    //   326: invokeinterface 349 2 0
    //   331: aload_0
    //   332: getfield 336	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Alin	Lalin;
    //   335: iconst_m1
    //   336: iload 5
    //   338: invokeinterface 352 3 0
    //   343: aload_0
    //   344: getfield 336	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Alin	Lalin;
    //   347: aload_0
    //   348: invokeinterface 355 2 0
    //   353: aload_0
    //   354: getfield 336	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Alin	Lalin;
    //   357: aload_0
    //   358: getfield 359	com/tencent/mobileqq/activity/aio/AudioPlayer:mPlaySpeed	F
    //   361: invokeinterface 362 2 0
    //   366: aload_0
    //   367: getfield 336	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Alin	Lalin;
    //   370: invokeinterface 365 1 0
    //   375: iload 9
    //   377: istore 8
    //   379: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   382: ifeq -329 -> 53
    //   385: ldc_w 367
    //   388: iconst_2
    //   389: new 97	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   396: ldc_w 369
    //   399: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokestatic 255	java/lang/System:currentTimeMillis	()J
    //   405: lload 10
    //   407: lsub
    //   408: invokevirtual 113	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   411: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: iload 9
    //   419: istore 8
    //   421: goto -368 -> 53
    //   424: astore 14
    //   426: aconst_null
    //   427: astore 13
    //   429: aload 13
    //   431: astore 12
    //   433: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   436: ifeq +37 -> 473
    //   439: aload 13
    //   441: astore 12
    //   443: ldc 95
    //   445: iconst_2
    //   446: new 97	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   453: ldc_w 371
    //   456: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: aload 14
    //   461: invokevirtual 374	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   464: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   470: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   473: iload_3
    //   474: istore 5
    //   476: aload 13
    //   478: ifnull -190 -> 288
    //   481: aload 13
    //   483: invokevirtual 330	java/io/InputStream:close	()V
    //   486: iload_3
    //   487: istore 5
    //   489: goto -201 -> 288
    //   492: astore 12
    //   494: iload_3
    //   495: istore 5
    //   497: goto -209 -> 288
    //   500: astore_1
    //   501: aconst_null
    //   502: astore 12
    //   504: aload 12
    //   506: ifnull +8 -> 514
    //   509: aload 12
    //   511: invokevirtual 330	java/io/InputStream:close	()V
    //   514: aload_1
    //   515: athrow
    //   516: astore_1
    //   517: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   520: ifeq +13 -> 533
    //   523: ldc 95
    //   525: iconst_2
    //   526: ldc_w 376
    //   529: aload_1
    //   530: invokestatic 379	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   533: aload_0
    //   534: getfield 336	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Alin	Lalin;
    //   537: instanceof 332
    //   540: ifeq +81 -> 621
    //   543: iload 7
    //   545: istore_2
    //   546: iconst_0
    //   547: iload_2
    //   548: iconst_2
    //   549: aload_1
    //   550: invokevirtual 380	java/lang/Exception:toString	()Ljava/lang/String;
    //   553: invokestatic 295	com/tencent/mobileqq/activity/aio/AudioPlayer:n	(IIILjava/lang/String;)V
    //   556: aload_0
    //   557: aload_0
    //   558: getfield 336	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Alin	Lalin;
    //   561: iconst_0
    //   562: iconst_0
    //   563: invokevirtual 381	com/tencent/mobileqq/activity/aio/AudioPlayer:a	(Lalin;II)V
    //   566: iconst_0
    //   567: istore 8
    //   569: goto -516 -> 53
    //   572: aload_0
    //   573: new 383	com/tencent/mobileqq/ptt/player/AmrPlayer
    //   576: dup
    //   577: invokespecial 384	com/tencent/mobileqq/ptt/player/AmrPlayer:<init>	()V
    //   580: putfield 336	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Alin	Lalin;
    //   583: ldc 95
    //   585: iconst_1
    //   586: new 97	java/lang/StringBuilder
    //   589: dup
    //   590: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   593: ldc_w 386
    //   596: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: iload 5
    //   601: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   604: ldc_w 388
    //   607: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: invokestatic 391	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   616: iconst_2
    //   617: istore_2
    //   618: goto -312 -> 306
    //   621: iconst_0
    //   622: istore_2
    //   623: goto -77 -> 546
    //   626: astore 12
    //   628: iload 4
    //   630: istore 5
    //   632: goto -344 -> 288
    //   635: astore 12
    //   637: goto -123 -> 514
    //   640: astore_1
    //   641: goto -137 -> 504
    //   644: astore 14
    //   646: goto -217 -> 429
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	649	0	this	AudioPlayer
    //   0	649	1	paramString	String
    //   0	649	2	paramInt	int
    //   1	494	3	b1	byte
    //   211	418	4	b2	byte
    //   272	359	5	b3	byte
    //   11	314	6	i	int
    //   3	541	7	j	int
    //   51	517	8	bool1	boolean
    //   6	412	9	bool2	boolean
    //   23	383	10	l	long
    //   204	238	12	localFileInputStream1	java.io.FileInputStream
    //   492	1	12	localException1	Exception
    //   502	8	12	localObject	java.lang.Object
    //   626	1	12	localException2	Exception
    //   635	1	12	localException3	Exception
    //   200	282	13	localFileInputStream2	java.io.FileInputStream
    //   424	36	14	localException4	Exception
    //   644	1	14	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   20	49	82	finally
    //   58	75	82	finally
    //   87	126	82	finally
    //   126	182	82	finally
    //   188	192	82	finally
    //   279	284	82	finally
    //   293	304	82	finally
    //   306	375	82	finally
    //   379	417	82	finally
    //   481	486	82	finally
    //   509	514	82	finally
    //   514	516	82	finally
    //   517	533	82	finally
    //   533	543	82	finally
    //   546	566	82	finally
    //   572	616	82	finally
    //   192	202	424	java/lang/Exception
    //   481	486	492	java/lang/Exception
    //   192	202	500	finally
    //   188	192	516	java/lang/Exception
    //   293	304	516	java/lang/Exception
    //   306	375	516	java/lang/Exception
    //   514	516	516	java/lang/Exception
    //   572	616	516	java/lang/Exception
    //   279	284	626	java/lang/Exception
    //   509	514	635	java/lang/Exception
    //   206	213	640	finally
    //   220	226	640	finally
    //   233	270	640	finally
    //   433	439	640	finally
    //   443	473	640	finally
    //   206	213	644	java/lang/Exception
    //   220	226	644	java/lang/Exception
    //   233	270	644	java/lang/Exception
  }
  
  public void yt(boolean paramBoolean)
  {
    this.bcZ = paramBoolean;
    if (isPlaying()) {
      Cf(this.jdField_a_of_type_Alin.getCurrentPosition() - MediaPlayerManager.bNM);
    }
  }
  
  public void yu(boolean paramBoolean)
  {
    this.bda = paramBoolean;
    if (isPlaying()) {
      Cf(this.jdField_a_of_type_Alin.getCurrentPosition() - MediaPlayerManager.bNM);
    }
  }
  
  class a
    extends BroadcastReceiver
  {
    long HL = 0L;
    boolean bcS = false;
    long lj = 0L;
    int offset;
    String sourcePath;
    
    a(String paramString, int paramInt)
    {
      this.sourcePath = paramString;
      this.offset = paramInt;
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      long l = SystemClock.uptimeMillis();
      int i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
      if (QLog.isColorLevel()) {
        QLog.d("AudioPlayer_Old", 2, "onReceive ACTION_SCO_AUDIO_STATE_UPDATED = " + i + " " + this.sourcePath + ", time=" + l);
      }
      if (1 == i) {
        if (this.lj == 0L)
        {
          this.lj = l;
          AudioPlayer.a(AudioPlayer.this, AudioPlayer.this.audioManager);
          AudioPlayerBase.bdh = true;
          if (!AudioPlayer.this.isPlaying()) {
            AudioPlayer.this.play(this.sourcePath, this.offset);
          }
        }
      }
      do
      {
        do
        {
          return;
          if (2 == i)
          {
            this.bcS = true;
            return;
          }
        } while (i != 0);
        if (this.HL == 0L)
        {
          this.HL = l;
          return;
        }
        if (this.bcS) {
          AudioPlayer.this.bYJ();
        }
        if (((this.lj != 0L) && (l - this.lj <= 2000L)) || (l - this.HL <= 1000L))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AudioPlayer_Old", 2, "sco disconnected quickly.");
          }
          AudioPlayerBase.bdg = true;
          if ((AudioPlayer.a(AudioPlayer.this)) && (!AudioPlayer.this.audioManager.isBluetoothA2dpOn())) {
            AudioPlayer.a(AudioPlayer.this, false);
          }
          if (!AudioPlayer.this.isPlaying())
          {
            AudioPlayer.this.play(this.sourcePath, this.offset);
            return;
          }
          AudioPlayer.this.Cf(0);
          return;
        }
      } while (!AudioPlayer.this.isPlaying());
      AudioPlayer.this.Cf(AudioPlayer.this.a.getCurrentPosition());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AudioPlayer
 * JD-Core Version:    0.7.0.1
 */