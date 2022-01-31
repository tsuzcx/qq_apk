import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.adbox.GdtAdBoxData;
import com.tencent.mobileqq.pb.PBStringField;
import java.lang.ref.WeakReference;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;

public class ytm
{
  private ytl jdField_a_of_type_Ytl;
  private ytn jdField_a_of_type_Ytn;
  
  public ytm(ytn paramytn, ytl paramytl)
  {
    yxp.a("GdtAdBoxPresenter", "GdtAdBoxPresenter() called with: view = [" + paramytn + "], model = [" + paramytl + "]");
    this.jdField_a_of_type_Ytn = paramytn;
    this.jdField_a_of_type_Ytl = paramytl;
    paramytl.a(this);
  }
  
  public void a()
  {
    yxp.a("GdtAdBoxPresenter", "onCreate() called");
    this.jdField_a_of_type_Ytn.b(this.jdField_a_of_type_Ytl);
  }
  
  public void a(Activity paramActivity, View paramView, GdtAdBoxData paramGdtAdBoxData)
  {
    paramGdtAdBoxData = new GdtHandler.Params();
    GdtAppReceiver localGdtAppReceiver = new GdtAppReceiver();
    paramGdtAdBoxData.c = 11;
    paramGdtAdBoxData.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    paramActivity = paramView.getTag(2131366945);
    if (paramActivity == null)
    {
      yxp.d("GdtAdBoxPresenter", "onClick() tag == null");
      return;
    }
    paramActivity = (GdtAd)paramActivity;
    yxp.a("GdtAdBoxPresenter", "onClick() open url = [" + paramActivity.info.dest_info.landing_page.get() + "]");
    paramGdtAdBoxData.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramActivity;
    paramGdtAdBoxData.jdField_a_of_type_Boolean = true;
    paramGdtAdBoxData.jdField_b_of_type_Boolean = true;
    paramGdtAdBoxData.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(localGdtAppReceiver);
    paramActivity = new Bundle();
    paramActivity.putString("big_brother_ref_source_key", "biz_src_miniapp");
    paramGdtAdBoxData.jdField_a_of_type_AndroidOsBundle = paramActivity;
    GdtHandler.a(paramGdtAdBoxData);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    yxp.a("GdtAdBoxPresenter", "onResume() called");
  }
  
  public void c() {}
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ytm
 * JD-Core Version:    0.7.0.1
 */