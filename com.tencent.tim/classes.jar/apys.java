import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.trooponline.data.TroopAllOnlineData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class apys
  implements Manager
{
  protected long asq;
  protected QQAppInterface mApp;
  private Map<String, apyq> nU = new ConcurrentHashMap();
  private Map<String, TroopAllOnlineData> nV = new ConcurrentHashMap();
  
  public apys(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public void Ue(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      this.nU.remove(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.i("TroopOnlineMemberManage", 1, "removeDetailOnlineData: e = " + paramString.toString());
    }
  }
  
  public void Uf(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = (apyq)this.nU.get(paramString);
    } while (paramString == null);
    paramString.IB = null;
    paramString.asp = NetConnInfoCenter.getServerTime();
  }
  
  public void a(String paramString1, List<apyr> paramList, int paramInt1, String paramString2, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 <= 0) {
      i = 10;
    }
    apyq localapyq2 = (apyq)this.nU.get(paramString1);
    apyq localapyq1 = localapyq2;
    if (localapyq2 == null)
    {
      localapyq1 = new apyq();
      this.nU.put(paramString1, localapyq1);
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      localapyq1.crO = paramString2;
      localapyq1.dXX = paramInt2;
    }
    if ((paramList != null) && (paramList.size() > 0)) {
      localapyq1.IB = paramList;
    }
    localapyq1.asp = (NetConnInfoCenter.getServerTime() + i);
  }
  
  public long aT(String paramString)
  {
    paramString = (apyq)this.nU.get(paramString);
    if (paramString != null) {}
    for (long l1 = paramString.asp;; l1 = 0L)
    {
      long l2 = l1;
      if (l1 <= 0L) {
        l2 = NetConnInfoCenter.getServerTime();
      }
      return l2;
    }
  }
  
  public long aU(String paramString)
  {
    paramString = (apyq)this.nU.get(paramString);
    if (paramString != null) {}
    for (long l1 = paramString.aso;; l1 = 0L)
    {
      long l2 = l1;
      if (l1 <= 0L) {
        l2 = NetConnInfoCenter.getServerTime();
      }
      return l2;
    }
  }
  
  public long aV(String paramString)
  {
    EntityManager localEntityManager = this.mApp.a().createEntityManager();
    paramString = (TroopAllOnlineData)localEntityManager.find(TroopAllOnlineData.class, paramString);
    localEntityManager.close();
    if (paramString != null) {}
    for (long l1 = paramString.nextReqTime;; l1 = 0L)
    {
      long l2 = l1;
      if (l1 <= 0L) {
        l2 = NetConnInfoCenter.getServerTime();
      }
      return l2;
    }
  }
  
  public long aW(String paramString)
  {
    paramString = (TroopAllOnlineData)this.nV.get(paramString);
    if (paramString != null) {}
    for (long l1 = paramString.nextReqTime;; l1 = 0L)
    {
      long l2 = l1;
      if (l1 <= 0L) {
        l2 = NetConnInfoCenter.getServerTime();
      }
      return l2;
    }
  }
  
  public List<apyr> bb(String paramString)
  {
    paramString = (apyq)this.nU.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.IB;
  }
  
  public List<String> bc(String paramString)
  {
    EntityManager localEntityManager = this.mApp.a().createEntityManager();
    paramString = (TroopAllOnlineData)localEntityManager.find(TroopAllOnlineData.class, paramString);
    localEntityManager.close();
    if (paramString == null) {
      return null;
    }
    return paramString.memberUinList;
  }
  
  public List<String> bd(String paramString)
  {
    paramString = (TroopAllOnlineData)this.nV.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.memberUinList;
  }
  
  public void c(String paramString, List<String> paramList, int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 10;
    }
    TroopAllOnlineData localTroopAllOnlineData = new TroopAllOnlineData();
    localTroopAllOnlineData.troopUin = paramString;
    localTroopAllOnlineData.memberUinList = paramList;
    localTroopAllOnlineData.nextReqTime = i;
    paramString = this.mApp.a().createEntityManager();
    paramString.persistOrReplace(localTroopAllOnlineData);
    paramString.close();
  }
  
  public void d(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    if (paramInt1 <= 0) {
      i = 10;
    }
    apyq localapyq2 = (apyq)this.nU.get(paramString1);
    apyq localapyq1 = localapyq2;
    if (localapyq2 == null)
    {
      localapyq1 = new apyq();
      this.nU.put(paramString1, localapyq1);
    }
    if ((i != 4) || (!TextUtils.isEmpty(paramString2)))
    {
      localapyq1.crO = paramString2;
      localapyq1.dXX = paramInt3;
    }
    localapyq1.aso = (NetConnInfoCenter.getServerTime() + i);
    if (paramInt2 != -1) {
      localapyq1.listType = paramInt2;
    }
  }
  
  public void d(String paramString, List<String> paramList, int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 10;
    }
    TroopAllOnlineData localTroopAllOnlineData2 = (TroopAllOnlineData)this.nV.get(paramString);
    TroopAllOnlineData localTroopAllOnlineData1 = localTroopAllOnlineData2;
    if (localTroopAllOnlineData2 == null)
    {
      localTroopAllOnlineData1 = new TroopAllOnlineData();
      this.nV.put(paramString, localTroopAllOnlineData1);
    }
    localTroopAllOnlineData1.troopUin = paramString;
    localTroopAllOnlineData1.memberUinList = paramList;
    localTroopAllOnlineData1.nextReqTime = (NetConnInfoCenter.getServerTime() + i);
  }
  
  public int eY(String paramString)
  {
    paramString = (apyq)this.nU.get(paramString);
    if ((paramString != null) && (paramString.listType > 0)) {
      return paramString.listType;
    }
    return 1;
  }
  
  public int eZ(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    paramString = (apyq)this.nU.get(paramString);
    if (paramString != null) {}
    for (int i = paramString.dXX;; i = 0) {
      return i;
    }
  }
  
  public long hA()
  {
    return this.asq;
  }
  
  public void lW(long paramLong)
  {
    this.asq = paramLong;
  }
  
  public String oU(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = "";
      return paramString;
    }
    TroopInfo localTroopInfo = ((TroopManager)this.mApp.getManager(52)).b(paramString);
    if (localTroopInfo != null) {}
    for (boolean bool = localTroopInfo.isKicked();; bool = true)
    {
      if (bool) {
        return "";
      }
      paramString = (apyq)this.nU.get(paramString);
      String str;
      if (paramString != null) {
        str = paramString.crO;
      }
      for (int i = paramString.dXX;; i = 0)
      {
        if (str == null) {
          return "";
        }
        paramString = str;
        if (localTroopInfo == null) {
          break;
        }
        paramString = str;
        if (localTroopInfo.wMemberNumClient <= 0) {
          break;
        }
        paramString = str;
        if (i <= localTroopInfo.wMemberNumClient) {
          break;
        }
        paramString = str;
        if (TextUtils.isEmpty(str)) {
          break;
        }
        str = str.replace(String.valueOf(i), String.valueOf(localTroopInfo.wMemberNumClient));
        paramString = str;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("TroopOnlineMemberManage", 2, String.format("getOnlineTip onlineCount: %s, memberNum: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(localTroopInfo.wMemberNumClient) }));
        return str;
        str = null;
      }
    }
  }
  
  public void onDestroy()
  {
    this.nU.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apys
 * JD-Core Version:    0.7.0.1
 */