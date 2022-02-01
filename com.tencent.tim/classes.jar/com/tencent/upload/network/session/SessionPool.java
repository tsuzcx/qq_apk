package com.tencent.upload.network.session;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadConfiguration.NetworkStateObserver;
import com.tencent.upload.network.route.IUploadRouteStrategy;
import com.tencent.upload.network.route.RouteFactory;
import com.tencent.upload.network.route.UploadRoute;
import com.tencent.upload.utils.Const.FileType;
import com.tencent.upload.utils.Const.UploadRetCode;
import com.tencent.upload.utils.UploadLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SessionPool
  implements IUploadSessionCallback
{
  private static final int CLOSE_WAIT_TIME = 240000;
  private static final int MSG_CLOSE_POOL = 110000;
  private static final int MSG_REBUILD_SESSIONS = 110001;
  private static final String TAG = "SessionPool";
  private static final Map<String, String> sSessionIdMap = new HashMap();
  private volatile boolean mClosed = false;
  private UploadRoute mCurrentRoute;
  private List<IUploadSession> mDetectingSession;
  private Const.FileType mFileType;
  private boolean mInited;
  private int mLastErrorCode = 0;
  private PoolStateListener mListener;
  private UploadConfiguration.NetworkStateObserver mNetworkStateObserver;
  private int mPoolInitSize;
  private int mRouteFailTimes = 0;
  private IUploadRouteStrategy mRouteStrategy;
  private BlockingQueue<IUploadSession> mSessionQueue;
  private HandlerThread mThread;
  private Handler mWorkHandler;
  private String oldIp;
  
  public SessionPool(Const.FileType paramFileType)
  {
    this.mFileType = paramFileType;
  }
  
  private boolean changeRoute(int paramInt)
  {
    this.mClosed = false;
    this.mInited = false;
    UploadLog.d(getTag(), "do change route.");
    cleanSessions();
    if (this.mRouteStrategy == null) {
      this.mRouteStrategy = RouteFactory.createRouteStrategy(this.mFileType);
    }
    if (isNetworkAvailable())
    {
      UploadRoute localUploadRoute = this.mRouteStrategy.next(this.mCurrentRoute, paramInt);
      if (localUploadRoute == null)
      {
        UploadLog.d("SessionPool", "changeRoute get next route null");
        return false;
      }
      createSession(localUploadRoute);
      UploadLog.d("SessionPool", "changeRoute get next route !");
    }
    for (;;)
    {
      return true;
      UploadLog.d("SessionPool", "changeRoute network is not available return");
    }
  }
  
  private void createSession(int paramInt, UploadRoute paramUploadRoute)
  {
    for (;;)
    {
      int i;
      try
      {
        UploadLog.d(getTag(), "createSession num: " + paramInt + " route:" + paramUploadRoute);
        this.mCurrentRoute = paramUploadRoute.clone();
        i = 0;
        if (i < paramInt)
        {
          UploadSession localUploadSession = new UploadSession(this.mThread.getLooper(), this, this.mFileType);
          if (localUploadSession.open(paramUploadRoute))
          {
            UploadLog.d(getTag(), "createSession open success !! id:" + localUploadSession.hashCode());
            this.mDetectingSession.add(localUploadSession);
          }
          else
          {
            UploadLog.e(getTag(), "createSession open fail !!");
          }
        }
      }
      finally {}
      return;
      i += 1;
    }
  }
  
  private void createSession(UploadRoute paramUploadRoute)
  {
    if (paramUploadRoute == null)
    {
      UploadLog.d(getTag(), "create session route == " + paramUploadRoute);
      return;
    }
    createSession(this.mPoolInitSize, paramUploadRoute);
  }
  
  public static String getSessionIdByPath(String paramString)
  {
    return (String)sSessionIdMap.get(paramString);
  }
  
  private String getTag()
  {
    return "SessionPool-" + this.mFileType;
  }
  
  private void initHandler(Looper paramLooper)
  {
    if (paramLooper == null) {
      throw new IllegalArgumentException("initHandler Exception looper == null !!");
    }
    this.mWorkHandler = new WorkThreadHandler(this, paramLooper);
  }
  
  private void initNetworkListener()
  {
    this.mNetworkStateObserver = new SessionPool.1(this);
    UploadConfiguration.registerNetworkStateObserver(this.mNetworkStateObserver);
  }
  
  private void initSessions()
  {
    this.mInited = false;
    this.mRouteStrategy = RouteFactory.createRouteStrategy(this.mFileType);
    if (isNetworkAvailable())
    {
      createSession(this.mRouteStrategy.reset());
      return;
    }
    UploadLog.d("SessionPool", "initSessions network is not available !");
  }
  
  private static boolean isInVaildServer(int paramInt)
  {
    return (paramInt == Const.UploadRetCode.EINPROGRESS.getCode()) || (paramInt == Const.UploadRetCode.EAGAIN.getCode());
  }
  
  private static boolean isNetworkAvailable()
  {
    return UploadConfiguration.isNetworkAvailable();
  }
  
  public static boolean isNetworkUnavailable(int paramInt)
  {
    Object localObject = UploadConfiguration.getNetworkUnavailableRetCode();
    UploadLog.i("SessionPool", "check network unavailable code, retCodeList:" + (String)localObject + ", targetCode:" + paramInt);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(",");
      if ((localObject != null) && (localObject.length > 0))
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          String str = localObject[i].trim();
          if ((!TextUtils.isEmpty(str)) && (str.equals(String.valueOf(paramInt))))
          {
            UploadLog.i("SessionPool", "check network unavailable: true");
            return true;
          }
          i += 1;
        }
      }
    }
    UploadLog.i("SessionPool", "check network unavailable: false");
    return false;
  }
  
  private boolean isSessionValid(IUploadSession paramIUploadSession)
  {
    return (paramIUploadSession != null) && (paramIUploadSession.getState() == IUploadSession.SessionState.ESTABLISHED);
  }
  
  private boolean needChangeNextRoute(int paramInt)
  {
    Object localObject = UploadConfiguration.getChangeRouteRetCode();
    UploadLog.i(getTag(), "check needChangeNextRoute, retCodeList:" + (String)localObject + ", targetCode:" + paramInt);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(",");
      if ((localObject != null) && (localObject.length > 0))
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          String str = localObject[i].trim();
          if ((!TextUtils.isEmpty(str)) && (str.equals(String.valueOf(paramInt))))
          {
            UploadLog.i(getTag(), "check needChangeNextRoute: true");
            return true;
          }
          i += 1;
        }
      }
    }
    UploadLog.i(getTag(), "check needChangeNextRoute: false");
    return false;
  }
  
  public static void recordSessionId(String paramString1, String paramString2)
  {
    sSessionIdMap.put(paramString1, paramString2);
  }
  
  private void setPoolInitSize()
  {
    switch (SessionPool.2.$SwitchMap$com$tencent$upload$utils$Const$FileType[this.mFileType.ordinal()])
    {
    default: 
      this.mPoolInitSize = 1;
      return;
    case 1: 
      this.mPoolInitSize = 2;
      return;
    }
    this.mPoolInitSize = 2;
  }
  
  public void allIpFailed()
  {
    if (this.mListener != null) {
      this.mListener.allIpFailed(this);
    }
  }
  
  public void cleanSessions()
  {
    UploadLog.d(getTag(), "cleanSessions --- " + this.mSessionQueue.size());
    Iterator localIterator = this.mSessionQueue.iterator();
    while (localIterator.hasNext())
    {
      IUploadSession localIUploadSession = (IUploadSession)localIterator.next();
      if (isSessionValid(localIUploadSession)) {
        localIUploadSession.close();
      }
    }
    this.mSessionQueue.clear();
  }
  
  public void close()
  {
    if (this.mClosed) {
      return;
    }
    UploadLog.d("SessionPool", "close session pool");
    this.mClosed = true;
    this.mSessionQueue.clear();
  }
  
  public int getIdleSessionSize()
  {
    return this.mSessionQueue.size();
  }
  
  public Const.FileType getPoolType()
  {
    return this.mFileType;
  }
  
  public IUploadRouteStrategy getmRouteStrategy()
  {
    return this.mRouteStrategy;
  }
  
  public void init()
  {
    UploadLog.d("SessionPool", "SessionPool init.");
    this.mThread = new HandlerThread(getTag());
    this.mThread.start();
    initHandler(this.mThread.getLooper());
    this.mSessionQueue = new LinkedBlockingQueue(6);
    this.mDetectingSession = new LinkedList();
    initNetworkListener();
    setPoolInitSize();
    initSessions();
  }
  
  protected void invalidate()
  {
    this.mClosed = false;
  }
  
  public boolean isReady()
  {
    return (this.mInited) || (this.mSessionQueue.size() > 0);
  }
  
  public void notifyIdle()
  {
    UploadLog.d(getTag(), "notifyIdle --- " + this.mSessionQueue.size());
    if ((this.mSessionQueue.size() == 0) && (this.mDetectingSession.size() == 0)) {
      this.mListener.onSessionPoolError(this, Const.UploadRetCode.NO_SESSION.getCode());
    }
  }
  
  public void offer(IUploadSession paramIUploadSession)
  {
    UploadLog.d(getTag(), "offer session --- id:" + paramIUploadSession.hashCode());
    if ((paramIUploadSession.getState() == IUploadSession.SessionState.ESTABLISHED) && (!this.mSessionQueue.contains(paramIUploadSession))) {
      this.mSessionQueue.offer(paramIUploadSession);
    }
    notifyIdle();
  }
  
  public void onOpenFailed(IUploadSession paramIUploadSession, int paramInt, String paramString)
  {
    if (paramIUploadSession != null) {}
    for (;;)
    {
      try
      {
        boolean bool = this.mDetectingSession.contains(paramIUploadSession);
        if (!bool) {
          return;
        }
        UploadLog.i("[connect] " + getTag(), "failed to open session:" + paramIUploadSession.hashCode());
        this.mDetectingSession.remove(paramIUploadSession);
        UploadLog.i("[connect] " + getTag(), "onOpenFailed remove from mDetectingSession, current size:" + this.mDetectingSession.size());
        if ((!paramIUploadSession.getUploadRoute().isDuplicate(this.mCurrentRoute)) || (this.mSessionQueue.size() != 0) || (this.mDetectingSession.size() != 0)) {
          continue;
        }
        if (!isNetworkAvailable()) {
          break label274;
        }
        paramIUploadSession = this.mRouteStrategy.next(this.mCurrentRoute, 0);
        if (paramIUploadSession == null)
        {
          UploadLog.i("[connect] " + getTag(), "all ip failed, mCurrentRoute:" + this.mCurrentRoute);
          allIpFailed();
          continue;
        }
        createSession(paramIUploadSession);
      }
      finally {}
      continue;
      label274:
      UploadLog.w("[connect] " + getTag(), "network is not available !!");
    }
  }
  
  public void onOpenSucceed(IUploadSession paramIUploadSession)
  {
    if (paramIUploadSession != null) {}
    for (;;)
    {
      try
      {
        boolean bool = this.mDetectingSession.contains(paramIUploadSession);
        if (!bool) {
          return;
        }
        notify();
        UploadLog.i("[connect] " + getTag(), "session is ready --- id:" + paramIUploadSession.hashCode());
        this.mDetectingSession.remove(paramIUploadSession);
        this.mSessionQueue.offer(paramIUploadSession);
        if ((this.mSessionQueue.size() == 1) && (!this.mInited))
        {
          UploadLog.i("[connect] " + getTag(), "sessionPool is inited now !");
          this.mInited = true;
          this.mListener.onSessionPoolRestore(this.mFileType);
          continue;
        }
        if (this.mSessionQueue.size() <= 0) {
          continue;
        }
      }
      finally {}
      this.mInited = true;
    }
  }
  
  public void onSessionClosed(IUploadSession paramIUploadSession)
  {
    if (paramIUploadSession == null) {
      return;
    }
    UploadLog.w("[connect] " + getTag(), "onSessionClosed ! Session:" + paramIUploadSession.hashCode());
    this.mSessionQueue.remove(paramIUploadSession);
    notifyIdle();
  }
  
  public void onSessionError(IUploadSession paramIUploadSession, int paramInt, String paramString)
  {
    if (paramIUploadSession == null) {}
    for (;;)
    {
      return;
      try
      {
        boolean bool = isNetworkAvailable();
        this.mLastErrorCode = paramInt;
        UploadLog.w("[connect] " + getTag(), "onSessionError ! Session:" + paramIUploadSession.hashCode() + " errCode=" + paramInt + " errMsg=" + paramString + " networkAvailable=" + bool);
        this.mSessionQueue.remove(paramIUploadSession);
        UploadLog.w("[connect] " + getTag(), "remove session " + paramIUploadSession.hashCode() + " queue size: " + this.mSessionQueue.size());
        if (!needChangeNextRoute(paramInt)) {
          break label341;
        }
        UploadLog.w("[connect] " + getTag(), "[dochangeRoute] errCode=" + paramInt + " errMsg=" + paramString + " currentRoute=" + paramIUploadSession.getUploadRoute().toString());
        if (changeRoute(6))
        {
          UploadLog.i("[connect] " + getTag(), "changeRoute success");
          continue;
        }
      }
      finally {}
      UploadLog.i("[connect] " + getTag(), "changeRoute failed, allIpFailed");
      allIpFailed();
      continue;
      label341:
      if ((paramInt == Const.UploadRetCode.EINPROGRESS.getCode()) || (paramInt == Const.UploadRetCode.EAGAIN.getCode()) || (paramInt == Const.UploadRetCode.EHOSTUNREACH.getCode()) || (paramInt == Const.UploadRetCode.ENETUNREACH.getCode()) || (paramInt == Const.UploadRetCode.ENETDOWN.getCode()) || (paramInt == Const.UploadRetCode.ETIMEDOUT.getCode()) || (paramInt == Const.UploadRetCode.ECONNABORTED.getCode()))
      {
        UploadLog.w("[connect] " + getTag(), "errCode=" + paramInt + " 网络异常 !");
      }
      else if ((paramInt == 30100) || (paramInt == Const.UploadRetCode.NETWORK_NOT_AVAILABLE.getCode()))
      {
        UploadLog.w("[connect] " + getTag(), "errCode=" + paramInt + " 网络不可用 !");
      }
      else
      {
        UploadLog.i("[connect] " + getTag(), "reconnect session: " + paramIUploadSession.hashCode());
        paramIUploadSession.close();
        paramIUploadSession.open(paramIUploadSession.getUploadRoute());
        this.mDetectingSession.add(paramIUploadSession);
      }
    }
  }
  
  /* Error */
  public IUploadSession poll()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 91	com/tencent/upload/network/session/SessionPool:mSessionQueue	Ljava/util/concurrent/BlockingQueue;
    //   6: invokeinterface 353 1 0
    //   11: ifeq +23 -> 34
    //   14: aload_0
    //   15: getfield 91	com/tencent/upload/network/session/SessionPool:mSessionQueue	Ljava/util/concurrent/BlockingQueue;
    //   18: invokeinterface 530 1 0
    //   23: checkcast 304	com/tencent/upload/network/session/IUploadSession
    //   26: invokeinterface 533 1 0
    //   31: ifeq +100 -> 131
    //   34: aload_0
    //   35: getfield 91	com/tencent/upload/network/session/SessionPool:mSessionQueue	Ljava/util/concurrent/BlockingQueue;
    //   38: invokeinterface 353 1 0
    //   43: ifle +105 -> 148
    //   46: aload_0
    //   47: getfield 91	com/tencent/upload/network/session/SessionPool:mSessionQueue	Ljava/util/concurrent/BlockingQueue;
    //   50: invokeinterface 535 1 0
    //   55: checkcast 304	com/tencent/upload/network/session/IUploadSession
    //   58: astore_1
    //   59: aload_1
    //   60: invokeinterface 533 1 0
    //   65: ifeq +20 -> 85
    //   68: aload_1
    //   69: invokeinterface 370 1 0
    //   74: aload_0
    //   75: getfield 91	com/tencent/upload/network/session/SessionPool:mSessionQueue	Ljava/util/concurrent/BlockingQueue;
    //   78: aload_1
    //   79: invokeinterface 467 2 0
    //   84: pop
    //   85: aload_0
    //   86: invokespecial 103	com/tencent/upload/network/session/SessionPool:getTag	()Ljava/lang/String;
    //   89: ldc_w 537
    //   92: invokestatic 111	com/tencent/upload/utils/UploadLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: aload_0
    //   96: iconst_1
    //   97: aload_0
    //   98: getfield 124	com/tencent/upload/network/session/SessionPool:mCurrentRoute	Lcom/tencent/upload/network/route/UploadRoute;
    //   101: invokespecial 207	com/tencent/upload/network/session/SessionPool:createSession	(ILcom/tencent/upload/network/route/UploadRoute;)V
    //   104: aload_0
    //   105: invokespecial 103	com/tencent/upload/network/session/SessionPool:getTag	()Ljava/lang/String;
    //   108: ldc_w 539
    //   111: invokestatic 111	com/tencent/upload/utils/UploadLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: aload_0
    //   115: ldc2_w 540
    //   118: invokevirtual 545	java/lang/Object:wait	(J)V
    //   121: aload_0
    //   122: invokespecial 103	com/tencent/upload/network/session/SessionPool:getTag	()Ljava/lang/String;
    //   125: ldc_w 547
    //   128: invokestatic 111	com/tencent/upload/utils/UploadLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: aload_0
    //   132: getfield 91	com/tencent/upload/network/session/SessionPool:mSessionQueue	Ljava/util/concurrent/BlockingQueue;
    //   135: invokeinterface 535 1 0
    //   140: checkcast 304	com/tencent/upload/network/session/IUploadSession
    //   143: astore_1
    //   144: aload_0
    //   145: monitorexit
    //   146: aload_1
    //   147: areturn
    //   148: aload_0
    //   149: invokespecial 103	com/tencent/upload/network/session/SessionPool:getTag	()Ljava/lang/String;
    //   152: ldc_w 549
    //   155: invokestatic 111	com/tencent/upload/utils/UploadLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: goto -73 -> 85
    //   161: astore_1
    //   162: aload_0
    //   163: monitorexit
    //   164: aload_1
    //   165: athrow
    //   166: astore_1
    //   167: ldc 23
    //   169: new 143	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 551
    //   179: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_1
    //   183: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 111	com/tencent/upload/utils/UploadLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: goto -71 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	SessionPool
    //   58	89	1	localIUploadSession	IUploadSession
    //   161	4	1	localObject	Object
    //   166	17	1	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	34	161	finally
    //   34	85	161	finally
    //   85	114	161	finally
    //   114	121	161	finally
    //   121	131	161	finally
    //   131	144	161	finally
    //   148	158	161	finally
    //   167	192	161	finally
    //   114	121	166	java/lang/InterruptedException
  }
  
  public void rebuildSessions()
  {
    UploadLog.d("SessionPool", getTag() + " rebuildSessions");
    if (this.mWorkHandler != null)
    {
      this.mWorkHandler.removeMessages(110001);
      this.mWorkHandler.sendMessageDelayed(this.mWorkHandler.obtainMessage(110001), 1000L);
    }
  }
  
  public void registerListener(PoolStateListener paramPoolStateListener)
  {
    this.mListener = paramPoolStateListener;
  }
  
  public void removeCloseTimer()
  {
    if (this.mWorkHandler != null) {
      this.mWorkHandler.removeMessages(110000);
    }
  }
  
  public void reset()
  {
    if ((isInVaildServer(this.mLastErrorCode)) && (changeRoute(0))) {
      return;
    }
    this.mClosed = false;
    cleanSessions();
    UploadLog.d(getTag(), "reset session pool");
    initSessions();
  }
  
  public void reset(UploadRoute paramUploadRoute)
  {
    cleanSessions();
    this.mClosed = false;
    this.mInited = false;
    createSession(this.mPoolInitSize, paramUploadRoute);
    UploadLog.d(getTag(), "reset session pool with redirect route: " + paramUploadRoute);
  }
  
  public void saveRoute(UploadRoute paramUploadRoute)
  {
    this.mLastErrorCode = 0;
    if ((TextUtils.isEmpty(this.oldIp)) || (!paramUploadRoute.getIp().equalsIgnoreCase(this.oldIp)))
    {
      UploadLog.d(getTag(), "save recent route: " + paramUploadRoute);
      this.oldIp = paramUploadRoute.getIp();
      if (this.mRouteStrategy != null) {
        this.mRouteStrategy.save(paramUploadRoute);
      }
    }
  }
  
  public void setCloseTimer()
  {
    UploadLog.d("SessionPool", getTag() + " setCloseTimer");
    if (this.mWorkHandler != null)
    {
      this.mWorkHandler.removeMessages(110000);
      this.mWorkHandler.sendMessageDelayed(this.mWorkHandler.obtainMessage(110000), 240000L);
    }
  }
  
  protected void setPoolInitSize(int paramInt)
  {
    this.mPoolInitSize = paramInt;
  }
  
  public void unregisterListener(PoolStateListener paramPoolStateListener)
  {
    if (this.mListener == paramPoolStateListener) {
      this.mListener = null;
    }
  }
  
  public static abstract interface PoolStateListener
  {
    public abstract void allIpFailed(SessionPool paramSessionPool);
    
    public abstract void onSessionPoolError(SessionPool paramSessionPool, int paramInt);
    
    public abstract void onSessionPoolRestore(Const.FileType paramFileType);
  }
  
  static class WorkThreadHandler
    extends Handler
  {
    private WeakReference<SessionPool> mRef;
    private int n = 1;
    
    public WorkThreadHandler(SessionPool paramSessionPool, Looper paramLooper)
    {
      super();
      this.mRef = new WeakReference(paramSessionPool);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        do
        {
          do
          {
            return;
          } while ((this.mRef == null) || (this.mRef.get() == null));
          UploadLog.d("SessionPool", "receive msg MSG_CLOSE_POOL");
          ((SessionPool)this.mRef.get()).close();
          return;
          if (!SessionPool.access$200()) {
            break;
          }
          UploadLog.d("SessionPool", "receive msg MSG_REBUILD_SESSIONS hasNetwork:true");
        } while ((this.mRef == null) || (this.mRef.get() == null));
        paramMessage = (SessionPool)this.mRef.get();
        if ((paramMessage.mSessionQueue.size() == 0) && (paramMessage.mDetectingSession.size() == 0)) {
          paramMessage.reset();
        }
        this.n = 1;
        return;
        UploadLog.d("SessionPool", "receive msg MSG_REBUILD_SESSIONS n == " + this.n);
      } while (this.n > 6);
      paramMessage = obtainMessage(110001);
      int i = this.n;
      this.n = (i + 1);
      sendMessageDelayed(paramMessage, (1 << i) * 1000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.upload.network.session.SessionPool
 * JD-Core Version:    0.7.0.1
 */