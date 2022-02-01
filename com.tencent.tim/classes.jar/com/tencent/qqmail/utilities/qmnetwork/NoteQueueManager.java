package com.tencent.qqmail.utilities.qmnetwork;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.NoteManager;
import com.tencent.qqmail.model.qmdomain.QMComposeNote;
import com.tencent.qqmail.model.qmdomain.QMNNote;
import com.tencent.qqmail.model.qmdomain.QMNNoteCategory;
import com.tencent.qqmail.model.qmdomain.QMNNoteInformation;
import com.tencent.qqmail.model.qmdomain.QMNNoteStatus;
import com.tencent.qqmail.model.qmnote.storage.QMNoteTask;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.ui.QMSendMailNotification;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.TreeSet;

public class NoteQueueManager
{
  public static final String CONFLICT_KEY = "conflictnts";
  protected static final String CONFLICT_TITLE = "(冲突)";
  public static final String FROM_NETWORK_KEY = "fromNetwork";
  public static final Object NEW_SEQ_KEY = "svr";
  private static final String N_NOTE_DATACHANGE = "NOTE_DATACHANGE";
  protected static final String SYNC_CONFLICT_KEY = "conflict";
  private static final String TAG = "NoteQueueManager";
  private static volatile NoteQueueManager _instance = null;
  private QMComposeQueueState _state = QMComposeQueueState.Suspending;
  private TreeSet<String> _waitingQueue = new TreeSet();
  public int cancled = 0;
  public int errored = 0;
  private String mCurrentNoteId = "";
  private QMNetworkRequest mRequest = null;
  private String mUin;
  public int successed = 0;
  public int total = 0;
  
  private NoteQueueManager(QQMailAccount paramQQMailAccount)
  {
    this.mUin = paramQQMailAccount.getUin();
  }
  
  private NoteManager getNoteManager()
  {
    return NoteManager.sharedInstance();
  }
  
  private QMNoteTask getNoteTask()
  {
    return QMNoteTask.sharedInstance();
  }
  
  private void pollQueue()
  {
    if (this._state != QMComposeQueueState.Suspending) {
      return;
    }
    this._state = QMComposeQueueState.Running;
    recursivePollQueue();
  }
  
  private void recursivePollQueue()
  {
    try
    {
      String str1 = (String)this._waitingQueue.first();
      this._waitingQueue.remove(str1);
      if (str1 == null)
      {
        this._state = QMComposeQueueState.Suspending;
        return;
      }
    }
    catch (NoSuchElementException localNoSuchElementException)
    {
      String str2;
      for (;;)
      {
        str2 = null;
      }
      this.mCurrentNoteId = str2;
      QMComposeNote localQMComposeNote = getNoteManager().readUnsendNote(str2);
      if ((localQMComposeNote == null) || (localQMComposeNote.status == null))
      {
        recursivePollQueue();
        return;
      }
      Object localObject = localQMComposeNote.information;
      StringBuilder localStringBuilder = new StringBuilder().append("recursivePollQueue noteId:").append(str2).append(", status:").append(localQMComposeNote.status.status).append(", subject:");
      if (localObject != null) {}
      for (localObject = ((QMNNoteInformation)localObject).subject;; localObject = "")
      {
        QMLog.log(4, "NoteQueueManager", (String)localObject);
        if (localQMComposeNote.status.status != 1) {
          break;
        }
        sendNoteAndPollQueue(localQMComposeNote, str2);
        return;
      }
      localObject = new MailManagerDelegate();
      ((MailManagerDelegate)localObject).setOnSuccess(new NoteQueueManager.1(this, str2));
      ((MailManagerDelegate)localObject).setOnError(new NoteQueueManager.2(this));
      getNoteManager().loadSendConflictArray(str2, null, (MailManagerDelegate)localObject);
    }
  }
  
