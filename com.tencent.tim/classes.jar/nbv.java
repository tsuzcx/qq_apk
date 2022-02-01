import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.view.ISPlayerVideoView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/superplayer/SuperPlayer;", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayer;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnVideoPreparedListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnCompletionListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnErrorListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnInfoListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnCaptureImageListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnSeekCompleteListener;", "videoPlayer", "Lcom/tencent/superplayer/api/ISuperPlayer;", "(Lcom/tencent/superplayer/api/ISuperPlayer;)V", "currentPositionMs", "", "getCurrentPositionMs", "()J", "currentVideoView", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IVideoView;", "durationMs", "getDurationMs", "value", "", "isLoopBack", "()Z", "setLoopBack", "(Z)V", "isPauseing", "isPlaying", "listener", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IEventListener;", "outputMute", "getOutputMute", "setOutputMute", "", "speedRatio", "getSpeedRatio", "()F", "setSpeedRatio", "(F)V", "videoHeight", "", "getVideoHeight", "()I", "videoWidth", "getVideoWidth", "getStreamDumpInfo", "", "onCaptureImageFailed", "", "p0", "id", "errorCode", "onCaptureImageSucceed", "width", "height", "bitmap", "Landroid/graphics/Bitmap;", "onCompletion", "onError", "tvkPlayer", "module", "errorType", "extraInfo", "onInfo", "what", "arg1", "arg2", "extra", "", "onSeekComplete", "onVideoPrepared", "openMediaPlayer", "context", "Landroid/content/Context;", "videoInfo", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/PlayerVideoInfo;", "startPositionMilsec", "playerOption", "Lcom/tencent/superplayer/api/SuperPlayerOption;", "pause", "pauseDownload", "prePlayViewShow", "release", "resumeDownload", "seekTo", "positionMilsec", "mode", "setEventListener", "setHttpBufferRange", "emergencyTime", "safePlayTime", "preloadDuration", "setLoopback", "isLoopback", "setXYaxis", "type", "start", "stop", "updatePlayerVideoView", "videoView", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class nbv
  implements ISuperPlayer.OnCaptureImageListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnVideoPreparedListener, nbm
{
  private nbl a;
  private final ISuperPlayer b;
  private nbr c;
  private float kf;
  
  public nbv(@Nullable ISuperPlayer paramISuperPlayer)
  {
    this.b = paramISuperPlayer;
    this.kf = 1.0F;
  }
  
  public void S(int paramInt1, int paramInt2, int paramInt3)
  {
    ISuperPlayer localISuperPlayer = this.b;
    if (localISuperPlayer != null) {
      localISuperPlayer.setBusinessDownloadStrategy(paramInt1, paramInt2, paramInt3, paramInt3);
    }
  }
  
  public void a(@NotNull Context paramContext, @NotNull nbt paramnbt, long paramLong, @NotNull SuperPlayerOption paramSuperPlayerOption)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramnbt, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramSuperPlayerOption, "playerOption");
    ISuperPlayer localISuperPlayer = this.b;
    if (localISuperPlayer != null) {
      localISuperPlayer.openMediaPlayer(paramContext.getApplicationContext(), nbu.a(paramnbt), paramLong, paramSuperPlayerOption);
    }
  }
  
  public void a(@Nullable nbl paramnbl)
  {
    this.a = paramnbl;
    paramnbl = this.b;
    if (paramnbl != null) {
      paramnbl.setOnVideoPreparedListener((ISuperPlayer.OnVideoPreparedListener)this);
    }
    paramnbl = this.b;
    if (paramnbl != null) {
      paramnbl.setOnCompletionListener((ISuperPlayer.OnCompletionListener)this);
    }
    paramnbl = this.b;
    if (paramnbl != null) {
      paramnbl.setOnErrorListener((ISuperPlayer.OnErrorListener)this);
    }
    paramnbl = this.b;
    if (paramnbl != null) {
      paramnbl.setOnInfoListener((ISuperPlayer.OnInfoListener)this);
    }
    paramnbl = this.b;
    if (paramnbl != null) {
      paramnbl.setOnCaptureImageListener((ISuperPlayer.OnCaptureImageListener)this);
    }
    paramnbl = this.b;
    if (paramnbl != null) {
      paramnbl.setOnSeekCompleteListener((ISuperPlayer.OnSeekCompleteListener)this);
    }
  }
  
  public void aTR()
  {
    ISuperPlayer localISuperPlayer = this.b;
    if (localISuperPlayer != null) {
      localISuperPlayer.onPrePlayViewShow();
    }
  }
  
  public void b(@Nullable nbr paramnbr)
  {
    this.c = paramnbr;
    ISuperPlayer localISuperPlayer = this.b;
    if (localISuperPlayer != null) {
      if (paramnbr == null) {
        break label47;
      }
    }
    label47:
    for (paramnbr = paramnbr.am();; paramnbr = null)
    {
      nbr localnbr = paramnbr;
      if (!(paramnbr instanceof ISPlayerVideoView)) {
        localnbr = null;
      }
      localISuperPlayer.updatePlayerVideoView((ISPlayerVideoView)localnbr);
      return;
    }
  }
  
  public long getCurrentPositionMs()
  {
    ISuperPlayer localISuperPlayer = this.b;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getCurrentPositionMs();
    }
    return 0L;
  }
  
  public long getDurationMs()
  {
    ISuperPlayer localISuperPlayer = this.b;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getDurationMs();
    }
    return 0L;
  }
  
  public boolean getOutputMute()
  {
    ISuperPlayer localISuperPlayer = this.b;
    return (localISuperPlayer != null) && (localISuperPlayer.isOutputMute() == true);
  }
  
  @Nullable
  public String getStreamDumpInfo()
  {
    ISuperPlayer localISuperPlayer = this.b;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getStreamDumpInfo();
    }
    return null;
  }
  
  public int getVideoHeight()
  {
    ISuperPlayer localISuperPlayer = this.b;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getVideoHeight();
    }
    return 0;
  }
  
  public int getVideoWidth()
  {
    ISuperPlayer localISuperPlayer = this.b;
    if (localISuperPlayer != null) {
      return localISuperPlayer.getVideoWidth();
    }
    return 0;
  }
  
  public void onCaptureImageFailed(@Nullable ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2)
  {
    paramISuperPlayer = this.a;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.a((nbm)this, paramInt1, paramInt2);
    }
  }
  
  public void onCaptureImageSucceed(@Nullable ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, @Nullable Bitmap paramBitmap)
  {
    paramISuperPlayer = this.a;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.a((nbm)this, paramInt1, paramInt2, paramInt3, paramBitmap);
    }
  }
  
  public void onCompletion(@Nullable ISuperPlayer paramISuperPlayer)
  {
    paramISuperPlayer = this.a;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.b((nbm)this);
    }
  }
  
  public boolean onError(@Nullable ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString)
  {
    paramISuperPlayer = this.a;
    return (paramISuperPlayer != null) && (paramISuperPlayer.a((nbm)this, paramInt1, paramInt2, paramInt3, paramString) == true);
  }
  
  public boolean onInfo(@Nullable ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, @Nullable Object paramObject)
  {
    int i = paramInt;
    switch (paramInt)
    {
    default: 
      i = paramInt;
    }
    for (;;)
    {
      paramISuperPlayer = this.a;
      if ((paramISuperPlayer == null) || (paramISuperPlayer.a((nbm)this, i, paramObject) != true)) {
        break;
      }
      return true;
      i = 112;
      continue;
      i = 113;
      continue;
      i = 105;
      continue;
      i = 108;
    }
    return false;
  }
  
  public void onSeekComplete(@Nullable ISuperPlayer paramISuperPlayer)
  {
    paramISuperPlayer = this.a;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.c((nbm)this);
    }
  }
  
  public void onVideoPrepared(@Nullable ISuperPlayer paramISuperPlayer)
  {
    paramISuperPlayer = this.a;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.a((nbm)this);
    }
  }
  
  public void pause()
  {
    ISuperPlayer localISuperPlayer = this.b;
    if (localISuperPlayer != null) {
      localISuperPlayer.pause();
    }
  }
  
  public void pauseDownload()
  {
    ISuperPlayer localISuperPlayer = this.b;
    if (localISuperPlayer != null) {
      localISuperPlayer.pauseDownload();
    }
  }
  
  public void release()
  {
    ISuperPlayer localISuperPlayer = this.b;
    if (localISuperPlayer != null) {
      localISuperPlayer.release();
    }
  }
  
  public void resumeDownload()
  {
    ISuperPlayer localISuperPlayer = this.b;
    if (localISuperPlayer != null) {
      localISuperPlayer.resumeDownload();
    }
  }
  
  public void seekTo(int paramInt1, int paramInt2)
  {
    int j = 1;
    int i = j;
    switch (paramInt2)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      ISuperPlayer localISuperPlayer = this.b;
      if (localISuperPlayer != null) {
        localISuperPlayer.seekTo(paramInt1, i);
      }
      return;
      i = 3;
      continue;
      i = 2;
    }
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    ISuperPlayer localISuperPlayer = this.b;
    if (localISuperPlayer != null) {
      localISuperPlayer.setLoopback(paramBoolean);
    }
  }
  
  public void setOutputMute(boolean paramBoolean)
  {
    ISuperPlayer localISuperPlayer = this.b;
    if (localISuperPlayer != null) {
      localISuperPlayer.setOutputMute(paramBoolean);
    }
  }
  
  public void setSpeedRatio(float paramFloat)
  {
    this.kf = paramFloat;
    ISuperPlayer localISuperPlayer = this.b;
    if (localISuperPlayer != null) {
      localISuperPlayer.setPlaySpeedRatio(this.kf);
    }
  }
  
  public void setXYaxis(int paramInt)
  {
    int j = 0;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      ISuperPlayer localISuperPlayer = this.b;
      if (localISuperPlayer != null) {
        localISuperPlayer.setXYaxis(i);
      }
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public void start()
  {
    ISuperPlayer localISuperPlayer = this.b;
    if (localISuperPlayer != null) {
      localISuperPlayer.start();
    }
  }
  
  public void stop()
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((ISuperPlayer)localObject).reset();
    }
    localObject = this.c;
    if (localObject != null)
    {
      ISuperPlayer localISuperPlayer = this.b;
      if (localISuperPlayer != null)
      {
        View localView = ((nbr)localObject).am();
        localObject = localView;
        if (!(localView instanceof ISPlayerVideoView)) {
          localObject = null;
        }
        localISuperPlayer.updatePlayerVideoView((ISPlayerVideoView)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nbv
 * JD-Core Version:    0.7.0.1
 */