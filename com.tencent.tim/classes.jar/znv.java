import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class znv
  extends accg
{
  protected StringBuilder J;
  Comparator<RecentBaseData> mComparator = new znw(this);
  private ConcurrentHashMap<Integer, ArrayList<RecentBaseData>> mCurrentDataMap = new ConcurrentHashMap();
  
  public znv(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private List<RecentBaseData> h(List<RecentUser> paramList, List<RecentBaseData> paramList1)
  {
    int i;
    ArrayList localArrayList;
    int j;
    label18:
    Object localObject2;
    Object localObject1;
    int k;
    if (paramList == null)
    {
      i = 0;
      localArrayList = new ArrayList();
      j = 0;
      if (j >= i) {
        break label348;
      }
      RecentUser localRecentUser = (RecentUser)paramList.get(j);
      Object localObject3 = aajt.makeKey(localRecentUser.uin, localRecentUser.getType());
      localObject2 = aajt.a().a((String)localObject3);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = aaiv.a(localRecentUser, this.app, BaseApplicationImpl.getContext());
        if (localObject1 != null) {
          aajt.a().c((RecentBaseData)localObject1, (String)localObject3);
        }
      }
      if (localObject1 != null)
      {
        ((RecentBaseData)localObject1).c(this.app, BaseApplicationImpl.getContext());
        if ((((RecentBaseData)localObject1).wU() <= 0) || ((((RecentBaseData)localObject1).mUnreadFlag != 1) && (((RecentBaseData)localObject1).mUnreadFlag != 4))) {
          break label280;
        }
        k = ((RecentBaseData)localObject1).ng();
        if (k != 1) {
          break label254;
        }
        localObject2 = this.app.a(true).a(((RecentBaseData)localObject1).qx());
        if (localObject2 == null) {
          break label241;
        }
        localObject3 = ((ardq)this.app.getBusinessHandler(107)).a("");
        if ((!((HotChatInfo)localObject2).isGameRoom) && (!((HotChatInfo)localObject2).troopUin.equals(((aree)localObject3).cAg))) {
          break label241;
        }
      }
    }
    label280:
    for (;;)
    {
      j += 1;
      break label18;
      i = paramList.size();
      break;
      label241:
      localArrayList.add(localObject1);
      continue;
      label254:
      if ((k == 0) || (k == 3000))
      {
        localArrayList.add(localObject1);
        continue;
        if ((paramList1 != null) && (paramList1.size() > 0))
        {
          localObject2 = paramList1.iterator();
          while (((Iterator)localObject2).hasNext()) {
            if (((RecentBaseData)((Iterator)localObject2).next()).qx().equals(((RecentBaseData)localObject1).qx())) {
              localArrayList.add(localObject1);
            }
          }
        }
      }
    }
    label348:
    return localArrayList;
  }
  
  private void ho(List<RecentUser> paramList)
  {
    if (QLog.isDevelopLevel())
    {
      if (this.J == null) {
        this.J = new StringBuilder();
      }
      for (;;)
      {
        this.J.append("checkRUList, src[");
        localObject1 = paramList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (RecentUser)((Iterator)localObject1).next();
          this.J.append(((RecentUser)localObject2).uin + "|" + ((RecentUser)localObject2).getType() + ",");
        }
        this.J.setLength(0);
      }
      this.J.append("], [");
    }
    Object localObject1 = null;
    int i;
    int j;
    String str;
    if (paramList != null)
    {
      i = paramList.size() - 1;
      for (;;)
      {
        if (i >= 0)
        {
          localObject2 = (RecentUser)paramList.get(i);
          j = ((RecentUser)localObject2).getType();
          str = ((RecentUser)localObject2).uin;
          if (TextUtils.isEmpty(str))
          {
            paramList.remove(i);
            if (this.J != null)
            {
              this.J.append(i).append(",").append(((RecentUser)localObject2).getType()).append(";");
              i -= 1;
            }
          }
          else if ((j == 1) && ((((RecentUser)localObject2).lFlag & 1L) != 0L))
          {
            if ((localObject1 != null) || (this.app == null)) {
              break label483;
            }
          }
        }
      }
    }
    label483:
    for (Object localObject2 = this.app.a(true);; localObject2 = localObject1)
    {
      localObject1 = localObject2;
      if (localObject2 == null) {
        break;
      }
      localObject1 = localObject2;
      if (((HotChatManager)localObject2).kj(str)) {
        break;
      }
      paramList.remove(i);
      localObject1 = localObject2;
      if (this.J == null) {
        break;
      }
      this.J.append("invalide hotchat ").append(i).append(",").append(str).append(";");
      localObject1 = localObject2;
      break;
      if ((j == 3000) && (this.app != null))
      {
        localObject2 = ((acdu)this.app.getManager(53)).a(str);
        if ((localObject2 == null) || (((DiscussionInfo)localObject2).isUIControlFlag_Hidden_RecentUser()) || (((DiscussionInfo)localObject2).isHidden()))
        {
          paramList.remove(i);
          if (this.J != null) {
            this.J.append("hidden_RecentUser ").append(i).append(",").append(str).append(";");
          }
        }
      }
      break;
      if (this.J != null)
      {
        this.J.append("]");
        QLog.i("MiniMsgHandler", 4, this.J.toString());
      }
      return;
    }
  }
  
  private boolean ho(int paramInt)
  {
    boolean bool = false;
    if (paramInt == -2050) {
      bool = true;
    }
    return bool;
  }
  
  public void V(String paramString, int paramInt1, int paramInt2)
  {
    if (((paramInt1 == 1) || (paramInt1 == 0) || (paramInt1 == 3000)) && (!ho(paramInt2)))
    {
      znx.a().cqb();
      if (!TextUtils.isEmpty(paramString)) {
        znx.a().cK(paramString, paramInt1);
      }
    }
  }
  
  public List<RecentBaseData> c(int paramInt1, int paramInt2)
  {
    Object localObject2 = new ArrayList();
    List localList = this.app.a().a().q(false);
    for (;;)
    {
      try
      {
        Object localObject1 = (ArrayList)this.mCurrentDataMap.get(Integer.valueOf(paramInt1));
        if (localObject1 == null)
        {
          localObject1 = new ArrayList();
          ho(localList);
          if (paramInt2 != 1) {
            break label233;
          }
          localObject3 = localObject1;
          ((List)localObject2).addAll(h(localList, localObject3));
          Collections.sort((List)localObject2, this.mComparator);
          if (((List)localObject2).size() > 100)
          {
            localList = ((List)localObject2).subList(0, 100);
            localObject2 = localList;
          }
          continue;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          ((ArrayList)localObject1).clear();
          ((ArrayList)localObject1).addAll((Collection)localObject2);
          this.mCurrentDataMap.put(Integer.valueOf(paramInt1), localObject1);
          if (!QLog.isColorLevel()) {
            break label230;
          }
          localObject1 = new StringBuilder().append("initMsgCacheByIndex : resultDataList size = ").append(((List)localObject2).size()).append(",lastDatasize = ");
          if (localObject3 == null)
          {
            paramInt1 = 0;
            QLog.d("MiniMsgHandler", 2, paramInt1);
            return localObject2;
          }
          paramInt1 = localObject3.size();
          continue;
          localException1 = localException1;
        }
        catch (Exception localException2)
        {
          continue;
        }
        localException1.printStackTrace();
        return localObject2;
      }
      continue;
      label230:
      return localObject2;
      label233:
      Object localObject3 = null;
    }
  }
  
  public void cpW()
  {
    this.mCurrentDataMap.clear();
  }
  
  public void i(Integer paramInteger)
  {
    this.mCurrentDataMap.remove(paramInteger);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     znv
 * JD-Core Version:    0.7.0.1
 */