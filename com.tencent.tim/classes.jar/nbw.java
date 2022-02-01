import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.superplayer.api.SuperPlayerFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/superplayer/SuperPlayerFactory;", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerFactory;", "()V", "createMediaPlayer", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayer;", "videoView", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IVideoView;", "createPlayerVideoView", "context", "Landroid/content/Context;", "isUseTextureView", "", "createPreloader", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerPreloader;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class nbw
  implements nbn
{
  public static final nbw a = new nbw();
  
  @NotNull
  public nbm a(@Nullable nbr paramnbr)
  {
    if (allf.isSDKReady()) {
      return (nbm)new nbv(SuperPlayerFactory.createMediaPlayer((Context)BaseApplicationImpl.getContext(), 104, null));
    }
    return (nbm)new nbv(null);
  }
  
  @NotNull
  public nbo a()
  {
    if (allf.isSDKReady()) {
      return (nbo)new nbx(SuperPlayerFactory.createPreDownloader((Context)BaseApplicationImpl.getContext(), 104));
    }
    return (nbo)new nbx(null);
  }
  
  @NotNull
  public nbr a(@NotNull Context paramContext, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (allf.isSDKReady()) {
      return (nbr)new nbz(SuperPlayerFactory.createPlayerVideoView(paramContext));
    }
    return (nbr)new nbz(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nbw
 * JD-Core Version:    0.7.0.1
 */