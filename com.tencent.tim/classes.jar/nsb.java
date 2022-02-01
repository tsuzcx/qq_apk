import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nsb
  implements View.OnClickListener
{
  nsb(nrz paramnrz) {}
  
  public void onClick(View paramView)
  {
    this.b.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nsb
 * JD-Core Version:    0.7.0.1
 */