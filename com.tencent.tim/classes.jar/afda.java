import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.dating.FansEntity;
import com.tencent.mobileqq.dating.SayHelloMsgListActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class afda
  extends ajqz
{
  public afda(SayHelloMsgListActivity paramSayHelloMsgListActivity) {}
  
  public void O(boolean paramBoolean, List<FansEntity> paramList)
  {
    int i = 0;
    if (paramBoolean)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        FansEntity localFansEntity = (FansEntity)localIterator.next();
        RecentBaseData localRecentBaseData = (RecentBaseData)this.this$0.jP.get(String.valueOf(localFansEntity.uin));
        if ((localRecentBaseData != null) && ((localRecentBaseData instanceof RecentSayHelloListItem))) {
          ((RecentSayHelloListItem)localRecentBaseData).a(localFansEntity);
        }
      }
      anot.a(this.this$0.app, "dc00899", "grp_lbs", "", "c2c_tmp", "exp_hi_list", 0, 0, "", "", "", "");
    }
    if (this.this$0.k != null)
    {
      this.this$0.k.removeMessages(0);
      this.this$0.k.sendEmptyMessage(0);
    }
    if (QLog.isDevelopLevel()) {
      if (paramList != null) {
        break label187;
      }
    }
    for (;;)
    {
      QLog.d("Q.msg_box", 4, "get tags, size is " + i);
      return;
      label187:
      i = paramList.size();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afda
 * JD-Core Version:    0.7.0.1
 */