import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.tofumsg.TofuItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfo;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfoResult;

public class aohq
  implements Handler.Callback, Manager
{
  aoht a = new aohr(this);
  QQAppInterface app;
  aixa<aoho, QQAppInterface> d;
  Set<String> de;
  EntityManager em;
  Handler handler;
  HashMap<String, List<TofuItem>> nO;
  
  public aohq(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.handler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.d = new aohs(this);
    this.de = Collections.synchronizedSet(new HashSet());
    this.nO = new HashMap();
    this.em = paramQQAppInterface.a().createEntityManager();
    paramQQAppInterface.addObserver(this.a, true);
  }
  
  private void RR(String paramString)
  {
    List localList = aT(paramString);
    boolean bool = e(paramString, localList);
    if (!bool) {
      this.de.remove(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.i("Tofu_TofuManager", 2, String.format("WHAT_PREPARE_PULL_TOFUDATA uin=%s reqSize=%d hasReq=%b", new Object[] { MobileQQ.getShortUinStr(paramString), Integer.valueOf(localList.size()), Boolean.valueOf(bool) }));
    }
  }
  
  private static TofuItem a(List<TofuItem> paramList, int paramInt)
  {
    if (paramList == null) {
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TofuItem localTofuItem = (TofuItem)paramList.next();
      if (localTofuItem.busId == paramInt) {
        return localTofuItem;
      }
    }
    return null;
  }
  
  private void h(boolean paramBoolean, String paramString, List<oidb_0xe61.BeancurdCubeInfoResult> paramList)
  {
    List localList;
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0)) {
      localList = aU(paramString);
    }
    try
    {
      wkh localwkh = (wkh)this.app.getManager(282);
      a(paramList, new aohk(this.app, localwkh, this.d));
      paramBoolean = a(paramString, paramList, localList);
      if (localList.size() > 0) {
        f(paramString, localList, paramBoolean);
      }
      if (QLog.isColorLevel()) {
        QLog.i("Tofu_TofuManager", 2, String.format("WHAT_GET_PULLED_DATA frdUin=%s", new Object[] { MobileQQ.getShortUinStr(paramString) }));
      }
      this.de.remove(paramString);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private boolean updateEntity(EntityManager paramEntityManager, Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntityManager.isOpen()) {
      if (paramEntity.getStatus() == 1000)
      {
        paramEntityManager.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return bool;
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return paramEntityManager.update(paramEntity);
      }
    }
    QLog.d("Tofu_TofuManager", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  protected void a(List<oidb_0xe61.BeancurdCubeInfoResult> paramList, Comparator paramComparator)
    throws Exception
  {
    if ((paramList == null) || (paramList.size() <= 1)) {
      return;
    }
    Collections.sort(paramList, paramComparator);
  }
  
  protected boolean a(String paramString, List<oidb_0xe61.BeancurdCubeInfoResult> paramList, List<TofuItem> paramList1)
  {
    long l = System.currentTimeMillis() / 1000L;
    Iterator localIterator = paramList.iterator();
    boolean bool = false;
    while (localIterator.hasNext())
    {
      oidb_0xe61.BeancurdCubeInfoResult localBeancurdCubeInfoResult = (oidb_0xe61.BeancurdCubeInfoResult)localIterator.next();
      if ((localBeancurdCubeInfoResult == null) || (!localBeancurdCubeInfoResult.beancurdCubeInfo.has()) || (localBeancurdCubeInfoResult.beancurdCubeInfo.get() == null) || (!localBeancurdCubeInfoResult.beancurdCubeInfo.uint64_busi_id.has())) {
        break label183;
      }
      int i = aohm.jy((int)((oidb_0xe61.BeancurdCubeInfo)localBeancurdCubeInfoResult.beancurdCubeInfo.get()).uint64_busi_id.get());
      if (i != -1)
      {
        paramList = a(paramList1, i);
        if (paramList != null) {
          break label180;
        }
        paramList = new TofuItem(paramString, i);
        paramList1.add(paramList);
        bool = true;
        label145:
        ((aoho)this.d.get(this.app)).a(i).a(paramList, localBeancurdCubeInfoResult, l);
      }
    }
    label180:
    label183:
    for (;;)
    {
      break;
      return bool;
      break label145;
    }
  }
  
  @NotNull
  protected List<TofuItem> aT(String paramString)
  {
    List localList = aU(paramString);
    ArrayList localArrayList = new ArrayList(aohm.ou.length);
    long l = System.currentTimeMillis() / 1000L;
    int i = 0;
    TofuItem localTofuItem;
    aohl localaohl;
    if (i < aohm.ou.length)
    {
      localTofuItem = a(localList, i);
      localaohl = ((aoho)this.d.get(this.app)).a(i);
      if (localTofuItem != null) {
        break label119;
      }
      localTofuItem = new TofuItem(paramString, i);
    }
    label119:
    for (;;)
    {
      localTofuItem = localaohl.a(localTofuItem, l);
      if (localTofuItem != null) {
        localArrayList.add(localTofuItem);
      }
      i += 1;
      break;
      return localArrayList;
    }
  }
  
  @NotNull
  protected List<TofuItem> aU(String paramString)
  {
    Object localObject1 = (List)this.nO.get(paramString);
    if (localObject1 == null)
    {
      long l = System.currentTimeMillis();
      try
      {
        localObject2 = this.em.query(TofuItem.class, false, "frdUin=?", new String[] { paramString }, null, null, null, null);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          QLog.d("Tofu_TofuManager", 1, "readTofuItems exception + " + localException.getMessage(), localException);
          continue;
          int i = localException.size();
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new ArrayList(aohm.ou.length);
      }
      this.nO.put(paramString, localObject2);
      if (QLog.isColorLevel())
      {
        paramString = MobileQQ.getShortUinStr(paramString);
        if (localObject2 == null)
        {
          i = 0;
          QLog.i("Tofu_TofuManager", 2, String.format("readTofuItems %s size=%d cost=%dms", new Object[] { paramString, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) }));
        }
      }
      else
      {
        return localObject2;
      }
    }
    return localObject1;
  }
  
  protected boolean e(String paramString, List<TofuItem> paramList)
  {
    if ((paramList.size() == 0) || (!aqiw.isNetworkAvailable())) {
      return false;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (TofuItem)paramList.next();
      oidb_0xe61.BeancurdCubeInfo localBeancurdCubeInfo = ((TofuItem)localObject).packToPbReq();
      localObject = ((aoho)this.d.get(this.app)).a(((TofuItem)localObject).busId).a((TofuItem)localObject);
      if (localObject != null) {
        localBeancurdCubeInfo.bytes_busi_data_req.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      localArrayList.add(localBeancurdCubeInfo);
    }
    ((aohp)this.app.getBusinessHandler(177)).S(paramString, localArrayList);
    return true;
  }
  
  /* Error */
  protected void f(String paramString, List<TofuItem> paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 255	java/lang/System:currentTimeMillis	()J
    //   3: lstore 4
    //   5: aload_0
    //   6: getfield 86	aohq:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   9: invokevirtual 395	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   12: astore 6
    //   14: aload 6
    //   16: invokevirtual 400	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   19: aload_2
    //   20: invokeinterface 155 1 0
    //   25: astore 7
    //   27: aload 7
    //   29: invokeinterface 160 1 0
    //   34: ifeq +140 -> 174
    //   37: aload 7
    //   39: invokeinterface 164 1 0
    //   44: checkcast 166	com/tencent/mobileqq/tofumsg/TofuItem
    //   47: astore 8
    //   49: aload_0
    //   50: aload_0
    //   51: getfield 86	aohq:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   54: aload 8
    //   56: invokespecial 402	aohq:updateEntity	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   59: pop
    //   60: goto -33 -> 27
    //   63: astore 7
    //   65: ldc 115
    //   67: iconst_1
    //   68: new 228	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   75: ldc_w 404
    //   78: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload 7
    //   83: invokevirtual 349	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   86: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: aload 7
    //   94: invokestatic 352	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   97: aload 6
    //   99: invokevirtual 407	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   102: iload_3
    //   103: ifeq +13 -> 116
    //   106: aload_0
    //   107: getfield 73	aohq:nO	Ljava/util/HashMap;
    //   110: aload_1
    //   111: aload_2
    //   112: invokevirtual 337	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   115: pop
    //   116: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +54 -> 173
    //   122: ldc 115
    //   124: iconst_2
    //   125: ldc_w 409
    //   128: iconst_4
    //   129: anewarray 4	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: aload_1
    //   135: aastore
    //   136: dup
    //   137: iconst_1
    //   138: aload_2
    //   139: invokeinterface 129 1 0
    //   144: invokestatic 135	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   147: aastore
    //   148: dup
    //   149: iconst_2
    //   150: invokestatic 255	java/lang/System:currentTimeMillis	()J
    //   153: lload 4
    //   155: lsub
    //   156: invokestatic 344	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   159: aastore
    //   160: dup
    //   161: iconst_3
    //   162: iload_3
    //   163: invokestatic 140	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   166: aastore
    //   167: invokestatic 146	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   170: invokestatic 150	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: return
    //   174: aload 6
    //   176: invokevirtual 412	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   179: aload 6
    //   181: invokevirtual 407	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   184: goto -82 -> 102
    //   187: astore_1
    //   188: aload 6
    //   190: invokevirtual 407	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   193: aload_1
    //   194: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	aohq
    //   0	195	1	paramString	String
    //   0	195	2	paramList	List<TofuItem>
    //   0	195	3	paramBoolean	boolean
    //   3	151	4	l	long
    //   12	177	6	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   25	13	7	localIterator	Iterator
    //   63	30	7	localException	Exception
    //   47	8	8	localTofuItem	TofuItem
    // Exception table:
    //   from	to	target	type
    //   19	27	63	java/lang/Exception
    //   27	60	63	java/lang/Exception
    //   174	179	63	java/lang/Exception
    //   19	27	187	finally
    //   27	60	187	finally
    //   65	97	187	finally
    //   174	179	187	finally
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      RR((String)paramMessage.obj);
      return false;
    }
    paramMessage = (Object[])paramMessage.obj;
    h(((Boolean)paramMessage[0]).booleanValue(), (String)paramMessage[1], (List)paramMessage[2]);
    return false;
  }
  
  public void onDestroy()
  {
    this.em.close();
    this.app.removeObserver(this.a);
    this.handler.removeCallbacksAndMessages(null);
    ((aoho)this.d.get(this.app)).destroy();
  }
  
  public boolean qa(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equalsIgnoreCase(this.app.getCurrentAccountUin())) || (this.de.contains(paramString)))
    {
      QLog.i("Tofu_TofuManager", 1, "startCheckPullTofuData return");
      return false;
    }
    QLog.i("Tofu_TofuManager", 1, "startCheckPullTofuData frdUin=" + MobileQQ.getShortUinStr(paramString));
    this.de.add(paramString);
    this.handler.obtainMessage(0, paramString).sendToTarget();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aohq
 * JD-Core Version:    0.7.0.1
 */