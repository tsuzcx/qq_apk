import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.commodity.CommodityListView;
import com.tencent.biz.subscribe.widget.commodity.CommodityListView.a;
import com.tencent.biz.subscribe.widget.commodity.CommodityListView.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class sjd
  implements View.OnClickListener
{
  public sjd(CommodityListView.a parama, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.val$pos < CommodityListView.a.a(this.b).size())
    {
      CommodityListView.a.b(this.b).remove(this.val$pos);
      ((ArrayList)this.b.a.getData()).remove(this.val$pos);
      this.b.notifyDataSetChanged();
      if (CommodityListView.a(this.b.a) != null) {
        CommodityListView.a(this.b.a).yy(CommodityListView.a.c(this.b).size());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sjd
 * JD-Core Version:    0.7.0.1
 */