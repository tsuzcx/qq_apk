import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zsc
  implements View.OnClickListener
{
  zsc(zry paramzry) {}
  
  public void onClick(View paramView)
  {
    yup.a("home_page", "guide_close", 0, 0, new String[0]);
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zsc
 * JD-Core Version:    0.7.0.1
 */