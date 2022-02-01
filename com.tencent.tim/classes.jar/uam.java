import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uam
  implements View.OnClickListener
{
  uam(uaj paramuaj) {}
  
  public void onClick(View paramView)
  {
    this.b.b.bF();
    ubu.a(this.b.d, 4);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uam
 * JD-Core Version:    0.7.0.1
 */