package com.tencent.mobileqq.apollo.process.chanel;

import abjm;
import abjp;
import abmm;
import abnn;
import abnz;
import android.os.Bundle;
import android.text.TextUtils;
import auru;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CmGameCmdChannel
{
  private static CmGameCmdChannel a;
  private abnn b;
  private WeakReference<QQAppInterface> mAppRef;
  private abjm mRenderRunners;
  private auru mRequestHandlerThread;
  final List<a> mRequestHandlers;
  
  private CmGameCmdChannel(QQAppInterface paramQQAppInterface)
  {
    this.mAppRef = new WeakReference(paramQQAppInterface);
    this.mRequestHandlers = new ArrayList();
    this.mRenderRunners = new abjm();
    this.b = new abnn(paramQQAppInterface);
    init();
  }
  
  /* Error */
  public static CmGameCmdChannel a(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 58	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:a	Lcom/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel;
    //   6: ifnonnull +23 -> 29
    //   9: new 2	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 59	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   17: putstatic 58	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:a	Lcom/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel;
    //   20: getstatic 58	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:a	Lcom/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel;
    //   23: astore_0
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_0
    //   28: areturn
    //   29: getstatic 58	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:a	Lcom/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel;
    //   32: getfield 35	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:mAppRef	Ljava/lang/ref/WeakReference;
    //   35: invokevirtual 63	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   38: checkcast 65	com/tencent/mobileqq/app/QQAppInterface
    //   41: astore_1
    //   42: aload_1
    //   43: aload_0
    //   44: if_acmpeq -24 -> 20
    //   47: ldc 67
    //   49: iconst_1
    //   50: new 69	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   57: ldc 72
    //   59: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_1
    //   63: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 89	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: getstatic 58	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:a	Lcom/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel;
    //   75: invokevirtual 92	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:onDestroy	()V
    //   78: new 2	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel
    //   81: dup
    //   82: aload_0
    //   83: invokespecial 59	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   86: putstatic 58	com/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel:a	Lcom/tencent/mobileqq/apollo/process/chanel/CmGameCmdChannel;
    //   89: ldc 67
    //   91: iconst_1
    //   92: new 69	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   99: ldc 94
    //   101: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_0
    //   105: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: goto -94 -> 20
    //   117: astore_0
    //   118: ldc 2
    //   120: monitorexit
    //   121: aload_0
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramQQAppInterface	QQAppInterface
    //   41	22	1	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   3	20	117	finally
    //   20	24	117	finally
    //   29	42	117	finally
    //   47	114	117	finally
  }
  
  private void init()
  {
    if (ApolloEngine.BJ()) {
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_ApolloDataChannel", 2, "new ApolloCmdChannel nativeSetDataChannelObj");
      }
    }
    for (;;)
    {
      this.mRequestHandlerThread = new auru(ThreadManager.getSubThreadLooper(), null);
      synchronized (this.mRequestHandlers)
      {
        Collections.sort(this.mRequestHandlers, new abnz(this));
        return;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("apollochannel_ApolloDataChannel", 2, "new ApolloCmdChannel ApolloEngine.isEngineReady() false");
      }
    }
  }
  
  public String a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "{}";
    }
    if (QLog.isColorLevel()) {
      QLog.d("apollochannel_ApolloDataChannel", 2, "[requestData], ,cmd:" + paramString1 + ",reqData:" + paramString2 + ",async:" + paramBoolean);
    }
    ??? = paramString1.trim();
    Object localObject2 = new RequestRunable(this, (String)???, paramString2, paramInt1, paramInt2);
    if (("cs.close_room.local".equals(???)) || ("cs.make_room_min.local".equals(???)) || ("cs.share_game_result.local".equals(???)) || ("cs.invite_friends.local".equals(paramString1)) || ("cs.send_b2c_redpacket.local".equals(paramString1)) || ("cs.first_frame_drawn.local".equals(paramString1)) || ("cs.qta_notify_test_result.local".equals(paramString1)) || ("cs.share_pic.local".equals(paramString1))) {
      ThreadManager.post((Runnable)localObject2, 5, null, true);
    }
    for (;;)
    {
      return "{}";
      if (paramBoolean) {
        this.mRequestHandlerThread.post((Runnable)localObject2);
      } else {
        synchronized (this.mRequestHandlers)
        {
          localObject2 = this.mRequestHandlers.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            abjp localabjp = ((a)((Iterator)localObject2).next()).a(paramString1, paramString2, paramInt1, paramInt2);
            if (localabjp != null)
            {
              if (localabjp.bDr) {
                ((Iterator)localObject2).remove();
              }
              paramString1 = localabjp.bgF;
              return paramString1;
            }
          }
        }
      }
    }
  }
  
  public void a(a parama)
  {
    synchronized (this.mRequestHandlers)
    {
      this.mRequestHandlers.remove(parama);
      this.mRequestHandlers.add(parama);
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_ApolloDataChannel", 2, "addCmdHandler class:" + parama.getClass().getName() + ", size: " + this.mRequestHandlers.size());
      }
      return;
    }
  }
  
  public void b(a parama)
  {
    if (parama == null) {}
    for (;;)
    {
      return;
      synchronized (this.mRequestHandlers)
      {
        this.mRequestHandlers.remove(parama);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("apollochannel_ApolloDataChannel", 2, "removeCmdHandler class:" + parama.getClass().getName() + ", size: " + this.mRequestHandlers.size());
        return;
      }
    }
  }
  
  public void f(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollochannel_ApolloDataChannel", 2, "[callbackFromRequest], errCode:" + paramInt1 + ",cmd:" + paramString1 + ",reqData:" + paramString2);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("cmd", paramString1);
    localBundle.putString("respData", paramString2);
    paramString1 = EIPCResult.createResult(paramInt1, localBundle);
    abmm.a().callbackResult(paramInt2, paramString1);
  }
  
  public void onDestroy()
  {
    QLog.i("apollochannel_ApolloDataChannel", 1, "onDestroy app:" + this.mAppRef.get());
    this.mRenderRunners.onDestroy();
    synchronized (this.mRequestHandlers)
    {
      Iterator localIterator = this.mRequestHandlers.iterator();
      if (localIterator.hasNext()) {
        ((a)localIterator.next()).destroyHandler();
      }
    }
    this.mRequestHandlers.clear();
    this.mRequestHandlerThread.removeCallbacksAndMessages(null);
    if (this.b != null)
    {
      this.b.onDestroy();
      this.b = null;
    }
  }
  
  public void u(int paramInt1, String paramString, int paramInt2)
  {
    if (this.mAppRef == null) {}
    while (this.b == null) {
      return;
    }
    this.b.u(paramInt1, paramString, paramInt2);
  }
  
  static class RequestRunable
    implements Runnable
  {
    private String bgD;
    private WeakReference<CmGameCmdChannel> fw;
    private int mCallbackId;
    private String mCmd;
    private int mGameId;
    
    RequestRunable(CmGameCmdChannel paramCmGameCmdChannel, String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      this.fw = new WeakReference(paramCmGameCmdChannel);
      this.mCmd = paramString1;
      this.bgD = paramString2;
      this.mCallbackId = paramInt1;
      this.mGameId = paramInt2;
    }
    
    public void run()
    {
      if (this.fw == null) {}
      CmGameCmdChannel localCmGameCmdChannel;
      do
      {
        return;
        localCmGameCmdChannel = (CmGameCmdChannel)this.fw.get();
      } while ((localCmGameCmdChannel == null) || (TextUtils.isEmpty(this.mCmd)) || (TextUtils.isEmpty(this.bgD)));
      synchronized (localCmGameCmdChannel.mRequestHandlers)
      {
        Iterator localIterator = localCmGameCmdChannel.mRequestHandlers.iterator();
        while (localIterator.hasNext())
        {
          abjp localabjp = ((CmGameCmdChannel.a)localIterator.next()).a(this.mCmd, this.bgD, this.mCallbackId, this.mGameId);
          if (localabjp != null)
          {
            if (localabjp.bDr) {
              localIterator.remove();
            }
            if (localabjp.bDs) {
              localCmGameCmdChannel.f(0, this.mCmd, localabjp.bgF, this.mCallbackId);
            }
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract abjp a(String paramString1, String paramString2, int paramInt1, int paramInt2);
    
    public abstract void destroyHandler();
    
    public abstract int zz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameCmdChannel
 * JD-Core Version:    0.7.0.1
 */