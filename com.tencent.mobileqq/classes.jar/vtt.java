import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer;

public class vtt
  extends Handler
{
  private vtt(MediaPlayer paramMediaPlayer) {}
  
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
          } while (this.a.jdField_a_of_type_Vue == null);
          this.a.jdField_a_of_type_Vue.a_(this.a);
          return;
          Log.d("Story-MediaPlayer", "onSeekComplete");
        } while (this.a.jdField_a_of_type_Vuf == null);
        this.a.jdField_a_of_type_Vuf.a(this.a);
        return;
        Log.d("Story-MediaPlayer", "onPlaybackComplete");
        if (this.a.jdField_a_of_type_Vub != null) {
          this.a.jdField_a_of_type_Vub.a(this.a);
        }
        this.a.c(false);
        return;
        Log.d("Story-MediaPlayer", "onVideoSizeChanged");
      } while (this.a.jdField_a_of_type_Vuh == null);
      this.a.jdField_a_of_type_Vuh.a(this.a, paramMessage.arg1, paramMessage.arg2);
      return;
    case 100: 
      Log.e("Story-MediaPlayer", "Error (" + paramMessage.arg1 + "," + paramMessage.arg2 + ")");
      if (this.a.jdField_a_of_type_Vuc == null) {
        break;
      }
    }
    for (boolean bool = this.a.jdField_a_of_type_Vuc.a(this.a, paramMessage.arg1, paramMessage.arg2);; bool = false)
    {
      if ((this.a.jdField_a_of_type_Vub != null) && (!bool)) {
        this.a.jdField_a_of_type_Vub.a(this.a);
      }
      this.a.c(false);
      return;
      Log.d("Story-MediaPlayer", "onInfo");
      if (this.a.jdField_a_of_type_Vud == null) {
        break;
      }
      this.a.jdField_a_of_type_Vud.a_(this.a, paramMessage.arg1, paramMessage.arg2);
      return;
      if (this.a.jdField_a_of_type_Vua != null) {
        this.a.jdField_a_of_type_Vua.a(this.a, paramMessage.arg1);
      }
      this.a.e = paramMessage.arg1;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vtt
 * JD-Core Version:    0.7.0.1
 */