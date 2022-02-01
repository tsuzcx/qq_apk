import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vcb
  implements View.OnClickListener
{
  vcb(vca paramvca) {}
  
  public void onClick(View paramView)
  {
    vca.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcb
 * JD-Core Version:    0.7.0.1
 */