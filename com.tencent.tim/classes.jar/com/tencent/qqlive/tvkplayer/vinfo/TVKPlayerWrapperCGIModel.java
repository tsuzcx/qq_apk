package com.tencent.qqlive.tvkplayer.vinfo;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKPlayerUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKLiveInfoGetter;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKLiveInfoGetter.OnGetLiveInfoListener;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter.ITVKVodInfoGetterCallback;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveInfoGetter;
import com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVodInfoGetter;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class TVKPlayerWrapperCGIModel
{
  public static final int REQ_TYPE_ERROR_RETRY = 5;
  public static final int REQ_TYPE_HIGH_RAIL = 4;
  public static final int REQ_TYPE_LIVE_BACK_PLAY = 6;
  public static final int REQ_TYPE_LOOP_PLAY = 3;
  public static final int REQ_TYPE_NORMAL = 0;
  public static final int REQ_TYPE_SWITCH_AUDIO = 2;
  public static final int REQ_TYPE_SWITCH_DEF = 1;
  private static final int STATE_CANCELED = 2;
  private static final int STATE_COMPLETE = 3;
  private static final int STATE_INIT = 0;
  private static final int STATE_ON_GOING = 1;
  public static final String TAG = "TVKPlayer[TVKPlayerWrapper]";
  private static boolean sIsDDSInit = false;
  private static boolean sIsDDSSup = false;
  private CGIWrapperCallback mCallback;
  private CGICallbackHandler mHandler;
  private CGICombineCallback mRequestCallback;
  private Queue<CGIRequest> mRequestQueue;
  
  public TVKPlayerWrapperCGIModel(@NonNull Looper paramLooper, CGIWrapperCallback paramCGIWrapperCallback)
  {
    this.mCallback = paramCGIWrapperCallback;
    this.mRequestQueue = new LinkedBlockingQueue();
    this.mRequestCallback = new CGICombineCallback(null);
    this.mHandler = new CGICallbackHandler(paramLooper);
  }
  
  private CGIRequest buildRequest(int paramInt, TVKPlaybackParam paramTVKPlaybackParam, TVKPlaybackInfo paramTVKPlaybackInfo)
  {
    if (paramInt == 0) {
      return buildRequestForTypeNormal(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    }
    if (paramInt == 1) {
      return buildRequestForTypeSwitchDefinition(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    }
    if (paramInt == 2) {
      return buildRequestForTypeSwitchAudio(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    }
    if (paramInt == 3) {
      return buildRequestForTypeLoopPlay(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    }
    if (paramInt == 4) {
      return buildRequestForTypeHighRail(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    }
    if (paramInt == 6) {
      return buildRequestForTypeLiveBackPlay(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    }
    if (paramInt == 5) {
      return buildRequestForTypeErrorRetry(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    }
    return buildRequestForTypeNormal(paramTVKPlaybackParam, paramTVKPlaybackInfo);
  }
  
  @NonNull
  private CGIRequest buildRequestForTypeErrorRetry(TVKPlaybackParam paramTVKPlaybackParam, TVKPlaybackInfo paramTVKPlaybackInfo)
  {
    playVideoInfoCommonExtraRequestMapFormat(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    CGIRequest localCGIRequest = new CGIRequest(null);
    localCGIRequest.reqId = -1;
    localCGIRequest.reqType = 5;
    localCGIRequest.reqState = 0;
    localCGIRequest.playbackParam = paramTVKPlaybackParam;
    localCGIRequest.playbackInfo = paramTVKPlaybackInfo;
    localCGIRequest.requestInfo = paramTVKPlaybackInfo.requestInfo().copy();
    localCGIRequest.startTimeMs = System.currentTimeMillis();
    return localCGIRequest;
  }
  
  @NonNull
  private CGIRequest buildRequestForTypeHighRail(TVKPlaybackParam paramTVKPlaybackParam, TVKPlaybackInfo paramTVKPlaybackInfo)
  {
    playVideoInfoCommonExtraRequestMapFormat(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    CGIRequest localCGIRequest = new CGIRequest(null);
    localCGIRequest.reqId = -1;
    localCGIRequest.reqType = 4;
    localCGIRequest.reqState = 0;
    localCGIRequest.playbackParam = paramTVKPlaybackParam;
    localCGIRequest.playbackInfo = paramTVKPlaybackInfo;
    localCGIRequest.requestInfo = paramTVKPlaybackInfo.requestInfo().copy();
    localCGIRequest.startTimeMs = System.currentTimeMillis();
    return localCGIRequest;
  }
  
  @NonNull
  private CGIRequest buildRequestForTypeLiveBackPlay(TVKPlaybackParam paramTVKPlaybackParam, TVKPlaybackInfo paramTVKPlaybackInfo)
  {
    playVideoInfoCommonExtraRequestMapFormat(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    if (-1L == paramTVKPlaybackParam.livePlayBackTimeSec()) {
      paramTVKPlaybackParam.videoInfo().getExtraRequestParamsMap().remove("playbacktime");
    }
    for (;;)
    {
      CGIRequest localCGIRequest = new CGIRequest(null);
      localCGIRequest.reqId = -1;
      localCGIRequest.reqType = 6;
      localCGIRequest.reqState = 0;
      localCGIRequest.playbackParam = paramTVKPlaybackParam;
      localCGIRequest.playbackInfo = paramTVKPlaybackInfo;
      localCGIRequest.requestInfo = paramTVKPlaybackInfo.requestInfo().copy();
      localCGIRequest.startTimeMs = System.currentTimeMillis();
      return localCGIRequest;
      paramTVKPlaybackParam.videoInfo().getExtraRequestParamsMap().put("playbacktime", String.valueOf(paramTVKPlaybackParam.livePlayBackTimeSec()));
    }
  }
  
  @NonNull
  private CGIRequest buildRequestForTypeLoopPlay(TVKPlaybackParam paramTVKPlaybackParam, TVKPlaybackInfo paramTVKPlaybackInfo)
  {
    playVideoInfoCommonExtraRequestMapFormat(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    paramTVKPlaybackParam.videoInfo().addProxyExtraMap("tv_task_type", String.valueOf(1));
    return new CGIRequest(null);
  }
  
  @NonNull
  private CGIRequest buildRequestForTypeNormal(TVKPlaybackParam paramTVKPlaybackParam, TVKPlaybackInfo paramTVKPlaybackInfo)
  {
    playVideoInfoCommonExtraRequestMapFormat(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    CGIRequest localCGIRequest = new CGIRequest(null);
    localCGIRequest.reqId = -1;
    localCGIRequest.reqType = 0;
    localCGIRequest.reqState = 0;
    localCGIRequest.playbackParam = paramTVKPlaybackParam;
    localCGIRequest.playbackInfo = paramTVKPlaybackInfo;
    localCGIRequest.requestInfo = paramTVKPlaybackInfo.requestInfo().copy();
    localCGIRequest.startTimeMs = System.currentTimeMillis();
    return localCGIRequest;
  }
  
  @NonNull
  private CGIRequest buildRequestForTypeSwitchAudio(TVKPlaybackParam paramTVKPlaybackParam, TVKPlaybackInfo paramTVKPlaybackInfo)
  {
    playVideoInfoCommonExtraRequestMapFormat(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    CGIRequest localCGIRequest = new CGIRequest(null);
    localCGIRequest.reqId = -1;
    localCGIRequest.reqType = 2;
    localCGIRequest.reqState = 0;
    localCGIRequest.playbackParam = paramTVKPlaybackParam;
    localCGIRequest.playbackInfo = paramTVKPlaybackInfo;
    localCGIRequest.requestInfo = paramTVKPlaybackInfo.requestInfo().copy();
    localCGIRequest.startTimeMs = System.currentTimeMillis();
    return localCGIRequest;
  }
  
  @NonNull
  private CGIRequest buildRequestForTypeSwitchDefinition(TVKPlaybackParam paramTVKPlaybackParam, TVKPlaybackInfo paramTVKPlaybackInfo)
  {
    playVideoInfoCommonExtraRequestMapFormat(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    CGIRequest localCGIRequest = new CGIRequest(null);
    localCGIRequest.reqId = -1;
    localCGIRequest.reqType = 1;
    localCGIRequest.reqState = 0;
    localCGIRequest.playbackParam = paramTVKPlaybackParam;
    localCGIRequest.playbackInfo = paramTVKPlaybackInfo;
    localCGIRequest.requestInfo = paramTVKPlaybackInfo.requestInfo().copy();
    localCGIRequest.startTimeMs = System.currentTimeMillis();
    return localCGIRequest;
  }
  
  private void dumpRequest(CGIRequest paramCGIRequest)
  {
    TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", "CGI : ## videoInfo Request ##");
    String str1 = paramCGIRequest.playbackParam.videoInfo().getVid();
    String str2 = paramCGIRequest.requestInfo.definition();
    String str3 = paramCGIRequest.requestInfo.audioTrack();
    boolean bool1 = paramCGIRequest.requestInfo.h265Enable();
    boolean bool2 = paramCGIRequest.requestInfo.drmEnable();
    boolean bool3 = paramCGIRequest.requestInfo.hdr10Enable();
    boolean bool4 = paramCGIRequest.requestInfo.dolbyEnable();
    long l = paramCGIRequest.playbackParam.livePlayBackTimeSec();
    if (paramCGIRequest.reqType == 0) {
      TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", "CGI : request type :normal request");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str1)) {
        TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", "CGI : request param : vid : " + str1);
      }
      TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", "CGI : request param : definition  :" + str2);
      TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", "CGI : request param : h265Enable  :" + bool1);
      TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", "CGI : request param : audioTrack  :" + str3);
      TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", "CGI : request param : drmEnable   :" + bool2);
      TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", "CGI : request param : hdr10Enable :" + bool3);
      TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", "CGI : request param : dolbyEnable :" + bool4);
      TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", "CGI : request param : playbacktimems :" + l);
      return;
      if (paramCGIRequest.reqType == 1) {
        TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", "CGI : request type :switch definition request");
      } else if (paramCGIRequest.reqType == 2) {
        TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", "CGI : request type :switch audio track request");
      } else if (paramCGIRequest.reqType == 3) {
        TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", "CGI : request type :loop play request");
      } else if (paramCGIRequest.reqType == 4) {
        TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", "CGI : request type :high rail request");
      } else if (paramCGIRequest.reqType == 6) {
        TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", "CGI : request type :live back play");
      }
    }
  }
  
  @Nullable
  private CGIRequest findRequestByReqId(int paramInt)
  {
    Iterator localIterator = this.mRequestQueue.iterator();
    while (localIterator.hasNext())
    {
      CGIRequest localCGIRequest = (CGIRequest)localIterator.next();
      if (paramInt == localCGIRequest.reqId) {
        return localCGIRequest;
      }
    }
    return null;
  }
  
  /* Error */
  private boolean hasRemainingOnGoingRequest()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 70	com/tencent/qqlive/tvkplayer/vinfo/TVKPlayerWrapperCGIModel:mRequestQueue	Ljava/util/Queue;
    //   6: invokeinterface 308 1 0
    //   11: astore_3
    //   12: aload_3
    //   13: invokeinterface 313 1 0
    //   18: ifeq +39 -> 57
    //   21: aload_3
    //   22: invokeinterface 317 1 0
    //   27: checkcast 12	com/tencent/qqlive/tvkplayer/vinfo/TVKPlayerWrapperCGIModel$CGIRequest
    //   30: astore 4
    //   32: aload 4
    //   34: getfield 143	com/tencent/qqlive/tvkplayer/vinfo/TVKPlayerWrapperCGIModel$CGIRequest:reqState	I
    //   37: ifeq +14 -> 51
    //   40: aload 4
    //   42: getfield 143	com/tencent/qqlive/tvkplayer/vinfo/TVKPlayerWrapperCGIModel$CGIRequest:reqState	I
    //   45: istore_1
    //   46: iload_1
    //   47: iconst_1
    //   48: if_icmpne -36 -> 12
    //   51: iconst_1
    //   52: istore_2
    //   53: aload_0
    //   54: monitorexit
    //   55: iload_2
    //   56: ireturn
    //   57: iconst_0
    //   58: istore_2
    //   59: goto -6 -> 53
    //   62: astore_3
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_3
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	TVKPlayerWrapperCGIModel
    //   45	4	1	i	int
    //   52	7	2	bool	boolean
    //   11	11	3	localIterator	Iterator
    //   62	4	3	localObject	Object
    //   30	11	4	localCGIRequest	CGIRequest
    // Exception table:
    //   from	to	target	type
    //   2	12	62	finally
    //   12	46	62	finally
  }
  
  public static boolean isHwDolbyDSSupported()
  {
    if (sIsDDSInit) {
      return sIsDDSSup;
    }
    try
    {
      Object localObject1 = Class.forName("android.os.SystemProperties");
      localObject1 = (String)((Class)localObject1).getMethod("get", new Class[] { String.class }).invoke(localObject1, new Object[] { "dolby.ds.state" });
      if ((localObject1 != null) && ((localObject1 == null) || (!((String)localObject1).trim().equals(""))))
      {
        bool = true;
        sIsDDSSup = bool;
        sIsDDSInit = true;
        return sIsDDSSup;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject2 = null;
        continue;
        boolean bool = false;
      }
    }
  }
  
  private void markAllRequestCanceled()
  {
    Iterator localIterator = this.mRequestQueue.iterator();
    while (localIterator.hasNext()) {
      ((CGIRequest)localIterator.next()).reqState = 2;
    }
  }
  
  private void playVideoInfoCommonExtraRequestMapFormat(TVKPlaybackParam paramTVKPlaybackParam, TVKPlaybackInfo paramTVKPlaybackInfo)
  {
    TVKPlayerWrapperHelper.PlayerVideoInfoHelper.configVideoInfoMapToExtralMap(paramTVKPlaybackParam.videoInfo());
    TVKPlayerWrapperHelper.PlayerVideoInfoHelper.videoInfoConfigDefinition(paramTVKPlaybackParam, paramTVKPlaybackInfo);
    TVKPlayerWrapperHelper.PlayerVideoInfoHelper.configVideoInfoHEVCLevel(paramTVKPlaybackParam.videoInfo(), paramTVKPlaybackInfo.requestInfo().definition(), paramTVKPlaybackInfo.requestInfo().h265Enable());
    paramTVKPlaybackParam.videoInfo().addExtraRequestParamsMap("flowid", paramTVKPlaybackInfo.requestInfo().flowId());
    TVKPlayerWrapperHelper.PlayerVideoInfoHelper.configVideoInfoVersion(paramTVKPlaybackParam.videoInfo());
    TVKPlayerWrapperHelper.PlayerVideoInfoHelper.dumpVideoInfo(paramTVKPlaybackParam.videoInfo());
  }
  
  private void removeRequestByReqId(int paramInt)
  {
    this.mRequestQueue.remove(findRequestByReqId(paramInt));
  }
  
  private void sendRequest(CGIRequest paramCGIRequest)
  {
    Object localObject = paramCGIRequest.playbackParam.context();
    TVKUserInfo localTVKUserInfo = paramCGIRequest.playbackParam.userInfo();
    TVKPlayerVideoInfo localTVKPlayerVideoInfo = paramCGIRequest.playbackParam.videoInfo();
    String str = paramCGIRequest.requestInfo.definition();
    int i = paramCGIRequest.requestInfo.formatId();
    if (localTVKPlayerVideoInfo.getPlayType() == 2)
    {
      localObject = new TVKVodInfoGetter((Context)localObject);
      ((ITVKVodInfoGetter)localObject).setOnInfoGetListener(this.mRequestCallback);
      i = ((ITVKVodInfoGetter)localObject).getPlayInfo(localTVKUserInfo, localTVKPlayerVideoInfo, str, i, 0);
    }
    for (;;)
    {
      paramCGIRequest.reqId = i;
      paramCGIRequest.reqState = 1;
      dumpRequest(paramCGIRequest);
      this.mRequestQueue.add(paramCGIRequest);
      return;
      if (localTVKPlayerVideoInfo.getPlayType() == 8)
      {
        localObject = new TVKVodInfoGetter((Context)localObject);
        ((ITVKVodInfoGetter)localObject).setOnInfoGetListener(this.mRequestCallback);
        i = ((ITVKVodInfoGetter)localObject).getPlayInfo(localTVKUserInfo, localTVKPlayerVideoInfo, str, i, 0);
      }
      else if (localTVKPlayerVideoInfo.getPlayType() == 1)
      {
        localObject = TVKLiveInfoGetter.create((Context)localObject);
        ((ITVKLiveInfoGetter)localObject).setOnGetLiveInfoListener(this.mRequestCallback);
        i = ((ITVKLiveInfoGetter)localObject).getLiveInfo(localTVKUserInfo, localTVKPlayerVideoInfo, str, i, isHwDolbyDSSupported());
      }
      else
      {
        i = -1;
      }
    }
  }
  
  public void request(int paramInt, @NonNull TVKPlaybackParam paramTVKPlaybackParam, @NonNull TVKPlaybackInfo paramTVKPlaybackInfo)
  {
    try
    {
      paramTVKPlaybackParam = buildRequest(paramInt, paramTVKPlaybackParam, paramTVKPlaybackInfo);
      markAllRequestCanceled();
      sendRequest(paramTVKPlaybackParam);
      return;
    }
    finally
    {
      paramTVKPlaybackParam = finally;
      throw paramTVKPlaybackParam;
    }
  }
  
  public void reset()
  {
    try
    {
      markAllRequestCanceled();
      this.mRequestQueue.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  class CGICallbackHandler
    extends Handler
  {
    CGICallbackHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
    }
  }
  
  class CGICombineCallback
    implements ITVKLiveInfoGetter.OnGetLiveInfoListener, ITVKVodInfoGetter.ITVKVodInfoGetterCallback
  {
    private CGICombineCallback() {}
    
    private void handleOnFailure(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
    {
      TVKPlayerWrapperCGIModel.CGIRequest localCGIRequest = TVKPlayerWrapperCGIModel.this.findRequestByReqId(paramInt1);
      if (processVideoInfoIsRequestExpired(localCGIRequest))
      {
        TVKPlayerWrapperCGIModel.this.removeRequestByReqId(paramInt1);
        return;
      }
      localCGIRequest.reqState = 3;
      TVKPlayerWrapperCGIModel.this.removeRequestByReqId(paramInt1);
      TVKPlayerWrapperCGIModel.this.mCallback.onGetVodInfoFailed(localCGIRequest.reqType, localCGIRequest.requestInfo, paramInt2, paramString1, paramInt3, paramString2);
    }
    
    private void handleOnGetLiveInfoFailed(int paramInt, TVKLiveVideoInfo paramTVKLiveVideoInfo)
    {
      TVKPlayerWrapperCGIModel.CGIRequest localCGIRequest = TVKPlayerWrapperCGIModel.this.findRequestByReqId(paramInt);
      if (processVideoInfoIsRequestExpired(localCGIRequest))
      {
        TVKPlayerWrapperCGIModel.this.removeRequestByReqId(paramInt);
        return;
      }
      localCGIRequest.reqState = 3;
      TVKPlayerWrapperCGIModel.this.removeRequestByReqId(paramInt);
      TVKPlayerWrapperCGIModel.this.mCallback.onGetLiveInfoFailed(localCGIRequest.reqType, localCGIRequest.requestInfo, paramTVKLiveVideoInfo);
    }
    
    private void handleOnGetLiveInfoSucceed(int paramInt, TVKLiveVideoInfo paramTVKLiveVideoInfo)
    {
      TVKPlayerWrapperCGIModel.CGIRequest localCGIRequest = TVKPlayerWrapperCGIModel.this.findRequestByReqId(paramInt);
      if (processVideoInfoIsRequestExpired(localCGIRequest))
      {
        TVKPlayerWrapperCGIModel.this.removeRequestByReqId(paramInt);
        return;
      }
      localCGIRequest.reqState = 3;
      TVKPlayerWrapperCGIModel.this.removeRequestByReqId(paramInt);
      TVKPlayerWrapperCGIModel.this.mCallback.onGetLiveInfoSuccess(localCGIRequest.reqType, localCGIRequest.requestInfo, paramTVKLiveVideoInfo);
    }
    
    private void handleOnSuccess(int paramInt, TVKVideoInfo paramTVKVideoInfo)
    {
      TVKPlayerWrapperCGIModel.CGIRequest localCGIRequest = TVKPlayerWrapperCGIModel.this.findRequestByReqId(paramInt);
      if (processVideoInfoIsRequestExpired(localCGIRequest))
      {
        TVKPlayerWrapperCGIModel.this.removeRequestByReqId(paramInt);
        return;
      }
      localCGIRequest.reqState = 3;
      TVKPlayerWrapperCGIModel.this.removeRequestByReqId(paramInt);
      if (processVideoInfoIsNeedReRequestVideoInfo(localCGIRequest, paramTVKVideoInfo))
      {
        localCGIRequest.playbackInfo.requestInfo().h265Enable(false);
        TVKPlayerWrapperCGIModel.this.request(localCGIRequest.reqType, localCGIRequest.playbackParam, localCGIRequest.playbackInfo);
        return;
      }
      TVKPlayerWrapperCGIModel.this.mCallback.onGetVodInfoSuccess(localCGIRequest.reqType, localCGIRequest.requestInfo, paramTVKVideoInfo);
    }
    
    private boolean processVideoInfoIsHEVCNotSupported(TVKPlayerWrapperCGIModel.CGIRequest paramCGIRequest, TVKNetVideoInfo paramTVKNetVideoInfo)
    {
      if (!paramTVKNetVideoInfo.isHevc()) {}
      while ((paramTVKNetVideoInfo.getCurDefinition() == null) || (TextUtils.isEmpty(paramTVKNetVideoInfo.getCurDefinition().getDefn())) || (paramCGIRequest.playbackParam.videoInfo().getPlayType() != 2)) {
        return false;
      }
      int j = TVKUtils.optInt(paramCGIRequest.playbackParam.videoInfo().getConfigMapValue("sysplayer_hevc_cap", ""), 0);
      int i;
      if (j == 1)
      {
        i = 28;
        if (TVKPlayerUtils.getDefnHevcLevel(paramTVKNetVideoInfo.getCurDefinition().getDefn(), i) > 0) {
          break label107;
        }
      }
      label107:
      for (boolean bool = true;; bool = false)
      {
        return bool;
        i = j;
        if (j != 2) {
          break;
        }
        i = 33;
        break;
      }
    }
    
    private boolean processVideoInfoIsNeedReRequestVideoInfo(TVKPlayerWrapperCGIModel.CGIRequest paramCGIRequest, TVKNetVideoInfo paramTVKNetVideoInfo)
    {
      if (TVKPlayerWrapperCGIModel.this.hasRemainingOnGoingRequest())
      {
        TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", "CGI : video info success , has remaining request , no need re request.");
        return false;
      }
      if (processVideoInfoIsHEVCNotSupported(paramCGIRequest, paramTVKNetVideoInfo))
      {
        TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", "CGI : video info success , h265 level higher than system , re request h264");
        return true;
      }
      TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", "CGI : video info success , and no need re request new.");
      return false;
    }
    
    private boolean processVideoInfoIsRequestExpired(TVKPlayerWrapperCGIModel.CGIRequest paramCGIRequest)
    {
      if (paramCGIRequest == null) {}
      while (paramCGIRequest.reqState == 2) {
        return true;
      }
      return false;
    }
    
    public void onFailure(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
    {
      TVKPlayerWrapperCGIModel.this.mHandler.post(new TVKPlayerWrapperCGIModel.CGICombineCallback.1(this, paramInt1, paramInt2, paramString1, paramInt3, paramString2));
    }
    
    public void onGetLiveInfoFailed(int paramInt, TVKLiveVideoInfo paramTVKLiveVideoInfo)
    {
      TVKPlayerWrapperCGIModel.this.mHandler.post(new TVKPlayerWrapperCGIModel.CGICombineCallback.4(this, paramInt, paramTVKLiveVideoInfo));
    }
    
    public void onGetLiveInfoSucceed(int paramInt, TVKLiveVideoInfo paramTVKLiveVideoInfo)
    {
      TVKPlayerWrapperCGIModel.this.mHandler.post(new TVKPlayerWrapperCGIModel.CGICombineCallback.3(this, paramInt, paramTVKLiveVideoInfo));
    }
    
    public void onSuccess(int paramInt, TVKVideoInfo paramTVKVideoInfo)
    {
      TVKPlayerWrapperCGIModel.this.mHandler.post(new TVKPlayerWrapperCGIModel.CGICombineCallback.2(this, paramInt, paramTVKVideoInfo));
    }
  }
  
  static class CGIRequest
  {
    TVKPlaybackInfo playbackInfo;
    TVKPlaybackParam playbackParam;
    int reqId;
    int reqState;
    int reqType;
    TVKPlaybackInfo.RequestInfo requestInfo;
    long startTimeMs;
  }
  
  public static abstract interface CGIWrapperCallback
  {
    public abstract void onGetLiveInfoFailed(int paramInt, TVKPlaybackInfo.RequestInfo paramRequestInfo, TVKLiveVideoInfo paramTVKLiveVideoInfo);
    
    public abstract void onGetLiveInfoSuccess(int paramInt, TVKPlaybackInfo.RequestInfo paramRequestInfo, TVKLiveVideoInfo paramTVKLiveVideoInfo);
    
    public abstract void onGetVodInfoFailed(int paramInt1, TVKPlaybackInfo.RequestInfo paramRequestInfo, int paramInt2, String paramString1, int paramInt3, String paramString2);
    
    public abstract void onGetVodInfoSuccess(int paramInt, TVKPlaybackInfo.RequestInfo paramRequestInfo, TVKVideoInfo paramTVKVideoInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.TVKPlayerWrapperCGIModel
 * JD-Core Version:    0.7.0.1
 */