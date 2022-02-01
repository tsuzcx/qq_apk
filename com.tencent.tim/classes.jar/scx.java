import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class scx
  implements View.OnClickListener
{
  scx(scw paramscw) {}
  
  public void onClick(View paramView)
  {
    scw.a(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     scx
 * JD-Core Version:    0.7.0.1
 */