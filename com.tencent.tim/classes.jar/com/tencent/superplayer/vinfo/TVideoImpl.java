package com.tencent.superplayer.vinfo;

import android.content.Context;
import android.os.Looper;
import com.tencent.qqlive.tvkplayer.playerwrapper.player.TVKMediaSource;
import com.tencent.qqlive.tvkplayer.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKNetVideoInfo.DefnInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlaybackInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlaybackInfo.RequestInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlaybackParam;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlayerWrapperCGIModel;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlayerWrapperCGIModel.CGIWrapperCallback;
import com.tencent.qqlive.tvkplayer.vinfo.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKVideoInfo;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.api.TVideoNetInfo.DefinitionInfo;
import com.tencent.superplayer.utils.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;

class TVideoImpl
{
  public static final String TAG = TVideoImpl.class.getSimpleName();
  private Context mContext;
  private VInfoGetter.VInfoGetterListener mListener;
  private TVKPlayerWrapperCGIModel mWrapperCGI;
  private TVKPlayerCGICallback mWrapperCGICallback;
  
  TVideoImpl(Context paramContext, Looper paramLooper)
  {
    this.mContext = paramContext;
    this.mWrapperCGICallback = new TVKPlayerCGICallback(null);
    this.mWrapperCGI = new TVKPlayerWrapperCGIModel(paramLooper, this.mWrapperCGICallback);
  }
  
  void doGetVInfo(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    Object localObject1 = VInfoCacheMgr.getVInfoFromCache(paramSuperPlayerVideoInfo);
    if ((localObject1 != null) && (this.mListener != null))
    {
      this.mListener.onGetVInfoSuccess((SuperPlayerVideoInfo)localObject1);
      return;
    }
    int i;
    Object localObject2;
    switch (paramSuperPlayerVideoInfo.getVideoType())
    {
    default: 
      LogUtil.e(TAG, "doGetVInfo() playerVideoInfo.getVideoType() is ERROR = " + paramSuperPlayerVideoInfo.getVideoType());
      return;
    case 1: 
      i = 2;
      localObject2 = new TVKPlayerVideoInfo(i, paramSuperPlayerVideoInfo.getVid(), paramSuperPlayerVideoInfo.getPid());
      ((TVKPlayerVideoInfo)localObject2).setPid(paramSuperPlayerVideoInfo.getPid());
      ((TVKPlayerVideoInfo)localObject2).setPlatform(paramSuperPlayerVideoInfo.getBusiPlatform());
      localObject1 = new TVKPlaybackParam();
      ((TVKPlaybackParam)localObject1).context(this.mContext);
      TVKUserInfo localTVKUserInfo = new TVKUserInfo();
      localTVKUserInfo.setLoginCookie(paramSuperPlayerVideoInfo.getTVideoLoginCookie());
      ((TVKPlaybackParam)localObject1).userInfo(localTVKUserInfo);
      ((TVKPlaybackParam)localObject1).videoInfo((TVKPlayerVideoInfo)localObject2);
      ((TVKPlaybackParam)localObject1).definition(paramSuperPlayerVideoInfo.getRequestDefinition());
      ((TVKPlaybackParam)localObject1).mediaSource(new TVKMediaSource((TVKPlayerVideoInfo)localObject2));
      localObject2 = new TVKPlaybackInfo();
      ((TVKPlaybackInfo)localObject2).requestInfo().flowId(((TVKPlaybackParam)localObject1).flowId());
      ((TVKPlaybackInfo)localObject2).requestInfo().definition(((TVKPlaybackParam)localObject1).definition());
      if (paramSuperPlayerVideoInfo.getVideoType() == 1) {
        ((TVKPlaybackInfo)localObject2).requestInfo().formatId(0);
      }
      break;
    }
    for (;;)
    {
      ((TVKPlaybackInfo)localObject2).requestInfo().tag(paramSuperPlayerVideoInfo);
      this.mWrapperCGI.request(0, (TVKPlaybackParam)localObject1, (TVKPlaybackInfo)localObject2);
      return;
      i = 1;
      break;
      ((TVKPlaybackInfo)localObject2).requestInfo().formatId(2);
    }
  }
  
