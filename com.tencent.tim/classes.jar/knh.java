import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyPatchAdView;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyPatchAdView.a;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

final class knh
  implements ReadInJoyPatchAdView.a
{
  knh(ReadInJoyPatchAdView paramReadInJoyPatchAdView, Activity paramActivity, mza parammza, mye parammye, mza.a parama, myc parammyc, kng.a parama1) {}
  
  public void a(mye.b paramb, int paramInt)
  {
    if (!kng.a(paramb)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(kng.TAG, 2, "onStart: id = " + paramb.d.mArticleID);
    }
    kng.b(paramb, paramInt, 1);
    kng.aEM();
  }
  
  public void b(mye.b paramb, int paramInt)
  {
    int i = 1;
    if (!kng.a(paramb)) {}
    for (;;)
    {
      return;
      if ((paramInt == 1) && (!paramb.d.patchStatus.at.get()))
      {
        paramb.d.patchStatus.at.set(true);
        paramInt = i;
      }
      while (paramInt != 0)
      {
        jzk.a(new kku.a().a(BaseApplication.getContext()).a(jzk.aEK).b(jzk.aFx).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.advertisementInfo).e(new JSONObject()).a());
        return;
        if ((paramInt == 2) && (!paramb.d.patchStatus.au.get()))
        {
          paramb.d.patchStatus.au.set(true);
          paramInt = i;
        }
        else
        {
          paramInt = 0;
        }
      }
    }
  }
  
  public void c(mye.b paramb, int paramInt)
  {
    if (!kng.a(paramb)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(kng.TAG, 2, "onResume: id = " + paramb.d.mArticleID);
      }
      if (this.jdField_b_of_type_Mza.d().d.patchStatus.U.get() == 2)
      {
        kng.a(this.jdField_b_of_type_Mza.d(), this.jdField_b_of_type_Mza, true, this.jdField_a_of_type_Kng$a);
        return;
      }
    } while (this.jdField_b_of_type_Mza.d().d.patchStatus.V.get() != 2);
    kng.a(this.jdField_b_of_type_Mza.d(), this.jdField_b_of_type_Mza, false, true, this.jdField_a_of_type_Mza$a, this.jdField_a_of_type_Myc, this.jdField_a_of_type_Kng$a);
  }
  
  public void c(mye.b paramb, int paramInt1, int paramInt2)
  {
    if (!kng.a(paramb)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.advertisementInfo.clickPos = paramInt2;
    if (paramInt1 == 1) {
      paramb.d.patchStatus.ar.set(true);
    }
    for (;;)
    {
      ods.b(this.w, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.advertisementInfo, null, 3, true, null);
      jzk.a(new kku.a().a(this.w).a(jzk.aEJ).b(jzk.aFC).d(paramInt2).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.advertisementInfo).a());
      return;
      paramb.d.patchStatus.as.set(true);
    }
  }
  
  public void d(mye.b paramb, int paramInt)
  {
    if (!kng.a(paramb)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(kng.TAG, 2, "onPause: id = " + paramb.d.mArticleID);
    }
    if (this.jdField_b_of_type_Mza.d().d.patchStatus.U.get() == 1) {
      this.jdField_b_of_type_Mza.d().d.patchStatus.U.set(2);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.finish();
      }
      kng.aEN();
      return;
      if (this.jdField_b_of_type_Mza.d().d.patchStatus.V.get() == 1) {
        this.jdField_b_of_type_Mza.d().d.patchStatus.V.set(2);
      }
    }
  }
  
  public void d(mye.b paramb, int paramInt1, int paramInt2)
  {
    if (!kng.a(paramb)) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d(kng.TAG, 2, "onCompletion: id = " + paramb.d.mArticleID);
        }
        kng.b(paramb, paramInt1, 3);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyPatchAdView.finish();
        if (paramInt1 != 1) {
          break;
        }
      } while (this.jdField_b_of_type_Mza.d() != paramb);
      switch (paramInt2)
      {
      default: 
        this.jdField_b_of_type_Mye.a(paramb);
        return;
      }
      this.jdField_b_of_type_Mye.pause();
      return;
    } while ((this.jdField_a_of_type_Mza$a == null) || (paramInt2 != 0));
    this.jdField_a_of_type_Mza$a.a(paramb);
    this.jdField_a_of_type_Myc.aTG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     knh
 * JD-Core Version:    0.7.0.1
 */