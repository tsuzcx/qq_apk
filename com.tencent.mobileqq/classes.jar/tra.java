import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class tra
  implements View.OnClickListener
{
  tra(tqz paramtqz) {}
  
  public void onClick(View paramView)
  {
    tqz.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tra
 * JD-Core Version:    0.7.0.1
 */