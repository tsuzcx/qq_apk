import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.qphone.base.util.QLog;

public class dul
  implements MediaPlayer.OnVideoSizeChangedListener
{
  public dul(FileViewMusicService paramFileViewMusicService, Activity paramActivity) {}
  
  public void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileViewMusicService<FileAssistant>", 2, "invalid video width(" + paramInt1 + ") or height(" + paramInt2 + ")");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileViewMusicService<FileAssistant>", 2, "onVideoSizeChanged width:" + paramInt1 + " height:" + paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(this.jdField_a_of_type_AndroidAppActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dul
 * JD-Core Version:    0.7.0.1
 */