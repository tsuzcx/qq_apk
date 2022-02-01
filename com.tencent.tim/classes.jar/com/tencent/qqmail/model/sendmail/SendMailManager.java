package com.tencent.qqmail.model.sendmail;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONObject;
import com.tencent.androidqqmail.tim.TimReportManager;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.ftn.Ftn.FileInfo;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.callback.SendMailFtnCallback;
import com.tencent.qqmail.ftn.model.FtnUI;
import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.QMFolderSQLite;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMMailProtocolManager;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.task.QMTaskManager;
import com.tencent.qqmail.model.task.QMTaskSQLiteHelper;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.verify.QMVerify;
import com.tencent.qqmail.utilities.VmDetectUtil;
import com.tencent.qqmail.utilities.abtest.QMABTestManager;
import com.tencent.qqmail.utilities.encryptionalgorithm.RsaEncryption;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmbroadcastreceiver.QMNetworkHandler;
import com.tencent.qqmail.utilities.qmnetwork.CGIManager;
import com.tencent.qqmail.utilities.qmnetwork.CGIRequest;
import com.tencent.qqmail.utilities.qmnetwork.NetworkManager;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMCancelError;
import com.tencent.qqmail.utilities.qmnetwork.QMFileEntity;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkConfig;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest.QMHttpMethod;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.QMSchedulers;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import moai.oss.KvHelper;
import moai.oss.OssHelper;
import org.apache.commons.lang3.StringUtils;
import rx.Observable;
import rx.Subscriber;

public class SendMailManager
{
  private static final String FILE_ENTITY = "fileEntity";
  private static String TAG = "SendMailManager";
  private static volatile SendMailManager _instance;
  private QMFolderManager folderMgr = QMMailManager.sharedInstance().getFolderMgr();
  private QMMailManager mailMgr = QMMailManager.sharedInstance();
  private QMMailProtocolManager protocolMgr = QMMailManager.sharedInstance().getProtocolMgr();
  private QMMailSQLiteHelper sqliteHelper = QMMailManager.sharedInstance().getSqliteHelper();
  
