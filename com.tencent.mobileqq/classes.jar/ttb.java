import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;

class ttb
  implements MediaPlayer.OnBufferingUpdateListener
{
  ttb(tsy paramtsy, tsp paramtsp) {}
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    this.jdField_a_of_type_Tsp.a(this.jdField_a_of_type_Tsy, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ttb
 * JD-Core Version:    0.7.0.1
 */