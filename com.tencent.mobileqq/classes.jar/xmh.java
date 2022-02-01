import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;

class xmh
  implements MediaPlayer.OnBufferingUpdateListener
{
  xmh(xme paramxme, xlv paramxlv) {}
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    this.jdField_a_of_type_Xlv.a(this.jdField_a_of_type_Xme, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xmh
 * JD-Core Version:    0.7.0.1
 */