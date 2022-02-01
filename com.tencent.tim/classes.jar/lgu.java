import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;

public class lgu
{
  private int aOK;
  private QQAppInterface app;
  private HashMap<String, ArrayList<String>> dI;
  private ArrayList<String> kB;
  private ArrayList<String> kC;
  private ArrayList<String> kD;
  private ArrayList<String> kE;
  private ArrayList<String> kF;
  private ArrayList<String> kG;
  private ArrayList<String> kH;
  private ArrayList<HashMap<String, String>> kI;
  private String mCurUin;
  private long timeStamp;
  
  private void a(String paramString, List<String> paramList, HashMap<String, String> paramHashMap)
  {
    if ((paramList == null) || (paramHashMap == null)) {}
    for (;;)
    {
      return;
      ArrayList localArrayList = new ArrayList();
      while (paramList.size() > 8)
      {
        List localList = paramList.subList(0, 8);
        paramList = paramList.subList(8, paramList.size());
        localArrayList.add(o(localList));
      }
      localArrayList.add(o(paramList));
      int k = localArrayList.size();
      int i = 0;
      while (i < k)
      {
        int j = 0;
        if ((j < 8) && (i + j < k))
        {
          int m = j + i;
          if (m == 0) {}
          for (paramList = paramString;; paramList = String.format("%s%d", new Object[] { paramString, Integer.valueOf(m) }))
          {
            paramHashMap.put(eI(paramList), localArrayList.get(m));
            j += 1;
            break;
          }
        }
        i += j;
      }
    }
  }
  
  private void aMd()
  {
    this.kI = new ArrayList();
    this.timeStamp = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put(eI("p_time_stamp"), eI(this.timeStamp + ""));
    localHashMap.put(eI("p_flag"), eI("1"));
    a("p_sp_care", this.kB, localHashMap);
    a("p_common_g", this.kC, localHashMap);
    a("p_common_d", this.kD, localHashMap);
    a("p_top_q", this.kE, localHashMap);
    a("p_top_g", this.kF, localHashMap);
    a("p_top_d", this.kG, localHashMap);
    this.kI.add(localHashMap);
    if ((this.aOK != cF()) || (lgs.a().ajZ))
    {
      l(this.dI);
      int k = this.kH.size();
      int i = 0;
      while (i < k)
      {
        localHashMap = new HashMap();
        localHashMap.put(eI("p_time_stamp"), eI(this.timeStamp + ""));
        int j = 0;
        while ((j < 8) && (i + j < k))
        {
          int m = j + i;
          localHashMap.put(eI("p_f_r" + m), eI((String)this.kH.get(m)));
          j += 1;
        }
        this.kI.add(localHashMap);
        i += j;
      }
      setFriendNum(this.aOK);
    }
  }
  
  private void aMe()
  {
    this.kB = new ArrayList();
    this.kC = new ArrayList();
    this.kD = new ArrayList();
    this.kE = new ArrayList();
    this.kF = new ArrayList();
    this.kG = new ArrayList();
    this.dI = new HashMap();
    this.kH = new ArrayList();
    this.mCurUin = this.app.getCurrentUin();
  }
  
