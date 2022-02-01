import android.content.Context;
import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class antv
  implements AdExposureChecker.ExposureCallback
{
  antv(antu paramantu, zyd paramzyd, Context paramContext, GdtAd paramGdtAd) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletGdtAdManager_StructMsgItemLayout31", 2, "reportImpression...");
    }
    this.jdField_a_of_type_Zyd.ad(this.val$context, 1);
    this.jdField_a_of_type_Zyd.cD(this.val$gdtAd.getUrlForImpression());
    zyd.l("public.tailplace.show", "", "", "1", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     antv
 * JD-Core Version:    0.7.0.1
 */