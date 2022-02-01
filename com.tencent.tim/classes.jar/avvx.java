import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import cooperation.qzone.music.QzoneWebMusicJsPlugin.a;

public class avvx
  implements DialogInterface.OnClickListener
{
  public avvx(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin, QzoneWebMusicJsPlugin.a parama) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    LocalMultiProcConfig.putBool("qzbg_music_mobinet_tips", true);
    if (this.a != null) {
      this.a.onConfirm();
    }
    paramDialogInterface.dismiss();
    this.this$0.isFlowWarningVisible = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avvx
 * JD-Core Version:    0.7.0.1
 */