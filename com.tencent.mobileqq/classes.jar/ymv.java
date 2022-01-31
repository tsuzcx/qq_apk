import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.TextureView;
import android.view.View;
import com.tencent.biz.subscribe.videoplayer.VideoFrameCheckHelper.1;
import mqq.util.WeakReference;

public class ymv
{
  private long jdField_a_of_type_Long;
  private volatile Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("VideoFrameCheckHelper");
  private final String jdField_a_of_type_JavaLangString = "VideoFrameCheckHelper";
  private final Handler b;
  
  public ymv()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.b = new Handler(Looper.getMainLooper());
  }
  
  private void a(TextureView paramTextureView, ymw paramymw)
  {
    paramymw = new WeakReference(paramymw);
    paramTextureView = new WeakReference(paramTextureView);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoFrameCheckHelper.1(this, paramymw, paramTextureView), 40L);
  }
  
  private boolean a(TextureView paramTextureView)
  {
    try
    {
      if (!paramTextureView.isAvailable()) {
        break label152;
      }
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      int i = paramTextureView.getWidth() / 16;
      int j = paramTextureView.getHeight() / 16;
      if ((i <= 0) || (j <= 0)) {
        break label159;
      }
      if (Build.VERSION.SDK_INT >= 17) {}
      for (this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramTextureView.getResources().getDisplayMetrics(), i, j, Bitmap.Config.ARGB_8888);; this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888))
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = paramTextureView.getBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        if (!voh.a(this.jdField_a_of_type_AndroidGraphicsBitmap, 4, 16)) {
          break;
        }
        wxe.b("VideoFrameCheckHelper", "isCurrentFrameBlack CheckVideoViewRealStartRunnable find dark bitmap ! current = %d");
        return true;
      }
      wxe.d("VideoFrameCheckHelper", "isCurrentFrameBlack StoryPlayerTest.isBlack false. treat as not-black frame");
    }
    catch (Exception paramTextureView)
    {
      paramTextureView.printStackTrace();
      return false;
    }
    return false;
    label152:
    wxe.d("VideoFrameCheckHelper", "isCurrentFrameBlack targetView.isAvailable() false. treat as not-black frame");
    label159:
    return false;
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
      this.b.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      wxe.d("VideoFrameCheckHelper", "release");
      return;
    }
    finally {}
  }
  
  public void a(View paramView, ymw paramymw)
  {
    if ((paramView == null) || (paramymw == null)) {}
    do
    {
      return;
      paramView = voh.a(paramView);
    } while (paramView == null);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a(paramView, paramymw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ymv
 * JD-Core Version:    0.7.0.1
 */