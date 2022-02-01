import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQStoryFeed;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import org.json.JSONObject;

public class wkh
  implements Manager
{
  private static int[] fB = { -1034, -2015, -2060, -2062, -2061, -7007, -2074, -7009, -7010, -7011 };
  private final String aSF = "{\n\t\"priority\": {\n\t\t\"1\": 1,\n\t\t\"2\": 2,\n\t\t\"3\": 5,\n\t\t\"4\": 6,\n\t\t\"5\": 7,\n\t\t\"6\": 3,\n\t\t\"7\": 4\n\t},\n\t\"interval\": 3\n}";
  private QQAppInterface app;
  private final int bOV = 10000;
  private boolean bdB = true;
  private SparseArray<Integer> br = new SparseArray();
  private Map<String, Map<Integer, BeancurdMsg>> hs = new ConcurrentHashMap();
  private Map<String, Long> ht = new ConcurrentHashMap();
  private boolean isDestroyed;
  private int mInterval = 3;
  
  public wkh(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    init();
  }
  
  private void H(MessageRecord paramMessageRecord)
  {
    this.app.b().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.msgtype, paramMessageRecord.uniseq);
    this.app.b().t(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
  }
  
  private void P(String paramString, int paramInt1, int paramInt2)
  {
    paramString = this.app.b().b(paramString, paramInt1, new int[] { fa(paramInt2) });
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramString.next();
        if (localMessageRecord != null)
        {
          this.app.b().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.msgtype, localMessageRecord.uniseq);
          this.app.b().t(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
        }
      }
    }
  }
  
  private MessageRecord a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    String str = "";
    if ((paramString2 instanceof String)) {
      str = paramString2;
    }
    int i = fa(paramInt2);
    MessageRecord localMessageRecord = anbi.d(i);
    List localList = this.app.b().k(paramString1, paramInt1);
    if ((localList != null) && (localList.size() > 0)) {}
    for (long l = 1L + ((MessageRecord)localList.get(localList.size() - 1)).time;; l = anaz.gQ())
    {
      localMessageRecord.init(this.app.getAccount(), paramString1, paramString1, str, l, i, paramInt1, l);
      localMessageRecord.isread = true;
      localMessageRecord.msg = paramString2;
      if (paramInt2 == 5) {}
      try
      {
        localMessageRecord.msg = null;
        localMessageRecord.msgData = paramString2.getBytes("ISO_8859_1");
        ((MessageForQQStoryFeed)localMessageRecord).mergeFrom(localMessageRecord.msgData);
        return localMessageRecord;
      }
      catch (Exception paramString1) {}
    }
    return localMessageRecord;
  }
  
  private boolean b(BeancurdMsg paramBeancurdMsg)
  {
    long l = anaz.gQ();
    if (l > paramBeancurdMsg.startTime + paramBeancurdMsg.validTime) {}
    for (boolean bool = false;; bool = true)
    {
      log(String.format("busiID:%d,now:%d,BeancurdMsg.startTime:%d,validTime:%d", new Object[] { Integer.valueOf(paramBeancurdMsg.busiid), Long.valueOf(l), Long.valueOf(paramBeancurdMsg.startTime), Long.valueOf(paramBeancurdMsg.validTime) }));
      return bool;
    }
  }
  
  private int eZ(int paramInt)
  {
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < fB.length)
      {
        if (fB[i] == paramInt) {
          j = i + 1;
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  private int fa(int paramInt)
  {
    int j = 0;
    int i = j;
    if (paramInt > 0)
    {
      i = j;
      if (paramInt <= fB.length) {
        i = fB[(paramInt - 1)];
      }
    }
    return i;
  }
  
  private void h(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    paramString1 = a(paramString1, paramInt1, paramInt2, paramString2);
    paramString1.isread = true;
    if (!achp.a(this.app, paramString1, false)) {
      this.app.b().b(paramString1, paramString1.selfuin);
    }
  }
  
  public static boolean i(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    int[] arrayOfInt = fB;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        int k = arrayOfInt[i];
        if (paramChatMessage.msgtype == k) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  private void init()
  {
    Object localObject2 = null;
    Object localObject3 = aqmj.Ch();
    Object localObject1 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      localObject1 = "{\n\t\"priority\": {\n\t\t\"1\": 1,\n\t\t\"2\": 2,\n\t\t\"3\": 5,\n\t\t\"4\": 6,\n\t\t\"5\": 7,\n\t\t\"6\": 3,\n\t\t\"7\": 4\n\t},\n\t\"interval\": 3\n}";
    }
    xm((String)localObject1);
    EntityManager localEntityManager = this.app.a().createEntityManager();
    localObject1 = localEntityManager.query(BeancurdMsg.class, new BeancurdMsg().getTableName(), false, null, null, null, null, null, null);
    if (localObject1 != null) {
      log(String.format("init.beancurd table count = %d", new Object[] { Integer.valueOf(((List)localObject1).size()) }));
    }
    if ((localObject1 != null) && (((List)localObject1).size() > 10000))
    {
      ((List)localObject1).clear();
      localEntityManager.drop(BeancurdMsg.class);
    }
    BeancurdMsg localBeancurdMsg;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      log(String.format("init: has BeancurdMsg  size = %d ", new Object[] { Integer.valueOf(((List)localObject1).size()) }));
      Iterator localIterator = ((List)localObject1).iterator();
      localObject1 = localObject2;
      if (localIterator.hasNext())
      {
        localBeancurdMsg = (BeancurdMsg)localIterator.next();
        log(" the table pending show msg :" + localBeancurdMsg);
        if (!b(localBeancurdMsg))
        {
          log(String.format("init: has invalid msg  ", new Object[0]));
          if (localObject1 != null) {
            break label392;
          }
          localObject1 = new ArrayList();
        }
      }
    }
    label392:
    for (;;)
    {
      ((List)localObject1).add(localBeancurdMsg);
      break;
      String str = localBeancurdMsg.frienduin;
      localObject3 = (Map)this.hs.get(str);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new ConcurrentHashMap(6);
      }
      ((Map)localObject2).put(Integer.valueOf(localBeancurdMsg.busiid), localBeancurdMsg);
      this.hs.put(str, localObject2);
      break;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localEntityManager.remove((BeancurdMsg)((Iterator)localObject1).next());
          continue;
          log(String.format("init: has no BeancurdMsg  ", new Object[0]));
        }
      }
      localEntityManager.close();
      return;
    }
  }
  
  private void log(String paramString)
  {
    if ((QLog.isColorLevel()) && (this.bdB)) {
      QLog.d("BeancurdManager", 2, "fight: " + paramString);
    }
  }
  
  private List<MessageRecord> r(String paramString, int paramInt)
  {
    return this.app.b().b(paramString, paramInt, null);
  }
  
  public void Q(String paramString, int paramInt1, int paramInt2)
  {
    Map localMap = (Map)this.hs.get(paramString);
    if (localMap != null)
    {
      BeancurdMsg localBeancurdMsg = (BeancurdMsg)localMap.get(Integer.valueOf(paramInt2));
      if (localBeancurdMsg != null)
      {
        localMap.remove(Integer.valueOf(paramInt2));
        this.hs.put(paramString, localMap);
        this.app.a().createEntityManager().remove(localBeancurdMsg);
      }
    }
  }
  
  public long T(String paramString)
  {
    log(String.format(" blockBeancurdForQZone ", new Object[0]));
    long l = SystemClock.uptimeMillis() + 5000L;
    this.ht.put(paramString, Long.valueOf(l));
    return l;
  }
  
  public BeancurdMsg a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = (Map)this.hs.get(paramString);
    if (paramString != null) {
      return (BeancurdMsg)paramString.get(Integer.valueOf(paramInt2));
    }
    return null;
  }
  
  public boolean a(BeancurdMsg paramBeancurdMsg)
  {
    return false;
  }
  
  public void cx(String paramString, int paramInt)
  {
    Object localObject2 = null;
    boolean bool;
    Map localMap;
    try
    {
      bool = TextUtils.isEmpty(paramString);
      if (bool) {}
      for (;;)
      {
        return;
        if (!this.isDestroyed)
        {
          this.ht.remove(paramString);
          log(String.format("triggerInfsert: start   ", new Object[0]));
          localMap = (Map)this.hs.get(paramString);
          if (localMap != null) {
            break;
          }
          log(String.format("triggerInsert: no beancurd  ", new Object[0]));
        }
      }
      localObject1 = r(paramString, paramInt);
    }
    finally {}
    Object localObject1;
    int i;
    if (localObject1 != null)
    {
      i = ((List)localObject1).size();
      if ((i > 0) && (i > this.mInterval)) {
        localObject1 = ((List)localObject1).subList(i - this.mInterval, i);
      }
    }
    for (;;)
    {
      label167:
      MessageRecord localMessageRecord;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        i = ((List)localObject1).size() - 1;
        if (i >= 0)
        {
          localMessageRecord = (MessageRecord)((List)localObject1).get(i);
          if (eZ(localMessageRecord.msgtype) <= 0) {}
        }
      }
      for (;;)
      {
        Iterator localIterator = localMap.keySet().iterator();
        localObject1 = null;
        label213:
        Object localObject3;
        if (localIterator.hasNext())
        {
          localObject3 = (BeancurdMsg)localMap.get(Integer.valueOf(((Integer)localIterator.next()).intValue()));
          if (!b((BeancurdMsg)localObject3))
          {
            if (localObject2 != null) {
              break label683;
            }
            localObject2 = new ArrayList();
          }
        }
        label683:
        for (;;)
        {
          ((List)localObject2).add(localObject3);
          break label213;
          i -= 1;
          break label167;
          if (localObject1 == null) {}
          for (;;)
          {
            localObject1 = localObject3;
            break;
            try
            {
              int j = ((Integer)this.br.get(((BeancurdMsg)localObject1).busiid)).intValue();
              int k = ((Integer)this.br.get(((BeancurdMsg)localObject3).busiid)).intValue();
              i = j;
              if (((BeancurdMsg)localObject1).ispush) {
                i = j * 100;
              }
              bool = ((BeancurdMsg)localObject3).ispush;
              j = k;
              if (bool) {
                j = k * 100;
              }
              if (i > j) {
                continue;
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                log("trigger 2 mPriorityMap null..." + localException.getMessage());
              }
            }
            localObject3 = localObject1;
          }
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              BeancurdMsg localBeancurdMsg = (BeancurdMsg)((Iterator)localObject2).next();
              Q(localBeancurdMsg.frienduin, 0, localBeancurdMsg.busiid);
            }
          }
          if (localObject1 == null) {
            break;
          }
          log(String.format("triggerInsert: best beancurd id = %d ", new Object[] { Integer.valueOf(((BeancurdMsg)localObject1).busiid) }));
          bool = ((BeancurdMsg)localObject1).isNeedDelHistory;
          i = ((BeancurdMsg)localObject1).busiid;
          localObject2 = ((BeancurdMsg)localObject1).buffer;
          if (localMessageRecord == null)
          {
            if (bool) {
              P(paramString, paramInt, i);
            }
            Q(paramString, paramInt, i);
            h(paramString, paramInt, i, (String)localObject2);
            bool = true;
          }
          for (;;)
          {
            if ((bool) && (((BeancurdMsg)localObject1).ispush)) {
              report(1, i);
            }
            log(String.format("triggerInsert: is inserted = %b ", new Object[] { Boolean.valueOf(bool) }));
            break;
            if ((localMessageRecord.msgtype == fa(i)) || (((BeancurdMsg)localObject1).ispush))
            {
              H(localMessageRecord);
              if (bool) {
                P(paramString, paramInt, i);
              }
              Q(paramString, paramInt, i);
              h(paramString, paramInt, i, (String)localObject2);
              bool = true;
            }
            else
            {
              bool = false;
            }
          }
        }
        localMessageRecord = null;
      }
    }
  }
  
  public boolean d(List<MessageRecord> paramList, boolean paramBoolean)
  {
    int j = this.mInterval;
    int k = paramList.size();
    int i;
    if ((j > 0) && (k > 0))
    {
      i = 0;
      if ((i >= Math.min(j, k)) || (eZ(((MessageRecord)paramList.get(k - i - 1)).msgtype) > 0))
      {
        if (i >= Math.min(j, k)) {
          break label178;
        }
        paramList = (MessageRecord)paramList.remove(k - i - 1);
        if ((paramList != null) && (paramBoolean))
        {
          this.app.b().a(paramList.frienduin, paramList.istroop, paramList.msgtype, paramList.uniseq);
          this.app.b().t(paramList.frienduin, paramList.istroop, paramList.uniseq);
        }
      }
    }
    label178:
    for (paramBoolean = true;; paramBoolean = false)
    {
      log(String.format(" filter beancurd is = %b", new Object[] { Boolean.valueOf(paramBoolean) }));
      return paramBoolean;
      i += 1;
      break;
    }
  }
  
  public int getPriority(int paramInt)
  {
    return ((Integer)this.br.get(paramInt)).intValue();
  }
  
  public void onDestroy()
  {
    log(" onDestory...");
    this.isDestroyed = true;
    this.br.clear();
    this.hs.clear();
    this.ht.clear();
  }
  
  public void report(int paramInt1, int paramInt2)
  {
    String str = "";
    switch (paramInt1)
    {
    }
    for (;;)
    {
      anot.a(this.app, "dc00898", "", "", str, str, 0, 0, "", Integer.toString(paramInt2), "", "");
      return;
      str = "0x8009431";
      continue;
      str = "0x8009432";
      continue;
      str = "0x8009433";
      continue;
      str = "0x8009434";
    }
  }
  
  public void xm(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("priority"))
        {
          JSONObject localJSONObject = paramString.getJSONObject("priority");
          if ((localJSONObject != null) && (localJSONObject.length() > 0))
          {
            Iterator localIterator = localJSONObject.keys();
            while (localIterator.hasNext())
            {
              String str = localIterator.next().toString();
              int i = localJSONObject.optInt(str);
              this.br.append(Integer.parseInt(str), Integer.valueOf(i));
            }
          }
        }
        if (!paramString.has("interval")) {}
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        log("parseConfig.error:" + paramString.getMessage());
        return;
      }
    }
    this.mInterval = paramString.optInt("interval");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wkh
 * JD-Core Version:    0.7.0.1
 */