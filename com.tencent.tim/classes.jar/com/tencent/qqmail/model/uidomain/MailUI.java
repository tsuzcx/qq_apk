package com.tencent.qqmail.model.uidomain;

import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.sendmail.SendMailHelper;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class MailUI
  extends Mail
{
  private static final String TAG = MailUI.class.getSimpleName();
  private static final long serialVersionUID = 6473003391812430018L;
  @Deprecated
  private long aggregateType;
  @Deprecated
  private Future<Boolean> canToppedTask;
  private long convMailId;
  private Future<Mail> convMailTask;
  @Deprecated
  private Future<Boolean> isToppedTask;
  private MailReference reference;
  private Future<long[]> task = null;
  
  public MailUI() {}
  
  public MailUI(@NonNull Mail paramMail)
  {
    this(paramMail, 0L, 0L);
  }
  
  public MailUI(@NonNull Mail paramMail, long paramLong1, long paramLong2)
  {
    if (setMail(paramMail))
    {
      this.aggregateType = paramLong1;
      this.convMailId = paramLong2;
      refreshTopStatus();
    }
  }
  
  private Mail getSiblingMail(long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    int i = paramInt1 + paramInt2;
    Object localObject = new StringBuilder().append("pos:").append(i).append(",index:").append(paramInt1).append(",return:");
    if (i > paramArrayOfLong.length - 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("hill-searchMail", bool);
      if ((i >= 0) && (i <= paramArrayOfLong.length - 1)) {
        break;
      }
      localObject = null;
      return localObject;
    }
    long l = paramArrayOfLong[i];
    Log.d("hill-searchMail", "mailIds:" + paramArrayOfLong.length);
    paramInt1 = i;
    for (;;)
    {
      Mail localMail = getMail(l);
      localObject = localMail;
      if (localMail != null) {
        break;
      }
      paramInt1 += paramInt2;
      if ((paramInt1 < 0) || (paramInt1 > paramArrayOfLong.length - 1)) {
        return null;
      }
      l = paramArrayOfLong[paramInt1];
    }
  }
  
  public static MailUI readMailData(long paramLong1, long paramLong2, boolean paramBoolean, Future<long[]> paramFuture, long paramLong3)
  {
    Object localObject = QMMailManager.sharedInstance().readMail(paramLong1, paramBoolean, true);
    if (localObject == null) {
      return null;
    }
    localObject = new MailUI((Mail)localObject, paramLong2, paramLong3);
    ((MailUI)localObject).setTask(paramFuture);
    return localObject;
  }
  
  private boolean setMail(Mail paramMail)
  {
    if (paramMail == null) {
      return false;
    }
    setInformation(paramMail.getInformation());
    setStatus(paramMail.getStatus());
    setContent(paramMail.getContent());
    setRead(paramMail.isRead());
    setVote(paramMail.getVote());
    return true;
  }
  
  public boolean canReject()
  {
    MailStatus localMailStatus = getStatus();
    if (localMailStatus == null) {
      return false;
    }
    if (localMailStatus.isSystemMail()) {
      switch (localMailStatus.getXQQStyle())
      {
      }
    }
    return true;
  }
  
  public boolean canReply()
  {
    boolean bool = true;
    MailStatus localMailStatus = getStatus();
    MailInformation localMailInformation = getInformation();
    if ((localMailStatus == null) || (localMailInformation == null) || (localMailInformation.getToList() == null) || (localMailInformation.getFrom() == null)) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      int i = localMailStatus.getXQQStyle();
      if ((i == 1) || (i == 2) || (i == 5) || (i == 6)) {}
      for (i = 1; (localMailStatus.isSubscribeMail()) || (i != 0); i = 0) {
        return false;
      }
    }
  }
  
  public boolean canReplyAll()
  {
    MailStatus localMailStatus = getStatus();
    Object localObject = getInformation();
    if ((localMailStatus == null) || (localObject == null)) {}
    do
    {
      return false;
      int i = ((MailInformation)localObject).getAccountId();
      localObject = AccountManager.shareInstance().getAccountList().getAccountById(i);
    } while ((!canReply()) || (localMailStatus.isGroupMail()) || (!SendMailHelper.isShowReplyAll(this, (Account)localObject)));
    return true;
  }
  
  public boolean canSpam()
  {
    MailStatus localMailStatus = getStatus();
    MailInformation localMailInformation = getInformation();
    if ((localMailStatus == null) || (localMailInformation == null)) {}
    int m;
    int i;
    int j;
    int k;
    int n;
    do
    {
      return false;
      m = localMailInformation.getAccountId();
      QMFolderManager localQMFolderManager = QMFolderManager.sharedInstance();
      i = localQMFolderManager.getInboxFolderId(m);
      j = localQMFolderManager.getSpamFolderId(m);
      k = localQMFolderManager.getQQMailGroupFolderId(m);
      m = localQMFolderManager.getTrashFolderId(m);
      n = localMailInformation.getFolderId();
    } while (((n != i) && (n != j) && (n != k) && (n != m) && (!localMailStatus.isSubscribeMail())) || (localMailStatus.isSystemMail()) || (localMailStatus.isProtocolMail()));
    return true;
  }
  
  @Deprecated
  public boolean canTop()
  {
    try
    {
      boolean bool = ((Boolean)this.canToppedTask.get()).booleanValue();
      return bool;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
      return false;
    }
    catch (ExecutionException localExecutionException)
    {
      for (;;)
      {
        localExecutionException.printStackTrace();
      }
    }
  }
  
  protected MailReference createReference(long[] paramArrayOfLong, long paramLong, boolean paramBoolean)
  {
    MailReference localMailReference = new MailReference();
    if (paramArrayOfLong != null)
    {
      int i = 0;
      while (i < paramArrayOfLong.length)
      {
        if (paramLong == paramArrayOfLong[i])
        {
          localMailReference = new MailReference();
          Log.d("hill-searchMail", "i:" + i + ",mailIds.length:" + paramArrayOfLong.length);
          if (i == 0) {
            localMailReference.setPrev(null);
          }
          while (i == paramArrayOfLong.length - 1)
          {
            localMailReference.setNext(null);
            return localMailReference;
            Mail localMail = getSiblingMail(paramArrayOfLong, i, -1);
            if (localMail != null) {
              localMailReference.setPrev(new MailReferenceNav(localMail.getInformation().getId(), localMail.getStatus().isConversation(), paramBoolean));
            } else {
              localMailReference.setPrev(null);
            }
          }
          paramArrayOfLong = getSiblingMail(paramArrayOfLong, i, 1);
          if (paramArrayOfLong != null)
          {
            localMailReference.setNext(new MailReferenceNav(paramArrayOfLong.getInformation().getId(), paramArrayOfLong.getStatus().isConversation(), paramBoolean));
            return localMailReference;
          }
          localMailReference.setNext(null);
          return localMailReference;
        }
        i += 1;
      }
    }
    return localMailReference;
  }
  
  protected Mail getMail(long paramLong)
  {
    Log.d("hill-searchMail", "MailUI mailId:" + paramLong);
    return QMMailManager.sharedInstance().readMailInfo(paramLong, false);
  }
  
  public long[] getMailIds()
  {
    try
    {
      long[] arrayOfLong = (long[])this.task.get();
      return arrayOfLong;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return new long[0];
  }
  
  public MailReference getReference()
  {
    return this.reference;
  }
  
  public Future<long[]> getTask()
  {
    return this.task;
  }
  
  @Deprecated
  public boolean isTopped()
  {
    try
    {
      boolean bool = ((Boolean)this.isToppedTask.get()).booleanValue();
      return bool;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
      return false;
    }
    catch (ExecutionException localExecutionException)
    {
      for (;;)
      {
        localExecutionException.printStackTrace();
      }
    }
  }
  
  protected void processParentRefrence(long[] paramArrayOfLong, long paramLong1, long paramLong2)
  {
    MailReference localMailReference = this.reference;
    if ((paramLong2 != 0L) && ((localMailReference.getNext() == null) || (localMailReference.getPrev() == null)))
    {
      paramArrayOfLong = createReference(paramArrayOfLong, paramLong2, false);
      if (localMailReference.getNext() == null) {
        localMailReference.setNext(paramArrayOfLong.getNext());
      }
      if (localMailReference.getPrev() == null) {
        localMailReference.setPrev(paramArrayOfLong.getPrev());
      }
    }
  }
  
  protected void processRefrence(long[] paramArrayOfLong, long paramLong1, long paramLong2)
  {
    if (paramLong2 != 0L) {}
    for (boolean bool = true;; bool = false)
    {
      this.reference = createReference(paramArrayOfLong, paramLong1, bool);
      return;
    }
  }
  
  public void refreshTopStatus()
  {
    this.convMailTask = Threads.submitTask(new MailUI.1(this));
    this.canToppedTask = Threads.submitTask(new MailUI.2(this));
    this.isToppedTask = Threads.submitTask(new MailUI.3(this));
  }
  
  public void setTask(Future<long[]> paramFuture)
  {
    this.task = paramFuture;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(super.toString());
    localStringBuffer.insert(14, "UI");
    localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    localStringBuffer.append(",");
    if (this.reference != null) {
      localStringBuffer.append("\"MailUIref\":" + this.reference.toString() + ",");
    }
    int i = localStringBuffer.length() - 1;
    if (localStringBuffer.charAt(i) == ',') {
      localStringBuffer.deleteCharAt(i);
    }
    localStringBuffer.append("}");
    return localStringBuffer.toString();
  }
  
  public void updateReference(long[] paramArrayOfLong)
  {
    long[] arrayOfLong;
    if (paramArrayOfLong != null)
    {
      arrayOfLong = paramArrayOfLong;
      if (paramArrayOfLong.length != 0) {}
    }
    else
    {
      arrayOfLong = getMailIds();
    }
    long l = getInformation().getId();
    if (this.convMailId != 0L) {
      processRefrence(QMMailManager.sharedInstance().getConvMailIds(this.convMailId), l, this.convMailId);
    }
    for (;;)
    {
      if (this.convMailId != 0L) {
        processParentRefrence(arrayOfLong, l, this.convMailId);
      }
      return;
      processRefrence(arrayOfLong, l, this.convMailId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.uidomain.MailUI
 * JD-Core Version:    0.7.0.1
 */