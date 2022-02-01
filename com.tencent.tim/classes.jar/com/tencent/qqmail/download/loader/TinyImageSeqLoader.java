package com.tencent.qqmail.download.loader;

import com.alibaba.fastjson.JSONObject;
import com.tencent.moai.downloader.listener.DownloadTaskListener;
import com.tencent.qqmail.activity.media.ImagePagerAdapter;
import com.tencent.qqmail.activity.media.MediaItemInfo;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.download.AttachDownloadManager;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.download.util.DownloadUtil;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.CGIManager;
import com.tencent.qqmail.utilities.qmnetwork.CGIRequest;
import com.tencent.qqmail.utilities.qmnetwork.NetworkManager;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkConfig;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;

public class TinyImageSeqLoader
{
  public static final int DOWN_ERROR_FTN = -1;
  public static final int DOWN_ERROR_NOPERMISSION = -3;
  public static final int DOWN_ERROR_NORMAL = -2;
  public static final int DOWN_SUCCESS = 0;
  private int mAccountId;
  private int mFailCount = 0;
  private HashMap<String, String> mFtnCookies = new HashMap();
  private HashMap<String, JSONObject> mFtnDatas = new HashMap();
  private ImagePagerAdapter mImagePagerAdapter = null;
  private Queue<MediaItemInfo> mImageQueue = new LinkedList();
  private boolean mIsDownloadBegin = false;
  private Listener mListener = null;
  private HashMap<String, String> mLoadFileNameCache = new HashMap();
  private HashMap<String, String> mLoadKeyCache = new HashMap();
  private DownloadTaskListener mProtocolListener = null;
  private String mSaveAsPath = "";
  private int mSuccCount = 0;
  private int mTotalCount = 0;
  
  public TinyImageSeqLoader(int paramInt, String paramString, List<MediaItemInfo> paramList, Listener paramListener, ImagePagerAdapter paramImagePagerAdapter)
  {
    this.mAccountId = paramInt;
    paramInt = i;
    while (paramInt < paramList.size())
    {
      this.mImageQueue.add(paramList.get(paramInt));
      paramInt += 1;
    }
    this.mSaveAsPath = paramString;
    this.mImagePagerAdapter = paramImagePagerAdapter;
    if (this.mImageQueue != null) {
      this.mTotalCount = this.mImageQueue.size();
    }
    this.mListener = paramListener;
  }
  
