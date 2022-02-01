import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.List;

class adpm
  implements AdapterView.OnItemClickListener
{
  adpm(adpi paramadpi) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = adpi.a(this.this$0).getSelectedView();
    if (localObject != null) {
      ((View)localObject).setSelected(false);
    }
    adpi.a(this.this$0).setSelection(paramInt);
    localObject = adpi.a(this.this$0).getSelectedView();
    if (localObject != null) {
      ((View)localObject).setSelected(true);
    }
    adpi.a(this.this$0, paramInt);
    adpi.a(this.this$0, true);
    if ((adpi.a(this.this$0) != null) && (adpi.a(this.this$0).size() > 0) && (adpi.a(this.this$0).size() > adpi.a(this.this$0)))
    {
      localObject = (adqa)adpi.a(this.this$0).get(adpi.a(this.this$0));
      if (localObject != null) {
        adqu.a(null, ((adqa)localObject).appName, "AIOInputPannelTabClick", 0, 0, 0L, 0L, 0L, "", "");
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adpm
 * JD-Core Version:    0.7.0.1
 */