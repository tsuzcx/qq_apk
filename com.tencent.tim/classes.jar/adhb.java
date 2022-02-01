import android.os.Handler;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class adhb
  implements adgp.a
{
  adhb(adgy paramadgy, long paramLong, adhv paramadhv) {}
  
  public void a(int paramInt, String paramString, adhr paramadhr)
  {
    adgy.c(this.this$0, false);
    if (adgy.a(this.this$0)) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject = this.this$0;
        if ((paramadhr == null) || (paramadhr.jdField_a_of_type_Adhh == null)) {
          continue;
        }
        i = paramadhr.jdField_a_of_type_Adhh.cFS;
        ((adgy)localObject).cFD = i;
        adgy localadgy = this.this$0;
        if ((paramadhr == null) || (paramadhr.jdField_a_of_type_Adhh == null) || (paramadhr.jdField_a_of_type_Adhh.a == null) || (paramadhr.jdField_a_of_type_Adhh.a.length <= 0)) {
          continue;
        }
        localObject = paramadhr.jdField_a_of_type_Adhh.a[0].imageId;
        localadgy.bsO = ((String)localObject);
      }
      catch (Exception localException)
      {
        Object localObject;
        long l1;
        long l2;
        boolean bool2;
        boolean bool1;
        QLog.i("AREngine_ARCloudControl", 1, "  mCloudTime  mImageId " + localException.getMessage());
        continue;
        int i = 0;
        continue;
        QLog.i("AREngine_ARCloudControl", 1, "MIGObjectClaasify not need  run requestToCheckLBSLocation.");
        adgy.a(this.this$0).b(paramInt, paramadhr);
        return;
      }
      if (this.this$0.SR != 0L) {
        this.this$0.SW = (System.currentTimeMillis() - this.this$0.SR);
      }
      if (this.this$0.SS != 0L)
      {
        localObject = this.this$0;
        ((adgy)localObject).mUploadTime += System.currentTimeMillis() - this.this$0.SS;
      }
      if (adgy.a(this.this$0) != null) {
        adgy.a(this.this$0).removeMessages(1);
      }
      l1 = System.currentTimeMillis();
      l2 = this.val$start;
      QLog.i("AREngine_ARCloudControl", 1, "[DEBUG_SCAN_yt_face] onARCloudUploadImgComplete  retCode = " + paramInt + ", rspInfo = , sessionId = " + paramString + ",uploadCost = " + (l1 - l2));
      QLog.i("AREngine_ARCloudControl", 1, String.format("selectImage total time cost:start Time is %s", new Object[] { "requestToUpload" }));
      if (adgy.a(this.this$0) == null) {
        break;
      }
      if ((paramInt == 0) && (paramadhr != null) && ((adhh.a(paramadhr.jdField_a_of_type_Adhh)) || (adhk.a(paramadhr.jdField_a_of_type_Adhk)) || (adin.a(paramadhr.jdField_a_of_type_Adin)) || (adht.a(paramadhr.jdField_a_of_type_Adht)) || (adhy.a(paramadhr.jdField_a_of_type_Adhy))))
      {
        QLog.d("AREngine_ARCloudControl", 2, "mResult set:" + this.this$0.mResult);
        this.this$0.mResult = 0;
      }
      if ((paramadhr != null) && (adhh.a(paramadhr.jdField_a_of_type_Adhh))) {
        paramadhr.jdField_a_of_type_Adhh.path = this.a.a.fileName;
      }
      if ((paramadhr != null) && (adhk.a(paramadhr.jdField_a_of_type_Adhk))) {
        paramadhr.jdField_a_of_type_Adhk.path = this.a.a.fileName;
      }
      if ((paramadhr != null) && (adhy.a(paramadhr.jdField_a_of_type_Adhy))) {
        paramadhr.jdField_a_of_type_Adhy.path = this.a.a.fileName;
      }
      if (!adgy.c(this.this$0))
      {
        bool2 = false;
        bool1 = bool2;
        if (paramInt == 0)
        {
          bool1 = bool2;
          if (paramadhr != null) {
            if ((!adhh.a(paramadhr.jdField_a_of_type_Adhh)) && (!adhk.a(paramadhr.jdField_a_of_type_Adhk)) && (!adht.a(paramadhr.jdField_a_of_type_Adht)) && (!adhl.a(paramadhr.jdField_a_of_type_Adhl)))
            {
              bool1 = bool2;
              if (!adhy.a(paramadhr.jdField_a_of_type_Adhy)) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
        l1 = adgy.a(this.this$0).fp();
        adfx.a().H(bool1, l1);
        adgy.d(this.this$0, true);
      }
      if ((!adgy.d(this.this$0)) && (paramInt == 0) && (paramadhr != null) && ((adhh.a(paramadhr.jdField_a_of_type_Adhh)) || (adhk.a(paramadhr.jdField_a_of_type_Adhk)) || (adht.a(paramadhr.jdField_a_of_type_Adht)) || (adhl.a(paramadhr.jdField_a_of_type_Adhl)) || (adhy.a(paramadhr.jdField_a_of_type_Adhy))))
      {
        l1 = adgy.a(this.this$0).fp();
        adfx.a().aD(l1, this.this$0.a.cFO);
        adgy.e(this.this$0, true);
      }
      if (adgy.a(this.this$0) != null) {
        adgy.a(this.this$0).add(paramString);
      }
      if ((this.this$0.mResult != 0) || (!adhr.a(this.this$0.b.recognitions, paramadhr))) {
        break label934;
      }
      if (this.this$0.b.switchLBSLocation != 1) {
        break label919;
      }
      if ((paramadhr.Sl == 128L) && ((paramadhr.Sl != 128L) || (!adgy.a(this.this$0).a(paramadhr.jdField_a_of_type_Adin)))) {
        continue;
      }
      i = 1;
      if (i == 0) {
        continue;
      }
      QLog.i("AREngine_ARCloudControl", 1, "normal process run requestToCheckLBSLocation.");
      adgy.a(this.this$0, paramInt, paramadhr);
      return;
      i = 0;
      continue;
      localObject = "";
    }
    label919:
    adgy.a(this.this$0).b(2, null);
    return;
    label934:
    adgy.a(this.this$0).b(paramInt, paramadhr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adhb
 * JD-Core Version:    0.7.0.1
 */