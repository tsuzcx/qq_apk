import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

public class ics
  implements DialogInterface.OnClickListener
{
  public ics(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin, String[] paramArrayOfString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QzoneWebMusicJsPlugin.access$002(this.jdField_a_of_type_CooperationQzoneMusicQzoneWebMusicJsPlugin, true);
    this.jdField_a_of_type_CooperationQzoneMusicQzoneWebMusicJsPlugin.playMusicList(this.jdField_a_of_type_ArrayOfJavaLangString[0]);
    QzoneWebMusicJsPlugin.access$102(this.jdField_a_of_type_CooperationQzoneMusicQzoneWebMusicJsPlugin, false);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ics
 * JD-Core Version:    0.7.0.1
 */