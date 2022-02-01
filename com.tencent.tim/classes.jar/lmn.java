import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class lmn
  implements View.OnClickListener
{
  lmn(lmm paramlmm, lie paramlie) {}
  
  public void onClick(View paramView)
  {
    ndi.b(this.b.a(), 0, 1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lmn
 * JD-Core Version:    0.7.0.1
 */