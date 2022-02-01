import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

final class tqe
  implements ttf
{
  tqe(ReadInJoyPatchAdView paramReadInJoyPatchAdView, Activity paramActivity, rwu paramrwu, rvy paramrvy, rxa paramrxa, rvs paramrvs, tqf paramtqf) {}
  
  public void a(rwc paramrwc, int paramInt)
  {
    if (!tqd.a(paramrwc)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(tqd.a, 2, "onStart: id = " + paramrwc.a.mArticleID);
    }
    tqd.a(paramrwc, paramInt, 1);
    tqd.b();
  }
  
  public void a(rwc paramrwc, int paramInt1, int paramInt2)
  {
    if (!tqd.a(paramrwc)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a.clickPos = paramInt2;
    if (paramInt1 == 1) {
      paramrwc.a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    for (;;)
    {
      ubd.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a, null, 3, true, null);
      nzq.a(new tlx().a(this.jdField_a_of_type_AndroidAppActivity).a(nzq.a).b(nzq.T).d(paramInt2).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a).a());
      return;
      paramrwc.a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
  }
  
  public void b(rwc paramrwc, int paramInt)
  {
    int i = 1;
    if (!tqd.a(paramrwc)) {}
    for (;;)
    {
      return;
      if ((paramInt == 1) && (!paramrwc.a.patchStatus.c.get()))
      {
        paramrwc.a.patchStatus.c.set(true);
        paramInt = i;
      }
      while (paramInt != 0)
      {
        nzq.a(new tlx().a(BaseApplication.getContext()).a(nzq.b).b(nzq.O).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a).e(new JSONObject()).a());
        return;
        if ((paramInt == 2) && (!paramrwc.a.patchStatus.d.get()))
        {
          paramrwc.a.patchStatus.d.set(true);
          paramInt = i;
        }
        else
        {
          paramInt = 0;
        }
      }
    }
  }
  
  public void b(rwc paramrwc, int paramInt1, int paramInt2)
  {
    if (!tqd.a(paramrwc)) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d(tqd.a, 2, "onCompletion: id = " + paramrwc.a.mArticleID);
        }
        tqd.a(paramrwc, paramInt1, 3);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a();
        if (paramInt1 != 1) {
          break;
        }
      } while (this.jdField_a_of_type_Rwu.a() != paramrwc);
      switch (paramInt2)
      {
      default: 
        this.jdField_a_of_type_Rvy.a(paramrwc);
        return;
      }
      this.jdField_a_of_type_Rvy.a();
      return;
    } while ((this.jdField_a_of_type_Rxa == null) || (paramInt2 != 0));
    this.jdField_a_of_type_Rxa.a(paramrwc);
    this.jdField_a_of_type_Rvs.c();
  }
  
  public void c(rwc paramrwc, int paramInt)
  {
    if (!tqd.a(paramrwc)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(tqd.a, 2, "onResume: id = " + paramrwc.a.mArticleID);
      }
      if (this.jdField_a_of_type_Rwu.a().a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2)
      {
        tqd.a(this.jdField_a_of_type_Rwu.a(), this.jdField_a_of_type_Rwu, true, this.jdField_a_of_type_Tqf);
        return;
      }
    } while (this.jdField_a_of_type_Rwu.a().a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2);
    tqd.a(this.jdField_a_of_type_Rwu.a(), this.jdField_a_of_type_Rwu, false, true, this.jdField_a_of_type_Rxa, this.jdField_a_of_type_Rvs, this.jdField_a_of_type_Tqf);
  }
  
  public void d(rwc paramrwc, int paramInt)
  {
    if (!tqd.a(paramrwc)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(tqd.a, 2, "onPause: id = " + paramrwc.a.mArticleID);
    }
    if (this.jdField_a_of_type_Rwu.a().a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {
      this.jdField_a_of_type_Rwu.a().a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a();
      }
      tqd.c();
      return;
      if (this.jdField_a_of_type_Rwu.a().a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {
        this.jdField_a_of_type_Rwu.a().a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tqe
 * JD-Core Version:    0.7.0.1
 */