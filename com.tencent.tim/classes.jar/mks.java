import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoTagSelectionFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoTagSelectionFragment.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;

public class mks
  implements AdapterView.c
{
  public mks(ReadInJoyVideoTagSelectionFragment paramReadInJoyVideoTagSelectionFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramAdapterView.getItemAtPosition(paramInt);
    if ((paramAdapterView != null) && ((paramAdapterView instanceof TagInfo)))
    {
      if (ReadInJoyVideoTagSelectionFragment.a(this.a).isFull()) {
        break label72;
      }
      if ((!ReadInJoyVideoTagSelectionFragment.a(this.a).a((TagInfo)paramAdapterView)) && (!ReadInJoyVideoTagSelectionFragment.a(this.a).isShowing())) {
        ReadInJoyVideoTagSelectionFragment.a(this.a).show();
      }
    }
    label72:
    while (ReadInJoyVideoTagSelectionFragment.b(this.a).isShowing()) {
      return;
    }
    ReadInJoyVideoTagSelectionFragment.b(this.a).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mks
 * JD-Core Version:    0.7.0.1
 */