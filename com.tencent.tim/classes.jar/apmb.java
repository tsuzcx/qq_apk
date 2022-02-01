import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.troop.honor.TroopHonorManager.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.oidb.oidb_0xdc9.oidb_0xdc9.HonorList;
import tencent.im.troop.honor.troop_honor.HonorChangeGrayTipsReserved;
import tencent.im.troop.honor.troop_honor.UserHonor;

public class apmb
  implements Manager
{
  private apme a;
  private boolean cRk;
  private QQAppInterface mApp;
  private EntityManager mEntityManager;
  
  public apmb(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mEntityManager = paramQQAppInterface.a().createEntityManager();
    this.a = new apme();
    ThreadManager.getSubThreadHandler().post(new TroopHonorManager.1(this));
  }
  
  public void a(apme paramapme, boolean paramBoolean)
  {
    if (paramapme == null) {}
    for (;;)
    {
      try
      {
        QLog.d("TroopHonor.manager", 1, "updateConfig, config == null");
        return;
      }
      finally {}
      if ((paramBoolean) && (this.cRk))
      {
        QLog.d("TroopHonor.manager", 1, "had init config");
      }
      else
      {
        this.cRk = true;
        this.a = paramapme;
        if (QLog.isColorLevel()) {
          QLog.d("TroopHonor.manager", 2, String.format("updateConfig, isInit: %s, config: %s", new Object[] { Boolean.valueOf(paramBoolean), paramapme }));
        }
        if (!paramBoolean) {
          ((acms)this.mApp.getBusinessHandler(20)).notifyUI(80, true, null);
        }
      }
    }
  }
  
  public boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntity.getStatus() == 1000)
    {
      this.mEntityManager.persistOrReplace(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return bool;
    }
    return this.mEntityManager.update(paramEntity);
  }
  
  public void aF(String paramString, boolean paramBoolean)
  {
    TroopManager localTroopManager = (TroopManager)this.mApp.getManager(52);
    TroopInfo localTroopInfo = localTroopManager.c(paramString);
    if (localTroopInfo == null) {
      QLog.d("TroopHonor.manager", 1, "updateTroopHonorAIOSwitch troopInfo is null");
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopHonor.manager", 2, String.format("updateTroopHonorAIOSwitch, troopUin: %s, isOpen: %s, old: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(localTroopInfo.isTroopHonorOpen()) }));
      }
    } while (!(localTroopInfo.isTroopHonorOpen() ^ paramBoolean));
    if (paramBoolean) {}
    for (localTroopInfo.dwGroupFlagExt3 &= 0xFDFFFFFF;; localTroopInfo.dwGroupFlagExt3 |= 0x2000000)
    {
      localTroopManager.i(localTroopInfo);
      return;
    }
  }
  
  public List<apmd> aX(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = apmc.aY(paramString);
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        Object localObject = (Integer)paramString.next();
        localObject = this.a.a(((Integer)localObject).intValue());
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public void ba(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    TroopManager localTroopManager;
    Object localObject;
    do
    {
      return;
      localTroopManager = (TroopManager)this.mApp.getManager(52);
      TroopMemberInfo localTroopMemberInfo = localTroopManager.b(paramString1, paramString2);
      if (this.mApp.getCurrentAccountUin().equals(paramString2))
      {
        localObject = localTroopManager.c(paramString1);
        if ((localObject != null) && (paramString3 != null) && (!paramString3.equals(((TroopInfo)localObject).myHonorList)))
        {
          ((TroopInfo)localObject).myHonorList = paramString3;
          localTroopManager.i((TroopInfo)localObject);
        }
      }
      localObject = localTroopMemberInfo;
      if (localTroopMemberInfo == null)
      {
        localObject = localTroopMemberInfo;
        if (!TextUtils.isEmpty(paramString3))
        {
          localObject = new TroopMemberInfo();
          ((TroopMemberInfo)localObject).memberuin = paramString2;
          ((TroopMemberInfo)localObject).troopuin = paramString1;
        }
      }
    } while ((localObject == null) || (paramString3.equals(((TroopMemberInfo)localObject).honorList)));
    if (QLog.isColorLevel()) {
      QLog.d("TroopHonor.manager", 2, String.format("updateTroopMemberHonor troopUin: %s, memberUin: %s, newHonorList: %s, oldHonorList: %s", new Object[] { paramString1, paramString2, paramString3, ((TroopMemberInfo)localObject).honorList }));
    }
    ((TroopMemberInfo)localObject).honorList = paramString3;
    if (((TroopMemberInfo)localObject).getStatus() == 1000) {
      localTroopManager.a(paramString1, paramString2, (TroopMemberInfo)localObject);
    }
    localTroopManager.b(paramString1, paramString2, (TroopMemberInfo)localObject);
  }
  
  public void c(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    for (;;)
    {
      try
      {
        Object localObject = new troop_honor.HonorChangeGrayTipsReserved();
        ((troop_honor.HonorChangeGrayTipsReserved)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = ((troop_honor.HonorChangeGrayTipsReserved)localObject).user_honor.get();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
        {
          localObject = paramArrayOfByte.iterator();
          if (((Iterator)localObject).hasNext())
          {
            paramArrayOfByte = (troop_honor.UserHonor)((Iterator)localObject).next();
            String str = String.valueOf(paramArrayOfByte.uin.get());
            if (!paramArrayOfByte.id.has()) {
              break label224;
            }
            paramArrayOfByte = paramArrayOfByte.id.get();
            ba(paramString, str, apmc.S(paramArrayOfByte));
            if ((!TextUtils.isEmpty(str)) && (str.equals(this.mApp.getCurrentAccountUin()))) {
              ((acms)this.mApp.getBusinessHandler(20)).notifyUI(80, true, new Object[] { paramString, str });
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("TroopHonor.push", 2, String.format("updatePushTroopHonor, pushType: %s, troopUin: %s, memberUin: %s, ids: %s", new Object[] { Integer.valueOf(paramInt), paramString, str, paramArrayOfByte }));
            continue;
          }
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramString)
      {
        paramString.printStackTrace();
        QLog.d("TroopHonor.manager", 1, "updatePushTroopHonor", paramString);
      }
      label224:
      paramArrayOfByte = null;
    }
  }
  
  public List<apmd> i(String paramString1, String paramString2)
  {
    if (!qD(paramString1)) {
      return null;
    }
    Object localObject = ((TroopManager)this.mApp.getManager(52)).b(paramString1, paramString2);
    if (localObject != null) {}
    for (localObject = aX(((TroopMemberInfo)localObject).honorList);; localObject = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopHonor.manager", 2, String.format("getTroopHonorList, troopUin: %s, memberUin: %s, honorList: %s", new Object[] { paramString1, paramString2, localObject }));
      }
      return localObject;
    }
  }
  
  public void mQ(List<oidb_0xdc9.HonorList> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      QLog.d("TroopHonor.manager", 1, "updateHostHonorList| honorList is empty!");
    }
    StringBuilder localStringBuilder;
    label390:
    do
    {
      return;
      TroopManager localTroopManager = (TroopManager)this.mApp.getManager(52);
      localStringBuilder = new StringBuilder();
      String str1 = this.mApp.getCurrentAccountUin();
      if (TextUtils.isEmpty(str1))
      {
        QLog.d("TroopHonor.manager", 1, "updateHostHonorList memberUin is empty");
        return;
      }
      EntityTransaction localEntityTransaction = this.mEntityManager.getTransaction();
      localEntityTransaction.begin();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (oidb_0xdc9.HonorList)localIterator.next();
        String str2 = String.valueOf(paramList.group_id.get());
        if (paramList.is_gray.has()) {}
        for (int i = paramList.is_gray.get();; i = 0)
        {
          List localList = paramList.id.get();
          String str3 = apmc.S(localList);
          localStringBuilder.append(str2).append(": ").append(str3).append("\n");
          if (TextUtils.isEmpty(str2)) {
            break label390;
          }
          paramList = localTroopManager.c(str2);
          if (paramList != null)
          {
            paramList.troopHonorGrayFlag = i;
            a(paramList);
            if (QLog.isColorLevel()) {
              QLog.d("TroopHonor.manager", 2, String.format("updateHostHonorList| update troopUin: %s, troopHonorGrayFlag: %s", new Object[] { str2, Integer.valueOf(i) }));
            }
          }
          TroopMemberInfo localTroopMemberInfo = localTroopManager.b(str2, str1);
          paramList = localTroopMemberInfo;
          if (localTroopMemberInfo == null)
          {
            paramList = localTroopMemberInfo;
            if (!TextUtils.isEmpty(str3))
            {
              paramList = new TroopMemberInfo();
              paramList.memberuin = this.mApp.getCurrentAccountUin();
              paramList.troopuin = str2;
            }
          }
          if (paramList == null) {
            break;
          }
          paramList.honorList = str3;
          if (paramList.getStatus() == 1000) {
            localTroopManager.a(str2, str1, paramList);
          }
          boolean bool = a(paramList);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("TroopHonor.manager", 2, String.format("updateHostHonorList| update host memberInfo, troopUin: %s, honorList: %s, result: %s", new Object[] { str2, localList, Boolean.valueOf(bool) }));
          break;
        }
        QLog.d("TroopHonor.manager", 1, String.format("updateHostHonorList| troopUin is empty", new Object[0]));
      }
      localEntityTransaction.commit();
      localEntityTransaction.end();
    } while (!QLog.isColorLevel());
    QLog.d("TroopHonor.manager", 2, "updateHostHonorList, " + localStringBuilder.toString());
  }
  
  public void onDestroy()
  {
    this.mEntityManager.close();
  }
  
  public boolean qC(String paramString)
  {
    if ((this.a != null) && (this.a.bUc)) {}
    for (int i = 1;; i = 0)
    {
      TroopManager localTroopManager = (TroopManager)this.mApp.getManager(52);
      if (i == 0)
      {
        paramString = localTroopManager.c(paramString);
        if ((paramString == null) || (paramString.troopHonorGrayFlag != 1)) {
          break;
        }
      }
      return true;
    }
    return false;
  }
  
  public boolean qD(String paramString)
  {
    boolean bool5 = false;
    boolean bool2;
    TroopManager localTroopManager;
    boolean bool1;
    if ((this.a != null) && (this.a.bUc))
    {
      bool2 = true;
      localTroopManager = (TroopManager)this.mApp.getManager(52);
      if (bool2) {
        break label240;
      }
      TroopInfo localTroopInfo = localTroopManager.c(paramString);
      if ((localTroopInfo == null) || (localTroopInfo.troopHonorGrayFlag != 1)) {
        break label223;
      }
      bool1 = true;
    }
    for (;;)
    {
      label64:
      paramString = localTroopManager.c(paramString);
      boolean bool3;
      label91:
      boolean bool6;
      if ((paramString != null) && ((paramString.dwGroupFlagExt3 & 0x2000000) == 0L))
      {
        bool3 = true;
        bool6 = anlm.ayn();
        if (QLog.isColorLevel()) {
          QLog.d("TroopHonor.manager", 2, String.format("isSupportTroopHonor, isGlobalOpen: %s, isGrayTroop: %s, isAIOOpen: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3) }));
        }
        paramString = (acff)this.mApp.getManager(51);
        if (paramString == null) {
          break label234;
        }
        paramString = paramString.c(this.mApp.getCurrentUin());
        if (paramString == null) {
          break label234;
        }
      }
      label223:
      label234:
      for (boolean bool4 = paramString.troopHonorSwitch;; bool4 = false)
      {
        if (!bool2)
        {
          bool2 = bool5;
          if (!bool1) {}
        }
        else
        {
          bool2 = bool5;
          if (bool3)
          {
            bool2 = bool5;
            if (!bool6)
            {
              bool2 = bool5;
              if (bool4) {
                bool2 = true;
              }
            }
          }
        }
        return bool2;
        bool2 = false;
        break;
        bool1 = false;
        break label64;
        bool3 = false;
        break label91;
      }
      label240:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apmb
 * JD-Core Version:    0.7.0.1
 */