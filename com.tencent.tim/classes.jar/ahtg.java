import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.gamecenter.message.UinToTinyId;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.Nullable;

public class ahtg
  extends FullCache
{
  private long aaU;
  private QQAppInterface app;
  private ConcurrentHashMap<String, Pair<String, String>> fw = new ConcurrentHashMap();
  
  public ahtg(QQAppInterface paramQQAppInterface, DBDelayManager paramDBDelayManager)
  {
    super(paramQQAppInterface, paramDBDelayManager, UinToTinyId.class);
    this.app = paramQQAppInterface;
    doInit();
  }
  
  @Nullable
  private String E(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString3)) {
      return null;
    }
    UinToTinyId localUinToTinyId = a(paramString3);
    if (localUinToTinyId != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.tiny_msg.TinyIdCache", 2, "findUinWithTinyId UIN = " + localUinToTinyId.friendUin + ",  fromTinyId = " + paramString1 + ", toTinyId = " + paramString2);
      }
      return localUinToTinyId.friendUin;
    }
    localUinToTinyId = new UinToTinyId();
    long l = this.aaU - 1L;
    this.aaU = l;
    localUinToTinyId.friendUin = String.valueOf(l);
    localUinToTinyId.tinyId = paramString3;
    localUinToTinyId.fromTinyId = paramString1;
    localUinToTinyId.toTinyId = paramString2;
    addCache(localUinToTinyId);
    dqa();
    if (QLog.isColorLevel()) {
      QLog.d("Q.tiny_msg.TinyIdCache", 2, "findUinWithTinyId NULL UIN = " + localUinToTinyId.friendUin + ",  fromTinyId = " + paramString1 + ", toTinyId = " + paramString2 + ", time = " + NetConnInfoCenter.getServerTime());
    }
    return localUinToTinyId.friendUin;
  }
  
  private UinToTinyId a(String paramString)
  {
    return (UinToTinyId)findCache(paramString);
  }
  
  private void doInit()
  {
    do
    {
      try
      {
        this.fw.clear();
        this.cacheMap.clear();
        Object localObject1 = this.app.a().createEntityManager();
        localObject2 = ((EntityManager)localObject1).query(UinToTinyId.class);
        ((EntityManager)localObject1).close();
        if (localObject2 != null)
        {
          clearCache();
          localObject1 = ((List)localObject2).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (UinToTinyId)((Iterator)localObject1).next();
            this.cacheMap.put(((UinToTinyId)localObject2).tinyId, localObject2);
          }
        }
        localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sp_name_tinyid_uin_mapping", 0);
      }
      catch (Exception localException)
      {
        QLog.d("Q.tiny_msg.TinyIdCache", 1, "doInit occur error", localException);
        return;
      }
      SharedPreferences localSharedPreferences;
      Object localObject2 = this.app.getCurrentAccountUin();
      this.aaU = localSharedPreferences.getLong("key_last_uin_consume_" + (String)localObject2, 9223372036854775807L);
    } while (!QLog.isColorLevel());
    QLog.d("Q.tiny_msg.TinyIdCache", 2, "doInit size = " + this.cacheMap.size() + ", lastUinConsume = " + this.aaU);
  }
  
  private void dqa()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sp_name_tinyid_uin_mapping", 0);
    String str = this.app.getCurrentAccountUin();
    localSharedPreferences.edit().putLong("key_last_uin_consume_" + str, this.aaU).apply();
    if (QLog.isColorLevel()) {
      QLog.d("Q.tiny_msg.TinyIdCache", 2, "persistLastConsumeId lastUinConsume = " + this.aaU);
    }
  }
  
  /* Error */
  public String bb(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 40	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +12 -> 18
    //   9: aload_2
    //   10: invokestatic 40	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: istore_3
    //   14: iload_3
    //   15: ifeq +9 -> 24
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: areturn
    //   24: aload_0
    //   25: aload_1
    //   26: aload_2
    //   27: new 54	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   34: aload_1
    //   35: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_2
    //   39: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 230	ahtg:E	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   48: astore_1
    //   49: goto -29 -> 20
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	ahtg
    //   0	57	1	paramString1	String
    //   0	57	2	paramString2	String
    //   13	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	52	finally
    //   24	49	52	finally
  }
  
  public Pair<String, String> c(String paramString)
  {
    Object localObject2 = null;
    Object localObject1;
    if (this.fw.containsKey(paramString)) {
      localObject1 = (Pair)this.fw.get(paramString);
    }
    for (;;)
    {
      if ((QLog.isColorLevel()) && (localObject1 != null)) {
        QLog.d("Q.tiny_msg.TinyIdCache", 2, "findTinyId  from cache fromTinyId = " + (String)((Pair)localObject1).first + ", toTinyId = " + (String)((Pair)localObject1).second);
      }
      return localObject1;
      Iterator localIterator = this.cacheMap.values().iterator();
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (UinToTinyId)localIterator.next();
      } while (!TextUtils.equals(((UinToTinyId)localObject1).friendUin, paramString));
      localObject1 = new Pair(((UinToTinyId)localObject1).fromTinyId, ((UinToTinyId)localObject1).toTinyId);
      this.fw.put(paramString, localObject1);
    }
  }
  
  public void clearCache()
  {
    this.cacheMap.clear();
    this.fw.clear();
  }
  
  public void destroy()
  {
    clearCache();
  }
  
  public String getKey(Entity paramEntity)
  {
    return ((UinToTinyId)paramEntity).tinyId;
  }
  
  public String lq(String paramString)
  {
    String str = "";
    Pair localPair = c(paramString);
    paramString = str;
    if (localPair != null) {
      paramString = (String)localPair.first;
    }
    return paramString;
  }
  
  public void onDestroy()
  {
    destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahtg
 * JD-Core Version:    0.7.0.1
 */