import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.codeEngine.MiniCodeController.1;
import com.tencent.mobileqq.ar.codeEngine.MiniCodeController.2;
import com.tencent.mobileqq.minicode.DecodeProxy;
import com.tencent.mobileqq.minicode.RecogUtil;
import com.tencent.mobileqq.minicode.YuvProxy;
import com.tencent.mobileqq.minicode.recog.MiniCodeDetector;
import com.tencent.mobileqq.minicode.recog.RecogCallback;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class adjn
  implements RecogCallback
{
  private static long Uh;
  private static boolean bNM;
  private static boolean bNN;
  private static boolean bNO;
  private static boolean bNP;
  public static volatile adjn c;
  private CopyOnWriteArrayList<WeakReference<adjn.c>> V = new CopyOnWriteArrayList();
  private boolean YW;
  private adfp jdField_a_of_type_Adfp;
  private MiniCodeDetector jdField_a_of_type_ComTencentMobileqqMinicodeRecogMiniCodeDetector;
  private boolean bNJ;
  private boolean bNK;
  private boolean bNL;
  private boolean bNQ;
  private boolean bNR;
  private boolean bNS = adfw.a().bML;
  private boolean bNT = adfw.a().bMM;
  private int cHj = -1;
  private Set<Long> cc = Collections.synchronizedSet(new HashSet());
  private CopyOnWriteArrayList<WeakReference<RecogCallback>> mRecogCallbacks = new CopyOnWriteArrayList();
  
  private adjn()
  {
    boolean bool = RecogUtil.isX86VM();
    if (bool)
    {
      this.bNT = false;
      this.bNS = false;
      QLog.i("MiniRecog.MiniCodeController", 1, String.format("init return [%b %b]", new Object[] { Boolean.valueOf(false), Boolean.valueOf(bool) }));
    }
    if ((!bNP) || (RecogUtil.getMiniScanErrorCnt(false) > 0))
    {
      bNP = true;
      ThreadManager.post(new MiniCodeController.2(this), 5, null, true);
    }
  }
  
  private adfp a()
  {
    try
    {
      if (this.jdField_a_of_type_Adfp == null) {
        this.jdField_a_of_type_Adfp = new adfp();
      }
      adfp localadfp = this.jdField_a_of_type_Adfp;
      return localadfp;
    }
    finally {}
  }
  
  public static adjn a()
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new adjn();
      }
      return c;
    }
    finally {}
  }
  
  public static boolean aeD()
  {
    return bNM;
  }
  
  public static boolean aeE()
  {
    return bNN;
  }
  
  public static int b(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!bNN) {}
    do
    {
      return -1;
      try
      {
        YuvProxy.Yuv2Rgba(paramArrayOfInt, paramArrayOfByte, paramInt1, paramInt2);
        return 0;
      }
      catch (Throwable paramArrayOfInt) {}
    } while (!QLog.isColorLevel());
    QLog.i("MiniRecog.MiniCodeController", 2, "Yuv2Rgba exception", paramArrayOfInt);
    return -1;
  }
  
  private void cSc()
  {
    if (bNM)
    {
      Iterator localIterator = this.V.iterator();
      while (localIterator.hasNext())
      {
        adjn.c localc = (adjn.c)((WeakReference)localIterator.next()).get();
        if (localc != null) {
          localc.cSf();
        }
      }
    }
  }
  
  public static boolean kX(String paramString)
  {
    return (paramString != null) && (paramString.length() > 0) && (!paramString.equals("____JAVA_EXCEPTION____")) && (!paramString.equals("____NATIVE_ERROR____")) && (!paramString.equals("____NATIVE_EXCEPTION____")) && (!paramString.startsWith("____NATIVE_ERROR____")) && (!paramString.startsWith("____NATIVE_EXCEPTION____"));
  }
  
  public void a(adjn.c paramc)
  {
    Iterator localIterator = this.V.iterator();
    while (localIterator.hasNext())
    {
      adjn.c localc = (adjn.c)((WeakReference)localIterator.next()).get();
      if ((localc != null) && (localc == paramc)) {
        return;
      }
    }
    this.V.add(new WeakReference(paramc));
  }
  
  public void a(RecogCallback paramRecogCallback)
  {
    Iterator localIterator = this.V.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      adjn.c localc = (adjn.c)localWeakReference.get();
      if ((localc != null) && (localc == paramRecogCallback)) {
        this.V.remove(localWeakReference);
      }
    }
  }
  
  public boolean a(Bitmap paramBitmap, long paramLong, Rect paramRect)
  {
    MiniCodeDetector localMiniCodeDetector = this.jdField_a_of_type_ComTencentMobileqqMinicodeRecogMiniCodeDetector;
    if ((!bNN) || (localMiniCodeDetector == null) || (paramRect == null)) {
      return false;
    }
    Object localObject = new Object();
    boolean bool2 = this.bNQ;
    int i;
    if (bool2) {
      i = 3000;
    }
    for (;;)
    {
      boolean[] arrayOfBoolean = new boolean[1];
      arrayOfBoolean[0] = false;
      paramRect = new adjo(this, paramRect, paramLong, localObject, localMiniCodeDetector, arrayOfBoolean, paramBitmap);
      boolean bool1;
      if ((bool2) && (localMiniCodeDetector.detect(paramBitmap, paramLong)))
      {
        bool1 = true;
        label97:
        arrayOfBoolean[0] = bool1;
        if ((bool2) && ((!bool2) || (arrayOfBoolean[0] == 0))) {
          break label231;
        }
        bool1 = true;
        label123:
        if (QLog.isColorLevel()) {
          QLog.i("MiniRecog.MiniCodeController", 2, String.format("detectSync needWait=%b bReady=%b exec=%b ts=%d", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(arrayOfBoolean[0]), Long.valueOf(paramLong) }));
        }
        if (bool1)
        {
          localMiniCodeDetector.addRecogCallback(paramRect);
          paramLong = i;
        }
      }
      try
      {
        localObject.wait(paramLong);
        localMiniCodeDetector.removeRecogCallback(paramRect);
        return arrayOfBoolean[0];
        i = 5000;
        continue;
        bool1 = false;
        break label97;
        label231:
        bool1 = false;
        break label123;
      }
      catch (InterruptedException paramBitmap)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.MiniCodeController", 2, "detectSync wait InterruptedException", paramBitmap);
          }
        }
      }
      finally {}
    }
  }
  
  public void addRecogCallback(RecogCallback paramRecogCallback)
  {
    Iterator localIterator = this.mRecogCallbacks.iterator();
    while (localIterator.hasNext())
    {
      RecogCallback localRecogCallback = (RecogCallback)((WeakReference)localIterator.next()).get();
      if ((localRecogCallback != null) && (localRecogCallback == paramRecogCallback)) {
        return;
      }
    }
    this.mRecogCallbacks.add(new WeakReference(paramRecogCallback));
  }
  
  public boolean aeF()
  {
    return this.bNQ;
  }
  
  public void ak(long paramLong, String paramString)
  {
    if (this.cc.contains(Long.valueOf(paramLong))) {
      this.cc.remove(Long.valueOf(paramLong));
    }
    boolean bool = this.cc.isEmpty();
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniCodeController", 2, String.format("onDestroy busiHash=%d desc=%s bDoDestroy=%b", new Object[] { Long.valueOf(paramLong), paramString, Boolean.valueOf(bool) }));
    }
    if (bool) {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqMinicodeRecogMiniCodeDetector != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqMinicodeRecogMiniCodeDetector.close();
          this.jdField_a_of_type_ComTencentMobileqqMinicodeRecogMiniCodeDetector = null;
        }
        if (this.jdField_a_of_type_Adfp != null) {
          this.jdField_a_of_type_Adfp.cRn();
        }
        this.YW = false;
        this.bNR = false;
        c = null;
        return;
      }
      finally {}
    }
  }
  
  public void cSd()
  {
    boolean bool1;
    boolean bool2;
    label48:
    Object localObject3;
    String str1;
    label93:
    label116:
    try
    {
      if ((this.bNS) && (!bNM))
      {
        bool1 = adjs.aeI();
        if (!bool1) {}
      }
      try
      {
        if (adjs.h("minicode") != 0) {
          break label525;
        }
        bool1 = true;
        bNM = bool1;
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          Object localObject1;
          QLog.i("MiniRecog.MiniCodeController", 1, "loadSoAndModel decode error", localThrowable1);
        }
      }
      if (this.cHj < 0) {
        break label553;
      }
      bool2 = true;
      if ((!this.bNT) || (!bool2)) {
        break label632;
      }
      localObject3 = adju.jP("QMCF_qr");
      str1 = adjt.sE();
      if ((TextUtils.isEmpty(str1)) || (!str1.equalsIgnoreCase((String)localObject3))) {
        break label559;
      }
      bool1 = true;
      if (!QLog.isColorLevel()) {
        break label654;
      }
      localObject1 = localObject3;
      if (localObject3 != null) {
        break label637;
      }
      localObject1 = "null";
    }
    finally {}
    QLog.i("MiniRecog.MiniCodeController", 2, String.format("loadSoAndModel detectSoMd5=%s modelNeedMd5=%s bMatch=%b", new Object[] { localObject1, localObject3, Boolean.valueOf(bool1) }));
    label525:
    label654:
    for (;;)
    {
      boolean bool3;
      if ((this.bNT) && (bool2) && (!bNN) && (bool1))
      {
        bool3 = adju.aeI();
        if (!bool3) {}
      }
      for (;;)
      {
        try
        {
          int i = adju.h("QMCF_qr");
          int j = adju.h("yuvutil");
          if ((i != 0) || (j != 0)) {
            continue;
          }
          bool3 = true;
          bNN = bool3;
        }
        catch (Throwable localThrowable2)
        {
          label553:
          label559:
          QLog.i("MiniRecog.MiniCodeController", 1, "loadSoAndModel detect error", localThrowable2);
          continue;
          Uh = 0L;
          continue;
          MiniCodeDetector localMiniCodeDetector = this.jdField_a_of_type_ComTencentMobileqqMinicodeRecogMiniCodeDetector;
          if (localMiniCodeDetector == null) {
            continue;
          }
          bool1 = true;
          continue;
          bool1 = false;
          continue;
        }
        if ((!this.bNT) || (!bool2) || (!bNN) || (!bool1) || (this.jdField_a_of_type_ComTencentMobileqqMinicodeRecogMiniCodeDetector != null)) {
          continue;
        }
        bool1 = adjt.aeI();
        if (!bool1) {
          continue;
        }
        try
        {
          if (Uh != 0L) {
            continue;
          }
          Uh = SystemClock.uptimeMillis();
          this.jdField_a_of_type_ComTencentMobileqqMinicodeRecogMiniCodeDetector = new MiniCodeDetector(null, this.cHj, 0, 0);
          this.jdField_a_of_type_ComTencentMobileqqMinicodeRecogMiniCodeDetector.addRecogCallback(this);
          localObject1 = adjt.sD() + File.separator + adjt.getFileName("qr_detection_model.bin");
          localObject3 = adjt.sD() + File.separator + adjt.getFileName("qr_detection_model.txt");
          str1 = adjt.sD() + File.separator + adjt.getFileName("qr_anchor.bin");
          String str2 = RecogUtil.getKernalBinPath();
          File localFile = new File(str2);
          if (!localFile.exists()) {
            localFile.mkdirs();
          }
          this.jdField_a_of_type_ComTencentMobileqqMinicodeRecogMiniCodeDetector.initEnv((String)localObject1, (String)localObject3, str1, str2);
          bool1 = true;
        }
        catch (Throwable localThrowable3)
        {
          QLog.i("MiniRecog.MiniCodeController", 1, "loadSoAndModel detect model error", localThrowable3);
          bool1 = false;
          continue;
        }
        QLog.i("MiniRecog.MiniCodeController", 1, String.format("loadSoAndModel bDecodeInited=%b bDetectInited=%b bSupportDetect=%b mDecodeDpcSwitch=%b mDetectDpcSwitch=%b bModelInited=%b iDetectRuntype=%d", new Object[] { Boolean.valueOf(bNM), Boolean.valueOf(bNN), Boolean.valueOf(bool2), Boolean.valueOf(this.bNS), Boolean.valueOf(this.bNT), Boolean.valueOf(bool1), Integer.valueOf(this.cHj) }));
        cSc();
        return;
        bool1 = false;
        break;
        bool2 = false;
        break label48;
        bool1 = false;
        break label93;
        bool3 = false;
      }
      label632:
      bool1 = false;
      continue;
      label637:
      localObject3 = str1;
      if (str1 != null) {
        break label116;
      }
      localObject3 = "null";
      break label116;
    }
  }
  
  public void cSe()
  {
    int i = 1;
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder("requestDownloadResourceIfNeed");
        if ((!bNM) && (!this.bNJ))
        {
          if (!adjs.aeI()) {
            continue;
          }
          this.bNJ = true;
          if (QLog.isColorLevel()) {
            localStringBuilder.append(" decode 0");
          }
        }
        if (this.cHj >= 0)
        {
          if ((this.bNT) && (i != 0) && (!bNN) && (!this.bNK))
          {
            if (!adju.aeI()) {
              break label224;
            }
            this.bNK = true;
            if (QLog.isColorLevel()) {
              localStringBuilder.append(" detect 0");
            }
          }
          if ((this.bNT) && (i != 0) && (this.jdField_a_of_type_ComTencentMobileqqMinicodeRecogMiniCodeDetector == null) && (!this.bNL))
          {
            if (!adjt.aeI()) {
              break label256;
            }
            this.bNL = true;
            if (QLog.isColorLevel()) {
              localStringBuilder.append(" model 0");
            }
          }
          if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
            QLog.i("MiniRecog.MiniCodeController", 2, localStringBuilder.toString());
          }
          return;
          if (this.jdField_a_of_type_Adfp != null) {
            this.jdField_a_of_type_Adfp.KS(0);
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          localStringBuilder.append(" decode 1");
          continue;
        }
        i = 0;
      }
      finally {}
      continue;
      label224:
      if (this.jdField_a_of_type_Adfp != null) {
        this.jdField_a_of_type_Adfp.KS(1);
      }
      if (QLog.isColorLevel())
      {
        localObject.append(" detect 1");
        continue;
        label256:
        if (this.jdField_a_of_type_Adfp != null) {
          this.jdField_a_of_type_Adfp.KS(2);
        }
        if (QLog.isColorLevel()) {
          localObject.append(" model 1");
        }
      }
    }
  }
  
  public String decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (!bNM) {
      return "";
    }
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniCodeController", 2, String.format("decode [w,h,barX,barY,barW,barH]=[%d,%d,%d,%d,%d,%d] mode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7) }));
    }
    try
    {
      if (!bNO)
      {
        String str = DecodeProxy.getVersion();
        QLog.i("MiniRecog.MiniCodeController", 1, "call nativeDecode version = " + str);
        if (QLog.isColorLevel()) {
          DecodeProxy.setLogSwitch(true);
        }
        bNO = true;
      }
      paramArrayOfByte = DecodeProxy.nativeDecode(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      QLog.i("MiniRecog.MiniCodeController", 2, "call nativeDecode error", paramArrayOfByte);
    }
    return "____JAVA_EXCEPTION____";
  }
  
  public boolean detect(Bitmap paramBitmap, long paramLong)
  {
    MiniCodeDetector localMiniCodeDetector = this.jdField_a_of_type_ComTencentMobileqqMinicodeRecogMiniCodeDetector;
    boolean bool1;
    if ((!bNN) || (!this.bNQ) || (localMiniCodeDetector == null)) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = localMiniCodeDetector.detect(paramBitmap, paramLong);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.i("MiniRecog.MiniCodeController", 2, String.format("detect async exec=%b ts=%d", new Object[] { Boolean.valueOf(bool2), Long.valueOf(paramLong) }));
    return bool2;
  }
  
  /* Error */
  public void h(android.content.Context paramContext, long paramLong, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 83	adjn:bNS	Z
    //   6: ifne +17 -> 23
    //   9: aload_0
    //   10: getfield 88	adjn:bNT	Z
    //   13: istore 5
    //   15: iload 5
    //   17: ifne +6 -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_1
    //   24: invokevirtual 457	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   27: astore_1
    //   28: aload_0
    //   29: getfield 73	adjn:cc	Ljava/util/Set;
    //   32: lload_2
    //   33: invokestatic 257	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   36: invokeinterface 458 2 0
    //   41: istore 5
    //   43: iload 5
    //   45: ifeq +37 -> 82
    //   48: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   51: ifeq +31 -> 82
    //   54: ldc 94
    //   56: iconst_2
    //   57: ldc_w 460
    //   60: iconst_2
    //   61: anewarray 4	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: lload_2
    //   67: invokestatic 257	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   70: aastore
    //   71: dup
    //   72: iconst_1
    //   73: aload 4
    //   75: aastore
    //   76: invokestatic 108	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   79: invokestatic 114	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: iload 5
    //   84: ifeq -64 -> 20
    //   87: aload_0
    //   88: invokespecial 462	adjn:a	()Ladfp;
    //   91: astore 4
    //   93: aload_0
    //   94: getfield 150	adjn:YW	Z
    //   97: ifne +80 -> 177
    //   100: aload_0
    //   101: getfield 175	adjn:bNR	Z
    //   104: istore 5
    //   106: iload 5
    //   108: ifne +69 -> 177
    //   111: aload_0
    //   112: iconst_1
    //   113: putfield 175	adjn:bNR	Z
    //   116: aload 4
    //   118: aload_1
    //   119: new 8	adjn$a
    //   122: dup
    //   123: aload_0
    //   124: aload 4
    //   126: invokespecial 465	adjn$a:<init>	(Ladjn;Ladfp;)V
    //   129: new 11	adjn$b
    //   132: dup
    //   133: aload_0
    //   134: aconst_null
    //   135: invokespecial 468	adjn$b:<init>	(Ladjn;Lcom/tencent/mobileqq/ar/codeEngine/MiniCodeController$1;)V
    //   138: invokevirtual 471	adfp:a	(Landroid/content/Context;Ladfh;Ladfk;)V
    //   141: getstatic 153	adjn:bNM	Z
    //   144: ifeq +7 -> 151
    //   147: aload_0
    //   148: invokespecial 396	adjn:cSc	()V
    //   151: aload_0
    //   152: invokevirtual 473	adjn:cSd	()V
    //   155: goto -135 -> 20
    //   158: astore_1
    //   159: aload_0
    //   160: monitorexit
    //   161: aload_1
    //   162: athrow
    //   163: astore_1
    //   164: ldc 94
    //   166: iconst_1
    //   167: ldc_w 475
    //   170: aload_1
    //   171: invokestatic 477	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   174: goto -33 -> 141
    //   177: aload_0
    //   178: invokevirtual 479	adjn:cSe	()V
    //   181: goto -40 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	adjn
    //   0	184	1	paramContext	android.content.Context
    //   0	184	2	paramLong	long
    //   0	184	4	paramString	String
    //   13	94	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	15	158	finally
    //   23	43	158	finally
    //   48	82	158	finally
    //   87	106	158	finally
    //   111	141	158	finally
    //   141	151	158	finally
    //   151	155	158	finally
    //   164	174	158	finally
    //   177	181	158	finally
    //   111	141	163	java/lang/RuntimeException
  }
  
  public void onDetectReady(int paramInt)
  {
    this.bNQ = true;
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniCodeController", 2, "onDetectReady");
    }
    Iterator localIterator = this.mRecogCallbacks.iterator();
    while (localIterator.hasNext())
    {
      RecogCallback localRecogCallback = (RecogCallback)((WeakReference)localIterator.next()).get();
      if (localRecogCallback != null) {
        localRecogCallback.onDetectReady(paramInt);
      }
    }
    long l;
    if (Uh > 0L)
    {
      l = SystemClock.uptimeMillis() - Uh;
      Uh = 0L;
    }
    for (;;)
    {
      ThreadManager.post(new MiniCodeController.1(this, paramInt, l), 5, null, true);
      return;
      l = 0L;
    }
  }
  
  public void onDetectResult(List<adjj> paramList, long paramLong)
  {
    Iterator localIterator = this.mRecogCallbacks.iterator();
    while (localIterator.hasNext())
    {
      RecogCallback localRecogCallback = (RecogCallback)((WeakReference)localIterator.next()).get();
      if (localRecogCallback != null) {
        localRecogCallback.onDetectResult(paramList, paramLong);
      }
    }
  }
  
  public void onSaveImg(long paramLong)
  {
    Iterator localIterator = this.mRecogCallbacks.iterator();
    while (localIterator.hasNext())
    {
      RecogCallback localRecogCallback = (RecogCallback)((WeakReference)localIterator.next()).get();
      if (localRecogCallback != null) {
        localRecogCallback.onSaveImg(paramLong);
      }
    }
  }
  
  public void removeRecogCallback(RecogCallback paramRecogCallback)
  {
    Iterator localIterator = this.mRecogCallbacks.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      RecogCallback localRecogCallback = (RecogCallback)localWeakReference.get();
      if ((localRecogCallback != null) && (localRecogCallback == paramRecogCallback)) {
        this.mRecogCallbacks.remove(localWeakReference);
      }
    }
  }
  
  class a
    extends adez
  {
    private final adfp d;
    
    public a(adfp paramadfp)
    {
      this.d = paramadfp;
    }
    
    public void zE()
    {
      adjn.a(adjn.this, true);
      adjn.b(adjn.this, false);
      boolean bool = this.d.adV();
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.MiniCodeController", 2, String.format("onConnectReady isMiniResConfigReady=%b", new Object[] { Boolean.valueOf(bool) }));
      }
      adjn.this.cSd();
      adjn.this.cSe();
    }
  }
  
  class b
    implements adfk
  {
    private int cHl;
    
    private b() {}
    
    public void KQ(int paramInt)
    {
      switch (paramInt)
      {
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MiniRecog.MiniCodeController", 2, String.format("onMiniDownloadSuccess type=%d", new Object[] { Integer.valueOf(paramInt) }));
        }
        adjn.this.cSd();
        return;
        adjn.c(adjn.this, true);
        continue;
        adjn.d(adjn.this, true);
        continue;
        adjn.e(adjn.this, true);
        this.cHl = 100;
      }
    }
    
    public void hk(int paramInt1, int paramInt2)
    {
      switch (paramInt1)
      {
      }
      while (paramInt1 == 0)
      {
        Iterator localIterator = adjn.a(adjn.this).iterator();
        while (localIterator.hasNext())
        {
          adjn.c localc = (adjn.c)((WeakReference)localIterator.next()).get();
          if (localc != null) {
            localc.La(this.cHl);
          }
        }
        this.cHl = paramInt2;
      }
    }
    
    public void hl(int paramInt1, int paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.MiniCodeController", 2, String.format("onMiniDownloadError type=%d error=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
      if (paramInt1 == 0)
      {
        Iterator localIterator = adjn.a(adjn.this).iterator();
        while (localIterator.hasNext())
        {
          adjn.c localc = (adjn.c)((WeakReference)localIterator.next()).get();
          if (localc != null) {
            localc.Lb(paramInt2);
          }
        }
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void La(int paramInt);
    
    public abstract void Lb(int paramInt);
    
    public abstract void cSf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adjn
 * JD-Core Version:    0.7.0.1
 */