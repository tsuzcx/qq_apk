import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;

class ufu
  implements MediaPlayer.OnBufferingUpdateListener
{
  ufu(ufr paramufr, ufi paramufi) {}
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    this.jdField_a_of_type_Ufi.a(this.jdField_a_of_type_Ufr, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ufu
 * JD-Core Version:    0.7.0.1
 */