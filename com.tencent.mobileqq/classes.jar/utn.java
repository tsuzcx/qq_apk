import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class utn
  implements View.OnClickListener
{
  utn(utm paramutm) {}
  
  public void onClick(View paramView)
  {
    this.a.g();
    this.a.i();
    utm.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     utn
 * JD-Core Version:    0.7.0.1
 */