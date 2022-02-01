import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class amld
  implements View.OnClickListener
{
  public amld(BaseSearchActivity paramBaseSearchActivity) {}
  
  public void onClick(View paramView)
  {
    BaseSearchActivity.dCE = 1;
    this.a.b.setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amld
 * JD-Core Version:    0.7.0.1
 */