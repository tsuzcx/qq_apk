import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.PadInfo;
import com.tencent.tim.teamwork.BrowsePadInfo;
import com.tencent.tim.teamwork.CreatedPadInfo;
import com.tencent.tim.teamwork.PadInfo;
import com.tencent.tim.teamwork.PadInfoForStructMsg;
import com.tencent.tim.teamwork.ReSendCmd;
import com.tencent.tim.teamwork.SharedPadInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class aull
  implements Manager
{
  private static String cIB = "https://pub.idqqimg.com/pc/misc/files/20180403/da40f07bd79e4796b712b44023911be0.png";
  private static String cIC = "https://pub.idqqimg.com/pc/misc/files/20180403/da40f07bd79e4796b712b44023911be0.png";
  private static String cjL = "https://pub.idqqimg.com/pc/misc/files/20180403/29c998e16c094b10a96b3e0d1589c2f6.png";
  private static String cjM = "https://pub.idqqimg.com/pc/misc/files/20180403/da40f07bd79e4796b712b44023911be0.png";
  private static String cjN = "https://pub.idqqimg.com/pc/misc/files/20180410/1fce078ca2434b18bfec613961d526ff.png";
  private static String cjO = "https://pub.idqqimg.com/pc/misc/files/20180410/5349bc325950481ebde04c38208d9028.png";
  public ArrayList<String> Ek = new ArrayList();
  public ArrayList<String> El = new ArrayList();
  public ArrayList<String> Em = new ArrayList();
  public ArrayList<String> En = new ArrayList();
  QQAppInterface app;
  protected EntityManager em;
  private int erG;
  private volatile boolean isInited;
  private ConcurrentHashMap<String, Entity> jN = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Entity> jO = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Entity> jP = new ConcurrentHashMap();
  ConcurrentHashMap<String, PadInfoForStructMsg> jQ = new ConcurrentHashMap();
  
  public aull(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.em = paramQQAppInterface.a().createEntityManager();
  }
  
  public static String AA()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("tencentdoc_url_config", 4);
    if (localSharedPreferences != null) {
      cjO = localSharedPreferences.getString("tencentdoc_pre_img_url_miniproj_sheet", "https://pub.idqqimg.com/pc/misc/files/20180410/5349bc325950481ebde04c38208d9028.png");
    }
    return cjO;
  }
  
  public static String Ax()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("tencentdoc_url_config", 4);
    if (localSharedPreferences != null) {
      cjL = localSharedPreferences.getString("tencentdoc_pre_img_url_doc", "https://pub.idqqimg.com/pc/misc/files/20180403/29c998e16c094b10a96b3e0d1589c2f6.png");
    }
    return cjL;
  }
  
  public static String Ay()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("tencentdoc_url_config", 4);
    if (localSharedPreferences != null) {
      cjM = localSharedPreferences.getString("tencentdoc_pre_img_url_sheet", "https://pub.idqqimg.com/pc/misc/files/20180403/da40f07bd79e4796b712b44023911be0.png");
    }
    return cjM;
  }
  
  public static String Az()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("tencentdoc_url_config", 4);
    if (localSharedPreferences != null) {
      cjN = localSharedPreferences.getString("tencentdoc_pre_img_url_miniproj_doc", "https://pub.idqqimg.com/pc/misc/files/20180410/1fce078ca2434b18bfec613961d526ff.png");
    }
    return cjN;
  }
  
  private void C(String paramString, ArrayList<String> paramArrayList)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("tencentdoc_url_config", 4).edit();
    String[] arrayOfString = new String[paramArrayList.size()];
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < arrayOfString.length)
    {
      localStringBuilder.append((String)paramArrayList.get(i));
      if (i != arrayOfString.length - 1) {
        localStringBuilder.append("#");
      }
      i += 1;
    }
    localEditor.putString(paramString, localStringBuilder.toString());
    localEditor.commit();
  }
  
  public static String Fd()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("tencentdoc_url_config", 4);
    if (localSharedPreferences != null) {
      cIB = localSharedPreferences.getString("tencentdoc_pre_img_url_form", "https://pub.idqqimg.com/pc/misc/files/20180403/da40f07bd79e4796b712b44023911be0.png");
    }
    return cIB;
  }
  
  public static String Fe()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("tencentdoc_url_config", 4);
    if (localSharedPreferences != null) {
      cIC = localSharedPreferences.getString("tencentdoc_pre_img_url_ppt", "https://pub.idqqimg.com/pc/misc/files/20180403/da40f07bd79e4796b712b44023911be0.png");
    }
    return cIC;
  }
  
  private ConcurrentHashMap<String, Entity> G()
  {
    Object localObject2;
    Object localObject3;
    Object localObject1;
    try
    {
      ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
      localObject2 = this.jO;
      localObject3 = this.jN;
      localObject1 = this.jQ;
      localConcurrentHashMap.putAll((Map)localObject2);
      localObject2 = ((ConcurrentHashMap)localObject3).values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Entity)((Iterator)localObject2).next();
        if ((localObject3 instanceof PadInfo))
        {
          localObject3 = (PadInfo)localObject3;
          String str = ault.nT(((PadInfo)localObject3).pad_url);
          if (!localConcurrentHashMap.containsKey(str)) {
            localConcurrentHashMap.put(str, localObject3);
          }
        }
      }
      localObject1 = ((ConcurrentHashMap)localObject1).values().iterator();
    }
    finally {}
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Entity)((Iterator)localObject1).next();
      if ((localObject2 instanceof PadInfo))
      {
        localObject2 = (PadInfo)localObject2;
        localObject3 = ault.nT(((PadInfo)localObject2).pad_url);
        if (!localConcurrentHashMap1.containsKey(localObject3)) {
          localConcurrentHashMap1.put(localObject3, localObject2);
        }
      }
    }
    return localConcurrentHashMap1;
  }
  
  private Entity a(int paramInt, String paramString)
  {
    Iterator localIterator = this.jQ.values().iterator();
    while (localIterator.hasNext())
    {
      PadInfo localPadInfo = (PadInfo)localIterator.next();
      if ((localPadInfo.domainId == paramInt) && (paramString.equals(localPadInfo.padId)))
      {
        localIterator.remove();
        return localPadInfo;
      }
    }
    return null;
  }
  
  private Entity a(int paramInt, String paramString, ConcurrentHashMap<String, Entity> paramConcurrentHashMap)
  {
    paramConcurrentHashMap = paramConcurrentHashMap.values().iterator();
    while (paramConcurrentHashMap.hasNext())
    {
      PadInfo localPadInfo = (PadInfo)paramConcurrentHashMap.next();
      if ((localPadInfo.domainId == paramInt) && (paramString.equals(localPadInfo.padId)))
      {
        paramConcurrentHashMap.remove();
        return localPadInfo;
      }
    }
    return null;
  }
  
  public static void ao(Context paramContext, String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext = paramString2;
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext = paramString2 + "_" + paramString1;
    }
    localEditor.putLong(paramContext, System.currentTimeMillis());
    localEditor.commit();
  }
  
  public static int b(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    paramContext = paramString2;
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext = paramString2 + "_" + paramString1;
    }
    return localSharedPreferences.getInt(paramContext, paramInt);
  }
  
  public static int c(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    paramContext = paramString2;
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext = paramString2 + "_" + paramString1;
    }
    return localSharedPreferences.getInt(paramContext, paramInt);
  }
  
  private void evA()
  {
    Object localObject2 = (ArrayList)this.em.query(PadInfoForStructMsg.class);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("initStructPadInfoCache info.size : ");
      if (localObject2 != null) {
        break label151;
      }
    }
    label151:
    for (Object localObject1 = "null";; localObject1 = Integer.valueOf(((List)localObject2).size()))
    {
      QLog.w("TeamWorkManager_T", 2, localObject1);
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break;
      }
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (PadInfoForStructMsg)((Iterator)localObject1).next();
        if (QLog.isColorLevel()) {
          QLog.w("TeamWorkManager_T", 2, "initStructPadInfoCache info.pad_url : " + ((PadInfoForStructMsg)localObject2).pad_url);
        }
        this.jQ.put(ault.nT(((PadInfoForStructMsg)localObject2).pad_url), localObject2);
      }
    }
  }
  
  private void evx()
  {
    int k = 0;
    int i = 0;
    while (i < auko.iD.length)
    {
      this.Ek.add(auko.iD[i]);
      i += 1;
    }
    i = 0;
    while (i < auko.iE.length)
    {
      this.El.add(auko.iE[i]);
      i += 1;
    }
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= auko.iF.length) {
        break;
      }
      this.Em.add(auko.iF[i]);
      i += 1;
    }
    while (j < auko.iG.length)
    {
      this.En.add(auko.iG[j]);
      j += 1;
    }
  }
  
  public static String g(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    paramContext = paramString2;
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext = paramString2 + "_" + paramString1;
    }
    return localSharedPreferences.getString(paramContext, paramString3);
  }
  
  /* Error */
  private void mB(List<PadInfo> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 99	aull:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   4: invokevirtual 348	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   7: invokevirtual 353	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   10: aload_1
    //   11: invokeinterface 311 1 0
    //   16: astore_1
    //   17: aload_1
    //   18: invokeinterface 197 1 0
    //   23: ifeq +66 -> 89
    //   26: aload_1
    //   27: invokeinterface 201 1 0
    //   32: checkcast 205	com/tencent/tim/teamwork/PadInfo
    //   35: astore_2
    //   36: aload_0
    //   37: getfield 99	aull:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   40: aload_2
    //   41: invokevirtual 357	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   44: goto -27 -> 17
    //   47: astore_1
    //   48: ldc_w 359
    //   51: iconst_1
    //   52: new 144	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   59: ldc_w 361
    //   62: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_1
    //   66: invokevirtual 362	java/lang/Exception:toString	()Ljava/lang/String;
    //   69: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 365	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aload_0
    //   79: getfield 99	aull:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   82: invokevirtual 348	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   85: invokevirtual 368	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   88: return
    //   89: aload_0
    //   90: getfield 99	aull:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   93: invokevirtual 348	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   96: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   99: aload_0
    //   100: getfield 99	aull:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   103: invokevirtual 348	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   106: invokevirtual 368	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   109: return
    //   110: astore_1
    //   111: aload_0
    //   112: getfield 99	aull:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   115: invokevirtual 348	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   118: invokevirtual 368	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   121: aload_1
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	aull
    //   0	123	1	paramList	List<PadInfo>
    //   35	6	2	localPadInfo	PadInfo
    // Exception table:
    //   from	to	target	type
    //   0	17	47	java/lang/Exception
    //   17	44	47	java/lang/Exception
    //   89	99	47	java/lang/Exception
    //   0	17	110	finally
    //   17	44	110	finally
    //   48	78	110	finally
    //   89	99	110	finally
  }
  
  public static void o(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext = paramString2;
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext = paramString2 + "_" + paramString1;
    }
    localEditor.putInt(paramContext, paramInt);
    localEditor.commit();
  }
  
  public static void p(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext = paramString2;
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext = paramString2 + "_" + paramString1;
    }
    localEditor.putInt(paramContext, paramInt);
    localEditor.commit();
  }
  
  public static void x(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext = paramString2;
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext = paramString2 + "_" + paramString1;
    }
    localEditor.putString(paramContext, paramString3);
    localEditor.commit();
  }
  
  public int OF()
  {
    return this.jN.size();
  }
  
  public int OG()
  {
    return this.jO.size();
  }
  
  public int OH()
  {
    return this.jP.size();
  }
  
  public int OI()
  {
    return this.erG;
  }
  
  public PadInfo a(String paramString, int paramInt)
  {
    Object localObject = null;
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      do
      {
        return localObject;
        str = ault.nT(paramString);
        if (paramInt == 1) {
          return (PadInfo)this.jN.get(str);
        }
        if (paramInt == 2) {
          return (PadInfo)this.jO.get(str);
        }
        if (paramInt == 3) {
          return (PadInfo)this.jP.get(str);
        }
      } while (paramInt != 4);
      localObject = (PadInfo)this.jO.get(str);
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = (PadInfo)this.jN.get(str);
      }
      localObject = paramString;
    } while (paramString != null);
    return (PadInfo)this.jQ.get(str);
  }
  
  public void a(ReSendCmd paramReSendCmd, TimDocSSOMsg.PadInfo paramPadInfo)
  {
    if ((paramReSendCmd == null) || (TextUtils.isEmpty(paramReSendCmd.cjb)) || (paramPadInfo == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TeamWorkManager_T", 2, "updatePadInfoForStructMsg sendCmd.padUrl : " + paramReSendCmd.cjb);
    }
    PadInfoForStructMsg localPadInfoForStructMsg2 = (PadInfoForStructMsg)this.jQ.get(ault.nT(paramReSendCmd.cjb));
    PadInfoForStructMsg localPadInfoForStructMsg1 = localPadInfoForStructMsg2;
    if (localPadInfoForStructMsg2 == null)
    {
      localPadInfoForStructMsg1 = new PadInfoForStructMsg();
      localPadInfoForStructMsg1.pad_url = paramReSendCmd.cjb;
    }
    aulh.a(localPadInfoForStructMsg1, paramPadInfo);
    a(localPadInfoForStructMsg1);
    this.jQ.put(ault.nT(paramReSendCmd.cjb), localPadInfoForStructMsg1);
  }
  
  public boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntity.getStatus() == 1000)
    {
      this.em.persistOrReplace(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return bool;
    }
    return this.em.update(paramEntity);
  }
  
  public void aaR(int paramInt)
  {
    if (paramInt == 1)
    {
      this.em.drop(CreatedPadInfo.class);
      this.jN.clear();
    }
    do
    {
      return;
      if (paramInt == 2)
      {
        this.em.drop(BrowsePadInfo.class);
        this.jO.clear();
        return;
      }
    } while (paramInt != 3);
    this.em.drop(SharedPadInfo.class);
    this.jP.clear();
  }
  
  public void ab(int paramInt1, String paramString, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      Object localObject = null;
      if (paramInt2 == 1) {
        localObject = (PadInfo)a(paramInt1, paramString, this.jN);
      }
      while (localObject != null)
      {
        this.em.remove((Entity)localObject);
        return;
        PadInfo localPadInfo;
        if (paramInt2 == 2)
        {
          localPadInfo = (PadInfo)a(paramInt1, paramString, this.jO);
          localObject = (PadInfo)a(paramInt1, paramString);
          if (localObject != null) {
            this.em.remove((Entity)localObject);
          }
          paramString = (PadInfo)a(paramInt1, paramString, this.jN);
          localObject = localPadInfo;
          if (paramString != null)
          {
            this.em.remove(paramString);
            localObject = localPadInfo;
          }
        }
        else if (paramInt2 == 3)
        {
          localObject = (PadInfo)a(paramInt1, paramString, this.jP);
        }
        else if (paramInt2 == 4)
        {
          localPadInfo = (PadInfo)a(paramInt1, paramString);
          localObject = (PadInfo)a(paramInt1, paramString, this.jO);
          if (localObject != null) {
            this.em.remove((Entity)localObject);
          }
          paramString = (PadInfo)a(paramInt1, paramString, this.jN);
          localObject = localPadInfo;
          if (paramString != null)
          {
            this.em.remove(paramString);
            localObject = localPadInfo;
          }
        }
      }
    }
  }
  
  public PadInfo b(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = ault.nT(paramString);
      if (paramInt == 1) {
        return (PadInfo)this.jN.get(paramString);
      }
      if (paramInt == 2) {
        return (PadInfo)this.jO.get(paramString);
      }
      if (paramInt == 3) {
        return (PadInfo)this.jP.get(paramString);
      }
    } while (paramInt != 4);
    return (PadInfo)this.jQ.get(paramString);
  }
  
  public void c(int paramInt1, List<PadInfo> paramList, int paramInt2)
  {
    if (paramInt1 == 2) {
      aaR(paramInt2);
    }
    if (paramList != null)
    {
      Iterator localIterator;
      PadInfo localPadInfo;
      if (paramInt2 == 1)
      {
        localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          localPadInfo = (PadInfo)localIterator.next();
          this.jN.put(ault.nT(localPadInfo.pad_url), localPadInfo);
        }
      }
      if (paramInt2 == 2)
      {
        localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          localPadInfo = (PadInfo)localIterator.next();
          this.jO.put(ault.nT(localPadInfo.pad_url), localPadInfo);
        }
      }
      if (paramInt2 == 3)
      {
        localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          localPadInfo = (PadInfo)localIterator.next();
          this.jP.put(ault.nT(localPadInfo.pad_url), localPadInfo);
        }
      }
      mB(paramList);
      nZ(paramList);
    }
  }
  
  public void evB()
  {
    Object localObject2;
    try
    {
      if (!this.isInited) {
        qh();
      }
      Iterator localIterator1 = this.jO.values().iterator();
      while (localIterator1.hasNext())
      {
        localObject2 = ault.nT(((PadInfo)localIterator1.next()).pad_url);
        if (this.jQ.containsKey(localObject2))
        {
          localObject2 = (PadInfo)this.jQ.remove(localObject2);
          if (localObject2 != null) {
            this.em.remove((Entity)localObject2);
          }
        }
      }
      localIterator2 = this.jN.values().iterator();
    }
    finally {}
    Iterator localIterator2;
    while (localIterator2.hasNext())
    {
      localObject2 = ault.nT(((PadInfo)localIterator2.next()).pad_url);
      if (this.jQ.containsKey(localObject2))
      {
        localObject2 = (PadInfo)this.jQ.remove(localObject2);
        if (localObject2 != null) {
          this.em.remove((Entity)localObject2);
        }
      }
    }
  }
  
  public void evy()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.Ek == null) || (this.Ek.size() <= 0))
    {
      i = 0;
      while (i < auko.iD.length)
      {
        this.Ek.add(auko.iD[i]);
        i += 1;
      }
    }
    if ((this.Em == null) || (this.Em.size() <= 0))
    {
      i = 0;
      while (i < auko.iF.length)
      {
        this.Em.add(auko.iF[i]);
        i += 1;
      }
    }
    if ((this.En == null) || (this.En.size() <= 0))
    {
      i = 0;
      while (i < auko.iG.length)
      {
        this.En.add(auko.iG[i]);
        i += 1;
      }
    }
    int i = 0;
    int j;
    while (i < this.Ek.size())
    {
      j = 0;
      while (j < this.Em.size())
      {
        localArrayList.add((String)this.Ek.get(i) + (String)this.Em.get(j));
        j += 1;
      }
      i += 1;
    }
    i = 0;
    while (i < this.Ek.size())
    {
      j = 0;
      while (j < this.En.size())
      {
        localArrayList.add((String)this.Ek.get(i) + (String)this.En.get(j));
        j += 1;
      }
      i += 1;
    }
    C("tencentdoc_template_path_list", localArrayList);
  }
  
  public void evz()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.Ek == null) || (this.El.size() <= 0))
    {
      i = 0;
      while (i < auko.iD.length)
      {
        this.Ek.add(auko.iD[i]);
        i += 1;
      }
    }
    if ((this.El == null) || (this.El.size() <= 0))
    {
      i = 0;
      while (i < auko.iE.length)
      {
        this.El.add(auko.iE[i]);
        i += 1;
      }
    }
    int i = 0;
    while (i < this.Ek.size())
    {
      int j = 0;
      while (j < this.El.size())
      {
        localArrayList.add((String)this.Ek.get(i) + (String)this.El.get(j));
        j += 1;
      }
      i += 1;
    }
    C("tencentdoc_type_path_list", localArrayList);
  }
  
  public void gQ(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      PadInfo localPadInfo = null;
      String str = ault.nT(paramString);
      if (paramInt == 1) {
        paramString = (PadInfo)this.jN.remove(str);
      }
      while (paramString != null)
      {
        this.em.remove(paramString);
        return;
        if (paramInt == 2)
        {
          localPadInfo = (PadInfo)this.jO.remove(str);
          if (this.jQ.containsKey(str))
          {
            paramString = (PadInfo)this.jQ.remove(str);
            this.em.remove(paramString);
          }
          paramString = localPadInfo;
          if (this.jN.containsKey(str))
          {
            paramString = (PadInfo)this.jN.remove(str);
            this.em.remove(paramString);
            paramString = localPadInfo;
          }
        }
        else if (paramInt == 3)
        {
          paramString = (PadInfo)this.jP.remove(str);
        }
        else
        {
          paramString = localPadInfo;
          if (paramInt == 4)
          {
            localPadInfo = (PadInfo)this.jQ.remove(str);
            if (this.jO.containsKey(str))
            {
              paramString = (PadInfo)this.jO.remove(str);
              this.em.remove(paramString);
            }
            paramString = localPadInfo;
            if (this.jN.containsKey(str))
            {
              paramString = (PadInfo)this.jN.remove(str);
              this.em.remove(paramString);
              paramString = localPadInfo;
            }
          }
        }
      }
    }
  }
  
  public void h(PadInfo paramPadInfo)
  {
    if ((paramPadInfo == null) || (TextUtils.isEmpty(paramPadInfo.pad_url))) {}
    for (;;)
    {
      return;
      if (paramPadInfo.type_list == 1) {
        if (paramPadInfo.itemDeleteFlag) {
          gQ(paramPadInfo.pad_url, paramPadInfo.type_list);
        }
      }
      while (!paramPadInfo.itemDeleteFlag)
      {
        a(paramPadInfo);
        return;
        Entity localEntity = (Entity)this.jN.get(ault.nT(paramPadInfo.pad_url));
        if (localEntity != null)
        {
          paramPadInfo.pinInAllList = ((PadInfo)localEntity).pinInAllList;
          paramPadInfo.lastPinnedTimeInAllList = ((PadInfo)localEntity).lastPinnedTimeInAllList;
        }
        this.jN.put(ault.nT(paramPadInfo.pad_url), paramPadInfo);
        continue;
        if (paramPadInfo.type_list == 2)
        {
          if (paramPadInfo.itemDeleteFlag)
          {
            gQ(paramPadInfo.pad_url, paramPadInfo.type_list);
          }
          else
          {
            localEntity = (Entity)this.jO.get(ault.nT(paramPadInfo.pad_url));
            if (localEntity != null)
            {
              paramPadInfo.pinInAllList = ((PadInfo)localEntity).pinInAllList;
              paramPadInfo.lastPinnedTimeInAllList = ((PadInfo)localEntity).lastPinnedTimeInAllList;
            }
            this.jO.put(ault.nT(paramPadInfo.pad_url), paramPadInfo);
          }
        }
        else if (paramPadInfo.type_list == 3) {
          if (paramPadInfo.itemDeleteFlag) {
            gQ(paramPadInfo.pad_url, paramPadInfo.type_list);
          } else {
            this.jP.put(ault.nT(paramPadInfo.pad_url), paramPadInfo);
          }
        }
      }
    }
  }
  
  public List<PadInfo> hn()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jO != null)
    {
      Iterator localIterator = this.jO.values().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((PadInfo)localIterator.next());
      }
    }
    return localArrayList;
  }
  
  public List<PadInfo> ho()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jP != null)
    {
      Iterator localIterator = this.jP.values().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((PadInfo)localIterator.next());
      }
    }
    return localArrayList;
  }
  
  public List<PadInfo> hp()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = G();
    if ((localObject != null) && (!((ConcurrentHashMap)localObject).isEmpty()))
    {
      localObject = ((ConcurrentHashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        PadInfo localPadInfo = (PadInfo)((Iterator)localObject).next();
        localPadInfo.type_list = 4;
        localPadInfo.pinedFlag = false;
        localArrayList.add(localPadInfo);
      }
    }
    this.erG = localArrayList.size();
    return localArrayList;
  }
  
  public long iC()
  {
    long l2 = 0L;
    ArrayList localArrayList = new ArrayList();
    Object localObject = G();
    long l1;
    if ((localObject != null) && (!((ConcurrentHashMap)localObject).isEmpty()))
    {
      localObject = ((ConcurrentHashMap)localObject).values().iterator();
      l2 = 0L;
      l1 = 0L;
      while (((Iterator)localObject).hasNext())
      {
        PadInfo localPadInfo = (PadInfo)((Iterator)localObject).next();
        long l3 = l2;
        if (localPadInfo.pinedFlag)
        {
          l3 = l2;
          if (localPadInfo.lastPinnedTime > l2) {
            l3 = localPadInfo.lastPinnedTime;
          }
        }
        if (localPadInfo.lastEditTime <= l1) {
          break label142;
        }
        l1 = localPadInfo.lastEditTime;
        l2 = l3;
      }
    }
    for (;;)
    {
      this.erG = localArrayList.size();
      if (l1 > l2) {
        return l1;
      }
      return l2;
      label142:
      break;
      l1 = 0L;
    }
  }
  
  public void j(String paramString, boolean paramBoolean, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = ault.nT(paramString);
      PadInfo localPadInfo;
      if (this.jQ.containsKey(paramString))
      {
        localPadInfo = (PadInfo)this.jQ.get(paramString);
        localPadInfo.pinInAllList = paramBoolean;
        localPadInfo.lastPinnedTimeInAllList = paramLong;
        a(localPadInfo);
      }
      if (this.jO.containsKey(paramString))
      {
        localPadInfo = (PadInfo)this.jO.get(paramString);
        localPadInfo.pinInAllList = paramBoolean;
        localPadInfo.lastPinnedTimeInAllList = paramLong;
        a(localPadInfo);
      }
    } while (!this.jN.containsKey(paramString));
    paramString = (PadInfo)this.jN.get(paramString);
    paramString.pinInAllList = paramBoolean;
    paramString.lastPinnedTimeInAllList = paramLong;
    a(paramString);
  }
  
  /* Error */
  public void nZ(List<PadInfo> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +82 -> 83
    //   4: aload_0
    //   5: getfield 99	aull:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   8: invokevirtual 348	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   11: astore_2
    //   12: aload_2
    //   13: invokevirtual 353	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   16: aload_1
    //   17: invokeinterface 311 1 0
    //   22: astore_1
    //   23: aload_1
    //   24: invokeinterface 197 1 0
    //   29: ifeq +55 -> 84
    //   32: aload_0
    //   33: aload_1
    //   34: invokeinterface 201 1 0
    //   39: checkcast 205	com/tencent/tim/teamwork/PadInfo
    //   42: invokevirtual 512	aull:h	(Lcom/tencent/tim/teamwork/PadInfo;)V
    //   45: goto -22 -> 23
    //   48: astore_1
    //   49: ldc_w 359
    //   52: iconst_1
    //   53: new 144	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   60: ldc_w 514
    //   63: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_1
    //   67: invokevirtual 362	java/lang/Exception:toString	()Ljava/lang/String;
    //   70: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 365	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: aload_2
    //   80: invokevirtual 368	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   83: return
    //   84: aload_2
    //   85: invokevirtual 370	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   88: aload_2
    //   89: invokevirtual 368	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   92: return
    //   93: astore_1
    //   94: aload_2
    //   95: invokevirtual 368	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	aull
    //   0	100	1	paramList	List<PadInfo>
    //   11	84	2	localEntityTransaction	EntityTransaction
    // Exception table:
    //   from	to	target	type
    //   16	23	48	java/lang/Exception
    //   23	45	48	java/lang/Exception
    //   84	88	48	java/lang/Exception
    //   16	23	93	finally
    //   23	45	93	finally
    //   49	79	93	finally
    //   84	88	93	finally
  }
  
  public void oa(List<PadInfo> paramList)
  {
    EntityTransaction localEntityTransaction;
    if (paramList != null)
    {
      localEntityTransaction = this.em.getTransaction();
      localEntityTransaction.begin();
    }
    HashMap localHashMap;
    PadInfo localPadInfo;
    Object localObject;
    for (;;)
    {
      try
      {
        localHashMap = new HashMap();
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          localPadInfo = (PadInfo)paramList.next();
          localHashMap.put(ault.nT(localPadInfo.pad_url), localPadInfo);
          continue;
        }
        localPadInfo.pinInAllList = false;
      }
      catch (Exception paramList)
      {
        QLog.e("TeamWorkManager", 1, "updatePinFlagOfAllList failed exception:  " + paramList.toString());
        return;
        paramList = this.jO.keySet().iterator();
        if (!paramList.hasNext()) {
          break;
        }
        localObject = (String)paramList.next();
        localPadInfo = (PadInfo)this.jO.get(localObject);
        if (localHashMap.containsKey(localObject))
        {
          localObject = (PadInfo)localHashMap.get(localObject);
          if (localObject != null)
          {
            localPadInfo.pinInAllList = true;
            localPadInfo.lastPinnedTimeInAllList = ((PadInfo)localObject).lastPinnedTime;
          }
          a(localPadInfo);
          continue;
        }
      }
      finally
      {
        localEntityTransaction.end();
      }
      localPadInfo.lastPinnedTimeInAllList = 0L;
    }
    paramList = this.jN.keySet().iterator();
    if (paramList.hasNext())
    {
      localObject = (String)paramList.next();
      localPadInfo = (PadInfo)this.jN.get(localObject);
      if (localHashMap.containsKey(localObject))
      {
        localObject = (PadInfo)localHashMap.get(localObject);
        if (localObject != null) {
          localPadInfo.pinInAllList = true;
        }
      }
      for (localPadInfo.lastPinnedTimeInAllList = ((PadInfo)localObject).lastPinnedTime;; localPadInfo.lastPinnedTimeInAllList = 0L)
      {
        a(localPadInfo);
        break;
        localPadInfo.pinInAllList = false;
      }
    }
    paramList = this.jQ.keySet().iterator();
    if (paramList.hasNext())
    {
      localObject = (String)paramList.next();
      localPadInfo = (PadInfo)this.jQ.get(localObject);
      if (localHashMap.containsKey(localObject))
      {
        localObject = (PadInfo)localHashMap.get(localObject);
        if (localObject != null) {
          localPadInfo.pinInAllList = true;
        }
      }
      for (localPadInfo.lastPinnedTimeInAllList = ((PadInfo)localObject).lastPinnedTime;; localPadInfo.lastPinnedTimeInAllList = 0L)
      {
        a(localPadInfo);
        break;
        localPadInfo.pinInAllList = false;
      }
    }
    localEntityTransaction.commit();
    localEntityTransaction.end();
  }
  
  public void onDestroy()
  {
    this.em.close();
  }
  
  public void qh()
  {
    if (!this.isInited)
    {
      Object localObject4;
      try
      {
        if (this.isInited) {
          break label258;
        }
        this.jN.clear();
        this.jO.clear();
        this.jP.clear();
        Object localObject1 = this.em.query(CreatedPadInfo.class);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject4 = (CreatedPadInfo)((Iterator)localObject1).next();
            this.jN.put(ault.nT(((CreatedPadInfo)localObject4).pad_url), localObject4);
          }
        }
        localObject3 = this.em.query(BrowsePadInfo.class);
      }
      finally {}
      if ((localObject3 != null) && (((List)localObject3).size() > 0))
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (BrowsePadInfo)((Iterator)localObject3).next();
          this.jO.put(ault.nT(((BrowsePadInfo)localObject4).pad_url), localObject4);
        }
      }
      Object localObject3 = this.em.query(SharedPadInfo.class);
      if ((localObject3 != null) && (((List)localObject3).size() > 0))
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (SharedPadInfo)((Iterator)localObject3).next();
          this.jP.put(ault.nT(((SharedPadInfo)localObject4).pad_url), localObject4);
        }
      }
      evA();
      this.isInited = true;
    }
    label258:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aull
 * JD-Core Version:    0.7.0.1
 */