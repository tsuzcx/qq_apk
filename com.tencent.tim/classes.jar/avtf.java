import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.contentbox.MsgMoreView;

public class avtf
  implements View.OnClickListener
{
  public avtf(MsgMoreView paramMsgMoreView) {}
  
  public void onClick(View paramView)
  {
    if (MsgMoreView.a(this.a) != null) {
      MsgMoreView.a(this.a).a(MsgMoreView.a(this.a), paramView, 5);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avtf
 * JD-Core Version:    0.7.0.1
 */