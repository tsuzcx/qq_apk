import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class jcp
  implements View.OnClickListener
{
  jcp(jci paramjci) {}
  
  public void onClick(View paramView)
  {
    if (!jci.a(this.b))
    {
      this.b.atC();
      jci.a(this.b).b.dX(0L);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jcp
 * JD-Core Version:    0.7.0.1
 */