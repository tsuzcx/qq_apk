import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.TextureView;
import android.view.View;
import com.tencent.biz.subscribe.videoplayer.VideoFrameCheckHelper.1;

public class wtq
{
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private final String jdField_a_of_type_JavaLangString = "VideoFrameCheckHelper";
  
  private void a(TextureView paramTextureView, wtr paramwtr)
  {
    a().postDelayed(new VideoFrameCheckHelper.1(this, paramTextureView, paramwtr), 20L);
  }
  
  private boolean a(TextureView paramTextureView)
  {
    boolean bool2 = false;
    if (paramTextureView.isAvailable())
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      int i = paramTextureView.getWidth() / 16;
      int j = paramTextureView.getHeight() / 16;
      boolean bool1 = bool2;
      if (i > 0)
      {
        bool1 = bool2;
        if (j > 0) {
          if (Build.VERSION.SDK_INT < 17) {
            break label126;
          }
        }
      }
      label126:
      for (this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramTextureView.getResources().getDisplayMetrics(), i, j, Bitmap.Config.ARGB_8888);; this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888))
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = paramTextureView.getBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        if (!tvg.a(this.jdField_a_of_type_AndroidGraphicsBitmap, 4, 16)) {
          break;
        }
        ved.b("VideoFrameCheckHelper", "isCurrentFrameBlack CheckVideoViewRealStartRunnable find dark bitmap ! current = %d");
        bool1 = true;
        return bool1;
      }
      ved.d("VideoFrameCheckHelper", "isCurrentFrameBlack StoryPlayerTest.isBlack false. treat as not-black frame");
      return false;
    }
    ved.d("VideoFrameCheckHelper", "isCurrentFrameBlack targetView.isAvailable() false. treat as not-black frame");
    return false;
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    ved.d("VideoFrameCheckHelper", "release");
  }
  
  public void a(View paramView, wtr paramwtr)
  {
    if ((paramView == null) || (paramwtr == null)) {}
    do
    {
      return;
      paramView = tvg.a(paramView);
    } while (paramView == null);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a(paramView, paramwtr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wtq
 * JD-Core Version:    0.7.0.1
 */