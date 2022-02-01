package com.tencent.mobileqq.activity.richmedia.state;

import aaqh;
import aaqi;
import aasw;
import aasx;
import aasy;
import aasz;
import aata;
import aatb;
import aatc;
import aate;
import aatf;
import acfp;
import amae;
import amal;
import aman;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.opengl.EGL14;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.Toast;
import anhm;
import anhp;
import anhp.a;
import anhr;
import anhr.a;
import anhz;
import anii;
import anij.b;
import anim;
import anim.c;
import anim.f;
import aniq;
import anir;
import aniu;
import anka;
import anki;
import anld;
import anld.a;
import anpc;
import aqhq;
import awed;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.maxvideo.mediadevice.AVCodec.AVCodecCallback;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture.a;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.qphone.base.util.QLog;
import imm;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class RMVideoStateMgr
  implements anhp.a, anhr.a, anld.a, AVCodec.AVCodecCallback, AudioCapture.a
{
  public static boolean byU;
  public static boolean byW = true;
  private static RMVideoStateMgr e;
  private static final int[] jF = { 850, 780, 650, 480 };
  public aasw a;
  final aasy jdField_a_of_type_Aasy = new aasy();
  final aasz jdField_a_of_type_Aasz = new aasz();
  final aata jdField_a_of_type_Aata = new aata();
  final aatb jdField_a_of_type_Aatb = new aatb();
  public final aate a;
  public aatf a;
  public anka a;
  public a a;
  public final RMVideoSwitchCameraPicMgr a;
  public AudioCapture.a a;
  public AudioCapture a;
  public PreviewContext a;
  public AtomicInteger aK = new AtomicInteger(0);
  public AtomicInteger aL = new AtomicInteger(1);
  public aasx b;
  private amae jdField_b_of_type_Amae;
  private aman jdField_b_of_type_Aman;
  public double bL;
  public String bdG;
  public String bdT;
  private int businessType;
  public boolean byV;
  public boolean byX;
  public boolean byY;
  private boolean byZ;
  public boolean bza = true;
  public boolean bzb;
  public boolean bzc;
  public boolean bzd = true;
  private volatile boolean bze;
  private boolean bzf;
  private boolean bzg;
  private volatile boolean bzh;
  private boolean bzi = true;
  public AtomicBoolean cb = new AtomicBoolean(false);
  private int cjK = 1;
  public int cjL = 480;
  private int cjM;
  public int cjN;
  private WeakReference<amal> eX;
  private boolean isReleased;
  private int[] jG = new int[8];
  public anim mCamera;
  public Context mContext;
  public Handler mHandler = new Handler(Looper.getMainLooper());
  public long mStartTime;
  private Object mlock = new Object();
  public int timerCount;
  
  private RMVideoStateMgr()
  {
    this.jdField_a_of_type_Aate = new aate();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr = new RMVideoSwitchCameraPicMgr();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$a = new a();
    this.jdField_b_of_type_Aasx = new aasx();
  }
  
  public static void AR(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RMVideoStateMgr", 2, "clearVideoDataFile:" + paramString);
    }
    String str = anhm.zR();
    if ((str != null) && (!"".equals(str)) && (str.contains("/Android/data/com.tencent.mobileqq/qq/video"))) {
      y(str, paramString, false);
    }
  }
  
  public static void AS(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      return;
      str = new File(paramString).getParentFile().getAbsolutePath();
    } while (TextUtils.isEmpty(str));
    ed(str, paramString);
  }
  
  private void CX(boolean paramBoolean)
  {
    if ((anii.isFoundProductManufacturer(anii.KEY_NO_QUALCOMM_CPU_IS_VERY_SLOW_PHONE)) || (paramBoolean)) {
      PtvFilterUtils.Qg(false);
    }
  }
  
  private void Gu(int paramInt)
  {
    if ((paramInt != -1) && (paramInt < anhm.nz.length))
    {
      paramInt *= 4;
      aniq.dHf = anhm.nu[paramInt];
      aniq.dHg = anhm.nu[(paramInt + 1)];
      aniq.dHh = anhm.nu[(paramInt + 2)];
      aniq.dHi = anhm.nu[(paramInt + 3)];
      return;
    }
    aniq.dHf = anhm.dGd;
    aniq.dHg = anhm.dGd * 3 / 4;
    aniq.dHh = aniq.dHf * aniq.dHd / aniq.dHe;
    aniq.dHi = aniq.dHg * aniq.dHd / aniq.dHe;
  }
  
  private boolean Xj()
  {
    int k = 1;
    this.bzg = true;
    if (Build.VERSION.SDK_INT < 18) {
      this.bzg = false;
    }
    for (int i = 1;; i = 0)
    {
      if (!anki.ahh())
      {
        this.bzg = false;
        i = 2;
      }
      int j = k;
      if (this.businessType != 10000)
      {
        j = k;
        if (this.businessType != 10002)
        {
          if (this.businessType != 10007) {
            break label221;
          }
          j = k;
        }
      }
      if (j == 0)
      {
        this.bzg = false;
        i = 3;
      }
      if (!this.bzf)
      {
        this.bzg = false;
        i = 4;
      }
      if (BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).getInt("sp_mc_crash_times", 0) >= 2)
      {
        this.bzg = false;
        i = 5;
      }
      for (;;)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_FailCode", Integer.toString(i));
        anpc.a(BaseApplicationImpl.getContext()).collectPerformance(null, "actMediaCodecSupport", this.bzg, 0L, 0L, localHashMap, "");
        if (QLog.isColorLevel()) {
          QLog.i("RMVideoStateMgr", 2, "mediacodec isMediaCodecSupport:" + this.bzg + ", code:" + i);
        }
        return this.bzg;
        label221:
        j = 0;
        break;
      }
    }
  }
  
  public static RMVideoStateMgr a()
  {
    try
    {
      if (e == null) {
        e = new RMVideoStateMgr();
      }
      RMVideoStateMgr localRMVideoStateMgr = e;
      return localRMVideoStateMgr;
    }
    finally {}
  }
  
  /* Error */
  private boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 187
    //   8: iconst_2
    //   9: ldc_w 380
    //   12: invokestatic 382	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_2
    //   16: invokestatic 388	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   19: invokevirtual 392	java/lang/Long:longValue	()J
    //   22: lstore 6
    //   24: lload 6
    //   26: ldc2_w 393
    //   29: lcmp
    //   30: ifne +51 -> 81
    //   33: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +30 -> 66
    //   39: ldc 187
    //   41: iconst_2
    //   42: new 189	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 396
    //   52: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: lload 6
    //   57: invokevirtual 399	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   60: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 382	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: iconst_0
    //   67: istore 9
    //   69: iload 9
    //   71: ireturn
    //   72: astore_2
    //   73: ldc2_w 393
    //   76: lstore 6
    //   78: goto -54 -> 24
    //   81: iconst_0
    //   82: istore 8
    //   84: invokestatic 405	com/tencent/mobileqq/shortvideo/VideoEnvironment:Jq	()I
    //   87: istore 5
    //   89: lload 6
    //   91: aload_1
    //   92: iload_3
    //   93: iload 4
    //   95: invokestatic 408	anhm:a	(JLandroid/content/Context;II)Z
    //   98: istore 9
    //   100: iload 9
    //   102: istore 8
    //   104: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq +41 -> 148
    //   110: ldc 187
    //   112: iconst_2
    //   113: new 189	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   120: ldc_w 410
    //   123: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: iload 8
    //   128: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   131: ldc_w 412
    //   134: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: iload 5
    //   139: invokevirtual 369	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   142: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 382	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   148: iload 5
    //   150: ifeq +6 -> 156
    //   153: iconst_0
    //   154: istore 8
    //   156: iconst_0
    //   157: istore 9
    //   159: iload 9
    //   161: ifeq +71 -> 232
    //   164: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   167: ifeq +41 -> 208
    //   170: ldc 187
    //   172: iconst_2
    //   173: new 189	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   180: ldc_w 414
    //   183: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: iload 9
    //   188: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   191: ldc_w 412
    //   194: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: iload 5
    //   199: invokevirtual 369	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 382	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: invokestatic 417	com/tencent/mobileqq/shortvideo/VideoEnvironment:dPA	()V
    //   211: ldc_w 419
    //   214: aload_1
    //   215: iconst_1
    //   216: invokestatic 422	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;Landroid/content/Context;Z)I
    //   219: istore 5
    //   221: lload 6
    //   223: aload_1
    //   224: iload_3
    //   225: iload 4
    //   227: invokestatic 408	anhm:a	(JLandroid/content/Context;II)Z
    //   230: istore 8
    //   232: iload 8
    //   234: istore 9
    //   236: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   239: ifeq -170 -> 69
    //   242: ldc 187
    //   244: iconst_2
    //   245: ldc_w 424
    //   248: invokestatic 382	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: iload 8
    //   253: ireturn
    //   254: astore_2
    //   255: aload_2
    //   256: invokevirtual 427	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   259: ldc2_w 393
    //   262: putstatic 430	anhm:sUin	J
    //   265: iconst_1
    //   266: istore 9
    //   268: goto -109 -> 159
    //   271: astore_1
    //   272: aload_1
    //   273: invokevirtual 427	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   276: iconst_0
    //   277: istore 10
    //   279: iload 10
    //   281: istore 8
    //   283: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   286: ifeq -54 -> 232
    //   289: ldc 187
    //   291: iconst_2
    //   292: new 189	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   299: ldc_w 432
    //   302: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: iload 9
    //   307: invokevirtual 364	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   310: ldc_w 412
    //   313: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: iload 5
    //   318: invokevirtual 369	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   321: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokestatic 382	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   327: iload 10
    //   329: istore 8
    //   331: goto -99 -> 232
    //   334: astore_2
    //   335: goto -80 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	this	RMVideoStateMgr
    //   0	338	1	paramContext	Context
    //   0	338	2	paramString	String
    //   0	338	3	paramInt1	int
    //   0	338	4	paramInt2	int
    //   87	230	5	i	int
    //   22	200	6	l	long
    //   82	248	8	bool1	boolean
    //   67	239	9	bool2	boolean
    //   277	51	10	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   15	24	72	java/lang/NumberFormatException
    //   89	100	254	java/lang/UnsatisfiedLinkError
    //   221	232	271	java/lang/UnsatisfiedLinkError
    //   104	148	334	java/lang/UnsatisfiedLinkError
  }
  
  public static boolean aH(boolean paramBoolean)
  {
    return (anhz.axf()) || (paramBoolean);
  }
  
  private int b(int[] paramArrayOfInt)
  {
    int j = anhm.nz.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfInt[1] == anhm.nz[i])
      {
        paramArrayOfInt[0] = anhm.ny[i];
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private int c(int[] paramArrayOfInt)
  {
    int j = anhm.ns.length;
    int i = 0;
    while (i < j)
    {
      if ((paramArrayOfInt[0] == anhm.ns[i]) && (paramArrayOfInt[1] == anhm.nt[i])) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void changeState(int paramInt)
  {
    this.aL.getAndSet(paramInt);
  }
  
  private void cyj()
  {
    this.bzh = false;
  }
  
  private static void ed(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.trim().length() == 0)) {}
    for (;;)
    {
      return;
      paramString1 = new File(paramString1);
      paramString2 = new File(paramString2);
      if ((paramString1.exists()) && (paramString2.exists()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("RMVideoStateMgr", 2, "deleteDirectoryByTime rootDir:" + paramString1 + ", currentDirectory:" + paramString2);
        }
        paramString2 = paramString2.getName();
        paramString1 = paramString1.listFiles();
        if ((paramString1 != null) && (paramString1.length > 0) && (!TextUtils.isEmpty(paramString2)))
        {
          int i = 0;
          while (i < paramString1.length)
          {
            String str = paramString1[i].getName();
            if ((!TextUtils.isEmpty(str)) && (str.compareTo(paramString2) < 0)) {
              aqhq.cn(paramString1[i].getAbsolutePath());
            }
            i += 1;
          }
        }
      }
    }
  }
  
  private void s(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = anhm.nu.length / 2;
    int i = 0;
    if (i < j)
    {
      int k = p(anhm.nu[(i * 2 + 1)], paramBoolean);
      if ((anhm.nu[(i * 2)] != paramInt1) || (k != paramInt2)) {}
    }
    for (;;)
    {
      if ((i >= 0) && (jF[i] != this.cjL)) {
        this.cjL = jF[i];
      }
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  private native void setBeautyLevelNative(int paramInt);
  
  private native void setResolutionAlignedByteNative(int paramInt);
  
  private native void setVideoClipSpec(int[] paramArrayOfInt);
  
  private static void y(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString1 == null) || (paramString1.trim().length() == 0)) {}
    do
    {
      do
      {
        return;
        paramString1 = new File(paramString1);
      } while (!paramString1.exists());
      File[] arrayOfFile = paramString1.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int i = 0;
        if (i < arrayOfFile.length)
        {
          if ((paramString2 != null) && (!"".equals(paramString2)) && (arrayOfFile[i].getAbsolutePath().equals(paramString2))) {}
          for (;;)
          {
            i += 1;
            break;
            if (arrayOfFile[i].isDirectory()) {
              y(arrayOfFile[i].getAbsolutePath(), paramString2, true);
            } else {
              arrayOfFile[i].delete();
            }
          }
        }
      }
    } while (!paramBoolean);
    paramString1.delete();
  }
  
  public void AQ(String paramString)
  {
    stopWatching();
    if (QLog.isColorLevel()) {
      QLog.d("" + paramString, 2, "[@][deleteCacheFile] [RMFileEventNotify]stopWatching");
    }
    if (this.bdG != null) {
      aqhq.delete(this.bdG, false);
    }
  }
  
  public void CW(boolean paramBoolean)
  {
    this.byZ = paramBoolean;
  }
  
  public void CY(boolean paramBoolean)
  {
    changeState(1);
    a().CV(paramBoolean);
    a().initState();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$a.bzj) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$a.mPaused)) {
      a().onPause();
    }
  }
  
  public void CZ(boolean paramBoolean)
  {
    this.byX = paramBoolean;
  }
  
  public void Da(boolean paramBoolean)
  {
    this.bzi = paramBoolean;
  }
  
  public void Db(boolean paramBoolean)
  {
    this.jdField_a_of_type_Aasz.byS = paramBoolean;
  }
  
  public void H(int paramInt, String paramString)
  {
    try
    {
      
      label3:
      a().onPause();
      if (paramInt == 0)
      {
        j(0, acfp.m(2131713967), false);
        if (1 == aaqi.ciB) {
          awed.ad(anhm.sUin + "", "qzone_video_record", "1", null);
        }
      }
      return;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      break label3;
    }
  }
  
  boolean WV()
  {
    long l = anld.s(anld.a().JE);
    if (l <= anld.ama)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoStateMgr", 2, "[@] checkDiskSpaceIsOK,freeSpace <= FREESPACE_LIMIT_EXIT freeSpace=" + l + "StorageManager.FREESPACE_LIMIT_EXIT=" + anld.ama + " 手机剩余存储空间不足");
      }
      j(0, acfp.m(2131713966), false);
      return false;
    }
    return true;
  }
  
  public boolean Xb()
  {
    return this.aL.get() == 4;
  }
  
  public boolean Xc()
  {
    return this.aL.get() == 3;
  }
  
  public boolean Xd()
  {
    return this.byZ;
  }
  
  public boolean Xe()
  {
    if (this.mCamera == null) {}
    do
    {
      return true;
      if ((this.mCamera.jdField_b_of_type_Anim$f.bn.get()) && (this.mCamera.c.bn.get()) && (this.mCamera.jdField_b_of_type_Anim$f.e.equals(this.mCamera.c.e))) {
        return false;
      }
    } while (!anii.isFoundProductManufacturer(anii.KEY_DO_NOT_DESTORY_GLSURFACE_VIEW));
    return false;
  }
  
  public boolean Xf()
  {
    int i = this.aL.get();
    if (i == 3) {
      a().cxZ();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RMVideoStateMgr", 2, "[exitRecordMode]currentState = " + i + " mCurrentSegInvalid=" + this.byZ);
      }
      return this.byZ;
      if (i == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RMVideoStateMgr", 2, "current = G_STATUS_IDLE ,so do not change state...");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$a.bzj = true;
      }
    }
  }
  
  public boolean Xg()
  {
    if (!this.bzh) {
      synchronized (this.mlock)
      {
        boolean bool = this.bzh;
        if (!bool) {}
        try
        {
          this.mlock.wait(1000L);
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    return true;
  }
  
  public boolean Xh()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) && (this.byX);
  }
  
  public boolean Xi()
  {
    return this.bzi;
  }
  
  public int a(anhp.a parama, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    int i = -1;
    if (parama == this)
    {
      a().a(parama, paramBoolean, paramInt1, paramInt2);
      i = 0;
    }
    return i;
  }
  
  public aatc a()
  {
    int i = this.aL.get();
    aasz localaasz = this.jdField_a_of_type_Aasz;
    switch (i)
    {
    default: 
      return localaasz;
    case 2: 
      return this.jdField_a_of_type_Aasy;
    case 3: 
      return this.jdField_a_of_type_Aatb;
    }
    return this.jdField_a_of_type_Aata;
  }
  
  @TargetApi(17)
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong, anir paramanir)
  {
    if (!this.bzg) {
      throw new RuntimeException("HWRecorder is not supported.");
    }
    if (this.jdField_b_of_type_Aman == null) {
      throw new RuntimeException("hwVideoRecorder == null");
    }
    amal localamal;
    if (this.eX != null) {
      localamal = (amal)this.eX.get();
    }
    while ((this.bze) && (this.jdField_b_of_type_Amae != null)) {
      switch (this.cjM)
      {
      default: 
        throw new RuntimeException("unknown status " + this.cjM);
        localamal = null;
        break;
      case 0: 
        this.jdField_b_of_type_Amae.a(EGL14.eglGetCurrentContext());
        this.jdField_b_of_type_Aman.a(this.jdField_b_of_type_Amae, localamal);
        this.cjM = 1;
      case 1: 
        this.jdField_b_of_type_Aman.f(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
        paramanir.JG();
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("RMVideoStateMgr", 2, "frameAvailableForHwRecorder:: hwRecordingEnabled = " + this.bze + " ; hwEncodeConfig = " + this.jdField_b_of_type_Amae);
  }
  
  public void a(int paramInt1, aasx paramaasx, int paramInt2)
  {
    switch (paramInt1)
    {
    case 3: 
    default: 
      return;
    case 1: 
    case 2: 
      paramaasx.cjE = paramInt2;
      paramaasx.cjF = 0;
      return;
    }
    paramaasx.cjE = (paramaasx.cjI - paramaasx.cjH - paramInt2);
    paramaasx.cjF = 0;
  }
  
  public void a(aasx paramaasx, boolean paramBoolean)
  {
    for (int i = 1;; i = 0)
    {
      try
      {
        boolean bool1 = anii.isFoundProduct(anii.KEY_PREVIEW_ORIENTATION_270_OF_FRONT_MODEL);
        boolean bool2 = anii.isFoundProductFeatureRom(anii.KEY_PREVIEW_ORIENTATION_270_OF_FRONT_MODEL_2);
        boolean bool3 = anii.isFoundProductFeatureRom(anii.KEY_CONST_HEIGHT_MAP_CLIP_WIDTH_POSITIVE_OFFSET_OF_FRONT_CAMERA);
        if (((bool1) || (bool2) || (bool3)) && (aaqh.cix == 1)) {
          paramaasx.cjF = (-paramaasx.cjF);
        }
        this.jG[0] = paramaasx.cjE;
        this.jG[1] = paramaasx.cjF;
        this.jG[2] = paramaasx.cjG;
        this.jG[3] = paramaasx.cjH;
        this.jG[4] = paramaasx.cjI;
        this.jG[5] = paramaasx.cjJ;
        int[] arrayOfInt = this.jG;
        if (aaqh.cix != 1) {
          continue;
        }
        arrayOfInt[6] = i;
        if (QLog.isColorLevel()) {
          QLog.i("RMVideoStateMgr", 2, "setVideoClipSpecdst_width=" + paramaasx.cjI + "spec.dst_height=" + paramaasx.cjJ + "xoffset=" + paramaasx.cjE + "y_offset=" + paramaasx.cjF + "clip_width=" + paramaasx.cjG + "clip_height" + paramaasx.cjH);
        }
        setVideoClipSpec(this.jG);
      }
      catch (UnsatisfiedLinkError paramaasx)
      {
        for (;;)
        {
          paramaasx.printStackTrace();
        }
      }
      s(this.jdField_b_of_type_Aasx.cjI, this.jdField_b_of_type_Aasx.cjJ, paramBoolean);
      return;
    }
  }
  
  public void a(amal paramamal)
  {
    this.eX = new WeakReference(paramamal);
  }
  
  public void a(anim paramanim)
  {
    this.mCamera = paramanim;
    if (this.mCamera != null) {
      paramanim.b(this);
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, String paramString, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = 2;
    boolean bool2 = false;
    boolean bool1 = false;
    PtvFilterUtils.Qg(true);
    if (paramInt1 == 0)
    {
      PtvFilterUtils.Vb(0);
      if (QLog.isColorLevel()) {
        QLog.d("FlowCameraActivity", 2, "initVideoParams(): ptvMaxTime=" + paramInt4);
      }
      aniq.dFO = 0;
      aniq.dHo = 0;
      aniq.dQu();
      aniq.dGY = paramInt4 * 1000;
      VideoEnvironment.dPz();
      paramBoolean = anii.isFoundProductFeature(anii.KEY_PREVIEW_DATA_LENGTH_MIN_640X480_MODLE);
      if (QLog.isColorLevel()) {
        QLog.e("RMVideoStateMgr", 2, "isFoundProductFeature:need640Black=" + paramBoolean);
      }
      if (paramBoolean)
      {
        anhm.dGc = 640;
        anhm.dGd = 480;
        if (QLog.isColorLevel()) {
          QLog.e("RMVideoStateMgr", 2, "isFoundProductFeature:true[640*480]");
        }
      }
      for (;;)
      {
        this.cjK = 1;
        AudioCapture.BUF_SIZE = 4000;
        return;
        paramBoolean = anii.isFoundProductFeature(anii.KEY_PREVIEW_DATA_LENGTH_MIN_1024X768_HUAWEI_MODLE);
        if (QLog.isColorLevel()) {
          QLog.e("RMVideoStateMgr", 2, "isFoundProductFeature:need1024Black=" + paramBoolean);
        }
        if (paramBoolean)
        {
          anhm.dGc = 1024;
          anhm.dGd = 768;
          if (QLog.isColorLevel()) {
            QLog.e("RMVideoStateMgr", 2, "isFoundProductFeature:true[1024*768]");
          }
        }
        else
        {
          anhm.dGc = 320;
          anhm.dGd = 240;
        }
      }
    }
    if (paramInt1 == 1)
    {
      PtvFilterUtils.Vb(0);
      AudioCapture.BUF_SIZE = 4000;
      AudioCapture.dyq = 1;
      aniq.dHo = 1;
      aniq.dQu();
    }
    for (;;)
    {
      int i;
      try
      {
        VideoEnvironment.a(paramAppInterface, paramString, paramBoolean);
        VideoEnvironment.dPy();
        paramAppInterface = VideoEnvironment.a(paramInt2, false);
        if (a(paramAppInterface))
        {
          i = b(paramAppInterface);
          anhm.dGc = paramAppInterface[0];
          anhm.dGd = paramAppInterface[1];
          paramInt4 = paramAppInterface[2];
          paramInt1 = paramAppInterface[3];
          Gu(i);
          paramAppInterface = VideoEnvironment.q(paramInt2);
          if (paramInt3 != 1) {
            continue;
          }
          paramInt2 = paramAppInterface[0];
          if (paramInt2 != 0) {
            break label1493;
          }
          if (paramInt4 > 0)
          {
            VideoEnvironment.UQ(paramInt4);
            VideoEnvironment.UP(paramInt4);
            this.cjL = paramInt4;
          }
          this.bzb = true;
          this.cjK = 2;
        }
      }
      catch (Throwable paramAppInterface)
      {
        paramAppInterface.printStackTrace();
        continue;
        anhm.dGc = anhm.ny[1];
        anhm.dGd = anhm.nz[1];
        paramInt4 = 450;
        paramInt1 = 750;
        i = 1;
        continue;
        if ((paramInt3 == 4) || (paramInt3 == 3))
        {
          paramInt2 = paramAppInterface[1];
          continue;
        }
        paramInt2 = paramAppInterface[2];
        continue;
      }
      if (paramInt1 == 2)
      {
        PtvFilterUtils.Vb(1);
        aniq.dFO = 0;
        aniq.dHo = 0;
        aniq.dQu();
      }
      for (;;)
      {
        try
        {
          VideoEnvironment.a(paramAppInterface, paramString, false);
          VideoEnvironment.dPy();
          paramAppInterface = VideoEnvironment.a(paramInt2, true);
          if (a(paramAppInterface))
          {
            i = c(paramAppInterface);
            anhm.dGc = paramAppInterface[0];
            anhm.dGd = paramAppInterface[1];
            paramInt4 = paramAppInterface[2];
            paramInt1 = paramAppInterface[3];
            Gu(i);
            paramAppInterface = VideoEnvironment.q(paramInt2);
            if (paramInt3 != 1) {
              continue;
            }
            paramInt2 = paramAppInterface[0];
            if (paramInt2 != 0) {
              break label1487;
            }
            if (paramInt4 > 0)
            {
              VideoEnvironment.UQ(paramInt4);
              VideoEnvironment.UP(paramInt4);
              paramBoolean = bool1;
              if (paramInt2 == 1) {
                paramBoolean = true;
              }
              VideoEnvironment.bT(paramInt4, paramBoolean);
              this.cjL = paramInt4;
            }
            this.cjK = 3;
            AudioCapture.BUF_SIZE = 4000;
            AudioCapture.dyq = 1;
            CX(true);
            paramInt2 = imm.getNumCores();
            paramInt1 = paramInt2;
            if (paramInt2 > 4) {
              paramInt1 = 4;
            }
            paramInt2 = paramInt1;
            if (paramInt1 <= 0) {
              paramInt2 = 2;
            }
            paramInt1 = paramInt2;
            if (paramInt2 != 1)
            {
              paramInt1 = paramInt2;
              if (paramInt2 % 2 != 0) {
                paramInt1 = 2;
              }
            }
            PtvFilterUtils.Vc(paramInt1);
          }
        }
        catch (Throwable paramAppInterface)
        {
          paramAppInterface.printStackTrace();
          continue;
          anhm.dGc = anhm.ns[0];
          anhm.dGd = anhm.nt[0];
          paramInt4 = 450;
          paramInt1 = 750;
          i = 0;
          continue;
          if ((paramInt3 == 4) || (paramInt3 == 3))
          {
            paramInt2 = paramAppInterface[1];
            continue;
          }
          paramInt2 = paramAppInterface[2];
          continue;
        }
        if (paramInt1 == 3)
        {
          PtvFilterUtils.Vb(1);
          aniq.dFO = 0;
          aniq.dHo = 0;
          aniq.dQu();
        }
        for (;;)
        {
          try
          {
            VideoEnvironment.a(paramAppInterface, paramString, false);
            VideoEnvironment.dPy();
            paramAppInterface = VideoEnvironment.a(paramInt2, true);
            if (a(paramAppInterface))
            {
              j = c(paramAppInterface);
              anhm.dGc = paramAppInterface[0];
              anhm.dGd = paramAppInterface[1];
              i = paramAppInterface[2];
              paramInt1 = paramAppInterface[3];
              Gu(j);
              paramAppInterface = VideoEnvironment.q(paramInt2);
              if (paramInt3 != 1) {
                continue;
              }
              paramInt2 = paramAppInterface[0];
              if (paramInt2 != 0) {
                break label1481;
              }
              if (i > 0)
              {
                VideoEnvironment.UR(paramInt4);
                VideoEnvironment.UP(i);
                paramBoolean = bool2;
                if (paramInt2 == 1) {
                  paramBoolean = true;
                }
                VideoEnvironment.bT(i, paramBoolean);
                this.cjL = i;
              }
              this.cjK = 3;
              AudioCapture.BUF_SIZE = 4000;
              AudioCapture.dyq = 1;
              CX(true);
              paramInt2 = imm.getNumCores();
              paramInt1 = paramInt2;
              if (paramInt2 > 4) {
                paramInt1 = 4;
              }
              paramInt2 = paramInt1;
              if (paramInt1 <= 0) {
                paramInt2 = 2;
              }
              if ((paramInt2 == 1) || (paramInt2 % 2 == 0)) {
                break label1475;
              }
              paramInt1 = k;
              PtvFilterUtils.Vc(paramInt1);
            }
          }
          catch (Throwable paramAppInterface)
          {
            paramAppInterface.printStackTrace();
            continue;
            anhm.dGc = anhm.ns[1];
            anhm.dGd = anhm.nt[1];
            i = 450;
            paramInt1 = 750;
            int j = 1;
            continue;
            if ((paramInt3 == 4) || (paramInt3 == 3))
            {
              paramInt2 = paramAppInterface[1];
              continue;
            }
            paramInt2 = paramAppInterface[2];
            continue;
          }
          if (paramInt1 == 4)
          {
            PtvFilterUtils.Vb(0);
            if (QLog.isColorLevel()) {
              QLog.d("FlowCameraActivity", 2, "initVideoParams(): ptvMaxTime=" + paramInt4);
            }
            aniq.dFO = 0;
            aniq.dHo = 0;
            aniq.dQu();
            aniq.dGY = paramInt4 * 1000;
            VideoEnvironment.dPz();
            aniq.dHc = 18;
            paramBoolean = anii.isFoundProductFeature(anii.KEY_PREVIEW_DATA_LENGTH_MIN_640X480_MODLE);
            if (QLog.isColorLevel()) {
              QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:need640Black=" + paramBoolean);
            }
            if (paramBoolean)
            {
              anhm.dGc = 640;
              anhm.dGd = 480;
              if (QLog.isColorLevel()) {
                QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:true[640*480]");
              }
            }
            for (;;)
            {
              this.cjK = 4;
              AudioCapture.BUF_SIZE = 4000;
              return;
              paramBoolean = anii.isFoundProductFeature(anii.KEY_PREVIEW_DATA_LENGTH_MIN_1024X768_HUAWEI_MODLE);
              if (QLog.isColorLevel()) {
                QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:need1024Black=" + paramBoolean);
              }
              if (paramBoolean)
              {
                anhm.dGc = 1024;
                anhm.dGd = 768;
                if (QLog.isColorLevel()) {
                  QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:true[1024*768]");
                }
              }
              else
              {
                anhm.dGc = 640;
                anhm.dGd = 480;
              }
            }
          }
          if (paramInt1 != 5) {
            break;
          }
          PtvFilterUtils.Vb(0);
          aniq.dFO = 0;
          aniq.dHo = 0;
          aniq.dQu();
          aniq.dGY = paramInt4 * 1000;
          VideoEnvironment.dPz();
          aniq.dHc = 18;
          paramBoolean = anii.isFoundProductFeature(anii.KEY_PREVIEW_DATA_LENGTH_MIN_640X480_MODLE);
          if (QLog.isColorLevel()) {
            QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:need640Black=" + paramBoolean);
          }
          if (paramBoolean)
          {
            anhm.dGc = 640;
            anhm.dGd = 480;
            if (QLog.isColorLevel()) {
              QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:true[640*480]");
            }
          }
          for (;;)
          {
            this.cjK = 5;
            AudioCapture.BUF_SIZE = 4000;
            return;
            paramBoolean = anii.isFoundProductFeature(anii.KEY_PREVIEW_DATA_LENGTH_MIN_1024X768_HUAWEI_MODLE);
            if (QLog.isColorLevel()) {
              QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:need1024Black=" + paramBoolean);
            }
            if (paramBoolean)
            {
              anhm.dGc = 1024;
              anhm.dGd = 768;
              if (QLog.isColorLevel()) {
                QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:true[1024*768]");
              }
            }
            else
            {
              anhm.dGc = 1024;
              anhm.dGd = 768;
            }
          }
          label1475:
          paramInt1 = paramInt2;
          continue;
          label1481:
          i = paramInt1;
        }
        label1487:
        paramInt4 = paramInt1;
      }
      label1493:
      paramInt4 = paramInt1;
    }
  }
  
  public void a(PreviewContext paramPreviewContext)
  {
    if (this.mCamera != null) {
      this.mCamera.dGT = this.cjK;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext = paramPreviewContext;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame = true;
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      a().a(paramObject, paramInt, paramVarArgs);
    }
    do
    {
      return;
    } while ((!anim.c.class.isInstance(paramObject)) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext == null));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame = true;
  }
  
  public boolean a(Context paramContext, String paramString, aatf paramaatf)
  {
    changeState(1);
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    anhm.SCREEN_WIDTH = localDisplayMetrics.widthPixels;
    anhm.SCREEN_HEIGHT = localDisplayMetrics.heightPixels;
    this.isReleased = false;
    this.mContext = paramContext;
    this.bL = 0.0D;
    this.bzc = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext = null;
    this.byX = false;
    this.byY = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture = null;
    this.jdField_a_of_type_Aatf = paramaatf;
    this.cb.set(false);
    this.bzi = true;
    if (QLog.isColorLevel()) {
      QLog.i("RMVideoStateMgr", 2, "rmStateMgr onCreate viewST:" + this.jdField_a_of_type_Aatf + "\n videoStateMgr:" + e);
    }
    if (!a(paramContext, paramString, anhm.nu[4], anhm.nu[5]))
    {
      if (QLog.isColorLevel()) {
        QLog.e("RMVideoStateMgr", 2, "initTMMEngine[failed]");
      }
      if (1 == aaqi.ciB) {
        awed.ad(paramString, "qzone_video_record", "0", null);
      }
      return false;
    }
    try
    {
      this.jdField_a_of_type_Anka = new anka(anhm.zR());
      setBeautyLevel(1);
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a = ((RMVideoSwitchCameraPicMgr.b)paramContext);
        aniu.a().a().addCodecCallback(this);
        aniu.a().b().a(this);
        anld.a();
        if ((this.aK.getAndIncrement() > 0) && (this.jdField_a_of_type_Aatf != null))
        {
          this.jdField_a_of_type_Aatf.cwF();
          aniu.a().a().yR();
          aniu.a().destory();
        }
        aniu.a().a().a(this);
        aniu.a().a().startTimer();
        if ((this.bzg) && (this.jdField_b_of_type_Aman == null)) {
          this.jdField_b_of_type_Aman = new aman();
        }
        return true;
      }
      catch (ClassCastException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
      return false;
    }
    catch (RuntimeException paramContext) {}
  }
  
  public boolean a(int[] paramArrayOfInt)
  {
    return (paramArrayOfInt != null) && (paramArrayOfInt.length == 4) && (paramArrayOfInt[0] > 0) && (paramArrayOfInt[1] > 0);
  }
  
  public float aC()
  {
    if ((this.jdField_b_of_type_Aasx.cjJ <= 0) || (this.jdField_b_of_type_Aasx.cjI <= 0)) {
      return 1.333333F;
    }
    return this.jdField_b_of_type_Aasx.cjI * 1.0F / this.jdField_b_of_type_Aasx.cjJ;
  }
  
  public void aYk()
  {
    if (this.isReleased) {
      return;
    }
    aniu.a().a().yR();
    aniu.a().a().a(null);
    aniu.a().a().removeCodecCallback(this);
    aniu.a().a().recycle();
    aniu.a().b().recycle();
    aniu.a().destory();
    try
    {
      anhm.unInit();
      anld.a().release();
      this.isReleased = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
      }
    }
  }
  
  public void b(int paramInt1, aasx paramaasx, int paramInt2)
  {
    switch (paramInt1)
    {
    case 3: 
    default: 
      return;
    case 1: 
      paramaasx.cjE = paramInt2;
      paramaasx.cjF = (paramaasx.cjJ - paramaasx.cjG);
      return;
    case 2: 
      paramaasx.cjE = paramInt2;
      paramaasx.cjF = 0;
      return;
    case 4: 
      paramaasx.cjE = (paramaasx.cjI - paramaasx.cjH - paramInt2);
      paramaasx.cjF = (paramaasx.cjJ - paramaasx.cjG);
      return;
    case 5: 
      paramaasx.cjE = (paramaasx.cjI - paramaasx.cjH - paramInt2);
      paramaasx.cjF = 0;
      return;
    }
    paramaasx.cjE = 0;
    paramaasx.cjF = (-(paramaasx.cjJ - paramaasx.cjG) / 2);
  }
  
  public void be(int paramInt, boolean paramBoolean)
  {
    this.businessType = paramInt;
    boolean bool2 = VideoEnvironment.awR();
    if ((paramBoolean) && (bool2)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.bzf = bool1;
      Xj();
      if (QLog.isColorLevel()) {
        QLog.i("RMVideoStateMgr", 2, "mediacodec set businessType:" + this.businessType + ", isSoload:" + paramBoolean + ", isDeviceSupport:" + bool2 + ", isSurpportFilter:" + this.bzf);
      }
      return;
    }
  }
  
  public void c(amae paramamae)
  {
    this.jdField_b_of_type_Amae = paramamae;
  }
  
  public void cyf()
  {
    this.bL = 0.0D;
    aniu.a().a().reset();
    if (aniu.a().a().thread.getState() == Thread.State.TERMINATED)
    {
      aniu.a().destory();
      aniu.a().a().a(this);
      aniu.a().a().startTimer();
    }
  }
  
  public void cyg()
  {
    cyj();
    this.byZ = false;
    if (QLog.isColorLevel()) {
      QLog.e("RMVideoStateMgr", 2, "[enterRecordMode]currentState = " + this.aL.get() + " mCurrentSegInvalid=" + this.byZ);
    }
    a().cxZ();
  }
  
  public void cyh()
  {
    this.bze = true;
    if (QLog.isColorLevel()) {
      QLog.e("RMVideoStateMgr", 2, "startHwRecorder");
    }
  }
  
  public void cyi()
  {
    if (QLog.isColorLevel()) {
      QLog.e("RMVideoStateMgr", 2, "stopHwRecorder");
    }
    this.bze = false;
    if (this.jdField_b_of_type_Aman != null) {
      this.jdField_b_of_type_Aman.stopRecording();
    }
    this.cjM = 0;
  }
  
  public void cyk()
  {
    synchronized (this.mlock)
    {
      this.bzh = true;
      this.mlock.notifyAll();
      return;
    }
  }
  
  public void cyl()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, "[@][initAudioRecord]mIsAudioReady=" + this.byX + " mAI=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture);
    }
    if (!Xh())
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture = new AudioCapture(this.mContext);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.a(this);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.init();
    }
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, "[@][initAudioRecord]");
    }
  }
  
  public void cym()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.dJZ();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.dQg();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.d.getAndSet(this.jdField_a_of_type_Anka);
    }
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, "[@][openAudioRecord]");
    }
  }
  
  public void cyn()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, "[@][closeAudioRecord]mIsAudioReady=" + this.byX + " mAI=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture);
    }
    if (Xh())
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.b(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture$a);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.destory();
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoStateMgr", 2, "[@][closeAudioRecord]");
      }
    }
    this.byX = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture = null;
    this.byY = false;
  }
  
  public boolean hA(int paramInt)
  {
    try
    {
      setResolutionAlignedByteNative(paramInt);
      return true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return false;
  }
  
  public boolean hB(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RMVideoStateMgr", 2, "mediacodec from:" + paramInt + ", isMediaCodecSupport:" + this.bzg);
    }
    return this.bzg;
  }
  
  public boolean hC(int paramInt)
  {
    int j = this.cjN;
    int i = j;
    if (j <= 0)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
        i = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, " checkVideoFrameCount frameCount = " + i);
    }
    return i >= paramInt;
  }
  
  public void j(int paramInt, String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aatf != null) {
      this.jdField_a_of_type_Aatf.k(paramInt, paramString, paramBoolean);
    }
  }
  
  public void l(int paramInt, String paramString, boolean paramBoolean)
  {
    Toast.makeText(VideoEnvironment.getContext(), "" + paramString, 0).show();
  }
  
  public void onAVCodecEvent(AVCodec.AVCodecCallback arg1, MessageStruct paramMessageStruct)
  {
    a().onAVCodecEvent(???, paramMessageStruct);
    if (paramMessageStruct.mId == 33554451)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoStateMgr", 2, "[@] onAVCodecEvent, MSG_RECORD_SUBMIT_FINISH_CALLBACK");
      }
      synchronized (this.cb)
      {
        this.cb.set(true);
        this.cb.notifyAll();
        if (QLog.isColorLevel()) {
          QLog.d("RMVideoStateMgr", 2, "[@] onAVCodecEvent, MSG_RECORD_SUBMIT_FINISH_CALLBACK ,notifyAll");
        }
        return;
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.aK.decrementAndGet() == 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mActivtiyDestory = true;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext = null;
      }
      this.mContext = null;
      if (QLog.isColorLevel()) {
        QLog.i("RMVideoStateMgr", 2, "rmStateMgr onDestroy viewST:" + this.jdField_a_of_type_Aatf + "\n videoStateMgr:" + e);
      }
      this.jdField_a_of_type_Aatf.cwF();
      this.jdField_a_of_type_Aatf = null;
      this.jdField_a_of_type_Aasz.onPause();
      this.jdField_a_of_type_Aasz.onStop();
      this.jdField_a_of_type_Aasy.onPause();
      this.jdField_a_of_type_Aasy.onStop();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture = null;
      stopWatching();
      this.jdField_a_of_type_Aasw = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a = null;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture$a = null;
      aYk();
      this.businessType = 0;
      this.bzf = false;
      this.bzg = false;
    }
    if (this.mCamera != null) {
      this.mCamera.jdField_b_of_type_Anil = null;
    }
    this.mCamera = null;
  }
  
  public void onPause()
  {
    anhm.ahI();
    a().onPause();
    anld.a().a(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$a.mPaused = true;
  }
  
  public void onResume()
  {
    if (this.bzd) {
      anhm.ahH();
    }
    anld.a().a(this);
    a().initState();
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) && (this.mCamera != null) && (!this.mCamera.aZC)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$a.bzj = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$a.mPaused = false;
  }
  
  int p(int paramInt, boolean paramBoolean)
  {
    int i = paramInt;
    if (aH(paramBoolean))
    {
      int j = paramInt % 16;
      i = paramInt;
      if (j > 0) {
        i = paramInt + (16 - j);
      }
    }
    return i;
  }
  
  public void r(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    stopWatching();
    int i = 0;
    while (i < paramInt2)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.removeLatestVideo();
      if (paramBoolean) {
        AVCodec.get().removeLastCapture();
      }
      i += 1;
    }
    this.bL = paramInt1;
    aniu.a().a().UV(paramInt1);
    if (this.aL.getAndAdd(0) < 3) {
      startWatching();
    }
  }
  
  public void runOnUiThread(Runnable paramRunnable)
  {
    this.mHandler.post(paramRunnable);
  }
  
  public void setBeautyLevel(int paramInt)
  {
    try
    {
      setBeautyLevelNative(paramInt);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public void startWatching()
  {
    if ((this.jdField_a_of_type_Aasw != null) && (this.bL > 0.0D)) {
      this.jdField_a_of_type_Aasw.startWatching();
    }
  }
  
  public void stopWatching()
  {
    if (this.jdField_a_of_type_Aasw != null) {
      this.jdField_a_of_type_Aasw.stopWatching();
    }
  }
  
  public void tl(int paramInt)
  {
    changeState(paramInt);
    a().initState();
  }
  
  public int yX()
  {
    return this.cjK;
  }
  
  public int yY()
  {
    int k = aniq.dGY;
    int j = k / 1000;
    int i = j;
    if (k % 1000 >= 500) {
      i = j + 1;
    }
    return i;
  }
  
  public int yZ()
  {
    return aniq.dGY * 10 / 1000;
  }
  
  public static class a
  {
    public boolean bzj;
    public boolean mPaused;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr
 * JD-Core Version:    0.7.0.1
 */