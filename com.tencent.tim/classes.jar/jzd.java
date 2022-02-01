import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class jzd
  implements View.OnClickListener
{
  jzd(jzc paramjzc) {}
  
  public void onClick(View paramView)
  {
    this.a.a.aBq();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jzd
 * JD-Core Version:    0.7.0.1
 */