import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.qquserguide.UserguideVideoFragment;
import com.tencent.qphone.base.util.QLog;

public class esh
  implements MediaPlayer.OnErrorListener
{
  public esh(UserguideVideoFragment paramUserguideVideoFragment) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    this.a.jdField_a_of_type_Int = 0;
    if (QLog.isDevelopLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 4, "fight........onError....extra .== ..........." + paramInt2);
    }
    this.a.a().finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     esh
 * JD-Core Version:    0.7.0.1
 */