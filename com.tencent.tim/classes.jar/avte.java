import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.contentbox.MsgFootTips;

public class avte
  implements View.OnClickListener
{
  public avte(MsgFootTips paramMsgFootTips) {}
  
  public void onClick(View paramView)
  {
    if (MsgFootTips.a(this.b) == 2) {
      MsgFootTips.a(this.b).sendEmptyMessage(2);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (MsgFootTips.a(this.b) == 5) {
        if (this.b.yK) {
          MsgFootTips.a(this.b).sendEmptyMessage(-10001);
        } else {
          MsgFootTips.a(this.b).sendEmptyMessage(-10000);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avte
 * JD-Core Version:    0.7.0.1
 */