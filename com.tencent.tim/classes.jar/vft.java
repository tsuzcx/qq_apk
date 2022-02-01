import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.activity.LebaListMgrActivity.4.1;
import com.tencent.qphone.base.util.QLog;

public class vft
  extends ackr
{
  public vft(LebaListMgrActivity paramLebaListMgrActivity) {}
  
  public void z(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.lebatab.mgr", 4, "notifyLebaViewItemsReloaded");
    }
    if ((LebaListMgrActivity.a(this.this$0) == null) || (!this.this$0.isResume())) {
      return;
    }
    paramObject = zjq.a().dp();
    this.this$0.runOnUiThread(new LebaListMgrActivity.4.1(this, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vft
 * JD-Core Version:    0.7.0.1
 */