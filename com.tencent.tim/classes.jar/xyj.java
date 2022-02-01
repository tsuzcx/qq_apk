import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xyj
  implements View.OnClickListener
{
  xyj(xyi paramxyi) {}
  
  public void onClick(View paramView)
  {
    xrc.a(this.this$0.app, this.this$0.a(), this.this$0.sessionInfo, 1, false, this.this$0.app.getCurrentUin(), "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xyj
 * JD-Core Version:    0.7.0.1
 */