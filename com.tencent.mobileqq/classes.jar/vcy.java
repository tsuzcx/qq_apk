import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vcy
  implements View.OnClickListener
{
  vcy(vcx paramvcx) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a() instanceof vcj)) {
      ((vcj)this.a.a()).f();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcy
 * JD-Core Version:    0.7.0.1
 */