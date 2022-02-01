import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer;

public class xlo
  extends Handler
{
  private xlo(MediaPlayer paramMediaPlayer) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 4: 
    case 2: 
    case 5: 
      do
      {
        do
        {
          do
          {
            return;
            Log.d("Story-MediaPlayer", "onPrepared");
          } while (this.a.jdField_a_of_type_Xlz == null);
          this.a.jdField_a_of_type_Xlz.a_(this.a);
          return;
          Log.d("Story-MediaPlayer", "onSeekComplete");
        } while (this.a.jdField_a_of_type_Xma == null);
        this.a.jdField_a_of_type_Xma.a(this.a);
        return;
        Log.d("Story-MediaPlayer", "onPlaybackComplete");
        if (this.a.jdField_a_of_type_Xlw != null) {
          this.a.jdField_a_of_type_Xlw.a(this.a);
        }
        this.a.c(false);
        return;
        Log.d("Story-MediaPlayer", "onVideoSizeChanged");
      } while (this.a.jdField_a_of_type_Xmc == null);
      this.a.jdField_a_of_type_Xmc.a(this.a, paramMessage.arg1, paramMessage.arg2);
      return;
    case 100: 
      Log.e("Story-MediaPlayer", "Error (" + paramMessage.arg1 + "," + paramMessage.arg2 + ")");
      if (this.a.jdField_a_of_type_Xlx == null) {
        break;
      }
    }
    for (boolean bool = this.a.jdField_a_of_type_Xlx.a(this.a, paramMessage.arg1, paramMessage.arg2);; bool = false)
    {
      if ((this.a.jdField_a_of_type_Xlw != null) && (!bool)) {
        this.a.jdField_a_of_type_Xlw.a(this.a);
      }
      this.a.c(false);
      return;
      Log.d("Story-MediaPlayer", "onInfo");
      if (this.a.jdField_a_of_type_Xly == null) {
        break;
      }
      this.a.jdField_a_of_type_Xly.a_(this.a, paramMessage.arg1, paramMessage.arg2);
      return;
      if (this.a.jdField_a_of_type_Xlv != null) {
        this.a.jdField_a_of_type_Xlv.a(this.a, paramMessage.arg1);
      }
      this.a.e = paramMessage.arg1;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xlo
 * JD-Core Version:    0.7.0.1
 */