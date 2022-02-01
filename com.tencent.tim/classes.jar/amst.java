import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amst
  implements View.OnClickListener
{
  amst(amss paramamss) {}
  
  public void onClick(View paramView)
  {
    this.a.a.cR(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amst
 * JD-Core Version:    0.7.0.1
 */