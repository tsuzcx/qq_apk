import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.activity.TimLebaListMgrActivity;
import com.tencent.tim.activity.TimLebaListMgrActivity.3.1;

public class ataw
  extends ackr
{
  public ataw(TimLebaListMgrActivity paramTimLebaListMgrActivity) {}
  
  public void z(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.lebatab.mgr", 4, "notifyLebaViewItemsReloaded");
    }
    if ((TimLebaListMgrActivity.a(this.this$0) == null) || (!this.this$0.isResume())) {
      return;
    }
    paramObject = TimLebaListMgrActivity.a(this.this$0);
    this.this$0.runOnUiThread(new TimLebaListMgrActivity.3.1(this, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ataw
 * JD-Core Version:    0.7.0.1
 */