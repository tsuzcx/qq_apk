import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.C2CMessageManager.1;
import com.tencent.imcore.message.C2CMessageManager.2;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.imcore.message.QQMessageFacade.b;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UinType;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class toa
  extends tnt
{
  public toa(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, tom paramtom)
  {
    super(paramQQAppInterface, paramQQMessageFacade, paramtom);
  }
  
  private ArrayList<MessageRecord> a(String paramString, List<MessageRecord> paramList1, List<MessageRecord> paramList2, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    this.b.df("C2CMsgFilter basetime=" + paramLong1 + ",lowtime=" + paramLong2, "");
    if ((paramList1 == null) || (paramList1.isEmpty())) {
      return localArrayList;
    }
    Object localObject1 = paramList1.iterator();
    long l2 = 9223372036854775807L;
    long l1 = -1L;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageRecord)((Iterator)localObject1).next();
      if (l2 < ((MessageRecord)localObject2).time) {
        break label768;
      }
      l2 = ((MessageRecord)localObject2).time;
    }
    label768:
    for (;;)
    {
      if (l1 <= ((MessageRecord)localObject2).time) {
        l1 = ((MessageRecord)localObject2).time;
      }
      for (;;)
      {
        break;
        localObject2 = b(paramString, 0, l2 - 30L, l1 + 30L);
        MessageRecord localMessageRecord1;
        MessageRecord localMessageRecord2;
        if (paramList2 == null)
        {
          localObject1 = null;
          localMessageRecord1 = anbi.d(-1000);
          localMessageRecord2 = anbi.d(-1000);
          paramList1 = paramList1.iterator();
        }
        label391:
        label763:
        for (;;)
        {
          MessageRecord localMessageRecord3;
          boolean bool;
          if (paramList1.hasNext())
          {
            localMessageRecord3 = (MessageRecord)paramList1.next();
            localMessageRecord3.time -= 30L;
            localMessageRecord3.time += 30L;
            Object localObject3 = b((List)localObject2, localMessageRecord1.time, localMessageRecord2.time);
            if ((localObject2 == null) || (((List)localObject2).size() == 0))
            {
              localArrayList.add(localMessageRecord3);
              if (localObject1 == null) {
                continue;
              }
              ((List)localObject1).add(localMessageRecord3);
              continue;
              localObject1 = new ArrayList();
              break;
            }
            Object localObject4 = ((List)localObject3).iterator();
            for (;;)
            {
              if (((Iterator)localObject4).hasNext())
              {
                localObject3 = (MessageRecord)((Iterator)localObject4).next();
                if (top.a((MessageRecord)localObject3, localMessageRecord3, true)) {
                  if (QLog.isColorLevel())
                  {
                    localObject4 = new StringBuilder().append("C2CMsgFilter shmsgseq equals?");
                    if (localMessageRecord3.shmsgseq == ((MessageRecord)localObject3).shmsgseq)
                    {
                      bool = true;
                      QLog.i("Q.msg.BaseMessageManager", 2, bool + ",msg=" + localMessageRecord3.getLogColorContent() + "time:" + localMessageRecord3.time + "<->" + ((MessageRecord)localObject3).time + ", type=" + ((MessageRecord)localObject3).msgtype + "-" + localMessageRecord3.msgtype);
                    }
                  }
                  else if ((localObject1 != null) && (paramLong1 != -1L) && (((MessageRecord)localObject3).time <= paramLong1))
                  {
                    ((List)localObject1).add(localObject3);
                  }
                }
              }
            }
          }
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              break label763;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "C2CMsgFilter not eq: msg=" + localMessageRecord3.getLogColorContent() + "time:" + localMessageRecord3.time + ",type:" + localMessageRecord3.msgtype + ",msg.con : " + localMessageRecord3.getLogColorContent());
            }
            if (localObject1 != null) {
              ((List)localObject1).add(localMessageRecord3);
            }
            localArrayList.add(localMessageRecord3);
            break;
            bool = false;
            break label391;
            if ((paramLong1 > 0L) && (localObject1 != null))
            {
              localMessageRecord1.time = paramLong2;
              localMessageRecord2.time = paramLong1;
              paramString = b(paramString, 0, paramLong2, paramLong1).iterator();
              while (paramString.hasNext())
              {
                paramList1 = (MessageRecord)paramString.next();
                if ((!top.fy(paramList1.msgtype)) && (paramList1.time <= paramLong1))
                {
                  this.b.df("addmsg ptt = " + paramList1.getId(), "");
                  top.b((List)localObject1, paramList1, true);
                }
              }
            }
            if (paramList2 != null) {
              paramList2.addAll((Collection)localObject1);
            }
            return localArrayList;
          }
        }
      }
    }
  }
  
  private List<MessageRecord> a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.b paramb, toa.a parama)
  {
    Object localObject2 = this.app.a(paramInt1).l(paramString, paramInt1);
    if ((localObject2 == null) || (((List)localObject2).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "NavigateRefreshMessageListHead ERROR: AIO is closed !!");
      }
      paramb.pX = null;
      a(paramb, paramInt1);
      paramString = paramb.pX;
      return paramString;
    }
    if (localObject2 != null) {
      this.b.a("current Aio", ((List)localObject2).subList(0, Math.min(paramInt2, ((List)localObject2).size())));
    }
    long l2 = ((MessageRecord)((List)localObject2).get(0)).uniseq;
    Object localObject1 = this.app.a().h(paramString);
    long l1;
    label135:
    Object localObject3;
    ArrayList localArrayList2;
    int i;
    if (localObject1 == null)
    {
      l1 = 0L;
      localObject3 = this.app.a(paramInt1).h(paramString, paramInt1);
      localArrayList2 = new ArrayList();
      this.b.df("NavigateRefreshMessageListHead isLocalOnly=" + paramb.aQg + ",uniseq=" + l2 + ",ect=" + l1, " ,getC2CRoamingSetting" + this.app.AK());
      if (this.app.AK() == 0) {
        paramb.aQg = true;
      }
      i = 0;
      label253:
      if (i >= ((List)localObject2).size()) {
        break label2568;
      }
      if (((MessageRecord)((List)localObject2).get(i)).uniseq != l2) {
        break label480;
      }
      label286:
      if (i >= ((List)localObject2).size()) {
        break label2562;
      }
      if (!top.fy(((MessageRecord)((List)localObject2).get(i)).msgtype)) {
        break label471;
      }
      l2 = ((MessageRecord)((List)localObject2).get(i)).uniseq;
      i = 1;
    }
    for (;;)
    {
      if ((paramb.aQg) || (l1 == 0L) || (i == 0))
      {
        b(paramString, paramInt1, l2, paramInt2, paramb, localArrayList2);
        a(localArrayList2, parama);
        fn(localArrayList2);
        this.app.a(paramInt1).d(paramString, paramInt1, localArrayList2);
        paramb.pX = localArrayList2;
        if (paramb.isComplete) {
          bO(paramString, paramInt1);
        }
        paramString = localArrayList2;
        if (!top.V(localArrayList2)) {
          break;
        }
        paramString = localArrayList2;
        if (paramb.bCT >= 3) {
          break;
        }
        a(paramb, paramInt1);
        return localArrayList2;
        l1 = ((Long)((Pair)localObject1).first).longValue();
        break label135;
        label471:
        i += 1;
        break label286;
        label480:
        i += 1;
        break label253;
      }
      i = 0;
      label492:
      if (i < ((List)localObject3).size())
      {
        localObject1 = (MessageRecord)((List)localObject3).get(i);
        if (((MessageRecord)localObject1).uniseq != l2) {}
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "NavigateRefreshMessageListHead cacheIndex:" + i + ", itemList:" + ((List)localObject3).size());
        }
        long l3;
        if (localObject1 == null)
        {
          localObject1 = this.app.a(paramInt1).a(paramString, paramInt1, l2);
          if (localObject1 == null)
          {
            this.b.df("refresh from empty C2C msg", "");
            paramb.isComplete = true;
            paramb.aQg = true;
            paramb.pX = new ArrayList();
            return paramb.pX;
            i += 1;
            break label492;
          }
          l3 = ((MessageRecord)localObject1).time;
          this.b.df("NavigateRefreshMessageListHead uniseq=" + l2 + ", aioBase.getId():" + ((MessageRecord)localObject1).getId(), "");
          localArrayList2.addAll(this.app.a(paramInt1).a(paramString, paramInt1, l3, paramInt2, String.format("time>=%d or (time=%d and _id<%d)", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(((MessageRecord)localObject1).getId()) })));
          this.b.df("NavigateRefreshMessageListHead Db fromTime:" + l3, "");
          this.b.a("only load in db", localArrayList2);
          l2 = l3;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "NavigateRefreshMessageListHead locallist size " + localArrayList2.size());
          }
          if (l1 <= l2) {
            break label2547;
          }
          l1 = Math.min(l2, paramb.EK);
          this.b.df("ect > fromTime!! newEct:" + l1, "");
        }
        label2159:
        label2547:
        for (boolean bool1 = false;; bool1 = true)
        {
          this.b.a("before pull locallist", localArrayList2);
          this.b.df("before pull locallist" + localArrayList2.size(), "");
          if (localArrayList2.size() < paramInt2)
          {
            localObject3 = new Bundle();
            i = this.b.ax.addAndGet(1);
            ((Bundle)localObject3).putInt("counter", i);
            ((Bundle)localObject3).putBoolean("timeout", true);
            ((Bundle)localObject3).putLong("UIN", Long.valueOf(paramString).longValue());
            ((Bundle)localObject3).putBoolean("canUpdateEct", bool1);
            this.b.cP.put(Integer.valueOf(i), localArrayList2);
            Object localObject4 = new ArrayList();
            i = 0;
            Object localObject5;
            while (i < ((List)localObject2).size())
            {
              localObject5 = (MessageRecord)((List)localObject2).get(i);
              if (((MessageRecord)localObject5).time == ((MessageRecord)localObject1).time)
              {
                ((ArrayList)localObject4).add(localObject5);
                i += 1;
                continue;
                l2 = ((MessageRecord)localObject1).time;
                if (i >= paramInt2)
                {
                  j = i - paramInt2;
                  while (j < i)
                  {
                    localObject4 = (MessageRecord)((List)localObject3).get(j);
                    if (((MessageRecord)localObject4).time >= l1) {
                      localArrayList2.add(localObject4);
                    }
                    j += 1;
                  }
                  this.b.a("all in cache", localArrayList2);
                }
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "NavigateRefreshMessageListHead fromTime:" + l2);
                  }
                  break;
                  localObject4 = (MessageRecord)((List)localObject3).get(0);
                  localObject3 = ((List)localObject3).subList(0, i).iterator();
                  while (((Iterator)localObject3).hasNext())
                  {
                    localObject5 = (MessageRecord)((Iterator)localObject3).next();
                    if (((MessageRecord)localObject5).time >= l1) {
                      localArrayList2.add(localObject5);
                    }
                  }
                  this.b.a("cache part", localArrayList2);
                  i = paramInt2 - localArrayList2.size();
                  localArrayList2.addAll(0, this.app.a(paramInt1).a(paramString, paramInt1, ((MessageRecord)localObject4).time, i, String.format("time>=%d or (time=%d and _id<%d)", new Object[] { Long.valueOf(l1), Long.valueOf(((MessageRecord)localObject4).time), Long.valueOf(((MessageRecord)localObject4).getId()) })));
                  this.b.a("cache + db", localArrayList2);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "NavigateRefreshMessageListHead memdb:size:" + localArrayList2.size() + ",miss:" + i);
                  }
                }
              }
            }
            l2 = ((MessageRecord)localObject1).uniseq;
            i = localArrayList2.size();
            if (localArrayList2.isEmpty()) {
              i = paramInt2;
            }
            for (;;)
            {
              ((Bundle)localObject3).putLong("baseTime", l1);
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "pull roam " + i + ",time=" + l1 + ",timeFilterList:" + ((ArrayList)localObject4).size());
              }
              l3 = 0L;
              if (!bool1) {
                l3 = paramb.EL;
              }
              this.app.a().a(paramString, l1, (short)i, (Bundle)localObject3, l3);
              ((Bundle)localObject3).putInt("size_req", i);
              this.b.cQ.put(top.u(paramString, paramInt1), Boolean.valueOf(false));
              try
              {
                localArrayList2.wait(35000L);
                if ((this.b.cQ.containsKey(top.u(paramString, paramInt1))) && (((Boolean)this.b.cQ.get(top.u(paramString, paramInt1))).booleanValue()))
                {
                  paramb.pX = null;
                  this.b.df("get auto pull C2C msg when pull refresh !", ", timestamp = " + System.currentTimeMillis());
                  return paramb.pX;
                  i = paramInt2 - i;
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
            if ((((Bundle)localObject3).getBoolean("timeout")) && (QLog.isColorLevel())) {
              QLog.w("Q.msg.BaseMessageManager", 2, "timeout!");
            }
            this.b.df("after pull locallist" + localArrayList2.size(), "");
            this.b.a("after pull locallist", localArrayList2);
            localArrayList1 = new ArrayList();
            int j = localArrayList2.size() - 1;
            while (j >= 0)
            {
              localObject2 = (MessageRecord)localArrayList2.get(j);
              localObject5 = ((ArrayList)localObject4).iterator();
              while (((Iterator)localObject5).hasNext())
              {
                MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject5).next();
                if (top.a(localMessageRecord, (MessageRecord)localObject2, true))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead filterMr " + localMessageRecord.getLogColorContent() + ",uniseq=" + localMessageRecord.uniseq);
                  }
                  localArrayList1.add(localObject2);
                }
                else if (QLog.isColorLevel())
                {
                  QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead not find filterMr " + localMessageRecord.getLogColorContent() + ",mr=" + ((MessageRecord)localObject2).getLogColorContent());
                }
              }
              j -= 1;
            }
            localArrayList2.removeAll(localArrayList1);
            if (((Bundle)localObject3).getBoolean("timeout")) {
              break label2478;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead " + localArrayList2.size());
            }
            this.app.a(paramInt1).a(paramString, paramInt1, l2, localArrayList2);
            boolean bool2 = ((Bundle)localObject3).getBoolean("success");
            boolean bool3 = ((Bundle)localObject3).getBoolean("complete");
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.BaseMessageManager", 2, "success ?" + bool2 + ", complete?" + bool3);
            }
            if ((!bool2) || (bool3))
            {
              paramb.aQg = true;
              if (!localArrayList2.isEmpty()) {
                break label2450;
              }
              if (!localArrayList2.isEmpty()) {
                break label2467;
              }
              label2167:
              b(paramString, paramInt1, l2, paramInt2, paramb, localArrayList2);
            }
            if (!bool1)
            {
              paramb.EK = ((Bundle)localObject3).getLong("tempEct");
              paramb.EL = ((Bundle)localObject3).getLong("tempRandom");
              this.b.df("update tempEct:" + paramb.EK + ", rand=" + paramb.EL, "");
            }
          }
          fn(localArrayList2);
          a(localArrayList2, parama);
          this.app.a(paramInt1).d(paramString, paramInt1, localArrayList2);
          paramb.pX = localArrayList2;
          if (paramb.isComplete) {
            bO(paramString, paramInt1);
          }
          paramString = this.b;
          parama = new StringBuilder().append("refresh C2C finish , context = ").append(paramb).append(" , size = ");
          if (localArrayList2 == null) {}
          for (paramInt2 = -1;; paramInt2 = localArrayList2.size())
          {
            paramString.df(paramInt2, ", timestamp = " + System.currentTimeMillis());
            paramString = localArrayList2;
            if (!top.V(localArrayList2)) {
              break;
            }
            paramString = localArrayList2;
            if (paramb.bCT >= 3) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.msg.BaseMessageManager", 2, "refresh C2C finish, now rePull sticker msg! " + paramb.bCT);
            }
            a(paramb, paramInt1);
            return localArrayList2;
            l2 = ((MessageRecord)localArrayList2.get(0)).uniseq;
            break label2159;
            paramInt2 -= localArrayList2.size();
            break label2167;
            this.b.df("pull timeout", "");
            paramb.aQg = true;
            if (localArrayList2.isEmpty()) {}
            for (;;)
            {
              b(paramString, paramInt1, l2, i, paramb, localArrayList2);
              break;
              l2 = ((MessageRecord)localArrayList2.get(0)).uniseq;
            }
          }
        }
        label2450:
        label2467:
        label2478:
        i = 0;
        ArrayList localArrayList1 = null;
      }
      label2562:
      i = 0;
      continue;
      label2568:
      i = 0;
    }
  }
  
  private List<MessageRecord> a(String paramString, List<MessageRecord> paramList, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = a(paramString, paramList, localArrayList, paramLong1, paramLong2);
    this.b.a("needSave", paramString);
    this.b.a("msgInDB", localArrayList);
    if ((paramString != null) && (!paramString.isEmpty())) {
      this.app.a(((MessageRecord)paramString.get(0)).istroop).b(paramString, null);
    }
    paramList = paramString.iterator();
    label428:
    while (paramList.hasNext())
    {
      Object localObject = (MessageRecord)paramList.next();
      MessageRecord localMessageRecord;
      if (((MessageRecord)localObject).getId() < 0L)
      {
        this.b.df("refresh C2C insert db error ! , mr.seq = " + ((MessageRecord)localObject).shmsgseq + " , mr.uniseq = " + ((MessageRecord)localObject).uniseq + ", mr.uid=" + ((MessageRecord)localObject).msgUid, "mr.msg = " + ((MessageRecord)localObject).getLogColorContent());
        localMessageRecord = b((MessageRecord)localObject);
        if (localMessageRecord == null) {
          localArrayList.remove(localObject);
        }
      }
      for (;;)
      {
        if ((!(localObject instanceof MessageForShortVideo)) || (((MessageForShortVideo)localObject).redBagType != LocalMediaInfo.REDBAG_TYPE_GET)) {
          break label428;
        }
        localObject = (MessageForShortVideo)localObject;
        VideoRedbagData.insertData(((MessageForShortVideo)localObject).shortVideoId, ((MessageForShortVideo)localObject).uniseq, ((MessageForShortVideo)localObject).redBagStat);
        break;
        this.b.df("refresh C2C insert db error ! , m.seq = " + localMessageRecord.shmsgseq + " , mr.uniseq = " + localMessageRecord.uniseq + ", m.uid=" + localMessageRecord.msgUid, "");
        localArrayList.set(localArrayList.indexOf(localObject), localMessageRecord);
        continue;
        this.b.df("refresh C2C roam step 3 , mr.seq = " + ((MessageRecord)localObject).shmsgseq + " , mr.uniseq = " + ((MessageRecord)localObject).uniseq, "mr.msg = " + ((MessageRecord)localObject).getLogColorContent());
      }
    }
    this.b.df("setC2CRoamMessageResult needsave=" + paramString.size(), "");
    return localArrayList;
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString1, String paramString2)
  {
    MessageRecord localMessageRecord = anbi.d(paramMessageRecord.msgtype);
    MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
    localMessageRecord.senderuin = paramString2;
    localMessageRecord.frienduin = paramString1;
    if (TextUtils.equals(acbn.bkE, paramString1)) {
      paramMessageRecord.saveExtInfoToExtStr("msg_in_box", "msg_in_box");
    }
    if (top.eD(paramMessageRecord.istroop) == 1032) {}
    for (localMessageRecord.istroop = 1032;; localMessageRecord.istroop = paramMessageRecord.istroop)
    {
      if (!top.fz(paramMessageRecord.msgtype))
      {
        this.app.a(paramMessageRecord.istroop).a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.senderuin, localMessageRecord.selfuin, localMessageRecord.getExtraKey());
        a(localMessageRecord, null, false, true, 1);
      }
      return;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.b paramb, ArrayList<MessageRecord> paramArrayList, MessageRecord paramMessageRecord, long paramLong)
  {
    int i = paramArrayList.size();
    toj localtoj = paramb.a;
    if ((localtoj != null) && (!localtoj.a(paramString, paramInt1, paramInt2, paramb, paramArrayList, paramMessageRecord, paramLong)))
    {
      this.b.df("get roam msg failed", "");
      paramb.aQg = true;
      if (!paramArrayList.isEmpty()) {
        break label102;
      }
      if (paramMessageRecord != null) {
        break label92;
      }
      paramLong = 0L;
    }
    for (;;)
    {
      a(paramString, paramInt1, paramLong, paramInt2 - i, paramb, paramArrayList, false);
      return;
      label92:
      paramLong = paramMessageRecord.uniseq;
      continue;
      label102:
      paramLong = ((MessageRecord)paramArrayList.get(0)).uniseq;
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList, toa.a parama)
  {
    ArrayList localArrayList = new ArrayList();
    MessageRecord localMessageRecord;
    if (paramArrayList != null)
    {
      Iterator localIterator = paramArrayList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localMessageRecord = (MessageRecord)localIterator.next();
      } while ((top.t(localMessageRecord)) || (localMessageRecord.msgUid != parama.origUid) || (localMessageRecord.time != parama.time));
    }
    for (int i = paramArrayList.indexOf(localMessageRecord);; i = -1)
    {
      int j = i;
      if (i == -1) {
        return;
      }
      while (j < paramArrayList.size())
      {
        localArrayList.add(paramArrayList.get(j));
        j += 1;
      }
      paramArrayList.clear();
      paramArrayList.addAll(localArrayList);
      return;
    }
  }
  
  private MessageRecord b(MessageRecord paramMessageRecord)
  {
    return this.app.a(paramMessageRecord.istroop).a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.time, paramMessageRecord.senderuin, paramMessageRecord.msg);
  }
  
  private List<MessageRecord> b(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return a(paramString, paramInt, Math.min(paramLong1, paramLong2), Math.max(paramLong1, paramLong2));
  }
  
  private List<MessageRecord> b(List<MessageRecord> paramList, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty())) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if ((localMessageRecord.time > paramLong1) && (localMessageRecord.time < paramLong2)) {
        localArrayList.add(localMessageRecord);
      }
    }
    return localArrayList;
  }
  
  private void bO(String paramString, int paramInt)
  {
    if ((1000 == paramInt) || (1004 == paramInt))
    {
      paramString = this.app.b().f(paramString, paramInt);
      if ((paramString != null) && (!paramString.isEmpty())) {
        break label41;
      }
    }
    label41:
    ChatMessage localChatMessage;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = paramString.iterator();
      }
      localChatMessage = (ChatMessage)localIterator.next();
    } while ((localChatMessage.isSend()) || (top.fz(localChatMessage.msgtype)));
    ((ChatMessage)paramString.get(0)).mNeedGrayTips = true;
  }
  
  protected Map<String, List<MessageRecord>> T()
  {
    return this.a.T();
  }
  
  List<MessageRecord> a(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    Object localObject = this.app.a(paramInt).h(paramString, paramInt);
    ArrayList localArrayList = new ArrayList();
    if (localObject != null) {
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      MessageRecord localMessageRecord;
      if (((Iterator)localObject).hasNext())
      {
        localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((localMessageRecord.time < paramLong1) || (localMessageRecord.time > paramLong2)) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "getTempListFromDB fromCache=" + localArrayList.size());
        }
        paramString = this.app.a(paramInt).a(paramString, paramInt, paramLong2, -1, String.format("time>=%d or time=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "getTempListFromDB from=" + paramLong1 + ",to=" + paramLong2 + ",size=" + paramString.size());
        }
        paramString = top.e(localArrayList, paramString).iterator();
        while (paramString.hasNext()) {
          top.b(localArrayList, (MessageRecord)paramString.next(), false);
        }
      }
      localArrayList.add(localMessageRecord);
    }
    return localArrayList;
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
    super.a(paramb, paramInt);
  }
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, tnt.a parama)
  {
    if (paramMessageRecord == null) {
      return;
    }
    Map localMap = parama.gH;
    acxw localacxw = parama.jdField_a_of_type_Acxw;
    Object localObject4 = parama.jdField_a_of_type_Tog;
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = anaz.gQ();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    String str1 = paramMessageRecord.frienduin;
    String str2 = paramMessageRecord.senderuin;
    int i = paramMessageRecord.istroop;
    long l = paramMessageRecord.time;
    Object localObject1;
    if ((i != 3000) && (i != 1) && (i != 7000))
    {
      localObject1 = paramMessageRecord.frienduin;
      if (!String.valueOf(acbn.bkE).equals(localObject1)) {
        break label4953;
      }
      localObject1 = paramMessageRecord.senderuin;
    }
    label328:
    label1110:
    label4953:
    for (;;)
    {
      if ((i == 1001) && (!paramMessageRecord.isSend()) && (MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord)))
      {
        if (top.v(paramMessageRecord)) {
          anot.a(this.app, "CliOper", "", "", "0X8005C8E", "0X8005C8E", 0, 0, "", "", "", "");
        }
      }
      else
      {
        if ((top.eD(i) != 1009) && (((tog)localObject4).t((String)localObject1, 1009)))
        {
          ((tog)localObject4).d(acbn.bkt, 1009, (String)localObject1, paramMessageRecord.istroop);
          c(acbn.bkt, 1009, (String)localObject1, this.app.getCurrentAccountUin());
        }
        if ((top.eD(i) != 1001) && (((tog)localObject4).t((String)localObject1, 1001)))
        {
          ((tog)localObject4).d(acbn.bkE, 1001, (String)localObject1, paramMessageRecord.istroop);
          if (!((tog)localObject4).f((String)localObject1, 1001, acbn.blg)) {
            break label1110;
          }
          c(acbn.blg, 1001, (String)localObject1, this.app.getCurrentAccountUin());
        }
        if ((top.eD(i) != 1010) && (((tog)localObject4).t((String)localObject1, 1010)))
        {
          ((tog)localObject4).d(acbn.bkY, 1010, (String)localObject1, paramMessageRecord.istroop);
          if (!((tog)localObject4).f((String)localObject1, 1010, acbn.blh)) {
            break label1132;
          }
          c(acbn.blh, 1010, (String)localObject1, this.app.getCurrentAccountUin());
        }
        if ((top.eD(i) != 1044) && (((tog)localObject4).t((String)localObject1, 1044)) && (((tog)localObject4).f((String)localObject1, 1044, acbn.blR))) {
          c(acbn.blR, 1044, (String)localObject1, this.app.getCurrentAccountUin());
        }
        if ((i == 1008) && (xki.hN(paramMessageRecord.frienduin)))
        {
          localObject1 = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0).edit();
          if ((paramMessageRecord instanceof MessageForPubAccount)) {
            break;
          }
          if (!(paramMessageRecord instanceof MessageForText)) {
            break label1154;
          }
          anot.a(this.app, "P_CliOper", "weather_public_account", "", "weather_public_account", "brief_weather_push", 0, 0, "", "", "", "");
          ((SharedPreferences.Editor)localObject1).putLong("pa_list_send_time" + this.app.getCurrentAccountUin(), System.currentTimeMillis());
          ((SharedPreferences.Editor)localObject1).commit();
        }
        if (top.eD(paramMessageRecord.istroop) != 1009) {
          break label1520;
        }
        if ((((tog)localObject4).gO(str1)) || (localMap.containsKey(top.u(paramMessageRecord.frienduin, paramMessageRecord.istroop)))) {
          localacxw.FK(paramMessageRecord.frienduin);
        }
        a(paramMessageRecord, acbn.bkt, paramMessageRecord.frienduin);
        str1 = acbn.bkt;
        i = paramMessageRecord.istroop;
        l = paramMessageRecord.time;
      }
      int k;
      for (;;)
      {
        for (;;)
        {
          if (((paramMessageRecord instanceof MessageForVideo)) && (paramMessageRecord.istroop != 3000) && (paramMessageRecord.istroop != 1)) {
            k = -1;
          }
          try
          {
            localObject1 = paramMessageRecord.msg.split("\\|");
            j = k;
            if (localObject1 != null)
            {
              j = k;
              if (localObject1.length >= 2) {
                j = Integer.valueOf(localObject1[1]).intValue();
              }
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              Object localObject5;
              boolean bool;
              int j = -1;
              continue;
              localException1.a((MessageForVideo)paramMessageRecord, false);
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("AdvertisementRecentUserManager", 2, "isAdMessage:recent_list_advertisement_message change 0");
              }
              paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message", "0");
              if (i != 1032)
              {
                localObject3 = localacxw.a(str1, k);
                if (j != 0) {
                  ((RecentUser)localObject3).lFlag = 16L;
                }
                if (!localMap.containsKey(top.u(((RecentUser)localObject3).uin, ((RecentUser)localObject3).getType()))) {
                  break label4938;
                }
                localObject3 = (RecentUser)localMap.get(top.u(((RecentUser)localObject3).uin, ((RecentUser)localObject3).getType()));
              }
              for (;;)
              {
                j = i;
                if (!top.fz(paramMessageRecord.msgtype))
                {
                  if ((i != 1008) || (gN(str1))) {
                    break label3260;
                  }
                  j = i;
                }
                for (;;)
                {
                  if ((!paramMessageRecord.isSend()) && (paramMessageRecord.istroop == 0) && (aqft.rj(paramMessageRecord.frienduin)) && (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("guide_msg_cookie"))))
                  {
                    bool = aqlr.isScreenLocked(this.app.getApp());
                    if (QLog.isColorLevel()) {
                      QLog.i("BabyQReportCookie", 2, "now in the aio, isScreenLocked = " + bool);
                    }
                    if ((T().containsKey(top.u(paramMessageRecord.frienduin, paramMessageRecord.istroop))) && (!bool))
                    {
                      this.app.b().uz(paramMessageRecord.getExtInfoFromExtStr("guide_msg_cookie"));
                      if (QLog.isColorLevel()) {
                        QLog.i("BabyQReportCookie", 2, "now in the aio!!!");
                      }
                    }
                  }
                  if (j == 1036) {
                    this.b.e(null);
                  }
                  super.a(paramMessageRecord, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, parama);
                  paramEntityManager = aobw.a.a(this.app);
                  paramEntityManager.aD(paramMessageRecord);
                  paramEntityManager.schedule();
                  return;
                  if ((i == 10005) || (!aluu.kV(i))) {
                    break;
                  }
                  aluu.a(this.app, str1, i, paramMessageRecord);
                  break;
                  localObject3 = localacxw.a(str1, i);
                  break label2926;
                  j = i;
                  if (!asgx.j(this.app, paramMessageRecord)) {
                    if (str1.equals(acbn.bkF))
                    {
                      QLog.i("Q.msg.BaseMessageManager.NEARBY_MSG", 2, "mr.senderUin = " + paramMessageRecord.senderuin);
                      j = i;
                    }
                    else if ((i == 1009) && (str1.equals(acbn.bkt)))
                    {
                      if (l > ((RecentUser)localObject3).lastmsgtime) {
                        ((RecentUser)localObject3).lastmsgtime = l;
                      }
                      ((RecentUser)localObject3).setType(top.eD(((RecentUser)localObject3).getType()));
                      localacxw.e((RecentUser)localObject3);
                      j = i;
                    }
                    else if ((i == 1032) && (str1.equals(acbn.blK)))
                    {
                      if ((l > ((RecentUser)localObject3).lastmsgtime) && (aegu.ah(paramMessageRecord))) {
                        ((RecentUser)localObject3).lastmsgtime = l;
                      }
                      ((RecentUser)localObject3).setType(top.eD(((RecentUser)localObject3).getType()));
                      localacxw.e((RecentUser)localObject3);
                      j = i;
                    }
                    else if ((i == 1008) && (!jxp.c(paramMessageRecord)) && ((oan.a().e(this.app, str1, i)) || ("1".equals(paramMessageRecord.getExtInfoFromExtStr("inter_num")))))
                    {
                      str1 = top.u(str1, i);
                      if (parama.gM.containsKey(str1))
                      {
                        ((List)parama.gM.get(str1)).add(paramMessageRecord);
                        j = i;
                      }
                      else
                      {
                        localObject3 = new ArrayList();
                        ((List)localObject3).add(paramMessageRecord);
                        parama.gM.put(str1, localObject3);
                        j = i;
                      }
                    }
                    else if ((i == 1008) && (!jxp.c(paramMessageRecord)) && (("2".equals(paramMessageRecord.getExtInfoFromExtStr("inter_num"))) || (nyn.i(this.app, str1))))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("EcShopAssistantManager", 2, "ecshop new msg puin: " + paramMessageRecord.senderuin + ", inter_num: " + paramMessageRecord.getExtInfoFromExtStr("inter_num"));
                      }
                      str1 = top.u(str1, i);
                      if (parama.gN.containsKey(str1))
                      {
                        ((List)parama.gN.get(str1)).add(paramMessageRecord);
                        j = i;
                      }
                      else
                      {
                        localObject3 = new ArrayList();
                        ((List)localObject3).add(paramMessageRecord);
                        parama.gN.put(str1, localObject3);
                        j = i;
                      }
                    }
                    else if (paramMessageRecord.msgtype == -1034)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageManager", 2, "insertSignMsgIfNeeded add recentUserCache start");
                      }
                      j = i;
                      if (localacxw.kG(str1))
                      {
                        if (QLog.isColorLevel()) {
                          QLog.d("Q.msg.BaseMessageManager", 2, "insertSignMsgIfNeeded add recentUserCache uin " + str1);
                        }
                        ((RecentUser)localObject3).uin = str1;
                        ((RecentUser)localObject3).setType(top.eD(((RecentUser)localObject3).getType()));
                        if (l > ((RecentUser)localObject3).lastmsgtime) {
                          ((RecentUser)localObject3).lastmsgtime = l;
                        }
                        localMap.put(top.u(str1, i), localObject3);
                        j = i;
                      }
                    }
                    else if ((paramMessageRecord.msgtype == -5010) && (paramMessageRecord.isSend()))
                    {
                      j = i;
                      if (paramMessageRecord.istroop != 3000)
                      {
                        j = i;
                        if (paramMessageRecord.istroop != 1)
                        {
                          j = i;
                          if (!paramMessageRecord.frienduin.equals(paramMessageRecord.selfuin))
                          {
                            ((RecentUser)localObject3).setType(top.eD(((RecentUser)localObject3).getType()));
                            if (l > ((RecentUser)localObject3).lastmsgtime) {
                              ((RecentUser)localObject3).lastmsgtime = l;
                            }
                            if (QLog.isColorLevel()) {
                              QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache MSG_TYPE_DINGDONG_SCHEDULE_MSG");
                            }
                            localMap.put(top.u(str1, i), localObject3);
                            j = i;
                          }
                        }
                      }
                    }
                    else if (((paramMessageRecord.isBlessMsg) || (paramMessageRecord.isCheckNeedShowInListTypeMsg)) && (paramMessageRecord.isSend()))
                    {
                      if ((!paramMessageRecord.isBlessMsg) || (!paramMessageRecord.needUpdateMsgTag))
                      {
                        j = i;
                        if (paramMessageRecord.isCheckNeedShowInListTypeMsg)
                        {
                          j = i;
                          if (!paramMessageRecord.needNeedShowInList) {}
                        }
                      }
                      else
                      {
                        ((RecentUser)localObject3).uin = str1;
                        ((RecentUser)localObject3).setType(0);
                        if (l > ((RecentUser)localObject3).lastmsgtime) {
                          ((RecentUser)localObject3).lastmsgtime = l;
                        }
                        if (QLog.isColorLevel()) {
                          QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache isBlessMsg");
                        }
                        localMap.put(top.u(str1, i), localObject3);
                        j = i;
                      }
                    }
                    else if ((paramMessageRecord.frienduin.equals(acbn.blu)) && (paramMessageRecord.istroop == 0))
                    {
                      ((RecentUser)localObject3).uin = acbn.bkA;
                      ((RecentUser)localObject3).setType(4000);
                      ((RecentUser)localObject3).displayName = this.app.getApplication().getApplicationContext().getString(2131696301);
                      if (l > ((RecentUser)localObject3).lastmsgtime) {
                        ((RecentUser)localObject3).lastmsgtime = l;
                      }
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache MAYKNOW_RECOMMEND_UIN");
                      }
                      localMap.put(top.u(str1, i), localObject3);
                      j = i;
                    }
                    else if ((paramMessageRecord.frienduin.equals(acbn.blC)) && (paramMessageRecord.istroop == 0))
                    {
                      ((RecentUser)localObject3).uin = acbn.bkA;
                      ((RecentUser)localObject3).setType(4000);
                      ((RecentUser)localObject3).displayName = this.app.getApplication().getApplicationContext().getString(2131696301);
                      if (l > ((RecentUser)localObject3).lastmsgtime) {
                        ((RecentUser)localObject3).lastmsgtime = l;
                      }
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache FRIEND_ANNIVER_UIN");
                      }
                      localMap.put(top.u(str1, i), localObject3);
                      j = i;
                    }
                    else if ((paramMessageRecord.frienduin.equals(acbn.bkJ)) && (paramMessageRecord.istroop == 0))
                    {
                      ((RecentUser)localObject3).uin = acbn.bkA;
                      ((RecentUser)localObject3).setType(4000);
                      ((RecentUser)localObject3).displayName = this.app.getApplication().getApplicationContext().getString(2131696301);
                      if (l > ((RecentUser)localObject3).lastmsgtime) {
                        ((RecentUser)localObject3).lastmsgtime = l;
                      }
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache FRIEND_SYSTEM_MSG_UIN");
                      }
                      localMap.put(top.u(str1, i), localObject3);
                      j = i;
                    }
                    else if ((paramMessageRecord.isLongMsg()) && (this.app.a().aQ(paramMessageRecord)))
                    {
                      j = i;
                      if (QLog.isColorLevel())
                      {
                        QLog.i("Q.msg.BaseMessageManager", 2, "addMessageRecord, long msg uncompleted");
                        j = i;
                      }
                    }
                    else
                    {
                      j = i;
                      if (!aine.aE(paramMessageRecord)) {
                        if (i == 1044)
                        {
                          j = i;
                          if (str1.equals(acbn.blR)) {}
                        }
                        else
                        {
                          j = i;
                          if (!TextUtils.equals(paramMessageRecord.senderuin, acbn.bkN))
                          {
                            if ((paramMessageRecord.msgtype != -5010) || (!paramMessageRecord.isSend())) {
                              break label4735;
                            }
                            j = i;
                            if (paramMessageRecord.istroop != 3000)
                            {
                              j = i;
                              if (paramMessageRecord.istroop != 1)
                              {
                                j = i;
                                if (!paramMessageRecord.frienduin.equals(paramMessageRecord.selfuin))
                                {
                                  ((RecentUser)localObject3).setType(top.eD(((RecentUser)localObject3).getType()));
                                  if (l > ((RecentUser)localObject3).lastmsgtime) {
                                    ((RecentUser)localObject3).lastmsgtime = l;
                                  }
                                  localMap.put(top.u(str1, i), localObject3);
                                  j = i;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
                ((RecentUser)localObject3).uin = str1;
                if ((i != 1000) && (i != 1020))
                {
                  j = i;
                  if (i != 1004) {}
                }
                else
                {
                  if (!aalb.q(this.app, str1)) {
                    break label4891;
                  }
                  j = 0;
                  ((RecentUser)localObject3).setType(0);
                  ((RecentUser)localObject3).troopUin = "";
                }
                for (;;)
                {
                  ((RecentUser)localObject3).setType(top.eD(((RecentUser)localObject3).getType()));
                  bool = true;
                  if ((paramMessageRecord instanceof MessageForUniteGrayTip)) {
                    bool = ((MessageForUniteGrayTip)paramMessageRecord).tipParam.ciF;
                  }
                  if ((l > ((RecentUser)localObject3).lastmsgtime) && (bool)) {
                    ((RecentUser)localObject3).lastmsgtime = l;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "add recentUserCache ELSE");
                  }
                  localMap.put(top.u(str1, j), localObject3);
                  break;
                  j = i;
                  if (!TextUtils.equals(str2, this.app.getAccount()))
                  {
                    j = i;
                    if (!TextUtils.equals(str2, str1))
                    {
                      ((RecentUser)localObject3).troopUin = str2;
                      j = i;
                    }
                  }
                }
              }
              j = 0;
            }
          }
          localObject1 = (alkm)this.app.getManager(38);
          if (j != 6) {
            break label2868;
          }
          ((alkm)localObject1).a((MessageForVideo)paramMessageRecord, true);
          ((alkm)localObject1).a((MessageForVideo)paramMessageRecord);
          k = paramMessageRecord.istroop;
          if ((i != 1008) || (!jxp.c(paramMessageRecord))) {
            break label4941;
          }
          j = 1;
          if (j == 0) {
            break label3215;
          }
          localObject1 = jxp.a(this.app, paramMessageRecord, false);
          if ((localObject1 == null) || (TextUtils.isEmpty(((jxc)localObject1).a.UD))) {
            break label2881;
          }
          jxl.a().lw(((jxc)localObject1).mSenderUin);
          jxl.a().b((jxc)localObject1);
          paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_uin", ((jxc)localObject1).a.UD);
          if (((jxc)localObject1).a.mNickName != null) {
            paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_name", ((jxc)localObject1).a.mNickName);
          }
          paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_first_report", "false");
          paramMessageRecord.saveExtInfoToExtStr("recent_list_advertisement_message_first_click", "false");
          localObject1 = paramEntityManager.query(MessageRecord.class, paramMessageRecord.getTableName(), false, null, null, null, null, null, null);
          if (localObject1 == null) {
            break label2907;
          }
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject4 = (MessageRecord)((Iterator)localObject1).next();
            paramEntityManager.remove((Entity)localObject4);
            aalb.l(this.app, ((MessageRecord)localObject4).senderuin, ((MessageRecord)localObject4).istroop);
            localObject5 = localacxw.a(str1, k);
            if (localObject5 != null)
            {
              aajt.a().Av(str1 + "-" + k);
              localacxw.f((RecentUser)localObject5);
            }
            this.app.b().a(((MessageRecord)localObject4).senderuin, 1008, true, true);
          }
          anot.a(this.app, "CliOper", "", "", "0X8005C8F", "0X8005C8F", 0, 0, "", "", "", "");
          break;
          c(acbn.bkE, 1001, (String)localObject1, this.app.getCurrentAccountUin());
          break label328;
          label1132:
          c(acbn.bkY, 1010, (String)localObject1, this.app.getCurrentAccountUin());
          break label404;
          if (!(paramMessageRecord instanceof MessageForArkApp)) {
            break label580;
          }
          localObject5 = (MessageForArkApp)paramMessageRecord;
          ((SharedPreferences.Editor)localObject1).putBoolean("show_flag", true);
          try
          {
            localObject5 = new JSONObject(((MessageForArkApp)localObject5).ark_app_message.metaList).optJSONObject("weather");
            if ((localObject5 == null) || (!((JSONObject)localObject5).has("info"))) {
              break label580;
            }
            JSONObject localJSONObject = ((JSONObject)localObject5).optJSONObject("info");
            Object localObject6 = localJSONObject.optJSONObject("it1");
            if (localObject6 == null) {
              break label580;
            }
            String str3 = ((JSONObject)localObject6).optString("city");
            String str4 = ((JSONObject)localObject6).optString("temp");
            localObject6 = ((JSONObject)localObject6).optString("type");
            if (!TextUtils.isEmpty(str3)) {
              ((SharedPreferences.Editor)localObject1).putString("cur_city", str3.split("-")[0]);
            }
            if (!TextUtils.isEmpty(str4)) {
              ((SharedPreferences.Editor)localObject1).putString("cur_temp", str4);
            }
            if (!TextUtils.isEmpty((CharSequence)localObject6)) {
              ((SharedPreferences.Editor)localObject1).putString("cur_code", (String)localObject6);
            }
            ((SharedPreferences.Editor)localObject1).putLong("pa_send_time" + this.app.getAccount(), System.currentTimeMillis());
            if (0L != ((JSONObject)localObject5).optLong("ts")) {
              ((SharedPreferences.Editor)localObject1).putLong("pa_time_stamp" + this.app.getAccount(), localJSONObject.optLong("ts"));
            }
            if (!QLog.isColorLevel()) {
              break label580;
            }
            QLog.d("Q.msg.BaseMessageManager", 2, "parse ark msg city: " + str3 + ", temp: " + str4 + ", code: " + (String)localObject6 + ", ts: " + localJSONObject.optLong("ts"));
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
        }
        break label580;
        label1520:
        if (String.valueOf(acbn.bkE).equals(paramMessageRecord.frienduin))
        {
          if ((((tog)localObject4).gO(paramMessageRecord.senderuin)) || (localMap.containsKey(top.u(paramMessageRecord.senderuin, paramMessageRecord.istroop)))) {
            localacxw.FK(paramMessageRecord.senderuin);
          }
          k = 0;
          j = 0;
          bool = afcw.aiJ();
          if (top.v(paramMessageRecord))
          {
            a(paramMessageRecord, acbn.blg, paramMessageRecord.senderuin);
            if (!bool) {
              a(paramMessageRecord, acbn.bkE, acbn.blg);
            }
            a(paramMessageRecord, acbn.bkF, acbn.blg);
            k = j;
            if (!paramMessageRecord.isread)
            {
              ((tog)localObject4).aX(1001, paramMessageRecord.senderuin);
              k = j;
            }
            label1662:
            if (k != 0) {
              break label1799;
            }
          }
          for (str1 = acbn.bkF;; str1 = acbn.bkE)
          {
            paramMessageRecord.frienduin = paramMessageRecord.senderuin;
            break;
            if (((tog)localObject4).f(paramMessageRecord.frienduin, 1001, acbn.blg)) {
              c(acbn.blg, 1001, paramMessageRecord.senderuin, this.app.getCurrentAccountUin());
            }
            j = k;
            if (afcw.am(paramMessageRecord))
            {
              a(paramMessageRecord, acbn.bkE, paramMessageRecord.senderuin);
              j = 1;
            }
            k = j;
            if (afcw.x(paramMessageRecord.msgtype, paramMessageRecord.senderuin)) {
              break label1662;
            }
            k = j;
            if (paramMessageRecord.istroop != 1001) {
              break label1662;
            }
            a(paramMessageRecord, acbn.bkF, paramMessageRecord.senderuin);
            k = j;
            break label1662;
          }
        }
        if (((top.eD(paramMessageRecord.istroop) == 1001) && (top.as(paramMessageRecord.istroop, paramMessageRecord.msgtype))) || (top.eD(paramMessageRecord.istroop) == 1010))
        {
          if ((((tog)localObject4).gO(str1)) || (localMap.containsKey(top.u(paramMessageRecord.frienduin, paramMessageRecord.istroop)))) {
            localacxw.FK(paramMessageRecord.frienduin);
          }
          j = 0;
          i = 0;
          bool = afcw.aiJ();
          if (top.v(paramMessageRecord))
          {
            a(paramMessageRecord, acbn.blg, paramMessageRecord.senderuin);
            if (!bool) {
              a(paramMessageRecord, acbn.bkE, acbn.blg);
            }
            a(paramMessageRecord, acbn.bkF, acbn.blg);
            j = i;
            if (!paramMessageRecord.isread)
            {
              ((tog)localObject4).aX(1001, paramMessageRecord.senderuin);
              j = i;
            }
            if (j != 0) {
              break label2112;
            }
          }
          for (str1 = acbn.bkF;; str1 = acbn.bkE)
          {
            i = paramMessageRecord.istroop;
            l = paramMessageRecord.time;
            break;
            if (((tog)localObject4).f(paramMessageRecord.frienduin, 1001, acbn.blg)) {
              c(acbn.blg, 1001, paramMessageRecord.senderuin, this.app.getCurrentAccountUin());
            }
            i = j;
            if (afcw.am(paramMessageRecord))
            {
              a(paramMessageRecord, acbn.bkE, paramMessageRecord.frienduin);
              i = 1;
            }
            j = i;
            if (afcw.x(paramMessageRecord.msgtype, paramMessageRecord.senderuin)) {
              break label1971;
            }
            j = i;
            if (paramMessageRecord.istroop != 1001) {
              break label1971;
            }
            a(paramMessageRecord, acbn.bkF, paramMessageRecord.frienduin);
            j = i;
            break label1971;
          }
        }
        if (!String.valueOf(acbn.bkD).equals(paramMessageRecord.frienduin)) {
          break label2178;
        }
        if (!(paramMessageRecord instanceof MessageForSystemMsg)) {
          break label4947;
        }
        localObject1 = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg();
        if (localObject1 != null) {
          paramMessageRecord.time = ((structmsg.StructMsg)localObject1).msg_time.get();
        }
        l = paramMessageRecord.time;
      }
      if (String.valueOf(acbn.bkK).equals(paramMessageRecord.frienduin))
      {
        if (!(paramMessageRecord instanceof MessageForSystemMsg)) {
          break label4950;
        }
        localObject1 = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg();
        if (localObject1 != null) {
          paramMessageRecord.time = ((structmsg.StructMsg)localObject1).msg_time.get();
        }
        l = paramMessageRecord.time;
      }
      for (;;)
      {
        localObject1 = this.b.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
        int m = anze.a().af(this.app);
        if (m > 0)
        {
          k = 0;
          j = k;
          if (!paramMessageRecord.isSendFromLocal())
          {
            j = k;
            if (paramMessageRecord.time < ((QQMessageFacade.Message)localObject1).time) {
              j = 1;
            }
          }
          if (j == 0)
          {
            MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject1, paramMessageRecord);
            ((QQMessageFacade.Message)localObject1).msgData = paramMessageRecord.msgData;
            this.b.e((QQMessageFacade.Message)localObject1);
          }
        }
        for (;;)
        {
          try
          {
            b((QQMessageFacade.Message)localObject1);
            this.b.a().unReadNum = m;
          }
          catch (Throwable localThrowable1)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("Q.msg.BaseMessageManager", 2, "addMessageRecord ERROR", localThrowable1);
            continue;
          }
          this.b.e(null);
        }
        if (acbn.bkL.equals(paramMessageRecord.frienduin))
        {
          yym.a(this, paramMessageRecord, this.b, this.app);
          l = paramMessageRecord.time;
          break;
        }
        Object localObject2;
        if (acbn.bkB.equals(paramMessageRecord.frienduin))
        {
          try
          {
            localObject2 = paramEntityManager.query(MessageRecord.class, paramMessageRecord.getTableName(), false, null, null, null, null, null, null);
            if (localObject2 != null)
            {
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext()) {
                paramEntityManager.remove((MessageRecord)((Iterator)localObject2).next());
              }
            }
          }
          finally {}
          break;
        }
        if ((String.valueOf(acbn.blu).equals(paramMessageRecord.frienduin)) || (acbn.blC.equals(paramMessageRecord.frienduin)))
        {
          localObject2 = this.b.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
          localObject4 = (ysf)this.app.getManager(34);
          ((QQMessageFacade.Message)localObject2).istroop = paramMessageRecord.istroop;
          ((ysf)localObject4).AI(false);
          m = ((ysf)localObject4).xq();
          if (m > 0)
          {
            k = 0;
            j = k;
            if (!paramMessageRecord.isSendFromLocal())
            {
              j = k;
              if (paramMessageRecord.time < ((QQMessageFacade.Message)localObject2).time) {
                j = 1;
              }
            }
            if (j == 0)
            {
              MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject2, paramMessageRecord);
              ((QQMessageFacade.Message)localObject2).msgData = paramMessageRecord.msgData;
              this.b.e((QQMessageFacade.Message)localObject2);
            }
          }
          for (;;)
          {
            try
            {
              b((QQMessageFacade.Message)localObject2);
              this.b.a().unReadNum = m;
            }
            catch (Throwable localThrowable2)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("Q.msg.BaseMessageManager", 2, "addMessageRecord ERROR", localThrowable2);
              continue;
            }
            this.b.e(null);
          }
        }
        if (top.eD(paramMessageRecord.istroop) == 1032)
        {
          if (aegu.ah(paramMessageRecord)) {
            a(paramMessageRecord, acbn.blK, paramMessageRecord.frienduin);
          }
          str1 = acbn.blK;
          l = paramMessageRecord.time;
          i = 1032;
          break;
        }
        if (top.eD(paramMessageRecord.istroop) == 1044)
        {
          if (((((tog)localObject4).gO(paramMessageRecord.senderuin)) || (localMap.containsKey(top.u(paramMessageRecord.senderuin, paramMessageRecord.istroop)))) && (!aalb.q(this.app, paramMessageRecord.senderuin))) {
            localacxw.FK(paramMessageRecord.senderuin);
          }
          a(paramMessageRecord, acbn.blR, paramMessageRecord.frienduin);
          str1 = acbn.blR;
          l = paramMessageRecord.time;
          i = 1044;
          break;
        }
        label2907:
        Object localObject3;
        label2926:
        label4735:
        break;
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgByMessageRecord in SubThread!");
      }
    }
    for (;;)
    {
      ((achs)this.app.getManager(92)).V(paramMessageRecord);
      super.a(paramMessageRecord, paramBoolean1, paramBoolean2);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "removeMsgByMessageRecord in MainThread!");
      }
    }
  }
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2, QQMessageFacade.b paramb, ArrayList<MessageRecord> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageManager", 2, String.format("loadFromLocalConfess uin:%s type:%d topicId:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramb.topicId) }));
    }
    String str = aegu.g(paramString, paramInt1, paramb.topicId);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    long l1;
    if (paramLong > 0L)
    {
      localObject1 = this.app.a(paramInt1).a(paramString, paramInt1, paramLong);
      localObject2 = this.b;
      localObject3 = new StringBuilder().append("loadFromLocal uniseq=").append(paramLong).append(",count=").append(paramInt2).append(", fromtime=");
      if (localObject1 == null)
      {
        paramLong = -1L;
        ((QQMessageFacade)localObject2).df(paramLong, "");
        if (localObject1 == null) {
          break label726;
        }
        l1 = ((MessageRecord)localObject1).time;
        paramLong = ((MessageRecord)localObject1).getId();
      }
    }
    for (;;)
    {
      localObject3 = this.app.a(paramInt1).h(paramString, paramInt1);
      localObject2 = new ArrayList();
      label201:
      MessageRecord localMessageRecord;
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
          if (TextUtils.equals(str, aegu.g(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.getConfessTopicId()))) {
            if ((localMessageRecord.time <= l1) && ((localObject1 == null) || (!top.a((MessageRecord)localObject1, localMessageRecord, true)))) {
              break label664;
            }
          }
        }
        this.b.a("loadFromLocal load from Cache", (Collection)localObject2);
      }
      long l2;
      if ((paramArrayList.size() < paramInt2) && (((List)localObject2).size() > 0))
      {
        paramArrayList.addAll(0, ((List)localObject2).subList(Math.max(((List)localObject2).size() - (paramInt2 - paramArrayList.size()), 0), ((List)localObject2).size()));
        if (paramArrayList.size() > 0)
        {
          l1 = Math.min(l1, ((MessageRecord)paramArrayList.get(0)).time);
          l2 = Math.max(Math.min(paramLong, ((MessageRecord)paramArrayList.get(0)).getId()), 0L);
          paramLong = l1;
          l1 = l2;
          l2 = paramLong;
          paramLong = l1;
        }
      }
      for (;;)
      {
        if (paramArrayList.size() < paramInt2)
        {
          int i = aegu.ag(paramInt1, paramb.topicId) << 3;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(String.format(" and (extLong & 4194296)=%d", new Object[] { Integer.valueOf(i) }));
          ((StringBuilder)localObject1).append(String.format(" or (time=%d and _id<%d and (extLong & 4194296)=%d) ", new Object[] { Long.valueOf(l2), Long.valueOf(paramLong), Integer.valueOf(i) }));
          localObject1 = this.app.a(paramInt1).a(paramString, paramInt1, paramLong, 3, l2, paramInt2, ((StringBuilder)localObject1).toString());
          this.b.df("queryTimedMessageDBUnion list size" + ((List)localObject1).size() + ", getID=" + paramLong, "");
          if (!((List)localObject1).isEmpty()) {
            break label677;
          }
          paramb.isComplete = true;
        }
        for (;;)
        {
          paramb.aQg = true;
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMessageManager", 2, String.format("loadFromLocalConfess uin:%s type:%d topicId:%d findCount:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramb.topicId), Integer.valueOf(paramArrayList.size()) }));
          }
          return;
          paramLong = ((MessageRecord)localObject1).time;
          break;
          label664:
          ((List)localObject2).add(localMessageRecord);
          break label201;
          label677:
          if (((List)localObject1).size() < paramInt2) {
            paramb.isComplete = true;
          }
          this.b.a("loadFromLocal load from DB", (Collection)localObject1);
          paramArrayList.addAll(0, (Collection)localObject1);
        }
        l2 = l1;
      }
      label726:
      paramLong = 9223372036854775807L;
      l1 = 9223372036854775807L;
      continue;
      localObject1 = null;
      paramLong = 9223372036854775807L;
      l1 = 9223372036854775807L;
    }
  }
  
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2, QQMessageFacade.b paramb, ArrayList<MessageRecord> paramArrayList, boolean paramBoolean)
  {
    MessageRecord localMessageRecord1 = this.app.a(paramInt1).a(paramString, paramInt1, paramLong);
    Object localObject1 = this.b;
    Object localObject2 = new StringBuilder().append("loadFromLocal uniseq=").append(paramLong).append(",count=").append(paramInt2).append(", fromtime=");
    label140:
    MessageRecord localMessageRecord2;
    if (localMessageRecord1 == null)
    {
      paramLong = -1L;
      ((QQMessageFacade)localObject1).df(paramLong, "");
      if (localMessageRecord1 == null) {
        break label518;
      }
      long l3 = localMessageRecord1.time;
      long l2 = localMessageRecord1.getId();
      localObject2 = this.app.a(paramInt1).h(paramString, paramInt1);
      localObject1 = new ArrayList();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localMessageRecord2 = (MessageRecord)((Iterator)localObject2).next();
          if ((localMessageRecord2.time <= l3) && (!top.a(localMessageRecord1, localMessageRecord2, true))) {
            break label466;
          }
        }
        this.b.a("loadFromLocal load from Cache", (Collection)localObject1);
      }
      long l1 = l2;
      paramLong = l3;
      if (paramArrayList.size() < paramInt2)
      {
        l1 = l2;
        paramLong = l3;
        if (((List)localObject1).size() > 0)
        {
          paramArrayList.addAll(0, ((List)localObject1).subList(Math.max(((List)localObject1).size() - (paramInt2 - paramArrayList.size()), 0), ((List)localObject1).size()));
          l1 = l2;
          paramLong = l3;
          if (paramArrayList.size() > 0)
          {
            paramLong = Math.min(l3, ((MessageRecord)paramArrayList.get(0)).time);
            l1 = Math.max(Math.min(l2, ((MessageRecord)paramArrayList.get(0)).getId()), 0L);
          }
        }
      }
      if (paramArrayList.size() < paramInt2)
      {
        paramString = this.app.a(paramInt1).a(paramString, paramInt1, l1, localMessageRecord1.versionCode, paramLong, paramInt2, String.format(" or (time=%d and _id<%d) ", new Object[] { Long.valueOf(paramLong), Long.valueOf(l1) }));
        this.b.df("queryTimedMessageDBUnion list size" + paramString.size() + ", getID=" + localMessageRecord1.getId(), "");
        if (!paramString.isEmpty()) {
          break label479;
        }
        paramb.isComplete = true;
      }
    }
    for (;;)
    {
      paramb.aQg = paramBoolean;
      return;
      paramLong = localMessageRecord1.time;
      break;
      label466:
      ((List)localObject1).add(localMessageRecord2);
      break label140;
      label479:
      if (paramString.size() < paramInt2) {
        paramb.isComplete = true;
      }
      this.b.a("loadFromLocal load from DB", paramString);
      paramArrayList.addAll(0, paramString);
    }
    label518:
    paramb.aQg = paramBoolean;
    paramb.isComplete = true;
    this.b.df("loadFromLocal complete", "");
  }
  
  public void a(String paramString, int paramInt, QQMessageFacade.b paramb, toa.a parama, FragmentActivity paramFragmentActivity)
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
    this.app.execute(new C2CMessageManager.2(this, paramb, paramInt, paramString, parama, paramFragmentActivity));
  }
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, Bundle paramBundle)
  {
    boolean bool1 = paramBundle.getBoolean("success");
    boolean bool2 = paramBundle.getBoolean("complete");
    List localList = (List)this.b.cP.get(Integer.valueOf(paramBundle.getInt("counter")));
    paramBundle.putBoolean("timeout", false);
    long l1 = paramBundle.getLong("baseTime");
    long l2 = paramBundle.getLong("lowTime");
    paramBundle = this.b;
    Object localObject = new StringBuilder().append("setC2CRoamMessageResult success=").append(bool1).append(",complete=").append(bool2).append(",res_size=");
    if (paramList1 == null)
    {
      paramInt = -1;
      paramBundle.df(paramInt + ",baseT=" + l1 + ",lowTime=" + l2, "");
      if (paramList1 != null) {
        break label526;
      }
    }
    label526:
    for (paramBundle = new ArrayList();; paramBundle = paramList1)
    {
      paramList1 = paramList2;
      if (paramList2 == null) {
        paramList1 = new ArrayList();
      }
      if (bool1)
      {
        paramList2 = a(paramString, paramBundle, l1, l2);
        if ((localList != null) && (!localList.isEmpty()))
        {
          l1 = ((MessageRecord)localList.get(0)).time;
          paramString = new ArrayList();
          paramBundle = localList.iterator();
          for (;;)
          {
            if (paramBundle.hasNext())
            {
              localObject = (MessageRecord)paramBundle.next();
              if (((MessageRecord)localObject).time == l1)
              {
                paramString.add(localObject);
                continue;
                paramInt = paramList1.size();
                break;
              }
            }
          }
          paramList2 = paramList2.iterator();
          paramInt = 0;
          if (!paramList2.hasNext()) {
            break label446;
          }
          paramBundle = (MessageRecord)paramList2.next();
          localObject = paramString.iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          } while (!top.a((MessageRecord)((Iterator)localObject).next(), paramBundle, true));
        }
      }
      for (int j = 1;; j = 0)
      {
        int i = paramInt;
        if (localList != null)
        {
          i = paramInt;
          if (j == 0)
          {
            localList.add(paramInt, paramBundle);
            i = paramInt + 1;
            paramList1.add(paramBundle);
          }
        }
        paramInt = i;
        break;
        if (localList != null) {
          localList.addAll(paramList2);
        }
        label446:
        paramString = this.b;
        paramList1 = new StringBuilder().append("setC2CRoamMessageResult locallist:");
        if (localList == null) {}
        for (paramInt = -1;; paramInt = localList.size())
        {
          paramString.df(paramInt, "");
          if (localList != null) {}
          try
          {
            localList.notify();
            return;
          }
          finally {}
        }
      }
    }
  }
  
  public long b(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.time;
  }
  
  public void b(String paramString, int paramInt1, int paramInt2, QQMessageFacade.b paramb)
  {
    if (fq(paramInt1))
    {
      if (paramInt1 == 1008)
      {
        c(paramString, paramInt1, paramInt2, paramb);
        return;
      }
      if ((top.eD(paramInt1) == 1032) && (paramb.topicId > 0))
      {
        paramb.aQg = true;
        d(paramString, paramInt1, paramInt2, paramb);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshMessageListHead TYPE ERROR! TYPE = " + paramInt1);
      }
      paramb.isComplete = true;
      paramb.pX = null;
      a(paramb, paramInt1);
      return;
    }
    if (paramb.a != null) {}
    List localList;
    for (int j = 1;; j = 0)
    {
      localList = this.app.a(paramInt1).l(paramString, paramInt1);
      if (((localList != null) && (!localList.isEmpty())) || (j != 0)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead ERROR: AIO is closed !!");
      }
      paramb.pX = null;
      a(paramb, paramInt1);
      return;
    }
    if (localList != null) {
      this.b.a("current Aio", localList.subList(0, Math.min(paramInt2, localList.size())));
    }
    long l2;
    Object localObject1;
    long l1;
    label264:
    long l3;
    label283:
    Object localObject2;
    ArrayList localArrayList1;
    int k;
    label418:
    int i;
    if ((localList == null) || (localList.isEmpty()))
    {
      l2 = 0L;
      localObject1 = this.app.a().h(paramString);
      if (localObject1 != null) {
        break label699;
      }
      l1 = 0L;
      if (j == 0) {
        break label715;
      }
      l3 = Math.max(l1, NetConnInfoCenter.getServerTime() - 86400L);
      localObject2 = this.app.a(paramInt1).h(paramString, paramInt1);
      localArrayList1 = new ArrayList();
      this.b.df("refreshC2CMessageListHead isLocalOnly=" + paramb.aQg + ",uniseq=" + l2 + ",ect=" + l1 + ", possibleBreakTime=" + l3, " ,getC2CRoamingSetting" + this.app.AK());
      if (this.app.AK() == 0) {
        paramb.aQg = true;
      }
      if (localList != null) {
        break label722;
      }
      k = 0;
      i = 0;
      label421:
      if (i >= k) {
        break label3163;
      }
      if (((MessageRecord)localList.get(i)).uniseq != l2) {
        break label743;
      }
      label449:
      if (i >= localList.size()) {
        break label3157;
      }
      if (!top.fy(((MessageRecord)localList.get(i)).msgtype)) {
        break label734;
      }
      l2 = ((MessageRecord)localList.get(i)).uniseq;
      i = 1;
    }
    for (;;)
    {
      if ((paramb.aQg) || (l3 == 0L) || ((i == 0) && (j == 0)))
      {
        b(paramString, paramInt1, l2, paramInt2, paramb, localArrayList1);
        fn(localArrayList1);
        this.app.a(paramInt1).d(paramString, paramInt1, localArrayList1);
        paramb.pX = localArrayList1;
        if (paramb.isComplete) {
          bO(paramString, paramInt1);
        }
        paramString = this.b;
        localObject1 = new StringBuilder().append("refresh load local C2C msg only FIN , context = ").append(paramb).append(", size = ");
        if (localArrayList1 == null) {}
        for (paramInt2 = -1;; paramInt2 = localArrayList1.size())
        {
          paramString.df(paramInt2, ", timestamp = " + System.currentTimeMillis());
          if ((!top.V(localArrayList1)) || (paramb.bCT >= 3)) {
            break label761;
          }
          a(paramb, paramInt1);
          return;
          l2 = ((MessageRecord)localList.get(0)).uniseq;
          break;
          label699:
          l1 = ((Long)((Pair)localObject1).first).longValue();
          break label264;
          label715:
          l3 = l1;
          break label283;
          label722:
          k = localList.size();
          break label418;
          label734:
          i += 1;
          break label449;
          label743:
          i += 1;
          break label421;
        }
        label761:
        this.b.as(paramb);
        return;
      }
      if (localObject2 == null)
      {
        k = 0;
        i = 0;
        label782:
        if (i >= k) {
          break label3148;
        }
        localObject1 = (MessageRecord)((List)localObject2).get(i);
        if (((MessageRecord)localObject1).uniseq != l2) {
          break label1096;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead cacheIndex:" + i + ", itemList:" + ((List)localObject2).size());
        }
        if (localObject1 == null)
        {
          localObject1 = this.app.a(paramInt1).a(paramString, paramInt1, l2);
          if (localObject1 == null)
          {
            if (j != 0)
            {
              a(paramString, paramInt1, paramInt2, paramb, localArrayList1, null, 0L);
              fn(localArrayList1);
              this.app.a(paramInt1).d(paramString, paramInt1, localArrayList1);
              paramb.pX = localArrayList1;
              if (paramb.isComplete) {
                bO(paramString, paramInt1);
              }
              paramString = this.b;
              localObject1 = new StringBuilder().append("refresh C2C finish , context = ").append(paramb).append(" , size = ");
              if (localArrayList1 == null) {}
              for (paramInt2 = -1;; paramInt2 = localArrayList1.size())
              {
                paramString.df(paramInt2, ", timestamp = " + System.currentTimeMillis());
                if ((!top.V(localArrayList1)) || (paramb.bCT >= 3)) {
                  break label1114;
                }
                if (QLog.isColorLevel()) {
                  QLog.i("Q.msg.BaseMessageManager", 2, "refresh C2C finish, now rePull sticker msg! " + paramb.bCT);
                }
                a(paramb, paramInt1);
                return;
                k = ((List)localObject2).size();
                break;
                label1096:
                i += 1;
                break label782;
              }
              label1114:
              this.b.as(paramb);
              return;
            }
            this.b.df("refresh from empty C2C msg", "");
            paramb.isComplete = true;
            paramb.aQg = true;
            paramb.pX = new ArrayList();
            this.b.as(paramb);
            return;
          }
          l3 = ((MessageRecord)localObject1).time;
          this.b.df("refreshC2CMessageListHead uniseq=" + l2 + ", aioBase.getId():" + ((MessageRecord)localObject1).getId(), "");
          localArrayList1.addAll(this.app.a(paramInt1).a(paramString, paramInt1, l3, paramInt2, String.format("time>=%d or (time=%d and _id<%d)", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(((MessageRecord)localObject1).getId()) })));
          this.b.df("refreshC2CMessageListHead Db fromTime:" + l3, "");
          this.b.a("only load in db", localArrayList1);
          l2 = l3;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead locallist size " + localArrayList1.size());
          }
          if (l1 <= l2) {
            break label3142;
          }
          l1 = Math.min(l2, paramb.EK);
          this.b.df("ect > fromTime!! newEct:" + l1, "");
        }
        label2700:
        label3123:
        label3132:
        label3142:
        for (boolean bool1 = false;; bool1 = true)
        {
          this.b.a("before pull locallist", localArrayList1);
          this.b.df("before pull locallist" + localArrayList1.size(), "");
          if ((l1 > 0L) && (localArrayList1.size() < paramInt2))
          {
            localObject2 = new Bundle();
            i = this.b.ax.addAndGet(1);
            ((Bundle)localObject2).putInt("counter", i);
            ((Bundle)localObject2).putBoolean("timeout", true);
            ((Bundle)localObject2).putLong("UIN", Long.valueOf(paramString).longValue());
            ((Bundle)localObject2).putBoolean("canUpdateEct", bool1);
            this.b.cP.put(Integer.valueOf(i), localArrayList1);
            Object localObject3 = new ArrayList();
            i = 0;
            MessageRecord localMessageRecord1;
            while (i < localList.size())
            {
              localMessageRecord1 = (MessageRecord)localList.get(i);
              if (localMessageRecord1.time == ((MessageRecord)localObject1).time)
              {
                ((ArrayList)localObject3).add(localMessageRecord1);
                i += 1;
                continue;
                l2 = ((MessageRecord)localObject1).time;
                if (i >= paramInt2)
                {
                  k = i - paramInt2;
                  while (k < i)
                  {
                    localObject3 = (MessageRecord)((List)localObject2).get(k);
                    if (((MessageRecord)localObject3).time >= l3) {
                      localArrayList1.add(localObject3);
                    }
                    k += 1;
                  }
                  this.b.a("all in cache", localArrayList1);
                }
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead fromTime:" + l2);
                  }
                  break;
                  localObject3 = (MessageRecord)((List)localObject2).get(0);
                  localObject2 = ((List)localObject2).subList(0, i).iterator();
                  while (((Iterator)localObject2).hasNext())
                  {
                    localMessageRecord1 = (MessageRecord)((Iterator)localObject2).next();
                    if (localMessageRecord1.time >= l3) {
                      localArrayList1.add(localMessageRecord1);
                    }
                  }
                  this.b.a("cache part", localArrayList1);
                  i = paramInt2 - localArrayList1.size();
                  localArrayList1.addAll(0, this.app.a(paramInt1).a(paramString, paramInt1, ((MessageRecord)localObject3).time, i, String.format("time>=%d or (time=%d and _id<%d)", new Object[] { Long.valueOf(l3), Long.valueOf(((MessageRecord)localObject3).time), Long.valueOf(((MessageRecord)localObject3).getId()) })));
                  this.b.a("cache + db", localArrayList1);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead memdb:size:" + localArrayList1.size() + ",miss:" + i);
                  }
                }
              }
            }
            l2 = ((MessageRecord)localObject1).uniseq;
            i = localArrayList1.size();
            if (localArrayList1.isEmpty()) {
              i = paramInt2;
            }
            for (;;)
            {
              ((Bundle)localObject2).putLong("baseTime", l1);
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "pull roam " + i + ",time=" + l1 + ",timeFilterList:" + ((ArrayList)localObject3).size());
              }
              l3 = 0L;
              if (!bool1) {
                l3 = paramb.EL;
              }
              this.app.a().a(paramString, l1, (short)i, (Bundle)localObject2, l3);
              ((Bundle)localObject2).putInt("size_req", i);
              this.b.cQ.put(top.u(paramString, paramInt1), Boolean.valueOf(false));
              try
              {
                localArrayList1.wait(35000L);
                if ((this.b.cQ.containsKey(top.u(paramString, paramInt1))) && (((Boolean)this.b.cQ.get(top.u(paramString, paramInt1))).booleanValue()))
                {
                  paramb.pX = null;
                  this.b.df("get auto pull C2C msg when pull refresh !", ", timestamp = " + System.currentTimeMillis());
                  this.b.as(paramb);
                  return;
                  i = paramInt2 - i;
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
            if ((((Bundle)localObject2).getBoolean("timeout")) && (QLog.isColorLevel())) {
              QLog.w("Q.msg.BaseMessageManager", 2, "timeout!");
            }
            this.b.df("after pull locallist" + localArrayList1.size(), "");
            this.b.a("after pull locallist", localArrayList1);
            ArrayList localArrayList2 = new ArrayList();
            k = localArrayList1.size() - 1;
            while (k >= 0)
            {
              localMessageRecord1 = (MessageRecord)localArrayList1.get(k);
              Iterator localIterator = ((ArrayList)localObject3).iterator();
              while (localIterator.hasNext())
              {
                MessageRecord localMessageRecord2 = (MessageRecord)localIterator.next();
                if (top.a(localMessageRecord2, localMessageRecord1, true))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead filterMr " + localMessageRecord2.getLogColorContent() + ",uniseq=" + localMessageRecord2.uniseq);
                  }
                  localArrayList2.add(localMessageRecord1);
                }
                else if (QLog.isColorLevel())
                {
                  QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead not find filterMr " + localMessageRecord2.getLogColorContent() + ",mr=" + localMessageRecord1.getLogColorContent());
                }
              }
              k -= 1;
            }
            localArrayList1.removeAll(localArrayList2);
            if (!((Bundle)localObject2).getBoolean("timeout"))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead " + localArrayList1.size());
              }
              this.app.a(paramInt1).a(paramString, paramInt1, l2, localArrayList1);
              boolean bool2 = ((Bundle)localObject2).getBoolean("success");
              boolean bool3 = ((Bundle)localObject2).getBoolean("complete");
              if (QLog.isColorLevel()) {
                QLog.w("Q.msg.BaseMessageManager", 2, "success ?" + bool2 + ", complete?" + bool3);
              }
              if ((j == 0) && ((!bool2) || (bool3)))
              {
                paramb.aQg = true;
                if (localArrayList1.isEmpty())
                {
                  if (!localArrayList1.isEmpty()) {
                    break label3019;
                  }
                  i = paramInt2;
                  b(paramString, paramInt1, l2, i, paramb, localArrayList1);
                }
              }
              else
              {
                if (!bool1)
                {
                  paramb.EK = ((Bundle)localObject2).getLong("tempEct");
                  paramb.EL = ((Bundle)localObject2).getLong("tempRandom");
                  this.b.df("update tempEct:" + paramb.EK + ", rand=" + paramb.EL, "");
                }
                if ((j != 0) && (localArrayList1.size() < paramInt2) && (bool3)) {
                  a(paramString, paramInt1, paramInt2, paramb, localArrayList1, (MessageRecord)localObject1, l1);
                }
                fn(localArrayList1);
                this.app.a(paramInt1).d(paramString, paramInt1, localArrayList1);
                paramb.pX = localArrayList1;
                if (paramb.isComplete) {
                  bO(paramString, paramInt1);
                }
                paramString = this.b;
                localObject1 = new StringBuilder().append("refresh C2C finish , context = ").append(paramb).append(" , size = ");
                if (localArrayList1 != null) {
                  break label3123;
                }
              }
            }
          }
          for (paramInt2 = -1;; paramInt2 = localArrayList1.size())
          {
            paramString.df(paramInt2, ", timestamp = " + System.currentTimeMillis());
            if ((!top.V(localArrayList1)) || (paramb.bCT >= 3)) {
              break label3132;
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.msg.BaseMessageManager", 2, "refresh C2C finish, now rePull sticker msg! " + paramb.bCT);
            }
            a(paramb, paramInt1);
            return;
            l2 = ((MessageRecord)localArrayList1.get(0)).uniseq;
            break;
            label3019:
            i = paramInt2 - localArrayList1.size();
            break label2700;
            this.b.df("pull timeout", "");
            paramb.aQg = true;
            if (localArrayList1.isEmpty()) {}
            for (;;)
            {
              b(paramString, paramInt1, l2, i, paramb, localArrayList1);
              break;
              l2 = ((MessageRecord)localArrayList1.get(0)).uniseq;
            }
            if ((j == 0) || (localArrayList1.size() >= paramInt2)) {
              break label2826;
            }
            a(paramString, paramInt1, paramInt2, paramb, localArrayList1, (MessageRecord)localObject1, l1);
            break label2826;
          }
          this.b.as(paramb);
          return;
        }
        label2826:
        label3148:
        i = 0;
        localObject1 = null;
      }
      label3157:
      i = 0;
      continue;
      label3163:
      i = 0;
    }
  }
  
  public void b(String paramString, int paramInt1, long paramLong, int paramInt2, QQMessageFacade.b paramb, ArrayList<MessageRecord> paramArrayList)
  {
    a(paramString, paramInt1, paramLong, paramInt2, paramb, paramArrayList, true);
  }
  
  public void bEm()
  {
    this.app.b().gP.remove(acbn.bkE);
    String str = acbn.bkE;
    Iterator localIterator = this.app.a(1001).g(str, 1001).iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (!afcw.am(localMessageRecord)) {
        this.app.a(localMessageRecord.istroop).a(acbn.bkE, localMessageRecord.istroop, localMessageRecord.senderuin + "", localMessageRecord.selfuin + "", localMessageRecord.getExtraKey());
      }
    }
    this.app.a().bT(str, 1001);
  }
  
  protected void bL(String paramString, int paramInt)
  {
    super.bL(paramString, paramInt);
    if (paramInt == 1038)
    {
      paramString = (adag)this.app.getBusinessHandler(148);
      if (paramString != null) {
        paramString.cPv();
      }
    }
  }
  
  public void c(String paramString, int paramInt1, int paramInt2, QQMessageFacade.b paramb)
  {
    Object localObject = this.app.a(paramInt1).l(paramString, paramInt1);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshC2CMessageListHead ERROR: AIO is closed !!");
      }
      paramb.pX = null;
      a(paramb, paramInt1);
    }
    long l;
    do
    {
      return;
      if (localObject != null) {
        this.b.a("current Aio", ((List)localObject).subList(0, Math.min(15, ((List)localObject).size())));
      }
      l = ((MessageRecord)((List)localObject).get(0)).uniseq;
      localObject = new ArrayList();
      paramb.aQg = true;
    } while (!paramb.aQg);
    b(paramString, paramInt1, l, paramInt2, paramb, (ArrayList)localObject);
    this.app.a(paramInt1).d(paramString, paramInt1, (List)localObject);
    paramb.pX = ((List)localObject);
    if (ocp.m(this.app, paramString))
    {
      if ((paramb.pX == null) || (paramb.pX.size() == 0))
      {
        l = kaw.a().a(this.app, paramString);
        ((PublicAccountHandler)this.app.getBusinessHandler(11)).m(paramString, l, 1);
        anot.b(this.app, "P_CliOper", "Pb_account_lifeservice", paramString, "0X8005C99", "0X8005C99", 0, 1, 0, "new", "2", "", "");
        return;
      }
      paramb.isComplete = false;
      paramb.isSuccess = false;
    }
    paramString = this.b;
    StringBuilder localStringBuilder = new StringBuilder().append("refresh load local C2C msg only FIN , context = ").append(paramb).append(", size = ");
    if (localObject == null) {}
    for (paramInt1 = -1;; paramInt1 = ((ArrayList)localObject).size())
    {
      paramString.df(paramInt1, ", timestamp = " + System.currentTimeMillis());
      this.b.as(paramb);
      return;
    }
  }
  
  public void d(String paramString, int paramInt1, int paramInt2, QQMessageFacade.b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageManager", 2, String.format("doRefreshMessageListHead_Confess uin:%s type:%d topicId:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramb.topicId) }));
    }
    Object localObject = this.app.a(paramInt1).l(paramString, paramInt1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      int i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        if (((MessageRecord)((List)localObject).get(i)).getConfessTopicId() != paramb.topicId) {
          ((List)localObject).remove(i);
        }
        i -= 1;
      }
    }
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      this.b.a("current Aio", ((List)localObject).subList(0, Math.min(paramInt2, ((List)localObject).size())));
    }
    if ((localObject != null) && (((List)localObject).size() > 0)) {}
    for (long l = ((MessageRecord)((List)localObject).get(0)).uniseq;; l = 0L)
    {
      localObject = new ArrayList();
      a(paramString, paramInt1, l, paramInt2, paramb, (ArrayList)localObject);
      fn((List)localObject);
      this.app.a(paramInt1).d(paramString, paramInt1, (List)localObject);
      paramb.pX = ((List)localObject);
      this.b.as(paramb);
      return;
    }
  }
  
  protected boolean fq(int paramInt)
  {
    UinType localUinType = UinType.valueOf(paramInt);
    if (localUinType != null) {
      return localUinType.isInvalidUinTypeWhenRefresh();
    }
    return (paramInt != 0) && (paramInt != 1000) && (paramInt != 1004) && (paramInt != 9501) && (paramInt != 1044) && (paramInt != 1045) && (paramInt != 10007) && (paramInt != 10008);
  }
  
  protected boolean gN(String paramString)
  {
    paramString = ((acja)this.app.getManager(56)).b(paramString);
    if (paramString != null) {
      return paramString.isVisible();
    }
    return true;
  }
  
  public void v(MessageRecord paramMessageRecord)
  {
    ThreadManager.post(new C2CMessageManager.1(this, paramMessageRecord), 8, null, true);
  }
  
  public static class a
  {
    public boolean aPY;
    public boolean isOver;
    public long origUid;
    public long time;
    public boolean valid;
    
    public void f(long paramLong1, long paramLong2, boolean paramBoolean)
    {
      this.isOver = false;
      this.valid = true;
      this.time = paramLong2;
      this.origUid = paramLong1;
      this.aPY = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     toa
 * JD-Core Version:    0.7.0.1
 */