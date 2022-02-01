import android.graphics.Bitmap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IEventListener;", "", "onCaptureImageFailed", "", "player", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayer;", "id", "", "errCode", "onCaptureImageSucceed", "width", "height", "bitmap", "Landroid/graphics/Bitmap;", "onCompletion", "onDownloadCallback", "info", "", "onError", "", "module", "errorType", "errorCode", "extraInfo", "onInfo", "what", "extra", "onSeekComplete", "onVideoPrepared", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface nbl
{
  public abstract void a(@NotNull nbm paramnbm);
  
  public abstract void a(@NotNull nbm paramnbm, int paramInt1, int paramInt2);
  
  public abstract void a(@NotNull nbm paramnbm, int paramInt1, int paramInt2, int paramInt3, @Nullable Bitmap paramBitmap);
  
  public abstract boolean a(@NotNull nbm paramnbm, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString);
  
  public abstract boolean a(@NotNull nbm paramnbm, int paramInt, @Nullable Object paramObject);
  
  public abstract void b(@NotNull nbm paramnbm);
  
  public abstract void c(@NotNull nbm paramnbm);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nbl
 * JD-Core Version:    0.7.0.1
 */