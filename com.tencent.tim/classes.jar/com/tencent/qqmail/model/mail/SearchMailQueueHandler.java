package com.tencent.qqmail.model.mail;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.contact.ContactsHistoryMailSearchInfo;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.model.qmdomain.SearchInfo;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.IAbortable;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SearchMailQueueHandler
  extends Handler
{
  private static final Object INIT_SEARCH_MAIL_QUEUE_THREAD_LOCK = new Object();
  public static final int SEARCH_ABORT_ALL = -996;
  public static final int SEARCH_BEGIN = -999;
  public static final int SEARCH_NEXT = -980;
  public static final int SEARCH_PURGE = -990;
  private static final String TAG = "SearchMailQueueHandler";
  private static volatile SearchMailQueueHandler _ins;
  private static HandlerThread seachMailQueueThread;
  private SearchMailCallback callback = genCallbacks();
  private List<IAbortable> carriers = Collections.synchronizedList(new LinkedList());
  private boolean isFreshSearch = true;
  private QMMailManager manager = QMMailManager.sharedInstance();
  private SearchMailQueue queue = new SearchMailQueue();
  private SearchInfo saveInfo;
  
  private SearchMailQueueHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void abort()
  {
    synchronized (this.carriers)
    {
      Iterator localIterator = this.carriers.iterator();
      if (localIterator.hasNext()) {
        ((IAbortable)localIterator.next()).abort();
      }
    }
  }
  
  private void addCarrier(IAbortable paramIAbortable)
  {
    if (paramIAbortable != null) {
      this.carriers.add(paramIAbortable);
    }
  }
  
  private void autorun(boolean paramBoolean)
  {
    QMLog.log(4, "SearchMailQueueHandler", "autorun: reset[ " + paramBoolean + "], hasNext:[" + this.queue.hasNext() + "] , hasErrorToStop:[" + this.queue.hasErrorToStop() + "]");
    if (paramBoolean) {
      this.queue.resetErrorCount();
    }
    synchronized (this.queue)
    {
      while ((this.queue.hasNext()) && (!this.queue.hasErrorToStop()))
      {
        SearchInfo localSearchInfo = this.queue.next();
        if (localSearchInfo != null) {
          this.callback.useCarrier(localSearchInfo);
        }
      }
    }
  }
  
  private void clear()
  {
    this.queue.clear();
    this.carriers.clear();
  }
  
  private boolean compare(SearchInfo paramSearchInfo)
  {
    boolean bool = true;
    if ((this.saveInfo != null) && ((paramSearchInfo instanceof ContactsHistoryMailSearchInfo))) {
      return true;
    }
    if ((this.saveInfo != null) && (this.saveInfo.getKeyword().equals(paramSearchInfo.getKeyword())) && (this.saveInfo.getSearchType() == paramSearchInfo.getSearchType()) && (this.saveInfo.getFlag() == paramSearchInfo.getFlag()) && (this.saveInfo.getArea() == paramSearchInfo.getArea()) && (this.saveInfo.getPage() == paramSearchInfo.getPage())) {
      if (this.saveInfo.getArea() == 8) {
        if (this.saveInfo.getTagIds().length != paramSearchInfo.getTagIds().length) {
          break label149;
        }
      }
    }
    for (;;)
    {
      this.saveInfo = paramSearchInfo;
      return bool;
      if (this.saveInfo.getFolderIds().length != paramSearchInfo.getFolderIds().length) {
        label149:
        bool = false;
      }
    }
  }
  
  private void deliverToQueue(SearchInfo paramSearchInfo)
  {
    int i = 0;
    int j = paramSearchInfo.getAccountId();
    int k = paramSearchInfo.getFolderId();
    Object localObject1 = AccountManager.shareInstance().getAccountList().getAccountById(j);
    Object localObject2;
    Object localObject3;
    if ((paramSearchInfo instanceof ContactsHistoryMailSearchInfo))
    {
      paramSearchInfo = (ContactsHistoryMailSearchInfo)paramSearchInfo;
      localObject1 = paramSearchInfo.getAccounts();
      while (i < ((ArrayList)localObject1).size())
      {
        localObject2 = (Account)((ArrayList)localObject1).get(i);
        if (((Account)localObject2).isQQMail())
        {
          localObject3 = new ContactsHistoryMailSearchInfo();
          ((ContactsHistoryMailSearchInfo)localObject3).setAccountId(((Account)localObject2).getId());
          ((ContactsHistoryMailSearchInfo)localObject3).setMailIds(paramSearchInfo.getMailIds());
          ((ContactsHistoryMailSearchInfo)localObject3).setEmails(paramSearchInfo.getEmails());
          this.queue.add((SearchInfo)localObject3);
        }
        i += 1;
      }
    }
    if ((j == 0) && (k == 0))
    {
      localObject1 = AccountManager.shareInstance().getAccountList();
      i = 0;
    }
    while (i < ((AccountList)localObject1).size())
    {
      localObject2 = ((AccountList)localObject1).get(i);
      Object localObject4 = sortFolders(QMFolderManager.sharedInstance().getFoldersByAccountId(((Account)localObject2).getId()));
      localObject3 = new String[((ArrayList)localObject4).size()];
      j = 0;
      while (j < ((ArrayList)localObject4).size())
      {
        localObject3[j] = (((QMFolder)((ArrayList)localObject4).get(j)).getId() + "");
        j += 1;
      }
      if ((((Account)localObject2).isImapMail()) || (((Account)localObject2).isActiveSyncMail())) {
        localObject3 = ((ArrayList)localObject4).iterator();
      }
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (QMFolder)((Iterator)localObject3).next();
        SearchInfo localSearchInfo = new SearchInfo(paramSearchInfo.getSearchType());
        localSearchInfo.setAccountId(((Account)localObject2).getId());
        localSearchInfo.setFolderId(((QMFolder)localObject4).getId());
        localSearchInfo.setKeyword(paramSearchInfo.getKeyword());
        localSearchInfo.setFlag(paramSearchInfo.getFlag());
        localSearchInfo.setArea(paramSearchInfo.getArea());
        localSearchInfo.setFolderIds(new String[] { ((QMFolder)localObject4).getId() + "" });
        if (this.callback.useFilter(localSearchInfo))
        {
          this.queue.add(localSearchInfo);
          continue;
          localObject4 = new SearchInfo(paramSearchInfo.getSearchType());
          ((SearchInfo)localObject4).setAccountId(((Account)localObject2).getId());
          ((SearchInfo)localObject4).setFolderId(0);
          ((SearchInfo)localObject4).setKeyword(paramSearchInfo.getKeyword());
          ((SearchInfo)localObject4).setFlag(paramSearchInfo.getFlag());
          ((SearchInfo)localObject4).setArea(paramSearchInfo.getArea());
          ((SearchInfo)localObject4).setFolderIds((String[])localObject3);
          if (this.callback.useFilter((SearchInfo)localObject4)) {
            this.queue.add((SearchInfo)localObject4);
          }
        }
      }
      i += 1;
      continue;
      if (j == 0)
      {
        localObject1 = paramSearchInfo.getFolderIds();
        localObject2 = new int[localObject1.length];
        i = 0;
        while (i < localObject1.length)
        {
          localObject2[i] = Integer.parseInt(localObject1[i]);
          i += 1;
        }
        localObject1 = QMFolderManager.sharedInstance().getFoldersByIds((int[])localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (QMFolder)((Iterator)localObject1).next();
          localObject3 = AccountManager.shareInstance().getAccountList().getAccountById(((QMFolder)localObject2).getAccountId());
          if ((((Account)localObject3).isQQMail()) || ((!((Account)localObject3).isQQMail()) && (paramSearchInfo.getFlag() == -1)))
          {
            localObject3 = new SearchInfo(paramSearchInfo.getSearchType());
            ((SearchInfo)localObject3).setAccountId(((QMFolder)localObject2).getAccountId());
            ((SearchInfo)localObject3).setFolderId(((QMFolder)localObject2).getId());
            ((SearchInfo)localObject3).setKeyword(paramSearchInfo.getKeyword());
            ((SearchInfo)localObject3).setFlag(paramSearchInfo.getFlag());
            ((SearchInfo)localObject3).setArea(paramSearchInfo.getArea());
            ((SearchInfo)localObject3).setFolderIds(new String[] { ((QMFolder)localObject2).getId() + "" });
            if (this.callback.useFilter((SearchInfo)localObject3)) {
              this.queue.add((SearchInfo)localObject3);
            }
          }
        }
      }
      if ((k == 0) && (localObject1 != null) && ((((Account)localObject1).isImapMail()) || (((Account)localObject1).isActiveSyncMail()))) {
        localObject2 = sortFolders(QMFolderManager.sharedInstance().getFoldersByAccountId(((Account)localObject1).getId())).iterator();
      }
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (QMFolder)((Iterator)localObject2).next();
        localObject4 = new SearchInfo(paramSearchInfo.getSearchType());
        ((SearchInfo)localObject4).setAccountId(((Account)localObject1).getId());
        ((SearchInfo)localObject4).setFolderId(((QMFolder)localObject3).getId());
        ((SearchInfo)localObject4).setKeyword(paramSearchInfo.getKeyword());
        ((SearchInfo)localObject4).setFlag(paramSearchInfo.getFlag());
        ((SearchInfo)localObject4).setArea(paramSearchInfo.getArea());
        ((SearchInfo)localObject4).setFolderIds(new String[] { ((QMFolder)localObject3).getId() + "" });
        if (this.callback.useFilter((SearchInfo)localObject4))
        {
          this.queue.add((SearchInfo)localObject4);
          continue;
          if (this.callback.useFilter(paramSearchInfo)) {
            this.queue.add(paramSearchInfo);
          }
        }
      }
    }
  }
  
  private SearchMailCallback genCallbacks()
  {
    SearchMailCallback localSearchMailCallback = new SearchMailCallback();
    localSearchMailCallback.setOnReady(new SearchMailQueueHandler.1(this));
    localSearchMailCallback.setOnProcess(new SearchMailQueueHandler.2(this));
    localSearchMailCallback.setOnMoveOn(new SearchMailQueueHandler.3(this));
    localSearchMailCallback.setOnSuccess(new SearchMailQueueHandler.4(this));
    localSearchMailCallback.setOnEmpty(new SearchMailQueueHandler.5(this));
    localSearchMailCallback.setOnError(new SearchMailQueueHandler.6(this));
    localSearchMailCallback.setOnComplete(new SearchMailQueueHandler.7(this));
    localSearchMailCallback.setOnLock(new SearchMailQueueHandler.8(this));
    return localSearchMailCallback;
  }
  
  private void purge()
  {
    this.saveInfo = null;
  }
  
  public static void release()
  {
    synchronized (INIT_SEARCH_MAIL_QUEUE_THREAD_LOCK)
    {
      if (_ins != null)
      {
        _ins = null;
        releaseSearchMailQueueThread();
      }
      return;
    }
  }
  
  private static void releaseSearchMailQueueThread()
  {
    if (seachMailQueueThread != null)
    {
      seachMailQueueThread.quit();
      seachMailQueueThread = null;
    }
  }
  
  public static SearchMailQueueHandler shareInstance()
  {
    if (_ins == null) {}
    synchronized (INIT_SEARCH_MAIL_QUEUE_THREAD_LOCK)
    {
      SearchMailQueueHandler localSearchMailQueueHandler = _ins;
      if (localSearchMailQueueHandler == null) {}
      try
      {
        seachMailQueueThread = new HandlerThread("search_mail_queue_thread", -4);
        seachMailQueueThread.start();
        _ins = new SearchMailQueueHandler(seachMailQueueThread.getLooper());
        return _ins;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QMLog.log(5, "SearchMailQueueHandler", "start seachMailQueueThread err:", localException);
          release();
        }
      }
    }
  }
  
  private ArrayList<QMFolder> sortFolders(ArrayList<QMFolder> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    QMFolder localQMFolder;
    while (localIterator.hasNext())
    {
      localQMFolder = (QMFolder)localIterator.next();
      if (localQMFolder.getType() == 1) {
        localArrayList.add(localQMFolder);
      }
    }
    localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      localQMFolder = (QMFolder)localIterator.next();
      if (!localArrayList.contains(localQMFolder)) {
        localArrayList.add(localQMFolder);
      }
    }
    paramArrayList.clear();
    return localArrayList;
  }
  
  public void getCarrier(ISearchGetCarrier paramISearchGetCarrier)
  {
    this.callback.getCarrier(paramISearchGetCarrier);
  }
  
  public void getFilter(ISearchFilter paramISearchFilter)
  {
    this.callback.getFilter(paramISearchFilter);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case -999: 
      autorun(true);
      return;
    case -980: 
      setFreshSearch(false);
      autorun(false);
      return;
    case -996: 
      abort();
      clear();
      return;
    }
    purge();
  }
  
  public boolean isFreshSearch()
  {
    return this.isFreshSearch;
  }
  
  public void search(SearchInfo paramSearchInfo)
  {
    Threads.runInBackground(new SearchMailQueueHandler.9(this, paramSearchInfo));
  }
  
  public void setFreshSearch(boolean paramBoolean)
  {
    this.isFreshSearch = paramBoolean;
  }
  
  public static abstract interface ISearchFilter
  {
    public abstract boolean run(SearchInfo paramSearchInfo);
  }
  
  public static abstract interface ISearchGetCarrier
  {
    public abstract IAbortable run(SearchInfo paramSearchInfo, SearchMailQueueHandler.SearchMailCallback paramSearchMailCallback);
  }
  
  public static abstract interface ISearchOnComplete
  {
    public abstract void run(SearchInfo paramSearchInfo);
  }
  
  public static abstract interface ISearchOnEmpty
  {
    public abstract void run(SearchInfo paramSearchInfo);
  }
  
  public static abstract interface ISearchOnError
  {
    public abstract void run(SearchInfo paramSearchInfo, QMNetworkError paramQMNetworkError);
  }
  
  public static abstract interface ISearchOnLock
  {
    public abstract void run(SearchInfo paramSearchInfo, int paramInt);
  }
  
  public static abstract interface ISearchOnMoveOn
  {
    public abstract void run(SearchInfo paramSearchInfo, long[] paramArrayOfLong);
  }
  
  public static abstract interface ISearchOnProcess
  {
    public abstract void run(SearchInfo paramSearchInfo, long paramLong);
  }
  
  public static abstract interface ISearchOnReady
  {
    public abstract boolean run(SearchInfo paramSearchInfo);
  }
  
  public static abstract interface ISearchOnSuccess
  {
    public abstract void run(SearchInfo paramSearchInfo, long[] paramArrayOfLong);
  }
  
  public class SearchMailCallback
  {
    private SearchMailQueueHandler.ISearchGetCarrier getCarrier;
    private SearchMailQueueHandler.ISearchFilter getFilter;
    private SearchMailQueueHandler.ISearchOnComplete onComplete;
    private SearchMailQueueHandler.ISearchOnEmpty onEmpty;
    private SearchMailQueueHandler.ISearchOnError onError;
    private SearchMailQueueHandler.ISearchOnLock onLock;
    private SearchMailQueueHandler.ISearchOnMoveOn onMoveOn;
    private SearchMailQueueHandler.ISearchOnProcess onProcess;
    private SearchMailQueueHandler.ISearchOnReady onReady;
    private SearchMailQueueHandler.ISearchOnSuccess onSuccess;
    
    public SearchMailCallback() {}
    
    protected void getCarrier(SearchMailQueueHandler.ISearchGetCarrier paramISearchGetCarrier)
    {
      this.getCarrier = paramISearchGetCarrier;
    }
    
    protected void getFilter(SearchMailQueueHandler.ISearchFilter paramISearchFilter)
    {
      this.getFilter = paramISearchFilter;
    }
    
    public void handleOnComplete(SearchInfo paramSearchInfo)
    {
      if (this.onComplete != null) {
        this.onComplete.run(paramSearchInfo);
      }
    }
    
    public void handleOnEmpty(SearchInfo paramSearchInfo)
    {
      if (this.onEmpty != null) {
        this.onEmpty.run(paramSearchInfo);
      }
    }
    
    public void handleOnError(SearchInfo paramSearchInfo, QMNetworkError paramQMNetworkError)
    {
      if (this.onError != null) {
        this.onError.run(paramSearchInfo, paramQMNetworkError);
      }
    }
    
    public void handleOnLock(SearchInfo paramSearchInfo, int paramInt)
    {
      if (this.onLock != null) {
        this.onLock.run(paramSearchInfo, paramInt);
      }
    }
    
    public void handleOnMoveOn(SearchInfo paramSearchInfo, long[] paramArrayOfLong)
    {
      if (this.onMoveOn != null) {
        this.onMoveOn.run(paramSearchInfo, paramArrayOfLong);
      }
    }
    
    public void handleOnProcess(SearchInfo paramSearchInfo, long paramLong)
    {
      if (this.onProcess != null) {
        this.onProcess.run(paramSearchInfo, paramLong);
      }
    }
    
    public boolean handleOnReady(SearchInfo paramSearchInfo)
    {
      if (this.onReady != null) {
        return this.onReady.run(paramSearchInfo);
      }
      return true;
    }
    
    public void handleOnSuccess(SearchInfo paramSearchInfo, long[] paramArrayOfLong)
    {
      if (this.onSuccess != null) {
        this.onSuccess.run(paramSearchInfo, paramArrayOfLong);
      }
    }
    
    protected void setOnComplete(SearchMailQueueHandler.ISearchOnComplete paramISearchOnComplete)
    {
      this.onComplete = paramISearchOnComplete;
    }
    
    protected void setOnEmpty(SearchMailQueueHandler.ISearchOnEmpty paramISearchOnEmpty)
    {
      this.onEmpty = paramISearchOnEmpty;
    }
    
    protected void setOnError(SearchMailQueueHandler.ISearchOnError paramISearchOnError)
    {
      this.onError = paramISearchOnError;
    }
    
    protected void setOnLock(SearchMailQueueHandler.ISearchOnLock paramISearchOnLock)
    {
      this.onLock = paramISearchOnLock;
    }
    
    protected void setOnMoveOn(SearchMailQueueHandler.ISearchOnMoveOn paramISearchOnMoveOn)
    {
      this.onMoveOn = paramISearchOnMoveOn;
    }
    
    protected void setOnProcess(SearchMailQueueHandler.ISearchOnProcess paramISearchOnProcess)
    {
      this.onProcess = paramISearchOnProcess;
    }
    
    protected void setOnReady(SearchMailQueueHandler.ISearchOnReady paramISearchOnReady)
    {
      this.onReady = paramISearchOnReady;
    }
    
    protected void setOnSuccess(SearchMailQueueHandler.ISearchOnSuccess paramISearchOnSuccess)
    {
      this.onSuccess = paramISearchOnSuccess;
    }
    
    protected void useCarrier(SearchInfo paramSearchInfo)
    {
      try
      {
        synchronized (this.getCarrier)
        {
          paramSearchInfo = this.getCarrier.run(paramSearchInfo, this);
          SearchMailQueueHandler.this.addCarrier(paramSearchInfo);
          return;
        }
        return;
      }
      catch (Exception paramSearchInfo)
      {
        QMLog.log(6, "SearchMailQueueHandler", paramSearchInfo.toString());
      }
    }
    
    protected boolean useFilter(SearchInfo paramSearchInfo)
    {
      if (this.getFilter != null) {
        return this.getFilter.run(paramSearchInfo);
      }
      return true;
    }
  }
  
  public class SearchMailQueue
  {
    private static final int MAX_ERROR_TIME = 3;
    public static final int MAX_SEARCH_TASK_NUM = 2;
    private static final String PREFIX_NAME = "INFO_";
    private Map<String, Integer> errorMap = Collections.synchronizedMap(new HashMap());
    private List<SearchInfo> exist = Collections.synchronizedList(new LinkedList());
    private List<SearchInfo> running = Collections.synchronizedList(new LinkedList());
    
    public SearchMailQueue() {}
    
    private String getSearchId(SearchInfo paramSearchInfo)
    {
      return "INFO_" + paramSearchInfo.getAccountId() + "_" + paramSearchInfo.getFolderId() + "_" + paramSearchInfo.getSearchType() + "_" + QMMath.hashPositivetInt(paramSearchInfo.getKeyword());
    }
    
    protected void add(SearchInfo paramSearchInfo)
    {
      if (!this.exist.contains(paramSearchInfo)) {
        this.exist.add(0, paramSearchInfo);
      }
      QMLog.log(4, "SearchMailQueueHandler", "add:" + this.exist.size() + ":" + this.running.size());
    }
    
    protected void clear()
    {
      this.exist.clear();
      this.running.clear();
      this.errorMap.clear();
    }
    
    protected boolean hasErrorToStop()
    {
      Object localObject = null;
      try
      {
        if (this.exist.size() > 0) {
          localObject = (SearchInfo)this.exist.get(this.exist.size() - 1);
        }
        if (localObject != null)
        {
          localObject = (Integer)this.errorMap.get(getSearchId((SearchInfo)localObject));
          if ((localObject != null) && (((Integer)localObject).intValue() >= 3)) {
            return true;
          }
        }
      }
      catch (Exception localException)
      {
        QMLog.log(6, "SearchMailQueueHandler", "containsError: out of range.");
        return true;
      }
      return false;
    }
    
    protected boolean hasNext()
    {
      return (this.exist.size() > 0) && (this.running.size() < 2);
    }
    
    protected boolean isEmpty()
    {
      return (this.exist.size() == 0) && (this.running.size() == 0);
    }
    
    protected boolean isRunning()
    {
      return this.running.size() > 0;
    }
    
    protected void moveon(SearchInfo paramSearchInfo)
    {
      if (!this.exist.contains(paramSearchInfo)) {
        this.exist.add(paramSearchInfo);
      }
      this.running.remove(paramSearchInfo);
      QMLog.log(4, "SearchMailQueueHandler", "moveon*:" + this.exist.size() + ":" + this.running.size());
    }
    
    protected SearchInfo next()
    {
      try
      {
        SearchInfo localSearchInfo = (SearchInfo)this.exist.get(this.exist.size() - 1);
        this.exist.remove(localSearchInfo);
        this.running.add(localSearchInfo);
        QMLog.log(4, "SearchMailQueueHandler", "next:" + this.exist.size() + ":" + this.running.size());
        return localSearchInfo;
      }
      catch (Exception localException) {}
      return null;
    }
    
    protected void remove(SearchInfo paramSearchInfo)
    {
      if (this.running.contains(paramSearchInfo)) {
        this.running.remove(paramSearchInfo);
      }
      QMLog.log(4, "SearchMailQueueHandler", "remove:" + this.exist.size() + ":" + this.running.size());
    }
    
    protected void resetErrorCount()
    {
      int i = this.errorMap.size();
      this.errorMap.clear();
      QMLog.log(4, "SearchMailQueueHandler", "resetErrorCount : [" + i + ", " + this.errorMap.size() + "]");
    }
    
    protected void restore(SearchInfo paramSearchInfo)
    {
      String str = getSearchId(paramSearchInfo);
      if (str == null)
      {
        QMLog.log(6, "SearchMailQueueHandler", "restore on null id");
        return;
      }
      Integer localInteger2 = (Integer)this.errorMap.get(str);
      Integer localInteger1 = localInteger2;
      if (localInteger2 == null)
      {
        localInteger1 = Integer.valueOf(0);
        this.errorMap.put(str, localInteger1);
      }
      QMLog.log(4, "SearchMailQueueHandler", "current errCnt:" + str + "[" + this.errorMap.get(str) + "]");
      if (this.exist.contains(paramSearchInfo)) {
        this.exist.remove(paramSearchInfo);
      }
      this.exist.add(0, paramSearchInfo);
      if (this.running.contains(paramSearchInfo)) {
        this.running.remove(paramSearchInfo);
      }
      this.errorMap.put(str, Integer.valueOf(localInteger1.intValue() + 1));
      QMLog.log(4, "SearchMailQueueHandler", "restore:" + this.exist.size() + ":" + this.running.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.SearchMailQueueHandler
 * JD-Core Version:    0.7.0.1
 */