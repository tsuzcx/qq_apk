import android.os.Bundle;
import com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.1;
import com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.2;
import com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.3;
import com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.4;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.imcore.message.QQMessageFacade.b;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public abstract class tnu
  extends tnt
{
  public tnu(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, tom paramtom)
  {
    super(paramQQAppInterface, paramQQMessageFacade, paramtom);
  }
  
  private HashMap<String, MessageRecord> a(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    HashMap localHashMap = new HashMap();
    if ((paramList == null) || (paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
      }
      return localHashMap;
    }
    Object localObject = paramList.iterator();
    MessageRecord localMessageRecord;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localMessageRecord = (MessageRecord)((Iterator)localObject).next();
    } while (localMessageRecord.shmsgseq <= 0L);
    for (long l = localMessageRecord.uniseq;; l = 0L)
    {
      localObject = this.app.a(paramInt).a(paramString, paramInt, l);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refresh find msg in cache id = " + ((MessageRecord)localObject).getId() + ", msg = " + ((MessageRecord)localObject).getLogColorContent() + ", uniseq = " + ((MessageRecord)localObject).uniseq + " , msgtime = " + ((MessageRecord)localObject).time + " , shMsgSeq = " + ((MessageRecord)localObject).shmsgseq + " , extra = " + ((MessageRecord)localObject).extraflag);
        }
        if (!paramList.isEmpty())
        {
          paramList = paramList.iterator();
          do
          {
            if (!paramList.hasNext()) {
              break;
            }
            localMessageRecord = (MessageRecord)paramList.next();
          } while (localMessageRecord.shmsgseq != ((MessageRecord)localObject).shmsgseq);
          StringBuilder localStringBuilder = new StringBuilder();
          if (localMessageRecord.getId() > 0L) {}
          for (paramString = "id&" + localMessageRecord.getId();; paramString = "uniseq&" + localMessageRecord.uniseq)
          {
            localHashMap.put(paramString + "&" + localMessageRecord.shmsgseq, localMessageRecord);
            break;
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.w("Q.msg.BaseMessageManager", 2, "refresh can't find msg in cache !!");
      }
      return localHashMap;
    }
  }
  
  private void a(int paramInt, String paramString, long paramLong, List<ChatMessage> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    label323:
    for (;;)
    {
      return;
      Object localObject1;
      Object localObject2;
      if (paramList != null)
      {
        localObject1 = paramList.iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (ChatMessage)((Iterator)localObject1).next();
        } while (top.s((MessageRecord)localObject2));
      }
      for (long l1 = ((ChatMessage)localObject2).shmsgseq;; l1 = 0L)
      {
        if ((l1 > paramLong) || (paramLong == 0L) || (l1 == 0L)) {
          break label323;
        }
        long l2 = anaz.gQ();
        localObject1 = paramList.iterator();
        do
        {
          l1 = l2;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (ChatMessage)((Iterator)localObject1).next();
        } while (((ChatMessage)localObject2).shmsgseq != paramLong);
        l1 = ((ChatMessage)localObject2).time;
        localObject2 = this.app.getCurrentAccountUin();
        localObject1 = (MessageForTroopUnreadTips)anbi.d(-4009);
        ((MessageForTroopUnreadTips)localObject1).init((String)localObject2, paramString, (String)localObject2, "", l1, -4009, paramInt, 0L);
        ((MessageForTroopUnreadTips)localObject1).shmsgseq = paramLong;
        paramString = new ArrayList();
        paramString.add(localObject1);
        this.app.b().a(paramString, (String)localObject2, false, false);
        paramString = new ArrayList();
        localObject2 = paramList.iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramString.add((ChatMessage)((Iterator)localObject2).next());
        }
        top.a(paramString, (MessageRecord)localObject1, false);
        paramList.clear();
        paramString = paramString.iterator();
        while (paramString.hasNext()) {
          paramList.add((ChatMessage)paramString.next());
        }
        break;
      }
    }
  }
  
  public int a(String paramString1, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "clearLimitCountHistory uin = " + paramString1 + ", type = " + paramInt1 + ", needDeleteDB = " + paramBoolean1 + ", delNum = " + paramInt2);
    }
    int i = this.app.b().a(paramString1, 1, false, false);
    if (1 == paramInt1) {}
    for (String str = String.format("shmsgseq in (select shmsgseq from %s order by shmsgseq limit %s)", new Object[] { paramString2, Integer.valueOf(paramInt2) });; str = null)
    {
      if (paramBoolean1) {
        this.app.a(paramInt1).a(paramString1, paramInt1, paramString2, str, null, null);
      }
      return i;
    }
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("COUNT MUST > 0 !");
    }
    System.currentTimeMillis();
    Object localObject2 = this.app.a(paramInt1).l(paramString, paramInt1);
    if ((localObject2 == null) || (((List)localObject2).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
      }
      return new ArrayList();
    }
    long l2 = 0L;
    Object localObject3 = ((List)localObject2).iterator();
    do
    {
      l1 = l2;
      if (!((Iterator)localObject3).hasNext()) {
        break;
      }
      localObject4 = (MessageRecord)((Iterator)localObject3).next();
    } while (((MessageRecord)localObject4).shmsgseq <= 0L);
    long l1 = ((MessageRecord)localObject4).uniseq;
    localObject3 = this.app.a(paramInt1).a(paramString, paramInt1, l1);
    Object localObject4 = a(paramString, paramInt1, (List)localObject2);
    List localList = this.app.a(paramInt1).h(paramString, paramInt1);
    int i;
    int j;
    label222:
    int k;
    if ((localList != null) && (!localList.isEmpty()))
    {
      i = 0;
      if (i < localList.size())
      {
        if (((MessageRecord)localList.get(i)).uniseq != l1) {
          break label1603;
        }
        j = i;
        for (;;)
        {
          label388:
          label692:
          try
          {
            localObject2 = new ArrayList();
            if (localObject3 == null)
            {
              l1 = 0L;
              if (j == 0)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageManager", 2, "refresh cache miss step 0, timestamp = " + System.currentTimeMillis());
                }
                localObject3 = this.app.a(paramInt1);
                if (l1 - paramInt2 < 0L) {
                  break label1612;
                }
                l2 = l1 - paramInt2;
                break label1585;
                label310:
                Object localObject1;
                ((List)localObject2).addAll(((ton)localObject3).e(paramString, paramInt1, l2, localObject1));
                ((List)localObject2).addAll(this.app.a(paramInt1).a(paramString, paramInt1, l1, (Map)localObject4));
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageManager", 2, "refresh cache miss step 1, timestamp = " + System.currentTimeMillis());
                }
                paramString = (TroopManager)this.app.getManager(52);
                paramInt1 = 0;
                if (paramInt1 >= ((List)localObject2).size()) {
                  break label1571;
                }
                localObject3 = (MessageRecord)((List)localObject2).get(paramInt1);
                paramString.b(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).senderuin);
                paramInt1 += 1;
                continue;
              }
            }
            else
            {
              l1 = ((MessageRecord)localObject3).shmsgseq;
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 0, cacheIndex = " + j + " timestamp = " + System.currentTimeMillis());
            }
            if (j < paramInt2) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 1, timestamp = " + System.currentTimeMillis());
            }
            i = j - paramInt2;
            l2 = ((MessageRecord)localList.get(i)).shmsgseq;
            label567:
            if ((i > 0) && (((MessageRecord)localList.get(i - 1)).shmsgseq == ((MessageRecord)localList.get(i)).shmsgseq))
            {
              i -= 1;
              if (!QLog.isColorLevel()) {
                break label1576;
              }
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh same seq  itemListStartPoint= " + i);
              continue;
            }
            if (i != 0) {
              break label1109;
            }
            if (!QLog.isColorLevel()) {
              break label1624;
            }
            QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 2, timestamp = " + System.currentTimeMillis());
          }
          finally {}
          if ((i < localList.size() - 1) && (((MessageRecord)localList.get(i)).shmsgseq == ((MessageRecord)localList.get(i + 1)).shmsgseq))
          {
            k += 1;
            if (!QLog.isColorLevel()) {
              break label1637;
            }
            QLog.d("Q.msg.BaseMessageManager", 2, "refresh same seq  itemListStartPoint= " + k);
            break label1637;
          }
          i = k + 1;
          if (i > j)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 3, size = " + ((List)localObject2).size() + ", timestamp = " + System.currentTimeMillis());
            }
            ((List)localObject2).addAll(this.app.a(paramInt1).a(paramString, paramInt1, l1, (Map)localObject4));
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 4, size = " + ((List)localObject2).size() + ", timestamp = " + System.currentTimeMillis());
            }
          }
          else
          {
            ((List)localObject2).addAll(localList.subList(i, j));
            paramInt2 -= ((List)localObject2).size();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 5, size = " + ((List)localObject2).size() + ", timestamp = " + System.currentTimeMillis());
            }
            localObject3 = this.app.a(paramInt1);
            if (l2 - paramInt2 < 0L) {
              break label1646;
            }
            l1 = l2 - paramInt2;
            label1036:
            ((List)localObject2).addAll(0, ((ton)localObject3).e(paramString, paramInt1, l1, l2));
            if (QLog.isColorLevel())
            {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 6, size = " + ((List)localObject2).size() + ", timestamp = " + System.currentTimeMillis());
              continue;
              label1109:
              ((List)localObject2).addAll(localList.subList(i, j));
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache step 7, size = " + ((List)localObject2).size() + ", timestamp = " + System.currentTimeMillis());
              }
            }
          }
        }
        l2 = ((MessageRecord)localList.get(0)).shmsgseq;
        k = 0;
        i = 0;
        label1203:
        if ((i < localList.size() - 1) && (((MessageRecord)localList.get(i)).shmsgseq == ((MessageRecord)localList.get(i + 1)).shmsgseq))
        {
          k += 1;
          if (!QLog.isColorLevel()) {
            break label1652;
          }
          QLog.d("Q.msg.BaseMessageManager", 2, "refresh same seq  itemListStartPoint= " + k);
          break label1652;
        }
        i = k + 1;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache and DB step 0, sameSeq = " + l2 + ",itemListStartPoint = " + i + ", timestamp = " + System.currentTimeMillis());
        }
        if (i > j)
        {
          ((List)localObject2).addAll(this.app.a(paramInt1).a(paramString, paramInt1, l2, (Map)localObject4));
          label1389:
          paramInt2 -= ((List)localObject2).size();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache and DB step 1, size = " + ((List)localObject2).size() + ", timestamp = " + System.currentTimeMillis());
          }
          localObject3 = this.app.a(paramInt1);
          if (l2 - paramInt2 < 0L) {
            break label1661;
          }
        }
      }
    }
    label1571:
    label1576:
    label1585:
    label1603:
    label1612:
    label1618:
    label1624:
    label1637:
    label1646:
    label1652:
    label1661:
    for (l1 = l2 - paramInt2;; l1 = 0L)
    {
      ((List)localObject2).addAll(0, ((ton)localObject3).e(paramString, paramInt1, l1, l2));
      if (!QLog.isColorLevel()) {
        break label388;
      }
      QLog.d("Q.msg.BaseMessageManager", 2, "refresh read cache and DB step 2, size = " + ((List)localObject2).size() + ", timestamp = " + System.currentTimeMillis());
      break label388;
      ((List)localObject2).addAll(localList.subList(i, j));
      break label1389;
      return localObject2;
      break label567;
      j = 0;
      break label222;
      for (;;)
      {
        if (l1 - 1L < 0L) {
          break label1618;
        }
        l3 = l1 - 1L;
        break label310;
        i += 1;
        break;
        l2 = 0L;
      }
      long l3 = 0L;
      break label310;
      k = j - paramInt2;
      i = k;
      break label692;
      i += 1;
      break label692;
      l1 = 0L;
      break label1036;
      i += 1;
      break label1203;
    }
  }
  
  protected void a(QQMessageFacade.b paramb, int paramInt)
  {
    String str = paramb.uin;
    List localList = this.app.a(paramInt).l(str, paramInt);
    if ((paramb.bCT < 3) && (top.V(localList)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.BaseMessageManager", 2, "refreshHeadComplete : pull more sticker msg");
      }
      paramb.bCT += 1;
      b(str, paramInt, 15, paramb);
      return;
    }
    if ((top.b(str, paramInt, localList)) && (paramb.aQh) && (paramb.bCS < 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "refreshHeadComplete : pull more long msg");
      }
      paramb.bCS += 1;
      b(str, paramInt, 15, paramb);
      return;
    }
    super.a(paramb, paramInt);
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, boolean paramBoolean, QQMessageFacade.b paramb)
  {
    paramb.aQj = false;
    paramb.aQh = true;
    paramb.uin = paramString;
    paramb.uinType = paramInt;
    if ((!paramb.aQl) && (this.b.gQ.containsKey(top.u(paramString, paramInt))))
    {
      this.b.as(paramb);
      return;
    }
    this.b.gQ.put(top.u(paramString, paramInt), Boolean.valueOf(true));
    this.app.execute(new BaseMessageManagerForTroopAndDisc.4(this, paramb, paramString, paramInt, paramLong2, paramLong1, paramBoolean));
  }
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, Bundle paramBundle)
  {
    boolean bool2 = paramBundle.getBoolean("success");
    long l3 = paramBundle.getLong("beginSeq", -1L);
    long l4 = paramBundle.getLong("endSeq", -1L);
    boolean bool3 = paramBundle.getBoolean("key_from_parallel_pull", false);
    List localList;
    Object localObject1;
    Object localObject2;
    int i;
    label112:
    long l1;
    label278:
    long l2;
    label293:
    label329:
    Object localObject3;
    if ((paramInt == 1) && (bool3) && (paramList1 != null) && (!paramList1.isEmpty()))
    {
      localList = a(paramString, paramInt, paramList1.size());
      localObject1 = this.b;
      localObject2 = new StringBuilder().append("refresh roam step 1 , result = ");
      if (paramList1 != null) {
        break label730;
      }
      i = -1;
      ((QQMessageFacade)localObject1).df(i + " , success = " + bool2 + " , beginSeq = " + l3 + " , endSeq = " + l4, " , timestamp = " + System.currentTimeMillis());
      this.b.cP.remove(Integer.valueOf(paramBundle.getInt("counter")));
      if (localList == null) {
        break label1170;
      }
      localObject1 = paramList2;
      if (paramList2 == null) {
        localObject1 = new ArrayList();
      }
      if ((paramList1 == null) || (paramList1.isEmpty())) {
        break label854;
      }
      paramList2 = new ArrayList();
      localObject2 = this.app.a(paramInt);
      if (l3 - 15L <= 0L) {
        break label741;
      }
      l1 = l3 - 15L;
      if (l3 - 1L <= 0L) {
        break label747;
      }
      l2 = l3 - 1L;
      paramList2.addAll(((ton)localObject2).e(paramString, paramInt, l1, l2));
      paramList2.addAll(localList);
      paramList1 = paramList1.iterator();
      if (!paramList1.hasNext()) {
        break label854;
      }
      localObject2 = (MessageRecord)paramList1.next();
      localObject3 = paramList2.iterator();
      do
      {
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
      } while (!top.a((MessageRecord)((Iterator)localObject3).next(), (MessageRecord)localObject2, false, true));
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!bool1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam msg rewrite sending msg  mr.senderuin: " + ((MessageRecord)localObject2).senderuin + " mr.msgtype: " + ((MessageRecord)localObject2).msgtype + " mr.frienduin: " + ((MessageRecord)localObject2).frienduin + " mr.shmsgseq: " + ((MessageRecord)localObject2).shmsgseq + " mr.time:" + ((MessageRecord)localObject2).time + " mr.msg: " + ((MessageRecord)localObject2).getLogColorContent());
        }
        if ((((MessageRecord)localObject2).senderuin != null) && (((MessageRecord)localObject2).senderuin.equalsIgnoreCase(this.app.getCurrentAccountUin())))
        {
          localObject3 = this.b.a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, (MessageRecord)localObject2, paramList2);
          if (localObject3 != null) {
            if (((MessageRecord)localObject3).isValid) {
              break label1197;
            }
          }
        }
      }
      label1157:
      label1170:
      label1197:
      for (paramInt = 1;; paramInt = 0)
      {
        this.b.a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject3).uniseq, ((MessageRecord)localObject2).shmsgseq, ((MessageRecord)localObject2).time);
        if (((MessageRecord)localObject3).msgtype == -2017)
        {
          byte[] arrayOfByte = top.a((MessageRecord)localObject3, (MessageRecord)localObject2);
          this.b.c(((MessageRecord)localObject2).frienduin, 1, ((MessageRecord)localObject3).uniseq, arrayOfByte);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam text msg rewrite success");
        }
        if (paramInt == 0) {
          break label329;
        }
        ((MessageRecord)localObject3).shmsgseq = ((MessageRecord)localObject2).shmsgseq;
        ((MessageRecord)localObject3).time = ((MessageRecord)localObject2).time;
        ((MessageRecord)localObject3).extraflag = 0;
        this.app.a().a().Y((MessageRecord)localObject3);
        break label329;
        localList = (List)this.b.cP.get(Integer.valueOf(paramBundle.getInt("counter")));
        break;
        label730:
        i = paramList1.size();
        break label112;
        label741:
        l1 = 0L;
        break label278;
        label747:
        l2 = 0L;
        break label293;
        ((List)localObject1).add(localObject2);
        if (!QLog.isColorLevel()) {
          break label329;
        }
        QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam step 2 , mr.msg = " + ((MessageRecord)localObject2).getLogColorContent() + " , mr.seq = " + ((MessageRecord)localObject2).shmsgseq + " , mr.msgtype = " + ((MessageRecord)localObject2).msgtype + ", isExist = " + bool1 + " , extra = " + ((MessageRecord)localObject2).extraflag);
        break label329;
        label854:
        paramBundle.putBoolean("success", bool2);
        if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
          this.app.a(((MessageRecord)((List)localObject1).get(0)).istroop).b((List)localObject1, null);
        }
        paramList1 = ((List)localObject1).iterator();
        while (paramList1.hasNext())
        {
          paramList2 = (MessageRecord)paramList1.next();
          if (paramList2.getId() < 0L) {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.BaseMessageManager", 2, "refresh insert db error ! , mr.msg = " + paramList2.getLogColorContent() + " , mr.seq = " + paramList2.shmsgseq + " , mr.uniseq = " + paramList2.uniseq + " , extra = " + paramList2.extraflag);
            }
          }
          for (;;)
          {
            if ((!(paramList2 instanceof MessageForShortVideo)) || (((MessageForShortVideo)paramList2).redBagType != LocalMediaInfo.REDBAG_TYPE_GET)) {
              break label1157;
            }
            paramList2 = (MessageForShortVideo)paramList2;
            VideoRedbagData.insertData(paramList2.shortVideoId, paramList2.uniseq, paramList2.redBagStat);
            break;
            top.c(localList, paramList2, true);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam step 3 , mr.msg = " + paramList2.getLogColorContent() + " , mr.seq = " + paramList2.shmsgseq + " , mr.uniseq = " + paramList2.uniseq + " , extra = " + paramList2.extraflag);
            }
          }
        }
        try
        {
          localList.notify();
          if (bool3) {
            this.b.a().v(paramString, l3, l4);
          }
          return;
        }
        finally {}
      }
    }
  }
  
  public boolean a(String paramString1, int paramInt, List<MessageRecord> paramList, String paramString2)
  {
    if ((paramList != null) && (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refresh autopull step 0 , FAIL! , timestamp = " + System.currentTimeMillis());
      }
    }
    do
    {
      return false;
      this.b.cQ.put(top.u(paramString1, paramInt), Boolean.valueOf(true));
      paramString1 = this.app.a(paramInt).l(paramString1, paramInt);
    } while ((paramString1 == null) || (paramString1.isEmpty()));
    paramList = top.d(paramList, true);
    int i;
    if (((MessageRecord)paramList.get(0)).shmsgseq <= ((MessageRecord)paramString1.get(paramString1.size() - 1)).shmsgseq + 1L)
    {
      i = 1;
      if (i == 0) {
        break label276;
      }
      paramInt = 0;
      label151:
      if (paramInt >= paramList.size()) {
        break label300;
      }
      if (((MessageRecord)paramList.get(paramInt)).shmsgseq <= ((MessageRecord)paramString1.get(paramString1.size() - 1)).shmsgseq) {
        break label269;
      }
    }
    for (;;)
    {
      paramList = paramList.subList(paramInt, paramList.size());
      if ((!paramList.isEmpty()) && (((MessageRecord)paramString1.get(0)).shmsgseq <= ((MessageRecord)paramList.get(0)).shmsgseq)) {
        this.b.s(paramList, paramString2);
      }
      for (;;)
      {
        return true;
        i = 0;
        break;
        label269:
        paramInt += 1;
        break label151;
        label276:
        this.app.a(paramInt).bEs();
        this.b.s(paramList, paramString2);
      }
      label300:
      paramInt = 0;
    }
  }
  
  protected abstract String at(String paramString1, String paramString2);
  
  protected abstract String au(String paramString1, String paramString2);
  
  public long b(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.shmsgseq;
  }
  
  public void b(String paramString, int paramInt1, int paramInt2, QQMessageFacade.b paramb)
  {
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("COUNT MUST > 0 !");
    }
    Object localObject1 = this.app.a(paramInt1).l(paramString, paramInt1);
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
      }
      paramb.pX = null;
      a(paramb, paramInt1);
      return;
    }
    localObject1 = ((List)localObject1).iterator();
    Object localObject2;
    long l3;
    int i;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageRecord)((Iterator)localObject1).next();
      if (((MessageRecord)localObject2).shmsgseq > 0L)
      {
        l3 = ((MessageRecord)localObject2).uniseq;
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO Head is Invalid !!");
        }
        paramb.pX = null;
        a(paramb, paramInt1);
        return;
      }
      MessageRecord localMessageRecord1 = this.app.a(paramInt1).a(paramString, paramInt1, l3);
      long l1;
      if (localMessageRecord1 == null)
      {
        l1 = 0L;
        if (localMessageRecord1 != null) {
          break label305;
        }
      }
      long l2;
      label305:
      for (int j = 3;; j = localMessageRecord1.versionCode)
      {
        localObject2 = a(paramString, paramInt1, paramInt2);
        i = 0;
        if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
          break label1908;
        }
        int k = ((List)localObject2).size() - 1;
        l2 = l1;
        i = 0;
        while ((k >= 0) && (l2 - ((MessageRecord)((List)localObject2).get(k)).shmsgseq <= 1L))
        {
          l2 = ((MessageRecord)((List)localObject2).get(k)).shmsgseq;
          i += 1;
          k -= 1;
        }
        l1 = localMessageRecord1.shmsgseq;
        break;
      }
      for (;;)
      {
        long l4 = l2 - 1L;
        long l5;
        long l6;
        if (paramInt2 - i < 0)
        {
          i = 0;
          l5 = 1L + (l4 - i);
          l6 = this.app.a().j(paramString, paramInt1);
          i = 1;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "refresh breakpoint step 0, delSeq = " + l6 + ", endSeq = " + l4 + ",beginSeq = " + l5 + ",lastContinuedSeq = " + l2 + ",localSeqEnd = " + l1 + ", timestamp = " + System.currentTimeMillis());
          }
          if (l4 <= 0L)
          {
            paramb.isComplete = true;
            i = 0;
          }
          if (l4 > l6) {
            break label659;
          }
          paramb.isComplete = true;
          i = 0;
          l1 = l5;
        }
        for (;;)
        {
          label484:
          l2 = l1;
          if (l1 < 0L) {
            l2 = 0L;
          }
          localObject1 = new ArrayList();
          Iterator localIterator = ((List)localObject2).iterator();
          Object localObject3;
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label767;
            }
            localObject3 = (MessageRecord)localIterator.next();
            if (((MessageRecord)localObject3).shmsgseq < l2)
            {
              ((List)localObject1).add(localObject3);
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh breakpoint invalid: id = " + ((MessageRecord)localObject3).getId() + ", msg = " + ((MessageRecord)localObject3).getLogColorContent() + " , msgtime = " + ((MessageRecord)localObject3).time + " , shMsgSeq = " + ((MessageRecord)localObject3).shmsgseq + " , extra = " + ((MessageRecord)localObject3).extraflag);
              continue;
              i = paramInt2 - i;
              break;
              label659:
              if (l5 > l6) {
                break label1901;
              }
              l1 = l6 + 1L;
              break label484;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh breakpoint valid: id = " + ((MessageRecord)localObject3).getId() + ", msg = " + ((MessageRecord)localObject3).getLogColorContent() + " , msgtime = " + ((MessageRecord)localObject3).time + " , shMsgSeq = " + ((MessageRecord)localObject3).shmsgseq + " , extra = " + ((MessageRecord)localObject3).extraflag);
            }
          }
          label767:
          ((List)localObject2).removeAll((Collection)localObject1);
          ((List)localObject1).clear();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "refresh breakpoint step 1, size = " + ((List)localObject2).size() + ", timestamp = " + System.currentTimeMillis());
          }
          boolean bool2 = true;
          boolean bool1 = bool2;
          if (!paramb.aQg)
          {
            bool1 = bool2;
            if (l4 >= l2)
            {
              bool1 = bool2;
              if (l4 > 0L)
              {
                bool1 = bool2;
                if (i != 0)
                {
                  localObject1 = new Bundle();
                  i = this.b.ax.addAndGet(1);
                  ((Bundle)localObject1).putInt("counter", i);
                  ((Bundle)localObject1).putBoolean("success", false);
                  this.b.cP.put(Integer.valueOf(i), localObject2);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam step 0 , timestamp = " + System.currentTimeMillis());
                  }
                  if (paramInt1 == 3000) {
                    this.app.a().a(Long.valueOf(paramString).longValue(), l2, l4, true, (Bundle)localObject1);
                  }
                  for (;;)
                  {
                    this.b.cQ.put(top.u(paramString, paramInt1), Boolean.valueOf(false));
                    if (aqiw.isNetworkAvailable(BaseApplication.getContext())) {}
                    try
                    {
                      localObject2.wait(35000L);
                      bool1 = ((Bundle)localObject1).getBoolean("success");
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam step 4 , size = " + ((List)localObject2).size() + " , timestamp = " + System.currentTimeMillis());
                      }
                      if ((this.b.cQ.containsKey(top.u(paramString, paramInt1))) && (((Boolean)this.b.cQ.get(top.u(paramString, paramInt1))).booleanValue()))
                      {
                        this.b.df("get auto pull msg when pull refresh !", ", timestamp = " + System.currentTimeMillis());
                        paramb.pX = null;
                        a(paramb, paramInt1);
                        return;
                        if (paramInt1 != 1) {
                          continue;
                        }
                        this.app.a().a(paramString, l2, l4, true, (Bundle)localObject1, 0);
                      }
                    }
                    catch (InterruptedException localInterruptedException)
                    {
                      for (;;)
                      {
                        localInterruptedException.printStackTrace();
                      }
                    }
                    finally {}
                  }
                }
              }
            }
          }
          if (((((List)localObject2).isEmpty()) && (l4 > 0L)) || ((!bool1) && (((List)localObject2).size() < paramInt2)))
          {
            l1 = l4;
            if (!((List)localObject2).isEmpty())
            {
              HashMap localHashMap = new HashMap();
              localObject3 = ((List)localObject2).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                MessageRecord localMessageRecord2 = (MessageRecord)((Iterator)localObject3).next();
                if (localMessageRecord2.shmsgseq == ((MessageRecord)((List)localObject2).get(0)).shmsgseq)
                {
                  StringBuilder localStringBuilder = new StringBuilder();
                  if (localMessageRecord2.getId() > 0L) {}
                  for (localObject1 = "id&" + localMessageRecord2.getId();; localObject1 = "uniseq&" + localMessageRecord2.uniseq)
                  {
                    localHashMap.put((String)localObject1 + "&" + localMessageRecord2.shmsgseq, localMessageRecord2);
                    break;
                  }
                }
              }
              ((List)localObject2).addAll(0, this.app.a(paramInt1).a(paramString, paramInt1, ((MessageRecord)((List)localObject2).get(0)).shmsgseq, localHashMap));
              l1 = ((MessageRecord)((List)localObject2).get(0)).shmsgseq - 1L;
            }
            localObject1 = this.app.a(paramInt1);
            if (localMessageRecord1 == null)
            {
              l2 = 0L;
              localObject1 = ((ton)localObject1).a(paramString, paramInt1, l2, j, l1, paramInt2 - ((List)localObject2).size(), null);
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam fail step 0 , size = " + ((List)localObject1).size() + ",seq = " + l1 + " , timestamp = " + System.currentTimeMillis());
              }
              if (!((List)localObject1).isEmpty()) {
                break label1795;
              }
              paramb.isComplete = true;
              label1633:
              paramb.aQg = true;
              label1639:
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg", 2, "context.isLocalOnly = " + paramb.aQg);
              }
              fn((List)localObject2);
              this.app.a(paramInt1).d(paramString, paramInt1, (List)localObject2);
              paramb.pX = ((List)localObject2);
              paramString = this.b;
              localObject1 = new StringBuilder().append("refresh finish , context = ").append(paramb).append(" , size = ");
              if (localObject2 != null) {
                break label1890;
              }
            }
          }
          label1795:
          label1890:
          for (paramInt2 = -1;; paramInt2 = ((List)localObject2).size())
          {
            paramString.df(paramInt2, ", timestamp = " + System.currentTimeMillis());
            a(paramb, paramInt1);
            return;
            l2 = localMessageRecord1.getId();
            break;
            ((List)localObject2).addAll(0, (Collection)localObject1);
            break label1633;
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refresh roam addRoamMsgToList uniseq = " + l3 + " , locallist = " + ((List)localObject2).size() + " , timestamp = " + System.currentTimeMillis());
            }
            this.app.a(paramInt1).a(paramString, paramInt1, l3, (List)localObject2);
            break label1639;
          }
          label1901:
          l1 = l5;
        }
        label1908:
        l2 = l1;
      }
      i = 0;
      l3 = 0L;
    }
  }
  
  public boolean b(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager.troop.revoked_troop_msg", 2, "cleanBizTypeMarkForMsgRevoke==>uin:" + paramString + "|type:" + paramInt + "|seqFrom:" + paramLong);
    }
    if ((paramString == null) || (paramLong < 0L)) {
      return false;
    }
    acxw localacxw = this.app.a().a();
    RecentUser localRecentUser = localacxw.a(paramString, paramInt);
    apnu localapnu;
    if ((localRecentUser != null) && (localRecentUser.shouldShowInRecentList(this.app)))
    {
      localapnu = (apnu)this.app.getManager(363);
      if ((!(localRecentUser.msg instanceof aalj)) || (((aalj)localRecentUser.msg).a.shmsgseq != paramLong)) {
        break label196;
      }
    }
    label196:
    for (int i = apmu.jK(localRecentUser.msgType);; i = -1)
    {
      if (i == -1) {
        return false;
      }
      localRecentUser.cleanMsgAndMsgData(localRecentUser.msgType);
      localacxw.e(localRecentUser);
      localapnu.aJ(paramString, paramInt, i);
      return true;
      return false;
    }
  }
  
  public void bM(String paramString, int paramInt)
  {
    if (paramInt <= 0) {}
    Object localObject1;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "pullTroopMsgParallelInSilence, start...count:" + paramInt);
      }
      apdd.aqY = System.currentTimeMillis();
      localObject1 = this.app.a(1).l(paramString, 1);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "refreshTroopMessageListHead ERROR: AIO is closed !!");
    return;
    long l1 = 0L;
    Object localObject2 = ((List)localObject1).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (MessageRecord)((Iterator)localObject2).next();
      if (((MessageRecord)localObject3).shmsgseq > 0L) {
        l1 = ((MessageRecord)localObject3).uniseq;
      }
    }
    for (int i = 1;; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "aioMsgList size:" + ((List)localObject1).size());
      }
      if (i == 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshTroopMessageListHead ERROR: AIO Head is Invalid !!");
        return;
      }
      localObject1 = this.app.a(1).a(paramString, 1, l1);
      if (localObject1 == null) {}
      long l2;
      for (l1 = 0L;; l1 = ((MessageRecord)localObject1).shmsgseq)
      {
        localObject1 = a(paramString, 1, paramInt);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "lastContinuedSeq:" + l1 + " locallist size:" + ((List)localObject1).size());
        }
        i = 0;
        if (((List)localObject1).isEmpty()) {
          break label1270;
        }
        int j = ((List)localObject1).size() - 1;
        l2 = l1;
        i = 0;
        while ((j >= 0) && (l2 - ((MessageRecord)((List)localObject1).get(j)).shmsgseq <= 1L))
        {
          l2 = ((MessageRecord)((List)localObject1).get(j)).shmsgseq;
          i += 1;
          j -= 1;
        }
      }
      for (;;)
      {
        long l4 = l2 - 1L;
        long l3;
        long l5;
        if (paramInt - i < 0)
        {
          paramInt = 0;
          l3 = 1L + (l4 - paramInt);
          l5 = this.app.a().j(paramString, 1);
          paramInt = 1;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "refresh breakpoint step 0, delSeq = " + l5 + ", endSeq = " + l4 + ",beginSeq = " + l3 + ",lastContinuedSeq = " + l2 + ",localSeqEnd = " + l1 + ", timestamp = " + System.currentTimeMillis());
          }
          if (l4 <= 0L) {
            paramInt = 0;
          }
          if (l4 > l5) {
            break label705;
          }
          l1 = l3;
          paramInt = 0;
        }
        for (;;)
        {
          label535:
          if (l1 < 0L) {
            l1 = 0L;
          }
          for (;;)
          {
            for (;;)
            {
              localObject2 = new ArrayList();
              localObject3 = ((List)localObject1).iterator();
              for (;;)
              {
                if (!((Iterator)localObject3).hasNext()) {
                  break label814;
                }
                MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
                if (localMessageRecord.shmsgseq < l1)
                {
                  ((List)localObject2).add(localMessageRecord);
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "refresh breakpoint invalid: id = " + localMessageRecord.getId() + ", msg = " + localMessageRecord.getLogColorContent() + " , msgtime = " + localMessageRecord.time + " , shMsgSeq = " + localMessageRecord.shmsgseq + " , extra = " + localMessageRecord.extraflag);
                  continue;
                  paramInt -= i;
                  break;
                  label705:
                  if (l3 > l5) {
                    break label1263;
                  }
                  l1 = 1L + l5;
                  break label535;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "refresh breakpoint valid: id = " + localMessageRecord.getId() + ", msg = " + localMessageRecord.getLogColorContent() + " , msgtime = " + localMessageRecord.time + " , shMsgSeq = " + localMessageRecord.shmsgseq + " , extra = " + localMessageRecord.extraflag);
                }
              }
              label814:
              ((List)localObject1).removeAll((Collection)localObject2);
              ((List)localObject2).clear();
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "refresh breakpoint step 1, size = " + ((List)localObject1).size() + ", timestamp = " + System.currentTimeMillis());
              }
              if ((l4 < l1) || (l4 <= 0L) || (paramInt == 0)) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "refresh roam step 0 , timestamp = " + System.currentTimeMillis() + " beginSeq:" + l1 + " endSeq:" + l4);
              }
              l2 = (l4 - l1) / 20L;
              if ((l4 - l1) % 20L == 0L) {}
              for (paramInt = 0;; paramInt = 1)
              {
                l2 = paramInt;
                localObject2 = new Bundle();
                ((Bundle)localObject2).putBoolean("key_from_parallel_pull", true);
                ((Bundle)localObject2).putBoolean("success", false);
                paramInt = 0;
                while (l1 < l4)
                {
                  ThreadManager.post(new BaseMessageManagerForTroopAndDisc.1(this, l1 + 19L, l4, paramInt, l1, paramString, (Bundle)localObject2), 8, null, false);
                  l1 += 20L;
                  paramInt += 1;
                }
              }
              this.b.cQ.put(top.u(paramString, 1), Boolean.valueOf(false));
              if (aqiw.isNetworkAvailable(BaseApplication.getContext())) {}
              try
              {
                localObject1.wait(35000L);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "refresh roam step 4 , size = " + ((List)localObject1).size() + " , timestamp = " + System.currentTimeMillis());
                }
                if ((!this.b.cQ.containsKey(top.u(paramString, 1))) || (!((Boolean)this.b.cQ.get(top.u(paramString, 1))).booleanValue())) {
                  break;
                }
                this.b.df("get auto pull msg when pull refresh !", ", timestamp = " + System.currentTimeMillis());
                return;
              }
              catch (InterruptedException localInterruptedException)
              {
                for (;;)
                {
                  localInterruptedException.printStackTrace();
                }
              }
              finally {}
            }
          }
          label1263:
          l1 = l3;
        }
        label1270:
        l2 = l1;
      }
    }
  }
  
  protected void c(QQMessageFacade.Message paramMessage)
  {
    paramMessage.nickName = at(paramMessage.senderuin, paramMessage.frienduin);
  }
  
  protected void d(QQMessageFacade.Message paramMessage)
  {
    paramMessage.nickName = au(paramMessage.senderuin, paramMessage.frienduin);
  }
  
  public void k(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "updateTroopUnread uin=" + paramString + ",type=" + paramInt + ",from=" + paramLong);
    }
    if (paramLong < 0L) {}
    do
    {
      return;
      if (paramString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageManager", 2, "updateTroopUnread return : uin=null");
    return;
    this.app.a().o(paramString, paramInt, paramLong);
    this.b.as(this.b.a(paramString, paramInt));
  }
  
  protected void l(String paramString, int paramInt, long paramLong)
  {
    if ((paramString == null) || (paramLong < 0L) || (this.app == null)) {}
    acxw localacxw;
    RecentUser localRecentUser;
    do
    {
      return;
      localacxw = this.app.a().a();
      localRecentUser = localacxw.a(paramString, paramInt);
    } while ((localRecentUser == null) || (!localRecentUser.shouldShowInRecentList(this.app)) || (!(localRecentUser.msg instanceof aalj)) || (((aalj)localRecentUser.msg).a.shmsgseq > paramLong));
    int i;
    if ((paramInt == 1) && ((localRecentUser.msg instanceof aalz)))
    {
      aptq localaptq = aptr.a(this.app, paramString);
      if ((localaptq != null) && (localaptq.dVP == 1))
      {
        i = 1;
        label129:
        if (i == 0)
        {
          if (aizp.a().J(this.app, paramString)) {
            break label319;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "TroopNotificationMsg, cleanMsgAndMsgData");
          }
          localRecentUser.cleanMsgAndMsgData(localRecentUser.msgType);
          localacxw.e(localRecentUser);
        }
      }
    }
    for (;;)
    {
      ((apnu)this.app.getManager(363)).aJ(paramString, paramInt, 0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "cleanBizTypeMark TYPE_ALL_MSG type = " + paramInt + ", seqFrom = " + paramLong);
      }
      if (paramInt != 1) {
        break;
      }
      paramInt = this.app.cs(paramString);
      if ((paramInt == 1) || (paramInt == 4)) {
        break;
      }
      aajt.a().Av(localRecentUser.uin + "-" + localRecentUser.getType());
      this.b.a(localRecentUser);
      return;
      i = 0;
      break label129;
      label319:
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "TroopNotificationMsg, delRecentUser");
      }
      localacxw.b(localRecentUser, false);
      continue;
      localRecentUser.cleanMsgAndMsgData(localRecentUser.msgType);
      localacxw.e(localRecentUser);
    }
  }
  
  public void r(String paramString, ArrayList<MessageRecord> paramArrayList)
  {
    int k = -1;
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    int i = 0;
    while (paramArrayList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramArrayList.next();
      aozx localaozx = localMessageRecord.mMessageInfo;
      if ((localaozx != null) && (!localMessageRecord.isread))
      {
        if (localMessageRecord.istroop == 1) {}
        for (boolean bool = true;; bool = false)
        {
          acxw localacxw = this.app.a().a();
          RecentUser localRecentUser = localacxw.a(paramString, localMessageRecord.istroop);
          if (!localaozx.aAH()) {
            break;
          }
          int n = localaozx.b(this.app, bool, localMessageRecord.frienduin);
          int m = k;
          int j = i;
          if (aozx.bq(n, localRecentUser.msgType))
          {
            localRecentUser.msgType = n;
            localRecentUser.msg = apnt.a(this.app, paramString, localaozx, localRecentUser.msg, localMessageRecord, bool);
            localacxw.e(localRecentUser);
            m = localMessageRecord.istroop;
            j = 1;
          }
          k = m;
          i = j;
          if (!bool) {
            break;
          }
          if (n != 24)
          {
            k = m;
            i = j;
            if (n != 22) {
              break;
            }
          }
          k = m;
          i = j;
          if (jof.a(localMessageRecord)) {
            break;
          }
          k = m;
          i = j;
          if (!apuh.Y(this.app, "atMeOrReplyMe")) {
            break;
          }
          localArrayList.add(localMessageRecord);
          k = m;
          i = j;
          break;
        }
      }
    }
    if (localArrayList.size() > 0)
    {
      ThreadManager.getSubThreadHandler().post(new BaseMessageManagerForTroopAndDisc.2(this, localArrayList));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "markAtOrReplyMeMsgInTroop_" + localArrayList.size());
      }
    }
    if (i != 0) {
      this.b.as(this.b.a(paramString, k));
    }
  }
  
  public void v(MessageRecord paramMessageRecord)
  {
    long l = System.currentTimeMillis();
    ThreadManager.post(new BaseMessageManagerForTroopAndDisc.3(this, paramMessageRecord, this.app.a().aT(paramMessageRecord), l), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tnu
 * JD-Core Version:    0.7.0.1
 */