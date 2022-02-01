package com.tencent.qqmail.model.uidomain;

import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMMailOperationHandler;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushMailNotify;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class MailOperate
{
  public static final String TAG = "MailOperate";
  private final ArrayList<Data> deleteList = new ArrayList();
  private final ArrayList<Data> moveList = new ArrayList();
  private final ArrayList<Data> rejectList = new ArrayList();
  private final ArrayList<Data> spamList = new ArrayList();
  private final ArrayList<Data> starList = new ArrayList();
  private final ArrayList<Data> tagList = new ArrayList();
  private final ArrayList<Data> topList = new ArrayList();
  private final ArrayList<Data> unreadList = new ArrayList();
  
  private static void abort(Data paramData, ArrayList<Data> paramArrayList)
  {
    Data localData = paramData;
    if (paramData == null) {
      localData = paramData;
    }
    try
    {
      if (paramArrayList.size() > 0) {
        localData = (Data)paramArrayList.get(0);
      }
      int i = paramArrayList.indexOf(localData);
      if (i >= 0)
      {
        paramData = (Data)paramArrayList.get(i);
        if (!paramData.bHandled) {
          paramData.mHandler.cancel();
        }
      }
      return;
    }
    finally {}
  }
  
  private static void addList(Data paramData, ArrayList<Data> paramArrayList)
  {
    try
    {
      int i = paramArrayList.indexOf(paramData);
      if (i >= 0) {
        paramArrayList.set(i, paramData);
      }
      for (;;)
      {
        paramData = paramData.getMailIds();
        int j = paramData.length;
        i = 0;
        while (i < j)
        {
          long l = paramData[i];
          QMPushMailNotify.getInstance().clearNewMailNotify(l);
          i += 1;
        }
        paramArrayList.add(paramData);
      }
      return;
    }
    finally {}
  }
  
  private static boolean canHandle(Data paramData, ArrayList<Data> paramArrayList)
  {
    Data localData = paramData;
    if (paramData == null) {
      localData = paramData;
    }
    try
    {
      if (paramArrayList.size() > 0) {
        localData = (Data)paramArrayList.get(0);
      }
      int i = paramArrayList.indexOf(localData);
      if (i >= 0)
      {
        paramData = (Data)paramArrayList.get(i);
        if (!paramData.bHandled)
        {
          paramData.bHandled = true;
          return true;
        }
      }
      return false;
    }
    finally {}
  }
  
  private static void clearHandled(ArrayList<Data> paramArrayList)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        Data localData = (Data)localIterator.next();
        if (!localData.bHandled) {
          localArrayList.add(localData);
        }
      }
    }
    finally {}
  }
  
  private void deleteMail(int paramInt, Data paramData, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("deleteMail accountId:").append(paramInt).append(" ids:");
    if (paramData.getMailIds() != null) {}
    for (String str = Arrays.toString(paramData.getMailIds());; str = "null")
    {
      QMLog.log(4, "MailOperate", str + " isPurgeDelete:" + paramBoolean);
      addList(paramData, this.deleteList);
      paramData.setOperationHandler(QMMailManager.sharedInstance().deleteMails(paramData.getMailIds(), paramBoolean));
      return;
    }
  }
  
  private void deleteWithClockSendMail(int paramInt, Data paramData, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("deleteWithClockSendMail accountId:").append(paramInt).append(" ids:");
    if (paramData.getMailIds() != null) {}
    for (String str = Arrays.toString(paramData.getMailIds());; str = "null")
    {
      QMLog.log(4, "MailOperate", str + " isPurgeDelete:" + paramBoolean);
      addList(paramData, this.deleteList);
      paramData.setOperationHandler(QMMailManager.sharedInstance().deleteAndSyncMailsWithClockSendMail(paramInt, paramData.getMailIds(), paramBoolean));
      return;
    }
  }
  
  private void moveMail(int paramInt1, int paramInt2, Data paramData, int paramInt3)
  {
    addList(paramData, this.moveList);
    paramData.setOperationHandler(QMMailManager.sharedInstance().moveMails(paramInt2, paramInt3, paramData.getMailIds()));
  }
  
  private void rejectMail(int paramInt1, int paramInt2, Data paramData, boolean paramBoolean1, boolean paramBoolean2)
  {
    addList(paramData, this.rejectList);
    paramData.setOperationHandler(QMMailManager.sharedInstance().rejectMail(paramInt2, paramData.getMailIds(), paramBoolean1, paramBoolean2));
  }
  
  private void spamMail(int paramInt1, int paramInt2, Data paramData, boolean paramBoolean)
  {
    addList(paramData, this.spamList);
    paramData.setOperationHandler(QMMailManager.sharedInstance().spamMail(paramInt2, paramData.getMailIds()));
  }
  
  private void starMail(Data paramData, boolean paramBoolean)
  {
    addList(paramData, this.starList);
    paramData.setOperationHandler(QMMailManager.sharedInstance().starMails(paramData.getMailIds(), paramBoolean));
  }
  
  private void tagMail(int paramInt, Data paramData, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    addList(paramData, this.tagList);
    paramData.setOperationHandler(QMMailManager.sharedInstance().tagMails(paramData.getMailIds(), paramArrayOfString1, paramArrayOfString2));
  }
  
  private void topMail(Data paramData, boolean paramBoolean)
  {
    addList(paramData, this.topList);
    paramData.setOperationHandler(QMMailManager.sharedInstance().topMails(paramData.getMailIds(), paramBoolean));
  }
  
  private void unreadMail(Data paramData, boolean paramBoolean1, boolean paramBoolean2)
  {
    addList(paramData, this.unreadList);
    paramData.setOperationHandler(QMMailManager.sharedInstance().unreadMails(paramData.getMailIds(), paramBoolean1, paramBoolean2));
  }
  
  private void unreadMailLocal(int paramInt, Data paramData, boolean paramBoolean)
  {
    addList(paramData, this.unreadList);
    paramData.setOperationHandler(QMMailManager.sharedInstance().unreadMailsLocal(paramInt, paramData.getMailIds(), paramBoolean));
  }
  
  public void abortDelete()
  {
    abort(null, this.deleteList);
  }
  
  public void abortDelete(long paramLong)
  {
    abort(new Data(paramLong), this.deleteList);
  }
  
  public void abortDelete(List<Long> paramList)
  {
    abort(new Data(paramList), this.deleteList);
  }
  
  public void abortDelete(long[] paramArrayOfLong)
  {
    abort(new Data(paramArrayOfLong), this.deleteList);
  }
  
  public void abortMove()
  {
    abort(null, this.moveList);
  }
  
  public void abortMove(long paramLong)
  {
    abort(new Data(paramLong), this.moveList);
  }
  
  public void abortMove(List<Long> paramList)
  {
    abort(new Data(paramList), this.moveList);
  }
  
  public void abortMove(long[] paramArrayOfLong)
  {
    abort(new Data(paramArrayOfLong), this.moveList);
  }
  
  public void abortReject()
  {
    abort(null, this.rejectList);
  }
  
  public void abortReject(long paramLong)
  {
    abort(new Data(paramLong), this.rejectList);
  }
  
  public void abortReject(List<Long> paramList)
  {
    abort(new Data(paramList), this.rejectList);
  }
  
  public void abortReject(long[] paramArrayOfLong)
  {
    abort(new Data(paramArrayOfLong), this.rejectList);
  }
  
  public void abortSpam()
  {
    abort(null, this.spamList);
  }
  
  public void abortSpam(long paramLong)
  {
    abort(new Data(paramLong), this.spamList);
  }
  
  public void abortSpam(List<Long> paramList)
  {
    abort(new Data(paramList), this.spamList);
  }
  
  public void abortSpam(long[] paramArrayOfLong)
  {
    abort(new Data(paramArrayOfLong), this.spamList);
  }
  
  public void abortStar()
  {
    abort(null, this.starList);
  }
  
  public void abortStar(long paramLong)
  {
    abort(new Data(paramLong), this.starList);
  }
  
  public void abortStar(List<Long> paramList)
  {
    abort(new Data(paramList), this.starList);
  }
  
  public void abortStar(long[] paramArrayOfLong)
  {
    abort(new Data(paramArrayOfLong), this.starList);
  }
  
  public void abortTag()
  {
    abort(null, this.tagList);
  }
  
  public void abortTag(long paramLong)
  {
    abort(new Data(paramLong), this.tagList);
  }
  
  public void abortTag(List<Long> paramList)
  {
    abort(new Data(paramList), this.tagList);
  }
  
  public void abortTag(long[] paramArrayOfLong)
  {
    abort(new Data(paramArrayOfLong), this.tagList);
  }
  
  public void abortTop()
  {
    abort(null, this.topList);
  }
  
  public void abortTop(long paramLong)
  {
    abort(new Data(paramLong), this.topList);
  }
  
  public void abortTop(List<Long> paramList)
  {
    abort(new Data(paramList), this.topList);
  }
  
  public void abortTop(long[] paramArrayOfLong)
  {
    abort(new Data(paramArrayOfLong), this.topList);
  }
  
  public void abortUnread()
  {
    abort(null, this.unreadList);
  }
  
  public void abortUnread(long paramLong)
  {
    abort(new Data(paramLong), this.unreadList);
  }
  
  public void abortUnread(List<Long> paramList)
  {
    abort(new Data(paramList), this.unreadList);
  }
  
  public void abortUnread(long[] paramArrayOfLong)
  {
    abort(new Data(paramArrayOfLong), this.unreadList);
  }
  
  public boolean canHandleDelete()
  {
    return canHandle(null, this.deleteList);
  }
  
  public boolean canHandleDelete(long paramLong)
  {
    return canHandle(new Data(paramLong), this.deleteList);
  }
  
  public boolean canHandleDelete(List<Long> paramList)
  {
    return canHandle(new Data(paramList), this.deleteList);
  }
  
  public boolean canHandleDelete(long[] paramArrayOfLong)
  {
    return canHandle(new Data(paramArrayOfLong), this.deleteList);
  }
  
  public boolean canHandleMove()
  {
    return canHandle(null, this.moveList);
  }
  
  public boolean canHandleMove(long paramLong)
  {
    return canHandle(new Data(paramLong), this.moveList);
  }
  
  public boolean canHandleMove(List<Long> paramList)
  {
    return canHandle(new Data(paramList), this.moveList);
  }
  
  public boolean canHandleMove(long[] paramArrayOfLong)
  {
    return canHandle(new Data(paramArrayOfLong), this.moveList);
  }
  
  public boolean canHandleReject()
  {
    return canHandle(null, this.rejectList);
  }
  
  public boolean canHandleReject(long paramLong)
  {
    return canHandle(new Data(paramLong), this.rejectList);
  }
  
  public boolean canHandleReject(List<Long> paramList)
  {
    return canHandle(new Data(paramList), this.rejectList);
  }
  
  public boolean canHandleReject(long[] paramArrayOfLong)
  {
    return canHandle(new Data(paramArrayOfLong), this.rejectList);
  }
  
  public boolean canHandleSpam()
  {
    return canHandle(null, this.spamList);
  }
  
  public boolean canHandleSpam(long paramLong)
  {
    return canHandle(new Data(paramLong), this.spamList);
  }
  
  public boolean canHandleSpam(List<Long> paramList)
  {
    return canHandle(new Data(paramList), this.spamList);
  }
  
  public boolean canHandleSpam(long[] paramArrayOfLong)
  {
    return canHandle(new Data(paramArrayOfLong), this.spamList);
  }
  
  public boolean canHandleStar()
  {
    return canHandle(null, this.starList);
  }
  
  public boolean canHandleStar(long paramLong)
  {
    return canHandle(new Data(paramLong), this.starList);
  }
  
  public boolean canHandleStar(List<Long> paramList)
  {
    return canHandle(new Data(paramList), this.starList);
  }
  
  public boolean canHandleStar(long[] paramArrayOfLong)
  {
    return canHandle(new Data(paramArrayOfLong), this.starList);
  }
  
  public boolean canHandleTag()
  {
    return canHandle(null, this.tagList);
  }
  
  public boolean canHandleTag(long paramLong)
  {
    return canHandle(new Data(paramLong), this.tagList);
  }
  
  public boolean canHandleTag(List<Long> paramList)
  {
    return canHandle(new Data(paramList), this.tagList);
  }
  
  public boolean canHandleTag(long[] paramArrayOfLong)
  {
    return canHandle(new Data(paramArrayOfLong), this.tagList);
  }
  
  public boolean canHandleTop()
  {
    return canHandle(null, this.topList);
  }
  
  public boolean canHandleTop(long paramLong)
  {
    return canHandle(new Data(paramLong), this.topList);
  }
  
  public boolean canHandleTop(List<Long> paramList)
  {
    return canHandle(new Data(paramList), this.topList);
  }
  
  public boolean canHandleTop(long[] paramArrayOfLong)
  {
    return canHandle(new Data(paramArrayOfLong), this.topList);
  }
  
  public boolean canHandleUnread()
  {
    return canHandle(null, this.unreadList);
  }
  
  public boolean canHandleUnread(long paramLong)
  {
    return canHandle(new Data(paramLong), this.unreadList);
  }
  
  public boolean canHandleUnread(List<Long> paramList)
  {
    return canHandle(new Data(paramList), this.unreadList);
  }
  
  public boolean canHandleUnread(long[] paramArrayOfLong)
  {
    return canHandle(new Data(paramArrayOfLong), this.unreadList);
  }
  
  public void clear()
  {
    clearHandled(this.deleteList);
    clearHandled(this.rejectList);
    clearHandled(this.starList);
    clearHandled(this.tagList);
    clearHandled(this.unreadList);
    clearHandled(this.spamList);
  }
  
  public void deleteMail(int paramInt, long paramLong, boolean paramBoolean)
  {
    deleteMail(paramInt, new Data(paramLong), paramBoolean);
  }
  
  public void deleteMail(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    deleteMail(paramInt, new Data(paramList), paramBoolean);
  }
  
  public void deleteMail(int paramInt, long[] paramArrayOfLong, boolean paramBoolean)
  {
    deleteMail(paramInt, new Data(paramArrayOfLong), paramBoolean);
  }
  
  public void deleteWithClockSendMail(int paramInt, long paramLong, boolean paramBoolean)
  {
    deleteWithClockSendMail(paramInt, new Data(paramLong), paramBoolean);
  }
  
  public void deleteWithClockSendMail(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    deleteWithClockSendMail(paramInt, new Data(paramList), paramBoolean);
  }
  
  public void deleteWithClockSendMail(int paramInt, long[] paramArrayOfLong, boolean paramBoolean)
  {
    deleteWithClockSendMail(paramInt, new Data(paramArrayOfLong), paramBoolean);
  }
  
  public void moveIntoAdvertise(int paramInt, Mail paramMail)
  {
    QMMailManager.sharedInstance().moveOutOfAdvertise(paramMail, false);
    QMMailManager.sharedInstance().updateAllAdvertiseEntrance();
  }
  
  public void moveMail(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    moveMail(paramInt1, paramInt2, new Data(paramLong), paramInt3);
  }
  
  public void moveMail(int paramInt1, int paramInt2, List<Long> paramList, int paramInt3)
  {
    moveMail(paramInt1, paramInt2, new Data(paramList), paramInt3);
  }
  
  public void moveMail(int paramInt1, int paramInt2, long[] paramArrayOfLong, int paramInt3)
  {
    moveMail(paramInt1, paramInt2, new Data(paramArrayOfLong), paramInt3);
  }
  
  public void moveOutOfAdvertise(int paramInt, Mail paramMail)
  {
    QMMailManager.sharedInstance().moveOutOfAdvertise(paramMail, true);
    QMMailManager.sharedInstance().updateAllAdvertiseEntrance();
  }
  
  public void mustBeAdvertise(int paramInt, Mail paramMail)
  {
    QMMailManager.sharedInstance().mustBeAdvertise(paramMail, true);
    QMMailManager.sharedInstance().updateAllAdvertiseEntrance();
  }
  
  public void mustNotBeAdvertise(int paramInt, Mail paramMail)
  {
    QMMailManager.sharedInstance().mustBeAdvertise(paramMail, false);
    QMMailManager.sharedInstance().updateAllAdvertiseEntrance();
  }
  
  public void rejectMail(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    rejectMail(paramInt1, paramInt2, new Data(paramLong), paramBoolean1, paramBoolean2);
  }
  
  public void rejectMail(int paramInt1, int paramInt2, List<Long> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    rejectMail(paramInt1, paramInt2, new Data(paramList), paramBoolean1, paramBoolean2);
  }
  
  public void rejectMail(int paramInt1, int paramInt2, long[] paramArrayOfLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    rejectMail(paramInt1, paramInt2, new Data(paramArrayOfLong), paramBoolean1, paramBoolean2);
  }
  
  public void spamMail(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    spamMail(paramInt1, paramInt2, new Data(paramLong), paramBoolean);
  }
  
  public void spamMail(int paramInt1, int paramInt2, List<Long> paramList, boolean paramBoolean)
  {
    spamMail(paramInt1, paramInt2, new Data(paramList), paramBoolean);
  }
  
  public void spamMail(int paramInt1, int paramInt2, long[] paramArrayOfLong, boolean paramBoolean)
  {
    spamMail(paramInt1, paramInt2, new Data(paramArrayOfLong), paramBoolean);
  }
  
  public void starMail(long paramLong, boolean paramBoolean)
  {
    starMail(new Data(paramLong), paramBoolean);
  }
  
  public void starMail(List<Long> paramList, boolean paramBoolean)
  {
    starMail(new Data(paramList), paramBoolean);
  }
  
  public void starMail(long[] paramArrayOfLong, boolean paramBoolean)
  {
    starMail(new Data(paramArrayOfLong), paramBoolean);
  }
  
  public void tagMail(int paramInt, long paramLong, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    tagMail(paramInt, new Data(paramLong), paramArrayOfString1, paramArrayOfString2);
  }
  
  public void tagMail(int paramInt, List<Long> paramList, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    tagMail(paramInt, new Data(paramList), paramArrayOfString1, paramArrayOfString2);
  }
  
  public void tagMail(int paramInt, long[] paramArrayOfLong, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    tagMail(paramInt, new Data(paramArrayOfLong), paramArrayOfString1, paramArrayOfString2);
  }
  
  public void topMail(long paramLong, boolean paramBoolean)
  {
    topMail(new Data(paramLong), paramBoolean);
  }
  
  public void topMail(List<Long> paramList, boolean paramBoolean)
  {
    starMail(new Data(paramList), paramBoolean);
  }
  
  public void topMail(long[] paramArrayOfLong, boolean paramBoolean)
  {
    starMail(new Data(paramArrayOfLong), paramBoolean);
  }
  
  public void unreadMail(long paramLong, boolean paramBoolean)
  {
    unreadMail(new Data(paramLong), paramBoolean, false);
  }
  
  public void unreadMail(List<Long> paramList, boolean paramBoolean)
  {
    unreadMail(new Data(paramList), paramBoolean, false);
  }
  
  public void unreadMail(long[] paramArrayOfLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    unreadMail(new Data(paramArrayOfLong), paramBoolean1, paramBoolean2);
  }
  
  public void unreadMailLocal(int paramInt, long[] paramArrayOfLong, boolean paramBoolean)
  {
    unreadMailLocal(paramInt, new Data(paramArrayOfLong), paramBoolean);
  }
  
  static class Data
  {
    boolean bHandled = false;
    QMMailOperationHandler mHandler;
    long[] mailids;
    
    public Data(long paramLong)
    {
      this.mailids = new long[] { paramLong };
    }
    
    public Data(List<Long> paramList)
    {
      ValidateHelper.notNull(paramList);
      int j = paramList.size();
      this.mailids = new long[j];
      int i = 0;
      while (i < j)
      {
        this.mailids[i] = ((Long)paramList.get(i)).longValue();
        i += 1;
      }
    }
    
    public Data(long[] paramArrayOfLong)
    {
      ValidateHelper.notNull(paramArrayOfLong);
      this.mailids = paramArrayOfLong;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      Data localData = (Data)paramObject;
      boolean bool1;
      if (this.mailids == localData.mailids)
      {
        bool1 = true;
        return bool1;
      }
      if (this.mailids.length == localData.mailids.length)
      {
        int i = 0;
        for (;;)
        {
          if (i >= this.mailids.length) {
            break label77;
          }
          bool1 = bool2;
          if (this.mailids[i] != localData.mailids[i]) {
            break;
          }
          i += 1;
        }
        label77:
        return true;
      }
      return super.equals(paramObject);
    }
    
    public long[] getMailIds()
    {
      return this.mailids;
    }
    
    public void setOperationHandler(QMMailOperationHandler paramQMMailOperationHandler)
    {
      this.mHandler = paramQMMailOperationHandler;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.uidomain.MailOperate
 * JD-Core Version:    0.7.0.1
 */