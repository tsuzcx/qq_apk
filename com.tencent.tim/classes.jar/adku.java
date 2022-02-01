import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo.a;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.mobileqq.ar.model.QQARSession.1;
import com.tencent.mobileqq.ar.model.QQARSession.10;
import com.tencent.mobileqq.ar.model.QQARSession.11;
import com.tencent.mobileqq.ar.model.QQARSession.12;
import com.tencent.mobileqq.ar.model.QQARSession.13;
import com.tencent.mobileqq.ar.model.QQARSession.14;
import com.tencent.mobileqq.ar.model.QQARSession.15;
import com.tencent.mobileqq.ar.model.QQARSession.16;
import com.tencent.mobileqq.ar.model.QQARSession.17;
import com.tencent.mobileqq.ar.model.QQARSession.18;
import com.tencent.mobileqq.ar.model.QQARSession.2;
import com.tencent.mobileqq.ar.model.QQARSession.20;
import com.tencent.mobileqq.ar.model.QQARSession.21;
import com.tencent.mobileqq.ar.model.QQARSession.22;
import com.tencent.mobileqq.ar.model.QQARSession.23;
import com.tencent.mobileqq.ar.model.QQARSession.24;
import com.tencent.mobileqq.ar.model.QQARSession.25;
import com.tencent.mobileqq.ar.model.QQARSession.26;
import com.tencent.mobileqq.ar.model.QQARSession.27;
import com.tencent.mobileqq.ar.model.QQARSession.28;
import com.tencent.mobileqq.ar.model.QQARSession.3;
import com.tencent.mobileqq.ar.model.QQARSession.4;
import com.tencent.mobileqq.ar.model.QQARSession.5;
import com.tencent.mobileqq.ar.model.QQARSession.6;
import com.tencent.mobileqq.ar.model.QQARSession.7;
import com.tencent.mobileqq.ar.model.QQARSession.8;
import com.tencent.mobileqq.ar.model.QQARSession.9;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class adku
  extends adkl
  implements adcz, addz.a, adgy.a, adid.a, adio.a, Camera.PreviewCallback
{
  private static adku jdField_a_of_type_Adku;
  public static boolean bOc;
  private static boolean bOu = true;
  private int Fe = 17;
  private HandlerThread J;
  private long UA;
  private long UB;
  private long UC;
  private long UD;
  private long UE;
  private long UF;
  private long UG;
  private long UH;
  private long UI;
  private long UJ;
  private long UK;
  public long UL = 4096L;
  private long UM;
  private long UN;
  private long Ut = 0L;
  private long Uu = 0L;
  private final long Uv = 5L;
  private final long Uw = 2183L;
  private long Ux = 0L;
  private long Uy = 0L;
  private long Uz = 0L;
  private adgy jdField_a_of_type_Adgy;
  private adib jdField_a_of_type_Adib;
  public adid a;
  private adio jdField_a_of_type_Adio;
  private adkx jdField_a_of_type_Adkx;
  private boolean aNH = true;
  private adbn jdField_b_of_type_Adbn;
  private adhr jdField_b_of_type_Adhr;
  private adig jdField_b_of_type_Adig;
  private adik jdField_b_of_type_Adik;
  private adin jdField_b_of_type_Adin;
  private ARNativeBridge jdField_b_of_type_ComTencentMobileqqArARNativeBridge;
  private ARCommonConfigInfo jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
  private boolean bOb;
  private boolean bOd;
  private final boolean bOe = true;
  private boolean bOf;
  private boolean bOg;
  private boolean bOh;
  private boolean bOi;
  private volatile boolean bOj;
  private boolean bOk;
  private boolean bOl;
  private boolean bOm;
  private boolean bOn = true;
  private boolean bOo = true;
  private boolean bOp = true;
  private boolean bOq;
  public boolean bOr = true;
  public boolean bOs;
  boolean bOt = false;
  private String buv = "0";
  private addz jdField_c_of_type_Addz;
  private adig jdField_c_of_type_Adig;
  private adik jdField_c_of_type_Adik;
  ARScanStarFaceConfigInfo jdField_c_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo = null;
  private Handler cH;
  private int cIk = 5;
  private int cIl = 5;
  private int cIm = 5;
  private int cIn = 5;
  private int cIo = 5;
  private int cIp = 5;
  private int cIq;
  private int cIr;
  int cIs;
  private int cIt;
  private volatile int cIu = 0;
  private int cns;
  private int cnu;
  private long currentTime;
  private Object df = new Object();
  private ArCloudConfigInfo jdField_e_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
  private ArConfigInfo jdField_e_of_type_ComTencentMobileqqArAidlArConfigInfo;
  private ArCloudConfigInfo f;
  private Runnable fX;
  public ArCloudConfigInfo g;
  public ArCloudConfigInfo h;
  private int mImageHeight;
  private int mImageWidth;
  private boolean mIsInited;
  private volatile boolean mIsResume;
  private ArrayList<Runnable> mTaskList;
  private ArrayList<ArCloudConfigInfo> uA;
  
  public adku()
  {
    this.mSessionType = 1;
    bOu = false;
    adkt.a().b(this);
  }
  
  private void Gn(boolean paramBoolean)
  {
    if ((this.mIsInited) && (this.cHX == 2) && (this.jdField_a_of_type_Adib != null)) {
      this.jdField_a_of_type_Adib.Gj(paramBoolean);
    }
  }
  
  private void Go(boolean paramBoolean)
  {
    this.jdField_b_of_type_Adin = null;
    adin.a.a.bNC = paramBoolean;
    a(null, adin.a.a);
  }
  
  private void Lf(int paramInt)
  {
    if (paramInt == 0) {
      this.cHX = 2;
    }
    for (;;)
    {
      QLog.d("AREngine_QQARSession", 1, "start end. mCurEngineState = " + this.cHX);
      QLog.d("AREngine_QQARSession", 1, "onStartComplete. retCode = " + paramInt);
      if (this.jdField_a_of_type_Adib != null) {
        this.jdField_a_of_type_Adib.KU(paramInt);
      }
      return;
      this.cHX = 5;
      this.bOb = false;
    }
  }
  
  public static addc a(ArCloudConfigInfo paramArCloudConfigInfo, boolean paramBoolean, long paramLong, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramArCloudConfigInfo == null) {
      return null;
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (paramArCloudConfigInfo.type == 0)
    {
      localObject1 = adiz.b(paramArCloudConfigInfo);
      localObject2 = adiz.c(paramArCloudConfigInfo);
      localObject3 = adiz.d(paramArCloudConfigInfo);
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!new File((String)localObject1).exists()) || (TextUtils.isEmpty((CharSequence)localObject2)) || (!new File((String)localObject2).exists()))
      {
        QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo failed. resource path empty or file not exist.");
        return null;
      }
      localObject4 = aded.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.buq);
      paramArCloudConfigInfo = new addm(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.buc, paramArCloudConfigInfo.type, paramArCloudConfigInfo.cCF, (String)localObject2, (String)localObject1, (String)localObject3, (ArCloudConfigInfo.a)localObject4, paramInt, paramFloat1, paramFloat2, paramFloat3);
      paramArCloudConfigInfo.Sl = paramLong;
      QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo. key = " + paramArCloudConfigInfo.key + ", arType = " + paramArCloudConfigInfo.cCE + ", trackMode = " + paramArCloudConfigInfo.cCF + ", resPath = " + paramArCloudConfigInfo.bsh + ", luaPath = " + paramArCloudConfigInfo.bsg + ", musicPath = " + paramArCloudConfigInfo.bsi + ", recogType = " + paramLong);
      return paramArCloudConfigInfo;
    }
    int j;
    int i;
    if ((paramArCloudConfigInfo.type == 2) || (paramArCloudConfigInfo.type == 3))
    {
      if (!VersionUtils.isIceScreamSandwich())
      {
        QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo failed. NOT IceScreamSandwich.");
        return null;
      }
      if (aded.adL())
      {
        QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo failed. isRubbishDeviceNeedsSoftwareDecode.");
        return null;
      }
      localObject2 = adiz.e(paramArCloudConfigInfo);
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!new File((String)localObject2).exists()))
      {
        QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo failed. video path empty or file not exist.");
        return null;
      }
      localObject1 = new adec(paramArCloudConfigInfo);
      j = aded.a((adec)localObject1);
      i = j;
      if (j == 0) {
        i = 2147483647;
      }
      localObject1 = aded.a((adec)localObject1);
      j = ((Integer)((Pair)localObject1).first).intValue();
      localObject3 = (adkf)((Pair)localObject1).second;
      localObject1 = null;
      if (!paramArCloudConfigInfo.aei()) {
        if (((!paramBoolean) || ((paramLong != 2L) && (paramLong != 2048L))) && ((paramLong != 1L) || (paramArCloudConfigInfo.cCF != 2))) {
          break label650;
        }
      }
      label650:
      for (localObject1 = aded.a(((ArVideoResourceInfo)paramArCloudConfigInfo.uk.get(0)).buq, adky.screenWidth, adky.screenHeight, paramArCloudConfigInfo.aeo());; localObject1 = aded.a(((ArVideoResourceInfo)paramArCloudConfigInfo.uk.get(0)).buq, adky.screenWidth, adky.screenHeight))
      {
        paramArCloudConfigInfo = new addv(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.buc, paramArCloudConfigInfo.type, paramArCloudConfigInfo.cCF, j, (adkf)localObject3, (ArCloudConfigInfo.a)localObject1, (String)localObject2, i, paramInt, paramFloat1, paramFloat2, paramFloat3);
        paramArCloudConfigInfo.Sl = paramLong;
        QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo. key = " + paramArCloudConfigInfo.key + ", arType = " + paramArCloudConfigInfo.cCE + ", trackMode = " + paramArCloudConfigInfo.cCF + ", renderType = " + paramArCloudConfigInfo.cDO + ", keyingParams = " + paramArCloudConfigInfo.jdField_a_of_type_Adkf + ", videoPath = " + paramArCloudConfigInfo.mVideoPath + ", layout = " + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$a + ", videoPlayCount = " + i + ", recogType = " + paramLong);
        return paramArCloudConfigInfo;
      }
    }
    if (paramArCloudConfigInfo.type == 4)
    {
      localObject1 = new adec(paramArCloudConfigInfo);
      j = aded.a((adec)localObject1);
      i = j;
      if (j == 0) {
        i = 2147483647;
      }
      localObject1 = aded.a((adec)localObject1);
      j = ((Integer)((Pair)localObject1).first).intValue();
      localObject3 = (adkf)((Pair)localObject1).second;
      localObject1 = null;
      if (!paramArCloudConfigInfo.aei()) {
        if (((!paramBoolean) || ((paramLong != 2L) && (paramLong != 2048L))) && ((paramLong != 1L) || (paramArCloudConfigInfo.cCF != 2))) {
          break label1120;
        }
      }
      label1120:
      for (localObject1 = aded.a(((ArVideoResourceInfo)paramArCloudConfigInfo.uk.get(0)).buq, adky.screenWidth, adky.screenHeight, paramArCloudConfigInfo.aeo());; localObject1 = aded.a(((ArVideoResourceInfo)paramArCloudConfigInfo.uk.get(0)).buq, adky.screenWidth, adky.screenHeight))
      {
        localObject2 = "";
        long l = 0L;
        localObject4 = adkz.c(((ArVideoResourceInfo)paramArCloudConfigInfo.uk.get(0)).videoSize + "|" + ((ArVideoResourceInfo)paramArCloudConfigInfo.uk.get(0)).videoUrl);
        if (localObject4 != null)
        {
          l = ((Long)((Pair)localObject4).first).longValue();
          localObject2 = (String)((Pair)localObject4).second;
        }
        paramBoolean = aded.adL();
        paramArCloudConfigInfo = new addy(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.buc, paramArCloudConfigInfo.type, paramArCloudConfigInfo.cCF, j, (adkf)localObject3, (ArCloudConfigInfo.a)localObject1, (String)localObject2, l, paramBoolean, i, paramInt, paramFloat1, paramFloat2, paramFloat3);
        paramArCloudConfigInfo.Sl = paramLong;
        QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo. key = " + paramArCloudConfigInfo.key + ", arType = " + paramArCloudConfigInfo.cCE + ", trackMode = " + paramArCloudConfigInfo.cCF + ", renderType = " + paramArCloudConfigInfo.cDO + ", keyingParams = " + paramArCloudConfigInfo.jdField_a_of_type_Adkf + ", videoUrl = " + paramArCloudConfigInfo.mVideoUrl + ", videoSize = " + paramArCloudConfigInfo.mVideoSize + ", layout = " + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$a + ", isSoftDecode = " + paramArCloudConfigInfo.bMi + ", videoPlayCount = " + i + ", recogType = " + paramLong);
        return paramArCloudConfigInfo;
      }
    }
    if (paramArCloudConfigInfo.type == 5)
    {
      if (aded.adL())
      {
        localObject1 = paramArCloudConfigInfo.uk.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ArVideoResourceInfo)((Iterator)localObject1).next();
          if ((localObject2 != null) && ((((ArVideoResourceInfo)localObject2).videoType == 2) || (((ArVideoResourceInfo)localObject2).videoType == 3)))
          {
            QLog.i("AREngine_QQARSession", 1, "getMultiFragmentAnimARResourceInfo failed. isRubbishDeviceNeedsSoftwareDecode.");
            return null;
          }
        }
      }
      paramArCloudConfigInfo = new addr(paramArCloudConfigInfo.picId, paramArCloudConfigInfo.type, paramArCloudConfigInfo.cCF, paramArCloudConfigInfo, paramInt, paramFloat1, paramFloat2, paramFloat3);
      paramArCloudConfigInfo.Sl = paramLong;
      return paramArCloudConfigInfo;
    }
    if (paramArCloudConfigInfo.type == 100)
    {
      localObject1 = adiz.a(paramArCloudConfigInfo);
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!new File((String)localObject1).exists()))
      {
        QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo failed. resource path empty or file not exist.");
        return null;
      }
      paramArCloudConfigInfo = new addq(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.buc, paramArCloudConfigInfo.type, 1, "", (String)localObject1, "", paramArCloudConfigInfo, paramInt, paramFloat1, paramFloat2, paramFloat3);
      QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo. key = " + paramArCloudConfigInfo.key + ", resType = " + paramArCloudConfigInfo.cCE + ", resPath = " + paramArCloudConfigInfo.bsh + ", luaPath = " + paramArCloudConfigInfo.bsg + ", musicPath = " + paramArCloudConfigInfo.bsi);
      return paramArCloudConfigInfo;
    }
    if (paramArCloudConfigInfo.type == 7)
    {
      localObject1 = adiz.c(paramArCloudConfigInfo);
      localObject2 = adiz.b(paramArCloudConfigInfo);
      return new addn(paramArCloudConfigInfo.picId, paramArCloudConfigInfo.type, paramArCloudConfigInfo.cCF, paramInt, paramFloat1, paramFloat2, paramFloat3, (String)localObject1, (String)localObject2);
    }
    if (paramArCloudConfigInfo.type == 8)
    {
      localObject1 = adiz.b(paramArCloudConfigInfo);
      localObject2 = adiz.jN(paramArCloudConfigInfo.jdField_a_of_type_Adbm.brE);
      localObject3 = paramArCloudConfigInfo.jdField_a_of_type_Adbm.ua;
      boolean bool = paramArCloudConfigInfo.jdField_a_of_type_Adbm.bLc;
      if (paramArCloudConfigInfo.jdField_a_of_type_Adbm.cBG == 1) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        i = paramArCloudConfigInfo.jdField_a_of_type_Adbm.cBI;
        j = paramArCloudConfigInfo.jdField_a_of_type_Adbm.cBH;
        return new addi(paramArCloudConfigInfo.picId, paramArCloudConfigInfo.type, paramArCloudConfigInfo.cCF, paramInt, paramFloat1, paramFloat2, paramFloat3, (String)localObject1, (String)localObject2, (ArrayList)localObject3, Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), i, j);
      }
    }
    return null;
  }
  
  public static adku a()
  {
    if (jdField_a_of_type_Adku == null) {
      jdField_a_of_type_Adku = new adku();
    }
    return jdField_a_of_type_Adku;
  }
  
  private void a(adhh paramadhh)
  {
    QLog.i("AREngine_QQARSession", 1, "processCloudMarkerRecogResult start.");
    this.bOg = true;
    this.fX = new QQARSession.10(this);
    if (!this.jdField_a_of_type_Adio.a(paramadhh, this, false, this.buv))
    {
      QLog.i("AREngine_QQARSession", 1, "processCloudMarkerRecogResult end. download preprocess failed.");
      this.bOg = false;
      cSp();
      return;
    }
    h(this.fX, 30000L);
  }
  
  private void a(adhk paramadhk)
  {
    QLog.i("AREngine_QQARSession", 1, "processYouTuCloudObjectClassifyResult start.");
    this.fX = new QQARSession.11(this);
    if (!this.jdField_a_of_type_Adio.a(paramadhk, this, false, this.buv))
    {
      QLog.i("AREngine_QQARSession", 1, "processYouTuCloudObjectClassifyResult end. download preprocess failed.");
      cSq();
      return;
    }
    QLog.i("AREngine_QQARSession", 1, "processYouTuCloudObjectClassifyResult post task for handle timeout");
    h(this.fX, 30000L);
  }
  
  private void a(adht paramadht)
  {
    QLog.i("AREngine_QQARSession", 1, "processCloudFaceRecogResult start.");
    this.jdField_a_of_type_Adid.b(paramadht);
    iN(4L);
    this.bOm = true;
    QLog.i("AREngine_QQARSession", 1, "processCloudFaceRecogResult end.");
  }
  
  private void a(adhy paramadhy)
  {
    QLog.i("AREngine_QQARSession", 1, "processCloudSceneRecogResult start.");
    this.fX = new QQARSession.13(this);
    if (!this.jdField_a_of_type_Adio.a(paramadhy, this, false, this.buv))
    {
      QLog.i("AREngine_QQARSession", 1, "processCloudSceneRecogResult end. download preprocess failed.");
      cSt();
      return;
    }
    QLog.i("AREngine_QQARSession", 1, "processCloudSceneRecogResult post task for handle timeout");
    h(this.fX, 30000L);
  }
  
  private void a(adig paramadig1, adig paramadig2)
  {
    if ((QLog.isColorLevel()) && (adie.bNm)) {
      QLog.d("AREngine_QQARSession", 2, "ARFaceTest processLocalFaceRecogResult. curLocalFaceRecogResult = " + paramadig1);
    }
    if (this.jdField_a_of_type_Adkx != null) {
      this.jdField_a_of_type_Adkx.iQ(paramadig1.Tl);
    }
    if (this.jdField_a_of_type_Adkx != null) {
      this.jdField_a_of_type_Adkx.requestRender();
    }
    a(null, paramadig1);
  }
  
  private void a(adik paramadik1, adik paramadik2)
  {
    if (paramadik1.state != 2) {
      if (paramadik1.b.aek())
      {
        if (this.jdField_a_of_type_Adkx != null) {
          this.jdField_a_of_type_Adkx.iQ(paramadik1.Tl);
        }
        if (this.jdField_a_of_type_Adkx != null) {
          this.jdField_a_of_type_Adkx.requestRender();
        }
        this.UC = 0L;
        this.UD = 0L;
        if (paramadik1.state == 0) {
          a(1L, paramadik1.b, paramadik1.markerType, paramadik1.sY, paramadik1.sZ, paramadik1.ta);
        }
        a(new addb(paramadik1.markerType, paramadik1.sY, paramadik1.sZ, paramadik1.ta, paramadik1.pose, this.jdField_a_of_type_Adid.a(this.cns, this.cnu)));
        this.bOl = true;
      }
    }
    do
    {
      do
      {
        return;
        if ((paramadik2 != null) && (paramadik2.state != 2)) {
          this.UC = System.currentTimeMillis();
        }
        this.UD = System.currentTimeMillis();
      } while (this.UC <= 0L);
      if (aeU())
      {
        paramadik2 = new float[16];
        a(new addb(paramadik1.markerType, 0.0F, 0.0F, 0.0F, paramadik2, this.jdField_a_of_type_Adid.a(this.cns, this.cnu)));
      }
    } while (this.UD - this.UC <= 1500L);
    this.UC = 0L;
    adcl.a().KB(1);
    cSm();
  }
  
  private void a(adin paramadin)
  {
    QLog.i("AREngine_QQARSession", 1, "processMIGCloudObjectClassifyResult start.");
    if (paramadin.getRenderType() == -1)
    {
      cSr();
      return;
    }
    if (paramadin.getRenderType() == 1)
    {
      b(paramadin);
      return;
    }
    int i;
    if (this.jdField_b_of_type_Adin == null) {
      i = 1;
    }
    while ((this.jdField_a_of_type_Adgy != null) && (i != 0))
    {
      this.jdField_a_of_type_Adgy.Ge(true);
      QLog.i("AREngine_QQARSession", 1, "processMIGCloudObjectClassifyResultInternal setCompareSameSceneFlag.");
      return;
      if (!paramadin.b(this.jdField_b_of_type_Adin)) {
        i = 1;
      } else {
        i = 0;
      }
    }
    b(paramadin);
  }
  
  private boolean a(long paramLong, ArCloudConfigInfo paramArCloudConfigInfo, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    addc localaddc1 = a(paramArCloudConfigInfo, false, paramLong, paramInt, paramFloat1, paramFloat2, paramFloat3);
    if (localaddc1 == null) {
      return false;
    }
    QLog.d("AREngine_QQARSession", 1, "startModelRender. recogType = " + paramLong + ", key = " + localaddc1.key + ", resType = " + localaddc1.cCE);
    if (this.jdField_a_of_type_Adkx != null)
    {
      this.Uz = paramLong;
      this.jdField_e_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramArCloudConfigInfo;
      addc localaddc2 = a(this.f, false, paramLong, paramInt, paramFloat1, paramFloat2, paramFloat3);
      if ((localaddc2 != null) && (localaddc2.key.equalsIgnoreCase(localaddc1.key))) {
        return true;
      }
      if ((localaddc2 == null) || (localaddc2.key.equalsIgnoreCase(localaddc1.key))) {
        break label337;
      }
      this.jdField_a_of_type_Adkx.cSm();
      this.jdField_a_of_type_Adkx.a(localaddc1);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Adkx != null) {
        this.jdField_a_of_type_Adkx.requestRender();
      }
      adkt.a().cRB();
      if ((this.mIsInited) && (this.cHX == 2) && (this.jdField_a_of_type_Adib != null))
      {
        if ((!paramArCloudConfigInfo.aef()) && (paramArCloudConfigInfo.aek())) {
          adcl.a().KA(3);
        }
        paramArCloudConfigInfo = new adec(paramArCloudConfigInfo);
        this.jdField_a_of_type_Adib.a(paramLong, true, paramArCloudConfigInfo);
      }
      this.f = this.jdField_e_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
      if (this.cIq == 0)
      {
        this.UH = System.currentTimeMillis();
        this.cIq = ((int)(this.UH - this.UG));
      }
      if ((this.cIr == 0) && (this.jdField_b_of_type_Adhr != null))
      {
        this.UJ = System.currentTimeMillis();
        this.cIr = ((int)(this.UJ - this.UI));
      }
      return true;
      label337:
      this.jdField_a_of_type_Adkx.a(localaddc1);
    }
  }
  
  public static void ac(Runnable paramRunnable)
  {
    if (b() != null) {
      b().post(paramRunnable);
    }
  }
  
  private boolean aeP()
  {
    boolean bool = false;
    QLog.i("AREngine_QQARSession", 2, "startRenderManager.");
    if (this.jdField_a_of_type_Adkx != null)
    {
      this.jdField_a_of_type_Adkx.A(0, this.jdField_b_of_type_ComTencentMobileqqArARNativeBridge);
      this.jdField_a_of_type_Adkx.A(8, this.jdField_b_of_type_Adbn);
      bool = true;
    }
    return bool;
  }
  
  private boolean aeQ()
  {
    QLog.i("AREngine_QQARSession", 2, "startLocalRecog.");
    if (this.jdField_a_of_type_Adid != null)
    {
      if (!this.jdField_a_of_type_Adid.a(this.mContext, this.Ux, this.mImageWidth, this.mImageHeight, this.jdField_e_of_type_ComTencentMobileqqArAidlArConfigInfo, this.uA, this.jdField_c_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo, this)) {
        return false;
      }
      return this.jdField_a_of_type_Adid.start();
    }
    return false;
  }
  
  private boolean aeR()
  {
    QLog.i("AREngine_QQARSession", 2, "startCloudRecog.");
    if (this.jdField_a_of_type_Adgy != null)
    {
      this.jdField_a_of_type_Adgy.aL(this.mImageWidth, this.mImageHeight, this.Fe);
      this.jdField_a_of_type_Adgy.start();
      return true;
    }
    return false;
  }
  
  private boolean aeS()
  {
    QLog.i("AREngine_QQARSession", 2, "stopLocalRecog.");
    if (this.jdField_a_of_type_Adid != null) {
      this.jdField_a_of_type_Adid.stop();
    }
    return true;
  }
  
  private boolean aeT()
  {
    QLog.i("AREngine_QQARSession", 2, "stopCloudRecog.");
    if (this.jdField_a_of_type_Adgy != null) {
      this.jdField_a_of_type_Adgy.stop();
    }
    return true;
  }
  
  private boolean aeW()
  {
    return false;
  }
  
  public static boolean aeX()
  {
    return bOu;
  }
  
  public static adku b()
  {
    return jdField_a_of_type_Adku;
  }
  
  private void b(adhf paramadhf, ArLBSActivity paramArLBSActivity)
  {
    if ((this.mIsInited) && (this.cHX == 2) && (this.jdField_a_of_type_Adib != null)) {
      this.jdField_a_of_type_Adib.a(paramadhf, paramArLBSActivity);
    }
  }
  
  private void b(adii paramadii)
  {
    QLog.i("AREngine_QQARSession", 1, "processLocalGestureCircleRecogResult");
    if (this.jdField_b_of_type_Adbn != null) {
      this.jdField_b_of_type_Adbn.a(paramadii, this.mImageWidth, this.mImageHeight, this.cns, this.cnu);
    }
  }
  
  private void b(adin paramadin)
  {
    QLog.i("AREngine_QQARSession", 1, "processMIGCloudObjectClassifyResultInternal start.");
    if (paramadin.getRenderType() == 1)
    {
      anot.a(null, "dc00898", "", "", "0X8008999", "0X8008999", 0, 0, "1", "", "", "");
      if (this.jdField_b_of_type_Adin != null) {
        Go(false);
      }
      this.fX = new QQARSession.12(this);
      if (!this.jdField_a_of_type_Adio.a(paramadin, this, false, this.buv))
      {
        QLog.i("AREngine_QQARSession", 1, "processMIGCloudObjectClassifyResult end. download preprocess failed.");
        cSr();
      }
    }
    adin.a locala;
    do
    {
      return;
      QLog.i("AREngine_QQARSession", 1, "processMIGCloudObjectClassifyResult post task for handle timeout");
      h(this.fX, 30000L);
      return;
      anot.a(null, "dc00898", "", "", "0X8008999", "0X8008999", 0, 0, "0", "", "", "");
      locala = paramadin.a();
      if (locala != null)
      {
        this.jdField_b_of_type_Adin = paramadin;
        a(null, locala);
        cSl();
      }
    } while ((locala != null) && (locala.bNB));
    cSr();
  }
  
  private boolean bb(boolean paramBoolean)
  {
    QLog.i("AREngine_QQARSession", 1, "startSensorTrack. isForExternalTrack = " + paramBoolean);
    this.bOk = paramBoolean;
    if (this.jdField_c_of_type_Addz != null) {
      this.jdField_c_of_type_Addz.start();
    }
    return true;
  }
  
  private void cSk()
  {
    QLog.d("AREngine_QQARSession", 1, "pauseCloudRecog.");
    if (this.jdField_a_of_type_Adgy != null) {
      this.jdField_a_of_type_Adgy.pause();
    }
  }
  
  private void cSl()
  {
    QLog.d("AREngine_QQARSession", 1, "resumeCloudRecog.");
    if (this.cIr == 0) {
      this.UI = 0L;
    }
    this.jdField_b_of_type_Adhr = null;
    this.bOg = false;
    if (this.jdField_a_of_type_Adgy != null) {
      this.jdField_a_of_type_Adgy.resume();
    }
  }
  
  private void cSo()
  {
    if (this.jdField_c_of_type_Addz != null)
    {
      this.jdField_c_of_type_Addz.uninit();
      this.jdField_c_of_type_Addz = null;
    }
    if (this.jdField_a_of_type_Adid != null)
    {
      this.jdField_a_of_type_Adid.uninit();
      this.jdField_a_of_type_Adid = null;
    }
    if (this.jdField_a_of_type_Adgy != null)
    {
      this.jdField_a_of_type_Adgy.uninit();
      this.jdField_a_of_type_Adgy = null;
    }
    if (this.jdField_a_of_type_Adio != null)
    {
      this.jdField_a_of_type_Adio.uninit();
      this.jdField_a_of_type_Adio = null;
    }
    if (this.jdField_a_of_type_Adkx != null) {
      this.jdField_a_of_type_Adkx = null;
    }
    this.jdField_b_of_type_ComTencentMobileqqArARNativeBridge = null;
    this.bOs = false;
    this.cIu = 0;
    synchronized (this.df)
    {
      if (this.J != null)
      {
        if (this.cH != null) {
          this.cH.removeCallbacksAndMessages(null);
        }
        this.cH = null;
        if (Build.VERSION.SDK_INT >= 18) {
          this.J.quitSafely();
        }
        this.J = null;
        this.mTaskList = null;
      }
      return;
    }
  }
  
  private void cSp()
  {
    QLog.i("AREngine_QQARSession", 1, "onProcessCloudMarkerRecogResultComplete.");
    if (!ARRecognition.b(this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) {
      iM(1L);
    }
    cSu();
    this.bOl = false;
  }
  
  private void cSs()
  {
    QLog.i("AREngine_QQARSession", 1, "onProcessCloudFaceRecogResultComplete.");
    if (!ARRecognition.b(this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) {}
    for (;;)
    {
      cSu();
      this.bOm = false;
      return;
      iN(1L);
    }
  }
  
  private void cSu()
  {
    QLog.i("AREngine_QQARSession", 1, "processCloudRecogResult end.");
    cSl();
  }
  
  private void cSw()
  {
    QLog.i("AREngine_QQARSession", 1, "stopSensorTrack.");
    this.bOk = false;
    if (this.jdField_c_of_type_Addz != null) {
      this.jdField_c_of_type_Addz.stop();
    }
  }
  
  private void cSx()
  {
    if (this.cIu != 1) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Adid != null) {
        this.jdField_a_of_type_Adid.reset();
      }
    } while (this.jdField_b_of_type_Adbn == null);
    this.jdField_b_of_type_Adbn.cPM();
  }
  
  public static void cSz()
  {
    jdField_a_of_type_Adku = null;
    bOu = true;
  }
  
  private void e(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    long l2 = System.currentTimeMillis() - this.UK;
    if (l2 >= 1000L) {}
    for (long l1 = 0L;; l1 = 1000L - l2)
    {
      QLog.i("AREngine_QQARSession", 1, String.format("onARObjectClassifyDownloadComplete result=%s timeCost=%s timeDelay=%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(l2), Long.valueOf(l1) }));
      h(new QQARSession.16(this, paramBoolean, paramArCloudConfigInfo), l1);
      this.h = null;
      return;
    }
  }
  
  private void f(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    long l2 = System.currentTimeMillis() - this.UK;
    if (l2 >= 1000L) {}
    for (long l1 = 0L;; l1 = 1000L - l2)
    {
      QLog.i("AREngine_QQARSession", 1, String.format("onARSceneRecogDownloadCompleteInteral result=%s timeCost=%s timeDelay=%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(l2), Long.valueOf(l1) }));
      h(new QQARSession.18(this, paramBoolean, paramArCloudConfigInfo), l1);
      this.h = null;
      return;
    }
  }
  
  public static void h(Runnable paramRunnable, long paramLong)
  {
    if (b() != null) {
      b().postDelayed(paramRunnable, paramLong);
    }
  }
  
  private void post(Runnable paramRunnable)
  {
    synchronized (this.df)
    {
      if (this.cH != null)
      {
        this.cH.post(paramRunnable);
        this.mTaskList.add(paramRunnable);
      }
      return;
    }
  }
  
  private void postDelayed(Runnable paramRunnable, long paramLong)
  {
    synchronized (this.df)
    {
      if (this.cH != null)
      {
        this.cH.postDelayed(paramRunnable, paramLong);
        this.mTaskList.add(paramRunnable);
      }
      return;
    }
  }
  
  private void remove(Runnable paramRunnable)
  {
    for (;;)
    {
      int i;
      synchronized (this.df)
      {
        if ((this.cH != null) && (this.mTaskList != null))
        {
          i = 0;
          if (i < this.mTaskList.size())
          {
            if (!paramRunnable.equals(this.mTaskList.get(i))) {
              break label107;
            }
            QLog.i("AREngine_QQARSession", 1, "removeTask. task = " + this.mTaskList.get(i));
            this.mTaskList.remove(i);
            this.cH.removeCallbacks(paramRunnable);
          }
        }
        return;
      }
      label107:
      i += 1;
    }
  }
  
  private void removeAll()
  {
    synchronized (this.df)
    {
      if ((this.cH != null) && (this.mTaskList != null))
      {
        QLog.i("AREngine_QQARSession", 1, "removeAllTask. task count = " + this.mTaskList.size());
        int i = 0;
        while (i < this.mTaskList.size())
        {
          this.cH.removeCallbacks((Runnable)this.mTaskList.get(i));
          i += 1;
        }
        this.mTaskList.clear();
      }
      return;
    }
  }
  
  public static void removeTask(Runnable paramRunnable)
  {
    if (b() != null) {
      b().remove(paramRunnable);
    }
  }
  
  public static void uo()
  {
    if (b() != null) {
      b().removeAll();
    }
  }
  
  public int BP()
  {
    QLog.d("AREngine_QQARSession", 1, "start startInternal. mCurEngineState = " + this.cHX);
    if ((this.cHX != 0) || (!adkt.a().aeN())) {
      return -1;
    }
    this.cIq = 0;
    this.UG = System.currentTimeMillis();
    this.UH = 0L;
    this.cIr = 0;
    this.UI = 0L;
    this.UJ = 0L;
    this.mImageWidth = adkt.a().fk();
    this.mImageHeight = adkt.a().fl();
    this.Fe = adkt.a().getPreviewFormat();
    this.cnu = adky.screenHeight;
    this.cns = adky.screenWidth;
    this.jdField_b_of_type_ComTencentMobileqqArARNativeBridge = new ARNativeBridge();
    if (!this.jdField_b_of_type_ComTencentMobileqqArARNativeBridge.isLoadSoSuccess())
    {
      QLog.d("AREngine_QQARSession", 1, "startAR internal fail");
      this.jdField_b_of_type_ComTencentMobileqqArARNativeBridge = null;
      this.bOb = false;
      Lf(6);
      return 6;
    }
    aeP();
    this.jdField_c_of_type_Addz.a(this.mContext, this);
    if ((this.jdField_a_of_type_Adid != null) && (!aeQ()))
    {
      Lf(7);
      return 7;
    }
    if (!ARRecognition.b(this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) {
      iM(5L);
    }
    while ((this.jdField_a_of_type_Adgy != null) && (!aeR()))
    {
      Lf(3);
      return 3;
      iM(4L);
      iN(1L);
    }
    this.cHX = 2;
    this.jdField_a_of_type_Adkx.a(this);
    Lf(0);
    return 0;
  }
  
  public void Gf(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QLog.i("AREngine_QQARSession", 1, "onARCloudSelectImageComplete. result = " + paramBoolean);
      if (this.UI == 0L) {
        this.UI = System.currentTimeMillis();
      }
      if (this.UM > 0L)
      {
        long l = System.currentTimeMillis() - this.UM;
        if (l > 0L) {
          this.UN = (l + this.UN);
        }
        this.UM = 0L;
      }
    }
  }
  
  public void Gg(boolean paramBoolean)
  {
    QLog.i("AREngine_QQARSession", 1, "onARCloudPretreatComplete. result = " + paramBoolean);
    if ((paramBoolean) && (this.bOo))
    {
      this.bOo = false;
      anot.a(null, "dc00898", "", "", "0X80085AD", "0X80085AD", 0, 0, "", "", "", "");
    }
  }
  
  public void Gh(boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_Adhr != null) && (this.jdField_b_of_type_Adhr.jdField_a_of_type_Adin != null)) {
      ac(new QQARSession.9(this, paramBoolean));
    }
  }
  
  public void KW(int paramInt)
  {
    QLog.i("AREngine_QQARSession", 1, "onARMarkerAllDownloadProgress. progress = " + paramInt);
    if ((this.mIsInited) && (this.cHX == 2) && (this.jdField_a_of_type_Adib != null)) {
      this.jdField_a_of_type_Adib.hq(2, paramInt);
    }
  }
  
  public void KX(int paramInt)
  {
    if ((this.mIsInited) && (this.cHX == 2) && (this.jdField_a_of_type_Adib != null)) {
      this.jdField_a_of_type_Adib.hq(2, paramInt);
    }
  }
  
  public void KY(int paramInt)
  {
    if ((this.mIsInited) && (this.cHX == 2) && (this.jdField_a_of_type_Adib != null)) {
      this.jdField_a_of_type_Adib.hq(2, paramInt);
    }
  }
  
  public void Lg(int paramInt)
  {
    QLog.d("AREngine_QQARSession", 1, String.format("enterIntoCertainWorkStatus on workMode=%s", new Object[] { Integer.valueOf(paramInt) }));
    if ((paramInt == 1) && (this.cIu != paramInt)) {
      ac(new QQARSession.28(this));
    }
  }
  
  public int a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, ARCommonConfigInfo paramARCommonConfigInfo, ArConfigInfo paramArConfigInfo, ARScanStarFaceConfigInfo paramARScanStarFaceConfigInfo, adib paramadib, Activity paramActivity, adbn paramadbn, adkx paramadkx)
  {
    QLog.d("AREngine_QQARSession", 1, String.format("initAR isEnableARCloudFromSettings=%s isEnableARCloudFromH5=%s isTestMode=%s commonConfig=%s markerConfig=%s faceConfig=%s arEngineCallback=%s mIsArInited=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean4), paramARCommonConfigInfo, paramArConfigInfo, paramARScanStarFaceConfigInfo, paramadib, Boolean.valueOf(this.bOb) }));
    if (this.bOb) {
      return 0;
    }
    if (paramARCommonConfigInfo == null)
    {
      this.bOb = false;
      QLog.i("AREngine_QQARSession", 1, "initAR fail! commonConfig is null.");
      if (paramadib != null) {
        paramadib.KU(3);
      }
      return 3;
    }
    bOc = paramBoolean4;
    this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = paramARCommonConfigInfo;
    this.jdField_e_of_type_ComTencentMobileqqArAidlArConfigInfo = paramArConfigInfo;
    this.jdField_c_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo = paramARScanStarFaceConfigInfo;
    this.jdField_a_of_type_Adib = paramadib;
    this.bOd = paramARCommonConfigInfo.isEnableARCloud();
    this.Ut = ARRecognition.d(paramARCommonConfigInfo.recognitions);
    this.Uu = ARRecognition.c(paramARCommonConfigInfo.recognitions);
    if (this.bOd)
    {
      paramBoolean4 = true;
      this.bOf = paramBoolean4;
      if (!paramBoolean2) {
        this.bOf = false;
      }
      if (paramBoolean1) {
        this.bOf = true;
      }
      if (!paramBoolean3) {
        break label361;
      }
      this.bOs = true;
      this.bOf = false;
    }
    label361:
    for (this.Ux = 4096L;; this.Ux = (this.Ut & 0x5))
    {
      this.Uy = (this.Uu & 0x887);
      if (this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions == null) {
        break label376;
      }
      int j;
      for (int i = 0; i < this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions.size(); i = j + 1)
      {
        long l = 1 << (int)((ARRecognition)this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions.get(i)).type;
        j = i;
        if ((this.Ux & l) == 0L)
        {
          j = i;
          if ((l & this.Uy) == 0L)
          {
            this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions.remove(i);
            j = i - 1;
          }
        }
      }
      paramBoolean4 = false;
      break;
    }
    label376:
    this.cIk = ARRecognition.b(this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L);
    this.cIl = ARRecognition.b(this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 2L);
    this.cIm = ARRecognition.b(this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 4L);
    this.cIn = ARRecognition.b(this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 64L);
    this.cIo = ARRecognition.b(this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 128L);
    this.cIp = ARRecognition.b(this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 2048L);
    QLog.i("AREngine_QQARSession", 1, "initAR mIsEnableARCloudFromConfig=" + this.bOd + " mLocalRecogTypeFromConfig=" + this.Ut + " mCloudRecogTypeFromConfig=" + this.Uu + " mIsEnableARCloudFromClientSupport=" + true + " mLocalRecogTypeFromClientSupport=" + 5L + " mCloudRecogTypeFromClientSupport=" + 2183L + " mIsEnableARCloud=" + this.bOf + " mLocalRecogType=" + this.Ux + " mCloudRecogType=" + this.Uy + " mMarkerRecogPriority=" + this.cIk + " mObjectClassifyPriority=" + this.cIl + " mFaceRecogPriority=" + this.cIm + " mPreOcrRecogPriority=" + this.cIn + " mSceneRecogPriority=" + this.cIp);
    QLog.i("AREngine_QQARSession", 1, "Build.MODEL = " + Build.MODEL);
    this.jdField_a_of_type_Adkx = paramadkx;
    this.jdField_b_of_type_Adbn = paramadbn;
    this.jdField_a_of_type_Adio = new adio(this.mAppInterface, this.mContext);
    if ((this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.aRCloudCacheExpireTime > 0L)) {
      this.jdField_a_of_type_Adio.d(this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.aRCloudCacheExpireTime * 60L * 1000L, bOc);
    }
    for (;;)
    {
      this.uA = this.jdField_a_of_type_Adio.cM();
      if ((this.Ux != 0L) && (this.jdField_a_of_type_Adid == null)) {
        this.jdField_a_of_type_Adid = new adid();
      }
      if ((!this.bOf) || (this.jdField_a_of_type_Adgy != null)) {
        break;
      }
      this.jdField_a_of_type_Adgy = new adgy();
      if (this.jdField_a_of_type_Adgy.a(this, this.mAppInterface, paramActivity, 900000000, 900000000, 0, this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo)) {
        break;
      }
      QLog.i("AREngine_QQARSession", 1, "initAR fail! ARCloud init ar so fail.");
      this.jdField_a_of_type_Adgy = null;
      this.bOb = false;
      if (paramadib != null) {
        paramadib.KU(8);
      }
      return 8;
      this.jdField_a_of_type_Adio.d(86400000L, bOc);
    }
    this.bOb = true;
    this.cHX = 0;
    return 0;
  }
  
  public void a(long paramLong, adim paramadim)
  {
    if (this.cIu == 1)
    {
      if (paramadim.Sl != 4096L) {
        return;
      }
      b((adii)paramadim);
      return;
    }
    adil localadil = new adil();
    if ((1L & paramLong) != 0L) {
      localadil.jdField_a_of_type_Adik = ((adik)paramadim);
    }
    if ((0x4 & paramLong) != 0L) {
      localadil.jdField_a_of_type_Adig = ((adig)paramadim);
    }
    a(localadil, null);
  }
  
  public void a(long paramLong, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    g(new QQARSession.2(this, paramLong, paramArCloudConfigInfo), 500L);
  }
  
  public void a(addb paramaddb)
  {
    a(paramaddb, null);
  }
  
  public void a(addd paramaddd, adim paramadim)
  {
    if ((paramadim != null) && (paramadim.Sl == 4L)) {
      if ((this.mIsInited) && (this.cHX == 2) && (this.jdField_a_of_type_Adib != null)) {
        this.jdField_a_of_type_Adib.a(paramadim.Sl, 0, null, paramadim);
      }
    }
    label211:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((paramadim == null) || (paramadim.Sl != 128L)) {
              break;
            }
          } while ((!this.mIsInited) || (this.cHX != 2) || (this.jdField_a_of_type_Adib == null));
          this.jdField_a_of_type_Adib.a(paramadim.Sl, 0, null, paramadim);
          return;
          if (this.jdField_e_of_type_ComTencentMobileqqArAidlArCloudConfigInfo == null) {
            break label211;
          }
          if (this.jdField_a_of_type_Adkx != null) {
            this.jdField_a_of_type_Adkx.requestRender();
          }
          if ((!this.jdField_e_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.ael()) || (!this.bOk)) {
            break;
          }
        } while ((!this.mIsInited) || (this.cHX != 2) || (this.jdField_a_of_type_Adib == null));
        this.jdField_a_of_type_Adib.a(this.Uz, this.jdField_e_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.cCF, paramaddd, null);
        return;
      } while (this.jdField_a_of_type_Adkx == null);
      this.jdField_a_of_type_Adkx.b(paramaddd);
      return;
    } while (this.jdField_a_of_type_Adkx == null);
    this.jdField_a_of_type_Adkx.b(paramaddd);
  }
  
  /* Error */
  public void a(adil paramadil, adhr paramadhr)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 204	adku:mIsInited	Z
    //   6: ifeq +13 -> 19
    //   9: aload_0
    //   10: getfield 207	adku:cHX	I
    //   13: istore_3
    //   14: iload_3
    //   15: iconst_2
    //   16: if_icmpeq +6 -> 22
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_1
    //   23: ifnull +33 -> 56
    //   26: aload_1
    //   27: getfield 1350	adil:jdField_a_of_type_Adik	Ladik;
    //   30: ifnull +11 -> 41
    //   33: aload_0
    //   34: aload_1
    //   35: getfield 1350	adil:jdField_a_of_type_Adik	Ladik;
    //   38: putfield 1378	adku:jdField_b_of_type_Adik	Ladik;
    //   41: aload_1
    //   42: getfield 1352	adil:jdField_a_of_type_Adig	Ladig;
    //   45: ifnull +11 -> 56
    //   48: aload_0
    //   49: aload_1
    //   50: getfield 1352	adil:jdField_a_of_type_Adig	Ladig;
    //   53: putfield 1380	adku:jdField_b_of_type_Adig	Ladig;
    //   56: aload_2
    //   57: ifnull +8 -> 65
    //   60: aload_0
    //   61: aload_2
    //   62: putfield 623	adku:jdField_b_of_type_Adhr	Ladhr;
    //   65: aload_0
    //   66: getfield 144	adku:Ux	J
    //   69: lconst_0
    //   70: lcmp
    //   71: ifeq +1510 -> 1581
    //   74: aload_0
    //   75: getfield 146	adku:Uy	J
    //   78: lconst_0
    //   79: lcmp
    //   80: ifeq +1501 -> 1581
    //   83: aload_1
    //   84: ifnull +590 -> 674
    //   87: aload_1
    //   88: getfield 1350	adil:jdField_a_of_type_Adik	Ladik;
    //   91: ifnull +583 -> 674
    //   94: aload_1
    //   95: getfield 1350	adil:jdField_a_of_type_Adik	Ladik;
    //   98: getfield 749	adik:state	I
    //   101: istore_3
    //   102: iload_3
    //   103: ifne +227 -> 330
    //   106: aconst_null
    //   107: ldc_w 1382
    //   110: ldc_w 485
    //   113: ldc_w 485
    //   116: ldc_w 1384
    //   119: ldc_w 1384
    //   122: iconst_0
    //   123: iconst_0
    //   124: aload_1
    //   125: getfield 1350	adil:jdField_a_of_type_Adik	Ladik;
    //   128: getfield 751	adik:b	Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
    //   131: getfield 559	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:picId	Ljava/lang/String;
    //   134: ldc_w 975
    //   137: ldc_w 485
    //   140: ldc_w 485
    //   143: invokestatic 980	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   146: aload_0
    //   147: getfield 1061	adku:jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   150: getfield 1066	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:recognitions	Ljava/util/ArrayList;
    //   153: lconst_1
    //   154: invokestatic 1071	com/tencent/mobileqq/ar/ARRecognition:b	(Ljava/util/ArrayList;J)Z
    //   157: ifne +323 -> 480
    //   160: aload_1
    //   161: getfield 1350	adil:jdField_a_of_type_Adik	Ladik;
    //   164: getfield 751	adik:b	Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
    //   167: astore_2
    //   168: ldc 232
    //   170: iconst_1
    //   171: new 234	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 1386
    //   181: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_2
    //   185: invokevirtual 754	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:aek	()Z
    //   188: invokevirtual 536	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   191: ldc_w 1388
    //   194: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_2
    //   198: invokevirtual 1371	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:ael	()Z
    //   201: invokevirtual 536	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   204: ldc_w 1390
    //   207: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_2
    //   211: invokevirtual 1393	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:aem	()Z
    //   214: invokevirtual 536	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   217: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 304	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: aload_0
    //   224: getfield 204	adku:mIsInited	Z
    //   227: ifeq +36 -> 263
    //   230: aload_0
    //   231: getfield 207	adku:cHX	I
    //   234: iconst_2
    //   235: if_icmpne +28 -> 263
    //   238: aload_0
    //   239: getfield 209	adku:jdField_a_of_type_Adib	Ladib;
    //   242: ifnull +21 -> 263
    //   245: aload_0
    //   246: getfield 209	adku:jdField_a_of_type_Adib	Ladib;
    //   249: lconst_1
    //   250: new 387	adec
    //   253: dup
    //   254: aload_2
    //   255: invokespecial 390	adec:<init>	(Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;)V
    //   258: invokeinterface 1396 4 0
    //   263: aload_2
    //   264: invokevirtual 416	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:aei	()Z
    //   267: ifne +269 -> 536
    //   270: aload_2
    //   271: invokevirtual 754	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:aek	()Z
    //   274: ifeq +213 -> 487
    //   277: aload_0
    //   278: lconst_1
    //   279: invokevirtual 1074	adku:iM	(J)V
    //   282: aload_0
    //   283: lconst_1
    //   284: aload_2
    //   285: aload_1
    //   286: getfield 1350	adil:jdField_a_of_type_Adik	Ladik;
    //   289: getfield 762	adik:markerType	I
    //   292: aload_1
    //   293: getfield 1350	adil:jdField_a_of_type_Adik	Ladik;
    //   296: getfield 766	adik:sY	F
    //   299: aload_1
    //   300: getfield 1350	adil:jdField_a_of_type_Adik	Ladik;
    //   303: getfield 769	adik:sZ	F
    //   306: aload_1
    //   307: getfield 1350	adil:jdField_a_of_type_Adik	Ladik;
    //   310: getfield 772	adik:ta	F
    //   313: invokespecial 775	adku:a	(JLcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;IFFF)Z
    //   316: pop
    //   317: aload_2
    //   318: invokevirtual 443	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:aeo	()Z
    //   321: ifeq +9 -> 330
    //   324: aload_0
    //   325: iconst_0
    //   326: invokespecial 1016	adku:bb	(Z)Z
    //   329: pop
    //   330: aload_1
    //   331: getfield 1350	adil:jdField_a_of_type_Adik	Ladik;
    //   334: getfield 749	adik:state	I
    //   337: iconst_2
    //   338: if_icmpeq +16 -> 354
    //   341: aload_1
    //   342: getfield 1350	adil:jdField_a_of_type_Adik	Ladik;
    //   345: getfield 751	adik:b	Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
    //   348: invokevirtual 416	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:aei	()Z
    //   351: ifeq +36 -> 387
    //   354: aload_0
    //   355: aload_1
    //   356: getfield 1350	adil:jdField_a_of_type_Adik	Ladik;
    //   359: aload_0
    //   360: getfield 1398	adku:jdField_c_of_type_Adik	Ladik;
    //   363: invokespecial 1400	adku:a	(Ladik;Ladik;)V
    //   366: aload_1
    //   367: getfield 1350	adil:jdField_a_of_type_Adik	Ladik;
    //   370: getfield 749	adik:state	I
    //   373: iconst_2
    //   374: if_icmpeq +211 -> 585
    //   377: aload_0
    //   378: lconst_0
    //   379: putfield 269	adku:UA	J
    //   382: aload_0
    //   383: lconst_0
    //   384: putfield 957	adku:UB	J
    //   387: aload_1
    //   388: ifnull -369 -> 19
    //   391: aload_1
    //   392: getfield 1350	adil:jdField_a_of_type_Adik	Ladik;
    //   395: ifnull +1353 -> 1748
    //   398: aload_0
    //   399: aload_1
    //   400: getfield 1350	adil:jdField_a_of_type_Adik	Ladik;
    //   403: putfield 1398	adku:jdField_c_of_type_Adik	Ladik;
    //   406: aload_1
    //   407: getfield 1350	adil:jdField_a_of_type_Adik	Ladik;
    //   410: getfield 751	adik:b	Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
    //   413: ifnull -394 -> 19
    //   416: aload_1
    //   417: getfield 1350	adil:jdField_a_of_type_Adik	Ladik;
    //   420: getfield 751	adik:b	Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
    //   423: invokevirtual 416	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:aei	()Z
    //   426: ifne -407 -> 19
    //   429: aload_0
    //   430: aconst_null
    //   431: putfield 1378	adku:jdField_b_of_type_Adik	Ladik;
    //   434: aload_0
    //   435: aconst_null
    //   436: putfield 1398	adku:jdField_c_of_type_Adik	Ladik;
    //   439: goto -420 -> 19
    //   442: astore_1
    //   443: aload_0
    //   444: monitorexit
    //   445: aload_1
    //   446: athrow
    //   447: astore_2
    //   448: ldc 232
    //   450: iconst_1
    //   451: new 234	java/lang/StringBuilder
    //   454: dup
    //   455: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   458: ldc_w 1402
    //   461: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: aload_2
    //   465: invokevirtual 1405	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   468: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: invokestatic 304	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   477: goto -331 -> 146
    //   480: aload_0
    //   481: invokespecial 1100	adku:cSk	()V
    //   484: goto -324 -> 160
    //   487: aload_2
    //   488: invokevirtual 1393	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:aem	()Z
    //   491: ifne +10 -> 501
    //   494: aload_2
    //   495: invokevirtual 1371	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:ael	()Z
    //   498: ifeq +31 -> 529
    //   501: aload_2
    //   502: invokevirtual 1371	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:ael	()Z
    //   505: ifeq -175 -> 330
    //   508: aload_0
    //   509: lconst_1
    //   510: invokevirtual 1074	adku:iM	(J)V
    //   513: aload_2
    //   514: invokevirtual 443	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:aeo	()Z
    //   517: ifeq -187 -> 330
    //   520: aload_0
    //   521: iconst_1
    //   522: invokespecial 1016	adku:bb	(Z)Z
    //   525: pop
    //   526: goto -196 -> 330
    //   529: aload_0
    //   530: invokespecial 660	adku:cSp	()V
    //   533: goto -203 -> 330
    //   536: aload_2
    //   537: invokevirtual 754	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:aek	()Z
    //   540: ifne -210 -> 330
    //   543: aload_2
    //   544: invokevirtual 1393	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:aem	()Z
    //   547: ifne +10 -> 557
    //   550: aload_2
    //   551: invokevirtual 1371	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:ael	()Z
    //   554: ifeq -224 -> 330
    //   557: aload_2
    //   558: invokevirtual 1371	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:ael	()Z
    //   561: ifeq -231 -> 330
    //   564: aload_0
    //   565: lconst_1
    //   566: invokevirtual 1074	adku:iM	(J)V
    //   569: aload_2
    //   570: invokevirtual 443	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:aeo	()Z
    //   573: ifeq -243 -> 330
    //   576: aload_0
    //   577: iconst_1
    //   578: invokespecial 1016	adku:bb	(Z)Z
    //   581: pop
    //   582: goto -252 -> 330
    //   585: aload_0
    //   586: getfield 623	adku:jdField_b_of_type_Adhr	Ladhr;
    //   589: ifnull +23 -> 612
    //   592: aload_0
    //   593: getfield 645	adku:bOg	Z
    //   596: ifeq +16 -> 612
    //   599: aload_0
    //   600: lconst_0
    //   601: putfield 269	adku:UA	J
    //   604: aload_0
    //   605: lconst_0
    //   606: putfield 957	adku:UB	J
    //   609: goto -222 -> 387
    //   612: aload_0
    //   613: getfield 269	adku:UA	J
    //   616: lconst_0
    //   617: lcmp
    //   618: ifne +10 -> 628
    //   621: aload_0
    //   622: invokestatic 801	java/lang/System:currentTimeMillis	()J
    //   625: putfield 269	adku:UA	J
    //   628: aload_0
    //   629: invokestatic 801	java/lang/System:currentTimeMillis	()J
    //   632: putfield 957	adku:UB	J
    //   635: aload_0
    //   636: getfield 269	adku:UA	J
    //   639: lconst_0
    //   640: lcmp
    //   641: ifle -254 -> 387
    //   644: aload_0
    //   645: getfield 957	adku:UB	J
    //   648: aload_0
    //   649: getfield 269	adku:UA	J
    //   652: lsub
    //   653: ldc2_w 805
    //   656: lcmp
    //   657: ifle -270 -> 387
    //   660: aload_0
    //   661: ldc2_w 1406
    //   664: putfield 269	adku:UA	J
    //   667: aload_0
    //   668: invokespecial 660	adku:cSp	()V
    //   671: goto -284 -> 387
    //   674: aload_1
    //   675: ifnull +385 -> 1060
    //   678: aload_1
    //   679: getfield 1352	adil:jdField_a_of_type_Adig	Ladig;
    //   682: ifnull +378 -> 1060
    //   685: aload_0
    //   686: aload_0
    //   687: getfield 1380	adku:jdField_b_of_type_Adig	Ladig;
    //   690: aload_0
    //   691: getfield 1409	adku:jdField_c_of_type_Adig	Ladig;
    //   694: invokespecial 1411	adku:a	(Ladig;Ladig;)V
    //   697: iconst_0
    //   698: istore 5
    //   700: iconst_0
    //   701: istore 4
    //   703: aload_0
    //   704: getfield 1380	adku:jdField_b_of_type_Adig	Ladig;
    //   707: getfield 1414	adig:us	Ljava/util/ArrayList;
    //   710: invokevirtual 1143	java/util/ArrayList:size	()I
    //   713: istore_3
    //   714: iload_3
    //   715: ifle +48 -> 763
    //   718: aload_0
    //   719: getfield 1380	adku:jdField_b_of_type_Adig	Ladig;
    //   722: getfield 1414	adig:us	Ljava/util/ArrayList;
    //   725: invokevirtual 540	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   728: astore_2
    //   729: iload 4
    //   731: istore 5
    //   733: aload_2
    //   734: invokeinterface 545 1 0
    //   739: ifeq +24 -> 763
    //   742: aload_2
    //   743: invokeinterface 549 1 0
    //   748: checkcast 1416	com/tencent/mobileqq/ar/DrawView2$a
    //   751: getfield 1419	com/tencent/mobileqq/ar/DrawView2$a:bMw	Z
    //   754: ifne +1012 -> 1766
    //   757: iconst_1
    //   758: istore 4
    //   760: goto +1006 -> 1766
    //   763: invokestatic 721	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   766: ifeq +46 -> 812
    //   769: getstatic 726	adie:bNm	Z
    //   772: ifeq +40 -> 812
    //   775: ldc 232
    //   777: iconst_2
    //   778: new 234	java/lang/StringBuilder
    //   781: dup
    //   782: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   785: ldc_w 1421
    //   788: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   791: iload_3
    //   792: invokevirtual 244	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   795: ldc_w 1423
    //   798: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: iload 5
    //   803: invokevirtual 536	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   806: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   809: invokestatic 254	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   812: iload 5
    //   814: ifeq +99 -> 913
    //   817: aconst_null
    //   818: ldc_w 1382
    //   821: ldc_w 485
    //   824: ldc_w 485
    //   827: ldc_w 1384
    //   830: ldc_w 1384
    //   833: iconst_0
    //   834: iconst_0
    //   835: aload_1
    //   836: getfield 1352	adil:jdField_a_of_type_Adig	Ladig;
    //   839: getfield 1414	adig:us	Ljava/util/ArrayList;
    //   842: iconst_0
    //   843: invokevirtual 429	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   846: checkcast 1416	com/tencent/mobileqq/ar/DrawView2$a
    //   849: getfield 1426	com/tencent/mobileqq/ar/DrawView2$a:faceID	I
    //   852: invokestatic 1429	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   855: ldc_w 1431
    //   858: ldc_w 485
    //   861: ldc_w 485
    //   864: invokestatic 980	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   867: aload_0
    //   868: lconst_0
    //   869: putfield 1433	adku:UE	J
    //   872: aload_0
    //   873: lconst_0
    //   874: putfield 1435	adku:UF	J
    //   877: goto -490 -> 387
    //   880: astore_2
    //   881: ldc 232
    //   883: iconst_1
    //   884: new 234	java/lang/StringBuilder
    //   887: dup
    //   888: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   891: ldc_w 1402
    //   894: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   897: aload_2
    //   898: invokevirtual 1405	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   901: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   907: invokestatic 304	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   910: goto -43 -> 867
    //   913: ldc2_w 1436
    //   916: lstore 6
    //   918: invokestatic 1440	adie:qR	()Z
    //   921: ifeq +8 -> 929
    //   924: ldc2_w 1441
    //   927: lstore 6
    //   929: aload_0
    //   930: getfield 1433	adku:UE	J
    //   933: lconst_0
    //   934: lcmp
    //   935: ifne +10 -> 945
    //   938: aload_0
    //   939: invokestatic 801	java/lang/System:currentTimeMillis	()J
    //   942: putfield 1433	adku:UE	J
    //   945: aload_0
    //   946: invokestatic 801	java/lang/System:currentTimeMillis	()J
    //   949: putfield 1435	adku:UF	J
    //   952: aload_0
    //   953: getfield 1433	adku:UE	J
    //   956: lconst_0
    //   957: lcmp
    //   958: ifle -571 -> 387
    //   961: aload_0
    //   962: getfield 1435	adku:UF	J
    //   965: aload_0
    //   966: getfield 1433	adku:UE	J
    //   969: lsub
    //   970: lload 6
    //   972: lcmp
    //   973: ifle -586 -> 387
    //   976: invokestatic 721	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   979: ifeq +30 -> 1009
    //   982: ldc 232
    //   984: iconst_2
    //   985: new 234	java/lang/StringBuilder
    //   988: dup
    //   989: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   992: ldc_w 1444
    //   995: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: lload 6
    //   1000: invokevirtual 369	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1003: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1006: invokestatic 254	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1009: aload_0
    //   1010: ldc2_w 692
    //   1013: invokevirtual 1074	adku:iM	(J)V
    //   1016: aload_0
    //   1017: ldc2_w 1406
    //   1020: putfield 1433	adku:UE	J
    //   1023: aload_0
    //   1024: getfield 1380	adku:jdField_b_of_type_Adig	Ladig;
    //   1027: iconst_1
    //   1028: putfield 1447	adig:isTimeOut	Z
    //   1031: aload_0
    //   1032: aload_0
    //   1033: getfield 1380	adku:jdField_b_of_type_Adig	Ladig;
    //   1036: aload_0
    //   1037: getfield 1409	adku:jdField_c_of_type_Adig	Ladig;
    //   1040: invokespecial 1411	adku:a	(Ladig;Ladig;)V
    //   1043: aload_0
    //   1044: aconst_null
    //   1045: putfield 1380	adku:jdField_b_of_type_Adig	Ladig;
    //   1048: aload_0
    //   1049: aconst_null
    //   1050: putfield 1409	adku:jdField_c_of_type_Adig	Ladig;
    //   1053: aload_0
    //   1054: invokespecial 1449	adku:cSs	()V
    //   1057: goto -670 -> 387
    //   1060: aload_2
    //   1061: ifnull -674 -> 387
    //   1064: aload_0
    //   1065: getfield 1061	adku:jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   1068: getfield 1066	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:recognitions	Ljava/util/ArrayList;
    //   1071: aload_2
    //   1072: invokestatic 1452	com/tencent/mobileqq/ar/ARRecognition:a	(Ljava/util/ArrayList;Ladhr;)Lcom/tencent/mobileqq/ar/ARRecognition$b;
    //   1075: astore 8
    //   1077: aload 8
    //   1079: getfield 1457	com/tencent/mobileqq/ar/ARRecognition$b:Sb	J
    //   1082: lstore 6
    //   1084: aload 8
    //   1086: getfield 1460	com/tencent/mobileqq/ar/ARRecognition$b:bLk	Z
    //   1089: istore 4
    //   1091: aload_0
    //   1092: getfield 1061	adku:jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   1095: getfield 1066	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:recognitions	Ljava/util/ArrayList;
    //   1098: lload 6
    //   1100: invokestatic 1071	com/tencent/mobileqq/ar/ARRecognition:b	(Ljava/util/ArrayList;J)Z
    //   1103: istore 5
    //   1105: aload_0
    //   1106: getfield 217	adku:jdField_b_of_type_Adin	Ladin;
    //   1109: ifnull +34 -> 1143
    //   1112: lload 6
    //   1114: ldc2_w 1272
    //   1117: lcmp
    //   1118: ifeq +25 -> 1143
    //   1121: aload_0
    //   1122: iconst_0
    //   1123: invokespecial 982	adku:Go	(Z)V
    //   1126: aload_0
    //   1127: getfield 1462	adku:bOi	Z
    //   1130: ifeq +13 -> 1143
    //   1133: aload_0
    //   1134: lconst_1
    //   1135: invokevirtual 697	adku:iN	(J)V
    //   1138: aload_0
    //   1139: iconst_0
    //   1140: putfield 1462	adku:bOi	Z
    //   1143: lload 6
    //   1145: lconst_0
    //   1146: lcmp
    //   1147: ifeq -760 -> 387
    //   1150: lload 6
    //   1152: ldc2_w 692
    //   1155: lcmp
    //   1156: ifne +81 -> 1237
    //   1159: iload 5
    //   1161: ifeq +14 -> 1175
    //   1164: aload_0
    //   1165: aload_2
    //   1166: getfield 1465	adhr:jdField_a_of_type_Adht	Ladht;
    //   1169: invokespecial 1467	adku:a	(Ladht;)V
    //   1172: goto -785 -> 387
    //   1175: aload_0
    //   1176: getfield 1061	adku:jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   1179: getfield 1066	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:recognitions	Ljava/util/ArrayList;
    //   1182: ldc2_w 1468
    //   1185: lconst_1
    //   1186: invokestatic 1472	com/tencent/mobileqq/ar/ARRecognition:b	(Ljava/util/ArrayList;JJ)Z
    //   1189: ifeq +14 -> 1203
    //   1192: aload_0
    //   1193: aload_2
    //   1194: getfield 1465	adhr:jdField_a_of_type_Adht	Ladht;
    //   1197: invokespecial 1467	adku:a	(Ladht;)V
    //   1200: goto -813 -> 387
    //   1203: aload_0
    //   1204: getfield 1378	adku:jdField_b_of_type_Adik	Ladik;
    //   1207: ifnull +14 -> 1221
    //   1210: aload_0
    //   1211: getfield 1378	adku:jdField_b_of_type_Adik	Ladik;
    //   1214: getfield 749	adik:state	I
    //   1217: iconst_2
    //   1218: if_icmpne -831 -> 387
    //   1221: aload_0
    //   1222: lconst_1
    //   1223: invokevirtual 1074	adku:iM	(J)V
    //   1226: aload_0
    //   1227: aload_2
    //   1228: getfield 1465	adhr:jdField_a_of_type_Adht	Ladht;
    //   1231: invokespecial 1467	adku:a	(Ladht;)V
    //   1234: goto -847 -> 387
    //   1237: lload 6
    //   1239: ldc2_w 417
    //   1242: lcmp
    //   1243: ifne +81 -> 1324
    //   1246: iload 5
    //   1248: ifeq +14 -> 1262
    //   1251: aload_0
    //   1252: aload_2
    //   1253: getfield 1475	adhr:jdField_a_of_type_Adhk	Ladhk;
    //   1256: invokespecial 1477	adku:a	(Ladhk;)V
    //   1259: goto -872 -> 387
    //   1262: aload_0
    //   1263: getfield 1061	adku:jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   1266: getfield 1066	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:recognitions	Ljava/util/ArrayList;
    //   1269: ldc2_w 417
    //   1272: lconst_1
    //   1273: invokestatic 1472	com/tencent/mobileqq/ar/ARRecognition:b	(Ljava/util/ArrayList;JJ)Z
    //   1276: ifeq +14 -> 1290
    //   1279: aload_0
    //   1280: aload_2
    //   1281: getfield 1475	adhr:jdField_a_of_type_Adhk	Ladhk;
    //   1284: invokespecial 1477	adku:a	(Ladhk;)V
    //   1287: goto -900 -> 387
    //   1290: aload_0
    //   1291: getfield 1378	adku:jdField_b_of_type_Adik	Ladik;
    //   1294: ifnull +14 -> 1308
    //   1297: aload_0
    //   1298: getfield 1378	adku:jdField_b_of_type_Adik	Ladik;
    //   1301: getfield 749	adik:state	I
    //   1304: iconst_2
    //   1305: if_icmpne -918 -> 387
    //   1308: aload_0
    //   1309: lconst_1
    //   1310: invokevirtual 1074	adku:iM	(J)V
    //   1313: aload_0
    //   1314: aload_2
    //   1315: getfield 1475	adhr:jdField_a_of_type_Adhk	Ladhk;
    //   1318: invokespecial 1477	adku:a	(Ladhk;)V
    //   1321: goto -934 -> 387
    //   1324: lload 6
    //   1326: ldc2_w 1272
    //   1329: lcmp
    //   1330: ifne +120 -> 1450
    //   1333: iload 5
    //   1335: ifeq +14 -> 1349
    //   1338: aload_0
    //   1339: aload_2
    //   1340: getfield 1221	adhr:jdField_a_of_type_Adin	Ladin;
    //   1343: invokespecial 1479	adku:a	(Ladin;)V
    //   1346: goto -959 -> 387
    //   1349: aload_0
    //   1350: getfield 1014	adku:bOj	Z
    //   1353: ifeq +30 -> 1383
    //   1356: aload_0
    //   1357: getfield 217	adku:jdField_b_of_type_Adin	Ladin;
    //   1360: ifnull +8 -> 1368
    //   1363: aload_0
    //   1364: iconst_0
    //   1365: invokespecial 982	adku:Go	(Z)V
    //   1368: aload_0
    //   1369: getfield 1462	adku:bOi	Z
    //   1372: ifeq -1353 -> 19
    //   1375: aload_0
    //   1376: iconst_0
    //   1377: putfield 1462	adku:bOi	Z
    //   1380: goto -1361 -> 19
    //   1383: aload_0
    //   1384: getfield 1061	adku:jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   1387: getfield 1066	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:recognitions	Ljava/util/ArrayList;
    //   1390: ldc2_w 1272
    //   1393: lconst_1
    //   1394: invokestatic 1472	com/tencent/mobileqq/ar/ARRecognition:b	(Ljava/util/ArrayList;JJ)Z
    //   1397: ifeq +14 -> 1411
    //   1400: aload_0
    //   1401: aload_2
    //   1402: getfield 1221	adhr:jdField_a_of_type_Adin	Ladin;
    //   1405: invokespecial 1479	adku:a	(Ladin;)V
    //   1408: goto -1021 -> 387
    //   1411: aload_0
    //   1412: getfield 1378	adku:jdField_b_of_type_Adik	Ladik;
    //   1415: ifnull +14 -> 1429
    //   1418: aload_0
    //   1419: getfield 1378	adku:jdField_b_of_type_Adik	Ladik;
    //   1422: getfield 749	adik:state	I
    //   1425: iconst_2
    //   1426: if_icmpne -1039 -> 387
    //   1429: aload_0
    //   1430: lconst_1
    //   1431: invokevirtual 1074	adku:iM	(J)V
    //   1434: aload_0
    //   1435: iconst_1
    //   1436: putfield 1462	adku:bOi	Z
    //   1439: aload_0
    //   1440: aload_2
    //   1441: getfield 1221	adhr:jdField_a_of_type_Adin	Ladin;
    //   1444: invokespecial 1479	adku:a	(Ladin;)V
    //   1447: goto -1060 -> 387
    //   1450: lload 6
    //   1452: lconst_1
    //   1453: lcmp
    //   1454: ifne +40 -> 1494
    //   1457: iload 5
    //   1459: ifeq +14 -> 1473
    //   1462: aload_0
    //   1463: aload_2
    //   1464: getfield 1482	adhr:jdField_a_of_type_Adhh	Ladhh;
    //   1467: invokespecial 1484	adku:a	(Ladhh;)V
    //   1470: goto -1083 -> 387
    //   1473: iload 4
    //   1475: ifeq +8 -> 1483
    //   1478: aload_0
    //   1479: lconst_1
    //   1480: invokevirtual 697	adku:iN	(J)V
    //   1483: aload_0
    //   1484: aload_2
    //   1485: getfield 1482	adhr:jdField_a_of_type_Adhh	Ladhh;
    //   1488: invokespecial 1484	adku:a	(Ladhh;)V
    //   1491: goto -1104 -> 387
    //   1494: lload 6
    //   1496: ldc2_w 419
    //   1499: lcmp
    //   1500: ifne -1113 -> 387
    //   1503: iload 5
    //   1505: ifeq +14 -> 1519
    //   1508: aload_0
    //   1509: aload_2
    //   1510: getfield 1487	adhr:jdField_a_of_type_Adhy	Ladhy;
    //   1513: invokespecial 1489	adku:a	(Ladhy;)V
    //   1516: goto -1129 -> 387
    //   1519: aload_0
    //   1520: getfield 1061	adku:jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   1523: getfield 1066	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:recognitions	Ljava/util/ArrayList;
    //   1526: ldc2_w 419
    //   1529: lconst_1
    //   1530: invokestatic 1472	com/tencent/mobileqq/ar/ARRecognition:b	(Ljava/util/ArrayList;JJ)Z
    //   1533: ifeq +14 -> 1547
    //   1536: aload_0
    //   1537: aload_2
    //   1538: getfield 1487	adhr:jdField_a_of_type_Adhy	Ladhy;
    //   1541: invokespecial 1489	adku:a	(Ladhy;)V
    //   1544: goto -1157 -> 387
    //   1547: aload_0
    //   1548: getfield 1378	adku:jdField_b_of_type_Adik	Ladik;
    //   1551: ifnull +14 -> 1565
    //   1554: aload_0
    //   1555: getfield 1378	adku:jdField_b_of_type_Adik	Ladik;
    //   1558: getfield 749	adik:state	I
    //   1561: iconst_2
    //   1562: if_icmpne -1175 -> 387
    //   1565: aload_0
    //   1566: lconst_1
    //   1567: invokevirtual 1074	adku:iM	(J)V
    //   1570: aload_0
    //   1571: aload_2
    //   1572: getfield 1487	adhr:jdField_a_of_type_Adhy	Ladhy;
    //   1575: invokespecial 1489	adku:a	(Ladhy;)V
    //   1578: goto -1191 -> 387
    //   1581: aload_0
    //   1582: getfield 144	adku:Ux	J
    //   1585: lconst_0
    //   1586: lcmp
    //   1587: ifeq +51 -> 1638
    //   1590: aload_1
    //   1591: ifnull -1572 -> 19
    //   1594: aload_1
    //   1595: getfield 1350	adil:jdField_a_of_type_Adik	Ladik;
    //   1598: ifnull +18 -> 1616
    //   1601: aload_0
    //   1602: aload_1
    //   1603: getfield 1350	adil:jdField_a_of_type_Adik	Ladik;
    //   1606: aload_0
    //   1607: getfield 1398	adku:jdField_c_of_type_Adik	Ladik;
    //   1610: invokespecial 1400	adku:a	(Ladik;Ladik;)V
    //   1613: goto -1226 -> 387
    //   1616: aload_1
    //   1617: getfield 1352	adil:jdField_a_of_type_Adig	Ladig;
    //   1620: ifnull -1233 -> 387
    //   1623: aload_0
    //   1624: aload_1
    //   1625: getfield 1352	adil:jdField_a_of_type_Adig	Ladig;
    //   1628: aload_0
    //   1629: getfield 1409	adku:jdField_c_of_type_Adig	Ladig;
    //   1632: invokespecial 1411	adku:a	(Ladig;Ladig;)V
    //   1635: goto -1248 -> 387
    //   1638: aload_0
    //   1639: getfield 146	adku:Uy	J
    //   1642: lconst_0
    //   1643: lcmp
    //   1644: ifeq -1257 -> 387
    //   1647: aload_2
    //   1648: ifnull -1629 -> 19
    //   1651: aload_2
    //   1652: getfield 1475	adhr:jdField_a_of_type_Adhk	Ladhk;
    //   1655: invokestatic 1494	adhk:a	(Ladhk;)Z
    //   1658: ifeq +14 -> 1672
    //   1661: aload_0
    //   1662: aload_2
    //   1663: getfield 1475	adhr:jdField_a_of_type_Adhk	Ladhk;
    //   1666: invokespecial 1477	adku:a	(Ladhk;)V
    //   1669: goto -1282 -> 387
    //   1672: aload_2
    //   1673: getfield 1221	adhr:jdField_a_of_type_Adin	Ladin;
    //   1676: invokestatic 1497	adin:a	(Ladhi;)Z
    //   1679: ifeq +14 -> 1693
    //   1682: aload_0
    //   1683: aload_2
    //   1684: getfield 1221	adhr:jdField_a_of_type_Adin	Ladin;
    //   1687: invokespecial 1479	adku:a	(Ladin;)V
    //   1690: goto -1303 -> 387
    //   1693: aload_2
    //   1694: getfield 1482	adhr:jdField_a_of_type_Adhh	Ladhh;
    //   1697: invokestatic 1502	adhh:a	(Ladhh;)Z
    //   1700: ifeq +10 -> 1710
    //   1703: aload_0
    //   1704: invokespecial 660	adku:cSp	()V
    //   1707: goto -1320 -> 387
    //   1710: aload_2
    //   1711: getfield 1465	adhr:jdField_a_of_type_Adht	Ladht;
    //   1714: invokestatic 1506	adht:a	(Ladht;)Z
    //   1717: ifeq +10 -> 1727
    //   1720: aload_0
    //   1721: invokespecial 1449	adku:cSs	()V
    //   1724: goto -1337 -> 387
    //   1727: aload_2
    //   1728: getfield 1487	adhr:jdField_a_of_type_Adhy	Ladhy;
    //   1731: invokestatic 1511	adhy:a	(Ladhy;)Z
    //   1734: ifeq -1347 -> 387
    //   1737: aload_0
    //   1738: aload_2
    //   1739: getfield 1487	adhr:jdField_a_of_type_Adhy	Ladhy;
    //   1742: invokespecial 1489	adku:a	(Ladhy;)V
    //   1745: goto -1358 -> 387
    //   1748: aload_1
    //   1749: getfield 1352	adil:jdField_a_of_type_Adig	Ladig;
    //   1752: ifnull -1733 -> 19
    //   1755: aload_0
    //   1756: aload_1
    //   1757: getfield 1352	adil:jdField_a_of_type_Adig	Ladig;
    //   1760: putfield 1409	adku:jdField_c_of_type_Adig	Ladig;
    //   1763: goto -1744 -> 19
    //   1766: goto -1037 -> 729
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1769	0	this	adku
    //   0	1769	1	paramadil	adil
    //   0	1769	2	paramadhr	adhr
    //   13	779	3	i	int
    //   701	773	4	bool1	boolean
    //   698	806	5	bool2	boolean
    //   916	579	6	l	long
    //   1075	10	8	localb	com.tencent.mobileqq.ar.ARRecognition.b
    // Exception table:
    //   from	to	target	type
    //   2	14	442	finally
    //   26	41	442	finally
    //   41	56	442	finally
    //   60	65	442	finally
    //   65	83	442	finally
    //   87	102	442	finally
    //   106	146	442	finally
    //   146	160	442	finally
    //   160	263	442	finally
    //   263	330	442	finally
    //   330	354	442	finally
    //   354	387	442	finally
    //   391	439	442	finally
    //   448	477	442	finally
    //   480	484	442	finally
    //   487	501	442	finally
    //   501	526	442	finally
    //   529	533	442	finally
    //   536	557	442	finally
    //   557	582	442	finally
    //   585	609	442	finally
    //   612	628	442	finally
    //   628	671	442	finally
    //   678	697	442	finally
    //   703	714	442	finally
    //   718	729	442	finally
    //   733	757	442	finally
    //   763	812	442	finally
    //   817	867	442	finally
    //   867	877	442	finally
    //   881	910	442	finally
    //   918	924	442	finally
    //   929	945	442	finally
    //   945	1009	442	finally
    //   1009	1057	442	finally
    //   1064	1112	442	finally
    //   1121	1143	442	finally
    //   1164	1172	442	finally
    //   1175	1200	442	finally
    //   1203	1221	442	finally
    //   1221	1234	442	finally
    //   1251	1259	442	finally
    //   1262	1287	442	finally
    //   1290	1308	442	finally
    //   1308	1321	442	finally
    //   1338	1346	442	finally
    //   1349	1368	442	finally
    //   1368	1380	442	finally
    //   1383	1408	442	finally
    //   1411	1429	442	finally
    //   1429	1447	442	finally
    //   1462	1470	442	finally
    //   1478	1483	442	finally
    //   1483	1491	442	finally
    //   1508	1516	442	finally
    //   1519	1544	442	finally
    //   1547	1565	442	finally
    //   1565	1578	442	finally
    //   1581	1590	442	finally
    //   1594	1613	442	finally
    //   1616	1635	442	finally
    //   1638	1647	442	finally
    //   1651	1669	442	finally
    //   1672	1690	442	finally
    //   1693	1707	442	finally
    //   1710	1724	442	finally
    //   1727	1745	442	finally
    //   1748	1763	442	finally
    //   106	146	447	java/lang/Exception
    //   817	867	880	java/lang/Exception
  }
  
  public void a(Context arg1, AppInterface paramAppInterface)
  {
    super.a(???, paramAppInterface);
    System.currentTimeMillis();
    QLog.d("AREngine_QQARSession", 1, String.format("init context=%s appInterface=%s mIsInited=%s", new Object[] { ???, paramAppInterface, Boolean.valueOf(this.mIsInited) }));
    if (this.mIsInited) {
      return;
    }
    this.jdField_c_of_type_Addz = new addz();
    synchronized (this.df)
    {
      if (this.J == null)
      {
        this.J = ThreadManager.newFreeHandlerThread("AREngineThread", 0);
        this.J.start();
        this.cH = new Handler(this.J.getLooper());
        this.mTaskList = new ArrayList();
      }
      this.mIsInited = true;
      return;
    }
  }
  
  public void a(ArCloudConfigInfo paramArCloudConfigInfo, int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QQARSession", 2, "onCommonCallbackFromManager, resourceInfo=" + paramArCloudConfigInfo + ", action=" + paramInt1 + ", result=" + paramInt2 + " ,data=" + paramObject);
    }
    ac(new QQARSession.26(this, paramArCloudConfigInfo, paramInt1, paramInt2, paramObject));
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo, adda paramadda)
  {
    QLog.i("AREngine_QQARSession", 1, "onRenderManagerCallback. onMultiARAnimationInteraction.");
    ac(new QQARSession.25(this, paramArVideoResourceInfo, paramadda));
  }
  
  public void a(boolean paramBoolean, int paramInt, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    QLog.i("AREngine_QQARSession", 1, "onARMarkerResourceDownloadComplete. result = " + paramBoolean + " type  " + paramInt);
    if ((this.mIsInited) && (this.cHX != 2)) {}
  }
  
  public void a(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    QLog.i("AREngine_QQARSession", 1, String.format("onARMarkerAllDownloadComplete result=%s config=%s", new Object[] { Boolean.valueOf(paramBoolean), paramArCloudConfigInfo }));
    if ((paramBoolean) && (paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.bOa) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.bNZ) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.but)) && (!paramArCloudConfigInfo.aek()))
    {
      this.jdField_a_of_type_Adib.ch(0, paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.but);
      this.cIs = 1;
      this.h = paramArCloudConfigInfo;
      return;
    }
    d(paramBoolean, paramArCloudConfigInfo);
  }
  
  public boolean a(adin paramadin)
  {
    return (this.jdField_b_of_type_Adin == null) || (!this.jdField_b_of_type_Adin.b(paramadin));
  }
  
  public boolean aeO()
  {
    return this.bOb;
  }
  
  public boolean aeU()
  {
    return this.jdField_e_of_type_ComTencentMobileqqArAidlArCloudConfigInfo != null;
  }
  
  public boolean aeV()
  {
    QLog.i("AREngine_QQARSession", 1, "stopInternal.");
    this.bOt = true;
    cSw();
    aeS();
    aeT();
    this.jdField_b_of_type_Adik = null;
    this.jdField_c_of_type_Adik = null;
    this.jdField_b_of_type_Adig = null;
    this.jdField_c_of_type_Adig = null;
    this.jdField_b_of_type_Adhr = null;
    this.bOg = false;
    this.Uz = 0L;
    this.jdField_e_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
    this.f = null;
    this.UA = 0L;
    this.UB = 0L;
    this.UC = 0L;
    this.UD = 0L;
    this.bOk = false;
    this.bOt = false;
    this.UE = 0L;
    this.UF = 0L;
    return true;
  }
  
  public boolean aes()
  {
    return false;
  }
  
  public void b(int paramInt, adhr paramadhr)
  {
    if (this.bOs) {
      QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete mIsForbiddenLocalMarkAndCloudRecg:do nothing but return ");
    }
    for (;;)
    {
      return;
      QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. retCode = " + paramInt + ", recogResult = " + paramadhr + ":time is:" + (System.currentTimeMillis() - this.currentTime));
      this.currentTime = System.currentTimeMillis();
      if ((paramInt == 0) && (this.bOp))
      {
        this.bOp = false;
        anot.a(null, "dc00898", "", "", "0X80085AE", "0X80085AE", 0, 0, "", "", "", "");
      }
      if (((this.jdField_b_of_type_Adhr == null) || (this.jdField_b_of_type_Adin != null)) && ((this.jdField_b_of_type_Adik == null) || (this.jdField_b_of_type_Adik.state == 2)) && ((this.jdField_b_of_type_Adig == null) || (this.jdField_b_of_type_Adig.us.size() <= 0)) && (!aeU())) {
        break;
      }
      if ((this.jdField_b_of_type_Adhr != null) && (this.jdField_b_of_type_Adin == null)) {
        QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. mCurCloudRecogResult != null.");
      }
      while (this.jdField_a_of_type_Adgy != null)
      {
        this.jdField_a_of_type_Adgy.Gd(true);
        return;
        if ((this.jdField_b_of_type_Adik != null) && (this.jdField_b_of_type_Adik.state != 2)) {
          QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. mCurLocalMarkerRecogResult.state != ARConstants.AR_TRACK_STATE_LOST.");
        } else if ((this.jdField_b_of_type_Adig != null) && (this.jdField_b_of_type_Adig.us.size() > 0)) {
          QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. mCurLocalFaceRecogResult.faceDatas.size() > 0.");
        } else if (aeU()) {
          QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. isModelRenderStarted().");
        }
      }
    }
    int i;
    boolean bool;
    Object localObject;
    if ((this.jdField_b_of_type_Adhr == null) && (this.jdField_b_of_type_Adin != null))
    {
      QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. deal mCurMIGObjectClassifyResult sucess");
      i = 0;
      if ((paramInt != 0) || (paramadhr == null)) {
        break label1070;
      }
      if ((!adhh.a(paramadhr.jdField_a_of_type_Adhh)) && (!adhk.a(paramadhr.jdField_a_of_type_Adhk)) && (!adin.a(paramadhr.jdField_a_of_type_Adin)) && (!adht.a(paramadhr.jdField_a_of_type_Adht)))
      {
        paramInt = i;
        if (!adhy.a(paramadhr.jdField_a_of_type_Adhy)) {}
      }
      else
      {
        paramInt = 1;
      }
      bool = adhl.a(paramadhr.jdField_a_of_type_Adhl);
      i = paramInt;
      if (bool)
      {
        i = paramInt;
        if (paramInt != 0)
        {
          i = paramInt;
          if (ARRecognition.a(paramadhr, this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 64L))
          {
            i = 0;
            QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard other recog result as OCR preRecog has high priority");
          }
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("onARCloudUploadImgComplete result:  marker{success: ").append(adhh.a(paramadhr.jdField_a_of_type_Adhh)).append(", priority: ").append(this.cIk).append("}");
        localStringBuilder1.append("  object{success: ").append(adhk.a(paramadhr.jdField_a_of_type_Adhk)).append(", priority: ").append(this.cIl).append("}");
        localStringBuilder1.append("  face{success: ").append(adht.a(paramadhr.jdField_a_of_type_Adht)).append(", priority: ").append(this.cIm).append("}");
        localStringBuilder1.append("  pre ocr{success: ").append(adhl.a(paramadhr.jdField_a_of_type_Adhl)).append(", priority: ").append(this.cIn).append("}");
        StringBuilder localStringBuilder2 = localStringBuilder1.append(" \n mig-object{success: ").append(adin.a(paramadhr.jdField_a_of_type_Adin)).append(", priority: ").append(this.cIo).append("}name:");
        if (paramadhr.jdField_a_of_type_Adin == null) {
          break label900;
        }
        localObject = paramadhr.jdField_a_of_type_Adin.toString();
        label666:
        localStringBuilder2.append((String)localObject);
        localStringBuilder1.append("  scene{success: ").append(adhy.a(paramadhr.jdField_a_of_type_Adhy)).append(", priority: ").append(this.cIp).append("}");
        QLog.i("AREngine_QQARSession", 2, localStringBuilder1.toString());
      }
    }
    for (;;)
    {
      if ((i != 0) && (!this.bOq))
      {
        QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete first recognize success.");
        this.bOq = true;
      }
      if ((bool) && (i == 0))
      {
        this.bOh = true;
        ac(new QQARSession.5(this));
      }
      for (;;)
      {
        if (i != 0) {
          break label939;
        }
        if (this.jdField_b_of_type_Adin != null)
        {
          Go(true);
          if ((this.mIsInited) && (this.cHX == 2) && (!this.bOj)) {
            cSr();
          }
        }
        if ((!ARRecognition.b(this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) && ((this.Ux & 1L) != 0L))
        {
          cSk();
          iN(1L);
        }
        if (this.jdField_a_of_type_Adgy != null) {
          this.jdField_a_of_type_Adgy.Gd(true);
        }
        QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. cloud recog failed.");
        return;
        if ((this.jdField_b_of_type_Adhr == null) || (this.jdField_b_of_type_Adin == null)) {
          break;
        }
        QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. deal mCurMIGObjectClassifyResult error happen");
        break;
        label900:
        localObject = "";
        break label666;
        if ((!bool) && (this.bOh))
        {
          this.bOh = false;
          ac(new QQARSession.6(this));
        }
      }
      label939:
      if (i != 0)
      {
        localObject = adhr.a(this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, paramadhr);
        if ((adhr.a(this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, paramadhr)) && (((adhf)localObject).retCode != 1))
        {
          ac(new QQARSession.7(this, (adhf)localObject, adhr.a(this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, paramadhr)));
          if (this.jdField_a_of_type_Adgy != null) {
            this.jdField_a_of_type_Adgy.Gd(true);
          }
          QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. lbs location failed.");
          return;
        }
      }
      cSk();
      this.UA = 0L;
      this.UB = 0L;
      ac(new QQARSession.8(this, paramadhr));
      if (this.jdField_a_of_type_Adgy == null) {
        break;
      }
      this.jdField_a_of_type_Adgy.Gd(true);
      return;
      label1070:
      i = 0;
      bool = false;
    }
  }
  
  public void b(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if ((paramBoolean) && (paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.bOa) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.bNZ) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.but)) && (!paramArCloudConfigInfo.aek()))
    {
      this.jdField_a_of_type_Adib.ch(0, paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.but);
      this.h = paramArCloudConfigInfo;
      this.cIs = 2;
      return;
    }
    e(paramBoolean, paramArCloudConfigInfo);
  }
  
  public void b(float[] paramArrayOfFloat)
  {
    if (this.jdField_a_of_type_Adkx != null) {
      this.jdField_a_of_type_Adkx.a(0, paramArrayOfFloat);
    }
  }
  
  public void c(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if ((paramBoolean) && (paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.bOa) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.bNZ) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.but)) && (!paramArCloudConfigInfo.aek()))
    {
      this.jdField_a_of_type_Adib.ch(0, paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.but);
      this.h = paramArCloudConfigInfo;
      this.cIs = 2;
      return;
    }
    f(paramBoolean, paramArCloudConfigInfo);
  }
  
  public ArrayList<String> cL()
  {
    if (this.jdField_a_of_type_Adgy != null) {
      return this.jdField_a_of_type_Adgy.cL();
    }
    return null;
  }
  
  public void cQu()
  {
    QLog.i("AREngine_QQARSession", 1, "onRenderReadyStatus ready");
    ac(new QQARSession.20(this));
  }
  
  public void cRM()
  {
    if (this.UM == 0L) {
      this.UM = System.currentTimeMillis();
    }
  }
  
  public void cRN()
  {
    QLog.i("AREngine_QQARSession", 1, "onARCloudUploadStart.");
    this.cIt += 1;
  }
  
  public void cRY()
  {
    QLog.i("AREngine_QQARSession", 1, "onARMarkerAllDownloadStart.");
    this.UK = System.currentTimeMillis();
    if ((this.mIsInited) && (this.cHX == 2) && (this.jdField_a_of_type_Adib != null)) {
      this.jdField_a_of_type_Adib.hq(0, 4);
    }
  }
  
  public void cRZ()
  {
    QLog.i("AREngine_QQARSession", 1, "onARObjectClassifyDownloadStart.");
    this.UK = System.currentTimeMillis();
    ac(new QQARSession.15(this));
  }
  
  public void cSa()
  {
    QLog.i("AREngine_QQARSession", 1, "onARSceneRecogDownloadStart.");
    this.UK = System.currentTimeMillis();
    ac(new QQARSession.17(this));
  }
  
  public void cSm()
  {
    QLog.d("AREngine_QQARSession", 1, "stopModelRender.");
    if ((this.jdField_a_of_type_Adkx != null) && (this.jdField_e_of_type_ComTencentMobileqqArAidlArCloudConfigInfo != null))
    {
      this.jdField_a_of_type_Adkx.cSm();
      if (adkt.a().aeN()) {
        adkt.a().ho(this.cns, this.cnu);
      }
      if ((this.mIsInited) && (this.jdField_a_of_type_Adib != null) && ((this.cHX == 2) || (this.cHX == 4)))
      {
        adec localadec = new adec(this.jdField_e_of_type_ComTencentMobileqqArAidlArCloudConfigInfo);
        this.jdField_a_of_type_Adib.a(this.Uz, false, localadec);
      }
    }
    this.Uz = 0L;
    this.jdField_e_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
    this.f = null;
  }
  
  public void cSn()
  {
    QLog.d("AREngine_QQARSession", 1, "stopModelRenderOnly.");
    if ((this.mIsInited) && (this.cHX == 2) && (this.jdField_a_of_type_Adkx != null)) {
      this.jdField_a_of_type_Adkx.cSm();
    }
  }
  
  public void cSq()
  {
    QLog.i("AREngine_QQARSession", 1, "onProcessCloudObjectClassifyResultComplete.");
    if (!ARRecognition.b(this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) {}
    for (;;)
    {
      cSu();
      return;
      iN(1L);
    }
  }
  
  public void cSr()
  {
    QLog.i("AREngine_QQARSession", 1, "onProcessMigCloudObjectClassifyResultComplete.");
    if (!ARRecognition.b(this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) {}
    for (;;)
    {
      this.jdField_b_of_type_Adin = null;
      cSu();
      return;
      iN(1L);
      this.bOi = false;
    }
  }
  
  public void cSt()
  {
    QLog.i("AREngine_QQARSession", 1, "onProcessCloudSceneRecogResultComplete.");
    if (!ARRecognition.b(this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) {}
    for (;;)
    {
      cSu();
      return;
      iN(1L);
    }
  }
  
  public void cSv()
  {
    QLog.d("AREngine_QQARSession", 1, "engine notifyRenderReady ");
    if (this.h == null) {}
    do
    {
      do
      {
        return;
      } while ((this.h.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo == null) || (!this.h.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.bOa) || (!this.h.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.bNZ) || (TextUtils.isEmpty(this.h.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.but)));
      if (this.cIs == 1)
      {
        d(true, this.h);
        return;
      }
    } while (this.cIs != 2);
    e(true, this.h);
  }
  
  public void cSy()
  {
    QLog.d("AREngine_QQARSession", 1, String.format("CloseAREngineRecoglizeFunction  ", new Object[0]));
    ac(new QQARSession.27(this));
  }
  
  public void d(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    long l2 = System.currentTimeMillis() - this.UK;
    if (l2 >= 1000L) {}
    for (long l1 = 0L;; l1 = 1000L - l2)
    {
      QLog.i("AREngine_QQARSession", 1, String.format("onARMarkerAllDownloadCompleteInternal result=%s timeCost=%s timeDelay=%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(l2), Long.valueOf(l1) }));
      h(new QQARSession.14(this, paramBoolean, paramArCloudConfigInfo), l1);
      return;
    }
  }
  
  public void eb(String paramString, int paramInt)
  {
    QLog.i("AREngine_QQARSession", 1, "onRenderManagerCallback. onARAnimationStart. key = " + paramString + ", remainPlayCount = " + paramInt);
    ac(new QQARSession.21(this, paramInt));
  }
  
  public void ec(String paramString, int paramInt)
  {
    QLog.i("AREngine_QQARSession", 1, "onRenderManagerCallback. onARAnimationComplete. key = " + paramString + ", remainPlayCount = " + paramInt);
    ac(new QQARSession.22(this, paramInt));
  }
  
  public void ed(String paramString, int paramInt)
  {
    QLog.i("AREngine_QQARSession", 1, "onRenderManagerCallback. onARAnimationPlayInterrupt. key = " + paramString + ", remainPlayCount = " + paramInt);
    ac(new QQARSession.23(this, paramInt));
  }
  
  public void ee(String paramString, int paramInt)
  {
    QLog.i("AREngine_QQARSession", 1, "onRenderManagerCallback. onARAnimationPlayError. key = " + paramString + ", remainPlayCount = " + paramInt);
    ac(new QQARSession.24(this, paramInt));
  }
  
  public long fo()
  {
    return this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.mARCloudUploadDelayTime;
  }
  
  public long fp()
  {
    if ((this.mContext instanceof ScanTorchActivity)) {
      return ((ScanTorchActivity)this.mContext).fp();
    }
    return 0L;
  }
  
  public void g(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong) {}
  
  public void g(Runnable paramRunnable, long paramLong)
  {
    if ((this.bOb) && (this.cHX == 2)) {
      h(paramRunnable, paramLong);
    }
  }
  
  public void iM(long paramLong)
  {
    QLog.d("AREngine_QQARSession", 1, "pauseLocalRecog. recogType = " + paramLong);
    if (this.jdField_a_of_type_Adid != null) {
      this.jdField_a_of_type_Adid.iG(paramLong);
    }
  }
  
  public void iN(long paramLong)
  {
    QLog.d("AREngine_QQARSession", 1, "resumeLocalRecog. recogType = " + paramLong);
    if (this.jdField_a_of_type_Adid != null)
    {
      if ((1L & paramLong) != 0L)
      {
        this.jdField_b_of_type_Adik = null;
        this.jdField_c_of_type_Adik = null;
        this.UA = 0L;
        this.UB = 0L;
        this.UC = 0L;
        this.UD = 0L;
      }
      if ((0x4 & paramLong) != 0L)
      {
        this.jdField_b_of_type_Adig = null;
        this.jdField_c_of_type_Adig = null;
        this.UE = 0L;
        this.UF = 0L;
      }
      this.jdField_a_of_type_Adid.iH(paramLong);
    }
  }
  
  public boolean isInited()
  {
    return this.mIsInited;
  }
  
  public boolean l(byte[] paramArrayOfByte)
  {
    if (this.cHX == 2)
    {
      onPreviewFrame(paramArrayOfByte, null);
      return true;
    }
    return false;
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if ((this.mIsInited) && (this.jdField_a_of_type_Adkx != null))
    {
      if ((!this.bOb) || (this.cHX != 2)) {
        break label371;
      }
      this.jdField_a_of_type_Adkx.iP(this.jdField_a_of_type_Adkx.fq() + 1L);
      if ((this.jdField_a_of_type_Adid == null) || ((this.jdField_a_of_type_Adid.bR(1L)) && (this.jdField_a_of_type_Adid.bR(4L)) && (this.jdField_a_of_type_Adid.bR(4096L))) || (aeW())) {
        break label334;
      }
      if ((this.cIu == 0) || ((this.cIu == 1) && (this.jdField_b_of_type_Adbn.Bu() == 0) && (this.jdField_b_of_type_Adbn.adq()))) {
        this.jdField_a_of_type_Adid.k(this.jdField_a_of_type_Adkx.fq(), paramArrayOfByte);
      }
      if (!this.bOs) {
        break label209;
      }
      this.jdField_a_of_type_Adkx.iQ(this.jdField_a_of_type_Adkx.fq());
      if (this.jdField_a_of_type_Adkx != null) {
        this.jdField_a_of_type_Adkx.requestRender();
      }
    }
    label209:
    label371:
    do
    {
      for (;;)
      {
        if (this.jdField_a_of_type_Adgy != null) {
          this.jdField_a_of_type_Adgy.aW(paramArrayOfByte);
        }
        return;
        if (((!this.jdField_a_of_type_Adid.bR(1L)) && (this.jdField_b_of_type_Adik != null) && (this.jdField_b_of_type_Adik.state == 2)) || ((!this.jdField_a_of_type_Adid.bR(4L)) && (this.jdField_b_of_type_Adig != null) && (this.jdField_b_of_type_Adig.us.size() == 0)) || ((!this.jdField_a_of_type_Adid.bR(4L)) && (this.jdField_a_of_type_Adid.bS(4L))))
        {
          this.jdField_a_of_type_Adkx.iQ(this.jdField_a_of_type_Adkx.fq());
          if (this.jdField_a_of_type_Adkx != null)
          {
            this.jdField_a_of_type_Adkx.requestRender();
            continue;
            this.jdField_a_of_type_Adkx.iQ(this.jdField_a_of_type_Adkx.fq());
            if (this.jdField_a_of_type_Adkx != null) {
              this.jdField_a_of_type_Adkx.requestRender();
            }
          }
        }
      }
      this.jdField_a_of_type_Adkx.iP(this.jdField_a_of_type_Adkx.fq() + 1L);
      this.jdField_a_of_type_Adkx.iQ(this.jdField_a_of_type_Adkx.fq());
    } while (this.jdField_a_of_type_Adkx == null);
    label334:
    this.jdField_a_of_type_Adkx.requestRender();
  }
  
  public void pause()
  {
    QLog.i("AREngine_QQARSession", 1, "ARengine status  pause. now ");
    if ((!this.mIsInited) || (this.cHX != 2)) {
      return;
    }
    cSw();
    cSm();
    cSk();
    if ((this.jdField_a_of_type_Adid != null) && (!this.jdField_a_of_type_Adid.bR(4L))) {}
    for (boolean bool = true;; bool = false)
    {
      iM(5L);
      if ((bool) && (this.jdField_a_of_type_Adib != null)) {
        this.jdField_a_of_type_Adib.Gi(bool);
      }
      this.bOj = true;
      if (this.jdField_b_of_type_Adin != null) {
        Go(true);
      }
      this.bOm = false;
      cSx();
      if ((this.jdField_a_of_type_Adid != null) && (this.cIu == 1))
      {
        iM(4096L);
        this.jdField_a_of_type_Adid.b(false, this.mImageWidth, this.mImageHeight);
      }
      if (this.jdField_a_of_type_Adio != null) {
        this.jdField_a_of_type_Adio.cRV();
      }
      this.mIsResume = false;
      this.cHX = 3;
      this.jdField_a_of_type_Adkx.a(null);
      return;
    }
  }
  
  public void resume()
  {
    QLog.d("AREngine_QQARSession", 1, "ARengine status resume now start. + mCurrentSessionStatus:=" + this.cHX);
    if ((!this.mIsInited) || (this.cHX == 0) || (this.cHX == 4) || (this.cHX == 5) || (this.cHX == 2)) {
      return;
    }
    this.jdField_a_of_type_Adkx.a(this);
    bb(this.bOk);
    this.jdField_b_of_type_Adik = null;
    this.jdField_c_of_type_Adik = null;
    this.jdField_b_of_type_Adig = null;
    this.jdField_c_of_type_Adig = null;
    this.jdField_b_of_type_Adhr = null;
    this.bOg = false;
    this.bOj = false;
    this.jdField_b_of_type_Adin = null;
    this.bOi = false;
    this.Uz = 0L;
    this.jdField_e_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
    this.f = null;
    this.UA = 0L;
    this.UB = 0L;
    this.UC = 0L;
    this.UD = 0L;
    this.bOk = false;
    this.bOt = false;
    this.UE = 0L;
    this.UF = 0L;
    if ((this.bOs) || (this.cIu == 1))
    {
      iN(4096L);
      this.jdField_a_of_type_Adid.b(true, this.mImageWidth, this.mImageHeight);
      this.mIsResume = true;
      this.cHX = 2;
      return;
    }
    cSl();
    if (!ARRecognition.b(this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) {
      iM(5L);
    }
    for (;;)
    {
      this.mIsResume = true;
      this.cHX = 2;
      QLog.d("AREngine_QQARSession", 1, "ARengine status resume now end.");
      return;
      iM(4L);
      iN(1L);
    }
  }
  
  public int start()
  {
    ac(new QQARSession.1(this));
    return 0;
  }
  
  public void stop()
  {
    QLog.i("AREngine_QQARSession", 1, "stop start. mCurEngineState = " + this.cHX);
    if (this.cHX == 5) {
      return;
    }
    this.cHX = 4;
    this.bOt = false;
    if (this.fX != null)
    {
      removeTask(this.fX);
      this.fX = null;
    }
    uo();
    ac(new QQARSession.3(this));
  }
  
  public void uninit()
  {
    QLog.i("AREngine_QQARSession", 1, "uninit start. mIsInited = " + this.mIsInited);
    if (!this.mIsInited) {
      return;
    }
    adkt.a().c(this);
    ac(new QQARSession.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adku
 * JD-Core Version:    0.7.0.1
 */