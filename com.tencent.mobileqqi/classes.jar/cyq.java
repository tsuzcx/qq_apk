import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.RedTouchObserver;
import com.tencent.qphone.base.util.QLog;

public class cyq
  extends RedTouchObserver
{
  public cyq(LebaListMgrActivity paramLebaListMgrActivity) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.lebatab.mgr", 4, "notifyLebaViewItemsReloaded");
    }
    if ((LebaListMgrActivity.a(this.a) == null) || (!this.a.isResume())) {
      return;
    }
    paramObject = LebaShowListManager.a().a();
    this.a.runOnUiThread(new cyr(this, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cyq
 * JD-Core Version:    0.7.0.1
 */