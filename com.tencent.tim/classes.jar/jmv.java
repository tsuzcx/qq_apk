import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.PoiMapActivity.TabView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class jmv
  implements View.OnClickListener
{
  public jmv(PoiMapActivity paramPoiMapActivity) {}
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof PoiMapActivity.TabView))
    {
      this.this$0.nU(((PoiMapActivity.TabView)paramView).aCj);
      this.this$0.ays();
      if (QLog.isDevelopLevel()) {
        QLog.i("PoiMapActivity", 4, "mTabClickListener" + ((PoiMapActivity.TabView)paramView).aCj);
      }
      if (!PoiMapActivity.a(this.this$0)) {
        break label127;
      }
      this.this$0.report("share_locate", "click_tab" + (((PoiMapActivity.TabView)paramView).aCj + 1), "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label127:
      this.this$0.report("share_locate", "click_tab" + (((PoiMapActivity.TabView)paramView).aCj + 1), this.this$0.To, this.this$0.Tn, "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jmv
 * JD-Core Version:    0.7.0.1
 */