import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.takevideo.EditVideoMusic;
import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog;

public class yxe
  implements DialogInterface.OnClickListener
{
  public yxe(EditVideoMusicDialog paramEditVideoMusicDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.h();
    paramDialogInterface.dismiss();
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yxe
 * JD-Core Version:    0.7.0.1
 */