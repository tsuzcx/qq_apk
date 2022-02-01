import android.view.View;
import com.tencent.superplayer.view.ISPlayerVideoView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/superplayer/SuperPlayerVideoView;", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IVideoView;", "videoView", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "(Lcom/tencent/superplayer/view/ISPlayerVideoView;)V", "doCacheSurfaceTexture", "", "doRecoverSurfaceTexture", "getOriginView", "Landroid/view/View;", "setFixedSize", "videoWidth", "", "videoHeight", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class nbz
  implements nbr
{
  private final ISPlayerVideoView a;
  
  public nbz(@Nullable ISPlayerVideoView paramISPlayerVideoView)
  {
    this.a = paramISPlayerVideoView;
  }
  
  @Nullable
  public View am()
  {
    ISPlayerVideoView localISPlayerVideoView2 = this.a;
    ISPlayerVideoView localISPlayerVideoView1 = localISPlayerVideoView2;
    if (!(localISPlayerVideoView2 instanceof View)) {
      localISPlayerVideoView1 = null;
    }
    return (View)localISPlayerVideoView1;
  }
  
  public void doCacheSurfaceTexture()
  {
    ISPlayerVideoView localISPlayerVideoView = this.a;
    if (localISPlayerVideoView != null) {
      localISPlayerVideoView.disableViewCallback();
    }
  }
  
  public void doRecoverSurfaceTexture()
  {
    ISPlayerVideoView localISPlayerVideoView = this.a;
    if (localISPlayerVideoView != null) {
      localISPlayerVideoView.enableViewCallback();
    }
  }
  
  public void setFixedSize(int paramInt1, int paramInt2)
  {
    ISPlayerVideoView localISPlayerVideoView = this.a;
    if (localISPlayerVideoView != null) {
      localISPlayerVideoView.setFixedSize(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nbz
 * JD-Core Version:    0.7.0.1
 */