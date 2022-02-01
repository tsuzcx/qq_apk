import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.ISPlayerPreDownloader.Listener;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/superplayer/SuperPlayerPreloader;", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerPreloader;", "Lcom/tencent/superplayer/api/ISPlayerPreDownloader$Listener;", "preloader", "Lcom/tencent/superplayer/api/ISPlayerPreDownloader;", "(Lcom/tencent/superplayer/api/ISPlayerPreDownloader;)V", "listener", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerPreloader$Listener;", "destory", "", "isVideoCached", "", "videoInfo", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/PlayerVideoInfo;", "onInfo", "p0", "p1", "", "p2", "p3", "", "onPrepareDownloadProgressUpdate", "p4", "p5", "", "onPrepareError", "onPrepareSuccess", "setPreDownloadListener", "startPreDownload", "videoDurationMs", "preloadDurationMs", "stopPreDownload", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class nbx
  implements ISPlayerPreDownloader.Listener, nbo
{
  private final ISPlayerPreDownloader jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
  private nbo.b jdField_a_of_type_Nbo$b;
  
  public nbx(@Nullable ISPlayerPreDownloader paramISPlayerPreDownloader)
  {
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader = paramISPlayerPreDownloader;
  }
  
  public int a(@NotNull nbt paramnbt)
  {
    Intrinsics.checkParameterIsNotNull(paramnbt, "videoInfo");
    return 0;
  }
  
  public void a(@Nullable nbo.b paramb)
  {
    this.jdField_a_of_type_Nbo$b = paramb;
    paramb = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
    if (paramb != null) {
      paramb.setOnPreDownloadListener((ISPlayerPreDownloader.Listener)this);
    }
  }
  
  public void a(@NotNull nbt paramnbt, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramnbt, "videoInfo");
    ISPlayerPreDownloader localISPlayerPreDownloader = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
    if (localISPlayerPreDownloader != null) {
      localISPlayerPreDownloader.startPreDownload(nbu.a(paramnbt), paramLong1, paramLong2);
    }
  }
  
  public void aTZ()
  {
    ISPlayerPreDownloader localISPlayerPreDownloader = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
    if (localISPlayerPreDownloader != null) {
      localISPlayerPreDownloader.stopAllPreDownload();
    }
  }
  
  public void destory()
  {
    ISPlayerPreDownloader localISPlayerPreDownloader = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
    if (localISPlayerPreDownloader != null) {
      localISPlayerPreDownloader.destory();
    }
  }
  
  public void onInfo(int paramInt, long paramLong1, long paramLong2, @Nullable Object paramObject)
  {
    throw ((Throwable)new NotImplementedError("An operation is not implemented: " + "Not yet implemented"));
  }
  
  public void onPrepareDownloadProgressUpdate(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, @Nullable String paramString)
  {
    throw ((Throwable)new NotImplementedError("An operation is not implemented: " + "Not yet implemented"));
  }
  
  public void onPrepareError(int paramInt)
  {
    nbo.b localb = this.jdField_a_of_type_Nbo$b;
    if (localb != null) {
      localb.aUa();
    }
  }
  
  public void onPrepareSuccess(int paramInt)
  {
    nbo.b localb = this.jdField_a_of_type_Nbo$b;
    if (localb != null) {
      localb.aUb();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nbx
 * JD-Core Version:    0.7.0.1
 */