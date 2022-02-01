import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class auwu
  implements View.OnClickListener
{
  auwu(auwt paramauwt) {}
  
  public void onClick(View paramView)
  {
    this.b.ui(true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auwu
 * JD-Core Version:    0.7.0.1
 */