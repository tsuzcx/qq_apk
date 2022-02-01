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

public class tgz
{
  private tgy jdField_a_of_type_Tgy;
  private tha jdField_a_of_type_Tha;
  
  public tgz(tha paramtha, tgy paramtgy)
  {
    tkw.d("GdtAdBoxPresenter", "GdtAdBoxPresenter() called with: view = [" + paramtha + "], model = [" + paramtgy + "]");
    this.jdField_a_of_type_Tha = paramtha;
    this.jdField_a_of_type_Tgy = paramtgy;
    paramtgy.a(this);
  }
  
  public void a(Activity paramActivity, View paramView, GdtAdBoxData paramGdtAdBoxData)
  {
    paramGdtAdBoxData = new GdtHandler.Params();
    GdtAppReceiver localGdtAppReceiver = new GdtAppReceiver();
    paramGdtAdBoxData.processId = 11;
    paramGdtAdBoxData.activity = new WeakReference(paramActivity);
    paramActivity = paramView.getTag(2131367901);
    if (paramActivity == null)
    {
      tkw.e("GdtAdBoxPresenter", "onClick() tag == null");
      return;
    }
    paramActivity = (GdtAd)paramActivity;
    tkw.d("GdtAdBoxPresenter", "onClick() open url = [" + paramActivity.info.dest_info.landing_page.get() + "]");
    paramGdtAdBoxData.ad = paramActivity;
    paramGdtAdBoxData.reportForClick = true;
    paramGdtAdBoxData.aOV = true;
    paramGdtAdBoxData.appReceiver = new WeakReference(localGdtAppReceiver);
    paramActivity = new Bundle();
    paramActivity.putString("big_brother_ref_source_key", "biz_src_miniapp");
    paramGdtAdBoxData.extra = paramActivity;
    GdtHandler.a(paramGdtAdBoxData);
  }
  
  public boolean onBackEvent()
  {
    return false;
  }
  
  public void onCreate()
  {
    tkw.d("GdtAdBoxPresenter", "onCreate() called");
    this.jdField_a_of_type_Tha.b(this.jdField_a_of_type_Tgy);
  }
  
  public void onDestroy() {}
  
  public void onPause() {}
  
  public void onResume()
  {
    tkw.d("GdtAdBoxPresenter", "onResume() called");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tgz
 * JD-Core Version:    0.7.0.1
 */