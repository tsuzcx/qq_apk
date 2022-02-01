import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class acqa
  implements Comparator<RecentBaseData>
{
  private QQAppInterface app;
  private StringBuilder sb = new StringBuilder();
  
  public acqa(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private int C(String paramString1, String paramString2)
  {
    long l1 = Long.parseLong(paramString1);
    long l2 = Long.parseLong(paramString2);
    if (l1 - l2 == 0L) {
      return 0;
    }
    if (l1 - l2 > 0L) {
      return 1;
    }
    return -1;
  }
  
  private boolean K(String paramString, int paramInt)
  {
    return (this.app.a() != null) && (this.app.a().D(paramString, paramInt) > 0);
  }
  
  public int a(RecentBaseData paramRecentBaseData1, RecentBaseData paramRecentBaseData2)
  {
    if (((paramRecentBaseData1 instanceof RecentUserBaseData)) && ((paramRecentBaseData2 instanceof RecentUserBaseData)))
    {
      paramRecentBaseData1 = (RecentUserBaseData)paramRecentBaseData1;
      paramRecentBaseData2 = (RecentUserBaseData)paramRecentBaseData2;
      TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
      boolean bool1;
      if ((paramRecentBaseData1.mUser.getType() == 1) && (!ajpd.d(this.app, paramRecentBaseData1.mUser)))
      {
        bool1 = localTroopManager.kv(paramRecentBaseData1.qx());
        if ((paramRecentBaseData2.mUser.getType() != 1) || (ajpd.d(this.app, paramRecentBaseData2.mUser))) {
          break label138;
        }
      }
      label138:
      for (boolean bool2 = localTroopManager.kv(paramRecentBaseData2.qx());; bool2 = FriendsStatusUtil.b(this.app, paramRecentBaseData2.mUser))
      {
        if ((!bool1) || (bool2)) {
          break label154;
        }
        return -1;
        bool1 = FriendsStatusUtil.b(this.app, paramRecentBaseData1.mUser);
        break;
      }
      label154:
      if ((!bool1) && (bool2)) {
        return 1;
      }
      if ((!bool1) && (!bool2)) {
        if ((paramRecentBaseData1.mUnreadNum > 0) && (paramRecentBaseData1.mUser.getType() == 0) && (abbf.jb(this.app.getCurrentAccountUin() + paramRecentBaseData1.mUser.uin)) && (!K(paramRecentBaseData1.mUser.uin, 0)))
        {
          i = 1;
          if (i == 0) {
            break label594;
          }
        }
      }
    }
    label325:
    label465:
    label594:
    for (int i = 4096;; i = 0)
    {
      if ((paramRecentBaseData2.mUnreadNum > 0) && (paramRecentBaseData2.mUser.getType() == 0) && (abbf.jb(this.app.getCurrentAccountUin() + paramRecentBaseData2.mUser.uin)) && (!K(paramRecentBaseData2.mUser.uin, 0)))
      {
        j = 1;
        if (j == 0) {
          break label588;
        }
      }
      for (int j = 4096;; j = 0)
      {
        long l2 = Math.max(paramRecentBaseData1.mUser.lastmsgtime, paramRecentBaseData1.mUser.lastmsgdrafttime);
        long l3 = Math.max(paramRecentBaseData2.mUser.lastmsgtime, paramRecentBaseData2.mUser.lastmsgdrafttime);
        long l1 = l2;
        if (paramRecentBaseData1.mUser.lastmsgtime <= 0L)
        {
          l1 = l2;
          if (paramRecentBaseData1.mUser.lastmsgdrafttime <= 0L) {
            l1 = Math.max(l2, paramRecentBaseData1.mUser.opTime);
          }
        }
        l2 = l3;
        if (paramRecentBaseData2.mUser.lastmsgtime <= 0L)
        {
          l2 = l3;
          if (paramRecentBaseData2.mUser.lastmsgdrafttime <= 0L) {
            l2 = Math.max(l3, paramRecentBaseData2.mUser.opTime);
          }
        }
        if (l1 > l2) {
          l1 = 3L;
        }
        for (;;)
        {
          l1 = (int)(l1 | i) - (int)(0x2 | j);
          if (l1 != 0L) {
            break label575;
          }
          return C(paramRecentBaseData1.mUser.uin, paramRecentBaseData2.mUser.uin);
          i = 0;
          break;
          j = 0;
          break label325;
          l1 = paramRecentBaseData1.mDisplayTime;
          l2 = paramRecentBaseData2.mDisplayTime;
          j = 0;
          i = 0;
          break label465;
          if (l1 < l2) {
            l1 = 1L;
          } else {
            l1 = 2L;
          }
        }
        if (l1 < 0L) {
          return 1;
        }
        return -1;
        return 0;
      }
    }
  }
  
  public void hG(List<RecentUser> paramList)
  {
    RecentUser localRecentUser;
    if (QLog.isDevelopLevel())
    {
      if (this.sb == null) {
        this.sb = new StringBuilder();
      }
      for (;;)
      {
        this.sb.append("checkRUList, src[");
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localRecentUser = (RecentUser)((Iterator)localObject).next();
          this.sb.append(localRecentUser.uin + "|" + localRecentUser.getType() + ",");
        }
        this.sb.setLength(0);
      }
      this.sb.append("], [");
    }
    Object localObject = null;
    int i;
    if (paramList == null)
    {
      i = 0;
      i -= 1;
      label141:
      if (i < 0) {
        break label560;
      }
      localRecentUser = (RecentUser)paramList.get(i);
      if (localRecentUser != null) {
        break label187;
      }
      paramList.remove(i);
    }
    label187:
    label597:
    label600:
    for (;;)
    {
      i -= 1;
      break label141;
      i = paramList.size();
      break;
      if ((TextUtils.isEmpty(localRecentUser.uin)) || (TextUtils.isEmpty(localRecentUser.uin.trim())))
      {
        paramList.remove(i);
        if ((this.sb != null) && (QLog.isDevelopLevel())) {
          this.sb.append(i).append(",").append(localRecentUser.getType()).append(";");
        }
      }
      else if ((localRecentUser.getType() == 1) && ((localRecentUser.lFlag & 1L) != 0L))
      {
        if ((localObject != null) || (this.app == null)) {
          break label597;
        }
        localObject = this.app.a(true);
      }
      for (;;)
      {
        if ((localObject == null) || (((HotChatManager)localObject).kj(localRecentUser.uin))) {
          break label600;
        }
        paramList.remove(i);
        if ((this.sb == null) || (!QLog.isDevelopLevel())) {
          break label600;
        }
        this.sb.append("invalide hotchat ").append(i).append(",").append(localRecentUser.uin).append(";");
        break;
        if (localRecentUser.getType() == 3000)
        {
          if (this.app == null) {
            break label557;
          }
          DiscussionInfo localDiscussionInfo = ((acdu)this.app.getManager(53)).a(localRecentUser.uin);
          if ((localDiscussionInfo == null) || (localDiscussionInfo.isUIControlFlag_Hidden_RecentUser()) || (localDiscussionInfo.isHidden()))
          {
            paramList.remove(i);
            if ((this.sb != null) && (QLog.isDevelopLevel())) {
              this.sb.append("hidden_RecentUser ").append(i).append(",").append(localRecentUser.uin).append(";");
            }
          }
          break;
        }
        if (localRecentUser.lFlag == 16L)
        {
          if (this.app == null) {
            break label557;
          }
          jxl.a().a(this.app, localRecentUser);
          break;
        }
        if ((localRecentUser.getType() == 10005) && (this.app != null)) {
          aibe.a().a(this.app, localRecentUser);
        }
        break;
        if ((this.sb != null) && (QLog.isDevelopLevel()))
        {
          this.sb.append("]");
          QLog.i("Q.recent", 4, this.sb.toString());
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acqa
 * JD-Core Version:    0.7.0.1
 */