import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yrn
  implements View.OnClickListener
{
  yrn(yrj paramyrj) {}
  
  public void onClick(View paramView)
  {
    xwa.a("home_page", "guide_close", 0, 0, new String[0]);
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yrn
 * JD-Core Version:    0.7.0.1
 */