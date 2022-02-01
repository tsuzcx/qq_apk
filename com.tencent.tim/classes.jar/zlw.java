import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zlw
  implements View.OnClickListener
{
  zlw(zlt paramzlt) {}
  
  public void onClick(View paramView)
  {
    this.b.o = null;
    this.b.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zlw
 * JD-Core Version:    0.7.0.1
 */