import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer;

public class ufb
  extends Handler
{
  private ufb(MediaPlayer paramMediaPlayer) {}
  
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
          } while (this.a.jdField_a_of_type_Ufm == null);
          this.a.jdField_a_of_type_Ufm.a_(this.a);
          return;
          Log.d("Story-MediaPlayer", "onSeekComplete");
        } while (this.a.jdField_a_of_type_Ufn == null);
        this.a.jdField_a_of_type_Ufn.a(this.a);
        return;
        Log.d("Story-MediaPlayer", "onPlaybackComplete");
        if (this.a.jdField_a_of_type_Ufj != null) {
          this.a.jdField_a_of_type_Ufj.a(this.a);
        }
        this.a.c(false);
        return;
        Log.d("Story-MediaPlayer", "onVideoSizeChanged");
      } while (this.a.jdField_a_of_type_Ufp == null);
      this.a.jdField_a_of_type_Ufp.a(this.a, paramMessage.arg1, paramMessage.arg2);
      return;
    case 100: 
      Log.e("Story-MediaPlayer", "Error (" + paramMessage.arg1 + "," + paramMessage.arg2 + ")");
      if (this.a.jdField_a_of_type_Ufk == null) {
        break;
      }
    }
    for (boolean bool = this.a.jdField_a_of_type_Ufk.a(this.a, paramMessage.arg1, paramMessage.arg2);; bool = false)
    {
      if ((this.a.jdField_a_of_type_Ufj != null) && (!bool)) {
        this.a.jdField_a_of_type_Ufj.a(this.a);
      }
      this.a.c(false);
      return;
      Log.d("Story-MediaPlayer", "onInfo");
      if (this.a.jdField_a_of_type_Ufl == null) {
        break;
      }
      this.a.jdField_a_of_type_Ufl.a_(this.a, paramMessage.arg1, paramMessage.arg2);
      return;
      if (this.a.jdField_a_of_type_Ufi != null) {
        this.a.jdField_a_of_type_Ufi.a(this.a, paramMessage.arg1);
      }
      this.a.e = paramMessage.arg1;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ufb
 * JD-Core Version:    0.7.0.1
 */