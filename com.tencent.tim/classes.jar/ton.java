import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.commonsdk.util.LargerInteger;
import com.tencent.imcore.message.MsgProxy.1;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.app.msgcache.MsgLruCache;
import com.tencent.mobileqq.app.proxy.MsgQueueItem;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.locks.Lock;

public class ton
  extends acxq
{
  private static int bCM = 1;
  private static int bCN = 1;
  protected akvm a;
  private tom a;
  private Object bE = new Object();
  
  public ton(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager, tom paramtom)
  {
    super(paramQQAppInterface, paramProxyManager);
    this.jdField_a_of_type_Tom = paramtom;
  }
  
  private void L(String paramString, int paramInt1, int paramInt2)
  {
    List localList = c(paramString, paramInt1, paramInt2);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localList != null)
    {
      localObject1 = localObject2;
      if (!localList.isEmpty())
      {
        if ((QLog.isColorLevel()) && (aqmq.aFf()))
        {
          localObject1 = new StringBuilder(localList.size() * 48 + 28);
          ((StringBuilder)localObject1).append("getAIOMsgList_confess, msgInfoList: ");
          localObject2 = localList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
            ((StringBuilder)localObject1).append("(").append(localMessageRecord.time).append(",").append(localMessageRecord.shmsgseq).append(",").append(localMessageRecord.msgtype).append(") ");
          }
          QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = new ArrayList();
        u(localList, (List)localObject1);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new ArrayList();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "getAIOMsgList_confess continuedList :" + ((List)localObject2).size());
    }
    b(paramString, paramInt1, (List)localObject2);
  }
  
  private int M(String paramString, int paramInt)
  {
    List localList = k(paramString, paramInt);
    int i = 0;
    if (localList != null)
    {
      i = localList.size();
      localList.clear();
    }
    if (T().containsKey(u(paramString, paramInt))) {
      T().remove(u(paramString, paramInt));
    }
    return i;
  }
  
  private void M(String paramString, int paramInt1, int paramInt2)
  {
    Lock localLock = a(paramString, paramInt1);
    localLock.lock();
    try
    {
      N(paramString, paramInt1, paramInt2);
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  private void N(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = k(paramString, paramInt1);
    if ((localObject == null) || (((List)localObject).isEmpty())) {}
    for (;;)
    {
      return;
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        if ((!localMessageRecord.isread) && (localMessageRecord.getConfessTopicId() == paramInt2)) {
          localMessageRecord.isread = true;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "setMsgRead " + ((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).getBaseInfoString());
      }
      paramString = m(paramString, paramInt1);
      if ((paramString != null) && (!paramString.isEmpty()))
      {
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          localObject = (MessageRecord)paramString.next();
          if ((!((MessageRecord)localObject).isread) && (((MessageRecord)localObject).getConfessTopicId() == paramInt2)) {
            ((MessageRecord)localObject).isread = true;
          }
        }
      }
    }
  }
  
  private List<MessageRecord> W(String paramString)
  {
    return b().get(paramString);
  }
  
  private List<MessageRecord> X(String paramString)
  {
    return (List)T().get(paramString);
  }
  
  private int a(int paramInt1, QQMessageFacade.Message paramMessage, String paramString, int paramInt2, int paramInt3)
  {
    Object localObject = k(paramString, paramInt2);
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      return paramInt3;
    }
    localObject = ((List)localObject).iterator();
    MessageRecord localMessageRecord;
    while (((Iterator)localObject).hasNext())
    {
      localMessageRecord = (MessageRecord)((Iterator)localObject).next();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "setRecommendMsgReaded " + localMessageRecord.getBaseInfoString());
      }
      if ((localMessageRecord.msgtype == paramInt1) && (!localMessageRecord.isread))
      {
        paramInt3 += 1;
        localMessageRecord.isread = true;
      }
    }
    localObject = m(paramString, paramInt2);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((localMessageRecord.msgtype == paramInt1) && (!localMessageRecord.isread)) {
          localMessageRecord.isread = true;
        }
      }
    }
    localObject = new ContentValues();
    ((ContentValues)localObject).put("isread", Boolean.valueOf(true));
    a(paramString, paramInt2, paramMessage.versionCode, (ContentValues)localObject, "msgtype=? and isread=?", new String[] { String.valueOf(paramInt1), "0" }, null);
    return paramInt3;
  }
  
  private int a(int paramInt, List<MessageRecord> paramList)
  {
    int j = 0;
    int i = j;
    if (paramList != null)
    {
      i = j;
      if (paramList.size() > 0)
      {
        if (paramInt <= 0) {
          break label69;
        }
        paramList = paramList.iterator();
        i = 0;
        if (paramList.hasNext())
        {
          if (((MessageRecord)paramList.next()).getConfessTopicId() != paramInt) {
            break label76;
          }
          i += 1;
        }
      }
    }
    label69:
    label76:
    for (;;)
    {
      break;
      return i;
      return paramList.size();
    }
  }
  
  private QQMessageFacade.Message a(String paramString, EntityManager paramEntityManager, int paramInt1, int paramInt2)
  {
    if (u(paramString, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase(paramEntityManager);
    }
    int i;
    String str;
    if ((paramString.startsWith("mr_discusssion")) || (paramString.startsWith("mr_troop")))
    {
      i = 1;
      boolean bool = paramString.endsWith("_New");
      str = "select * from (select count() as unReadNum from %s mr where mr.isread=0),(select count() as hasReply from %s mr where mr.issend=0),%s m where m.isValid=1 and m.msgtype " + top.ow() + " and m.longMsgId='%d' and m.issend='%d' order by %s limit 1";
      if (!bool) {
        break label183;
      }
      if (i == 0) {
        break label176;
      }
      paramEntityManager = "longMsgIndex asc , shmsgseq desc , _id desc";
    }
    for (;;)
    {
      paramString = String.format(str, new Object[] { paramString, paramString, paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramEntityManager });
      paramString = a().rawQuery(QQMessageFacade.Message.class, paramString, null);
      if ((paramString == null) || (paramString.isEmpty())) {
        break label190;
      }
      return (QQMessageFacade.Message)paramString.get(0);
      i = 0;
      break;
      label176:
      paramEntityManager = "longMsgIndex asc , time desc , _id desc";
      continue;
      label183:
      paramEntityManager = "_id desc";
    }
    label190:
    return null;
  }
  
  private MessageRecord a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, boolean paramBoolean)
  {
    if (paramMessageRecord1 == null) {}
    do
    {
      do
      {
        do
        {
          return paramMessageRecord2;
          if (!top.c(paramMessageRecord1, paramMessageRecord2)) {
            break;
          }
        } while (paramMessageRecord1.longMsgIndex > paramMessageRecord2.longMsgIndex);
        return paramMessageRecord1;
        if (!paramBoolean) {
          break;
        }
      } while (paramMessageRecord2.shmsgseq > paramMessageRecord1.shmsgseq);
      return paramMessageRecord1;
    } while (paramMessageRecord2.time > paramMessageRecord1.time);
    return paramMessageRecord1;
  }
  
  private List<MessageRecord> a(String paramString1, int paramInt, String paramString2)
  {
    List localList2 = W(paramString2);
    List localList1 = localList2;
    if (localList2 == null)
    {
      long l = System.nanoTime();
      localList1 = c(paramString1, paramInt, new anpc.e());
      c(paramString1, paramInt, localList1);
      a(paramString1, paramString2, localList1, l);
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("getMsgList1 uin ").append(paramString1).append(" , type = ").append(paramInt).append(" itemList size=").append(localList1.size());
      if ((bCM % 20 == 0) && (bCM > 100)) {
        paramString2.append("\n").append(QLog.getStackTraceString(new Throwable("MsgProxy_getMsgList1")));
      }
      QLog.d("Q.msg.MsgProxy", 2, paramString2.toString());
      bCM += 1;
    }
    return localList1;
  }
  
  private List<MessageRecord> a(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramInt == 0) || (paramInt == 1000) || (paramInt == 1004) || (paramInt == 1044) || (paramInt == 1045)) {
      return a(paramString, paramInt, paramList, localArrayList);
    }
    if ((paramInt == 1033) || (paramInt == 1034))
    {
      u(paramList, localArrayList);
      return localArrayList;
    }
    localArrayList.addAll(paramList);
    return localArrayList;
  }
  
  private List<MessageRecord> a(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2)
  {
    if (paramList1.size() > 15)
    {
      paramList2.addAll(paramList1.subList(paramList1.size() - 15, paramList1.size()));
      if ((!top.b(paramString, paramInt, paramList2)) && (!top.V(paramList2))) {
        break label207;
      }
      paramInt = 1;
      label60:
      if ((paramList1.size() > 15) && (paramInt != 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "getAIOMsgList : pull more long msg");
        }
        paramList2.clear();
        if (paramList1.size() <= 30) {
          break label212;
        }
        paramList2.addAll(paramList1.subList(paramList1.size() - 30, paramList1.size()));
      }
    }
    for (;;)
    {
      paramList1 = this.app.a().h(paramString);
      paramString = paramList2;
      if (paramList1 != null)
      {
        paramList1 = b(paramList2, ((Long)paramList1.first).longValue());
        paramString = paramList2;
        if (paramList1 != null)
        {
          paramString = paramList2;
          if (!paramList1.isEmpty()) {
            paramString = paramList1;
          }
        }
      }
      return paramString;
      paramList2.addAll(paramList1);
      break;
      label207:
      paramInt = 0;
      break label60;
      label212:
      paramList2.addAll(paramList1);
    }
  }
  
  @Nullable
  private List<MessageRecord> a(String paramString, int paramInt, boolean paramBoolean)
  {
    List localList = X(u(paramString, paramInt));
    if ((localList == null) || (localList.isEmpty()))
    {
      if (b(paramString, paramInt, paramBoolean)) {
        return null;
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "getAIOMsgList from aioPool size = " + localList.size());
    }
    return X(u(paramString, paramInt));
  }
  
  private void a(anpc.e parame)
  {
    if ((parame.dKY != 0) && (anpc.ayC()) && (anpc.lH(1)))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_IsMainThread", String.valueOf(parame.dKX));
      localHashMap.put("param_OptType", parame.cfO);
      localHashMap.put("param_OptTotalCost", String.valueOf(parame.ant));
      localHashMap.put("param_OptCount", String.valueOf(parame.dKY));
      localHashMap.put("param_OptMsgCount", String.valueOf(parame.dKZ));
      localHashMap.put("param_OptOneCost", String.valueOf(parame.anu));
      localHashMap.put("param_OptScene", parame.cfP);
      localHashMap.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "actSqliteOptCost", true, parame.dKZ, 0L, localHashMap, null, false);
    }
  }
  
  private void a(String paramString, int paramInt, anpc.e parame, long paramLong)
  {
    if (TextUtils.equals(parame.cfP, "launch"))
    {
      paramLong = (System.nanoTime() - paramLong) / 1000L;
      parame.ant += paramLong;
      parame.dKY += 1;
      parame.dKZ += 1;
      parame.anu = (parame.ant / parame.dKY);
      if ((anpc.cJf) && (QLog.isColorLevel()) && (top.w(paramString, paramInt))) {
        QLog.d("Q.msg.MsgProxy", 2, "SQLCost|" + this.app.getAccount() + "|select|launch|1|" + paramLong / 1000L + "|" + paramString);
      }
    }
    for (;;)
    {
      return;
      if (TextUtils.equals(parame.cfP, "AIO"))
      {
        paramLong = (System.nanoTime() - paramLong) / 1000L;
        parame.ant = paramLong;
        parame.dKY = 1;
        parame.dKZ = 1;
        parame.anu = (parame.ant / parame.dKY);
        if ((anpc.cJf) && (QLog.isColorLevel()) && (top.w(paramString, paramInt))) {
          QLog.d("Q.msg.MsgProxy", 2, "SQLCost|" + this.app.getAccount() + "|select|AIO|1|" + paramLong / 1000L + "|" + paramString);
        }
      }
      else
      {
        paramLong = (System.nanoTime() - paramLong) / 1000L;
        if (Looper.myLooper() == Looper.getMainLooper()) {}
        for (paramInt = 1; (paramInt != 0) && (anpc.ayC()) && (anpc.lH(2)); paramInt = 0)
        {
          parame.dKX = 1;
          parame.cfO = "select";
          parame.cfP = "mainThread";
          parame.ant = paramLong;
          parame.dKY = 1;
          parame.dKZ = 1;
          parame.anu = (parame.ant / parame.dKY);
          paramString = new HashMap();
          paramString.put("param_IsMainThread", String.valueOf(parame.dKX));
          paramString.put("param_OptType", parame.cfO);
          paramString.put("param_OptTotalCost", String.valueOf(parame.ant));
          paramString.put("param_OptCount", String.valueOf(parame.dKY));
          paramString.put("param_OptMsgCount", String.valueOf(parame.dKZ));
          paramString.put("param_OptOneCost", String.valueOf(parame.anu));
          paramString.put("param_OptScene", parame.cfP);
          paramString.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
          anpc.a(BaseApplication.getContext()).collectPerformance(null, "actSqliteOptCost", true, parame.dKZ, 0L, paramString, null, false);
          return;
        }
      }
    }
  }
  
  private void a(List<MessageRecord> paramList, ProxyListener paramProxyListener)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (localMessageRecord.versionCode > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("vip", 2, "proxy addSync id=" + localMessageRecord.vipBubbleID);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.addMsgQueueDonotNotify(localMessageRecord.frienduin, localMessageRecord.istroop, getTableName(localMessageRecord.frienduin, localMessageRecord.istroop), localMessageRecord, 0, paramProxyListener);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase();
  }
  
  private MessageRecord b(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject1 = i(paramString, paramInt1);
    int i;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      i = ((List)localObject1).size() - 1;
      if (i >= 0) {
        if ((paramInt2 == 0) || (((MessageRecord)((List)localObject1).get(i)).getConfessTopicId() == paramInt2))
        {
          localObject1 = (MessageRecord)((List)localObject1).get(i);
          label76:
          localObject2 = localObject1;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder().append("getLastMsgFromList mr = ");
            if (localObject1 != null) {
              break label215;
            }
            localObject2 = "null";
            label111:
            QLog.d("Q.msg.MsgProxy", 2, (String)localObject2);
          }
        }
      }
    }
    for (Object localObject2 = localObject1;; localObject2 = null)
    {
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        QLog.e("Q.msg.MsgProxy", 1, new Object[] { "getLastMsgFromList no cache", paramString, ",", Integer.valueOf(paramInt1), ",", Integer.valueOf(paramInt2) });
        acqz.p(this.app, paramString, paramInt1);
        localObject1 = c(paramString, paramInt1, paramInt2);
      }
      return localObject1;
      i -= 1;
      break;
      label215:
      localObject2 = ((MessageRecord)localObject1).getBaseInfoString();
      break label111;
      localObject1 = null;
      break label76;
    }
  }
  
  @Nullable
  private MessageRecord b(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    paramString = W(u(paramString, paramInt1));
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramString.next();
        if ((localMessageRecord.shmsgseq == paramLong) && (localMessageRecord.msgtype == paramInt2)) {
          return localMessageRecord;
        }
      }
    }
    return null;
  }
  
  private List<MessageRecord> b(String paramString, int paramInt, anpc.e parame)
  {
    String str = u(paramString, paramInt);
    List localList2 = W(str);
    List localList1 = localList2;
    if (localList2 == null)
    {
      long l = System.nanoTime();
      localList1 = c(paramString, paramInt, parame);
      c(paramString, paramInt, localList1);
      a(paramString, str, localList1, l);
    }
    if (QLog.isColorLevel())
    {
      parame = new StringBuilder();
      parame.append("getMsgList2 uin ").append(paramString).append(" , type = ").append(paramInt).append(" itemList size=").append(localList1.size());
      if ((bCN % 20 == 0) && (bCN > 100)) {
        parame.append("\n").append(QLog.getStackTraceString(new Throwable("MsgProxy_getMsgList1")));
      }
      QLog.d("Q.msg.MsgProxy", 2, parame.toString());
      bCN += 1;
    }
    return localList1;
  }
  
  public static List<MessageRecord> b(List<MessageRecord> paramList, long paramLong)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
      if (localMessageRecord.time >= paramLong) {
        localArrayList.add(localMessageRecord);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private void b(String paramString, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    Object localObject2 = k(paramString, paramInt);
    Object localObject1 = u(paramString, paramInt);
    a(paramString, paramInt, (String)localObject1, (List)localObject2);
    top.a((List)localObject2, paramMessageRecord, true);
    if ((localObject2 != null) && (((List)localObject2).size() > 40) && (!top.gP(paramString)))
    {
      ((List)localObject2).remove(0);
      localObject2 = b();
      if (((MsgLruCache)localObject2).getCacheType(localObject1) == acss.czW) {
        ((MsgLruCache)localObject2).changeCacheType(localObject1, acss.czV);
      }
    }
    if ((T().containsKey(localObject1)) && (paramBoolean))
    {
      localObject1 = X((String)localObject1);
      if (localObject1 != null) {
        break label256;
      }
      localObject1 = new ArrayList();
    }
    label256:
    for (;;)
    {
      if (((paramMessageRecord instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)paramMessageRecord).tipParam.dbK == 3211265)) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if (((paramMessageRecord instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)paramMessageRecord).tipParam.dbK == 655392)) {}
        for (int i = 1;; i = 0)
        {
          if (paramString.equals(acbn.bkD))
          {
            ((List)localObject1).add(0, paramMessageRecord);
            return;
          }
          if ((paramMessageRecord.msgtype == -4021) || (paramInt != 0) || (i != 0))
          {
            top.a((List)localObject1, paramMessageRecord, true);
            return;
          }
          ((List)localObject1).add(paramMessageRecord);
          return;
        }
      }
    }
  }
  
  private void b(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    List localList = k(paramString1, paramInt1);
    ArrayList localArrayList = new ArrayList();
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        if ((localMessageRecord.senderuin != null) && (localMessageRecord.selfuin != null) && (localMessageRecord.senderuin.equals(paramString2)) && (localMessageRecord.selfuin.equals(paramString3)) && (((paramInt2 != 0) && (paramInt2 == localMessageRecord.getExtraKey())) || (paramInt2 == 0))) {
          localArrayList.add(localMessageRecord);
        }
      }
      localList.removeAll(localArrayList);
    }
    if (paramInt2 == 0L) {
      a(paramString1, paramInt1, getTableName(paramString1, paramInt1), "senderuin=? and selfuin=?", new String[] { paramString2, paramString3 }, null);
    }
    for (;;)
    {
      localArrayList.clear();
      return;
      if (paramInt1 == 1032)
      {
        paramString1 = localArrayList.iterator();
        while (paramString1.hasNext()) {
          a((MessageRecord)paramString1.next(), false);
        }
      }
    }
  }
  
  private void b(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    T().put(u(paramString, paramInt), paramList);
  }
  
  private boolean b(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      bW(paramString, paramInt);
      return false;
    }
    T().remove(u(paramString, paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "getAioMsgPool().remove");
    }
    return true;
  }
  
  private void bEt()
  {
    zxj localzxj = (zxj)this.app.getManager(125);
    localzxj.hJ = null;
    localzxj.hK = null;
  }
  
  private void bW(String paramString, int paramInt)
  {
    Object localObject = new anpc.e();
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    for (int i = 1;; i = 0)
    {
      ((anpc.e)localObject).dKX = i;
      ((anpc.e)localObject).cfO = "select";
      ((anpc.e)localObject).cfP = "AIO";
      localList = a(paramString, paramInt, (anpc.e)localObject);
      a((anpc.e)localObject);
      if ((localList == null) || (localList.isEmpty())) {
        break label288;
      }
      if ((!QLog.isColorLevel()) || (!aqmq.aFf())) {
        break label213;
      }
      localObject = new StringBuilder(localList.size() * 48 + 28);
      ((StringBuilder)localObject).append("getAIOMsgList, msgInfoList: ");
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        ((StringBuilder)localObject).append("(").append(localMessageRecord.time).append(",").append(localMessageRecord.shmsgseq).append(",").append(localMessageRecord.msgtype).append(") ");
      }
    }
    QLog.d("Q.msg.MsgProxy", 2, ((StringBuilder)localObject).toString());
    label213:
    for (List localList = a(paramString, paramInt, localList);; localList = n(paramString, paramInt))
    {
      localObject = localList;
      if (localList == null) {
        localObject = new ArrayList();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "continuedList :" + ((List)localObject).size());
      }
      b(paramString, paramInt, (List)localObject);
      return;
    }
  }
  
  @Nullable
  private List<MessageRecord> c(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    List localList = X(u(paramString, paramInt1));
    if (a(paramInt2, localList) == 0) {
      if (paramBoolean) {
        L(paramString, paramInt1, paramInt2);
      }
    }
    for (;;)
    {
      paramString = X(u(paramString, paramInt1));
      do
      {
        return paramString;
        T().remove(u(paramString, paramInt1));
        paramString = localList;
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.MsgProxy", 2, "MsgPool.getPoolInstance().getAIOMsgList_confess().remove");
      return localList;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "getAIOMsgList_confess from aioPool size = " + localList.size());
      }
    }
  }
  
  private void c(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    List localList = W(u(paramString, paramInt));
    if (localList != null)
    {
      top.a(localList, paramMessageRecord, true);
      if (localList.size() > 40)
      {
        localList.remove(0);
        paramMessageRecord = u(paramString, paramInt);
        MsgLruCache localMsgLruCache = b();
        if (localMsgLruCache.getCacheType(paramMessageRecord) == acss.czW) {
          localMsgLruCache.changeCacheType(paramMessageRecord, acss.czV);
        }
      }
      c(paramString, paramInt, localList);
    }
  }
  
  @Nullable
  private List<MessageRecord> d(String paramString, int paramInt1, int paramInt2)
  {
    List localList2 = W(u(paramString, paramInt1));
    List localList1 = localList2;
    if (a(paramInt2, localList2) == 0)
    {
      localList1 = e(paramString, paramInt1, paramInt2);
      c(paramString, paramInt1, localList1);
    }
    if ((localList1 != null) && (QLog.isColorLevel())) {
      QLog.d("Q.msg.MsgProxy", 2, String.format("getMsgList_confess uin:%s type:%d topicId:%d size:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(localList1.size()) }));
    }
    return localList1;
  }
  
  private List<MessageRecord> d(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = W(u(paramString, paramInt1));
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramString.next();
        if ((localMessageRecord.shmsgseq == paramLong) && (localMessageRecord.msgtype == paramInt2)) {
          localArrayList.add(localMessageRecord);
        }
      }
    }
    return localArrayList;
  }
  
  private List<MessageRecord> d(String paramString, int paramInt, anpc.e parame)
  {
    Object localObject2 = W(u(paramString, paramInt));
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.MsgProxy", 2, "init from cache, uin=" + paramString);
        localObject1 = localObject2;
      }
    }
    long l1;
    boolean bool;
    do
    {
      return localObject1;
      l1 = System.currentTimeMillis();
      localObject2 = O(paramString, paramInt);
      bool = c(paramString, paramInt, false);
      if (bool) {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase();
      }
      List localList = o(paramString, paramInt);
      long l2 = System.nanoTime();
      localObject1 = a().a((String)localObject2, null, this.app);
      a(paramString, paramInt, parame, l2);
      if (localObject1 != null)
      {
        int j = ((List)localObject1).size() / 2;
        paramInt = ((List)localObject1).size();
        int i = 0;
        paramInt -= 1;
        while (i < j)
        {
          parame = (MessageRecord)((List)localObject1).get(i);
          ((List)localObject1).set(i, ((List)localObject1).get(paramInt));
          ((List)localObject1).set(paramInt, parame);
          i += 1;
          paramInt -= 1;
        }
      }
      for (parame = (anpc.e)localObject1;; parame = new ArrayList())
      {
        localObject1 = top.e(parame, localList).iterator();
        while (((Iterator)localObject1).hasNext()) {
          top.a(parame, (MessageRecord)((Iterator)localObject1).next(), true);
        }
      }
      localObject1 = parame;
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MsgProxy", 2, new Object[] { "init from db, uin=", paramString, ", isSaveToDatabase=", Boolean.valueOf(bool), ", cost=", Long.valueOf(System.currentTimeMillis() - l1), " sqlStr = ", localObject2, " size =", Integer.valueOf(parame.size()) });
    return parame;
  }
  
  private List<MessageRecord> e(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject2 = new StringBuilder();
    if (c(paramString, paramInt1, false)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase();
    }
    ((StringBuilder)localObject2).append("select * from ");
    ((StringBuilder)localObject2).append(getTableName(paramString, paramInt1));
    ((StringBuilder)localObject2).append(" where _id in ");
    ((StringBuilder)localObject2).append("(select _id from ");
    ((StringBuilder)localObject2).append(getTableName(paramString, paramInt1));
    int i;
    if (paramInt2 > 0)
    {
      i = aegu.ag(paramInt1, paramInt2);
      ((StringBuilder)localObject2).append(" where (extLong & 4194296)=");
      ((StringBuilder)localObject2).append(i << 3);
    }
    ((StringBuilder)localObject2).append(" order by time desc limit ");
    ((StringBuilder)localObject2).append(40);
    ((StringBuilder)localObject2).append(")");
    ((StringBuilder)localObject2).append(" order by time desc, _id desc");
    Object localObject1 = f(paramString, paramInt1, paramInt2);
    paramString = a().a(((StringBuilder)localObject2).toString(), null, this.app);
    if (QLog.isColorLevel())
    {
      localObject2 = ((StringBuilder)localObject2).toString();
      if (paramString != null) {
        break label297;
      }
    }
    label297:
    for (paramInt1 = 0;; paramInt1 = paramString.size())
    {
      QLog.i("Q.msg.MsgProxy", 2, String.format("getMsgList_confess sql:%s listSize:%d", new Object[] { localObject2, Integer.valueOf(paramInt1) }));
      if (paramString == null) {
        break label348;
      }
      i = paramString.size() / 2;
      paramInt1 = paramString.size();
      paramInt2 = 0;
      paramInt1 -= 1;
      while (paramInt2 < i)
      {
        localObject2 = (MessageRecord)paramString.get(paramInt2);
        paramString.set(paramInt2, paramString.get(paramInt1));
        paramString.set(paramInt1, localObject2);
        paramInt2 += 1;
        paramInt1 -= 1;
      }
    }
    for (;;)
    {
      localObject1 = top.e(paramString, (List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        top.a(paramString, (MessageRecord)((Iterator)localObject1).next(), true);
      }
      label348:
      paramString = new ArrayList();
    }
    return paramString;
  }
  
  private int eC(int paramInt)
  {
    Object localObject = k(acbn.bkV, 4001);
    int i;
    if (localObject != null)
    {
      int j = ((List)localObject).size() - 1;
      i = 0;
      while (j >= 0)
      {
        if (((MessageRecord)((List)localObject).get(j)).msgtype != paramInt) {
          break label179;
        }
        ((List)localObject).remove(j);
        i += 1;
        j -= 1;
      }
      a(String.valueOf(acbn.bkV), 4001, getTableName(String.valueOf(acbn.bkV), 4001), "msgtype=?", new String[] { String.valueOf(paramInt) }, null);
    }
    for (;;)
    {
      if ((localObject != null) && (((List)localObject).size() == 0) && (anze.a().af(this.app) <= 0))
      {
        localObject = this.app.a().a();
        RecentUser localRecentUser = ((acxw)localObject).a(acbn.bkT, 9000);
        if (localRecentUser != null) {
          ((acxw)localObject).f(localRecentUser);
        }
      }
      return i;
      label179:
      break;
      i = 0;
    }
  }
  
  @Nullable
  private MessageRecord f(String paramString, int paramInt, long paramLong)
  {
    List localList = null;
    Object localObject2 = k(paramString, paramInt);
    Object localObject1 = localList;
    if (localObject2 != null)
    {
      Iterator localIterator = ((List)localObject2).iterator();
      do
      {
        localObject1 = localList;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (MessageRecord)localIterator.next();
      } while (((MessageRecord)localObject1).uniseq != paramLong);
      ((List)localObject2).remove(localObject1);
    }
    localList = m(paramString, paramInt);
    paramString = (String)localObject1;
    if (localList != null)
    {
      localObject2 = localList.iterator();
      do
      {
        paramString = (String)localObject1;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        paramString = (MessageRecord)((Iterator)localObject2).next();
      } while (paramString.uniseq != paramLong);
      localList.remove(paramString);
    }
    return paramString;
  }
  
  private void fq(List<MessageRecord> paramList)
  {
    HashMap localHashMap = new HashMap();
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      String str = top.e((MessageRecord)paramList.get(i));
      if (localHashMap.containsKey(str)) {
        if (((Integer)localHashMap.get(str)).intValue() >= 15) {
          paramList.remove(i);
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        localHashMap.put(str, Integer.valueOf(((Integer)localHashMap.get(str)).intValue() + 1));
        continue;
        localHashMap.put(str, Integer.valueOf(1));
      }
    }
  }
  
  @Nullable
  private MessageRecord h(String paramString, int paramInt, long paramLong)
  {
    List localList = null;
    Object localObject2 = k(paramString, paramInt);
    Object localObject1 = localList;
    if (localObject2 != null)
    {
      Iterator localIterator = ((List)localObject2).iterator();
      do
      {
        localObject1 = localList;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (MessageRecord)localIterator.next();
      } while (((MessageRecord)localObject1).getId() != paramLong);
      ((List)localObject2).remove(localObject1);
    }
    localList = m(paramString, paramInt);
    paramString = (String)localObject1;
    if (localList != null)
    {
      localObject2 = localList.iterator();
      do
      {
        paramString = (String)localObject1;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        paramString = (MessageRecord)((Iterator)localObject2).next();
      } while (paramString.getId() != paramLong);
      localList.remove(paramString);
    }
    return paramString;
  }
  
  @Nullable
  private MessageRecord j(String paramString, int paramInt, long paramLong)
  {
    paramString = W(u(paramString, paramInt));
    if (paramString != null)
    {
      Iterator localIterator = paramString.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        if (localMessageRecord.uniseq == paramLong)
        {
          paramString.remove(localMessageRecord);
          return localMessageRecord;
        }
      }
    }
    return null;
  }
  
  private List<MessageRecord> n(String paramString, int paramInt)
  {
    return g(paramString, paramInt, 15);
  }
  
  private void r(String paramString, int paramInt, long paramLong)
  {
    Object localObject = k(paramString, paramInt);
    if ((localObject == null) || (((List)localObject).isEmpty())) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((!localMessageRecord.isread) && (a(paramInt, paramLong, localMessageRecord)) && ((!top.ft(paramInt)) || (!top.fF(localMessageRecord.msgtype)))) {
          localMessageRecord.isread = true;
        }
      }
      paramString = m(paramString, paramInt);
      if ((paramString != null) && (!paramString.isEmpty()))
      {
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          localObject = (MessageRecord)paramString.next();
          if ((!((MessageRecord)localObject).isread) && (a(paramInt, paramLong, (MessageRecord)localObject)) && ((!top.ft(paramInt)) || (!top.fF(((MessageRecord)localObject).msgtype)))) {
            ((MessageRecord)localObject).isread = true;
          }
        }
      }
    }
  }
  
  private void u(List<MessageRecord> paramList1, List<MessageRecord> paramList2)
  {
    if (paramList1.size() > 15)
    {
      fq(paramList1);
      paramList2.addAll(paramList1);
      return;
    }
    paramList2.addAll(paramList1);
  }
  
  public int K(String paramString, int paramInt)
  {
    paramString = m(paramString, paramInt);
    if (paramString == null) {
      return 0;
    }
    return paramString.size();
  }
  
  protected int L(String paramString, int paramInt)
  {
    Lock localLock = a(paramString, paramInt);
    localLock.lock();
    try
    {
      paramInt = M(paramString, paramInt);
      return paramInt;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  protected String O(String paramString, int paramInt)
  {
    if (top.gP(paramString)) {
      return "select * from " + getTableName(paramString, paramInt) + " order by time desc , _id desc";
    }
    if (top.fv(paramInt)) {
      return "select * from " + getTableName(paramString, paramInt) + " where _id in (select _id from " + getTableName(paramString, paramInt) + " order by time desc limit " + 40 + ") order by time desc, _id desc";
    }
    return "select * from " + getTableName(paramString, paramInt) + " order by _id desc limit " + 40;
  }
  
  protected Map<String, List<MessageRecord>> T()
  {
    return this.jdField_a_of_type_Tom.T();
  }
  
  protected List<MessageRecord> Y(String paramString)
  {
    ArrayList localArrayList;
    synchronized (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.getMsgQueueLock())
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.getQueue();
      localArrayList = new ArrayList();
      localObject2 = ((Vector)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        MsgQueueItem localMsgQueueItem = (MsgQueueItem)((Iterator)localObject2).next();
        if ((localMsgQueueItem.item instanceof MessageRecord))
        {
          MessageRecord localMessageRecord = (MessageRecord)localMsgQueueItem.item;
          if ((TextUtils.equals(paramString, localMsgQueueItem.tableName)) && (localMsgQueueItem.action == 0)) {
            localArrayList.add(localMessageRecord);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, new Object[] { "getMsgListFromQueue tableName=", paramString, ", size=", Integer.valueOf(localArrayList.size()) });
    }
    return localArrayList;
  }
  
  public int a(int paramInt, QQMessageFacade.Message paramMessage)
  {
    String str = String.valueOf(acbn.bkV);
    Lock localLock = a(str, 4001);
    localLock.lock();
    try
    {
      paramInt = a(paramInt, paramMessage, str, 4001, 0);
      return paramInt;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  protected int a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramMessageRecord == null) {
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "--->deleteC2CMsgByMessageRecord : peerUin:" + paramMessageRecord.frienduin + " type:" + paramMessageRecord.istroop + " uniseq:" + paramMessageRecord.uniseq + " mr:" + paramMessageRecord + " dbid:" + paramMessageRecord.getId());
    }
    if (ahwb.aB(paramMessageRecord)) {
      return b(paramMessageRecord, paramBoolean);
    }
    if (paramBoolean)
    {
      g(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.getId());
      label125:
      long l = paramMessageRecord.getId();
      if (l <= 0L) {
        break label204;
      }
      a(paramMessageRecord.frienduin, paramMessageRecord.istroop, getTableName(paramMessageRecord.frienduin, paramMessageRecord.istroop), "_id=?", new String[] { String.valueOf(l) }, null);
    }
    for (;;)
    {
      if (paramMessageRecord.isread) {
        break label258;
      }
      return 2;
      e(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
      break label125;
      label204:
      if (paramMessageRecord.uniseq == 0L) {
        break;
      }
      a(paramMessageRecord.frienduin, paramMessageRecord.istroop, getTableName(paramMessageRecord.frienduin, paramMessageRecord.istroop), "uniseq=?", new String[] { String.valueOf(paramMessageRecord.uniseq) }, null);
    }
    label258:
    bX(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    return 1;
  }
  
  public int a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    int i = 0;
    Object localObject = null;
    String str = getTableName(paramString, paramInt);
    paramString = localObject;
    if (top.fv(paramInt))
    {
      paramString = "( msgtype " + top.ox() + " and isValid=1 ) and ( time < ? or (time = ? and longMsgIndex <= ? and _id <= ?))";
      long l1 = paramMessageRecord.time;
      long l2 = paramMessageRecord.time;
      paramInt = paramMessageRecord.longMsgIndex;
      long l3 = paramMessageRecord.getId();
      paramString = a().query(false, str, new String[] { "_id" }, paramString, new String[] { String.valueOf(l1), String.valueOf(l2), String.valueOf(paramInt), String.valueOf(l3) }, null, null, null, null);
    }
    paramInt = i;
    if (paramString != null)
    {
      paramInt = paramString.getCount();
      paramString.close();
    }
    return paramInt;
  }
  
  protected int a(List<MessageRecord> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return -1;
    }
    int i = paramList.size();
    Object localObject1 = (MessageRecord)paramList.get(paramList.size() - 1);
    String str = ((MessageRecord)localObject1).frienduin;
    int j = ((MessageRecord)localObject1).istroop;
    Object localObject2 = new ArrayList();
    localObject1 = new ArrayList();
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (paramBoolean)
      {
        g(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.getId());
        label124:
        if (localMessageRecord.getId() <= 0L) {
          break label176;
        }
        ((List)localObject2).add(String.valueOf(localMessageRecord.getId()));
      }
      for (;;)
      {
        break;
        e(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
        break label124;
        label176:
        if (localMessageRecord.uniseq != 0L) {
          ((List)localObject1).add(String.valueOf(localMessageRecord.uniseq));
        } else {
          i -= 1;
        }
      }
    }
    if (((List)localObject2).size() > 100)
    {
      paramList = ((List)localObject2).iterator();
      while (paramList.hasNext())
      {
        localObject2 = (String)paramList.next();
        a(str, j, getTableName(str, j), "_id=?", new String[] { localObject2 }, null);
      }
    }
    int k;
    if (((List)localObject2).size() != 0)
    {
      k = ((List)localObject2).size();
      paramList = new String[k];
      Arrays.fill(paramList, "?");
      paramList = Arrays.toString(paramList);
      paramList = "_id IN (" + paramList.substring(1, paramList.length() - 1) + ")";
      a(str, j, getTableName(str, j), paramList, (String[])((List)localObject2).toArray(new String[k]), null);
    }
    if (((List)localObject1).size() > 100)
    {
      paramList = ((List)localObject1).iterator();
      while (paramList.hasNext())
      {
        localObject1 = (String)paramList.next();
        a(str, j, getTableName(str, j), "uniseq=?", new String[] { localObject1 }, null);
      }
    }
    if (((List)localObject1).size() != 0)
    {
      k = ((List)localObject1).size();
      paramList = new String[k];
      Arrays.fill(paramList, "?");
      paramList = Arrays.toString(paramList);
      paramList = "uniseq IN (" + paramList.substring(1, paramList.length() - 1) + ")";
      a(str, j, getTableName(str, j), paramList, (String[])((List)localObject1).toArray(new String[k]), null);
    }
    bX(str, j);
    return i;
  }
  
  protected akvm a()
  {
    if ((this.jdField_a_of_type_Akvm == null) || (!this.jdField_a_of_type_Akvm.isOpen())) {}
    synchronized (this.bE)
    {
      if ((this.jdField_a_of_type_Akvm == null) || (!this.jdField_a_of_type_Akvm.isOpen())) {
        this.jdField_a_of_type_Akvm = ((akvm)this.app.a().createMessageRecordEntityManager());
      }
      return this.jdField_a_of_type_Akvm;
    }
  }
  
  @Deprecated
  public Cursor a(String paramString, int paramInt)
  {
    int j = 0;
    List localList = h(paramString, paramInt);
    if (paramString.equals(String.valueOf(acbn.bkD)))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < localList.size())
      {
        localArrayList.add(localList.get(localList.size() - i - 1));
        i += 1;
      }
      new ArrayList();
      paramString = g(paramString, paramInt, 2147483647);
      if (paramString != null)
      {
        paramInt = j;
        while (paramInt < paramString.size())
        {
          localArrayList.add(paramString.get(paramString.size() - paramInt - 1));
          paramInt += 1;
        }
      }
      return new tok(this, localArrayList);
    }
    return new tok(this, (List)((ArrayList)localList).clone());
  }
  
  public QQMessageFacade.Message a(String paramString, EntityManager paramEntityManager)
  {
    return a(paramString, paramEntityManager, 0);
  }
  
  protected QQMessageFacade.Message a(String paramString, EntityManager paramEntityManager, int paramInt)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    for (;;)
    {
      synchronized (this.app.a().transSaveLock)
      {
        if (u(paramString, false)) {
          this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase(paramEntityManager);
        }
        if (paramString.startsWith("mr_discusssion")) {
          break label505;
        }
        if (!paramString.startsWith("mr_troop")) {
          break label520;
        }
        break label505;
        boolean bool2 = paramString.endsWith("_New");
        localObject1 = new StringBuilder(1024);
        ((StringBuilder)localObject1).append("select * from (select count() as unReadNum from %s mr where mr.isread=0),(select count() as hasReply from %s mr where mr.issend=0),%s m where m.isValid=1 and m.msgtype ");
        ((StringBuilder)localObject1).append(top.ow());
        ((StringBuilder)localObject1).append(" order by %s limit 1");
        Object localObject5 = ((StringBuilder)localObject1).toString();
        if (!bool2) {
          break label534;
        }
        if (!bool1) {
          break label526;
        }
        localObject1 = "shmsgseq desc , _id desc";
        localObject1 = String.format((String)localObject5, new Object[] { paramString, paramString, paramString, localObject1 });
        localObject5 = a().rawQuery(QQMessageFacade.Message.class, (String)localObject1, null);
        localObject1 = localObject2;
        if (localObject5 != null)
        {
          localObject1 = localObject2;
          if (!((List)localObject5).isEmpty())
          {
            i = ((List)localObject5).size() - 1;
            localObject2 = localObject3;
            if (i >= 0)
            {
              if ((paramInt != 0) && (((QQMessageFacade.Message)((List)localObject5).get(i)).getConfessTopicId() != paramInt)) {
                break label542;
              }
              localObject2 = (QQMessageFacade.Message)((List)localObject5).get(i);
            }
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (((QQMessageFacade.Message)localObject2).isLongMsg())
              {
                localObject1 = localObject2;
                if (((QQMessageFacade.Message)localObject2).longMsgIndex > 0) {
                  localObject1 = a(paramString, paramEntityManager, ((QQMessageFacade.Message)localObject2).longMsgId, ((QQMessageFacade.Message)localObject2).issend);
                }
              }
            }
          }
        }
        paramString = Y(paramString);
        if ((paramString != null) && (paramString.size() > 0))
        {
          i = paramString.size() - 1;
          if (i >= 0)
          {
            if ((paramInt <= 0) || (((MessageRecord)paramString.get(i)).getConfessTopicId() == paramInt)) {
              break label511;
            }
            paramString.remove(i);
            break label511;
          }
        }
        if ((paramString == null) || (paramString.size() <= 0)) {
          break label499;
        }
        if (localObject1 == null)
        {
          paramInt = 0;
          paramString = paramString.iterator();
          paramEntityManager = (EntityManager)localObject1;
          if (paramString.hasNext())
          {
            localObject2 = (MessageRecord)paramString.next();
            if (!((MessageRecord)localObject2).isread) {
              break label551;
            }
            i = 0;
            paramEntityManager = a(paramEntityManager, (MessageRecord)localObject2, bool1);
            paramInt = i + paramInt;
            continue;
          }
        }
        else
        {
          paramInt = ((QQMessageFacade.Message)localObject1).unReadNum;
          continue;
        }
        if (localObject1 == null)
        {
          paramString = new QQMessageFacade.Message();
          MessageRecord.copyMessageRecordBaseField(paramString, paramEntityManager);
          paramString.unReadNum = paramInt;
          return paramString;
        }
      }
      paramString = (String)localObject1;
      continue;
      label499:
      paramString = (String)localObject1;
      continue;
      label505:
      boolean bool1 = true;
      continue;
      label511:
      i -= 1;
      continue;
      label520:
      bool1 = false;
      continue;
      label526:
      Object localObject1 = "time desc , _id desc";
      continue;
      label534:
      localObject1 = "_id desc";
      continue;
      label542:
      i -= 1;
      continue;
      label551:
      int i = 1;
    }
  }
  
  public FullMessageSearchResult.SearchResultItem a(String paramString1, int paramInt1, String paramString2, int paramInt2, acpu paramacpu)
  {
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = null;
    }
    for (;;)
    {
      return paramString1;
      if (c(paramString1, paramInt1, true)) {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase();
      }
      long l1 = NetConnInfoCenter.getServerTime();
      long l2 = acpz.Rg;
      Object localObject = getTableName(paramString1, paramInt1);
      localObject = a().query(false, (String)localObject, null, "msgtype in (?,?,?) AND time>=?", new String[] { String.valueOf(-1000), String.valueOf(-1035), String.valueOf(-2011), String.valueOf(l1 - l2) }, null, null, "time desc, longMsgIndex desc", String.valueOf(paramInt2));
      try
      {
        paramString2 = a(paramString1, paramInt1, paramString2, paramacpu, (Cursor)localObject);
        paramString1 = paramString2;
        return paramString2;
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MsgProxy", 2, paramString1, new Object[0]);
        }
        return null;
      }
      finally
      {
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
    }
  }
  
  protected FullMessageSearchResult.SearchResultItem a(String paramString1, int paramInt, String paramString2, acpu paramacpu, Cursor paramCursor)
  {
    return acpw.a(this.app, this.jdField_a_of_type_Akvm, paramCursor, paramString1, paramInt, paramString2, paramacpu);
  }
  
  protected ChatHistorySearchData a(Cursor paramCursor, SessionInfo paramSessionInfo, String paramString)
  {
    if ((paramCursor == null) || (paramCursor.getCount() == 0) || (paramSessionInfo == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    String str1 = paramSessionInfo.aTl;
    int j = paramSessionInfo.cZ;
    String str2 = paramString.toLowerCase(Locale.US);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramString = new HashSet();
    a(paramSessionInfo, str1, j, paramString);
    HashSet localHashSet = new HashSet();
    paramString = paramString.iterator();
    Object localObject;
    while (paramString.hasNext())
    {
      str1 = (String)paramString.next();
      if (str1 != null)
      {
        localObject = aqgv.a(this.app, paramSessionInfo, str1.equals(this.app.getCurrentAccountUin()), str1);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).toLowerCase(Locale.US).contains(str2))) {
          localHashSet.add(str1);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "getSearchResult, keyuins = " + localHashSet.toString());
    }
    if (paramCursor.isBeforeFirst()) {
      paramCursor.moveToFirst();
    }
    if (!paramCursor.isAfterLast())
    {
      paramString = a(paramCursor, paramSessionInfo, j);
      if ((TextUtils.isEmpty(paramString)) || (!localHashSet.contains(paramString))) {
        break label468;
      }
    }
    label465:
    label468:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
        str1 = "";
        paramString = str1;
        if (localObject != null) {
          paramString = str1;
        }
      }
      for (;;)
      {
        try
        {
          if (localObject.length > 0) {
            paramString = new String((byte[])localObject, "utf-8");
          }
          if (!paramString.toLowerCase(Locale.US).contains(str2)) {
            break label465;
          }
          i = 1;
          if (i != 0)
          {
            if (localArrayList1.size() >= 50) {
              continue;
            }
            paramString = (MessageRecord)a().cursor2Entity(MessageRecord.class, null, paramCursor);
            if (paramString != null) {
              localArrayList1.add(paramString);
            }
          }
          paramCursor.moveToNext();
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          paramString = "";
          continue;
          localArrayList2.add(Integer.valueOf(paramCursor.getInt(0)));
          continue;
        }
        if (localArrayList1.size() > 0)
        {
          paramCursor = new ChatHistorySearchData();
          paramCursor.mSearchData1 = localArrayList1;
          paramCursor.mSearchData2 = localArrayList2;
          return paramCursor;
        }
        return null;
      }
    }
  }
  
  /* Error */
  public ChatHistorySearchData a(SessionInfo paramSessionInfo, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload 4
    //   5: astore_3
    //   6: aload_1
    //   7: ifnull +26 -> 33
    //   10: aload 4
    //   12: astore_3
    //   13: aload_1
    //   14: getfield 1087	com/tencent/mobileqq/activity/aio/SessionInfo:aTl	Ljava/lang/String;
    //   17: invokestatic 1056	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifne +13 -> 33
    //   23: aload_2
    //   24: invokestatic 1056	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   27: ifeq +8 -> 35
    //   30: aload 4
    //   32: astore_3
    //   33: aload_3
    //   34: areturn
    //   35: aload_0
    //   36: aload_1
    //   37: getfield 1087	com/tencent/mobileqq/activity/aio/SessionInfo:aTl	Ljava/lang/String;
    //   40: aload_1
    //   41: getfield 1090	com/tencent/mobileqq/activity/aio/SessionInfo:cZ	I
    //   44: invokevirtual 550	ton:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   47: astore_3
    //   48: aload_0
    //   49: invokevirtual 289	ton:a	()Lakvm;
    //   52: iconst_0
    //   53: aload_3
    //   54: aconst_null
    //   55: ldc_w 1183
    //   58: iconst_1
    //   59: anewarray 230	java/lang/String
    //   62: dup
    //   63: iconst_0
    //   64: sipush -1000
    //   67: invokestatic 233	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   70: aastore
    //   71: aconst_null
    //   72: aconst_null
    //   73: ldc_w 1070
    //   76: aconst_null
    //   77: invokevirtual 946	akvm:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   80: astore 5
    //   82: aload_0
    //   83: aload 5
    //   85: aload_1
    //   86: aload_2
    //   87: invokevirtual 1185	ton:a	(Landroid/database/Cursor;Lcom/tencent/mobileqq/activity/aio/SessionInfo;Ljava/lang/String;)Lcom/tencent/mobileqq/data/ChatHistorySearchData;
    //   90: astore_1
    //   91: aload_1
    //   92: astore_3
    //   93: aload 5
    //   95: ifnull -62 -> 33
    //   98: aload 5
    //   100: invokeinterface 954 1 0
    //   105: aload_1
    //   106: areturn
    //   107: astore_1
    //   108: aload 4
    //   110: astore_3
    //   111: aload 5
    //   113: ifnull -80 -> 33
    //   116: aload 5
    //   118: invokeinterface 954 1 0
    //   123: aconst_null
    //   124: areturn
    //   125: astore_1
    //   126: aload 5
    //   128: ifnull +10 -> 138
    //   131: aload 5
    //   133: invokeinterface 954 1 0
    //   138: aload_1
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	ton
    //   0	140	1	paramSessionInfo	SessionInfo
    //   0	140	2	paramString	String
    //   5	106	3	localObject1	Object
    //   1	108	4	localObject2	Object
    //   80	52	5	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   82	91	107	java/lang/Exception
    //   82	91	125	finally
  }
  
  protected MessageRecord a(MessageRecord paramMessageRecord, int paramInt, boolean paramBoolean)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    MessageRecord localMessageRecord = a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
    paramMessageRecord.msgtype = paramInt;
    ContentValues localContentValues;
    if (localMessageRecord != null)
    {
      localMessageRecord.msgtype = paramInt;
      localContentValues = new ContentValues();
      localContentValues.put("msgtype", Integer.valueOf(paramInt));
      if (localMessageRecord == null) {
        break label180;
      }
      if (localMessageRecord.getId() <= 0L) {
        break label137;
      }
      a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
    }
    for (;;)
    {
      return localMessageRecord;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.msg.MsgProxy", 2, "update : updateMessageType : set fail !");
      break;
      label137:
      a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(localMessageRecord.uniseq) }, null);
      continue;
      label180:
      if (paramMessageRecord.getId() > 0L) {
        a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(paramMessageRecord.getId()) }, null);
      }
    }
  }
  
  protected MessageRecord a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    MessageRecord localMessageRecord = a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
    paramMessageRecord.isValid = paramBoolean;
    ContentValues localContentValues;
    if (localMessageRecord != null)
    {
      localMessageRecord.isValid = paramBoolean;
      localContentValues = new ContentValues();
      localContentValues.put("isValid", Boolean.valueOf(paramBoolean));
      if (localMessageRecord == null) {
        break label180;
      }
      if (localMessageRecord.getId() <= 0L) {
        break label141;
      }
      a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
      label107:
      if ((localMessageRecord instanceof ChatMessage)) {
        ((ChatMessage)localMessageRecord).reParse();
      }
    }
    for (;;)
    {
      return localMessageRecord;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.msg.MsgProxy", 2, "update : setMessageIsValidFlag : set fail !");
      break;
      label141:
      a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(localMessageRecord.uniseq) }, null);
      break label107;
      label180:
      if (paramMessageRecord.getId() > 0L) {
        a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(paramMessageRecord.getId()) }, null);
      }
    }
  }
  
  public MessageRecord a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, 0);
  }
  
  protected MessageRecord a(String paramString, int paramInt1, int paramInt2)
  {
    Lock localLock = a(paramString, paramInt1);
    localLock.lock();
    try
    {
      paramString = b(paramString, paramInt1, paramInt2);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public MessageRecord a(String paramString, int paramInt, long paramLong)
  {
    MessageRecord localMessageRecord2 = null;
    if ((paramLong == 0L) || (paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    Object localObject = h(paramString, paramInt);
    MessageRecord localMessageRecord1 = localMessageRecord2;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      do
      {
        localMessageRecord1 = localMessageRecord2;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localMessageRecord1 = (MessageRecord)((Iterator)localObject).next();
      } while (localMessageRecord1.uniseq != paramLong);
    }
    if (localMessageRecord1 == null)
    {
      paramString = l(paramString, paramInt);
      if (paramString != null)
      {
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          localMessageRecord2 = (MessageRecord)paramString.next();
          if (localMessageRecord2.uniseq == paramLong) {
            return localMessageRecord2;
          }
        }
      }
    }
    return localMessageRecord1;
  }
  
  public MessageRecord a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    Lock localLock = a(paramString, paramInt1);
    localLock.lock();
    try
    {
      paramString = b(paramString, paramInt1, paramLong, paramInt2);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public MessageRecord a(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    MessageRecord localMessageRecord = a(paramString, paramInt1, paramLong);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("extraflag", Integer.valueOf(paramInt2));
    localContentValues.put("sendFailCode", Integer.valueOf(paramInt3));
    if (localMessageRecord != null)
    {
      localMessageRecord.extraflag = paramInt2;
      localMessageRecord.sendFailCode = paramInt3;
      if (localMessageRecord.getId() > 0L) {
        a(paramString, paramInt1, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
      }
      for (;;)
      {
        if ((localMessageRecord instanceof ChatMessage)) {
          ((ChatMessage)localMessageRecord).reParse();
        }
        return localMessageRecord;
        a(paramString, paramInt1, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(localMessageRecord.uniseq) }, null);
      }
    }
    a(paramString, paramInt1, 3, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
    return localMessageRecord;
  }
  
  protected MessageRecord a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    MessageRecord localMessageRecord = a(paramString, paramInt, paramLong1);
    if (localMessageRecord != null)
    {
      localMessageRecord.time = paramLong2;
      localMessageRecord.shmsgseq = paramLong3;
      i(paramString, paramInt, paramLong1);
      b(paramString, paramInt, localMessageRecord);
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("time", Long.valueOf(paramLong2));
    localContentValues.put("shmsgseq", Long.valueOf(paramLong3));
    if (localMessageRecord != null)
    {
      if (localMessageRecord.getId() > 0L)
      {
        a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
        return localMessageRecord;
      }
      a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
      return localMessageRecord;
    }
    a(paramString, paramInt, 3, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
    return localMessageRecord;
  }
  
  public MessageRecord a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    Object localObject = a(paramString1, paramInt, paramLong1);
    if ((localObject == null) && (paramString2 != null)) {}
    for (;;)
    {
      try
      {
        long l = Long.valueOf(paramString2).longValue();
        paramLong1 = l;
        if (QLog.isColorLevel())
        {
          paramLong1 = l;
          QLog.i("Q.msg.MsgProxy", 2, "can't find message by uniseq, try filename");
        }
        paramLong1 = l;
        paramString2 = a(paramString1, paramInt, l);
        paramLong1 = l;
      }
      catch (NumberFormatException paramString2)
      {
        paramString2 = (String)localObject;
        continue;
        a(paramString1, paramInt, paramString2.versionCode, (ContentValues)localObject, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
        return paramString2;
      }
      if (paramString2 != null)
      {
        paramString2.time = paramLong2;
        if ((paramString2.extraflag == 32772) || (paramString2.extraflag == 32768))
        {
          paramString2.extraflag = 0;
          paramString2.sendFailCode = 0;
        }
        i(paramString1, paramInt, paramLong1);
        b(paramString1, paramInt, paramString2);
        if (paramString2.msgtype == -2005) {
          this.app.a().d(paramString2.uniseq, paramString2.frienduin, paramString2.istroop, paramLong2);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "update msgTime set msg =" + paramString2.getBaseInfoString());
        }
      }
      localObject = new ContentValues();
      ((ContentValues)localObject).put("time", Long.valueOf(paramLong2));
      if ((paramString2 != null) && (paramString2.extraflag == 0))
      {
        ((ContentValues)localObject).put("extraflag", Integer.valueOf(0));
        ((ContentValues)localObject).put("sendFailCode", Integer.valueOf(0));
      }
      if (paramString2 != null) {
        if (paramString2.getId() > 0L)
        {
          a(paramString1, paramInt, paramString2.versionCode, (ContentValues)localObject, "_id=?", new String[] { String.valueOf(paramString2.getId()) }, null);
          return paramString2;
        }
      }
      a(paramString1, paramInt, 3, (ContentValues)localObject, "uniseq=?", new String[] { String.valueOf(paramLong1) }, null);
      return paramString2;
      paramString2 = (String)localObject;
    }
  }
  
  public MessageRecord a(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    if (paramString2 == null) {
      return null;
    }
    MessageRecord localMessageRecord = a(paramString1, paramInt, paramLong);
    ContentValues localContentValues = new ContentValues();
    if ((localMessageRecord == null) || (localMessageRecord.versionCode > 0)) {}
    try
    {
      localContentValues.put("msgData", paramString2.getBytes("UTF-8"));
      label54:
      localMessageRecord.msg = paramString2;
      localMessageRecord.msgData = paramString2.getBytes();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "updateMsgContentByUniseq: set msg =" + localMessageRecord.getBaseInfoString());
      }
      if (localMessageRecord.getId() > 0L)
      {
        a(paramString1, paramInt, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
        label149:
        if ((localMessageRecord instanceof ChatMessage)) {
          ((ChatMessage)localMessageRecord).reParse();
        }
      }
      for (;;)
      {
        return localMessageRecord;
        localContentValues.put("msg", paramString2);
        break;
        a(paramString1, paramInt, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
        break label149;
        try
        {
          localContentValues.put("msgData", paramString2.getBytes("UTF-8"));
          a(paramString1, paramInt, 3, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
        }
        catch (UnsupportedEncodingException paramString2)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, "updateMsgContentByUniseq fail!" + paramString2);
            }
          }
        }
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label54;
    }
  }
  
  public MessageRecord a(String paramString1, int paramInt, long paramLong, String paramString2, Object paramObject)
  {
    MessageRecord localMessageRecord = a(paramString1, paramInt, paramLong);
    try
    {
      localObject = MessageRecord.class.getDeclaredField(paramString2);
      localClass = ((Field)localObject).getType();
      ((Field)localObject).setAccessible(true);
      if (localMessageRecord != null) {
        ((Field)localObject).set(localMessageRecord, paramObject);
      }
      if (Modifier.isStatic(((Field)localObject).getModifiers())) {
        break label476;
      }
      if (((Field)localObject).isAnnotationPresent(notColumn.class)) {
        return localMessageRecord;
      }
      localObject = new ContentValues();
      if (localClass != Long.TYPE) {
        break label189;
      }
      ((ContentValues)localObject).put(paramString2, (Long)paramObject);
    }
    catch (Exception paramString1)
    {
      Object localObject;
      for (;;)
      {
        Class localClass;
        paramString1.printStackTrace();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.msg.MsgProxy", 2, "updateMsgFieldByUniseq error! ", paramString1);
        return localMessageRecord;
        label189:
        if (localClass == Integer.TYPE)
        {
          ((ContentValues)localObject).put(paramString2, (Integer)paramObject);
        }
        else if (localClass == String.class)
        {
          ((ContentValues)localObject).put(paramString2, (String)paramObject);
        }
        else if (localClass == Byte.TYPE)
        {
          ((ContentValues)localObject).put(paramString2, (Byte)paramObject);
        }
        else if (localClass == [B.class)
        {
          ((ContentValues)localObject).put(paramString2, (byte[])paramObject);
        }
        else if (localClass == Short.TYPE)
        {
          ((ContentValues)localObject).put(paramString2, (Short)paramObject);
        }
        else if (localClass == Boolean.TYPE)
        {
          ((ContentValues)localObject).put(paramString2, (Boolean)paramObject);
        }
        else if (localClass == Float.TYPE)
        {
          ((ContentValues)localObject).put(paramString2, (Float)paramObject);
        }
        else if (localClass == Double.TYPE)
        {
          ((ContentValues)localObject).put(paramString2, (Double)paramObject);
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("Q.msg.MsgProxy", 2, "updateMsgFieldByUniseq fieldType error! " + localClass.getClass().getSimpleName());
          continue;
          a(paramString1, paramInt, localMessageRecord.versionCode, (ContentValues)localObject, "uniseq=?", new String[] { String.valueOf(localMessageRecord.uniseq) }, null);
        }
      }
      a(paramString1, paramInt, 3, (ContentValues)localObject, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
    }
    if (localMessageRecord != null) {
      if (localMessageRecord.getId() > 0L)
      {
        a(paramString1, paramInt, localMessageRecord.versionCode, (ContentValues)localObject, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
        if (!(localMessageRecord instanceof ChatMessage)) {
          break label476;
        }
        ((ChatMessage)localMessageRecord).reParse();
        return localMessageRecord;
      }
    }
    label476:
    return localMessageRecord;
  }
  
  protected MessageRecord a(String paramString1, int paramInt, long paramLong, String paramString2, String paramString3)
  {
    if (c(paramString1, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase(a());
    }
    paramString2 = String.format("select * from " + getTableName(paramString1, paramInt) + " where time=%d and senderuin=%s", new Object[] { Long.valueOf(paramLong), paramString2 });
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMsgByConstraints: sql=" + paramString2 + ", peeruin = " + paramString1 + ", type = " + paramInt);
    }
    paramString1 = a().a(paramString2, null, this.app);
    if (paramString1 != null)
    {
      paramString1 = paramString1.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (MessageRecord)paramString1.next();
        if (paramString2.msg.equals(paramString3)) {
          return paramString2;
        }
      }
    }
    return null;
  }
  
  public MessageRecord a(String paramString1, int paramInt1, long paramLong1, String paramString2, String paramString3, long paramLong2, int paramInt2)
  {
    MessageRecord localMessageRecord = a(paramString1, paramInt1, paramLong1);
    if (localMessageRecord != null)
    {
      paramString3 = a(localMessageRecord.msg, paramString2, paramString3, paramLong2, paramInt2);
      localMessageRecord.msg = paramString3;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "updateMsgContentToForward: set msg =" + localMessageRecord.getBaseInfoString());
      }
      paramString2 = new ContentValues();
      if ((localMessageRecord.versionCode <= 0) || (paramString3 == null)) {
        break label213;
      }
    }
    for (;;)
    {
      try
      {
        paramString2.put("msgData", paramString3.getBytes("UTF-8"));
        if (localMessageRecord.getId() <= 0L) {
          break label226;
        }
        a(paramString1, paramInt1, localMessageRecord.versionCode, paramString2, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
        if ((localMessageRecord instanceof ChatMessage)) {
          ((ChatMessage)localMessageRecord).reParse();
        }
        return localMessageRecord;
      }
      catch (UnsupportedEncodingException paramString3)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.msg.MsgProxy", 2, "updateMsgContentToForward fail!" + paramString3);
        continue;
      }
      label213:
      paramString2.put("msg", paramString3);
      continue;
      label226:
      a(paramString1, paramInt1, localMessageRecord.versionCode, paramString2, "uniseq=?", new String[] { String.valueOf(localMessageRecord.uniseq) }, null);
    }
  }
  
  public MessageRecord a(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    MessageRecord localMessageRecord = a(paramString, paramInt, paramLong);
    ContentValues localContentValues = new ContentValues();
    if (paramArrayOfByte != null) {
      localContentValues.put("msgData", paramArrayOfByte);
    }
    if (localMessageRecord != null)
    {
      localMessageRecord.msgData = paramArrayOfByte;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "updateMsgContent: set msg = " + localMessageRecord.getBaseInfoString());
      }
      if (localMessageRecord.getId() > 0L) {
        a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
      }
      for (;;)
      {
        if ((localMessageRecord instanceof ChatMessage)) {
          ((ChatMessage)localMessageRecord).reParse();
        }
        return localMessageRecord;
        a(paramString, paramInt, localMessageRecord.versionCode, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
      }
    }
    a(paramString, paramInt, 3, localContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
    return localMessageRecord;
  }
  
  public MessageRecord a(String paramString1, int paramInt, String paramString2)
  {
    if ((paramString2 == null) || (paramString1 == null) || (paramString1.length() == 0)) {
      return null;
    }
    paramString1 = i(paramString1, paramInt);
    if (paramString1 != null)
    {
      paramString1 = paramString1.iterator();
      while (paramString1.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramString1.next();
        if (((localMessageRecord instanceof MessageForTroopFile)) && (paramString2.equals(((MessageForTroopFile)localMessageRecord).url))) {
          return localMessageRecord;
        }
      }
    }
    return null;
  }
  
  protected String a(Cursor paramCursor, SessionInfo paramSessionInfo, int paramInt)
  {
    paramCursor.getString(paramCursor.getColumnIndex("senderuin"));
    if (aqiu.ms(paramCursor.getInt(paramCursor.getColumnIndex("issend")))) {
      return this.app.getCurrentAccountUin();
    }
    return paramSessionInfo.aTl;
  }
  
  @NonNull
  protected String a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt)
  {
    return aoon.a(paramString1, paramString2, paramString3, paramLong, paramInt);
  }
  
  @Nullable
  protected List<MessageRecord> a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramString = k(paramString, paramInt1); paramString != null; paramString = c(paramString, paramInt1, paramInt2)) {
      return (List)((ArrayList)paramString).clone();
    }
    return null;
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "getAllMessages uin " + paramString + " , type = " + paramInt1 + " , customTypes = " + Arrays.toString(paramArrayOfInt));
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = l(paramString, paramInt1);
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "getAllMessages from AIO CACHE FAIL！ ");
      }
      localObject1 = h(paramString, paramInt1);
    }
    for (;;)
    {
      long l1 = 9223372036854775807L;
      long l4 = 9223372036854775807L;
      HashSet localHashSet = new HashSet();
      int i;
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
      {
        i = 0;
        while (i < paramArrayOfInt.length)
        {
          localHashSet.add(Integer.valueOf(paramArrayOfInt[i]));
          i += 1;
        }
      }
      long l3;
      long l2;
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        if ((((List)localObject1).size() >= paramInt2) && (localHashSet.isEmpty()))
        {
          localArrayList.addAll(((List)localObject1).subList(((List)localObject1).size() - paramInt2, ((List)localObject1).size()));
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "getAllMessages size = " + localArrayList.size());
          }
          return localArrayList;
        }
        l3 = l1;
        Object localObject2;
        if (top.fs(paramInt1))
        {
          localObject2 = ((List)localObject1).iterator();
          for (;;)
          {
            l3 = l1;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
            if (localMessageRecord.shmsgseq < l1) {
              l1 = localMessageRecord.shmsgseq;
            }
          }
        }
        localObject1 = ((List)localObject1).iterator();
        i = 3;
        l2 = 9223372036854775807L;
        l1 = l4;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
          if ((!top.fs(paramInt1)) || (((MessageRecord)localObject2).versionCode != 3) || (((MessageRecord)localObject2).shmsgseq != l3) || (l3 == 0L)) {
            for (;;)
            {
              int j;
              long l5;
              if (!localHashSet.contains(Integer.valueOf(((MessageRecord)localObject2).msgtype)))
              {
                j = i;
                l5 = l1;
                l4 = l2;
                if (!localHashSet.isEmpty()) {}
              }
              else
              {
                j = i;
                if (((MessageRecord)localObject2).versionCode < i) {
                  j = ((MessageRecord)localObject2).versionCode;
                }
                l4 = l2;
                if (((MessageRecord)localObject2).getId() > 0L)
                {
                  l4 = l2;
                  if (((MessageRecord)localObject2).getId() < l2) {
                    l4 = ((MessageRecord)localObject2).getId();
                  }
                }
                l2 = l1;
                if (((MessageRecord)localObject2).time < l1) {
                  l2 = ((MessageRecord)localObject2).time;
                }
                localArrayList.add(localObject2);
                l5 = l2;
              }
              i = j;
              l1 = l5;
              l2 = l4;
            }
          }
        }
        if (localArrayList.size() >= paramInt2) {
          return localArrayList.subList(localArrayList.size() - paramInt2, localArrayList.size());
        }
        l4 = l3;
        l3 = l1;
        l1 = l4;
      }
      for (;;)
      {
        if (top.fs(paramInt1)) {
          localArrayList.addAll(0, a(paramString, paramInt1, l2, i, l1, paramInt2 - localArrayList.size(), paramArrayOfInt));
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "getAllMessages size = " + localArrayList.size());
          }
          return localArrayList;
          localArrayList.addAll(0, a(paramString, paramInt1, l2, i, l3, paramInt2 - localArrayList.size(), paramArrayOfInt));
        }
        l3 = 9223372036854775807L;
        i = 3;
        l1 = 9223372036854775807L;
        l2 = 9223372036854775807L;
      }
    }
  }
  
  protected List<MessageRecord> a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy_" + MsgLruCache.TAG, 2, "getAIOMsgList, jump to peerUin: " + paramString + " type: " + paramInt1 + " , from = " + paramLong);
    }
    Lock localLock = a(paramString, paramInt1);
    localLock.lock();
    try
    {
      paramString = b(paramString, paramInt1, paramLong, paramInt2);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  protected List<MessageRecord> a(String paramString1, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryTimedMessageDBUnion, peerUin = " + paramString1 + ", type " + paramInt1 + ",_id = " + paramLong1 + ",versionCode = " + paramInt2 + ", from " + paramLong2 + ",count = " + paramInt3 + ",whrere = " + paramString2);
    }
    paramString2 = aqir.a(getOldTableName(paramString1, paramInt1), getTableName(paramString1, paramInt1), paramLong1, paramInt2, paramLong2, paramInt3, this.app.getReadableDatabase(), paramString2);
    if (paramString2 != null)
    {
      if (c(paramString1, paramInt1, true)) {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase(a());
      }
      paramString1 = a().a(paramString2.toString(), null, this.app);
      if (QLog.isColorLevel()) {
        QLog.i("QQMessageFacade", 2, paramString2.toString());
      }
      if (paramString1 != null)
      {
        Collections.reverse(paramString1);
        if (QLog.isColorLevel())
        {
          paramString2 = paramString1.iterator();
          while (paramString2.hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)paramString2.next();
            QLog.i("QQMessageFacade", 2, "queryTimedMessageDBUnion " + localMessageRecord.time + ", " + localMessageRecord.getId() + ", " + localMessageRecord.getLogColorContent());
          }
        }
        return paramString1;
      }
    }
    return new ArrayList();
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryC2CMessageFromDB_UnionTables, peerUin = " + paramString + ", type " + paramInt1 + ",_id = " + paramLong1 + ",versionCode = " + paramInt2 + ", from " + paramLong2 + ",count = " + paramInt3 + ",customTypes = " + Arrays.toString(paramArrayOfInt));
    }
    Object localObject2 = null;
    if (c(paramString, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase(paramString, paramInt1);
    }
    Object localObject1 = localObject2;
    if (paramArrayOfInt != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfInt.length > 0)
      {
        localObject1 = new StringBuilder(" and msgtype in ( ");
        int i = 0;
        while (i < paramArrayOfInt.length)
        {
          ((StringBuilder)localObject1).append(paramArrayOfInt[i]);
          if (i < paramArrayOfInt.length - 1) {
            ((StringBuilder)localObject1).append(" , ");
          }
          i += 1;
        }
        ((StringBuilder)localObject1).append(") ");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    paramArrayOfInt = a(paramString, paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, (String)localObject1);
    paramString = paramArrayOfInt;
    if (paramArrayOfInt == null) {
      paramString = new ArrayList();
    }
    return paramString;
  }
  
  public List<MessageRecord> a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageByTimeOrSeq() called with: peerUin = [" + paramString1 + "], type = [" + paramInt1 + "], seq = [" + paramLong + "], count = [" + paramInt2 + "], whereClause = [" + paramString2 + "]");
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageByTimeOrSeq:uin=" + paramString1 + ",type=" + paramInt1 + ",seq=" + paramLong + ",count=" + paramInt2);
    }
    if (c(paramString1, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase();
    }
    boolean bool = top.fs(paramInt1);
    if (v(paramString1, paramInt1))
    {
      if (bool) {}
      for (paramString1 = c(paramString1, paramInt1, paramLong, paramInt2, paramString2); paramString1 != null; paramString1 = b(paramString1, paramInt1, paramLong, paramInt2, paramString2)) {
        return paramString1;
      }
    }
    return new ArrayList();
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromTimeRange, peerUin = " + paramString + ", type " + paramInt1 + ",beginTime = " + paramLong1 + ",endTime = " + paramLong2 + ",topicId=" + paramInt2);
    }
    Object localObject1 = h(paramString, paramInt1);
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((((MessageRecord)localObject2).time >= paramLong1) && (((MessageRecord)localObject2).time <= paramLong2) && ((paramInt2 <= 0) || (((MessageRecord)localObject2).getConfessTopicId() == paramInt2))) {
          localArrayList.add(localObject2);
        }
      }
    }
    if ((localArrayList.size() > 0) && (((MessageRecord)localArrayList.get(0)).time == paramLong1)) {
      return localArrayList;
    }
    if (c(paramString, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase(a());
    }
    if ((paramInt2 > 0) && ((paramInt1 == 1033) || (paramInt1 == 1034))) {}
    for (int i = aegu.ag(paramInt1, paramInt2) << 3;; i = 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("select * from ");
      ((StringBuilder)localObject1).append(getTableName(paramString, paramInt1));
      ((StringBuilder)localObject1).append(" where time>=? and time<=?");
      if (i != 0) {
        ((StringBuilder)localObject1).append(" and (extLong & 4194296)=?");
      }
      ((StringBuilder)localObject1).append(" order by time asc");
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromTimeRange " + ((StringBuilder)localObject1).toString());
      }
      if (localArrayList.size() > 0) {
        paramLong2 = ((MessageRecord)localArrayList.get(0)).time;
      }
      paramLong1 = Math.min(paramLong1, paramLong2);
      Object localObject3;
      if (localArrayList != null)
      {
        localObject2 = localArrayList.iterator();
        do
        {
          for (;;)
          {
            if (!((Iterator)localObject2).hasNext()) {
              break label467;
            }
            localObject3 = (MessageRecord)((Iterator)localObject2).next();
            if (((MessageRecord)localObject3).time != paramLong2) {
              break;
            }
            ((Iterator)localObject2).remove();
          }
        } while (((MessageRecord)localObject3).time <= paramLong2);
      }
      label467:
      if (i == 0)
      {
        localObject2 = a();
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject3 = this.app;
        localObject1 = ((akvm)localObject2).a((String)localObject1, new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, (QQAppInterface)localObject3);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder().append("queryMessageFromTimeRange, peerUin = ").append(paramString).append(", type ").append(paramInt1).append(",queryBeginTime = ").append(paramLong1).append(",queryEndTime = ").append(paramLong2).append(",resultSize=");
          if (localObject1 != null) {
            break label693;
          }
        }
      }
      label693:
      for (paramInt1 = 0;; paramInt1 = ((List)localObject1).size())
      {
        QLog.d("Q.msg.MsgProxy", 2, paramInt1 + ",topicId=" + paramInt2);
        if (localObject1 != null) {
          localArrayList.addAll(0, (Collection)localObject1);
        }
        return localArrayList;
        localObject2 = a();
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject3 = this.app;
        localObject1 = ((akvm)localObject2).a((String)localObject1, new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2), String.valueOf(i) }, (QQAppInterface)localObject3);
        break;
      }
    }
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, long paramLong, @NonNull Map<String, MessageRecord> paramMap)
  {
    Object localObject1 = paramMap;
    if (paramMap == null) {
      localObject1 = new HashMap();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "querySameSeqMessageWithFilter,  peerUin = " + paramString + ", type " + paramInt + ", seq = " + paramLong + ", filterMsgSet.size = " + ((Map)localObject1).size() + ",filterMsgSet = " + ((Map)localObject1).keySet());
    }
    if (c(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase(a());
    }
    paramString = "select * from " + getTableName(paramString, paramInt) + " where shmsgseq=?";
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "querySameSeqMessageWithFilter " + paramString);
    }
    paramMap = a();
    Object localObject2 = this.app;
    paramMap = paramMap.a(paramString, new String[] { String.valueOf(paramLong) }, (QQAppInterface)localObject2);
    if (paramMap == null) {
      return new ArrayList();
    }
    paramString = new ArrayList();
    paramMap = paramMap.iterator();
    while (paramMap.hasNext())
    {
      localObject2 = (MessageRecord)paramMap.next();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "filter msg , seq = " + ((MessageRecord)localObject2).shmsgseq + " ,id = " + ((MessageRecord)localObject2).getId() + ",uniseq=" + ((MessageRecord)localObject2).uniseq);
      }
      if ((!((Map)localObject1).containsKey("id&" + ((MessageRecord)localObject2).getId() + "&" + ((MessageRecord)localObject2).shmsgseq)) && (!((Map)localObject1).containsKey("uniseq&" + ((MessageRecord)localObject2).uniseq + "&" + ((MessageRecord)localObject2).shmsgseq))) {
        paramString.add(localObject2);
      }
    }
    return paramString;
  }
  
  protected List<MessageRecord> a(String paramString, int paramInt, anpc.e parame)
  {
    Lock localLock = a(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = b(paramString, paramInt, parame);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy_" + MsgLruCache.TAG, 2, "getAIOMsgList peerUin: " + paramString + " type: " + paramInt + " , autoInit = " + paramBoolean1);
    }
    Lock localLock = a(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = a(paramString, paramInt, paramBoolean1);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = l(paramString, paramInt);
    paramString = new HashSet();
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        paramString.add(Integer.valueOf(paramArrayOfInt[i]));
        i += 1;
      }
    }
    long l;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      if (paramString.isEmpty())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "getAllMessages size = " + localArrayList.size());
        }
        return localArrayList;
      }
      paramArrayOfInt = ((List)localObject).iterator();
      l = 9223372036854775807L;
      if (paramArrayOfInt.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramArrayOfInt.next();
        if (localMessageRecord.shmsgseq >= l) {
          break label282;
        }
        l = localMessageRecord.shmsgseq;
      }
    }
    label282:
    for (;;)
    {
      break;
      paramArrayOfInt = ((List)localObject).iterator();
      while (paramArrayOfInt.hasNext())
      {
        localObject = (MessageRecord)paramArrayOfInt.next();
        if (((!top.fs(paramInt)) || (((MessageRecord)localObject).versionCode != 3) || (((MessageRecord)localObject).shmsgseq != l) || (l == 0L)) && ((paramString.contains(Integer.valueOf(((MessageRecord)localObject).msgtype))) || (paramString.isEmpty()))) {
          localArrayList.add(localObject);
        }
      }
      return localArrayList;
    }
  }
  
  protected Lock a(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_Tom.a(paramString, paramInt);
  }
  
  public tom a()
  {
    return this.jdField_a_of_type_Tom;
  }
  
  protected void a(SessionInfo paramSessionInfo, String paramString, int paramInt, Set<String> paramSet)
  {
    paramSet.add(this.app.getCurrentAccountUin());
    paramSet.add(paramSessionInfo.aTl);
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    if (paramInt2 > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.addMsgQueue(paramString1, paramInt1, getTableName(paramString1, paramInt1), paramContentValues, paramString2, paramArrayOfString, 1, paramProxyListener);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.addMsgQueue(paramString1, paramInt1, getOldTableName(paramString1, paramInt1), paramContentValues, paramString2, paramArrayOfString, 1, paramProxyListener);
  }
  
  public void a(String paramString, int paramInt, long paramLong, ContentValues paramContentValues)
  {
    MessageRecord localMessageRecord = a(paramString, paramInt, paramLong);
    if (localMessageRecord != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "updateMsgContent: set msg = " + localMessageRecord.getBaseInfoString());
      }
      if (localMessageRecord.getId() > 0L)
      {
        a(paramString, paramInt, localMessageRecord.versionCode, paramContentValues, "_id=?", new String[] { String.valueOf(localMessageRecord.getId()) }, null);
        return;
      }
      a(paramString, paramInt, localMessageRecord.versionCode, paramContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
      return;
    }
    a(paramString, paramInt, 3, paramContentValues, "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
  }
  
  public void a(String paramString, int paramInt, long paramLong, List<MessageRecord> paramList)
  {
    Lock localLock = a(paramString, paramInt);
    localLock.lock();
    try
    {
      b(paramString, paramInt, paramLong, paramList);
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  protected void a(String paramString, int paramInt, MessageRecord paramMessageRecord, ProxyListener paramProxyListener)
  {
    if (paramMessageRecord.versionCode > 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.addMsgQueueDonotNotify(paramString, paramInt, getTableName(paramString, paramInt), paramMessageRecord, 0, paramProxyListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase();
  }
  
  protected void a(String paramString, int paramInt, MessageRecord paramMessageRecord, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((top.fG(paramMessageRecord.msgtype)) && (!top.x(paramMessageRecord.frienduin, paramMessageRecord.istroop))) {}
    while (!paramBoolean2) {
      return;
    }
    if (paramBoolean1)
    {
      a(paramString, paramInt, paramMessageRecord, paramProxyListener);
      return;
    }
    a(paramString, paramInt, paramMessageRecord, paramProxyListener);
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(paramString, paramInt, paramMessageRecord, paramBoolean3);
    a(paramString, paramInt, paramMessageRecord, paramProxyListener, paramBoolean1, paramBoolean2);
  }
  
  protected void a(String paramString, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "insertToList " + paramMessageRecord.getBaseInfoString());
    }
    for (;;)
    {
      localLock = a(paramString, paramInt);
      localLock.lock();
      try
      {
        b(paramString, paramInt, paramMessageRecord, paramBoolean);
        return;
      }
      finally
      {
        localLock.unlock();
      }
      QLog.d("Q.msg.MsgProxy", 1, "insertToList " + paramMessageRecord.getUserLogString());
    }
  }
  
  protected void a(String paramString, int paramInt, Entity paramEntity, ProxyListener paramProxyListener)
  {
    if (((paramEntity instanceof MessageRecord)) && (((MessageRecord)paramEntity).versionCode > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.addMsgQueue(paramString, paramInt, getTableName(paramString, paramInt), paramEntity, 0, paramProxyListener);
    }
  }
  
  protected void a(String paramString1, int paramInt, String paramString2, ContentValues paramContentValues, String paramString3, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.addMsgQueue(paramString1, paramInt, paramString2, paramContentValues, paramString3, paramArrayOfString, 1, paramProxyListener);
  }
  
  protected void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    Lock localLock = a(paramString1, paramInt1);
    localLock.lock();
    try
    {
      b(paramString1, paramInt1, paramString2, paramString3, paramInt2);
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  protected void a(String paramString1, int paramInt, String paramString2, String paramString3, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.addMsgQueue(paramString1, paramInt, paramString2, paramString3, paramArrayOfString, 2, paramProxyListener);
  }
  
  protected void a(String paramString1, String paramString2, List<MessageRecord> paramList, long paramLong)
  {
    boolean bool = false;
    if (aqmq.aFf())
    {
      anaz.b localb2 = (anaz.b)anaz.ne.get(paramString2);
      anaz.b localb1 = localb2;
      if (localb2 == null) {
        localb1 = new anaz.b();
      }
      localb1.friendUin = paramString1;
      localb1.isInited = false;
      if (!paramList.isEmpty()) {
        bool = true;
      }
      localb1.cEO = bool;
      localb1.aku = ((System.nanoTime() - paramLong) / 1000000L);
      anaz.ne.put(paramString2, localb1);
    }
  }
  
  protected boolean a(int paramInt, long paramLong, MessageRecord paramMessageRecord)
  {
    if (top.fs(paramInt)) {
      if (paramLong < paramMessageRecord.shmsgseq) {}
    }
    while (paramLong >= paramMessageRecord.time)
    {
      return true;
      return false;
    }
    return false;
  }
  
  protected boolean a(String paramString1, int paramInt, String paramString2, List<MessageRecord> paramList)
  {
    ambj localambj = (ambj)this.app.getManager(326);
    if ((!T().containsKey(paramString2)) && (localambj.oD(paramString1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "insertToAioMsgPool because of orderMediaMsgSending " + paramString1);
      }
      paramString2 = new ArrayList();
      if (paramList.size() > 15) {
        paramString2.addAll(paramList.subList(paramList.size() - 15, paramList.size()));
      }
      for (;;)
      {
        b(paramString1, paramInt, paramString2);
        return true;
        paramString2.addAll(paramList);
      }
    }
    return false;
  }
  
  @Nullable
  protected List<MessageRecord> aA(List<MessageRecord> paramList)
  {
    if (paramList != null) {
      return (List)((ArrayList)paramList).clone();
    }
    return null;
  }
  
  protected List<MessageRecord> aB(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new ArrayList(paramList);
    HashSet localHashSet = new HashSet();
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      if (localHashSet.contains(top.e((MessageRecord)paramList.get(i)))) {
        localArrayList.add(paramList.get(i));
      }
      for (;;)
      {
        i -= 1;
        break;
        localHashSet.add(top.e((MessageRecord)paramList.get(i)));
      }
    }
    paramList.removeAll(localArrayList);
    Collections.reverse(paramList);
    return paramList;
  }
  
  public void aY(int paramInt, String paramString)
  {
    try
    {
      paramString = top.u(paramString, paramInt);
      T().remove(paramString);
      bEt();
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, "delAIOMsg ");
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  protected int b(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramMessageRecord.extraflag == 32772) {}
    for (paramMessageRecord = a(paramMessageRecord, false); paramMessageRecord == null; paramMessageRecord = a(paramMessageRecord, -2006, paramBoolean)) {
      return -1;
    }
    if (paramMessageRecord.isread) {
      return 1;
    }
    return 2;
  }
  
  protected MsgLruCache b()
  {
    return this.jdField_a_of_type_Tom.b();
  }
  
  public MessageRecord b(String paramString, int paramInt)
  {
    String str1 = getTableName(paramString, paramInt);
    if (u(str1, false)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase(this.jdField_a_of_type_Akvm);
    }
    String str2 = top.ox();
    if (top.fs(paramInt)) {}
    for (paramString = "shmsgseq asc , _id desc";; paramString = "time asc , _id desc")
    {
      paramString = String.format("select * from %s m where m.isValid=1 and m.msgtype %s order by %s limit 1", new Object[] { str1, str2, paramString });
      paramString = a().rawQuery(MessageRecord.class, paramString, null);
      if ((paramString == null) || (paramString.isEmpty())) {
        break;
      }
      return (MessageRecord)paramString.get(0);
    }
    return null;
  }
  
  public MessageRecord b(String paramString, int paramInt, long paramLong)
  {
    Object localObject2;
    if ((paramLong == 0L) || (paramString == null) || (paramString.length() == 0))
    {
      localObject2 = null;
      return localObject2;
    }
    Object localObject1 = i(paramString, paramInt);
    if (localObject1 != null)
    {
      localObject2 = ((List)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (MessageRecord)((Iterator)localObject2).next();
      } while (((MessageRecord)localObject1).uniseq != paramLong);
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      paramString = b(paramString, paramInt, paramLong);
      localObject2 = localObject1;
      if (paramString == null) {
        break;
      }
      localObject2 = localObject1;
      if (paramString.isEmpty()) {
        break;
      }
      return (MessageRecord)paramString.get(0);
      localObject1 = null;
    }
  }
  
  public MessageRecord b(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryLastMsgForMessageTabFromDB, peerUin = " + paramString1 + ", type " + paramInt);
    }
    if (c(paramString1, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase(a());
    }
    if (top.fs(paramInt))
    {
      localStringBuilder = new StringBuilder().append("select * from ").append(getTableName(paramString1, paramInt)).append(" where isValid=1 and msgtype ").append(top.ow()).append(" ");
      if (paramString2 != null) {}
      for (paramString1 = "and " + paramString2;; paramString1 = "")
      {
        paramString1 = paramString1 + " order by shmsgseq desc , _id desc limit 1";
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "queryLastTABSupportMessageFromDB : sqlStr:" + paramString1);
        }
        paramString1 = a().a(paramString1, null, this.app);
        if ((paramString1 != null) && (paramString1.size() >= 1)) {
          break;
        }
        return null;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder().append("select * from ").append(getTableName(paramString1, paramInt)).append(" where isValid=1 and msgtype ").append(top.ow()).append(" ");
    if (paramString2 != null) {}
    for (paramString1 = "and " + paramString2;; paramString1 = "")
    {
      paramString1 = paramString1 + " order by time desc , _id desc limit 1";
      break;
    }
    return (MessageRecord)paramString1.get(0);
  }
  
  public List<MessageRecord> b(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1033) || (paramInt1 == 1034)) {}
    for (boolean bool = true;; bool = false)
    {
      Lock localLock = a(paramString, paramInt1);
      localLock.lock();
      try
      {
        paramString = a(paramString, paramInt1, paramInt2, bool);
        return paramString;
      }
      finally
      {
        localLock.unlock();
      }
    }
  }
  
  protected List<MessageRecord> b(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy_" + MsgLruCache.TAG, 2, "getAIOMsgList_confess peerUin: " + paramString + " type: " + paramInt1 + " , autoInit = " + paramBoolean + ", topicId=" + paramInt2);
    }
    Lock localLock = a(paramString, paramInt1);
    localLock.lock();
    try
    {
      paramString = c(paramString, paramInt1, paramInt2, paramBoolean);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  protected List<MessageRecord> b(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByMsgUniseqFromDB, peerUin[" + ahav.kZ(paramString) + "] type[" + paramInt + "] uniseq[" + paramLong + "]");
    }
    if (paramLong == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByMsgUniseqFromDB Warning! uniseq==0");
      }
      paramString = new ArrayList();
    }
    Object localObject;
    do
    {
      return paramString;
      if (c(paramString, paramInt, true)) {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase(a());
      }
      paramString = "select * from " + getTableName(paramString, paramInt) + " where uniseq=?";
      localObject = a();
      QQAppInterface localQQAppInterface = this.app;
      localObject = ((akvm)localObject).a(paramString, new String[] { String.valueOf(paramLong) }, localQQAppInterface);
      paramString = (String)localObject;
    } while (localObject != null);
    return new ArrayList();
  }
  
  protected List<MessageRecord> b(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    if (top.fs(paramInt1)) {}
    for (List localList = f(paramString, paramInt1, paramLong, 2147483647L);; localList = a(paramString, paramInt1, paramLong, 2147483647L, paramInt2))
    {
      Object localObject = localList;
      if (localList == null) {
        localObject = new ArrayList();
      }
      b(paramString, paramInt1, (List)localObject);
      return localObject;
    }
  }
  
  protected List<MessageRecord> b(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    if (c(paramString1, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase(a());
    }
    String str1;
    String str2;
    if (paramInt2 > 0)
    {
      str1 = "limit " + paramInt2;
      str2 = "select * from " + getTableName(paramString1, paramInt1) + " where time<%d %s order by time desc, _id desc %s";
      if (paramString2 != null) {
        break label273;
      }
    }
    label273:
    for (paramString2 = "";; paramString2 = "and " + paramString2)
    {
      paramString2 = String.format(str2, new Object[] { Long.valueOf(paramLong), paramString2, str1 });
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessageByTime: sql=" + paramString2 + ", peeruin = " + paramString1 + ", type = " + paramInt1);
      }
      paramString2 = a().a(paramString2, null, this.app);
      if (paramString2 != null) {
        Collections.reverse(paramString2);
      }
      if (paramString2 == null) {
        break label299;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessageByTime: list size =" + paramString2.size() + ", peeruin = " + paramString1 + ", type = " + paramInt1);
      }
      return paramString2;
      str1 = "";
      break;
    }
    label299:
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageByTime: null list , peeruin = " + paramString1 + ", type = " + paramInt1);
    }
    return new ArrayList();
  }
  
  public List<MessageRecord> b(String paramString, int paramInt, List<Long> paramList)
  {
    if ((paramList == null) || (paramString == null) || (paramString.length() == 0) || (paramList.size() == 0)) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      MessageRecord localMessageRecord;
      if (i < paramList.size())
      {
        localMessageRecord = a(paramString, paramInt, ((Long)paramList.get(i)).longValue());
        if (localMessageRecord != null) {}
      }
      else
      {
        if (i < paramList.size() - 1) {
          localArrayList.addAll(c(paramString, paramInt, paramList.subList(i, paramList.size())));
        }
        return localArrayList;
      }
      localArrayList.add(localMessageRecord);
      i += 1;
    }
  }
  
  protected void b(String paramString, int paramInt, long paramLong, List<MessageRecord> paramList)
  {
    String str = u(paramString, paramInt);
    if (b().containsKey(str))
    {
      List localList = W(str);
      int k = 0;
      int i = 0;
      int j;
      Object localObject;
      for (;;)
      {
        j = k;
        if (i < localList.size())
        {
          localObject = (MessageRecord)localList.get(i);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "find cache " + ((MessageRecord)localObject).getBaseInfoString());
          }
          if (((MessageRecord)localObject).uniseq == paramLong) {
            j = i;
          }
        }
        else
        {
          if ((j <= 0) || (j >= localList.size())) {
            break label303;
          }
          localObject = new ArrayList();
          i = 0;
          while (i < j)
          {
            MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, "removeList " + localMessageRecord.getBaseInfoString());
            }
            ((List)localObject).add(localMessageRecord);
            i += 1;
          }
        }
        i += 1;
      }
      localList.removeAll((Collection)localObject);
      ((List)localObject).clear();
      localList.addAll(0, paramList);
      while (localList.size() > 40)
      {
        i = localList.size() - 40;
        for (;;)
        {
          if (i > 0)
          {
            localList.remove(0);
            i -= 1;
            continue;
            label303:
            if (j != 0) {
              break;
            }
            localList.addAll(0, paramList);
            break;
          }
        }
        paramList = b();
        if (paramList.getCacheType(str) == acss.czW) {
          paramList.changeCacheType(str, acss.czV);
        }
      }
      c(paramString, paramInt, localList);
    }
  }
  
  public void b(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    Lock localLock = a(paramString, paramInt);
    localLock.lock();
    try
    {
      c(paramString, paramInt, paramMessageRecord);
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public void b(List<MessageRecord> paramList, ProxyListener paramProxyListener)
  {
    a(top.aC(paramList), paramProxyListener);
  }
  
  public void bEs()
  {
    try
    {
      T().clear();
      bEt();
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, "delAIOMsg ");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void bEu()
  {
    b().clear();
    T().clear();
  }
  
  /* Error */
  public void bEv()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 247	ton:jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager	Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   4: invokevirtual 556	com/tencent/mobileqq/app/proxy/ProxyManager:transSaveToDatabase	()V
    //   7: aload_0
    //   8: getfield 247	ton:jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager	Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   11: invokevirtual 1793	com/tencent/mobileqq/app/proxy/ProxyManager:clearMsgQueue	()V
    //   14: aload_0
    //   15: invokevirtual 289	ton:a	()Lakvm;
    //   18: invokevirtual 1797	akvm:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   21: astore 11
    //   23: aload_0
    //   24: getfield 372	ton:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   27: invokevirtual 1800	com/tencent/mobileqq/app/QQAppInterface:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   30: astore 12
    //   32: aload 12
    //   34: invokevirtual 1806	com/tencent/mobileqq/app/SQLiteDatabase:getAllTableNameFromCache	()[Ljava/lang/String;
    //   37: astore 13
    //   39: aload 13
    //   41: ifnonnull +4 -> 45
    //   44: return
    //   45: aload_0
    //   46: getfield 372	ton:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   49: sipush 201
    //   52: invokevirtual 672	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   55: checkcast 1808	akwh
    //   58: astore 14
    //   60: iconst_0
    //   61: istore_1
    //   62: iload_1
    //   63: aload 13
    //   65: arraylength
    //   66: if_icmpge -22 -> 44
    //   69: aload 13
    //   71: iload_1
    //   72: aaload
    //   73: astore 15
    //   75: aload 15
    //   77: ldc_w 1810
    //   80: invokevirtual 259	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   83: ifeq +449 -> 532
    //   86: new 56	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   93: ldc_w 1812
    //   96: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload 15
    //   101: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc_w 1814
    //   107: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload 15
    //   112: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: ldc_w 770
    //   118: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: astore 8
    //   126: aload 8
    //   128: ifnull +286 -> 414
    //   131: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +31 -> 165
    //   137: ldc_w 1150
    //   140: iconst_2
    //   141: new 56	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   148: ldc_w 1816
    //   151: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload 8
    //   156: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: aload 12
    //   167: aload 8
    //   169: aconst_null
    //   170: invokevirtual 1819	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   173: astore 9
    //   175: aload 9
    //   177: ifnull +170 -> 347
    //   180: aload 9
    //   182: astore 8
    //   184: aload 9
    //   186: invokeinterface 951 1 0
    //   191: ifle +156 -> 347
    //   194: aload 9
    //   196: astore 8
    //   198: aload 9
    //   200: invokeinterface 1130 1 0
    //   205: pop
    //   206: aload 9
    //   208: astore 8
    //   210: aload 9
    //   212: aload 9
    //   214: ldc_w 1821
    //   217: invokeinterface 1824 2 0
    //   222: invokeinterface 1828 2 0
    //   227: lstore 6
    //   229: aload 9
    //   231: astore 8
    //   233: aload 9
    //   235: aload 9
    //   237: ldc_w 1829
    //   240: invokeinterface 1824 2 0
    //   245: invokeinterface 1396 2 0
    //   250: astore 10
    //   252: aload 9
    //   254: astore 8
    //   256: aload 9
    //   258: aload 9
    //   260: ldc_w 1830
    //   263: invokeinterface 1824 2 0
    //   268: invokeinterface 1170 2 0
    //   273: istore_2
    //   274: aload 9
    //   276: astore 8
    //   278: aload 9
    //   280: aload 9
    //   282: ldc_w 1397
    //   285: invokeinterface 1824 2 0
    //   290: invokeinterface 1170 2 0
    //   295: istore_3
    //   296: lload 6
    //   298: lstore 4
    //   300: aload 9
    //   302: astore 8
    //   304: iload_2
    //   305: invokestatic 1425	top:fs	(I)Z
    //   308: ifne +20 -> 328
    //   311: lload 6
    //   313: lstore 4
    //   315: iload_3
    //   316: iconst_1
    //   317: if_icmpne +11 -> 328
    //   320: lload 6
    //   322: ldc2_w 1831
    //   325: ladd
    //   326: lstore 4
    //   328: aload 9
    //   330: astore 8
    //   332: aload_0
    //   333: getfield 372	ton:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   336: invokevirtual 377	com/tencent/mobileqq/app/QQAppInterface:a	()Lanaz;
    //   339: aload 10
    //   341: iload_2
    //   342: lload 4
    //   344: invokevirtual 1835	anaz:F	(Ljava/lang/String;IJ)V
    //   347: aload 9
    //   349: ifnull +10 -> 359
    //   352: aload 9
    //   354: invokeinterface 954 1 0
    //   359: aload 11
    //   361: ifnull +8 -> 369
    //   364: aload 11
    //   366: invokevirtual 1840	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   369: aload 12
    //   371: aload 15
    //   373: aconst_null
    //   374: aconst_null
    //   375: invokevirtual 1844	com/tencent/mobileqq/app/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   378: pop
    //   379: aload 11
    //   381: ifnull +8 -> 389
    //   384: aload 11
    //   386: invokevirtual 1847	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   389: aload 11
    //   391: ifnull +8 -> 399
    //   394: aload 11
    //   396: invokevirtual 1850	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   399: aload 14
    //   401: ifnull +13 -> 414
    //   404: aload 14
    //   406: aload 15
    //   408: aconst_null
    //   409: aconst_null
    //   410: invokevirtual 1852	akwh:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   413: pop
    //   414: iload_1
    //   415: iconst_1
    //   416: iadd
    //   417: istore_1
    //   418: goto -356 -> 62
    //   421: astore 10
    //   423: aconst_null
    //   424: astore 9
    //   426: aload 9
    //   428: astore 8
    //   430: aload 10
    //   432: invokevirtual 1167	java/lang/Exception:printStackTrace	()V
    //   435: aload 9
    //   437: ifnull -78 -> 359
    //   440: aload 9
    //   442: invokeinterface 954 1 0
    //   447: goto -88 -> 359
    //   450: astore 9
    //   452: aconst_null
    //   453: astore 8
    //   455: aload 8
    //   457: ifnull +10 -> 467
    //   460: aload 8
    //   462: invokeinterface 954 1 0
    //   467: aload 9
    //   469: athrow
    //   470: astore 8
    //   472: aload 8
    //   474: invokevirtual 1167	java/lang/Exception:printStackTrace	()V
    //   477: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   480: ifeq +14 -> 494
    //   483: ldc 108
    //   485: iconst_2
    //   486: ldc_w 1854
    //   489: aload 8
    //   491: invokestatic 1329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   494: aload 11
    //   496: ifnull -97 -> 399
    //   499: aload 11
    //   501: invokevirtual 1850	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   504: goto -105 -> 399
    //   507: astore 8
    //   509: aload 11
    //   511: ifnull +8 -> 519
    //   514: aload 11
    //   516: invokevirtual 1850	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   519: aload 8
    //   521: athrow
    //   522: astore 9
    //   524: goto -69 -> 455
    //   527: astore 10
    //   529: goto -103 -> 426
    //   532: aconst_null
    //   533: astore 8
    //   535: goto -409 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	538	0	this	ton
    //   61	357	1	i	int
    //   273	69	2	j	int
    //   295	23	3	k	int
    //   298	45	4	l1	long
    //   227	94	6	l2	long
    //   124	337	8	localObject1	Object
    //   470	20	8	localException1	Exception
    //   507	13	8	localObject2	Object
    //   533	1	8	localObject3	Object
    //   173	268	9	localCursor	Cursor
    //   450	18	9	localObject4	Object
    //   522	1	9	localObject5	Object
    //   250	90	10	str1	String
    //   421	10	10	localException2	Exception
    //   527	1	10	localException3	Exception
    //   21	494	11	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   30	340	12	localSQLiteDatabase	com.tencent.mobileqq.app.SQLiteDatabase
    //   37	33	13	arrayOfString	String[]
    //   58	347	14	localakwh	akwh
    //   73	334	15	str2	String
    // Exception table:
    //   from	to	target	type
    //   165	175	421	java/lang/Exception
    //   165	175	450	finally
    //   364	369	470	java/lang/Exception
    //   369	379	470	java/lang/Exception
    //   384	389	470	java/lang/Exception
    //   364	369	507	finally
    //   369	379	507	finally
    //   384	389	507	finally
    //   472	494	507	finally
    //   184	194	522	finally
    //   198	206	522	finally
    //   210	229	522	finally
    //   233	252	522	finally
    //   256	274	522	finally
    //   278	296	522	finally
    //   304	311	522	finally
    //   332	347	522	finally
    //   430	435	522	finally
    //   184	194	527	java/lang/Exception
    //   198	206	527	java/lang/Exception
    //   210	229	527	java/lang/Exception
    //   233	252	527	java/lang/Exception
    //   256	274	527	java/lang/Exception
    //   278	296	527	java/lang/Exception
    //   304	311	527	java/lang/Exception
    //   332	347	527	java/lang/Exception
  }
  
  protected void bEw()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.getQueue() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.getQueue().size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase(this.jdField_a_of_type_Akvm);
    }
  }
  
  protected void bX(String paramString, int paramInt)
  {
    List localList = k(paramString, paramInt);
    if ((localList != null) && (localList.size() == 0))
    {
      if (c(paramString, paramInt, true)) {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase(a());
      }
      b().remove(u(paramString, paramInt));
      c(paramString, paramInt, c(paramString, paramInt, new anpc.e()));
    }
  }
  
  protected int c(String paramString, int paramInt, boolean paramBoolean)
  {
    int i = L(paramString, paramInt);
    akwh localakwh;
    if (paramBoolean)
    {
      a(paramString, paramInt, getTableName(paramString, paramInt), null, null, null);
      a(paramString, paramInt, getOldTableName(paramString, paramInt), null, null, null);
      localakwh = (akwh)this.app.getManager(201);
      Looper localLooper = Looper.getMainLooper();
      if (Thread.currentThread() != localLooper.getThread()) {
        break label95;
      }
      ThreadManager.post(new MsgProxy.1(this, localakwh, paramString, paramInt), 10, null, false);
    }
    label95:
    while (localakwh == null) {
      return i;
    }
    localakwh.a(getTableName(paramString, paramInt), null, null);
    return i;
  }
  
  protected MessageRecord c(String paramString, int paramInt1, int paramInt2)
  {
    String str1 = getTableName(paramString, paramInt1);
    if (u(str1, false)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase(this.jdField_a_of_type_Akvm);
    }
    paramString = new StringBuilder(512);
    paramString.append("select * from %s m where m.isValid=1");
    paramString.append(" order by %s limit 1");
    String str2 = paramString.toString();
    if (top.fs(paramInt1))
    {
      paramString = "shmsgseq desc , _id desc";
      paramString = String.format(str2, new Object[] { str1, paramString });
      paramString = a().rawQuery(MessageRecord.class, paramString, null);
      if ((paramString != null) && (!paramString.isEmpty())) {
        paramInt1 = paramString.size() - 1;
      }
    }
    else
    {
      for (;;)
      {
        if (paramInt1 < 0) {
          break label172;
        }
        if (((MessageRecord)paramString.get(paramInt1)).getConfessTopicId() == paramInt2)
        {
          return (MessageRecord)paramString.get(paramInt1);
          paramString = "time desc , _id desc";
          break;
        }
        paramInt1 -= 1;
      }
    }
    label172:
    return null;
  }
  
  public MessageRecord c(String paramString, int paramInt, long paramLong)
  {
    if ((paramLong == 0L) || (paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    Object localObject = i(paramString, paramInt);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (localMessageRecord.shmsgseq == paramLong) {
          return localMessageRecord;
        }
      }
    }
    return k(paramString, paramInt, paramLong);
  }
  
  protected List<MessageRecord> c(String paramString, int paramInt1, int paramInt2)
  {
    Lock localLock = a(paramString, paramInt1);
    localLock.lock();
    try
    {
      paramString = d(paramString, paramInt1, paramInt2);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public List<MessageRecord> c(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    Lock localLock = a(paramString, paramInt1);
    localLock.lock();
    try
    {
      paramString = d(paramString, paramInt1, paramLong, paramInt2);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  protected List<MessageRecord> c(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    if (c(paramString1, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase(a());
    }
    Object localObject = "select * from " + getTableName(paramString1, paramInt1) + " where shmsgseq<=? and shmsgseq>? %s order by shmsgseq asc";
    long l;
    if (paramString2 == null)
    {
      paramString2 = "";
      paramString2 = String.format((String)localObject, new Object[] { paramString2 });
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessageBySeq: sql=" + paramString2 + ", peeruin = " + paramString1 + ", type = " + paramInt1);
      }
      if (paramInt2 > 0) {
        break label275;
      }
      l = 0L;
    }
    for (;;)
    {
      localObject = a();
      QQAppInterface localQQAppInterface = this.app;
      paramString2 = ((akvm)localObject).a(paramString2, new String[] { String.valueOf(paramLong), String.valueOf(l) }, localQQAppInterface);
      if (paramString2 == null) {
        break label299;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessageBySeq: list size =" + paramString2.size() + ", peeruin = " + paramString1 + ", type = " + paramInt1);
      }
      return paramString2;
      paramString2 = "and " + paramString2;
      break;
      label275:
      if (paramLong > paramInt2) {
        l = paramLong - paramInt2;
      } else {
        l = 0L;
      }
    }
    label299:
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageBySeq: null list , peeruin = " + paramString1 + ", type = " + paramInt1);
    }
    return new ArrayList();
  }
  
  public List<MessageRecord> c(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) || (paramLong2 == 0L) || (paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = i(paramString, paramInt);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((localMessageRecord.shmsgseq == paramLong1) && (localMessageRecord.msgUid == paramLong2)) {
          localArrayList.add(localMessageRecord);
        }
      }
    }
    if (localArrayList.isEmpty())
    {
      paramString = h(paramString, paramInt, paramLong1, paramLong2);
      if ((paramString != null) && (!paramString.isEmpty())) {
        localArrayList.addAll(paramString);
      }
    }
    return localArrayList;
  }
  
  protected List<MessageRecord> c(String paramString, int paramInt, anpc.e parame)
  {
    Lock localLock = a(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = d(paramString, paramInt, parame);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  protected List<MessageRecord> c(String paramString, int paramInt, List<Long> paramList)
  {
    int j = 0;
    Object localObject;
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("queryMessagesByMsgUniseqFromDB, peerUin[").append(ahav.kZ(paramString)).append("] type[").append(paramInt).append("] uniseqList[");
      if (paramList == null)
      {
        i = 0;
        QLog.d("Q.msg.MsgProxy", 2, i + "]");
      }
    }
    else
    {
      if ((paramList != null) && (paramList.size() != 0)) {
        break label125;
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByMsgUniseqFromDB Warning! uniseq==0");
      }
      paramString = new ArrayList();
    }
    label125:
    do
    {
      return paramString;
      i = paramList.size();
      break;
      if (c(paramString, paramInt, true)) {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase(a());
      }
      localObject = new String[paramList.size()];
      StringBuilder localStringBuilder = new StringBuilder("(");
      i = j;
      while (i < paramList.size())
      {
        localObject[i] = String.valueOf(((Long)paramList.get(i)).longValue());
        localStringBuilder.append("?");
        if (i < paramList.size() - 1) {
          localStringBuilder.append(",");
        }
        i += 1;
      }
      localStringBuilder.append(")");
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByMsgUniseqFromDB, uniseq list=" + localStringBuilder.toString());
      }
      paramString = "select * from " + getTableName(paramString, paramInt) + " where uniseq in " + localStringBuilder.toString();
      paramList = a().a(paramString, (String[])localObject, this.app);
      paramString = paramList;
    } while (paramList != null);
    return new ArrayList();
  }
  
  protected void c(String paramString, int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    M(paramString, paramInt1, paramInt2);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isread", Boolean.valueOf(true));
    String str;
    if (((paramInt1 == 1001) || (paramInt1 == 10002)) && (paramMessageRecord.msgtype != -1003) && (paramMessageRecord.msgtype != -1031) && (paramMessageRecord.msgtype != -1032) && (paramMessageRecord.msgtype != 201)) {
      if (paramMessageRecord.versionCode > 0)
      {
        str = getTableName(String.valueOf(acbn.bkE), 1001);
        a(paramString, paramInt1, str, localContentValues, "senderuin=? and isread=?", new String[] { paramString, "0" }, null);
      }
    }
    label315:
    do
    {
      for (;;)
      {
        a(paramString, paramInt1, paramMessageRecord.versionCode, localContentValues, "isread=?", new String[] { "0" }, null);
        return;
        str = getOldTableName(String.valueOf(acbn.bkE), 1001);
        break;
        if (paramInt1 == 1009)
        {
          a(paramString, paramInt1, getTableName(acbn.bkt, 1009), localContentValues, "senderuin=? and isread=?", new String[] { paramString, "0" }, null);
        }
        else if (paramInt1 == 1010)
        {
          a(paramString, paramInt1, getTableName(acbn.bkY, 1010), localContentValues, "senderuin=? and isread=?", new String[] { paramString, "0" }, null);
        }
        else
        {
          if ((paramInt1 != 0) || (!TextUtils.equals(paramString, acbn.bkJ))) {
            break label315;
          }
          a(paramString, paramInt1, getTableName(acbn.bkJ, 0), localContentValues, "senderuin=? and isread=?", new String[] { paramString, "0" }, null);
        }
      }
      if ((paramInt1 == 1032) && (TextUtils.equals(paramString, acbn.blK)))
      {
        a(paramString, paramInt1, getTableName(paramString, paramInt1), localContentValues, "isread=?", new String[] { "0" }, null);
        return;
      }
    } while ((paramInt1 != 1033) && (paramInt1 != 1034));
    paramInt2 = aegu.ag(paramInt1, paramInt2) << 3;
    a(paramString, paramInt1, getTableName(acbn.blK, 1032), localContentValues, "senderuin=? and isread=? and (extLong & 4194296)=? ", new String[] { paramString, "0", Integer.toString(paramInt2) }, null);
    a(paramString, paramInt1, paramMessageRecord.versionCode, localContentValues, "isread=? and (extLong & 4194296)=?", new String[] { "0", Integer.toString(paramInt2) }, null);
  }
  
  protected void c(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    try
    {
      b().put(paramString, paramInt, paramList);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean c(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramString == null) {
      return false;
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.getMsgQueueLock())
      {
        Vector localVector = this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.getQueue();
        i = 0;
        if (i < localVector.size())
        {
          MsgQueueItem localMsgQueueItem = (MsgQueueItem)localVector.get(i);
          if ((top.isSaveConversation(localMsgQueueItem.frindUin, paramString, localMsgQueueItem.type, paramInt)) && ((localMsgQueueItem.action == 1) || (localMsgQueueItem.action == 2) || ((paramBoolean) && (localMsgQueueItem.action == 0))))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MsgProxy", 2, new Object[] { "needTransSaveToDatabase uin=", paramString, ", type=", LargerInteger.valueOf(paramInt), ", hasInsertAction=", Boolean.valueOf(paramBoolean), ",result=true" });
            }
            return true;
          }
        }
        else
        {
          return false;
        }
      }
      i += 1;
    }
  }
  
  public MessageRecord d(String paramString, int paramInt, long paramLong)
  {
    if ((paramLong == 0L) || (paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    Object localObject = i(paramString, paramInt);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((localMessageRecord.shmsgseq == paramLong) && (!top.s(localMessageRecord))) {
          return localMessageRecord;
        }
      }
    }
    return l(paramString, paramInt, paramLong);
  }
  
  public List<MessageRecord> d(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) || (paramLong2 == 0L) || (paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = i(paramString, paramInt);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((localMessageRecord.time == paramLong1) && (localMessageRecord.msgUid == paramLong2)) {
          localArrayList.add(localMessageRecord);
        }
      }
    }
    if (localArrayList.isEmpty())
    {
      paramString = g(paramString, paramInt, paramLong1, paramLong2);
      if ((paramString != null) && (!paramString.isEmpty())) {
        localArrayList.addAll(paramString);
      }
    }
    return localArrayList;
  }
  
  public List<MessageRecord> d(String paramString, int paramInt, List<Integer> paramList)
  {
    Object localObject = paramList;
    if (paramList.size() > 50) {
      localObject = paramList.subList(0, 50);
    }
    paramString = getTableName(paramString, paramInt);
    paramList = new String[1];
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      paramList[0] = String.valueOf(((Integer)localIterator.next()).intValue());
      localObject = a().query(false, paramString, null, "_id = ?", paramList, null, null, null, null);
      if (localObject != null) {}
      try
      {
        localArrayList.add((MessageRecord)a().cursor2Entity(MessageRecord.class, null, (Cursor)localObject));
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MsgProxy", 2, localException, new Object[0]);
        }
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
      finally
      {
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
    }
    return localArrayList;
  }
  
  public void d(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (paramMessageRecord.uniseq != 0L)) {}
    do
    {
      return;
      if (paramMessageRecord.getId() > 0L)
      {
        paramMessageRecord.createMessageUniseq();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("uniseq", Long.valueOf(paramMessageRecord.uniseq));
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MsgProxy", 2, "updateUniseqByID: set msg =" + paramMessageRecord.getBaseInfoString());
        }
        a(paramString, paramInt, paramMessageRecord.versionCode, localContentValues, "_id=?", new String[] { String.valueOf(paramMessageRecord.getId()) }, null);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.msg.MsgProxy", 2, "updateUniseqByID ERROR: _id<0 !");
  }
  
  public void d(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    Lock localLock = a(paramString, paramInt);
    localLock.lock();
    try
    {
      e(paramString, paramInt, paramList);
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public void destory()
  {
    if ((this.jdField_a_of_type_Akvm != null) && (this.jdField_a_of_type_Akvm.isOpen())) {
      this.jdField_a_of_type_Akvm.close();
    }
  }
  
  public int e(String paramString, int paramInt, long paramLong)
  {
    String str = getTableName(paramString, paramInt);
    boolean bool = top.fs(paramInt);
    Object localObject2;
    if (bool)
    {
      ??? = "shmsgseq desc , _id desc";
      if (!bool) {
        break label192;
      }
      localObject2 = "shmsgseq";
      localObject2 = String.format("select * from (select count() as unReadNum from %s mr where mr.isread=0 and mr.issend='0' and mr.%s>'%d'),%s m where m.%s>'%d' order by %s limit 1", new Object[] { str, localObject2, Long.valueOf(paramLong), str, localObject2, Long.valueOf(paramLong), ??? });
    }
    for (;;)
    {
      synchronized (this.app.a().transSaveLock)
      {
        if (c(paramString, paramInt, false)) {
          this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase(a());
        }
        localObject2 = a().rawQuery(QQMessageFacade.Message.class, (String)localObject2, null);
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          i = ((QQMessageFacade.Message)((List)localObject2).get(0)).unReadNum;
          paramInt = f(paramString, paramInt, paramLong);
          return i + paramInt;
          ??? = "time desc , _id desc";
          break;
          label192:
          localObject2 = "time";
        }
      }
      int i = 0;
    }
  }
  
  public MessageRecord e(String paramString, int paramInt, long paramLong)
  {
    Lock localLock = a(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = f(paramString, paramInt, paramLong);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public List<MessageRecord> e(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryBeforeHistoryByShmsgseq uin=" + paramString + ", type=" + paramInt1 + ", seq=" + paramLong + ", count=" + paramInt2);
    }
    if (c(paramString, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase();
    }
    paramString = getTableName(paramString, paramInt1);
    Object localObject1 = "select * from " + paramString + " where (shmsgseq < ? and msgtype " + top.ox() + " and isValid=1) order by shmsgseq desc limit ";
    Object localObject2 = new String[1];
    localObject2[0] = String.valueOf(paramLong);
    paramString = a().a((String)localObject1 + paramInt2, (String[])localObject2, this.app);
    if (paramString == null) {
      paramString = new ArrayList();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryBeforeHistoryByShmsgseq list.size=" + paramString.size());
      }
      if (paramString.size() < paramInt2)
      {
        akwh localakwh = (akwh)this.app.getManager(201);
        if (localakwh != null)
        {
          localObject1 = localakwh.c().a((String)localObject1 + (paramInt2 - paramString.size()), (String[])localObject2, this.app);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder().append("queryBeforeHistoryByShmsgseq list2.size=");
            if (localObject1 != null) {
              break label456;
            }
          }
        }
      }
      label456:
      for (paramInt1 = 0;; paramInt1 = ((List)localObject1).size())
      {
        QLog.d("Q.msg.MsgProxy", 2, paramInt1);
        if (localObject1 != null) {
          paramString.addAll((Collection)localObject1);
        }
        Collections.reverse(paramString);
        if (!QLog.isColorLevel()) {
          break label498;
        }
        localObject1 = paramString.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
          QLog.d("Q.msg.MsgProxy", 2, "queryBeforeHistoryByShmsgseq " + ((MessageRecord)localObject2).time + ", " + ((MessageRecord)localObject2).getId() + ", " + ((MessageRecord)localObject2).getLogColorContent());
        }
      }
      QLog.d("Q.msg.MsgProxy", 2, "queryBeforeHistoryByShmsgseq return size=" + paramString.size());
      label498:
      return paramString;
    }
  }
  
  public List<MessageRecord> e(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromBySeq, peerUin = " + paramString + ", type " + paramInt + ",beginSeq = " + paramLong1 + ",endSeq = " + paramLong2);
    }
    if (c(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase(a());
    }
    paramString = "select * from " + getTableName(paramString, paramInt) + " where shmsgseq>=? and shmsgseq<=? order by shmsgseq asc";
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromBySeq " + paramString);
    }
    Object localObject = a();
    QQAppInterface localQQAppInterface = this.app;
    localObject = ((akvm)localObject).a(paramString, new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, localQQAppInterface);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = new ArrayList();
    }
    return paramString;
  }
  
  protected void e(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    Object localObject1;
    if (T().containsKey(u(paramString, paramInt)))
    {
      localObject1 = X(u(paramString, paramInt));
      if (localObject1 != null) {
        break label250;
      }
      localObject1 = new ArrayList();
    }
    label250:
    for (;;)
    {
      List localList = top.e((List)localObject1, paramList);
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (MessageRecord)localIterator.next();
        if ((localObject2 instanceof MessageForPoke))
        {
          localObject2 = (MessageForPoke)localObject2;
          if (!((MessageForPoke)localObject2).isPlayed) {
            ((MessageForPoke)localObject2).setPlayed(this.app);
          }
        }
      }
      if (zxj.d(this.app, paramInt, paramString)) {
        this.app.b().a(paramInt).a(this.app, localList, localList, true, false);
      }
      if ((paramInt == 0) && (((List)localObject1).size() > 0) && (ahwb.aB((MessageRecord)((List)localObject1).get(0)))) {
        paramInt = localList.size() - 1;
      }
      while (paramInt >= 0)
      {
        top.a((List)localObject1, (MessageRecord)localList.get(paramInt), true);
        paramInt -= 1;
        continue;
        ((List)localObject1).addAll(0, localList);
      }
      paramList.clear();
      paramList.addAll(localList);
      return;
    }
  }
  
  public int eB(int paramInt)
  {
    Lock localLock = a(acbn.bkV, paramInt);
    localLock.lock();
    try
    {
      paramInt = eC(paramInt);
      return paramInt;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  protected int f(String paramString, int paramInt, long paramLong)
  {
    int i = 0;
    if (paramString == null) {
      return 0;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.getMsgQueueLock())
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.getQueue().iterator();
        if (localIterator.hasNext())
        {
          MsgQueueItem localMsgQueueItem = (MsgQueueItem)localIterator.next();
          if ((localMsgQueueItem.item instanceof MessageRecord))
          {
            MessageRecord localMessageRecord = (MessageRecord)localMsgQueueItem.item;
            if ((top.isSaveConversation(localMessageRecord.frienduin, paramString, localMessageRecord.istroop, paramInt)) && (localMsgQueueItem.action == 0) && (localMessageRecord.time > paramLong) && (!localMessageRecord.isread) && (!localMessageRecord.isSend())) {
              i += 1;
            }
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, new Object[] { "getUnreadCountFromQueue uin=", paramString, ", type=", Integer.valueOf(paramInt), ", lastRead=", Integer.valueOf(i) });
          }
          return i;
        }
      }
    }
  }
  
  protected List<MessageRecord> f(String paramString, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList;
    synchronized (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.getMsgQueueLock())
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.getQueue();
      localArrayList = new ArrayList();
      localObject2 = ((Vector)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        MsgQueueItem localMsgQueueItem = (MsgQueueItem)((Iterator)localObject2).next();
        if ((localMsgQueueItem.item instanceof MessageRecord))
        {
          MessageRecord localMessageRecord = (MessageRecord)localMsgQueueItem.item;
          if ((top.isSaveConversation(localMessageRecord.frienduin, paramString, localMessageRecord.istroop, paramInt1)) && (localMsgQueueItem.action == 0) && ((paramInt2 <= 0) || (localMessageRecord.getConfessTopicId() == paramInt2))) {
            localArrayList.add(localMessageRecord);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, new Object[] { "getMsgListFromQueue uin=", paramString, ", type=", Integer.valueOf(paramInt1), ", size=", Integer.valueOf(localArrayList.size()) });
    }
    return localArrayList;
  }
  
  public List<MessageRecord> f(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryLaterHistoryByShmsgseq uin=" + paramString + ", type=" + paramInt1 + ", seq=" + paramLong + ", count=" + paramInt2);
    }
    if (c(paramString, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase();
    }
    Object localObject2 = getTableName(paramString, paramInt1);
    paramString = "select * from " + (String)localObject2 + " where (shmsgseq >= ? and msgtype " + top.ox() + " and isValid=1) order by shmsgseq asc limit " + (paramInt2 + 1);
    Object localObject1 = new String[1];
    localObject1[0] = String.valueOf(paramLong);
    paramString = a().a(paramString, (String[])localObject1, this.app);
    if (paramString == null)
    {
      localObject1 = new ArrayList();
      return localObject1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryLaterHistoryByShmsgseq list.size=" + paramString.size());
    }
    if ((paramString.size() > 0) && (((MessageRecord)paramString.get(0)).shmsgseq == paramLong)) {
      paramString.remove(0);
    }
    label513:
    label553:
    for (;;)
    {
      localObject1 = paramString;
      if (!QLog.isColorLevel()) {
        break;
      }
      localObject1 = paramString.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        QLog.d("Q.msg.MsgProxy", 2, "queryLaterHistoryByShmsgseq " + ((MessageRecord)localObject2).time + ", " + ((MessageRecord)localObject2).getId() + ", " + ((MessageRecord)localObject2).getLogColorContent());
      }
      akwh localakwh = (akwh)this.app.getManager(201);
      if (localakwh != null)
      {
        localObject2 = "select * from " + (String)localObject2 + " where (shmsgseq > ? and msgtype " + top.ox() + " and isValid=1) order by shmsgseq asc limit " + paramInt2;
        localObject1 = localakwh.c().a((String)localObject2, (String[])localObject1, this.app);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("queryLaterHistoryByShmsgseq list2.size=");
          if (localObject1 != null) {
            break label502;
          }
        }
        label502:
        for (paramInt1 = 0;; paramInt1 = ((List)localObject1).size())
        {
          QLog.d("Q.msg.MsgProxy", 2, paramInt1);
          if (localObject1 == null) {
            break label553;
          }
          if (((List)localObject1).size() != paramInt2) {
            break label513;
          }
          paramString = (String)localObject1;
          break;
        }
        paramString.addAll(0, (Collection)localObject1);
        if (paramString.size() > paramInt2) {
          paramString.subList(paramInt2, paramString.size()).clear();
        }
      }
    }
    QLog.d("Q.msg.MsgProxy", 2, "queryLaterHistoryByShmsgseq return size=" + paramString.size());
    return paramString;
  }
  
  public List<MessageRecord> f(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromSeqRange, peerUin = " + paramString + ", type " + paramInt + ",beginSeq = " + paramLong1 + ",endSeq = " + paramLong2);
    }
    Object localObject1 = h(paramString, paramInt);
    ArrayList localArrayList = new ArrayList();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((((MessageRecord)localObject2).shmsgseq >= paramLong1) && (((MessageRecord)localObject2).shmsgseq <= paramLong2)) {
          localArrayList.add(localObject2);
        }
      }
    }
    if ((localArrayList.size() > 0) && (((MessageRecord)localArrayList.get(0)).shmsgseq == paramLong1)) {
      return localArrayList;
    }
    if (c(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase(a());
    }
    localObject1 = "select * from " + getTableName(paramString, paramInt) + " where shmsgseq>=? and shmsgseq<=? order by shmsgseq asc";
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromBySeq " + (String)localObject1);
    }
    if (localArrayList.size() > 0) {
      paramLong2 = ((MessageRecord)localArrayList.get(0)).shmsgseq;
    }
    paramLong1 = Math.min(paramLong1, paramLong2);
    if (localArrayList != null)
    {
      localObject2 = localArrayList.iterator();
      do
      {
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label380;
          }
          localObject3 = (MessageRecord)((Iterator)localObject2).next();
          if (((MessageRecord)localObject3).shmsgseq != paramLong2) {
            break;
          }
          ((Iterator)localObject2).remove();
        }
      } while (((MessageRecord)localObject3).shmsgseq <= paramLong2);
    }
    label380:
    Object localObject2 = a();
    Object localObject3 = this.app;
    localObject1 = ((akvm)localObject2).a((String)localObject1, new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, (QQAppInterface)localObject3);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("queryMessageFromTimeRange, peerUin = ").append(paramString).append(", type ").append(paramInt).append(",queryBeginSeq = ").append(paramLong1).append(",queryEndSeq = ").append(paramLong2).append(",resultSize=");
      if (localObject1 != null) {
        break label523;
      }
    }
    label523:
    for (paramInt = 0;; paramInt = ((List)localObject1).size())
    {
      QLog.d("Q.msg.MsgProxy", 2, paramInt);
      if (localObject1 != null) {
        localArrayList.addAll(0, (Collection)localObject1);
      }
      return localArrayList;
    }
  }
  
  public int g(String paramString, int paramInt, long paramLong)
  {
    MessageRecord localMessageRecord = e(paramString, paramInt, paramLong);
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("--->removeSingleMsg : peerUin:").append(paramString).append(" type:").append(paramInt).append(" uniseq:").append(paramLong).append(" mr:").append(localMessageRecord).append(" dbid:");
      if (localMessageRecord != null)
      {
        localObject = Long.valueOf(localMessageRecord.getId());
        QLog.d("Q.msg.MsgProxy", 2, localObject);
      }
    }
    else
    {
      if (localMessageRecord == null) {
        break label215;
      }
      long l = localMessageRecord.getId();
      if (l == -1L) {
        break label183;
      }
      a(paramString, paramInt, getTableName(paramString, paramInt), "_id=?", new String[] { String.valueOf(l) }, null);
    }
    for (;;)
    {
      bX(localMessageRecord.frienduin, localMessageRecord.istroop);
      if (!localMessageRecord.isread) {
        break label213;
      }
      return 1;
      localObject = "mr is null.";
      break;
      label183:
      a(paramString, paramInt, getTableName(paramString, paramInt), "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
    }
    label213:
    return 2;
    label215:
    a(paramString, paramInt, getTableName(paramString, paramInt), "uniseq=?", new String[] { String.valueOf(paramLong) }, null);
    return 1;
  }
  
  protected MessageRecord g(String paramString, int paramInt, long paramLong)
  {
    Lock localLock = a(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = h(paramString, paramInt, paramLong);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public List<MessageRecord> g(String paramString, int paramInt)
  {
    return aB(h(paramString, paramInt));
  }
  
  protected List<MessageRecord> g(String paramString, int paramInt1, int paramInt2)
  {
    if (c(paramString, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase(a());
    }
    Object localObject = String.format("select _id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong from ( select _id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong from " + getOldTableName(paramString, paramInt1) + " order by _id desc limit " + paramInt2 + " ) order by _id asc", new Object[0]);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromOldDB: sqlStr=" + (String)localObject + ", peeruin = " + paramString + ", type = " + paramInt1);
    }
    localObject = a().a((String)localObject, null, this.app);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromOldDB: list size =" + ((List)localObject).size() + ", peeruin = " + paramString + ", type = " + paramInt1);
      }
      return localObject;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromOldDB: null list , peeruin = " + paramString + ", type = " + paramInt1);
    }
    return new ArrayList();
  }
  
  protected List<MessageRecord> g(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByTimeFromDB, peerUin[" + ahav.kZ(paramString) + "] type[" + paramInt + "] time[" + paramLong1 + "] uid[" + paramLong2 + "]");
    }
    if ((paramLong2 == 0L) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByTimeFromDB Warning! msgseq == 0 || msgUid == 0");
    }
    if (c(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase(a());
    }
    Object localObject = "select * from " + getTableName(paramString, paramInt) + " where time=? and msgUid=?";
    akvm localakvm = a();
    QQAppInterface localQQAppInterface = this.app;
    localObject = localakvm.a((String)localObject, new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, localQQAppInterface);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("queryMessagesByTimeFromDB, peerUin[").append(ahav.kZ(paramString)).append("] type[").append(paramInt).append("] time[").append(paramLong1).append("] uid[").append(paramLong2).append("], list.size():");
      if (localObject != null) {
        break label287;
      }
    }
    label287:
    for (paramInt = i;; paramInt = ((List)localObject).size())
    {
      QLog.d("Q.msg.MsgProxy", 2, paramInt);
      if (localObject == null) {
        break;
      }
      return localObject;
    }
    return new ArrayList();
  }
  
  @NonNull
  protected String getOldTableName(String paramString, int paramInt)
  {
    return MessageRecord.getOldTableName(paramString, paramInt);
  }
  
  @Deprecated
  protected QQAppInterface getQQAppInterface()
  {
    return this.app;
  }
  
  @NonNull
  public String getTableName(String paramString, int paramInt)
  {
    return MessageRecord.getTableName(paramString, paramInt);
  }
  
  public List<MessageRecord> h(String paramString, int paramInt)
  {
    Lock localLock = a(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = aA(k(paramString, paramInt));
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  protected List<MessageRecord> h(String paramString, int paramInt1, int paramInt2)
  {
    if (c(paramString, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase(a());
    }
    Object localObject = String.format("select * from " + getTableName(paramString, paramInt1) + " where isValid=1 and msgtype != ? order by shmsgseq desc , _id desc limit ?", new Object[0]);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryValidMessageBySeq: sql=" + (String)localObject + ", peeruin = " + paramString + ", type = " + paramInt1);
    }
    akvm localakvm = a();
    QQAppInterface localQQAppInterface = this.app;
    localObject = localakvm.a((String)localObject, new String[] { String.valueOf(-2006), String.valueOf(paramInt2) }, localQQAppInterface);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryValidMessageBySeq: list size =" + ((List)localObject).size() + ", peeruin = " + paramString + ", type = " + paramInt1);
      }
      return localObject;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryValidMessageBySeq: null list , peeruin = " + paramString + ", type = " + paramInt1);
    }
    return new ArrayList();
  }
  
  protected List<MessageRecord> h(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB, peerUin[" + ahav.kZ(paramString) + "] type[" + paramInt + "] shmsgseq[" + paramLong1 + "] msgUid[" + paramLong2 + "]");
    }
    if (((paramLong1 == 0L) || (paramLong2 == 0L)) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB Warning! shmsgseq == 0 || msgUid == 0");
    }
    if (c(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase(a());
    }
    paramString = "select * from " + getTableName(paramString, paramInt) + " where shmsgseq=? and msgUid=?";
    akvm localakvm = a();
    QQAppInterface localQQAppInterface = this.app;
    paramString = localakvm.a(paramString, new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, localQQAppInterface);
    if (paramString != null) {
      return paramString;
    }
    return new ArrayList();
  }
  
  public MessageRecord i(String paramString, int paramInt, long paramLong)
  {
    Lock localLock = a(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = j(paramString, paramInt, paramLong);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public List<MessageRecord> i(String paramString, int paramInt)
  {
    Lock localLock = a(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = j(paramString, paramInt);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  protected void init() {}
  
  @Nullable
  protected List<MessageRecord> j(String paramString, int paramInt)
  {
    paramString = W(u(paramString, paramInt));
    if (paramString != null) {
      return (List)((ArrayList)paramString).clone();
    }
    return null;
  }
  
  protected MessageRecord k(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB, peerUin[" + ahav.kZ(paramString) + "] type[" + paramInt + "] shmsgseq[" + paramLong + "]");
    }
    if ((paramLong == 0L) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB Warning! shmsgseq == 0 || msgUid == 0");
    }
    if (c(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase(a());
    }
    Object localObject = "select * from " + getTableName(paramString, paramInt) + " where shmsgseq=?";
    akvm localakvm = a();
    QQAppInterface localQQAppInterface = this.app;
    localObject = localakvm.a((String)localObject, new String[] { String.valueOf(paramLong) }, localQQAppInterface);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("queryMessagesByShmsgseqFromDB, peerUin[").append(ahav.kZ(paramString)).append("] type[").append(paramInt).append("] shmsgseq[").append(paramLong).append("], list.size():");
      if (localObject != null) {
        break label261;
      }
    }
    label261:
    for (paramInt = 0;; paramInt = ((List)localObject).size())
    {
      QLog.d("Q.msg.MsgProxy", 2, paramInt);
      if (localObject == null) {
        break;
      }
      return (MessageRecord)((List)localObject).get(0);
    }
    return null;
  }
  
  protected List<MessageRecord> k(String paramString, int paramInt)
  {
    String str = u(paramString, paramInt);
    Lock localLock = a(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = a(paramString, paramInt, str);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  protected MessageRecord l(String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB4Troop, peerUin[" + ahav.kZ(paramString) + "] type[" + paramInt + "] shmsgseq[" + paramLong + "]");
    }
    if ((paramLong == 0L) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB4Troop Warning! shmsgseq == 0");
    }
    if (c(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase(a());
    }
    paramString = "select * from " + getTableName(paramString, paramInt) + " where shmsgseq=? and msgtype " + top.oy();
    akvm localakvm = a();
    QQAppInterface localQQAppInterface = this.app;
    paramString = localakvm.a(paramString, new String[] { String.valueOf(paramLong) }, localQQAppInterface);
    if ((paramString != null) && (paramString.size() > 0)) {
      return (MessageRecord)paramString.get(0);
    }
    return null;
  }
  
  public List<MessageRecord> l(String paramString, int paramInt)
  {
    Lock localLock = a(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = aA(m(paramString, paramInt));
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public MessageRecord m(String paramString, int paramInt, long paramLong)
  {
    Object localObject1 = c(paramString, paramInt, paramLong);
    if (localObject1 != null) {
      return localObject1;
    }
    Object localObject2 = (akwh)this.app.getManager(201);
    if (localObject2 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MsgProxy", 2, "queryMsgItemHistoryByShmsgseq, looking for slow db");
      }
      localObject1 = "select * from " + getTableName(paramString, paramInt) + " where shmsgseq=?";
      localObject2 = ((akwh)localObject2).c();
      QQAppInterface localQQAppInterface = this.app;
      localObject1 = ((akvm)localObject2).a((String)localObject1, new String[] { String.valueOf(paramLong) }, localQQAppInterface);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("queryMsgItemHistoryByShmsgseq, slow db return peerUin[").append(ahav.kZ(paramString)).append("] type[").append(paramInt).append("] shmsgseq[").append(paramLong).append("], list.size():");
        if (localObject1 != null) {
          break label211;
        }
      }
      label211:
      for (paramInt = 0;; paramInt = ((List)localObject1).size())
      {
        QLog.d("Q.msg.MsgProxy", 2, paramInt);
        if (localObject1 == null) {
          break;
        }
        return (MessageRecord)((List)localObject1).get(0);
      }
    }
    return null;
  }
  
  protected List<MessageRecord> m(String paramString, int paramInt)
  {
    return a(paramString, paramInt, false, false);
  }
  
  protected List<MessageRecord> o(String paramString, int paramInt)
  {
    return f(paramString, paramInt, 0);
  }
  
  protected void p(String paramString, int paramInt, long paramLong)
  {
    q(paramString, paramInt, paramLong);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isread", Boolean.valueOf(true));
    if (top.fs(paramInt)) {}
    String str2;
    String str3;
    for (String str1 = "shmsgseq";; str1 = "time")
    {
      str2 = String.valueOf(paramLong);
      str3 = getTableName(paramString, paramInt);
      if ((!top.ft(paramInt)) || (top.oz() == null)) {
        break;
      }
      a(paramString, paramInt, str3, localContentValues, String.format("isread=? and %s<=? and " + top.oz(), new Object[] { str1 }), new String[] { "0", str2 }, null);
      return;
    }
    a(paramString, paramInt, str3, localContentValues, String.format("isread=? and %s<=?", new Object[] { str1 }), new String[] { "0", str2 }, null);
  }
  
  protected void q(String paramString, int paramInt, long paramLong)
  {
    Lock localLock = a(paramString, paramInt);
    localLock.lock();
    try
    {
      r(paramString, paramInt, paramLong);
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  protected String u(String paramString, int paramInt)
  {
    return top.u(paramString, paramInt);
  }
  
  protected boolean u(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return false;
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.getMsgQueueLock())
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.getQueue().iterator();
      while (localIterator.hasNext())
      {
        MsgQueueItem localMsgQueueItem = (MsgQueueItem)localIterator.next();
        if (TextUtils.isEmpty(localMsgQueueItem.tableName)) {
          return true;
        }
        if ((paramString.equals(localMsgQueueItem.tableName)) && ((localMsgQueueItem.action == 1) || (localMsgQueueItem.action == 2) || ((paramBoolean) && (localMsgQueueItem.action == 0))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, new Object[] { "needTransSaveToDatabase tableName=", paramString, ", hasInsertAction=", Boolean.valueOf(paramBoolean), ",result=true" });
          }
          return true;
        }
      }
      return false;
    }
  }
  
  protected boolean v(String paramString, int paramInt)
  {
    return aqir.a(getTableName(paramString, paramInt), this.app.getReadableDatabase());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ton
 * JD-Core Version:    0.7.0.1
 */