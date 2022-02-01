import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uzn
  implements View.OnClickListener
{
  uzn(uzl paramuzl) {}
  
  public void onClick(View paramView)
  {
    uzl.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzn
 * JD-Core Version:    0.7.0.1
 */