import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class tlk
  implements View.OnClickListener
{
  tlk(tlj paramtlj) {}
  
  public void onClick(View paramView)
  {
    tlj.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tlk
 * JD-Core Version:    0.7.0.1
 */