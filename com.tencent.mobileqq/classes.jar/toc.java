import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemNewFriendMsgData;
import com.tencent.mobileqq.app.NewFriendManager.INewFriendListener;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class toc
  implements NewFriendManager.INewFriendListener
{
  public toc(QQLSActivity paramQQLSActivity) {}
  
  public void R_() {}
  
  public void a(int paramInt)
  {
    if ((paramInt == 0) && (this.a.a.a().size() > 0))
    {
      Iterator localIterator = this.a.a.a().iterator();
      while (localIterator.hasNext())
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
        if ((localRecentBaseData instanceof RecentItemNewFriendMsgData))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "Need to delete RecentItemNewFriendMsgData");
          }
          this.a.a.a().remove(localRecentBaseData);
          this.a.b();
        }
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     toc
 * JD-Core Version:    0.7.0.1
 */