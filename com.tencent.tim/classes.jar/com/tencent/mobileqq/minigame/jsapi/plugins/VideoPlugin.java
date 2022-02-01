package com.tencent.mobileqq.minigame.jsapi.plugins;

import android.app.Activity;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import aqmr;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPlugin;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.util.ColorUtil;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.CoverView;
import com.tencent.mobileqq.mini.widget.media.CoverVideoView;
import com.tencent.mobileqq.minigame.jsapi.manager.GameVideoPlayerManager;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.minigame.utils.GameLog;
import java.lang.ref.WeakReference;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class VideoPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_INSERT_VIDEO_PLAYER = "insertVideoPlayer";
  public static final String EVENT_OPERATE_VIDEO_PLAYER = "operateVideoPlayer";
  public static final String EVENT_REMOVE_VIDEOPLAYER = "removeVideoPlayer";
  public static final String EVENT_UPDATE_VIDEO_PLAYER = "updateVideoPlayer";
  private static final Set<String> S_EVENT_MAP = new VideoPlugin.1();
  private static final String TAG = "VideoPlugin";
  private float density;
  private SparseArray<CoverView> mCoverViewSparseArray = new SparseArray();
  
  private void insertVideoPlayer(Activity paramActivity, JsRuntime paramJsRuntime, int paramInt, JSONObject paramJSONObject)
  {
    GameLog.getInstance().i("VideoPlugin", "insertVideoPlayer: " + paramJSONObject);
    Object localObject = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if (localObject == null)
    {
      localObject = new CoverVideoView(paramActivity);
      ((CoverVideoView)localObject).setAtyRef(new WeakReference(paramActivity));
      ((CoverVideoView)localObject).setData(paramJSONObject.optString("data"));
      ((CoverVideoView)localObject).setServiceWebview(paramJsRuntime);
      ((CoverVideoView)localObject).setVideoPlayerId(paramInt);
      ((CoverVideoView)localObject).setParentId(paramInt);
      this.mCoverViewSparseArray.put(paramInt, localObject);
      GameVideoPlayerManager.getInstance().addPlayerView((ViewGroup)localObject);
    }
    for (paramActivity = (Activity)localObject;; paramActivity = (Activity)localObject)
    {
      if ((paramActivity instanceof CoverVideoView))
      {
        ((CoverVideoView)paramActivity).initVideoPlayerSettings(paramJSONObject);
        if (paramJSONObject.optBoolean("hide")) {
          ((CoverVideoView)paramActivity).setVisibility(8);
        }
      }
      return;
    }
  }
  
  private void removeCoverChildView(int paramInt)
  {
    int i = 0;
    if (i < this.mCoverViewSparseArray.size())
    {
      int j = this.mCoverViewSparseArray.keyAt(i);
      CoverView localCoverView1 = (CoverView)this.mCoverViewSparseArray.get(j);
      if ((localCoverView1 != null) && (localCoverView1.getParentId() == paramInt))
      {
        if (localCoverView1.getParentId() != 0) {
          break label72;
        }
        GameVideoPlayerManager.getInstance().removeView(localCoverView1);
      }
      for (;;)
      {
        i += 1;
        break;
        label72:
        CoverView localCoverView2 = (CoverView)this.mCoverViewSparseArray.get(localCoverView1.getParentId());
        if (localCoverView2 != null) {
          localCoverView2.removeView(localCoverView1);
        }
      }
    }
  }
  
  private void removeVideoPlayer(int paramInt)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if (!(localCoverView instanceof CoverVideoView)) {
      return;
    }
    removeCoverChildView(paramInt);
    GameVideoPlayerManager.getInstance().removeView(localCoverView);
  }
  
  private void updateVideoPlayer(int paramInt, JSONObject paramJSONObject)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if ((localCoverView instanceof CoverVideoView))
    {
      ((CoverVideoView)localCoverView).updateVideoPlayerSettings(paramJSONObject);
      if (!paramJSONObject.optBoolean("hide")) {
        ((CoverVideoView)localCoverView).setVisibility(0);
      }
      paramJSONObject = paramJSONObject.optString("src");
      if (!aqmr.isEmpty(paramJSONObject)) {
        ((CoverVideoView)localCoverView).setVideoPath(paramJSONObject);
      }
    }
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    GameLog.getInstance().i("VideoPlugin", "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt);
    if (!(this.jsPluginEngine.getActivityContext() instanceof GameActivity))
    {
      QLog.e("VideoPlugin", 1, "handleNativeRequest activity not GameActivity");
      return "{}";
    }
    GameActivity localGameActivity = (GameActivity)this.jsPluginEngine.getActivityContext();
    if (this.density <= 0.0F) {
      this.density = DisplayUtil.getDensity(localGameActivity);
    }
    if ("insertVideoPlayer".equals(paramString1)) {}
    for (;;)
    {
      int i;
      JSONObject localJSONObject;
      try
      {
        paramString2 = new JSONObject(paramString2);
        i = paramString2.optInt("videoPlayerId");
        localJSONObject = new JSONObject();
        localJSONObject.put("containerId", i);
        localGameActivity.runOnUiThread(new VideoPlugin.2(this, localGameActivity, paramJsRuntime, i, paramString2, paramString1, localJSONObject, paramInt));
        return "{}";
      }
      catch (Throwable paramString2)
      {
        GameLog.getInstance().e("VideoPlugin", paramString1 + " error.", paramString2);
        continue;
      }
      if ("updateVideoPlayer".equals(paramString1)) {
        try
        {
          paramString2 = new JSONObject(paramString2);
          localGameActivity.runOnUiThread(new VideoPlugin.3(this, paramString2.optInt("videoPlayerId"), paramString2, paramJsRuntime, paramString1, paramInt));
        }
        catch (Throwable paramString2)
        {
          GameLog.getInstance().e("VideoPlugin", paramString1 + " error.", paramString2);
        }
      } else if ("operateVideoPlayer".equals(paramString1)) {
        try
        {
          localJSONObject = new JSONObject(paramString2);
          String str = localJSONObject.optString("type");
          localGameActivity.runOnUiThread(new VideoPlugin.4(this, paramJsRuntime, localJSONObject.optInt("videoPlayerId"), str, paramString2, paramString1, paramInt));
        }
        catch (Throwable paramString2)
        {
          GameLog.getInstance().e("VideoPlugin", paramString1 + " error.", paramString2);
        }
      } else if ("removeVideoPlayer".equals(paramString1)) {
        try
        {
          i = new JSONObject(paramString2).optInt("videoPlayerId");
          paramString2 = (CoverView)this.mCoverViewSparseArray.get(i);
          if ((paramString2 instanceof CoverVideoView))
          {
            ((CoverVideoView)paramString2).pauseWithUi();
            ((CoverVideoView)paramString2).stop();
            ((CoverVideoView)paramString2).release();
          }
          localGameActivity.runOnUiThread(new VideoPlugin.5(this, i, paramJsRuntime, paramString1, paramInt));
        }
        catch (Throwable paramString2)
        {
          GameLog.getInstance().e("VideoPlugin", paramString1 + " error.", paramString2);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.mCoverViewSparseArray.size())
        {
          CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.valueAt(i);
          if (!(localCoverView instanceof CoverVideoView)) {
            continue;
          }
          ((CoverVideoView)localCoverView).stop();
          ((CoverVideoView)localCoverView).release();
          continue;
        }
        this.mCoverViewSparseArray.clear();
      }
      catch (Throwable localThrowable)
      {
        GameLog.getInstance().e("VideoPlugin", "onDestroy error.", localThrowable);
        continue;
        i += 1;
      }
      super.onDestroy();
      return;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    int i = 0;
    while (i < this.mCoverViewSparseArray.size())
    {
      int j = this.mCoverViewSparseArray.keyAt(i);
      CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(j);
      if ((localCoverView instanceof CoverVideoView)) {
        ((CoverVideoView)localCoverView).pauseWithUi();
      }
      i += 1;
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public boolean operateVideoPlayer(JsRuntime paramJsRuntime, int paramInt, String paramString1, String paramString2)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if (!(localCoverView instanceof CoverVideoView)) {}
    do
    {
      return false;
      if ("play".equals(paramString1))
      {
        ((CoverVideoView)localCoverView).playWithUi();
        return true;
      }
      if ("pause".equals(paramString1))
      {
        ((CoverVideoView)localCoverView).pauseWithUi();
        return true;
      }
      if ("stop".equals(paramString1))
      {
        ((CoverVideoView)localCoverView).stop();
        return true;
      }
      if (("seek".equals(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
        try
        {
          paramInt = (int)(new JSONObject(paramString2).optDouble("time") * 1000.0D);
          bool = ((CoverVideoView)localCoverView).seekTo(paramInt);
          return bool;
        }
        catch (Exception paramJsRuntime)
        {
          for (;;)
          {
            GameLog.getInstance().e("VideoPlugin", "wrong seek pram. " + paramString2, paramJsRuntime);
            boolean bool = false;
          }
        }
      }
      if (("playbackRate".equals(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        GameLog.getInstance().e("VideoPlugin", "playbackRate is not support.");
        return true;
      }
      if ("requestFullScreen".equals(paramString1))
      {
        if (!((CoverVideoView)localCoverView).isFullScreen()) {
          ((CoverVideoView)localCoverView).fullScreen();
        }
        return true;
      }
      if ("exitFullScreen".equals(paramString1))
      {
        if (((CoverVideoView)localCoverView).isFullScreen()) {
          ((CoverVideoView)localCoverView).smallScreen();
        }
        return true;
      }
    } while (!"sendDanmu".equals(paramString1));
    for (;;)
    {
      try
      {
        paramString1 = new JSONArray(paramString2);
        if (paramString1.length() == 2)
        {
          paramJsRuntime = paramString1.getString(0);
          paramInt = ColorUtil.parseColor(paramString1.getString(1));
          ((CoverVideoView)localCoverView).playDanmu(paramJsRuntime, paramInt);
          return true;
        }
        if (paramString1.length() == 1)
        {
          paramJsRuntime = paramString1.getString(0);
          paramInt = 0;
          continue;
        }
        paramJsRuntime = null;
      }
      catch (Exception paramJsRuntime)
      {
        GameLog.getInstance().e("VideoPlugin", "sendDanmu error.", paramJsRuntime);
        return false;
      }
      paramInt = 0;
    }
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.VideoPlugin
 * JD-Core Version:    0.7.0.1
 */