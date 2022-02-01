import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.1;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.2;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.3;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.5;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.6;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.AioKeyword;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.MessageRecord;>;
import java.util.Map;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class apan
  implements Manager
{
  protected final List<String> Hw = new ArrayList();
  public final List<String> Hx = new ArrayList();
  protected boolean cPA;
  protected boolean cPz;
  public final SparseArray<apaf> dy = new SparseArray();
  public final SparseArray<TroopAioKeywordTipInfo> dz = new SparseArray();
  public QQAppInterface mApp;
  protected final Map<String, apae> ny = new HashMap();
  
  public apan(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  private String a(String paramString1, String paramString2, Integer paramInteger)
  {
    return paramString1 + "_" + paramString2 + "_" + paramInteger;
  }
  
  private void a(MessageRecord paramMessageRecord, TroopAioKeywordTipInfo paramTroopAioKeywordTipInfo, apan.a parama)
  {
    if (parama != null) {
      ThreadManager.getUIHandler().post(new TroopAioKeywordTipManager.5(this, parama, paramMessageRecord, paramTroopAioKeywordTipInfo));
    }
  }
  
  private void a(Integer paramInteger, MessageRecord paramMessageRecord, apan.a parama)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramInteger);
    ((acms)this.mApp.getBusinessHandler(20)).a(localArrayList, new apap(this, paramMessageRecord, parama));
  }
  
  private boolean a(Integer paramInteger, int paramInt, MessageRecord paramMessageRecord)
  {
    Object localObject1;
    synchronized (this.dy)
    {
      localObject1 = (apaf)this.dy.get(paramInteger.intValue());
      if (localObject1 == null) {
        return false;
      }
    }
    synchronized (this.Hx)
    {
      if (!this.cPA)
      {
        this.Hx.addAll(apad.o(this.mApp));
        this.cPA = true;
      }
      paramInteger = a(this.mApp.getCurrentAccountUin(), paramMessageRecord.getExtInfoFromExtStr("key_aio_keyword"), paramInteger);
      if ((!paramMessageRecord.isSend()) && (this.Hx.contains(paramInteger)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopAioKeywordTipManager", 2, "isSupportedRuleId, blackUinKeyRuleId=" + paramInteger);
        }
        return false;
      }
      if ((((apaf)localObject1).startTime > NetConnInfoCenter.getServerTime()) || (((apaf)localObject1).endTime < NetConnInfoCenter.getServerTime()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopAioKeywordTipManager", 2, "isSupportedRuleId, not support timelimit, currentTime=" + NetConnInfoCenter.getServerTime() + ",ruleInfo.startTime =" + ((apaf)localObject1).startTime + ",ruleInfo.endTime=" + ((apaf)localObject1).endTime);
        }
        return false;
      }
    }
    if ((((apaf)localObject1).dSv & paramInt) == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAioKeywordTipManager", 2, "isSupportedRuleId, not support positionFlag, ruleInfo.positionFlag=" + ((apaf)localObject1).dSv + ", curInvokeType=" + paramInt);
      }
      return false;
    }
    if ((((apaf)localObject1).Ht != null) && (((apaf)localObject1).Ht.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAioKeywordTipManager", 2, "isSupportedRuleId, ruleInfo.troopTypes == null");
      }
      paramInteger = ((TroopManager)this.mApp.getManager(52)).c(paramMessageRecord.frienduin);
      if (!((apaf)localObject1).Ht.contains(Integer.valueOf((int)paramInteger.dwGroupClassExt)))
      {
        if (QLog.isColorLevel())
        {
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("[");
          localObject1 = ((apaf)localObject1).Ht.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            paramMessageRecord.append(((Integer)((Iterator)localObject1).next()).intValue());
            paramMessageRecord.append(",");
          }
          paramMessageRecord.append("]");
          QLog.i("TroopAioKeywordTipManager", 2, "isSupportedRuleId, not support troopType, troopTypes=" + paramMessageRecord.toString() + ",mCurType=" + paramInteger.dwGroupClassExt);
        }
        return false;
      }
    }
    return true;
  }
  
  private boolean bd(MessageRecord paramMessageRecord)
  {
    boolean bool = true;
    aBh();
    for (;;)
    {
      synchronized (this.Hw)
      {
        if (this.Hw.size() == 0) {
          return false;
        }
        if (!TextUtils.equals(paramMessageRecord.getExtInfoFromExtStr("key_is_checked_aio_keyword"), "1")) {
          break;
        }
        if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("key_aio_keyword")))
        {
          bool = true;
          return bool;
        }
      }
      bool = false;
    }
    Object localObject2 = e(paramMessageRecord);
    ??? = null;
    Iterator localIterator = ((List)localObject2).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = oA((String)localIterator.next());
      ??? = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramMessageRecord.saveExtInfoToExtStr("key_aio_keyword", (String)localObject2);
        ??? = localObject2;
      }
    }
    paramMessageRecord.saveExtInfoToExtStr("key_is_checked_aio_keyword", "1");
    this.mApp.b().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, "extStr", paramMessageRecord.extStr);
    if (!TextUtils.isEmpty((CharSequence)???)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private List<Integer> d(MessageRecord arg1)
  {
    Object localObject1 = ???.getExtInfoFromExtStr("key_aio_keyword");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      synchronized (this.ny)
      {
        localObject1 = (apae)this.ny.get(localObject1);
        if (localObject1 != null)
        {
          localObject1 = ((apae)localObject1).Hs;
          return localObject1;
        }
      }
    }
    return null;
  }
  
  private List<String> e(MessageRecord paramMessageRecord)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramMessageRecord.msgtype == -1000) || (paramMessageRecord.msgtype == -1051))
    {
      paramMessageRecord = (MessageForText)paramMessageRecord;
      if (paramMessageRecord.sb == null) {
        paramMessageRecord.parse();
      }
      if (paramMessageRecord.sb != null) {
        localArrayList.add(paramMessageRecord.sb.toString().toLowerCase());
      }
    }
    do
    {
      do
      {
        do
        {
          return localArrayList;
        } while (paramMessageRecord.msgtype != -2011);
        paramMessageRecord = (MessageForStructing)paramMessageRecord;
        if (paramMessageRecord.structingMsg == null) {
          paramMessageRecord.parse();
        }
      } while (!(paramMessageRecord.structingMsg instanceof AbsShareMsg));
      paramMessageRecord = (AbsShareMsg)paramMessageRecord.structingMsg;
      if (!TextUtils.isEmpty(paramMessageRecord.mContentTitle)) {
        localArrayList.add(paramMessageRecord.mContentTitle.toLowerCase());
      }
      if (!TextUtils.isEmpty(paramMessageRecord.mContentSummary)) {
        localArrayList.add(paramMessageRecord.mContentSummary.toLowerCase());
      }
    } while (TextUtils.isEmpty(paramMessageRecord.mMsgUrl));
    localArrayList.add(paramMessageRecord.mMsgUrl.toLowerCase());
    return localArrayList;
  }
  
  private void mK(List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ThreadManager.post(new TroopAioKeywordTipManager.2(this, paramList), 8, null, true);
  }
  
  private String oA(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = 2147483647;
    for (;;)
    {
      int j;
      synchronized (this.Hw)
      {
        Iterator localIterator = this.Hw.iterator();
        localObject1 = null;
        if (!localIterator.hasNext()) {
          break label102;
        }
        localObject2 = (String)localIterator.next();
        j = paramString.indexOf((String)localObject2);
        if ((j < 0) || (j >= i)) {
          break label99;
        }
        if (j == 0) {
          return localObject2;
        }
      }
      Object localObject1 = localObject2;
      i = j;
      label99:
      for (;;)
      {
        break;
      }
      label102:
      Object localObject2 = localObject1;
    }
  }
  
  public void Q(List<apae> arg1, List<apaf> paramList1)
  {
    if (??? != null)
    {
      Object localObject2;
      try
      {
        synchronized (this.Hw)
        {
          this.Hw.clear();
          localObject2 = ???.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            apae localapae = (apae)((Iterator)localObject2).next();
            this.Hw.add(localapae.keyWord.toLowerCase());
          }
        }
      }
      finally {}
      synchronized (this.ny)
      {
        this.ny.clear();
        ??? = ???.iterator();
        if (???.hasNext())
        {
          localObject2 = (apae)???.next();
          this.ny.put(((apae)localObject2).keyWord.toLowerCase(), localObject2);
        }
      }
    }
    if (paramList1 != null) {
      synchronized (this.dy)
      {
        this.dy.clear();
        paramList1 = paramList1.iterator();
        if (paramList1.hasNext())
        {
          ??? = (apaf)paramList1.next();
          this.dy.put(((apaf)???).ruleId, ???);
        }
      }
    }
    this.cPz = true;
  }
  
  public Pair<MessageRecord, Integer> a(List<MessageRecord> paramList, List<String> paramList1, int paramInt)
  {
    Iterator localIterator1 = paramList.iterator();
    Object localObject1 = null;
    paramList = null;
    Object localObject2;
    for (;;)
    {
      if (localIterator1.hasNext())
      {
        localObject2 = (MessageRecord)localIterator1.next();
        if (bd((MessageRecord)localObject2))
        {
          Object localObject3 = d((MessageRecord)localObject2);
          if ((localObject3 != null) && (((List)localObject3).size() > 0))
          {
            Iterator localIterator2 = ((List)localObject3).iterator();
            for (;;)
            {
              if (localIterator2.hasNext())
              {
                localObject3 = (Integer)localIterator2.next();
                if (((paramList1 == null) || (!paramList1.contains(((MessageRecord)localObject2).getExtInfoFromExtStr("key_aio_keyword") + "_" + localObject3))) && (a((Integer)localObject3, paramInt, (MessageRecord)localObject2)))
                {
                  localObject1 = localObject3;
                  paramList = (List<MessageRecord>)localObject2;
                  label160:
                  if (localObject1 == null) {
                    break;
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      return new Pair(paramList, localObject1);
      localObject2 = localObject1;
      localObject1 = paramList;
      paramList = (List<MessageRecord>)localObject2;
      break;
      localObject2 = paramList;
      paramList = (List<MessageRecord>)localObject1;
      localObject1 = localObject2;
      break label160;
      paramList1 = paramList;
      paramList = (List<MessageRecord>)localObject1;
      localObject1 = paramList1;
    }
  }
  
  public void a(String paramString1, String paramString2, Integer paramInteger)
  {
    ThreadManager.post(new TroopAioKeywordTipManager.6(this, paramString1, paramString2, paramInteger), 8, null, true);
  }
  
  public void a(List<MessageRecord> paramList, List<String> paramList1, int paramInt, apan.a parama)
  {
    ThreadManager.post(new TroopAioKeywordTipManager.3(this, paramList, paramList1, paramInt, parama), 8, null, true);
  }
  
  public void aBh()
  {
    try
    {
      if (!this.cPz)
      {
        oidb_0x496.AioKeyword localAioKeyword = apad.a();
        Q(apad.a(localAioKeyword), apad.b(localAioKeyword));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void mJ(List<? extends MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ThreadManager.post(new TroopAioKeywordTipManager.1(this, paramList), 5, null, true);
  }
  
  public void onDestroy() {}
  
  public static abstract class a
  {
    public void b(MessageRecord paramMessageRecord, TroopAioKeywordTipInfo paramTroopAioKeywordTipInfo) {}
    
    public void c(String paramString, Integer paramInteger) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apan
 * JD-Core Version:    0.7.0.1
 */