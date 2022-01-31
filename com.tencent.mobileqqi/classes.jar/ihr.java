import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

public class ihr
  implements DialogInterface.OnClickListener
{
  public ihr(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.stopPlay();
    QzoneWebMusicJsPlugin.access$200(this.a, "cancel");
    paramDialogInterface.dismiss();
    QzoneWebMusicJsPlugin.access$302(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ihr
 * JD-Core Version:    0.7.0.1
 */