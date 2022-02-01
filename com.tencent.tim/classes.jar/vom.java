import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemNewFriendMsgData;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class vom
  implements ysf.a
{
  public vom(QQLSActivity paramQQLSActivity) {}
  
  public void Az(int paramInt)
  {
    if ((paramInt == 0) && (this.this$0.a.f().size() > 0))
    {
      Iterator localIterator = this.this$0.a.f().iterator();
      while (localIterator.hasNext())
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
        if ((localRecentBaseData instanceof RecentItemNewFriendMsgData))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "Need to delete RecentItemNewFriendMsgData");
          }
          this.this$0.a.f().remove(localRecentBaseData);
          this.this$0.updateUI();
        }
      }
    }
  }
  
  public void bLU() {}
  
  public void bLV() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vom
 * JD-Core Version:    0.7.0.1
 */