  private void responseSucc(QMComposeNote paramQMComposeNote, QMNetworkResponse paramQMNetworkResponse, String paramString)
  {
    JSONObject localJSONObject = (JSONObject)paramQMNetworkResponse.getResponseJson();
    JSONArray localJSONArray = localJSONObject.getJSONArray("nts");
    Object localObject = null;
    paramQMNetworkResponse = (QMNetworkResponse)localObject;
    if (localJSONArray != null)
    {
      paramQMNetworkResponse = (QMNetworkResponse)localObject;
      if (localJSONArray.size() > 0) {
        paramQMNetworkResponse = localJSONArray.getJSONObject(0);
      }
    }
    if (paramQMNetworkResponse != null)
    {
      localObject = paramQMNetworkResponse.getJSONObject("inf");
      paramQMNetworkResponse = paramQMNetworkResponse.getJSONObject("st");
      if (paramQMNetworkResponse != null) {
        paramQMComposeNote.status.sequence = paramQMNetworkResponse.getLong("sequence").longValue();
      }
      if (localObject != null)
      {
        paramQMNetworkResponse = paramQMComposeNote.information.noteId;
        paramQMComposeNote.information.noteId = ((String)((JSONObject)localObject).get("id"));
        localObject = (String)((JSONObject)localObject).get("conflict");
        if ((localObject != null) && (((String)localObject).length() != 0) && (Integer.parseInt((String)localObject) != 0)) {
          break label619;
        }
        paramQMComposeNote.status.status = 6;
        QMLog.log(4, "algerconflict delete", "delete" + paramString);
        if (!this._waitingQueue.contains(paramString)) {
          break label433;
        }
        paramQMNetworkResponse = NoteManager.parseNoteList(localJSONObject);
        if (paramString.equals(paramQMNetworkResponse.information.noteId)) {
          break label361;
        }
        getNoteManager().replaceLocalNote(localJSONObject);
        getNoteManager().addIdMapping(paramString, paramQMNetworkResponse.information.noteId, "" + paramQMNetworkResponse.status.sequence);
        QMLog.log(4, "algerconflict", "reedit newnote " + paramString + " newId: " + paramQMNetworkResponse.information.noteId);
        this.successed += 1;
      }
    }
    for (;;)
    {
      paramQMNetworkResponse = new HashMap();
      paramQMNetworkResponse.put("noteId", paramQMComposeNote.information.noteId);
      paramQMNetworkResponse.put("fromNetwork", "true");
      QMNotification.postNotification("NOTE_DATACHANGE", paramQMNetworkResponse);
      return;
      label361:
      getNoteManager().setSeq(paramString, paramQMNetworkResponse.status.sequence);
      QMLog.log(4, "algerconflict", "reedit savednote " + paramString + " newId: " + paramQMNetworkResponse.information.noteId + paramQMNetworkResponse.status.sequence);
      break;
      label433:
      if ((this._waitingQueue != null) && (this._waitingQueue.contains(paramQMNetworkResponse))) {
        QMLog.log(4, "NoteQueueManager", "reEdit note, but the previous request success!!!");
      }
      for (;;)
      {
        paramQMNetworkResponse = getNoteManager().replaceLocalNote(localJSONObject);
        getNoteManager().addIdMapping(paramString, paramQMNetworkResponse.information.noteId, "" + paramQMNetworkResponse.status.sequence);
        QMLog.log(4, "algerconflict addNoteIdCache", "ori:" + paramString + " new:" + paramQMNetworkResponse.information.noteId + " seq: " + paramQMNetworkResponse.status.sequence);
        localObject = new HashMap();
        ((HashMap)localObject).put(paramString, paramQMNetworkResponse.information.noteId);
        QMNotification.postNotification("NOTE_TEMPID", localObject);
        break;
        getNoteManager().deleteUnsendNote(paramString);
        paramQMComposeNote.deleteComposeCache();
      }
      label619:
      paramQMComposeNote.status.status = 3;
      this.errored += 1;
    }
  }
  
  private void sendNoteAndPollQueue(QMComposeNote paramQMComposeNote, String paramString)
  {
    MailManagerDelegate localMailManagerDelegate = new MailManagerDelegate();
    localMailManagerDelegate.setOnSuccess(new NoteQueueManager.3(this, paramQMComposeNote, paramString));
    localMailManagerDelegate.setOnError(new NoteQueueManager.4(this, paramString));
    localMailManagerDelegate.setOnComplete(new NoteQueueManager.5(this, paramString, paramQMComposeNote));
    localMailManagerDelegate.setOnSendData(new NoteQueueManager.6(this));
    this.mCurrentNoteId = paramString;
    this.mRequest = getNoteManager().sendNoteWithCallback(paramQMComposeNote, localMailManagerDelegate);
  }
  
  @Nullable
  public static NoteQueueManager sharedInstance()
  {
    QQMailAccount localQQMailAccount = AccountManager.shareInstance().getAccountList().getDefaultNoteAccount();
    if (localQQMailAccount == null) {
      return null;
    }
    if ((_instance == null) || (!TextUtils.equals(_instance.mUin, localQQMailAccount.getUin()))) {}
    try
    {
      if ((_instance == null) || (!TextUtils.equals(_instance.mUin, localQQMailAccount.getUin()))) {
        _instance = new NoteQueueManager(localQQMailAccount);
      }
      return _instance;
    }
    finally {}
  }
  
  public void abort(String paramString)
  {
    if ((paramString.equals(this.mCurrentNoteId)) && (this.mRequest != null)) {
      this.mRequest.abort();
    }
  }
  
  public void abortAll()
  {
    this._waitingQueue.clear();
    if (this.mRequest != null) {
      this.mRequest.abort();
    }
  }
  
  public void consumeTask(int paramInt)
  {
    getNoteTask().removeTaskById("" + paramInt);
  }
  
