package com.tencent.qqmail.model.sendmail;

import android.util.Log;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.FtnManagerImpl;
import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.QMProtocolRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMCancelError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class SendMailRequest
{
  public static final int STEP_CHECK_FILE = 6;
  public static final int STEP_COMPLETE = 8;
  public static final int STEP_CREATE_FILE = 4;
  public static final int STEP_INIT_SEND = 1;
  public static final int STEP_SEND_MAIN_CONTENT = 7;
  public static final int STEP_START_SENDMAIL = 3;
  public static final int STEP_UPLOAD_FILE = 5;
  public static final int STEP_UPLOAD_FTN_ATTACH = 2;
  private static final String TAG = "SendMailRequest";
  private MailManagerDelegate callback;
  private QMNetworkRequest cgiRequest = null;
  private Set<Long> ftnFileUploadTaskids;
  private Set<FtnUploadInfo> ftnUploadInfos = null;
  private AtomicBoolean isAbort = new AtomicBoolean(false);
  private boolean isQQMAil;
  private QMProtocolRequest protocolRequest = null;
  private AtomicInteger step = new AtomicInteger(1);
  
  public boolean abort()
  {
    boolean bool = false;
    this.isAbort.set(true);
    Object localObject;
    if ((this.callback != null) && (((!this.isQQMAil) && (this.step.get() < 3)) || (this.isQQMAil)))
    {
      localObject = new QMCancelError(true);
      this.callback.handleError(localObject);
      this.callback.handleComplete(null);
    }
    if (this.cgiRequest != null)
    {
      if (this.cgiRequest.getStatus() < 5)
      {
        this.cgiRequest.abort();
        bool = true;
      }
      return bool;
    }
    if (this.protocolRequest != null)
    {
      if (this.protocolRequest.isHasRequestSent())
      {
        this.protocolRequest.abort();
        return false;
      }
      this.protocolRequest.abort();
      return true;
    }
    if (this.ftnUploadInfos != null)
    {
      localObject = this.ftnUploadInfos.iterator();
      while (((Iterator)localObject).hasNext())
      {
        FtnUploadInfo localFtnUploadInfo = (FtnUploadInfo)((Iterator)localObject).next();
        String str = localFtnUploadInfo.getFid();
        localFtnUploadInfo.setState(3);
        FtnManager.sharedInstance().abortRequest(str);
        Log.d("SendMailRequest", "abort, fid:" + str);
      }
    }
    if (this.ftnFileUploadTaskids != null)
    {
      localObject = this.ftnFileUploadTaskids.iterator();
      while (((Iterator)localObject).hasNext()) {
        FtnManagerImpl.abort(((Long)((Iterator)localObject).next()).longValue());
      }
    }
    Log.d("SendMailRequest", "abort finish");
    return true;
  }
  
  public void addFtnTaskId(long paramLong)
  {
    if (this.ftnFileUploadTaskids == null) {
      this.ftnFileUploadTaskids = new HashSet();
    }
    this.ftnFileUploadTaskids.add(Long.valueOf(paramLong));
  }
  
  public void addFtnUploadInfo(FtnUploadInfo paramFtnUploadInfo)
  {
    if (this.ftnUploadInfos == null) {
      this.ftnUploadInfos = new HashSet();
    }
    this.ftnUploadInfos.add(paramFtnUploadInfo);
  }
  
  public AtomicBoolean getIsAbort()
  {
    return this.isAbort;
  }
  
  public AtomicInteger getStep()
  {
    return this.step;
  }
  
  public void release()
  {
    this.cgiRequest = null;
    this.protocolRequest = null;
    this.ftnUploadInfos.clear();
    this.isAbort.set(false);
  }
  
  public void setCgiRequest(QMNetworkRequest paramQMNetworkRequest)
  {
    this.cgiRequest = paramQMNetworkRequest;
  }
  
  public void setIsQQMail(boolean paramBoolean)
  {
    this.isQQMAil = paramBoolean;
  }
  
  public void setProtocolRequest(QMProtocolRequest paramQMProtocolRequest)
  {
    this.protocolRequest = paramQMProtocolRequest;
  }
  
  public void setRequeCallback(MailManagerDelegate paramMailManagerDelegate)
  {
    this.callback = paramMailManagerDelegate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailRequest
 * JD-Core Version:    0.7.0.1
 */