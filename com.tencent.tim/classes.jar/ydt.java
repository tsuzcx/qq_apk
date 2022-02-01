import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ydt
  implements View.OnClickListener
{
  ydt(ycd paramycd) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "mQidianClickListener ... mQidianKefu = " + this.this$0.blL);
    }
    this.this$0.showLoading(2131697483);
    this.this$0.b.a(this.this$0.mActivity, this.this$0.sessionInfo.aTl, this.this$0.aXk, this.this$0.aXl, this.this$0.aXm, new ydu(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ydt
 * JD-Core Version:    0.7.0.1
 */