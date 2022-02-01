import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.SelectedAndSearchBar;
import com.tencent.mobileqq.activity.SelectedAndSearchBar.b;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class vtf
  implements AdapterView.OnItemClickListener
{
  public vtf(SelectedAndSearchBar paramSelectedAndSearchBar) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ResultRecord localResultRecord = (ResultRecord)SelectedAndSearchBar.a(this.this$0).get(paramInt);
    if (SelectedAndSearchBar.a(this.this$0) != null) {
      SelectedAndSearchBar.a(this.this$0).a(localResultRecord);
    }
    this.this$0.cz(false);
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     vtf
 * JD-Core Version:    0.7.0.1
 */