import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPkgSelectDialog.1.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class trn
  implements AdapterView.OnItemClickListener
{
  trn(trm paramtrm) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    trm.a(this.a, paramInt);
    trm.a(this.a).notifyDataSetChanged();
    trm.a(this.a).postDelayed(new GiftPkgSelectDialog.1.1(this, paramInt), 100L);
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trn
 * JD-Core Version:    0.7.0.1
 */