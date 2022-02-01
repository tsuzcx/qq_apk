import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vow
  implements View.OnClickListener
{
  public vow(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.aZE) {
      this.a.refresh();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ("group_activity".equals(this.a.mFrom))
      {
        this.a.ayu();
      }
      else
      {
        this.a.setResult(-1, this.a.j());
        this.a.finish();
        this.a.ayn();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vow
 * JD-Core Version:    0.7.0.1
 */