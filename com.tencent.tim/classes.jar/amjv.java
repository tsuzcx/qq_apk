import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amjv
  implements View.OnClickListener
{
  amjv(amju paramamju, HotWordSearchEntryDataModel.a parama) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.a.moreUrl))
    {
      amxk.g(this.this$0.d, this.this$0.context, this.a.moreUrl);
      amxk.b("hot_list", "clk_title", new String[] { String.valueOf(1), String.valueOf(this.this$0.bms) });
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      amxk.b("hot_list", "clk_title", new String[] { String.valueOf(2), String.valueOf(this.this$0.bms) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amjv
 * JD-Core Version:    0.7.0.1
 */