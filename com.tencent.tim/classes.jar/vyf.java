import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.qphone.base.util.QLog;

public class vyf
  implements ThreadExcutor.IThreadListener
{
  public vyf(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void onAdded()
  {
    QLog.e("TroopAssistantActivity", 2, "mRefreshListener onAdded:" + TroopAssistantActivity.a(this.this$0));
    TroopAssistantActivity.a(this.this$0, true);
  }
  
  public void onPostRun()
  {
    QLog.e("TroopAssistantActivity", 2, "mRefreshListener onPostRun:" + TroopAssistantActivity.a(this.this$0));
    TroopAssistantActivity.a(this.this$0, false);
  }
  
  public void onPreRun()
  {
    QLog.e("TroopAssistantActivity", 2, "mRefreshListener onPreRun:" + TroopAssistantActivity.a(this.this$0));
    TroopAssistantActivity.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vyf
 * JD-Core Version:    0.7.0.1
 */