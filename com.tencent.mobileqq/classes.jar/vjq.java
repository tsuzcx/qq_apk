import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vjq
  implements View.OnClickListener
{
  vjq(vjo paramvjo) {}
  
  public void onClick(View paramView)
  {
    vjo.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjq
 * JD-Core Version:    0.7.0.1
 */