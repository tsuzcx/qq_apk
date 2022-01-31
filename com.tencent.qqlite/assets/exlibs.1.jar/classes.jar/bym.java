import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;

public class bym
  implements DialogInterface.OnDismissListener
{
  public bym(AIOImageListScene paramAIOImageListScene) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AIOImageListScene.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bym
 * JD-Core Version:    0.7.0.1
 */