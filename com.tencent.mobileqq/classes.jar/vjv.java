import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.WatermarkVideoRunnable;

public class vjv
  implements DialogInterface.OnKeyListener
{
  public vjv(AIOGalleryScene paramAIOGalleryScene) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.a.o = true;
      AIOGalleryScene.a(this.a).dismiss();
      if (AIOGalleryScene.a(this.a) != null) {
        AIOGalleryScene.a(this.a).a();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vjv
 * JD-Core Version:    0.7.0.1
 */