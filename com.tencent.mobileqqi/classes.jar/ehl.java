import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;

public class ehl
  implements DialogInterface.OnDismissListener
{
  public ehl(AIOImageListScene paramAIOImageListScene) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AIOImageListScene.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ehl
 * JD-Core Version:    0.7.0.1
 */