  private void aMf()
  {
    Object localObject1 = this.app.a().a();
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      localObject1 = ((acxw)localObject1).q(false);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (RecentUser)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = aajt.makeKey(((RecentUser)localObject2).uin, ((RecentUser)localObject2).getType());
            localObject2 = aajt.a().a((String)localObject2);
            if ((localObject2 != null) && ((((RecentBaseData)localObject2).mMenuFlag & 0xF0) == 32)) {
              if (((RecentBaseData)localObject2).ng() == 1) {
                this.kF.add(((RecentBaseData)localObject2).qx());
              } else if (((RecentBaseData)localObject2).ng() == 3000) {
                this.kG.add(((RecentBaseData)localObject2).qx());
              } else if (((RecentBaseData)localObject2).ng() == 0) {
                this.kE.add(((RecentBaseData)localObject2).qx());
              }
            }
          }
        }
      }
    }
  }
  
  private void aMg()
  {
    aMh();
    aMi();
  }
  
  private void aMh()
  {
    TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
    if (localTroopManager == null) {}
    for (;;)
    {
      return;
      Object localObject1 = localTroopManager.eg();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (CommonlyUsedTroop)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = localTroopManager.b(((CommonlyUsedTroop)localObject2).troopUin);
            if (localObject2 != null) {
              this.kC.add(((TroopInfo)localObject2).troopuin);
            }
          }
        }
      }
    }
  }
  
  private void aMi()
  {
    Object localObject1 = (acdu)this.app.getManager(53);
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      localObject1 = (List)((acdu)localObject1).getDiscussList().clone();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Entity)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = (DiscussionInfo)localObject2;
            if (((DiscussionInfo)localObject2).hasCollect) {
              this.kD.add(((DiscussionInfo)localObject2).uin);
            }
          }
        }
      }
    }
  }
  
  private void aMj()
  {
    acff localacff = (acff)this.app.getManager(51);
    if (localacff != null)
    {
      localObject1 = localacff.cp();
      if ((localObject1 != null) && (((List)localObject1).size() != 0)) {}
    }
    else
    {
      return;
    }
    Object localObject1 = ((List)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Entity)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = (Groups)localObject2;
        ArrayList localArrayList = localacff.B(String.valueOf(((Groups)localObject2).group_id));
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          Object localObject3 = new ArrayList(localArrayList);
          int j = ((List)localObject3).size();
          localArrayList = new ArrayList(((List)localObject3).size());
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            Entity localEntity = (Entity)((Iterator)localObject3).next();
            if (localEntity != null)
            {
              Friends localFriends = (Friends)localEntity;
              localArrayList.add(((Friends)localEntity).uin);
              if (localacff.a(localFriends.uin) != null) {
                this.kB.add(localFriends.uin);
              }
            }
          }
          this.dI.put(((Groups)localObject2).group_name, localArrayList);
          i += j;
        }
      }
    }
    this.aOK = i;
  }
  
  private long cF()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {}
    do
    {
      return 0L;
      localObject = awit.a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    return ((SharedPreferences)localObject).getLong("event_simple_p_info_f_num2", 0L);
  }
  
  private void clear()
  {
    this.kB = null;
    this.kC = null;
    this.kD = null;
    this.kE = null;
    this.kF = null;
    this.kG = null;
    this.dI = null;
    this.kH = null;
    this.aOK = 0;
  }
  
  public static String eH(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return atad.toMD5(paramString);
  }
  
  private String eI(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return Base64.encodeToString(paramString.getBytes(), 3);
  }
  
  private void ie()
  {
    aMe();
    aMj();
    aMg();
    aMf();
    aMd();
    clear();
  }
  
  private void l(HashMap<String, ArrayList<String>> paramHashMap)
  {
    Iterator localIterator1 = paramHashMap.keySet().iterator();
    StringBuilder localStringBuilder;
    int i;
    label69:
    String str2;
    if (localIterator1.hasNext())
    {
      String str1 = (String)localIterator1.next();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1).append(':');
      Iterator localIterator2 = ((ArrayList)paramHashMap.get(str1)).iterator();
      i = 0;
      if (localIterator2.hasNext())
      {
        str2 = (String)localIterator2.next();
        if (i < 8) {
          break label169;
        }
        this.kH.add(localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str1).append(':');
        i = 0;
      }
    }
    label169:
    for (;;)
    {
      localStringBuilder.append(eH(str2)).append('^');
      i += 1;
      break label69;
      this.kH.add(localStringBuilder.toString());
      break;
      return;
    }
  }
  
  private String o(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localStringBuilder.append(eH((String)paramList.next())).append('^');
    }
    return eI(localStringBuilder.toString());
  }
  
  private void qV(int paramInt)
  {
    if (paramInt < this.kI.size())
    {
      HashMap localHashMap = (HashMap)this.kI.get(paramInt);
      anpc.a(null).collectPerformance(this.mCurUin, "event_simple_p_info", false, 1000L, 1000L, localHashMap, null);
    }
  }
  
  private void setFriendNum(int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {}
    do
    {
      return;
      localObject = awit.a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("event_simple_p_info_f_num2", paramInt);
    awit.a((SharedPreferences.Editor)localObject, true);
  }
  
  public void T(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    this.app = paramQQAppInterface;
    ie();
    if (this.kI != null)
    {
      int i = 0;
      for (;;)
      {
        if (i < this.kI.size())
        {
          qV(i);
          try
          {
            Thread.sleep(1000L);
            i += 1;
          }
          catch (Exception paramQQAppInterface)
          {
            for (;;)
            {
              paramQQAppInterface.printStackTrace();
            }
          }
        }
      }
    }
    this.kI = null;
    this.app = null;
    this.mCurUin = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lgu
 * JD-Core Version:    0.7.0.1
 */