import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;
import com.tencent.mobileqq.activity.qwallet.fragment.QwalletGdtCanvasFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class antw
  implements View.OnClickListener
{
  antw(antu paramantu, GdtAd paramGdtAd, Context paramContext, zyd paramzyd) {}
  
  public void onClick(View paramView)
  {
    new GdtDwellTimeStatisticsAfterClick(this.val$gdtAd, new WeakReference(paramView)).click();
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.activity = new WeakReference((Activity)this.val$context);
    localParams.ad = this.val$gdtAd;
    localParams.reportForClick = true;
    localParams.aOV = true;
    localParams.appReceiver = new WeakReference(this.jdField_a_of_type_Zyd.a(this.val$context));
    localParams.p = QwalletGdtCanvasFragment.class;
    if (localParams.extra == null) {
      localParams.extra = new Bundle();
    }
    localParams.extra.putString("big_brother_ref_source_key", "biz_src_zf_qianbao");
    GdtHandler.a(localParams);
    AdExposureChecker.onClick(this.val$context, this.val$gdtAd, new WeakReference(antu.a));
    zyd.l("public.tailplace.click", "", "", "1", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     antw
 * JD-Core Version:    0.7.0.1
 */