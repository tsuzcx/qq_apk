import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyProteusFamilyFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class lej
  implements View.OnClickListener
{
  public lej(ReadInJoyProteusFamilyFragment paramReadInJoyProteusFamilyFragment) {}
  
  public void onClick(View paramView)
  {
    if (ReadInJoyProteusFamilyFragment.a(this.this$0) != null) {
      ReadInJoyProteusFamilyFragment.a(this.this$0).lP(true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lej
 * JD-Core Version:    0.7.0.1
 */