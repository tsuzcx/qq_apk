import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class wto
  implements View.OnClickListener
{
  wto(wtn paramwtn) {}
  
  public void onClick(View paramView)
  {
    wtn.a(this.this$0).dismissDialog(230);
    stj.a(wtn.a(this.this$0), wtn.a(this.this$0).cZ, wtn.a(this.this$0).aTl, wtn.a(this.this$0).getAccount());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wto
 * JD-Core Version:    0.7.0.1
 */