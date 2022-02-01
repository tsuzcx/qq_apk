import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.initializer.FaceDetectInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

public class ankq
{
  private static ankq.a a = new ankq.a();
  private static final String bvQ = acbn.SDCARD_PATH + "early";
  private static boolean cHF;
  private static boolean cHG;
  private static boolean cHH;
  private static boolean cHI;
  private static boolean cHJ;
  private static boolean cHK;
  private static final Object eU;
  private static final String[] gN = { "qq.android.native.short.video.filter.const", "qq.android.native.short.video.filter.const.v1", "qq.android.native.short.video.filter.const.v2", "qq.android.native.short.video.filter.const.v3", "qq.android.native.short.video.filter.const.v4", "qq.android.native.short.video.filter.const.v665", "qq.android.native.short.video.filter.const.v700" };
  private static final String[] gO = { "qq.android.native.short.video.filter.var", "qq.android.native.short.video.filter.var.v1", "qq.android.native.short.video.filter.var.v2", "qq.android.native.short.video.filter.var.v3", "qq.android.native.short.video.filter.var.v665" };
  private static final String[] gP = { "qq.android.native.short.video.x86", "qq.android.native.short.video", "qq.android.native.short.video.v658", "qq.android.native.short.video.v660", "qq.android.native.short.video.v665", "qq.android.native.short.video.v670", "qq.android.native.short.video.v700" };
  
  static
  {
    atao.init();
    eU = new Object();
  }
  
  public static int JS()
  {
    int i;
    if (ayb()) {
      if (bz(BaseApplicationImpl.getContext())) {
        i = 1;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterSoLoad", 2, "getQmcfSoState:" + i);
      }
      return i;
      i = 2;
      continue;
      i = 0;
    }
  }
  
  public static String a(Context paramContext, int[] paramArrayOfInt)
  {
    paramArrayOfInt = anfi.zt();
    if (paramArrayOfInt.equals("Pendant000_0"))
    {
      VideoEnvironment.k("PtvFilterSoLoad", "getSVFilterSoPath:pathVersion=Pendant000_0", null);
      return null;
    }
    return aK(paramContext) + paramArrayOfInt + File.separator;
  }
  
