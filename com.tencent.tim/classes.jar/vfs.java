import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.activity.LebaListMgrActivity.3.1;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class vfs
  extends aklk
{
  public vfs(LebaListMgrActivity paramLebaListMgrActivity) {}
  
  protected void f(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.mgr", 2, "onGameCenterMsgReceive. notifyData.");
    }
    if ((this.this$0.isResume()) && (paramBoolean1) && (paramInt != 2) && (LebaListMgrActivity.a(this.this$0) != null))
    {
      List localList = zjq.a().dp();
      this.this$0.runOnUiThread(new LebaListMgrActivity.3.1(this, localList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vfs
 * JD-Core Version:    0.7.0.1
 */