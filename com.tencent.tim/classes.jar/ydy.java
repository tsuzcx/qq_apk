import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ydy
  implements View.OnClickListener
{
  ydy(ydw paramydw) {}
  
  public void onClick(View paramView)
  {
    if (!this.this$0.aSY) {
      aprg.H(this.this$0.mContext, null, this.this$0.sessionInfo.aTl);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ydy
 * JD-Core Version:    0.7.0.1
 */