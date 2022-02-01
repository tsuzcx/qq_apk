import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zll
  implements View.OnClickListener
{
  zll(zli paramzli) {}
  
  public void onClick(View paramView)
  {
    this.c.o = null;
    this.c.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zll
 * JD-Core Version:    0.7.0.1
 */