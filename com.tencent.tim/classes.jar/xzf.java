import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xzf
  implements View.OnClickListener
{
  xzf(xys paramxys) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.this$0.TAG, 2, "mQimStatusOnClickListener.onClick: invoked. info: v = " + paramView);
    }
    this.this$0.app.reportClickEvent("CliOper", "0X80087E6");
    xva.a().b(this.this$0.app, this.this$0.mContext);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xzf
 * JD-Core Version:    0.7.0.1
 */