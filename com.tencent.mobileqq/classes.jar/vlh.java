import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vlh
  implements View.OnClickListener
{
  vlh(vlg paramvlg) {}
  
  public void onClick(View paramView)
  {
    vlg.a(this.a, false);
    this.a.b();
    if (vlg.a(this.a) != null) {
      vlg.a(this.a).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vlh
 * JD-Core Version:    0.7.0.1
 */