import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

public class avvv
  implements DialogInterface.OnClickListener
{
  public avvv(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.this$0.resumePlay();
    LocalMultiProcConfig.putBool("qzbg_music_mobinet_tips", true);
    paramDialogInterface.dismiss();
    QzoneWebMusicJsPlugin.access$902(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avvv
 * JD-Core Version:    0.7.0.1
 */