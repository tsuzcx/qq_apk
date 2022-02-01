import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uzs
  implements View.OnClickListener
{
  uzs(uzr paramuzr) {}
  
  public void onClick(View paramView)
  {
    uzr.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzs
 * JD-Core Version:    0.7.0.1
 */