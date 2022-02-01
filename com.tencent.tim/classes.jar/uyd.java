import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uyd
  implements View.OnClickListener
{
  uyd(uyb paramuyb) {}
  
  public void onClick(View paramView)
  {
    uyb.a(this.a).eK(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uyd
 * JD-Core Version:    0.7.0.1
 */