  private void doLoadImage(int paramInt1, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, ArrayList<Cookie> paramArrayList, int paramInt2)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.setAccountId(paramInt1);
    localDownloadInfo.setAttachId(paramLong1);
    localDownloadInfo.setMailId(paramLong2);
    localDownloadInfo.setUrl(paramString1);
    localDownloadInfo.setKey(paramString1);
    localDownloadInfo.setAttachId(paramLong1);
    localDownloadInfo.setFileName(paramString2);
    localDownloadInfo.setFilePath(paramString3);
    localDownloadInfo.setSaveAsPath(this.mSaveAsPath);
    localDownloadInfo.setCookies(paramArrayList);
    localDownloadInfo.setIsNotify(false);
    localDownloadInfo.setDownloadType(1);
    localDownloadInfo.setAttachType(paramInt2);
    localDownloadInfo.setAttachDownloadListener(new TinyImageSeqLoader.1(this, paramLong1, paramInt1));
    AttachDownloadManager.shareInstance().fetchAttach(localDownloadInfo);
  }
  
  private void getFtnInfoFromCgi(String paramString1, String paramString2, MediaItemInfo paramMediaItemInfo)
  {
    String str1 = paramMediaItemInfo.getFileName();
    String str2 = StringExtention.removeTokenFromUrl(StringExtention.parseUrlParam(paramString2), "t=");
    Object localObject = StringExtention.appendString(str2, "&t=ftnExs_Key&from=mobile");
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new TinyImageSeqLoader.2(this, paramString1, paramString2, paramMediaItemInfo));
    localQMCallback.setOnError(new TinyImageSeqLoader.3(this, str1));
    localObject = QMNetworkConfig.getCgiRequestHost(this.mAccountId) + "/cgi-bin/" + (String)localObject;
    localObject = new CGIRequest(this.mAccountId, (String)localObject);
    ((QMNetworkRequest)localObject).setRequestCallback(localQMCallback);
    ((QMNetworkRequest)localObject).setSuggestParseResponseToJson(false);
    NetworkManager.sharedInstance().sendRequest((QMNetworkRequest)localObject);
    str2 = StringExtention.appendString(str2, "&t=ftnExs_download.json&from=mobile");
    localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new TinyImageSeqLoader.4(this, paramString1, paramString2, paramMediaItemInfo));
    localQMCallback.setOnError(new TinyImageSeqLoader.5(this, str1));
    CGIManager.httpGet(this.mAccountId, str2, null, localQMCallback);
  }
  
  private void getInfoFromCgiDone(String paramString1, String paramString2, MediaItemInfo paramMediaItemInfo)
  {
    String str1;
    String str2;
    if ((this.mFtnCookies.containsKey(paramString1)) && (this.mFtnDatas.containsKey(paramString1)))
    {
      str1 = paramMediaItemInfo.getFileName();
      str2 = (String)((JSONObject)this.mFtnDatas.get(paramString1)).get("errcode");
      if (str2.equals("0")) {
        Threads.runOnMainThread(new TinyImageSeqLoader.6(this, paramString1, paramString2, str1, paramMediaItemInfo));
      }
    }
    else
    {
      return;
    }
    paramString1 = (MailBigAttach)paramMediaItemInfo.getAttach();
    if (str2.equals("-6"))
    {
      QMAttachManager.sharedInstance().updateBigAttachExpire(paramString1.getHashId(), -2L);
      QMNotification.postNotification("ftnfailexpired", QMNotification.createNotification(new Object[] { "ftnfailexpired", Long.valueOf(paramString1.getHashId()) }));
    }
    for (;;)
    {
      Threads.runOnMainThread(new TinyImageSeqLoader.7(this, str1));
      return;
      if (str2.equals("-102")) {
        QMNotification.postNotification("ftn_fail_exceed_limit", QMNotification.createNotification(new Object[] { "ftn_fail_exceed_limit", Long.valueOf(paramString1.getHashId()) }));
      } else {
        QMNotification.postNotification("ftn_fail_get_information", QMNotification.createNotification(new Object[] { "ftn_fail_get_information", Long.valueOf(paramString1.getHashId()) }));
      }
    }
  }
  
  private void handleFtnSuccess(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    if ((!this.mFtnDatas.containsKey(paramString1)) || (!this.mFtnCookies.containsKey(paramString1))) {
      return;
    }
    Object localObject = (String)this.mFtnCookies.get(paramString1);
    paramString1 = (String)((JSONObject)this.mFtnDatas.get(paramString1)).get("fileurl");
    localObject = new BasicClientCookie("qm_ftn_key", (String)localObject);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    if (!this.mLoadKeyCache.containsKey(paramString1)) {
      this.mLoadKeyCache.put(paramString1, paramString2);
    }
    if (!this.mLoadFileNameCache.containsKey(paramString1)) {
      this.mLoadFileNameCache.put(paramString1, paramString3);
    }
    doLoadImage(this.mAccountId, paramLong, 0L, paramString1, paramString3, "", localArrayList, 1);
  }
  
  private boolean isAttachDownload(Attach paramAttach)
  {
    paramAttach = paramAttach.getPreview().getMyDisk();
    if ((paramAttach != null) && (!paramAttach.equals(""))) {
      return new File(paramAttach).exists();
    }
    return false;
  }
  
  private boolean isImageLoad(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (!paramString.equals(""))
      {
        paramString = new File(paramString);
        bool1 = bool2;
        if (paramString != null) {
          bool1 = paramString.exists();
        }
      }
    }
    return bool1;
  }
  
  public void handleDownError(String paramString1, String paramString2, int paramInt)
  {
    this.mFailCount += 1;
    Listener localListener = this.mListener;
    int i = this.mSuccCount;
    localListener.onChangeNext(paramString1, this.mFailCount + i, paramString2, this.mSuccCount, this.mFailCount, false);
    load(this.mSaveAsPath + File.separator + paramString2, paramInt);
  }
  
  public void handleDownSuccess(String paramString1, long paramLong, String paramString2)
  {
    if (!StringExtention.isNullOrEmpty(paramString2)) {
      this.mSuccCount += 1;
    }
    for (int i = 0;; i = -2)
    {
      File localFile = new File(paramString2);
      this.mListener.onChangeNext(paramString1, this.mSuccCount + this.mFailCount, localFile.getName(), this.mSuccCount, this.mFailCount, true);
      load(paramString2, i);
      return;
      this.mFailCount += 1;
    }
  }
  
  public void load(String paramString, int paramInt)
  {
    if (this.mImageQueue == null) {}
    MediaItemInfo localMediaItemInfo;
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            return;
            if (!this.mIsDownloadBegin)
            {
              this.mIsDownloadBegin = true;
              this.mListener.onBefore();
            }
            if ((this.mSuccCount == 0) && (this.mFailCount == 0)) {
              this.mListener.onBefore();
            }
            if (this.mSuccCount + this.mFailCount >= this.mTotalCount)
            {
              this.mListener.onComplete(paramString, this.mSuccCount, this.mFailCount, this.mTotalCount, paramInt);
              this.mIsDownloadBegin = false;
              return;
            }
            localMediaItemInfo = (MediaItemInfo)this.mImageQueue.poll();
          } while (localMediaItemInfo == null);
          if (localMediaItemInfo.getAttach() != null)
          {
            localObject = localMediaItemInfo.getAttach().getHashId() + "";
            if ((this.mImagePagerAdapter != null) && (this.mImagePagerAdapter.isProtocolDownCached((String)localObject)) && (!isAttachDownload(localMediaItemInfo.getAttach())))
            {
              load(paramString + File.separator + localMediaItemInfo.getAttach().getName(), paramInt);
              return;
            }
          }
          paramString = localMediaItemInfo.getDataPath();
          localObject = AttachDownloadManager.shareInstance().getAttachFromLocal(localMediaItemInfo.getSourcePath());
          if ((localObject != null) && (((File)localObject).exists()))
          {
            DownloadUtil.existFileSaveAs(localMediaItemInfo.getAttach(), this.mSaveAsPath, false);
            handleDownSuccess(paramString, localMediaItemInfo.getAttach().getHashId(), this.mSaveAsPath);
            return;
          }
          if (localMediaItemInfo.getImageType() != 2) {
            break;
          }
        } while ((this.mImagePagerAdapter != null) && (this.mImagePagerAdapter.isQQMailDownCached(paramString)) && (!isImageLoad(localMediaItemInfo.getSourcePath())));
        if (!this.mLoadKeyCache.containsKey(paramString)) {
          this.mLoadKeyCache.put(paramString, paramString);
        }
        if (!this.mLoadFileNameCache.containsKey(paramString)) {
          this.mLoadFileNameCache.put(paramString, localMediaItemInfo.getFileName());
        }
        doLoadImage(localMediaItemInfo.getAccountId(), localMediaItemInfo.getAttach().getHashId(), localMediaItemInfo.getMailId(), paramString, localMediaItemInfo.getFileName(), localMediaItemInfo.getSourcePath(), null, 0);
        return;
        if (localMediaItemInfo.getImageType() != 3) {
          break;
        }
        localObject = StringExtention.hashKeyForDisk(paramString);
      } while ((this.mImagePagerAdapter != null) && (this.mImagePagerAdapter.isQQMailDownCached(paramString)));
      getFtnInfoFromCgi((String)localObject, paramString, localMediaItemInfo);
      return;
    } while (localMediaItemInfo.getImageType() != 4);
    doLoadImage(localMediaItemInfo.getAccountId(), localMediaItemInfo.getAttach().getHashId(), localMediaItemInfo.getMailId(), localMediaItemInfo.getAttach().getHashId() + "", localMediaItemInfo.getFileName(), localMediaItemInfo.getSourcePath(), null, 3);
  }
  
  public static abstract interface Listener
  {
    public abstract void onBefore();
    
    public abstract void onChangeNext(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean);
    
    public abstract void onComplete(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.loader.TinyImageSeqLoader
 * JD-Core Version:    0.7.0.1
 */