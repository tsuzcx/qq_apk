import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IVideoView;", "", "doCacheSurfaceTexture", "", "doRecoverSurfaceTexture", "getOriginView", "Landroid/view/View;", "setFixedSize", "videoWidth", "", "videoHeight", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface nbr
{
  @Nullable
  public abstract View am();
  
  public abstract void doCacheSurfaceTexture();
  
  public abstract void doRecoverSurfaceTexture();
  
  public abstract void setFixedSize(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nbr
 * JD-Core Version:    0.7.0.1
 */