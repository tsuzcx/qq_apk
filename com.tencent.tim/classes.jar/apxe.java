import android.graphics.Bitmap;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController.5;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController.5.2.1;

public class apxe
  implements URLDrawable.DownloadListener
{
  public apxe(TroopGiftAnimationController.5 param5, URLDrawable paramURLDrawable) {}
  
  public void onFileDownloadFailed(int paramInt) {}
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    if (this.a.this$0.c == null) {
      return;
    }
    Bitmap localBitmap = apuh.f(this.g);
    this.a.this$0.c.al(new TroopGiftAnimationController.5.2.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apxe
 * JD-Core Version:    0.7.0.1
 */