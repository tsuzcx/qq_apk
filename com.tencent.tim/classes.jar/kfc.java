import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.DailyTitleBarSwitcher;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class kfc
  implements View.OnClickListener
{
  kfc(kfa paramkfa, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((kfa.a(this.this$0) != null) && (!TextUtils.isEmpty(this.YS))) {
      kxm.aJ(kfa.a(this.this$0).getContext(), this.YS);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kfc
 * JD-Core Version:    0.7.0.1
 */