import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.TextureView;
import com.tencent.biz.subscribe.videoplayer.VideoFrameCheckHelper.1;
import mqq.util.WeakReference;

public class sht
{
  private final Handler bi;
  private long hH;
  private volatile Bitmap mCurrentFrameBitmap;
  private final Handler mMainHandler;
  
  private void a(TextureView paramTextureView, sht.a parama)
  {
    parama = new WeakReference(parama);
    paramTextureView = new WeakReference(paramTextureView);
    this.bi.postDelayed(new VideoFrameCheckHelper.1(this, parama, paramTextureView), 40L);
  }
  
  private boolean a(TextureView paramTextureView)
  {
    try
    {
      if (!paramTextureView.isAvailable()) {
        break label152;
      }
      if ((this.mCurrentFrameBitmap != null) && (!this.mCurrentFrameBitmap.isRecycled()))
      {
        this.mCurrentFrameBitmap.recycle();
        this.mCurrentFrameBitmap = null;
      }
      int i = paramTextureView.getWidth() / 16;
      int j = paramTextureView.getHeight() / 16;
      if ((i <= 0) || (j <= 0)) {
        break label159;
      }
      if (Build.VERSION.SDK_INT >= 17) {}
      for (this.mCurrentFrameBitmap = Bitmap.createBitmap(paramTextureView.getResources().getDisplayMetrics(), i, j, Bitmap.Config.ARGB_8888);; this.mCurrentFrameBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888))
      {
        this.mCurrentFrameBitmap = paramTextureView.getBitmap(this.mCurrentFrameBitmap);
        if (!qgk.a(this.mCurrentFrameBitmap, 4, 16)) {
          break;
        }
        ram.d("VideoFrameCheckHelper", "isCurrentFrameBlack CheckVideoViewRealStartRunnable find dark bitmap ! current = %d");
        return true;
      }
      ram.w("VideoFrameCheckHelper", "isCurrentFrameBlack StoryPlayerTest.isBlack false. treat as not-black frame");
    }
    catch (Exception paramTextureView)
    {
      paramTextureView.printStackTrace();
      return false;
    }
    return false;
    label152:
    ram.w("VideoFrameCheckHelper", "isCurrentFrameBlack targetView.isAvailable() false. treat as not-black frame");
    label159:
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void uE(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sht
 * JD-Core Version:    0.7.0.1
 */