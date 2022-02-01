import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.TextureView;
import com.tencent.biz.subscribe.videoplayer.VideoFrameCheckHelper.1;
import mqq.util.WeakReference;

public class zks
{
  private long jdField_a_of_type_Long;
  private volatile Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final Handler b;
  
  private void a(TextureView paramTextureView, zkt paramzkt)
  {
    paramzkt = new WeakReference(paramzkt);
    paramTextureView = new WeakReference(paramTextureView);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoFrameCheckHelper.1(this, paramzkt, paramTextureView), 40L);
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
        if (!wmy.a(this.jdField_a_of_type_AndroidGraphicsBitmap, 4, 16)) {
          break;
        }
        xvv.b("VideoFrameCheckHelper", "isCurrentFrameBlack CheckVideoViewRealStartRunnable find dark bitmap ! current = %d");
        return true;
      }
      xvv.d("VideoFrameCheckHelper", "isCurrentFrameBlack StoryPlayerTest.isBlack false. treat as not-black frame");
    }
    catch (Exception paramTextureView)
    {
      paramTextureView.printStackTrace();
      return false;
    }
    return false;
    label152:
    xvv.d("VideoFrameCheckHelper", "isCurrentFrameBlack targetView.isAvailable() false. treat as not-black frame");
    label159:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zks
 * JD-Core Version:    0.7.0.1
 */