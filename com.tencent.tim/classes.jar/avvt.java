import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

public class avvt
  implements DialogInterface.OnClickListener
{
  public avvt(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin, int paramInt1, int paramInt2, int paramInt3) {}
  
  @TargetApi(9)
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = BaseApplication.getContext().getSharedPreferences("share", 0);
    if (Build.VERSION.SDK_INT >= 9) {
      paramDialogInterface.edit().putBoolean("qzone_bg_music_auto_play_warn_flag", false).apply();
    }
    for (;;)
    {
      QzoneWebMusicJsPlugin.access$400(this.this$0, this.eyO, this.eyP, this.eyQ);
      return;
      paramDialogInterface.edit().putBoolean("qzone_bg_music_auto_play_warn_flag", false).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avvt
 * JD-Core Version:    0.7.0.1
 */