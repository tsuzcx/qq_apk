import android.support.v4.util.LruCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ahyk
{
  final List<Object> Cn;
  QQAppInterface app;
  final ConcurrentHashMap<String, Object[]> fD;
  final LruCache<String, ahyk.a> s;
  
  public ahyk(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.fD = new ConcurrentHashMap(3);
    this.Cn = new ArrayList();
    this.s = new ahyl(this, 20);
  }
  
  public static final int O(QQAppInterface paramQQAppInterface)
  {
    int i = ((Integer)ajrb.c(paramQQAppInterface.getAccount(), "self_gender", Integer.valueOf(0))).intValue();
    if (i == 2) {
      return 1;
    }
    if (i == 1) {
      return 0;
    }
    return 2;
  }
  
  private ahyk.a a(String paramString)
  {
    try
    {
      if (this.s != null)
      {
        paramString = (ahyk.a)this.s.get(paramString);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void a(String paramString, ahyk.a parama)
  {
    try
    {
      this.s.put(paramString, parama);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    do
    {
      do
      {
        do
        {
          return;
          locala = a(paramString1);
          if ((locala == null) || (locala.time > paramLong)) {
            break;
          }
          locala.gender = paramInt;
          if ((paramString2 != null) && (paramString2.length() > 0)) {
            locala.nick = paramString2;
          }
          locala.time = paramLong;
        } while (!QLog.isDevelopLevel());
        ajrk.f("PttShow", "cacheGender_update", new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        return;
      } while (locala != null);
      ahyk.a locala = new ahyk.a();
      locala.uin = paramString1;
      locala.gender = paramInt;
      if ((paramString2 != null) && (paramString2.length() > 0)) {
        locala.nick = paramString2;
      }
      locala.time = paramLong;
      a(paramString1, locala);
    } while (!QLog.isDevelopLevel());
    ajrk.f("PttShow", "cacheGender_add", new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
  }
  
  public void ao(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || ((paramMessageRecord.extLong & 0x1) == 0) || (paramMessageRecord.senderuin == null)) {}
    label218:
    do
    {
      Object localObject1;
      do
      {
        return;
        localObject1 = a(paramMessageRecord.senderuin);
      } while ((localObject1 != null) && (((ahyk.a)localObject1).time >= paramMessageRecord.time));
      try
      {
        String str1 = paramMessageRecord.getExtInfoFromExtStr("hotchat_nick");
        i = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("hotchat_gender"));
        l1 = paramMessageRecord.time;
        localObject2 = str1;
        j = i;
        if (!paramMessageRecord.senderuin.equals(this.app.getCurrentAccountUin())) {
          break label218;
        }
        str2 = (String)ajrb.c(this.app.getAccount(), "self_nick", String.valueOf(""));
        k = O(this.app);
        localObject1 = str1;
        if (str2 == null) {
          break;
        }
        localObject1 = str1;
        if (str2.length() <= 0) {
          break;
        }
        localObject1 = str2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i;
          long l1;
          Object localObject2;
          int j;
          String str2;
          int k;
          long l2;
          localException.printStackTrace();
          continue;
          if (k != 2) {
            i = k;
          }
        }
      }
      l2 = NetConnInfoCenter.getServerTime();
      localObject2 = localObject1;
      j = i;
      l1 = l2;
      if (QLog.isDevelopLevel())
      {
        ajrk.f("PttShow", "cacheSelfGender", new Object[] { str2, Integer.valueOf(k), Long.valueOf(l2) });
        l1 = l2;
        j = i;
        localObject2 = localObject1;
      }
      a(paramMessageRecord.senderuin, (String)localObject2, j, l1);
    } while (!QLog.isDevelopLevel());
    ajrk.f("PttShow", "cacheGender", new Object[] { paramMessageRecord.extStr });
  }
  
  public Object b(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0) || (this.s == null))
    {
      paramString = null;
      return paramString;
    }
    int i = 2;
    ahyk.a locala = a(paramString);
    if (locala == null) {
      if (paramString.equals(this.app.getCurrentAccountUin()))
      {
        paramString = (String)ajrb.c(this.app.getAccount(), "self_nick", String.valueOf(""));
        i = O(this.app);
        a(this.app.getAccount(), paramString, i, NetConnInfoCenter.getServerTime());
      }
    }
    for (;;)
    {
      switch (paramInt)
      {
      case 2: 
      default: 
        return null;
        if (QLog.isDevelopLevel())
        {
          ajrk.f("PttShow", "getGender no cache", new Object[] { paramString });
          paramString = null;
          continue;
          i = locala.gender;
          paramString = locala.nick;
        }
        break;
      case 1: 
        return Integer.valueOf(i);
        paramString = null;
      }
    }
  }
  
  public String lt(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || (this.s == null)) {
      return null;
    }
    paramString = b(paramString, 2);
    if ((paramString instanceof String)) {
      return (String)paramString;
    }
    return null;
  }
  
  public static class a
  {
    public int gender;
    public String nick;
    public long time;
    public String uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahyk
 * JD-Core Version:    0.7.0.1
 */