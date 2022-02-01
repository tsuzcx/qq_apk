import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class amlo
  implements View.OnClickListener
{
  public amlo(UniteSearchActivity paramUniteSearchActivity) {}
  
  public void onClick(View paramView)
  {
    UniteSearchActivity.dCE = 1;
    this.this$0.b.setText("");
    this.this$0.IM();
    amub.a(this.this$0.app, 0, this.this$0.from, "0X8009D2B", 0, 0, null, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amlo
 * JD-Core Version:    0.7.0.1
 */