import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.a;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.b;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionResDownload.1;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class adby
{
  final String TAG;
  PromotionConfigInfo b;
  ArrayList<adby.a> uc = new ArrayList();
  
  public adby(long paramLong)
  {
    this.TAG = ("ARPromotionResDownload_" + paramLong);
  }
  
  static PromotionConfigInfo.b a(boolean paramBoolean, PromotionConfigInfo paramPromotionConfigInfo)
  {
    Iterator localIterator = paramPromotionConfigInfo.operationInfos.entrySet().iterator();
    PromotionConfigInfo.b localb = null;
    while (localIterator.hasNext())
    {
      PromotionConfigInfo.a locala = (PromotionConfigInfo.a)((Map.Entry)localIterator.next()).getValue();
      if (!adca.isExpired(locala.end))
      {
        localb = a(paramBoolean, paramPromotionConfigInfo.mUin, locala);
        if (localb != null) {
          return localb;
        }
      }
    }
    return localb;
  }
  
  static PromotionConfigInfo.b a(boolean paramBoolean, PromotionConfigInfo paramPromotionConfigInfo, PromotionConfigInfo.a parama)
  {
    PromotionConfigInfo.b localb = a(paramBoolean, paramPromotionConfigInfo.mUin, parama);
    parama = localb;
    if (localb == null)
    {
      parama = localb;
      if (paramBoolean) {
        parama = a(paramBoolean, paramPromotionConfigInfo);
      }
    }
    return parama;
  }
  
  public static PromotionConfigInfo.b a(boolean paramBoolean, String paramString, PromotionConfigInfo.a parama)
  {
    parama = parama.b().entrySet().iterator();
    while (parama.hasNext())
    {
      PromotionConfigInfo.b localb = (PromotionConfigInfo.b)((Map.Entry)parama.next()).getValue();
      if (localb.downloadType == -1)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(adca.TAG, 1, "isPromotionResReady, 已经下载失败了, id[" + localb.id + "], index[" + localb.index + "]");
        }
      }
      else if ((paramBoolean) && (localb.cCa == 0))
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(adca.TAG, 1, "isPromotionResReady, 无需预下载, id[" + localb.id + "], index[" + localb.index + "]");
        }
      }
      else if (!a(paramString, localb)) {
        return localb;
      }
    }
    return null;
  }
  
  private void a(String paramString1, boolean paramBoolean, AppInterface paramAppInterface, String paramString2, int paramInt, PromotionConfigInfo.b paramb)
  {
    if ((b() == null) || (paramb == null))
    {
      ah(paramString2, paramInt, -3);
      return;
    }
    paramString2 = a(paramAppInterface, paramb);
    paramb.RX = System.currentTimeMillis();
    Object localObject1 = (aopo)paramAppInterface.getManager(193);
    ((aopo)localObject1).a(paramb.url);
    ((aopo)localObject1).be(paramb.url, 0L);
    localObject1 = paramb.zipFilePath;
    if (a(paramAppInterface.getAccount(), paramb))
    {
      paramAppInterface = paramb.cM;
      if (!paramBoolean) {}
      try
      {
        paramb.bLi = false;
        QLog.w(this.TAG, 1, "innerDownloadRes[" + paramString1 + "], 资源已经存在, callByPreDownload[" + paramBoolean + "], item[" + paramb + "], zipPath[" + (String)localObject1 + "]");
        paramb.setDownloadType(2);
        paramString2.a(paramb.url, paramb.md5, 100, (String)localObject1, paramb);
        return;
      }
      finally {}
    }
    Object localObject2 = paramb.cM;
    if (!paramBoolean) {}
    for (;;)
    {
      try
      {
        paramb.bLi = false;
        if (paramb.downloadType == 1)
        {
          QLog.w(this.TAG, 1, "innerDownloadRes[" + paramString1 + "], 已经在下载中, callByPreDownload[" + paramBoolean + "], item[" + paramb + "], zipPath[" + (String)localObject1 + "]");
          return;
        }
      }
      finally {}
      paramb.setDownloadType(1);
      boolean bool = ((aduq)paramAppInterface.getManager(191)).a(paramb.url, paramb.md5, ".zip", true, 5, paramb, paramb.a);
      QLog.w(this.TAG, 1, "innerDownloadRes[" + paramString1 + "], 开始下载, callByPreDownload[" + paramBoolean + "], ret[" + bool + "], item[" + paramb + "]");
      if (!bool) {
        paramString2.a(paramb.url, paramb.md5, -4, null, paramb);
      }
    }
  }
  
  static boolean a(PromotionConfigInfo.b paramb)
  {
    if (paramb.index == 0)
    {
      String str = adbx.a(paramb);
      if (!new File(str + "entry.png").exists()) {
        if (QLog.isDevelopLevel()) {
          QLog.w("PromotionResDownload", 1, "文件不存在, path[" + str + "], name[" + "entry.png" + "]");
        }
      }
      do
      {
        do
        {
          return false;
          if (new File(str + "entry.json").exists()) {
            break;
          }
        } while (!QLog.isDevelopLevel());
        QLog.w("PromotionResDownload", 1, "文件不存在, path[" + str + "], name[" + "entry.json" + "]");
        return false;
        paramb = adbx.b(paramb);
        if (new File(paramb + "guide.json").exists()) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.w("PromotionResDownload", 1, "文件不存在, path[" + paramb + "], name[" + "guide.json" + "]");
      return false;
    }
    if (paramb.index == 1) {}
    return true;
  }
  
  public static boolean a(String paramString, PromotionConfigInfo.b paramb)
  {
    String str = paramb.brM;
    if (aqny.b(paramString, paramb.id, paramb.index, paramb.md5, str)) {
      return a(paramb);
    }
    return false;
  }
  
  private ArrayList<adby.a> cK()
  {
    ArrayList localArrayList2 = new ArrayList();
    synchronized (this.uc)
    {
      localArrayList2.addAll(this.uc);
      return localArrayList2;
    }
  }
  
  /* Error */
  aduq.b a(AppInterface paramAppInterface, PromotionConfigInfo.b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: getfield 230	com/tencent/mobileqq/ar/ARPromotionMgr/PromotionConfigInfo$b:a	Laduq$b;
    //   6: ifnull +12 -> 18
    //   9: aload_2
    //   10: getfield 230	com/tencent/mobileqq/ar/ARPromotionMgr/PromotionConfigInfo$b:a	Laduq$b;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_2
    //   19: getfield 123	com/tencent/mobileqq/ar/ARPromotionMgr/PromotionConfigInfo$b:index	I
    //   22: istore_3
    //   23: aload_2
    //   24: new 285	adbz
    //   27: dup
    //   28: aload_0
    //   29: aload_1
    //   30: aload_2
    //   31: getfield 118	com/tencent/mobileqq/ar/ARPromotionMgr/PromotionConfigInfo$b:id	Ljava/lang/String;
    //   34: iload_3
    //   35: invokespecial 288	adbz:<init>	(Ladby;Lcom/tencent/common/app/AppInterface;Ljava/lang/String;I)V
    //   38: putfield 230	com/tencent/mobileqq/ar/ARPromotionMgr/PromotionConfigInfo$b:a	Laduq$b;
    //   41: aload_2
    //   42: getfield 230	com/tencent/mobileqq/ar/ARPromotionMgr/PromotionConfigInfo$b:a	Laduq$b;
    //   45: astore_1
    //   46: goto -32 -> 14
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	adby
    //   0	54	1	paramAppInterface	AppInterface
    //   0	54	2	paramb	PromotionConfigInfo.b
    //   22	13	3	i	int
    // Exception table:
    //   from	to	target	type
    //   2	14	49	finally
    //   18	46	49	finally
  }
  
  public void a(adby.a parama)
  {
    synchronized (this.uc)
    {
      this.uc.add(parama);
      return;
    }
  }
  
  void a(AppInterface paramAppInterface, boolean paramBoolean, String paramString, int paramInt)
  {
    Object localObject1 = b();
    if (localObject1 == null) {
      QLog.w(this.TAG, 1, "requestPreDownload, ConfigInfo为空, callByPreDownload[" + paramBoolean + "], activatyid[" + paramString + "], index[" + paramInt + "]");
    }
    do
    {
      Object localObject2;
      for (;;)
      {
        return;
        if (!(paramAppInterface instanceof QQAppInterface))
        {
          QLog.w(this.TAG, 1, "requestPreDownload, 不在主进程");
          return;
        }
        localObject2 = ((PromotionConfigInfo)localObject1).getItem(paramString);
        if (localObject2 == null)
        {
          ah(paramString, paramInt, -3);
          return;
        }
        localObject1 = a(paramBoolean, (PromotionConfigInfo)localObject1, (PromotionConfigInfo.a)localObject2);
        QLog.w(this.TAG, 1, "requestPreDownload, expectID[" + paramString + "], expectIndex[" + paramInt + "], callByPreDownload[" + paramBoolean + "], zipItem[" + localObject1 + "]");
        if (localObject1 != null) {
          break;
        }
        paramAppInterface = ((PromotionConfigInfo.a)localObject2).b().entrySet().iterator();
        while (paramAppInterface.hasNext()) {
          ah(paramString, ((PromotionConfigInfo.b)((Map.Entry)paramAppInterface.next()).getValue()).index, 100);
        }
      }
      paramString = ((PromotionConfigInfo.b)localObject1).md5;
      if (!paramBoolean) {
        break;
      }
      if (((PromotionConfigInfo.b)localObject1).cCa != 0)
      {
        localObject2 = new aopp((QQAppInterface)paramAppInterface, paramString, new PromotionResDownload.1(this, paramBoolean, paramAppInterface, (PromotionConfigInfo.b)localObject1), 0L);
        paramBoolean = ((aopo)paramAppInterface.getManager(193)).a(10074, "prd", paramString, 0, ((PromotionConfigInfo.b)localObject1).url, ((PromotionConfigInfo.b)localObject1).zipFilePath, ((PromotionConfigInfo.b)localObject1).cCa, 0, true, (aopm)localObject2);
        ((PromotionConfigInfo.b)localObject1).RW = System.currentTimeMillis();
        QLog.w(this.TAG, 1, "requestPreDownload, 预下载申请调度, ret[" + paramBoolean + "], index[" + ((PromotionConfigInfo.b)localObject1).index + "]");
        return;
      }
    } while (!AudioHelper.aCz());
    QLog.w(this.TAG, 1, "requestPreDownload, 无需预下载，id[" + ((PromotionConfigInfo.b)localObject1).id + "], index[" + ((PromotionConfigInfo.b)localObject1).index + "]");
    return;
    a(acfp.m(2131709985), paramBoolean, paramAppInterface, ((PromotionConfigInfo.b)localObject1).id, ((PromotionConfigInfo.b)localObject1).index, (PromotionConfigInfo.b)localObject1);
  }
  
  void ah(String paramString, int paramInt1, int paramInt2)
  {
    ai(paramString, paramInt1, paramInt2);
    BusinessCommonConfig.sendDownloadResultNotify(2, paramString, paramInt1, paramInt2);
  }
  
  void ai(String paramString, int paramInt1, int paramInt2)
  {
    Iterator localIterator = cK().iterator();
    while (localIterator.hasNext()) {
      ((adby.a)localIterator.next()).aj(paramString, paramInt1, paramInt2);
    }
  }
  
  PromotionConfigInfo b()
  {
    return this.b;
  }
  
  public void b(adby.a parama)
  {
    synchronized (this.uc)
    {
      this.uc.remove(parama);
      return;
    }
  }
  
  void c(PromotionConfigInfo paramPromotionConfigInfo)
  {
    if ((paramPromotionConfigInfo == null) || (paramPromotionConfigInfo.operationInfos == null)) {
      return;
    }
    this.b = paramPromotionConfigInfo;
    paramPromotionConfigInfo = paramPromotionConfigInfo.operationInfos.entrySet().iterator();
    while (paramPromotionConfigInfo.hasNext())
    {
      Iterator localIterator = ((PromotionConfigInfo.a)((Map.Entry)paramPromotionConfigInfo.next()).getValue()).b().entrySet().iterator();
      while (localIterator.hasNext()) {
        ((PromotionConfigInfo.b)((Map.Entry)localIterator.next()).getValue()).cPU();
      }
    }
  }
  
  void cPV()
  {
    Iterator localIterator = cK().iterator();
    while (localIterator.hasNext()) {
      ((adby.a)localIterator.next()).cPW();
    }
  }
  
  public void destroy()
  {
    this.b = null;
  }
  
  public static abstract interface a
  {
    public abstract void aj(String paramString, int paramInt1, int paramInt2);
    
    public abstract void cPW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adby
 * JD-Core Version:    0.7.0.1
 */