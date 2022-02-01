import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class svu
  implements View.OnClickListener
{
  svu(svs paramsvs) {}
  
  public void onClick(View paramView)
  {
    this.this$0.bBn();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     svu
 * JD-Core Version:    0.7.0.1
 */