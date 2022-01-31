import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.filemanager.core.QfavFilePreviewController;
import cooperation.qqfav.ipc.FavoritesRemoteCommand.IRemoteCommandHandler;

public class dqx
  implements FavoritesRemoteCommand.IRemoteCommandHandler
{
  public dqx(QfavFilePreviewController paramQfavFilePreviewController) {}
  
  public boolean a(int paramInt, Bundle paramBundle)
  {
    new Handler(Looper.getMainLooper()).post(new dqy(this, paramBundle));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dqx
 * JD-Core Version:    0.7.0.1
 */