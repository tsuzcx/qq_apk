import android.graphics.Bitmap;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/nearby/now/view/QQVideoViewImpl$setVideoPath$param$1$1", "Lcom/tencent/mobileqq/videoplatform/api/VideoPlayerCallback;", "onCapFrame", "", "p0", "", "p1", "", "p2", "", "p3", "p4", "Landroid/graphics/Bitmap;", "onDownloadComplete", "onDownloadProgress", "onFirstFrameRendered", "onLoopBack", "onPlayError", "id", "module", "errorType", "errorCode", "exInfo", "", "onPlayProgress", "onStateChange", "state", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ajye
  implements VideoPlayerCallback
{
  ajye(ajyd paramajyd, String paramString1, String paramString2, long paramLong) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, @Nullable Bitmap paramBitmap) {}
  
  public void onDownloadComplete(long paramLong) {}
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong) {}
  
  public void onLoopBack(long paramLong1, long paramLong2) {}
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString)
  {
    ajzp.c localc = ajyd.a(this.a);
    if (localc != null) {
      localc.a((ajzp)this.a, 0, 0, 0, paramString, null);
    }
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2) {}
  
  public void onStateChange(long paramLong, int paramInt)
  {
    switch (paramInt)
    {
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = ajyd.a(this.a);
      } while (localObject == null);
      ((ajzp.e)localObject).b((ajzp)this.a);
      return;
      localObject = ajyd.a(this.a);
    } while (localObject == null);
    ((ajzp.a)localObject).a((ajzp)this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajye
 * JD-Core Version:    0.7.0.1
 */