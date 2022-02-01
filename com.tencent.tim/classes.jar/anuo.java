import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

class anuo
  implements View.OnClickListener
{
  anuo(anun paramanun) {}
  
  public void onClick(View paramView)
  {
    if (TextUtils.isEmpty(this.this$0.mPeerUin))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    for (;;)
    {
      try
      {
        String str = aomk.q(this.this$0.mApp, this.this$0.cip);
        if (!TextUtils.isEmpty(str)) {
          break label133;
        }
        this.this$0.dTA();
        this.this$0.e(this.this$0.mPeerUin, paramView);
        anot.b(this.this$0.mApp, "P_CliOper", "Pb_account_lifeservice", "", "0X8005C9B", "0X8005C9B", 0, 1, 0, this.this$0.mPeerUin, this.this$0.mApp.getCurrentAccountUin(), this.this$0.mFileName, this.this$0.cip);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      break;
      label133:
      if (new File(localException).exists())
      {
        if (this.this$0.isPlaying) {
          this.this$0.stop();
        } else {
          this.this$0.play();
        }
      }
      else
      {
        this.this$0.dTA();
        this.this$0.e(this.this$0.mPeerUin, paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anuo
 * JD-Core Version:    0.7.0.1
 */