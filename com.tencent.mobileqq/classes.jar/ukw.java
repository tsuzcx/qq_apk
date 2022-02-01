import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

final class ukw
  implements unx
{
  ukw(ReadInJoyPatchAdView paramReadInJoyPatchAdView, Activity paramActivity, sqd paramsqd, spg paramspg, sqj paramsqj, spa paramspa, ukx paramukx) {}
  
  public void a(spk paramspk, int paramInt)
  {
    if (!ukv.a(paramspk)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(ukv.a, 2, "onStart: id = " + paramspk.a.mArticleID);
    }
    ukv.a(paramspk, paramInt, 1);
    ukv.b();
  }
  
  public void a(spk paramspk, int paramInt1, int paramInt2)
  {
    if (!ukv.a(paramspk)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a.clickPos = paramInt2;
    if (paramInt1 == 1) {
      paramspk.a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    for (;;)
    {
      paramspk = uvp.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a, null, 3, true, null);
      ois.a(new ufy().a(this.jdField_a_of_type_AndroidAppActivity).a(1).b(8).a(paramspk).d(paramInt2).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a).a());
      return;
      paramspk.a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
  }
  
  public void b(spk paramspk, int paramInt)
  {
    int i = 1;
    if (!ukv.a(paramspk)) {}
    for (;;)
    {
      return;
      if ((paramInt == 1) && (!paramspk.a.patchStatus.c.get()))
      {
        paramspk.a.patchStatus.c.set(true);
        paramInt = i;
      }
      while (paramInt != 0)
      {
        ois.a(new ufy().a(BaseApplication.getContext()).a(2).b(4).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a).e(new JSONObject()).a());
        return;
        if ((paramInt == 2) && (!paramspk.a.patchStatus.d.get()))
        {
          paramspk.a.patchStatus.d.set(true);
          paramInt = i;
        }
        else
        {
          paramInt = 0;
        }
      }
    }
  }
  
  public void b(spk paramspk, int paramInt1, int paramInt2)
  {
    if (!ukv.a(paramspk)) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d(ukv.a, 2, "onCompletion: id = " + paramspk.a.mArticleID);
        }
        ukv.a(paramspk, paramInt1, 3);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a();
        if (paramInt1 != 1) {
          break;
        }
      } while (this.jdField_a_of_type_Sqd.a() != paramspk);
      switch (paramInt2)
      {
      default: 
        this.jdField_a_of_type_Spg.a(paramspk);
        return;
      }
      this.jdField_a_of_type_Spg.a();
      return;
    } while ((this.jdField_a_of_type_Sqj == null) || (paramInt2 != 0));
    this.jdField_a_of_type_Sqj.a(paramspk);
    this.jdField_a_of_type_Spa.c();
  }
  
  public void c(spk paramspk, int paramInt)
  {
    if (!ukv.a(paramspk)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(ukv.a, 2, "onResume: id = " + paramspk.a.mArticleID);
      }
      if (this.jdField_a_of_type_Sqd.a().a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2)
      {
        ukv.a(this.jdField_a_of_type_Sqd.a(), this.jdField_a_of_type_Sqd, true, this.jdField_a_of_type_Ukx);
        return;
      }
    } while (this.jdField_a_of_type_Sqd.a().a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2);
    ukv.a(this.jdField_a_of_type_Sqd.a(), this.jdField_a_of_type_Sqd, false, true, this.jdField_a_of_type_Sqj, this.jdField_a_of_type_Spa, this.jdField_a_of_type_Ukx);
  }
  
  public void d(spk paramspk, int paramInt)
  {
    if (!ukv.a(paramspk)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(ukv.a, 2, "onPause: id = " + paramspk.a.mArticleID);
    }
    if (this.jdField_a_of_type_Sqd.a().a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {
      this.jdField_a_of_type_Sqd.a().a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a();
      }
      ukv.c();
      return;
      if (this.jdField_a_of_type_Sqd.a().a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {
        this.jdField_a_of_type_Sqd.a().a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ukw
 * JD-Core Version:    0.7.0.1
 */