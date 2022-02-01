import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class ajdr
  extends Observable
  implements Manager
{
  protected QQAppInterface app;
  private boolean cnD;
  private boolean cnE;
  public boolean cnF;
  protected ConcurrentHashMap<Long, TroopAppInfo> fP;
  protected ConcurrentHashMap<String, ArrayList<Long>> fQ;
  protected ConcurrentHashMap<Long, apbo> fR;
  protected ConcurrentHashMap<String, aozx> fS;
  protected LruCache<String, String> z;
  
  /* Error */
  public ajdr(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 29	java/util/Observable:<init>	()V
    //   4: aload_0
    //   5: new 31	java/util/concurrent/ConcurrentHashMap
    //   8: dup
    //   9: invokespecial 32	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   12: putfield 34	ajdr:fS	Ljava/util/concurrent/ConcurrentHashMap;
    //   15: aload_0
    //   16: aload_1
    //   17: putfield 36	ajdr:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: aload_0
    //   21: getfield 38	ajdr:fP	Ljava/util/concurrent/ConcurrentHashMap;
    //   24: ifnonnull +25 -> 49
    //   27: aload_0
    //   28: monitorenter
    //   29: aload_0
    //   30: getfield 38	ajdr:fP	Ljava/util/concurrent/ConcurrentHashMap;
    //   33: ifnonnull +14 -> 47
    //   36: aload_0
    //   37: new 31	java/util/concurrent/ConcurrentHashMap
    //   40: dup
    //   41: invokespecial 32	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   44: putfield 38	ajdr:fP	Ljava/util/concurrent/ConcurrentHashMap;
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_0
    //   50: getfield 40	ajdr:fQ	Ljava/util/concurrent/ConcurrentHashMap;
    //   53: ifnonnull +25 -> 78
    //   56: aload_0
    //   57: monitorenter
    //   58: aload_0
    //   59: getfield 40	ajdr:fQ	Ljava/util/concurrent/ConcurrentHashMap;
    //   62: ifnonnull +14 -> 76
    //   65: aload_0
    //   66: new 31	java/util/concurrent/ConcurrentHashMap
    //   69: dup
    //   70: invokespecial 32	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   73: putfield 40	ajdr:fQ	Ljava/util/concurrent/ConcurrentHashMap;
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_0
    //   79: getfield 42	ajdr:z	Landroid/support/v4/util/LruCache;
    //   82: ifnonnull +27 -> 109
    //   85: aload_0
    //   86: monitorenter
    //   87: aload_0
    //   88: getfield 42	ajdr:z	Landroid/support/v4/util/LruCache;
    //   91: ifnonnull +16 -> 107
    //   94: aload_0
    //   95: new 44	android/support/v4/util/LruCache
    //   98: dup
    //   99: bipush 10
    //   101: invokespecial 47	android/support/v4/util/LruCache:<init>	(I)V
    //   104: putfield 42	ajdr:z	Landroid/support/v4/util/LruCache;
    //   107: aload_0
    //   108: monitorexit
    //   109: return
    //   110: astore_1
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_1
    //   114: athrow
    //   115: astore_1
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_1
    //   119: athrow
    //   120: astore_1
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_1
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	ajdr
    //   0	125	1	paramQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   29	47	110	finally
    //   47	49	110	finally
    //   111	113	110	finally
    //   58	76	115	finally
    //   76	78	115	finally
    //   116	118	115	finally
    //   87	107	120	finally
    //   107	109	120	finally
    //   121	123	120	finally
  }
  
  public void LQ(boolean paramBoolean)
  {
    this.cnD = paramBoolean;
  }
  
  public void LR(boolean paramBoolean)
  {
    this.cnE = paramBoolean;
  }
  
  public ArrayList<Long> P(String paramString)
  {
    return (ArrayList)this.fQ.get(paramString);
  }
  
  public aozx a(String paramString)
  {
    return (aozx)this.fS.get(paramString);
  }
  
  public aozx a(String paramString, aozx paramaozx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfoManager_At_Me_DISC", 2, "messageInfoMap: update__:" + paramString + " " + paramaozx.b(this.app, true, paramString) + " " + paramaozx.aAH() + " " + paramaozx.getShmsgseq());
    }
    aozx localaozx2 = (aozx)this.fS.get(paramString);
    aozx localaozx1 = localaozx2;
    if (paramaozx != null)
    {
      if (paramaozx.aAH()) {
        break label105;
      }
      localaozx1 = localaozx2;
    }
    label105:
    do
    {
      do
      {
        return localaozx1;
        if (localaozx2 != null) {
          break;
        }
        paramaozx = new aozx(paramaozx);
        this.fS.put(paramString, paramaozx);
        localaozx1 = paramaozx;
      } while (!QLog.isColorLevel());
      QLog.d("TroopInfoManager_At_Me_DISC", 2, "messageInfoMap: put:" + paramString);
      return paramaozx;
      localaozx2.a(paramaozx);
      localaozx1 = localaozx2;
    } while (!QLog.isColorLevel());
    QLog.d("TroopInfoManager_At_Me_DISC", 2, "messageInfoMap: update:" + paramString);
    return localaozx2;
  }
  
  public apbo a(Long paramLong, boolean paramBoolean)
  {
    if (this.fR == null) {
      this.fR = new ConcurrentHashMap();
    }
    apbo localapbo2 = (apbo)this.fR.get(paramLong);
    apbo localapbo1 = localapbo2;
    if (localapbo2 == null)
    {
      localapbo1 = localapbo2;
      if (paramBoolean)
      {
        localapbo1 = new apbo(this.app, paramLong);
        this.fR.put(paramLong, localapbo1);
      }
    }
    return localapbo1;
  }
  
  public void a(Long paramLong, TroopAppInfo paramTroopAppInfo)
  {
    this.fP.put(paramLong, paramTroopAppInfo);
  }
  
  public ArrayList<TroopAppInfo> aj(ArrayList<Long> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject = (Long)paramArrayList.next();
        localObject = (TroopAppInfo)this.fP.get(localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public boolean aqu()
  {
    return this.cnD;
  }
  
  public boolean aqv()
  {
    return this.cnE;
  }
  
  public aozx b(String paramString)
  {
    return (aozx)this.fS.remove(paramString);
  }
  
  public void b(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.cnF = paramBoolean;
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext = paramString2;
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext = paramString2 + "_" + paramString1;
    }
    localEditor.putBoolean(paramContext, paramBoolean);
    localEditor.apply();
  }
  
  public void h(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    this.z.put(paramString, aqgo.encodeToString(paramArrayOfByte, 2));
  }
  
  public void n(Long paramLong)
  {
    if (this.fR == null) {
      return;
    }
    this.fR.remove(paramLong);
  }
  
  public void onDestroy()
  {
    if (this.fR != null)
    {
      Iterator localIterator = this.fR.values().iterator();
      while (localIterator.hasNext())
      {
        apbo localapbo = (apbo)localIterator.next();
        if (localapbo != null) {
          localapbo.deleteObservers();
        }
      }
      this.fR.clear();
    }
  }
  
  public byte[] r(String paramString)
  {
    paramString = (String)this.z.get(paramString);
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = aqgo.decode(paramString, 0);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public void x(String paramString, ArrayList<Long> paramArrayList)
  {
    this.fQ.put(paramString, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajdr
 * JD-Core Version:    0.7.0.1
 */