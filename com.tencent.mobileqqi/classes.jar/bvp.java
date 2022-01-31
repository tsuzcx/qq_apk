import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.common.app.BaseApplicationImpl;

public class bvp
  implements MediaPlayer.OnCompletionListener
{
  public bvp(BaseApplicationImpl paramBaseApplicationImpl, MediaPlayer.OnCompletionListener paramOnCompletionListener) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.b == 0)
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener != null) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener.onCompletion(paramMediaPlayer);
      }
      return;
    }
    paramMediaPlayer = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
    paramMediaPlayer.b -= 1;
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bvp
 * JD-Core Version:    0.7.0.1
 */