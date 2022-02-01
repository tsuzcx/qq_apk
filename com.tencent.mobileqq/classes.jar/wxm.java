import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;

class wxm
  implements MediaPlayer.OnBufferingUpdateListener
{
  wxm(wxj paramwxj, wxa paramwxa) {}
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    this.jdField_a_of_type_Wxa.a(this.jdField_a_of_type_Wxj, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wxm
 * JD-Core Version:    0.7.0.1
 */