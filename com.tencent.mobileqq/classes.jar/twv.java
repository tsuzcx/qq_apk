import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

final class twv
  implements tzv
{
  twv(ReadInJoyPatchAdView paramReadInJoyPatchAdView, Activity paramActivity, sdy paramsdy, sdc paramsdc, see paramsee, scw paramscw, tww paramtww) {}
  
  public void a(sdg paramsdg, int paramInt)
  {
    if (!twu.a(paramsdg)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(twu.a, 2, "onStart: id = " + paramsdg.a.mArticleID);
    }
    twu.a(paramsdg, paramInt, 1);
    twu.b();
  }
  
  public void a(sdg paramsdg, int paramInt1, int paramInt2)
  {
    if (!twu.a(paramsdg)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a.clickPos = paramInt2;
    if (paramInt1 == 1) {
      paramsdg.a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    for (;;)
    {
      uhs.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a, null, 3, true, null);
      obb.a(new trn().a(this.jdField_a_of_type_AndroidAppActivity).a(obb.a).b(obb.T).d(paramInt2).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a).a());
      return;
      paramsdg.a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
  }
  
  public void b(sdg paramsdg, int paramInt)
  {
    int i = 1;
    if (!twu.a(paramsdg)) {}
    for (;;)
    {
      return;
      if ((paramInt == 1) && (!paramsdg.a.patchStatus.c.get()))
      {
        paramsdg.a.patchStatus.c.set(true);
        paramInt = i;
      }
      while (paramInt != 0)
      {
        obb.a(new trn().a(BaseApplication.getContext()).a(obb.b).b(obb.O).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a).e(new JSONObject()).a());
        return;
        if ((paramInt == 2) && (!paramsdg.a.patchStatus.d.get()))
        {
          paramsdg.a.patchStatus.d.set(true);
          paramInt = i;
        }
        else
        {
          paramInt = 0;
        }
      }
    }
  }
  
  public void b(sdg paramsdg, int paramInt1, int paramInt2)
  {
    if (!twu.a(paramsdg)) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d(twu.a, 2, "onCompletion: id = " + paramsdg.a.mArticleID);
        }
        twu.a(paramsdg, paramInt1, 3);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a();
        if (paramInt1 != 1) {
          break;
        }
      } while (this.jdField_a_of_type_Sdy.a() != paramsdg);
      switch (paramInt2)
      {
      default: 
        this.jdField_a_of_type_Sdc.a(paramsdg);
        return;
      }
      this.jdField_a_of_type_Sdc.a();
      return;
    } while ((this.jdField_a_of_type_See == null) || (paramInt2 != 0));
    this.jdField_a_of_type_See.a(paramsdg);
    this.jdField_a_of_type_Scw.c();
  }
  
  public void c(sdg paramsdg, int paramInt)
  {
    if (!twu.a(paramsdg)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(twu.a, 2, "onResume: id = " + paramsdg.a.mArticleID);
      }
      if (this.jdField_a_of_type_Sdy.a().a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2)
      {
        twu.a(this.jdField_a_of_type_Sdy.a(), this.jdField_a_of_type_Sdy, true, this.jdField_a_of_type_Tww);
        return;
      }
    } while (this.jdField_a_of_type_Sdy.a().a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2);
    twu.a(this.jdField_a_of_type_Sdy.a(), this.jdField_a_of_type_Sdy, false, true, this.jdField_a_of_type_See, this.jdField_a_of_type_Scw, this.jdField_a_of_type_Tww);
  }
  
  public void d(sdg paramsdg, int paramInt)
  {
    if (!twu.a(paramsdg)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(twu.a, 2, "onPause: id = " + paramsdg.a.mArticleID);
    }
    if (this.jdField_a_of_type_Sdy.a().a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {
      this.jdField_a_of_type_Sdy.a().a.patchStatus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a();
      }
      twu.c();
      return;
      if (this.jdField_a_of_type_Sdy.a().a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {
        this.jdField_a_of_type_Sdy.a().a.patchStatus.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     twv
 * JD-Core Version:    0.7.0.1
 */