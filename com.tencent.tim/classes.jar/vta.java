import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SearchMightKnowFragment;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vta
  implements View.OnClickListener
{
  public vta(SearchMightKnowFragment paramSearchMightKnowFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.b.setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vta
 * JD-Core Version:    0.7.0.1
 */