import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.videoplatform.api.IBaseVideoView;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/nearby/now/view/QQVideoViewImpl;", "Lcom/tencent/mobileqq/nearby/now/view/player/IVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onCompletionListener", "Lcom/tencent/mobileqq/nearby/now/view/player/IVideoView$OnCompletionListener;", "onErrorListener", "Lcom/tencent/mobileqq/nearby/now/view/player/IVideoView$OnErrorListener;", "onPreparedListener", "Lcom/tencent/mobileqq/nearby/now/view/player/IVideoView$OnPreparedListener;", "videoView", "Lcom/tencent/mobileqq/videoplatform/view/BaseVideoView;", "createVideoView", "", "getCurrentPosition", "", "getDuration", "getPlayType", "", "getProgress", "getView", "Landroid/view/View;", "isPlaying", "", "pause", "restart", "seekTo", "pos", "setOnCompletionListener", "listener", "setOnDownloadListener", "Lcom/tencent/mobileqq/nearby/now/view/player/IVideoView$OnDownloadListener;", "setOnErrorListener", "setOnInfoListener", "Lcom/tencent/mobileqq/nearby/now/view/player/IVideoView$OnInfoListener;", "setOnPreparedListener", "setVideoPath", "vid", "", "localPath", "remotePath", "videoTime", "setVisibility", "visibility", "start", "stop", "stopPlayback", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ajyd
  implements ajzp
{
  private ajzp.a jdField_a_of_type_Ajzp$a;
  private ajzp.c jdField_a_of_type_Ajzp$c;
  private ajzp.e jdField_a_of_type_Ajzp$e;
  private BaseVideoView c;
  private final Context context;
  
  public ajyd(@NotNull Context paramContext)
  {
    this.context = paramContext;
    azn();
  }
  
  private final void azn()
  {
    IBaseVideoView localIBaseVideoView = allg.createBaseVideoView(this.context, 0L, null, null);
    if (localIBaseVideoView == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.videoplatform.view.BaseVideoView");
    }
    this.c = ((BaseVideoView)localIBaseVideoView);
  }
  
  public void a(@Nullable ajzp.a parama)
  {
    this.jdField_a_of_type_Ajzp$a = parama;
  }
  
  public void a(@Nullable ajzp.b paramb) {}
  
  public void a(@Nullable ajzp.c paramc)
  {
    this.jdField_a_of_type_Ajzp$c = paramc;
  }
  
  public void a(@Nullable ajzp.d paramd) {}
  
  public void a(@Nullable ajzp.e parame)
  {
    this.jdField_a_of_type_Ajzp$e = parame;
  }
  
  public void a(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, long paramLong)
  {
    boolean bool = false;
    if (this.c == null)
    {
      azn();
      return;
    }
    paramString1 = new VideoPlayParam();
    paramString1.mSceneName = allh.eO(113);
    paramString1.mSceneId = 113;
    if ((paramString2 == null) || (StringsKt.endsWith$default(paramString2, ".mp4", false, 2, null) != true)) {
      paramString1.mUrls = new String[] { paramString3 };
    }
    for (;;)
    {
      paramString1.mIsLocal = bool;
      if (paramLong > 0L) {
        paramString1.mMaxPlayTimeMs = paramLong;
      }
      paramString1.mNeedPlayProgress = true;
      paramString1.mCallback = ((VideoPlayerCallback)new ajye(this, paramString2, paramString3, paramLong));
      paramString2 = this.c;
      if (paramString2 == null) {
        break;
      }
      paramString2.setVideoParam(paramString1);
      start();
      return;
      paramString1.mVideoPath = paramString2;
      bool = true;
    }
  }
  
  public long getCurrentPosition()
  {
    BaseVideoView localBaseVideoView = this.c;
    if (localBaseVideoView != null) {
      return localBaseVideoView.getCurPlayingPos();
    }
    return 0L;
  }
  
  public int getProgress()
  {
    BaseVideoView localBaseVideoView = this.c;
    if (localBaseVideoView != null) {
      return (int)(localBaseVideoView.getCurPlayingPos() * 100 / (localBaseVideoView.getVideoDurationMs() + 0.1D));
    }
    return -1;
  }
  
  @Nullable
  public View getView()
  {
    return (View)this.c;
  }
  
  public boolean isPlaying()
  {
    BaseVideoView localBaseVideoView = this.c;
    if (localBaseVideoView != null) {
      return localBaseVideoView.isPlaying();
    }
    return false;
  }
  
  public void pause()
  {
    BaseVideoView localBaseVideoView = this.c;
    if (localBaseVideoView != null) {
      localBaseVideoView.pause();
    }
  }
  
  public void restart()
  {
    BaseVideoView localBaseVideoView = this.c;
    if (localBaseVideoView != null)
    {
      localBaseVideoView.seekTo(0);
      localBaseVideoView.play();
    }
  }
  
  public void seekTo(long paramLong)
  {
    BaseVideoView localBaseVideoView = this.c;
    if (localBaseVideoView != null) {
      localBaseVideoView.seekTo((int)paramLong);
    }
  }
  
  public void start()
  {
    BaseVideoView localBaseVideoView = this.c;
    if ((localBaseVideoView != null) && (!localBaseVideoView.isPlaying())) {
      localBaseVideoView.play();
    }
  }
  
  public void stopPlayback()
  {
    BaseVideoView localBaseVideoView = this.c;
    if (localBaseVideoView != null)
    {
      localBaseVideoView.releasePlayer(false);
      this.c = ((BaseVideoView)null);
    }
    this.jdField_a_of_type_Ajzp$a = ((ajzp.a)null);
    this.jdField_a_of_type_Ajzp$c = ((ajzp.c)null);
    this.jdField_a_of_type_Ajzp$e = ((ajzp.e)null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajyd
 * JD-Core Version:    0.7.0.1
 */