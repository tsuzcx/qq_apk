import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vln
  implements View.OnClickListener
{
  vln(vll paramvll) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a() != null) {
      this.a.a().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vln
 * JD-Core Version:    0.7.0.1
 */