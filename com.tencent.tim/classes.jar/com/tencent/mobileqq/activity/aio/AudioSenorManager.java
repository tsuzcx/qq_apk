package com.tencent.mobileqq.activity.aio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import aqmr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import wja;

public class AudioSenorManager
  extends BroadcastReceiver
{
  public static int bNM = 1000;
  private a jdField_a_of_type_ComTencentMobileqqActivityAioAudioSenorManager$a;
  private b jdField_a_of_type_ComTencentMobileqqActivityAioAudioSenorManager$b;
  private c jdField_a_of_type_ComTencentMobileqqActivityAioAudioSenorManager$c;
  private float ai;
  private volatile int bNN = 0;
  private boolean bdj;
  Runnable eg = new AudioSenorManager.1(this);
  Runnable eh = new AudioSenorManager.2(this);
  private Sensor f;
  private Sensor g;
  boolean hi = true;
  float lastX;
  float lastY;
  QQAppInterface mApp;
  private SensorManager mSensorManager;
  private float ps = 0.6F;
  private float pt = 0.02F;
  float pu;
  private List<String> rA = new CopyOnWriteArrayList();
  
  public AudioSenorManager(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    paramQQAppInterface = paramQQAppInterface.getApp();
    this.mSensorManager = ((SensorManager)paramQQAppInterface.getSystemService("sensor"));
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("mqq.audiosenormanager.audio.start");
    localIntentFilter.addAction("mqq.audiosenormanager.audio.end");
    paramQQAppInterface.registerReceiver(this, localIntentFilter);
  }
  
  public static boolean Rj()
  {
    return Build.MODEL.equals("ZTE U930");
  }
  
  private float a(Sensor paramSensor)
  {
    String str = Build.MODEL;
    float f1;
    if ((str.equals("ZTE U880s")) || (str.equals("ZTE U807"))) {
      f1 = 97.0F;
    }
    do
    {
      return f1;
      if ((str.equals("Coolpad 5890")) || (str.equals("Coolpad 5891")) || (str.equals("Coolpad 8720L")) || (str.equals("Coolpad 5879")) || (str.equals("Coolpad 5891Q"))) {
        return 5.0F;
      }
      if ((str.equals("HUAWEI Y320-T00")) || (str.equals("Lenovo A658t")) || (str.equals("Lenovo A788t"))) {
        return 10.0F;
      }
      if (str.equals("ME860")) {
        return 99.0F;
      }
      if ((str.equals("ZTE U930HD")) || (str.equals("ZTE-T U960s"))) {
        return 100.0F;
      }
      f1 = 0.0F;
    } while (paramSensor == null);
    return paramSensor.getMaximumRange();
  }
  
  /* Error */
  private void bYK()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: invokestatic 193	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   6: getstatic 199	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:qq_audio_play	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   9: invokevirtual 203	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   12: aconst_null
    //   13: invokevirtual 207	com/tencent/mobileqq/app/DeviceProfileManager:aJ	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   16: astore 7
    //   18: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +29 -> 50
    //   24: ldc 214
    //   26: iconst_2
    //   27: new 216	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   34: ldc 219
    //   36: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload 7
    //   41: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload 7
    //   52: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   55: ifne +441 -> 496
    //   58: aload 7
    //   60: invokevirtual 240	java/lang/String:length	()I
    //   63: iconst_1
    //   64: if_icmple +432 -> 496
    //   67: aload 7
    //   69: ldc 242
    //   71: invokevirtual 246	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   74: astore 7
    //   76: ldc 248
    //   78: aload 7
    //   80: iconst_0
    //   81: aaload
    //   82: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: istore 6
    //   87: iload 6
    //   89: ifne +280 -> 369
    //   92: iconst_1
    //   93: istore 4
    //   95: aload 7
    //   97: iconst_1
    //   98: aaload
    //   99: invokestatic 254	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   102: fstore_2
    //   103: fload_2
    //   104: fstore_1
    //   105: iload 4
    //   107: istore_3
    //   108: aload 7
    //   110: arraylength
    //   111: iconst_5
    //   112: if_icmplt +40 -> 152
    //   115: aload_0
    //   116: aload 7
    //   118: iconst_2
    //   119: aaload
    //   120: invokestatic 254	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   123: putfield 56	com/tencent/mobileqq/activity/aio/AudioSenorManager:ps	F
    //   126: aload_0
    //   127: aload 7
    //   129: iconst_3
    //   130: aaload
    //   131: invokestatic 254	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   134: putfield 59	com/tencent/mobileqq/activity/aio/AudioSenorManager:pt	F
    //   137: aload 7
    //   139: iconst_4
    //   140: aaload
    //   141: invokestatic 260	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   144: putstatic 46	com/tencent/mobileqq/activity/aio/AudioSenorManager:bNM	I
    //   147: iload 4
    //   149: istore_3
    //   150: fload_2
    //   151: fstore_1
    //   152: getstatic 46	com/tencent/mobileqq/activity/aio/AudioSenorManager:bNM	I
    //   155: ifge +9 -> 164
    //   158: sipush 1000
    //   161: putstatic 46	com/tencent/mobileqq/activity/aio/AudioSenorManager:bNM	I
    //   164: aload_0
    //   165: getfield 56	com/tencent/mobileqq/activity/aio/AudioSenorManager:ps	F
    //   168: fconst_0
    //   169: fcmpg
    //   170: ifgt +5 -> 175
    //   173: iconst_0
    //   174: istore_3
    //   175: invokestatic 193	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   178: getstatic 266	com/tencent/mobileqq/app/DeviceProfileManager$AccountDpcManager$DpcAccountNames:qq_audio_play_fix	Lcom/tencent/mobileqq/app/DeviceProfileManager$AccountDpcManager$DpcAccountNames;
    //   181: invokevirtual 267	com/tencent/mobileqq/app/DeviceProfileManager$AccountDpcManager$DpcAccountNames:name	()Ljava/lang/String;
    //   184: aconst_null
    //   185: invokevirtual 207	com/tencent/mobileqq/app/DeviceProfileManager:aJ	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   188: astore 7
    //   190: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +30 -> 223
    //   196: ldc 214
    //   198: iconst_2
    //   199: new 216	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   206: ldc_w 269
    //   209: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload 7
    //   214: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 226	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: aload 7
    //   225: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   228: ifne +262 -> 490
    //   231: aload 7
    //   233: invokevirtual 240	java/lang/String:length	()I
    //   236: iconst_1
    //   237: if_icmple +253 -> 490
    //   240: aload 7
    //   242: ldc 242
    //   244: invokevirtual 246	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   247: astore 7
    //   249: ldc_w 271
    //   252: aload 7
    //   254: iconst_4
    //   255: aaload
    //   256: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   259: ifne +228 -> 487
    //   262: aload 7
    //   264: iconst_4
    //   265: aaload
    //   266: invokestatic 254	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   269: fstore_2
    //   270: fload_2
    //   271: fstore_1
    //   272: ldc 248
    //   274: aload 7
    //   276: iconst_5
    //   277: aaload
    //   278: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   281: istore 6
    //   283: iload 5
    //   285: istore_3
    //   286: iload 6
    //   288: ifne +5 -> 293
    //   291: iconst_1
    //   292: istore_3
    //   293: iload_3
    //   294: istore 4
    //   296: iload 4
    //   298: ifeq +27 -> 325
    //   301: aload_0
    //   302: aload_0
    //   303: getfield 98	com/tencent/mobileqq/activity/aio/AudioSenorManager:mSensorManager	Landroid/hardware/SensorManager;
    //   306: iconst_1
    //   307: invokevirtual 275	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   310: putfield 185	com/tencent/mobileqq/activity/aio/AudioSenorManager:f	Landroid/hardware/Sensor;
    //   313: aload_0
    //   314: new 6	com/tencent/mobileqq/activity/aio/AudioSenorManager$a
    //   317: dup
    //   318: aload_0
    //   319: invokespecial 276	com/tencent/mobileqq/activity/aio/AudioSenorManager$a:<init>	(Lcom/tencent/mobileqq/activity/aio/AudioSenorManager;)V
    //   322: putfield 177	com/tencent/mobileqq/activity/aio/AudioSenorManager:jdField_a_of_type_ComTencentMobileqqActivityAioAudioSenorManager$a	Lcom/tencent/mobileqq/activity/aio/AudioSenorManager$a;
    //   325: aload_0
    //   326: aload_0
    //   327: getfield 98	com/tencent/mobileqq/activity/aio/AudioSenorManager:mSensorManager	Landroid/hardware/SensorManager;
    //   330: bipush 8
    //   332: invokevirtual 275	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   335: putfield 173	com/tencent/mobileqq/activity/aio/AudioSenorManager:g	Landroid/hardware/Sensor;
    //   338: aload_0
    //   339: new 12	com/tencent/mobileqq/activity/aio/AudioSenorManager$c
    //   342: dup
    //   343: aload_0
    //   344: invokespecial 277	com/tencent/mobileqq/activity/aio/AudioSenorManager$c:<init>	(Lcom/tencent/mobileqq/activity/aio/AudioSenorManager;)V
    //   347: putfield 183	com/tencent/mobileqq/activity/aio/AudioSenorManager:jdField_a_of_type_ComTencentMobileqqActivityAioAudioSenorManager$c	Lcom/tencent/mobileqq/activity/aio/AudioSenorManager$c;
    //   350: fload_1
    //   351: ldc_w 278
    //   354: fcmpl
    //   355: ifle +91 -> 446
    //   358: aload_0
    //   359: fload_1
    //   360: putfield 280	com/tencent/mobileqq/activity/aio/AudioSenorManager:ai	F
    //   363: aload_0
    //   364: iconst_1
    //   365: putfield 282	com/tencent/mobileqq/activity/aio/AudioSenorManager:bdj	Z
    //   368: return
    //   369: iconst_0
    //   370: istore 4
    //   372: goto -277 -> 95
    //   375: astore 7
    //   377: iconst_1
    //   378: istore 4
    //   380: fconst_0
    //   381: fstore_2
    //   382: fload_2
    //   383: fstore_1
    //   384: iload 4
    //   386: istore_3
    //   387: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   390: ifeq -238 -> 152
    //   393: ldc 214
    //   395: iconst_2
    //   396: ldc_w 284
    //   399: aload 7
    //   401: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   404: fload_2
    //   405: fstore_1
    //   406: iload 4
    //   408: istore_3
    //   409: goto -257 -> 152
    //   412: astore 7
    //   414: fload_1
    //   415: fstore_2
    //   416: fload_2
    //   417: fstore_1
    //   418: iload_3
    //   419: istore 4
    //   421: invokestatic 212	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   424: ifeq -128 -> 296
    //   427: ldc 214
    //   429: iconst_2
    //   430: ldc_w 289
    //   433: aload 7
    //   435: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   438: fload_2
    //   439: fstore_1
    //   440: iload_3
    //   441: istore 4
    //   443: goto -147 -> 296
    //   446: aload_0
    //   447: getfield 173	com/tencent/mobileqq/activity/aio/AudioSenorManager:g	Landroid/hardware/Sensor;
    //   450: ifnull -87 -> 363
    //   453: aload_0
    //   454: aload_0
    //   455: aload_0
    //   456: getfield 173	com/tencent/mobileqq/activity/aio/AudioSenorManager:g	Landroid/hardware/Sensor;
    //   459: invokespecial 291	com/tencent/mobileqq/activity/aio/AudioSenorManager:a	(Landroid/hardware/Sensor;)F
    //   462: putfield 280	com/tencent/mobileqq/activity/aio/AudioSenorManager:ai	F
    //   465: goto -102 -> 363
    //   468: astore 7
    //   470: fload_1
    //   471: fstore_2
    //   472: goto -56 -> 416
    //   475: astore 7
    //   477: fconst_0
    //   478: fstore_2
    //   479: goto -97 -> 382
    //   482: astore 7
    //   484: goto -102 -> 382
    //   487: goto -215 -> 272
    //   490: iload_3
    //   491: istore 4
    //   493: goto -197 -> 296
    //   496: fconst_0
    //   497: fstore_1
    //   498: iconst_1
    //   499: istore_3
    //   500: goto -348 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	503	0	this	AudioSenorManager
    //   104	394	1	f1	float
    //   102	377	2	f2	float
    //   107	393	3	i	int
    //   93	399	4	j	int
    //   1	283	5	k	int
    //   85	202	6	bool	boolean
    //   16	259	7	localObject	Object
    //   375	25	7	localException1	java.lang.Exception
    //   412	22	7	localException2	java.lang.Exception
    //   468	1	7	localException3	java.lang.Exception
    //   475	1	7	localException4	java.lang.Exception
    //   482	1	7	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   67	87	375	java/lang/Exception
    //   240	270	412	java/lang/Exception
    //   272	283	468	java/lang/Exception
    //   95	103	475	java/lang/Exception
    //   108	147	482	java/lang/Exception
  }
  
  private void bYL()
  {
    this.lastX = -999.0F;
    this.lastY = -999.0F;
    this.pu = -999.0F;
    this.hi = false;
  }
  
  private void xk(String paramString)
  {
    if (!aqmr.isEmpty(paramString))
    {
      if (!this.rA.contains(paramString)) {
        this.rA.add(paramString);
      }
      bYL();
      ThreadManager.removeJobFromThreadPool(this.eh, 16);
      ThreadManager.excute(this.eg, 16, null, false);
    }
  }
  
  private void xl(String paramString)
  {
    if (!aqmr.isEmpty(paramString))
    {
      if (this.rA.contains(paramString)) {
        this.rA.remove(this.rA.indexOf(paramString));
      }
      if (this.rA.size() == 0)
      {
        ThreadManager.removeJobFromThreadPool(this.eg, 16);
        ThreadManager.excute(this.eh, 16, null, false);
        if (this.bNN != 0)
        {
          this.bNN = 0;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioSenorManager$b != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioSenorManager$b.Cd(this.bNN);
          }
        }
      }
    }
  }
  
  public void a(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioSenorManager$b = paramb;
  }
  
  public void onDestory()
  {
    if (this.mApp != null)
    {
      this.mApp.getApp().unregisterReceiver(this);
      this.mApp = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioSenorManager$b = null;
    this.rA.clear();
    ThreadManager.removeJobFromThreadPool(this.eh, 16);
    ThreadManager.removeJobFromThreadPool(this.eg, 16);
    this.mSensorManager.unregisterListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioSenorManager$a);
    this.mSensorManager.unregisterListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioSenorManager$c);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    paramIntent = paramIntent.getStringExtra("audiosenormanager.playkey");
    if ((paramContext != null) && (paramContext.equals("mqq.audiosenormanager.audio.start")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioPlayer_SenorManager", 2, "onReceive AUDIO_SENOR_START_NOTIFY key = " + paramIntent);
      }
      if (!this.bdj) {
        bYK();
      }
      xk(paramIntent);
    }
    while ((paramContext == null) || (!paramContext.equals("mqq.audiosenormanager.audio.end"))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AudioPlayer_SenorManager", 2, "onReceive AUDIO_SENOR_END_NOTIFY key = " + paramIntent);
    }
    xl(paramIntent);
  }
  
  class a
    implements SensorEventListener
  {
    a() {}
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      float f6;
      float f5;
      float f4;
      float f3;
      float f2;
      float f1;
      if (paramSensorEvent.sensor.getType() == 1)
      {
        f6 = paramSensorEvent.values[0];
        f5 = paramSensorEvent.values[1];
        f4 = paramSensorEvent.values[2];
        f3 = f4;
        f2 = f5;
        f1 = f6;
        if (AudioSenorManager.Rj())
        {
          f1 = f6 * 10.0F;
          f2 = f5 * 10.0F;
          f3 = f4 * 10.0F;
        }
        if ((AudioSenorManager.this.lastX != -999.0F) || (AudioSenorManager.this.lastY != -999.0F) || (AudioSenorManager.this.pu != -999.0F)) {
          break label135;
        }
      }
      for (;;)
      {
        AudioSenorManager.this.lastX = f1;
        AudioSenorManager.this.lastY = f2;
        AudioSenorManager.this.pu = f3;
        return;
        label135:
        f4 = Math.abs(AudioSenorManager.this.lastX - f1);
        f5 = Math.abs(AudioSenorManager.this.lastY - f2);
        f6 = Math.abs(AudioSenorManager.this.pu - f3);
        if ((f4 >= AudioSenorManager.a(AudioSenorManager.this)) || (f5 >= AudioSenorManager.a(AudioSenorManager.this)) || (f6 >= AudioSenorManager.a(AudioSenorManager.this)))
        {
          if ((!AudioSenorManager.this.hi) && (QLog.isColorLevel())) {
            QLog.d("AudioPlayer_SenorManager", 2, "AccelerationListener$onSensorChanged moving | x=" + f1 + " | y = " + f2 + " | z = " + f3 + " | ax = " + f4 + " | ay = " + f5 + " | az = " + f6 + " | value=" + AudioSenorManager.a(AudioSenorManager.this));
          }
          AudioSenorManager.this.hi = true;
        }
        else if ((f4 < AudioSenorManager.b(AudioSenorManager.this)) && (f5 < AudioSenorManager.b(AudioSenorManager.this)) && (f6 < AudioSenorManager.b(AudioSenorManager.this)))
        {
          if ((AudioSenorManager.this.hi) && (QLog.isColorLevel())) {
            QLog.d("AudioPlayer_SenorManager", 2, "AccelerationListener$onSensorChanged stop moving | x=" + f1 + " | y = " + f2 + " | z = " + f3 + " | ax = " + f4 + " | ay = " + f5 + " | az = " + f6 + " | value=" + AudioSenorManager.a(AudioSenorManager.this));
          }
          AudioSenorManager.this.hi = false;
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void Cd(int paramInt);
  }
  
  class c
    implements SensorEventListener
  {
    c() {}
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      int i = 1;
      if (wja.Rc()) {}
      label141:
      label144:
      for (;;)
      {
        return;
        boolean bool;
        if (paramSensorEvent.values[0] < AudioSenorManager.c(AudioSenorManager.this))
        {
          bool = true;
          label28:
          QLog.d("AudioPlayer_SenorManager", 2, "ProximityEventListener$onSensorChanged close =" + bool + " | mIsMoving =" + AudioSenorManager.this.hi);
          if ((!AudioHelper.aCt()) && (bool) && (!AudioSenorManager.this.hi)) {
            continue;
          }
          if (!bool) {
            break label141;
          }
        }
        for (;;)
        {
          if (i == AudioSenorManager.a(AudioSenorManager.this)) {
            break label144;
          }
          AudioSenorManager.a(AudioSenorManager.this, i);
          if (AudioSenorManager.a(AudioSenorManager.this) == null) {
            break;
          }
          AudioSenorManager.a(AudioSenorManager.this).Cd(i);
          return;
          bool = false;
          break label28;
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AudioSenorManager
 * JD-Core Version:    0.7.0.1
 */