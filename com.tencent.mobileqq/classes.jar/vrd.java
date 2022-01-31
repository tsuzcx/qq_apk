import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog;

public class vrd
  implements DialogInterface.OnClickListener
{
  public vrd(EditVideoMusicDialog paramEditVideoMusicDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vrd
 * JD-Core Version:    0.7.0.1
 */