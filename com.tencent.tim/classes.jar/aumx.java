import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.tim.teamworkforgroup.GPadInfo;
import com.tencent.tim.teamworkforgroup.GroupPadTemplateInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class aumx
  implements Manager
{
  private ConcurrentHashMap<String, Entity> iy;
  private ConcurrentHashMap<String, Entity> iz;
  private EntityManager mEntityManager;
  
  public static String c(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    paramContext = paramString2;
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext = paramString2 + "_" + paramString1;
    }
    return localSharedPreferences.getString(paramContext, paramString3);
  }
  
  /* Error */
  private void mB(List<GPadInfo> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 55	aumx:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   4: invokevirtual 61	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   7: invokevirtual 66	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   10: aload_1
    //   11: invokeinterface 72 1 0
    //   16: astore_1
    //   17: aload_1
    //   18: invokeinterface 78 1 0
    //   23: ifeq +64 -> 87
    //   26: aload_1
    //   27: invokeinterface 82 1 0
    //   32: checkcast 84	com/tencent/tim/teamworkforgroup/GPadInfo
    //   35: astore_2
    //   36: aload_0
    //   37: getfield 55	aumx:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   40: aload_2
    //   41: invokevirtual 88	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   44: goto -27 -> 17
    //   47: astore_1
    //   48: ldc 90
    //   50: iconst_1
    //   51: new 28	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   58: ldc 92
    //   60: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_1
    //   64: invokevirtual 93	java/lang/Exception:toString	()Ljava/lang/String;
    //   67: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload_0
    //   77: getfield 55	aumx:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   80: invokevirtual 61	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   83: invokevirtual 102	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   86: return
    //   87: aload_0
    //   88: getfield 55	aumx:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   91: invokevirtual 61	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   94: invokevirtual 105	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   97: aload_0
    //   98: getfield 55	aumx:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   101: invokevirtual 61	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   104: invokevirtual 102	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   107: return
    //   108: astore_1
    //   109: aload_0
    //   110: getfield 55	aumx:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   113: invokevirtual 61	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   116: invokevirtual 102	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   119: aload_1
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	aumx
    //   0	121	1	paramList	List<GPadInfo>
    //   35	6	2	localGPadInfo	GPadInfo
    // Exception table:
    //   from	to	target	type
    //   0	17	47	java/lang/Exception
    //   17	44	47	java/lang/Exception
    //   87	97	47	java/lang/Exception
    //   0	17	108	finally
    //   17	44	108	finally
    //   48	76	108	finally
    //   87	97	108	finally
  }
  
  /* Error */
  private void mC(List<GroupPadTemplateInfo> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 55	aumx:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   4: invokevirtual 61	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   7: invokevirtual 66	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   10: aload_1
    //   11: invokeinterface 72 1 0
    //   16: astore_1
    //   17: aload_1
    //   18: invokeinterface 78 1 0
    //   23: ifeq +64 -> 87
    //   26: aload_1
    //   27: invokeinterface 82 1 0
    //   32: checkcast 110	com/tencent/tim/teamworkforgroup/GroupPadTemplateInfo
    //   35: astore_2
    //   36: aload_0
    //   37: getfield 55	aumx:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   40: aload_2
    //   41: invokevirtual 88	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   44: goto -27 -> 17
    //   47: astore_1
    //   48: ldc 90
    //   50: iconst_1
    //   51: new 28	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   58: ldc 112
    //   60: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_1
    //   64: invokevirtual 93	java/lang/Exception:toString	()Ljava/lang/String;
    //   67: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload_0
    //   77: getfield 55	aumx:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   80: invokevirtual 61	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   83: invokevirtual 102	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   86: return
    //   87: aload_0
    //   88: getfield 55	aumx:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   91: invokevirtual 61	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   94: invokevirtual 105	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   97: aload_0
    //   98: getfield 55	aumx:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   101: invokevirtual 61	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   104: invokevirtual 102	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   107: return
    //   108: astore_1
    //   109: aload_0
    //   110: getfield 55	aumx:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   113: invokevirtual 61	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   116: invokevirtual 102	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   119: aload_1
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	aumx
    //   0	121	1	paramList	List<GroupPadTemplateInfo>
    //   35	6	2	localGroupPadTemplateInfo	GroupPadTemplateInfo
    // Exception table:
    //   from	to	target	type
    //   0	17	47	java/lang/Exception
    //   17	44	47	java/lang/Exception
    //   87	97	47	java/lang/Exception
    //   0	17	108	finally
    //   17	44	108	finally
    //   48	76	108	finally
    //   87	97	108	finally
  }
  
  public static void o(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext = paramString2;
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext = paramString2 + "_" + paramString1;
    }
    localEditor.putString(paramContext, paramString3);
    localEditor.commit();
  }
  
  public ConcurrentHashMap<String, Entity> C()
  {
    return this.iy;
  }
  
  public void X(int paramInt, List<GPadInfo> paramList)
  {
    if (paramInt == 2) {
      dUj();
    }
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        GPadInfo localGPadInfo = (GPadInfo)localIterator.next();
        this.iy.put(ault.nT(localGPadInfo.pad_url), localGPadInfo);
      }
      mB(paramList);
    }
  }
  
  public GPadInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = ault.nT(paramString);
    return (GPadInfo)this.iy.get(paramString);
  }
  
  public void a(GroupPadTemplateInfo paramGroupPadTemplateInfo)
  {
    if ((paramGroupPadTemplateInfo == null) || (TextUtils.isEmpty(paramGroupPadTemplateInfo.templateUrl))) {
      return;
    }
    this.iz.put(paramGroupPadTemplateInfo.templateUrl, paramGroupPadTemplateInfo);
    a(paramGroupPadTemplateInfo);
  }
  
  public boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntity.getStatus() == 1000)
    {
      this.mEntityManager.persistOrReplace(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return bool;
    }
    return this.mEntityManager.update(paramEntity);
  }
  
  public void bk(long paramLong)
  {
    Object localObject4;
    try
    {
      this.iy.clear();
      Object localObject1 = this.mEntityManager.query(GPadInfo.class, false, "groupCode=?", new String[] { String.valueOf(paramLong) }, null, null, null, null);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = (GPadInfo)((Iterator)localObject1).next();
          this.iy.put(ault.nT(((GPadInfo)localObject4).pad_url), localObject4);
        }
      }
      this.iz.clear();
    }
    finally {}
    Object localObject3 = this.mEntityManager.query(GroupPadTemplateInfo.class, false, "groupCode=?", new String[] { "" + paramLong }, null, null, null, null);
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (GroupPadTemplateInfo)((Iterator)localObject3).next();
        this.iz.put(((GroupPadTemplateInfo)localObject4).templateUrl, localObject4);
      }
    }
  }
  
  public void dUj()
  {
    this.mEntityManager.drop(GPadInfo.class);
    this.iy.clear();
  }
  
  public void dUk()
  {
    this.mEntityManager.drop(GroupPadTemplateInfo.class);
    this.iz.clear();
  }
  
  public List<GPadInfo> gu()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.iy != null)
    {
      Iterator localIterator = this.iy.values().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((GPadInfo)localIterator.next());
      }
    }
    return localArrayList;
  }
  
  public List<GroupPadTemplateInfo> gv()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.iz != null)
    {
      Iterator localIterator = this.iz.values().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((GroupPadTemplateInfo)localIterator.next());
      }
    }
    return localArrayList;
  }
  
  public void mA(List<GroupPadTemplateInfo> paramList)
  {
    if (this.iz != null) {
      dUk();
    }
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        GroupPadTemplateInfo localGroupPadTemplateInfo = (GroupPadTemplateInfo)localIterator.next();
        this.iz.put(localGroupPadTemplateInfo.templateUrl, localGroupPadTemplateInfo);
      }
      mC(paramList);
      mD(paramList);
    }
  }
  
  /* Error */
  public void mD(List<GroupPadTemplateInfo> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +80 -> 81
    //   4: aload_0
    //   5: getfield 55	aumx:mEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   8: invokevirtual 61	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   11: astore_2
    //   12: aload_2
    //   13: invokevirtual 66	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   16: aload_1
    //   17: invokeinterface 72 1 0
    //   22: astore_1
    //   23: aload_1
    //   24: invokeinterface 78 1 0
    //   29: ifeq +53 -> 82
    //   32: aload_0
    //   33: aload_1
    //   34: invokeinterface 82 1 0
    //   39: checkcast 110	com/tencent/tim/teamworkforgroup/GroupPadTemplateInfo
    //   42: invokevirtual 242	aumx:a	(Lcom/tencent/tim/teamworkforgroup/GroupPadTemplateInfo;)V
    //   45: goto -22 -> 23
    //   48: astore_1
    //   49: ldc 90
    //   51: iconst_1
    //   52: new 28	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   59: ldc 244
    //   61: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_1
    //   65: invokevirtual 93	java/lang/Exception:toString	()Ljava/lang/String;
    //   68: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload_2
    //   78: invokevirtual 102	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   81: return
    //   82: aload_2
    //   83: invokevirtual 102	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   86: return
    //   87: astore_1
    //   88: aload_2
    //   89: invokevirtual 102	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	aumx
    //   0	94	1	paramList	List<GroupPadTemplateInfo>
    //   11	78	2	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    // Exception table:
    //   from	to	target	type
    //   16	23	48	java/lang/Exception
    //   23	45	48	java/lang/Exception
    //   16	23	87	finally
    //   23	45	87	finally
    //   49	77	87	finally
  }
  
  public void onDestroy()
  {
    if ((this.mEntityManager != null) && (this.mEntityManager.isOpen())) {
      this.mEntityManager.close();
    }
    this.iy.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aumx
 * JD-Core Version:    0.7.0.1
 */