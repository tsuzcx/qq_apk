import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer;

public class xvi
  extends Handler
{
  private xvi(MediaPlayer paramMediaPlayer) {}
  
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
          } while (this.a.jdField_a_of_type_Xvt == null);
          this.a.jdField_a_of_type_Xvt.a_(this.a);
          return;
          Log.d("Story-MediaPlayer", "onSeekComplete");
        } while (this.a.jdField_a_of_type_Xvu == null);
        this.a.jdField_a_of_type_Xvu.a(this.a);
        return;
        Log.d("Story-MediaPlayer", "onPlaybackComplete");
        if (this.a.jdField_a_of_type_Xvq != null) {
          this.a.jdField_a_of_type_Xvq.a(this.a);
        }
        this.a.c(false);
        return;
        Log.d("Story-MediaPlayer", "onVideoSizeChanged");
      } while (this.a.jdField_a_of_type_Xvw == null);
      this.a.jdField_a_of_type_Xvw.a(this.a, paramMessage.arg1, paramMessage.arg2);
      return;
    case 100: 
      Log.e("Story-MediaPlayer", "Error (" + paramMessage.arg1 + "," + paramMessage.arg2 + ")");
      if (this.a.jdField_a_of_type_Xvr == null) {
        break;
      }
    }
    for (boolean bool = this.a.jdField_a_of_type_Xvr.a(this.a, paramMessage.arg1, paramMessage.arg2);; bool = false)
    {
      if ((this.a.jdField_a_of_type_Xvq != null) && (!bool)) {
        this.a.jdField_a_of_type_Xvq.a(this.a);
      }
      this.a.c(false);
      return;
      Log.d("Story-MediaPlayer", "onInfo");
      if (this.a.jdField_a_of_type_Xvs == null) {
        break;
      }
      this.a.jdField_a_of_type_Xvs.a_(this.a, paramMessage.arg1, paramMessage.arg2);
      return;
      if (this.a.jdField_a_of_type_Xvp != null) {
        this.a.jdField_a_of_type_Xvp.a(this.a, paramMessage.arg1);
      }
      this.a.e = paramMessage.arg1;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvi
 * JD-Core Version:    0.7.0.1
 */