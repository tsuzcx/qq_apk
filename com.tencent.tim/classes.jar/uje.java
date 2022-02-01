import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.BaseChatpieHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uje
  implements View.OnClickListener
{
  public uje(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(View paramView)
  {
    ajlc.a().djF = 0;
    this.this$0.a.x(this.this$0.a(), this.this$0.a().getIntent());
    this.this$0.fV(1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uje
 * JD-Core Version:    0.7.0.1
 */