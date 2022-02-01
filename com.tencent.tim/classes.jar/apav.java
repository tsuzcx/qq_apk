import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.msgcache.MsgLruCache;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageForConfessNews;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.troop.data.TroopAndDiscMsgProxy.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;

public class apav
  extends ton
{
  private zxj a;
  public Comparator af = new apaw(this);
  TroopManager b;
  
  public apav(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager, tom paramtom)
  {
    super(paramQQAppInterface, paramProxyManager, paramtom);
  }
  
  @Nullable
  private List<MessageRecord> b(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = (List)a().T().get(u(paramString, paramInt));
    List localList;
    Object localObject2;
    MessageRecord localMessageRecord;
    if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
      if (paramBoolean1)
      {
        localObject1 = new anpc.e();
        if (Looper.myLooper() == Looper.getMainLooper()) {}
        for (int i = 1;; i = 0)
        {
          ((anpc.e)localObject1).dKX = i;
          ((anpc.e)localObject1).cfO = "select";
          ((anpc.e)localObject1).cfP = "AIO";
          localList = a(paramString, paramInt, (anpc.e)localObject1);
          if ((((anpc.e)localObject1).dKY != 0) && (anpc.ayC()) && (anpc.lH(1)))
          {
            localObject2 = new HashMap();
            ((HashMap)localObject2).put("param_IsMainThread", String.valueOf(((anpc.e)localObject1).dKX));
            ((HashMap)localObject2).put("param_OptType", ((anpc.e)localObject1).cfO);
            ((HashMap)localObject2).put("param_OptTotalCost", String.valueOf(((anpc.e)localObject1).ant));
            ((HashMap)localObject2).put("param_OptCount", String.valueOf(((anpc.e)localObject1).dKY));
            ((HashMap)localObject2).put("param_OptMsgCount", String.valueOf(((anpc.e)localObject1).dKZ));
            ((HashMap)localObject2).put("param_OptOneCost", String.valueOf(((anpc.e)localObject1).anu));
            ((HashMap)localObject2).put("param_OptScene", ((anpc.e)localObject1).cfP);
            ((HashMap)localObject2).put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
            anpc.a(BaseApplication.getContext()).collectPerformance(null, "actSqliteOptCost", true, ((anpc.e)localObject1).dKZ, 0L, (HashMap)localObject2, null, false);
          }
          if ((localList == null) || (localList.isEmpty())) {
            break label980;
          }
          if ((!QLog.isColorLevel()) || (!aqmq.aFf())) {
            break label423;
          }
          localObject1 = new StringBuilder(localList.size() * 48 + 28);
          ((StringBuilder)localObject1).append("getAIOMsgList, msgInfoList: ");
          localObject2 = localList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
            ((StringBuilder)localObject1).append("(").append(localMessageRecord.time).append(",").append(localMessageRecord.shmsgseq).append(",").append(localMessageRecord.msgtype).append(") ");
          }
        }
        QLog.d("Q.msg.TroopMsgProxy", 2, ((StringBuilder)localObject1).toString());
        label423:
        new ArrayList();
        localObject2 = top.d(localList, false);
        if ((paramBoolean2) && (paramInt == 1) && (!((List)localObject2).isEmpty()) && (((MessageRecord)((List)localObject2).get(((List)localObject2).size() - 1)).shmsgseq > this.app.a().l(paramString, paramInt)))
        {
          this.app.a().G(paramString, paramInt, ((MessageRecord)((List)localObject2).get(((List)localObject2).size() - 1)).shmsgseq);
          if ((((List)localObject2).size() >= localList.size()) || (((List)localObject2).size() >= 10)) {
            break label856;
          }
          long l = ((MessageRecord)((List)localObject2).get(0)).shmsgseq;
          if (this.app.a().k(paramString, paramInt) < l)
          {
            w(paramString, paramInt, true);
            this.app.a().H(paramString, paramInt, l);
          }
        }
        if ((!top.b(paramString, paramInt, (List)localObject2)) && (top.U((List)localObject2)))
        {
          localObject1 = localObject2;
          if (!top.V((List)localObject2)) {}
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.TroopMsgProxy", 2, "getAIOMsgList : pull more long msg");
          }
          localObject1 = top.a(localList, false, 30);
        }
        if ((top.T((List)localObject1)) || (localObject1 == null) || (((List)localObject1).isEmpty())) {
          break label1070;
        }
        localObject2 = e(localList, ((MessageRecord)((List)localObject1).get(0)).shmsgseq);
        if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
          label730:
          localObject1 = localObject2;
        }
      }
    }
    label1070:
    for (;;)
    {
      label734:
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new ArrayList();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.TroopMsgProxy", 2, "continuedList :" + ((List)localObject2).size());
      }
      Collections.sort((List)localObject2, this.af);
      a().T().put(u(paramString, paramInt), localObject2);
      for (;;)
      {
        paramString = (List)a().T().get(u(paramString, paramInt));
        if (paramString != null) {
          Collections.sort(paramString, this.af);
        }
        return paramString;
        label856:
        w(paramString, paramInt, false);
        break;
        localList = h(paramString, paramInt, 15);
        if (QLog.isColorLevel())
        {
          localObject2 = localList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
            QLog.d("Q.msg.TroopMsgProxy", 2, "getAIOMsgList from DB query valid msg " + localMessageRecord.getBaseInfoString());
          }
        }
        localObject2 = localObject1;
        if (localList == null) {
          break label730;
        }
        localObject2 = localObject1;
        if (localList.isEmpty()) {
          break label730;
        }
        localObject2 = top.d(localList, true);
        break label730;
        label980:
        localObject1 = g(paramString, paramInt, 15);
        break label734;
        a().T().remove(u(paramString, paramInt));
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.TroopMsgProxy", 2, "getAioMsgPool().remove :");
        }
        return null;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.TroopMsgProxy", 2, "getAIOMsgList from aiopool size = " + ((List)localObject1).size());
        }
      }
    }
  }
  
  protected String O(String paramString, int paramInt)
  {
    return "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where _id in (select _id from " + MessageRecord.getTableName(paramString, paramInt) + " order by shmsgseq desc limit " + 40 + ") order by shmsgseq desc, _id desc";
  }
  
  protected int a(MessageRecord paramMessageRecord, boolean paramBoolean)
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
  
  protected int a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    int i = 0;
    paramString = MessageRecord.getTableName(paramString, paramInt);
    akvm localakvm = a();
    String str = "( msgtype " + top.ox() + " and isValid=1 ) and shmsgseq <= ?";
    long l = paramMessageRecord.shmsgseq;
    paramString = localakvm.query(false, paramString, new String[] { "_id" }, str, new String[] { String.valueOf(l) }, null, null, null, null);
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
    if (paramList.size() == 0) {
      return -1;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      a((MessageRecord)localIterator.next(), paramBoolean);
    }
    return paramList.size();
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    List localList = h(paramString, paramInt);
    MessageRecord localMessageRecord = a(paramString, paramInt, paramMessageRecord, localList);
    Object localObject = localMessageRecord;
    if (localMessageRecord == null)
    {
      localObject = localMessageRecord;
      if (this.app.a().Gq != null)
      {
        localList.clear();
        localObject = this.app.a().Gq.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if ((localMessageRecord.frienduin.equals(paramString)) && (localMessageRecord.istroop == paramInt)) {
            localList.add(localMessageRecord);
          }
        }
        paramString = a(paramString, paramInt, paramMessageRecord, localList);
        localObject = paramString;
        if (paramString != null)
        {
          QLog.d("Q.msg.TroopMsgProxy", 1, "getSendingTroopMsgItem in send cache;");
          localObject = paramString;
        }
      }
    }
    return localObject;
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord, List<MessageRecord> paramList)
  {
    if ((paramMessageRecord == null) || (paramList == null) || (paramList.isEmpty()) || (paramMessageRecord.msgtype == -2006))
    {
      paramMessageRecord = null;
      return paramMessageRecord;
    }
    paramInt = paramList.size() - 1;
    label43:
    if (paramInt >= 0) {
      if (top.a((MessageRecord)paramList.get(paramInt), paramMessageRecord, true, true)) {
        paramString = (MessageRecord)paramList.get(paramInt);
      }
    }
    for (;;)
    {
      paramMessageRecord = paramString;
      if (paramString == null) {
        break;
      }
      paramMessageRecord = paramString;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.TroopMsgProxy", 2, "getSendingTroopMsgItem: find msg =" + paramString.getLogColorContent() + " , mr.seq = " + paramString.shmsgseq + " , mr.time = " + paramString.time + " , mr.msgtype = " + paramString.msgtype + " , extra = " + paramString.extraflag);
      return paramString;
      if ((((MessageRecord)paramList.get(paramInt)).msgtype == -2011) && (paramMessageRecord.msgtype == -2011))
      {
        if (paramMessageRecord.msgUid == ((MessageRecord)paramList.get(paramInt)).msgUid) {
          paramString = (MessageRecord)paramList.get(paramInt);
        }
      }
      else if ((((MessageRecord)paramList.get(paramInt)).msgtype == -2048) && (paramMessageRecord.msgtype == -2048))
      {
        paramString = (MessageForTroopReward)paramList.get(paramInt);
        MessageForTroopReward localMessageForTroopReward = (MessageForTroopReward)paramMessageRecord;
        if (paramString.rewardSeq == localMessageForTroopReward.rewardSeq)
        {
          paramString = (MessageRecord)paramList.get(paramInt);
          continue;
        }
      }
      paramInt -= 1;
      break label43;
      paramString = null;
    }
  }
  
  protected String a(Cursor paramCursor, SessionInfo paramSessionInfo, int paramInt)
  {
    return paramCursor.getString(paramCursor.getColumnIndex("senderuin"));
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMsgProxy", 2, "queryTroopMessageFromDB_UnionTables, peerUin = " + paramString + ", type " + paramInt1 + ",_id = " + paramLong1 + ",versionCode = " + paramInt2 + ", endSeq " + paramLong2 + ",count = " + paramInt3 + ",customTypes = " + Arrays.toString(paramArrayOfInt));
    }
    if (c(paramString, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase(paramString, paramInt1);
    }
    Object localObject2 = null;
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
        ((StringBuilder)localObject1).append(" ) ");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    paramString = aqir.a(MessageRecord.getOldTableName(paramString, paramInt1), MessageRecord.getTableName(paramString, paramInt1), paramLong1, paramInt2, paramLong2, (String)localObject1, paramInt3, this.app.getReadableDatabase());
    if (paramString == null) {
      paramString = new ArrayList();
    }
    do
    {
      return paramString;
      paramString = paramString.toString();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.TroopMsgProxy", 2, "queryTroopMessageFromDB_UnionTables " + paramString);
      }
      paramArrayOfInt = a().a(paramString, null, this.app);
      paramString = paramArrayOfInt;
    } while (paramArrayOfInt != null);
    return new ArrayList();
  }
  
  public List<MessageRecord> a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMsgProxy", 2, "queryMessageByTimeOrSeq:uin=" + paramString1 + ",type=" + paramInt1 + ",seq=" + paramLong + ",count=" + paramInt2);
    }
    if (c(paramString1, paramInt1, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase();
    }
    if (aqir.a(MessageRecord.getTableName(paramString1, paramInt1), this.app.getReadableDatabase()))
    {
      paramString1 = c(paramString1, paramInt1, paramLong, paramInt2, paramString2);
      if (paramString1 != null) {
        return paramString1;
      }
    }
    return new ArrayList();
  }
  
  protected List<MessageRecord> a(String paramString, int paramInt, anpc.e parame)
  {
    Lock localLock = a().a(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = super.a(paramString, paramInt, parame);
      if (paramString != null) {
        Collections.sort(paramString, this.af);
      }
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  protected List<MessageRecord> a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMsgProxy_" + MsgLruCache.TAG, 2, "getAIOMsgList peerUin: " + paramString + " type: " + paramInt + " , autoInit = " + paramBoolean1);
    }
    Lock localLock = a().a(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = b(paramString, paramInt, paramBoolean1, paramBoolean2);
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  protected void a(SessionInfo paramSessionInfo, String paramString, int paramInt, Set<String> paramSet)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 1026: 
      paramSessionInfo = ((TroopManager)this.app.getManager(52)).al(paramString);
      paramString = paramSessionInfo.iterator();
      while (paramString.hasNext()) {
        paramSet.add(((TroopMemberInfo)paramString.next()).memberuin);
      }
      paramSessionInfo.clear();
      return;
    }
    paramSessionInfo = ((acdu)this.app.getManager(53)).z(paramString);
    paramString = paramSessionInfo.iterator();
    while (paramString.hasNext()) {
      paramSet.add(((DiscussionMemberInfo)paramString.next()).memberUin);
    }
    paramSessionInfo.clear();
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(paramString, paramInt, paramMessageRecord, paramBoolean3);
    if (paramMessageRecord.shmsgseq <= 0L)
    {
      if (paramMessageRecord.shmsgseq < 0L) {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.TroopMsgProxy", 2, "addMessage() msg discard !!! 1: peerUin = [" + paramString + "], type = [" + paramInt + "], mr = [" + paramMessageRecord + "]");
        }
      }
      do
      {
        return;
        if (top.s(paramMessageRecord)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.TroopMsgProxy", 2, "addMessage() msg discard !!! 2: peerUin = [" + paramString + "], type = [" + paramInt + "], mr = [" + paramMessageRecord + "]");
      return;
    }
    a(paramString, paramInt, paramMessageRecord, paramProxyListener, paramBoolean1, paramBoolean2);
  }
  
  protected void a(String paramString, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    Lock localLock;
    if (QLog.isColorLevel())
    {
      QLog.d("Q.msg.TroopMsgProxy", 2, "insertToList " + paramMessageRecord.getBaseInfoString());
      localLock = a().a(paramString, paramInt);
      localLock.lock();
    }
    label661:
    label726:
    label873:
    label879:
    label885:
    for (;;)
    {
      Object localObject1;
      int i;
      int j;
      try
      {
        Object localObject2 = k(paramString, paramInt);
        localObject1 = u(paramString, paramInt);
        a(paramString, paramInt, (String)localObject1, (List)localObject2);
        if ((paramMessageRecord.isSendFromLocal()) || ((top.s(paramMessageRecord)) && (paramMessageRecord.msgtype != -4012) && (paramMessageRecord.msgtype != -4009) && (paramMessageRecord.msgtype != -5001) && (paramMessageRecord.msgtype != -5021)) || (top.x(paramMessageRecord)))
        {
          if ((localObject2 == null) || (((List)localObject2).isEmpty()) || (((MessageRecord)((List)localObject2).get(((List)localObject2).size() - 1)).shmsgseq <= 0L)) {
            break label661;
          }
          if ((!top.fB(paramMessageRecord.msgtype)) || (paramMessageRecord.shmsgseq <= 0L)) {}
        }
        else
        {
          top.a((List)localObject2, paramMessageRecord, true);
          if ((localObject2 != null) && (((List)localObject2).size() > 40) && (!top.gP(paramString)))
          {
            ((List)localObject2).remove(0);
            localObject2 = a().b();
            if (((MsgLruCache)localObject2).getCacheType(localObject1) == acss.czW) {
              ((MsgLruCache)localObject2).changeCacheType(localObject1, acss.czV);
            }
          }
          if ((a().T().containsKey(localObject1)) && (paramBoolean))
          {
            localObject1 = (List)a().T().get(localObject1);
            if (localObject1 != null) {
              break label726;
            }
            localObject1 = new ArrayList();
            if ((!(paramMessageRecord instanceof MessageForUniteGrayTip)) || (((MessageForUniteGrayTip)paramMessageRecord).tipParam.dbK != 3211265)) {
              break label879;
            }
            i = 1;
            if ((!(paramMessageRecord instanceof MessageForUniteGrayTip)) || (((MessageForUniteGrayTip)paramMessageRecord).tipParam.dbK != 655392)) {
              break label873;
            }
            j = 1;
            if ((paramMessageRecord.msgtype != -4009) && (paramMessageRecord.msgtype != -4012) && (i == 0) && (j == 0)) {
              break label806;
            }
            top.a((List)localObject1, paramMessageRecord, true);
            if ((paramMessageRecord.msgtype == -2006) && (zxj.d(this.app, paramInt, paramString)) && ((paramMessageRecord instanceof MessageForFoldMsg)) && (!paramMessageRecord.isSend()))
            {
              if (this.jdField_a_of_type_Zxj == null) {
                this.jdField_a_of_type_Zxj = ((zxj)this.app.getManager(125));
              }
              this.jdField_a_of_type_Zxj.a((List)localObject1, (MessageForFoldMsg)paramMessageRecord);
            }
          }
          return;
          QLog.d("Q.msg.TroopMsgProxy", 1, "insertToList " + paramMessageRecord.getUserLogString());
          break;
        }
        if ((paramMessageRecord.msgtype == -2016) && (paramMessageRecord.shmsgseq != 0L))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.msg.TroopMsgProxy", 2, "insertToList av offline msg " + paramMessageRecord.getBaseInfoString());
          continue;
        }
        paramMessageRecord.shmsgseq = ((MessageRecord)((List)localObject2).get(((List)localObject2).size() - 1)).shmsgseq;
      }
      finally
      {
        localLock.unlock();
      }
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.TroopMsgProxy", 2, "insertToList change seq " + paramMessageRecord.getBaseInfoString());
        continue;
        if ((paramMessageRecord.msgtype == -2016) && (paramMessageRecord.shmsgseq != 0L))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.TroopMsgProxy", 2, "insertToList av offline msg " + paramMessageRecord.getBaseInfoString());
          }
        }
        else
        {
          paramMessageRecord.shmsgseq = 0L;
          continue;
          if ((((List)localObject1).size() > 200) && (paramMessageRecord.istroop == 1)) {
            if (this.b == null)
            {
              this.b = ((TroopManager)this.app.getManager(52));
            }
            else if (!this.b.kA(paramString))
            {
              QLog.d("yellowye", 2, "list.remove(0)");
              ((List)localObject1).remove(0);
              break label885;
              if (paramMessageRecord.msgtype == -4021)
              {
                top.b((List)localObject1, paramMessageRecord, true);
              }
              else if (((paramMessageRecord instanceof MessageForConfessNews)) && (paramMessageRecord.msgtype == -2065) && (paramMessageRecord.istroop == 1))
              {
                top.a((List)localObject1, paramMessageRecord, false);
              }
              else
              {
                ((List)localObject1).add(paramMessageRecord);
                continue;
                j = 0;
                continue;
                i = 0;
              }
            }
          }
        }
      }
    }
  }
  
  public MessageRecord b(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    MessageRecord localMessageRecord = a(paramString, paramInt, paramLong1);
    int j = 0;
    if (localMessageRecord != null) {
      if (localMessageRecord.shmsgseq > 0L) {
        break label190;
      }
    }
    label190:
    for (int i = 1;; i = 0)
    {
      localMessageRecord.shmsgseq = paramLong2;
      localMessageRecord.time = paramLong3;
      if ((localMessageRecord.extraflag == 32772) || (localMessageRecord.extraflag == 32768))
      {
        localMessageRecord.extraflag = 0;
        localMessageRecord.sendFailCode = 0;
        if (!localMessageRecord.isValid)
        {
          localMessageRecord.msgtype = -2006;
          localMessageRecord.isValid = true;
        }
      }
      i(paramString, paramInt, paramLong1);
      b(paramString, paramInt, localMessageRecord);
      j = i;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.TroopMsgProxy", 2, "update msgSeq set msg =" + localMessageRecord.getBaseInfoString());
        j = i;
      }
      if ((localMessageRecord == null) || (!localMessageRecord.isSendFromLocal()) || (j == 0)) {
        break;
      }
      a(paramString, paramInt, localMessageRecord, null);
      return localMessageRecord;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("shmsgseq", Long.valueOf(paramLong2));
    localContentValues.put("time", Long.valueOf(paramLong3));
    if (localMessageRecord != null)
    {
      localContentValues.put("msgtype", Integer.valueOf(localMessageRecord.msgtype));
      localContentValues.put("isValid", Boolean.valueOf(localMessageRecord.isValid));
      if (localMessageRecord.extraflag == 0)
      {
        localContentValues.put("extraflag", Integer.valueOf(0));
        localContentValues.put("sendFailCode", Integer.valueOf(0));
      }
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
  
  protected void bEv()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase();
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.clearMsgQueue();
    EntityTransaction localEntityTransaction = a().getTransaction();
    SQLiteDatabase localSQLiteDatabase = this.app.getWritableDatabase();
    String[] arrayOfString = localSQLiteDatabase.getAllTableNameFromCache();
    if (arrayOfString == null) {
      return;
    }
    akwh localakwh = (akwh)this.app.getManager(201);
    int i = 0;
    label62:
    String str1;
    if (i < arrayOfString.length)
    {
      str1 = arrayOfString[i];
      if ((!str1.startsWith("mr_discusssion")) && (!str1.startsWith("mr_troop"))) {
        break label421;
      }
    }
    label330:
    Object localObject3;
    label421:
    for (Object localObject1 = "select frienduin, istroop, shmsgseq as tmpseq, issend from " + str1 + " where shmsgseq=(select max(shmsgseq) from " + str1 + ")";; localObject3 = null)
    {
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("", 2, "sql zsw =" + (String)localObject1);
        }
        localObject1 = localSQLiteDatabase.rawQuery((String)localObject1, null);
        if (localObject1 == null) {}
      }
      try
      {
        if (((Cursor)localObject1).getCount() > 0)
        {
          ((Cursor)localObject1).moveToFirst();
          long l = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndexOrThrow("tmpseq"));
          String str2 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndexOrThrow("frienduin"));
          int j = ((Cursor)localObject1).getInt(((Cursor)localObject1).getColumnIndexOrThrow("istroop"));
          this.app.a().F(str2, j, l);
        }
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
        if (localEntityTransaction == null) {}
      }
      finally
      {
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
      try
      {
        localEntityTransaction.begin();
        localSQLiteDatabase.delete(str1, null, null);
        if (localEntityTransaction != null) {
          localEntityTransaction.commit();
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.msg.TroopMsgProxy", 2, "clearAllHistoryFromDB: ", localException);
        if (localObject4 == null) {
          break label330;
        }
        localObject4.end();
        break label330;
      }
      finally
      {
        if (localObject4 == null) {
          continue;
        }
        localObject4.end();
      }
      if (localakwh != null) {
        localakwh.a(str1, null, null);
      }
      i += 1;
      break label62;
      break;
    }
  }
  
  protected List<MessageRecord> c(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) || (paramString == null) || (paramString.length() == 0)) {
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
        if ((localMessageRecord.shmsgseq == paramLong1) && ((!localMessageRecord.isSendFromLocal()) || (localMessageRecord.extraflag == 0)) && (!top.s(localMessageRecord))) {
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
  
  public void d(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    Lock localLock = a().a(paramString, paramInt);
    localLock.lock();
    try
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        if (localMessageRecord.msgtype == -4004) {
          this.app.b().a(localMessageRecord.frienduin, 1, localMessageRecord.msgtype, localMessageRecord.uniseq);
        }
      }
    }
    finally
    {
      localLock.unlock();
    }
    super.d(paramString, paramInt, paramList);
  }
  
  protected int e(String paramString, int paramInt, long paramLong)
  {
    int i = 0;
    String str = MessageRecord.getTableName(paramString, paramInt);
    str = String.format("select * from (select count() as unReadNum from %s mr where mr.isread=0 and mr.issend='0' and mr.%s>'%d'),%s m where m.%s>'%d' order by %s limit 1", new Object[] { str, "shmsgseq", Long.valueOf(paramLong), str, "shmsgseq", Long.valueOf(paramLong), "shmsgseq desc , _id desc" });
    if (c(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase(a());
    }
    paramString = a().rawQuery(QQMessageFacade.Message.class, str, null);
    paramInt = i;
    if (paramString != null)
    {
      paramInt = i;
      if (!paramString.isEmpty()) {
        paramInt = ((QQMessageFacade.Message)paramString.get(0)).unReadNum;
      }
    }
    return paramInt;
  }
  
  protected List<MessageRecord> e(List<MessageRecord> paramList, long paramLong)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
      if (localMessageRecord.shmsgseq >= paramLong) {}
      label130:
      for (;;)
      {
        i -= 1;
        break;
        if ((localMessageRecord.isValid) && ((localMessageRecord.msgtype != -2006) || ((localMessageRecord instanceof MessageForFoldMsg)))) {}
        for (int j = 1;; j = 0)
        {
          if (j == 0) {
            break label130;
          }
          long l = localMessageRecord.shmsgseq;
          localArrayList.add(0, localMessageRecord);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  protected List<MessageRecord> h(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMsgProxy", 2, "queryMessagesByShmsgseqFromDB, peerUin[" + ahav.kZ(paramString) + "] type[" + paramInt + "] shmsgseq[" + paramLong1 + "] msgUid[" + paramLong2 + "]");
    }
    if ((paramLong1 == 0L) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.TroopMsgProxy", 2, "queryMessagesByShmsgseqFromDB Warning! shmsgseq == 0");
    }
    if (c(paramString, paramInt, true)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase(a());
    }
    paramString = "select * from " + MessageRecord.getTableName(paramString, paramInt) + " where shmsgseq=?";
    akvm localakvm = a();
    QQAppInterface localQQAppInterface = this.app;
    paramString = localakvm.a(paramString, new String[] { String.valueOf(paramLong1) }, localQQAppInterface);
    if (paramString != null) {
      return paramString;
    }
    return new ArrayList();
  }
  
  protected void p(String paramString, int paramInt, long paramLong)
  {
    q(paramString, paramInt, paramLong);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("isread", Boolean.valueOf(true));
    String str1 = String.valueOf(paramLong);
    String str2 = MessageRecord.getTableName(paramString, paramInt);
    if ((top.ft(paramInt)) && (top.oz() != null))
    {
      a(paramString, paramInt, str2, localContentValues, String.format("isread=? and %s<=? and " + top.oz(), new Object[] { "shmsgseq" }), new String[] { "0", str1 }, null);
      return;
    }
    a(paramString, paramInt, str2, localContentValues, String.format("isread=? and %s<=?", new Object[] { "shmsgseq" }), new String[] { "0", str1 }, null);
  }
  
  protected void w(String paramString, int paramInt, boolean paramBoolean)
  {
    ThreadManager.post(new Thread(new TroopAndDiscMsgProxy.2(this, paramBoolean), "report_troop_aio_break"), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apav
 * JD-Core Version:    0.7.0.1
 */