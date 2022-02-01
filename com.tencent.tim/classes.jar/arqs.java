import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import com.tencent.open.agent.FriendChooser;
import com.tencent.qphone.base.util.QLog;

public class arqs
  extends Handler
{
  public arqs(FriendChooser paramFriendChooser) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      this.a.b.scrollTo(this.a.q.getLayoutParams().width, 0);
      if (QLog.isColorLevel()) {
        QLog.e("qqBaseActivity", 2, "" + this.a.q.getLayoutParams().width);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arqs
 * JD-Core Version:    0.7.0.1
 */