  void setListener(VInfoGetter.VInfoGetterListener paramVInfoGetterListener)
  {
    this.mListener = paramVInfoGetterListener;
  }
  
  class TVKPlayerCGICallback
    implements TVKPlayerWrapperCGIModel.CGIWrapperCallback
  {
    private TVKPlayerCGICallback() {}
    
    public void onGetLiveInfoFailed(int paramInt, TVKPlaybackInfo.RequestInfo paramRequestInfo, TVKLiveVideoInfo paramTVKLiveVideoInfo)
    {
      if (TVideoImpl.this.mListener != null) {
        TVideoImpl.this.mListener.onGetVInfoFailed((SuperPlayerVideoInfo)paramRequestInfo.tag(), 5002, 32000002, paramTVKLiveVideoInfo.getErrInfo());
      }
    }
    
    public void onGetLiveInfoSuccess(int paramInt, TVKPlaybackInfo.RequestInfo paramRequestInfo, TVKLiveVideoInfo paramTVKLiveVideoInfo)
    {
      if (paramTVKLiveVideoInfo == null)
      {
        LogUtil.e(TVideoImpl.TAG, "onGetLiveInfoSuccess() reqType " + paramInt + ", liveInfo == null");
        return;
      }
      paramRequestInfo = (SuperPlayerVideoInfo)paramRequestInfo.tag();
      int i = 403;
      if (paramTVKLiveVideoInfo.getStream() == 2) {
        i = 401;
      }
      TVideoNetInfo localTVideoNetInfo;
      ArrayList localArrayList;
      for (;;)
      {
        paramRequestInfo.setPlayUrl(paramTVKLiveVideoInfo.getPlayUrl());
        paramRequestInfo.setFormat(i);
        localTVideoNetInfo = new TVideoNetInfo();
        localArrayList = new ArrayList();
        if (paramTVKLiveVideoInfo.getDefinitionList() == null) {
          break;
        }
        Iterator localIterator = paramTVKLiveVideoInfo.getDefinitionList().iterator();
        while (localIterator.hasNext())
        {
          TVKNetVideoInfo.DefnInfo localDefnInfo = (TVKNetVideoInfo.DefnInfo)localIterator.next();
          localArrayList.add(new TVideoNetInfo.DefinitionInfo(localDefnInfo.getDefn(), localDefnInfo.getDefnName(), localDefnInfo.getDefnRate(), localDefnInfo.getDefnShowName()));
        }
        if (paramTVKLiveVideoInfo.getStream() == 1) {
          i = 402;
        }
      }
      LogUtil.e(TVideoImpl.TAG, "onGetLiveInfoSuccess() reqType:" + paramInt + "  liveInfo.getDefinitionList() == null");
      localTVideoNetInfo.setDefinitionList(localArrayList);
      if (paramTVKLiveVideoInfo.getCurDefinition() != null) {
        localTVideoNetInfo.setCurrentDefinition(new TVideoNetInfo.DefinitionInfo(paramTVKLiveVideoInfo.getCurDefinition().getDefn(), paramTVKLiveVideoInfo.getCurDefinition().getDefnName(), paramTVKLiveVideoInfo.getCurDefinition().getDefnRate(), paramTVKLiveVideoInfo.getCurDefinition().getDefnShowName()));
      }
      localTVideoNetInfo.setUpdateTimeMillis(System.currentTimeMillis());
      if ((paramTVKLiveVideoInfo.getWatermarkInfos() == null) || (paramTVKLiveVideoInfo.getWatermarkInfos().size() == 0)) {}
      for (boolean bool = true;; bool = false)
      {
        localTVideoNetInfo.setHasWatermark(bool);
        paramRequestInfo.setTVideoNetInfo(localTVideoNetInfo);
        VInfoCacheMgr.saveVInfoToCache(paramRequestInfo);
        if (TVideoImpl.this.mListener == null) {
          break;
        }
        TVideoImpl.this.mListener.onGetVInfoSuccess(paramRequestInfo);
        return;
      }
    }
    
    public void onGetVodInfoFailed(int paramInt1, TVKPlaybackInfo.RequestInfo paramRequestInfo, int paramInt2, String paramString1, int paramInt3, String paramString2)
    {
      if (TVideoImpl.this.mListener != null)
      {
        if (paramInt2 != 101) {
          break label45;
        }
        paramInt1 = 5000;
      }
      for (;;)
      {
        TVideoImpl.this.mListener.onGetVInfoFailed((SuperPlayerVideoInfo)paramRequestInfo.tag(), paramInt1, paramInt3, paramString1);
        return;
        label45:
        paramInt1 = paramInt2;
        if (paramInt2 == 103) {
          paramInt1 = 5001;
        }
      }
    }
    
    public void onGetVodInfoSuccess(int paramInt, TVKPlaybackInfo.RequestInfo paramRequestInfo, TVKVideoInfo paramTVKVideoInfo)
    {
      paramRequestInfo = (SuperPlayerVideoInfo)paramRequestInfo.tag();
      if ((paramTVKVideoInfo.getDownloadType() == 4) || (paramTVKVideoInfo.getDownloadType() == 5))
      {
        paramRequestInfo.setFormat(303);
        paramRequestInfo.setTVideoSectionList(paramTVKVideoInfo.getSectionList());
      }
      TVideoNetInfo localTVideoNetInfo;
      ArrayList localArrayList;
      for (;;)
      {
        paramRequestInfo.setVideoDurationMs(paramTVKVideoInfo.getDuration() * 1000);
        localTVideoNetInfo = new TVideoNetInfo();
        localTVideoNetInfo.setVideoDuration(paramTVKVideoInfo.getDuration() * 1000);
        localTVideoNetInfo.setVideoSize(paramTVKVideoInfo.getFileSize());
        localArrayList = new ArrayList();
        if (paramTVKVideoInfo.getDefinitionList() == null) {
          break;
        }
        Iterator localIterator = paramTVKVideoInfo.getDefinitionList().iterator();
        while (localIterator.hasNext())
        {
          TVKNetVideoInfo.DefnInfo localDefnInfo = (TVKNetVideoInfo.DefnInfo)localIterator.next();
          localArrayList.add(new TVideoNetInfo.DefinitionInfo(localDefnInfo.getDefn(), localDefnInfo.getDefnName(), localDefnInfo.getDefnRate(), localDefnInfo.getDefnShowName()));
        }
        if (paramTVKVideoInfo.getDownloadType() == 1)
        {
          paramRequestInfo.setFormat(301);
          paramRequestInfo.setPlayUrl(paramTVKVideoInfo.getPlayUrl());
        }
        else if (paramTVKVideoInfo.getDownloadType() == 3)
        {
          paramRequestInfo.setFormat(302);
          paramRequestInfo.setPlayUrl(paramTVKVideoInfo.getPlayUrl());
        }
        else
        {
          paramRequestInfo.setFormat(304);
          paramRequestInfo.setPlayUrl(paramTVKVideoInfo.getPlayUrl());
        }
      }
      LogUtil.e(TVideoImpl.TAG, "onGetVodInfoSuccess() reqType:" + paramInt + "  liveInfo.getDefinitionList() == null");
      localTVideoNetInfo.setDefinitionList(localArrayList);
      if (paramTVKVideoInfo.getCurDefinition() != null) {
        localTVideoNetInfo.setCurrentDefinition(new TVideoNetInfo.DefinitionInfo(paramTVKVideoInfo.getCurDefinition().getDefn(), paramTVKVideoInfo.getCurDefinition().getDefnName(), paramTVKVideoInfo.getCurDefinition().getDefnRate(), paramTVKVideoInfo.getCurDefinition().getDefnShowName()));
      }
      localTVideoNetInfo.setUpdateTimeMillis(System.currentTimeMillis());
      if ((paramTVKVideoInfo.getWatermarkInfos() == null) || (paramTVKVideoInfo.getWatermarkInfos().size() == 0)) {}
      for (boolean bool = true;; bool = false)
      {
        localTVideoNetInfo.setHasWatermark(bool);
        paramRequestInfo.setTVideoNetInfo(localTVideoNetInfo);
        VInfoCacheMgr.saveVInfoToCache(paramRequestInfo);
        if (TVideoImpl.this.mListener != null) {
          TVideoImpl.this.mListener.onGetVInfoSuccess(paramRequestInfo);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.vinfo.TVideoImpl
 * JD-Core Version:    0.7.0.1
 */