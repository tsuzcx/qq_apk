package com.tencent.av.smallscreen;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.av.VideoController;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import ikp;
import ivk;
import ivq;
import ivu;
import ivv;
import jds;
import mqq.app.AppService;

public class BaseSmallScreenService
  extends AppService
  implements SmallScreenRelativeLayout.a
{
  boolean Vl = false;
  boolean Vm = false;
  boolean Vn = false;
  boolean Vo = true;
  public boolean Vp = false;
  TelephonyManager jdField_a_of_type_AndroidTelephonyTelephonyManager = null;
  final ivq[] jdField_a_of_type_ArrayOfIvq = new ivq[3];
  int atY = 0;
  int atZ = 7;
  int aua = 0;
  Runnable bA = null;
  Runnable bz = null;
  Handler mHandler;
  boolean mIsInit = true;
  PhoneStateListener mPhoneStateListener = new ivk(this);
  
  public int a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    paramSmallScreenRelativeLayout = a(paramSmallScreenRelativeLayout);
    if (paramSmallScreenRelativeLayout == null) {
      return 0;
    }
    return paramSmallScreenRelativeLayout.b().x;
  }
  
  public SmallScreenRelativeLayout a(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfIvq[paramInt] != null) {
      return this.jdField_a_of_type_ArrayOfIvq[paramInt].jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout;
    }
    return null;
  }
  
  ivq a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfIvq[paramInt];
  }
  
  public ivu a(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfIvq[paramInt] != null) {
      return this.jdField_a_of_type_ArrayOfIvq[paramInt].jdField_a_of_type_Ivu;
    }
    return null;
  }
  
  protected ivu a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    Object localObject2 = null;
    int i = 0;
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i < 3)
      {
        if (a(i) == paramSmallScreenRelativeLayout) {
          localObject1 = a(i);
        }
      }
      else {
        return localObject1;
      }
      i += 1;
    }
  }
  
  public void a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout) {}
  
  public void a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramSmallScreenRelativeLayout = a(paramSmallScreenRelativeLayout);
    if (paramSmallScreenRelativeLayout != null)
    {
      WindowManager.LayoutParams localLayoutParams = paramSmallScreenRelativeLayout.b();
      localLayoutParams.x = paramInt1;
      localLayoutParams.y = paramInt2;
      localLayoutParams.width = (paramInt3 - paramInt1);
      localLayoutParams.height = (paramInt4 - paramInt2);
      paramSmallScreenRelativeLayout.update();
    }
  }
  
  public boolean a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    return true;
  }
  
  public void af(int paramInt, String paramString) {}
  
  void aqP()
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w("BaseSmallScreenService", 1, "onIsLockChanged, mIsLock[" + this.Vm + "], seq[" + l + "]");
    }
    cC(l);
  }
  
  void aqQ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "onHasSmartBarChanged mHasSmartBar = " + this.Vl);
    }
    SmallScreenRelativeLayout localSmallScreenRelativeLayout = a(1);
    if (localSmallScreenRelativeLayout != null) {
      localSmallScreenRelativeLayout.ard();
    }
  }
  
  void aqR() {}
  
  void aqS() {}
  
  public int b(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    paramSmallScreenRelativeLayout = a(paramSmallScreenRelativeLayout);
    if (paramSmallScreenRelativeLayout == null) {
      return 0;
    }
    return paramSmallScreenRelativeLayout.b().y;
  }
  
  void cC(long paramLong) {}
  
  public Handler getHandler()
  {
    if (this.mHandler == null) {
      this.mHandler = new Handler(Looper.getMainLooper());
    }
    return this.mHandler;
  }
  
  protected boolean isAppOnForeground()
  {
    return ivv.isAppOnForeground(((AppInterface)this.app).getApp());
  }
  
  /* Error */
  public void onCreate()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iconst_1
    //   4: istore_2
    //   5: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +11 -> 19
    //   11: ldc 138
    //   13: iconst_2
    //   14: ldc 216
    //   16: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: invokespecial 218	mqq/app/AppService:onCreate	()V
    //   23: aload_0
    //   24: iconst_0
    //   25: putfield 45	com/tencent/av/smallscreen/BaseSmallScreenService:Vn	Z
    //   28: aload_0
    //   29: ldc 220
    //   31: invokevirtual 224	com/tencent/av/smallscreen/BaseSmallScreenService:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   34: checkcast 226	android/view/LayoutInflater
    //   37: astore_3
    //   38: aload_3
    //   39: ifnonnull +133 -> 172
    //   42: ldc 138
    //   44: iconst_1
    //   45: ldc 228
    //   47: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_0
    //   51: invokevirtual 234	com/tencent/av/smallscreen/BaseSmallScreenService:stopSelf	()V
    //   54: return
    //   55: astore_3
    //   56: ldc 138
    //   58: iconst_1
    //   59: new 140	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   66: ldc 236
    //   68: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_3
    //   72: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload_0
    //   82: invokevirtual 234	com/tencent/av/smallscreen/BaseSmallScreenService:stopSelf	()V
    //   85: return
    //   86: astore 5
    //   88: aload 4
    //   90: astore_3
    //   91: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq -56 -> 38
    //   97: ldc 138
    //   99: iconst_2
    //   100: new 140	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   107: ldc 236
    //   109: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload 5
    //   114: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: aload 4
    //   125: astore_3
    //   126: goto -88 -> 38
    //   129: astore 5
    //   131: aload 4
    //   133: astore_3
    //   134: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq -99 -> 38
    //   140: ldc 138
    //   142: iconst_2
    //   143: new 140	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   150: ldc 236
    //   152: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload 5
    //   157: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: aload 4
    //   168: astore_3
    //   169: goto -131 -> 38
    //   172: aload_0
    //   173: aload_0
    //   174: ldc 241
    //   176: invokevirtual 224	com/tencent/av/smallscreen/BaseSmallScreenService:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   179: checkcast 243	android/telephony/TelephonyManager
    //   182: putfield 65	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_AndroidTelephonyTelephonyManager	Landroid/telephony/TelephonyManager;
    //   185: aload_0
    //   186: getfield 65	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_AndroidTelephonyTelephonyManager	Landroid/telephony/TelephonyManager;
    //   189: aload_0
    //   190: getfield 72	com/tencent/av/smallscreen/BaseSmallScreenService:mPhoneStateListener	Landroid/telephony/PhoneStateListener;
    //   193: bipush 32
    //   195: invokevirtual 247	android/telephony/TelephonyManager:listen	(Landroid/telephony/PhoneStateListener;I)V
    //   198: new 249	ivn
    //   201: dup
    //   202: aload_0
    //   203: invokespecial 252	ivn:<init>	(Landroid/content/Context;)V
    //   206: astore 4
    //   208: aload 4
    //   210: aload_0
    //   211: aload_3
    //   212: aload_0
    //   213: invokevirtual 255	ivn:a	(Landroid/content/Context;Landroid/view/LayoutInflater;Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout$a;)V
    //   216: aload_0
    //   217: getfield 59	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ArrayOfIvq	[Livq;
    //   220: iconst_0
    //   221: aload 4
    //   223: aastore
    //   224: new 257	ivx
    //   227: dup
    //   228: aload_0
    //   229: invokespecial 258	ivx:<init>	(Landroid/content/Context;)V
    //   232: astore 4
    //   234: aload 4
    //   236: aload_0
    //   237: aload_3
    //   238: aload_0
    //   239: invokevirtual 259	ivx:a	(Landroid/content/Context;Landroid/view/LayoutInflater;Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout$a;)V
    //   242: aload_0
    //   243: getfield 59	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ArrayOfIvq	[Livq;
    //   246: iconst_1
    //   247: aload 4
    //   249: aastore
    //   250: new 261	ivt
    //   253: dup
    //   254: aload_0
    //   255: invokespecial 262	ivt:<init>	(Landroid/content/Context;)V
    //   258: astore 4
    //   260: aload 4
    //   262: aload_0
    //   263: aload_3
    //   264: aload_0
    //   265: invokevirtual 263	ivt:a	(Landroid/content/Context;Landroid/view/LayoutInflater;Lcom/tencent/av/smallscreen/SmallScreenRelativeLayout$a;)V
    //   268: aload_0
    //   269: getfield 59	com/tencent/av/smallscreen/BaseSmallScreenService:jdField_a_of_type_ArrayOfIvq	[Livq;
    //   272: iconst_2
    //   273: aload 4
    //   275: aastore
    //   276: new 265	android/content/IntentFilter
    //   279: dup
    //   280: invokespecial 266	android/content/IntentFilter:<init>	()V
    //   283: astore_3
    //   284: aload_3
    //   285: ldc_w 268
    //   288: invokevirtual 272	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   291: aload_3
    //   292: ldc_w 274
    //   295: invokevirtual 272	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   298: aload_0
    //   299: invokestatic 277	ivv:hasSmartBar	()Z
    //   302: putfield 41	com/tencent/av/smallscreen/BaseSmallScreenService:Vl	Z
    //   305: getstatic 282	android/os/Build$VERSION:SDK_INT	I
    //   308: bipush 21
    //   310: if_icmplt +160 -> 470
    //   313: invokestatic 287	com/tencent/av/VideoController:a	()Lcom/tencent/av/VideoController;
    //   316: invokevirtual 290	com/tencent/av/VideoController:a	()Ljds;
    //   319: invokevirtual 295	jds:wG	()Z
    //   322: ifeq +148 -> 470
    //   325: iconst_1
    //   326: istore_1
    //   327: aload_0
    //   328: getfield 78	com/tencent/av/smallscreen/BaseSmallScreenService:app	Lmqq/app/AppRuntime;
    //   331: checkcast 200	com/tencent/common/app/AppInterface
    //   334: invokevirtual 204	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   337: invokestatic 298	ivv:isFloatWindowOpAllowed	(Landroid/content/Context;)Z
    //   340: ifeq +135 -> 475
    //   343: iload_1
    //   344: ifne +131 -> 475
    //   347: aload_0
    //   348: iload_2
    //   349: putfield 47	com/tencent/av/smallscreen/BaseSmallScreenService:Vo	Z
    //   352: aload_0
    //   353: aload_0
    //   354: getfield 78	com/tencent/av/smallscreen/BaseSmallScreenService:app	Lmqq/app/AppRuntime;
    //   357: checkcast 200	com/tencent/common/app/AppInterface
    //   360: invokevirtual 204	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   363: invokestatic 301	ivv:ad	(Landroid/content/Context;)Z
    //   366: putfield 43	com/tencent/av/smallscreen/BaseSmallScreenService:Vm	Z
    //   369: aload_0
    //   370: aload_0
    //   371: getfield 78	com/tencent/av/smallscreen/BaseSmallScreenService:app	Lmqq/app/AppRuntime;
    //   374: checkcast 200	com/tencent/common/app/AppInterface
    //   377: invokevirtual 204	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   380: invokestatic 209	ivv:isAppOnForeground	(Landroid/content/Context;)Z
    //   383: putfield 49	com/tencent/av/smallscreen/BaseSmallScreenService:Vp	Z
    //   386: aload_0
    //   387: getfield 61	com/tencent/av/smallscreen/BaseSmallScreenService:bz	Ljava/lang/Runnable;
    //   390: ifnonnull +15 -> 405
    //   393: aload_0
    //   394: new 8	com/tencent/av/smallscreen/BaseSmallScreenService$InitRunnable
    //   397: dup
    //   398: aload_0
    //   399: invokespecial 302	com/tencent/av/smallscreen/BaseSmallScreenService$InitRunnable:<init>	(Lcom/tencent/av/smallscreen/BaseSmallScreenService;)V
    //   402: putfield 61	com/tencent/av/smallscreen/BaseSmallScreenService:bz	Ljava/lang/Runnable;
    //   405: aload_0
    //   406: invokevirtual 304	com/tencent/av/smallscreen/BaseSmallScreenService:getHandler	()Landroid/os/Handler;
    //   409: aload_0
    //   410: getfield 61	com/tencent/av/smallscreen/BaseSmallScreenService:bz	Ljava/lang/Runnable;
    //   413: ldc2_w 305
    //   416: invokevirtual 310	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   419: pop
    //   420: aload_0
    //   421: getfield 63	com/tencent/av/smallscreen/BaseSmallScreenService:bA	Ljava/lang/Runnable;
    //   424: ifnonnull +15 -> 439
    //   427: aload_0
    //   428: new 11	com/tencent/av/smallscreen/BaseSmallScreenService$OnOpChangedRunnable
    //   431: dup
    //   432: aload_0
    //   433: invokespecial 311	com/tencent/av/smallscreen/BaseSmallScreenService$OnOpChangedRunnable:<init>	(Lcom/tencent/av/smallscreen/BaseSmallScreenService;)V
    //   436: putfield 63	com/tencent/av/smallscreen/BaseSmallScreenService:bA	Ljava/lang/Runnable;
    //   439: aload_0
    //   440: invokevirtual 304	com/tencent/av/smallscreen/BaseSmallScreenService:getHandler	()Landroid/os/Handler;
    //   443: aload_0
    //   444: getfield 63	com/tencent/av/smallscreen/BaseSmallScreenService:bA	Ljava/lang/Runnable;
    //   447: ldc2_w 312
    //   450: invokevirtual 310	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   453: pop
    //   454: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   457: ifeq -403 -> 54
    //   460: ldc 138
    //   462: iconst_2
    //   463: ldc_w 315
    //   466: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   469: return
    //   470: iconst_0
    //   471: istore_1
    //   472: goto -145 -> 327
    //   475: iconst_0
    //   476: istore_2
    //   477: goto -130 -> 347
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	480	0	this	BaseSmallScreenService
    //   326	146	1	i	int
    //   4	473	2	bool	boolean
    //   37	2	3	localLayoutInflater	android.view.LayoutInflater
    //   55	17	3	localException1	java.lang.Exception
    //   90	202	3	localObject1	Object
    //   1	273	4	localObject2	Object
    //   86	27	5	localException2	java.lang.Exception
    //   129	27	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   19	23	55	java/lang/Exception
    //   28	38	86	java/lang/Exception
    //   28	38	129	java/lang/OutOfMemoryError
  }
  
  public void onDestroy()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "onDestroy start");
    }
    super.onDestroy();
    this.Vn = true;
    this.jdField_a_of_type_AndroidTelephonyTelephonyManager.listen(this.mPhoneStateListener, 0);
    this.jdField_a_of_type_AndroidTelephonyTelephonyManager = null;
    if (this.bA != null) {
      getHandler().removeCallbacks(this.bA);
    }
    if (this.bz != null) {
      getHandler().removeCallbacks(this.bz);
    }
    this.mPhoneStateListener = null;
    this.bz = null;
    this.bA = null;
    while (i < 3)
    {
      this.jdField_a_of_type_ArrayOfIvq[i].onDestroy();
      this.jdField_a_of_type_ArrayOfIvq[i] = null;
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "onDestroy end");
    }
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "onLowMemory");
    }
  }
  
  class InitRunnable
    implements Runnable
  {
    InitRunnable() {}
    
    public void run()
    {
      BaseSmallScreenService.this.aqS();
    }
  }
  
  class OnOpChangedRunnable
    implements Runnable
  {
    OnOpChangedRunnable() {}
    
    public void run()
    {
      boolean bool2 = false;
      int i;
      if (!BaseSmallScreenService.this.Vn)
      {
        if ((Build.VERSION.SDK_INT < 21) || (!VideoController.a().a().wG())) {
          break label270;
        }
        i = 1;
        boolean bool1 = bool2;
        if (ivv.isFloatWindowOpAllowed(((AppInterface)BaseSmallScreenService.a(BaseSmallScreenService.this)).getApp()))
        {
          bool1 = bool2;
          if (i == 0) {
            bool1 = true;
          }
        }
        if (bool1 != BaseSmallScreenService.this.Vo)
        {
          BaseSmallScreenService.this.Vo = bool1;
          BaseSmallScreenService.this.aqR();
        }
        bool1 = ivv.hasSmartBar();
        if (bool1 != BaseSmallScreenService.this.Vl)
        {
          BaseSmallScreenService.this.Vl = bool1;
          BaseSmallScreenService.this.aqQ();
        }
        bool1 = ivv.ad(((AppInterface)BaseSmallScreenService.b(BaseSmallScreenService.this)).getApp());
        if (bool1 != BaseSmallScreenService.this.Vm)
        {
          BaseSmallScreenService.this.Vm = bool1;
          BaseSmallScreenService.this.aqP();
        }
        bool1 = BaseSmallScreenService.this.isAppOnForeground();
        if (bool1 != BaseSmallScreenService.this.Vp)
        {
          l = AudioHelper.hG();
          if (QLog.isDevelopLevel()) {
            QLog.w("BaseSmallScreenService", 1, "OnOpChangedRunnable, AppOnForegroundChanged, seq[" + l + "]");
          }
          BaseSmallScreenService.this.Vp = bool1;
          BaseSmallScreenService.this.cC(l);
          if (!bool1) {
            break label275;
          }
        }
      }
      label270:
      label275:
      for (long l = 1L;; l = 2L)
      {
        ikp.r(20, l);
        BaseSmallScreenService.this.getHandler().postDelayed(this, 1000L);
        return;
        i = 0;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.smallscreen.BaseSmallScreenService
 * JD-Core Version:    0.7.0.1
 */