  private int bool2int(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1;
    }
    return 0;
  }
  
  @NonNull
  private Observable<JSONObject> checkFile(JSONObject paramJSONObject, int paramInt1, int paramInt2)
  {
    QMLog.log(3, TAG, "checkFile");
    String str1 = getDataJson(paramJSONObject).getString("sFileId");
    String str2 = paramJSONObject.getString("md5");
    paramJSONObject = (QMFileEntity)paramJSONObject.getObject("fileEntity", QMFileEntity.class);
    return CGIManager.httpGet(paramInt2, "uploadunite", StringExtention.replace(StringExtention.replace(StringExtention.replace("func=CheckFile&fromapp=1&&fileid=$fileid$&md5=$md5$&suffix=$suffix$", "fileid", str1), "md5", str2), "suffix", FileUtil.getFileNameSuffix(paramJSONObject.getFileNameString()))).doOnError(new SendMailManager.44(this)).flatMap(new SendMailManager.43(this, paramJSONObject, paramInt1)).retry(new SendMailManager.42(this));
  }
  
  @NonNull
  private Observable<JSONObject> createFile(QMFileEntity paramQMFileEntity, int paramInt)
  {
    QMLog.log(3, TAG, "createFile");
    String str2 = FileUtil.calculateDigest(paramQMFileEntity.getFile(), "SHA-1");
    String str3 = FileUtil.calculateDigest(paramQMFileEntity.getFile(), "MD5");
    String str4 = StringExtention.replace("func=CreateFile&fromapp=1&sha=$sha$&path=$path$&md5=$md5$&size=$size$", "sha", str2);
    Object localObject = "";
    try
    {
      String str1 = StringExtention.urlEncode(paramQMFileEntity.getFileNameString());
      localObject = str1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        QMLog.log(6, TAG, localUnsupportedEncodingException.getMessage(), localUnsupportedEncodingException);
      }
    }
    return CGIManager.httpGet(paramInt, "uploadunite", StringExtention.replace(StringExtention.replace(StringExtention.replace(str4, "path", (String)localObject), "md5", str3), "size", paramQMFileEntity.getFile().length() + "")).doOnError(new SendMailManager.41(this)).flatMap(new SendMailManager.40(this, paramQMFileEntity, str2, str3)).retry(new SendMailManager.39(this));
  }
  
  public static SendMailManager createInstance()
  {
    if (_instance == null) {}
    try
    {
      if (_instance == null) {
        _instance = new SendMailManager();
      }
      return _instance;
    }
    finally {}
  }
  
  private Observable<Void> fillMailBigAttach(List<FtnUploadInfo> paramList, ArrayList<AttachInfo> paramArrayList)
  {
    return Observable.create(new SendMailManager.14(this, paramList, paramArrayList));
  }
  
  private long getBinaryFilesTotalBytes(List<QMFileEntity> paramList)
  {
    paramList = paramList.iterator();
    for (long l = 0L; paramList.hasNext(); l = ((QMFileEntity)paramList.next()).getFile().length() + l) {}
    return l;
  }
  
  private JSONObject getDataJson(JSONObject paramJSONObject)
  {
    return paramJSONObject.getJSONObject("data");
  }
  
  @NonNull
  private String getFtnErrorDescription(int paramInt, String paramString)
  {
    String str;
    if (paramInt == -110) {
      str = QMApplicationContext.sharedInstance().getString(2131719527);
    }
    do
    {
      return str;
      if (paramInt == 5) {
        return QMApplicationContext.sharedInstance().getString(2131719521);
      }
      if (paramInt == 4) {
        return QMApplicationContext.sharedInstance().getString(2131719542);
      }
      if (paramInt == 0)
      {
        if (QMNetworkUtils.isNetworkAvailable()) {
          return QMApplicationContext.sharedInstance().getString(2131719542);
        }
        return QMApplicationContext.sharedInstance().getString(2131719529);
      }
      str = paramString;
    } while (!TextUtils.isEmpty(paramString));
    return QMApplicationContext.sharedInstance().getString(2131719541);
  }
  
  @NonNull
  private Observable<List<FtnUploadInfo>> getFtnList(List<FtnUploadInfo> paramList)
  {
    return FtnManager.sharedInstance().getListInObservable().flatMap(new SendMailManager.15(this, paramList));
  }
  
  private String getLegalLog(String paramString)
  {
    return paramString.substring(0, Math.min(150, paramString.length())).replace("\r\n", "|").replace("\n", "|");
  }
  
  private void getNetworkErrorMsg(QMNetworkError paramQMNetworkError, StringBuilder paramStringBuilder)
  {
    String str2 = paramQMNetworkError.desp;
    String str1 = str2;
    if (!TextUtils.isEmpty(str2)) {
      str1 = getLegalLog(str2);
    }
    paramStringBuilder.append(str1).append(";");
    if (QMNetworkError.despContainsRequestDetail(paramQMNetworkError.debugDescription))
    {
      paramStringBuilder.append(getLegalLog(paramQMNetworkError.debugDescription));
      return;
    }
    paramStringBuilder.append(";;;");
  }
  
  private long getPostDataBytesEstimation(HashMap<String, String> paramHashMap, String paramString)
  {
    long l1 = paramString.getBytes().length;
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      paramString = (Map.Entry)paramHashMap.next();
      long l2 = ((String)paramString.getKey()).getBytes().length;
      l1 = ((String)paramString.getValue()).getBytes().length + (l1 + l2);
    }
    return l1;
  }
  
  private QMTaskSQLiteHelper getTaskSqLite()
  {
    return QMTaskManager.sharedInstance(1).getSQLite();
  }
  
  @NonNull
  private Map<String, FtnUploadInfo> getUploadedFtnUploadInfoMap(List<String> paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = FtnManager.sharedInstance().getFtnListByFids(paramList);
    int i = 0;
    while (i < paramList.getCount())
    {
      FileInfo localFileInfo = paramList.get(i);
      FtnUploadInfo localFtnUploadInfo = new FtnUploadInfo();
      localFtnUploadInfo.setFid(localFileInfo.fid);
      localFtnUploadInfo.setFileSize(localFileInfo.filesize);
      localHashMap.put(localFileInfo.fid, localFtnUploadInfo);
      i += 1;
    }
    return localHashMap;
  }
  
  @NonNull
  private <T> Observable<T> isAbort(T paramT, AtomicBoolean paramAtomicBoolean)
  {
    return Observable.create(new SendMailManager.16(this, paramAtomicBoolean, paramT));
  }
  
  @NonNull
  private Boolean isRetry(Integer paramInteger, Throwable paramThrowable)
  {
    QMLog.log(5, TAG, "retry count:" + paramInteger + ", err: " + paramThrowable);
    if (((paramThrowable instanceof QMNetworkError)) && (QMNetworkUtils.isNetworkAvailable()) && (paramInteger.intValue() < 3))
    {
      SystemClock.sleep(new Random().nextInt(500));
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  
  @NonNull
  private Observable<Void> normalAttach2BigAttach(ComposeMailUI paramComposeMailUI, int paramInt, AtomicBoolean paramAtomicBoolean, BinaryFilesData paramBinaryFilesData, SendMailFtnCallback paramSendMailFtnCallback, MailManagerDelegate paramMailManagerDelegate)
  {
    if (FtnManager.sharedInstance() == null) {
      return Observable.just(null);
    }
    Object localObject3 = paramComposeMailUI.getAddAttachInfoList();
    if (localObject3 == null) {
      return Observable.just(null);
    }
    paramComposeMailUI = paramBinaryFilesData.bytesWrittenRecord;
    Object localObject2 = new ArrayList();
    paramBinaryFilesData = ((ArrayList)localObject3).iterator();
    while (paramBinaryFilesData.hasNext())
    {
      localObject1 = (AttachInfo)paramBinaryFilesData.next();
      if ((((AttachInfo)localObject1).isNeedFtnUpload()) && (!TextUtils.isEmpty(((AttachInfo)localObject1).getFid()))) {
        ((List)localObject2).add(((AttachInfo)localObject1).getFid());
      }
    }
    paramBinaryFilesData = getUploadedFtnUploadInfoMap((List)localObject2);
    Object localObject1 = paramBinaryFilesData.keySet();
    ((List)localObject2).removeAll((Collection)localObject1);
    localObject2 = FtnManager.sharedInstance().getUploadInfoByFids((List)localObject2);
    replaceUnfinishUploadItemsByCache((Map)localObject2);
    Set localSet = ((Map)localObject2).keySet();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    localObject3 = ((ArrayList)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      AttachInfo localAttachInfo = (AttachInfo)((Iterator)localObject3).next();
      if (localAttachInfo.isNeedFtnUpload())
      {
        Object localObject4 = new File(localAttachInfo.getAttachPath());
        paramComposeMailUI.bytesAttachNeedFtnUpload += ((File)localObject4).length();
        paramComposeMailUI.totalBytes += ((File)localObject4).length();
        if ((((File)localObject4).exists()) && (((File)localObject4).isFile()))
        {
          localArrayList3.add(localAttachInfo);
          localObject4 = localAttachInfo.getFid();
          if (((Set)localObject1).contains(localObject4))
          {
            localObject4 = (FtnUploadInfo)paramBinaryFilesData.get(localObject4);
            localArrayList2.add(localObject4);
            paramComposeMailUI.bytesWrittenByFilePathMap.put(localAttachInfo.getAttachPath(), Long.valueOf(((FtnUploadInfo)localObject4).getFileSize()));
            QMLog.log(4, TAG, "has uploaded success, attachId:" + localAttachInfo.getHashId() + ", fid:" + ((FtnUploadInfo)localObject4).getFid());
          }
          else if (localSet.contains(localObject4))
          {
            localObject4 = (FtnUploadInfo)((Map)localObject2).get(localObject4);
            if (paramSendMailFtnCallback != null) {
              paramSendMailFtnCallback.onFtnAttachStratUpload((FtnUploadInfo)localObject4);
            }
            localArrayList1.add(new Pair(localAttachInfo, localObject4));
            QMLog.log(4, TAG, "uploading, name:" + ((FtnUploadInfo)localObject4).getName() + ", fid:" + ((FtnUploadInfo)localObject4).getFid() + ", progress:" + ((FtnUploadInfo)localObject4).getProgress() + ", stage:" + ((FtnUploadInfo)localObject4).getStage());
          }
          else
          {
            localArrayList1.add(new Pair(localAttachInfo, new FtnUploadInfo(null, localAttachInfo.getAttachPath(), 1, -1)));
          }
        }
      }
    }
    if (paramMailManagerDelegate != null)
    {
      long l = paramComposeMailUI.getBytesWritten();
      Log.d(TAG, "normalAttach2BigAttach skip:" + l + ", total:" + paramComposeMailUI.totalBytes);
      paramMailManagerDelegate.handleSendData(Long.valueOf(l), Long.valueOf(paramComposeMailUI.totalBytes));
    }
    QMLog.log(4, TAG, "normalAttach2BigAttach attachUploadingftnUploadInfoPairs:" + localArrayList1.size() + ", attachUploadedftnUploadInfors:" + localArrayList2.size() + ", total:" + paramComposeMailUI.totalBytes);
    int i = localArrayList1.size() + localArrayList2.size();
    if (i == 0) {
      return Observable.just(null);
    }
    if ((paramAtomicBoolean != null) && (paramAtomicBoolean.get())) {
      return Observable.error(new QMCancelError(true));
    }
    return Observable.merge(signAndUploadBigAttach(paramInt, paramAtomicBoolean, localArrayList1, paramComposeMailUI, paramSendMailFtnCallback, paramMailManagerDelegate), Observable.from(localArrayList2)).buffer(i).flatMap(new SendMailManager.13(this, paramAtomicBoolean)).flatMap(new SendMailManager.12(this)).flatMap(new SendMailManager.11(this, localArrayList3));
  }
  
  private String replaceInlineImageByUrl(String paramString1, QMFileEntity paramQMFileEntity, String paramString2, List<String> paramList)
  {
    String str = paramString1;
    if (paramList.size() > 0)
    {
      str = paramString1;
      if (paramList.contains(paramQMFileEntity.getFile().getPath())) {
        str = paramString1.replace("file://localhost" + paramQMFileEntity.getFile().getPath(), paramString2);
      }
    }
    return str;
  }
  
  private void replaceUnfinishUploadItemsByCache(Map<String, FtnUploadInfo> paramMap)
  {
    if ((paramMap == null) && (paramMap.size() == 0)) {}
    for (;;)
    {
      return;
      Set localSet = paramMap.keySet();
      Iterator localIterator = FtnManager.sharedInstance().getAllUploadData().iterator();
      while (localIterator.hasNext())
      {
        FtnUploadInfo localFtnUploadInfo = (FtnUploadInfo)localIterator.next();
        if (localSet.contains(localFtnUploadInfo.getFid()))
        {
          paramMap.put(localFtnUploadInfo.getFid(), localFtnUploadInfo);
          Log.d(TAG, "get ftn cache, fid: " + localFtnUploadInfo.getFid() + ", getState: " + localFtnUploadInfo.getState());
          if (localFtnUploadInfo.getState() == 2) {
            FtnManager.sharedInstance().abortRequest(localFtnUploadInfo.getFid());
          }
        }
      }
    }
  }
  
  private void reportSendMailError(long paramLong, AtomicBoolean paramAtomicBoolean1, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, AtomicBoolean paramAtomicBoolean2, AtomicBoolean paramAtomicBoolean3, AtomicInteger paramAtomicInteger)
  {
    long l = System.currentTimeMillis();
    if ((QMNetworkUtils.isNetworkAvailable()) && (!paramAtomicBoolean1.get())) {}
    for (boolean bool = true;; bool = false)
    {
      if (paramStringBuilder1.length() == 0) {
        paramStringBuilder1.append(";;;;");
      }
      paramStringBuilder2.append(";").append(bool2int(paramAtomicBoolean2.get())).append(";").append(bool2int(bool)).append(";").append(bool2int(paramAtomicBoolean3.get())).append(";").append(l - paramLong).append(";").append(paramAtomicInteger.get()).append(";").append(bool2int(QMABTestManager.isSendMailByFtn())).append(";").append(QMNetworkUtils.getActiveNetworkName()).append(";").append(QMNetworkUtils.getNetworkLevel()).append(";").append(paramStringBuilder1.toString());
      OssHelper.cgiSendmailInfo(new Object[] { paramStringBuilder2.toString() });
      QMLog.log(4, TAG, "sendMailByCGI detailInfo:" + paramStringBuilder2);
      return;
    }
  }
  
  private Observable<QMNetworkRequest> sendMailByFtn(int paramInt1, String paramString1, HashMap<String, String> paramHashMap, String paramString2, ComposeMailUI paramComposeMailUI, int paramInt2, SendMailRequest paramSendMailRequest, BinaryFilesData paramBinaryFilesData, SendMailFtnCallback paramSendMailFtnCallback, QMCallback paramQMCallback)
  {
    List localList1 = paramBinaryFilesData.binayFiles;
    ArrayList localArrayList = paramBinaryFilesData.allInlineImgsPaths;
    String str = paramBinaryFilesData.removeFiles;
    AtomicBoolean localAtomicBoolean = paramSendMailRequest.getIsAbort();
    AtomicInteger localAtomicInteger = paramSendMailRequest.getStep();
    long l2 = getPostDataBytesEstimation(paramHashMap, paramString2);
    Log.d(TAG, "postDataBytesEstimation:" + l2);
    BytesWrittenRecord localBytesWrittenRecord = paramBinaryFilesData.bytesWrittenRecord;
    localBytesWrittenRecord.totalBytes += l2;
    long l1 = paramBinaryFilesData.getTotalBytes();
    paramBinaryFilesData = new QMCallback(paramQMCallback);
    paramBinaryFilesData.setOnBeforeSend(null);
    paramBinaryFilesData.setOnSuccess(new SendMailManager.27(this, paramInt2, paramQMCallback));
    paramBinaryFilesData.setOnSendData(new SendMailManager.28(this, localBytesWrittenRecord, l2, paramQMCallback));
    StringBuilder localStringBuilder = new StringBuilder();
    List localList2 = getTaskSqLite().getSendMailTaskAttachInfo(paramInt2);
    if (localList2.size() > 0)
    {
      paramSendMailRequest = (String)paramHashMap.get("content");
      Iterator localIterator1 = localList1.iterator();
      List localList3 = Arrays.asList(str.split(","));
      while (localIterator1.hasNext())
      {
        QMFileEntity localQMFileEntity = (QMFileEntity)localIterator1.next();
        Iterator localIterator2 = localList2.iterator();
        while (localIterator2.hasNext())
        {
          SendMailTaskAttachInfo localSendMailTaskAttachInfo = (SendMailTaskAttachInfo)localIterator2.next();
          if (localQMFileEntity.getFile().getPath().equals(localSendMailTaskAttachInfo.getPath()))
          {
            QMLog.log(4, TAG, "sendMailByFtn cache, path:" + localSendMailTaskAttachInfo.getPath() + ", fileid: " + localSendMailTaskAttachInfo.getFileId());
            paramSendMailRequest = replaceInlineImageByUrl(paramSendMailRequest, localQMFileEntity, localSendMailTaskAttachInfo.getUrl(), localArrayList);
            localBytesWrittenRecord.bytesWrittenByFilePathMap.put(localQMFileEntity.getFile().getPath(), Long.valueOf(localQMFileEntity.getFile().length()));
            if (!localList3.contains(localQMFileEntity.getFile().getName())) {
              localStringBuilder.append(localSendMailTaskAttachInfo.getFileId()).append("|");
            }
            localIterator1.remove();
          }
        }
      }
      paramHashMap.put("content", paramSendMailRequest);
      if (paramQMCallback != null)
      {
        l2 = localBytesWrittenRecord.getBytesWritten();
        KvHelper.sendmailByFtnSkipAttachSize(new double[] { (float)l2 / 1024.0F });
        Log.d(TAG, "skip:" + l2 + ", total:" + l1);
        paramQMCallback.handleSendData(null, l2, l1);
      }
    }
    QMLog.log(4, TAG, localList1.size() + " files is needed to send");
    if (localList1.size() == 0) {
      return sendMailContent(new ArrayList(), paramHashMap, str, localStringBuilder, localArrayList, paramComposeMailUI, paramString2, paramInt1, paramString1, paramBinaryFilesData);
    }
    localAtomicInteger.set(4);
    return Observable.from(localList1).subscribeOn(QMSchedulers.network()).flatMap(new SendMailManager.37(this, paramInt1)).flatMap(new SendMailManager.36(this, localAtomicBoolean)).buffer(localList1.size()).flatMap(new SendMailManager.35(this, localAtomicInteger)).flatMap(new SendMailManager.34(this, l1, localBytesWrittenRecord, paramSendMailFtnCallback, paramQMCallback)).flatMap(new SendMailManager.33(this, localAtomicBoolean)).buffer(localList1.size()).flatMap(new SendMailManager.32(this, localAtomicInteger)).flatMap(new SendMailManager.31(this, paramInt2, paramInt1)).flatMap(new SendMailManager.30(this, localAtomicBoolean)).buffer(localList1.size()).flatMap(new SendMailManager.29(this, localAtomicInteger, paramHashMap, str, localStringBuilder, localArrayList, paramComposeMailUI, paramString2, paramInt1, paramString1, paramBinaryFilesData));
  }
  
  private void sendMailByProtocol(Account paramAccount, ComposeMailUI paramComposeMailUI, int paramInt, MailManagerDelegate paramMailManagerDelegate, SendMailRequest paramSendMailRequest, SendMailFtnCallback paramSendMailFtnCallback)
  {
    AtomicInteger localAtomicInteger = paramSendMailRequest.getStep();
    BinaryFilesData localBinaryFilesData = new BinaryFilesData();
    Object localObject = paramComposeMailUI.getAddAttachInfoList();
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AttachInfo localAttachInfo = (AttachInfo)((Iterator)localObject).next();
        if (localAttachInfo.isBinaryAttach())
        {
          BytesWrittenRecord localBytesWrittenRecord = localBinaryFilesData.bytesWrittenRecord;
          localBytesWrittenRecord.totalBytes += localAttachInfo.getRealSize();
        }
      }
    }
    Log.d(TAG, "totalBytes:" + localBinaryFilesData.getTotalBytes());
    localAtomicInteger.set(2);
    normalAttach2BigAttach(paramComposeMailUI, paramInt, paramSendMailRequest.getIsAbort(), localBinaryFilesData, paramSendMailFtnCallback, paramMailManagerDelegate).subscribeOn(QMSchedulers.network()).flatMap(new SendMailManager.5(this, paramSendMailRequest)).doOnNext(new SendMailManager.4(this, localAtomicInteger, paramMailManagerDelegate, localBinaryFilesData, paramAccount, paramComposeMailUI, paramSendMailRequest)).onErrorResumeNext(new SendMailManager.3(this, paramSendMailRequest, localAtomicInteger, paramMailManagerDelegate)).subscribe();
  }
  
  @NonNull
  private Observable<QMNetworkRequest> sendMailContent(List<JSONObject> paramList, HashMap<String, String> paramHashMap, String paramString1, StringBuilder paramStringBuilder, List<String> paramList1, ComposeMailUI paramComposeMailUI, String paramString2, int paramInt, String paramString3, QMCallback paramQMCallback)
  {
    return Observable.create(new SendMailManager.38(this, paramHashMap, paramString1, paramStringBuilder, paramList, paramList1, paramComposeMailUI, paramString2, paramInt, paramString3, paramQMCallback));
  }
  
  public static SendMailManager sharedInstance()
  {
    createInstance();
    return _instance;
  }
  
  private Observable<FtnUploadInfo> signAndUploadBigAttach(int paramInt, AtomicBoolean paramAtomicBoolean, List<Pair<AttachInfo, FtnUploadInfo>> paramList, BytesWrittenRecord paramBytesWrittenRecord, SendMailFtnCallback paramSendMailFtnCallback, MailManagerDelegate paramMailManagerDelegate)
  {
    return Observable.from(paramList).flatMap(new SendMailManager.19(this, paramInt)).flatMap(new SendMailManager.18(this, paramAtomicBoolean)).flatMap(new SendMailManager.17(this, paramInt, paramBytesWrittenRecord, paramSendMailFtnCallback, paramMailManagerDelegate));
  }
  
  @NonNull
  private Observable<Pair<AttachInfo, FtnUploadInfo>> signFile(Pair<AttachInfo, FtnUploadInfo> paramPair, int paramInt)
  {
    AttachInfo localAttachInfo = (AttachInfo)paramPair.first;
    FtnUploadInfo localFtnUploadInfo = (FtnUploadInfo)paramPair.second;
    QMLog.log(4, TAG, "ftnAttach signFile, " + localAttachInfo.getAttachName() + " stage:" + localFtnUploadInfo.getStage());
    if ((localFtnUploadInfo.getStage() == 0) || (localFtnUploadInfo.getStage() == 1))
    {
      localFtnUploadInfo.setState(1);
      return FtnManager.sharedInstance().signFileInObservable((FtnUploadInfo)paramPair.second).flatMap(new SendMailManager.20(this, paramInt, localAttachInfo, paramPair));
    }
    Log.d(TAG, localAttachInfo.getAttachName() + " has sign file");
    return Observable.just(paramPair);
  }
  
  private void startSendMail(Account paramAccount, ComposeMailUI paramComposeMailUI, QMVerify paramQMVerify, int paramInt, BinaryFilesData paramBinaryFilesData, SendMailRequest paramSendMailRequest, Subscriber<? super QMNetworkRequest> paramSubscriber, SendMailFtnCallback paramSendMailFtnCallback, MailManagerDelegate paramMailManagerDelegate)
  {
    int i = paramAccount.getId();
    String str;
    if (paramComposeMailUI.getStatus().isGroupMail())
    {
      str = "groupmail_send";
      if ((paramBinaryFilesData.binayFiles.size() <= 0) || (!QMABTestManager.isSendMailByFtn())) {
        break label367;
      }
    }
    QMCallback localQMCallback;
    label367:
    for (boolean bool = true;; bool = false)
    {
      localQMCallback = new QMCallback();
      localQMCallback.setOnSendData(new SendMailManager.22(this, paramMailManagerDelegate, bool, paramBinaryFilesData));
      localQMCallback.setOnSuccess(new SendMailManager.23(this, paramMailManagerDelegate, i, paramComposeMailUI));
      localQMCallback.setOnError(new SendMailManager.24(this, paramSubscriber));
      localQMCallback.setOnComplete(new SendMailManager.25(this, paramSubscriber));
      paramMailManagerDelegate = SendMailHelper.getComposeInfoFromMail(paramComposeMailUI);
      paramQMVerify = SendMailHelper.getVerifyParams(paramQMVerify);
      paramAccount = paramQMVerify;
      try
      {
        paramQMVerify = paramQMVerify + "&detect=" + StringExtention.urlEncode(RsaEncryption.encrypt(VmDetectUtil.detect()));
        paramAccount = paramQMVerify;
        paramQMVerify = paramQMVerify + "&device=" + StringExtention.urlEncode(new StringBuilder().append(Build.BRAND).append("_").append(Build.MODEL).append("_").append(Build.VERSION.RELEASE).toString());
        paramAccount = paramQMVerify;
      }
      catch (Throwable paramQMVerify)
      {
        for (;;)
        {
          StringBuilder localStringBuilder;
          QMLog.log(5, TAG, "sendMailByCGI vm detect failed", paramQMVerify);
          continue;
          paramQMVerify = QMNetworkConfig.getCgiRequestHost(i);
        }
        paramQMVerify.setRequestCallback(localQMCallback);
        paramQMVerify.setFileParams(paramBinaryFilesData.binayFiles);
        paramAccount = paramAccount + "&type=binary&mailpath=" + paramComposeMailUI.getComposeCacheFilePath() + "&removefiles=" + paramBinaryFilesData.removeFiles;
        paramQMVerify.setRequestParams(SendMailHelper.getComposeSendParam(paramMailManagerDelegate, paramComposeMailUI) + paramAccount);
        paramSendMailRequest.getStep().set(7);
        NetworkManager.sharedInstance().sendRequest(paramQMVerify);
        QMLog.log(4, TAG, "sendMail hasBinaryAttach done");
        paramAccount = paramQMVerify;
      }
      if (paramBinaryFilesData.binayFiles.size() <= 0) {
        break label517;
      }
      QMLog.log(4, TAG, "sendMail hasBinaryAttach");
      localStringBuilder = new StringBuilder();
      if (!QMSettingManager.sharedInstance().isEnableHttpsDomain()) {
        break label388;
      }
      paramQMVerify = QMNetworkConfig.getCgiRequestHostHttps(i);
      paramQMVerify = new CGIRequest(i, paramQMVerify + "/cgi-bin/" + str, QMNetworkRequest.QMHttpMethod.QMHttpMethod_MULTIPART);
      if (!QMABTestManager.isSendMailByFtn()) {
        break label397;
      }
      sendMailByFtn(i, str, paramMailManagerDelegate, paramAccount, paramComposeMailUI, paramInt, paramSendMailRequest, paramBinaryFilesData, paramSendMailFtnCallback, localQMCallback).subscribe(new SendMailManager.26(this, paramSubscriber));
      return;
      str = "compose_send";
      break;
    }
    for (;;)
    {
      label388:
      label397:
      paramSubscriber.onNext(paramAccount);
      return;
      label517:
      QMLog.log(4, TAG, "sendMail has not BinaryAttach");
      paramSendMailRequest.getStep().set(7);
      paramAccount = CGIManager.httpPost(i, str, SendMailHelper.getComposeSendParam(paramMailManagerDelegate, paramComposeMailUI) + paramAccount, localQMCallback);
    }
  }
  
  private void throwOrReportNonNetworkErrorException(Throwable paramThrowable)
  {
    if ((paramThrowable != null) && (!(paramThrowable instanceof QMNetworkError))) {
      new ArrayList().add(paramThrowable);
    }
  }
  
  private void updateAfterSendMail(int paramInt, ComposeMailUI paramComposeMailUI, JSONObject paramJSONObject)
  {
    if (!StringUtils.isEmpty(paramComposeMailUI.getDraftId())) {}
    SQLiteDatabase localSQLiteDatabase;
    Long localLong2;
    for (int i = 1;; i = 0)
    {
      localSQLiteDatabase = this.sqliteHelper.getWritableDatabase();
      Long localLong1 = paramJSONObject.getLong("convupdate");
      localLong2 = paramJSONObject.getLong("update");
      Mail localMail = this.mailMgr.readMail(paramComposeMailUI.getOriginMailId(), false);
      paramJSONObject = localMail;
      if (localMail == null) {
        paramJSONObject = this.mailMgr.readSearchMail(paramComposeMailUI.getOriginMailId(), false);
      }
      if ((paramJSONObject == null) || (paramJSONObject.getInformation() == null)) {
        break label193;
      }
      if ((localLong1 == null) || (localLong1.longValue() != 1L)) {
        break label194;
      }
      paramJSONObject = this.sqliteHelper.mail.getConvMailParentIds(this.sqliteHelper.getReadableDatabase(), paramJSONObject.getInformation().getConvHash());
      if ((paramJSONObject == null) || (paramJSONObject.length <= 0)) {
        break;
      }
      paramInt = 0;
      while (paramInt < paramJSONObject.length)
      {
        paramComposeMailUI = this.mailMgr.readMailOrSearchMail(paramJSONObject[paramInt]);
        this.mailMgr.loadRemoteMail(paramComposeMailUI, 0);
        paramInt += 1;
      }
    }
    this.sqliteHelper.folder.setOverdue(localSQLiteDatabase, paramComposeMailUI.getOriginFolderId(), true);
    for (;;)
    {
      label193:
      return;
      label194:
      if (((localLong2 != null) && (localLong2.longValue() == 1L)) || (i != 0) || (paramComposeMailUI.isSaved()))
      {
        if ((paramComposeMailUI.isSaved()) && (i == 0))
        {
          this.sqliteHelper.folder.setOverdue(localSQLiteDatabase, this.folderMgr.getDraftFolderId(paramInt), true);
          return;
        }
        if ((paramComposeMailUI.getStatus().isGroupMail()) && ((paramComposeMailUI.getReplyId() == null) || (paramComposeMailUI.getReplyId().equals(""))))
        {
          this.sqliteHelper.folder.setOverdue(localSQLiteDatabase, this.folderMgr.getQQMailGroupFolderId(paramInt), true);
          return;
        }
        if ((i != 0) && (!paramComposeMailUI.isSaved())) {
          break;
        }
        if (paramJSONObject.getStatus().isGroupMail())
        {
          this.mailMgr.loadRemoteMail(paramJSONObject, 0);
          return;
        }
        paramComposeMailUI = this.sqliteHelper.mail.getConvMailParentIds(this.sqliteHelper.getReadableDatabase(), paramJSONObject.getInformation().getConvHash());
        if ((paramComposeMailUI == null) || (paramComposeMailUI.length <= 0)) {
          break;
        }
        paramInt = 0;
        while (paramInt < paramComposeMailUI.length)
        {
          this.mailMgr.loadRemoteMail(this.mailMgr.readMailOrSearchMail(paramComposeMailUI[paramInt]), 0);
          paramInt += 1;
        }
      }
    }
  }
  
  private Observable<FtnUploadInfo> uploadBigAttach(int paramInt, Pair<AttachInfo, FtnUploadInfo> paramPair, BytesWrittenRecord paramBytesWrittenRecord, SendMailFtnCallback paramSendMailFtnCallback, MailManagerDelegate paramMailManagerDelegate)
  {
    return Observable.create(new SendMailManager.21(this, paramPair, paramBytesWrittenRecord, paramMailManagerDelegate, paramInt, paramSendMailFtnCallback));
  }
  
  @NonNull
  private Observable<JSONObject> uploadNormalAttachByFtn(JSONObject paramJSONObject, long paramLong, BytesWrittenRecord paramBytesWrittenRecord, SendMailFtnCallback paramSendMailFtnCallback, QMCallback paramQMCallback)
  {
    return Observable.create(new SendMailManager.45(this, paramJSONObject, paramQMCallback, paramBytesWrittenRecord, paramLong, paramSendMailFtnCallback));
  }
  
  public SendMailRequest sendMail(Account paramAccount, ComposeMailUI paramComposeMailUI, QMVerify paramQMVerify, int paramInt, MailManagerDelegate paramMailManagerDelegate)
  {
    SendMailRequest localSendMailRequest = new SendMailRequest();
    if (paramComposeMailUI.hasAttach()) {
      TimReportManager.reportClickEvent(QMApplicationContext.sharedInstance(), "0X8008907", 0, 0, 0, 0, 0, "", "", "", "");
    }
    SendMailManager.1 local1 = new SendMailManager.1(this, localSendMailRequest);
    if (paramMailManagerDelegate != null) {
      paramMailManagerDelegate.handleBeforeSend(null);
    }
    localSendMailRequest.setRequeCallback(paramMailManagerDelegate);
    if (!paramAccount.isQQMail())
    {
      localSendMailRequest.setIsQQMail(false);
      sendMailByProtocol(paramAccount, paramComposeMailUI, paramInt, paramMailManagerDelegate, localSendMailRequest, local1);
      return localSendMailRequest;
    }
    localSendMailRequest.setIsQQMail(true);
    sendMailByCGI(paramAccount, paramComposeMailUI, paramQMVerify, paramInt, localSendMailRequest, local1, paramMailManagerDelegate).subscribe(new SendMailManager.2(this, localSendMailRequest));
    return localSendMailRequest;
  }
  
  public Observable<QMNetworkRequest> sendMailByCGI(Account paramAccount, ComposeMailUI paramComposeMailUI, QMVerify paramQMVerify, int paramInt, SendMailRequest paramSendMailRequest, SendMailFtnCallback paramSendMailFtnCallback, MailManagerDelegate paramMailManagerDelegate)
  {
    BinaryFilesData localBinaryFilesData = new BinaryFilesData();
    if ((SendMailHelper.calculateInlineImgs(paramComposeMailUI.getContent().getBody(), localBinaryFilesData.allInlineImgsPaths, localBinaryFilesData.allInlineImgsNames)) || (paramComposeMailUI.hasBinaryAttach()))
    {
      localBinaryFilesData.removeFiles = SendMailHelper.generateBinaryFiles(paramAccount, paramComposeMailUI, localBinaryFilesData.allInlineImgsPaths, localBinaryFilesData.allInlineImgsNames, localBinaryFilesData.binayFiles);
      localObject = localBinaryFilesData.bytesWrittenRecord;
      ((BytesWrittenRecord)localObject).totalBytes += getBinaryFilesTotalBytes(localBinaryFilesData.binayFiles);
    }
    Object localObject = paramSendMailRequest.getIsAbort();
    AtomicInteger localAtomicInteger = paramSendMailRequest.getStep();
    localAtomicInteger.set(2);
    StringBuilder localStringBuilder1 = new StringBuilder();
    boolean bool1;
    StringBuilder localStringBuilder2;
    AtomicBoolean localAtomicBoolean1;
    long l;
    if (localBinaryFilesData.binayFiles.size() > 0)
    {
      bool1 = true;
      localStringBuilder1.append(localBinaryFilesData.binayFiles.size()).append(";").append(localBinaryFilesData.bytesWrittenRecord.totalBytes);
      localStringBuilder2 = new StringBuilder();
      localAtomicBoolean1 = new AtomicBoolean(true);
      l = System.currentTimeMillis();
      if (QMNetworkUtils.isNetworkConnected()) {
        break label353;
      }
    }
    label353:
    for (boolean bool2 = true;; bool2 = false)
    {
      AtomicBoolean localAtomicBoolean2 = new AtomicBoolean(bool2);
      SendMailManager.6 local6 = new SendMailManager.6(this, localAtomicBoolean2);
      QMNetworkHandler.getInstance().registerNetworkListener(local6);
      return normalAttach2BigAttach(paramComposeMailUI, paramInt, (AtomicBoolean)localObject, localBinaryFilesData, paramSendMailFtnCallback, paramMailManagerDelegate).flatMap(new SendMailManager.10(this, (AtomicBoolean)localObject)).flatMap(new SendMailManager.9(this, localAtomicInteger, paramAccount, paramComposeMailUI, paramQMVerify, paramInt, localBinaryFilesData, paramSendMailRequest, paramSendMailFtnCallback, paramMailManagerDelegate)).onErrorResumeNext(new SendMailManager.8(this, localAtomicBoolean1, (AtomicBoolean)localObject, localStringBuilder2, paramMailManagerDelegate)).doOnCompleted(new SendMailManager.7(this, paramSendMailRequest, bool1, localAtomicBoolean1, l, localAtomicBoolean2, localStringBuilder2, localStringBuilder1, (AtomicBoolean)localObject, localAtomicInteger, paramMailManagerDelegate, local6)).subscribeOn(QMSchedulers.network());
      bool1 = false;
      break;
    }
  }
  
  public class BinaryFilesData
  {
    public ArrayList<String> allInlineImgsNames = new ArrayList();
    public ArrayList<String> allInlineImgsPaths = new ArrayList();
    public List<QMFileEntity> binayFiles = new ArrayList();
    public SendMailManager.BytesWrittenRecord bytesWrittenRecord = new SendMailManager.BytesWrittenRecord(SendMailManager.this, null);
    public String removeFiles = "";
    
    public BinaryFilesData() {}
    
    public long getBytesAttachNeedFtnUpload()
    {
      return this.bytesWrittenRecord.bytesAttachNeedFtnUpload;
    }
    
    public long getBytesWritten()
    {
      return this.bytesWrittenRecord.getBytesWritten();
    }
    
    public long getTotalBytes()
    {
      return this.bytesWrittenRecord.totalBytes;
    }
    
    public void setTotalBytes(long paramLong)
    {
      this.bytesWrittenRecord.totalBytes = paramLong;
    }
  }
  
  class BytesWrittenRecord
  {
    public long bytesAttachNeedFtnUpload = 0L;
    public final Map<String, Long> bytesWrittenByFilePathMap = new ConcurrentHashMap();
    public long totalBytes = 0L;
    
    private BytesWrittenRecord() {}
    
    public long getBytesWritten()
    {
      Iterator localIterator = this.bytesWrittenByFilePathMap.keySet().iterator();
      String str;
      for (long l = 0L; localIterator.hasNext(); l = ((Long)this.bytesWrittenByFilePathMap.get(str)).longValue() + l) {
        str = (String)localIterator.next();
      }
      return l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager
 * JD-Core Version:    0.7.0.1
 */