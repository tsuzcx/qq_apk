import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageForLocationShare;
import com.tencent.mobileqq.location.ui.LocationShareFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aisg
  implements View.OnClickListener
{
  private MessageForLocationShare b;
  public boolean clickable = true;
  
  private void duh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationMessageModule", 2, new Object[] { "realClick: invoked. 屏蔽消息双击事件 messageForLocationShare: ", this.b });
    }
    LocationShareFragment.c(BaseActivity.sTopActivity, this.b.istroop, this.b.frienduin, 2);
    anot.a(null, "CliOper", "", "", "0X800A766", "0X800A766", 0, 0, "", "0", "0", "");
  }
  
  public void b(MessageForLocationShare paramMessageForLocationShare)
  {
    this.b = paramMessageForLocationShare;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationMessageModule", 2, new Object[] { "onClick: invoked. ", " v: ", paramView, " messageForLocationShare: ", this.b });
    }
    if (!this.clickable) {
      if (QLog.isColorLevel()) {
        QLog.d("LocationMessageModule", 2, new Object[] { "onClick: invoked. disable click in chat history", " v: ", paramView });
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (sox.fY("LocationMessageModule"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("LocationMessageModule", 2, new Object[] { "onClick: invoked. 屏蔽消息双击事件", " v: ", paramView });
        }
      }
      else if ((BaseActivity.sTopActivity != null) && (this.b != null) && (this.b.isSharingLocation)) {
        duh();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aisg
 * JD-Core Version:    0.7.0.1
 */