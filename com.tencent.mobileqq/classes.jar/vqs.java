import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vqs
  implements View.OnClickListener
{
  vqs(vqq paramvqq) {}
  
  public void onClick(View paramView)
  {
    vqq.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqs
 * JD-Core Version:    0.7.0.1
 */