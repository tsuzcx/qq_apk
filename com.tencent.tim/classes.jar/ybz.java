import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ybz
  implements View.OnClickListener
{
  ybz(ybt paramybt) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof Integer)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str = this.this$0.sessionInfo.aTl;
      if (this.this$0.sessionInfo.cZ == 1006) {
        str = this.this$0.sessionInfo.aTo;
      }
      ybt.a(this.this$0, (Integer)localObject, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ybz
 * JD-Core Version:    0.7.0.1
 */