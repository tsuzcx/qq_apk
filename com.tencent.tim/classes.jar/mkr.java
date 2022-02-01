import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoTagSelectionFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoTagSelectionFragment.a;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;

public class mkr
  implements AdapterView.c
{
  public mkr(ReadInJoyVideoTagSelectionFragment paramReadInJoyVideoTagSelectionFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (TagInfo)ReadInJoyVideoTagSelectionFragment.a(this.a).getItem(paramInt);
    ReadInJoyVideoTagSelectionFragment.a(this.a).b(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mkr
 * JD-Core Version:    0.7.0.1
 */