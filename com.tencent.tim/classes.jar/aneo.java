import NS_UNDEAL_COUNT.entrance_cfg;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.ContentObserver;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.config.provider.QZoneConfigProvider;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.servlet.QZoneManagerImp.2;
import com.tencent.mobileqq.servlet.QZoneManagerImp.3;
import com.tencent.mobileqq.servlet.QZoneManagerImp.4;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class aneo
  implements ajdp
{
  private static boolean cFb = true;
  public ArrayList<entrance_cfg> Aq = new ArrayList();
  public ConcurrentHashMap<Integer, avsd> T;
  private volatile Boolean aB = null;
  private QQAppInterface app;
  private boolean cEY;
  private boolean cEZ = true;
  private boolean cFa;
  private int dFf = 1;
  private ContentObserver e;
  private HashMap<String, Long> nl = new HashMap();
  public HashMap<String, Object> nm = new HashMap();
  private long type;
  
  public aneo(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    if (this.e == null) {
      this.e = new anep(this, null);
    }
    try
    {
      if (!this.cEY) {
        paramQQAppInterface.getApplication().getContentResolver().registerContentObserver(sxe.u, true, this.e);
      }
      ThreadManager.post(new QZoneManagerImp.2(this, paramQQAppInterface), 8, null, true);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        f(localException);
      }
    }
  }
  
  private void b(int paramInt, avsd paramavsd)
  {
    if ((paramavsd == null) || (this.app == null)) {
      return;
    }
    ThreadManager.post(new QZoneManagerImp.3(this, new avsd(paramavsd), paramInt), 5, null, false);
  }
  
  private boolean bA(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return LocalMultiProcConfig.getBool(paramQQAppInterface.getApp().getApplicationContext().getString(2131718976) + paramQQAppInterface.getAccount(), true);
  }
  
  /* Error */
  private void dPa()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 178	aneo:T	Ljava/util/concurrent/ConcurrentHashMap;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: new 180	java/util/concurrent/ConcurrentHashMap
    //   13: dup
    //   14: invokespecial 181	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   17: putfield 178	aneo:T	Ljava/util/concurrent/ConcurrentHashMap;
    //   20: aload_0
    //   21: getfield 178	aneo:T	Ljava/util/concurrent/ConcurrentHashMap;
    //   24: invokevirtual 184	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   27: aload_0
    //   28: getfield 63	aneo:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   31: invokevirtual 78	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   34: invokevirtual 84	mqq/app/MobileQQ:getContentResolver	()Landroid/content/ContentResolver;
    //   37: getstatic 187	com/tencent/common/config/provider/QZoneConfigProvider:u	Landroid/net/Uri;
    //   40: aconst_null
    //   41: ldc 189
    //   43: iconst_1
    //   44: anewarray 191	java/lang/String
    //   47: dup
    //   48: iconst_0
    //   49: aload_0
    //   50: getfield 63	aneo:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   53: invokevirtual 194	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   56: aastore
    //   57: aconst_null
    //   58: invokestatic 200	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   61: astore_1
    //   62: aload_1
    //   63: astore_2
    //   64: aload_2
    //   65: astore_1
    //   66: aload_2
    //   67: invokestatic 203	avsd:a	(Landroid/database/Cursor;)Ljava/util/HashMap;
    //   70: astore_3
    //   71: aload_3
    //   72: ifnull +13 -> 85
    //   75: aload_2
    //   76: astore_1
    //   77: aload_0
    //   78: getfield 178	aneo:T	Ljava/util/concurrent/ConcurrentHashMap;
    //   81: aload_3
    //   82: invokevirtual 207	java/util/concurrent/ConcurrentHashMap:putAll	(Ljava/util/Map;)V
    //   85: aload_2
    //   86: ifnull +18 -> 104
    //   89: aload_2
    //   90: invokeinterface 213 1 0
    //   95: ifne +9 -> 104
    //   98: aload_2
    //   99: invokeinterface 216 1 0
    //   104: return
    //   105: astore_3
    //   106: aconst_null
    //   107: astore_2
    //   108: aload_2
    //   109: astore_1
    //   110: aload_0
    //   111: aload_3
    //   112: invokevirtual 111	aneo:f	(Ljava/lang/Exception;)V
    //   115: aload_2
    //   116: ifnull -12 -> 104
    //   119: aload_2
    //   120: invokeinterface 213 1 0
    //   125: ifne -21 -> 104
    //   128: aload_2
    //   129: invokeinterface 216 1 0
    //   134: return
    //   135: astore_1
    //   136: aload_2
    //   137: ifnull +18 -> 155
    //   140: aload_2
    //   141: invokeinterface 213 1 0
    //   146: ifne +9 -> 155
    //   149: aload_2
    //   150: invokeinterface 216 1 0
    //   155: aload_1
    //   156: athrow
    //   157: astore_3
    //   158: aload_1
    //   159: astore_2
    //   160: aload_3
    //   161: astore_1
    //   162: goto -26 -> 136
    //   165: astore_3
    //   166: goto -58 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	aneo
    //   61	49	1	localObject1	Object
    //   135	24	1	localObject2	Object
    //   161	1	1	localObject3	Object
    //   1	159	2	localObject4	Object
    //   70	12	3	localHashMap	HashMap
    //   105	7	3	localException1	Exception
    //   157	4	3	localObject5	Object
    //   165	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   27	62	105	java/lang/Exception
    //   27	62	135	finally
    //   66	71	157	finally
    //   77	85	157	finally
    //   110	115	157	finally
    //   66	71	165	java/lang/Exception
    //   77	85	165	java/lang/Exception
  }
  
  private void dPb()
  {
    for (;;)
    {
      int i;
      try
      {
        if (this.T != null)
        {
          if (this.T.isEmpty()) {
            return;
          }
          avsd[] arrayOfavsd = (avsd[])this.T.values().toArray(new avsd[this.T.size()]);
          Integer[] arrayOfInteger = (Integer[])this.T.keySet().toArray(new Integer[this.T.size()]);
          ContentValues[] arrayOfContentValues = new ContentValues[arrayOfavsd.length];
          i = 0;
          if (i < arrayOfavsd.length)
          {
            if (this.app == null) {
              break label186;
            }
            String str = this.app.getAccount();
            if ((str == null) || (str.length() <= 0)) {
              break label186;
            }
            arrayOfContentValues[i] = arrayOfavsd[i].b();
            arrayOfContentValues[i].put("own_uin", str);
            arrayOfContentValues[i].put("type", arrayOfInteger[i]);
            break label186;
          }
          if (this.app != null)
          {
            this.app.getApplication().getContentResolver().bulkInsert(QZoneConfigProvider.u, arrayOfContentValues);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        f(localException);
      }
      return;
      label186:
      i += 1;
    }
  }
  
  private long gT()
  {
    if (this.T != null)
    {
      Iterator localIterator = this.T.keySet().iterator();
      for (long l1 = 0L;; l1 = 1L << ((Integer)localIterator.next()).intValue() | l1)
      {
        l2 = l1;
        if (!localIterator.hasNext()) {
          break;
        }
      }
    }
    long l2 = 0L;
    return l2;
  }
  
  public void G(HashMap<Integer, avsd> paramHashMap)
  {
    for (;;)
    {
      int j;
      int i;
      boolean bool;
      try
      {
        if (this.cFa)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("ZebraAlbum.QZoneManagerImp.", 4, "setFeedCount.user enter qzone.dismiss data.");
          }
        }
        else if ((paramHashMap != null) && (paramHashMap.size() != 0) && (this.app != null))
        {
          paramHashMap = paramHashMap.entrySet().toArray();
          if (paramHashMap == null) {
            break label329;
          }
          int m = paramHashMap.length;
          j = 0;
          i = 0;
          k = i;
          if (j < m)
          {
            Integer localInteger = paramHashMap[j];
            if ((localInteger != null) && ((localInteger instanceof Map.Entry)))
            {
              Object localObject = (Map.Entry)localInteger;
              localInteger = (Integer)((Map.Entry)localObject).getKey();
              localObject = (avsd)((Map.Entry)localObject).getValue();
              if (!bA(this.app))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FeedAlert.", 2, "QZoneManagerImp.checkShowQZonePush" + Long.toBinaryString(this.type) + ",count" + ((avsd)localObject).uCount);
                }
                if (localInteger.intValue() == 17) {
                  break label303;
                }
              }
              bool = b(localInteger.intValue(), (avsd)localObject);
              if ((!bool) || (!QLog.isColorLevel())) {
                break label310;
              }
              QLog.d("FeedAlert.", 2, "QZoneManagerImp.set feedcout map type:" + Long.toBinaryString(this.type) + "count change ,key=" + localInteger);
              break label310;
            }
          }
          else
          {
            if (k == 0) {
              break label302;
            }
            dPb();
            return;
          }
        }
      }
      catch (Exception paramHashMap)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("QZoneManagerImp.", 2, paramHashMap.toString());
          return;
        }
      }
      label302:
      return;
      for (;;)
      {
        label303:
        j += 1;
        break;
        label310:
        if ((i != 0) || (bool)) {
          i = 1;
        } else {
          i = 0;
        }
      }
      label329:
      int k = 0;
    }
  }
  
  public int Gh()
  {
    int j = 0;
    int i = 0;
    if (this.app == null) {
      j = i;
    }
    do
    {
      return j;
      SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("Qzone_Get_UndealCount_FLAG", 0);
      String str = this.app.getAccount();
      i = j;
      if (str != null)
      {
        i = j;
        if (str.length() > 0) {
          i = localSharedPreferences.getInt(str, 0);
        }
      }
      j = i;
    } while (!QLog.isColorLevel());
    QLog.d("QZoneManagerImp.", 2, "getGetUndealCountFlag:" + i);
    return i;
  }
  
  public void LO(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneManagerImp.", 2, "setEnterQZone.isenter=" + paramBoolean);
    }
    this.cFa = paramBoolean;
  }
  
  public void LP(boolean paramBoolean)
  {
    this.aB = Boolean.valueOf(paramBoolean);
  }
  
  public void QC(int paramInt)
  {
    if ((this.cEZ) || (paramInt <= 0)) {}
    do
    {
      for (;;)
      {
        return;
        if ((this.app != null) && (this.app.getApplication() != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QZoneManagerImp..UndealCount", 2, "sendGetFeedByTime. by servlet. type:" + paramInt);
          }
          if (paramInt == 2) {
            try
            {
              NewIntent localNewIntent1 = new NewIntent(this.app.getApplication(), aneq.class);
              localNewIntent1.setAction("Qzone_Get_NewAndUnread_Count");
              localNewIntent1.putExtra("qzone_send_by_time", paramInt);
              localNewIntent1.putExtra("scene", 103);
              this.app.startServlet(localNewIntent1);
              if (QLog.isColorLevel())
              {
                QLog.i("QZoneManagerImp..UndealCount", 2, "sendGetFeedByTime.switch to forground.");
                return;
              }
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              return;
            }
          }
        }
      }
      if (paramInt == 3)
      {
        ThreadManager.post(new QZoneManagerImp.4(this, paramInt), 8, null, true);
        return;
      }
    } while ((paramInt != 5) && (paramInt != 6) && (paramInt != 7) && (paramInt != 8));
    NewIntent localNewIntent2 = new NewIntent(this.app.getApplication(), aneq.class);
    localNewIntent2.setAction("Qzone_Get_NewAndUnread_Count");
    localNewIntent2.putExtra("qzone_send_by_time", paramInt);
    if ((paramInt == 5) || (paramInt == 6)) {
      localNewIntent2.putExtra("scene", 100);
    }
    for (;;)
    {
      this.app.startServlet(localNewIntent2);
      return;
      if ((paramInt == 7) || (paramInt == 8)) {
        localNewIntent2.putExtra("scene", 104);
      }
    }
  }
  
  @TargetApi(9)
  public void QD(int paramInt)
  {
    if (this.app == null) {}
    for (;;)
    {
      return;
      SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences("Qzone_Get_UndealCount_FLAG", 0).edit();
      String str = this.app.getAccount();
      if ((str != null) && (str.length() > 0)) {
        localEditor.putInt(str, paramInt);
      }
      if (Build.VERSION.SDK_INT < 9) {
        localEditor.commit();
      }
      while (QLog.isColorLevel())
      {
        QLog.d("QZoneManagerImp.", 2, "setGetUndealCountFlag:" + paramInt);
        return;
        localEditor.apply();
      }
    }
  }
  
  public void UJ(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QZoneManagerImp.", 4, "QZoneManagerImp clearUnReadCount cache arrays.type = " + paramInt);
    }
    if (this.T != null) {
      this.T.remove(Integer.valueOf(paramInt));
    }
    StringBuilder localStringBuilder = new StringBuilder("own_uin").append("=? AND ").append("type").append("=?");
    String str = this.app.getCurrentAccountUin();
    try
    {
      this.app.getApplication().getContentResolver().delete(sxe.u, localStringBuilder.toString(), new String[] { str, String.valueOf(paramInt) });
      return;
    }
    catch (Exception localException)
    {
      f(localException);
    }
  }
  
  public boolean a(int paramInt, long paramLong, ArrayList<QZoneCountUserInfo> paramArrayList, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    QLog.i("QZoneManagerImp.", 1, "qzone redtypeinfo:setFeedCount.feedtype=" + paramInt + ",count=" + paramLong + ",uin");
    if ((paramInt < 1) || (paramInt > 1010)) {
      return false;
    }
    if (this.T == null) {
      this.T = new ConcurrentHashMap();
    }
    avsd localavsd = new avsd();
    localavsd.uCount = paramLong;
    localavsd.ES = paramArrayList;
    localavsd.doA = paramBoolean1;
    localavsd.cNm = paramString1;
    if (!TextUtils.isEmpty(paramString2)) {
      localavsd.schema = paramString2;
    }
    paramBoolean1 = false;
    paramArrayList = (avsd)this.T.get(Integer.valueOf(paramInt));
    if (!localavsd.a(paramArrayList)) {
      paramBoolean1 = true;
    }
    if (paramBoolean1)
    {
      if ((paramLong > 0L) && (paramArrayList != null) && (paramArrayList.ES != null) && (localavsd != null) && (localavsd.ES != null) && (localavsd.ES.size() > 0))
      {
        paramString1 = localavsd.ES.iterator();
        if (paramString1.hasNext())
        {
          paramString2 = (QZoneCountUserInfo)paramString1.next();
          int i = 0;
          for (;;)
          {
            if ((i >= paramArrayList.ES.size()) || (((QZoneCountUserInfo)paramArrayList.ES.get(i)).uin == paramString2.uin))
            {
              if ((i == -1) || (i >= paramArrayList.ES.size())) {
                break;
              }
              paramArrayList.ES.remove(i);
              break;
            }
            i += 1;
          }
        }
        localavsd.ES.addAll(paramArrayList.ES);
      }
      this.T.put(Integer.valueOf(paramInt), localavsd);
      b(paramInt, localavsd);
    }
    return paramBoolean1;
  }
  
  public void an(int paramInt1, int paramInt2)
  {
    try
    {
      l = Long.parseLong(this.app.getAccount());
      if (l > 0L) {
        LocalMultiProcConfig.putInt4Uin("mine_message_count", paramInt2, l);
      }
      if (QLog.isColorLevel()) {
        QLog.d("QZoneManagerImp.", 2, "setPushCount type:" + paramInt1 + ",count" + paramInt2);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        f(localException);
        long l = 0L;
      }
    }
  }
  
  public boolean aqs()
  {
    return this.cEZ;
  }
  
  public boolean aqt()
  {
    boolean bool = true;
    if (this.aB == null) {
      if ((LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, this.app.getLongAccountUin()) & 0x80) == 0) {
        break label43;
      }
    }
    for (;;)
    {
      LP(bool);
      return this.aB.booleanValue();
      label43:
      bool = false;
    }
  }
  
  public avsd b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneManagerImp.", 2, "QZoneManagerImp getFeedCount type :" + paramInt);
    }
    if (this.T != null) {
      return (avsd)this.T.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public boolean b(int paramInt, avsd paramavsd)
  {
    boolean bool2;
    if (paramavsd == null)
    {
      QZLog.e("QZoneManagerImp.", "saveCountInfoInMemIfChanged qZoneCountInfo == null");
      bool2 = false;
      return bool2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneManagerImp.", 2, "setFeedCountAll.feedtype=" + paramInt + ",count=" + paramavsd.uCount + ",uin");
    }
    if ((paramInt < 1) || (paramInt > 1010)) {
      return false;
    }
    if (this.T == null) {
      this.T = new ConcurrentHashMap();
    }
    if (!paramavsd.a((avsd)this.T.get(Integer.valueOf(paramInt)))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      this.T.put(Integer.valueOf(paramInt), paramavsd);
      return bool1;
    }
  }
  
  public ArrayList<String> dF()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.T != null)
    {
      Object localObject = (avsd)this.T.get(Integer.valueOf(2));
      if ((localObject != null) && (((avsd)localObject).ES != null) && (((avsd)localObject).ES.size() > 0))
      {
        Iterator localIterator = ((avsd)localObject).ES.iterator();
        while (localIterator.hasNext())
        {
          localObject = (QZoneCountUserInfo)localIterator.next();
          if ((localObject != null) && (((QZoneCountUserInfo)localObject).uin >= 10000L))
          {
            localArrayList.add(String.valueOf(((QZoneCountUserInfo)localObject).uin));
          }
          else
          {
            if (localObject == null) {}
            for (localObject = "userInfo==null";; localObject = "userInfo,uin<10000,不是合法qq号")
            {
              QLog.w("UndealCount.QZoneManagerImp.", 1, (String)localObject);
              break;
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void dwq()
  {
    if (this.app == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), anes.class);
    localNewIntent.putExtra("key_uin", this.app.getAccount());
    localNewIntent.putExtra("lastPushMsgTime", aneb.o(this.app));
    this.app.startServlet(localNewIntent);
  }
  
  public void f(Exception paramException)
  {
    if (this.app == null)
    {
      QZLog.e("QZoneManagerImp.", "handleException app == null");
      return;
    }
    String str;
    if ((paramException instanceof IllegalArgumentException)) {
      if ((paramException.getMessage() != null) && (paramException.getMessage().contains("Unknown URI"))) {
        str = "0";
      }
    }
    for (;;)
    {
      QLog.e("QZoneManagerImp.", 1, paramException, new Object[0]);
      HashMap localHashMap = new HashMap();
      localHashMap.put("exception", paramException.getClass().getSimpleName());
      localHashMap.put("type", str);
      localHashMap.put("msg", paramException.getMessage());
      anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getAccount(), "qzoneconfigdberror", true, 0L, 0L, localHashMap, null, true);
      awcz.h(paramException, "QZoneConfigProvider error");
      return;
      str = "1";
      continue;
      str = "2";
    }
  }
  
  public void gH(String paramString1, String paramString2)
  {
    if (this.app == null) {
      return;
    }
    if (this.dFf != 0)
    {
      paramString1 = new NewIntent(this.app.getApplication(), aneq.class);
      paramString1.setAction("Qzone_Get_NewAndUnread_Count");
      paramString1.putExtra("qzone_send_by_time", 1);
      paramString1.putExtra("scene", 100);
      this.app.startServlet(paramString1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneManagerImp.", 2, "sendGetFeedCount");
    }
    this.cEZ = false;
  }
  
  public int jn(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneManagerImp.", 2, "QZoneManagerImp getFeedCount type :" + paramInt);
    }
    if (this.T != null)
    {
      avsd localavsd = (avsd)this.T.get(Integer.valueOf(paramInt));
      if (localavsd != null) {
        return (int)localavsd.uCount;
      }
    }
    return 0;
  }
  
  public void lm(long paramLong)
  {
    if (this.app == null) {}
    for (;;)
    {
      return;
      try
      {
        NewIntent localNewIntent = new NewIntent(this.app.getApplication(), aneq.class);
        localNewIntent.setAction("Qzone_Refresh_UI");
        localNewIntent.putExtra("notify_type", paramLong);
        if ((!this.cEY) && (this.app != null))
        {
          this.app.startServlet(localNewIntent);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QZoneManagerImp.", 1, "", localThrowable);
      }
    }
  }
  
  public void onDestroy()
  {
    this.cEY = true;
    if (this.e != null)
    {
      this.app.getApplication().getContentResolver().unregisterContentObserver(this.e);
      this.e = null;
    }
    if (this.T != null) {
      this.T.clear();
    }
    this.app = null;
    this.cEY = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aneo
 * JD-Core Version:    0.7.0.1
 */