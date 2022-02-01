import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.YTFace.cluster.FaceCluster;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceActInfo;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARFacePreviewResample;
import com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.3;
import com.tencent.mobileqq.armap.ARMapTracer;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class adie
{
  public static boolean bNm = true;
  public static Handler handler;
  HandlerThread I;
  long Ti;
  long Tj;
  public long Tk = -1L;
  adie.a jdField_a_of_type_Adie$a;
  ARScanStarFaceConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo;
  private ARFacePreviewResample jdField_a_of_type_ComTencentMobileqqArArengineARFacePreviewResample;
  public adht b;
  Handler.Callback b;
  public FaceCluster b;
  public volatile boolean bNn;
  public volatile boolean bNo = false;
  public int bpO = 90;
  Handler cF;
  int cGn;
  final int cGo = 10;
  public int cGp = 10;
  public Object cY = new Object();
  public Context context;
  HandlerThread handlerThread;
  volatile boolean isTracking = false;
  public volatile boolean mIsPause;
  volatile boolean mIsStarted;
  public int previewHeight;
  public int previewWidth;
  public List<adie.b> yk = new ArrayList();
  public List<adie.b> yl = new ArrayList();
  
  public adie()
  {
    this.jdField_b_of_type_AndroidOsHandler$Callback = new adif(this);
    if (anii.isFoundProduct(anii.KEY_PREVIEW_ORIENTATION_270_OF_BACK_MODEL)) {
      this.bpO = 270;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARLocalFaceRecog", 2, "ARLocalFaceRecog  rotateDegree = " + this.bpO);
    }
  }
  
  public static boolean qR()
  {
    boolean bool = false;
    if (Build.MODEL.equals("vivo X6Plus A")) {
      bool = true;
    }
    if (ARMapTracer.BU() == 3) {
      return true;
    }
    return bool;
  }
  
  public int a(float[][] paramArrayOfFloat, float[] paramArrayOfFloat1)
  {
    int k = paramArrayOfFloat.length;
    float[] arrayOfFloat = new float[k];
    int i = 0;
    if (i < k)
    {
      if (paramArrayOfFloat[i] != null) {
        arrayOfFloat[i] = this.jdField_b_of_type_ComTencentYTFaceClusterFaceCluster.calcuSimilarity(paramArrayOfFloat[i], paramArrayOfFloat1);
      }
      for (;;)
      {
        i += 1;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "findFaceIndexByFaceFeature2 faceFeature is null,i = " + i);
        }
      }
    }
    float f1 = arrayOfFloat[0];
    i = 0;
    int j = -1;
    while (i < k)
    {
      float f2 = f1;
      if (arrayOfFloat[i] >= f1)
      {
        f2 = arrayOfFloat[i];
        j = i;
      }
      i += 1;
      f1 = f2;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("AREngine_ARLocalFaceRecog", 2, "findFaceIndexByFaceFeature targetFaceFeature = " + Arrays.toString(paramArrayOfFloat1));
      QLog.d("AREngine_ARLocalFaceRecog", 2, "findFaceIndexByFaceFeature newFaceFeature = " + Arrays.toString(paramArrayOfFloat[0]));
    }
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARLocalFaceRecog", 2, "findFaceIndexByFaceFeature2 index = " + j + ",finalSimilarity = " + f1);
    }
    if ((!Float.isNaN(f1)) || (f1 < 0.5D)) {
      j = -1;
    }
    return j;
  }
  
  ARScanStarFaceActInfo a(String paramString)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = localObject3;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject2 = localObject3;
      if (this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo != null)
      {
        localObject2 = localObject3;
        if (this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo.a != null)
        {
          localObject2 = localObject3;
          if (this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo.a.length > 0)
          {
            int j = this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo.a.length;
            i = 0;
            localObject2 = localObject1;
            if (i < j)
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo.a[i];
              if ((localObject2 == null) || (!paramString.equals(((ARScanStarFaceActInfo)localObject2).bsI))) {
                break label119;
              }
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    label119:
    for (;;)
    {
      i += 1;
      break;
      return localObject2;
    }
  }
  
  public void a(ARFacePreviewResample paramARFacePreviewResample)
  {
    this.jdField_a_of_type_ComTencentMobileqqArArengineARFacePreviewResample = paramARFacePreviewResample;
  }
  
  public void a(List<adie.b> paramList, adht paramadht)
  {
    Object localObject2 = null;
    int i = 0;
    int n = 0;
    int j = 0;
    if (paramadht.b.length > 2) {
      if (paramadht.ur == null) {
        break label1383;
      }
    }
    label305:
    label1380:
    label1383:
    for (int k = paramadht.ur.size();; k = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "filterCloudFaceResult starCount = " + k);
      }
      Object localObject3;
      Object localObject1;
      int m;
      if (k > 0)
      {
        if (k == 1)
        {
          localObject3 = new adie.b();
          n = ((adht.a)paramadht.ur.get(0)).faceID;
          ((adie.b)localObject3).bNp = true;
          ((adie.b)localObject3).faceID = 0;
          ((adie.b)localObject3).d = paramadht.b[n];
          i = 0;
          while (i < k)
          {
            localObject1 = (adht.a)paramadht.ur.get(i);
            if (((adht.a)localObject1).faceID == n)
            {
              ((adie.b)localObject3).faceType = 2;
              ((adie.b)localObject3).name = ((adht.a)localObject1).name;
              ((adie.b)localObject3).bsV = ((adht.a)localObject1).bsV;
              ((adie.b)localObject3).uin = String.valueOf(((adht.a)localObject1).uin);
              ((adie.b)localObject3).bsW = ((adht.a)localObject1).bsW;
              ((adie.b)localObject3).bsX = ((adht.a)localObject1).bsX;
              ((adie.b)localObject3).bsY = ((adht.a)localObject1).bsY;
              ((adie.b)localObject3).confidence = ((adht.a)localObject1).confidence;
            }
            i += 1;
          }
          m = 0;
          i = j;
          if (i < paramadht.b.length)
          {
            j = m;
            localObject1 = localObject2;
            if (i != n)
            {
              if (localObject2 != null) {
                break label305;
              }
              localObject1 = paramadht.b[i];
              j = i;
            }
            for (;;)
            {
              i += 1;
              m = j;
              localObject2 = localObject1;
              break;
              j = m;
              localObject1 = localObject2;
              if (paramadht.b[i].width * paramadht.b[i].height > ((FaceStatus)localObject2).width * ((FaceStatus)localObject2).height)
              {
                localObject1 = paramadht.b[i];
                j = i;
              }
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "filterCloudFaceResult starCount = " + k + ",bigFaceID = " + m);
          }
          paramadht = new adie.b();
          paramadht.faceType = 1;
          paramadht.name = "";
          paramadht.bNp = true;
          paramadht.d = ((FaceStatus)localObject2);
          paramadht.faceID = 1;
          paramList.add(localObject3);
          paramList.add(paramadht);
          return;
        }
        if (k == 2)
        {
          localObject1 = new adie.b();
          ((adie.b)localObject1).bNp = true;
          ((adie.b)localObject1).faceID = 0;
          ((adie.b)localObject1).d = paramadht.b[0];
          localObject2 = new adie.b();
          ((adie.b)localObject2).bNp = true;
          ((adie.b)localObject2).faceID = 1;
          ((adie.b)localObject2).d = paramadht.b[1];
          while (i < k)
          {
            localObject3 = (adht.a)paramadht.ur.get(i);
            if (((adht.a)localObject3).faceID == 0)
            {
              ((adie.b)localObject1).faceType = 2;
              ((adie.b)localObject1).name = ((adht.a)localObject3).name;
              ((adie.b)localObject1).bsV = ((adht.a)localObject3).bsV;
              ((adie.b)localObject1).uin = String.valueOf(((adht.a)localObject3).uin);
              ((adie.b)localObject1).bsW = ((adht.a)localObject3).bsW;
              ((adie.b)localObject1).bsX = ((adht.a)localObject3).bsX;
              ((adie.b)localObject1).bsY = ((adht.a)localObject3).bsY;
              ((adie.b)localObject1).confidence = ((adht.a)localObject3).confidence;
            }
            if (((adht.a)localObject3).faceID == 1)
            {
              ((adie.b)localObject2).faceType = 2;
              ((adie.b)localObject2).name = ((adht.a)localObject3).name;
              ((adie.b)localObject2).bsV = ((adht.a)localObject3).bsV;
              ((adie.b)localObject2).uin = String.valueOf(((adht.a)localObject3).uin);
              ((adie.b)localObject2).bsW = ((adht.a)localObject3).bsW;
              ((adie.b)localObject2).bsX = ((adht.a)localObject3).bsX;
              ((adie.b)localObject2).bsY = ((adht.a)localObject3).bsY;
              ((adie.b)localObject2).confidence = ((adht.a)localObject3).confidence;
            }
            i += 1;
          }
          paramList.add(localObject1);
          paramList.add(localObject2);
          return;
        }
        localObject2 = paramadht.b[0];
        m = 0;
        i = 0;
        while (i < paramadht.b.length)
        {
          localObject1 = localObject2;
          if (paramadht.b[i].width * paramadht.b[i].height > ((FaceStatus)localObject2).width * ((FaceStatus)localObject2).height)
          {
            localObject1 = paramadht.b[i];
            m = i;
          }
          i += 1;
          localObject2 = localObject1;
        }
        j = -2;
        localObject1 = null;
        i = 0;
        if (i < paramadht.b.length)
        {
          if (i == m) {
            break label1380;
          }
          if (localObject1 == null)
          {
            localObject1 = paramadht.b[i];
            j = i;
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramadht.b[i].width * paramadht.b[i].height > ((FaceStatus)localObject1).width * ((FaceStatus)localObject1).height)
        {
          localObject1 = paramadht.b[i];
          j = i;
          continue;
          localObject3 = new adie.b();
          ((adie.b)localObject3).bNp = true;
          ((adie.b)localObject3).faceID = 0;
          ((adie.b)localObject3).d = ((FaceStatus)localObject2);
          localObject2 = new adie.b();
          ((adie.b)localObject2).bNp = true;
          ((adie.b)localObject2).faceID = 1;
          ((adie.b)localObject2).d = ((FaceStatus)localObject1);
          i = n;
          while (i < k)
          {
            localObject1 = (adht.a)paramadht.ur.get(i);
            if (((adht.a)localObject1).faceID == m)
            {
              ((adie.b)localObject3).faceType = 2;
              ((adie.b)localObject3).name = ((adht.a)localObject1).name;
              ((adie.b)localObject3).bsV = ((adht.a)localObject1).bsV;
              ((adie.b)localObject3).uin = String.valueOf(((adht.a)localObject1).uin);
              ((adie.b)localObject3).bsW = ((adht.a)localObject1).bsW;
              ((adie.b)localObject3).bsX = ((adht.a)localObject1).bsX;
              ((adie.b)localObject3).bsY = ((adht.a)localObject1).bsY;
              ((adie.b)localObject3).confidence = ((adht.a)localObject1).confidence;
            }
            if (((adht.a)localObject1).faceID == j)
            {
              ((adie.b)localObject2).faceType = 2;
              ((adie.b)localObject2).name = ((adht.a)localObject1).name;
              ((adie.b)localObject2).bsV = ((adht.a)localObject1).bsV;
              ((adie.b)localObject2).uin = String.valueOf(((adht.a)localObject1).uin);
              ((adie.b)localObject2).bsW = ((adht.a)localObject1).bsW;
              ((adie.b)localObject2).bsX = ((adht.a)localObject1).bsX;
              ((adie.b)localObject2).bsY = ((adht.a)localObject1).bsY;
              ((adie.b)localObject2).confidence = ((adht.a)localObject1).confidence;
            }
            i += 1;
          }
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "filterCloudFaceResult starCount = " + k + ",bigFaceID = " + m + ",secondBigFaceID = " + j);
          }
          paramList.add(localObject3);
          paramList.add(localObject2);
          return;
          paramadht = a(paramadht.b);
          localObject1 = new adie.b();
          ((adie.b)localObject1).faceType = 1;
          ((adie.b)localObject1).name = "";
          ((adie.b)localObject1).bNp = true;
          ((adie.b)localObject1).faceID = 0;
          if (paramadht != null) {
            ((adie.b)localObject1).d = paramadht[0];
          }
          localObject2 = new adie.b();
          ((adie.b)localObject2).faceType = 1;
          ((adie.b)localObject2).name = "";
          ((adie.b)localObject2).bNp = true;
          ((adie.b)localObject2).faceID = 1;
          if (paramadht != null) {
            ((adie.b)localObject2).d = paramadht[1];
          }
          paramList.add(localObject1);
          paramList.add(localObject2);
          return;
        }
      }
    }
  }
  
  void a(FaceStatus[] paramArrayOfFaceStatus1, FaceStatus[] paramArrayOfFaceStatus2)
  {
    if (paramArrayOfFaceStatus2 == null) {
      return;
    }
    int k = paramArrayOfFaceStatus2.length;
    int i = 0;
    label11:
    FaceStatus localFaceStatus;
    if (i < k)
    {
      localFaceStatus = paramArrayOfFaceStatus2[i];
      if (paramArrayOfFaceStatus1 == null) {
        break label125;
      }
      int m = paramArrayOfFaceStatus1.length;
      j = 0;
      label33:
      if (j >= m) {
        break label125;
      }
      if (localFaceStatus != paramArrayOfFaceStatus1[j]) {
        break label116;
      }
    }
    label116:
    label125:
    for (int j = 1;; j = 0)
    {
      if ((j == 0) && (localFaceStatus.nativeFaceAlignmentPtr != 0L))
      {
        FaceCluster.getInstance().releaseNativeFaceStatus(localFaceStatus);
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "releaseLocalFilteredFaceStatus,faceStatusInCloudResult = " + localFaceStatus);
        }
      }
      i += 1;
      break label11;
      break;
      j += 1;
      break label33;
    }
  }
  
  public boolean a(adie.b paramb, float[][] paramArrayOfFloat1, float[][] paramArrayOfFloat2)
  {
    boolean bool = true;
    if (!paramb.bNp)
    {
      long l1 = SystemClock.uptimeMillis();
      int i = a(paramArrayOfFloat1, paramb.d.feature);
      long l2 = SystemClock.uptimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "recoverSingleFace findFaceIndexByFaceFeature[TimeCost] = " + (l2 - l1));
      }
      if ((i >= 0) && (i < paramArrayOfFloat1.length))
      {
        paramb.d.xys = paramArrayOfFloat2[i];
        paramb.bNp = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "recoverSingleFace  result = " + bool + ",faceInfo = " + paramb);
      }
      return bool;
      bool = false;
    }
  }
  
  public boolean a(Context paramContext, int paramInt1, int paramInt2, ARScanStarFaceConfigInfo paramARScanStarFaceConfigInfo, adie.a parama)
  {
    long l = System.currentTimeMillis();
    if (FaceCluster.useAssetSo) {}
    label222:
    for (;;)
    {
      this.context = paramContext;
      this.previewWidth = paramInt1;
      this.previewHeight = paramInt2;
      this.jdField_a_of_type_Adie$a = parama;
      l = System.currentTimeMillis() - l;
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face] [ScanStarFace]init result = " + true + ",previewWidth = " + paramInt1 + ",previewHeight = " + paramInt2 + ",useAssetSo = " + FaceCluster.useAssetSo + ",localFaceRecogerInitCost = " + l);
      }
      adix.a().av(l, true);
      adic.iD(l);
      this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo = paramARScanStarFaceConfigInfo;
      this.mIsStarted = false;
      this.mIsPause = false;
      return true;
      boolean bool = adfa.aeb();
      if (bool)
      {
        adfb.be(paramContext);
        this.jdField_b_of_type_ComTencentYTFaceClusterFaceCluster = FaceCluster.getInstance();
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label222;
        }
        QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace]init ,isResourceReady = " + bool + ",FaceScanModelsLoader.hasFaceModelInit = " + adfb.bMx);
        break;
        adfb.bMx = false;
      }
    }
  }
  
  boolean a(List<adie.b> paramList, FaceStatus paramFaceStatus)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramList != null)
    {
      bool1 = bool2;
      if (paramList.size() > 0)
      {
        paramList = paramList.iterator();
        bool1 = false;
        if (paramList.hasNext())
        {
          adie.b localb = (adie.b)paramList.next();
          if (!localb.bNp) {
            break label313;
          }
          int i = Math.abs(localb.d.x + localb.d.width / 2 - (paramFaceStatus.x + paramFaceStatus.width / 2));
          int j = Math.abs(localb.d.y + localb.d.height / 2 - (paramFaceStatus.y + paramFaceStatus.height / 2));
          int k = Math.min(localb.d.width / 2, paramFaceStatus.width / 2);
          int m = Math.min(localb.d.height / 2, paramFaceStatus.height / 2);
          if ((i < k) && (j < m))
          {
            bool1 = true;
            label191:
            bool2 = bool1;
            if (QLog.isColorLevel()) {
              QLog.d("AREngine_ARLocalFaceRecog", 2, " shouldFilterTmpFace,distanceX = " + i + ",distanceY = " + j + ",w = " + k + ",h = " + m);
            }
          }
        }
      }
    }
    label313:
    for (bool2 = bool1;; bool2 = bool1)
    {
      bool1 = bool2;
      break;
      bool1 = false;
      break label191;
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, " shouldFilterTmpFace,result = " + bool1);
      }
      return bool1;
    }
  }
  
  FaceStatus[] a(FaceStatus[] paramArrayOfFaceStatus)
  {
    int j = 0;
    if ((paramArrayOfFaceStatus != null) && (paramArrayOfFaceStatus.length > 0))
    {
      FaceStatus[] arrayOfFaceStatus = paramArrayOfFaceStatus;
      if (paramArrayOfFaceStatus.length > 2)
      {
        arrayOfFaceStatus = new FaceStatus[2];
        arrayOfFaceStatus[0] = paramArrayOfFaceStatus[0];
        int i = 0;
        int k = 0;
        while (i < paramArrayOfFaceStatus.length)
        {
          if (paramArrayOfFaceStatus[i].width * paramArrayOfFaceStatus[i].height > arrayOfFaceStatus[0].width * arrayOfFaceStatus[0].height)
          {
            arrayOfFaceStatus[0] = paramArrayOfFaceStatus[i];
            k = i;
          }
          i += 1;
        }
        int m = -2;
        i = j;
        if (i < paramArrayOfFaceStatus.length)
        {
          j = m;
          if (i != k)
          {
            if (arrayOfFaceStatus[1] != null) {
              break label139;
            }
            arrayOfFaceStatus[1] = paramArrayOfFaceStatus[i];
            j = i;
          }
          for (;;)
          {
            i += 1;
            m = j;
            break;
            label139:
            j = m;
            if (paramArrayOfFaceStatus[i].width * paramArrayOfFaceStatus[i].height > arrayOfFaceStatus[1].width * arrayOfFaceStatus[1].height)
            {
              arrayOfFaceStatus[1] = paramArrayOfFaceStatus[i];
              j = i;
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "filterLocalDetectFace  bigFaceID = " + k + ",secondBigFaceID = " + m + ",faceCount = " + paramArrayOfFaceStatus.length);
        }
      }
      return arrayOfFaceStatus;
    }
    return null;
  }
  
  public boolean aew()
  {
    return this.bNn;
  }
  
  public boolean an(List<adie.b> paramList)
  {
    paramList = paramList.iterator();
    boolean bool = true;
    if (paramList.hasNext())
    {
      adie.b localb = (adie.b)paramList.next();
      if ((bool) && (localb.bNp)) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    return bool;
  }
  
  public void b(List<adie.b> paramList, adht paramadht)
  {
    paramadht = paramadht.b;
    int k = paramadht.length;
    int i = 0;
    FaceStatus localFaceStatus;
    if (i < k)
    {
      localFaceStatus = paramadht[i];
      Iterator localIterator = paramList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((adie.b)localIterator.next()).d != localFaceStatus);
    }
    for (int j = 1;; j = 0)
    {
      if ((j == 0) && (localFaceStatus.nativeFaceAlignmentPtr != 0L))
      {
        FaceCluster.getInstance().releaseNativeFaceStatus(localFaceStatus);
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "checkAndReleaseFilteredFaceStatus,faceStatusInCloudResult = " + localFaceStatus);
        }
      }
      i += 1;
      break;
      return;
    }
  }
  
  public boolean b(adht paramadht)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face][ScanStarFace]addFaceCloudRecogResult start,faceResult = " + paramadht);
    }
    this.bNn = true;
    long l = System.currentTimeMillis();
    handler.post(new ARLocalFaceRecog.3(this, paramadht, l));
    return true;
  }
  
  public void cRS()
  {
    boolean bool = adfa.aeb();
    if (bool)
    {
      adfb.be(this.context);
      this.jdField_b_of_type_ComTencentYTFaceClusterFaceCluster = FaceCluster.getInstance();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace]notifyResourceDownloadFinish ,isResourceReady = " + bool + ",FaceScanModelsLoader.hasFaceModelInit = " + adfb.bMx);
      }
      return;
      adfb.bMx = false;
    }
  }
  
  public boolean isPause()
  {
    return this.mIsPause;
  }
  
  public void jz(List<adie.b> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        adie.b localb = (adie.b)localIterator.next();
        if ((localb.d != null) && (localb.d.nativeFaceAlignmentPtr != 0L)) {
          FaceCluster.getInstance().releaseNativeFaceStatus(localb.d);
        }
      }
      paramList.clear();
    }
  }
  
  public void k(long paramLong, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (!this.mIsStarted) || (this.mIsPause) || (!adfb.bMx)) {}
    do
    {
      for (;;)
      {
        return;
        synchronized (this.cY)
        {
          int i = this.yk.size();
          if ((QLog.isColorLevel()) && (bNm)) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "onPreviewFrame totalFaceSize = " + i);
          }
          if (i == 0)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("AREngine_ARLocalFaceRecog", 2, "ARFaceTest onPreviewFrame totalFaceSize is 0,frameIdx = " + paramLong + ",isPreparingData = " + this.bNn);
          }
        }
      }
      if ((QLog.isColorLevel()) && (bNm)) {
        QLog.d("AREngine_ARLocalFaceRecog", 2, " Try to track Face, isTracking = " + this.isTracking + ",frameIndex = " + paramLong);
      }
    } while (this.isTracking);
    if ((QLog.isColorLevel()) && (bNm)) {
      QLog.d("AREngine_ARLocalFaceRecog", 2, "ARFaceTest Send track Face msg frameIdx = " + paramLong);
    }
    if (handler.hasMessages(3)) {
      handler.removeMessages(3);
    }
    this.jdField_a_of_type_ComTencentMobileqqArArengineARFacePreviewResample.k(paramArrayOfByte);
    paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqArArengineARFacePreviewResample.V();
    this.Tj = paramLong;
    ??? = Message.obtain();
    ((Message)???).what = 3;
    ((Message)???).obj = paramArrayOfByte;
    handler.sendMessage((Message)???);
  }
  
  boolean kW(String paramString)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool3;
    if (!TextUtils.isEmpty(paramString))
    {
      bool2 = bool3;
      if (this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo != null)
      {
        bool2 = bool3;
        if (this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo.a != null)
        {
          bool2 = bool3;
          if (this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo.a.length > 0)
          {
            int j = this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo.a.length;
            int i = 0;
            for (;;)
            {
              bool2 = bool1;
              if (i >= j) {
                break;
              }
              ARScanStarFaceActInfo localARScanStarFaceActInfo = this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo.a[i];
              long l = NetConnInfoCenter.getServerTimeMillis();
              bool2 = bool1;
              if (localARScanStarFaceActInfo != null)
              {
                bool2 = bool1;
                if (paramString.equals(localARScanStarFaceActInfo.bsI))
                {
                  bool2 = bool1;
                  if (l > localARScanStarFaceActInfo.beginTime)
                  {
                    bool2 = bool1;
                    if (l < localARScanStarFaceActInfo.endTime) {
                      bool2 = true;
                    }
                  }
                }
              }
              i += 1;
              bool1 = bool2;
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace]hasStarActivity result = " + bool2 + "starUin = " + paramString);
    }
    return bool2;
  }
  
  public void pause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace] pause ,mIsPause = " + this.mIsPause);
    }
    if (this.mIsPause) {}
    for (;;)
    {
      return;
      this.mIsPause = true;
      synchronized (this.cY)
      {
        jz(this.yk);
        jz(this.yl);
        this.cGp = 10;
        handler.removeCallbacksAndMessages(null);
        this.cF.removeCallbacksAndMessages(null);
        if (this.Ti <= 0L) {
          continue;
        }
        adic.aE(System.currentTimeMillis() - this.Ti, this.cGn);
        this.Ti = 0L;
        this.cGn = 0;
        return;
      }
    }
  }
  
  public void resume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace] resume ,mIsPause = " + this.mIsPause);
    }
    if (!this.mIsPause) {
      return;
    }
    this.mIsPause = false;
    this.Ti = System.currentTimeMillis();
    this.cGn = 0;
  }
  
  public boolean start()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace] start ,mIsStarted = " + this.mIsStarted);
    }
    if (this.mIsStarted) {
      return true;
    }
    if (this.handlerThread == null)
    {
      this.handlerThread = new HandlerThread("ARLocalFaceRecog");
      this.handlerThread.start();
      handler = new Handler(this.handlerThread.getLooper(), this.jdField_b_of_type_AndroidOsHandler$Callback);
    }
    if (this.I == null)
    {
      this.I = new HandlerThread("ARLocalFaceRecog_exFeature");
      this.I.start();
      this.cF = new Handler(this.I.getLooper());
    }
    this.mIsStarted = true;
    this.mIsPause = false;
    return true;
  }
  
  public void stop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace] stop,mIsStarted = " + this.mIsStarted);
    }
    if (!this.mIsStarted) {
      return;
    }
    this.mIsStarted = false;
    synchronized (this.cY)
    {
      jz(this.yk);
      jz(this.yl);
      this.cGp = 10;
      handler.removeCallbacksAndMessages(null);
      this.cF.removeCallbacksAndMessages(null);
      this.handlerThread.quit();
      this.handlerThread = null;
      handler = null;
      this.I.quit();
      this.I = null;
      this.cF = null;
      return;
    }
  }
  
  public void uninit()
  {
    QLog.d("AREngine_ARLocalFaceRecog", 1, "[ScanStarFace] uninit");
    if (handler != null) {
      handler.removeCallbacksAndMessages(null);
    }
    adfb.cRb();
    QLog.d("AREngine_ARLocalFaceRecog", 1, "[ScanStarFace] uninit finish");
  }
  
  public static abstract interface a
  {
    public abstract void a(adig paramadig);
  }
  
  public static class b
  {
    public boolean bNp;
    public String bsV;
    public String bsW;
    public String bsX;
    public String bsY;
    public int cGr;
    public float confidence;
    public FaceStatus d;
    public int faceID;
    public int faceType;
    public String name;
    public String uin;
    
    public String toString()
    {
      return "FaceInfo{name='" + this.name + '\'' + ", tracked=" + this.bNp + ", lostCount=" + this.cGr + ", faceType=" + this.faceType + ", faceStatus=" + this.d + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adie
 * JD-Core Version:    0.7.0.1
 */