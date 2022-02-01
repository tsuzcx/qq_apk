import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.face.FaceDownloader;
import com.tencent.mobileqq.app.face.FaceDownloader.a;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.util.FaceDecodeTask;
import com.tencent.mobileqq.util.FaceDecodeTask.a;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Hashtable;
import java.util.LinkedList;

public class aqej
  extends aqdg
  implements FaceDownloader.a, FaceDecodeTask.a
{
  acpq jdField_a_of_type_Acpq;
  FaceDownloader jdField_a_of_type_ComTencentMobileqqAppFaceFaceDownloader;
  NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  
  public aqej(NearbyAppInterface paramNearbyAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDownloader = ((aqdm)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(216)).a();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDownloader.a(this);
  }
  
  public void F(AppInterface paramAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface != paramAppInterface)
    {
      destory();
      if ((paramAppInterface instanceof NearbyAppInterface)) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = ((NearbyAppInterface)paramAppInterface);
      }
    }
  }
  
  public Bitmap a(int paramInt1, String paramString, int paramInt2, byte paramByte)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null) {
      return null;
    }
    paramString = FaceInfo.a(paramInt1, paramString, paramInt2, paramByte);
    Bitmap localBitmap = ((aqdm)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(216)).O(paramString);
    ajrk.log(4, "Q.qqhead.NearbyFaceDecoder", "getBitmapFromcache", new Object[] { paramString, localBitmap });
    return localBitmap;
  }
  
  public void a(AppInterface paramAppInterface, FaceInfo paramFaceInfo)
  {
    if (paramFaceInfo == null) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null) || (paramFaceInfo == null));
      this.dYw -= 1;
      if ((paramFaceInfo.aRY == 32) && (paramFaceInfo.b == null) && ((FaceInfo)this.x.get(paramFaceInfo.BM()) != null)) {
        ((acpp)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getBusinessHandler(4)).c(paramFaceInfo);
      }
    } while ((this.mPause) || (this.am.isEmpty()) || (this.dYw >= this.dYv));
    cUQ();
  }
  
  public void a(FaceInfo paramFaceInfo, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "onDecodeTaskCompleted,avatar=" + paramBitmap + ",faceInfo=" + paramFaceInfo);
    }
    if ((paramFaceInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null)) {
      return;
    }
    this.dYw -= 1;
    if ((!this.am.isEmpty()) && (!this.mPause)) {
      cUQ();
    }
    Object localObject = (FaceInfo)this.x.remove(paramFaceInfo.BM());
    int i;
    if (localObject != null)
    {
      int j = FaceInfo.dYJ;
      if (paramBitmap == null) {
        break label319;
      }
      i = FaceInfo.dYy;
      label117:
      ((FaceInfo)localObject).kg(j, i);
      if ((this.cTG) && (paramBitmap != null)) {
        if ((paramBitmap == null) || (localObject.aK[FaceInfo.dYJ] <= 0L) || (localObject.aK[FaceInfo.dYB] <= 0L)) {
          break label368;
        }
      }
    }
    label319:
    label326:
    label368:
    for (long l = localObject.aK[FaceInfo.dYJ] - localObject.aK[FaceInfo.dYB];; l = 0L)
    {
      if (l > 0L)
      {
        i = aqiw.getSystemNetwork(BaseApplicationImpl.getApplication().getApplicationContext());
        if (i != 1) {
          break label326;
        }
        localObject = "actNearByFaceShowCostWIFI";
      }
      for (;;)
      {
        if (localObject != null) {
          anpc.a(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), (String)localObject, true, l, 0L, null, "");
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "onDecodeTaskCompleted.cost=" + l);
        }
        if ((this.jdField_a_of_type_Aqdg$a == null) || (paramBitmap == null)) {
          break;
        }
        this.jdField_a_of_type_Aqdg$a.onDecodeTaskCompleted(this.dYw + this.am.size(), paramFaceInfo.aRY, paramFaceInfo.uin, paramBitmap);
        return;
        i = FaceInfo.RESULT_FAIL;
        break label117;
        if (i == 2) {
          localObject = "actNearByFaceShowCost2G";
        } else if (i == 3) {
          localObject = "actNearByFaceShowCost3G";
        } else if (i == 4) {
          localObject = "actNearByFaceShowCost4G";
        } else {
          localObject = null;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, FaceInfo paramFaceInfo, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "onFaceDownloadFinished,isSuccess=" + paramBoolean + ",faceInfo=" + paramFaceInfo + ",bitmap=" + paramBitmap);
    }
    if ((paramFaceInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null)) {
      return;
    }
    Object localObject = (FaceInfo)this.x.remove(paramFaceInfo.BM());
    int i;
    if (localObject != null)
    {
      int j = FaceInfo.dYJ;
      if (paramBitmap == null) {
        break label304;
      }
      i = FaceInfo.dYy;
      label96:
      ((FaceInfo)localObject).kg(j, i);
      if ((this.cTG) && (paramBitmap != null)) {
        if ((localObject.aK[FaceInfo.dYJ] <= 0L) || (localObject.aK[FaceInfo.dYB] <= 0L)) {
          break label351;
        }
      }
    }
    label304:
    label312:
    label351:
    for (long l = localObject.aK[FaceInfo.dYJ] - localObject.aK[FaceInfo.dYB];; l = 0L)
    {
      if (l > 0L)
      {
        localObject = "";
        i = aqiw.getSystemNetwork(BaseApplicationImpl.getApplication().getApplicationContext());
        if (i != 1) {
          break label312;
        }
        localObject = "actNearByFaceShowCostWIFI";
      }
      for (;;)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          anpc.a(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), (String)localObject, true, l, 0L, null, "");
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "onFaceDownloadFinished.cost=" + l);
        }
        if ((this.jdField_a_of_type_Aqdg$a == null) || (paramBitmap == null)) {
          break;
        }
        this.jdField_a_of_type_Aqdg$a.onDecodeTaskCompleted(this.dYw + this.am.size(), paramFaceInfo.aRY, paramFaceInfo.uin, paramBitmap);
        return;
        i = FaceInfo.RESULT_FAIL;
        break label96;
        if (i == 2) {
          localObject = "actNearByFaceShowCost2G";
        } else if (i == 3) {
          localObject = "actNearByFaceShowCost3G";
        } else if (i == 4) {
          localObject = "actNearByFaceShowCost4G";
        }
      }
    }
  }
  
  public boolean a(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3, int paramInt4, boolean paramBoolean3)
  {
    if ((paramString == null) || (paramString.length() < 5))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "requestDecodeStrangeFace fail , uin = " + paramString);
      }
      return false;
    }
    String str = FaceInfo.e(paramInt2, paramString, paramInt1);
    FaceInfo localFaceInfo = (FaceInfo)this.x.get(str);
    if ((localFaceInfo != null) && (!localFaceInfo.s(FaceInfo.dYB, 300000L)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "requestDecodeStrangeFace, uin repeat. uin=" + paramString);
      }
      if ((localFaceInfo.cTI) && (!paramBoolean2)) {
        localFaceInfo.cTI = false;
      }
      return true;
    }
    paramString = new FaceInfo(paramInt2, paramString, paramBoolean2, (byte)1, paramInt3, false, paramInt1, paramBoolean3, paramInt4);
    paramString.Xq(FaceInfo.dYB);
    this.x.put(str, paramString);
    d(paramString);
    return true;
  }
  
  public void c(int paramInt1, String paramString, int paramInt2, long paramLong) {}
  
  protected void cUQ()
  {
    localObject1 = null;
    do
    {
      try
      {
        FaceInfo localFaceInfo = (FaceInfo)this.am.removeFirst();
        if (localObject1 == null) {
          continue;
        }
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          this.dYw += 1;
          FaceDecodeTask.a(FaceDecodeTask.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, localFaceInfo, this));
          return;
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            localObject1 = localThrowable1;
            Object localObject2 = localThrowable2;
          }
        }
        localThrowable1 = localThrowable1;
      }
      this.dYw -= 1;
    } while (!QLog.isColorLevel());
    ajrk.m("Q.qqhead.NearbyFaceDecoder", new Object[] { "runNextTask", localThrowable1, localObject1 });
  }
  
  public void destory()
  {
    if ((this.jdField_a_of_type_Acpq != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.removeObserver(this.jdField_a_of_type_Acpq);
      this.jdField_a_of_type_Acpq = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDownloader != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDownloader.b(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = null;
    super.destory();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqej
 * JD-Core Version:    0.7.0.1
 */