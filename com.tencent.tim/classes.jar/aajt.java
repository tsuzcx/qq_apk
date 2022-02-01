import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class aajt
{
  private static aajt a;
  private static final Object mLock = new Object();
  public String bdn;
  private boolean bvV;
  public boolean bvW;
  private ConcurrentHashMap<String, RecentBaseData> dk = new ConcurrentHashMap(109);
  public final List<RecentBaseData> fl = new ArrayList(99);
  public List<RecentBaseData> vp;
  
  public static aajt a()
  {
    synchronized (mLock)
    {
      if (a == null) {
        a = new aajt();
      }
      return a;
    }
  }
  
  private void e(QQAppInterface paramQQAppInterface, List<RecentUser> paramList)
  {
    auvk.traceBegin("splitRecents");
    ArrayList localArrayList1 = new ArrayList(4);
    ArrayList localArrayList2 = new ArrayList(4);
    ArrayList localArrayList3 = new ArrayList(4);
    localArrayList1.add(paramQQAppInterface.getCurrentAccountUin());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      switch (localRecentUser.getType())
      {
      default: 
        break;
      case 0: 
        localArrayList1.add(localRecentUser.uin);
        break;
      case 1: 
        localArrayList2.add(localRecentUser.uin);
        break;
      case 3000: 
        localArrayList3.add(localRecentUser.uin);
      }
    }
    auvk.traceEnd();
    if (localArrayList1.size() > 2) {
      ((acff)paramQQAppInterface.getManager(51)).iG(localArrayList1);
    }
    if (localArrayList3.size() > 2) {
      ((acdu)paramQQAppInterface.getManager(53)).iG(localArrayList3);
    }
    if (localArrayList2.size() > 2) {
      ((TroopManager)paramQQAppInterface.getManager(52)).dM(localArrayList2);
    }
  }
  
  public static String makeKey(String paramString, int paramInt)
  {
    return paramString + "-" + paramInt;
  }
  
  public void Av(String paramString)
  {
    if ((this.dk != null) && (!TextUtils.isEmpty(paramString))) {
      this.dk.remove(paramString);
    }
  }
  
  public RecentBaseData a(String paramString)
  {
    try
    {
      if ((this.dk != null) && (!TextUtils.isEmpty(paramString)))
      {
        paramString = (RecentBaseData)this.dk.get(paramString);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, paramString.toString());
      }
    }
    return null;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("RecentDataListManager", 2, new Object[] { "preloadRecentBaseData, isPreloaded= ", Boolean.valueOf(this.bvV), ", forUI=", Boolean.valueOf(paramBoolean2), ", loadMore=", Boolean.valueOf(paramBoolean1) });
    }
    if (this.bvV) {
      return true;
    }
    if (paramBoolean2) {
      this.bvV = true;
    }
    if (paramQQAppInterface == null)
    {
      localObject1 = null;
      if (localObject1 == null) {
        break label576;
      }
    }
    label169:
    label435:
    label570:
    label576:
    for (Object localObject1 = ((acxw)localObject1).q(true);; localObject1 = null)
    {
      label107:
      int k;
      int j;
      Object localObject2;
      if (localObject1 == null)
      {
        i = 0;
        k = Math.min(10, i);
        if (k <= 0) {
          break label499;
        }
        if (!aako.L(paramQQAppInterface)) {
          e(paramQQAppInterface, (List)localObject1);
        }
        this.vp = new ArrayList(k);
        this.bdn = paramQQAppInterface.getCurrentUin();
        if (!aako.L(paramQQAppInterface)) {
          break label435;
        }
        i = 0;
        j = 0;
        if ((i >= ((List)localObject1).size()) || (i >= 10)) {
          break label289;
        }
        localObject2 = (RecentUser)((List)localObject1).get(i);
        RecentBaseData localRecentBaseData = aako.a(paramQQAppInterface, paramContext, (RecentUser)localObject2);
        if (localRecentBaseData == null) {
          break label264;
        }
        this.vp.add(localRecentBaseData);
        j += 1;
      }
      for (;;)
      {
        i += 1;
        break label169;
        localObject1 = paramQQAppInterface.a();
        break;
        i = ((List)localObject1).size();
        break label107;
        localObject2 = aaiv.a((RecentUser)localObject2, paramQQAppInterface, paramContext, true);
        this.vp.add(localObject2);
      }
      aako.gq(((List)localObject1).size(), ((List)localObject1).size() - j);
      QLog.d("RecentDataListManager", 1, new Object[] { "Recover from parcel, success size=", Integer.valueOf(j), " RU size=", Integer.valueOf(((List)localObject1).size()) });
      for (;;)
      {
        paramContext = new aajx(paramQQAppInterface);
        if ((paramQQAppInterface.isLogin()) && (Friends.isValidUin(paramQQAppInterface.getCurrentAccountUin()))) {
          paramContext.a(0, paramQQAppInterface.getCurrentAccountUin());
        }
        i = 0;
        while (i < k)
        {
          paramQQAppInterface = (RecentUser)((List)localObject1).get(i);
          if (paramQQAppInterface != null) {
            paramContext.a(paramQQAppInterface.getType(), paramQQAppInterface.uin);
          }
          i += 1;
        }
        aaiv.a((List)localObject1, paramQQAppInterface, paramContext, this.vp, k);
        QLog.d("RecentDataListManager", 1, new Object[] { "Recover from old way, success size= RU size=", Integer.valueOf(((List)localObject1).size()), " limit=", Integer.valueOf(k) });
      }
      this.bvW = true;
      label499:
      paramQQAppInterface = this.vp;
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder().append("preloadRecentBaseData end: ").append(this.bvV);
        if (paramQQAppInterface == null) {
          break label570;
        }
      }
      for (int i = paramQQAppInterface.size();; i = 0)
      {
        QLog.d("RecentDataListManager", 2, i);
        paramBoolean1 = bool;
        if (k > 0) {
          paramBoolean1 = true;
        }
        return paramBoolean1;
      }
    }
  }
  
  public void c(RecentBaseData paramRecentBaseData, String paramString)
  {
    if ((this.dk != null) && (!TextUtils.isEmpty(paramString)) && (paramRecentBaseData != null)) {
      this.dk.put(paramString, paramRecentBaseData);
    }
  }
  
  public void clearCache()
  {
    try
    {
      if (this.dk != null) {
        this.dk.clear();
      }
      if (this.fl != null) {
        this.fl.clear();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void u(List<RecentBaseData> paramList, String paramString)
  {
    this.vp = paramList;
    this.bdn = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aajt
 * JD-Core Version:    0.7.0.1
 */