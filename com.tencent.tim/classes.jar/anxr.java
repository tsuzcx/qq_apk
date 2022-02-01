import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager.1;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager.2;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager.3;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class anxr
  implements Manager
{
  ArrayList<SubAccountInfo> Bb = new ArrayList();
  private boolean cKy = true;
  EntityManager em;
  Lock lock = new ReentrantLock();
  private QQAppInterface mApp;
  public HashMap<String, ArrayList<SubAccountMessage>> nH = new HashMap();
  
  public anxr(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.em = paramQQAppInterface.a().createEntityManager();
    List localList = this.em.query(SubAccountInfo.class);
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("initSubAccountInfos() uin=").append(paramQQAppInterface.getCurrentAccountUin()).append(" result=");
      if (localList == null)
      {
        localObject = null;
        QLog.d("SUB_ACCOUNT", 2, localObject);
      }
    }
    else
    {
      if ((localList != null) && (localList.size() != 0)) {
        break label148;
      }
    }
    label148:
    do
    {
      return;
      localObject = Integer.valueOf(localList.size());
      break;
      this.Bb.clear();
      this.Bb.addAll(localList);
      dTJ();
      this.cKy = SettingCloneUtil.readValue(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), null, "qqsetting_subaccount_notify", true);
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, new Object[] { "NotifySwitch ", Boolean.valueOf(this.cKy) });
  }
  
  private void dTJ()
  {
    this.lock.lock();
    for (;;)
    {
      try
      {
        this.nH.clear();
        Iterator localIterator = this.Bb.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
        String str = localSubAccountInfo.subuin;
        ArrayList localArrayList = (ArrayList)this.em.query(SubAccountMessage.class, SubAccountMessage.class.getSimpleName(), false, "subUin=?", new String[] { str }, null, null, "time desc", null);
        if ((localArrayList != null) && (localArrayList.size() > 0)) {
          this.nH.put(str, localArrayList);
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("init() query subUin:").append(str).append(" allMsg and put map.list=");
          if (localArrayList == null)
          {
            str = null;
            QLog.d("SUB_ACCOUNT", 2, str);
          }
        }
        else
        {
          a(localSubAccountInfo, localArrayList, 0);
          continue;
        }
        i = localArrayList.size();
      }
      finally
      {
        this.lock.unlock();
      }
      int i;
      Integer localInteger = Integer.valueOf(i);
    }
    this.lock.unlock();
  }
  
  public void C(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("updateCookie() subUin=").append(paramString).append(" cookie=");
      if (paramArrayOfByte == null)
      {
        localObject1 = "null";
        QLog.d("SUB_ACCOUNT", 2, localObject1);
      }
    }
    else
    {
      if (paramString != null) {
        break label79;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "updateCookie() subUin is null.");
      }
    }
    label79:
    do
    {
      return;
      localObject1 = Integer.valueOf(paramArrayOfByte.length);
      break;
      if (this.Bb != null) {
        break label101;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "updateCookie() listSubInfo is null.");
    return;
    label101:
    this.lock.lock();
    for (;;)
    {
      try
      {
        localObject2 = this.Bb.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (SubAccountInfo)((Iterator)localObject2).next();
          if (!paramString.equals(((SubAccountInfo)localObject1).subuin)) {
            continue;
          }
          ((SubAccountInfo)localObject1).cookie = paramArrayOfByte;
          paramString = (String)localObject1;
          this.lock.unlock();
          if (paramString == null) {
            break;
          }
          a(paramString);
          return;
        }
      }
      finally
      {
        this.lock.unlock();
      }
      paramString = null;
    }
  }
  
  public int Kx()
  {
    int i = 0;
    this.lock.lock();
    try
    {
      if (this.Bb != null) {
        i = this.Bb.size();
      }
      this.lock.unlock();
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getBindedNumber() bindedNum=" + i);
      }
      return i;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public void R(String paramString1, String paramString2, boolean paramBoolean)
  {
    int j = 1;
    int k = 0;
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("updateA2() subUin=").append(paramString1).append(" A2=");
      if (paramString2 == null)
      {
        localObject1 = "null";
        QLog.d("SUB_ACCOUNT", 2, localObject1 + " change=" + paramBoolean);
      }
    }
    else
    {
      if (paramString1 != null) {
        break label99;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "updateA2() subUin is null.");
      }
    }
    label99:
    do
    {
      return;
      localObject1 = Integer.valueOf(paramString2.length());
      break;
      if (this.Bb != null) {
        break label121;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "updateA2() listSubInfo is null.");
    return;
    label121:
    this.lock.lock();
    for (;;)
    {
      try
      {
        localObject2 = this.Bb.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (SubAccountInfo)((Iterator)localObject2).next();
          if (!paramString1.equals(((SubAccountInfo)localObject1).subuin)) {
            continue;
          }
          if ((paramString2 != null) || (((SubAccountInfo)localObject1).A2 == null))
          {
            i = k;
            if (paramString2 != null)
            {
              i = k;
              if (paramString2.equals(((SubAccountInfo)localObject1).A2)) {}
            }
          }
          else
          {
            if (paramBoolean)
            {
              ((SubAccountInfo)localObject1).lasttime = (System.currentTimeMillis() / 1000L);
              if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "updateA2() change lasttime=" + ((SubAccountInfo)localObject1).lasttime);
              }
            }
            ((SubAccountInfo)localObject1).A2 = paramString2;
            if (paramString2 != null) {
              break label433;
            }
            ((SubAccountInfo)localObject1).hintIsNew = false;
            if (!QLog.isColorLevel()) {
              break label433;
            }
            QLog.d("SUB_ACCOUNT", 2, "updateA2() set hintIsNew=false");
            break label433;
          }
          if (paramString2 == null)
          {
            ((SubAccountInfo)localObject1).cookie = null;
            if (((SubAccountInfo)localObject1).status != 0) {
              continue;
            }
            ((SubAccountInfo)localObject1).status = 3;
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("SUB_ACCOUNT", 2, "updateA2() change status=" + ((SubAccountInfo)localObject1).status);
              i = j;
            }
            if (i == 0) {
              break label428;
            }
            paramString1 = (String)localObject1;
            this.lock.unlock();
            if (paramString1 == null) {
              break;
            }
            ThreadManager.getFileThreadHandler().post(new SubAccountManager.1(this, paramString1));
            return;
          }
          ((SubAccountInfo)localObject1).serverErrorMsg = null;
          ((SubAccountInfo)localObject1).serverErrorType = 0;
          continue;
        }
        paramString1 = null;
      }
      finally
      {
        this.lock.unlock();
      }
      label428:
      continue;
      label433:
      int i = 1;
    }
  }
  
  public void RA(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "removeAllMessage() subUin=" + paramString);
    }
    if (paramString == null) {
      return;
    }
    this.lock.lock();
    Object localObject1;
    Object localObject2;
    try
    {
      if (this.nH.containsKey(paramString))
      {
        localObject1 = (List)this.nH.remove(paramString);
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (SubAccountMessage)((Iterator)localObject1).next();
            this.em.remove((Entity)localObject2);
          }
        }
      }
      localObject2 = this.Bb.iterator();
    }
    finally
    {
      this.lock.unlock();
    }
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = (SubAccountInfo)((Iterator)localObject2).next();
    } while ((localObject1 == null) || (!paramString.equals(((SubAccountInfo)localObject1).subuin)));
    for (paramString = (String)localObject1;; paramString = null)
    {
      if (paramString != null)
      {
        paramString.unNotifySender = 0;
        paramString.unreadSenderNum = 0;
        paramString.unreadMsgNum = 0;
        paramString.unreadTroopMsgNum = 0;
        paramString.lastMsg = null;
        paramString.lastUin = null;
        paramString.lastUinNick = null;
        a(paramString);
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "removeAllMessage() info.subuin=" + paramString.subuin + " unreadMsg=" + paramString.unreadMsgNum + " unNotify=" + paramString.unNotifySender + " unreadSender=" + paramString.unreadSenderNum);
        }
      }
      this.lock.unlock();
      return;
    }
  }
  
  public void RB(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "updateSubAccountMsgTimeStr() dateFormate=" + paramString);
    }
    if (paramString == null) {}
    do
    {
      return;
      if ((this.Bb != null) && (this.Bb.size() != 0) && (this.nH != null) && (this.nH.size() != 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    Object localObject1 = new StringBuilder().append("updateSubAccountMsgTimeStr() ");
    if (this.Bb == null)
    {
      paramString = "listSubInfo == null";
      QLog.d("SUB_ACCOUNT", 2, paramString);
      localObject1 = new StringBuilder().append("updateSubAccountMsgTimeStr() ");
      if (this.nH != null) {
        break label163;
      }
    }
    label163:
    for (paramString = "mapSubMsg == null";; paramString = "mapSubMsg.size() == 0")
    {
      QLog.d("SUB_ACCOUNT", 2, paramString);
      return;
      paramString = "listSubInfo.size() == 0";
      break;
    }
    this.lock.lock();
    label332:
    for (;;)
    {
      try
      {
        localObject1 = this.Bb.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (SubAccountInfo)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = ((SubAccountInfo)localObject2).subuin;
            localObject2 = (ArrayList)this.nH.get(localObject2);
            if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
            {
              localObject2 = ((ArrayList)localObject2).iterator();
              int i = 1;
              if (((Iterator)localObject2).hasNext())
              {
                SubAccountMessage localSubAccountMessage = (SubAccountMessage)((Iterator)localObject2).next();
                if (localSubAccountMessage == null) {
                  continue;
                }
                localSubAccountMessage.mTimeString = aqmu.a(localSubAccountMessage.time * 1000L, true, paramString);
                if (i == 0) {
                  break label332;
                }
                i = 0;
              }
            }
          }
        }
        else
        {
          return;
        }
      }
      finally
      {
        this.lock.unlock();
      }
    }
  }
  
  public void RC(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "clearUnreadNum() subUin=" + paramString);
    }
    if (paramString == null) {}
    do
    {
      return;
      if ((this.Bb != null) && (this.Bb.size() != 0) && (this.nH != null) && (this.nH.size() != 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    Object localObject1 = new StringBuilder().append("clearUnreadNum() ");
    if (this.Bb == null)
    {
      paramString = "listSubInfo == null";
      QLog.d("SUB_ACCOUNT", 2, paramString);
      localObject1 = new StringBuilder().append("clearUnreadNum() ");
      if (this.nH != null) {
        break label163;
      }
    }
    label163:
    for (paramString = "mapSubMsg == null";; paramString = "mapSubMsg.size() == 0")
    {
      QLog.d("SUB_ACCOUNT", 2, paramString);
      return;
      paramString = "listSubInfo.size() == 0";
      break;
    }
    this.lock.lock();
    for (;;)
    {
      try
      {
        Object localObject2 = this.Bb.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label433;
        }
        localObject1 = (SubAccountInfo)((Iterator)localObject2).next();
        if ((localObject1 == null) || (!paramString.equals(((SubAccountInfo)localObject1).subuin))) {
          continue;
        }
        ArrayList localArrayList = (ArrayList)this.nH.get(paramString);
        if ((localArrayList == null) || (localArrayList.size() == 0)) {
          continue;
        }
        paramString = localArrayList.iterator();
        if (paramString.hasNext())
        {
          localObject2 = (SubAccountMessage)paramString.next();
          if (localObject2 == null) {
            continue;
          }
          if (!((SubAccountMessage)localObject2).needNotify) {
            break label443;
          }
          ((SubAccountMessage)localObject2).needNotify = false;
          i = 1;
          if (((SubAccountMessage)localObject2).unreadNum != 0)
          {
            ((SubAccountMessage)localObject2).unreadNum = 0;
            i = 1;
          }
          if (i == 0) {
            continue;
          }
          a((Entity)localObject2);
          continue;
        }
        ((SubAccountInfo)localObject1).unNotifySender = 0;
      }
      finally
      {
        this.lock.unlock();
      }
      ((SubAccountInfo)localObject1).unreadMsgNum = 0;
      ((SubAccountInfo)localObject1).unreadSenderNum = 0;
      ((SubAccountInfo)localObject1).unreadTroopMsgNum = 0;
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "clearUnreadNum() info.subuin=" + ((SubAccountInfo)localObject1).subuin + " unreadMsgNum=" + ((SubAccountInfo)localObject1).unreadMsgNum + " unNotify=" + ((SubAccountInfo)localObject1).unNotifySender + " unreadSender=" + ((SubAccountInfo)localObject1).unreadSenderNum);
      }
      label433:
      this.lock.unlock();
      return;
      label443:
      int i = 0;
    }
  }
  
  public void RD(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "cancelHintIsNew() subUin=" + paramString);
    }
    if ((paramString == null) || (paramString.length() <= 4)) {
      return;
    }
    this.lock.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.Bb.iterator();
        if (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          if (!paramString.equals(localSubAccountInfo.subuin)) {
            continue;
          }
          if (localSubAccountInfo.hintIsNew)
          {
            localSubAccountInfo.hintIsNew = false;
            paramString = localSubAccountInfo;
            this.lock.unlock();
            if (paramString == null) {
              break;
            }
            ThreadManager.getFileThreadHandler().post(new SubAccountManager.3(this, paramString));
            return;
          }
        }
      }
      finally
      {
        this.lock.unlock();
      }
      paramString = null;
    }
  }
  
  public void RE(String paramString)
  {
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "updateMsgData2SupportSubUin() subuin==null");
      }
      return;
    }
    String str = new SubAccountMessage().getTableName();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("subUin", paramString);
    boolean bool = this.em.update(str, localContentValues, null, null);
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "updateMsgData2SupportSubUin() set subUin=" + paramString + " result" + bool);
    }
    if (bool)
    {
      dTJ();
      return;
    }
    removeAllMessage();
  }
  
  public void Rx(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "removeSubAccountInfo() subUin=" + paramString);
    }
    if (paramString == null) {
      return;
    }
    this.lock.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.Bb.iterator();
        if (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          if (!paramString.equals(localSubAccountInfo.subuin)) {
            continue;
          }
          this.Bb.remove(localSubAccountInfo);
          paramString = localSubAccountInfo;
          this.lock.unlock();
          if (paramString == null) {
            break;
          }
          this.em.remove(paramString);
          return;
        }
      }
      finally
      {
        this.lock.unlock();
      }
      paramString = null;
    }
  }
  
  public void Ry(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "setAllSubMessageReaded() subUin=" + paramString);
    }
    if (paramString == null) {
      return;
    }
    this.lock.lock();
    Object localObject1;
    Object localObject2;
    try
    {
      if (!this.nH.containsKey(paramString)) {
        break label407;
      }
      localObject1 = (List)this.nH.get(paramString);
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label397;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SubAccountMessage)((Iterator)localObject1).next();
        ((SubAccountMessage)localObject2).isread = true;
        ((SubAccountMessage)localObject2).needNotify = false;
        ((SubAccountMessage)localObject2).unreadNum = 0;
      }
      localObject2 = this.Bb.iterator();
    }
    finally
    {
      this.lock.unlock();
    }
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = (SubAccountInfo)((Iterator)localObject2).next();
    } while ((localObject1 == null) || (!paramString.equals(((SubAccountInfo)localObject1).subuin)));
    for (;;)
    {
      if (localObject1 != null)
      {
        ((SubAccountInfo)localObject1).unNotifySender = 0;
        ((SubAccountInfo)localObject1).unreadSenderNum = 0;
        ((SubAccountInfo)localObject1).unreadSenderNum = 0;
        ((SubAccountInfo)localObject1).unreadMsgNum = 0;
        ((SubAccountInfo)localObject1).unreadTroopMsgNum = 0;
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "setAllMessageReaded() info.subuin=" + ((SubAccountInfo)localObject1).subuin + " unreadMsg=" + ((SubAccountInfo)localObject1).unreadMsgNum + " unNotify=" + ((SubAccountInfo)localObject1).unNotifySender + " unreadSender=" + ((SubAccountInfo)localObject1).unreadSenderNum);
        }
      }
      this.lock.unlock();
      localObject1 = new SubAccountMessage().getTableName();
      localObject2 = new ContentValues();
      ((ContentValues)localObject2).put("isread", Boolean.valueOf(true));
      ((ContentValues)localObject2).put("unreadNum", Integer.valueOf(0));
      boolean bool = this.em.update((String)localObject1, (ContentValues)localObject2, "subUin=?", new String[] { paramString });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SUB_ACCOUNT", 2, "setAllSubMessageReaded() set isRead and unreadNum, result" + bool);
      return;
      label397:
      this.lock.unlock();
      return;
      label407:
      this.lock.unlock();
      return;
      localObject1 = null;
    }
  }
  
  public void Rz(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!this.cKy)) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, new Object[] { "cur uin=", paramString, " mNotifySwitch=", Boolean.valueOf(this.cKy) });
      }
    }
    int j;
    do
    {
      return;
      i = this.mApp.a().A(paramString, 7000);
      j = this.mApp.a().B(paramString, 7000);
      if ((i > 0) || (j > 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "cur uin no unreadMsg uin=" + paramString);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, new Object[] { "cur uin has unreadMsg: c2cUnread=", Integer.valueOf(i), " troopUnread=" + j, " uin=", paramString });
    }
    paramString = this.Bb.iterator();
    label198:
    SubAccountInfo localSubAccountInfo;
    anxk.b localb;
    int k;
    while (paramString.hasNext())
    {
      localSubAccountInfo = (SubAccountInfo)paramString.next();
      if ((localSubAccountInfo != null) && (!TextUtils.isEmpty(localSubAccountInfo.subuin)) && (localSubAccountInfo.status == 1))
      {
        localb = anxk.a(this.mApp, localSubAccountInfo.subuin);
        j = this.mApp.a().A(localSubAccountInfo.subuin, 7000);
        k = this.mApp.a().B(localSubAccountInfo.subuin, 7000);
        if ((localb.showRedDot) || (j == localb.unReadCount)) {
          break label429;
        }
        this.mApp.a().G(localSubAccountInfo.subuin, 7000, localb.unReadCount - j);
      }
    }
    label338:
    tog localtog;
    label429:
    String str;
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("SUB_ACCOUNT", 2, "updateAnotherSubAccountUnreadMsg" + " info.subuin=" + localSubAccountInfo.subuin + " anotherC2cUnread=" + j + " anotherTroopUnread=" + k + " item.showRedDot=" + localb.showRedDot + " item.unReadCount=" + localb.unReadCount);
        break label198;
        break;
        if ((localb.showRedDot) && (localb.unReadCount != k))
        {
          localtog = this.mApp.a();
          str = localSubAccountInfo.subuin;
          if (localb.unReadCount <= 0) {
            break label487;
          }
        }
      }
    }
    label487:
    for (int i = 1;; i = 0)
    {
      localtog.E(str, 7000, i);
      break label338;
      break;
    }
  }
  
  public int Y(String paramString1, String paramString2)
  {
    int j = 0;
    if ((paramString1 == null) || (paramString2 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "removeMessage() return, NULL, subUin=" + paramString1 + " sendUin=" + paramString2);
      }
      return 0;
    }
    this.lock.lock();
    for (;;)
    {
      try
      {
        if (this.nH.containsKey(paramString1))
        {
          ArrayList localArrayList = (ArrayList)this.nH.get(paramString1);
          if ((localArrayList != null) && (localArrayList.size() > 0))
          {
            i = localArrayList.size() - 1;
            if (i < 0) {
              break label345;
            }
            localSubAccountMessage = (SubAccountMessage)localArrayList.get(i);
            if ((paramString1.equals(localSubAccountMessage.subUin)) && (paramString2.equals(localSubAccountMessage.senderuin)))
            {
              localArrayList.remove(i);
              i = 0 - localSubAccountMessage.unreadNum;
              Iterator localIterator = this.Bb.iterator();
              if (localIterator.hasNext())
              {
                localSubAccountInfo = (SubAccountInfo)localIterator.next();
                if ((localSubAccountInfo == null) || (!paramString1.equals(localSubAccountInfo.subuin))) {
                  continue;
                }
                a(localSubAccountInfo, localArrayList, 2);
                this.lock.unlock();
                if (localSubAccountMessage != null) {
                  this.em.remove(localSubAccountMessage);
                }
                if (QLog.isColorLevel()) {
                  QLog.d("SUB_ACCOUNT", 2, "removeMessage() subUin=" + paramString1 + " sendUin=" + paramString2 + " changedNum=" + i);
                }
                return i;
              }
            }
            else
            {
              i -= 1;
              continue;
            }
          }
          else
          {
            return 0;
          }
        }
        else
        {
          return 0;
        }
      }
      finally
      {
        this.lock.unlock();
      }
      SubAccountInfo localSubAccountInfo = null;
      continue;
      label345:
      SubAccountMessage localSubAccountMessage = null;
      int i = j;
    }
  }
  
  public SubAccountInfo a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "getSubAccountInfo() subUin=" + paramString);
    }
    if (paramString == null) {
      return null;
    }
    this.lock.lock();
    for (;;)
    {
      try
      {
        if (this.Bb != null)
        {
          Iterator localIterator = this.Bb.iterator();
          if (localIterator.hasNext())
          {
            SubAccountInfo localSubAccountInfo2 = (SubAccountInfo)localIterator.next();
            if (localSubAccountInfo2 == null) {
              continue;
            }
            localSubAccountInfo1 = localSubAccountInfo2;
            if (!"sub.uin.default".equals(paramString))
            {
              boolean bool = paramString.equals(localSubAccountInfo2.subuin);
              if (!bool) {
                continue;
              }
              localSubAccountInfo1 = localSubAccountInfo2;
            }
            return localSubAccountInfo1;
          }
        }
      }
      finally
      {
        this.lock.unlock();
      }
      SubAccountInfo localSubAccountInfo1 = null;
    }
  }
  
  SubAccountMessage a(String paramString)
  {
    SubAccountMessage localSubAccountMessage = new SubAccountMessage();
    localSubAccountMessage.frienduin = String.valueOf(13002L);
    localSubAccountMessage.unreadNum = 0;
    localSubAccountMessage.msgtype = -1000;
    localSubAccountMessage.senderuin = String.valueOf(13002L);
    localSubAccountMessage.subUin = paramString;
    localSubAccountMessage.istroop = 1;
    localSubAccountMessage.sendername = acfp.m(2131720593);
    localSubAccountMessage.msg = "";
    return localSubAccountMessage;
  }
  
  public SubAccountMessage a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "findSubAccountMessage() return, subUin=" + paramString1 + " sendUin=" + paramString2);
      }
    }
    Object localObject;
    do
    {
      return null;
      localObject = aQ(paramString1);
    } while ((localObject == null) || (((List)localObject).size() == 0));
    Iterator localIterator = ((List)localObject).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (SubAccountMessage)localIterator.next();
    } while ((localObject == null) || (!paramString1.equals(((SubAccountMessage)localObject).subUin)) || (!paramString2.equals(((SubAccountMessage)localObject).senderuin)));
    for (paramString1 = (String)localObject;; paramString1 = null) {
      return paramString1;
    }
  }
  
  public void a(anxs paramanxs)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("addAllSubAccountInfo() ");
      if (paramanxs == null)
      {
        localObject1 = "data == null";
        QLog.d("SUB_ACCOUNT", 2, (String)localObject1);
      }
    }
    else
    {
      if ((paramanxs != null) && (paramanxs.aLa != null) && (paramanxs.azm())) {
        break label183;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("addAllSubAccountInfo() return,");
        if (paramanxs != null) {
          break label143;
        }
      }
    }
    label143:
    for (paramanxs = "data == null";; paramanxs = "data.mMainAccount=" + paramanxs.aLa + " data.mSubUin=" + paramanxs.aQf)
    {
      QLog.d("SUB_ACCOUNT", 2, paramanxs);
      return;
      localObject1 = "data.mMainAccount=" + paramanxs.aLa + " data.mSubUin=" + paramanxs.aQf;
      break;
    }
    label183:
    ArrayList localArrayList2 = paramanxs.dM();
    Object localObject1 = paramanxs.dO();
    ArrayList localArrayList3 = paramanxs.dN();
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "addAllSubAccountInfo() allSubUin:" + ((ArrayList)localObject1).toString());
      QLog.d("SUB_ACCOUNT", 2, "removeOverdueSubAccountInfo() overdueUin:" + localArrayList3.toString());
    }
    ArrayList localArrayList1 = new ArrayList();
    this.lock.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = ((ArrayList)localObject1).iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localObject2 = this.Bb.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label629;
          }
          localObject1 = (SubAccountInfo)((Iterator)localObject2).next();
          if ((!paramanxs.aLa.equals(((SubAccountInfo)localObject1).trunkuin)) || (!str.equals(((SubAccountInfo)localObject1).subuin))) {
            continue;
          }
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = new SubAccountInfo();
            this.Bb.add(localObject2);
          }
          ((SubAccountInfo)localObject2).subuin = str;
          ((SubAccountInfo)localObject2).trunkuin = paramanxs.aLa;
          ((SubAccountInfo)localObject2).serverErrorType = paramanxs.serverErrorType;
          ((SubAccountInfo)localObject2).serverErrorMsg = paramanxs.errorMsg;
          if ((localArrayList2 != null) && (localArrayList2.contains(str)))
          {
            ((SubAccountInfo)localObject2).hintIsNew = true;
            ((SubAccountInfo)localObject2).lasttime = (System.currentTimeMillis() / 1000L);
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "addSubAccountInfo() change subUin=" + ((SubAccountInfo)localObject2).subuin + " hintIsNew=" + ((SubAccountInfo)localObject2).hintIsNew + " lasttime=" + ((SubAccountInfo)localObject2).lasttime);
            }
          }
          localArrayList1.add(localObject2);
          continue;
        }
        if (localArrayList3 == null) {
          break label575;
        }
      }
      finally
      {
        this.lock.unlock();
      }
      if (localArrayList3.size() > 0)
      {
        paramanxs = localArrayList3.iterator();
        while (paramanxs.hasNext()) {
          Rx((String)paramanxs.next());
        }
      }
      label575:
      this.lock.unlock();
      if ((localArrayList1 == null) || (localArrayList1.size() <= 0)) {
        break;
      }
      paramanxs = localArrayList1.iterator();
      while (paramanxs.hasNext()) {
        a((SubAccountInfo)paramanxs.next());
      }
      break;
      label629:
      localObject1 = null;
    }
  }
  
  public void a(SubAccountInfo paramSubAccountInfo, ArrayList<SubAccountMessage> paramArrayList, int paramInt)
  {
    if ((paramSubAccountInfo == null) || (paramArrayList == null))
    {
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder().append("countUnreadDatum() return,");
        if (paramSubAccountInfo != null) {
          break label51;
        }
      }
      label51:
      for (paramSubAccountInfo = "info == null";; paramSubAccountInfo = "list == null")
      {
        QLog.d("SUB_ACCOUNT", 2, paramSubAccountInfo);
        return;
      }
    }
    Collections.sort(paramArrayList);
    paramArrayList = paramArrayList.iterator();
    int k = 0;
    int n = 0;
    int m = 0;
    int i = 0;
    int i4 = 1;
    label82:
    Object localObject;
    int j;
    int i1;
    long l;
    label183:
    int i3;
    int i2;
    for (;;)
    {
      if (paramArrayList.hasNext())
      {
        localObject = (SubAccountMessage)paramArrayList.next();
        if (localObject != null)
        {
          j = i4;
          if (i4 != 0)
          {
            i1 = 0;
            if ((((SubAccountMessage)localObject).mEmoRecentMsg == null) && (((SubAccountMessage)localObject).msg != null)) {
              ((SubAccountMessage)localObject).mEmoRecentMsg = new aofk(((SubAccountMessage)localObject).msg, 3, 16);
            }
            paramSubAccountInfo.lastMsg = ((SubAccountMessage)localObject).mEmoRecentMsg;
            if (paramSubAccountInfo.lasttime <= ((SubAccountMessage)localObject).time) {
              break;
            }
            l = paramSubAccountInfo.lasttime;
            paramSubAccountInfo.lasttime = l;
            paramSubAccountInfo.lastUin = ((SubAccountMessage)localObject).frienduin;
            paramSubAccountInfo.lastUinNick = ((SubAccountMessage)localObject).sendername;
            j = i1;
            if (QLog.isColorLevel())
            {
              QLog.d("SUB_ACCOUNT", 2, "countUnreadDatum() change lasttime=" + paramSubAccountInfo.lasttime);
              j = i1;
            }
          }
          if (((SubAccountMessage)localObject).istroop == 1)
          {
            i3 = k + ((SubAccountMessage)localObject).unreadNum;
            i2 = n;
            i1 = m;
            label277:
            if (!((SubAccountMessage)localObject).needNotify) {
              break label589;
            }
            i += 1;
          }
        }
      }
    }
    label589:
    for (;;)
    {
      i4 = j;
      m = i1;
      n = i2;
      k = i3;
      break label82;
      l = ((SubAccountMessage)localObject).time;
      break label183;
      i1 = m;
      i2 = n;
      i3 = k;
      if (((SubAccountMessage)localObject).isread) {
        break label277;
      }
      i2 = n + ((SubAccountMessage)localObject).unreadNum;
      i1 = m + 1;
      i3 = k;
      break label277;
      paramSubAccountInfo.unNotifySender = i;
      paramSubAccountInfo.unreadMsgNum = n;
      paramSubAccountInfo.unreadSenderNum = m;
      paramSubAccountInfo.unreadTroopMsgNum = k;
      if (i4 != 0)
      {
        paramSubAccountInfo.lastMsg = null;
        paramSubAccountInfo.lasttime = 0L;
        paramSubAccountInfo.lastUin = null;
        paramSubAccountInfo.lastUinNick = null;
      }
      if ((paramInt == 1) && (paramSubAccountInfo.hintIsNew))
      {
        paramSubAccountInfo.hintIsNew = false;
        a(paramSubAccountInfo);
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "countUnreadDatum() set hintIsNew=false");
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      localObject = new StringBuilder().append("countUnreadDatum() info.subuin=").append(paramSubAccountInfo.subuin).append(" unreadMsg=").append(paramSubAccountInfo.unreadMsgNum).append(" unNotify=").append(paramSubAccountInfo.unNotifySender).append(" unreadSender=").append(paramSubAccountInfo.unreadSenderNum).append(" lastUin=").append(paramSubAccountInfo.lastUin).append(" lastNick=");
      if (paramSubAccountInfo.lastUinNick == null) {}
      for (paramArrayList = "null";; paramArrayList = Integer.valueOf(paramSubAccountInfo.lastUinNick.length()))
      {
        QLog.d("SUB_ACCOUNT", 2, paramArrayList + " lastTime=" + paramSubAccountInfo.lasttime);
        return;
      }
    }
  }
  
  public void a(SubAccountMessage paramSubAccountMessage)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      if (paramSubAccountMessage == null)
      {
        localObject = "null";
        QLog.d("SUB_ACCOUNT", 2, "updateTroopMsgRedDot() " + (String)localObject);
      }
    }
    else
    {
      if (this.cKy) {
        break label118;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "updateTroopMsgRedDot notify off");
      }
    }
    label118:
    while ((paramSubAccountMessage == null) || (paramSubAccountMessage.subUin == null) || (paramSubAccountMessage.senderuin == null))
    {
      return;
      localObject = "subUin=" + paramSubAccountMessage.subUin + " senderUin=" + paramSubAccountMessage.senderuin + " msg.time=" + paramSubAccountMessage.time;
      break;
    }
    this.lock.lock();
    for (;;)
    {
      try
      {
        if (this.nH.containsKey(paramSubAccountMessage.subUin))
        {
          localObject = (ArrayList)this.nH.get(paramSubAccountMessage.subUin);
          if ((localObject == null) || (((ArrayList)localObject).size() == 0))
          {
            if (!QLog.isColorLevel()) {
              break label452;
            }
            QLog.d("SUB_ACCOUNT", 2, "updateTroopMsgRedDot() list is empty");
            break label452;
            if (bool) {
              this.mApp.a().E(paramSubAccountMessage.subUin, 7000, paramSubAccountMessage.unreadNum);
            }
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "updateTroopMsgRedDot() needUpdate=" + bool);
            }
            return;
          }
          localObject = ((ArrayList)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            SubAccountMessage localSubAccountMessage = (SubAccountMessage)((Iterator)localObject).next();
            if ((!paramSubAccountMessage.subUin.equals(localSubAccountMessage.subUin)) || (!paramSubAccountMessage.senderuin.equals(localSubAccountMessage.senderuin))) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "updateTroopMsgRedDot() tMsg.time=" + localSubAccountMessage.time);
            }
            if ((acbn.blA.equals(paramSubAccountMessage.senderuin)) && (paramSubAccountMessage.time > localSubAccountMessage.time))
            {
              bool = true;
              continue;
            }
            if ((!acbn.blA.equals(paramSubAccountMessage.senderuin)) || (paramSubAccountMessage.unreadNum != 0)) {
              continue;
            }
            long l = paramSubAccountMessage.time;
            if (l != 0L) {
              continue;
            }
            bool = true;
            continue;
          }
        }
        bool = false;
      }
      finally
      {
        this.lock.unlock();
      }
      continue;
      label452:
      boolean bool = true;
    }
  }
  
  public boolean a(Entity paramEntity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.em.isOpen())
    {
      if (paramEntity.getStatus() != 1000) {
        break label48;
      }
      this.em.persistOrReplace(paramEntity);
      bool1 = bool2;
      if (paramEntity.getStatus() == 1001) {
        bool1 = true;
      }
    }
    label48:
    do
    {
      return bool1;
      if (paramEntity.getStatus() == 1001) {
        break;
      }
      bool1 = bool2;
    } while (paramEntity.getStatus() != 1002);
    return this.em.update(paramEntity);
  }
  
  public long aN(String paramString)
  {
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getActionTime() subUin is null.");
      }
      return 0L;
    }
    if (this.Bb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getActionTime() listSubInfo is null.");
      }
      return 0L;
    }
    this.lock.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.Bb.iterator();
        if (!localIterator.hasNext()) {
          break label131;
        }
        SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
        boolean bool = paramString.equals(localSubAccountInfo.subuin);
        if (!bool) {
          continue;
        }
        paramString = localSubAccountInfo;
        this.lock.unlock();
        if (paramString != null) {
          return paramString.lasttime;
        }
      }
      finally
      {
        this.lock.unlock();
      }
      return 0L;
      label131:
      paramString = null;
    }
  }
  
  public List<SubAccountMessage> aQ(String paramString)
  {
    Object localObject1 = null;
    ArrayList localArrayList = new ArrayList();
    aeoa localaeoa = (aeoa)aeif.a().o(607);
    this.lock.lock();
    label304:
    for (;;)
    {
      try
      {
        if ((this.nH != null) && (this.nH.containsKey(paramString)))
        {
          Iterator localIterator = ((ArrayList)this.nH.get(paramString)).iterator();
          if (localIterator.hasNext())
          {
            localObject2 = (SubAccountMessage)localIterator.next();
            if (acbn.blA.equals(((SubAccountMessage)localObject2).senderuin))
            {
              localObject1 = localObject2;
              break label304;
            }
            localArrayList.add(localObject2);
            break label304;
          }
          if ((localaeoa != null) && (!localaeoa.bVj))
          {
            if (localObject1 != null) {
              continue;
            }
            if (this.cKy) {
              localArrayList.add(0, a(paramString));
            }
          }
          return localArrayList;
          localArrayList.add(0, localObject1);
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label239;
        }
      }
      finally
      {
        this.lock.unlock();
      }
      Object localObject2 = new StringBuilder().append("getAllMessage() subUin:").append(paramString).append(" mspSubMsg=");
      if (this.nH == null) {}
      for (localObject1 = null;; localObject1 = "containsKey=" + this.nH.containsKey(paramString))
      {
        QLog.d("SUB_ACCOUNT", 2, (String)localObject1);
        label239:
        if ((localaeoa == null) || (localaeoa.bVj) || (!this.cKy)) {
          break;
        }
        localArrayList.add(0, a(paramString));
        break;
      }
    }
  }
  
  public void aY(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "setActionTime() subUin=" + paramString + " time=" + paramLong);
    }
    if (paramString == null) {}
    do
    {
      return;
      if (this.Bb != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "setActionTime() listSubInfo is null.");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "setActionTime() subUin=" + paramString + " change lasttime=" + paramLong);
    }
    this.lock.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.Bb.iterator();
        if (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          if (!paramString.equals(localSubAccountInfo.subuin)) {
            continue;
          }
          localSubAccountInfo.lasttime = paramLong;
          paramString = localSubAccountInfo;
          this.lock.unlock();
          if (paramString == null) {
            break;
          }
          ThreadManager.getFileThreadHandler().post(new SubAccountManager.2(this, paramString));
          return;
        }
      }
      finally
      {
        this.lock.unlock();
      }
      paramString = null;
    }
  }
  
  public byte[] aa(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "getCookie() subUin=" + paramString);
    }
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getCookie() subUin is null.");
      }
    }
    do
    {
      return null;
      if (this.Bb != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "getCookie() listSubInfo is null.");
    return null;
    this.lock.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.Bb.iterator();
        if (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          boolean bool = paramString.equals(localSubAccountInfo.subuin);
          if (!bool) {
            continue;
          }
          paramString = localSubAccountInfo;
          this.lock.unlock();
          if (paramString == null) {
            break;
          }
          return paramString.cookie;
        }
      }
      finally
      {
        this.lock.unlock();
      }
      paramString = null;
    }
  }
  
  public void ab(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "updateServerError() subUin=" + paramString1 + " error type=" + paramInt + " msg=" + paramString2);
    }
    if (paramString1 == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "updateServerError() subUin is null.");
      }
    }
    do
    {
      return;
      if (this.Bb != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "updateServerError() listSubInfo is null.");
    return;
    Object localObject = null;
    this.lock.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.Bb.iterator();
        if (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          if (paramString1.equals(localSubAccountInfo.subuin))
          {
            localSubAccountInfo.serverErrorType = paramInt;
            localSubAccountInfo.serverErrorMsg = paramString2;
            localObject = localSubAccountInfo;
          }
        }
        else
        {
          this.lock.unlock();
          if (localObject == null) {
            break;
          }
          a(localObject);
          return;
        }
      }
      finally
      {
        this.lock.unlock();
      }
    }
  }
  
  public boolean am(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "setStatus() subUin=" + paramString + " status=" + paramInt);
    }
    if (paramString == null) {
      return false;
    }
    Object localObject = null;
    this.lock.lock();
    label230:
    label235:
    for (;;)
    {
      try
      {
        Iterator localIterator = this.Bb.iterator();
        if (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          bool1 = paramString.equals(localSubAccountInfo.subuin);
          if (!bool1) {
            break label235;
          }
          localObject = localSubAccountInfo;
          continue;
        }
        this.lock.unlock();
        if (localObject != null)
        {
          if (localObject.status == paramInt) {
            break;
          }
          if ((paramInt != 2) && (paramInt != 3)) {
            break label230;
          }
          boolean bool2 = true;
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("SUB_ACCOUNT", 2, "setStatus() need2setMsgNum_1=" + true);
            bool1 = bool2;
          }
          localObject.status = paramInt;
          a(localObject);
          return bool1;
        }
      }
      finally
      {
        this.lock.unlock();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SUB_ACCOUNT", 2, "setStatus() findInfo is null. return default 0");
      return false;
      boolean bool1 = false;
    }
  }
  
  public boolean azj()
  {
    return this.cKy;
  }
  
  public void b(SubAccountMessage paramSubAccountMessage)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      if (paramSubAccountMessage == null)
      {
        localObject1 = "null";
        QLog.d("SUB_ACCOUNT", 2, "addNewMessage() " + (String)localObject1);
      }
    }
    else
    {
      if (this.cKy) {
        break label102;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "addNewMessage notify off");
      }
    }
    label102:
    while ((paramSubAccountMessage == null) || (paramSubAccountMessage.subUin == null) || (paramSubAccountMessage.senderuin == null))
    {
      return;
      localObject1 = "subUin=" + paramSubAccountMessage.subUin + " senderUin=" + paramSubAccountMessage.senderuin;
      break;
    }
    this.lock.lock();
    for (;;)
    {
      Object localObject2;
      SubAccountMessage localSubAccountMessage;
      try
      {
        localObject2 = this.Bb.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label482;
        }
        localObject1 = (SubAccountInfo)((Iterator)localObject2).next();
        if ((localObject1 == null) || (!paramSubAccountMessage.subUin.equals(((SubAccountInfo)localObject1).subuin))) {
          continue;
        }
        if (!this.nH.containsKey(paramSubAccountMessage.subUin)) {
          break label445;
        }
        localObject2 = (ArrayList)this.nH.get(paramSubAccountMessage.subUin);
        if (localObject2 == null)
        {
          localObject2 = new ArrayList();
          ((ArrayList)localObject2).add(paramSubAccountMessage);
          this.nH.put(paramSubAccountMessage.subUin, localObject2);
          a((SubAccountInfo)localObject1, (ArrayList)localObject2, 1);
          this.lock.unlock();
          a(paramSubAccountMessage);
          return;
        }
        Iterator localIterator = ((ArrayList)localObject2).iterator();
        if (localIterator.hasNext())
        {
          localSubAccountMessage = (SubAccountMessage)localIterator.next();
          if ((!paramSubAccountMessage.subUin.equals(localSubAccountMessage.subUin)) || (!paramSubAccountMessage.senderuin.equals(localSubAccountMessage.senderuin))) {
            continue;
          }
          if ((acbn.blA.equals(paramSubAccountMessage.senderuin)) && (paramSubAccountMessage.time == 0L) && (paramSubAccountMessage.unreadNum == 0))
          {
            paramSubAccountMessage.time = localSubAccountMessage.time;
            ((ArrayList)localObject2).remove(localSubAccountMessage);
            this.em.remove(localSubAccountMessage);
          }
        }
        else
        {
          ((ArrayList)localObject2).add(0, paramSubAccountMessage);
          a((SubAccountInfo)localObject1, (ArrayList)localObject2, 1);
          continue;
        }
        if (!acbn.blA.equals(paramSubAccountMessage.senderuin)) {
          continue;
        }
      }
      finally
      {
        this.lock.unlock();
      }
      if (paramSubAccountMessage.time <= localSubAccountMessage.time)
      {
        paramSubAccountMessage.unreadNum = localSubAccountMessage.unreadNum;
        paramSubAccountMessage.time = localSubAccountMessage.time;
        continue;
        label445:
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(paramSubAccountMessage);
        this.nH.put(paramSubAccountMessage.subUin, localObject2);
        a((SubAccountInfo)localObject1, (ArrayList)localObject2, 1);
        continue;
        label482:
        localObject1 = null;
      }
    }
  }
  
  public CharSequence c(String paramString)
  {
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getLatestMsg() subUin is null.");
      }
    }
    do
    {
      return null;
      if (this.Bb != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "getLatestMsg() listSubInfo is null.");
    return null;
    this.lock.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.Bb.iterator();
        if (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          boolean bool = paramString.equals(localSubAccountInfo.subuin);
          if (!bool) {
            continue;
          }
          paramString = localSubAccountInfo;
          this.lock.unlock();
          if (paramString == null) {
            break;
          }
          return paramString.lastMsg;
        }
      }
      finally
      {
        this.lock.unlock();
      }
      paramString = null;
    }
  }
  
  public void cV(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "setRecentListTop() subUin=" + paramString + " isTop=" + paramBoolean);
    }
    if ((paramString == null) || (paramString.length() < 5)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "setRecentListTop() subUin=" + paramString + " isTop=" + paramBoolean);
    }
    this.lock.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.Bb.iterator();
        if (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          if (!paramString.equals(localSubAccountInfo.subuin)) {
            continue;
          }
          localSubAccountInfo.isTop = paramBoolean;
          paramString = localSubAccountInfo;
          this.lock.unlock();
          if (paramString == null) {
            break;
          }
          a(paramString);
          return;
        }
      }
      finally
      {
        this.lock.unlock();
      }
      paramString = null;
    }
  }
  
  public ArrayList<String> dK()
  {
    if (this.Bb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getAllSubUin() listSubInfo is null. return null;");
      }
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    this.lock.lock();
    try
    {
      Iterator localIterator = this.Bb.iterator();
      while (localIterator.hasNext())
      {
        SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
        if (localSubAccountInfo != null) {
          localArrayList.add(localSubAccountInfo.subuin);
        }
      }
    }
    finally
    {
      this.lock.unlock();
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "getAllSubUin() return:" + String.valueOf(localObject));
    }
    return localObject;
  }
  
  public ArrayList<SubAccountInfo> dL()
  {
    ArrayList localArrayList = new ArrayList();
    this.lock.lock();
    try
    {
      localArrayList.addAll(this.Bb);
      return localArrayList;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public void dTK()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "clearAllUnNotifySenderNum()");
    }
    if (this.Bb == null) {}
    do
    {
      return;
      if (this.nH != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "clearAllUnNotifySenderNum() mapSubMsg is null.");
    return;
    this.lock.lock();
    try
    {
      Iterator localIterator = this.Bb.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (SubAccountInfo)localIterator.next();
        if (localObject2 != null)
        {
          ((SubAccountInfo)localObject2).unNotifySender = 0;
          localObject2 = ((SubAccountInfo)localObject2).subuin;
          localObject2 = (ArrayList)this.nH.get(localObject2);
          if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
          {
            localObject2 = ((ArrayList)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              SubAccountMessage localSubAccountMessage = (SubAccountMessage)((Iterator)localObject2).next();
              if (localSubAccountMessage.needNotify) {
                localSubAccountMessage.needNotify = false;
              }
            }
          }
        }
      }
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public int eA(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getUnreadAllMsgNum() subUin is null.");
      }
    }
    do
    {
      return 0;
      if (this.Bb != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "getUnreadAllMsgNum() listSubInfo is null.");
    return 0;
    this.lock.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.Bb.iterator();
        if (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          if (paramString.equals(localSubAccountInfo.subuin)) {
            i = localSubAccountInfo.unreadMsgNum;
          }
        }
        else
        {
          return i;
        }
      }
      finally
      {
        this.lock.unlock();
      }
    }
  }
  
  public int eB(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getUnreadAllTroopMsgNum() subUin is null.");
      }
    }
    do
    {
      return 0;
      if (this.Bb != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "getUnreadAllTroopMsgNum() listSubInfo is null.");
    return 0;
    this.lock.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.Bb.iterator();
        if (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          if (paramString.equals(localSubAccountInfo.subuin)) {
            i = localSubAccountInfo.unreadTroopMsgNum;
          }
        }
        else
        {
          return i;
        }
      }
      finally
      {
        this.lock.unlock();
      }
    }
  }
  
  public void eg(QQAppInterface paramQQAppInterface)
  {
    this.cKy = SettingCloneUtil.readValue(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), null, "qqsetting_subaccount_notify", true);
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, new Object[] { "updateNotifySwitch ", Boolean.valueOf(this.cKy) });
    }
    if (!this.cKy)
    {
      paramQQAppInterface = dK();
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.iterator();
        while (paramQQAppInterface.hasNext()) {
          Ry((String)paramQQAppInterface.next());
        }
      }
      removeAllMessage();
    }
  }
  
  public int ey(String paramString)
  {
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getStatus() subUin is null.");
      }
    }
    do
    {
      return 0;
      if (this.Bb != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "getStatus() listSubInfo is null.");
    return 0;
    Object localObject = null;
    this.lock.lock();
    label201:
    for (;;)
    {
      try
      {
        Iterator localIterator = this.Bb.iterator();
        if (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          boolean bool = paramString.equals(localSubAccountInfo.subuin);
          if (!bool) {
            break label201;
          }
          localObject = localSubAccountInfo;
          continue;
        }
        this.lock.unlock();
        if (localObject != null)
        {
          int j = localObject.status;
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("SUB_ACCOUNT", 2, "getStatus() findInfo status=" + j);
            i = j;
          }
          return i;
        }
      }
      finally
      {
        this.lock.unlock();
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getStatus() findInfo is null. return default 0");
      }
      int i = 0;
    }
  }
  
  public int ez(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getUnNotificationSenderNum() subUin is null.");
      }
    }
    do
    {
      return 0;
      if (this.Bb != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "getUnNotificationSenderNum() listSubInfo is null.");
    return 0;
    this.lock.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.Bb.iterator();
        if (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          if (paramString.equals(localSubAccountInfo.subuin)) {
            i = localSubAccountInfo.unNotifySender;
          }
        }
        else
        {
          return i;
        }
      }
      finally
      {
        this.lock.unlock();
      }
    }
  }
  
  public String getA2(String paramString)
  {
    String str = "";
    SubAccountInfo localSubAccountInfo = a(paramString);
    paramString = str;
    if (localSubAccountInfo != null) {
      paramString = localSubAccountInfo.A2;
    }
    return paramString;
  }
  
  public Pair<Integer, String> h(String paramString)
  {
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getServerError() subUin is null.");
      }
    }
    do
    {
      return null;
      if (this.Bb != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "getServerError() listSubInfo is null.");
    return null;
    this.lock.lock();
    label228:
    for (;;)
    {
      try
      {
        Iterator localIterator = this.Bb.iterator();
        Object localObject1 = null;
        Object localObject2;
        if (localIterator.hasNext())
        {
          localObject2 = (SubAccountInfo)localIterator.next();
          boolean bool = paramString.equals(((SubAccountInfo)localObject2).subuin);
          if (!bool) {
            break label228;
          }
          localObject1 = localObject2;
          continue;
        }
        this.lock.unlock();
        if (localObject1 != null)
        {
          localObject2 = new Pair(Integer.valueOf(localObject1.serverErrorType), localObject1.serverErrorMsg);
          paramString = (String)localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("SUB_ACCOUNT", 2, "getServerError() findInfo errType=" + localObject1.serverErrorType + " errMsg=" + localObject1.serverErrorMsg);
            paramString = (String)localObject2;
          }
          return paramString;
        }
      }
      finally
      {
        this.lock.unlock();
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getServerError() findInfo is null.");
      }
      paramString = null;
    }
  }
  
  public String nM(String paramString)
  {
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getLatestNick() subUin is null.");
      }
    }
    do
    {
      return null;
      if (this.Bb != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "getLatestNick() listSubInfo is null.");
    return null;
    this.lock.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.Bb.iterator();
        if (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          boolean bool = paramString.equals(localSubAccountInfo.subuin);
          if (!bool) {
            continue;
          }
          paramString = localSubAccountInfo;
          this.lock.unlock();
          if (paramString == null) {
            break;
          }
          return paramString.lastUinNick;
        }
      }
      finally
      {
        this.lock.unlock();
      }
      paramString = null;
    }
  }
  
  public void o(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("revokeMsg", 2, "updateUnreadNum");
    }
    SubAccountMessage localSubAccountMessage = a(paramString1, paramString2);
    if (localSubAccountMessage == null) {
      return;
    }
    this.lock.lock();
    for (;;)
    {
      try
      {
        int i = localSubAccountMessage.unreadNum;
        i -= paramInt;
        if (i == 0) {
          return;
        }
        localSubAccountMessage.unreadNum = paramInt;
        Iterator localIterator = this.Bb.iterator();
        if (localIterator.hasNext())
        {
          paramString2 = (SubAccountInfo)localIterator.next();
          if (paramString2 != null)
          {
            boolean bool = paramString1.equals(paramString2.subuin);
            if (bool)
            {
              if (paramString2 == null) {
                return;
              }
              if (localSubAccountMessage.istroop == 1)
              {
                paramString2.unreadTroopMsgNum -= i;
                paramString2.unreadTroopMsgNum = Math.max(0, paramString2.unreadTroopMsgNum);
                this.lock.unlock();
                a(localSubAccountMessage);
                anxk.G(paramQQAppInterface, paramString1, 6);
                paramQQAppInterface.a().G(paramString1, 7000, -i);
                paramQQAppInterface.b().as(new String[] { acbn.bku, paramString1 });
                paramQQAppInterface.cLO();
                paramString2 = new anxs();
                paramString2.aQf = paramString1;
                paramString2.cKB = true;
                paramString2.cKC = true;
                paramString2.errorType = 0;
                paramQQAppInterface.a().a().b(8003, true, paramString2);
                return;
              }
              paramString2.unreadMsgNum -= i;
            }
          }
        }
        else
        {
          paramString2 = null;
        }
      }
      finally
      {
        this.lock.unlock();
      }
    }
  }
  
  public void onDestroy()
  {
    this.lock.lock();
    try
    {
      this.Bb.clear();
      this.nH.clear();
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public boolean pJ(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "isSubAccountUin() , subUin=" + paramString);
    }
    if (paramString == null) {}
    do
    {
      return false;
      if (this.Bb != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "isSubAccountUin() listSubInfo is null.");
    return false;
    this.lock.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.Bb.iterator();
        if (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          if (localSubAccountInfo == null) {
            continue;
          }
          bool = paramString.equals(localSubAccountInfo.subuin);
          if (!bool) {
            continue;
          }
          bool = true;
          return bool;
        }
      }
      finally
      {
        this.lock.unlock();
      }
      boolean bool = false;
    }
  }
  
  public void removeAllMessage()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "removeAllMessage()");
    }
    this.lock.lock();
    try
    {
      this.nH.clear();
      if (this.Bb != null)
      {
        Iterator localIterator = this.Bb.iterator();
        while (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          localSubAccountInfo.unNotifySender = 0;
          localSubAccountInfo.unreadSenderNum = 0;
          localSubAccountInfo.unreadMsgNum = 0;
          localSubAccountInfo.unreadTroopMsgNum = 0;
          localSubAccountInfo.lastMsg = null;
          localSubAccountInfo.lastUin = null;
          localSubAccountInfo.lastUinNick = null;
          a(localSubAccountInfo);
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "removeAllMessage() info.subuin=" + localSubAccountInfo.subuin + " unreadMsg=" + localSubAccountInfo.unreadMsgNum + " unNotify=" + localSubAccountInfo.unNotifySender + " unreadSender=" + localSubAccountInfo.unreadSenderNum);
          }
        }
      }
    }
    finally
    {
      this.lock.unlock();
    }
    this.em.drop(SubAccountMessage.class.getSimpleName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anxr
 * JD-Core Version:    0.7.0.1
 */