import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class xmq
  implements View.OnClickListener
{
  xmq(xmp paramxmp) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.shakemsg", 2, "shake msg onClick() is called");
    }
    wja.bcO = true;
    if (this.a.Rk()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (SystemClock.uptimeMillis() - xmp.a(this.a) < 3000L)
      {
        QLog.d("Q.msg.shakemsg", 2, "shake return cause:too much click in a very short time!");
      }
      else
      {
        MessageForShakeWindow localMessageForShakeWindow = (MessageForShakeWindow)wja.a(paramView);
        if (((this.a.mContext instanceof ChatActivity)) || ((this.a.mContext instanceof SplashActivity)))
        {
          FragmentActivity localFragmentActivity = (FragmentActivity)this.a.mContext;
          xmp.a(this.a, SystemClock.uptimeMillis());
          localFragmentActivity.getChatFragment().a().bIc();
          this.a.app.bH(localMessageForShakeWindow.frienduin, false);
        }
        else
        {
          this.a.app.bH(localMessageForShakeWindow.frienduin, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xmq
 * JD-Core Version:    0.7.0.1
 */