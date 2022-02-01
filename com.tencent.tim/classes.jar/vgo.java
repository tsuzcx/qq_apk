import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class vgo
  implements View.OnClickListener
{
  public vgo(LoginInfoActivity paramLoginInfoActivity, FrameLayout paramFrameLayout) {}
  
  public void onClick(View paramView)
  {
    LoginInfoActivity.a(this.this$0, this.aV);
    LoginInfoActivity.a(this.this$0).removeMessages(20200313);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vgo
 * JD-Core Version:    0.7.0.1
 */