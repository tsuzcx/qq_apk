package com.tencent.mobileqq.msf.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteException;
import com.tencent.mobileqq.msf.core.j;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IBaseActionListener;
import com.tencent.qphone.base.remote.IBaseService;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

class s
{
  private static final String a = "MSF.D.RemoteServiceProxy";
  protected static ConcurrentLinkedQueue f = new ConcurrentLinkedQueue();
  protected static ConcurrentHashMap g = new ConcurrentHashMap();
  static final String k = "appTimeoutReq";
  protected volatile IBaseService d;
  protected Object e = new Object();
  protected volatile Handler h;
  protected volatile long i = -1L;
  AtomicInteger j = new AtomicInteger();
  String l;
  protected ServiceConnection m = new t(this);
  
  public s(String paramString)
  {
    this.l = paramString;
  }
  
  protected int a(ToServiceMsg paramToServiceMsg)
    throws RemoteException
  {
    return this.d.sendToServiceMsg(paramToServiceMsg);
  }
  
  protected FromServiceMsg a(ToServiceMsg paramToServiceMsg, String paramString)
  {
    paramToServiceMsg = j.a(paramToServiceMsg);
    paramToServiceMsg.setBusinessFail(1013, paramString);
    return paramToServiceMsg;
  }
  
  void a()
  {
    try
    {
      ComponentName localComponentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.l);
      Intent localIntent = new Intent();
      localIntent.setComponent(localComponentName);
      BaseApplication.getContext().startService(localIntent);
      QLog.d("MSF.D.RemoteServiceProxy", 2, " start service finish");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    c(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public int b(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return -1;
    }
    if (paramToServiceMsg.getAppSeq() < 0) {
      paramToServiceMsg.setAppSeq(MsfSdkUtils.getNextAppSeq());
    }
    try
    {
      synchronized (this.e)
      {
        if (this.h == null)
        {
          HandlerThread localHandlerThread = new HandlerThread("Timeout-Checker", 5);
          localHandlerThread.start();
          this.h = new Handler(localHandlerThread.getLooper());
        }
        int n;
        if (h())
        {
          n = 1;
          if (paramToServiceMsg.getTimeout() == -1L) {
            paramToServiceMsg.setTimeout(30000L);
          }
          if (paramToServiceMsg.isNeedCallback())
          {
            paramToServiceMsg.addAttribute("appTimeoutReq", Integer.valueOf(this.j.incrementAndGet()));
            g.put(Integer.valueOf(paramToServiceMsg.getAppSeq()), paramToServiceMsg);
            ??? = new a(paramToServiceMsg);
            this.h.postDelayed((Runnable)???, paramToServiceMsg.getTimeout() + 2000L);
          }
          if (n != 0)
          {
            n = a(paramToServiceMsg);
            return n;
          }
        }
        else
        {
          n = 0;
        }
      }
      return -1;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      c(paramToServiceMsg);
      return -1;
      c(paramToServiceMsg);
      synchronized (this.e)
      {
        i();
        return -1;
      }
    }
    catch (Exception localException)
    {
      if (this.d == null)
      {
        c(paramToServiceMsg);
        return -1;
      }
      localException.printStackTrace();
    }
  }
  
  /* Error */
  boolean b()
  {
    // Byte code:
    //   0: new 94	android/content/ComponentName
    //   3: dup
    //   4: invokestatic 100	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   7: invokevirtual 106	android/content/Context:getPackageName	()Ljava/lang/String;
    //   10: aload_0
    //   11: getfield 67	com/tencent/mobileqq/msf/sdk/s:l	Ljava/lang/String;
    //   14: invokespecial 109	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: astore_2
    //   18: new 111	android/content/Intent
    //   21: dup
    //   22: invokespecial 112	android/content/Intent:<init>	()V
    //   25: astore_3
    //   26: aload_3
    //   27: aload_2
    //   28: invokevirtual 116	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   31: pop
    //   32: invokestatic 100	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   35: aload_3
    //   36: aload_0
    //   37: getfield 65	com/tencent/mobileqq/msf/sdk/s:m	Landroid/content/ServiceConnection;
    //   40: iconst_1
    //   41: invokevirtual 226	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   44: istore_1
    //   45: ldc 10
    //   47: iconst_2
    //   48: new 228	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   55: ldc 231
    //   57: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_0
    //   61: getfield 67	com/tencent/mobileqq/msf/sdk/s:l	Ljava/lang/String;
    //   64: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc 237
    //   69: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: iload_1
    //   73: invokevirtual 240	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   76: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: iload_1
    //   83: ireturn
    //   84: astore_2
    //   85: iconst_0
    //   86: istore_1
    //   87: aload_2
    //   88: invokevirtual 130	java/lang/Exception:printStackTrace	()V
    //   91: iload_1
    //   92: ireturn
    //   93: astore_2
    //   94: goto -7 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	s
    //   44	48	1	bool	boolean
    //   17	11	2	localComponentName	ComponentName
    //   84	4	2	localException1	Exception
    //   93	1	2	localException2	Exception
    //   25	11	3	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   0	45	84	java/lang/Exception
    //   45	82	93	java/lang/Exception
  }
  
  protected void c(ToServiceMsg paramToServiceMsg)
  {
    f.add(paramToServiceMsg);
  }
  
  protected void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    try
    {
      paramToServiceMsg.getActionListener().onRecvFromMsg(paramFromServiceMsg);
      return;
    }
    catch (RemoteException paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
    }
  }
  
  public boolean c()
  {
    try
    {
      ComponentName localComponentName = new ComponentName(BaseApplication.getContext(), this.l);
      Intent localIntent = new Intent();
      localIntent.setComponent(localComponentName);
      boolean bool = BaseApplication.getContext().stopService(localIntent);
      QLog.d("MSF.D.RemoteServiceProxy", 2, " stopService " + this.l + " service finished " + bool);
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  protected void d()
  {
    u localu = new u(this);
    localu.setName("handleWaitSendProxyMsgThread");
    localu.start();
  }
  
  public void g()
  {
    try
    {
      BaseApplication.getContext().unbindService(this.m);
      this.d = null;
      QLog.d("MSF.D.RemoteServiceProxy", 2, " unbindService service finished");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected boolean h()
  {
    return this.d != null;
  }
  
  public void i()
  {
    long l1 = System.currentTimeMillis();
    if ((this.i == -1L) || (l1 - this.i > 10000L))
    {
      this.i = l1;
      a();
      b();
      return;
    }
    QLog.d("MSF.D.RemoteServiceProxy", 2, "wait start " + this.l + " service result, skiped...");
  }
  
  protected class a
    implements Runnable
  {
    private ToServiceMsg b;
    
    public a(ToServiceMsg paramToServiceMsg)
    {
      this.b = paramToServiceMsg;
    }
    
    public void run()
    {
      Object localObject = (ToServiceMsg)s.g.get(Integer.valueOf(this.b.getAppSeq()));
      if ((localObject != null) && (((ToServiceMsg)localObject).getAttribute("appTimeoutReq", Integer.valueOf(-1)) == this.b.getAttribute("appTimeoutReq", Integer.valueOf(-2))) && ((ToServiceMsg)s.g.remove(Integer.valueOf(this.b.getAppSeq())) != null))
      {
        QLog.d("MSF.D.RemoteServiceProxy", 2, "found timeout req, appseq is " + this.b.getAppSeq());
        localObject = s.this.a(this.b, this.b.getServiceName() + " timeout");
        s.this.a(this.b, (FromServiceMsg)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.s
 * JD-Core Version:    0.7.0.1
 */