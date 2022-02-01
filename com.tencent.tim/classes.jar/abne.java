import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import org.json.JSONObject;

class abne
  implements MediaPlayer.OnSeekCompleteListener
{
  abne(abnc paramabnc, JSONObject paramJSONObject, abob paramabob) {}
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    if (this.val$result != null) {
      abnc.a(this.a, this.b, this.val$result);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abne
 * JD-Core Version:    0.7.0.1
 */