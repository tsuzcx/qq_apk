package com.tencent.qqmail.ftn.request;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.model.LoginUser;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.account.watcher.AccountLoginWatcher;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.ftn.FtnDefine.FtnCallback;
import com.tencent.qqmail.ftn.FtnManagerImpl;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

public final class FtnRequestQueue
{
  private static final int LOGINED_STATUS = 2;
  private static final int LOGINING_STATUS = 1;
  private static final int MAIL_LOGINED_STATUS = 11;
  private static final int MAIL_SESSION_EXPIRE = 5;
  private static final int MAX_CONCURRENT_DOWNLOAD_REQUEST = 10;
  private static final int MAX_CONCURRENT_REQUEST = 5;
  private static final int MAX_CONCURRENT_UPLOAD_REQUEST = 10;
  private static final int MAX_QUEUE_WAIT_TIME = 50000;
  private static final int MAX_RUN_NO_REACTION_TIME = 300000;
  private static final int RESET_LOGIN_STATUS = 1;
  private static final int RETRY_AUTOLOGIN = 3;
  private static final int RETRY_AUTOLOGIN_MAX_COUNT = 5;
  private static final int SET_LOGINED_STATUS = 2;
  private static final String TAG = "FtnRequestQueue";
  private static final int TRY_LOGIN = 4;
  private static final int UNLOGIN_STATUS = 0;
  private long autoLoginMarkTime = 0L;
  private AutoLoginHandler autologinHandler = new AutoLoginHandler();
  private boolean bDead = false;
  private final QueueHandler downloadRequestHandler;
  private boolean isMailSessionExpire = false;
  private AccountLoginWatcher loginWatcher = new FtnRequestQueue.1(this);
  private int mAccountId = 0;
  private QQMailAccount mQQMailAccount = null;
  private int mStatus = 0;
  private final QueueHandler requestHandler;
  private final QueueHandler uploadRequestHandler;
  
  public FtnRequestQueue(int paramInt)
  {
    this.mAccountId = paramInt;
    this.mQQMailAccount = null;
    this.requestHandler = new QueueHandler(true, 5, 300000);
    this.uploadRequestHandler = new QueueHandler(false, 10, 300000);
    this.downloadRequestHandler = new QueueHandler(false, 10, 300000);
  }
  
  private void bindEvent(boolean paramBoolean)
  {
    LoginManager.shareInstance().bindLoginListener(this.loginWatcher, paramBoolean);
  }
  
  private boolean checkAndAutoLogin()
  {
    boolean bool = FtnManagerImpl.logined();
    Log.d("FtnRequestQueue", "checkAndAutoLogin, status: " + this.mStatus + ", ftnLogined: " + bool);
    if ((this.mStatus != 2) || (!bool))
    {
      this.autologinHandler.sendEmptyMessage(4);
      return false;
    }
    return true;
  }
  
  private void clearQueueAndErrorCallback()
  {
    this.requestHandler.sendEmptyMessage(100);
    this.uploadRequestHandler.sendEmptyMessage(100);
    this.downloadRequestHandler.sendEmptyMessage(100);
  }
  
  public FtnBaseRequest addDownloadFile(DownloadInfo paramDownloadInfo, String paramString1, String paramString2, FtnDefine.FtnCallback paramFtnCallback)
  {
    paramDownloadInfo = new DownloadFileRequest(paramDownloadInfo, paramString1, paramString2, paramFtnCallback);
    this.downloadRequestHandler.addRequest(paramDownloadInfo);
    return paramDownloadInfo;
  }
  
  public FtnBaseRequest addUploadFile(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, FtnDefine.FtnCallback paramFtnCallback)
  {
    paramString1 = new UploadFileRequest(paramString1, paramInt, paramString2, paramString3, paramString4, paramFtnCallback);
    this.uploadRequestHandler.addRequest(paramString1);
    return paramString1;
  }
  
  public void terminate()
  {
    this.bDead = true;
    bindEvent(false);
  }
  
