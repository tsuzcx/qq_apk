import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ufl
  implements View.OnClickListener
{
  ufl(ufj paramufj) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufl
 * JD-Core Version:    0.7.0.1
 */