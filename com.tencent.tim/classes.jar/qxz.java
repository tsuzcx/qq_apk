import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qxz
  implements View.OnClickListener
{
  qxz(qxq paramqxq, qzy paramqzy) {}
  
  public void onClick(View paramView)
  {
    rar.a("home_page", "guide_close", 0, 0, new String[0]);
    this.b.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qxz
 * JD-Core Version:    0.7.0.1
 */