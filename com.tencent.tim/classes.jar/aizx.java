import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.matchchat.MatchChatMsgListFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;

public class aizx
  implements Handler.Callback
{
  public aizx(MatchChatMsgListFragment paramMatchChatMsgListFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    label196:
    for (;;)
    {
      return false;
      if ((this.a.Pr()) || (this.a.a.getMode() != -1)) {
        break;
      }
      this.a.f.cS(this.a.yT);
      this.a.f.FX(21);
      this.a.cWQ();
      if ((this.a.mHasMore) || (this.a.yT.size() == 0)) {
        this.a.mFooterView.setVisibility(8);
      }
      for (;;)
      {
        if (this.a.bTI) {
          break label196;
        }
        this.a.bTI = true;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MatchChatMsgListFragment", 2, String.format(Locale.getDefault(), "init ui cost time : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.a.VX) }));
        return false;
        this.a.mFooterView.setVisibility(0);
      }
    }
    this.a.bTJ = true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aizx
 * JD-Core Version:    0.7.0.1
 */