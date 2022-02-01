import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ueq
  implements View.OnClickListener
{
  ueq(uep paramuep) {}
  
  public void onClick(View paramView)
  {
    uep.a(this.a, AdClickPos.SoftAdComponent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ueq
 * JD-Core Version:    0.7.0.1
 */