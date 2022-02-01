package com.tencent.qqmail.utilities.qmnetwork;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.helper.QMWtLoginManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.utilities.encryptionalgorithm.Aes;
import com.tencent.qqmail.utilities.encryptionalgorithm.RsaEncryption;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.thread.QMSchedulers;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.http.impl.cookie.BasicClientCookie;

public class NetworkManager
{
  private static final String TAG = "NET_MANAGER";
  private static NetworkManager _instance = new NetworkManager();
  private final ThreadPoolExecutor threadPoolExecutor = QMSchedulers.network;
  
  private QQMailAccount getAccountByRequest(CGIRequest paramCGIRequest)
  {
    paramCGIRequest = AccountManager.shareInstance().getAccountList().getAccountById(paramCGIRequest.accountId);
    if ((paramCGIRequest != null) && ((paramCGIRequest instanceof QQMailAccount))) {
      return (QQMailAccount)paramCGIRequest;
    }
    return null;
  }
  
  private String outputHttpHeader(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[ ");
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      localStringBuilder.append((String)localEntry.getKey()).append(":").append((String)localEntry.getValue()).append(";");
    }
    localStringBuilder.append(" ]");
    return localStringBuilder.toString();
  }
  
  public static NetworkManager sharedInstance()
  {
    return _instance;
  }
  
  public void executeTask(SessionTask paramSessionTask)
  {
    this.threadPoolExecutor.execute(paramSessionTask);
  }
  
  void executeTask(Task paramTask)
  {
    this.threadPoolExecutor.execute(paramTask);
  }
  
  public void sendRequest(QMNetworkRequest arg1)
  {
    QQMailAccount localQQMailAccount;
    int i;
    if ((??? instanceof CGIRequest))
    {
      localQQMailAccount = getAccountByRequest((CGIRequest)???);
      if (localQQMailAccount == null) {
        break label113;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        SessionTask localSessionTask = new SessionTask((CGIRequest)???);
        synchronized (localQQMailAccount.requestWaitingForSession)
        {
          if (localQQMailAccount.requestWaitingForSession.size() > 0)
          {
            localQQMailAccount.requestWaitingForSession.add(localSessionTask);
            return;
          }
          this.threadPoolExecutor.execute(localSessionTask);
        }
      }
      ??? = new Task(???);
      this.threadPoolExecutor.execute(???);
      return;
      Object localObject2 = null;
      i = 0;
      continue;
      label113:
      i = 0;
    }
  }
  