  class AutoLoginHandler
    extends Handler
  {
    private static final int RETRY_LOGIN_MAX_COUNT = 3;
    private int retryLoginCount = 0;
    
    public AutoLoginHandler()
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      QMLog.log(4, "FtnRequestQueue", "autologinHandler " + FtnRequestQueue.this.bDead + ", status:" + FtnRequestQueue.this.mStatus + ", " + paramMessage.toString());
      if (FtnRequestQueue.this.bDead) {
        return;
      }
      if (!QMNetworkUtils.isNetworkConnected())
      {
        FtnRequestQueue.this.clearQueueAndErrorCallback();
        return;
      }
      switch (paramMessage.what)
      {
      }
      long l;
      Object localObject;
      for (;;)
      {
        l = new Date().getTime();
        if ((FtnManagerImpl.logined()) && (FtnRequestQueue.this.mStatus != 0) && ((FtnRequestQueue.this.mStatus != 1) || (l - FtnRequestQueue.this.autoLoginMarkTime <= 50000L))) {
          break;
        }
        paramMessage = AccountManager.shareInstance().getAccountList().getDefaultFtnAccount();
        if (FtnRequestQueue.this.mQQMailAccount == null)
        {
          localObject = AccountManager.shareInstance().getAccountList().getAccountById(FtnRequestQueue.this.mAccountId);
          if ((localObject != null) && ((localObject instanceof QQMailAccount))) {
            FtnRequestQueue.access$202(FtnRequestQueue.this, (QQMailAccount)localObject);
          }
        }
        if ((paramMessage == null) || (FtnRequestQueue.this.mQQMailAccount == null) || (!StringUtils.equals(paramMessage.getUin(), FtnRequestQueue.this.mQQMailAccount.getUin()))) {
          break label569;
        }
        localObject = FtnRequestQueue.this.mQQMailAccount.getSid();
        LoginUser localLoginUser = paramMessage.getLoginUser();
        if ((!StringUtils.isEmpty((CharSequence)localObject)) && ((localLoginUser == null) || (localLoginUser.getLoginStatus() == 2)) && (!FtnRequestQueue.this.isMailSessionExpire)) {
          break label517;
        }
        QMLog.log(6, "FtnRequestQueue", "ftn login error do try autologin qqmail;sid error on uid " + FtnRequestQueue.this.mQQMailAccount.getUin());
        FtnRequestQueue.this.bindEvent(true);
        paramMessage.autoLogin();
        return;
        FtnRequestQueue.access$502(FtnRequestQueue.this, 0);
        if (paramMessage.obj != null) {}
        for (int i = ((Integer)paramMessage.obj).intValue(); i == 5; i = -1)
        {
          FtnRequestQueue.access$702(FtnRequestQueue.this, true);
          QMLog.log(6, "FtnRequestQueue", "ftn login error try autologin qqmail setsessionstate");
          break;
        }
        FtnRequestQueue.access$502(FtnRequestQueue.this, 2);
        FtnRequestQueue.this.requestHandler.trySend();
        FtnRequestQueue.this.uploadRequestHandler.trySend();
        FtnRequestQueue.this.downloadRequestHandler.trySend();
        continue;
        if (paramMessage.arg1 > 5)
        {
          continue;
          FtnRequestQueue.access$702(FtnRequestQueue.this, false);
        }
      }
      label517:
      FtnRequestQueue.access$502(FtnRequestQueue.this, 1);
      FtnRequestQueue.access$1102(FtnRequestQueue.this, l);
      FtnManagerImpl.autoLogin(FtnRequestQueue.this.mQQMailAccount.getEmail(), (String)localObject, FtnRequestQueue.this.mQQMailAccount.isBizMail(), new FtnRequestQueue.AutoLoginHandler.1(this));
      return;
      label569:
      FtnRequestQueue.this.clearQueueAndErrorCallback();
    }
  }
  
  class DownloadFileRequest
    extends FtnRequestQueue.RequestNativeRequest
  {
    private final String cookieKey;
    private final String cookieValue;
    private final DownloadInfo info;
    
    public DownloadFileRequest(DownloadInfo paramDownloadInfo, String paramString1, String paramString2, FtnDefine.FtnCallback paramFtnCallback)
    {
      super(paramFtnCallback, FtnRequestQueue.this.downloadRequestHandler);
      ValidateHelper.notNull(paramDownloadInfo);
      ValidateHelper.notNull(paramString1);
      ValidateHelper.notNull(paramString2);
      this.info = paramDownloadInfo;
      this.cookieKey = paramString1;
      this.cookieValue = paramString2;
    }
    
    public void run()
    {
      this.taskid = FtnManagerImpl.fileDownload(this.info, this.cookieKey, this.cookieValue, getCallback());
    }
  }
  
  public abstract class FtnBaseRequest
    implements FtnRequest, Runnable
  {
    protected boolean mAborted = false;
    protected final FtnDefine.FtnCallback mCallback;
    protected final FtnRequestQueue.QueueHandler mQueueHandler;
    protected int retryCount = 0;
    
    protected FtnBaseRequest(FtnDefine.FtnCallback paramFtnCallback, FtnRequestQueue.QueueHandler paramQueueHandler)
    {
      ValidateHelper.notNull(paramFtnCallback);
      ValidateHelper.notNull(paramQueueHandler);
      this.mCallback = paramFtnCallback;
      this.mQueueHandler = paramQueueHandler;
    }
    
    public void abort()
    {
      this.mAborted = true;
    }
    
    protected FtnDefine.FtnCallback getCallback()
    {
      return new FtnRequestQueue.FtnBaseRequest.1(this);
    }
    
    public void goOn()
    {
      this.mAborted = false;
    }
    
    public boolean isAborted()
    {
      return this.mAborted;
    }
    
    protected void systemError(int paramInt1, int paramInt2, int paramInt3, String paramString)
    {
      this.mCallback.onError(paramInt1, paramInt2, paramInt3, paramString);
      this.mCallback.onComplete();
      this.mQueueHandler.completeRequest(this);
    }
  }
  
  public class QueueHandler
    extends Handler
  {
    private static final int ADD_REQUEST_TO_HEAD_AND_NORMAL_REQUEST = 2;
    private static final int ADD_REQUEST_TO_TAIL_AND_NORMAL_REQUEST = 1;
    private static final int CLEAR_ALL_REQUEST_AND_ERROR_CALLBACK = 100;
    private static final int FORCE_REQUEST = 102;
    private static final int NORMAL_REQUEST = 101;
    private static final int REQUEST_ABORT_AND_NORMAL_REQUEST_NEXT = 4;
    private static final int REQUEST_COMPLETE_AND_NORMAL_REQUEST_NEXT = 3;
    private final HashMap<FtnRequestQueue.FtnBaseRequest, Long> aliveTime = new HashMap();
    private int mCurrentRequestCount = 0;
    private final int mMaxRequestCount;
    private final int mMaxRunNoReactionTime;
    private final boolean mNeedSession;
    private final LinkedList<FtnRequestQueue.FtnBaseRequest> mQueue = new LinkedList();
    int maxExistConcurrentCount = 0;
    private final String name;
    
    public QueueHandler(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      this(paramBoolean, paramInt1, paramInt2, "");
    }
    
    public QueueHandler(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
    {
      super();
      this.name = paramString;
      this.mNeedSession = paramBoolean;
      this.mMaxRequestCount = paramInt1;
      this.mMaxRunNoReactionTime = paramInt2;
    }
    
    private boolean hasNoReaction()
    {
      long l2 = new Date().getTime();
      FtnRequestQueue.FtnBaseRequest localFtnBaseRequest = null;
      synchronized (this.aliveTime)
      {
        Iterator localIterator = this.aliveTime.keySet().iterator();
        for (long l1 = 9223372036854775807L; localIterator.hasNext(); l1 = Math.min(l1, ((Long)this.aliveTime.get(localFtnBaseRequest)).longValue())) {
          localFtnBaseRequest = (FtnRequestQueue.FtnBaseRequest)localIterator.next();
        }
        if ((l1 < 9223372036854775807L) && (l2 - l1 > this.mMaxRunNoReactionTime))
        {
          markAlive(localFtnBaseRequest);
          return true;
        }
        return false;
      }
    }
    
    public void abortRequest(FtnRequestQueue.FtnBaseRequest paramFtnBaseRequest)
    {
      synchronized (this.aliveTime)
      {
        this.aliveTime.remove(paramFtnBaseRequest);
        paramFtnBaseRequest = Message.obtain();
        paramFtnBaseRequest.what = 4;
        paramFtnBaseRequest.arg2 = 10007;
        sendMessage(paramFtnBaseRequest);
        return;
      }
    }
    
    public void addRequest(FtnRequestQueue.FtnBaseRequest paramFtnBaseRequest)
    {
      Message localMessage = Message.obtain();
      localMessage.obj = paramFtnBaseRequest;
      localMessage.what = 1;
      localMessage.arg2 = 10000;
      sendMessage(localMessage);
    }
    
    public void completeRequest(FtnRequestQueue.FtnBaseRequest paramFtnBaseRequest)
    {
      synchronized (this.aliveTime)
      {
        this.aliveTime.remove(paramFtnBaseRequest);
        paramFtnBaseRequest = Message.obtain();
        paramFtnBaseRequest.what = 3;
        paramFtnBaseRequest.arg2 = 10003;
        sendMessage(paramFtnBaseRequest);
        return;
      }
    }
    
    public void handleMessage(Message paramMessage)
    {
      QMLog.log(4, "FtnRequestQueue", "QueueHandler mainHandler: mStatus:" + FtnRequestQueue.this.mStatus + ", msgcode:" + paramMessage.hashCode() + ", msg:" + paramMessage.toString() + ", dead:" + FtnRequestQueue.this.bDead + ", queue:" + this.mQueue.size() + ", " + this);
      if (paramMessage.what == 0) {
        throw new IllegalStateException();
      }
      if (FtnRequestQueue.this.bDead) {}
      label380:
      do
      {
        return;
        switch (paramMessage.what)
        {
        default: 
        case 1: 
        case 2: 
        case 3: 
        case 4: 
          while ((!this.mNeedSession) || (FtnRequestQueue.this.checkAndAutoLogin())) {
            switch (paramMessage.what)
            {
            default: 
              return;
            case 101: 
              if ((this.mCurrentRequestCount < this.mMaxRequestCount) || (hasNoReaction())) {
                break label380;
              }
              Log.v("FtnRequestQueue", "NORMAL_REQUEST，mCurrentRequestCount：" + this.mCurrentRequestCount);
              return;
              ValidateHelper.notNull(paramMessage.obj);
              this.mQueue.addLast((FtnRequestQueue.FtnBaseRequest)paramMessage.obj);
              paramMessage.what = 101;
              continue;
              ValidateHelper.notNull(paramMessage.obj);
              this.mQueue.addFirst((FtnRequestQueue.FtnBaseRequest)paramMessage.obj);
              paramMessage.what = 101;
              continue;
              if (this.mCurrentRequestCount > 0) {
                this.mCurrentRequestCount -= 1;
              }
              paramMessage.what = 101;
            }
          }
        }
        do
        {
          paramMessage.systemError(8, 0, 1, "");
          paramMessage = (FtnRequestQueue.FtnBaseRequest)this.mQueue.poll();
        } while (paramMessage != null);
        return;
        Log.v("FtnRequestQueue", "NORMAL_REQUEST，mCurrentRequestCount ok：" + this.mCurrentRequestCount);
        paramMessage = (FtnRequestQueue.FtnBaseRequest)this.mQueue.poll();
      } while (paramMessage == null);
      this.mCurrentRequestCount += 1;
      paramMessage.run();
      sendEmptyMessageDelayed(101, this.mMaxRunNoReactionTime);
      this.maxExistConcurrentCount = Math.max(this.maxExistConcurrentCount, this.mCurrentRequestCount);
    }
    
    public void markAlive(FtnRequestQueue.FtnBaseRequest paramFtnBaseRequest)
    {
      synchronized (this.aliveTime)
      {
        this.aliveTime.put(paramFtnBaseRequest, Long.valueOf(new Date().getTime()));
        return;
      }
    }
    
    public void readdRequest(FtnRequestQueue.FtnBaseRequest paramFtnBaseRequest)
    {
      Message localMessage = Message.obtain();
      localMessage.obj = paramFtnBaseRequest;
      localMessage.what = 2;
      localMessage.arg2 = 10001;
      sendMessage(localMessage);
    }
    
    public String toString()
    {
      return super.toString() + "[" + this.name + "]";
    }
    
    public void trySend()
    {
      Message localMessage = Message.obtain();
      localMessage.what = 101;
      localMessage.arg2 = 10002;
      sendMessage(localMessage);
    }
  }
  
  public abstract class RequestNativeRequest
    extends FtnRequestQueue.FtnBaseRequest
  {
    protected static final long BEFORE_RUNNING_TASK_ID = -1L;
    protected long taskid = -1L;
    
    protected RequestNativeRequest(FtnDefine.FtnCallback paramFtnCallback, FtnRequestQueue.QueueHandler paramQueueHandler)
    {
      super(paramFtnCallback, paramQueueHandler);
    }
    
    public void abort()
    {
      try
      {
        if (this.mAborted) {
          return;
        }
        FtnManagerImpl.abort(this.taskid);
        this.mQueueHandler.abortRequest(this);
        super.abort();
        return;
      }
      finally {}
    }
    
    public void goOn()
    {
      try
      {
        if (!this.mAborted) {
          return;
        }
        super.goOn();
        this.mQueueHandler.readdRequest(this);
        return;
      }
      finally {}
    }
    
    public void removeTask()
    {
      if (this.taskid != -1L) {
        FtnManagerImpl.removeTask(this.taskid);
      }
    }
  }
  
  class UploadFileRequest
    extends FtnRequestQueue.RequestNativeRequest
  {
    private final String filePath;
    private final String ip;
    private final int port;
    private final String sha;
    private final String uploadKey;
    
    public UploadFileRequest(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, FtnDefine.FtnCallback paramFtnCallback)
    {
      super(paramFtnCallback, FtnRequestQueue.this.uploadRequestHandler);
      ValidateHelper.notNullAndNotEmpty(paramString1);
      ValidateHelper.notNullAndNotEmpty(paramString4);
      ValidateHelper.notNullAndNotEmpty(paramString2);
      ValidateHelper.notNullAndNotEmpty(paramString3);
      this.ip = paramString1;
      this.port = paramInt;
      this.uploadKey = paramString2;
      this.sha = paramString3;
      this.filePath = paramString4;
    }
    
    public void run()
    {
      this.taskid = FtnManagerImpl.fileUpload(this.ip, this.port, this.uploadKey, this.sha, this.filePath, getCallback());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.request.FtnRequestQueue
 * JD-Core Version:    0.7.0.1
 */