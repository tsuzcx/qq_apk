import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vnl
  implements View.OnClickListener
{
  vnl(vnk paramvnk) {}
  
  public void onClick(View paramView)
  {
    vnk.a(this.a, false);
    this.a.b();
    if (vnk.a(this.a) != null) {
      vnk.a(this.a).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vnl
 * JD-Core Version:    0.7.0.1
 */