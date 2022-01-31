import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;

class vnz
  implements DialogInterface.OnClickListener
{
  vnz(vny paramvny) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    AIOImageListScene.j(this.a.a).setResult(8001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vnz
 * JD-Core Version:    0.7.0.1
 */