  /* Error */
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, axce.a parama)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc 2
    //   5: monitorenter
    //   6: invokestatic 173	ankq:axZ	()Z
    //   9: istore 5
    //   11: iload 5
    //   13: ifeq +64 -> 77
    //   16: aload_0
    //   17: invokestatic 179	angj:bB	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   20: pop
    //   21: aload_1
    //   22: invokestatic 182	ankq:by	(Landroid/content/Context;)Z
    //   25: istore_3
    //   26: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +43 -> 72
    //   32: ldc 131
    //   34: iconst_2
    //   35: new 43	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   42: ldc 184
    //   44: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: iload_3
    //   48: invokevirtual 187	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: ldc 189
    //   53: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: iload 5
    //   58: invokevirtual 187	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   61: ldc 191
    //   63: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 194	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: ldc 2
    //   74: monitorexit
    //   75: iload_3
    //   76: ireturn
    //   77: iload 4
    //   79: istore_3
    //   80: aload_2
    //   81: ifnull -55 -> 26
    //   84: aload_2
    //   85: getstatic 200	axcd:c	Laxcd;
    //   88: aconst_null
    //   89: iconst_0
    //   90: iconst_m1
    //   91: invokeinterface 205 5 0
    //   96: iload 4
    //   98: istore_3
    //   99: goto -73 -> 26
    //   102: astore_0
    //   103: ldc 2
    //   105: monitorexit
    //   106: aload_0
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	paramQQAppInterface	QQAppInterface
    //   0	108	1	paramContext	Context
    //   0	108	2	parama	axce.a
    //   25	74	3	bool1	boolean
    //   1	96	4	bool2	boolean
    //   9	48	5	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   6	11	102	finally
    //   16	26	102	finally
    //   26	72	102	finally
    //   84	96	102	finally
  }
  
  public static int aB(Context paramContext)
  {
    int i;
    if (axZ()) {
      if (by(paramContext)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterSoLoad", 2, "getFilterSoState " + i);
      }
      return i;
      i = 2;
      continue;
      i = 0;
    }
  }
  
  public static String aK(Context paramContext)
  {
    return awtn.b.c.cST;
  }
  
  public static String aL(Context paramContext)
  {
    return awtn.b.c.cSU;
  }
  
  public static String aM(Context paramContext)
  {
    int[] arrayOfInt = new int[1];
    String str = a(paramContext, arrayOfInt);
    if (str != null) {}
    for (paramContext = str;; paramContext = "null")
    {
      VideoEnvironment.k("PtvFilterSoLoad", "getSVFilterSoPath:errCode=" + arrayOfInt[0] + ",pathLog=" + paramContext, null);
      return str;
    }
  }
  
  public static String aN(Context paramContext)
  {
    paramContext = anfo.zu();
    if (paramContext.equals("artfilter000_0"))
    {
      VideoEnvironment.k("PtvFilterSoLoad", "getValidArtFilterPath:pathVersion=artfilter000_0", null);
      return null;
    }
    return anfo.zv() + paramContext + File.separator;
  }
  
  public static String aO(Context paramContext)
  {
    paramContext = angs.zH();
    if (paramContext.equals("Tracking000_0"))
    {
      VideoEnvironment.k("PtvFilterSoLoad", "getTrackingBasePath:pathVersion=Tracking000_0", null);
      return null;
    }
    return angs.zI() + paramContext + File.separator;
  }
  
  public static boolean awy()
  {
    return anfi.awy();
  }
  
  public static boolean axX()
  {
    try
    {
      if (!FeatureManager.isBasicFeaturesFunctionReady())
      {
        awtj.init();
        bool = FeatureManager.loadBasicFeatures();
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterSoLoad", 2, "SoLoader.loadSvFilterSo success:" + bool);
        }
      }
      boolean bool = FeatureManager.isBasicFeaturesFunctionReady();
      return bool;
    }
    finally {}
  }
  
  public static boolean axY()
  {
    return FeatureManager.Features.FACE_DETECT.isAllSoVersionOk();
  }
  
  public static boolean axZ()
  {
    int i;
    if ((anii.isFoundProductManufacturer(anii.KEY_BLACK_NOT_SUPPORT_FILTER_PHONE)) || (anii.isNotSupportFilterBasedSdk()))
    {
      i = 1;
      if (i == 0) {
        break label28;
      }
    }
    for (;;)
    {
      return false;
      i = 0;
      break;
      label28:
      boolean bool = imm.isBeautySupported();
      try
      {
        Class localClass = Class.forName("android.opengl.EGL14");
        if ((!bool) || (localClass == null) || (Build.VERSION.SDK_INT < 17)) {
          continue;
        }
        return true;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;)
        {
          Object localObject = null;
        }
      }
    }
  }
  
  public static boolean aya()
  {
    boolean bool1 = ankq.b.aye();
    boolean bool2 = VideoEnvironment.awT();
    return (bool1) && (bool2);
  }
  
  public static boolean ayb()
  {
    if (Build.VERSION.SDK_INT < 21) {}
    while (!QmcfManager.getInstance().isQmcfSupported()) {
      return false;
    }
    return true;
  }
  
  public static boolean ayc()
  {
    boolean bool3 = false;
    if (cHH) {
      return cHJ;
    }
    boolean bool4 = anki.axL();
    if (!anii.isInARParticleBackList()) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool5 = hasGyroscope();
      boolean bool2 = bool3;
      if (bool4)
      {
        bool2 = bool3;
        if (bool1)
        {
          bool2 = bool3;
          if (bool5) {
            bool2 = true;
          }
        }
      }
      cHJ = bool2;
      cHH = true;
      if (QLog.isColorLevel()) {
        QLog.i("PtvFilterSoLoad", 2, "isSupportARParticle switchOpen:" + bool4 + ", notInBlackList:" + bool1 + ", hasGyroscope:" + bool5 + ", isSupportARParticle:" + cHJ);
      }
      return cHJ;
    }
  }
  
  public static boolean ayd()
  {
    cHK = true;
    return cHK;
  }
  
  public static boolean by(Context paramContext)
  {
    return ankq.b.by(paramContext);
  }
  
  public static boolean bz(Context paramContext)
  {
    return ankq.b.bz(paramContext);
  }
  
  public static void dRg()
  {
    int k = 0;
    Object localObject = new File(bvQ);
    if (!((File)localObject).exists()) {}
    for (;;)
    {
      return;
      localObject = ((File)localObject).getAbsolutePath() + File.separator;
      int i = 0;
      File localFile;
      while (i < gN.length)
      {
        localFile = new File((String)localObject + gN[i]);
        if (localFile.exists()) {
          localFile.delete();
        }
        i += 1;
      }
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= gO.length) {
          break;
        }
        localFile = new File((String)localObject + gO[i]);
        if (localFile.exists()) {
          localFile.delete();
        }
        i += 1;
      }
      while (j < gP.length)
      {
        localFile = new File((String)localObject + gP[j]);
        if (localFile.exists()) {
          localFile.delete();
        }
        j += 1;
      }
    }
  }
  
  public static void dRh()
  {
    if (!cHF)
    {
      cHF = true;
      ThreadManager.post(new PtvFilterSoLoad.1(), 5, null, false);
    }
  }
  
  public static boolean f(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    try
    {
      boolean bool = a(paramQQAppInterface, paramContext, null);
      return bool;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  private static boolean hasGyroscope()
  {
    return BaseApplicationImpl.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.gyroscope");
  }
  
  public static boolean isSupportPortarit()
  {
    boolean bool4 = false;
    if (cHG) {
      return cHI;
    }
    boolean bool1;
    if (Build.VERSION.SDK_INT >= 21)
    {
      bool1 = true;
      if (anga.awE()) {
        break label126;
      }
    }
    label126:
    for (boolean bool2 = true;; bool2 = false)
    {
      boolean bool5 = anki.isPortraitSwitchOpen();
      boolean bool3 = bool4;
      if (bool1)
      {
        bool3 = bool4;
        if (bool2)
        {
          bool3 = bool4;
          if (bool5) {
            bool3 = true;
          }
        }
      }
      cHI = bool3;
      cHG = true;
      if (QLog.isColorLevel()) {
        QLog.i("PtvFilterSoLoad", 2, "isSupportPortarit sdkSupport:" + bool1 + ", whiteList:" + bool2 + ", switchOpen:" + bool5);
      }
      return cHI;
      bool1 = false;
      break;
    }
  }
  
  public static boolean pn(String paramString)
  {
    return ankq.b.pn(paramString);
  }
  
  public static class a
  {
    public AtomicInteger bQ = new AtomicInteger(0);
  }
  
  public static class b
  {
    public static int SV_SO_LOAD_STATUS_artfilter = -4;
    public static final String[] SV_SO_QMCF_SNPE = { "libgnustl_shared.so", "libSNPE.so", "libQMCF_snpe.so" };
    public static int[] SV_SO_QMCF_SNPE_LOAD_STATUS = { -4, -4, -4 };
    
    public static boolean aye()
    {
      return FeatureManager.isBasicFeaturesFunctionReady();
    }
    
    public static boolean by(Context paramContext)
    {
      paramContext = ankq.aM(paramContext);
      if (paramContext == null)
      {
        VideoEnvironment.k("PtvFilterSoLoad", "isFilterSoExist:getSVFilterSoPath soRootPath=null", null);
        return false;
      }
      if (!new File(paramContext).exists())
      {
        VideoEnvironment.k("PtvFilterSoLoad", "isFilterSoExist:getSVFilterSoPath soRootPath=" + paramContext + ",exists=false", null);
        return false;
      }
      return pn(paramContext);
    }
    
    public static boolean bz(Context arg0)
    {
      String str = ankq.aN(???);
      synchronized (ankq.eU)
      {
        boolean bool1 = aqhq.fileExists(str + "libQMCF.so");
        boolean bool2 = aqhq.fileExists(str + SV_SO_QMCF_SNPE[2]);
        if (QLog.isColorLevel()) {
          QLog.i("SVAF_SoLoad", 2, String.format("isArtFilterSoExist, qmcfso[%s], snpeso[%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
        }
        return bool1;
      }
    }
    
    public static boolean pn(String paramString)
    {
      return FeatureManager.isBasicFeaturesReadyInDir(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ankq
 * JD-Core Version:    0.7.0.1
 */