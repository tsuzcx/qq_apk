import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.LruCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.multicard.MultiCardManager.1;
import com.tencent.mobileqq.multicard.MultiCardManager.2;
import com.tencent.mobileqq.multicard.MultiCardManager.3;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;

public class ajjz
  implements Manager
{
  private boolean RD = true;
  private ajjz.d jdField_a_of_type_Ajjz$d;
  private ajjz.e jdField_a_of_type_Ajjz$e;
  private ajjz.f jdField_a_of_type_Ajjz$f;
  private long acU;
  private ahpl b;
  private HashMap<Long, WeakReference<ajjz.c>> lu = new HashMap(5);
  private HashMap<Long, WeakReference<ajjz.a>> lv = new HashMap(20);
  private HashMap<Long, Boolean> lw = new HashMap(200);
  private HashMap<Long, WeakReference<ajjz.b>> lx = new HashMap(5);
  private HashMap<Long, ArrayList<Long>> ly = new HashMap(5);
  private HashMap<Long, ArrayList<Long>> lz = new HashMap(5);
  private QQAppInterface mApp;
  private LruCache<Long, IntimateInfo> v = new LruCache(200);
  
  public ajjz(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.b = ((ahpl)this.mApp.getManager(323));
  }
  
  private void a(long paramLong, ajjz.c paramc)
  {
    ThreadManager.getSubThreadHandler().post(new MultiCardManager.3(this, paramLong, paramc));
  }
  
  private void a(long paramLong, ArrayList<Long> paramArrayList, ajjz.a parama)
  {
    ThreadManager.getSubThreadHandler().post(new MultiCardManager.2(this, paramLong, paramArrayList, parama));
  }
  
  private void a(long paramLong, ArrayList<Long> paramArrayList, ajjz.b paramb)
  {
    ThreadManager.getSubThreadHandler().post(new MultiCardManager.1(this, paramArrayList, paramLong, paramb));
  }
  
  /* Error */
  private ArrayList<Long> m(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 80	ajjz:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 148	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: ldc 150
    //   9: iconst_0
    //   10: invokevirtual 156	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   13: new 158	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   20: aload_0
    //   21: getfield 80	ajjz:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   24: invokevirtual 163	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   27: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 169
    //   32: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: lload_1
    //   36: invokevirtual 172	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   39: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: ldc 177
    //   44: invokeinterface 183 3 0
    //   49: astore 5
    //   51: aload 5
    //   53: invokestatic 189	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifne +125 -> 181
    //   59: new 191	org/json/JSONArray
    //   62: dup
    //   63: aload 5
    //   65: invokespecial 194	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   68: astore 7
    //   70: new 196	java/util/ArrayList
    //   73: dup
    //   74: aload 7
    //   76: invokevirtual 200	org/json/JSONArray:length	()I
    //   79: invokespecial 201	java/util/ArrayList:<init>	(I)V
    //   82: astore 5
    //   84: aload 7
    //   86: invokevirtual 200	org/json/JSONArray:length	()I
    //   89: istore 4
    //   91: iconst_0
    //   92: istore_3
    //   93: aload 5
    //   95: astore 6
    //   97: iload_3
    //   98: iload 4
    //   100: if_icmpge +73 -> 173
    //   103: aload 5
    //   105: aload 7
    //   107: iload_3
    //   108: invokevirtual 205	org/json/JSONArray:optLong	(I)J
    //   111: invokestatic 211	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   114: invokevirtual 215	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   117: pop
    //   118: iload_3
    //   119: iconst_1
    //   120: iadd
    //   121: istore_3
    //   122: goto -29 -> 93
    //   125: astore 7
    //   127: aconst_null
    //   128: astore 5
    //   130: aload 5
    //   132: astore 6
    //   134: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq +36 -> 173
    //   140: ldc 223
    //   142: iconst_2
    //   143: new 158	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   150: ldc 225
    //   152: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload 7
    //   157: invokevirtual 226	org/json/JSONException:toString	()Ljava/lang/String;
    //   160: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 229	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: aload 5
    //   171: astore 6
    //   173: aload 6
    //   175: areturn
    //   176: astore 7
    //   178: goto -48 -> 130
    //   181: aconst_null
    //   182: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	ajjz
    //   0	183	1	paramLong	long
    //   92	30	3	i	int
    //   89	12	4	j	int
    //   49	121	5	localObject1	Object
    //   95	79	6	localObject2	Object
    //   68	38	7	localJSONArray	JSONArray
    //   125	31	7	localJSONException1	org.json.JSONException
    //   176	1	7	localJSONException2	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   59	84	125	org/json/JSONException
    //   84	91	176	org/json/JSONException
    //   103	118	176	org/json/JSONException
  }
  
  public IntimateInfo a(long paramLong1, long paramLong2)
  {
    IntimateInfo localIntimateInfo2 = (IntimateInfo)this.v.get(Long.valueOf(paramLong2));
    IntimateInfo localIntimateInfo1 = localIntimateInfo2;
    if (localIntimateInfo2 == null)
    {
      String str = IntimateInfo.convertUinKeyForGroupCard(paramLong1 + "", paramLong2 + "");
      localIntimateInfo2 = this.b.a(str);
      localIntimateInfo1 = localIntimateInfo2;
      if (localIntimateInfo2 != null)
      {
        localIntimateInfo2.friendUin = IntimateInfo.getUinFromGroupCardKey(str);
        localIntimateInfo1 = localIntimateInfo2;
      }
    }
    return localIntimateInfo1;
  }
  
  public HashMap<Long, IntimateInfo> a(long paramLong, ArrayList<Long> paramArrayList)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("getIntimateInfoListCache, uinList: ");
      if (paramArrayList == null) {
        break label131;
      }
    }
    label131:
    for (Object localObject1 = paramArrayList.toString();; localObject1 = "null")
    {
      QLog.d("MultiCardManager", 2, (String)localObject1 + " " + paramLong);
      if (paramArrayList == null) {
        break label142;
      }
      localObject1 = new HashMap(paramArrayList.size() * 2);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject2 = (Long)paramArrayList.next();
        IntimateInfo localIntimateInfo = a(paramLong, ((Long)localObject2).longValue());
        if (localIntimateInfo != null) {
          ((HashMap)localObject1).put(localObject2, localIntimateInfo);
        }
      }
    }
    return localObject1;
    label142:
    return null;
  }
  
  public void a(Context paramContext, long paramLong, ArrayList<Long> arg4, ajjz.a parama)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder().append("getGroupIntimateInfoList, uinList: ").append(paramLong).append(" ");
      if (??? == null) {
        break label94;
      }
    }
    label94:
    for (Object localObject1 = ???.toString();; localObject1 = "null")
    {
      QLog.d("MultiCardManager", 2, (String)localObject1);
      if ((this.mApp != null) && (parama != null) && (??? != null))
      {
        if (aqiw.isNetSupport(paramContext)) {
          break;
        }
        a(paramLong, ???, parama);
      }
      return;
    }
    localObject1 = new ArrayList(???.size());
    paramContext = new ArrayList(???.size());
    Iterator localIterator = ???.iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      if ((IntimateInfo)this.v.get(localLong) != null) {
        ((ArrayList)localObject1).add(localLong);
      } else {
        for (;;)
        {
          synchronized (this.lw)
          {
            if (!this.lw.containsKey(localLong))
            {
              paramContext.add(localLong);
              this.lw.put(localLong, Boolean.TRUE);
            }
          }
          ((ArrayList)localObject1).add(localLong);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardManager", 2, "getGroupIntimateInfoList  alreadyRequest: " + ((ArrayList)localObject1).toString() + " notRequest:" + paramContext.toString());
    }
    if (paramContext.isEmpty())
    {
      a(paramLong, ???, parama);
      return;
    }
    a(paramLong, ???, parama);
    parama = new WeakReference(parama);
    synchronized (this.lv)
    {
      this.lv.put(Long.valueOf(paramLong), parama);
      ??? = new HashMap(5);
      ???.put("alreadyRequest", localObject1);
      ???.put("notRequest", paramContext);
      parama = new ArrayList(1);
      parama.add(Long.valueOf(paramLong));
      ???.put("groupUin", parama);
      ((ahpj)this.mApp.getBusinessHandler(153)).a(paramLong, paramContext, ???);
      return;
    }
  }
  
  public void a(Context arg1, long paramLong, ArrayList<Long> paramArrayList, ajjz.b paramb)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("getGroupMemberNick, uinList: ").append(paramLong).append(" ");
      if (paramArrayList == null) {
        break label94;
      }
    }
    label94:
    for (Object localObject1 = paramArrayList.toString();; localObject1 = "null")
    {
      QLog.d("MultiCardManager", 2, (String)localObject1);
      if ((this.mApp != null) && (paramb != null) && (paramArrayList != null))
      {
        if (aqiw.isNetSupport(???)) {
          break;
        }
        a(paramLong, paramArrayList, paramb);
      }
      return;
    }
    synchronized (this.ly)
    {
      if (!this.ly.containsKey(Long.valueOf(paramLong))) {
        break label319;
      }
      localObject1 = (ArrayList)this.ly.get(Long.valueOf(paramLong));
      if (localObject1 == null) {
        break label352;
      }
      localObject1 = (ArrayList)((ArrayList)localObject1).clone();
      localObject2 = paramArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject2).next();
        if (!((ArrayList)localObject1).contains(localLong)) {
          ((ArrayList)localObject1).add(localLong);
        }
      }
    }
    this.ly.put(Long.valueOf(paramLong), localObject1);
    for (;;)
    {
      a(paramLong, paramArrayList, paramb);
      if (i != 0) {
        break;
      }
      paramArrayList = new WeakReference(paramb);
      synchronized (this.lx)
      {
        this.lx.put(Long.valueOf(paramLong), paramArrayList);
        ((acms)this.mApp.getBusinessHandler(20)).b(false, paramLong + "", "0", 9);
        return;
        label319:
        this.ly.put(Long.valueOf(paramLong), (ArrayList)paramArrayList.clone());
        i = 0;
      }
      label352:
      int i = 1;
    }
  }
  
  public void b(String paramString, IntimateInfo paramIntimateInfo)
  {
    if (paramIntimateInfo != null) {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "saveGroupCardIntimateInfo " + paramString + " " + paramIntimateInfo.toString());
      }
    }
    try
    {
      long l = Long.parseLong(paramIntimateInfo.friendUin);
      if (!this.RD) {
        this.v.put(Long.valueOf(l), paramIntimateInfo);
      }
      paramString = IntimateInfo.convertUinKeyForGroupCard(paramString, paramIntimateInfo.friendUin);
      paramIntimateInfo.friendUin = paramString;
      paramIntimateInfo.lastAnimAfterFriendDays = paramIntimateInfo.beFriendDays;
      paramIntimateInfo.lastAnimAfterScore = paramIntimateInfo.currentScore;
      this.b.a(paramString, paramIntimateInfo);
      paramIntimateInfo.friendUin = (l + "");
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("intimate_relationship", 2, "saveGroupCardIntimateInfo " + paramString.toString());
    }
  }
  
  public void clear()
  {
    try
    {
      kh(this.acU);
      return;
    }
    finally {}
  }
  
  public void kh(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "exit " + paramLong);
    }
    this.RD = true;
    this.acU = 0L;
    if (this.jdField_a_of_type_Ajjz$d != null)
    {
      this.mApp.removeObserver(this.jdField_a_of_type_Ajjz$d);
      this.jdField_a_of_type_Ajjz$d = null;
    }
    if (this.jdField_a_of_type_Ajjz$e != null)
    {
      this.mApp.removeObserver(this.jdField_a_of_type_Ajjz$e);
      this.jdField_a_of_type_Ajjz$e = null;
    }
    if (this.jdField_a_of_type_Ajjz$f != null)
    {
      this.mApp.removeObserver(this.jdField_a_of_type_Ajjz$f);
      this.jdField_a_of_type_Ajjz$f = null;
    }
    if (this.lu != null) {}
    synchronized (this.lu)
    {
      this.lu.clear();
      if (this.lv != null) {}
      synchronized (this.lv)
      {
        this.lv.clear();
        if (this.v != null) {
          this.v.evictAll();
        }
        if (this.lz != null) {}
        synchronized (this.lz)
        {
          this.lz.clear();
          if (this.lx != null) {}
          synchronized (this.lx)
          {
            this.lx.clear();
            if (this.ly != null) {}
            synchronized (this.ly)
            {
              this.ly.clear();
              if (this.lw == null) {}
            }
          }
        }
      }
    }
    synchronized (this.lw)
    {
      this.lw.clear();
      return;
      localObject1 = finally;
      throw localObject1;
      localObject2 = finally;
      throw localObject2;
      localObject3 = finally;
      throw localObject3;
      localObject4 = finally;
      throw localObject4;
      localObject5 = finally;
      throw localObject5;
    }
  }
  
  public void m(long paramLong, ArrayList<Long> paramArrayList)
  {
    Object localObject = this.mApp.getApp().getSharedPreferences("group_intimate_recommend_uin_list", 0);
    if (paramArrayList != null)
    {
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put((Long)localIterator.next());
      }
      ((SharedPreferences)localObject).edit().putString(this.mApp.getCurrentUin() + "_" + paramLong, localJSONArray.toString()).commit();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("updateGroupRecommendUinListDiskCache, uin: ").append(paramLong).append(" ");
        if (paramArrayList == null) {
          break label221;
        }
      }
    }
    label221:
    for (paramArrayList = paramArrayList.toString();; paramArrayList = "null")
    {
      QLog.d("intimate_relationship", 2, paramArrayList);
      return;
      ((SharedPreferences)localObject).edit().remove(this.mApp.getCurrentUin() + "_" + paramLong).commit();
      break;
    }
  }
  
  public void onDestroy()
  {
    clear();
  }
  
  public static abstract interface a
  {
    public abstract void E(HashMap<Long, IntimateInfo> paramHashMap);
  }
  
  public static abstract interface b
  {
    public abstract void b(long paramLong, HashMap<Long, String> paramHashMap);
  }
  
  public static abstract interface c
  {
    public abstract void l(long paramLong, ArrayList<Long> paramArrayList);
  }
  
  class d
    extends ahpp
  {
    protected void a(boolean paramBoolean, HashMap<Long, IntimateInfo> paramHashMap, Object arg3)
    {
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder().append("onGetGroupIntimateInfos ").append(paramBoolean).append(" ");
        if (paramHashMap == null) {
          break label284;
        }
      }
      long l1;
      label284:
      for (paramHashMap = paramHashMap.size() + paramHashMap.toString();; paramHashMap = "null")
      {
        QLog.d("MultiCardManager", 2, paramHashMap);
        paramHashMap = new ArrayList(0);
        if (!(??? instanceof HashMap)) {
          break label393;
        }
        Object localObject2 = (HashMap)???;
        ??? = (ArrayList)((HashMap)localObject2).get("alreadyRequest");
        ??? = (ArrayList)((HashMap)localObject2).get("notRequest");
        localObject2 = (ArrayList)((HashMap)localObject2).get("groupUin");
        if ((localObject2 == null) || (((ArrayList)localObject2).size() <= 0)) {
          break label387;
        }
        l1 = ((Long)((ArrayList)localObject2).get(0)).longValue();
        if (??? != null) {
          paramHashMap.addAll((Collection)???);
        }
        l2 = l1;
        if (??? == null) {
          break label297;
        }
        paramHashMap.addAll(???);
        l2 = l1;
        if (paramBoolean) {
          break label297;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MultiCardManager", 2, "onGetGroupIntimateInfos false remove sendRequest  " + ???.toString());
        }
        synchronized (ajjz.e(this.this$0))
        {
          ??? = ???.iterator();
          if (!???.hasNext()) {
            break;
          }
          localObject2 = (Long)???.next();
          ajjz.e(this.this$0).remove(localObject2);
        }
      }
      label387:
      label393:
      for (long l2 = l1;; l2 = 0L)
      {
        label297:
        if ((l2 == ajjz.a(this.this$0)) && (ajjz.f(this.this$0) != null)) {}
        synchronized (ajjz.f(this.this$0))
        {
          ??? = (WeakReference)ajjz.f(this.this$0).get(Long.valueOf(l2));
          if (??? != null)
          {
            ??? = (ajjz.a)((WeakReference)???).get();
            if (??? != null) {
              ajjz.a(this.this$0, l2, paramHashMap, ???);
            }
          }
          return;
        }
        l1 = 0L;
        break;
      }
    }
    
    protected void b(boolean paramBoolean, long paramLong, ArrayList<Long> paramArrayList)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("onGetIntimateGroupRecommendUinList ").append(paramBoolean).append(" ").append(paramLong).append(" ");
        if (paramArrayList == null) {
          break label200;
        }
        ??? = paramArrayList.toString();
      }
      for (;;)
      {
        QLog.d("MultiCardManager", 2, (String)???);
        if ((paramLong == ajjz.a(this.this$0)) && (ajjz.d(this.this$0) != null)) {
          if (paramArrayList != null) {
            synchronized (ajjz.a(this.this$0))
            {
              ajjz.a(this.this$0).put(Long.valueOf(paramLong), (ArrayList)paramArrayList.clone());
            }
          }
        }
        synchronized (ajjz.d(this.this$0))
        {
          localObject2 = (WeakReference)ajjz.d(this.this$0).get(Long.valueOf(paramLong));
          if (localObject2 != null)
          {
            ??? = (ajjz.c)((WeakReference)localObject2).get();
            if (??? != null)
            {
              if (paramBoolean) {
                break;
              }
              ajjz.a(this.this$0, paramLong, (ajjz.c)???);
            }
          }
          return;
          label200:
          ??? = "null";
          continue;
          paramArrayList = finally;
          throw paramArrayList;
        }
      }
      ((ajjz.c)???).l(paramLong, paramArrayList);
    }
  }
  
  class e
    extends acfd
  {
    protected void onAddFriend(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiCardManager", 2, "onAddFriend " + paramString);
      }
      ArrayList localArrayList;
      if ((!ajjz.a(this.this$0)) && (ajjz.a(this.this$0) != null))
      {
        localArrayList = (ArrayList)ajjz.a(this.this$0).get(Long.valueOf(ajjz.a(this.this$0)));
        if (localArrayList == null) {}
      }
      try
      {
        long l = Long.parseLong(paramString);
        if (localArrayList.indexOf(Long.valueOf(l)) != -1)
        {
          paramString = new ArrayList(1);
          paramString.add(Long.valueOf(l));
          localArrayList = new ArrayList(1);
          localArrayList.add(Long.valueOf(ajjz.a(this.this$0)));
          HashMap localHashMap = new HashMap(5);
          localHashMap.put("notRequest", paramString);
          localHashMap.put("groupUin", localArrayList);
          ((ahpj)ajjz.a(this.this$0).getBusinessHandler(153)).a(ajjz.a(this.this$0), paramString, localHashMap);
        }
        return;
      }
      catch (Exception paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("MultiCardManager", 2, "onAddFriend error " + paramString.toString());
      }
    }
  }
  
  class f
    extends acnd
  {
    /* Error */
    protected void a(String arg1, boolean paramBoolean, java.util.List<com.tencent.mobileqq.data.TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
    {
      // Byte code:
      //   0: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   3: ifeq +47 -> 50
      //   6: ldc 21
      //   8: iconst_2
      //   9: new 23	java/lang/StringBuilder
      //   12: dup
      //   13: invokespecial 27	java/lang/StringBuilder:<init>	()V
      //   16: ldc 29
      //   18: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   21: iload_2
      //   22: invokevirtual 36	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   25: ldc 38
      //   27: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   30: aload_1
      //   31: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   34: ldc 38
      //   36: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   39: iload 4
      //   41: invokevirtual 41	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   44: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   47: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   50: aload_1
      //   51: invokestatic 55	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   54: lstore 5
      //   56: iload 4
      //   58: bipush 9
      //   60: if_icmpne +126 -> 186
      //   63: lload 5
      //   65: aload_0
      //   66: getfield 57	ajjz$f:this$0	Lajjz;
      //   69: invokestatic 60	ajjz:a	(Lajjz;)J
      //   72: lcmp
      //   73: ifne +113 -> 186
      //   76: aload_0
      //   77: getfield 57	ajjz$f:this$0	Lajjz;
      //   80: invokestatic 64	ajjz:b	(Lajjz;)Ljava/util/HashMap;
      //   83: ifnull +103 -> 186
      //   86: aload_0
      //   87: getfield 57	ajjz$f:this$0	Lajjz;
      //   90: invokestatic 64	ajjz:b	(Lajjz;)Ljava/util/HashMap;
      //   93: astore_1
      //   94: aload_1
      //   95: monitorenter
      //   96: aload_0
      //   97: getfield 57	ajjz$f:this$0	Lajjz;
      //   100: invokestatic 64	ajjz:b	(Lajjz;)Ljava/util/HashMap;
      //   103: lload 5
      //   105: invokestatic 68	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   108: invokevirtual 74	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   111: checkcast 76	java/lang/ref/WeakReference
      //   114: astore_3
      //   115: aload_1
      //   116: monitorexit
      //   117: aload_3
      //   118: ifnull +68 -> 186
      //   121: aload_3
      //   122: invokevirtual 79	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   125: checkcast 81	ajjz$b
      //   128: astore_3
      //   129: aload_3
      //   130: ifnull +56 -> 186
      //   133: new 83	java/util/ArrayList
      //   136: dup
      //   137: iconst_0
      //   138: invokespecial 86	java/util/ArrayList:<init>	(I)V
      //   141: pop
      //   142: aload_0
      //   143: getfield 57	ajjz$f:this$0	Lajjz;
      //   146: invokestatic 89	ajjz:c	(Lajjz;)Ljava/util/HashMap;
      //   149: astore_1
      //   150: aload_1
      //   151: monitorenter
      //   152: aload_0
      //   153: getfield 57	ajjz$f:this$0	Lajjz;
      //   156: invokestatic 89	ajjz:c	(Lajjz;)Ljava/util/HashMap;
      //   159: lload 5
      //   161: invokestatic 68	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   164: invokevirtual 74	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   167: checkcast 83	java/util/ArrayList
      //   170: astore 8
      //   172: aload_1
      //   173: monitorexit
      //   174: aload_0
      //   175: getfield 57	ajjz$f:this$0	Lajjz;
      //   178: lload 5
      //   180: aload 8
      //   182: aload_3
      //   183: invokestatic 92	ajjz:a	(Lajjz;JLjava/util/ArrayList;Lajjz$b;)V
      //   186: return
      //   187: astore_1
      //   188: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   191: ifeq +31 -> 222
      //   194: ldc 21
      //   196: iconst_2
      //   197: new 23	java/lang/StringBuilder
      //   200: dup
      //   201: invokespecial 27	java/lang/StringBuilder:<init>	()V
      //   204: ldc 29
      //   206: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   209: aload_1
      //   210: invokevirtual 93	java/lang/Exception:toString	()Ljava/lang/String;
      //   213: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   216: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   219: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   222: lconst_0
      //   223: lstore 5
      //   225: goto -169 -> 56
      //   228: astore_3
      //   229: aload_1
      //   230: monitorexit
      //   231: aload_3
      //   232: athrow
      //   233: astore_3
      //   234: aload_1
      //   235: monitorexit
      //   236: aload_3
      //   237: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	238	0	this	f
      //   0	238	2	paramBoolean	boolean
      //   0	238	3	paramList	java.util.List<com.tencent.mobileqq.data.TroopMemberInfo>
      //   0	238	4	paramInt1	int
      //   0	238	5	paramLong	long
      //   0	238	7	paramInt2	int
      //   170	11	8	localArrayList	ArrayList
      // Exception table:
      //   from	to	target	type
      //   50	56	187	java/lang/Exception
      //   96	117	228	finally
      //   229	231	228	finally
      //   152	174	233	finally
      //   234	236	233	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajjz
 * JD-Core Version:    0.7.0.1
 */