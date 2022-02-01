package com.tencent.mobileqq.ar.arengine;

import adfw;
import adhz;
import adik;
import adix;
import adku;
import android.opengl.Matrix;
import anii;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.FramePerformanceMonitor;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ytcommon.util.YTCommonInterface;
import com.youtu.arsdk.AROption;
import com.youtu.arsdk.ARPatternInfo;
import com.youtu.arsdk.ARShell;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ARLocalMarkerRecog
{
  private long Tt;
  private long Tu;
  private long Tv;
  private long Tw;
  private long Tx;
  private long Ty;
  private ProcessWorker jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog$ProcessWorker;
  private a jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog$a;
  private AROption jdField_a_of_type_ComYoutuArsdkAROption;
  private FramePerformanceMonitor b;
  private boolean bNq;
  private boolean bNw;
  private boolean bNx;
  private float[] bW;
  private String btc = "";
  private final int cGD = 25;
  private final int cGE = 800;
  private int cGF = 2;
  private int cGG;
  private int cGH;
  private int cGI = -1;
  private int cGJ;
  private int cGK;
  private int cGL;
  private int cGM;
  private int cGN;
  private int cGO;
  private int cGP;
  private final int cGQ = 5000;
  private Object cZ = new Object();
  private int cns;
  private int cnu;
  private ArConfigInfo d;
  Object db = new Object();
  private Object dc = new Object();
  private Object dd = new Object();
  private Map<String, ArCloudConfigInfo> jD;
  private int mImageHeight;
  private int mImageWidth;
  private boolean mIsInited;
  private boolean mIsPause;
  private boolean mIsStarted;
  private ArrayList<ArCloudConfigInfo> ut;
  private ArrayList<b> uu;
  
  /* Error */
  private boolean aez()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 125	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:bNq	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +49 -> 57
    //   11: iload_1
    //   12: iconst_1
    //   13: iadd
    //   14: istore_2
    //   15: iload_2
    //   16: bipush 20
    //   18: if_icmpge +39 -> 57
    //   21: ldc2_w 130
    //   24: invokestatic 137	java/lang/Thread:sleep	(J)V
    //   27: iload_2
    //   28: istore_1
    //   29: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   32: ifeq -30 -> 2
    //   35: ldc 144
    //   37: iconst_2
    //   38: ldc 146
    //   40: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: iload_2
    //   44: istore_1
    //   45: goto -43 -> 2
    //   48: astore 4
    //   50: aload 4
    //   52: invokevirtual 152	java/lang/Exception:printStackTrace	()V
    //   55: iconst_1
    //   56: ireturn
    //   57: aload_0
    //   58: getfield 89	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:dd	Ljava/lang/Object;
    //   61: astore 4
    //   63: aload 4
    //   65: monitorenter
    //   66: ldc 144
    //   68: iconst_1
    //   69: ldc 154
    //   71: invokestatic 157	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: invokestatic 162	com/youtu/arsdk/ARShell:nativeStop	()Z
    //   77: pop
    //   78: ldc 144
    //   80: iconst_1
    //   81: ldc 164
    //   83: invokestatic 157	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: ldc 144
    //   88: iconst_1
    //   89: ldc 166
    //   91: invokestatic 157	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: invokestatic 169	com/youtu/arsdk/ARShell:nativeDestroy	()Z
    //   97: pop
    //   98: ldc 144
    //   100: iconst_1
    //   101: ldc 171
    //   103: invokestatic 157	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: aload 4
    //   108: monitorexit
    //   109: iconst_1
    //   110: ireturn
    //   111: astore 5
    //   113: aload 4
    //   115: monitorexit
    //   116: aload 5
    //   118: athrow
    //   119: astore 4
    //   121: goto -94 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	ARLocalMarkerRecog
    //   1	44	1	i	int
    //   14	30	2	j	int
    //   6	2	3	bool	boolean
    //   48	3	4	localException1	Exception
    //   119	1	4	localException2	Exception
    //   111	6	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	48	java/lang/Exception
    //   29	43	48	java/lang/Exception
    //   57	66	48	java/lang/Exception
    //   116	119	48	java/lang/Exception
    //   66	109	111	finally
    //   113	116	111	finally
    //   21	27	119	java/lang/Exception
  }
  
  private boolean b(String paramString1, String paramString2, ArCloudConfigInfo arg3)
  {
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "addNewMarkerDynamically. markerName = " + paramString1 + ", markerFilePath = " + paramString2);
    ARPatternInfo localARPatternInfo = new ARPatternInfo();
    int i = 0;
    while (i < ARShell.getMarkerCount())
    {
      localARPatternInfo.name = "";
      ARShell.getMarkerInfo(i, localARPatternInfo);
      if (localARPatternInfo.name.equals(paramString1))
      {
        QLog.i("ARCloudEngine", 1, "addNewMarkerDynamically. marker already exist.");
        return true;
      }
      i += 1;
    }
    this.jD.put(???.a.buc, ???);
    synchronized (this.dd)
    {
      QLog.i("ARCloudEngine", 1, "addNewMarkerDynamically start.");
      System.currentTimeMillis();
      QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeAddMarker start. markerName = " + paramString1);
      i = ARShell.nativeAddMarker(paramString1, paramString2);
      QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeAddMarker end. ret = " + i);
      QLog.i("AREngine_ARLocalMarkerRecog", 1, "addNewMarkerDynamically successfully.");
      return true;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, ArConfigInfo paramArConfigInfo, ArrayList<ArCloudConfigInfo> paramArrayList, a parama)
  {
    boolean bool1 = false;
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "init start. imageWidth = " + paramInt1 + ", imageHeight = " + paramInt2);
    long l1 = System.currentTimeMillis();
    if (this.mIsInited) {
      return true;
    }
    this.cns = 0;
    this.cnu = 0;
    this.mImageWidth = paramInt1;
    this.mImageHeight = paramInt2;
    this.d = paramArConfigInfo;
    this.ut = paramArrayList;
    this.uu = new ArrayList();
    this.jD = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog$a = parama;
    this.b = null;
    this.mIsInited = false;
    this.mIsStarted = false;
    this.bNw = false;
    this.bNx = false;
    this.bNq = false;
    this.cGJ = 0;
    this.cGK = 0;
    this.cGL = 0;
    this.cGM = 0;
    this.Tt = 0L;
    this.Tu = 0L;
    this.cGN = 0;
    this.btc = "";
    this.Ty = 0L;
    try
    {
      long l2 = System.currentTimeMillis();
      if (!ARShell.loadNativeLibrary())
      {
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. initAlgorithm failed. loadNativeLibrary failed.");
        adix.a().at(System.currentTimeMillis() - l2, false);
      }
      for (;;)
      {
        this.mIsInited = bool1;
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "init end. mIsInited = " + this.mIsInited);
        adix.a().as(System.currentTimeMillis() - l1, this.mIsInited);
        return this.mIsInited;
        adix.a().at(System.currentTimeMillis() - l2, true);
        boolean bool2 = aey();
        if (!bool2) {
          aez();
        }
        bool1 = bool2;
      }
    }
    catch (UnsatisfiedLinkError paramArConfigInfo)
    {
      for (;;)
      {
        paramArConfigInfo.printStackTrace();
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. initAlgorithm failed. loadNativeLibrary failed. UnsatisfiedLinkError.");
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (!this.mIsStarted) {
      return false;
    }
    if (!paramArCloudConfigInfo.bsN.equalsIgnoreCase("2.0"))
    {
      QLog.i("AREngine_ARLocalMarkerRecog", 1, "addNewMarkerDynamically failed. sdk version error. sdk version = " + paramArCloudConfigInfo.bsN);
      return false;
    }
    Object localObject = this.dc;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.uu.size())
        {
          if (((b)this.uu.get(i)).btd.equals(paramString1))
          {
            ((b)this.uu.get(i)).bte = paramString2;
            ((b)this.uu.get(i)).c = paramArCloudConfigInfo;
            return true;
          }
        }
        else
        {
          b localb = new b(null);
          localb.btd = paramString1;
          localb.bte = paramString2;
          localb.c = paramArCloudConfigInfo;
          localb.bNy = false;
          localb.bNz = false;
          this.uu.add(localb);
          this.Ty = System.currentTimeMillis();
          return true;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public float[] a(int paramInt1, int paramInt2)
  {
    if (!this.mIsInited) {
      return null;
    }
    if ((this.cns == paramInt1) && (this.cnu == paramInt2)) {
      return this.bW;
    }
    this.cns = paramInt1;
    this.cnu = paramInt2;
    float[] arrayOfFloat = new float[16];
    ARShell.getProjectionMatrix(25.0F, 800.0F, arrayOfFloat, false);
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. getProjectionMatrix. proMatrix[0] = " + arrayOfFloat[0] + ", proMatrix[1] = " + arrayOfFloat[1] + ", proMatrix[2] = " + arrayOfFloat[2] + ", proMatrix[3] = " + arrayOfFloat[3] + ", proMatrix[4] = " + arrayOfFloat[4] + ", proMatrix[5] = " + arrayOfFloat[5] + ", proMatrix[6] = " + arrayOfFloat[6] + ", proMatrix[7] = " + arrayOfFloat[7] + ", proMatrix[8] = " + arrayOfFloat[8] + ", proMatrix[9] = " + arrayOfFloat[9] + ", proMatrix[10] = " + arrayOfFloat[10] + ", proMatrix[11] = " + arrayOfFloat[11] + ", proMatrix[12] = " + arrayOfFloat[12] + ", proMatrix[13] = " + arrayOfFloat[13] + ", proMatrix[14] = " + arrayOfFloat[14] + ", proMatrix[15] = " + arrayOfFloat[15]);
    float f1 = this.cns * 1.0F / this.cnu;
    float f2 = this.mImageHeight * 1.0F / this.mImageWidth;
    if (f1 > f2)
    {
      f1 = this.mImageWidth * this.cns * 1.0F / this.mImageHeight / this.cnu * 1.0F;
      arrayOfFloat[0] *= f1;
      arrayOfFloat[8] = (f1 * arrayOfFloat[8]);
      this.bW = arrayOfFloat;
      arrayOfFloat = new float[16];
      if (!anii.isFoundProduct(anii.KEY_PREVIEW_ORIENTATION_270_OF_BACK_MODEL)) {
        break label490;
      }
      Matrix.setRotateM(arrayOfFloat, 0, 90.0F, 0.0F, 0.0F, 1.0F);
    }
    for (;;)
    {
      Matrix.multiplyMM(this.bW, 0, arrayOfFloat, 0, this.bW, 0);
      return this.bW;
      if (f1 >= f2) {
        break;
      }
      f1 = this.mImageHeight * this.cnu * 1.0F / this.mImageWidth / this.cns * 1.0F;
      arrayOfFloat[5] *= f1;
      arrayOfFloat[9] = (f1 * arrayOfFloat[9]);
      break;
      label490:
      Matrix.setRotateM(arrayOfFloat, 0, 270.0F, 0.0F, 0.0F, 1.0F);
    }
  }
  
  boolean aey()
  {
    int i2 = 0;
    long l1 = System.currentTimeMillis();
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. initAlgorithm. start = " + l1);
    int i = YTCommonInterface.initAuthForQQ(BaseApplicationImpl.getApplication().getApplicationContext());
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. initAlgorithm. initAuth ret = " + i);
    this.jdField_a_of_type_ComYoutuArsdkAROption = new AROption();
    this.jdField_a_of_type_ComYoutuArsdkAROption.width = this.mImageWidth;
    this.jdField_a_of_type_ComYoutuArsdkAROption.height = this.mImageHeight;
    this.jdField_a_of_type_ComYoutuArsdkAROption.cameraParamPath = "";
    this.jdField_a_of_type_ComYoutuArsdkAROption.cachePath = "";
    if (adhz.BI() == 0)
    {
      this.jdField_a_of_type_ComYoutuArsdkAROption.recognizeQuality = 3;
      this.jdField_a_of_type_ComYoutuArsdkAROption.trackQuality = 1;
      this.jdField_a_of_type_ComYoutuArsdkAROption.performanceQuality = 3;
    }
    int k;
    label622:
    String str3;
    int i1;
    for (;;)
    {
      synchronized (this.dd)
      {
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. ARSDKVersion = " + ARShell.getSDKVersion());
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeCreate start.");
        ARShell.nativeCreate(BaseApplicationImpl.getApplication().getApplicationContext());
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeCreate end.");
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeInitialize start. width = " + this.jdField_a_of_type_ComYoutuArsdkAROption.width + ", height = " + this.jdField_a_of_type_ComYoutuArsdkAROption.height + ", cameraParamPath = " + this.jdField_a_of_type_ComYoutuArsdkAROption.cameraParamPath + ", recognizeQuality = " + this.jdField_a_of_type_ComYoutuArsdkAROption.recognizeQuality + ", trackQuality = " + this.jdField_a_of_type_ComYoutuArsdkAROption.trackQuality + ", performanceQuality = " + this.jdField_a_of_type_ComYoutuArsdkAROption.performanceQuality);
        i = ARShell.nativeInitialize(this.jdField_a_of_type_ComYoutuArsdkAROption);
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeInitialize end. ret = " + i);
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeStart start.");
        ARShell.nativeStart();
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeStart end.");
        this.Tx = (System.currentTimeMillis() - l1);
        if ((this.d == null) || (this.d.mArCloudConfigInfos == null)) {
          break;
        }
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "add marker for local. marker count = " + this.d.mArCloudConfigInfos.size());
        n = 0;
        m = 0;
        k = 0;
        i = m;
        j = k;
        if (n >= this.d.mArCloudConfigInfos.size()) {
          break label817;
        }
        ArCloudConfigInfo localArCloudConfigInfo1 = (ArCloudConfigInfo)this.d.mArCloudConfigInfos.get(n);
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "add marker for local. resource info = " + localArCloudConfigInfo1.toString());
        i = m;
        j = k;
        if (localArCloudConfigInfo1.bsN.equalsIgnoreCase("2.0"))
        {
          i = m;
          j = k;
          if (localArCloudConfigInfo1.a != null)
          {
            if (localArCloudConfigInfo1.a.buc != null) {
              break label622;
            }
            j = k;
            i = m;
          }
        }
        n += 1;
        m = i;
        k = j;
        continue;
        this.jdField_a_of_type_ComYoutuArsdkAROption.recognizeQuality = 3;
        this.jdField_a_of_type_ComYoutuArsdkAROption.trackQuality = 1;
        this.jdField_a_of_type_ComYoutuArsdkAROption.performanceQuality = 2;
      }
      String str1 = localObject2.a.buc;
      str3 = localObject2.a.bue;
      QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeAddMarker start. markerName = " + str1 + ", markerFilePath = " + str3);
      synchronized (this.dd)
      {
        try
        {
          i1 = ARShell.nativeAddMarker(str1, str3);
          QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeAddMarker end. ret = " + i1);
          i = m;
          j = k;
          if (i1 == 0)
          {
            i = m + 1;
            j = k + 1;
            this.jD.put(localObject2.a.buc, localObject2);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.i("AREngine_ARLocalMarkerRecog", 1, "nativeAddMarker = " + localException.getMessage());
            i1 = 0;
          }
        }
      }
    }
    i = 0;
    int j = 0;
    label817:
    int m = i;
    int n = j;
    if (!adku.bOc)
    {
      m = i;
      n = j;
      if (this.ut != null)
      {
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "add marker for cloud. marker count = " + this.ut.size());
        k = i2;
        for (;;)
        {
          m = i;
          n = j;
          if (k < this.ut.size())
          {
            ArCloudConfigInfo localArCloudConfigInfo2 = (ArCloudConfigInfo)this.ut.get(k);
            n = i;
            m = j;
            String str2;
            if (localArCloudConfigInfo2 != null)
            {
              n = i;
              m = j;
              if (localArCloudConfigInfo2.a != null)
              {
                QLog.i("AREngine_ARLocalMarkerRecog", 1, "add marker for cloud. resource info = " + localArCloudConfigInfo2.toString());
                n = i;
                m = j;
                if (localArCloudConfigInfo2.bsN.equalsIgnoreCase("2.0"))
                {
                  str2 = localArCloudConfigInfo2.a.buc;
                  str3 = localArCloudConfigInfo2.a.bue;
                  QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeAddMarker start. markerName = " + str2 + ", markerFilePath = " + str3);
                }
              }
            }
            synchronized (this.dd)
            {
              i1 = ARShell.nativeAddMarker(str2, str3);
              QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeAddMarker end. ret = " + i1);
              n = i;
              m = j;
              if (i1 == 0)
              {
                m = j + 1;
                n = i + 1;
                this.jD.put(localArCloudConfigInfo2.a.buc, localArCloudConfigInfo2);
              }
              k += 1;
              i = n;
              j = m;
            }
          }
        }
      }
    }
    if (this.cGL == 0) {
      this.cGL = n;
    }
    long l2 = System.currentTimeMillis();
    if (this.cGK == 0) {
      this.cGK = ((int)(l2 - l1));
    }
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. initAlgorithm successfully. timelen = " + (l2 - l1) + ", starttime = " + l1 + ", endtime = " + l2 + ", featureCount = " + m);
    return true;
  }
  
  public void cRT()
  {
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "dataReport. mDataReportRecogQuality = " + this.cGJ + ", mDataReportLoadedFeatureTimeLen = " + this.cGK + ", mDataReportLoadedFeatureCnt = " + this.cGL + ", mDataReportFirstRecogSuccessTimeLen = " + this.cGM + ", mDataReportFirstRecogSuccessStartTime = " + this.Tt + ", mDataReportFirstRecogSuccessEndTime = " + this.Tu + ", mDataReportFirstRecogSuccessFrameCnt = " + this.cGN + ", mDataReportFirstRecogSuccessFeatureId = " + this.btc);
    StringBuilder localStringBuilder = new StringBuilder().append("YOUTU_AR_PERF:, init sdk cost  = ").append(this.Tx).append(", addFeature(1 marker) cost  = ");
    int i;
    if (this.cGL == 0)
    {
      i = 0;
      localStringBuilder = localStringBuilder.append(i).append(", recog cost = ");
      if (this.cGO != 0) {
        break label300;
      }
      l = 0L;
      label180:
      localStringBuilder = localStringBuilder.append(l).append(", track cost = ");
      if (this.cGP != 0) {
        break label314;
      }
    }
    label300:
    label314:
    for (long l = 0L;; l = this.Tw / this.cGP)
    {
      QLog.i("AREngine_ARLocalMarkerRecog", 1, l + ", recog suc from start  = " + this.cGM);
      adix.a().a(this.cGK, this.cGL, this.cGM, this.cGN, this.cGJ, this.btc);
      this.cGP = 0;
      this.cGO = 0;
      this.Tw = 0L;
      this.Tv = 0L;
      return;
      i = this.cGK / this.cGL;
      break;
      l = this.Tv / this.cGO;
      break label180;
    }
  }
  
  public boolean isPause()
  {
    return this.mIsPause;
  }
  
  public void k(long paramLong, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (!this.mIsStarted) || (this.mIsPause)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog$ProcessWorker == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog$ProcessWorker.l(paramLong, paramArrayOfByte);
  }
  
  public void pause()
  {
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "pause. mIsPause = " + this.mIsPause);
    if (this.mIsPause) {
      return;
    }
    this.mIsPause = true;
    this.cGF = 2;
  }
  
  public void resume()
  {
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "resume. mIsPause = " + this.mIsPause);
    if (!this.mIsPause) {
      return;
    }
    this.cGM = 0;
    this.Tt = System.currentTimeMillis();
    this.Tu = 0L;
    this.cGN = 0;
    this.btc = "";
    this.mIsPause = false;
  }
  
  public boolean start()
  {
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "start start.");
    if (this.mIsStarted) {
      return true;
    }
    this.uu.clear();
    this.cGF = 2;
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog$ProcessWorker == null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog$ProcessWorker = new ProcessWorker();
    }
    this.cGM = 0;
    this.Tt = System.currentTimeMillis();
    this.Tu = 0L;
    this.cGN = 0;
    this.btc = "";
    this.mIsStarted = true;
    this.mIsPause = false;
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "start end. mIsStarted = " + this.mIsStarted);
    return true;
  }
  
  public void stop()
  {
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "stop start.");
    if (!this.mIsStarted) {
      return;
    }
    this.uu.clear();
    this.cGF = 2;
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog$ProcessWorker != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog$ProcessWorker.free();
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog$ProcessWorker = null;
    }
    this.b = null;
    cRT();
    this.mIsStarted = false;
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "stop end. mIsStarted = " + this.mIsStarted);
  }
  
  public void uninit()
  {
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "uninit start.");
    if (!this.mIsInited) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog$a = null;
    aez();
    this.mIsInited = false;
    QLog.i("AREngine_ARLocalMarkerRecog", 1, "uninit end. mIsInited = " + this.mIsInited);
  }
  
  class ProcessWorker
    extends Thread
  {
    private long TA;
    private long TB;
    private long Ts;
    private long Tz = adfw.a().cEZ;
    private boolean bNA;
    private boolean bNs;
    private boolean bNt = true;
    byte[] data = new byte[ARLocalMarkerRecog.a(ARLocalMarkerRecog.this) * ARLocalMarkerRecog.b(ARLocalMarkerRecog.this) * 3 / 2];
    
    public ProcessWorker()
    {
      setDaemon(true);
      start();
    }
    
    public void free()
    {
      this.bNt = false;
      if (getState() == Thread.State.WAITING) {
        try
        {
          notify();
          return;
        }
        finally {}
      }
    }
    
    void l(long paramLong, byte[] paramArrayOfByte)
    {
      long l;
      if (getState() == Thread.State.WAITING) {
        if (ARLocalMarkerRecog.c(ARLocalMarkerRecog.this) == 2)
        {
          l = System.currentTimeMillis();
          if (((!this.bNA) || (l - this.TB >= 1500L)) && ((ARLocalMarkerRecog.e(ARLocalMarkerRecog.this) == 0L) || (l - ARLocalMarkerRecog.e(ARLocalMarkerRecog.this) >= 5000L)) && (ARLocalMarkerRecog.f(ARLocalMarkerRecog.this) >= 2)) {
            break label152;
          }
        }
      }
      for (;;)
      {
        if (l - this.TA >= this.Tz) {
          ARLocalMarkerRecog.b(ARLocalMarkerRecog.this, 0);
        }
        System.arraycopy(paramArrayOfByte, 0, this.data, 0, this.data.length);
        this.TA = System.currentTimeMillis();
        this.Ts = paramLong;
        this.bNs = true;
        label152:
        do
        {
          try
          {
            notify();
            return;
          }
          finally {}
        } while (l - this.TA < this.Tz);
        if (ARLocalMarkerRecog.e(ARLocalMarkerRecog.this) != 0L) {
          ARLocalMarkerRecog.d(ARLocalMarkerRecog.this, 0L);
        }
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: ldc 122
      //   5: invokevirtual 126	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:setName	(Ljava/lang/String;)V
      //   8: bipush 12
      //   10: newarray float
      //   12: astore 13
      //   14: iconst_1
      //   15: invokestatic 132	com/youtu/arsdk/ARTargetInfo:allocateInitialized	(I)[Lcom/youtu/arsdk/ARTargetInfo;
      //   18: astore 14
      //   20: aload_0
      //   21: getfield 49	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:bNt	Z
      //   24: ifeq +72 -> 96
      //   27: aload_0
      //   28: getfield 112	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:bNs	Z
      //   31: ifne +54 -> 85
      //   34: aload_0
      //   35: getfield 49	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:bNt	Z
      //   38: istore 6
      //   40: iload 6
      //   42: ifeq +43 -> 85
      //   45: aload_0
      //   46: invokevirtual 135	java/lang/Object:wait	()V
      //   49: goto -22 -> 27
      //   52: astore 13
      //   54: aload 13
      //   56: invokevirtual 138	java/lang/InterruptedException:printStackTrace	()V
      //   59: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   62: ifeq -35 -> 27
      //   65: ldc 146
      //   67: iconst_2
      //   68: ldc 148
      //   70: aload 13
      //   72: invokestatic 152	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   75: goto -48 -> 27
      //   78: astore 13
      //   80: aload_0
      //   81: monitorexit
      //   82: aload 13
      //   84: athrow
      //   85: aload_0
      //   86: getfield 49	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:bNt	Z
      //   89: istore 6
      //   91: iload 6
      //   93: ifne +6 -> 99
      //   96: aload_0
      //   97: monitorexit
      //   98: return
      //   99: aload_0
      //   100: iconst_0
      //   101: putfield 112	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:bNs	Z
      //   104: invokestatic 84	java/lang/System:currentTimeMillis	()J
      //   107: pop2
      //   108: aload_0
      //   109: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   112: invokestatic 155	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/lang/Object;
      //   115: astore 13
      //   117: aload 13
      //   119: monitorenter
      //   120: aload_0
      //   121: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   124: iconst_1
      //   125: invokestatic 158	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;Z)Z
      //   128: pop
      //   129: aload_0
      //   130: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   133: invokestatic 78	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
      //   136: iconst_2
      //   137: if_icmpne +136 -> 273
      //   140: aload_0
      //   141: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   144: invokestatic 160	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:b	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/lang/Object;
      //   147: astore 15
      //   149: aload 15
      //   151: monitorenter
      //   152: iconst_0
      //   153: istore_2
      //   154: iload_2
      //   155: aload_0
      //   156: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   159: invokestatic 163	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/util/ArrayList;
      //   162: invokevirtual 169	java/util/ArrayList:size	()I
      //   165: if_icmpge +105 -> 270
      //   168: aload_0
      //   169: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   172: invokestatic 163	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/util/ArrayList;
      //   175: iload_2
      //   176: invokevirtual 173	java/util/ArrayList:get	(I)Ljava/lang/Object;
      //   179: checkcast 175	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$b
      //   182: getfield 178	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$b:bNy	Z
      //   185: ifne +1408 -> 1593
      //   188: aload_0
      //   189: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   192: aload_0
      //   193: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   196: invokestatic 163	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/util/ArrayList;
      //   199: iload_2
      //   200: invokevirtual 173	java/util/ArrayList:get	(I)Ljava/lang/Object;
      //   203: checkcast 175	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$b
      //   206: getfield 182	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$b:btd	Ljava/lang/String;
      //   209: aload_0
      //   210: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   213: invokestatic 163	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/util/ArrayList;
      //   216: iload_2
      //   217: invokevirtual 173	java/util/ArrayList:get	(I)Ljava/lang/Object;
      //   220: checkcast 175	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$b
      //   223: getfield 185	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$b:bte	Ljava/lang/String;
      //   226: aload_0
      //   227: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   230: invokestatic 163	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/util/ArrayList;
      //   233: iload_2
      //   234: invokevirtual 173	java/util/ArrayList:get	(I)Ljava/lang/Object;
      //   237: checkcast 175	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$b
      //   240: getfield 188	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$b:c	Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
      //   243: invokestatic 191	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;)Z
      //   246: ifeq +1347 -> 1593
      //   249: aload_0
      //   250: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   253: invokestatic 163	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/util/ArrayList;
      //   256: iload_2
      //   257: invokevirtual 173	java/util/ArrayList:get	(I)Ljava/lang/Object;
      //   260: checkcast 175	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$b
      //   263: iconst_1
      //   264: putfield 178	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$b:bNy	Z
      //   267: goto +1326 -> 1593
      //   270: aload 15
      //   272: monitorexit
      //   273: iconst_m1
      //   274: istore_3
      //   275: aload_0
      //   276: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   279: invokestatic 78	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
      //   282: istore 5
      //   284: iload_3
      //   285: istore_2
      //   286: invokestatic 84	java/lang/System:currentTimeMillis	()J
      //   289: lstore 7
      //   291: iload_3
      //   292: istore_2
      //   293: aload_0
      //   294: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   297: invokestatic 193	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/lang/Object;
      //   300: astore 15
      //   302: iload_3
      //   303: istore_2
      //   304: aload 15
      //   306: monitorenter
      //   307: iload 5
      //   309: iconst_2
      //   310: if_icmpne +885 -> 1195
      //   313: iload_3
      //   314: istore_2
      //   315: invokestatic 84	java/lang/System:currentTimeMillis	()J
      //   318: lstore 9
      //   320: iload_3
      //   321: istore_2
      //   322: aload_0
      //   323: getfield 36	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:data	[B
      //   326: aload 14
      //   328: invokestatic 199	com/youtu/arsdk/ARShell:nativeRecognize	([B[Lcom/youtu/arsdk/ARTargetInfo;)I
      //   331: istore 4
      //   333: aload 14
      //   335: iconst_0
      //   336: aaload
      //   337: astore 16
      //   339: iload 4
      //   341: ifne +849 -> 1190
      //   344: iload 4
      //   346: istore_2
      //   347: aload 14
      //   349: iconst_0
      //   350: aaload
      //   351: getfield 203	com/youtu/arsdk/ARTargetInfo:pose	[F
      //   354: bipush 14
      //   356: faload
      //   357: ldc 204
      //   359: fcmpl
      //   360: iflt +830 -> 1190
      //   363: iconst_0
      //   364: istore_3
      //   365: iload 4
      //   367: istore_2
      //   368: aload 16
      //   370: iload_3
      //   371: putfield 207	com/youtu/arsdk/ARTargetInfo:state	I
      //   374: iload 4
      //   376: istore_2
      //   377: invokestatic 84	java/lang/System:currentTimeMillis	()J
      //   380: lstore 11
      //   382: iload 4
      //   384: istore_2
      //   385: aload_0
      //   386: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   389: invokestatic 209	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:d	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
      //   392: pop
      //   393: iload 4
      //   395: istore_2
      //   396: aload_0
      //   397: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   400: lload 11
      //   402: lload 7
      //   404: lsub
      //   405: aload_0
      //   406: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   409: invokestatic 211	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)J
      //   412: ladd
      //   413: invokestatic 213	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;J)J
      //   416: pop2
      //   417: iload 4
      //   419: istore_2
      //   420: invokestatic 84	java/lang/System:currentTimeMillis	()J
      //   423: lstore 11
      //   425: iload 4
      //   427: istore_3
      //   428: iload 4
      //   430: istore_2
      //   431: iload 5
      //   433: aload 14
      //   435: iconst_0
      //   436: aaload
      //   437: getfield 207	com/youtu/arsdk/ARTargetInfo:state	I
      //   440: if_icmpeq +73 -> 513
      //   443: iload 4
      //   445: istore_2
      //   446: ldc 146
      //   448: iconst_1
      //   449: new 215	java/lang/StringBuilder
      //   452: dup
      //   453: invokespecial 216	java/lang/StringBuilder:<init>	()V
      //   456: ldc 218
      //   458: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   461: lload 11
      //   463: lload 9
      //   465: lsub
      //   466: invokevirtual 225	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   469: ldc 227
      //   471: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   474: lload 9
      //   476: invokevirtual 225	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   479: ldc 229
      //   481: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   484: lload 11
      //   486: invokevirtual 225	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   489: ldc 231
      //   491: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   494: aload 14
      //   496: iconst_0
      //   497: aaload
      //   498: getfield 207	com/youtu/arsdk/ARTargetInfo:state	I
      //   501: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   504: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   507: invokestatic 241	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   510: iload 4
      //   512: istore_3
      //   513: iload_3
      //   514: istore_2
      //   515: aload 15
      //   517: monitorexit
      //   518: iload 5
      //   520: iconst_2
      //   521: if_icmpne +923 -> 1444
      //   524: iload_3
      //   525: istore_2
      //   526: invokestatic 246	adap:a	()Ladap;
      //   529: invokestatic 84	java/lang/System:currentTimeMillis	()J
      //   532: lload 7
      //   534: lsub
      //   535: invokevirtual 250	adap:iv	(J)V
      //   538: aload_0
      //   539: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   542: astore 15
      //   544: iload_3
      //   545: ifne +916 -> 1461
      //   548: aload 14
      //   550: iconst_0
      //   551: aaload
      //   552: getfield 203	com/youtu/arsdk/ARTargetInfo:pose	[F
      //   555: bipush 14
      //   557: faload
      //   558: ldc 204
      //   560: fcmpl
      //   561: iflt +900 -> 1461
      //   564: aload 14
      //   566: iconst_0
      //   567: aaload
      //   568: getfield 207	com/youtu/arsdk/ARTargetInfo:state	I
      //   571: istore_2
      //   572: aload 15
      //   574: iload_2
      //   575: invokestatic 252	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;I)I
      //   578: pop
      //   579: aload_0
      //   580: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   583: astore 15
      //   585: aload_0
      //   586: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   589: invokestatic 78	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
      //   592: iconst_2
      //   593: if_icmpne +873 -> 1466
      //   596: aload_0
      //   597: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   600: invokestatic 99	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:f	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
      //   603: iconst_1
      //   604: iadd
      //   605: istore_2
      //   606: aload 15
      //   608: iload_2
      //   609: invokestatic 104	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:b	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;I)I
      //   612: pop
      //   613: iload 5
      //   615: iconst_2
      //   616: if_icmpeq +855 -> 1471
      //   619: aload_0
      //   620: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   623: invokestatic 78	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
      //   626: iconst_2
      //   627: if_icmpne +844 -> 1471
      //   630: aload_0
      //   631: iconst_1
      //   632: putfield 86	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:bNA	Z
      //   635: aload_0
      //   636: invokestatic 84	java/lang/System:currentTimeMillis	()J
      //   639: putfield 88	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:TB	J
      //   642: aload_0
      //   643: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   646: invokestatic 255	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:g	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
      //   649: ifne +11 -> 660
      //   652: aload_0
      //   653: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   656: invokestatic 258	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:h	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
      //   659: pop
      //   660: aload_0
      //   661: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   664: invokestatic 78	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
      //   667: ifne +59 -> 726
      //   670: aload_0
      //   671: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   674: invokestatic 255	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:g	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
      //   677: ifne +49 -> 726
      //   680: aload_0
      //   681: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   684: invokestatic 84	java/lang/System:currentTimeMillis	()J
      //   687: invokestatic 260	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;J)J
      //   690: pop2
      //   691: aload_0
      //   692: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   695: aload_0
      //   696: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   699: invokestatic 262	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)J
      //   702: aload_0
      //   703: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   706: invokestatic 264	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:d	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)J
      //   709: lsub
      //   710: l2i
      //   711: invokestatic 266	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;I)I
      //   714: pop
      //   715: aload_0
      //   716: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   719: ldc_w 268
      //   722: invokestatic 271	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;Ljava/lang/String;)Ljava/lang/String;
      //   725: pop
      //   726: iconst_2
      //   727: istore_2
      //   728: aload_0
      //   729: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   732: invokestatic 78	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
      //   735: iconst_2
      //   736: if_icmpne +759 -> 1495
      //   739: aload_0
      //   740: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   743: iconst_0
      //   744: invokestatic 273	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:d	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;I)I
      //   747: pop
      //   748: iconst_2
      //   749: istore_2
      //   750: new 275	adik
      //   753: dup
      //   754: invokespecial 276	adik:<init>	()V
      //   757: astore 15
      //   759: aload 15
      //   761: iload_2
      //   762: putfield 277	adik:state	I
      //   765: iload_2
      //   766: iconst_2
      //   767: if_icmpeq +309 -> 1076
      //   770: new 279	com/youtu/arsdk/ARPatternInfo
      //   773: dup
      //   774: invokespecial 280	com/youtu/arsdk/ARPatternInfo:<init>	()V
      //   777: astore 16
      //   779: aload 14
      //   781: iconst_0
      //   782: aaload
      //   783: getfield 283	com/youtu/arsdk/ARTargetInfo:markerIndex	I
      //   786: i2l
      //   787: aload 16
      //   789: invokestatic 287	com/youtu/arsdk/ARShell:getMarkerInfo	(JLcom/youtu/arsdk/ARPatternInfo;)I
      //   792: pop
      //   793: iload_2
      //   794: ifne +131 -> 925
      //   797: ldc 146
      //   799: iconst_1
      //   800: new 215	java/lang/StringBuilder
      //   803: dup
      //   804: invokespecial 216	java/lang/StringBuilder:<init>	()V
      //   807: ldc_w 289
      //   810: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   813: aload 16
      //   815: getfield 292	com/youtu/arsdk/ARPatternInfo:name	Ljava/lang/String;
      //   818: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   821: ldc_w 294
      //   824: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   827: aload 16
      //   829: getfield 297	com/youtu/arsdk/ARPatternInfo:markerType	I
      //   832: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   835: ldc_w 299
      //   838: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   841: aload 16
      //   843: getfield 302	com/youtu/arsdk/ARPatternInfo:index	J
      //   846: invokevirtual 225	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   849: ldc_w 304
      //   852: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   855: aload 16
      //   857: getfield 308	com/youtu/arsdk/ARPatternInfo:xSize	F
      //   860: invokevirtual 311	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
      //   863: ldc_w 313
      //   866: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   869: aload 16
      //   871: getfield 316	com/youtu/arsdk/ARPatternInfo:ySize	F
      //   874: invokevirtual 311	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
      //   877: ldc_w 318
      //   880: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   883: aload 16
      //   885: getfield 321	com/youtu/arsdk/ARPatternInfo:param1	F
      //   888: invokevirtual 311	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
      //   891: ldc_w 323
      //   894: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   897: aload 16
      //   899: getfield 326	com/youtu/arsdk/ARPatternInfo:param2	F
      //   902: invokevirtual 311	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
      //   905: ldc_w 328
      //   908: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   911: aload 16
      //   913: getfield 331	com/youtu/arsdk/ARPatternInfo:param3	F
      //   916: invokevirtual 311	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
      //   919: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   922: invokestatic 241	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   925: aload 15
      //   927: aload 16
      //   929: getfield 292	com/youtu/arsdk/ARPatternInfo:name	Ljava/lang/String;
      //   932: putfield 332	adik:btd	Ljava/lang/String;
      //   935: aload 15
      //   937: aload 16
      //   939: getfield 297	com/youtu/arsdk/ARPatternInfo:markerType	I
      //   942: putfield 333	adik:markerType	I
      //   945: aload 16
      //   947: getfield 297	com/youtu/arsdk/ARPatternInfo:markerType	I
      //   950: iconst_1
      //   951: if_icmpne +619 -> 1570
      //   954: aload 16
      //   956: getfield 321	com/youtu/arsdk/ARPatternInfo:param1	F
      //   959: fstore_1
      //   960: aload 15
      //   962: fload_1
      //   963: putfield 336	adik:sY	F
      //   966: aload 16
      //   968: getfield 297	com/youtu/arsdk/ARPatternInfo:markerType	I
      //   971: iconst_1
      //   972: if_icmpne +607 -> 1579
      //   975: aload 16
      //   977: getfield 326	com/youtu/arsdk/ARPatternInfo:param2	F
      //   980: fstore_1
      //   981: aload 15
      //   983: fload_1
      //   984: putfield 339	adik:sZ	F
      //   987: aload 16
      //   989: getfield 297	com/youtu/arsdk/ARPatternInfo:markerType	I
      //   992: iconst_1
      //   993: if_icmpne +595 -> 1588
      //   996: aload 16
      //   998: getfield 331	com/youtu/arsdk/ARPatternInfo:param3	F
      //   1001: fstore_1
      //   1002: aload 15
      //   1004: fload_1
      //   1005: putfield 342	adik:ta	F
      //   1008: aload 15
      //   1010: bipush 16
      //   1012: newarray float
      //   1014: putfield 343	adik:pose	[F
      //   1017: aload 14
      //   1019: iconst_0
      //   1020: aaload
      //   1021: getfield 203	com/youtu/arsdk/ARTargetInfo:pose	[F
      //   1024: iconst_0
      //   1025: aload 15
      //   1027: getfield 343	adik:pose	[F
      //   1030: iconst_0
      //   1031: aload 14
      //   1033: iconst_0
      //   1034: aaload
      //   1035: getfield 203	com/youtu/arsdk/ARTargetInfo:pose	[F
      //   1038: arraylength
      //   1039: invokestatic 108	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   1042: aload 15
      //   1044: aload_0
      //   1045: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   1048: invokestatic 346	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Ljava/util/Map;
      //   1051: aload 16
      //   1053: getfield 292	com/youtu/arsdk/ARPatternInfo:name	Ljava/lang/String;
      //   1056: invokeinterface 351 2 0
      //   1061: checkcast 353	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo
      //   1064: putfield 355	adik:b	Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
      //   1067: aload 15
      //   1069: aload_0
      //   1070: getfield 110	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:Ts	J
      //   1073: putfield 358	adik:Tl	J
      //   1076: aload_0
      //   1077: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   1080: invokestatic 361	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Z
      //   1083: ifeq +37 -> 1120
      //   1086: aload_0
      //   1087: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   1090: invokestatic 363	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:b	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Z
      //   1093: ifne +27 -> 1120
      //   1096: aload_0
      //   1097: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   1100: invokestatic 366	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$a;
      //   1103: ifnull +17 -> 1120
      //   1106: aload_0
      //   1107: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   1110: invokestatic 366	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$a;
      //   1113: aload 15
      //   1115: invokeinterface 371 2 0
      //   1120: aload_0
      //   1121: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   1124: iconst_0
      //   1125: invokestatic 158	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;Z)Z
      //   1128: pop
      //   1129: invokestatic 374	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:yield	()V
      //   1132: aload 13
      //   1134: monitorexit
      //   1135: goto -1115 -> 20
      //   1138: astore 14
      //   1140: aload 13
      //   1142: monitorexit
      //   1143: aload 14
      //   1145: athrow
      //   1146: astore 16
      //   1148: aload 15
      //   1150: monitorexit
      //   1151: aload 16
      //   1153: athrow
      //   1154: astore 15
      //   1156: aload 15
      //   1158: invokevirtual 375	java/lang/Exception:printStackTrace	()V
      //   1161: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1164: ifeq +14 -> 1178
      //   1167: ldc 146
      //   1169: iconst_2
      //   1170: ldc_w 377
      //   1173: aload 15
      //   1175: invokestatic 379	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   1178: aload_0
      //   1179: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   1182: iconst_0
      //   1183: invokestatic 158	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;Z)Z
      //   1186: pop
      //   1187: goto -58 -> 1129
      //   1190: iconst_2
      //   1191: istore_3
      //   1192: goto -827 -> 365
      //   1195: iload_3
      //   1196: istore_2
      //   1197: invokestatic 84	java/lang/System:currentTimeMillis	()J
      //   1200: lstore 9
      //   1202: iload_3
      //   1203: istore_2
      //   1204: aload_0
      //   1205: getfield 36	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:data	[B
      //   1208: aload 14
      //   1210: invokestatic 382	com/youtu/arsdk/ARShell:nativeTrack	([B[Lcom/youtu/arsdk/ARTargetInfo;)I
      //   1213: istore_3
      //   1214: aload 14
      //   1216: iconst_0
      //   1217: aaload
      //   1218: astore 16
      //   1220: iload_3
      //   1221: ifne +217 -> 1438
      //   1224: iload_3
      //   1225: istore_2
      //   1226: aload 14
      //   1228: iconst_0
      //   1229: aaload
      //   1230: getfield 203	com/youtu/arsdk/ARTargetInfo:pose	[F
      //   1233: bipush 14
      //   1235: faload
      //   1236: ldc 204
      //   1238: fcmpl
      //   1239: iflt +199 -> 1438
      //   1242: iconst_1
      //   1243: istore 4
      //   1245: iload_3
      //   1246: istore_2
      //   1247: aload 16
      //   1249: iload 4
      //   1251: putfield 207	com/youtu/arsdk/ARTargetInfo:state	I
      //   1254: iload_3
      //   1255: istore_2
      //   1256: invokestatic 84	java/lang/System:currentTimeMillis	()J
      //   1259: lstore 11
      //   1261: iload_3
      //   1262: istore_2
      //   1263: iload 5
      //   1265: aload 14
      //   1267: iconst_0
      //   1268: aaload
      //   1269: getfield 207	com/youtu/arsdk/ARTargetInfo:state	I
      //   1272: if_icmpeq +70 -> 1342
      //   1275: iload_3
      //   1276: istore_2
      //   1277: ldc 146
      //   1279: iconst_1
      //   1280: new 215	java/lang/StringBuilder
      //   1283: dup
      //   1284: invokespecial 216	java/lang/StringBuilder:<init>	()V
      //   1287: ldc_w 384
      //   1290: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1293: lload 11
      //   1295: lload 9
      //   1297: lsub
      //   1298: invokevirtual 225	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1301: ldc 227
      //   1303: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1306: lload 9
      //   1308: invokevirtual 225	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1311: ldc 229
      //   1313: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1316: lload 11
      //   1318: invokevirtual 225	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1321: ldc 231
      //   1323: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1326: aload 14
      //   1328: iconst_0
      //   1329: aaload
      //   1330: getfield 207	com/youtu/arsdk/ARTargetInfo:state	I
      //   1333: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1336: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1339: invokestatic 241	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   1342: iload_3
      //   1343: istore_2
      //   1344: invokestatic 84	java/lang/System:currentTimeMillis	()J
      //   1347: lstore 9
      //   1349: iload_3
      //   1350: istore_2
      //   1351: aload_0
      //   1352: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   1355: invokestatic 386	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:e	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
      //   1358: pop
      //   1359: iload_3
      //   1360: istore_2
      //   1361: aload_0
      //   1362: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   1365: lload 9
      //   1367: lload 7
      //   1369: lsub
      //   1370: aload_0
      //   1371: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   1374: invokestatic 388	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:b	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)J
      //   1377: ladd
      //   1378: invokestatic 390	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:b	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;J)J
      //   1381: pop2
      //   1382: goto -869 -> 513
      //   1385: astore 16
      //   1387: aload 15
      //   1389: monitorexit
      //   1390: aload 16
      //   1392: athrow
      //   1393: astore 15
      //   1395: aload 15
      //   1397: invokevirtual 375	java/lang/Exception:printStackTrace	()V
      //   1400: iload_2
      //   1401: istore_3
      //   1402: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1405: ifeq -867 -> 538
      //   1408: ldc 146
      //   1410: iconst_2
      //   1411: ldc_w 392
      //   1414: aload 15
      //   1416: invokestatic 379	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   1419: iload_2
      //   1420: istore_3
      //   1421: goto -883 -> 538
      //   1424: astore 14
      //   1426: aload_0
      //   1427: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   1430: iconst_0
      //   1431: invokestatic 158	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;Z)Z
      //   1434: pop
      //   1435: aload 14
      //   1437: athrow
      //   1438: iconst_2
      //   1439: istore 4
      //   1441: goto -196 -> 1245
      //   1444: iload_3
      //   1445: istore_2
      //   1446: invokestatic 246	adap:a	()Ladap;
      //   1449: invokestatic 84	java/lang/System:currentTimeMillis	()J
      //   1452: lload 7
      //   1454: lsub
      //   1455: invokevirtual 395	adap:iw	(J)V
      //   1458: goto -920 -> 538
      //   1461: iconst_2
      //   1462: istore_2
      //   1463: goto -891 -> 572
      //   1466: iconst_0
      //   1467: istore_2
      //   1468: goto -862 -> 606
      //   1471: aload_0
      //   1472: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   1475: invokestatic 78	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
      //   1478: iconst_2
      //   1479: if_icmpeq -837 -> 642
      //   1482: aload_0
      //   1483: iconst_0
      //   1484: putfield 86	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:bNA	Z
      //   1487: aload_0
      //   1488: lconst_0
      //   1489: putfield 88	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:TB	J
      //   1492: goto -850 -> 642
      //   1495: aload_0
      //   1496: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   1499: invokestatic 78	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
      //   1502: ifne +17 -> 1519
      //   1505: aload_0
      //   1506: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   1509: iconst_0
      //   1510: invokestatic 273	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:d	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;I)I
      //   1513: pop
      //   1514: iconst_2
      //   1515: istore_2
      //   1516: goto -766 -> 750
      //   1519: aload_0
      //   1520: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   1523: invokestatic 78	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:c	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
      //   1526: iconst_1
      //   1527: if_icmpne -777 -> 750
      //   1530: aload_0
      //   1531: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   1534: invokestatic 397	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:i	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
      //   1537: pop
      //   1538: aload_0
      //   1539: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   1542: invokestatic 400	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:j	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
      //   1545: iconst_2
      //   1546: if_icmpge +8 -> 1554
      //   1549: iconst_2
      //   1550: istore_2
      //   1551: goto -801 -> 750
      //   1554: aload_0
      //   1555: getfield 24	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog$ProcessWorker:this$0	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;
      //   1558: invokestatic 400	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog:j	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecog;)I
      //   1561: iconst_2
      //   1562: if_icmpne +38 -> 1600
      //   1565: iconst_0
      //   1566: istore_2
      //   1567: goto -817 -> 750
      //   1570: aload 16
      //   1572: getfield 308	com/youtu/arsdk/ARPatternInfo:xSize	F
      //   1575: fstore_1
      //   1576: goto -616 -> 960
      //   1579: aload 16
      //   1581: getfield 316	com/youtu/arsdk/ARPatternInfo:ySize	F
      //   1584: fstore_1
      //   1585: goto -604 -> 981
      //   1588: fconst_0
      //   1589: fstore_1
      //   1590: goto -588 -> 1002
      //   1593: iload_2
      //   1594: iconst_1
      //   1595: iadd
      //   1596: istore_2
      //   1597: goto -1443 -> 154
      //   1600: iconst_1
      //   1601: istore_2
      //   1602: goto -852 -> 750
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1605	0	this	ProcessWorker
      //   959	631	1	f	float
      //   153	1449	2	i	int
      //   274	1171	3	j	int
      //   331	1109	4	k	int
      //   282	991	5	m	int
      //   38	54	6	bool	boolean
      //   289	1164	7	l1	long
      //   318	1048	9	l2	long
      //   380	937	11	l3	long
      //   12	1	13	arrayOfFloat	float[]
      //   52	19	13	localInterruptedException	java.lang.InterruptedException
      //   78	5	13	localObject1	Object
      //   115	1026	13	localObject2	Object
      //   18	1014	14	arrayOfARTargetInfo1	com.youtu.arsdk.ARTargetInfo[]
      //   1138	189	14	arrayOfARTargetInfo2	com.youtu.arsdk.ARTargetInfo[]
      //   1424	12	14	localObject3	Object
      //   147	1002	15	localObject4	Object
      //   1154	234	15	localException1	Exception
      //   1393	22	15	localException2	Exception
      //   337	715	16	localObject5	Object
      //   1146	6	16	localObject6	Object
      //   1218	30	16	localARTargetInfo	com.youtu.arsdk.ARTargetInfo
      //   1385	195	16	localObject7	Object
      // Exception table:
      //   from	to	target	type
      //   45	49	52	java/lang/InterruptedException
      //   2	20	78	finally
      //   20	27	78	finally
      //   27	40	78	finally
      //   45	49	78	finally
      //   54	75	78	finally
      //   85	91	78	finally
      //   99	120	78	finally
      //   1143	1146	78	finally
      //   120	129	1138	finally
      //   1120	1129	1138	finally
      //   1129	1135	1138	finally
      //   1140	1143	1138	finally
      //   1178	1187	1138	finally
      //   1426	1438	1138	finally
      //   154	267	1146	finally
      //   270	273	1146	finally
      //   1148	1151	1146	finally
      //   129	152	1154	java/lang/Exception
      //   275	284	1154	java/lang/Exception
      //   538	544	1154	java/lang/Exception
      //   548	572	1154	java/lang/Exception
      //   572	606	1154	java/lang/Exception
      //   606	613	1154	java/lang/Exception
      //   619	642	1154	java/lang/Exception
      //   642	660	1154	java/lang/Exception
      //   660	726	1154	java/lang/Exception
      //   728	748	1154	java/lang/Exception
      //   750	765	1154	java/lang/Exception
      //   770	793	1154	java/lang/Exception
      //   797	925	1154	java/lang/Exception
      //   925	960	1154	java/lang/Exception
      //   960	981	1154	java/lang/Exception
      //   981	1002	1154	java/lang/Exception
      //   1002	1076	1154	java/lang/Exception
      //   1076	1120	1154	java/lang/Exception
      //   1151	1154	1154	java/lang/Exception
      //   1395	1400	1154	java/lang/Exception
      //   1402	1419	1154	java/lang/Exception
      //   1471	1492	1154	java/lang/Exception
      //   1495	1514	1154	java/lang/Exception
      //   1519	1549	1154	java/lang/Exception
      //   1554	1565	1154	java/lang/Exception
      //   1570	1576	1154	java/lang/Exception
      //   1579	1585	1154	java/lang/Exception
      //   315	320	1385	finally
      //   322	333	1385	finally
      //   347	363	1385	finally
      //   368	374	1385	finally
      //   377	382	1385	finally
      //   385	393	1385	finally
      //   396	417	1385	finally
      //   420	425	1385	finally
      //   431	443	1385	finally
      //   446	510	1385	finally
      //   515	518	1385	finally
      //   1197	1202	1385	finally
      //   1204	1214	1385	finally
      //   1226	1242	1385	finally
      //   1247	1254	1385	finally
      //   1256	1261	1385	finally
      //   1263	1275	1385	finally
      //   1277	1342	1385	finally
      //   1344	1349	1385	finally
      //   1351	1359	1385	finally
      //   1361	1382	1385	finally
      //   1387	1390	1385	finally
      //   286	291	1393	java/lang/Exception
      //   293	302	1393	java/lang/Exception
      //   304	307	1393	java/lang/Exception
      //   526	538	1393	java/lang/Exception
      //   1390	1393	1393	java/lang/Exception
      //   1446	1458	1393	java/lang/Exception
      //   129	152	1424	finally
      //   275	284	1424	finally
      //   286	291	1424	finally
      //   293	302	1424	finally
      //   304	307	1424	finally
      //   526	538	1424	finally
      //   538	544	1424	finally
      //   548	572	1424	finally
      //   572	606	1424	finally
      //   606	613	1424	finally
      //   619	642	1424	finally
      //   642	660	1424	finally
      //   660	726	1424	finally
      //   728	748	1424	finally
      //   750	765	1424	finally
      //   770	793	1424	finally
      //   797	925	1424	finally
      //   925	960	1424	finally
      //   960	981	1424	finally
      //   981	1002	1424	finally
      //   1002	1076	1424	finally
      //   1076	1120	1424	finally
      //   1151	1154	1424	finally
      //   1156	1178	1424	finally
      //   1390	1393	1424	finally
      //   1395	1400	1424	finally
      //   1402	1419	1424	finally
      //   1446	1458	1424	finally
      //   1471	1492	1424	finally
      //   1495	1514	1424	finally
      //   1519	1549	1424	finally
      //   1554	1565	1424	finally
      //   1570	1576	1424	finally
      //   1579	1585	1424	finally
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(adik paramadik);
  }
  
  static class b
  {
    public boolean bNy;
    public boolean bNz;
    public String btd = "";
    public String bte = "";
    public ArCloudConfigInfo c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalMarkerRecog
 * JD-Core Version:    0.7.0.1
 */