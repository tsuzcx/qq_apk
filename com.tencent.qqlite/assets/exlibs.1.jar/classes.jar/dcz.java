import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class dcz
  extends FriendListObserver
{
  public dcz(MsgBoxListActivity paramMsgBoxListActivity) {}
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (MsgBoxListActivity.a(this.a) == 1009))
    {
      MsgBoxListActivity.a(this.a);
      if (QLog.isDevelopLevel()) {
        QLog.d("DatingMsgListActivity", 4, "updateFriendInfo | type: same_state");
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      MsgBoxListActivity.a(this.a);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("DatingMsgListActivity", 4, "onUpdateCustomHead | isSuc" + paramBoolean);
    }
  }
  
  protected void c(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (!MsgBoxListActivity.a(this.a)) {
      MsgBoxListActivity.a(this.a, true);
    }
    do
    {
      return;
      if ((paramBoolean) && (MsgBoxListActivity.a(this.a) != null) && (MsgBoxListActivity.a(this.a) != null))
      {
        Iterator localIterator = MsgBoxListActivity.a(this.a).iterator();
        while (localIterator.hasNext())
        {
          RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
          if (localRecentBaseData.a().equals(paramString1))
          {
            localRecentBaseData.a = paramString2;
            MsgBoxListActivity.a(this.a).a(paramString1, MsgBoxListActivity.a(this.a));
          }
        }
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("DatingMsgListActivity", 4, "onGetFriendDateNick | isSuc :" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dcz
 * JD-Core Version:    0.7.0.1
 */