import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

public class icv
  implements DialogInterface.OnClickListener
{
  public icv(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.resumePlay();
    QzoneWebMusicJsPlugin.access$002(this.a, true);
    paramDialogInterface.dismiss();
    QzoneWebMusicJsPlugin.access$302(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     icv
 * JD-Core Version:    0.7.0.1
 */