  public void sendRequest(QMNetworkRequest paramQMNetworkRequest, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Object localObject = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
      ArrayList localArrayList;
      if ((localObject instanceof QQMailAccount))
      {
        localArrayList = paramQMNetworkRequest.getRequestCookies();
        if ((!SharedPreferenceUtil.isWtlogin()) || (((Account)localObject).isBizMail())) {
          break label187;
        }
        paramInt = 1;
        if (paramInt == 0) {
          break label267;
        }
        str = QMWtLoginManager.getInstance().getA2(((Account)localObject).getUin());
        if ((str != null) && (!str.equals(""))) {
          break label192;
        }
        QMLog.log(6, "NET_MANAGER", "sendRequest autoAuth. a2 not exist for " + ((Account)localObject).getEmail());
        localObject = "";
        label112:
        if ((localObject != null) && (!((String)localObject).equals(""))) {
          if (!RsaEncryption.isLoginUsedRsa()) {
            break label308;
          }
        }
      }
      label267:
      label308:
      for (String str = "rakey";; str = "akey")
      {
        localArrayList.add(new BasicClientCookie(str, (String)localObject));
        if (paramInt != 0) {
          localArrayList.add(new BasicClientCookie("ltype", "wtlogin"));
        }
        paramQMNetworkRequest.setRequestCookies(localArrayList);
        sendRequest(paramQMNetworkRequest);
        return;
        label187:
        paramInt = 0;
        break;
        label192:
        localObject = SharedPreferenceUtil.getLoginSvrUtc() + "\t" + ((Account)localObject).getUin() + "\t" + str + "\t";
        if (RsaEncryption.isLoginUsedRsa())
        {
          localObject = RsaEncryption.encryptInBlock((String)localObject);
          break label112;
        }
        localObject = Aes.encode((String)localObject, Aes.getServerKey());
        break label112;
        if (RsaEncryption.isLoginUsedRsa())
        {
          localObject = RsaEncryption.encryptInBlock(((QQMailAccount)localObject).getAutologinKey());
          break label112;
        }
        localObject = Aes.encode(((QQMailAccount)localObject).getAutologinKey(), Aes.getServerKey());
        break label112;
      }
    }
    sendRequest(paramQMNetworkRequest);
  }
  
  public class SessionTask
    extends NetworkManager.Task
  {
    public final NetworkManager networkMgr = NetworkManager.this;
    public final QMCallback oldCallback;
    
    public SessionTask(CGIRequest paramCGIRequest)
    {
      super(paramCGIRequest);
      this.oldCallback = paramCGIRequest.getRequestCallback();
      QMCallback localQMCallback = new QMCallback(this.oldCallback);
      localQMCallback.setOnSuccess(new NetworkManager.SessionTask.1(this, NetworkManager.this));
      localQMCallback.setOnError(new NetworkManager.SessionTask.2(this, NetworkManager.this));
      paramCGIRequest.setRequestCallback(CGIManager.wrapCGICallback(localQMCallback));
    }
    
    private void storeRequestsWaitingForSession(QMNetworkError paramQMNetworkError, QQMailAccount paramQQMailAccount)
    {
      PriorityBlockingQueue localPriorityBlockingQueue = (PriorityBlockingQueue)NetworkManager.this.threadPoolExecutor.getQueue();
      Runnable[] arrayOfRunnable = (Runnable[])localPriorityBlockingQueue.toArray(new Runnable[0]);
      QMLog.log(5, "NET_MANAGER", "session timeout: " + localPriorityBlockingQueue.size() + ", " + arrayOfRunnable.length + ", " + paramQQMailAccount.requestWaitingForSession.size() + ", " + localPriorityBlockingQueue.contains(this) + ", " + this.request);
      boolean bool = this.request.resetWithLogining((QMCGIError)paramQMNetworkError);
      paramQMNetworkError = paramQQMailAccount.requestWaitingForSession;
      if (bool) {}
      for (;;)
      {
        int i;
        try
        {
          NetworkManager.this.threadPoolExecutor.remove(this);
          paramQQMailAccount.requestWaitingForSession.add(this);
          int j = arrayOfRunnable.length;
          i = 0;
          if (i < j)
          {
            Runnable localRunnable = arrayOfRunnable[i];
            if (((localRunnable instanceof SessionTask)) && (((CGIRequest)((SessionTask)localRunnable).request).accountId == paramQQMailAccount.getId()) && (NetworkManager.this.threadPoolExecutor.remove(localRunnable)) && (!paramQQMailAccount.requestWaitingForSession.contains(localRunnable))) {
              paramQQMailAccount.requestWaitingForSession.add((SessionTask)localRunnable);
            }
          }
          else
          {
            QMLog.log(4, "NET_MANAGER", "session timeout wait: " + localPriorityBlockingQueue.size() + ", " + paramQQMailAccount.requestWaitingForSession.size());
            return;
          }
        }
        finally {}
        i += 1;
      }
    }
    
    public void run()
    {
      ??? = (CGIRequest)this.request;
      QQMailAccount localQQMailAccount = NetworkManager.this.getAccountByRequest((CGIRequest)???);
      if (localQQMailAccount == null) {
        return;
      }
      int j = localQQMailAccount.getLoginStatus();
      boolean bool1 = localQQMailAccount.isSessionExpire();
      boolean bool2 = ((CGIRequest)this.request).isWithoutSession();
      QMLog.log(4, "NET_MANAGER", "session task run isSessionExpire: " + bool1 + ", withoutSession: " + bool2 + ", loginStatus: " + j);
      if ((bool2) || ((j == 2) && (!bool1)))
      {
        super.run();
        return;
      }
      for (;;)
      {
        synchronized (localQQMailAccount.requestWaitingForSession)
        {
          QMLog.log(4, "NET_MANAGER", "session task run add to requestWaitingForSession login status : " + j);
          localQQMailAccount.requestWaitingForSession.add(this);
          if ((j != 1) && (j != 4))
          {
            i = 1;
            if (i == 0) {
              break;
            }
            QMLog.log(4, "NET_MANAGER", "session task run auto login status : " + j);
            localQQMailAccount.autoLogin();
            return;
          }
        }
        int i = 0;
      }
    }
  }
  
  public class Task
    implements Runnable
  {
    public final QMNetworkRequest request;
    
    public Task(QMNetworkRequest paramQMNetworkRequest)
    {
      ValidateHelper.notNull(paramQMNetworkRequest);
      this.request = paramQMNetworkRequest;
    }
    
    public void run()
    {
      QMHttpUtil.send(this.request);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.NetworkManager
 * JD-Core Version:    0.7.0.1
 */