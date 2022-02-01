import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import cooperation.liveroom.LiveRoomGiftCallback;

class aqxy
  implements MediaPlayer.OnCompletionListener
{
  aqxy(aqxx paramaqxx) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (aqxx.a(this.this$0)) {
      this.this$0.mMediaPlayer.start();
    }
    for (;;)
    {
      if (aqxx.a(this.this$0) != null) {
        aqxx.a(this.this$0).onCall(7, "");
      }
      return;
      aqxx.a(this.this$0, false);
      if (aqxx.a(this.this$0) != null) {
        aqxx.a(this.this$0).onCompletion(this.this$0.mMediaPlayer);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqxy
 * JD-Core Version:    0.7.0.1
 */