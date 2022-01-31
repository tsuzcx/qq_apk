import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;

public class vky
  implements DialogInterface.OnDismissListener
{
  public vky(AIOImageListScene paramAIOImageListScene) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AIOImageListScene.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vky
 * JD-Core Version:    0.7.0.1
 */