package com.tencent.mobileqq.activity.aio;

import alin;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import aqmr;
import com.tencent.mobileqq.utils.AudioHelper.a;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import wjx;
import wjz;
import wjz.a;

public class CommonAudioPlayer
  extends AudioPlayerBase
  implements AudioDeviceManager.a
{
  private a jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer$a;
  private wjz jdField_a_of_type_Wjz;
  private String aSH;
  private wjx b;
  volatile boolean bdL = false;
  
  public CommonAudioPlayer(Context paramContext, AudioPlayerBase.a parama)
  {
    super(paramContext, parama);
  }
  
  private void a(wjz.a parama)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (parama == null) {}
    Object localObject;
    do
    {
      return;
      localObject = "CommonAudioPlayer.notifyUIDeviceStatusChanged getDeviceStatusType = " + parama.vL();
      this.jdField_a_of_type_Wjz.xj((String)localObject);
      switch (parama.vL())
      {
      default: 
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer$a == null);
    bool1 = this.jdField_a_of_type_Wjz.Re();
    boolean bool3 = this.jdField_a_of_type_Wjz.Rh();
    if (bool3) {
      bool1 = bool2;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer$a.g(bool3, bool1);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer$a == null) {
        break;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer$a;
      bool2 = this.jdField_a_of_type_Wjz.Rf();
      bool3 = this.jdField_a_of_type_Wjz.Rg();
      boolean bool4 = this.jdField_a_of_type_Wjz.Re();
      if (parama.vL() == 2) {
        bool1 = true;
      }
      ((a)localObject).d(bool2, bool3, bool4, bool1);
      return;
    }
  }
  
  private void bYZ()
  {
    String str = this.aSH;
    if (aqmr.isEmpty(str)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setPackage(this.application.getPackageName());
    localIntent.setAction("mqq.audiosenormanager.audio.start");
    localIntent.putExtra("audiosenormanager.playkey", str);
    this.application.getApplicationContext().sendBroadcast(localIntent);
  }
  
  private void bZa()
  {
    String str = this.aSH;
    if (aqmr.isEmpty(str)) {
      return;
    }
    this.aSH = null;
    Intent localIntent = new Intent();
    localIntent.setPackage(this.application.getPackageName());
    localIntent.setAction("mqq.audiosenormanager.audio.end");
    localIntent.putExtra("audiosenormanager.playkey", str);
    this.application.getApplicationContext().sendBroadcast(localIntent);
  }
  
  protected void Cf(int paramInt)
  {
    if (this.sourcePath != null) {
      this.bdL = true;
    }
    super.Cf(paramInt);
  }
  
  public void a(alin paramalin, int paramInt1, int paramInt2)
  {
    this.b.bYB();
    super.a(paramalin, paramInt1, paramInt2);
    this.bdL = false;
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer$a = parama;
  }
  
  public void aM(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Wjz.a(paramInt, paramBoolean);
      wjz.a locala = this.jdField_a_of_type_Wjz.a();
      if (locala != null)
      {
        boolean bool = isPlaying();
        if (QLog.isColorLevel()) {
          QLog.d("AudioPlayer_Common", 2, "before notifyUIDeviceStatusChanged status = " + locala.bNJ + " | isPlaying = " + bool);
        }
        if (bool)
        {
          if (locala.Ri())
          {
            locala.bYE();
            Cf(this.jdField_a_of_type_Alin.getCurrentPosition() - MediaPlayerManager.bNM);
          }
          a(locala);
        }
      }
      switch (paramInt)
      {
      }
      break;
    }
    do
    {
      do
      {
        return;
        aY(paramBoolean, false);
        break;
        aY(paramBoolean, true);
        break;
      } while (paramBoolean);
      bYJ();
      return;
    } while (!paramBoolean);
    bYJ();
  }
  
  public void bYF()
  {
    this.jdField_a_of_type_Wjz.a(this.audioManager);
  }
  
  public void bYG()
    throws IOException
  {
    super.bYG();
    this.bdL = false;
  }
  
  public void bYH()
  {
    this.jdField_a_of_type_Wjz.ys(true);
  }
  
  public void bYI()
  {
    this.jdField_a_of_type_Wjz.ys(false);
  }
  
  protected AudioHelper.a c()
  {
    return this.jdField_a_of_type_Wjz.a();
  }
  
  public void doOnDestory()
  {
    super.doOnDestory();
    this.b.bYB();
  }
  
  public void init()
  {
    this.jdField_a_of_type_Wjz = new wjz();
    this.b = new wjx(this.application);
    this.b.b(this);
    this.jdField_a_of_type_Wjz.init();
  }
  
  public boolean isPlaying()
  {
    return (super.isPlaying()) || (this.bdL);
  }
  
  public void onCompletion()
  {
    this.b.bYB();
    super.onCompletion();
    this.bdL = false;
  }
  
  /* Error */
  protected boolean play(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_3
    //   2: iconst_1
    //   3: istore 7
    //   5: iload_2
    //   6: istore 6
    //   8: iload_2
    //   9: ifge +6 -> 15
    //   12: iconst_0
    //   13: istore 6
    //   15: invokestatic 258	java/lang/System:currentTimeMillis	()J
    //   18: lstore 8
    //   20: aload_0
    //   21: aload_1
    //   22: putfield 134	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:sourcePath	Ljava/lang/String;
    //   25: aload_0
    //   26: invokestatic 264	com/tencent/mobileqq/app/ThreadManager:remove	(Ljava/lang/Runnable;)Z
    //   29: pop
    //   30: aload_0
    //   31: getfield 51	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Wjz	Lwjz;
    //   34: invokevirtual 267	wjz:bYC	()V
    //   37: aload_0
    //   38: getfield 139	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:b	Lwjx;
    //   41: aload_1
    //   42: iload 6
    //   44: invokevirtual 271	wjx:Q	(Ljava/lang/String;I)I
    //   47: istore_2
    //   48: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   51: ifeq +29 -> 80
    //   54: ldc 165
    //   56: iconst_2
    //   57: new 27	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   64: ldc_w 273
    //   67: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: iload_2
    //   71: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   74: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: iload_2
    //   81: ifne +10 -> 91
    //   84: aload_0
    //   85: iconst_0
    //   86: putfield 23	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:bdL	Z
    //   89: iconst_0
    //   90: ireturn
    //   91: iload_2
    //   92: iconst_2
    //   93: if_icmpne +10 -> 103
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 23	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:bdL	Z
    //   101: iconst_1
    //   102: ireturn
    //   103: aload_0
    //   104: getfield 212	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:audioManager	Landroid/media/AudioManager;
    //   107: invokestatic 278	com/tencent/mobileqq/activity/aio/AudioPlayer:a	(Landroid/media/AudioManager;)Z
    //   110: ifeq +69 -> 179
    //   113: aload_0
    //   114: getfield 139	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:b	Lwjx;
    //   117: aload_1
    //   118: iload 6
    //   120: invokevirtual 281	wjx:R	(Ljava/lang/String;I)I
    //   123: istore_2
    //   124: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +29 -> 156
    //   130: ldc 165
    //   132: iconst_2
    //   133: new 27	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   140: ldc_w 283
    //   143: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: iload_2
    //   147: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   150: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: iload_2
    //   157: ifne +10 -> 167
    //   160: aload_0
    //   161: iconst_0
    //   162: putfield 23	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:bdL	Z
    //   165: iconst_0
    //   166: ireturn
    //   167: iload_2
    //   168: iconst_2
    //   169: if_icmpne +10 -> 179
    //   172: aload_0
    //   173: iconst_0
    //   174: putfield 23	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:bdL	Z
    //   177: iconst_1
    //   178: ireturn
    //   179: aload_1
    //   180: invokestatic 288	aqhq:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   183: ifne +93 -> 276
    //   186: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq +29 -> 218
    //   192: ldc 165
    //   194: iconst_2
    //   195: new 27	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   202: ldc_w 290
    //   205: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_1
    //   209: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: aload_0
    //   219: invokevirtual 293	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:stop	()V
    //   222: aload_0
    //   223: getfield 296	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayerBase$a	Lcom/tencent/mobileqq/activity/aio/AudioPlayerBase$a;
    //   226: ifnull -137 -> 89
    //   229: aload_0
    //   230: getfield 296	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayerBase$a	Lcom/tencent/mobileqq/activity/aio/AudioPlayerBase$a;
    //   233: aload_0
    //   234: iconst_m1
    //   235: invokeinterface 301 3 0
    //   240: iconst_0
    //   241: iconst_1
    //   242: iconst_1
    //   243: ldc_w 303
    //   246: invokestatic 307	com/tencent/mobileqq/activity/aio/AudioPlayer:n	(IIILjava/lang/String;)V
    //   249: aload_0
    //   250: getfield 311	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:mMsgTime	J
    //   253: lconst_0
    //   254: lcmp
    //   255: ifle -166 -> 89
    //   258: invokestatic 316	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   261: aload_0
    //   262: getfield 311	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:mMsgTime	J
    //   265: lsub
    //   266: l2f
    //   267: ldc_w 317
    //   270: fdiv
    //   271: invokestatic 321	com/tencent/mobileqq/activity/aio/AudioPlayer:an	(F)V
    //   274: iconst_0
    //   275: ireturn
    //   276: aload_0
    //   277: new 27	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   284: aload_1
    //   285: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: lload 8
    //   290: invokevirtual 324	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   293: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: putfield 83	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:aSH	Ljava/lang/String;
    //   299: aload_0
    //   300: invokevirtual 327	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:stopPlaying	()V
    //   303: new 329	java/io/FileInputStream
    //   306: dup
    //   307: aload_1
    //   308: invokespecial 331	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   311: astore 11
    //   313: aload 11
    //   315: astore 10
    //   317: aload 11
    //   319: invokestatic 336	aqlv:a	(Ljava/io/InputStream;)B
    //   322: istore 4
    //   324: aload 11
    //   326: astore 10
    //   328: iload 4
    //   330: istore_3
    //   331: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   334: ifeq +47 -> 381
    //   337: aload 11
    //   339: astore 10
    //   341: iload 4
    //   343: istore_3
    //   344: ldc 165
    //   346: iconst_2
    //   347: new 27	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   354: ldc_w 338
    //   357: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload_1
    //   361: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: ldc_w 340
    //   367: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: iload 4
    //   372: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   375: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   381: iload 4
    //   383: istore 5
    //   385: aload 11
    //   387: ifnull +12 -> 399
    //   390: aload 11
    //   392: invokevirtual 345	java/io/InputStream:close	()V
    //   395: iload 4
    //   397: istore 5
    //   399: iload 5
    //   401: iflt +272 -> 673
    //   404: aload_0
    //   405: new 347	com/tencent/mobileqq/ptt/player/SilkPlayer
    //   408: dup
    //   409: invokespecial 348	com/tencent/mobileqq/ptt/player/SilkPlayer:<init>	()V
    //   412: putfield 188	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Alin	Lalin;
    //   415: iconst_1
    //   416: istore_2
    //   417: iload_2
    //   418: invokestatic 353	aqjh:Xt	(I)V
    //   421: aload_0
    //   422: getfield 188	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Alin	Lalin;
    //   425: aload_1
    //   426: invokeinterface 356 2 0
    //   431: aload_0
    //   432: getfield 188	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Alin	Lalin;
    //   435: iload 6
    //   437: invokeinterface 359 2 0
    //   442: aload_0
    //   443: getfield 188	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Alin	Lalin;
    //   446: iconst_m1
    //   447: iload 5
    //   449: invokeinterface 362 3 0
    //   454: aload_0
    //   455: getfield 188	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Alin	Lalin;
    //   458: aload_0
    //   459: invokeinterface 365 2 0
    //   464: aload_0
    //   465: getfield 188	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Alin	Lalin;
    //   468: aload_0
    //   469: getfield 369	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:mPlaySpeed	F
    //   472: invokeinterface 372 2 0
    //   477: aload_0
    //   478: getfield 188	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Alin	Lalin;
    //   481: invokeinterface 375 1 0
    //   486: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   489: ifeq +34 -> 523
    //   492: ldc 165
    //   494: iconst_2
    //   495: new 27	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   502: ldc_w 377
    //   505: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: invokestatic 258	java/lang/System:currentTimeMillis	()J
    //   511: lload 8
    //   513: lsub
    //   514: invokevirtual 324	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   517: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   523: aload_0
    //   524: invokespecial 379	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:bYZ	()V
    //   527: iconst_1
    //   528: ireturn
    //   529: astore 12
    //   531: aconst_null
    //   532: astore 11
    //   534: aload 11
    //   536: astore 10
    //   538: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   541: ifeq +37 -> 578
    //   544: aload 11
    //   546: astore 10
    //   548: ldc 165
    //   550: iconst_2
    //   551: new 27	java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   558: ldc_w 381
    //   561: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: aload 12
    //   566: invokevirtual 384	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   569: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   575: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   578: iload_3
    //   579: istore 5
    //   581: aload 11
    //   583: ifnull -184 -> 399
    //   586: aload 11
    //   588: invokevirtual 345	java/io/InputStream:close	()V
    //   591: iload_3
    //   592: istore 5
    //   594: goto -195 -> 399
    //   597: astore 10
    //   599: iload_3
    //   600: istore 5
    //   602: goto -203 -> 399
    //   605: astore_1
    //   606: aconst_null
    //   607: astore 10
    //   609: aload 10
    //   611: ifnull +8 -> 619
    //   614: aload 10
    //   616: invokevirtual 345	java/io/InputStream:close	()V
    //   619: aload_1
    //   620: athrow
    //   621: astore_1
    //   622: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   625: ifeq +13 -> 638
    //   628: ldc 165
    //   630: iconst_2
    //   631: ldc_w 386
    //   634: aload_1
    //   635: invokestatic 389	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   638: aload_0
    //   639: getfield 188	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Alin	Lalin;
    //   642: instanceof 347
    //   645: ifeq +77 -> 722
    //   648: iload 7
    //   650: istore_2
    //   651: iconst_0
    //   652: iload_2
    //   653: iconst_2
    //   654: aload_1
    //   655: invokevirtual 390	java/lang/Exception:toString	()Ljava/lang/String;
    //   658: invokestatic 307	com/tencent/mobileqq/activity/aio/AudioPlayer:n	(IIILjava/lang/String;)V
    //   661: aload_0
    //   662: aload_0
    //   663: getfield 188	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Alin	Lalin;
    //   666: iconst_0
    //   667: iconst_0
    //   668: invokevirtual 391	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:a	(Lalin;II)V
    //   671: iconst_0
    //   672: ireturn
    //   673: aload_0
    //   674: new 393	com/tencent/mobileqq/ptt/player/AmrPlayer
    //   677: dup
    //   678: invokespecial 394	com/tencent/mobileqq/ptt/player/AmrPlayer:<init>	()V
    //   681: putfield 188	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Alin	Lalin;
    //   684: ldc 165
    //   686: iconst_1
    //   687: new 27	java/lang/StringBuilder
    //   690: dup
    //   691: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   694: ldc_w 396
    //   697: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: iload 5
    //   702: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   705: ldc_w 398
    //   708: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   714: invokestatic 401	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   717: iconst_2
    //   718: istore_2
    //   719: goto -302 -> 417
    //   722: iconst_0
    //   723: istore_2
    //   724: goto -73 -> 651
    //   727: astore 10
    //   729: iload 4
    //   731: istore 5
    //   733: goto -334 -> 399
    //   736: astore 10
    //   738: goto -119 -> 619
    //   741: astore_1
    //   742: goto -133 -> 609
    //   745: astore 12
    //   747: goto -213 -> 534
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	750	0	this	CommonAudioPlayer
    //   0	750	1	paramString	String
    //   0	750	2	paramInt	int
    //   1	599	3	b1	byte
    //   322	408	4	b2	byte
    //   383	349	5	b3	byte
    //   6	430	6	i	int
    //   3	646	7	j	int
    //   18	494	8	l	long
    //   315	232	10	localFileInputStream1	java.io.FileInputStream
    //   597	1	10	localException1	java.lang.Exception
    //   607	8	10	localObject	Object
    //   727	1	10	localException2	java.lang.Exception
    //   736	1	10	localException3	java.lang.Exception
    //   311	276	11	localFileInputStream2	java.io.FileInputStream
    //   529	36	12	localException4	java.lang.Exception
    //   745	1	12	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   303	313	529	java/lang/Exception
    //   586	591	597	java/lang/Exception
    //   303	313	605	finally
    //   299	303	621	java/lang/Exception
    //   404	415	621	java/lang/Exception
    //   417	486	621	java/lang/Exception
    //   619	621	621	java/lang/Exception
    //   673	717	621	java/lang/Exception
    //   390	395	727	java/lang/Exception
    //   614	619	736	java/lang/Exception
    //   317	324	741	finally
    //   331	337	741	finally
    //   344	381	741	finally
    //   538	544	741	finally
    //   548	578	741	finally
    //   317	324	745	java/lang/Exception
    //   331	337	745	java/lang/Exception
    //   344	381	745	java/lang/Exception
  }
  
  public void stop()
  {
    try
    {
      bZa();
      super.stop();
      this.bdL = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int vK()
  {
    return this.jdField_a_of_type_Wjz.vK();
  }
  
  public static abstract interface a
  {
    public abstract void d(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4);
    
    public abstract void g(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CommonAudioPlayer
 * JD-Core Version:    0.7.0.1
 */