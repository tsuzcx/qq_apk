import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aubh
  implements View.OnClickListener
{
  aubh(aubg paramaubg) {}
  
  public void onClick(View paramView)
  {
    this.a.a.iB();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aubh
 * JD-Core Version:    0.7.0.1
 */