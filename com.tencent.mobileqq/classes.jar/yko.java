import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.api.adbox.GdtAdBoxData;
import com.tencent.mobileqq.pb.PBStringField;
import java.lang.ref.WeakReference;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;

public class yko
{
  private ykn jdField_a_of_type_Ykn;
  private ykp jdField_a_of_type_Ykp;
  
  public yko(ykp paramykp, ykn paramykn)
  {
    yny.a("GdtAdBoxPresenter", "GdtAdBoxPresenter() called with: view = [" + paramykp + "], model = [" + paramykn + "]");
    this.jdField_a_of_type_Ykp = paramykp;
    this.jdField_a_of_type_Ykn = paramykn;
    paramykn.a(this);
  }
  
  public void a()
  {
    yny.a("GdtAdBoxPresenter", "onCreate() called");
    this.jdField_a_of_type_Ykp.b(this.jdField_a_of_type_Ykn);
  }
  
  public void a(Activity paramActivity, View paramView, GdtAdBoxData paramGdtAdBoxData)
  {
    paramGdtAdBoxData = new yjs();
    GdtAppReceiver localGdtAppReceiver = new GdtAppReceiver();
    paramGdtAdBoxData.jdField_a_of_type_Int = 11;
    paramGdtAdBoxData.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    paramActivity = paramView.getTag(2131301336);
    if (paramActivity == null)
    {
      yny.d("GdtAdBoxPresenter", "onClick() tag == null");
      return;
    }
    paramActivity = (GdtAd)paramActivity;
    yny.a("GdtAdBoxPresenter", "onClick() open url = [" + paramActivity.info.dest_info.landing_page.get() + "]");
    paramGdtAdBoxData.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramActivity;
    paramGdtAdBoxData.jdField_a_of_type_Boolean = true;
    paramGdtAdBoxData.jdField_b_of_type_Boolean = true;
    paramGdtAdBoxData.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(localGdtAppReceiver);
    paramActivity = new Bundle();
    paramActivity.putString("big_brother_ref_source_key", "biz_src_miniapp");
    paramGdtAdBoxData.jdField_a_of_type_AndroidOsBundle = paramActivity;
    yjr.a(paramGdtAdBoxData);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    yny.a("GdtAdBoxPresenter", "onResume() called");
  }
  
  public void c() {}
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yko
 * JD-Core Version:    0.7.0.1
 */