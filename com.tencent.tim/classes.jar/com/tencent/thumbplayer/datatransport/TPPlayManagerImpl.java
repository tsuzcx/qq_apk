package com.tencent.thumbplayer.datatransport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.thumbplayer.adapter.player.TPUrlDataSource;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamLong;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPCDNURLInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPProtocolInfo;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxyListener;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.composition.TPMediaComposition;
import com.tencent.thumbplayer.composition.TPMediaCompositionTrackClip;
import com.tencent.thumbplayer.composition.TPMediaDRMAsset;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.utils.TPCommonUtils;
import com.tencent.thumbplayer.utils.TPFutureResult;
import com.tencent.thumbplayer.utils.TPGlobalEventNofication;
import com.tencent.thumbplayer.utils.TPGlobalEventNofication.OnGlobalEventChangeListener;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.TPNetworkChangeMonitor;
import com.tencent.thumbplayer.utils.TPNetworkChangeMonitor.OnNetStatusChangeListener;
import com.tencent.thumbplayer.utils.TPReadWriteLock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import org.json.JSONObject;

public class TPPlayManagerImpl
  implements ITPPlayManager, TPGlobalEventNofication.OnGlobalEventChangeListener, TPNetworkChangeMonitor.OnNetStatusChangeListener
{
  private static final int API_CALL_TIME_OUT_MS = 500;
  private static final int LOD_P2P_TIMES = 3;
  private static final int MSG_DOWN_LOAD_CDN_INFO_UPDATE = 4100;
  private static final int MSG_DOWN_LOAD_CDN_URL_EXPERIED = 4103;
  private static final int MSG_DOWN_LOAD_CDN_URL_UPDATE = 4099;
  private static final int MSG_DOWN_LOAD_ERROR = 4098;
  private static final int MSG_DOWN_LOAD_FINISH = 4097;
  private static final int MSG_DOWN_LOAD_LONG_GET_PLAY_INFO = 4105;
  private static final int MSG_DOWN_LOAD_PLAY_BACK = 4104;
  private static final int MSG_DOWN_LOAD_PROGRESS_UPDARE = 4106;
  private static final int MSG_DOWN_LOAD_PROTOCOL_UPDATE = 4102;
  private static final int MSG_DOWN_LOAD_STATUS_UPDATE = 4101;
  private static final int MSG_DOWN_LOAD_STRING_GET_PLAY_INFO = 4107;
  private static final int MSG_INDEX = 4096;
  private static final int MSG_PROXY_CANCEL_READ_DATA = 4109;
  private static final int MSG_PROXY_GET_CONTENT_TYPE = 4112;
  private static final int MSG_PROXY_GET_DATA_FILE_PATH = 4111;
  private static final int MSG_PROXY_GET_DATA_TOTAL_SIZE = 4110;
  private static final int MSG_PROXY_START_READ_DATA = 4108;
  private static final String TAG = "TPThumbPlayer[TPPlayManagerImpl.java]";
  private static int TYPE_NOT_INIT = -1;
  private boolean loadProxySucc = false;
  private Context mContext;
  private ArrayList<TPDownloadParamData> mDownloadPramList;
  private ITPDownloadProxy mDownloadProxy;
  private String mFileID;
  private EventHandler mHandler;
  private InnerProxyListener mInnerProxyListener;
  private boolean mIsActive = true;
  private boolean mIsDemuxer = false;
  private boolean mIsUseResourceLoader = false;
  private TPReadWriteLock mLock;
  private String mOriginUrl;
  private LinkedList<TPDefTaskModel> mPendingDefTaskQueue;
  private int mPlayID = -1;
  private ITPPlayListener mPlayListener;
  private ITPPlayerProxyListener mPlayerProxyListener = null;
  private int mServiceType = TYPE_NOT_INIT;
  private long mSkipEndTimeMs;
  private long mStartTimeMs;
  private HashMap<String, Integer> mTrackProxyUrlPlayIdMap;
  private TPVideoInfo mVideoInfo;
  private int tryLoadP2pTimes = 3;
  
  public TPPlayManagerImpl(Context paramContext, Looper paramLooper)
  {
    this.mContext = paramContext;
    this.mHandler = new EventHandler(paramLooper);
    TPGlobalEventNofication.addEventListener(this);
    TPNetworkChangeMonitor.getInstance().addOnNetStatusChangeListener(this);
    this.mInnerProxyListener = new InnerProxyListener(null);
    this.mPlayListener = new TPPlayProxyListenerEmptyImpl("TPThumbPlayer[TPPlayManagerImpl.java]");
    this.mTrackProxyUrlPlayIdMap = new HashMap();
    this.mDownloadPramList = new ArrayList();
    this.mLock = new TPReadWriteLock();
  }
  
  private boolean addAudioTrack(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString1);
    paramString1 = new HashMap();
    paramString1.put("dl_param_data_transfer_mode", Integer.valueOf(1));
    paramString1 = new TPDownloadParam(localArrayList, 3, paramString1);
    return this.mDownloadProxy.setClipInfo(this.mPlayID, 2, paramString2, paramString1);
  }
  
  private TPDownloadParam convertDownloadParam(String paramString, TPDownloadParamData paramTPDownloadParamData, Map<String, String> paramMap)
  {
    return TPProxyUtils.convertProxyDownloadParams(paramString, paramTPDownloadParamData, paramMap);
  }
  
  private List<ITPMediaTrackClip> getAssetClips(ITPMediaAsset paramITPMediaAsset)
  {
    if ((paramITPMediaAsset instanceof TPMediaComposition))
    {
      paramITPMediaAsset = ((TPMediaComposition)paramITPMediaAsset).getAllAVTracks();
      if (!TPCommonUtils.isEmpty(paramITPMediaAsset))
      {
        paramITPMediaAsset = (ITPMediaTrack)paramITPMediaAsset.get(0);
        if ((paramITPMediaAsset != null) && (!TPCommonUtils.isEmpty(paramITPMediaAsset.getAllTrackClips()))) {
          return paramITPMediaAsset.getAllTrackClips();
        }
      }
    }
    else if ((paramITPMediaAsset instanceof ITPMediaTrack))
    {
      paramITPMediaAsset = (ITPMediaTrack)paramITPMediaAsset;
      if (!TPCommonUtils.isEmpty(paramITPMediaAsset.getAllTrackClips())) {
        return paramITPMediaAsset.getAllTrackClips();
      }
    }
    else if ((paramITPMediaAsset instanceof ITPMediaTrackClip))
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add((ITPMediaTrackClip)paramITPMediaAsset);
      return localArrayList;
    }
    return null;
  }
  
  private TPDownloadParamData getDownloadParamDataWithIndex(ArrayList<TPDownloadParamData> paramArrayList, int paramInt)
  {
    if ((TPCommonUtils.isEmpty(paramArrayList)) || (paramInt >= paramArrayList.size())) {
      return null;
    }
    return (TPDownloadParamData)paramArrayList.get(paramInt);
  }
  
  private String getFileId()
  {
    return this.mFileID;
  }
  
  private Object getFutureResult(TPFutureResult paramTPFutureResult)
  {
    try
    {
      paramTPFutureResult = paramTPFutureResult.getResult(500L);
      return paramTPFutureResult;
    }
    catch (Throwable paramTPFutureResult)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "onPlayCallback getResult has exception:" + paramTPFutureResult.toString());
    }
    return null;
  }
  
  private String getHttpValue(String paramString)
  {
    if (paramString == null) {}
    do
    {
      int i;
      do
      {
        return null;
        i = paramString.indexOf(':');
      } while ((i < 0) || (i + 1 >= paramString.length()));
      paramString = paramString.substring(i + 1);
    } while (paramString == null);
    return paramString.trim();
  }
  
  private void handleIsActive()
  {
    try
    {
      ITPDownloadProxy localITPDownloadProxy = this.mDownloadProxy;
      int j = this.mPlayID;
      if (this.mIsActive) {}
      for (int i = 101;; i = 100)
      {
        localITPDownloadProxy.setPlayState(j, i);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable);
    }
  }
  
  private void initProxy()
  {
    if (this.loadProxySucc) {}
    while (this.tryLoadP2pTimes <= 0) {
      return;
    }
    try
    {
      if (this.mServiceType == TYPE_NOT_INIT) {
        this.mServiceType = TPPlayerConfig.getProxyServiceType();
      }
      ITPProxyManagerAdapter localITPProxyManagerAdapter = TPProxyGlobalManager.getInstance().getPlayerProxy(this.mServiceType);
      if ((localITPProxyManagerAdapter != null) && (localITPProxyManagerAdapter.getDownloadProxy() != null))
      {
        this.mDownloadProxy = localITPProxyManagerAdapter.getDownloadProxy();
        this.mDownloadProxy.setUserData("qq_is_vip", Boolean.valueOf(TPPlayerConfig.isUserIsVip()));
        if (!TextUtils.isEmpty(TPPlayerConfig.getUserUin())) {
          this.mDownloadProxy.setUserData("user_uin", TPPlayerConfig.getUserUin());
        }
        if (!TextUtils.isEmpty(TPPlayerConfig.getAppVersionName(this.mContext))) {
          this.mDownloadProxy.setUserData("app_version_name", TPPlayerConfig.getAppVersionName(this.mContext));
        }
        if (TPPlayerConfig.getBuildNumber(this.mContext) != -1L) {
          this.mDownloadProxy.setUserData("app_version_code", String.valueOf(TPPlayerConfig.getBuildNumber(this.mContext)));
        }
        this.mDownloadProxy.setUserData("carrier_pesudo_code", TPPlayerConfig.getUserUpc());
        this.mDownloadProxy.setUserData("carrier_pesudo_state", Integer.valueOf(TPPlayerConfig.getUserUpcState()));
        this.mDownloadProxy.setUserData("external_network_ip", TPPlayerConfig.getOutNetIp());
        this.mDownloadProxy.setUserData("max_use_memory", Integer.valueOf(TPPlayerConfig.getProxyMaxUseMemoryMB()));
        this.loadProxySucc = true;
        return;
      }
    }
    catch (Exception localException)
    {
      this.tryLoadP2pTimes -= 1;
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localException);
      return;
    }
    this.tryLoadP2pTimes -= 1;
    TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p so load failed");
  }
  
  private void internalMessage(int paramInt1, int paramInt2, int paramInt3, Object paramObject, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    this.mLock.readLock().lock();
    if (this.mHandler == null)
    {
      TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", messageToCommand(paramInt1) + " , send failed , handler null");
      this.mLock.readLock().unlock();
      return;
    }
    if ((paramBoolean1) && (paramObject == null))
    {
      TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", messageToCommand(paramInt1) + ", send failed , params null");
      this.mLock.readLock().unlock();
      return;
    }
    if (paramBoolean2) {
      this.mHandler.removeMessages(paramInt1);
    }
    Message localMessage = this.mHandler.obtainMessage();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    localMessage.obj = paramObject;
    this.mHandler.sendMessageDelayed(localMessage, paramLong);
    this.mLock.readLock().unlock();
  }
  
  private void internalMessage(int paramInt, Object paramObject)
  {
    internalMessage(paramInt, 0, 0, paramObject, false, false, 0L);
  }
  
  private boolean isInitDownloadProxyFailed()
  {
    return isInitDownloadProxyFailed(false);
  }
  
  private boolean isInitDownloadProxyFailed(boolean paramBoolean)
  {
    if (!TPPlayerConfig.isUseP2P()) {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "config set don't use p2p proxy!");
    }
    do
    {
      return true;
      if (paramBoolean) {
        this.tryLoadP2pTimes = 3;
      }
      initProxy();
    } while (!this.loadProxySucc);
    return false;
  }
  
  private boolean isQQVideoExpired(String paramString)
  {
    if (paramString != null) {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("httpHeader"))
        {
          paramString = paramString.getString("httpHeader");
          Object localObject = null;
          if (!TextUtils.isEmpty(paramString))
          {
            String[] arrayOfString = paramString.split("\r\n");
            if (arrayOfString != null)
            {
              int i = 1;
              for (;;)
              {
                paramString = localObject;
                if (i < arrayOfString.length)
                {
                  paramString = arrayOfString[i];
                  if (paramString.startsWith("User-ReturnCode")) {
                    paramString = getHttpValue(paramString);
                  }
                }
                else
                {
                  if (TextUtils.isEmpty(paramString)) {
                    break;
                  }
                  if (!paramString.equals("-5103059"))
                  {
                    boolean bool = paramString.equals("-5103017");
                    if (!bool) {
                      break;
                    }
                  }
                  return true;
                }
                i += 1;
              }
            }
          }
        }
        return false;
      }
      catch (Exception paramString) {}
    }
  }
  
  private String messageToCommand(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknown";
    case 4106: 
      return "onDownloadProgressUpdate";
    case 4097: 
      return "onDownloadFinish";
    case 4098: 
      return "onDownloadError";
    case 4099: 
      return "onDownloadCdnUrlUpdate";
    case 4100: 
      return "onDownloadCdnUrlInfoUpdate";
    case 4101: 
      return "onDownloadStatusUpdate";
    case 4102: 
      return "onDownloadProtocolUpdate";
    case 4103: 
      return "onDownloadCdnUrlExpired";
    case 4104: 
      return "onPlayCallback";
    }
    return "getPlayInfo";
  }
  
  private void pauseDownload(int paramInt)
  {
    if (isInitDownloadProxyFailed()) {
      return;
    }
    try
    {
      this.mDownloadProxy.pauseDownload(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy pause download failed, taskId:" + paramInt);
    }
  }
  
  private void releaseHandler()
  {
    TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "inner event : release handler");
    this.mLock.writeLock().lock();
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler = null;
    }
    this.mLock.writeLock().unlock();
  }
  
  private void reset()
  {
    TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "reset");
    this.mFileID = "";
    this.mOriginUrl = "";
    this.mVideoInfo = null;
    this.mStartTimeMs = 0L;
    this.mSkipEndTimeMs = 0L;
    this.mIsDemuxer = false;
    this.mIsActive = true;
    if (!TPCommonUtils.isEmpty(this.mDownloadPramList)) {
      this.mDownloadPramList.clear();
    }
  }
  
  private void resumeDownload(int paramInt)
  {
    if (isInitDownloadProxyFailed()) {
      return;
    }
    try
    {
      this.mDownloadProxy.resumeDownload(this.mPlayID);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy resume download failed, taskId:" + paramInt);
    }
  }
  
  private void setPlayUserData()
  {
    this.mDownloadProxy.setUserData("dl_param_play_start_time", Long.valueOf(this.mStartTimeMs));
    this.mDownloadProxy.setUserData("dl_param_play_end_time", Long.valueOf(this.mSkipEndTimeMs));
  }
  
  private int startClipPlay(List<ITPMediaTrackClip> paramList, String paramString, ArrayList<TPDownloadParamData> paramArrayList)
  {
    if (TPCommonUtils.isEmpty(paramList))
    {
      TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "clipList is empty, return");
      return -1;
    }
    int k = paramList.size();
    Object localObject1 = new HashMap();
    int j = 0;
    int i = 1;
    Object localObject2;
    if (j < k)
    {
      localObject2 = (ITPMediaTrackClip)paramList.get(j);
      if ((!(localObject2 instanceof TPMediaCompositionTrackClip)) || (!TPCommonUtils.isUrl(((TPMediaCompositionTrackClip)localObject2).getFilePath()))) {
        break label427;
      }
      ((HashMap)localObject1).put(localObject2, new TPDownloadSeqAndClipIndexMapping(i, j));
      i += 1;
    }
    label427:
    for (;;)
    {
      j += 1;
      break;
      if (TPCommonUtils.isEmpty((Map)localObject1))
      {
        TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "all urls is local file url, return");
        return -1;
      }
      i = this.mDownloadProxy.startClipPlay(paramString, ((HashMap)localObject1).size(), this.mInnerProxyListener);
      if (i > 0)
      {
        paramList = ((HashMap)localObject1).entrySet().iterator();
        while (paramList.hasNext())
        {
          paramString = (Map.Entry)paramList.next();
          localObject1 = (ITPMediaTrackClip)paramString.getKey();
          paramString = (TPDownloadSeqAndClipIndexMapping)paramString.getValue();
          if ((localObject1 instanceof TPMediaCompositionTrackClip))
          {
            localObject1 = (TPMediaCompositionTrackClip)localObject1;
            Object localObject3 = getDownloadParamDataWithIndex(paramArrayList, paramString.clipIndex);
            if (localObject3 == null)
            {
              TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "fatal err, paramData is null.");
              return -1;
            }
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "multi trackClipIndex:" + paramString.clipIndex + ", download seq:" + paramString.downloadSeq + ", clip.url:" + ((TPMediaCompositionTrackClip)localObject1).getUrl() + ", clip.getFilePath:" + ((TPMediaCompositionTrackClip)localObject1).getFilePath() + ", paramData.savePath:" + ((TPDownloadParamData)localObject3).getSavePath() + ", paramData.DownloadFileID:" + ((TPDownloadParamData)localObject3).getDownloadFileID());
            localObject2 = ((TPDownloadParamData)localObject3).getDownloadFileID();
            localObject3 = convertDownloadParam(((TPMediaCompositionTrackClip)localObject1).getFilePath(), (TPDownloadParamData)localObject3, null);
            if (this.mDownloadProxy.setClipInfo(i, paramString.downloadSeq, (String)localObject2, (TPDownloadParam)localObject3)) {
              ((TPMediaCompositionTrackClip)localObject1).setFilePath(this.mDownloadProxy.getClipPlayUrl(i, paramString.downloadSeq, 1));
            }
          }
        }
      }
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start clip play failed, cause : playId < 0");
      return i;
    }
  }
  
  private TPUrlDataSource startSwitchDefTask(long paramLong, String paramString, TPDownloadParamData paramTPDownloadParamData, Map<String, String> paramMap)
  {
    String str = null;
    TPUrlDataSource localTPUrlDataSource = new TPUrlDataSource(paramString);
    if (!TPCommonUtils.isUrl(paramString)) {
      return localTPUrlDataSource;
    }
    if (isInitDownloadProxyFailed()) {
      return localTPUrlDataSource;
    }
    if (this.mPendingDefTaskQueue == null) {
      this.mPendingDefTaskQueue = new LinkedList();
    }
    if (paramTPDownloadParamData != null) {}
    for (paramMap = convertDownloadParam(paramString, paramTPDownloadParamData, paramMap);; paramMap = null)
    {
      if (paramTPDownloadParamData != null) {}
      try
      {
        str = paramTPDownloadParamData.getDownloadFileID();
        i = this.mDownloadProxy.startPlay(str, paramMap, this.mInnerProxyListener);
        if (i <= 0) {
          break label224;
        }
        paramMap = this.mDownloadProxy.getPlayUrl(i, 1);
        paramTPDownloadParamData = paramMap;
        if (TextUtils.isEmpty(paramMap)) {
          paramTPDownloadParamData = paramString;
        }
        localTPUrlDataSource.setSelfPlayerUrl(paramTPDownloadParamData);
        paramTPDownloadParamData = this.mDownloadProxy.getPlayUrl(i, 0);
        if (!TextUtils.isEmpty(paramTPDownloadParamData)) {
          continue;
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          int i;
          TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", paramString, "p2p proxy switch def failed");
          continue;
          paramString = paramTPDownloadParamData;
        }
      }
      localTPUrlDataSource.setSystemPlayerUrl(paramString);
      this.mPendingDefTaskQueue.offer(new TPDefTaskModel(paramLong, i));
      TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def sucess, defId:" + paramLong + ",playId:" + i);
      return localTPUrlDataSource;
      label224:
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def failed, cause : playId < 0");
      return localTPUrlDataSource;
    }
  }
  
  private void stopDownload(int paramInt)
  {
    if (isInitDownloadProxyFailed()) {
      return;
    }
    try
    {
      this.mDownloadProxy.stopPlay(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy stop play failed, taskID:" + paramInt);
    }
  }
  
  private void updateVideoInfo(TPVideoInfo paramTPVideoInfo)
  {
    if (isInitDownloadProxyFailed()) {}
    for (;;)
    {
      return;
      this.mVideoInfo = paramTPVideoInfo;
      if ((paramTPVideoInfo == null) || (paramTPVideoInfo.getDownloadPraramList() == null))
      {
        TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "video or downloadParamList is null, return");
        return;
      }
      if (this.mPlayID <= 0)
      {
        TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy not start, return");
        return;
      }
      paramTPVideoInfo = paramTPVideoInfo.getDownloadPraramList();
      int i = 0;
      while (i < paramTPVideoInfo.size())
      {
        TPDownloadParamData localTPDownloadParamData = (TPDownloadParamData)paramTPVideoInfo.get(i);
        TPDownloadParam localTPDownloadParam = convertDownloadParam(localTPDownloadParamData.getUrl(), localTPDownloadParamData, null);
        if (!this.mDownloadProxy.setClipInfo(this.mPlayID, localTPDownloadParamData.getClipNo(), localTPDownloadParamData.getDownloadFileID(), localTPDownloadParam)) {
          TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "setClipInfo failed, playID:" + this.mPlayID + ", clipNo:" + localTPDownloadParamData.getClipNo() + ", downloadFileID:" + localTPDownloadParamData.getDownloadFileID());
        }
        i += 1;
      }
    }
  }
  
  public String getPlayErrorCodeStr()
  {
    if (isInitDownloadProxyFailed()) {
      return null;
    }
    try
    {
      String str = this.mDownloadProxy.getPlayErrorCodeStr(this.mPlayID);
      return str;
    }
    catch (Throwable localThrowable)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable);
    }
    return null;
  }
  
  public ITPPlayerProxyListener getTPPlayerProxyListener()
  {
    return this.mPlayerProxyListener;
  }
  
  public boolean hasWaitDefTask()
  {
    if (isInitDownloadProxyFailed()) {}
    while ((this.mPendingDefTaskQueue == null) || (this.mPendingDefTaskQueue.size() <= 0)) {
      return false;
    }
    return true;
  }
  
  public boolean isEnable()
  {
    return !isInitDownloadProxyFailed();
  }
  
  public void onEvent(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "onEvent eventId: " + paramInt1 + ", arg1: " + paramInt2 + ", arg2: " + paramInt3 + ", object" + paramObject);
    switch (paramInt1)
    {
    default: 
      return;
    case 100001: 
      pushEventByInner(13);
      return;
    }
    pushEventByInner(14);
  }
  
  public void onStatusChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    TPLogUtil.d("TPThumbPlayer[TPPlayManagerImpl.java]", "onNetworkStatusChanged oldNetStatus: " + paramInt1 + ", netStatus: " + paramInt2);
    if (paramInt2 == 1)
    {
      pushEventByInner(1);
      pushEventByInner(10);
    }
    do
    {
      return;
      if (paramInt2 == 2)
      {
        pushEventByInner(2);
        pushEventByInner(9);
        return;
      }
    } while (paramInt2 != 3);
    pushEventByInner(2);
    pushEventByInner(10);
  }
  
  public void pauseDownload()
  {
    pauseDownload(this.mPlayID);
    Iterator localIterator;
    if (!TPCommonUtils.isEmpty(this.mPendingDefTaskQueue))
    {
      localIterator = this.mPendingDefTaskQueue.iterator();
      while (localIterator.hasNext())
      {
        TPDefTaskModel localTPDefTaskModel = (TPDefTaskModel)localIterator.next();
        if (localTPDefTaskModel != null) {
          pauseDownload(localTPDefTaskModel.proxyTaskID);
        }
      }
    }
    if (!TPCommonUtils.isEmpty(this.mTrackProxyUrlPlayIdMap))
    {
      localIterator = this.mTrackProxyUrlPlayIdMap.values().iterator();
      while (localIterator.hasNext()) {
        pauseDownload(((Integer)localIterator.next()).intValue());
      }
    }
  }
  
  public void playerSwitchDefComplete(long paramLong)
  {
    if (isInitDownloadProxyFailed()) {}
    for (;;)
    {
      return;
      try
      {
        if (!TPCommonUtils.isEmpty(this.mPendingDefTaskQueue))
        {
          for (TPDefTaskModel localTPDefTaskModel = (TPDefTaskModel)this.mPendingDefTaskQueue.peek(); (localTPDefTaskModel != null) && (localTPDefTaskModel.definitionID != paramLong); localTPDefTaskModel = (TPDefTaskModel)this.mPendingDefTaskQueue.peek())
          {
            TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stop proxy definitionID:" + localTPDefTaskModel.definitionID + ", taskID:" + localTPDefTaskModel.proxyTaskID);
            stopDownload(localTPDefTaskModel.proxyTaskID);
            this.mPendingDefTaskQueue.removeFirst();
          }
          if (localTPDefTaskModel != null)
          {
            TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stop proxy task id:" + localTPDefTaskModel.proxyTaskID);
            stopDownload(this.mPlayID);
            this.mPlayID = localTPDefTaskModel.proxyTaskID;
            handleIsActive();
            this.mPendingDefTaskQueue.remove(localTPDefTaskModel);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localException, "playerSwitchDefComplete exception");
      }
    }
  }
  
  public void pushEvent(int paramInt)
  {
    if (isInitDownloadProxyFailed()) {
      return;
    }
    try
    {
      paramInt = TPProxyEnumUtils.eventID2Inner(paramInt);
      pushEventByInner(paramInt);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localIllegalArgumentException);
    }
  }
  
  public void pushEventByInner(int paramInt)
  {
    if (isInitDownloadProxyFailed()) {
      return;
    }
    try
    {
      this.mDownloadProxy.pushEvent(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, "p2p proxy pushEvent failed, event:" + paramInt);
    }
  }
  
  public void release()
  {
    stopDownload();
    TPNetworkChangeMonitor.getInstance().removeOnNetStatusChangeListener(this);
    TPGlobalEventNofication.removeEventListener(this);
    releaseHandler();
    this.mPlayerProxyListener = null;
    this.mPlayListener = new TPPlayProxyListenerEmptyImpl("TPThumbPlayer[TPPlayManagerImpl.java]");
    this.mInnerProxyListener = null;
    this.mDownloadProxy = null;
  }
  
  public void resumeDownload()
  {
    resumeDownload(this.mPlayID);
    Iterator localIterator;
    if (!TPCommonUtils.isEmpty(this.mPendingDefTaskQueue))
    {
      localIterator = this.mPendingDefTaskQueue.iterator();
      while (localIterator.hasNext())
      {
        TPDefTaskModel localTPDefTaskModel = (TPDefTaskModel)localIterator.next();
        if (localTPDefTaskModel != null) {
          resumeDownload(localTPDefTaskModel.proxyTaskID);
        }
      }
    }
    if (!TPCommonUtils.isEmpty(this.mTrackProxyUrlPlayIdMap))
    {
      localIterator = this.mTrackProxyUrlPlayIdMap.values().iterator();
      while (localIterator.hasNext()) {
        resumeDownload(((Integer)localIterator.next()).intValue());
      }
    }
  }
  
  public void setBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (isInitDownloadProxyFailed()) {
      return;
    }
    try
    {
      this.mDownloadProxy.setBusinessDownloadStrategy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable);
    }
  }
  
  public void setIsActive(boolean paramBoolean)
  {
    TPLogUtil.d("TPThumbPlayer[TPPlayManagerImpl.java]", "mPlayId=" + this.mPlayID + ", setIsActive: " + paramBoolean);
    this.mIsActive = paramBoolean;
    if ((isInitDownloadProxyFailed()) || (this.mPlayID < 0)) {
      return;
    }
    handleIsActive();
  }
  
  public void setIsUseResourceLoader(boolean paramBoolean)
  {
    this.mIsUseResourceLoader = paramBoolean;
  }
  
  public void setLogListener(ITPDLProxyLogListener paramITPDLProxyLogListener) {}
  
  public void setPlayListener(ITPPlayListener paramITPPlayListener)
  {
    if (paramITPPlayListener == null)
    {
      this.mPlayListener = new TPPlayProxyListenerEmptyImpl("TPThumbPlayer[TPPlayManagerImpl.java]");
      return;
    }
    this.mPlayListener = paramITPPlayListener;
  }
  
  public void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    if (isInitDownloadProxyFailed()) {}
    do
    {
      do
      {
        return;
        if ((paramTPOptionalParam != null) && (paramTPOptionalParam.getKey() == 100))
        {
          this.mStartTimeMs = paramTPOptionalParam.getParamLong().value;
          return;
        }
      } while ((paramTPOptionalParam == null) || (paramTPOptionalParam.getKey() != 500));
      this.mSkipEndTimeMs = paramTPOptionalParam.getParamLong().value;
    } while (this.mPlayID <= 0);
    this.mDownloadProxy.setUserData("dl_param_play_end_time", Long.valueOf(this.mSkipEndTimeMs));
  }
  
  public void setProxyPlayState(int paramInt)
  {
    TPLogUtil.d("TPThumbPlayer[TPPlayManagerImpl.java]", "setProxyPlayState: " + paramInt);
    if (isInitDownloadProxyFailed()) {}
    for (;;)
    {
      return;
      try
      {
        this.mDownloadProxy.setPlayState(this.mPlayID, paramInt);
        if (((paramInt != 5) && (paramInt != 0)) || (TPCommonUtils.isEmpty(this.mPendingDefTaskQueue))) {
          continue;
        }
        Iterator localIterator = this.mPendingDefTaskQueue.iterator();
        while (localIterator.hasNext())
        {
          TPDefTaskModel localTPDefTaskModel = (TPDefTaskModel)localIterator.next();
          if (localTPDefTaskModel != null)
          {
            TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "setProxyPlayState definitionID:" + localTPDefTaskModel.definitionID + ", taskID:" + localTPDefTaskModel.proxyTaskID + ", state:" + paramInt);
            this.mDownloadProxy.setPlayState(localTPDefTaskModel.proxyTaskID, paramInt);
          }
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable);
      }
    }
  }
  
  public void setProxyServiceType(int paramInt)
  {
    this.mServiceType = paramInt;
  }
  
  public void setTPPlayerProxyListener(ITPPlayerProxyListener paramITPPlayerProxyListener)
  {
    this.mPlayerProxyListener = paramITPPlayerProxyListener;
  }
  
  public void setVideoInfo(TPVideoInfo paramTPVideoInfo)
  {
    if (paramTPVideoInfo == null) {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "setVideoInfo, param is null ");
    }
    do
    {
      return;
      if (this.mVideoInfo != null) {
        updateVideoInfo(paramTPVideoInfo);
      }
      this.mVideoInfo = paramTPVideoInfo;
      TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "setVideoInfo, enter");
      this.mFileID = paramTPVideoInfo.getProxyFileID();
      if (!TPCommonUtils.isEmpty(this.mDownloadPramList)) {
        this.mDownloadPramList.clear();
      }
    } while ((paramTPVideoInfo.getDownloadPraramList() == null) || (paramTPVideoInfo.getDownloadPraramList().size() <= 0));
    this.mDownloadPramList.addAll(paramTPVideoInfo.getDownloadPraramList());
  }
  
  public void startDemuxer(String paramString1, String paramString2)
    throws Exception
  {
    if ((!TPCommonUtils.isUrl(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      throw new Exception("illegal argument.");
    }
    if (!this.mIsDemuxer)
    {
      if (!addAudioTrack(paramString1, paramString2)) {
        throw new Exception("setClipInfo err.");
      }
    }
    else
    {
      stopDownload(this.mPlayID);
      startDownloadPlay(this.mOriginUrl, null);
      if (!addAudioTrack(paramString1, paramString2)) {
        throw new Exception("setClipInfo err.");
      }
    }
    this.mIsDemuxer = true;
  }
  
  public String startDownLoadTrackUrl(int paramInt, String paramString, TPDownloadParamData paramTPDownloadParamData)
  {
    int i = 1;
    int j = 1;
    if (TextUtils.isEmpty(paramString))
    {
      TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz url is empty");
      return paramString;
    }
    if (!TPCommonUtils.isUrl(paramString))
    {
      TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz url is locol url, not need use proxy");
      return paramString;
    }
    if (isInitDownloadProxyFailed())
    {
      TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz download proxy init failed");
      return paramString;
    }
    String str1;
    TPDownloadParam localTPDownloadParam1;
    if (paramTPDownloadParamData != null)
    {
      str1 = paramString;
      try
      {
        TPDownloadParam localTPDownloadParam2 = TPProxyUtils.convertProxyDownloadParams(paramString, paramTPDownloadParamData, null);
        paramInt = j;
        str1 = paramString;
        if (paramTPDownloadParamData.getTaskType() == 1) {
          paramInt = 2;
        }
        str1 = paramString;
        String str2 = paramTPDownloadParamData.getDownloadFileID();
        localTPDownloadParam1 = localTPDownloadParam2;
        paramTPDownloadParamData = str2;
        i = paramInt;
        str1 = paramString;
        if (TextUtils.isEmpty(str2))
        {
          str1 = paramString;
          paramTPDownloadParamData = TPCommonUtils.getMd5(paramString);
          i = paramInt;
          localTPDownloadParam1 = localTPDownloadParam2;
        }
        str1 = paramString;
        paramInt = this.mDownloadProxy.startPlay(paramTPDownloadParamData, localTPDownloadParam1, this.mInnerProxyListener);
        if (paramInt <= 0) {
          break label302;
        }
        str1 = paramString;
        TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start play, url type" + i);
        str1 = paramString;
        paramString = this.mDownloadProxy.getPlayUrl(paramInt, i);
        str1 = paramString;
        this.mTrackProxyUrlPlayIdMap.put(paramString, Integer.valueOf(paramInt));
        return paramString;
      }
      catch (Throwable paramString)
      {
        TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start play failed:" + paramString);
        return str1;
      }
    }
    else
    {
      str1 = paramString;
      paramTPDownloadParamData = new ArrayList();
      str1 = paramString;
      paramTPDownloadParamData.add(paramString);
      if (paramInt != 2) {
        break label315;
      }
    }
    label302:
    label315:
    for (paramInt = 3;; paramInt = 0)
    {
      str1 = paramString;
      localTPDownloadParam1 = new TPDownloadParam(paramTPDownloadParamData, paramInt, null);
      str1 = paramString;
      paramTPDownloadParamData = TPCommonUtils.getMd5(paramString);
      break;
      str1 = paramString;
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start play failed, cause : playId < 0");
      return paramString;
    }
  }
  
  public TPUrlDataSource startDownloadPlay(String paramString, Map<String, String> paramMap)
  {
    TPUrlDataSource localTPUrlDataSource = new TPUrlDataSource(paramString);
    if (!TPCommonUtils.isUrl(paramString)) {
      return localTPUrlDataSource;
    }
    if (isInitDownloadProxyFailed(true)) {
      return localTPUrlDataSource;
    }
    setPlayUserData();
    this.mOriginUrl = paramString;
    Object localObject1 = getDownloadParamDataWithIndex(this.mDownloadPramList, 0);
    if ((this.mIsUseResourceLoader) && (localObject1 != null) && (((TPDownloadParamData)localObject1).getDlType() == 1))
    {
      localObject1 = new TPDownloadParamData(11);
      if (localObject1 == null) {
        break label323;
      }
      paramMap = convertDownloadParam(paramString, (TPDownloadParamData)localObject1, paramMap);
    }
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder().append("single url:").append(paramString).append(", paramData.savePath:");
        if (localObject1 == null) {
          break label328;
        }
        localObject2 = ((TPDownloadParamData)localObject1).getSavePath();
        localObject2 = localStringBuilder.append((String)localObject2).append(", paramData.DownloadFileID:");
        if (localObject1 == null) {
          break label336;
        }
        localObject1 = ((TPDownloadParamData)localObject1).getDownloadFileID();
        TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", (String)localObject1);
        this.mPlayID = this.mDownloadProxy.startPlay(getFileId(), paramMap, this.mInnerProxyListener);
        handleIsActive();
        if (this.mPlayID > 0)
        {
          localObject1 = this.mDownloadProxy.getPlayUrl(this.mPlayID, 0);
          paramMap = (Map<String, String>)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            paramMap = paramString;
          }
          TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "startDownloadPlay, playId:" + this.mPlayID);
          localTPUrlDataSource.setSelfPlayerUrl(paramMap);
          paramMap = this.mDownloadProxy.getPlayUrl(this.mPlayID, 1);
          if (TextUtils.isEmpty(paramMap))
          {
            localTPUrlDataSource.setSystemPlayerUrl(paramString);
            break label320;
          }
        }
        else
        {
          TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start play failed, cause : playId < 0");
        }
      }
      catch (Throwable paramString)
      {
        TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", paramString, "p2p proxy start play failed");
      }
      paramString = paramMap;
      continue;
      break;
      label320:
      return localTPUrlDataSource;
      label323:
      paramMap = null;
      continue;
      label328:
      Object localObject2 = "null";
      continue;
      label336:
      localObject1 = "null";
    }
  }
  
  public ITPMediaAsset startDownloadPlayByAsset(ITPMediaAsset paramITPMediaAsset)
  {
    if (isInitDownloadProxyFailed(true)) {}
    Object localObject;
    do
    {
      return paramITPMediaAsset;
      setPlayUserData();
      if ((paramITPMediaAsset instanceof TPMediaDRMAsset))
      {
        localObject = startDownloadPlay(((TPMediaDRMAsset)paramITPMediaAsset).getDrmPlayUrl(), null);
        ((TPMediaDRMAsset)paramITPMediaAsset).setDrmPlayUrl(((TPUrlDataSource)localObject).getSelfPlayerUrl());
        return paramITPMediaAsset;
      }
      localObject = getAssetClips(paramITPMediaAsset);
    } while (TPCommonUtils.isEmpty((Collection)localObject));
    this.mPlayID = startClipPlay((List)localObject, getFileId(), this.mDownloadPramList);
    handleIsActive();
    return paramITPMediaAsset;
  }
  
  public TPUrlDataSource startSwitchDefTask(long paramLong, String paramString, TPVideoInfo paramTPVideoInfo, Map<String, String> paramMap)
  {
    if (paramTPVideoInfo == null) {
      return new TPUrlDataSource(paramString);
    }
    TPDownloadParamData localTPDownloadParamData = null;
    if (paramTPVideoInfo.getDownloadPraramList() != null) {
      localTPDownloadParamData = (TPDownloadParamData)paramTPVideoInfo.getDownloadPraramList().get(0);
    }
    return startSwitchDefTask(paramLong, paramString, localTPDownloadParamData, paramMap);
  }
  
  public ITPMediaAsset startSwitchDefTaskByAsset(ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo)
  {
    if ((isInitDownloadProxyFailed()) || (paramITPMediaAsset == null)) {}
    do
    {
      return paramITPMediaAsset;
      if (this.mPendingDefTaskQueue == null) {
        this.mPendingDefTaskQueue = new LinkedList();
      }
    } while (paramTPVideoInfo == null);
    if ((paramITPMediaAsset instanceof ITPMediaDRMAsset)) {
      if (paramTPVideoInfo.getDownloadPraramList() == null) {
        break label207;
      }
    }
    label207:
    for (paramTPVideoInfo = (TPDownloadParamData)paramTPVideoInfo.getDownloadPraramList().get(0);; paramTPVideoInfo = null)
    {
      paramTPVideoInfo = startSwitchDefTask(paramLong, ((ITPMediaDRMAsset)paramITPMediaAsset).getDrmPlayUrl(), paramTPVideoInfo, null);
      ((TPMediaDRMAsset)paramITPMediaAsset).setDrmPlayUrl(paramTPVideoInfo.getSelfPlayerUrl());
      return paramITPMediaAsset;
      List localList = getAssetClips(paramITPMediaAsset);
      if ((TPCommonUtils.isEmpty(localList)) || (paramTPVideoInfo == null)) {
        break;
      }
      int i = startClipPlay(localList, paramTPVideoInfo.getProxyFileID(), paramTPVideoInfo.getDownloadPraramList());
      if (i > 0)
      {
        this.mPendingDefTaskQueue.offer(new TPDefTaskModel(paramLong, i));
        TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def sucess, defId:" + paramLong + ",playId:" + i);
        return paramITPMediaAsset;
      }
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch clip def failed, cause : playId < 0");
      return paramITPMediaAsset;
    }
  }
  
  public void stopDemuxer()
  {
    if (this.mIsDemuxer)
    {
      stopDownload(this.mPlayID);
      startDownloadPlay(this.mOriginUrl, null);
    }
    this.mIsDemuxer = false;
  }
  
  public void stopDownLoadTrackUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz url is empty");
      return;
    }
    if (isInitDownloadProxyFailed())
    {
      TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz download proxy init failed");
      return;
    }
    if (!this.mTrackProxyUrlPlayIdMap.containsKey(paramString))
    {
      TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return, coz mTrackProxyUrlPlayIdMap not contain current proxy url:" + paramString + ", or it is not proxy url");
      return;
    }
    int i = ((Integer)this.mTrackProxyUrlPlayIdMap.get(paramString)).intValue();
    try
    {
      this.mDownloadProxy.stopPlay(i);
      return;
    }
    catch (Exception paramString)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy stop play failed:" + paramString);
    }
  }
  
  public void stopDownload()
  {
    if (this.mPlayID < 0)
    {
      TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stopDownload failed, coz playId:" + this.mPlayID + ", less than zero. maybe download proxy didn't started");
      return;
    }
    TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stopDownload, playId:" + this.mPlayID);
    stopDownload(this.mPlayID);
    Iterator localIterator;
    if (!TPCommonUtils.isEmpty(this.mPendingDefTaskQueue))
    {
      localIterator = this.mPendingDefTaskQueue.iterator();
      while (localIterator.hasNext())
      {
        TPDefTaskModel localTPDefTaskModel = (TPDefTaskModel)localIterator.next();
        if (localTPDefTaskModel != null) {
          stopDownload(localTPDefTaskModel.proxyTaskID);
        }
      }
      this.mPendingDefTaskQueue.clear();
    }
    if (!TPCommonUtils.isEmpty(this.mTrackProxyUrlPlayIdMap))
    {
      localIterator = this.mTrackProxyUrlPlayIdMap.values().iterator();
      while (localIterator.hasNext()) {
        stopDownload(((Integer)localIterator.next()).intValue());
      }
      this.mTrackProxyUrlPlayIdMap.clear();
    }
    this.mPlayID = -1;
    reset();
  }
  
  @SuppressLint({"HandlerLeak"})
  class EventHandler
    extends Handler
  {
    public EventHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (TPPlayManagerImpl.this.mPlayListener == null)
      {
        TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "handleMessage failed, mPlayListener is null and return");
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      case 4097: 
        TPPlayManagerImpl.this.mPlayListener.onDownloadFinish();
        return;
      case 4106: 
        paramMessage = (TPPlayerMsg.TPDownLoadProgressInfo)paramMessage.obj;
        TPPlayManagerImpl.this.mPlayListener.onDownloadProgressUpdate((int)paramMessage.playableDurationMS, paramMessage.downloadSpeedKBps, paramMessage.currentDownloadSize, paramMessage.totalFileSize, paramMessage.extraInfo);
        return;
      case 4098: 
        TPPlayManagerImpl.this.mPlayListener.onDownloadError(paramMessage.arg1, paramMessage.arg2, (String)paramMessage.obj);
        return;
      case 4099: 
        TPPlayManagerImpl.this.mPlayListener.onDownloadCdnUrlUpdate((String)paramMessage.obj);
        return;
      case 4100: 
        paramMessage = (TPPlayerMsg.TPCDNURLInfo)paramMessage.obj;
        TPPlayManagerImpl.this.mPlayListener.onDownloadCdnUrlInfoUpdate(paramMessage.url, paramMessage.cdnIp, paramMessage.uIp, paramMessage.errorStr);
        return;
      case 4101: 
        TPPlayManagerImpl.this.mPlayListener.onDownloadStatusUpdate(paramMessage.arg1);
        return;
      case 4102: 
        paramMessage = (TPPlayerMsg.TPProtocolInfo)paramMessage.obj;
        TPPlayManagerImpl.this.mPlayListener.onDownloadProtocolUpdate(paramMessage.protocolName, paramMessage.protocolVersion);
        return;
      case 4103: 
        TPPlayManagerImpl.this.mPlayListener.onDownloadCdnUrlExpired((Map)paramMessage.obj);
        return;
      case 4104: 
        paramMessage = (TPPlayManagerImpl.TPMessageParams)paramMessage.obj;
        localObject = (TPPlayManagerImpl.TPOnPlayCallBackParams)paramMessage.params;
        localObject = TPPlayManagerImpl.this.mPlayListener.onPlayCallback(((TPPlayManagerImpl.TPOnPlayCallBackParams)localObject).messageType, ((TPPlayManagerImpl.TPOnPlayCallBackParams)localObject).ext1, ((TPPlayManagerImpl.TPOnPlayCallBackParams)localObject).ext2, ((TPPlayManagerImpl.TPOnPlayCallBackParams)localObject).ext3, ((TPPlayManagerImpl.TPOnPlayCallBackParams)localObject).ext4);
        paramMessage.result.setResult(localObject);
        return;
      case 4105: 
        paramMessage = (TPPlayManagerImpl.TPMessageParams)paramMessage.obj;
        localObject = TPPlayManagerImpl.this.mPlayListener.getPlayInfo(((Long)paramMessage.params).longValue());
        paramMessage.result.setResult(localObject);
        return;
      }
      paramMessage = (TPPlayManagerImpl.TPMessageParams)paramMessage.obj;
      Object localObject = TPPlayManagerImpl.this.mPlayListener.getPlayInfo((String)paramMessage.params);
      paramMessage.result.setResult(localObject);
    }
  }
  
  class InnerProxyListener
    implements ITPPlayListener
  {
    private InnerProxyListener() {}
    
    public long getAdvRemainTime()
    {
      return TPPlayManagerImpl.this.mPlayListener.getAdvRemainTime();
    }
    
    public String getContentType(int paramInt, String paramString)
    {
      return TPPlayManagerImpl.this.mPlayListener.getContentType(paramInt, paramString);
    }
    
    public int getCurrentPlayClipNo()
    {
      return TPPlayManagerImpl.this.mPlayListener.getCurrentPlayClipNo();
    }
    
    public long getCurrentPosition()
    {
      return TPPlayManagerImpl.this.mPlayListener.getCurrentPosition();
    }
    
    public String getDataFilePath(int paramInt, String paramString)
    {
      return TPPlayManagerImpl.this.mPlayListener.getDataFilePath(paramInt, paramString);
    }
    
    public long getDataTotalSize(int paramInt, String paramString)
    {
      return TPPlayManagerImpl.this.mPlayListener.getDataTotalSize(paramInt, paramString);
    }
    
    public Object getPlayInfo(long paramLong)
    {
      TPFutureResult localTPFutureResult = new TPFutureResult();
      TPPlayManagerImpl.TPMessageParams localTPMessageParams = new TPPlayManagerImpl.TPMessageParams(null);
      localTPMessageParams.params = Long.valueOf(paramLong);
      localTPMessageParams.result = localTPFutureResult;
      TPPlayManagerImpl.this.internalMessage(4105, localTPMessageParams);
      return TPPlayManagerImpl.this.getFutureResult(localTPFutureResult);
    }
    
    public Object getPlayInfo(String paramString)
    {
      TPFutureResult localTPFutureResult = new TPFutureResult();
      TPPlayManagerImpl.TPMessageParams localTPMessageParams = new TPPlayManagerImpl.TPMessageParams(null);
      localTPMessageParams.params = paramString;
      localTPMessageParams.result = localTPFutureResult;
      TPPlayManagerImpl.this.internalMessage(4107, localTPMessageParams);
      return TPPlayManagerImpl.this.getFutureResult(localTPFutureResult);
    }
    
    public long getPlayerBufferLength()
    {
      return TPPlayManagerImpl.this.mPlayListener.getPlayerBufferLength();
    }
    
    public void onDownloadCdnUrlExpired(Map<String, String> paramMap)
    {
      TPPlayManagerImpl.this.internalMessage(4103, paramMap);
    }
    
    public void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      TPPlayerMsg.TPCDNURLInfo localTPCDNURLInfo = new TPPlayerMsg.TPCDNURLInfo();
      localTPCDNURLInfo.url = paramString1;
      localTPCDNURLInfo.cdnIp = paramString2;
      localTPCDNURLInfo.uIp = paramString3;
      localTPCDNURLInfo.errorStr = paramString4;
      TPPlayManagerImpl.this.internalMessage(4100, localTPCDNURLInfo);
    }
    
    public void onDownloadCdnUrlUpdate(String paramString)
    {
      TPPlayManagerImpl.this.internalMessage(4099, paramString);
    }
    
    public void onDownloadError(int paramInt1, int paramInt2, String paramString)
    {
      if (TPPlayManagerImpl.this.isQQVideoExpired(paramString))
      {
        TPPlayManagerImpl.this.internalMessage(4098, paramInt1, 14011001, paramString, false, false, 0L);
        return;
      }
      TPPlayManagerImpl.this.internalMessage(4098, paramInt1, paramInt2, paramString, false, false, 0L);
    }
    
    public void onDownloadFinish()
    {
      TPPlayManagerImpl.this.internalMessage(4097, null);
    }
    
    public void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
    {
      TPPlayerMsg.TPDownLoadProgressInfo localTPDownLoadProgressInfo = new TPPlayerMsg.TPDownLoadProgressInfo();
      localTPDownLoadProgressInfo.playableDurationMS = paramInt1;
      localTPDownLoadProgressInfo.downloadSpeedKBps = paramInt2;
      localTPDownLoadProgressInfo.currentDownloadSize = paramLong1;
      localTPDownLoadProgressInfo.totalFileSize = paramLong2;
      localTPDownLoadProgressInfo.extraInfo = paramString;
      TPPlayManagerImpl.this.internalMessage(4106, localTPDownLoadProgressInfo);
    }
    
    public void onDownloadProtocolUpdate(String paramString1, String paramString2)
    {
      TPPlayerMsg.TPProtocolInfo localTPProtocolInfo = new TPPlayerMsg.TPProtocolInfo();
      localTPProtocolInfo.protocolVersion = paramString2;
      localTPProtocolInfo.protocolName = paramString1;
      TPPlayManagerImpl.this.internalMessage(4102, localTPProtocolInfo);
    }
    
    public void onDownloadStatusUpdate(int paramInt)
    {
      TPPlayManagerImpl.this.internalMessage(4101, paramInt, 0, null, false, false, 0L);
    }
    
    public void onPcdnDownloadFailed(String paramString)
    {
      TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "onPcdnDownloadFailed: " + paramString);
      TPPlayManagerImpl.this.mPlayListener.onPcdnDownloadFailed(paramString);
    }
    
    public Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      TPPlayManagerImpl.TPOnPlayCallBackParams localTPOnPlayCallBackParams = new TPPlayManagerImpl.TPOnPlayCallBackParams(null);
      localTPOnPlayCallBackParams.messageType = paramInt;
      localTPOnPlayCallBackParams.ext1 = paramObject1;
      localTPOnPlayCallBackParams.ext2 = paramObject2;
      localTPOnPlayCallBackParams.ext3 = paramObject3;
      localTPOnPlayCallBackParams.ext4 = paramObject4;
      paramObject1 = new TPFutureResult();
      paramObject2 = new TPPlayManagerImpl.TPMessageParams(null);
      paramObject2.params = localTPOnPlayCallBackParams;
      paramObject2.result = paramObject1;
      TPPlayManagerImpl.this.internalMessage(4104, paramObject2);
      return TPPlayManagerImpl.this.getFutureResult(paramObject1);
    }
    
    public void onQuicDownloadStatusUpdate(String paramString)
    {
      TPPlayManagerImpl.this.mPlayListener.onQuicDownloadStatusUpdate(paramString);
    }
    
    public int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
    {
      return TPPlayManagerImpl.this.mPlayListener.onReadData(paramInt, paramString, paramLong1, paramLong2);
    }
    
    public int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
    {
      return TPPlayManagerImpl.this.mPlayListener.onStartReadData(paramInt, paramString, paramLong1, paramLong2);
    }
    
    public int onStopReadData(int paramInt1, String paramString, int paramInt2)
    {
      return TPPlayManagerImpl.this.mPlayListener.onStopReadData(paramInt1, paramString, paramInt2);
    }
  }
  
  static class TPDefTaskModel
  {
    long definitionID;
    int proxyTaskID;
    
    TPDefTaskModel(long paramLong, int paramInt)
    {
      this.definitionID = paramLong;
      this.proxyTaskID = paramInt;
    }
  }
  
  static class TPDownloadSeqAndClipIndexMapping
  {
    int clipIndex;
    int downloadSeq;
    
    TPDownloadSeqAndClipIndexMapping(int paramInt1, int paramInt2)
    {
      this.downloadSeq = paramInt1;
      this.clipIndex = paramInt2;
    }
  }
  
  static class TPMessageParams
  {
    Object params;
    TPFutureResult result;
  }
  
  static class TPOnPlayCallBackParams
  {
    Object ext1;
    Object ext2;
    Object ext3;
    Object ext4;
    int messageType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.TPPlayManagerImpl
 * JD-Core Version:    0.7.0.1
 */