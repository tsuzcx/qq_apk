import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.takevideo.EditVideoMusic;
import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog;

public class vre
  implements DialogInterface.OnClickListener
{
  public vre(EditVideoMusicDialog paramEditVideoMusicDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.g();
    paramDialogInterface.dismiss();
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vre
 * JD-Core Version:    0.7.0.1
 */