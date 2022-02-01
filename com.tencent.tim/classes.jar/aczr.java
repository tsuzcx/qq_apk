import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.Setting;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class aczr
  implements Manager
{
  private long beginTime = -1L;
  private ConcurrentHashMap<String, aczr.b> eC;
  private ConcurrentHashMap<String, String> eD;
  private long endTime = -1L;
  private QQAppInterface mApp;
  
  public aczr(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.eC = new ConcurrentHashMap(0);
    this.eD = new ConcurrentHashMap(0);
    cPp();
  }
  
  private void Gi(String paramString)
  {
    Object localObject1 = this.mApp.getQQHeadSetting(5, paramString, 0);
    int j;
    int i;
    if ((localObject1 != null) && (((Pair)localObject1).second != null))
    {
      localObject1 = (Setting)((Pair)localObject1).second;
      j = ((Setting)localObject1).systemHeadID;
      i = ((Setting)localObject1).bHeadType;
    }
    for (;;)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("ClassicHeadActivityManager", 2, " QQ 18 handle handleUpdateStrangerHeadReal uin=" + paramString + ",localHeadID=" + j + ",localType=" + i);
        localObject1 = new StringBuilder(1000);
        localObject2 = this.eC.entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
          ((StringBuilder)localObject1).append(" QQ 18 handle mHeadIdMap: uin=");
          ((StringBuilder)localObject1).append((String)localEntry.getKey());
          ((StringBuilder)localObject1).append(",headid=");
          ((StringBuilder)localObject1).append(((aczr.b)localEntry.getValue()).cAO);
          ((StringBuilder)localObject1).append(",type=");
          ((StringBuilder)localObject1).append(((aczr.b)localEntry.getValue()).cAP);
          ((StringBuilder)localObject1).append(",isRequest=");
          ((StringBuilder)localObject1).append(((aczr.b)localEntry.getValue()).Od);
          ((StringBuilder)localObject1).append(",saveTime=");
          ((StringBuilder)localObject1).append(((aczr.b)localEntry.getValue()).saveTime);
          ((StringBuilder)localObject1).append("\n");
          QLog.d("ClassicHeadActivityManager", 2, ((StringBuilder)localObject1).toString());
        }
      }
      if (this.eC.containsKey(paramString))
      {
        localObject1 = (aczr.b)this.eC.get(paramString);
        if (localObject1 != null)
        {
          int k = ((aczr.b)localObject1).cAO;
          int m = ((aczr.b)localObject1).cAP;
          if (((m == 0) && (k != j)) || ((m != i) && (!((aczr.b)localObject1).Od)))
          {
            ((aczr.b)localObject1).Od = true;
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder(1000);
              ((StringBuilder)localObject2).append("QQ 18 get and update stranger update head uin = ");
              ((StringBuilder)localObject2).append(paramString);
              ((StringBuilder)localObject2).append(",receiveSysid = ");
              ((StringBuilder)localObject2).append(k);
              ((StringBuilder)localObject2).append(",receiveType = ");
              ((StringBuilder)localObject2).append(m);
              ((StringBuilder)localObject2).append(",localSysid = ");
              ((StringBuilder)localObject2).append(j);
              ((StringBuilder)localObject2).append(",loaclType = ");
              ((StringBuilder)localObject2).append(i);
              ((StringBuilder)localObject2).append("\n");
              QLog.d("ClassicHeadActivityManager", 2, ((StringBuilder)localObject2).toString());
            }
            ((FriendListHandler)this.mApp.getBusinessHandler(1)).DH(paramString);
            this.eC.put(paramString, localObject1);
          }
          if ((k == j) && (m == i) && (((aczr.b)localObject1).Od))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ClassicHeadActivityManager", 4, " QQ 18 remove update map uin = " + paramString + ",receiveSysid = " + k + ",localSysid = " + j);
            }
            this.eC.remove(paramString);
          }
        }
      }
      return;
      i = 0;
      j = 0;
    }
  }
  
  public void Gg(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.eC != null) && (this.eC.containsKey(paramString)))
    {
      aczr.b localb = (aczr.b)this.eC.get(paramString);
      if ((localb != null) && (localb.Od))
      {
        QLog.d("ClassicHeadActivityManager", 2, " QQ 18 handle handleGetHeadError uin=" + paramString + ",HeadID=" + localb.cAO + ",Type=" + localb.cAP + ",IsRequest=" + localb.Od);
        this.eC.remove(paramString);
      }
    }
  }
  
  public void Gh(String paramString)
  {
    if ((this.mApp == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("ClassicHeadActivityManager", 2, " QQ 18 handleUpdateStrangerHead strangerUin = " + paramString);
          }
          String str = this.mApp.getCurrentAccountUin();
          if (!str.equals(paramString)) {
            break;
          }
          if ((this.eC != null) && (this.eC.containsKey(str))) {
            this.eC.remove(str);
          }
        } while (!QLog.isColorLevel());
        QLog.d("ClassicHeadActivityManager", 2, " QQ 18 handleUpdateStrangerHead remove current user ");
        return;
        if ((this.mApp.a == null) || (!this.mApp.a.He())) {
          break;
        }
      } while ((this.eD == null) || (this.eD.containsKey(paramString)));
      this.eD.put(paramString, "");
      return;
    } while ((this.eC == null) || (this.eC.size() <= 0));
    Gi(paramString);
  }
  
  public Setting a()
  {
    Object localObject = this.mApp.getCurrentAccountUin();
    localObject = this.mApp.getQQHeadSetting(1, (String)localObject, 0);
    if ((localObject != null) && (((Pair)localObject).second != null)) {
      return (Setting)((Pair)localObject).second;
    }
    return null;
  }
  
  public void a(aczr.a parama)
  {
    StringBuilder localStringBuilder;
    FriendListHandler localFriendListHandler;
    Object localObject;
    if ((adh()) && (parama != null))
    {
      localStringBuilder = new StringBuilder("handleFriendHeadFlagItem");
      localStringBuilder.append(" uin=").append(aqmr.getSimpleUinForPrint(parama.friendUin));
      localStringBuilder.append(" sysId=").append(parama.RM);
      localStringBuilder.append(" headType=").append(parama.RN);
      localStringBuilder.append(" qq18Switch=").append(parama.RL);
      if ((!TextUtils.isEmpty(parama.friendUin)) && (parama.friendUin.equals(this.mApp.getCurrentAccountUin())) && (parama.RL != -1L)) {
        ir(parama.RL);
      }
      localFriendListHandler = (FriendListHandler)this.mApp.getBusinessHandler(1);
      localObject = this.mApp.getQQHeadSetting(1, parama.friendUin, 0);
      if ((localObject == null) || (!((Boolean)((Pair)localObject).first).booleanValue())) {
        break label219;
      }
      localFriendListHandler.DH(parama.friendUin);
      localFriendListHandler.notifyUI(3, true, parama.friendUin);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClassicHeadActivityManager", 2, localStringBuilder.toString());
      }
      return;
      label219:
      if ((localObject != null) && (((Pair)localObject).second != null))
      {
        localObject = (Setting)((Pair)localObject).second;
        long l1 = ((Setting)localObject).systemHeadID;
        long l2 = ((Setting)localObject).bHeadType;
        localStringBuilder.append(" localsysId=").append(l1);
        localStringBuilder.append(" localheadType=").append(l2);
        if (((parama.RL == 1L) && (parama.RN != -1L) && (parama.RN != l2)) || ((parama.RM != -1L) && (parama.RM != l1) && (l2 == 0L)))
        {
          localStringBuilder.append(" fetch userHead");
          localFriendListHandler.DH(parama.friendUin);
          localFriendListHandler.notifyUI(3, true, parama.friendUin);
        }
      }
    }
  }
  
  public boolean adh()
  {
    long l = anaz.gQ() * 1000L;
    if ((this.beginTime != -1L) && (this.endTime != -1L) && (l > this.beginTime) && (l < this.endTime))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClassicHeadActivityManager", 2, "ClassicHeadActivityActivate is activate");
      }
      return true;
    }
    return false;
  }
  
  public void ag(String paramString, int paramInt1, int paramInt2)
  {
    int i = 0;
    Object localObject;
    int j;
    if ((!TextUtils.isEmpty(paramString)) && (this.mApp != null))
    {
      localObject = this.mApp.getQQHeadSetting(5, paramString, 0);
      if ((localObject == null) || (((Pair)localObject).second == null)) {
        break label350;
      }
      localObject = (Setting)((Pair)localObject).second;
      j = ((Setting)localObject).systemHeadID;
      i = ((Setting)localObject).bHeadType;
    }
    for (;;)
    {
      if ((paramInt1 == j) && (paramInt2 == i)) {
        if (this.eC.containsKey(paramString))
        {
          this.eC.remove(paramString);
          if (QLog.isColorLevel()) {
            QLog.d("ClassicHeadActivityManager", 2, " QQ 18 saveReceiveSysHeadId found same, remove uin=" + paramString + ", syid=" + paramInt1 + ",headType=" + paramInt2);
          }
        }
      }
      do
      {
        do
        {
          aczr.b localb;
          do
          {
            do
            {
              return;
              localObject = new aczr.b(paramString, paramInt1, paramInt2);
              if (this.eC.containsKey(paramString)) {
                break;
              }
              this.eC.put(paramString, localObject);
            } while (!QLog.isColorLevel());
            QLog.d("ClassicHeadActivityManager", 2, " QQ 18 saveReceiveSysHeadId save uin=" + paramString + ", syid=" + paramInt1 + ",headType=" + paramInt2);
            return;
            localb = (aczr.b)this.eC.get(paramString);
          } while (localb == null);
          i = localb.cAO;
          j = localb.cAP;
        } while (((paramInt2 != 0) || (paramInt1 == i)) && (j == paramInt2));
        this.eC.put(paramString, localObject);
      } while (!QLog.isColorLevel());
      QLog.d("ClassicHeadActivityManager", 2, " QQ 18 saveReceiveSysHeadId save uin=" + paramString + ", syid=" + paramInt1 + ",headType=" + paramInt2);
      return;
      label350:
      j = 0;
    }
  }
  
  public void cPp()
  {
    Object localObject = aqmj.S(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject != null) && (localObject.length == 2))
      {
        this.beginTime = aduc.ah(localObject[0]);
        this.endTime = aduc.ah(localObject[1]);
        if (QLog.isColorLevel()) {
          QLog.d("ClassicHeadActivityManager", 2, "parseClassicHeadActivityConfig success");
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClassicHeadActivityManager", 2, "parseClassicHeadActivityConfig beginTime=" + this.beginTime + " endTime=" + this.endTime);
    }
  }
  
  public void cPq()
  {
    if ((this.eD != null) && (this.eD.size() > 0))
    {
      Iterator localIterator = this.eD.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (QLog.isColorLevel()) {
          QLog.d("ClassicHeadActivityManager", 2, " QQ 18 handle actionB cached stranger head uin = " + (String)localEntry.getKey());
        }
        Gi((String)localEntry.getKey());
      }
      this.eD.clear();
      if (QLog.isColorLevel()) {
        QLog.d("ClassicHeadActivityManager", 2, " QQ 18 handle actionB cached stranger head update finished");
      }
    }
  }
  
  public long fl()
  {
    long l = PreferenceManager.getDefaultSharedPreferences(this.mApp.getApp()).getLong("classic_head_activity_switch_" + this.mApp.getCurrentUin(), -1L);
    if (QLog.isColorLevel()) {
      QLog.d("ClassicHeadActivityManager", 2, "getSwitch key=classic_head_activity_switch value= " + l);
    }
    return l;
  }
  
  public void ir(long paramLong)
  {
    String str = this.mApp.getCurrentAccountUin();
    long l = fl();
    if (l != paramLong)
    {
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.mApp.getApp()).edit();
      localEditor.putLong("classic_head_activity_switch_" + str, paramLong);
      localEditor.commit();
      if (QLog.isColorLevel()) {
        QLog.d("ClassicHeadActivityManager", 2, "save Switch Success");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClassicHeadActivityManager", 2, "qq18Switch=" + paramLong + " localSwitch=" + l);
    }
  }
  
  public void onDestroy()
  {
    this.eC.clear();
    this.eD.clear();
    this.eC = null;
    this.eD = null;
  }
  
  public void r(long paramLong1, long paramLong2, long paramLong3)
  {
    if ((this.mApp.getApp() == null) && (this.mApp.getCurrentUin() == null)) {}
    for (;;)
    {
      return;
      StringBuilder localStringBuilder = new StringBuilder("handleInitValue");
      localStringBuilder.append(" sysId=").append(paramLong1);
      localStringBuilder.append(" headType=").append(paramLong2);
      localStringBuilder.append(" qq18Switch=").append(paramLong3);
      String str = this.mApp.getCurrentAccountUin();
      ir(paramLong3);
      if (paramLong3 == 1L)
      {
        FriendListHandler localFriendListHandler = (FriendListHandler)this.mApp.getBusinessHandler(1);
        Object localObject = this.mApp.getQQHeadSetting(1, str, 0);
        if ((localObject != null) && (((Boolean)((Pair)localObject).first).booleanValue()))
        {
          localFriendListHandler.DH(str);
          localFriendListHandler.notifyUI(3, true, str);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("ClassicHeadActivityManager", 2, localStringBuilder.toString());
          return;
          if ((localObject != null) && (((Pair)localObject).second != null))
          {
            localObject = (Setting)((Pair)localObject).second;
            paramLong3 = ((Setting)localObject).systemHeadID;
            long l = ((Setting)localObject).bHeadType;
            localStringBuilder.append(" localSysId=").append(paramLong3);
            localStringBuilder.append(" localheadType=").append(l);
            if ((paramLong2 != l) || ((paramLong2 == 0L) && (paramLong1 != paramLong3)))
            {
              localStringBuilder.append(" fetch userHead");
              localFriendListHandler.DH(str);
              localFriendListHandler.notifyUI(3, true, str);
            }
          }
        }
      }
    }
  }
  
  public static class a
  {
    public long RL = -1L;
    public long RM = -1L;
    public long RN = -1L;
    public String friendUin;
    
    public a(long paramLong)
    {
      this.friendUin = Long.toString(paramLong);
    }
    
    public void clearData()
    {
      this.friendUin = null;
      this.RL = -1L;
      this.RN = -1L;
      this.RM = -1L;
    }
  }
  
  public static class b
  {
    public boolean Od;
    public int cAO;
    public int cAP;
    public long saveTime;
    public String uin;
    
    public b(String paramString, int paramInt1, int paramInt2)
    {
      this.uin = paramString;
      this.cAO = paramInt1;
      this.cAP = paramInt2;
      this.Od = false;
      this.saveTime = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aczr
 * JD-Core Version:    0.7.0.1
 */