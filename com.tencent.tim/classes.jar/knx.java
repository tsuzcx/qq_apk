import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPkgSelectDialog.1.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class knx
  implements AdapterView.OnItemClickListener
{
  knx(knw paramknw) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    knw.a(this.b, paramInt);
    knw.a(this.b).notifyDataSetChanged();
    knw.a(this.b).postDelayed(new GiftPkgSelectDialog.1.1(this, paramInt), 100L);
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     knx
 * JD-Core Version:    0.7.0.1
 */