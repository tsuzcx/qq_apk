import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class rro
  implements View.OnClickListener
{
  rro(rrl paramrrl) {}
  
  public void onClick(View paramView)
  {
    this.b.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rro
 * JD-Core Version:    0.7.0.1
 */