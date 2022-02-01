import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerPreloader;", "", "destory", "", "isVideoCached", "", "videoInfo", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/PlayerVideoInfo;", "setPreDownloadListener", "listener", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerPreloader$Listener;", "startPreDownload", "videoDurationMs", "", "preloadDurationMs", "stopPreDownload", "Companion", "Listener", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface nbo
{
  public static final nbo.a a = nbo.a.b;
  
  public abstract int a(@NotNull nbt paramnbt);
  
  public abstract void a(@Nullable nbo.b paramb);
  
  public abstract void a(@NotNull nbt paramnbt, long paramLong1, long paramLong2);
  
  public abstract void aTZ();
  
  public abstract void destory();
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerPreloader$Companion;", "", "()V", "PLAYER_VIDEO_FULL_CACHED", "", "PLAYER_VIDEO_NO_CACHED", "PLAYER_VIDEO_PARTIAL_CACHED", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class a {}
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerPreloader$Listener;", "", "onPreloadFailed", "", "onPreloadSuccess", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static abstract interface b
  {
    public abstract void aUa();
    
    public abstract void aUb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nbo
 * JD-Core Version:    0.7.0.1
 */