import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileIPv6Detecter.1;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class agkd
{
  private Map<String, agkd.a> kz = new HashMap();
  private String mSelfUin = "";
  private Executor n;
  
  private agkd.a a(agke.a parama)
  {
    if ((parama == null) || (parama.mDomain == null)) {
      return null;
    }
    synchronized (this.kz)
    {
      parama = (agkd.a)this.kz.get(parama.mDomain);
      return parama;
    }
  }
  
  private void a(agke.a parama, agkd.a parama1)
  {
    synchronized (this.kz)
    {
      this.kz.put(parama.mDomain, parama1);
      return;
    }
  }
  
  private boolean a(agke.a parama, agke.b paramb)
  {
    if ((parama == null) || (TextUtils.isEmpty(parama.mDomain)) || (paramb == null) || (TextUtils.isEmpty(paramb.mIp))) {
      QLog.e("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] delectDomainConn err. param=null");
    }
    long l;
    do
    {
      return false;
      l = System.currentTimeMillis();
      QLog.i("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] start delectIP [" + parama.mDomain + ":" + parama.mPort + "] ipInfo[" + paramb.mIp + ":" + paramb.mPort + "]");
      dhj();
    } while (this.n == null);
    this.n.execute(new FileIPv6Detecter.1(this, paramb, l, parama));
    return true;
  }
  
  private void d(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    int k = 0;
    int i = 2;
    int j;
    label51:
    HashMap localHashMap;
    if (MsfServiceSdk.get().getConnectedIPFamily() == 2)
    {
      j = 2;
      switch (ahbr.getIPStackType())
      {
      default: 
        i = 0;
      case 3: 
        localHashMap = new HashMap();
        localHashMap.put("param_domain", String.valueOf(paramString1));
        localHashMap.put("param_ipAddr", String.valueOf(paramString2));
        localHashMap.put("param_port", String.valueOf(paramInt));
        if (!paramBoolean) {
          break;
        }
      }
    }
    for (paramInt = k;; paramInt = 1)
    {
      localHashMap.put("param_result", String.valueOf(paramInt));
      localHashMap.put("param_stackType", String.valueOf(i));
      localHashMap.put("param_loginType", String.valueOf(j));
      anpc.a(BaseApplication.getContext()).collectPerformance(this.mSelfUin, "actFAIPConnect", true, 0L, 0L, localHashMap, null);
      QLog.d("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] >> reportDetectConnResult:" + localHashMap.toString());
      return;
      j = 1;
      break;
      i = 1;
      break label51;
      i = 3;
      break label51;
    }
  }
  
  private void dhi()
  {
    synchronized (this.kz)
    {
      this.kz.clear();
      return;
    }
  }
  
  /* Error */
  private void dhj()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 116	agkd:n	Ljava/util/concurrent/Executor;
    //   6: ifnonnull +38 -> 44
    //   9: ldc 67
    //   11: iconst_1
    //   12: ldc 193
    //   14: invokestatic 111	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: new 195	com/tencent/mobileqq/app/ThreadPoolParams
    //   20: dup
    //   21: invokespecial 196	com/tencent/mobileqq/app/ThreadPoolParams:<init>	()V
    //   24: astore_1
    //   25: aload_1
    //   26: iconst_5
    //   27: putfield 199	com/tencent/mobileqq/app/ThreadPoolParams:priority	I
    //   30: aload_1
    //   31: ldc 201
    //   33: putfield 204	com/tencent/mobileqq/app/ThreadPoolParams:poolThreadName	Ljava/lang/String;
    //   36: aload_0
    //   37: aload_1
    //   38: invokestatic 210	com/tencent/mobileqq/app/ThreadManager:newFreeThreadPool	(Lcom/tencent/mobileqq/app/ThreadPoolParams;)Ljava/util/concurrent/Executor;
    //   41: putfield 116	agkd:n	Ljava/util/concurrent/Executor;
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: astore_1
    //   48: ldc 67
    //   50: iconst_1
    //   51: new 83	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   58: ldc 212
    //   60: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_1
    //   64: invokevirtual 213	java/lang/Exception:toString	()Ljava/lang/String;
    //   67: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: goto -32 -> 44
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	agkd
    //   24	14	1	localThreadPoolParams	com.tencent.mobileqq.app.ThreadPoolParams
    //   47	17	1	localException	java.lang.Exception
    //   79	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	44	47	java/lang/Exception
    //   2	17	79	finally
    //   17	44	79	finally
    //   48	76	79	finally
  }
  
  public void a(QQAppInterface paramQQAppInterface, agke.a parama, agke.b paramb)
  {
    if ((parama == null) || (TextUtils.isEmpty(parama.mDomain)) || (paramb == null) || (TextUtils.isEmpty(paramb.mIp))) {
      QLog.e("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] detectV6Domain err. param=null");
    }
    if (paramQQAppInterface != null) {
      this.mSelfUin = paramQQAppInterface.getCurrentUin();
    }
    long l = System.currentTimeMillis();
    paramQQAppInterface = a(parama);
    if (paramQQAppInterface != null)
    {
      if ((paramQQAppInterface.cdH) || (paramQQAppInterface.cdI)) {}
      while (l - paramQQAppInterface.YC <= 600000L) {
        return;
      }
    }
    if (a(parama, paramb))
    {
      paramQQAppInterface = new agkd.a();
      paramQQAppInterface.cdI = true;
      paramQQAppInterface.b = paramb;
      paramQQAppInterface.YC = l;
      a(parama, paramQQAppInterface);
      return;
    }
    QLog.e("FileIPv6Detecter<FileAssistant>", 1, "[IPv6-File] delectIP err");
  }
  
  public boolean a(agke.a parama)
  {
    parama = a(parama);
    if (parama != null) {
      return parama.cdH;
    }
    return false;
  }
  
  public void onNetChanged()
  {
    dhi();
  }
  
  public class a
  {
    long YC = 0L;
    agke.b b;
    public volatile boolean cdH = false;
    public volatile boolean cdI = false;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agkd
 * JD-Core Version:    0.7.0.1
 */