import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;

public class nrf
  implements AdapterView.c
{
  public nrf(ReadInJoyDynamicGridView paramReadInJoyDynamicGridView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((!this.b.isEditMode()) && (this.b.isEnabled()) && (ReadInJoyDynamicGridView.a(this.b) != null)) {
      ReadInJoyDynamicGridView.a(this.b).onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nrf
 * JD-Core Version:    0.7.0.1
 */