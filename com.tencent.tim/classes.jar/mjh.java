import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView;
import java.util.List;

public class mjh
  implements AdapterView.OnItemLongClickListener
{
  public mjh(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!ReadInJoyDeliverUGCActivity.a(this.this$0).getItems().get(paramInt).equals(ReadInJoyDeliverUGCActivity.a(this.this$0))) {
      ReadInJoyDeliverUGCActivity.a(this.this$0).tU(paramInt);
    }
    ReadInJoyDeliverUGCActivity.a(this.this$0, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mjh
 * JD-Core Version:    0.7.0.1
 */