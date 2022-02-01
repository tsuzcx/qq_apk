import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class thh
  implements View.OnClickListener
{
  thh(the paramthe, thd paramthd) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.b;
    localObject = the.a.onClick(paramView);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.a.c.antiSpamParams = ((String)localObject);
      tkw.e("GdtBannerViewBuilder", "onclick:" + this.a.c.antiSpamParams);
    }
    if (this.a.a != null) {
      this.a.a.click();
    }
    GdtHandler.a(this.a.c);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     thh
 * JD-Core Version:    0.7.0.1
 */