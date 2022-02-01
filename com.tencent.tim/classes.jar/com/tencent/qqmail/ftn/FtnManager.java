package com.tencent.qqmail.ftn;

import android.content.res.Resources;
import androidx.annotation.Nullable;
import com.tencent.qqmail.ManagerLifecycle;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.ftn.Ftn.CreateFileInput;
import com.tencent.qqmail.ftn.Ftn.ShowUsrOutput;
import com.tencent.qqmail.ftn.callback.SaveFtnFileCallback;
import com.tencent.qqmail.ftn.model.FtnDownloadInfo;
import com.tencent.qqmail.ftn.model.FtnExpireInfo;
import com.tencent.qqmail.ftn.model.FtnUI;
import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import com.tencent.qqmail.ftn.model.FtnUserProfile;
import com.tencent.qqmail.ftn.request.FileSignRequest;
import com.tencent.qqmail.ftn.request.FtnRequestQueue;
import com.tencent.qqmail.ftn.request.FtnRequestQueue.FtnBaseRequest;
import com.tencent.qqmail.ftn.request.FtnRequestQueue.RequestNativeRequest;
import com.tencent.qqmail.ftn.util.SharedUrlUtil;
import com.tencent.qqmail.model.mail.watcher.FtnQueryAccountWatcher;
import com.tencent.qqmail.model.mail.watcher.FtnQueryExpireUnreadWatcher;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMFtnUploadNotification;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;
import rx.Observable;
import rx.Subscriber;

