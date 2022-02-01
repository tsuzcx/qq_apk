import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nrr
  implements AdapterView.OnItemClickListener
{
  public nrr(ReadInJoyNinePicDeliverDynamicGridView paramReadInJoyNinePicDeliverDynamicGridView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((!this.b.isEditMode()) && (this.b.isEnabled()) && (ReadInJoyNinePicDeliverDynamicGridView.a(this.b) != null)) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.b).onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nrr
 * JD-Core Version:    0.7.0.1
 */