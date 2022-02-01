import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class wgn
  extends aclh
{
  public wgn(VisitorsActivity paramVisitorsActivity) {}
  
  public void bPd()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "onVipStatusChanged: ");
    }
    if ((this.this$0.app != null) && (VipUtils.ce(this.this$0.app)))
    {
      this.this$0.ap(true);
      this.this$0.aq(true);
      if (VisitorsActivity.b(this.this$0).compareAndSet(true, false))
      {
        if (VisitorsActivity.a(this.this$0).get())
        {
          if (QLog.isColorLevel()) {
            QLog.d("VisitorsActivity", 2, "onVipStatusChanged: showDialog");
          }
          aqha.a(this.this$0, 232, null, acfp.m(2131716843), null, acfp.m(2131716840), new wgo(this), null).show();
        }
        this.this$0.removeObserver(VisitorsActivity.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wgn
 * JD-Core Version:    0.7.0.1
 */