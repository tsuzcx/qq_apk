import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.confess.BaseMsgListFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;

public class aegn
  implements Handler.Callback
{
  public aegn(BaseMsgListFragment paramBaseMsgListFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    label196:
    for (;;)
    {
      return false;
      if ((this.this$0.Pr()) || (this.this$0.a.getMode() != -1)) {
        break;
      }
      this.this$0.f.cS(this.this$0.yT);
      this.this$0.f.FX(17);
      this.this$0.cWQ();
      if ((this.this$0.mHasMore) || (this.this$0.yT.size() == 0)) {
        this.this$0.mFooterView.setVisibility(8);
      }
      for (;;)
      {
        if (this.this$0.bTI) {
          break label196;
        }
        this.this$0.bTI = true;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("BaseMsgListFragment", 2, String.format(Locale.getDefault(), "init ui cost time : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.this$0.VX) }));
        return false;
        this.this$0.mFooterView.setVisibility(0);
      }
    }
    this.this$0.bTJ = true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aegn
 * JD-Core Version:    0.7.0.1
 */