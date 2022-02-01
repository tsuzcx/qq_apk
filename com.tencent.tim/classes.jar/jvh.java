import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class jvh
  implements View.OnClickListener
{
  jvh(jvg paramjvg) {}
  
  public void onClick(View paramView)
  {
    this.a.b.on(this.a.b.state);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jvh
 * JD-Core Version:    0.7.0.1
 */