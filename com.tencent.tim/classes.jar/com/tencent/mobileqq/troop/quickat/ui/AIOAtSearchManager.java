package com.tencent.mobileqq.troop.quickat.ui;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import apoo;
import apoo.a;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AIOAtSearchManager
  implements Handler.Callback
{
  private List<ChatHistoryTroopMemberFragment.a> Ia = new ArrayList(0);
  private a a;
  private ConcurrentHashMap<String, Runnable> iO = new ConcurrentHashMap(1);
  private QQAppInterface mApp;
  private Handler mHandler;
  private HandlerThread mHandlerThread;
  private final SessionInfo mSessionInfo;
  private Handler mUIHandler = new Handler(Looper.getMainLooper(), this);
  
  public AIOAtSearchManager(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    this.mApp = paramQQAppInterface;
    this.mSessionInfo = paramSessionInfo;
    this.mHandlerThread = new HandlerThread("AIOAtSearchManager");
    this.mHandlerThread.start();
    this.mHandler = new Handler(this.mHandlerThread.getLooper());
  }
  
  public void a(a parama)
  {
    this.a = parama;
  }
  
  public void cancelAllTask()
  {
    eaN();
    this.mHandlerThread.quit();
    this.mHandler.removeCallbacksAndMessages(null);
    this.mUIHandler.removeCallbacksAndMessages(null);
  }
  
  public void eaN()
  {
    Iterator localIterator = this.iO.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (AtSearchRunnable)this.iO.get(localObject);
      if (localObject != null)
      {
        ((AtSearchRunnable)localObject).stop = true;
        this.mHandler.removeCallbacks((Runnable)localObject);
      }
    }
    this.iO.clear();
    this.mUIHandler.removeMessages(1);
  }
  
  public List<ChatHistoryTroopMemberFragment.a> gA()
  {
    try
    {
      List localList = this.Ia;
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.e("AIOAtSearchManager", 2, "taa handleMessage  " + System.currentTimeMillis());
    }
    if (this.a == null) {}
    do
    {
      do
      {
        return true;
      } while (paramMessage.what != 1);
      paramMessage = (apoo.a)paramMessage.obj;
    } while (!this.iO.containsKey(paramMessage.keyWord));
    this.a.a(paramMessage);
    return true;
  }
  
  /* Error */
  public void mR(List<ChatHistoryTroopMemberFragment.a> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +14 -> 17
    //   6: aload_1
    //   7: invokeinterface 204 1 0
    //   12: istore_2
    //   13: iload_2
    //   14: ifeq +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: aload_1
    //   22: putfield 58	com/tencent/mobileqq/troop/quickat/ui/AIOAtSearchManager:Ia	Ljava/util/List;
    //   25: goto -8 -> 17
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	AIOAtSearchManager
    //   0	33	1	paramList	List<ChatHistoryTroopMemberFragment.a>
    //   12	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	13	28	finally
    //   20	25	28	finally
  }
  
  public void q(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    eaN();
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      AtSearchRunnable localAtSearchRunnable = new AtSearchRunnable(paramString, gA(), this.mUIHandler, this.mApp, paramBoolean1, this.mSessionInfo, paramBoolean2);
      this.iO.put(paramString, localAtSearchRunnable);
      this.mHandler.post(localAtSearchRunnable);
      if (QLog.isColorLevel()) {
        QLog.e("AIOAtSearchManager", 2, "taa putTask: " + System.currentTimeMillis());
      }
      return;
    }
  }
  
  public static class AtSearchRunnable
    implements Runnable
  {
    private List<ChatHistoryTroopMemberFragment.a> Ia;
    private boolean cRD;
    private boolean cRE;
    private final SessionInfo mSessionInfo;
    private Handler mUIHandler;
    private WeakReference<QQAppInterface> n;
    public volatile boolean stop;
    private String wB;
    
    public AtSearchRunnable(String paramString, List<ChatHistoryTroopMemberFragment.a> paramList, Handler paramHandler, QQAppInterface paramQQAppInterface, boolean paramBoolean1, SessionInfo paramSessionInfo, boolean paramBoolean2)
    {
      this.wB = paramString;
      this.Ia = paramList;
      this.mUIHandler = paramHandler;
      this.cRE = paramBoolean1;
      this.n = new WeakReference(paramQQAppInterface);
      this.mSessionInfo = paramSessionInfo;
      this.cRD = paramBoolean2;
    }
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.e("AIOAtSearchManager", 2, "taa AtSearchRunnable start: " + System.currentTimeMillis());
      }
      if (this.stop) {}
      do
      {
        apoo.a locala;
        do
        {
          do
          {
            return;
          } while (this.n.get() == null);
          locala = new apoo(this.Ia).a((QQAppInterface)this.n.get(), this.wB, this.cRE, this.mSessionInfo, this.cRD);
        } while (this.stop);
        Message localMessage = this.mUIHandler.obtainMessage();
        localMessage.what = 1;
        localMessage.obj = locala;
        this.mUIHandler.sendMessage(localMessage);
      } while (!QLog.isColorLevel());
      QLog.e("AIOAtSearchManager", 2, "taa AtSearchRunnable end: " + System.currentTimeMillis());
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(apoo.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AIOAtSearchManager
 * JD-Core Version:    0.7.0.1
 */