import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

public class avvz
  implements DialogInterface.OnClickListener
{
  public avvz(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.this$0.isFlowWarningVisible = false;
    QzoneWebMusicJsPlugin.access$300(this.this$0, "cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avvz
 * JD-Core Version:    0.7.0.1
 */