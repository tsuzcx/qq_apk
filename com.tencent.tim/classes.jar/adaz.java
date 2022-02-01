import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class adaz
  implements View.OnClickListener
{
  adaz(aday paramaday) {}
  
  public void onClick(View paramView)
  {
    this.this$0.close();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adaz
 * JD-Core Version:    0.7.0.1
 */