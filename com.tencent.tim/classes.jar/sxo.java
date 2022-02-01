import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class sxo
  implements View.OnClickListener
{
  sxo(sxn paramsxn) {}
  
  public void onClick(View paramView)
  {
    this.a.back();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     sxo
 * JD-Core Version:    0.7.0.1
 */