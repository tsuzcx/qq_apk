import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;

public class eci
  implements DialogInterface.OnDismissListener
{
  public eci(AIOImageListScene paramAIOImageListScene) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AIOImageListScene.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eci
 * JD-Core Version:    0.7.0.1
 */