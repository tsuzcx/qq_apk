import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vka
  implements View.OnClickListener
{
  vka(vjx paramvjx) {}
  
  public void onClick(View paramView)
  {
    if (vjx.a(this.a) != null) {
      vjx.a(this.a).a(vjx.a(this.a));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vka
 * JD-Core Version:    0.7.0.1
 */