  public void handleSendNoteError()
  {
    String str = "记事保存失败";
    if (this.errored >= 1) {
      str = this.errored + "封" + "记事保存失败";
    }
    QMSendMailNotification.getInstance().error(str, 1, new ArrayList(), new ArrayList());
  }
  
  public void handleSendNoteSucc()
  {
    String str2 = QMApplicationContext.sharedInstance().getString(2131696476);
    String str1 = str2;
    if (this.successed > 1) {
      str1 = this.successed + "封" + str2;
    }
    str2 = QMApplicationContext.sharedInstance().getString(2131696476);
    QMSendMailNotification.getInstance().success(str2, str1, 1);
  }
  
  public boolean isQueueEmpty()
  {
    return this._waitingQueue.size() == 0;
  }
  
  public boolean isSendingNoteId(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.equals(this.mCurrentNoteId);
  }
  
  public void resetNoteNum(int paramInt)
  {
    this.total = paramInt;
    this.successed = 0;
    this.cancled = 0;
    this.errored = 0;
  }
  
  protected void responseComplete(QMComposeNote paramQMComposeNote)
  {
    this.mRequest = null;
    this.mCurrentNoteId = "";
  }
  
  protected void responseError(QMComposeNote paramQMComposeNote, QMNetworkError paramQMNetworkError)
  {
    this.errored += 1;
    handleSendNoteError();
  }
  
  public void startSend()
  {
    ArrayList localArrayList = getNoteManager().readAllUnsendNote();
    synchronized (this._waitingQueue)
    {
      this._waitingQueue.addAll(localArrayList);
      resetNoteNum(this._waitingQueue.size());
      pollQueue();
      return;
    }
  }
  
  public void startTaskSync()
  {
    Iterator localIterator = getNoteTask().getAllTaskList().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (HashMap)localIterator.next();
      try
      {
        j = Integer.parseInt((String)((HashMap)localObject2).get("opCode"));
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          int m;
          String str2;
          int k;
          label160:
          Object localObject3;
          localObject1 = null;
          str1 = null;
          int j = -1;
          i = -1;
        }
      }
      try
      {
        str1 = (String)((HashMap)localObject2).get("opParam");
      }
      catch (Exception localException3)
      {
        localObject1 = null;
        str1 = null;
        i = -1;
        break label160;
      }
      try
      {
        localObject1 = (String)((HashMap)localObject2).get("noteId");
      }
      catch (Exception localException4)
      {
        localObject1 = null;
        i = -1;
        break label160;
      }
      try
      {
        i = Integer.parseInt((String)((HashMap)localObject2).get("taskId"));
        if ((i >= 0) && (j <= 20))
        {
          m = i;
          str2 = str1;
          localObject2 = localObject1;
          k = j;
          if (j >= 3) {
            break label185;
          }
        }
        try
        {
          throw new Exception("taskid : " + i + " opCode: " + j);
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException5)
      {
        i = -1;
        break label160;
      }
      QMLog.log(6, "NoteQueueManager", "note tcontinueask convert error", localException1);
      k = j;
      localObject3 = localObject1;
      str2 = str1;
      m = i;
      label185:
      if (stateChanged(localObject3, k, str2))
      {
        consumeTask(m);
      }
      else
      {
        localObject1 = new ArrayList();
        ((List)localObject1).add(localObject3);
        switch (k)
        {
        default: 
          QMLog.log(4, "NoteQueueManager", "opCode not recongnized : " + k);
          break;
        case 6: 
          ((List)localObject1).add(localObject3);
          consumeTask(m);
          getNoteManager().moveNotesWithNotifications((List)localObject1, str2);
          break;
        case 5: 
          ((List)localObject1).add(localObject3);
          consumeTask(m);
          getNoteManager().starNotesWithNotification((List)localObject1, str2.equals("1"));
        }
      }
    }
  }
  
  public boolean stateChanged(String paramString1, int paramInt, String paramString2)
  {
    paramString1 = getNoteManager().readNoteData(paramString1);
    if ((paramString1 == null) || (paramString1.information == null) || (paramString1.information.category == null) || (paramString1.information.category.getCatalogId() == null) || (paramString1.status == null)) {}
    for (;;)
    {
      return true;
      switch (paramInt)
      {
      default: 
        return false;
      case 6: 
        if (paramString1.information.category.getCatalogId().equals(paramString2)) {
          return false;
        }
        break;
      case 5: 
        if (!paramString1.status.starred) {}
        for (int i = 1; i != paramString2.equals("1"); i = 0) {
          return false;
        }
      }
    }
  }
  
  public void updateProgressbarRatio(double paramDouble)
  {
    QMSendMailNotification.getInstance().updateSendMailProgress(paramDouble, 1);
  }
  
  static enum QMComposeQueueState
  {
    Running,  Suspending;
    
    private QMComposeQueueState() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.NoteQueueManager
 * JD-Core Version:    0.7.0.1
 */