public class FtnManager
  extends ManagerLifecycle
{
  private static final String EXTRA_KEY_UPLOADIDX = "extrakey_uploadidx";
  private static final String EXTRA_KEY_UPLOADTIME = "extrakey_upload";
  private static final String TAG = "FtnManager";
  private static volatile FtnManager _instance = null;
  private static Map<Long, Boolean> isAccessFtnBefore = new HashMap();
  private static Map<Long, Boolean> isFtnExpireShow = new HashMap();
  private static ArrayList<FtnQueryAccountWatcher> sFtnQueryAccountWatchers = new ArrayList();
  private static ArrayList<FtnQueryExpireUnreadWatcher> sFtnQueryExpireUnreadWatchers = new ArrayList();
  private int accountId;
  private int ftnType = 0;
  private final HashMap<String, FtnRequestQueue.FtnBaseRequest> mAbortedRequest = new HashMap();
  private boolean mFtnExpUnreadUpdate = false;
  private FtnExpireInfo mFtnExpireInfo = null;
  private FtnRequestQueue mFtnRequestQueue;
  private volatile QMFtnSQLite mFtnSQLite;
  private volatile QMFtnUploadSQLite mFtnUploadSQLite;
  private boolean mIsFromFtn = false;
  private final HashMap<String, FtnRequestQueue.FtnBaseRequest> mProcessingRequest = new HashMap();
  private int sortType = 1;
  private Map<String, FtnUploadInfo> uploadFileDataCache = new ConcurrentHashMap();
  
  private FtnManager(int paramInt, String paramString)
  {
    this.accountId = paramInt;
    this.ftnType = 0;
    this.sortType = 1;
    this.mFtnSQLite = new QMFtnSQLite(QMApplicationContext.sharedInstance(), paramString);
    this.mFtnUploadSQLite = new QMFtnUploadSQLite(this.mFtnSQLite.getSqliteHeler());
    this.mFtnRequestQueue = new FtnRequestQueue(paramInt);
  }
  
  private void abortNativeRequest(FtnRequestQueue.FtnBaseRequest paramFtnBaseRequest)
  {
    if ((paramFtnBaseRequest != null) && ((paramFtnBaseRequest instanceof FtnRequestQueue.RequestNativeRequest))) {
      ((FtnRequestQueue.RequestNativeRequest)paramFtnBaseRequest).removeTask();
    }
  }
  
  private void addRequest(String paramString, FtnRequestQueue.FtnBaseRequest paramFtnBaseRequest)
  {
    synchronized (this.mProcessingRequest)
    {
      this.mProcessingRequest.put(paramString, paramFtnBaseRequest);
      this.mAbortedRequest.remove(paramString);
      return;
    }
  }
  
  private UploadState checkUploadSt()
  {
    UploadState localUploadState = new UploadState();
    Iterator localIterator = this.uploadFileDataCache.entrySet().iterator();
    while (localIterator.hasNext())
    {
      FtnUploadInfo localFtnUploadInfo = (FtnUploadInfo)((Map.Entry)localIterator.next()).getValue();
      if (localFtnUploadInfo.getState() == 4) {
        localUploadState.fail += 1;
      } else if (localFtnUploadInfo.getState() == 2) {
        localUploadState.uploading += 1;
      } else if (localFtnUploadInfo.getState() == 3) {
        localUploadState.pause += 1;
      }
    }
    localUploadState.total = this.uploadFileDataCache.size();
    return localUploadState;
  }
  
  private static HashMap<String, Object> createErrorNotification(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, Object paramObject)
  {
    return QMNotification.createNotification(new Object[] { "paramfid", paramString1, "paramerrorcgiexceptioncode", Integer.valueOf(paramInt1), "paramerrorlogiccode", Integer.valueOf(paramInt2), "paramerrortype", Integer.valueOf(paramInt3), "paramerrordescription", paramString2, "paramerrordata", paramObject });
  }
  
  private void insertUploadInfo(FtnUploadInfo paramFtnUploadInfo, int paramInt)
  {
    paramFtnUploadInfo.setStage(paramInt);
    this.mFtnUploadSQLite.insertFtnUploadInfo(paramFtnUploadInfo);
  }
  
  private void removeRequest(String paramString)
  {
    synchronized (this.mProcessingRequest)
    {
      abortNativeRequest((FtnRequestQueue.FtnBaseRequest)this.mProcessingRequest.get(paramString));
      this.mProcessingRequest.remove(paramString);
      abortNativeRequest((FtnRequestQueue.FtnBaseRequest)this.mAbortedRequest.get(paramString));
      this.mAbortedRequest.remove(paramString);
      return;
    }
  }
  
  @Nullable
  public static FtnManager sharedInstance()
  {
    QQMailAccount localQQMailAccount = AccountManager.shareInstance().getAccountList().getDefaultFtnAccount();
    if (localQQMailAccount == null) {
      return null;
    }
    int i = localQQMailAccount.getId();
    if ((_instance == null) || (_instance.accountId != i)) {}
    try
    {
      if ((_instance == null) || (_instance.accountId != i)) {
        _instance = new FtnManager(i, localQQMailAccount.getUin());
      }
      return _instance;
    }
    finally {}
  }
  
  private void updateUserProfile(ShowUsrOutput paramShowUsrOutput, String paramString)
  {
    FtnUserProfile localFtnUserProfile = getUserProfile(paramString);
    if (localFtnUserProfile == null)
    {
      paramString = new FtnUserProfile(paramString);
      if (paramShowUsrOutput.expiredays < 7) {
        break label122;
      }
      paramString.setRenewDay(paramShowUsrOutput.expiredays);
      label36:
      if (paramShowUsrOutput.storeday <= 0L) {
        break label131;
      }
      paramString.setPreserverDay(paramShowUsrOutput.storeday);
      label53:
      if (paramShowUsrOutput.fsizelimit <= 2.147484E+009F) {
        break label141;
      }
      paramString.setSingleMaxSize(paramShowUsrOutput.fsizelimit);
    }
    for (;;)
    {
      paramString.setSingleMaxSize(paramShowUsrOutput.fsizelimit);
      paramString.setPreserverDay(paramShowUsrOutput.storeday);
      paramString.setUsage(paramShowUsrOutput.usage);
      paramString.setStorage(paramShowUsrOutput.storage);
      insertUserProfile(paramString);
      return;
      localFtnUserProfile.setUin(paramString);
      paramString = localFtnUserProfile;
      break;
      label122:
      paramString.setRenewDay(7);
      break label36;
      label131:
      paramString.setPreserverDay(30L);
      break label53;
      label141:
      paramString.setSingleMaxSize(2147483648L);
    }
  }
  
  public void abortAndRemoveRequest(String paramString)
  {
    abortRequest(paramString);
    removeRequest(paramString);
  }
  
  public boolean abortRequest(String paramString)
  {
    FtnRequestQueue.FtnBaseRequest localFtnBaseRequest = (FtnRequestQueue.FtnBaseRequest)this.mProcessingRequest.get(paramString);
    if (localFtnBaseRequest != null)
    {
      localFtnBaseRequest.abort();
      this.mAbortedRequest.put(paramString, localFtnBaseRequest);
      return true;
    }
    return false;
  }
  
  public void asyncFtnExpireTime()
  {
    Threads.runInBackground(new FtnManager.1(this));
  }
  
  public final void bindFtnQueryAccountListener(FtnQueryAccountWatcher paramFtnQueryAccountWatcher, boolean paramBoolean)
  {
    ArrayList localArrayList = sFtnQueryAccountWatchers;
    if (paramBoolean) {
      if (!localArrayList.contains(paramFtnQueryAccountWatcher)) {
        localArrayList.add(paramFtnQueryAccountWatcher);
      }
    }
    while (!localArrayList.contains(paramFtnQueryAccountWatcher)) {
      return;
    }
    localArrayList.remove(paramFtnQueryAccountWatcher);
  }
  
  public final void bindFtnQueryExpireUnreadListener(FtnQueryExpireUnreadWatcher paramFtnQueryExpireUnreadWatcher, boolean paramBoolean)
  {
    ArrayList localArrayList = sFtnQueryExpireUnreadWatchers;
    if (paramBoolean) {
      if (!localArrayList.contains(paramFtnQueryExpireUnreadWatcher)) {
        localArrayList.add(paramFtnQueryExpireUnreadWatcher);
      }
    }
    while (!localArrayList.contains(paramFtnQueryExpireUnreadWatcher)) {
      return;
    }
    localArrayList.remove(paramFtnQueryExpireUnreadWatcher);
  }
  
  public void checkUploadStAndNotify()
  {
    QMApplicationContext localQMApplicationContext = QMApplicationContext.sharedInstance();
    UploadState localUploadState = checkUploadSt();
    QMLog.log(4, "FtnManager", "checkUploadStAndNotify, total: " + localUploadState.total + ", fail: " + localUploadState.fail + ", pause: " + localUploadState.pause);
    if (localUploadState.total <= 0) {
      QMFtnUploadNotification.getInstance().success(localQMApplicationContext.getResources().getString(2131694077));
    }
    while (localUploadState.fail + localUploadState.pause < localUploadState.total) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (localUploadState.fail + localUploadState.pause > 0)
    {
      int i = localUploadState.fail;
      localStringBuilder.append(localUploadState.pause + i).append(localQMApplicationContext.getString(2131694066));
    }
    QMFtnUploadNotification.getInstance().error(localStringBuilder.toString());
  }
  
  public void createFile(FtnUploadInfo paramFtnUploadInfo)
  {
    createFile(paramFtnUploadInfo, null);
  }
  
  public void createFile(FtnUploadInfo paramFtnUploadInfo, FtnDefine.FtnCallback paramFtnCallback)
  {
    Object localObject2 = new CreateFileInput();
    ((CreateFileInput)localObject2).path = paramFtnUploadInfo.getName();
    ((CreateFileInput)localObject2).md5 = paramFtnUploadInfo.getMd5();
    ((CreateFileInput)localObject2).sha = paramFtnUploadInfo.getSha();
    ((CreateFileInput)localObject2).sha3 = paramFtnUploadInfo.getSha();
    ((CreateFileInput)localObject2).appid = 2;
    ((CreateFileInput)localObject2).size = paramFtnUploadInfo.getFileSize();
    Object localObject1 = null;
    try
    {
      localObject2 = ((CreateFileInput)localObject2).toByteArray();
      localObject1 = localObject2;
    }
    catch (IOException localIOException)
    {
      label72:
      break label72;
    }
    FtnManagerImpl.createFile(localObject1, new FtnManager.7(this, paramFtnUploadInfo, paramFtnCallback));
  }
  
  public void delFile(ArrayList<String> paramArrayList)
  {
    FtnManagerImpl.delFile((String[])paramArrayList.toArray(new String[0]), new FtnManager.13(this, paramArrayList));
    DataCollector.logEvent("Event_Ftn_Delete");
  }
  
  public boolean deleteDatabase()
  {
    _instance = null;
    if (this.mFtnSQLite != null) {
      return this.mFtnSQLite.deleteDatabase();
    }
    QMLog.log(6, "FtnManager", "deleteDatabase. ftnSQLite is null");
    return false;
  }
  
  public void deleteDownloadInfoByFid(String paramString)
  {
    this.mFtnSQLite.deleteDownloadInfoByFid(paramString);
  }
  
  public void deleteSavePathByPath(ArrayList<String> paramArrayList)
  {
    this.mFtnSQLite.deleteSavePathByPath(paramArrayList);
  }
  
  public void deleteUploadInfo(String paramString)
  {
    if (!this.mFtnUploadSQLite.deleteUploadInfoByRid(paramString)) {
      QMLog.log(5, "FtnManager", "deleteUploadInfo failed, rid: " + paramString);
    }
  }
  
  public void deleteUploadInfoByFid(String paramString)
  {
    if (!this.mFtnUploadSQLite.deleteUploadInfoByFid(paramString)) {
      QMLog.log(5, "FtnManager", "deleteUploadInfoByFid failed, fid: " + paramString);
    }
  }
  
  public void downloadFile(String paramString1, String paramString2, DownloadInfo paramDownloadInfo)
  {
    paramString1 = this.mFtnRequestQueue.addDownloadFile(paramDownloadInfo, paramString1, paramString2, new FtnManager.6(this, paramDownloadInfo));
    addRequest(paramDownloadInfo.getFid(), paramString1);
  }
  
  public int getAccountId()
  {
    return this.accountId;
  }
  
  public ArrayList<FtnUploadInfo> getAllUploadData()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.uploadFileDataCache.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    return localArrayList;
  }
  
  public long getAttachRefMailId(String paramString)
  {
    return this.mFtnSQLite.getFtnRefMailId(paramString);
  }
  
  public FtnDownloadInfo getDownloadInfo(String paramString)
  {
    return this.mFtnSQLite.getDownloadInfo(paramString);
  }
  
  public void getDownloadUrl(DownloadInfo paramDownloadInfo)
  {
    FtnManagerImpl.getFileDownloadUrl(paramDownloadInfo.getFid(), paramDownloadInfo.getFtnKey(), paramDownloadInfo.getFtnCode(), paramDownloadInfo.getFileName(), new FtnManager.4(this, paramDownloadInfo));
  }
  
  public HashMap<String, Integer> getFidIndex(int paramInt)
  {
    return this.mFtnSQLite.getFidByFileType(paramInt);
  }
  
  public HashMap<String, Integer> getFidIndex(int paramInt, String paramString)
  {
    return this.mFtnSQLite.getFidByFileTypeAndName(paramInt, paramString);
  }
  
  public Set<String> getFidsByFids(List<String> paramList)
  {
    return this.mFtnSQLite.getFidsByFids(paramList);
  }
  
  public void getFileRarPreview(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    FtnManagerImpl.getFileRarPreview(paramString1, paramString2, paramString3, paramString4, new FtnManager.15(this));
  }
  
  public void getFileVideoPreview(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    FtnManagerImpl.getFileVideoPreview(paramString1, paramString2, paramString3, paramLong, new FtnManager.12(this, paramString2));
  }
  
  public int getFtnExpUnreadCount()
  {
    if (this.mFtnExpireInfo == null) {
      return 0;
    }
    return this.mFtnExpireInfo.getLstExpireCnt();
  }
  
  public boolean getFtnExpUnreadUpdate()
  {
    return this.mFtnExpUnreadUpdate;
  }
  
  public FtnExpireInfo getFtnExpireInfo(long paramLong)
  {
    return this.mFtnSQLite.readFtnExpireInfo(paramLong);
  }
  
  public FtnUI getFtnList()
  {
    return this.mFtnSQLite.getFtnUI(this.ftnType, this.sortType);
  }
  
  public FtnUI getFtnList(int paramInt)
  {
    return this.mFtnSQLite.getFtnUIByFileType(paramInt);
  }
  
  public FtnUI getFtnListByFids(List<String> paramList)
  {
    return this.mFtnSQLite.getFtnUIByFids(paramList);
  }
  
  public boolean getIsFromFtn()
  {
    return this.mIsFromFtn;
  }
  
  public void getList()
  {
    getList(null);
  }
  
  public void getList(Subscriber<? super Void> paramSubscriber)
  {
    FtnManagerImpl.getList(0L, false, "", false, new FtnManager.3(this, paramSubscriber));
  }
  
  public Observable<Void> getListInObservable()
  {
    return Observable.create(new FtnManager.2(this));
  }
  
  public void getShareUrl(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (SharedUrlUtil.contain(paramString1))
    {
      QMLog.log(4, "FtnManager", "Ftn get share url success from sp");
      QMNotification.postNotification("actiongetshareurlsucc", QMNotification.createNotification(new Object[] { "paramfid", paramString1, "paramactionid", Integer.valueOf(paramInt) }));
      return;
    }
    paramString1 = new FtnManager.5(this, paramString1, paramInt, paramString2);
    FtnManagerImpl.getShareUrl(new String[] { paramString3 }, new String[] { paramString4 }, paramString1);
  }
  
  public int getUploadCountByState(int paramInt)
  {
    Iterator localIterator = this.uploadFileDataCache.entrySet().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (((FtnUploadInfo)((Map.Entry)localIterator.next()).getValue()).getState() != paramInt) {
        break label59;
      }
      i += 1;
    }
    label59:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public List<FtnUploadInfo> getUploadInfo()
  {
    return this.mFtnUploadSQLite.queryUploadInfo();
  }
  
  public Map<String, FtnUploadInfo> getUploadInfoByFids(List<String> paramList)
  {
    return this.mFtnUploadSQLite.queryUploadInfoByFids(paramList);
  }
  
  public FtnUserProfile getUserProfile(String paramString)
  {
    return this.mFtnSQLite.getUserProfile(paramString);
  }
  
  public boolean goOnRequest(String paramString)
  {
    FtnRequestQueue.FtnBaseRequest localFtnBaseRequest = (FtnRequestQueue.FtnBaseRequest)this.mAbortedRequest.get(paramString);
    if (localFtnBaseRequest != null)
    {
      localFtnBaseRequest.goOn();
      this.mProcessingRequest.put(paramString, localFtnBaseRequest);
      return true;
    }
    return false;
  }
  
  public boolean hasFtnAccount()
  {
    return AccountManager.shareInstance().getAccountList().getDefaultFtnAccount() != null;
  }
  
  public void insertDownloadInfo(FtnDownloadInfo paramFtnDownloadInfo)
  {
    this.mFtnSQLite.insertDownloadInfo(paramFtnDownloadInfo);
  }
  
  public void insertFtnExpireInfo(FtnExpireInfo paramFtnExpireInfo)
  {
    this.mFtnSQLite.insertFtnExpireInfo(paramFtnExpireInfo);
  }
  
  public void insertUploadData(String paramString, FtnUploadInfo paramFtnUploadInfo)
  {
    if (paramString == null) {}
    while (this.uploadFileDataCache.containsKey(paramString)) {
      return;
    }
    this.uploadFileDataCache.put(paramString, paramFtnUploadInfo);
  }
  
  public void insertUserProfile(FtnUserProfile paramFtnUserProfile)
  {
    this.mFtnSQLite.updateUserProfile(paramFtnUserProfile);
  }
  
  public boolean isAccessFtnBefore(long paramLong)
  {
    if (isAccessFtnBefore.get(Long.valueOf(paramLong)) == null) {
      return false;
    }
    return ((Boolean)isAccessFtnBefore.get(Long.valueOf(paramLong))).booleanValue();
  }
  
  public boolean isClearUploadNotify()
  {
    Iterator localIterator = this.uploadFileDataCache.entrySet().iterator();
    while (localIterator.hasNext()) {
      if (((FtnUploadInfo)((Map.Entry)localIterator.next()).getValue()).getState() == 2) {
        return false;
      }
    }
    return true;
  }
  
  public boolean isFtnExpUnreadNeedShow()
  {
    return (getFtnExpUnreadCount() > 0) && (!getIsFromFtn()) && ((getFtnExpUnreadUpdate()) || ((!getFtnExpUnreadUpdate()) && (!isAccessFtnBefore(getAccountId())) && (isFtnExpUnreadShow(getAccountId()))));
  }
  
  public boolean isFtnExpUnreadShow(long paramLong)
  {
    if (isFtnExpireShow.get(Long.valueOf(paramLong)) == null) {
      return false;
    }
    return ((Boolean)isFtnExpireShow.get(Long.valueOf(paramLong))).booleanValue();
  }
  
  public boolean isFtnExsit(String paramString)
  {
    return this.mFtnSQLite.isFtnExsit(paramString);
  }
  
  public void onTerminate()
  {
    this.mFtnRequestQueue.terminate();
    this.mFtnSQLite.closeDatabase();
    this.mFtnUploadSQLite.closeDatabase();
  }
  
  public void queryAccount()
  {
    FtnManagerImpl.queryAccount(new FtnManager.16(this));
  }
  
  public void removeUploadData(String paramString)
  {
    if (StringUtils.isEmpty(paramString)) {}
    while (!this.uploadFileDataCache.containsKey(paramString)) {
      return;
    }
    this.uploadFileDataCache.remove(paramString);
  }
  
  public void renewFile(ArrayList<String> paramArrayList, ArrayList<Integer> paramArrayList1)
  {
    renewFile(paramArrayList, paramArrayList1, null);
  }
  
  public void renewFile(ArrayList<String> paramArrayList, ArrayList<Integer> paramArrayList1, FtnDefine.FtnCallback paramFtnCallback)
  {
    String[] arrayOfString = (String[])paramArrayList.toArray(new String[0]);
    int[] arrayOfInt = new int[paramArrayList1.size()];
    Iterator localIterator = paramArrayList1.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      arrayOfInt[i] = ((Integer)localIterator.next()).intValue();
      i += 1;
    }
    FtnManagerImpl.renewFile(arrayOfString, arrayOfInt, new FtnManager.14(this, paramArrayList, paramArrayList1, paramFtnCallback));
    DataCollector.logEvent("Event_Ftn_Renew");
  }
  
  public void saveFile(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    saveFile(paramArrayList1, paramArrayList2, null);
  }
  
  public void saveFile(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, SaveFtnFileCallback paramSaveFtnFileCallback)
  {
    FtnManagerImpl.saveFile((String[])paramArrayList1.toArray(new String[0]), (String[])paramArrayList2.toArray(new String[0]), new FtnManager.17(this, paramSaveFtnFileCallback));
  }
  
  public FtnUI searchFtnList()
  {
    return this.mFtnSQLite.getFtnByFtnType(this.ftnType);
  }
  
  public FtnUI searchFtnList(int paramInt, String paramString)
  {
    return this.mFtnSQLite.getFtnUIByFileTypeAndName(paramInt, paramString);
  }
  
  public FtnUI searchFtnList(String paramString)
  {
    return this.mFtnSQLite.getFtnUIByFtnTypeAndName(this.ftnType, paramString);
  }
  
  public void setAccessFtnBefore(long paramLong, boolean paramBoolean)
  {
    isAccessFtnBefore.put(Long.valueOf(paramLong), Boolean.valueOf(paramBoolean));
  }
  
  public void setFtnExpUnreadShow(long paramLong, boolean paramBoolean)
  {
    isFtnExpireShow.put(Long.valueOf(paramLong), Boolean.valueOf(paramBoolean));
  }
  
  public void setFtnExpUnreadUpdate(boolean paramBoolean)
  {
    this.mFtnExpUnreadUpdate = paramBoolean;
  }
  
  public void setFtnExpireInfo(FtnExpireInfo paramFtnExpireInfo)
  {
    this.mFtnExpireInfo = paramFtnExpireInfo;
  }
  
  public void setIsFromFtn(boolean paramBoolean)
  {
    this.mIsFromFtn = paramBoolean;
  }
  
  public void signFile(FtnUploadInfo paramFtnUploadInfo)
  {
    signFile(paramFtnUploadInfo, null);
  }
  
  public void signFile(FtnUploadInfo paramFtnUploadInfo, Subscriber<? super FtnUploadInfo> paramSubscriber)
  {
    QMLog.log(3, "FtnManager", "signFile file: " + paramFtnUploadInfo.getAbsolutePath() + ", size: " + paramFtnUploadInfo.getFileSize());
    new FileSignRequest(paramFtnUploadInfo, new FtnManager.9(this, paramSubscriber, paramFtnUploadInfo));
  }
  
  public Observable<FtnUploadInfo> signFileInObservable(FtnUploadInfo paramFtnUploadInfo)
  {
    return Observable.create(new FtnManager.8(this, paramFtnUploadInfo));
  }
  
  public int syncFtnUploadIndex()
  {
    int j = 0;
    try
    {
      Object localObject = this.mFtnSQLite.getExtraInfo("extrakey_uploadidx");
      int i;
      long l;
      if ((localObject == null) || (((String)localObject).equals("")))
      {
        this.mFtnSQLite.setExtraInfo("extrakey_uploadidx", String.valueOf(0));
        i = 0;
        localObject = this.mFtnSQLite.getExtraInfo("extrakey_upload");
        if ((localObject != null) && (!((String)localObject).equals(""))) {
          break label153;
        }
        l = System.currentTimeMillis();
        this.mFtnSQLite.setExtraInfo("extrakey_upload", String.valueOf(l));
        label90:
        if (System.currentTimeMillis() - l <= 86400000L) {
          break label171;
        }
        this.mFtnSQLite.setExtraInfo("extrakey_upload", String.valueOf(System.currentTimeMillis()));
        i = j;
      }
      for (;;)
      {
        localObject = this.mFtnSQLite;
        i += 1;
        ((QMFtnSQLite)localObject).setExtraInfo("extrakey_uploadidx", String.valueOf(i));
        return i;
        i = Integer.parseInt((String)localObject);
        break;
        label153:
        l = Long.parseLong((String)localObject);
        break label90;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return 1;
    }
  }
  
  public void transCodeVideo(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    FtnManagerImpl.transCodeVideo(paramString1, paramLong, paramString2, paramString3, new FtnManager.11(this));
  }
  
  public final void triggerFtnQueryAccountError(HashMap<String, Object> paramHashMap)
  {
    int i = 0;
    while (i < sFtnQueryAccountWatchers.size())
    {
      ((FtnQueryAccountWatcher)sFtnQueryAccountWatchers.get(i)).onError();
      i += 1;
    }
  }
  
  public final void triggerFtnQueryAccountSuccess(HashMap<String, Object> paramHashMap)
  {
    int i = 0;
    while (i < sFtnQueryAccountWatchers.size())
    {
      ((FtnQueryAccountWatcher)sFtnQueryAccountWatchers.get(i)).onSuccess(paramHashMap);
      i += 1;
    }
  }
  
  public final void triggerFtnQueryExpireUnreadSuccess(long paramLong, FtnExpireInfo paramFtnExpireInfo, boolean paramBoolean)
  {
    int i = 0;
    while (i < sFtnQueryExpireUnreadWatchers.size())
    {
      ((FtnQueryExpireUnreadWatcher)sFtnQueryExpireUnreadWatchers.get(i)).onSuccess(paramLong, paramFtnExpireInfo, paramBoolean);
      i += 1;
    }
  }
  
  public void updateDownloadInfoById(String paramString1, String paramString2)
  {
    this.mFtnSQLite.updateDownloadInfoById(paramString1, paramString2);
  }
  
  public boolean updateFtn(String paramString1, String paramString2, String paramString3)
  {
    return this.mFtnSQLite.updateFtn(paramString1, paramString2, paramString3);
  }
  
  public boolean updateFtn(HashMap<String, HashMap<String, String>> paramHashMap)
  {
    return this.mFtnSQLite.updateFtn(paramHashMap);
  }
  
  public boolean updateRefMailId(String paramString, long paramLong)
  {
    return this.mFtnSQLite.updateFtnRefMailId(paramString, paramLong);
  }
  
  public void updateUploadInfoProgress(String paramString, int paramInt)
  {
    this.mFtnUploadSQLite.updateUploadInfoProgress(paramString, paramInt);
  }
  
  public void uploadFile(FtnUploadInfo paramFtnUploadInfo, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    uploadFile(paramFtnUploadInfo, paramString1, paramInt, paramString2, paramString3, null);
  }
  
  public void uploadFile(FtnUploadInfo paramFtnUploadInfo, String paramString1, int paramInt, String paramString2, String paramString3, FtnDefine.FtnCallback paramFtnCallback)
  {
    paramString1 = this.mFtnRequestQueue.addUploadFile(paramString1, paramInt, paramString2, paramString3, paramFtnUploadInfo.getAbsolutePath(), new FtnManager.10(this, paramFtnCallback, paramFtnUploadInfo));
    addRequest(paramFtnUploadInfo.getFid(), paramString1);
    insertUploadData(paramFtnUploadInfo.getFid(), paramFtnUploadInfo);
    DataCollector.logEvent("Event_Ftn_Upload_New");
  }
  
  static class UploadState
  {
    public int fail = 0;
    public int pause = 0;
    public int total = 0;
    public int uploading = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManager
 * JD-Core Version:    0.7.0.1
 */