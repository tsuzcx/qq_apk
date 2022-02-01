import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPkgSelectDialog.1.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class tyg
  implements AdapterView.OnItemClickListener
{
  tyg(tyf paramtyf) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    tyf.a(this.a, paramInt);
    tyf.a(this.a).notifyDataSetChanged();
    tyf.a(this.a).postDelayed(new GiftPkgSelectDialog.1.1(this, paramInt), 100L);
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tyg
 * JD-Core Version:    0.7.0.1
 */