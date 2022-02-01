import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.fragment.GroupSearchFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class amna
  implements View.OnClickListener
{
  public amna(GroupSearchFragment paramGroupSearchFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.dCV = 1;
    if (UniteSearchActivity.bi(GroupSearchFragment.b(this.this$0), GroupSearchFragment.a(this.this$0))) {
      this.this$0.dCV = 1;
    }
    this.this$0.dOn();
    this.this$0.YM.setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amna
 * JD-Core Version:    0.7.0.1
 */