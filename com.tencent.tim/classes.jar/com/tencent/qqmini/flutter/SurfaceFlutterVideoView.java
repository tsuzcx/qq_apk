package com.tencent.qqmini.flutter;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.qflutter.video.IQflutterVideoView;
import com.qflutter.video.IQflutterVideoView.StatusCallBack;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.proxy.VideoPlayerProviderProxy;
import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Map;
import org.json.JSONObject;

public class SurfaceFlutterVideoView
  extends TextureView
  implements TextureView.SurfaceTextureListener, IQflutterVideoView
{
  private static final String TAG = "QFV";
  private boolean autoPlay = false;
  private IQflutterVideoView.StatusCallBack callBack;
  private String currentPath;
  private String data;
  private final ReliableVideoPlayer player;
  private final VideoPlayerProviderProxy videoPlayerProviderProxy;
  
  public SurfaceFlutterVideoView(Context paramContext, Map<String, Object> paramMap)
  {
    super(paramContext);
    setSurfaceTextureListener(this);
    this.videoPlayerProviderProxy = ((VideoPlayerProviderProxy)ProxyManager.get(VideoPlayerProviderProxy.class));
    this.player = this.videoPlayerProviderProxy.getVideoPlayer();
    this.player.setLooping(true);
    this.data = ("" + paramMap.get("data"));
    updateVideoSrc(paramMap.get("videoUrl") + "");
    this.player.setOnCompletionListener(new SurfaceFlutterVideoView.1(this));
    this.player.setOnBufferingUpdateListener(new SurfaceFlutterVideoView.2(this));
    this.player.setOnErrorListener(new SurfaceFlutterVideoView.3(this));
    this.player.setOnPreparedListener(new SurfaceFlutterVideoView.4(this));
  }
  
  private void updateVideoSrc(String paramString)
  {
    String str;
    if ((!StringUtil.isEmpty(paramString)) && (!paramString.equals(this.currentPath)))
    {
      this.currentPath = paramString;
      if (!paramString.startsWith("http"))
      {
        str = paramString;
        if (!paramString.startsWith("https")) {}
      }
      else
      {
        str = this.videoPlayerProviderProxy.getUrl(MiniAppFileManager.getInstance().getAbsolutePath(paramString));
      }
      QMLog.d("QFV", "handleOperateXWebVideo playUrl : " + str);
    }
    try
    {
      this.player.reset();
      this.player.setDataSource(str);
      this.player.prepareAsync();
      return;
    }
    catch (Throwable paramString)
    {
      QMLog.e("QFV", "", paramString);
    }
  }
  
  public void onStatus(IQflutterVideoView.StatusCallBack paramStatusCallBack)
  {
    QMLog.e("QFVideoView", "on setCallback");
    this.callBack = paramStatusCallBack;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    QMLog.e("QFV", "surface onSurfaceTextureAvailable");
    this.player.setSurface(new Surface(paramSurfaceTexture));
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    QMLog.e("QFV", "surface onSurfaceTextureDestroyed");
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    QMLog.e("QFV", "surface onSurfaceTextureSizeChanged");
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void operate(Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      QMLog.e("QFVideoView", "operate null map");
    }
    QMLog.e("QFVideoView", "operate" + paramMap.toString());
    String str = "" + paramMap.get("type");
    try
    {
      if ("play".equals(str))
      {
        this.player.start();
        return;
      }
      if ("pause".equals(str))
      {
        this.player.pause();
        return;
      }
    }
    catch (Throwable paramMap)
    {
      QMLog.e("QFV", "", paramMap);
      return;
    }
    if ("stop".equals(str))
    {
      this.player.stop();
      return;
    }
    boolean bool = "seek".equals(str);
    if (bool) {
      try
      {
        int i = (int)(new JSONObject(paramMap).optDouble("time") * 1000.0D);
        this.player.seekTo(i);
        return;
      }
      catch (Exception localException)
      {
        QMLog.e("QFV", "wrong seek pram. " + paramMap, localException);
        return;
      }
    }
    if ("playbackRate".equals(localException))
    {
      QMLog.e("QFV", "playbackRate is not support.");
      return;
    }
    if ((!"requestFullScreen".equals(localException)) && (!"exitFullScreen".equals(localException)))
    {
      bool = "sendDanmu".equals(localException);
      if (!bool) {}
    }
  }
  
  public void update(Map<String, Object> paramMap)
  {
    JSONObject localJSONObject = new JSONObject(paramMap);
    QMLog.e("QFVideoView", "update" + paramMap.toString());
    if (!localJSONObject.optBoolean("hide")) {
      setVisibility(0);
    }
    paramMap = localJSONObject.optString("src");
    this.autoPlay = localJSONObject.optBoolean("autoplay", false);
    updateVideoSrc(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.flutter.SurfaceFlutterVideoView
 * JD-Core Version:    0.7.0.1
 */