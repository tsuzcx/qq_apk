import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import dov.com.qq.im.ae.play.AETakeFacePhotoPreviewFragment;
import dov.com.qq.im.ae.play.AEVideoShelfEditFragment;

public class axhd
  implements DialogInterface.OnDismissListener
{
  public axhd(AETakeFacePhotoPreviewFragment paramAETakeFacePhotoPreviewFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AETakeFacePhotoPreviewFragment.a(this.a);
    AEVideoShelfEditFragment.ad(this.a.getActivity(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axhd
 * JD-Core Version:    0.7.0.1
 */