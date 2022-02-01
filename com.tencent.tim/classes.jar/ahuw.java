import android.os.Handler;
import android.os.Message;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.gamecenter.view.NavBarQQGamePub;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;

public class ahuw
  extends Handler
{
  public ahuw(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      this.this$0.p(paramMessage.what, paramMessage.arg1, paramMessage.arg2, (String)paramMessage.obj);
      return;
      QQGameFeedWebFragment.a(this.this$0).setVisibility(8);
      return;
    } while (this.this$0.a == null);
    this.this$0.a.setUnreadNum(paramMessage.arg1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahuw
 * JD-Core Version:    0.7.0.1
 */