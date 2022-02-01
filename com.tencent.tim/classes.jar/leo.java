import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelectPositionFragment;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import java.util.List;

public class leo
  implements AdapterView.c
{
  public leo(ReadInJoySelectPositionFragment paramReadInJoySelectPositionFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt <= 0) {}
    do
    {
      return;
      paramAdapterView = (ljw.a)ReadInJoySelectPositionFragment.a(this.a).get(paramInt - 1);
    } while (paramAdapterView.type != 2);
    this.a.a(new SelectPositionModule.PositionData(paramAdapterView.country, paramAdapterView.province, paramAdapterView.city, paramAdapterView.cityCode));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     leo
 * JD-Core Version:    0.7.0.1
 */